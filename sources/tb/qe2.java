package tb;

import android.text.TextUtils;
import com.taobao.android.sopatch.download.C6634a;
import com.taobao.android.sopatch.download.FileDownloader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class qe2 {
    public static boolean a(pe2 pe2Var) {
        File e = oi0.e(pe2Var);
        if (e == null || !e.exists()) {
            return false;
        }
        return TextUtils.equals(pe2Var.c(), pc1.a(e));
    }

    public static void b(pe2 pe2Var, FileDownloader.Callback callback) {
        File e = oi0.e(pe2Var);
        if (e != null) {
            new C6634a().download(pe2Var.g(), e, callback);
        } else {
            callback.onFail();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v9 */
    private static String c(ZipFile zipFile, ZipEntry zipEntry, File file) {
        ?? r2;
        FileOutputStream fileOutputStream;
        Closeable closeable = null;
        try {
            if (file != null) {
                try {
                    zipFile = zipFile.getInputStream(zipEntry);
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        zipEntry = null;
                        closeable = zipFile;
                        r2 = zipEntry;
                        yj.a(closeable);
                        yj.a(r2);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    zipFile = 0;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    r2 = 0;
                    yj.a(closeable);
                    yj.a(r2);
                    throw th;
                }
                try {
                    String a = v21.a(zipFile, fileOutputStream);
                    yj.a(zipFile);
                    yj.a(fileOutputStream);
                    return a;
                } catch (Exception e3) {
                    e = e3;
                    ob1.e(e);
                    yj.a(zipFile);
                    yj.a(fileOutputStream);
                    return null;
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0092, code lost:
        r0.clear();
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00c7 -> B:61:0x00ca). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<tb.me2> d(tb.pe2 r10) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.io.File r1 = tb.oi0.e(r10)
            if (r1 == 0) goto Ld6
            boolean r2 = r1.exists()
            if (r2 == 0) goto Ld6
            boolean r2 = r1.isFile()
            if (r2 == 0) goto Ld6
            java.lang.String r2 = r1.getName()
            java.lang.String r3 = ".zip"
            boolean r2 = r2.endsWith(r3)
            if (r2 != 0) goto L2f
            java.lang.String r2 = r1.getName()
            java.lang.String r3 = ".aar"
            boolean r2 = r2.endsWith(r3)
            if (r2 == 0) goto Ld6
        L2f:
            long r2 = r1.length()
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L3b
            goto Ld6
        L3b:
            java.lang.String r2 = tb.a42.a()
            r3 = 0
            java.util.zip.ZipFile r4 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
            r4.<init>(r1)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
            java.util.Enumeration r1 = r4.entries()     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
        L49:
            boolean r3 = r1.hasMoreElements()     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            if (r3 == 0) goto Lad
            java.lang.Object r3 = r1.nextElement()     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            java.util.zip.ZipEntry r3 = (java.util.zip.ZipEntry) r3     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            java.lang.String r5 = r3.getName()     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            boolean r6 = r3.isDirectory()     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            if (r6 != 0) goto L49
            boolean r6 = r5.contains(r2)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            if (r6 == 0) goto L49
            java.lang.String r6 = ".so"
            boolean r6 = r5.endsWith(r6)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            if (r6 != 0) goto L6e
            goto L49
        L6e:
            java.lang.String r5 = tb.ti0.a(r5)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            tb.me2 r6 = r10.a(r5)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            boolean r7 = tb.oe2.b(r6)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            if (r7 == 0) goto L80
            r0.add(r6)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            goto L49
        L80:
            long r6 = r3.getSize()     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            java.io.File r6 = tb.oi0.d(r5, r6)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            java.lang.String r3 = c(r4, r3, r6)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            boolean r7 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            if (r7 == 0) goto L96
            r0.clear()     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            goto Lad
        L96:
            long r7 = r6.length()     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            int r9 = r10.d()     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            tb.me2 r3 = tb.he2.c(r5, r3, r7, r9)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            java.io.File r5 = tb.oi0.b(r3)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            tb.ti0.b(r6, r5)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            r0.add(r3)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            goto L49
        Lad:
            r4.close()     // Catch: java.lang.Exception -> Lc6
            goto Lca
        Lb1:
            r10 = move-exception
            r3 = r4
            goto Lcb
        Lb4:
            r10 = move-exception
            r3 = r4
            goto Lba
        Lb7:
            r10 = move-exception
            goto Lcb
        Lb9:
            r10 = move-exception
        Lba:
            r0.clear()     // Catch: java.lang.Throwable -> Lb7
            tb.ob1.e(r10)     // Catch: java.lang.Throwable -> Lb7
            if (r3 == 0) goto Lca
            r3.close()     // Catch: java.lang.Exception -> Lc6
            goto Lca
        Lc6:
            r10 = move-exception
            tb.ob1.e(r10)
        Lca:
            return r0
        Lcb:
            if (r3 == 0) goto Ld5
            r3.close()     // Catch: java.lang.Exception -> Ld1
            goto Ld5
        Ld1:
            r0 = move-exception
            tb.ob1.e(r0)
        Ld5:
            throw r10
        Ld6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.qe2.d(tb.pe2):java.util.List");
    }
}
