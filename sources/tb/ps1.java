package tb;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.tls.TrustRootIndex;
import okio.Buffer;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ps1 {
    public static final int INFO = 4;
    public static final int WARN = 5;
    private static final ps1 a = i();
    private static final Logger b = Logger.getLogger(OkHttpClient.class.getName());

    public static List<String> b(List<Protocol> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] e(List<Protocol> list) {
        Buffer buffer = new Buffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                buffer.writeByte(protocol.toString().length());
                buffer.writeUtf8(protocol.toString());
            }
        }
        return buffer.readByteArray();
    }

    private static ps1 i() {
        cn s;
        ps1 u = e5.u();
        if (u != null) {
            return u;
        }
        ps1 u2 = i5.u();
        if (u2 != null) {
            return u2;
        }
        if (!p() || (s = cn.s()) == null) {
            a61 s2 = a61.s();
            if (s2 != null) {
                return s2;
            }
            ps1 s3 = z51.s();
            return s3 != null ? s3 : new ps1();
        }
        return s;
    }

    public static ps1 j() {
        return a;
    }

    public static boolean p() {
        if ("conscrypt".equals(okhttp3.internal.a.r("okhttp.platform", null))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    public void a(SSLSocket sSLSocket) {
    }

    public okhttp3.internal.tls.b c(X509TrustManager x509TrustManager) {
        return new okhttp3.internal.tls.a(d(x509TrustManager));
    }

    public TrustRootIndex d(X509TrustManager x509TrustManager) {
        return new tb(x509TrustManager.getAcceptedIssuers());
    }

    public void f(SSLSocketFactory sSLSocketFactory) {
    }

    public void g(SSLSocket sSLSocket, @Nullable String str, List<Protocol> list) {
    }

    public void h(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public String k() {
        return "OkHttp";
    }

    public SSLContext l() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    @Nullable
    public String m(SSLSocket sSLSocket) {
        return null;
    }

    @Nullable
    public Object n(String str) {
        if (b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean o(String str) {
        return true;
    }

    public void q(int i, String str, @Nullable Throwable th) {
        b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void r(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        q(5, str, (Throwable) obj);
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
