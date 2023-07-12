package com.taobao.alivfssdk.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.alivfsadapter.AVFSAdapterManager;
import com.taobao.alivfsadapter.AVFSSDKAppMonitor;
import com.taobao.alivfssdk.fresco.binaryresource.BinaryResource;
import com.taobao.alivfssdk.fresco.cache.common.C6274b;
import com.taobao.alivfssdk.fresco.cache.common.CacheErrorLogger;
import com.taobao.alivfssdk.fresco.cache.common.CacheEvent;
import com.taobao.alivfssdk.fresco.cache.common.CacheEventListener;
import com.taobao.alivfssdk.fresco.cache.common.CacheKey;
import com.taobao.alivfssdk.fresco.cache.common.WriterCallback;
import com.taobao.alivfssdk.fresco.cache.disk.DiskStorage;
import com.taobao.alivfssdk.fresco.cache.disk.DiskStorageCache;
import com.taobao.alivfssdk.fresco.cache.disk.FileCache;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.io.StreamCorruptedException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import tb.C9248i0;
import tb.iq1;
import tb.kh1;
import tb.nz0;
import tb.rk1;

/* compiled from: Taobao */
/* renamed from: com.taobao.alivfssdk.cache.c */
/* loaded from: classes8.dex */
public class C6263c extends AVFSBaseCache implements CacheErrorLogger, CacheEventListener {
    private final String a;
    private final FileCache b;
    private final C6258a c;
    private LruCache<CacheKey, byte[]> d;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.alivfssdk.cache.c$a */
    /* loaded from: classes8.dex */
    class ThreadFactoryC6264a implements ThreadFactory {
        ThreadFactoryC6264a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AVFSDiskCache #" + C6263c.this.c.e());
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.alivfssdk.cache.c$b */
    /* loaded from: classes8.dex */
    class C6265b extends nz0<CacheKey, byte[]> {
        C6265b(C6263c c6263c, int i, float f) {
            super(i, f);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // tb.nz0
        /* renamed from: r */
        public int b(byte[] bArr) {
            return bArr.length;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.alivfssdk.cache.c$c */
    /* loaded from: classes8.dex */
    public class C6266c extends BufferedInputStream {
        final /* synthetic */ CacheKey a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C6266c(InputStream inputStream, int i, CacheKey cacheKey) {
            super(inputStream, i);
            this.a = cacheKey;
        }

        @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            C6263c.this.d.put(this.a, ((BufferedInputStream) this).buf);
            super.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.alivfssdk.cache.c$e */
    /* loaded from: classes8.dex */
    public static class C6269e extends ObjectInputStream {
        private final ClassLoader a;

        public C6269e(InputStream inputStream, ClassLoader classLoader) throws StreamCorruptedException, IOException {
            super(inputStream);
            this.a = classLoader;
        }

        @Override // java.io.ObjectInputStream
        protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            try {
                return super.resolveClass(objectStreamClass);
            } catch (ClassNotFoundException unused) {
                return Class.forName(objectStreamClass.getName(), false, this.a);
            }
        }
    }

    public C6263c(@NonNull C6258a c6258a, String str, DiskStorage diskStorage, DiskStorageCache.C6284b c6284b, int i) {
        this.c = c6258a;
        this.a = str;
        this.b = new DiskStorageCache(diskStorage, null, c6284b, this, this, null, C6261b.d().c(), Executors.newSingleThreadExecutor(new ThreadFactoryC6264a()));
        if (i > 0) {
            this.d = new C6265b(this, i, 0.2f);
        }
    }

    private void d(@NonNull String str, String str2, boolean z) {
        AVFSSDKAppMonitor f = AVFSAdapterManager.g().f();
        if (f != null) {
            f.hitMemoryCacheForModule(this.c.e(), z);
        }
    }

    @NonNull
    protected kh1.C9360b c(String str) {
        return kh1.a(this.c.e(), this.a, this.d != null).o(str);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void clearMemCache() {
        LruCache<CacheKey, byte[]> lruCache = this.d;
        if (lruCache != null) {
            lruCache.clear();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        clearMemCache();
        FileCache fileCache = this.b;
        if (fileCache != null) {
            fileCache.close();
        }
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean containObjectForKey(@NonNull String str, int i) {
        return containObjectForKey(str, (String) null, i);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public List<String> extendsKeysForKey(@NonNull String str) {
        return extendsKeysForKey(str, 0);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public InputStream inputStreamForKey(@NonNull String str, String str2) {
        return inputStreamForKey(str, str2, 0);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public Set<String> keySet() {
        try {
            Collection<DiskStorage.Entry> entries = this.b.getEntries();
            HashSet hashSet = new HashSet(entries.size());
            for (DiskStorage.Entry entry : entries) {
                hashSet.add(entry.getId());
            }
            return hashSet;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public long lengthForKey(String str, String str2) {
        if (str == null) {
            return -1L;
        }
        BinaryResource resource = this.b.getResource(new iq1(str, str2));
        if (resource != null) {
            return resource.size();
        }
        return -1L;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheErrorLogger
    public void logError(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, String str, String str2, @Nullable Throwable th) {
        C9248i0.d("AVFSCache", th, new Object[0]);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    @Nullable
    public <T> T objectForKey(@NonNull String str, String str2) {
        return (T) objectForKey(str, str2, (Class<Object>) null);
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheEventListener
    public boolean onEviction(CacheEvent cacheEvent) {
        return false;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheEventListener
    public void onHit(CacheEvent cacheEvent) {
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheEventListener
    public void onMiss(CacheEvent cacheEvent) {
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheEventListener
    public void onReadException(CacheEvent cacheEvent) {
        AVFSSDKAppMonitor f = AVFSAdapterManager.g().f();
        if (f != null) {
            f.writeEvent(c(kh1.OPERATION_READ).l(-2).m(cacheEvent.getException().getMessage()).j());
        }
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheEventListener
    public void onRemoveSuccess(CacheEvent cacheEvent) {
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheEventListener
    public void onWriteAttempt(CacheEvent cacheEvent) {
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheEventListener
    public void onWriteException(CacheEvent cacheEvent) {
        AVFSSDKAppMonitor f = AVFSAdapterManager.g().f();
        if (f != null) {
            f.writeEvent(c(kh1.OPERATION_WRITE).l(-2).m(cacheEvent.getException().getMessage()).j());
        }
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheEventListener
    public void onWriteSuccess(CacheEvent cacheEvent) {
        AVFSSDKAppMonitor f = AVFSAdapterManager.g().f();
        if (f != null) {
            f.writeEvent(c(kh1.OPERATION_WRITE).k(cacheEvent.getElapsed()).j());
        }
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean removeAllObject() {
        LruCache<CacheKey, byte[]> lruCache = this.d;
        if (lruCache != null) {
            lruCache.clear();
        }
        this.b.clearAll();
        return true;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean removeObjectForKey(@NonNull String str, int i) {
        return removeObjectForKey(str, (String) null, i);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setObjectForKey(@NonNull String str, String str2, Object obj, int i) {
        CacheKey iq1Var;
        if (str == null) {
            return false;
        }
        if (obj == null) {
            return removeObjectForKey(str, str2);
        }
        if (i == 268435456) {
            iq1Var = new rk1(str, str2);
        } else {
            iq1Var = new iq1(str, str2);
        }
        try {
            this.b.insert(iq1Var, new C6267d(iq1Var, obj));
            return true;
        } catch (Exception e) {
            C9248i0.d("AVFSCache", e, new Object[0]);
            return false;
        }
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setStreamForKey(@NonNull String str, String str2, @NonNull InputStream inputStream, int i) {
        CacheKey iq1Var;
        if (str == null) {
            return false;
        }
        if (i == 268435456) {
            iq1Var = new rk1(str, str2);
        } else {
            iq1Var = new iq1(str, str2);
        }
        try {
            System.currentTimeMillis();
            this.b.insert(iq1Var, C6274b.a(inputStream));
            System.currentTimeMillis();
            return true;
        } catch (Exception e) {
            C9248i0.d("AVFSCache", e, new Object[0]);
            return false;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.alivfssdk.cache.c$d */
    /* loaded from: classes8.dex */
    class C6267d implements WriterCallback {
        final /* synthetic */ CacheKey a;
        final /* synthetic */ Object b;

        C6267d(CacheKey cacheKey, Object obj) {
            this.a = cacheKey;
            this.b = obj;
        }

        @Override // com.taobao.alivfssdk.fresco.cache.common.WriterCallback
        public OutputStream write(OutputStream outputStream) throws IOException {
            ObjectOutputStream objectOutputStream;
            if (C6263c.this.d != null) {
                objectOutputStream = new ObjectOutputStream(new C6268a(outputStream));
            } else {
                objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(outputStream));
            }
            objectOutputStream.writeObject(this.b);
            return objectOutputStream;
        }

        /* compiled from: Taobao */
        /* renamed from: com.taobao.alivfssdk.cache.c$d$a */
        /* loaded from: classes8.dex */
        class C6268a extends BufferedOutputStream {
            private final ByteArrayOutputStream a;

            C6268a(OutputStream outputStream) {
                super(outputStream);
                this.a = new ByteArrayOutputStream();
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                C6263c.this.d.put(C6267d.this.a, this.a.toByteArray());
                super.close();
            }

            @Override // java.io.BufferedOutputStream, java.io.FilterOutputStream, java.io.OutputStream
            public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
                this.a.write(bArr, i, i2);
                super.write(bArr, i, i2);
            }

            @Override // java.io.BufferedOutputStream, java.io.FilterOutputStream, java.io.OutputStream
            public synchronized void write(int i) throws IOException {
                this.a.write(i);
                super.write(i);
            }
        }
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean containObjectForKey(@NonNull String str, String str2) {
        return containObjectForKey(str, str2, 0);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public List<String> extendsKeysForKey(@NonNull String str, int i) {
        CacheKey iq1Var;
        if (i == 268435456) {
            iq1Var = new rk1(str, null);
        } else {
            iq1Var = new iq1(str, null);
        }
        System.currentTimeMillis();
        try {
            List<String> catalogs = this.b.getCatalogs(iq1Var);
            System.currentTimeMillis();
            return catalogs;
        } catch (Exception e) {
            C9248i0.d("AVFSCache", e, new Object[0]);
            return null;
        }
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public InputStream inputStreamForKey(@NonNull String str, String str2, int i) {
        CacheKey iq1Var;
        if (str == null) {
            return null;
        }
        if (i == 268435456) {
            iq1Var = new rk1(str, str2);
        } else {
            iq1Var = new iq1(str, str2);
        }
        System.currentTimeMillis();
        try {
            BinaryResource resource = this.b.getResource(iq1Var);
            System.currentTimeMillis();
            if (resource != null) {
                C9248i0.c("AVFSCache", "- inputStreamForKey: moduleName=" + this.c.e() + ", key1=" + str + ", key2=" + str2);
                return resource.openStream();
            }
        } catch (IOException e) {
            C9248i0.d("AVFSCache", e, new Object[0]);
        }
        return null;
    }

    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0190: MOVE  (r8 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY]), block:B:87:0x0190 */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x013a A[Catch: all -> 0x018f, TryCatch #10 {all -> 0x018f, blocks: (B:23:0x004e, B:26:0x0056, B:28:0x005e, B:30:0x0066, B:70:0x0130, B:72:0x013a, B:73:0x0152, B:78:0x015d, B:80:0x0167, B:81:0x0182, B:41:0x008f, B:52:0x00b0, B:53:0x00b4, B:54:0x00b8, B:56:0x00ca, B:61:0x00e3, B:62:0x0105, B:64:0x0107, B:65:0x012a), top: B:101:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0167 A[Catch: all -> 0x018f, TryCatch #10 {all -> 0x018f, blocks: (B:23:0x004e, B:26:0x0056, B:28:0x005e, B:30:0x0066, B:70:0x0130, B:72:0x013a, B:73:0x0152, B:78:0x015d, B:80:0x0167, B:81:0x0182, B:41:0x008f, B:52:0x00b0, B:53:0x00b4, B:54:0x00b8, B:56:0x00ca, B:61:0x00e3, B:62:0x0105, B:64:0x0107, B:65:0x012a), top: B:101:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T objectForKey(@androidx.annotation.NonNull java.lang.String r17, java.lang.String r18, java.lang.Class<T> r19, int r20) {
        /*
            Method dump skipped, instructions count: 407
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.alivfssdk.cache.C6263c.objectForKey(java.lang.String, java.lang.String, java.lang.Class, int):java.lang.Object");
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean removeObjectForKey(@NonNull String str, String str2) {
        return removeObjectForKey(str, str2, 0);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean containObjectForKey(@NonNull String str, String str2, int i) {
        CacheKey iq1Var;
        if (str == null) {
            return false;
        }
        if (i == 268435456) {
            iq1Var = new rk1(str, str2);
        } else {
            iq1Var = new iq1(str, str2);
        }
        return this.b.hasKey(iq1Var);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean removeObjectForKey(@NonNull String str, String str2, int i) {
        CacheKey iq1Var;
        if (str == null) {
            return false;
        }
        if (i == 268435456) {
            iq1Var = new rk1(str, str2);
        } else {
            iq1Var = new iq1(str, str2);
        }
        LruCache<CacheKey, byte[]> lruCache = this.d;
        if (lruCache != null) {
            lruCache.remove(iq1Var);
        }
        return this.b.remove(iq1Var);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public long lengthForKey(String str, String str2, int i) {
        CacheKey iq1Var;
        if (str == null) {
            return -1L;
        }
        if (i == 268435456) {
            iq1Var = new rk1(str, str2);
        } else {
            iq1Var = new iq1(str, str2);
        }
        BinaryResource resource = this.b.getResource(iq1Var);
        if (resource != null) {
            return resource.size();
        }
        return -1L;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    @Nullable
    public <T> T objectForKey(@NonNull String str, String str2, Class<T> cls) {
        return (T) objectForKey(str, str2, cls, 0);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    @Nullable
    public <T> T objectForKey(@NonNull String str, int i) {
        return (T) objectForKey(str, (String) null, (Class<Object>) null, i);
    }
}
