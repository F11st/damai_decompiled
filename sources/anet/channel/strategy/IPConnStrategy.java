package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.strategy.b;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class IPConnStrategy implements IConnStrategy, Serializable {
    public static final int SOURCE_AMDC = 0;
    public static final int SOURCE_CUSTOMIZED = 2;
    public static final int SOURCE_LOCAL_DNS = 1;
    public static final int TYPE_IP_TO_HOST = -1;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_STATIC_BANDWITDH = 0;
    private static final long serialVersionUID = -2492035520806142510L;
    public volatile int cto;
    public volatile int heartbeat;
    public final String ip;
    transient boolean isToRemove;
    public final int port;
    public final ConnProtocol protocol;
    public volatile int retry;
    public volatile int rto;
    public volatile int status = -1;
    volatile int ipType = 1;
    volatile int ipSource = 1;

    private IPConnStrategy(String str, int i, ConnProtocol connProtocol, int i2, int i3, int i4, int i5) {
        this.ip = str;
        this.port = i;
        this.protocol = connProtocol;
        this.cto = i2;
        this.rto = i3;
        this.retry = i4;
        this.heartbeat = i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IPConnStrategy create(String str, b.a aVar) {
        ConnProtocol valueOf = ConnProtocol.valueOf(aVar);
        if (valueOf == null) {
            return null;
        }
        return create(str, aVar.a, valueOf, aVar.c, aVar.d, aVar.e, aVar.f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IPConnStrategy)) {
            return false;
        }
        IPConnStrategy iPConnStrategy = (IPConnStrategy) obj;
        return this.port == iPConnStrategy.port && this.ip.equals(iPConnStrategy.ip) && this.protocol.equals(iPConnStrategy.protocol);
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getConnectionTimeout() {
        return this.cto;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getHeartbeat() {
        return this.heartbeat;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public String getIp() {
        return this.ip;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getIpSource() {
        return this.ipSource;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getIpType() {
        return this.ipType;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getPort() {
        return this.port;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public ConnProtocol getProtocol() {
        return this.protocol;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getReadTimeout() {
        return this.rto;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getRetryTimes() {
        return this.retry;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getStatus() {
        return this.status;
    }

    public int getUniqueId() {
        return hashCode();
    }

    public int hashCode() {
        return ((((527 + this.ip.hashCode()) * 31) + this.port) * 31) + this.protocol.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append('{');
        sb.append(this.ip);
        if (this.ipType == 0) {
            sb.append("(*)");
        }
        sb.append(' ');
        sb.append(this.port);
        sb.append(' ');
        sb.append(this.protocol);
        sb.append('}');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IPConnStrategy create(String str, b.c cVar) {
        ConnProtocol valueOf = ConnProtocol.valueOf(cVar);
        if (valueOf == null) {
            return null;
        }
        return create(str, cVar.a, valueOf, cVar.c, cVar.d, cVar.e, cVar.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IPConnStrategy create(String str, int i, ConnProtocol connProtocol, int i2, int i3, int i4, int i5) {
        if (TextUtils.isEmpty(str) || connProtocol == null || i <= 0) {
            return null;
        }
        return new IPConnStrategy(str, i, connProtocol, i2, i3, i4, i5);
    }
}
