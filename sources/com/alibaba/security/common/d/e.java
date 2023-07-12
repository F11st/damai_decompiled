package com.alibaba.security.common.d;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class e {
    private static final String a = "FileUtils";
    private static final String b = "/realidentity";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r9, java.lang.String r10, boolean r11) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r10)
            r1 = 0
            if (r11 == 0) goto L33
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L7d
            r11.<init>()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L7d
            android.content.res.AssetManager r9 = r9.getAssets()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L7d
            java.io.InputStream r9 = r9.open(r10)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L7d
            java.io.BufferedReader r10 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            r0.<init>(r9)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            r10.<init>(r0)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
        L1f:
            java.lang.String r0 = r10.readLine()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            if (r0 == 0) goto L29
            r11.append(r0)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            goto L1f
        L29:
            java.lang.String r10 = r11.toString()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            goto L59
        L2e:
            r10 = move-exception
            goto L70
        L30:
            r10 = r9
            r9 = r1
            goto L7f
        L33:
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L7d
            r9.<init>(r0)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L7d
            java.nio.channels.FileChannel r2 = r9.getChannel()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6c
            java.nio.channels.FileChannel$MapMode r3 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6c
            r4 = 0
            long r6 = r2.size()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6c
            java.nio.MappedByteBuffer r10 = r2.map(r3, r4, r6)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6c
            java.lang.String r11 = "utf-8"
            java.nio.charset.Charset r11 = java.nio.charset.Charset.forName(r11)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6c
            java.nio.CharBuffer r10 = r11.decode(r10)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6c
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6c
            r8 = r1
            r1 = r9
            r9 = r8
        L59:
            if (r1 == 0) goto L60
            r1.close()     // Catch: java.io.IOException -> L5f
            goto L60
        L5f:
        L60:
            if (r9 == 0) goto L65
            r9.close()     // Catch: java.io.IOException -> L65
        L65:
            r1 = r10
            goto L8b
        L67:
            r10 = move-exception
            r8 = r1
            r1 = r9
            r9 = r8
            goto L70
        L6c:
            r10 = r1
            goto L7f
        L6e:
            r10 = move-exception
            r9 = r1
        L70:
            if (r1 == 0) goto L77
            r1.close()     // Catch: java.io.IOException -> L76
            goto L77
        L76:
        L77:
            if (r9 == 0) goto L7c
            r9.close()     // Catch: java.io.IOException -> L7c
        L7c:
            throw r10
        L7d:
            r9 = r1
            r10 = r9
        L7f:
            if (r9 == 0) goto L86
            r9.close()     // Catch: java.io.IOException -> L85
            goto L86
        L85:
        L86:
            if (r10 == 0) goto L8b
            r10.close()     // Catch: java.io.IOException -> L8b
        L8b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.d.e.a(android.content.Context, java.lang.String, boolean):java.lang.String");
    }

    private static String b(Context context) {
        return context.getFilesDir().getAbsolutePath() + b;
    }

    @SuppressLint({"NewApi"})
    private static String c(Context context, Uri uri) {
        if (DocumentsContract.isDocumentUri(context, uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                return a(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{documentId.split(":")[1]});
            }
            if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                return a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
            }
            return null;
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            return a(context, uri, null, null);
        } else {
            if ("file".equals(uri.getScheme())) {
                return uri.getPath();
            }
            return null;
        }
    }

    private static boolean d(String str) throws Exception {
        return new File(str).createNewFile();
    }

    private static String b(Context context, Uri uri) {
        return a(context, uri, null, null);
    }

    private static boolean d(File file) {
        if (file != null) {
            if (file.exists()) {
                return file.isFile() && file.delete();
            }
            return true;
        }
        return false;
    }

    private static boolean b(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    private static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            return c(file);
        }
        if (file.exists()) {
            return file.isFile() && file.delete();
        }
        return true;
    }

    private static boolean b(Context context, String str, String str2) {
        byte[] a2 = a(context, str);
        if (a2 == null) {
            return false;
        }
        return a(str2, a2);
    }

    private static boolean c(String str) {
        return new File(str).exists();
    }

    private static boolean c(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        if (file2.isFile()) {
                            if (!file2.delete()) {
                                return false;
                            }
                        } else if (file2.isDirectory() && !c(file2)) {
                            return false;
                        }
                    }
                }
                return file.delete();
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0048 -> B:54:0x007a). Please submit an issue!!! */
    public static boolean a(String str, byte[] bArr, String str2) {
        FileOutputStream fileOutputStream;
        ByteArrayInputStream byteArrayInputStream = null;
        boolean z = false;
        try {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, str2);
                if (file2.exists()) {
                    file2.delete();
                }
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
                try {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int read = byteArrayInputStream2.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr2, 0, read);
                    }
                    fileOutputStream.flush();
                    z = true;
                    try {
                        byteArrayInputStream2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayInputStream = byteArrayInputStream2;
                    try {
                        com.alibaba.security.common.c.a.c(a, "saveBytes2File got error " + th.getMessage());
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return z;
                    } catch (Throwable th3) {
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
        return z;
    }

    private static String a(Context context, String str, String str2) {
        StringBuilder sb;
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            sb = new StringBuilder();
            sb.append(externalCacheDir.getAbsolutePath());
            sb.append(File.separator);
        } else {
            File a2 = a(context);
            if (a2 != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(a2.getAbsolutePath());
                sb2.append(File.separator);
                sb = sb2;
            } else {
                sb = null;
            }
        }
        if (!TextUtils.isEmpty(str) && sb != null) {
            sb.append(str);
            sb.append(File.separator);
            sb.append(str2);
        }
        return sb.toString();
    }

    public static File a(Context context) {
        if (Build.VERSION.SDK_INT >= 8) {
            try {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir != null) {
                    if (!externalCacheDir.exists()) {
                        externalCacheDir.mkdirs();
                    }
                    return externalCacheDir;
                }
            } catch (Exception unused) {
            }
        }
        File file = new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + l.a(context) + "/cache/"));
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception unused2) {
        }
        return file;
    }

    public static long a(String str) {
        try {
            return a(new File(str));
        } catch (Exception e) {
            com.alibaba.security.common.c.a.d(a, e.getLocalizedMessage());
            return 0L;
        }
    }

    private static long a(File file) {
        if (file.exists()) {
            FileInputStream fileInputStream = null;
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        long available = fileInputStream2.available();
                        try {
                            fileInputStream2.close();
                            return available;
                        } catch (IOException unused) {
                            com.alibaba.security.common.c.a.b();
                            return available;
                        }
                    } catch (Exception e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        com.alibaba.security.common.c.a.d(a, e.getLocalizedMessage());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused2) {
                                com.alibaba.security.common.c.a.b();
                            }
                        }
                        return 0L;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused3) {
                                com.alibaba.security.common.c.a.b();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        return 0L;
    }

    private static String a(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT >= 19) {
            if (DocumentsContract.isDocumentUri(context, uri)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                    return a(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{documentId.split(":")[1]});
                }
                if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                    return a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
                }
                return null;
            } else if ("content".equalsIgnoreCase(uri.getScheme())) {
                return a(context, uri, null, null);
            } else {
                if ("file".equals(uri.getScheme())) {
                    return uri.getPath();
                }
                return null;
            }
        }
        return a(context, uri, null, null);
    }

    public static String a(Context context, Uri uri, String str, String[] strArr) {
        String[] strArr2 = {"_data"};
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(uri, strArr2, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        return query.getString(query.getColumnIndexOrThrow(strArr2[0]));
                    }
                    return null;
                } catch (Exception unused) {
                    if (0 != 0) {
                        cursor.close();
                        return null;
                    }
                    return null;
                }
            }
            return null;
        } catch (Exception unused2) {
        }
    }

    private static boolean a(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static synchronized boolean a(String str, byte[] bArr) {
        boolean a2;
        synchronized (e.class) {
            a2 = a(new File(str), bArr);
        }
        return a2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0041, code lost:
        if (r3 == null) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized boolean a(java.io.File r4, byte[] r5) {
        /*
            java.lang.Class<com.alibaba.security.common.d.e> r0 = com.alibaba.security.common.d.e.class
            monitor-enter(r0)
            r1 = 0
            if (r5 == 0) goto L47
            r4.mkdirs()     // Catch: java.lang.Throwable -> L44
            boolean r2 = r4.exists()     // Catch: java.lang.Throwable -> L44
            if (r2 == 0) goto L13
            r4.delete()     // Catch: java.lang.Throwable -> L44
            goto L1e
        L13:
            r4.createNewFile()     // Catch: java.lang.Throwable -> L17
            goto L1e
        L17:
            r2 = move-exception
            com.alibaba.security.common.c.a.b()     // Catch: java.lang.Throwable -> L44
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L44
        L1e:
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L39
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L39
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L3a
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L3a
            r4.write(r5)     // Catch: java.lang.Throwable -> L37
            r4.flush()     // Catch: java.lang.Throwable -> L37
            r1 = 1
            r4.close()     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L44
        L33:
            r3.close()     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L47
            goto L47
        L37:
            r2 = r4
            goto L3a
        L39:
            r3 = r2
        L3a:
            if (r2 == 0) goto L41
            r2.close()     // Catch: java.io.IOException -> L40 java.lang.Throwable -> L44
            goto L41
        L40:
        L41:
            if (r3 == 0) goto L47
            goto L33
        L44:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        L47:
            monitor-exit(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.d.e.a(java.io.File, byte[]):boolean");
    }

    public static byte[] a(Context context, String str) {
        InputStream inputStream;
        try {
            inputStream = context.getAssets().open(str);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr, 0, 100);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                return byteArray;
            } catch (Throwable unused2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return null;
                    } catch (IOException unused3) {
                        return null;
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            inputStream = null;
        }
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 100);
            if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    public static boolean a(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        FileInputStream fileInputStream = null;
        try {
            if (file.exists()) {
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    fileOutputStream2 = new FileOutputStream(file2);
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        }
                        fileOutputStream2.flush();
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused) {
                        }
                        try {
                            fileOutputStream2.close();
                            return true;
                        } catch (IOException unused2) {
                            return true;
                        }
                    } catch (Exception unused3) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused5) {
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        fileInputStream = fileInputStream2;
                        fileOutputStream = fileOutputStream2;
                        th = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused6) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused7) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused8) {
                    fileOutputStream2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    fileInputStream = fileInputStream2;
                }
            }
        } catch (Exception unused9) {
            fileOutputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
        return false;
    }

    private static void a(Context context, String str, File file) throws IOException {
        InputStream open = context.getAssets().open(str);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = open.read(bArr);
            if (read != -1) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.flush();
                open.close();
                fileOutputStream.close();
                file.setReadable(true);
                return;
            }
        }
    }
}
