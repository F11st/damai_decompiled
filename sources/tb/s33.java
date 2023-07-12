package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.efs.sdk.base.http.IHttpUtil;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Map;
import org.apache.commons.net.SocketClient;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class s33 implements IHttpUtil {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class a {
        private static final s33 a = new s33((byte) 0);
    }

    private s33() {
    }

    /* synthetic */ s33(byte b) {
        this();
    }

    private static HttpURLConnection a(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        if (map == null) {
            map = Collections.emptyMap();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        return httpURLConnection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r13v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @NonNull
    private static l01 b(@NonNull String str, @Nullable Map<String, String> map, @Nullable File file, @Nullable byte[] bArr) {
        FileInputStream fileInputStream;
        OutputStream outputStream;
        DataOutputStream dataOutputStream;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3;
        String str2;
        FileInputStream fileInputStream4;
        l01 l01Var = new l01();
        HttpURLConnection httpURLConnection = null;
        r4 = null;
        r4 = null;
        r4 = null;
        ?? r4 = null;
        httpURLConnection = null;
        httpURLConnection = null;
        httpURLConnection = null;
        try {
            try {
                HttpURLConnection a2 = a(str, map);
                try {
                    a2.setRequestMethod("POST");
                    a2.setRequestProperty(IRequestConst.CONNECTION, "close");
                    a2.setRequestProperty("Content-Type", "multipart/form-data;boundary=----WebKitFormBoundaryP0Rfzlf32iRoMhmb");
                    outputStream = a2.getOutputStream();
                    try {
                        dataOutputStream = new DataOutputStream(outputStream);
                        try {
                            dataOutputStream.writeBytes("------WebKitFormBoundaryP0Rfzlf32iRoMhmb\r\n");
                            if (bArr == 0) {
                                if (file != null && file.exists()) {
                                    dataOutputStream.writeBytes("Content-Disposition: form-data;name=\"file\";filename=\"" + file.getName() + "\"\r\n");
                                    dataOutputStream.writeBytes(SocketClient.NETASCII_EOL);
                                    fileInputStream4 = new FileInputStream(file);
                                    try {
                                        byte[] bArr2 = new byte[4096];
                                        while (true) {
                                            int read = fileInputStream4.read(bArr2);
                                            if (read == -1) {
                                                break;
                                            }
                                            dataOutputStream.write(bArr2, 0, read);
                                        }
                                        r4 = fileInputStream4;
                                    } catch (SocketTimeoutException e) {
                                        e = e;
                                        httpURLConnection = a2;
                                        fileInputStream3 = fileInputStream4;
                                        l01Var.e(-3);
                                        str2 = "post file '" + str + "' error";
                                        bArr = fileInputStream3;
                                        w63.c("efs.util.http", str2, e);
                                        l01Var.f(str);
                                        return l01Var;
                                    } catch (UnknownHostException e2) {
                                        e = e2;
                                        httpURLConnection = a2;
                                        fileInputStream2 = fileInputStream4;
                                        l01Var.e(-2);
                                        str2 = "post file '" + str + "' error， maybe network is disconnect";
                                        bArr = fileInputStream2;
                                        w63.c("efs.util.http", str2, e);
                                        l01Var.f(str);
                                        return l01Var;
                                    } catch (Throwable th) {
                                        e = th;
                                        httpURLConnection = a2;
                                        fileInputStream = fileInputStream4;
                                        str2 = "post file '" + str + "' error";
                                        bArr = fileInputStream;
                                        w63.c("efs.util.http", str2, e);
                                        l01Var.f(str);
                                        return l01Var;
                                    }
                                }
                                e(a2);
                                z43.c(outputStream);
                                z43.c(dataOutputStream);
                                z43.c(null);
                                return l01Var;
                            }
                            dataOutputStream.writeBytes("Content-Disposition: form-data;name=\"file\";filename=\"f\"\r\n");
                            dataOutputStream.writeBytes(SocketClient.NETASCII_EOL);
                            dataOutputStream.write(bArr, 0, bArr.length);
                            dataOutputStream.writeBytes(SocketClient.NETASCII_EOL);
                            dataOutputStream.writeBytes("------WebKitFormBoundaryP0Rfzlf32iRoMhmb--\r\n");
                            l01Var = c(a2);
                            e(a2);
                            z43.c(outputStream);
                            z43.c(dataOutputStream);
                            z43.c(r4);
                        } catch (SocketTimeoutException e3) {
                            e = e3;
                            fileInputStream4 = r4;
                        } catch (UnknownHostException e4) {
                            e = e4;
                            fileInputStream4 = r4;
                        } catch (Throwable th2) {
                            e = th2;
                            fileInputStream4 = r4;
                        }
                    } catch (SocketTimeoutException e5) {
                        e = e5;
                        fileInputStream4 = null;
                        dataOutputStream = null;
                    } catch (UnknownHostException e6) {
                        e = e6;
                        fileInputStream4 = null;
                        dataOutputStream = null;
                    } catch (Throwable th3) {
                        e = th3;
                        fileInputStream4 = null;
                        dataOutputStream = null;
                    }
                } catch (SocketTimeoutException e7) {
                    e = e7;
                    fileInputStream4 = null;
                    outputStream = null;
                    dataOutputStream = null;
                } catch (UnknownHostException e8) {
                    e = e8;
                    fileInputStream4 = null;
                    outputStream = null;
                    dataOutputStream = null;
                } catch (Throwable th4) {
                    e = th4;
                    fileInputStream4 = null;
                    outputStream = null;
                    dataOutputStream = null;
                }
            } catch (SocketTimeoutException e9) {
                e = e9;
                fileInputStream3 = null;
                outputStream = null;
                dataOutputStream = null;
            } catch (UnknownHostException e10) {
                e = e10;
                fileInputStream2 = null;
                outputStream = null;
                dataOutputStream = null;
            } catch (Throwable th5) {
                e = th5;
                fileInputStream = null;
                outputStream = null;
                dataOutputStream = null;
            }
            l01Var.f(str);
            return l01Var;
        } finally {
            e(httpURLConnection);
            z43.c(outputStream);
            z43.c(dataOutputStream);
            z43.c(bArr);
        }
    }

    private static l01 c(HttpURLConnection httpURLConnection) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        InputStream inputStream;
        l01 l01Var = new l01();
        if (httpURLConnection == null) {
            return l01Var;
        }
        try {
            l01Var.e(httpURLConnection.getResponseCode());
            inputStream = httpURLConnection.getInputStream();
            try {
                byte[] bArr = new byte[1024];
                byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            w63.c("efs.util.http", "get response error", th);
                            return l01Var;
                        } finally {
                            z43.c(inputStream);
                            z43.c(byteArrayOutputStream);
                        }
                    }
                }
                l01Var.c = byteArrayOutputStream.toString();
            } catch (Throwable th3) {
                byteArrayOutputStream = null;
                th = th3;
            }
        } catch (Throwable th4) {
            byteArrayOutputStream = null;
            th = th4;
            inputStream = null;
        }
        return l01Var;
    }

    public static s33 d() {
        return a.a;
    }

    private static void e(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            try {
                z43.c(httpURLConnection.getInputStream());
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.efs.sdk.base.http.IHttpUtil
    @NonNull
    public final l01 get(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        String str2;
        l01 l01Var = new l01();
        while (true) {
            if (0 >= 3) {
                break;
            }
            httpURLConnection = null;
            try {
                try {
                    httpURLConnection = a(str, map);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setRequestProperty(IRequestConst.CONNECTION, "close");
                    httpURLConnection.connect();
                    l01Var = c(httpURLConnection);
                    e(httpURLConnection);
                    break;
                } catch (SocketTimeoutException e) {
                    e = e;
                    try {
                        l01Var.e(-3);
                        str2 = "post file '" + str + "' error";
                        w63.c("efs.util.http", str2, e);
                        e(httpURLConnection);
                    }
                }
            } catch (UnknownHostException e2) {
                e = e2;
                l01Var.e(-2);
                str2 = "get request '" + str + "' error， maybe network is disconnect";
                w63.c("efs.util.http", str2, e);
                e(httpURLConnection);
            }
            e(httpURLConnection);
        }
        l01Var.f(str);
        return l01Var;
    }

    @Override // com.efs.sdk.base.http.IHttpUtil
    @NonNull
    public final l01 post(@NonNull String str, @Nullable Map<String, String> map, @NonNull File file) {
        return b(str, map, file, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.Map] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v7 */
    @Override // com.efs.sdk.base.http.IHttpUtil
    @NonNull
    public final l01 post(@NonNull String str, @Nullable Map<String, String> map, @NonNull byte[] bArr) {
        HttpURLConnection httpURLConnection;
        String str2;
        HttpURLConnection httpURLConnection2;
        l01 l01Var = new l01();
        OutputStream outputStream = null;
        try {
            try {
                httpURLConnection = a(str, map);
            } catch (SocketTimeoutException e) {
                e = e;
                httpURLConnection = null;
            } catch (UnknownHostException e2) {
                e = e2;
                httpURLConnection = null;
            } catch (Throwable th) {
                e = th;
                httpURLConnection = null;
            }
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty(IRequestConst.CONNECTION, "close");
                outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                l01Var = c(httpURLConnection);
                httpURLConnection2 = httpURLConnection;
            } catch (SocketTimeoutException e3) {
                e = e3;
                l01Var.e(-3);
                str2 = "post file '" + str + "' error";
                map = httpURLConnection;
                w63.c("efs.util.http", str2, e);
                httpURLConnection2 = map;
                l01Var.f(str);
                return l01Var;
            } catch (UnknownHostException e4) {
                e = e4;
                l01Var.e(-2);
                str2 = "post data to '" + str + "' error， maybe network is disconnect";
                map = httpURLConnection;
                w63.c("efs.util.http", str2, e);
                httpURLConnection2 = map;
                l01Var.f(str);
                return l01Var;
            } catch (Throwable th2) {
                e = th2;
                str2 = "post data '" + str + "' error";
                map = httpURLConnection;
                w63.c("efs.util.http", str2, e);
                httpURLConnection2 = map;
                l01Var.f(str);
                return l01Var;
            }
            l01Var.f(str);
            return l01Var;
        } finally {
            z43.c(outputStream);
            e(map);
        }
    }

    @Override // com.efs.sdk.base.http.IHttpUtil
    @NonNull
    public final l01 postAsFile(String str, Map<String, String> map, byte[] bArr) {
        return b(str, map, null, bArr);
    }
}
