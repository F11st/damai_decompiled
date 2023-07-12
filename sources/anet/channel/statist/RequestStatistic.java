package anet.channel.statist;

import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.fulltrace.IFullTraceAnalysisV3;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.AppLifecycle;
import anet.channel.util.C0241c;
import anet.channel.util.Inet64Util;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import tb.C9708t9;
import tb.hu0;

/* compiled from: Taobao */
@Monitor(module = "networkPrefer", monitorPoint = "network")
/* loaded from: classes.dex */
public class RequestStatistic extends StatObject {
    @Dimension
    public String abTestBucket;
    @Dimension
    public volatile String bizId;
    @Dimension
    public String bizReqId;
    @Dimension
    public volatile String bssid;
    @Dimension
    public String cid;
    @Dimension
    public int deviceLevel;
    @Dimension
    public String eagleEyeId;
    @Dimension
    public volatile String f_refer;
    public String falcoId;
    @Dimension
    public int firstErrorCode;
    @Dimension
    public String firstProtocol;
    @Dimension
    public String harmonyVersion;
    @Dimension
    public volatile String host;
    @Dimension
    public volatile String ip;
    @Dimension
    public int ipStackType;
    @Dimension
    public boolean is0RttOptimize;
    @Dimension
    public volatile String isBg;
    @Dimension
    public boolean isComplex;
    @Dimension
    public boolean isComplexEnable;
    @Dimension
    public boolean isFastDegrade;
    @Dimension
    public int isHarmonyOS;
    @Dimension
    public boolean isHitCache;
    @Dimension
    public boolean isHttpDetectEnable;
    @Dimension
    public boolean isIpv4Degrade;
    @Dimension
    public volatile boolean isProxy;
    public boolean isReqMain;
    public boolean isReqSync;
    @Dimension
    public volatile boolean isSSL;
    @Dimension
    public boolean isStrategyUpgrade;
    public String lastInterceptor;
    public String locationUrl;
    @Dimension
    public volatile int maxRetryTime;
    @Dimension
    public String mnc;
    @Dimension
    public int multiNetworkStatus;
    public volatile long netReqStart;
    @Dimension
    public volatile String netType;
    public String pTraceId;
    @Dimension
    public volatile int port;
    @Dimension
    public String process;
    @Dimension
    public volatile String protocolType;
    @Dimension
    public volatile String proxyType;
    @Deprecated
    public volatile String quicConnectionID;
    public volatile long reqServiceTransmissionEnd;
    @Dimension
    public volatile int ret;
    @Dimension
    public volatile int retryTimes;
    @Dimension
    public int roaming;
    public volatile long rspCbDispatch;
    public volatile long rspCbEnd;
    public volatile long rspCbStart;
    @Dimension
    public long sinceBgTime;
    @Dimension
    public long sinceInitTime;
    @Dimension
    public long sinceLastLaunchTime;
    public IFullTraceAnalysisV3.ISpan span;
    @Dimension
    public String speedBucket;
    @Deprecated
    public String traceId;
    @Dimension
    public String unit;
    @Dimension(name = "URL")
    public volatile String url;
    public String userInfo;
    @Dimension
    public String xqcConnEnv;
    @Dimension
    public volatile int ipRefer = 0;
    @Dimension
    public volatile int ipType = 1;
    @Dimension
    public volatile boolean isDNS = false;
    @Dimension(name = "errorCode")
    public volatile int statusCode = 0;
    @Dimension(name = "errorMsg")
    public volatile String msg = "";
    @Dimension
    public volatile String contentEncoding = null;
    @Dimension
    public volatile String contentType = null;
    @Dimension
    public volatile int degraded = 0;
    @Dimension
    public volatile StringBuilder errorTrace = null;
    @Dimension
    public double lng = 90000.0d;
    @Dimension
    public double lat = 90000.0d;
    @Dimension
    public float accuracy = -1.0f;
    @Dimension
    public JSONObject extra = null;
    @Dimension
    public int startType = 0;
    @Dimension
    public int isFromExternal = 0;
    @Dimension
    public int useMultiPath = 0;
    @Dimension
    public int multiPathOpened = 0;
    @Measure
    public volatile long reqHeadInflateSize = 0;
    @Measure
    public volatile long reqBodyInflateSize = 0;
    @Measure
    public volatile long reqHeadDeflateSize = 0;
    @Measure
    public volatile long reqBodyDeflateSize = 0;
    @Measure
    public volatile long rspHeadDeflateSize = 0;
    @Measure
    public volatile long rspBodyDeflateSize = 0;
    @Measure
    public volatile long rspHeadInflateSize = 0;
    @Measure
    public volatile long rspBodyInflateSize = 0;
    @Measure
    public volatile long retryCostTime = 0;
    @Measure
    public volatile long connWaitTime = 0;
    @Measure
    public volatile long sendBeforeTime = 0;
    @Measure
    public volatile long processTime = 0;
    @Measure
    public volatile long sendDataTime = 0;
    @Measure
    public volatile long firstDataTime = 0;
    @Measure
    public volatile long recDataTime = 0;
    @Measure
    public volatile long serverRT = 0;
    @Measure
    public volatile long cacheTime = 0;
    @Measure
    public volatile long lastProcessTime = 0;
    @Measure
    public volatile long callbackTime = 0;
    @Measure(max = 60000.0d)
    public volatile long oneWayTime = 0;
    @Measure
    public volatile long sendDataSize = 0;
    @Measure
    public volatile long recDataSize = 0;
    @Deprecated
    public volatile long waitingTime = 0;
    @Measure
    public volatile long serializeTransferTime = 0;
    @Measure
    public volatile long lastRecvDataTime = 0;
    public final AtomicBoolean isDone = new AtomicBoolean(false);
    public volatile boolean spdyRequestSend = false;
    public volatile long start = 0;
    public volatile long reqStart = 0;
    public volatile long sendStart = 0;
    public volatile long sendEnd = 0;
    public volatile long rspStart = 0;
    public volatile long rspEnd = 0;
    public volatile long contentLength = 0;
    public volatile int tnetErrorCode = 0;

