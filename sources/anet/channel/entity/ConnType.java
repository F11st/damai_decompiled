package anet.channel.entity;

import android.text.TextUtils;
import anet.channel.strategy.ConnProtocol;
import java.util.HashMap;
import java.util.Map;
import org.android.spdy.SpdyProtocol;
import tb.ab2;
import tb.hu0;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ConnType {
    public static final String H2S = "h2s";
    public static final String HTTP2 = "http2";
    public static final String HTTP3 = "http3";
    public static final String HTTP3_1RTT = "http3_1rtt";
    public static final String HTTP3_PLAIN = "http3plain";
    public static final String PK_ACS = "acs";
    public static final String PK_AUTO = "auto";
    public static final String PK_CDN = "cdn";
    public static final String PK_OPEN = "open";
    public static final String QUIC = "quic";
    public static final String QUIC_PLAIN = "quicplain";
    public static final String RTT_0 = "0rtt";
    public static final String RTT_1 = "1rtt";
    public static final String SPDY = "spdy";
    public static ConnType d = new ConnType("http");
    public static ConnType e = new ConnType("https");
    private static Map<ConnProtocol, ConnType> f = new HashMap();
    private int a;
    private String b;
    private String c;

    /* compiled from: Taobao */
    @Deprecated
    /* loaded from: classes.dex */
    public enum TypeLevel {
        SPDY,
        HTTP
    }

    private ConnType(String str) {
        this.c = "";
        this.c = str;
    }

    public static int a(ConnType connType, ConnType connType2) {
        return connType.b() - connType2.b();
    }

    private int b() {
        int i = this.a;
        if ((i & 8) != 0) {
            return 0;
        }
        return (i & 2) != 0 ? 1 : 2;
    }

    public static ConnType l(ConnProtocol connProtocol) {
        if (connProtocol == null) {
            return null;
        }
        if ("http".equalsIgnoreCase(connProtocol.protocol)) {
            return d;
        }
        if ("https".equalsIgnoreCase(connProtocol.protocol)) {
            return e;
        }
        synchronized (f) {
            if (f.containsKey(connProtocol)) {
                return f.get(connProtocol);
            }
            ConnType connType = new ConnType(connProtocol.toString());
            connType.b = connProtocol.publicKey;
            if (HTTP2.equalsIgnoreCase(connProtocol.protocol)) {
                connType.a |= 8;
            } else if (SPDY.equalsIgnoreCase(connProtocol.protocol)) {
                connType.a |= 2;
            } else if (H2S.equals(connProtocol.protocol)) {
                connType.a = 40;
            } else if (QUIC.equalsIgnoreCase(connProtocol.protocol)) {
                connType.a = 12;
            } else if (QUIC_PLAIN.equalsIgnoreCase(connProtocol.protocol)) {
                connType.a = 32780;
            } else if (HTTP3.equalsIgnoreCase(connProtocol.protocol)) {
                connType.a = 256;
            } else if (HTTP3_1RTT.equalsIgnoreCase(connProtocol.protocol)) {
                connType.a = 8448;
            } else if (HTTP3_PLAIN.equalsIgnoreCase(connProtocol.protocol)) {
                connType.a = SpdyProtocol.HTTP3_PLAIN;
            }
            if (connType.a == 0) {
                return null;
            }
            if (!TextUtils.isEmpty(connProtocol.publicKey)) {
                connType.a |= 128;
                if (RTT_1.equalsIgnoreCase(connProtocol.rtt)) {
                    connType.a |= 8192;
                } else if (!RTT_0.equalsIgnoreCase(connProtocol.rtt)) {
                    return null;
                } else {
                    connType.a |= 4096;
                }
            }
            f.put(connProtocol, connType);
            return connType;
        }
    }

    public int c() {
        return this.a;
    }

    public int d(boolean z) {
        if (PK_CDN.equals(this.b)) {
            return 1;
        }
        if (hu0.e() == ENV.TEST) {
            return 0;
        }
        if ("open".equals(this.b)) {
            return z ? 11 : 10;
        } else if (PK_ACS.equals(this.b)) {
            return z ? 4 : 3;
        } else {
            return -1;
        }
    }

    public int e() {
        if (!equals(d) && !equals(e)) {
            return ab2.a;
        }
        return ab2.b;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ConnType)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.c.equals(((ConnType) obj).c);
    }

    @Deprecated
    public TypeLevel f() {
        if (i()) {
            return TypeLevel.HTTP;
        }
        return TypeLevel.SPDY;
    }

    public boolean g() {
        return this.a == 40;
    }

    public boolean h() {
        int i = this.a;
        return i == 256 || i == 8448 || i == 33024;
    }

    public boolean i() {
        return equals(d) || equals(e);
    }

    public boolean j() {
        return "auto".equals(this.b);
    }

    public boolean k() {
        int i = this.a;
        return (i & 128) != 0 || (i & 32) != 0 || i == 12 || i == 256 || i == 8448 || equals(e);
    }

    public String toString() {
        return this.c;
    }
}
