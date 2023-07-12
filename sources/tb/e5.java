package tb;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class e5 extends i5 {
    e5(Class<?> cls) {
        super(cls, null, null, null, null, null);
    }

    @Nullable
    public static ps1 u() {
        try {
            if (i5.v() >= 29) {
                return new e5(Class.forName("com.android.org.conscrypt.SSLParametersImpl"));
            }
            return null;
        } catch (ReflectiveOperationException unused) {
            return null;
        }
    }

    private void w(SSLSocket sSLSocket) {
        if (SSLSockets.isSupportedSocket(sSLSocket)) {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
        }
    }

    @Override // tb.i5, tb.ps1
    @SuppressLint({"NewApi"})
    @IgnoreJRERequirement
    public void g(SSLSocket sSLSocket, String str, List<Protocol> list) {
        w(sSLSocket);
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        sSLParameters.setApplicationProtocols((String[]) ps1.b(list).toArray(new String[0]));
        sSLSocket.setSSLParameters(sSLParameters);
    }

    @Override // tb.i5, tb.ps1
    @Nullable
    @IgnoreJRERequirement
    public String m(SSLSocket sSLSocket) {
        String applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null || applicationProtocol.isEmpty()) {
            return null;
        }
        return applicationProtocol;
    }
}