    public RequestStatistic(String str, String str2) {
        this.proxyType = "";
        this.netType = "";
        this.bssid = null;
        this.isBg = "";
        this.roaming = 0;
        this.mnc = "0";
        this.sinceBgTime = 0L;
        this.multiNetworkStatus = 0;
        this.isHarmonyOS = 0;
        this.host = str;
        this.proxyType = NetworkStatusHelper.f();
        this.isProxy = !this.proxyType.isEmpty();
        this.netType = NetworkStatusHelper.e();
        this.bssid = NetworkStatusHelper.k();
        this.isBg = hu0.i() ? "bg" : "fg";
        if ("bg".equals(this.isBg) && AppLifecycle.b > 0) {
            this.sinceBgTime = System.currentTimeMillis() - AppLifecycle.b;
        }
        this.roaming = NetworkStatusHelper.p() ? 1 : 0;
        this.mnc = NetworkStatusHelper.h();
        this.bizId = str2;
        this.ipStackType = Inet64Util.n();
        this.isHttpDetectEnable = C9708t9.v();
        this.multiNetworkStatus = NetworkStatusHelper.d() != null ? 1 : 0;
        if (C0241c.k()) {
            this.isHarmonyOS = 1;
            this.harmonyVersion = C0241c.d();
        }
        this.isComplexEnable = C9708t9.p();
        this.isStrategyUpgrade = C9708t9.N();
    }

    public void appendErrorTrace(String str) {
        if (this.errorTrace == null) {
            this.errorTrace = new StringBuilder();
        }
        if (this.errorTrace.length() != 0) {
            this.errorTrace.append(",");
        }
        StringBuilder sb = this.errorTrace;
        sb.append(str);
        sb.append("=");
        sb.append(System.currentTimeMillis() - this.reqStart);
    }

    @Override // anet.channel.statist.StatObject
    public boolean beforeCommit() {
        return this.statusCode != -200;
    }

