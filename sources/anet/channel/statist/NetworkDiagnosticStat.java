package anet.channel.statist;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.Inet64Util;

/* compiled from: Taobao */
@Monitor(module = "networkPrefer", monitorPoint = "networkDiagnostic")
/* loaded from: classes.dex */
public class NetworkDiagnosticStat extends StatObject {
    public static final int DIAGNOSTIC_TYPE_AUTO = 2;
    public static final int DIAGNOSTIC_TYPE_USER = 1;
    @Dimension
    public int type;
    @Dimension
    public int code = 1;
    @Dimension
    public String netType = NetworkStatusHelper.i().toString();
    @Dimension
    public boolean isProxy = NetworkStatusHelper.o();
    @Dimension
    public int ipStackType = Inet64Util.n();

    public NetworkDiagnosticStat(int i) {
        this.type = i;
    }
}
