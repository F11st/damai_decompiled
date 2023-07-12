package anet.channel.statist;

import anet.channel.monitor.BandWidthSampler;
import anet.channel.quic.Http3ConnectionDetector;
import anet.channel.strategy.IConnStrategy;
import anet.channel.util.Inet64Util;
import com.youku.live.livesdk.preloader.Preloader;
import org.json.JSONObject;
import tb.g4;
import tb.hu0;
import tb.t9;
import tb.zm;

/* compiled from: Taobao */
@Monitor(module = "networkPrefer", monitorPoint = Preloader.KEY_SESSION)
/* loaded from: classes.dex */
public class SessionStatistic extends StatObject {
    public static int maxRetryTime;
    @Measure
    public long ackTime;
    @Measure(max = 15000.0d)
    public long authTime;
    @Measure
    public long cfRCount;
    @Dimension
    public String closeReason;
    @Dimension
    public int congControlKind;
    @Measure(max = 15000.0d, name = "connTime")
    public long connectionTime;
    @Dimension(name = "protocolType")
    public String conntype;
    @Dimension
    public String dcid;
    @Dimension
    public long errorCode;
    @Dimension
    public String host;
    @Measure
    public long inceptCount;
    @Dimension
    public String ip;
    @Dimension
    public int ipRefer;
    @Dimension
    public int ipStackType;
    @Dimension
    public int ipType;
    @Dimension
    public boolean isBackground;
    @Dimension
    public String isBg;
    @Dimension
    public boolean isComplex;
    @Dimension
    public boolean isComplexEnable;
    @Dimension
    public int isHitTicket;
    @Dimension
    public long isKL;
    @Dimension
    public boolean isTicketStore;
    @Dimension
    public String isTunnel;
    @Measure
    public int lastPingInterval;
    @Measure
    public double lossRate;
    @Dimension
    public int mss;
    @Dimension
    public int netSpeed;
    @Dimension
    public String netType;
    @Measure
    public long pRate;
    @Dimension
    public int port;
    @Measure
    public long ppkgCount;
    @Measure
    public long recvSizeCount;
    @Dimension
    public int ret;
    @Measure
    public double retransmissionRate;
    @Dimension
    public long retryTimes;
    @Measure
    public int rtoCount;
    @Dimension
    public String scid;
    @Dimension
    public int sdkv;
    @Measure
    public long sendSizeCount;
    @Measure
    public long srtt;
    @Measure(max = 15000.0d)
    public long sslCalTime;
    @Measure(max = 15000.0d)
    public long sslTime;
    @Dimension
    public long ticketTime;
    @Measure
    public int tlpCount;
    @Dimension
    public int xqc0RttStatus;
    @Dimension
    public String xqcConnEnv;
    @Dimension
    public int isProxy = 0;
    @Dimension
    public JSONObject extra = null;
    @Measure(max = 86400.0d)
    public long liveTime = 0;
    @Measure(constantValue = 1.0d)
    public long requestCount = 1;
    @Measure(constantValue = 0.0d)
    public long stdRCount = 1;
    public boolean isCommitted = false;
    public boolean isReported = true;

    public SessionStatistic(zm zmVar) {
        this.ipRefer = 0;
        this.ipType = 1;
        if (zmVar == null) {
            return;
        }
        this.ip = zmVar.e();
        this.port = zmVar.f();
        IConnStrategy iConnStrategy = zmVar.a;
        if (iConnStrategy != null) {
            this.ipRefer = iConnStrategy.getIpSource();
            this.ipType = zmVar.a.getIpType();
        }
        this.pRate = zmVar.c();
        this.conntype = zmVar.a().toString();
        this.retryTimes = zmVar.d;
        maxRetryTime = zmVar.e;
        int i = Http3ConnectionDetector.i();
        boolean u = t9.u();
        this.xqcConnEnv = "http3OrangeEnable=" + u + "-http3Detect=" + i + "-http3ABEnable=" + t9.r();
        this.isBg = hu0.i() ? "bg" : "fg";
        this.ipStackType = Inet64Util.n();
        this.netSpeed = BandWidthSampler.f().h();
        this.isComplexEnable = t9.p();
        this.isTicketStore = t9.P();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
        if (r3 != (-2601)) goto L14;
     */
    @Override // anet.channel.statist.StatObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean beforeCommit() {
        /*
            r7 = this;
            int r0 = r7.ret
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L53
            long r3 = r7.retryTimes
            int r0 = anet.channel.statist.SessionStatistic.maxRetryTime
            long r5 = (long) r0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L1d
            long r3 = r7.errorCode
            r5 = -2613(0xfffffffffffff5cb, double:NaN)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L1d
            r5 = -2601(0xfffffffffffff5d7, double:NaN)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L53
        L1d:
            boolean r0 = anet.channel.util.ALog.g(r2)
            if (r0 == 0) goto L52
            r0 = 0
            r3 = 5
            java.lang.Object[] r3 = new java.lang.Object[r3]
            long r4 = r7.retryTimes
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r3[r1] = r4
            java.lang.String r4 = "maxRetryTime"
            r3[r2] = r4
            r2 = 2
            int r4 = anet.channel.statist.SessionStatistic.maxRetryTime
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r2] = r4
            r2 = 3
            java.lang.String r4 = "errorCode"
            r3[r2] = r4
            r2 = 4
            long r4 = r7.errorCode
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r3[r2] = r4
            java.lang.String r2 = "SessionStat no need commit"
            java.lang.String r4 = "retry:"
            anet.channel.util.ALog.c(r2, r0, r4, r3)
        L52:
            return r1
        L53:
            boolean r0 = r7.isCommitted
            if (r0 == 0) goto L58
            return r1
        L58:
            r7.isCommitted = r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.statist.SessionStatistic.beforeCommit():boolean");
    }

    public g4 getAlarmObject() {
        g4 g4Var = new g4();
        g4Var.e = "networkPrefer";
        g4Var.f = "connect_succ_rate";
        boolean z = this.ret != 0;
        g4Var.a = z;
        if (z) {
            g4Var.b = this.closeReason;
        } else {
            g4Var.c = String.valueOf(this.errorCode);
        }
        return g4Var;
    }
}
