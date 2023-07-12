package tb;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.android.ultron.datamodel.cache.db.FileCache;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class rl2 {
    protected final String a;
    protected final String b;
    protected final long c;
    protected final Context d;
    protected final File e;
    protected FileCache f;

    /* compiled from: Taobao */
    /* renamed from: tb.rl2$a */
    /* loaded from: classes11.dex */
    class AsyncTaskC9654a extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ String a;
        final /* synthetic */ byte[] b;

        AsyncTaskC9654a(String str, byte[] bArr) {
            this.a = str;
            this.b = bArr;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            String str = this.a;
            synchronized (rl2.class) {
                File file = new File(rl2.this.e, str);
                if (file.exists()) {
                    return null;
                }
                rl2.this.j(this.b, file);
                if (file.isFile() && file.length() > 0) {
                    try {
                        rl2.this.f.h(this.a, file);
                    } catch (Throwable th) {
                        Log.e("TemplateCache", "File cache store exception", th);
                    }
                }
                return null;
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.rl2$b */
    /* loaded from: classes11.dex */
    public static final class C9655b {
        private Context a;
        private String b;
        private String c;
        private int d = 8;
        private long e = 4194304;
        private boolean f = true;

        public rl2 g() {
            if (this.a != null && !TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c)) {
                return new rl2(this, null);
            }
            throw new IllegalArgumentException();
        }

        public C9655b h(Context context) {
            this.a = context;
            return this;
        }

        public C9655b i(String str) {
            this.c = str;
            return this;
        }

        public C9655b j(long j) {
            this.e = j;
            return this;
        }

        public C9655b k(int i) {
            this.d = i;
            return this;
        }

        public C9655b l(String str) {
            this.b = str;
            return this;
        }
    }

    /* synthetic */ rl2(C9655b c9655b, AsyncTaskC9654a asyncTaskC9654a) {
        this(c9655b);
    }

    private File b() {
        File e = e();
        if (e == null) {
            return null;
        }
        File file = new File(e, this.a);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private File e() {
        File filesDir = this.d.getFilesDir();
        if (filesDir == null || !filesDir.canWrite()) {
            File cacheDir = this.d.getCacheDir();
            if (cacheDir == null || !cacheDir.canWrite()) {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    try {
                        File externalFilesDir = this.d.getExternalFilesDir(null);
                        if (externalFilesDir != null && externalFilesDir.canWrite()) {
                            return externalFilesDir;
                        }
                        File externalCacheDir = this.d.getExternalCacheDir();
                        if (externalCacheDir != null) {
                            if (externalCacheDir.canWrite()) {
                                return externalCacheDir;
                            }
                        }
                    } catch (Exception e) {
                        Log.e("TemplateCache", "get external files dir exception", e);
                    }
                }
                return null;
            }
            return cacheDir;
        }
        return filesDir;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0052, code lost:
        if (r8 != r1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0059, code lost:
        return java.util.Arrays.copyOf(r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte[] g(java.io.File r8) throws java.io.IOException {
        /*
            r7 = this;
            long r0 = r8.length()
            java.lang.String r2 = "Required array size too large"
            r3 = 2147483639(0x7ffffff7, double:1.060997891E-314)
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 > 0) goto L5a
            java.io.FileInputStream r3 = new java.io.FileInputStream
            r3.<init>(r8)
            int r8 = (int) r0
            byte[] r0 = new byte[r8]
            r1 = 0
        L16:
            int r4 = r8 - r1
            int r4 = r3.read(r0, r1, r4)
            if (r4 <= 0) goto L20
            int r1 = r1 + r4
            goto L16
        L20:
            if (r4 < 0) goto L4f
            int r4 = r3.read()
            if (r4 >= 0) goto L29
            goto L4f
        L29:
            r5 = 2147483639(0x7ffffff7, float:NaN)
            int r6 = r5 - r8
            if (r8 > r6) goto L39
            int r8 = r8 << 1
            r5 = 8192(0x2000, float:1.148E-41)
            int r8 = java.lang.Math.max(r8, r5)
            goto L3e
        L39:
            if (r8 == r5) goto L49
            r8 = 2147483639(0x7ffffff7, float:NaN)
        L3e:
            byte[] r0 = java.util.Arrays.copyOf(r0, r8)
            int r5 = r1 + 1
            byte r4 = (byte) r4
            r0[r1] = r4
            r1 = r5
            goto L16
        L49:
            java.lang.OutOfMemoryError r8 = new java.lang.OutOfMemoryError
            r8.<init>(r2)
            throw r8
        L4f:
            r3.close()
            if (r8 != r1) goto L55
            goto L59
        L55:
            byte[] r0 = java.util.Arrays.copyOf(r0, r1)
        L59:
            return r0
        L5a:
            java.lang.OutOfMemoryError r8 = new java.lang.OutOfMemoryError
            r8.<init>(r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.rl2.g(java.io.File):byte[]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0026, code lost:
        if (r1 != null) goto L6;
     */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x001f: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:15:0x001f */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0022 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.io.File j(byte[] r4, java.io.File r5) {
        /*
            r3 = this;
            r0 = 0
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L16
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L16
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L16
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L16
            r1.write(r4)     // Catch: java.lang.Exception -> L12 java.lang.Throwable -> L1e
        Le:
            r1.close()     // Catch: java.io.IOException -> L29
            goto L29
        L12:
            goto L17
        L14:
            r4 = move-exception
            goto L20
        L16:
            r1 = r0
        L17:
            if (r5 == 0) goto L26
            r5.delete()     // Catch: java.lang.Throwable -> L1e
            r5 = r0
            goto L26
        L1e:
            r4 = move-exception
            r0 = r1
        L20:
            if (r0 == 0) goto L25
            r0.close()     // Catch: java.io.IOException -> L25
        L25:
            throw r4
        L26:
            if (r1 == 0) goto L29
            goto Le
        L29:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.rl2.j(byte[], java.io.File):java.io.File");
    }

    public synchronized void c(String str) {
        this.f.b(str);
    }

    public byte[] d(String str) {
        FileCache.C6655b f = this.f.f(str);
        if (f != null) {
            byte[] h = h(f.c);
            if (h == null || h.length <= 0) {
                return h;
            }
            Log.d("TemplateCache", "[getTemplateById #" + str + "] get template from file.");
            return h;
        }
        return null;
    }

    public List<String> f() {
        ArrayList arrayList = new ArrayList();
        List<FileCache.C6655b> c = this.f.c();
        if (c != null && c.size() != 0) {
            for (FileCache.C6655b c6655b : c) {
                arrayList.add(c6655b.b);
            }
        }
        return arrayList;
    }

    protected byte[] h(File file) {
        try {
            return g(file);
        } catch (IOException e) {
            Log.e("TemplateCache", "Read all bytes exception:", e);
            return null;
        }
    }

    public void i(String str, byte[] bArr) {
        if (bArr == null) {
            Log.d("TemplateCache", "[getTemplateById #" + str + "] template from server is null.");
            return;
        }
        new AsyncTaskC9654a(str, bArr).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    private rl2(C9655b c9655b) {
        this.a = c9655b.b;
        Context context = c9655b.a;
        this.d = context;
        String str = c9655b.c;
        this.b = str;
        int unused = c9655b.d;
        long j = c9655b.e;
        this.c = j;
        boolean unused2 = c9655b.f;
        File b = b();
        this.e = b;
        this.f = new FileCache(context, b, str, j);
    }
}
