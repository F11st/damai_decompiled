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
import okhttp3.C8749g;
import tb.w31;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: okhttp3.internal.connection.b */
/* loaded from: classes2.dex */
public final class C8765b {
    private final List<C8749g> a;
    private int b = 0;
    private boolean c;
    private boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C8765b(List<C8749g> list) {
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
    public C8749g a(SSLSocket sSLSocket) throws IOException {
        C8749g c8749g;
        int i = this.b;
        int size = this.a.size();
        while (true) {
            if (i >= size) {
                c8749g = null;
                break;
            }
            c8749g = this.a.get(i);
            if (c8749g.c(sSLSocket)) {
                this.b = i + 1;
                break;
            }
            i++;
        }
        if (c8749g != null) {
            this.c = c(sSLSocket);
            w31.a.c(c8749g, sSLSocket, this.d);
            return c8749g;
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
