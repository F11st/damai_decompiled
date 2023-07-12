package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface Dns {
    public static final Dns SYSTEM = new Dns() { // from class: tb.ob0
        @Override // okhttp3.Dns
        public final List lookup(String str) {
            return okhttp3.i.a(str);
        }
    };

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
