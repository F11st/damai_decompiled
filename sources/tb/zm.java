package tb;

import anet.channel.entity.ConnType;
import anet.channel.strategy.IConnStrategy;
import com.taobao.accs.net.SmartHeartbeatImpl;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class zm {
    public final IConnStrategy a;
    private String b;
    private String c;
    public int d = 0;
    public int e = 0;

    public zm(String str, String str2, IConnStrategy iConnStrategy) {
        this.a = iConnStrategy;
        this.b = str;
        this.c = str2;
    }

    public ConnType a() {
        IConnStrategy iConnStrategy = this.a;
        if (iConnStrategy != null) {
            return ConnType.l(iConnStrategy.getProtocol());
        }
        return ConnType.d;
    }

    public int b() {
        IConnStrategy iConnStrategy = this.a;
        if (iConnStrategy == null || iConnStrategy.getConnectionTimeout() == 0) {
            return 20000;
        }
        return this.a.getConnectionTimeout();
    }

    public int c() {
        IConnStrategy iConnStrategy = this.a;
        return iConnStrategy != null ? iConnStrategy.getHeartbeat() : SmartHeartbeatImpl.FOREGROUND_INTERVAL;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        IConnStrategy iConnStrategy = this.a;
        if (iConnStrategy != null) {
            return iConnStrategy.getIp();
        }
        return null;
    }

    public int f() {
        IConnStrategy iConnStrategy = this.a;
        if (iConnStrategy != null) {
            return iConnStrategy.getPort();
        }
        return 0;
    }

    public int g() {
        IConnStrategy iConnStrategy = this.a;
        if (iConnStrategy == null || iConnStrategy.getReadTimeout() == 0) {
            return 20000;
        }
        return this.a.getReadTimeout();
    }

    public String h() {
        return this.c;
    }

    public String toString() {
        return "ConnInfo [ip=" + e() + ",port=" + f() + ",type=" + a() + ",hb" + c() + jn1.ARRAY_END_STR;
    }
}
