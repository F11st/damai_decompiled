package cn.damai.common.util;

import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import tb.mu0;

/* compiled from: Taobao */
/* renamed from: cn.damai.common.util.a */
/* loaded from: classes13.dex */
public class C0535a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String a = "a";

    public C0535a(Context context) {
        if (context == null) {
            Log.i(a, "context is null");
        }
    }

    public static boolean a(byte[] bArr, File file) {
        FileOutputStream fileOutputStream;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1880528642")) {
            return ((Boolean) ipChange.ipc$dispatch("1880528642", new Object[]{bArr, file})).booleanValue();
        }
        if (bArr == null || file == null) {
            return false;
        }
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable unused) {
        }
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            b(fileOutputStream);
            return true;
        } catch (Throwable unused2) {
            fileOutputStream2 = fileOutputStream;
            b(fileOutputStream2);
            return false;
        }
    }

    public static boolean b(Closeable closeable) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1043743740")) {
            return ((Boolean) ipChange.ipc$dispatch("1043743740", new Object[]{closeable})).booleanValue();
        }
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                Log.w("StackTrace", e);
                return false;
            }
        } else {
            z = false;
        }
        return z;
    }

    public static boolean c(InputStream inputStream, OutputStream outputStream) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1992562945")) {
            return ((Boolean) ipChange.ipc$dispatch("-1992562945", new Object[]{inputStream, outputStream})).booleanValue();
        }
        if (inputStream == null || outputStream == null) {
            return false;
        }
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.flush();
                return true;
            }
        }
    }

    public static File d(String str) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2035695844")) {
            return (File) ipChange.ipc$dispatch("-2035695844", new Object[]{str});
        }
        File file = new File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
        return file;
    }

    public static boolean e(File file) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1514596623")) {
            return ((Boolean) ipChange.ipc$dispatch("1514596623", new Object[]{file})).booleanValue();
        }
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        for (File file2 : file.listFiles()) {
            z |= e(file2);
        }
        return file.delete() | z;
    }

    public static boolean f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1526013794")) {
            return ((Boolean) ipChange.ipc$dispatch("1526013794", new Object[]{str})).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return e(new File(str));
    }

    public static boolean g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1312586065")) {
            return ((Boolean) ipChange.ipc$dispatch("1312586065", new Object[]{str})).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static byte[] h(File file) {
        FileInputStream fileInputStream;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1282481734")) {
            return (byte[]) ipChange.ipc$dispatch("1282481734", new Object[]{file});
        }
        byte[] bArr = null;
        if (file != null && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    bArr = v(fileInputStream);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                fileInputStream = null;
            }
            b(fileInputStream);
        }
        return bArr;
    }

    public static Bitmap i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1438868334")) {
            return (Bitmap) ipChange.ipc$dispatch("1438868334", new Object[]{str});
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = 2;
        return BitmapFactory.decodeFile(str, options);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
        if (r8 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
        if (r8 == null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
        return null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005d  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String j(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.common.util.C0535a.$ipChange
            java.lang.String r1 = "-513714273"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L20
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r8
            r8 = 1
            r2[r8] = r9
            r8 = 2
            r2[r8] = r10
            r8 = 3
            r2[r8] = r11
            java.lang.Object r8 = r0.ipc$dispatch(r1, r2)
            java.lang.String r8 = (java.lang.String) r8
            return r8
        L20:
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            if (r8 == 0) goto L49
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L59
            if (r9 == 0) goto L49
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L59
            java.lang.String r9 = r8.getString(r9)     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L59
            r8.close()
            return r9
        L47:
            r9 = move-exception
            goto L50
        L49:
            if (r8 == 0) goto L58
            goto L55
        L4c:
            r9 = move-exception
            goto L5b
        L4e:
            r9 = move-exception
            r8 = r7
        L50:
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L59
            if (r8 == 0) goto L58
        L55:
            r8.close()
        L58:
            return r7
        L59:
            r9 = move-exception
            r7 = r8
        L5b:
            if (r7 == 0) goto L60
            r7.close()
        L60:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.common.util.C0535a.j(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static final String k(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1198707976")) {
            return (String) ipChange.ipc$dispatch("1198707976", new Object[]{str});
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf("/");
        return (lastIndexOf <= 0 || lastIndexOf >= str.length() - 1) ? str : str.substring(lastIndexOf + 1, str.length());
    }

    public static String l(Context context, Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-406394080")) {
            return (String) ipChange.ipc$dispatch("-406394080", new Object[]{context, uri});
        }
        Uri uri2 = null;
        if (Build.VERSION.SDK_INT >= 19 && DocumentsContract.isDocumentUri(context, uri)) {
            if (q(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(split[0])) {
                    return context.getExternalCacheDir() + "/" + split[1];
                }
            } else if (o(uri)) {
                return j(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
            } else {
                if (s(uri)) {
                    String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str = split2[0];
                    if ("image".equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return j(context, uri2, "_id=?", new String[]{split2[1]});
                }
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            return j(context, uri, null, null);
        } else {
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    public static String m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2133642143")) {
            return (String) ipChange.ipc$dispatch("-2133642143", new Object[0]);
        }
        if (!p() || mu0.a() == null) {
            return null;
        }
        return mu0.a().getExternalCacheDir().toString();
    }

    public static String n(InputStream inputStream) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1175263221")) {
            return (String) ipChange.ipc$dispatch("1175263221", new Object[]{inputStream});
        }
        if (inputStream == null) {
            return null;
        }
        String str = new String(v(inputStream));
        b(inputStream);
        return str;
    }

    public static boolean o(Uri uri) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1161139900") ? ((Boolean) ipChange.ipc$dispatch("1161139900", new Object[]{uri})).booleanValue() : "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean p() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1727029120") ? ((Boolean) ipChange.ipc$dispatch("-1727029120", new Object[0])).booleanValue() : "mounted".equals(Environment.getExternalStorageState());
    }

    public static boolean q(Uri uri) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2102298495") ? ((Boolean) ipChange.ipc$dispatch("-2102298495", new Object[]{uri})).booleanValue() : "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static final boolean r(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1918664309")) {
            return ((Boolean) ipChange.ipc$dispatch("1918664309", new Object[]{str})).booleanValue();
        }
        if (g(str)) {
            return new File(str).isDirectory();
        }
        return false;
    }

    public static boolean s(Uri uri) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "492047925") ? ((Boolean) ipChange.ipc$dispatch("492047925", new Object[]{uri})).booleanValue() : "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean t(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-342293261")) {
            return ((Boolean) ipChange.ipc$dispatch("-342293261", new Object[]{str, Boolean.valueOf(z)})).booleanValue();
        }
        File file = new File(str);
        if (g(str) && !r(str)) {
            if (!z) {
                return false;
            }
            e(file);
        }
        try {
            file.mkdirs();
        } catch (Exception e) {
            Log.w("StackTrace", e);
        }
        return file.exists();
    }

    public static void u(Bitmap bitmap, String str) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "205307763")) {
            ipChange.ipc$dispatch("205307763", new Object[]{bitmap, str});
            return;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    public static byte[] v(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1388276826")) {
            return (byte[]) ipChange.ipc$dispatch("-1388276826", new Object[]{inputStream});
        }
        byte[] bArr = null;
        if (inputStream == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                c(inputStream, byteArrayOutputStream);
                bArr = byteArrayOutputStream.toByteArray();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            byteArrayOutputStream = null;
        }
        b(byteArrayOutputStream);
        return bArr;
    }
}
