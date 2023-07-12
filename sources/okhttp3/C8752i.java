package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: okhttp3.i */
/* loaded from: classes2.dex */
public final /* synthetic */ class C8752i {
    static {
        Dns dns = Dns.SYSTEM;
    }

    public static /* synthetic */ List a(String str) {
        return b(str);
    }

    public static /* synthetic */ List b(String str) throws UnknownHostException {
        if (str != null) {
            try {
                return Arrays.asList(InetAddress.getAllByName(str));
            } catch (NullPointerException e) {
                UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                unknownHostException.initCause(e);
                throw unknownHostException;
            }
        }
        throw new UnknownHostException("hostname == null");
    }
}
