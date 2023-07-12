package tb;

import com.taobao.monitor.network.INetworkSender;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class vj1 implements INetworkSender {
    private static volatile vj1 b;
    private final List<INetworkSender> a = new ArrayList();

    private vj1() {
    }

    public static vj1 b() {
        if (b == null) {
            synchronized (vj1.class) {
                if (b == null) {
                    b = new vj1();
                }
            }
        }
        return b;
    }

    public vj1 a(INetworkSender iNetworkSender) {
        if (iNetworkSender != null) {
            this.a.add(iNetworkSender);
        }
        return this;
    }

    @Override // com.taobao.monitor.network.INetworkSender
    public void send(String str, String str2) {
        for (INetworkSender iNetworkSender : this.a) {
            if (iNetworkSender != null) {
                iNetworkSender.send(str, str2);
            }
        }
    }
}
