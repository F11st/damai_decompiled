package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import tb.w31;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class b {
    private final List<okhttp3.g> a;
    private int b = 0;
    private boolean c;
    private boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(List<okhttp3.g> list) {
        this.a = list;
    }

    private boolean c(SSLSocket sSLSocket) {
        for (int i = this.b; i < this.a.size(); i++) {
            if (this.a.get(i).c(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public okhttp3.g a(SSLSocket sSLSocket) throws IOException {
        okhttp3.g gVar;
        int i = this.b;
        int size = this.a.size();
        while (true) {
            if (i >= size) {
                gVar = null;
                break;
            }
            gVar = this.a.get(i);
            if (gVar.c(sSLSocket)) {
                this.b = i + 1;
                break;
            }
            i++;
        }
        if (gVar != null) {
            this.c = c(sSLSocket);
            w31.a.c(gVar, sSLSocket, this.d);
            return gVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.d + ", modes=" + this.a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(IOException iOException) {
        this.d = true;
        if (!this.c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return iOException instanceof SSLException;
    }
}
