package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.StatFs;
import android.taobao.windvane.connect.HttpRequest;
import android.text.TextUtils;
import com.amap.api.mapcore.util.hy;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.util.HashMap;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class eu {
    private static final Bitmap.CompressFormat a = Bitmap.CompressFormat.PNG;
    private hy b;
    private ec<String, Bitmap> c;
    private a d;
    private final Object e = new Object();
    private boolean f = true;
    private HashMap<String, WeakReference<Bitmap>> g;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        public File c;
        public String j;
        public int a = HttpRequest.DEFAULT_MAX_LENGTH;
        public long b = 10485760;
        public Bitmap.CompressFormat d = eu.a;
        public int e = 100;
        public boolean f = true;
        public boolean g = true;
        public boolean h = false;
        public boolean i = true;

        public a(Context context, String str) {
            this.j = null;
            this.j = str;
            this.c = eu.a(context, str, null);
        }

        public void a(int i) {
            this.a = i;
        }

        public void b(boolean z) {
            this.g = z;
        }

        public void a(long j) {
            if (j <= 0) {
                this.g = false;
            }
            this.b = j;
        }

        public void b(String str) {
            this.c = eu.a(t.a, this.j, str);
        }

        public void a(String str) {
            this.c = new File(str);
        }

        public void a(boolean z) {
            this.f = z;
        }

        public a(Context context, String str, String str2) {
            this.j = null;
            this.j = str;
            this.c = eu.a(context, str, str2);
        }
    }

    private eu(a aVar) {
        b(aVar);
    }

    private void b(a aVar) {
        this.d = aVar;
        if (aVar.f) {
            if (ev.a()) {
                this.g = new HashMap<>(64);
            }
            this.c = new ec<String, Bitmap>(this.d.a) { // from class: com.amap.api.mapcore.util.eu.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.amap.api.mapcore.util.ec
                public void a(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
                    if (!eq.c() || eu.this.g == null || bitmap == null || bitmap.isRecycled()) {
                        return;
                    }
                    eu.this.g.put(str, new WeakReference(bitmap));
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.amap.api.mapcore.util.ec
                /* renamed from: a */
                public int b(String str, Bitmap bitmap) {
                    int a2 = eu.a(bitmap);
                    if (a2 == 0) {
                        return 1;
                    }
                    return a2;
                }
            };
        }
        if (aVar.h) {
            a();
        }
    }

    public static boolean d() {
        if (eq.b()) {
            return Environment.isExternalStorageRemovable();
        }
        return true;
    }

    public void c() {
        synchronized (this.e) {
            hy hyVar = this.b;
            if (hyVar != null) {
                try {
                    hyVar.e();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static eu a(a aVar) {
        return new eu(aVar);
    }

    public void a() {
        synchronized (this.e) {
            hy hyVar = this.b;
            if (hyVar == null || hyVar.d()) {
                a aVar = this.d;
                File file = aVar.c;
                if (aVar.g && file != null) {
                    try {
                        if (file.exists()) {
                            if (this.d.i) {
                                b(file);
                                file.mkdir();
                            }
                        } else {
                            file.mkdirs();
                        }
                    } catch (Throwable unused) {
                    }
                    long a2 = a(file);
                    long j = this.d.b;
                    if (a2 > j) {
                        this.b = hy.a(file, 1, 1, j);
                    }
                }
            }
            this.f = false;
            this.e.notifyAll();
        }
    }

    public static String c(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(str.getBytes("utf-8"));
            return a(messageDigest.digest());
        } catch (Throwable unused) {
            return String.valueOf(str.hashCode());
        }
    }

    private void b(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    b(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + file);
    }

    public Bitmap b(String str) {
        Bitmap bitmap;
        InputStream inputStream;
        Bitmap bitmap2;
        String c = c(str);
        synchronized (this.e) {
            while (this.f) {
                try {
                    this.e.wait();
                } catch (Throwable unused) {
                }
            }
            hy hyVar = this.b;
            bitmap = null;
            InputStream inputStream2 = null;
            bitmap = null;
            bitmap = null;
            bitmap = null;
            if (hyVar != null) {
                try {
                    hy.b a2 = hyVar.a(c);
                    if (a2 != null) {
                        inputStream = a2.a(0);
                        if (inputStream != null) {
                            try {
                                bitmap2 = es.a(((FileInputStream) inputStream).getFD(), Integer.MAX_VALUE, Integer.MAX_VALUE, this);
                            } catch (Throwable unused2) {
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable unused3) {
                                    }
                                }
                                return bitmap;
                            }
                        } else {
                            bitmap2 = null;
                        }
                        inputStream2 = inputStream;
                    } else {
                        bitmap2 = null;
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    bitmap = bitmap2;
                } catch (Throwable unused5) {
                    inputStream = null;
                }
            }
        }
        return bitmap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
        if (r1 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0050, code lost:
        if (0 != 0) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r5, android.graphics.Bitmap r6) {
        /*
            r4 = this;
            if (r5 == 0) goto L58
            if (r6 == 0) goto L58
            boolean r0 = r6.isRecycled()
            if (r0 == 0) goto Lb
            goto L58
        Lb:
            com.amap.api.mapcore.util.ec<java.lang.String, android.graphics.Bitmap> r0 = r4.c
            if (r0 == 0) goto L12
            r0.a(r5, r6)
        L12:
            java.lang.Object r0 = r4.e
            monitor-enter(r0)
            com.amap.api.mapcore.util.hy r1 = r4.b     // Catch: java.lang.Throwable -> L55
            if (r1 == 0) goto L53
            java.lang.String r5 = c(r5)     // Catch: java.lang.Throwable -> L55
            r1 = 0
            com.amap.api.mapcore.util.hy r2 = r4.b     // Catch: java.lang.Throwable -> L50
            com.amap.api.mapcore.util.hy$b r2 = r2.a(r5)     // Catch: java.lang.Throwable -> L50
            r3 = 0
            if (r2 != 0) goto L43
            com.amap.api.mapcore.util.hy r2 = r4.b     // Catch: java.lang.Throwable -> L50
            com.amap.api.mapcore.util.hy$a r5 = r2.b(r5)     // Catch: java.lang.Throwable -> L50
            if (r5 == 0) goto L4a
            java.io.OutputStream r1 = r5.a(r3)     // Catch: java.lang.Throwable -> L50
            com.amap.api.mapcore.util.eu$a r2 = r4.d     // Catch: java.lang.Throwable -> L50
            android.graphics.Bitmap$CompressFormat r3 = r2.d     // Catch: java.lang.Throwable -> L50
            int r2 = r2.e     // Catch: java.lang.Throwable -> L50
            r6.compress(r3, r2, r1)     // Catch: java.lang.Throwable -> L50
            r5.a()     // Catch: java.lang.Throwable -> L50
            r1.close()     // Catch: java.lang.Throwable -> L50
            goto L4a
        L43:
            java.io.InputStream r5 = r2.a(r3)     // Catch: java.lang.Throwable -> L50
            r5.close()     // Catch: java.lang.Throwable -> L50
        L4a:
            if (r1 == 0) goto L53
        L4c:
            r1.close()     // Catch: java.lang.Throwable -> L53
            goto L53
        L50:
            if (r1 == 0) goto L53
            goto L4c
        L53:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L55
            return
        L55:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L55
            throw r5
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.eu.a(java.lang.String, android.graphics.Bitmap):void");
    }

    public void b() {
        HashMap<String, WeakReference<Bitmap>> hashMap;
        if (eq.c() && (hashMap = this.g) != null) {
            hashMap.clear();
        }
        ec<String, Bitmap> ecVar = this.c;
        if (ecVar != null) {
            ecVar.a();
        }
        synchronized (this.e) {
            this.f = true;
            hy hyVar = this.b;
            if (hyVar != null && !hyVar.d()) {
                try {
                    this.b.close();
                    b(a(t.a, this.d.j, null));
                } catch (Throwable unused) {
                }
                this.b = null;
                a();
            }
        }
    }

    public Bitmap a(String str) {
        Bitmap bitmap;
        ec<String, Bitmap> ecVar;
        HashMap<String, WeakReference<Bitmap>> hashMap;
        WeakReference<Bitmap> weakReference;
        if (!eq.c() || (hashMap = this.g) == null || (weakReference = hashMap.get(str)) == null) {
            bitmap = null;
        } else {
            bitmap = weakReference.get();
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = null;
            }
            this.g.remove(str);
        }
        if (bitmap == null && (ecVar = this.c) != null) {
            bitmap = ecVar.a((ec<String, Bitmap>) str);
        }
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void a(boolean z) {
        HashMap<String, WeakReference<Bitmap>> hashMap;
        if (eq.c() && (hashMap = this.g) != null) {
            hashMap.clear();
        }
        ec<String, Bitmap> ecVar = this.c;
        if (ecVar != null) {
            ecVar.a();
        }
        synchronized (this.e) {
            hy hyVar = this.b;
            if (hyVar != null) {
                try {
                    if (!hyVar.d()) {
                        if (z) {
                            this.b.f();
                        } else {
                            this.b.close();
                        }
                        this.b = null;
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static File a(Context context, String str, String str2) {
        String path;
        File a2 = a(context);
        if (("mounted".equals(Environment.getExternalStorageState()) || !d()) && a2 != null) {
            path = a2.getPath();
        } else {
            path = context.getCacheDir().getPath();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(path);
        String str3 = File.separator;
        sb.append(str3);
        sb.append(str);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str3);
            sb.append(str2);
        }
        return new File(sb.toString());
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append(YKUpsConvert.CHAR_ZERO);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static int a(Bitmap bitmap) {
        if (eq.d()) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public static File a(Context context) {
        try {
            if (eq.a()) {
                return context.getExternalCacheDir();
            }
            return new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/cache/"));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static long a(File file) {
        if (eq.b()) {
            return file.getUsableSpace();
        }
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSize() * statFs.getAvailableBlocks();
    }
}
