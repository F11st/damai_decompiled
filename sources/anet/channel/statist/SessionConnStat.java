package anet.channel.statist;

import anet.channel.Session;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.Inet64Util;
import org.json.JSONException;
import org.json.JSONObject;
import tb.hu0;
import tb.t9;

/* compiled from: Taobao */
@Monitor(module = "networkPrefer", monitorPoint = "conn_stat")
/* loaded from: classes.dex */
public class SessionConnStat extends StatObject {
    @Dimension
    public String errorCode;
    @Dimension
    public String errorMsg;
    @Dimension
    public StringBuilder errorTrace;
    @Dimension
    public JSONObject extra;
    @Dimension
    public int firstIpType;
    @Dimension
    public String host;
    @Dimension
    public String ip;
    @Dimension
    public int ipStackType;
    @Dimension
    public String isBg;
    @Dimension
    public boolean isComplex;
    @Dimension
    public boolean isComplexEnable;
    @Dimension
    public boolean isCreated;
    @Dimension
    public boolean isTicketStore;
    @Dimension
    public int port;
    @Dimension
    public String protocolType;
    @Dimension
    public int ret;
    @Dimension
    public int sessionCount;
    @Dimension
    public String unit;
    @Dimension
    public int ipRefer = 0;
    @Dimension
    public int ipType = 1;
    @Dimension
    public double lng = 90000.0d;
    @Dimension
    public double lat = 90000.0d;
    @Dimension
    public float accuracy = -1.0f;
    @Dimension
    public int isProxy = 0;
    @Measure(max = 60000.0d)
    public long totalTime = 0;
    @Measure(max = 60000.0d)
    public long authTime = 0;
    public volatile boolean isCommited = false;
    public volatile long start = 0;
    public volatile long startConnect = 0;
    @Dimension
    public String netType = NetworkStatusHelper.e();
    @Dimension
    public String bssid = NetworkStatusHelper.k();
    @Dimension
    public int roaming = NetworkStatusHelper.p() ? 1 : 0;
    @Dimension
    public String mnc = NetworkStatusHelper.h();
    @Dimension
    public int retryTimes = -1;

    public SessionConnStat() {
        this.isBg = hu0.i() ? "bg" : "fg";
        this.ipStackType = Inet64Util.n();
        this.isComplexEnable = t9.p();
        this.isTicketStore = t9.P();
    }

    public void appendErrorTrace(int i) {
        if (this.errorTrace == null) {
            this.errorTrace = new StringBuilder();
        }
        if (this.errorTrace.length() > 0) {
            this.errorTrace.append(",");
        }
        StringBuilder sb = this.errorTrace;
        sb.append(i);
        sb.append("=");
        sb.append(System.currentTimeMillis() - this.startConnect);
    }

    @Override // anet.channel.statist.StatObject
    public boolean beforeCommit() {
        if (this.isCommited) {
            return false;
        }
        this.isCommited = true;
        return true;
    }

    public void putExtra(String str, Object obj) {
        try {
            if (this.extra == null) {
                this.extra = new JSONObject();
            }
            this.extra.put(str, obj);
        } catch (JSONException unused) {
        }
    }

    public void syncValueFromSession(Session session) {
        SessionStatistic sessionStatistic = session.s;
        this.ip = sessionStatistic.ip;
        this.port = sessionStatistic.port;
        this.ipRefer = sessionStatistic.ipRefer;
        this.ipType = sessionStatistic.ipType;
        this.protocolType = sessionStatistic.conntype;
        this.host = sessionStatistic.host;
        this.isProxy = sessionStatistic.isProxy;
        this.authTime = sessionStatistic.authTime;
        String m = session.m();
        this.unit = m;
        if (m == null && this.ipRefer == 1) {
            this.unit = "LocalDNS";
        }
    }
}
