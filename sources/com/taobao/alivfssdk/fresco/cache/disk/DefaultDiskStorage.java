package com.taobao.alivfssdk.fresco.cache.disk;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.alipay.sdk.m.x.AbstractC4344c;
import com.taobao.alivfssdk.fresco.binaryresource.BinaryResource;
import com.taobao.alivfssdk.fresco.binaryresource.C6272a;
import com.taobao.alivfssdk.fresco.cache.common.CacheErrorLogger;
import com.taobao.alivfssdk.fresco.cache.common.CacheKey;
import com.taobao.alivfssdk.fresco.cache.common.WriterCallback;
import com.taobao.alivfssdk.fresco.cache.disk.DiskStorage;
import com.taobao.alivfssdk.fresco.common.file.C6285a;
import com.taobao.alivfssdk.fresco.common.file.FileTreeVisitor;
import com.taobao.alivfssdk.fresco.common.file.FileUtils;
import com.taobao.alivfssdk.fresco.common.internal.C6290b;
import com.taobao.alivfssdk.fresco.common.internal.VisibleForTesting;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import tb.bu1;
import tb.iq1;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DefaultDiskStorage implements DiskStorage {
    private final File a;
    private final boolean b;
    private final File c;
    private final CacheErrorLogger d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public enum FileType {
        CONTENT(".cnt"),
        TEMP(".tmp");
        
        public final String extension;

        FileType(String str) {
            this.extension = str;
        }

        public static FileType fromExtension(String str) {
            if (".cnt".equals(str)) {
                return CONTENT;
            }
            if (".tmp".equals(str)) {
                return TEMP;
            }
            return null;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    private static class IncompleteFileException extends IOException {
        public final long actual;
        public final long expected;

        public IncompleteFileException(long j, long j2) {
            super("File was not written completely. Expected: " + j + ", found: " + j2);
            this.expected = j;
            this.actual = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.alivfssdk.fresco.cache.disk.DefaultDiskStorage$b */
    /* loaded from: classes8.dex */
    public class C6277b implements FileTreeVisitor {
        private final List<DiskStorage.Entry> a;

        private C6277b() {
            this.a = new ArrayList();
        }

        public List<DiskStorage.Entry> a() {
            return Collections.unmodifiableList(this.a);
        }

        @Override // com.taobao.alivfssdk.fresco.common.file.FileTreeVisitor
        public void postVisitDirectory(File file) {
        }

        @Override // com.taobao.alivfssdk.fresco.common.file.FileTreeVisitor
        public void preVisitDirectory(File file) {
        }

        @Override // com.taobao.alivfssdk.fresco.common.file.FileTreeVisitor
        public void visitFile(File file) {
            C6279d h = DefaultDiskStorage.this.h(file);
            if (h == null || h.a != FileType.CONTENT) {
                return;
            }
            this.a.add(new C6278c(h.b, file));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    @VisibleForTesting
    /* renamed from: com.taobao.alivfssdk.fresco.cache.disk.DefaultDiskStorage$c */
    /* loaded from: classes8.dex */
    public static class C6278c implements DiskStorage.Entry {
        private final String a;
        private final C6272a b;
        private long c;
        private long d;

        @Override // com.taobao.alivfssdk.fresco.cache.disk.DiskStorage.Entry
        /* renamed from: a */
        public C6272a getResource() {
            return this.b;
        }

        @Override // com.taobao.alivfssdk.fresco.cache.disk.DiskStorage.Entry
        public String getId() {
            return this.a;
        }

        @Override // com.taobao.alivfssdk.fresco.cache.disk.DiskStorage.Entry
        public long getSize() {
            if (this.c < 0) {
                this.c = this.b.size();
            }
            return this.c;
        }

        @Override // com.taobao.alivfssdk.fresco.cache.disk.DiskStorage.Entry
        public long getTimestamp() {
            if (this.d < 0) {
                this.d = this.b.b().lastModified();
            }
            return this.d;
        }

        private C6278c(String str, File file) {
            bu1.a(file);
            this.a = (String) bu1.a(str);
            this.b = C6272a.a(file);
            this.c = -1L;
            this.d = -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.alivfssdk.fresco.cache.disk.DefaultDiskStorage$d */
    /* loaded from: classes8.dex */
    public static class C6279d {
        public final FileType a;
        public final String b;
        public final String c;

        @Nullable
        public static C6279d b(File file) {
            FileType fromExtension;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            String str = null;
            if (lastIndexOf > 0 && (fromExtension = FileType.fromExtension(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (fromExtension.equals(FileType.TEMP)) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                int lastIndexOf3 = substring.lastIndexOf(33);
                if (lastIndexOf3 > 0) {
                    str = substring.substring(lastIndexOf3 + 1);
                    substring = substring.substring(0, lastIndexOf3);
                }
                return new C6279d(fromExtension, substring, str);
            }
            return null;
        }

        public File a(File file) throws IOException {
            String str = this.b;
            if (!TextUtils.isEmpty(this.c)) {
                str = str + jn1.AND_NOT + this.c + ".";
            }
            return File.createTempFile(str, ".tmp", file);
        }

        public String c(String str) {
            String str2 = str + File.separator + this.b;
            if (!TextUtils.isEmpty(this.c)) {
                str2 = str2 + jn1.AND_NOT + this.c;
            }
            return str2 + this.a.extension;
        }

        public String toString() {
            return this.a + jn1.BRACKET_START_STR + this.b + jn1.BRACKET_END_STR;
        }

        private C6279d(FileType fileType, String str, CacheKey cacheKey) {
            this.a = fileType;
            this.b = str;
            if ((cacheKey instanceof iq1) && !TextUtils.isEmpty(((iq1) cacheKey).b)) {
                try {
                    this.c = Base64.encodeToString(((iq1) cacheKey).b.getBytes("UTF-8"), 11);
                    return;
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.c = null;
        }

        private C6279d(FileType fileType, String str, String str2) {
            this.a = fileType;
            this.b = str;
            this.c = str2;
        }
    }

    /* compiled from: Taobao */
    @VisibleForTesting
    /* renamed from: com.taobao.alivfssdk.fresco.cache.disk.DefaultDiskStorage$e */
    /* loaded from: classes8.dex */
    class C6280e implements DiskStorage.Inserter {
        private final String a;
        @VisibleForTesting
        final File b;

        public C6280e(String str, File file) {
            this.a = str;
            this.b = file;
        }

        @Override // com.taobao.alivfssdk.fresco.cache.disk.DiskStorage.Inserter
        public boolean cleanUp() {
            return !this.b.exists() || this.b.delete();
        }

        @Override // com.taobao.alivfssdk.fresco.cache.disk.DiskStorage.Inserter
        public BinaryResource commit(CacheKey cacheKey, Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File e = DefaultDiskStorage.this.e(this.a, cacheKey);
            try {
                FileUtils.b(this.b, e);
                if (e.exists()) {
                    e.setLastModified(System.currentTimeMillis());
                }
                return C6272a.a(e);
            } catch (FileUtils.RenameException e2) {
                Throwable cause = e2.getCause();
                if (cause != null) {
                    if (!(cause instanceof FileUtils.ParentDirNotFoundException)) {
                        if (cause instanceof FileNotFoundException) {
                            cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND;
                        } else {
                            cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
                        }
                    } else {
                        cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND;
                    }
                } else {
                    cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
                }
                DefaultDiskStorage.this.d.logError(cacheErrorCategory, "DefaultDiskStorage", "commit", e2);
                throw e2;
            }
        }

        @Override // com.taobao.alivfssdk.fresco.cache.disk.DiskStorage.Inserter
        public void writeData(WriterCallback writerCallback, CacheKey cacheKey, Object obj) throws IOException {
            try {
                OutputStream fileOutputStream = new FileOutputStream(this.b);
                try {
                    C6290b c6290b = new C6290b(fileOutputStream);
                    fileOutputStream = writerCallback.write(c6290b);
                    fileOutputStream.flush();
                    long count = c6290b.getCount();
                    fileOutputStream.close();
                    if (this.b.length() != count) {
                        throw new IncompleteFileException(count, this.b.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.d.logError(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, "DefaultDiskStorage", "updateResource", e);
                throw e;
            }
        }
    }

    static {
        TimeUnit.MINUTES.toMillis(30L);
    }

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        bu1.a(file);
        this.a = file;
        this.b = l(file, cacheErrorLogger);
        this.c = new File(file, k(i));
        this.d = cacheErrorLogger;
        o();
    }

    private long c(File file) {
        if (file.exists()) {
            long length = file.length();
            if (file.delete()) {
                return length;
            }
            return -1L;
        }
        return 0L;
    }

    private DiskStorage.C6282b d(DiskStorage.Entry entry) throws IOException {
        C6278c c6278c = (C6278c) entry;
        byte[] read = c6278c.getResource().read();
        String p = p(read);
        return new DiskStorage.C6282b(c6278c.getResource().b().getPath(), p, (float) c6278c.getSize(), (!p.equals(Constants.Name.UNDEFINED) || read.length < 4) ? "" : String.format(null, "0x%02X 0x%02X 0x%02X 0x%02X", Byte.valueOf(read[0]), Byte.valueOf(read[1]), Byte.valueOf(read[2]), Byte.valueOf(read[3])));
    }

    private String g(String str, CacheKey cacheKey) {
        C6279d c6279d = new C6279d(FileType.CONTENT, str, cacheKey);
        return c6279d.c(j(c6279d.b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C6279d h(File file) {
        C6279d b = C6279d.b(file);
        if (b != null && i(b.b).equals(file.getParentFile())) {
            return b;
        }
        return null;
    }

    private File i(String str) {
        return new File(j(str));
    }

    private String j(String str) {
        String valueOf = String.valueOf(Math.abs(str.hashCode() % 100));
        return this.c + File.separator + valueOf;
    }

    @VisibleForTesting
    static String k(int i) {
        return String.format(null, "%s.ols%d.%d", AbstractC4344c.d, 100, Integer.valueOf(i));
    }

    private static boolean l(File file, CacheErrorLogger cacheErrorLogger) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            try {
                try {
                    return file.getCanonicalPath().contains(externalStorageDirectory.toString());
                } catch (IOException e) {
                    e = e;
                    CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.OTHER;
                    cacheErrorLogger.logError(cacheErrorCategory, "DefaultDiskStorage", "failed to read folder to check if external: " + ((String) null), e);
                    return false;
                }
            } catch (IOException e2) {
                e = e2;
            }
        }
        return false;
    }

    private void m(File file, String str) throws IOException {
        try {
            FileUtils.a(file);
        } catch (FileUtils.CreateDirectoryException e) {
            this.d.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, "DefaultDiskStorage", str, e);
            throw e;
        }
    }

    private boolean n(String str, CacheKey cacheKey, boolean z) {
        File e = e(str, cacheKey);
        boolean exists = e.exists();
        if (z && exists) {
            e.setLastModified(System.currentTimeMillis());
        }
        return exists;
    }

    private void o() {
        boolean z = true;
        if (this.a.exists() && this.c.exists()) {
            z = false;
        }
        if (z) {
            try {
                FileUtils.a(this.c);
            } catch (FileUtils.CreateDirectoryException unused) {
                CacheErrorLogger cacheErrorLogger = this.d;
                if (cacheErrorLogger != null) {
                    CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR;
                    cacheErrorLogger.logError(cacheErrorCategory, "DefaultDiskStorage", "version directory could not be created: " + this.c, null);
                }
            }
        }
    }

    private String p(byte[] bArr) {
        return bArr.length >= 2 ? (bArr[0] == -1 && bArr[1] == -40) ? "jpg" : (bArr[0] == -119 && bArr[1] == 80) ? "png" : (bArr[0] == 82 && bArr[1] == 73) ? "webp" : (bArr[0] == 71 && bArr[1] == 73) ? "gif" : Constants.Name.UNDEFINED : Constants.Name.UNDEFINED;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.DiskStorage
    public void clearAll() {
        C6285a.a(this.a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.DiskStorage
    public boolean contains(String str, CacheKey cacheKey, Object obj) {
        return n(str, cacheKey, false);
    }

    @VisibleForTesting
    File e(String str, CacheKey cacheKey) {
        return new File(g(str, cacheKey));
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.DiskStorage
    /* renamed from: f */
    public List<DiskStorage.Entry> getEntries() throws IOException {
        C6277b c6277b = new C6277b();
        C6285a.c(this.c, c6277b);
        return c6277b.a();
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.DiskStorage
    public List<String> getCatalogs(String str) {
        File[] listFiles = i(str).listFiles();
        ArrayList arrayList = new ArrayList();
        if (listFiles != null) {
            for (File file : listFiles) {
                C6279d b = C6279d.b(file);
                if (b != null && b.a == FileType.CONTENT && str.equals(b.b) && !TextUtils.isEmpty(b.c)) {
                    try {
                        arrayList.add(new String(Base64.decode(b.c, 11), "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.DiskStorage
    public DiskStorage.C6281a getDumpInfo() throws IOException {
        List<DiskStorage.Entry> entries = getEntries();
        DiskStorage.C6281a c6281a = new DiskStorage.C6281a();
        for (DiskStorage.Entry entry : entries) {
            DiskStorage.C6282b d = d(entry);
            String str = d.a;
            if (!c6281a.b.containsKey(str)) {
                c6281a.b.put(str, 0);
            }
            Map<String, Integer> map = c6281a.b;
            map.put(str, Integer.valueOf(map.get(str).intValue() + 1));
            c6281a.a.add(d);
        }
        return c6281a;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.DiskStorage
    public BinaryResource getResource(String str, CacheKey cacheKey, Object obj) {
        File e = e(str, cacheKey);
        if (e.exists()) {
            e.setLastModified(System.currentTimeMillis());
            return C6272a.a(e);
        }
        return null;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.DiskStorage
    public String getStorageName() {
        String absolutePath = this.a.getAbsolutePath();
        return JSMethod.NOT_SET + absolutePath.substring(absolutePath.lastIndexOf(47) + 1, absolutePath.length()) + JSMethod.NOT_SET + absolutePath.hashCode();
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.DiskStorage
    public DiskStorage.Inserter insert(String str, CacheKey cacheKey, Object obj) throws IOException {
        C6279d c6279d = new C6279d(FileType.TEMP, str, cacheKey);
        File i = i(c6279d.b);
        if (!i.exists()) {
            m(i, "insert");
        }
        try {
            return new C6280e(str, c6279d.a(i));
        } catch (IOException e) {
            this.d.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, "DefaultDiskStorage", "insert", e);
            throw e;
        }
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.DiskStorage
    public boolean isEnabled() {
        return true;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.DiskStorage
    public boolean isExternal() {
        return this.b;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.DiskStorage
    public void purgeUnexpectedResources() throws IOException {
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.DiskStorage
    public long remove(DiskStorage.Entry entry) {
        return c(((C6278c) entry).getResource().b());
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.DiskStorage
    public boolean touch(String str, CacheKey cacheKey, Object obj) {
        return n(str, cacheKey, true);
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.DiskStorage
    public long remove(String str, CacheKey cacheKey) {
        return c(e(str, cacheKey));
    }
}
