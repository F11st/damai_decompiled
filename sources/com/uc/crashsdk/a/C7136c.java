package com.uc.crashsdk.a;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import mtopsdk.network.util.Constants;
import org.apache.commons.net.SocketClient;

/* compiled from: Taobao */
/* renamed from: com.uc.crashsdk.a.c */
/* loaded from: classes11.dex */
public class C7136c {
    static final /* synthetic */ boolean a = true;
    private static String b = "";

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, true, false);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, true, true);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        return a(bArr, bArr2, z, true);
    }

    private static boolean b(File file, String str, String str2) {
        try {
            byte[] a2 = a(file);
            if (a2 != null && a2.length != 0) {
                return a(a2, str, str2);
            }
            return false;
        } catch (Exception e) {
            C7140g.a(e);
            return false;
        }
    }

    private static byte[] a(byte[] bArr, byte[] bArr2, boolean z, boolean z2) {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(z ? 1 : 2, secretKeySpec, ivParameterSpec);
        if (z) {
            if (!z2) {
                bArr = a(bArr);
            }
            return cipher.doFinal(bArr);
        }
        return cipher.doFinal(bArr);
    }

    private static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 16];
        int length = bArr.length;
        bArr2[0] = (byte) ((length >> 0) & 255);
        bArr2[1] = (byte) ((length >> 8) & 255);
        bArr2[2] = (byte) ((length >> 16) & 255);
        bArr2[3] = (byte) ((length >> 24) & 255);
        for (int i = 4; i < 16; i++) {
            bArr2[i] = 0;
        }
        System.arraycopy(bArr, 0, bArr2, 16, bArr.length);
        return bArr2;
    }

    public static byte[] a() {
        return new byte[]{48, 25, 6, 55};
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.ByteArrayOutputStream, java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(java.lang.String r7, byte[] r8) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L85
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L85
            java.net.URLConnection r7 = r1.openConnection()     // Catch: java.lang.Throwable -> L85
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch: java.lang.Throwable -> L85
            r1 = 5000(0x1388, float:7.006E-42)
            r7.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> L83
            r7.setReadTimeout(r1)     // Catch: java.lang.Throwable -> L83
            r1 = 1
            r7.setDoInput(r1)     // Catch: java.lang.Throwable -> L83
            r7.setDoOutput(r1)     // Catch: java.lang.Throwable -> L83
            java.lang.String r1 = "POST"
            r7.setRequestMethod(r1)     // Catch: java.lang.Throwable -> L83
            r1 = 0
            r7.setUseCaches(r1)     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = "Content-Type"
            java.lang.String r3 = "application/x-www-form-urlencoded"
            r7.setRequestProperty(r2, r3)     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = "Content-Length"
            int r3 = r8.length     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L83
            r7.setRequestProperty(r2, r3)     // Catch: java.lang.Throwable -> L83
            java.io.OutputStream r2 = r7.getOutputStream()     // Catch: java.lang.Throwable -> L83
            r2.write(r8)     // Catch: java.lang.Throwable -> L80
            int r8 = r7.getResponseCode()     // Catch: java.lang.Throwable -> L80
            r3 = 200(0xc8, float:2.8E-43)
            if (r8 == r3) goto L51
            com.uc.crashsdk.a.C7140g.a(r2)
            com.uc.crashsdk.a.C7140g.a(r0)
            com.uc.crashsdk.a.C7140g.a(r0)
            r7.disconnect()     // Catch: java.lang.Throwable -> L50
        L50:
            return r0
        L51:
            java.io.InputStream r8 = r7.getInputStream()     // Catch: java.lang.Throwable -> L80
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L7e
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L7e
            int r5 = r8.available()     // Catch: java.lang.Throwable -> L7e
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L7e
        L62:
            int r5 = r8.read(r3)     // Catch: java.lang.Throwable -> L89
            r6 = -1
            if (r5 == r6) goto L6d
            r4.write(r3, r1, r5)     // Catch: java.lang.Throwable -> L89
            goto L62
        L6d:
            byte[] r0 = r4.toByteArray()     // Catch: java.lang.Throwable -> L89
            com.uc.crashsdk.a.C7140g.a(r2)
            com.uc.crashsdk.a.C7140g.a(r8)
            com.uc.crashsdk.a.C7140g.a(r4)
            r7.disconnect()     // Catch: java.lang.Throwable -> L7d
        L7d:
            return r0
        L7e:
            r4 = r0
            goto L89
        L80:
            r8 = r0
            r4 = r8
            goto L89
        L83:
            r8 = r0
            goto L87
        L85:
            r7 = r0
            r8 = r7
        L87:
            r2 = r8
            r4 = r2
        L89:
            com.uc.crashsdk.a.C7140g.a(r2)
            com.uc.crashsdk.a.C7140g.a(r8)
            com.uc.crashsdk.a.C7140g.a(r4)
            if (r7 == 0) goto L97
            r7.disconnect()     // Catch: java.lang.Throwable -> L97
        L97:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.C7136c.a(java.lang.String, byte[]):byte[]");
    }

    public static void a(byte[] bArr, int i, byte[] bArr2) {
        if (!a && bArr2.length != 4) {
            throw new AssertionError();
        }
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2 + i] = bArr2[i2];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v9 */
    private static byte[] a(File file) {
        FileInputStream fileInputStream;
        byte[] bArr;
        BufferedInputStream bufferedInputStream = 0;
        byte[] bArr2 = null;
        r1 = null;
        BufferedInputStream bufferedInputStream2 = null;
        bufferedInputStream = 0;
        try {
            if (!file.isFile()) {
                return null;
            }
            try {
                int length = (int) file.length();
                fileInputStream = new FileInputStream(file);
                try {
                    BufferedInputStream bufferedInputStream3 = new BufferedInputStream(fileInputStream);
                    try {
                        bArr2 = new byte[length];
                        int i = 0;
                        while (i < length) {
                            int read = bufferedInputStream3.read(bArr2, i, length - i);
                            if (-1 == read) {
                                break;
                            }
                            i += read;
                        }
                        C7140g.a(bufferedInputStream3);
                        C7140g.a(fileInputStream);
                        return bArr2;
                    } catch (Exception e) {
                        e = e;
                        byte[] bArr3 = bArr2;
                        bufferedInputStream2 = bufferedInputStream3;
                        bArr = bArr3;
                        C7140g.b(e);
                        C7140g.a(bufferedInputStream2);
                        C7140g.a(fileInputStream);
                        bufferedInputStream = bArr;
                        return bufferedInputStream;
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream3;
                        C7140g.a((Closeable) bufferedInputStream);
                        C7140g.a(fileInputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    bArr = null;
                }
            } catch (Exception e3) {
                e = e3;
                bArr = null;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static boolean a(File file, String str, String str2) {
        for (int i = 0; i < 2; i++) {
            if (b(file, str, str2)) {
                return true;
            }
            C7134a.a("crashsdk", "upload try again: " + str);
        }
        return false;
    }

    private static boolean a(byte[] bArr, String str, String str2) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] byteArray;
        C7134a.a("Uploading to " + str2);
        OutputStream outputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            try {
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                StringBuilder sb = new StringBuilder();
                sb.append("------------izQ290kHh6g3Yn2IeyJCoc\r\n");
                sb.append("Content-Disposition: form-data; name=\"file\";");
                sb.append(" filename=\"");
                sb.append(str);
                sb.append("\"\r\n");
                sb.append("Content-Type: application/octet-stream\r\n");
                sb.append(SocketClient.NETASCII_EOL);
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=----------izQ290kHh6g3Yn2IeyJCoc");
                httpURLConnection.setRequestProperty("Content-Disposition", "form-data; name=\"file\"; filename=" + str);
                httpURLConnection.setRequestProperty(Constants.Protocol.CONTENT_LENGTH, String.valueOf(sb.length() + 40 + bArr.length));
                OutputStream outputStream2 = httpURLConnection.getOutputStream();
                try {
                    outputStream2.write(sb.toString().getBytes());
                    outputStream2.write(bArr);
                    outputStream2.write("\r\n------------izQ290kHh6g3Yn2IeyJCoc--\r\n".getBytes());
                    int responseCode = httpURLConnection.getResponseCode();
                    C7134a.a("crashsdk", "Response code: " + responseCode);
                    if (responseCode != 200) {
                        C7140g.a(outputStream2);
                        C7140g.a((Closeable) null);
                        C7140g.a((Closeable) null);
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused) {
                        }
                        return false;
                    }
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byte[] bArr2 = new byte[1024];
                        byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
                        while (true) {
                            try {
                                int read = inputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            } catch (Throwable th) {
                                th = th;
                                outputStream = outputStream2;
                                try {
                                    C7140g.b(th);
                                    if (httpURLConnection != null) {
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    return false;
                                } finally {
                                    C7140g.a(outputStream);
                                    C7140g.a(inputStream);
                                    C7140g.a(byteArrayOutputStream);
                                    if (httpURLConnection != null) {
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (Throwable unused3) {
                                        }
                                    }
                                }
                            }
                        }
                        if (byteArrayOutputStream.toByteArray() != null) {
                            C7134a.a("crashsdk", "Log upload response: " + new String(byteArray));
                            C7140g.a(outputStream2);
                            C7140g.a(inputStream);
                            C7140g.a(byteArrayOutputStream);
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable unused4) {
                            }
                            return true;
                        }
                        C7140g.a(outputStream2);
                        C7140g.a(inputStream);
                        C7140g.a(byteArrayOutputStream);
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused5) {
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    byteArrayOutputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            httpURLConnection = null;
            byteArrayOutputStream = null;
        }
    }
}