    public void putExtra(String str, Object obj) {
        try {
            if (this.extra == null) {
                this.extra = new JSONObject();
            }
            this.extra.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void recordRedirect(int i, String str) {
        this.url = str;
        appendErrorTrace(String.valueOf(i));
        long currentTimeMillis = System.currentTimeMillis();
        this.retryCostTime += currentTimeMillis - this.start;
        this.start = currentTimeMillis;
    }

    public void setConnType(ConnType connType) {
        this.isSSL = connType.k();
        this.protocolType = connType.toString();
    }

    public void setIPAndPort(String str, int i) {
        this.ip = str;
        this.port = i;
        if (str != null) {
            this.isDNS = true;
        }
        if (this.retryTimes != 0 || str == null) {
            return;
        }
        putExtra("firstIp", str);
    }

    public void setIpInfo(int i, int i2) {
        this.ipRefer = i;
        this.ipType = i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("[RequestStatistic]ret=");
        sb.append(this.ret);
        sb.append(",statusCode=");
        sb.append(this.statusCode);
        sb.append(",msg=");
        sb.append(this.msg);
        sb.append(",bizId=");
        sb.append(this.bizId);
        sb.append(",bizReqId=");
        sb.append(this.bizReqId);
        sb.append(",host=");
        sb.append(this.host);
        sb.append(",ipRefer=");
        sb.append(this.ipRefer);
        sb.append(",ip=");
        sb.append(this.ip);
        sb.append(",port=");
        sb.append(this.port);
        sb.append(",protocolType=");
        sb.append(this.protocolType);
        sb.append(",retryTime=");
        sb.append(this.retryTimes);
        sb.append(",retryCostTime=");
        sb.append(this.retryCostTime);
        sb.append(",processTime=");
        sb.append(this.processTime);
        sb.append(",connWaitTime=");
        sb.append(this.connWaitTime);
        sb.append(",cacheTime=");
        sb.append(this.cacheTime);
        sb.append(",sendDataTime=");
        sb.append(this.sendDataTime);
        sb.append(",firstDataTime=");
        sb.append(this.firstDataTime);
        sb.append(",recDataTime=");
        sb.append(this.recDataTime);
        sb.append(",lastProcessTime=");
        sb.append(this.lastProcessTime);
        sb.append(",lastRecvDataTime=");
        sb.append(this.lastRecvDataTime);
        sb.append(",oneWayTime=");
        sb.append(this.oneWayTime);
        sb.append(",callbackTime=");
        sb.append(this.callbackTime);
        sb.append(",serverRT=");
        sb.append(this.serverRT);
        sb.append(",sendSize=");
        sb.append(this.sendDataSize);
        sb.append(",recDataSize=");
        sb.append(this.recDataSize);
        sb.append(",originalDataSize=");
        sb.append(this.rspBodyDeflateSize);
        if (this.extra != null) {
            sb.append(",extra=");
            sb.append(this.extra.toString());
        }
        if (this.retryTimes > 0) {
            sb.append(",firstProtocol=");
            sb.append(this.firstProtocol);
            sb.append(",firstErrorCode=");
            sb.append(this.firstErrorCode);
        }
        if (this.statusCode == -304) {
            sb.append(",tnetErrorCode=");
            sb.append(this.tnetErrorCode);
        }
        sb.append(",lastInterceptor=");
        sb.append(this.lastInterceptor);
        sb.append(",isReqSync=");
        sb.append(this.isReqSync);
        sb.append(",isReqMain=");
        sb.append(this.isReqMain);
        sb.append(",process=");
        sb.append(this.process);
        if (!TextUtils.isEmpty(this.speedBucket)) {
            sb.append(", speedBucket=");
            sb.append(this.speedBucket);
        }
        sb.append(",url=");
        sb.append(this.url);
        sb.append(",cid=");
        sb.append(this.cid);
        sb.append(",xqcConnEnv=");
        sb.append(this.xqcConnEnv);
        sb.append(",ipStackType=");
        sb.append(this.ipStackType);
        sb.append(",multiPathOpened=");
        sb.append(this.multiPathOpened);
        sb.append(",useMultiPath=");
        sb.append(this.useMultiPath);
        sb.append(",isHttpDetectEnable=");
        sb.append(this.isHttpDetectEnable);
        sb.append(",isHarmonyOS=");
        sb.append(this.isHarmonyOS);
        sb.append(",multiNetworkStatus=");
        sb.append(this.multiNetworkStatus);
        sb.append(",isComplex=");
        sb.append(this.isComplex);
        sb.append(",isComplexEnable=");
        sb.append(this.isComplexEnable);
        sb.append(",isFastDegrade=");
        sb.append(this.isFastDegrade);
        sb.append(",is0RttOptimize=");
        sb.append(this.is0RttOptimize);
        sb.append(",isIpv4Degrade=");
        sb.append(this.isIpv4Degrade);
        sb.append(",isStrategyUpgrade=");
        sb.append(this.isStrategyUpgrade);
        return sb.toString();
    }
}
