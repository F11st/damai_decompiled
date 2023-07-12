package com.taobao.android.dinamic.tempate.manager;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import com.taobao.android.dinamic.C6312a;
import com.taobao.android.dinamic.C6313b;
import com.taobao.android.dinamic.log.DinamicLog;
import com.taobao.android.dinamic.tempate.DinamicTemplate;
import com.taobao.android.dinamic.tempate.db.FileCache;
import java.io.File;
import java.io.IOException;
import tb.ul2;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class TemplateCache {
    public static HttpLoader k = new C6348b();
    protected final String a;
    protected final String b;
    protected final long c;
    protected final int d;
    protected final Context e;
    protected final File f;
    protected final boolean g;
    protected FileCache h;
    protected LruCache<String, byte[]> i;
    protected HttpLoader j;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamic.tempate.manager.TemplateCache$2  reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ ul2 val$info;
        final /* synthetic */ boolean val$isSuccess;
        final /* synthetic */ DinamicTemplate val$template;

        AnonymousClass2(DinamicTemplate dinamicTemplate, ul2 ul2Var, boolean z) {
            this.val$template = dinamicTemplate;
            this.val$info = ul2Var;
            this.val$isSuccess = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C6313b.e()) {
                DinamicLog.a(C6313b.TAG, "download template=" + this.val$template + (((float) this.val$info.b) / 1000000.0d));
            }
            C6312a.h().d();
            ul2 ul2Var = this.val$info;
            String str = ul2Var.c;
            long j = ul2Var.b;
            throw null;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamic.tempate.manager.TemplateCache$3  reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ long val$consumingTime;
        final /* synthetic */ boolean val$isSuccess;
        final /* synthetic */ String val$module;
        final /* synthetic */ DinamicTemplate val$template;

        AnonymousClass3(DinamicTemplate dinamicTemplate, long j, String str, boolean z) {
            this.val$template = dinamicTemplate;
            this.val$consumingTime = j;
            this.val$module = str;
            this.val$isSuccess = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C6313b.e()) {
                DinamicLog.a(C6313b.TAG, "write template=" + this.val$template + (((float) this.val$consumingTime) / 1000000.0d));
            }
            C6312a.h().d();
            throw null;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface HttpLoader {
        byte[] loadUrl(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamic.tempate.manager.TemplateCache$a */
    /* loaded from: classes12.dex */
    public class AsyncTaskC6347a extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ byte[] c;
        final /* synthetic */ DinamicTemplate d;
        final /* synthetic */ ul2 e;

        AsyncTaskC6347a(String str, String str2, byte[] bArr, DinamicTemplate dinamicTemplate, ul2 ul2Var) {
            this.a = str;
            this.b = str2;
            this.c = bArr;
            this.d = dinamicTemplate;
            this.e = ul2Var;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            String lastPathSegment;
            if (TemplateCache.this.g) {
                lastPathSegment = this.a;
            } else {
                lastPathSegment = Uri.parse(Uri.decode(this.b)).getLastPathSegment();
            }
            synchronized (TemplateCache.class) {
                File file = new File(TemplateCache.this.f, lastPathSegment);
                if (file.exists()) {
                    return null;
                }
                TemplateCache.this.m(this.c, file, this.d, this.e.c);
                if (file.isFile() && file.length() > 0) {
                    try {
                        TemplateCache.this.h.g(this.a, file);
                    } catch (Throwable th) {
                        Log.e("TemplateCache", "File cache store exception", th);
                    }
                }
                return null;
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamic.tempate.manager.TemplateCache$b */
    /* loaded from: classes11.dex */
    static class C6348b implements HttpLoader {
        C6348b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:44:0x0080, code lost:
            if (r8 == null) goto L24;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x007d A[Catch: IOException -> 0x0079, TRY_LEAVE, TryCatch #0 {IOException -> 0x0079, blocks: (B:40:0x0075, B:43:0x007d), top: B:51:0x0075 }] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.taobao.android.dinamic.tempate.manager.TemplateCache.HttpLoader
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public byte[] loadUrl(java.lang.String r8) {
            /*
                r7 = this;
                r0 = 0
                java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L70
                r1.<init>(r8)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L70
                java.net.URLConnection r8 = r1.openConnection()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L70
                java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L70
                r1 = 10000(0x2710, float:1.4013E-41)
                r8.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L56
                r1 = 12000(0x2ee0, float:1.6816E-41)
                r8.setReadTimeout(r1)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L56
                r8.connect()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L56
                int r1 = r8.getResponseCode()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L56
                r2 = 200(0xc8, float:2.8E-43)
                if (r1 == r2) goto L25
                r8.disconnect()
                return r0
            L25:
                java.io.InputStream r1 = r8.getInputStream()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L56
                java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4f
                r3 = 4096(0x1000, float:5.74E-42)
                r2.<init>(r3)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4f
                byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L73
            L32:
                int r4 = r1.read(r3)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L73
                r5 = -1
                if (r4 == r5) goto L3e
                r5 = 0
                r2.write(r3, r5, r4)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L73
                goto L32
            L3e:
                r2.close()     // Catch: java.io.IOException -> L44
                r1.close()     // Catch: java.io.IOException -> L44
            L44:
                r8.disconnect()
                goto L83
            L48:
                r0 = move-exception
                goto L5d
            L4a:
                r2 = move-exception
                r6 = r2
                r2 = r0
                r0 = r6
                goto L5d
            L4f:
                r2 = r0
                goto L73
            L51:
                r1 = move-exception
                r2 = r0
                r0 = r1
                r1 = r2
                goto L5d
            L56:
                r1 = r0
                goto L72
            L58:
                r8 = move-exception
                r1 = r0
                r2 = r1
                r0 = r8
                r8 = r2
            L5d:
                if (r2 == 0) goto L65
                r2.close()     // Catch: java.io.IOException -> L63
                goto L65
            L63:
                goto L6a
            L65:
                if (r1 == 0) goto L6a
                r1.close()     // Catch: java.io.IOException -> L63
            L6a:
                if (r8 == 0) goto L6f
                r8.disconnect()
            L6f:
                throw r0
            L70:
                r8 = r0
                r1 = r8
            L72:
                r2 = r1
            L73:
                if (r2 == 0) goto L7b
                r2.close()     // Catch: java.io.IOException -> L79
                goto L7b
            L79:
                goto L80
            L7b:
                if (r1 == 0) goto L80
                r1.close()     // Catch: java.io.IOException -> L79
            L80:
                if (r8 == 0) goto L83
                goto L44
            L83:
                if (r2 == 0) goto L89
                byte[] r0 = r2.toByteArray()
            L89:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamic.tempate.manager.TemplateCache.C6348b.loadUrl(java.lang.String):byte[]");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamic.tempate.manager.TemplateCache$c */
    /* loaded from: classes12.dex */
    public static final class C6349c {
        private Context a;
        private String b;
        private String c;
        private int d = 8;
        private long e = 4194304;
        private boolean f = true;

        public TemplateCache g() {
            if (!TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c)) {
                return new TemplateCache(this, null);
            }
            throw new IllegalArgumentException();
        }

        public C6349c h(Context context) {
            this.a = context;
            return this;
        }

        public C6349c i(String str) {
            this.c = str;
            return this;
        }

        public C6349c j(long j) {
            this.e = j;
            return this;
        }

        public C6349c k(int i) {
            this.d = i;
            return this;
        }

        public C6349c l(String str) {
            this.b = str;
            return this;
        }
    }

    /* synthetic */ TemplateCache(C6349c c6349c, AsyncTaskC6347a asyncTaskC6347a) {
        this(c6349c);
    }

    private File b() {
        File f;
        if (this.e == null || (f = f()) == null) {
            return null;
        }
        File file = new File(f, this.a);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private byte[] e(DinamicTemplate dinamicTemplate, String str, String str2, ul2 ul2Var) {
        long nanoTime = System.nanoTime();
        byte[] loadUrl = this.j.loadUrl(str2);
        long nanoTime2 = System.nanoTime();
        ul2Var.a = 3;
        ul2Var.b = nanoTime2 - nanoTime;
        i(ul2Var, dinamicTemplate, loadUrl != null);
        if (loadUrl != null) {
            this.i.put(str, loadUrl);
            Log.d("TemplateCache", "[getTemplateById #" + str + "] get template from server.");
            new AsyncTaskC6347a(str, str2, loadUrl, dinamicTemplate, ul2Var).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
            return loadUrl;
        }
        Log.d("TemplateCache", "[getTemplateById #" + str + "] template from server is null.");
        return null;
    }

    private File f() {
        File filesDir = this.e.getFilesDir();
        if (filesDir == null || !filesDir.canWrite()) {
            File cacheDir = this.e.getCacheDir();
            if (cacheDir == null || !cacheDir.canWrite()) {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    try {
                        File externalFilesDir = this.e.getExternalFilesDir(null);
                        if (externalFilesDir != null && externalFilesDir.canWrite()) {
                            return externalFilesDir;
                        }
                        File externalCacheDir = this.e.getExternalCacheDir();
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

    private void i(ul2 ul2Var, DinamicTemplate dinamicTemplate, boolean z) {
        C6312a.h().d();
    }

    private void j(String str, DinamicTemplate dinamicTemplate, boolean z, long j) {
        C6312a.h().d();
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
    private byte[] k(java.io.File r8) throws java.io.IOException {
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
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamic.tempate.manager.TemplateCache.k(java.io.File):byte[]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
        if (r3 == null) goto L10;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.io.File m(byte[] r12, java.io.File r13, com.taobao.android.dinamic.tempate.DinamicTemplate r14, java.lang.String r15) {
        /*
            r11 = this;
            long r0 = java.lang.System.nanoTime()
            r2 = 0
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            r4.<init>(r13)     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            r3.write(r12)     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L3f
            r8 = 1
            long r4 = java.lang.System.nanoTime()     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L3f
            long r9 = r4 - r0
            r5 = r11
            r6 = r15
            r7 = r14
            r5.j(r6, r7, r8, r9)     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L3f
        L1f:
            r3.close()     // Catch: java.io.IOException -> L3e
            goto L3e
        L23:
            goto L28
        L25:
            r12 = move-exception
            goto L41
        L27:
            r3 = r2
        L28:
            if (r13 == 0) goto L2e
            r13.delete()     // Catch: java.lang.Throwable -> L3f
            r13 = r2
        L2e:
            r7 = 0
            long r4 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L3f
            long r8 = r4 - r0
            r4 = r11
            r5 = r15
            r6 = r14
            r4.j(r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L3f
            if (r3 == 0) goto L3e
            goto L1f
        L3e:
            return r13
        L3f:
            r12 = move-exception
            r2 = r3
        L41:
            if (r2 == 0) goto L46
            r2.close()     // Catch: java.io.IOException -> L46
        L46:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamic.tempate.manager.TemplateCache.m(byte[], java.io.File, com.taobao.android.dinamic.tempate.DinamicTemplate, java.lang.String):java.io.File");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] c(String str, ul2 ul2Var) throws IOException {
        byte[] bArr;
        System.currentTimeMillis();
        FileCache.C6343b e = this.h.e(str);
        if (e != null) {
            bArr = l(e.b);
            if (bArr != null && bArr.length > 0) {
                Log.d("TemplateCache", "[getTemplateById #" + str + "] get template from file.");
                this.i.put(str, bArr);
            }
        } else {
            bArr = null;
        }
        System.currentTimeMillis();
        ul2Var.a = 2;
        return bArr;
    }

    protected byte[] d(String str, ul2 ul2Var) {
        System.currentTimeMillis();
        byte[] bArr = this.i.get(str);
        System.currentTimeMillis();
        ul2Var.a = 1;
        Log.d("TemplateCache", "[getTemplateById #" + str + "] get template from memory.");
        return bArr;
    }

    public File g() {
        return this.f;
    }

    public byte[] h(DinamicTemplate dinamicTemplate, String str, String str2, ul2 ul2Var) {
        byte[] d = d(str, ul2Var);
        if (d != null) {
            return d;
        }
        try {
            d = c(str, ul2Var);
        } catch (IOException unused) {
        }
        return d != null ? d : e(dinamicTemplate, str, str2, ul2Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] l(File file) throws IOException {
        return k(file);
    }

    private TemplateCache(C6349c c6349c) {
        this.j = k;
        this.a = c6349c.b;
        Context context = c6349c.a;
        this.e = context;
        String str = c6349c.c;
        this.b = str;
        int i = c6349c.d;
        this.d = i;
        long j = c6349c.e;
        this.c = j;
        this.g = c6349c.f;
        File b = b();
        this.f = b;
        this.i = new LruCache<>(i);
        this.h = new FileCache(context, b, str, j);
    }
}
