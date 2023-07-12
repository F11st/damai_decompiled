package com.taobao.alivfssdk.fresco.cache.disk;

import android.content.Context;
import androidx.annotation.Nullable;
import com.taobao.alivfssdk.fresco.binaryresource.BinaryResource;
import com.taobao.alivfssdk.fresco.cache.common.CacheErrorLogger;
import com.taobao.alivfssdk.fresco.cache.common.CacheEventListener;
import com.taobao.alivfssdk.fresco.cache.common.CacheKey;
import com.taobao.alivfssdk.fresco.cache.common.WriterCallback;
import com.taobao.alivfssdk.fresco.cache.disk.DiskStorage;
import com.taobao.alivfssdk.fresco.common.disk.DiskTrimmable;
import com.taobao.alivfssdk.fresco.common.disk.DiskTrimmableRegistry;
import com.taobao.alivfssdk.fresco.common.internal.VisibleForTesting;
import com.taobao.alivfssdk.fresco.common.statfs.StatFsHelper;
import com.taobao.weex.annotation.JSMethod;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import tb.db2;
import tb.i0;
import tb.rk1;
import tb.wh1;
import tb.y92;

/* compiled from: Taobao */
@ThreadSafe
/* loaded from: classes8.dex */
public class DiskStorageCache implements FileCache, DiskTrimmable {
    public static final int START_OF_VERSIONING = 1;
    private static final long o = TimeUnit.HOURS.toMillis(2);
    private static final long p = TimeUnit.MINUTES.toMillis(30);
    static Pattern q = Pattern.compile("[^a-zA-Z0-9\\.\\-]");
    private final long a;
    private long b;
    private long d;
    private final CacheEventListener e;
    @GuardedBy("mLock")
    @VisibleForTesting
    final Set<String> f;
    @GuardedBy("mLock")
    private long g;
    private final long h;
    private final StatFsHelper i;
    private final DiskStorage j;
    private final EntryEvictionComparatorSupplier k;
    private final CacheErrorLogger l;
    private final a m;
    private final CountDownLatch c = new CountDownLatch(1);
    private final Object n = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    @VisibleForTesting
    /* loaded from: classes8.dex */
    public static class a {
        private boolean a = false;
        private long b = -1;
        private long c = -1;

        a() {
        }

        public synchronized long a() {
            return this.c;
        }

        public synchronized long b() {
            return this.b;
        }

        public synchronized void c(long j, long j2) {
            if (this.a) {
                this.b += j;
                this.c += j2;
            }
        }

        public synchronized boolean d() {
            return this.a;
        }

        public synchronized void e() {
            this.a = false;
            this.c = -1L;
            this.b = -1L;
        }

        public synchronized void f(long j, long j2) {
            this.c = j2;
            this.b = j;
            this.a = true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class b {
        public final long a;
        public final long b;
        public final long c;

        public b(long j, long j2, long j3) {
            this.a = j;
            this.b = j2;
            this.c = j3;
        }
    }

    public DiskStorageCache(DiskStorage diskStorage, EntryEvictionComparatorSupplier entryEvictionComparatorSupplier, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable DiskTrimmableRegistry diskTrimmableRegistry, final Context context, ExecutorService executorService) {
        this.a = bVar.b;
        long j = bVar.c;
        this.b = j;
        this.d = j;
        this.i = StatFsHelper.d();
        this.j = diskStorage;
        this.k = entryEvictionComparatorSupplier;
        this.g = -1L;
        this.e = cacheEventListener;
        this.h = bVar.a;
        this.l = cacheErrorLogger;
        this.m = new a();
        if (diskTrimmableRegistry != null) {
            diskTrimmableRegistry.registerDiskTrimmable(this);
        }
        this.f = new HashSet();
        executorService.execute(new Runnable() { // from class: com.taobao.alivfssdk.fresco.cache.disk.DiskStorageCache.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DiskStorageCache.this.n) {
                    DiskStorageCache.this.n();
                    DiskStorageCache.l(context, DiskStorageCache.this.j.getStorageName());
                }
                DiskStorageCache.this.c.countDown();
            }
        });
    }

    private BinaryResource f(DiskStorage.Inserter inserter, CacheKey cacheKey, String str) throws IOException {
        BinaryResource commit;
        synchronized (this.n) {
            commit = inserter.commit(cacheKey, cacheKey);
            this.f.add(str);
            this.m.c(commit.size(), 1L);
        }
        return commit;
    }

    private static String g(String str) {
        return q.matcher(str).replaceAll(JSMethod.NOT_SET);
    }

