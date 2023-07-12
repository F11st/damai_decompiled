package anet.channel.session;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.DataFrameCb;
import anet.channel.IAuth;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.heartbeat.IHeartbeat;
import anet.channel.heartbeat.SelfKillHeartbeatImpl;
import anet.channel.security.ISecurity;
import anet.channel.statist.CustomFrameStat;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.statist.SessionMonitor;
import anet.channel.statist.SessionStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.List;
import java.util.Map;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import mtopsdk.network.util.Constants;
import org.android.spdy.AccsSSLCallback;
import org.android.spdy.SessionCb;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyByteArray;
import org.android.spdy.SpdyErrorException;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.SpdySession;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.android.spdy.SuperviseConnectInfo;
import org.android.spdy.SuperviseData;
import tb.cf0;
import tb.g80;
import tb.h01;
import tb.he;
import tb.je;
import tb.lw2;
import tb.sf0;
import tb.t9;
import tb.x6;
import tb.xa2;
import tb.ym;
import tb.zm;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class TnetSpdySession extends Session implements SessionCb {
    protected SpdyAgent B;
    protected SpdySession C;
    protected volatile boolean D;
    protected long E;
    protected long F;
    private int G;
    protected int H;
    protected DataFrameCb I;
    protected IHeartbeat J;
    protected IAuth K;
    protected String L;
    protected ISecurity M;
    private boolean N;
    private boolean O;
    private volatile boolean P;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements IAuth.AuthCallback {
        a() {
        }

        @Override // anet.channel.IAuth.AuthCallback
        public void onAuthFail(int i, String str) {
            TnetSpdySession.this.r(5, null);
            SessionStatistic sessionStatistic = TnetSpdySession.this.s;
            if (sessionStatistic != null) {
                sessionStatistic.closeReason = "Accs_Auth_Fail:" + i;
                TnetSpdySession.this.s.errorCode = (long) i;
            }
            TnetSpdySession.this.b();
        }

        @Override // anet.channel.IAuth.AuthCallback
        public void onAuthSuccess() {
            TnetSpdySession tnetSpdySession = TnetSpdySession.this;
            SessionStatistic sessionStatistic = tnetSpdySession.s;
            sessionStatistic.ret = 1;
            ALog.c("awcn.TnetSpdySession", "spdyOnStreamResponse", tnetSpdySession.r, "authTime", Long.valueOf(sessionStatistic.authTime));
            TnetSpdySession tnetSpdySession2 = TnetSpdySession.this;
            if (tnetSpdySession2.F > 0) {
                tnetSpdySession2.s.authTime = System.currentTimeMillis() - TnetSpdySession.this.F;
            }
            TnetSpdySession.this.r(4, null);
            TnetSpdySession.this.E = System.currentTimeMillis();
            TnetSpdySession tnetSpdySession3 = TnetSpdySession.this;
            IHeartbeat iHeartbeat = tnetSpdySession3.J;
            if (iHeartbeat != null) {
                iHeartbeat.start(tnetSpdySession3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b implements AccsSSLCallback {
        b() {
        }

        @Override // org.android.spdy.AccsSSLCallback
        public byte[] getSSLPublicKey(int i, byte[] bArr) {
            byte[] bArr2;
            try {
                TnetSpdySession tnetSpdySession = TnetSpdySession.this;
                bArr2 = tnetSpdySession.M.decrypt(((Session) tnetSpdySession).a, ISecurity.CIPHER_ALGORITHM_AES128, SpdyProtocol.TNET_PUBKEY_SG_KEY, bArr);
                if (bArr2 != null) {
                    try {
                        if (ALog.g(2)) {
                            ALog.f("getSSLPublicKey", null, "decrypt", new String(bArr2));
                        }
                    } catch (Throwable th) {
                        th = th;
                        ALog.d("awcn.TnetSpdySession", "getSSLPublicKey", null, th, new Object[0]);
                        return bArr2;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bArr2 = null;
            }
            return bArr2;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    private class c extends g80 {
        private anet.channel.request.a a;
        private RequestCb b;
        private int c = 0;
        private long d = 0;

        public c(anet.channel.request.a aVar, RequestCb requestCb) {
            this.a = aVar;
            this.b = requestCb;
        }

        private void a(SuperviseData superviseData, int i, String str) {
            try {
                this.a.r.rspEnd = System.currentTimeMillis();
                anet.channel.fulltrace.a.f().log(this.a.r.span, "netRspRecvEnd", null);
                if (this.a.r.isDone.get()) {
                    return;
                }
                if (i > 0) {
                    this.a.r.ret = 1;
                    TnetSpdySession.this.P = true;
                }
                this.a.r.statusCode = i;
                this.a.r.msg = str;
                if (superviseData != null) {
                    this.a.r.rspEnd = superviseData.responseEnd;
                    this.a.r.sendBeforeTime = superviseData.sendStart - superviseData.requestStart;
                    RequestStatistic requestStatistic = this.a.r;
                    requestStatistic.sendDataTime = superviseData.sendEnd - requestStatistic.sendStart;
                    this.a.r.firstDataTime = superviseData.responseStart - superviseData.sendEnd;
                    this.a.r.recDataTime = superviseData.responseEnd - superviseData.responseStart;
                    this.a.r.sendDataSize = superviseData.bodySize + superviseData.compressSize;
                    this.a.r.recDataSize = this.d + superviseData.recvUncompressSize;
                    this.a.r.reqHeadInflateSize = superviseData.uncompressSize;
                    this.a.r.reqHeadDeflateSize = superviseData.compressSize;
                    this.a.r.reqBodyInflateSize = superviseData.bodySize;
                    this.a.r.reqBodyDeflateSize = superviseData.bodySize;
                    this.a.r.rspHeadDeflateSize = superviseData.recvCompressSize;
                    this.a.r.rspHeadInflateSize = superviseData.recvUncompressSize;
                    this.a.r.rspBodyDeflateSize = superviseData.recvBodySize;
                    this.a.r.rspBodyInflateSize = this.d;
                    if (this.a.r.contentLength == 0) {
                        this.a.r.contentLength = superviseData.originContentLength;
                    }
                    SessionStatistic sessionStatistic = TnetSpdySession.this.s;
                    sessionStatistic.recvSizeCount += superviseData.recvBodySize + superviseData.recvCompressSize;
                    sessionStatistic.sendSizeCount += superviseData.bodySize + superviseData.compressSize;
                    ALog.e("awcn.TnetSpdySession", "[setStatisticData]", this.a.n(), "tnetStat", superviseData.superviseDataToString(), Preloader.KEY_SESSION, TnetSpdySession.this.r);
                }
            } catch (Exception unused) {
            }
        }

        @Override // org.android.spdy.Spdycb
        public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, long j, SpdyByteArray spdyByteArray, Object obj) {
            if (ALog.g(1)) {
                ALog.c("awcn.TnetSpdySession", "spdyDataChunkRecvCB", this.a.n(), "len", Integer.valueOf(spdyByteArray.getDataLength()), "fin", Boolean.valueOf(z));
            }
            this.d += spdyByteArray.getDataLength();
            this.a.r.recDataSize += spdyByteArray.getDataLength();
            this.a.r.lastRecvDataTime = System.currentTimeMillis() - this.a.r.sendStart;
            IHeartbeat iHeartbeat = TnetSpdySession.this.J;
            if (iHeartbeat != null) {
                iHeartbeat.reSchedule();
            }
            if (this.b != null) {
                he d = je.a().d(spdyByteArray.getByteArray(), spdyByteArray.getDataLength());
                spdyByteArray.recycle();
                this.b.onDataReceive(d, z);
            }
            TnetSpdySession.this.n(32, null);
        }

        @Override // org.android.spdy.Spdycb
        public void spdyOnStreamResponse(SpdySession spdySession, long j, Map<String, List<String>> map, Object obj) {
            this.a.r.firstDataTime = System.currentTimeMillis() - this.a.r.sendStart;
            this.c = h01.i(map);
            TnetSpdySession.this.G = 0;
            ALog.f("awcn.TnetSpdySession", "", this.a.n(), HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(this.c));
            ALog.f("awcn.TnetSpdySession", "", this.a.n(), "response headers", map);
            RequestCb requestCb = this.b;
            if (requestCb != null) {
                requestCb.onResponseCode(this.c, h01.b(map));
            }
            TnetSpdySession.this.n(16, null);
            this.a.r.contentEncoding = h01.d(map, Constants.Protocol.CONTENT_ENCODING);
            this.a.r.contentType = h01.d(map, "Content-Type");
            this.a.r.contentLength = h01.f(map);
            this.a.r.serverRT = h01.h(map);
            this.a.r.eagleEyeId = h01.g(map);
            this.a.r.isHitCache = h01.e(map);
            TnetSpdySession.this.o(this.a, this.c);
            TnetSpdySession.this.p(this.a, map);
            IHeartbeat iHeartbeat = TnetSpdySession.this.J;
            if (iHeartbeat != null) {
                iHeartbeat.reSchedule();
            }
        }

        @Override // org.android.spdy.Spdycb
        public void spdyStreamCloseCallback(SpdySession spdySession, long j, int i, Object obj, SuperviseData superviseData) {
            String str;
            if (ALog.g(1)) {
                ALog.c("awcn.TnetSpdySession", "spdyStreamCloseCallback", this.a.n(), "streamId", Long.valueOf(j), "errorCode", Integer.valueOf(i));
            }
            if (i != 0) {
                this.c = cf0.ERROR_TNET_REQUEST_FAIL;
                str = cf0.a(cf0.ERROR_TNET_REQUEST_FAIL, String.valueOf(i));
                if (i != -2005) {
                    x6.b().commitStat(new ExceptionStatistic(-300, str, this.a.r, null));
                }
                ALog.e("awcn.TnetSpdySession", "spdyStreamCloseCallback error", this.a.n(), Preloader.KEY_SESSION, TnetSpdySession.this.r, "status code", Integer.valueOf(i), "URL", this.a.j().l());
            } else {
                str = "SUCCESS";
            }
            this.a.r.tnetErrorCode = i;
            a(superviseData, this.c, str);
            RequestCb requestCb = this.b;
            if (requestCb != null) {
                requestCb.onFinish(this.c, str, this.a.r);
            }
            if (i == -2004) {
                if (!TnetSpdySession.this.D) {
                    TnetSpdySession.this.t(true);
                }
                if (TnetSpdySession.N(TnetSpdySession.this) >= 2) {
                    ym ymVar = new ym();
                    ymVar.a = false;
                    ymVar.b = TnetSpdySession.this.N;
                    anet.channel.strategy.a.a().notifyConnEvent(((Session) TnetSpdySession.this).e, ((Session) TnetSpdySession.this).l, ymVar);
                    TnetSpdySession.this.c(true);
                }
            }
        }
    }

    public TnetSpdySession(Context context, zm zmVar) {
        super(context, zmVar);
        this.D = false;
        this.F = 0L;
        this.G = 0;
        this.H = -1;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = false;
        this.P = false;
    }

    static /* synthetic */ int N(TnetSpdySession tnetSpdySession) {
        int i = tnetSpdySession.G + 1;
        tnetSpdySession.G = i;
        return i;
    }

    private void S() {
        SpdyAgent.enableDebug = false;
        this.B = SpdyAgent.getInstance(this.a, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        ISecurity iSecurity = this.M;
        if (iSecurity != null && !iSecurity.isSecOff()) {
            this.B.setAccsSslCallback(new b());
        }
        if (t9.Q()) {
            return;
        }
        try {
            this.B.getClass().getDeclaredMethod("disableHeaderCache", new Class[0]).invoke(this.B, new Object[0]);
            ALog.f("awcn.TnetSpdySession", "tnet disableHeaderCache", null, new Object[0]);
        } catch (Exception e) {
            ALog.d("awcn.TnetSpdySession", "tnet disableHeaderCache", null, e, new Object[0]);
        }
    }

    private void T(int i, int i2, boolean z, String str) {
        DataFrameCb dataFrameCb = this.I;
        if (dataFrameCb != null) {
            dataFrameCb.onException(i, i2, z, str);
        }
    }

    protected void P() {
        IAuth iAuth = this.K;
        if (iAuth != null) {
            iAuth.auth(this, new a());
            return;
        }
        r(4, null);
        this.s.ret = 1;
        IHeartbeat iHeartbeat = this.J;
        if (iHeartbeat != null) {
            iHeartbeat.start(this);
        }
    }

    public void Q(anet.channel.a aVar) {
        if (aVar != null) {
            this.L = aVar.i();
            this.M = aVar.m();
        }
    }

    public void R(xa2 xa2Var) {
        if (xa2Var != null) {
            this.I = xa2Var.f;
            this.K = xa2Var.d;
            if (xa2Var.b) {
                this.s.isKL = 1L;
                this.v = true;
                IHeartbeat iHeartbeat = xa2Var.e;
                this.J = iHeartbeat;
                boolean z = xa2Var.c;
                this.N = z;
                if (iHeartbeat == null) {
                    if (z && !t9.i()) {
                        this.J = anet.channel.heartbeat.a.a();
                    } else {
                        this.J = anet.channel.heartbeat.a.b();
                    }
                }
            }
        }
        if (t9.x() && this.J == null) {
            this.J = new SelfKillHeartbeatImpl();
        }
    }

    public void U(int i) {
        this.H = i;
    }

    @Override // anet.channel.Session
    public void b() {
        ALog.e("awcn.TnetSpdySession", "force close!", this.r, Preloader.KEY_SESSION, this);
        r(7, null);
        try {
            IHeartbeat iHeartbeat = this.J;
            if (iHeartbeat != null) {
                iHeartbeat.stop();
                this.J = null;
            }
            SpdySession spdySession = this.C;
            if (spdySession != null) {
                spdySession.closeSession();
            }
        } catch (Exception unused) {
        }
    }

    @Override // org.android.spdy.SessionCb
    public void bioPingRecvCallback(SpdySession spdySession, int i) {
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x016d A[Catch: all -> 0x01af, TRY_LEAVE, TryCatch #3 {all -> 0x01af, blocks: (B:9:0x0014, B:11:0x0018, B:12:0x001b, B:14:0x0021, B:16:0x0027, B:18:0x002f, B:19:0x0037, B:20:0x00dc, B:25:0x00e8, B:27:0x00f2, B:28:0x010b, B:30:0x0113, B:32:0x011b, B:35:0x0124, B:37:0x0128, B:48:0x014e, B:50:0x0156, B:52:0x015c, B:53:0x015f, B:55:0x016d, B:59:0x0188, B:63:0x019a, B:38:0x012c, B:40:0x0132, B:42:0x0138, B:43:0x0142, B:45:0x0146, B:47:0x014b, B:46:0x0149), top: B:79:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0184  */
    @Override // anet.channel.Session
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e() {
        /*
            Method dump skipped, instructions count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.session.TnetSpdySession.e():void");
    }

    @Override // org.android.spdy.SessionCb
    public byte[] getSSLMeta(SpdySession spdySession) {
        String domain = spdySession.getDomain();
        long currentTimeMillis = System.currentTimeMillis();
        byte[] bArr = null;
        if (TextUtils.isEmpty(domain)) {
            ALog.f("awcn.TnetSpdySession", "get sslticket host is null", null, new Object[0]);
            return null;
        }
        try {
            ISecurity iSecurity = this.M;
            if (iSecurity != null) {
                Context context = this.a;
                bArr = iSecurity.getBytes(context, "accs_ssl_key2_" + domain);
            }
        } catch (Throwable th) {
            ALog.d("awcn.TnetSpdySession", "getSSLMeta", null, th, new Object[0]);
        }
        if (bArr != null && bArr.length > 0) {
            this.s.isHitTicket = 1;
        }
        this.s.ticketTime = System.currentTimeMillis() - currentTimeMillis;
        return bArr;
    }

    @Override // anet.channel.Session
    protected Runnable l() {
        return new Runnable() { // from class: anet.channel.session.TnetSpdySession.1
            @Override // java.lang.Runnable
            public void run() {
                if (TnetSpdySession.this.D) {
                    TnetSpdySession tnetSpdySession = TnetSpdySession.this;
                    ALog.e("awcn.TnetSpdySession", "send msg time out!", tnetSpdySession.r, "pingUnRcv:", Boolean.valueOf(tnetSpdySession.D));
                    try {
                        TnetSpdySession.this.n(2048, null);
                        SessionStatistic sessionStatistic = TnetSpdySession.this.s;
                        if (sessionStatistic != null) {
                            sessionStatistic.closeReason = "ping time out";
                        }
                        ym ymVar = new ym();
                        ymVar.a = false;
                        ymVar.b = TnetSpdySession.this.N;
                        anet.channel.strategy.a.a().notifyConnEvent(((Session) TnetSpdySession.this).e, ((Session) TnetSpdySession.this).l, ymVar);
                        TnetSpdySession.this.c(true);
                    } catch (Exception unused) {
                    }
                }
            }
        };
    }

    @Override // org.android.spdy.SessionCb
    public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        String domain = spdySession.getDomain();
        if (TextUtils.isEmpty(domain)) {
            return -1;
        }
        try {
            ISecurity iSecurity = this.M;
            if (iSecurity != null) {
                Context context = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append("accs_ssl_key2_");
                sb.append(domain);
                return iSecurity.saveBytes(context, sb.toString(), bArr) ? 0 : -1;
            }
            return -1;
        } catch (Throwable th) {
            ALog.d("awcn.TnetSpdySession", "putSSLMeta", null, th, new Object[0]);
            return -1;
        }
    }

    @Override // anet.channel.Session
    public boolean q() {
        return this.o == 4;
    }

    @Override // anet.channel.Session
    protected void s() {
        this.D = false;
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i, int i2) {
        ALog.e("awcn.TnetSpdySession", "spdyCustomControlFrameFailCallback", this.r, com.taobao.accs.common.Constants.KEY_DATA_ID, Integer.valueOf(i));
        T(i, i2, true, "tnet error");
        CustomFrameStat customFrameStat = new CustomFrameStat();
        customFrameStat.host = this.e;
        customFrameStat.isAccs = this.N;
        customFrameStat.errCode = i2;
        customFrameStat.ret = 0;
        x6.b().commitStat(customFrameStat);
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i, int i2, int i3, int i4, byte[] bArr) {
        ALog.e("awcn.TnetSpdySession", "[spdyCustomControlFrameRecvCallback]", this.r, "len", Integer.valueOf(i4), "frameCb", this.I);
        if (ALog.g(1) && i4 < 512) {
            String str = "";
            for (int i5 = 0; i5 < bArr.length; i5++) {
                str = str + Integer.toHexString(bArr[i5] & 255) + " ";
            }
            ALog.e("awcn.TnetSpdySession", null, this.r, "str", str);
        }
        DataFrameCb dataFrameCb = this.I;
        if (dataFrameCb != null) {
            dataFrameCb.onDataReceive(this, bArr, i, i2);
        } else {
            ALog.e("awcn.TnetSpdySession", "AccsFrameCb is null", this.r, new Object[0]);
            x6.b().commitStat(new ExceptionStatistic(-105, null, "rt"));
        }
        this.s.inceptCount++;
        IHeartbeat iHeartbeat = this.J;
        if (iHeartbeat != null) {
            iHeartbeat.reSchedule();
        }
    }

    @Override // org.android.spdy.SessionCb
    public void spdyPingRecvCallback(SpdySession spdySession, long j, Object obj) {
        if (ALog.g(2)) {
            ALog.f("awcn.TnetSpdySession", "ping receive", this.r, BizTime.HOST, this.d, "id", Long.valueOf(j));
        }
        if (j < 0) {
            return;
        }
        this.D = false;
        this.G = 0;
        IHeartbeat iHeartbeat = this.J;
        if (iHeartbeat != null) {
            iHeartbeat.reSchedule();
        }
        n(128, null);
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i) {
        ALog.e("awcn.TnetSpdySession", "spdySessionCloseCallback", this.r, " errorCode:", Integer.valueOf(i));
        IHeartbeat iHeartbeat = this.J;
        if (iHeartbeat != null) {
            iHeartbeat.stop();
            this.J = null;
        }
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e) {
                ALog.d("awcn.TnetSpdySession", "session clean up failed!", null, e, new Object[0]);
            }
        }
        if (i == -3516 || i == -5004) {
            ym ymVar = new ym();
            ymVar.a = false;
            anet.channel.strategy.a.a().notifyConnEvent(this.e, this.l, ymVar);
        }
        r(6, new sf0(2));
        if (superviseConnectInfo != null) {
            SessionStatistic sessionStatistic = this.s;
            sessionStatistic.requestCount = superviseConnectInfo.reused_counter;
            sessionStatistic.liveTime = superviseConnectInfo.keepalive_period_second;
            try {
                if (this.k.h()) {
                    SessionStatistic sessionStatistic2 = this.s;
                    sessionStatistic2.xqc0RttStatus = superviseConnectInfo.xqc0RttStatus;
                    sessionStatistic2.retransmissionRate = superviseConnectInfo.retransmissionRate;
                    sessionStatistic2.lossRate = superviseConnectInfo.lossRate;
                    sessionStatistic2.tlpCount = superviseConnectInfo.tlpCount;
                    sessionStatistic2.rtoCount = superviseConnectInfo.rtoCount;
                    sessionStatistic2.srtt = superviseConnectInfo.srtt;
                }
                if (spdySession != null) {
                    ALog.e("awcn.TnetSpdySession", "[spdySessionCloseCallback]", this.r, "connectInfo", spdySession.getConnectInfoOnDisConnected());
                }
            } catch (Exception unused) {
            }
        }
        SessionStatistic sessionStatistic3 = this.s;
        if (sessionStatistic3.errorCode == 0) {
            sessionStatistic3.errorCode = i;
        }
        sessionStatistic3.lastPingInterval = (int) (System.currentTimeMillis() - this.E);
        x6.b().commitStat(this.s);
        if (lw2.d(this.s.ip)) {
            x6.b().commitStat(new SessionMonitor(this.s));
        }
        x6.b().commitAlarm(this.s.getAlarmObject());
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        SessionStatistic sessionStatistic = this.s;
        sessionStatistic.connectionTime = superviseConnectInfo.connectTime;
        sessionStatistic.sslTime = superviseConnectInfo.handshakeTime;
        sessionStatistic.sslCalTime = superviseConnectInfo.doHandshakeTime;
        sessionStatistic.netType = NetworkStatusHelper.e();
        this.F = System.currentTimeMillis();
        if (this.k.h()) {
            SessionStatistic sessionStatistic2 = this.s;
            sessionStatistic2.scid = superviseConnectInfo.scid;
            sessionStatistic2.dcid = superviseConnectInfo.dcid;
            sessionStatistic2.congControlKind = superviseConnectInfo.congControlKind;
            this.O = spdySession.isQuicTry0RTT();
            ALog.e("awcn.TnetSpdySession", "[HTTP3 spdySessionConnectCB]", this.r, "connectInfo", spdySession.getConnectInfoOnConnected());
        }
        r(0, new sf0(1));
        P();
        ALog.e("awcn.TnetSpdySession", "spdySessionConnectCB connect", this.r, "connectTime", Integer.valueOf(superviseConnectInfo.connectTime), "sslTime", Integer.valueOf(superviseConnectInfo.handshakeTime));
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionFailedError(SpdySession spdySession, int i, Object obj) {
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e) {
                ALog.d("awcn.TnetSpdySession", "[spdySessionFailedError]session clean up failed!", null, e, new Object[0]);
            }
        }
        r(2, new sf0(256, i, "tnet connect fail"));
        ALog.e("awcn.TnetSpdySession", null, this.r, " errorId:", Integer.valueOf(i));
        SessionStatistic sessionStatistic = this.s;
        sessionStatistic.errorCode = i;
        sessionStatistic.ret = 0;
        if (!sessionStatistic.isReported) {
            sessionStatistic.ret = 2;
        }
        sessionStatistic.netType = NetworkStatusHelper.e();
        x6.b().commitStat(this.s);
        if (lw2.d(this.s.ip)) {
            x6.b().commitStat(new SessionMonitor(this.s));
        }
        x6.b().commitAlarm(this.s.getAlarmObject());
    }

    @Override // anet.channel.Session
    public void t(boolean z) {
        u(z, this.u);
    }

    @Override // anet.channel.Session
    public void u(boolean z, int i) {
        if (ALog.g(1)) {
            ALog.c("awcn.TnetSpdySession", "ping", this.r, "host", this.d, "thread", Thread.currentThread().getName());
        }
        if (z) {
            try {
                if (this.C != null) {
                    int i2 = this.o;
                    if (i2 == 0 || i2 == 4) {
                        n(64, null);
                        if (this.D) {
                            return;
                        }
                        this.D = true;
                        this.s.ppkgCount++;
                        this.C.submitPing();
                        if (ALog.g(1)) {
                            ALog.c("awcn.TnetSpdySession", this.d + " submit ping ms:" + (System.currentTimeMillis() - this.E) + " force:" + z, this.r, new Object[0]);
                        }
                        y(i);
                        this.E = System.currentTimeMillis();
                        IHeartbeat iHeartbeat = this.J;
                        if (iHeartbeat != null) {
                            iHeartbeat.reSchedule();
                            return;
                        }
                        return;
                    }
                    return;
                }
                SessionStatistic sessionStatistic = this.s;
                if (sessionStatistic != null) {
                    sessionStatistic.closeReason = "session null";
                }
                ALog.e("awcn.TnetSpdySession", this.d + " session null", this.r, new Object[0]);
                b();
            } catch (SpdyErrorException e) {
                if (e.SpdyErrorGetCode() == -1104 || e.SpdyErrorGetCode() == -1103) {
                    ALog.e("awcn.TnetSpdySession", "Send request on closed session!!!", this.r, new Object[0]);
                    r(6, new sf0(2));
                }
                ALog.d("awcn.TnetSpdySession", "ping", this.r, e, new Object[0]);
            } catch (Exception e2) {
                ALog.d("awcn.TnetSpdySession", "ping", this.r, e2, new Object[0]);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0161 A[Catch: Exception -> 0x021d, SpdyErrorException -> 0x0233, TRY_ENTER, TryCatch #4 {SpdyErrorException -> 0x0233, Exception -> 0x021d, blocks: (B:17:0x0082, B:19:0x0086, B:23:0x008d, B:25:0x0091, B:26:0x0098, B:29:0x00ae, B:30:0x00ea, B:32:0x00f2, B:35:0x00f7, B:37:0x0134, B:39:0x013a, B:41:0x013e, B:43:0x0142, B:45:0x0146, B:47:0x0155, B:50:0x0161, B:52:0x0168, B:54:0x016f, B:59:0x018e, B:61:0x01cb, B:62:0x01e3, B:53:0x016b, B:55:0x0173, B:57:0x0186, B:58:0x0188, B:46:0x014e, B:36:0x0120, B:72:0x0213), top: B:87:0x0082 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0173 A[Catch: Exception -> 0x021d, SpdyErrorException -> 0x0233, TryCatch #4 {SpdyErrorException -> 0x0233, Exception -> 0x021d, blocks: (B:17:0x0082, B:19:0x0086, B:23:0x008d, B:25:0x0091, B:26:0x0098, B:29:0x00ae, B:30:0x00ea, B:32:0x00f2, B:35:0x00f7, B:37:0x0134, B:39:0x013a, B:41:0x013e, B:43:0x0142, B:45:0x0146, B:47:0x0155, B:50:0x0161, B:52:0x0168, B:54:0x016f, B:59:0x018e, B:61:0x01cb, B:62:0x01e3, B:53:0x016b, B:55:0x0173, B:57:0x0186, B:58:0x0188, B:46:0x014e, B:36:0x0120, B:72:0x0213), top: B:87:0x0082 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01cb A[Catch: Exception -> 0x021d, SpdyErrorException -> 0x0233, TryCatch #4 {SpdyErrorException -> 0x0233, Exception -> 0x021d, blocks: (B:17:0x0082, B:19:0x0086, B:23:0x008d, B:25:0x0091, B:26:0x0098, B:29:0x00ae, B:30:0x00ea, B:32:0x00f2, B:35:0x00f7, B:37:0x0134, B:39:0x013a, B:41:0x013e, B:43:0x0142, B:45:0x0146, B:47:0x0155, B:50:0x0161, B:52:0x0168, B:54:0x016f, B:59:0x018e, B:61:0x01cb, B:62:0x01e3, B:53:0x016b, B:55:0x0173, B:57:0x0186, B:58:0x0188, B:46:0x014e, B:36:0x0120, B:72:0x0213), top: B:87:0x0082 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0206 A[Catch: Exception -> 0x020b, SpdyErrorException -> 0x020e, TRY_LEAVE, TryCatch #3 {SpdyErrorException -> 0x020e, Exception -> 0x020b, blocks: (B:63:0x01ee, B:65:0x0206), top: B:88:0x01ee }] */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v26 */
    @Override // anet.channel.Session
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public anet.channel.request.Cancelable w(anet.channel.request.a r24, anet.channel.RequestCb r25) {
        /*
            Method dump skipped, instructions count: 630
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.session.TnetSpdySession.w(anet.channel.request.a, anet.channel.RequestCb):anet.channel.request.Cancelable");
    }

    @Override // anet.channel.Session
    public void x(int i, byte[] bArr, int i2) {
        SpdySession spdySession;
        CustomFrameStat customFrameStat = new CustomFrameStat();
        customFrameStat.host = this.e;
        customFrameStat.isAccs = this.N;
        try {
            try {
            } catch (SpdyErrorException e) {
                ALog.d("awcn.TnetSpdySession", "sendCustomFrame error", this.r, e, new Object[0]);
                T(i, -300, true, "SpdyErrorException: " + e.toString());
                customFrameStat.errCode = e.SpdyErrorGetCode();
                if (e.SpdyErrorGetCode() == -1104 || e.SpdyErrorGetCode() == -1103) {
                    r(6, new sf0(2));
                }
            } catch (Exception e2) {
                ALog.d("awcn.TnetSpdySession", "sendCustomFrame error", this.r, e2, new Object[0]);
                customFrameStat.errCode = -4;
                T(i, -101, true, e2.toString());
            }
            if (this.I == null) {
                ALog.e("awcn.TnetSpdySession", "sendCustomFrame error dataFrameCb is null", this.r, new Object[0]);
                customFrameStat.errCode = -1;
                return;
            }
            ALog.e("awcn.TnetSpdySession", "sendCustomFrame", this.r, com.taobao.accs.common.Constants.KEY_DATA_ID, Integer.valueOf(i), "type", Integer.valueOf(i2));
            if (this.o == 4 && (spdySession = this.C) != null) {
                if (bArr != null && bArr.length > 16384) {
                    customFrameStat.errCode = -2;
                    T(i, cf0.ERROR_DATA_TOO_LARGE, false, null);
                } else {
                    spdySession.sendCustomControlFrame(i, i2, 0, bArr == null ? 0 : bArr.length, bArr);
                    SessionStatistic sessionStatistic = this.s;
                    sessionStatistic.requestCount++;
                    sessionStatistic.cfRCount++;
                    this.E = System.currentTimeMillis();
                    customFrameStat.ret = 1;
                }
            } else {
                ALog.e("awcn.TnetSpdySession", "sendCustomFrame", this.r, "sendCustomFrame con invalid mStatus:" + this.o);
                customFrameStat.errCode = -3;
                T(i, cf0.ERROR_SESSION_INVALID, true, "session invalid");
            }
        } finally {
            x6.b().commitStat(customFrameStat);
        }
    }
}
