package com.xiaomi.push.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.C7594ab;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class aw {
    private static long a;

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.aw$a */
    /* loaded from: classes11.dex */
    public static class C7730a {
        int a;

        /* renamed from: a  reason: collision with other field name */
        byte[] f902a;

        public C7730a(byte[] bArr, int i) {
            this.f902a = bArr;
            this.a = i;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.aw$b */
    /* loaded from: classes11.dex */
    public static class C7731b {
        public long a;

        /* renamed from: a  reason: collision with other field name */
        public Bitmap f903a;

        public C7731b(Bitmap bitmap, long j) {
            this.f903a = bitmap;
            this.a = j;
        }
    }

    private static int a(Context context, InputStream inputStream) {
        int i;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            AbstractC7535b.m586a("decode dimension failed for bitmap.");
            return 1;
        }
        int round = Math.round((context.getResources().getDisplayMetrics().densityDpi / 160.0f) * 48.0f);
        int i2 = options.outWidth;
        if (i2 <= round || (i = options.outHeight) <= round) {
            return 1;
        }
        return Math.min(i2 / round, i / round);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v3 */
    public static Bitmap a(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2;
        int a2;
        Uri parse = Uri.parse(str);
        ?? r0 = 0;
        r0 = 0;
        try {
            try {
                inputStream = context.getContentResolver().openInputStream(parse);
                try {
                    a2 = a(context, inputStream);
                    inputStream2 = context.getContentResolver().openInputStream(parse);
                } catch (IOException e) {
                    e = e;
                    inputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                    C7594ab.a((Closeable) r0);
                    C7594ab.a(inputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                inputStream2 = null;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = a2;
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream2, null, options);
                C7594ab.a(inputStream2);
                C7594ab.a(inputStream);
                return decodeStream;
            } catch (IOException e3) {
                e = e3;
                AbstractC7535b.a(e);
                C7594ab.a(inputStream2);
                C7594ab.a(inputStream);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            r0 = context;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d5, code lost:
        if (r1 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d7, code lost:
        r1.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f4, code lost:
        if (r1 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f7, code lost:
        return null;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00f9: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:56:0x00f9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.xiaomi.push.service.aw.C7730a a(java.lang.String r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.aw.a(java.lang.String, boolean):com.xiaomi.push.service.aw$a");
    }

    public static C7731b a(Context context, String str, boolean z) {
        C7730a a2;
        ByteArrayInputStream byteArrayInputStream = null;
        C7731b c7731b = new C7731b(null, 0L);
        Bitmap b = b(context, str);
        try {
            if (b != null) {
                c7731b.f903a = b;
                return c7731b;
            }
            try {
                a2 = a(str, z);
            } catch (Exception e) {
                e = e;
            }
            if (a2 == null) {
                C7594ab.a((Closeable) null);
                return c7731b;
            }
            c7731b.a = a2.a;
            byte[] bArr = a2.f902a;
            if (bArr != null) {
                if (z) {
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                    try {
                        int a3 = a(context, byteArrayInputStream2);
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = a3;
                        c7731b.f903a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        byteArrayInputStream = byteArrayInputStream2;
                    } catch (Exception e2) {
                        e = e2;
                        byteArrayInputStream = byteArrayInputStream2;
                        AbstractC7535b.a(e);
                        C7594ab.a(byteArrayInputStream);
                        return c7731b;
                    } catch (Throwable th) {
                        th = th;
                        byteArrayInputStream = byteArrayInputStream2;
                        C7594ab.a(byteArrayInputStream);
                        throw th;
                    }
                } else {
                    c7731b.f903a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                }
            }
            a(context, a2.f902a, str);
            C7594ab.a(byteArrayInputStream);
            return c7731b;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void a(Context context) {
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon");
        if (file.exists()) {
            if (a == 0) {
                a = com.xiaomi.push.aa.a(file);
            }
            if (a > 15728640) {
                try {
                    File[] listFiles = file.listFiles();
                    for (int i = 0; i < listFiles.length; i++) {
                        if (!listFiles[i].isDirectory() && Math.abs(System.currentTimeMillis() - listFiles[i].lastModified()) > 1209600) {
                            listFiles[i].delete();
                        }
                    }
                } catch (Exception e) {
                    AbstractC7535b.a(e);
                }
                a = 0L;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(android.content.Context r5, byte[] r6, java.lang.String r7) {
        /*
            if (r6 != 0) goto L8
            java.lang.String r5 = "cannot save small icon cause bitmap is null"
            com.xiaomi.channel.commonutils.logger.AbstractC7535b.m586a(r5)
            return
        L8:
            a(r5)
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.io.File r2 = r5.getCacheDir()
            java.lang.String r2 = r2.getPath()
            r1.append(r2)
            java.lang.String r2 = java.io.File.separator
            r1.append(r2)
            java.lang.String r2 = "mipush_icon"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L37
            r0.mkdirs()
        L37:
            java.io.File r1 = new java.io.File
            java.lang.String r7 = com.xiaomi.push.bp.a(r7)
            r1.<init>(r0, r7)
            r7 = 0
            boolean r0 = r1.exists()     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
            if (r0 != 0) goto L4a
            r1.createNewFile()     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
        L4a:
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> La9
            r3.<init>(r0)     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> La9
            r3.write(r6)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
            r3.flush()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
            com.xiaomi.push.C7594ab.a(r3)
            goto L71
        L5e:
            r5 = move-exception
            r7 = r3
            goto Laa
        L61:
            r6 = move-exception
            r7 = r3
            goto L6b
        L64:
            r6 = move-exception
            goto L6b
        L66:
            r5 = move-exception
            r0 = r7
            goto Laa
        L69:
            r6 = move-exception
            r0 = r7
        L6b:
            com.xiaomi.channel.commonutils.logger.AbstractC7535b.a(r6)     // Catch: java.lang.Throwable -> La9
            com.xiaomi.push.C7594ab.a(r7)
        L71:
            com.xiaomi.push.C7594ab.a(r0)
            long r6 = com.xiaomi.push.service.aw.a
            r3 = 0
            int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r0 != 0) goto La8
            java.io.File r6 = new java.io.File
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.io.File r5 = r5.getCacheDir()
            java.lang.String r5 = r5.getPath()
            r7.append(r5)
            java.lang.String r5 = java.io.File.separator
            r7.append(r5)
            r7.append(r2)
            java.lang.String r5 = r7.toString()
            r6.<init>(r5)
            long r5 = com.xiaomi.push.aa.a(r6)
            long r0 = r1.length()
            long r5 = r5 + r0
            com.xiaomi.push.service.aw.a = r5
        La8:
            return
        La9:
            r5 = move-exception
        Laa:
            com.xiaomi.push.C7594ab.a(r7)
            com.xiaomi.push.C7594ab.a(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.aw.a(android.content.Context, byte[], java.lang.String):void");
    }

    private static Bitmap b(Context context, String str) {
        Throwable th;
        FileInputStream fileInputStream;
        Bitmap bitmap;
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon", com.xiaomi.push.bp.a(str));
        FileInputStream fileInputStream2 = null;
        Bitmap bitmap2 = null;
        fileInputStream2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    bitmap2 = BitmapFactory.decodeStream(fileInputStream);
                    file.setLastModified(System.currentTimeMillis());
                    C7594ab.a(fileInputStream);
                    return bitmap2;
                } catch (Exception e) {
                    e = e;
                    Bitmap bitmap3 = bitmap2;
                    fileInputStream2 = fileInputStream;
                    bitmap = bitmap3;
                    AbstractC7535b.a(e);
                    C7594ab.a(fileInputStream2);
                    return bitmap;
                } catch (Throwable th2) {
                    th = th2;
                    C7594ab.a(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                FileInputStream fileInputStream3 = fileInputStream2;
                th = th3;
                fileInputStream = fileInputStream3;
            }
        } catch (Exception e2) {
            e = e2;
            bitmap = null;
        }
    }
}