    @GuardedBy("mLock")
    private void h(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        try {
            Collection<DiskStorage.Entry> k = k(this.j.getEntries());
            long b2 = this.m.b();
            long j2 = b2 - j;
            int i = 0;
            long j3 = 0;
            for (DiskStorage.Entry entry : k) {
                if (j3 > j2) {
                    break;
                }
                long remove = this.j.remove(entry);
                this.f.remove(entry.getId());
                if (remove > 0) {
                    i++;
                    j3 += remove;
                    CacheEventListener cacheEventListener = this.e;
                    if (cacheEventListener != null) {
                        cacheEventListener.onEviction(new db2().h(entry.getId()).e(evictionReason).g(remove).c(b2 - j3).b(j));
                    }
                }
            }
            this.m.c(-j3, -i);
            this.j.purgeUnexpectedResources();
        } catch (IOException e) {
            CacheErrorLogger cacheErrorLogger = this.l;
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.EVICTION;
            cacheErrorLogger.logError(cacheErrorCategory, "DiskStorageCache", "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    @VisibleForTesting
    public static String i(CacheKey cacheKey) {
        try {
            if (cacheKey instanceof wh1) {
                return p(((wh1) cacheKey).a().get(0));
            }
            if (cacheKey instanceof rk1) {
                return cacheKey.toString();
            }
            return p(cacheKey);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> j(CacheKey cacheKey) {
        try {
            ArrayList arrayList = new ArrayList();
            if (cacheKey instanceof wh1) {
                List<CacheKey> a2 = ((wh1) cacheKey).a();
                for (int i = 0; i < a2.size(); i++) {
                    arrayList.add(p(a2.get(i)));
                }
            } else if (cacheKey instanceof rk1) {
                arrayList.add(g(cacheKey.toString()));
            } else {
                arrayList.add(p(cacheKey));
            }
            return arrayList;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private Collection<DiskStorage.Entry> k(Collection<DiskStorage.Entry> collection) {
        if (this.k == null) {
            return collection;
        }
        long currentTimeMillis = System.currentTimeMillis() + o;
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (DiskStorage.Entry entry : collection) {
            if (entry.getTimestamp() > currentTimeMillis) {
                arrayList.add(entry);
            } else {
                arrayList2.add(entry);
            }
        }
        Collections.sort(arrayList2, this.k.get());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        StringBuilder sb = new StringBuilder();
        sb.append(applicationContext.getFilesDir().getParent());
        String str2 = File.separator;
        sb.append(str2);
        sb.append("shared_prefs");
        sb.append(str2);
        sb.append("disk_entries_list");
        sb.append(str);
        String sb2 = sb.toString();
        File file = new File(sb2 + ".xml");
        try {
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
            i0.e("DiskStorageCache", "Fail to delete SharedPreference from file system. ");
        }
    }

    private void m() throws IOException {
        synchronized (this.n) {
            boolean n = n();
            s();
            long b2 = this.m.b();
            if (b2 > this.d && !n) {
                this.m.e();
                n();
            }
            if (b2 > this.d) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = (this.d * 9) / 10;
                h(j, CacheEventListener.EvictionReason.CACHE_FULL);
                i0.c("DiskStorageCache", "- evictAboveSize: desiredSize=" + j + ", elapsed=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public boolean n() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.m.d()) {
            long j = this.g;
            if (j != -1 && currentTimeMillis - j <= p) {
                return false;
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        o();
        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
        i0.c("DiskStorageCache", "- maybeUpdateFileCacheSizeAndIndex: now=" + currentTimeMillis + ", elapsed=" + currentTimeMillis3 + "ms, thread=" + Thread.currentThread());
        this.g = currentTimeMillis;
        return true;
    }

    @GuardedBy("mLock")
    private void o() {
        Set<String> hashSet;
        long j;
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = o + currentTimeMillis;
        if (this.f.isEmpty()) {
            hashSet = this.f;
        } else {
            hashSet = new HashSet<>();
        }
        try {
            boolean z = false;
            long j3 = -1;
            int i = 0;
            long j4 = 0;
            int i2 = 0;
            int i3 = 0;
            for (DiskStorage.Entry entry : this.j.getEntries()) {
                i2++;
                j4 += entry.getSize();
                if (entry.getTimestamp() > j2) {
                    i3++;
                    j = j2;
                    int size = (int) (i + entry.getSize());
                    j3 = Math.max(entry.getTimestamp() - currentTimeMillis, j3);
                    i = size;
                    z = true;
                } else {
                    j = j2;
                    hashSet.add(entry.getId());
                }
                j2 = j;
            }
            if (z) {
                this.l.logError(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, "DiskStorageCache", "Future timestamp found in " + i3 + " files , with a total size of " + i + " bytes, and a maximum time delta of " + j3 + "ms", null);
            }
            long j5 = i2;
            if (this.m.a() == j5 && this.m.b() == j4) {
                return;
            }
            Set<String> set = this.f;
            if (set != hashSet) {
                set.clear();
                this.f.addAll(hashSet);
            }
            this.m.f(j4, j5);
        } catch (IOException e) {
            this.l.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, "DiskStorageCache", "calcFileCacheSize: " + e.getMessage(), e);
        }
    }

    private static String p(CacheKey cacheKey) throws UnsupportedEncodingException {
        return y92.a(cacheKey.toString().getBytes("UTF-8"));
    }

    private DiskStorage.Inserter q(String str, CacheKey cacheKey) throws IOException {
        m();
        return this.j.insert(str, cacheKey, cacheKey);
    }

    private void r(double d) {
        synchronized (this.n) {
            try {
                this.m.e();
                n();
                long b2 = this.m.b();
                h(b2 - ((long) (d * b2)), CacheEventListener.EvictionReason.CACHE_MANAGER_TRIMMED);
            } catch (IOException e) {
                CacheErrorLogger cacheErrorLogger = this.l;
                CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.EVICTION;
                cacheErrorLogger.logError(cacheErrorCategory, "DiskStorageCache", "trimBy: " + e.getMessage(), e);
            }
        }
    }

    @GuardedBy("mLock")
    private void s() {
        if (this.i.f(this.j.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.b - this.m.b())) {
            this.d = this.a;
        } else {
            this.d = this.b;
        }
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public void clearAll() {
        synchronized (this.n) {
            try {
                this.j.clearAll();
                this.f.clear();
            } catch (IOException e) {
                CacheErrorLogger cacheErrorLogger = this.l;
                CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.EVICTION;
                cacheErrorLogger.logError(cacheErrorCategory, "DiskStorageCache", "clearAll: " + e.getMessage(), e);
            }
            this.m.e();
        }
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public long clearOldEntries(long j) {
        long j2;
        long j3;
        synchronized (this.n) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                Collection<DiskStorage.Entry> entries = this.j.getEntries();
                long b2 = this.m.b();
                int i = 0;
                long j4 = 0;
                j3 = 0;
                for (DiskStorage.Entry entry : entries) {
                    try {
                        long j5 = currentTimeMillis;
                        long max = Math.max(1L, Math.abs(currentTimeMillis - entry.getTimestamp()));
                        if (max >= j) {
                            long remove = this.j.remove(entry);
                            this.f.remove(entry.getId());
                            if (remove > 0) {
                                i++;
                                j4 += remove;
                                CacheEventListener cacheEventListener = this.e;
                                if (cacheEventListener != null) {
                                    cacheEventListener.onEviction(new db2().h(entry.getId()).e(CacheEventListener.EvictionReason.CONTENT_STALE).g(remove).c(b2 - j4));
                                }
                            }
                        } else {
                            j3 = Math.max(j3, max);
                        }
                        currentTimeMillis = j5;
                    } catch (IOException e) {
                        e = e;
                        j2 = j3;
                        CacheErrorLogger cacheErrorLogger = this.l;
                        CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.EVICTION;
                        cacheErrorLogger.logError(cacheErrorCategory, "DiskStorageCache", "clearOldEntries: " + e.getMessage(), e);
                        j3 = j2;
                        return j3;
                    }
                }
                this.j.purgeUnexpectedResources();
                if (i > 0) {
                    n();
                    this.m.c(-j4, -i);
                }
            } catch (IOException e2) {
                e = e2;
                j2 = 0;
            }
        }
        return j3;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.j.close();
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public List<String> getCatalogs(CacheKey cacheKey) {
        synchronized (this.n) {
            List<String> j = j(cacheKey);
            if (j.size() > 0) {
                return this.j.getCatalogs(j.get(0));
            }
            return null;
        }
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public long getCount() {
        return this.m.a();
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public DiskStorage.a getDumpInfo() throws IOException {
        return this.j.getDumpInfo();
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public Collection<DiskStorage.Entry> getEntries() throws IOException {
        return this.j.getEntries();
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public BinaryResource getResource(CacheKey cacheKey) {
        BinaryResource binaryResource;
        i0.c("DiskStorageCache", "- getResource: key=" + cacheKey + ", thread=" + Thread.currentThread());
        db2 a2 = new db2().a(cacheKey);
        try {
            synchronized (this.n) {
                List<String> j = j(cacheKey);
                String str = null;
                binaryResource = null;
                for (int i = 0; i < j.size(); i++) {
                    str = j.get(i);
                    a2.h(str);
                    binaryResource = this.j.getResource(str, cacheKey, cacheKey);
                    if (binaryResource != null) {
                        break;
                    }
                }
                if (binaryResource == null) {
                    CacheEventListener cacheEventListener = this.e;
                    if (cacheEventListener != null) {
                        cacheEventListener.onMiss(a2);
                    }
                    this.f.remove(str);
                } else {
                    CacheEventListener cacheEventListener2 = this.e;
                    if (cacheEventListener2 != null) {
                        cacheEventListener2.onHit(a2);
                    }
                    this.f.add(str);
                }
            }
            return binaryResource;
        } catch (IOException e) {
            this.l.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, "DiskStorageCache", "getResource", e);
            a2.f(e);
            CacheEventListener cacheEventListener3 = this.e;
            if (cacheEventListener3 != null) {
                cacheEventListener3.onReadException(a2);
            }
            return null;
        }
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public long getSize() {
        return this.m.b();
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public boolean hasKey(CacheKey cacheKey) {
        synchronized (this.n) {
            if (hasKeySync(cacheKey)) {
                return true;
            }
            try {
                List<String> j = j(cacheKey);
                for (int i = 0; i < j.size(); i++) {
                    String str = j.get(i);
                    if (this.j.contains(str, cacheKey, cacheKey)) {
                        this.f.add(str);
                        return true;
                    }
                }
                return false;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public boolean hasKeySync(CacheKey cacheKey) {
        synchronized (this.n) {
            List<String> j = j(cacheKey);
            for (int i = 0; i < j.size(); i++) {
                if (this.f.contains(j.get(i))) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public BinaryResource insert(CacheKey cacheKey, WriterCallback writerCallback) throws IOException {
        String i;
        long currentTimeMillis = System.currentTimeMillis();
        db2 a2 = new db2().a(cacheKey);
        CacheEventListener cacheEventListener = this.e;
        if (cacheEventListener != null) {
            cacheEventListener.onWriteAttempt(a2);
        }
        synchronized (this.n) {
            i = i(cacheKey);
        }
        a2.h(i);
        try {
            DiskStorage.Inserter q2 = q(i, cacheKey);
            q2.writeData(writerCallback, cacheKey, cacheKey);
            BinaryResource f = f(q2, cacheKey, i);
            a2.g(f.size()).c(this.m.b()).d(System.currentTimeMillis() - currentTimeMillis);
            CacheEventListener cacheEventListener2 = this.e;
            if (cacheEventListener2 != null) {
                cacheEventListener2.onWriteSuccess(a2);
            }
            if (!q2.cleanUp()) {
                i0.e("DiskStorageCache", "Failed to delete temp file");
            }
            return f;
        } catch (IOException e) {
            a2.f(e);
            CacheEventListener cacheEventListener3 = this.e;
            if (cacheEventListener3 != null) {
                cacheEventListener3.onWriteException(a2);
            }
            i0.e("DiskStorageCache", "Failed inserting a file into the cache", e);
            throw e;
        }
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public boolean isEnabled() {
        return this.j.isEnabled();
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public boolean probe(CacheKey cacheKey) {
        String str;
        IOException e;
        String str2 = null;
        try {
            try {
                synchronized (this.n) {
                    try {
                        List<String> j = j(cacheKey);
                        int i = 0;
                        while (i < j.size()) {
                            String str3 = j.get(i);
                            if (this.j.touch(str3, cacheKey, cacheKey)) {
                                this.f.add(str3);
                                return true;
                            }
                            i++;
                            str2 = str3;
                        }
                        return false;
                    } catch (Throwable th) {
                        str = str2;
                        th = th;
                        try {
                            throw th;
                        } catch (IOException e2) {
                            e = e2;
                            CacheEventListener cacheEventListener = this.e;
                            if (cacheEventListener != null) {
                                cacheEventListener.onReadException(new db2().a(cacheKey).h(str).f(e));
                            }
                            return false;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            str = null;
            e = e3;
        }
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public boolean remove(CacheKey cacheKey) {
        synchronized (this.n) {
            try {
                try {
                    List<String> j = j(cacheKey);
                    if (j.size() > 0) {
                        String str = j.get(0);
                        db2 a2 = new db2().a(cacheKey);
                        a2.h(str);
                        long remove = this.j.remove(str, cacheKey);
                        this.f.remove(str);
                        a2.g(remove).c(this.m.b());
                        CacheEventListener cacheEventListener = this.e;
                        if (cacheEventListener != null) {
                            cacheEventListener.onRemoveSuccess(a2);
                        }
                        return remove >= 0;
                    }
                } catch (IOException e) {
                    CacheErrorLogger cacheErrorLogger = this.l;
                    CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.DELETE_FILE;
                    cacheErrorLogger.logError(cacheErrorCategory, "DiskStorageCache", "delete: " + e.getMessage(), e);
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.taobao.alivfssdk.fresco.common.disk.DiskTrimmable
    public void trimToMinimum() {
        synchronized (this.n) {
            n();
            long b2 = this.m.b();
            long j = this.h;
            if (j > 0 && b2 > 0 && b2 >= j) {
                double d = 1.0d - (j / b2);
                if (d > 0.02d) {
                    r(d);
                }
            }
        }
    }

    @Override // com.taobao.alivfssdk.fresco.common.disk.DiskTrimmable
    public void trimToNothing() {
        clearAll();
    }
}
