package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import tb.ps1;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.tls.b */
/* loaded from: classes2.dex */
public abstract class AbstractC8805b {
    public static AbstractC8805b b(X509TrustManager x509TrustManager) {
        return ps1.j().c(x509TrustManager);
    }

    public abstract List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException;
}
