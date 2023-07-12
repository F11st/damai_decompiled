package mtopsdk.mtop.util;

import android.text.TextUtils;
import anet.channel.fulltrace.IFullTraceAnalysisV3;
import anetwork.channel.statist.StatisticData;
import com.taobao.analysis.abtest.ABTestCenter;
import com.taobao.analysis.fulltrace.FullTraceAnalysis;
import com.taobao.analysis.fulltrace.RequestInfo;
import com.taobao.analysis.scene.SceneIdentifier;
import com.taobao.phenix.request.ImageStatistics;
import com.taobao.tao.remotebusiness.js.MtopJSBridge;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.RemoteConfig;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.common.MtopStatsListener;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.stat.IUploadStats;
import mtopsdk.network.domain.NetworkStats;
import tb.hh1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MtopStatistics implements Cloneable {
    private static final String MTOP_BX_ACTION_POINT = "baxiaAction";
    private static final String MTOP_EXCEPTIONS_MONITOR_POINT = "mtopExceptions";
    private static final String MTOP_STATS_MODULE = "mtopsdk";
    private static final String MTOP_STATS_MONITOR_POINT = "mtopStats";
    private static final String TAG = "mtopsdk.MtopStatistics";
    private static volatile AtomicBoolean isRegistered = new AtomicBoolean(false);
    public long allTime;
    public String apiKey;
    public boolean backGround;
    @Deprecated
    public int bizId;
    public String bizIdStr;
    public long bizReqProcessStart;
    public long bizReqStart;
    public long bizRspProcessStart;
    public long buildParams2NetworkTime;
    public long buildParamsEndTime;
    public long buildParamsStartTime;
    public long buildParamsTime;
    public int bxMainAction;
    public int bxRetry;
    public String bxSessionId;
    public long bxSleep;
    public long bxSubAction;
    public boolean bxUI;
    public long cacheCostTime;
    public int cacheHitType;
    public long cacheResponseParseEndTime;
    public long cacheResponseParseStartTime;
    public long cacheResponseParseTime;
    public long cacheReturnTime;
    public int cacheSwitch;
    public long callbackPocTime;
    public String clientTraceId;
    public boolean commitStat;
    public long computeMiniWuaTime;
    public long computeSignTime;
    public long computeWuaTime;
    public String domain;
    public String eagleEyeTraceId;
    protected long endTime;
    public long fcProcessCallbackTime;
    public long fcProcessCheckEndTime;
    public long fcProcessCheckStartTime;
    public long fcProcessStartTime;
    public String fullTraceId;
    public boolean handler;
    public int intSeqNo;
    public boolean isMain;
    public boolean isNoNetwork;
    public boolean isPrefetch;
    public boolean isReqMain;
    public boolean isReqSync;
    public String mappingCode;
    private MtopStatsListener mtopStatsListener;
    public long netSendEndTime;
    public long netSendStartTime;
    public NetworkStats netStats;
    public long netTotalTime;
    public String pageName;
    public String pageUrl;
    private RbStatisticData rbStatData;
    public int reqSource;
    public long requestPocTime;
    public String retCode;
    public int retType;
    public long rspCbDispatch;
    public long rspCbEnd;
    public long rspCbStart;
    public final String seqNo;
    public String serverTraceId;
    public long startCallBack2EndTime;
    public long startCallbackTime;
    public long startExecuteTime;
    public long startTime;
    protected String statSum;
    public int statusCode;
    public long totalTime;
    private IUploadStats uploadStats;
    public String url;
    public long waitCallbackTime;
    public long waitExecute2BuildParamTime;
    public long waitExecuteTime;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class RbStatisticData implements Cloneable {
        public long afterReqTime;
        public long beforeReqTime;
        public long bizCallbackTime;
        public int isCache;
        public long jsonParseTime;
        @Deprecated
        public long jsonTime;
        public long mtopDispatchTime;
        public long mtopReqTime;
        public long parseTime;
        public long rbReqTime;
        public long toMainThTime;
        @Deprecated
        public long totalTime;

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public String getStatSum() {
            StringBuilder sb = new StringBuilder(32);
            sb.append("rbReqTime=");
            sb.append(this.rbReqTime);
            sb.append(",mtopReqTime=");
            sb.append(this.mtopReqTime);
            sb.append(",mtopJsonParseTime=");
            sb.append(this.jsonParseTime);
            sb.append(",toMainThTime=");
            sb.append(this.toMainThTime);
            sb.append(",mtopDispatchTime=");
            sb.append(this.mtopDispatchTime);
            sb.append(",bizCallbackTime=");
            sb.append(this.bizCallbackTime);
            sb.append(",isCache=");
            sb.append(this.isCache);
            return sb.toString();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("rbReqTime=");
            sb.append(this.rbReqTime);
            sb.append(",mtopReqTime=");
            sb.append(this.mtopReqTime);
            sb.append(",mtopJsonParseTime=");
            sb.append(this.jsonParseTime);
            sb.append(",toMainThTime=");
            sb.append(this.toMainThTime);
            sb.append(",mtopDispatchTime=");
            sb.append(this.mtopDispatchTime);
            sb.append(",bizCallbackTime=");
            sb.append(this.bizCallbackTime);
            sb.append(",isCache=");
            sb.append(this.isCache);
            sb.append(",beforeReqTime=");
            sb.append(this.beforeReqTime);
            sb.append(",afterReqTime=");
            sb.append(this.afterReqTime);
            sb.append(",parseTime=");
            sb.append(this.parseTime);
            return sb.toString();
        }

        private RbStatisticData() {
            this.isCache = 0;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface RetType {
        public static final int BIZ_ERROR = 3;
        public static final int NETWORK_ERROR = 1;
        public static final int SUCCESS = 0;
        public static final int SYSTEM_ERROR = 2;

        /* compiled from: Taobao */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes11.dex */
        public @interface Definition {
        }
    }

    public MtopStatistics(IUploadStats iUploadStats, MtopStatsListener mtopStatsListener) {
        this.commitStat = true;
        this.cacheHitType = 0;
        this.retType = 0;
        this.statSum = "";
        this.apiKey = "";
        this.isMain = true;
        this.bxSessionId = "";
        this.bxUI = false;
        this.bxRetry = 0;
        this.bxSleep = -1L;
        this.isPrefetch = false;
        this.uploadStats = iUploadStats;
        this.mtopStatsListener = mtopStatsListener;
        this.intSeqNo = MtopUtils.createIntSeqNo();
        this.seqNo = "MTOP" + this.intSeqNo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCommitStatsTask() {
        boolean z;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        if (this.uploadStats == null) {
            return;
        }
        if (isRegistered.compareAndSet(false, true)) {
            registerMtopStats();
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("api", this.apiKey);
            hashMap.put("ret", this.retCode);
            hashMap.put("retType", String.valueOf(this.retType));
            hashMap.put("httpResponseStatus", String.valueOf(this.statusCode));
            hashMap.put("domain", this.domain);
            hashMap.put("reqSource", String.valueOf(this.reqSource));
            hashMap.put("cacheSwitch", String.valueOf(this.cacheSwitch));
            hashMap.put("cacheHitType", String.valueOf(this.cacheHitType));
            hashMap.put("clientTraceId", this.clientTraceId);
            hashMap.put("serverTraceId", this.serverTraceId);
            hashMap.put("pageName", this.pageName);
            hashMap.put(MtopJSBridge.MtopJSParam.PAGE_URL, this.pageUrl);
            hashMap.put("backGround", String.valueOf(this.backGround ? 1 : 0));
            hashMap.put("isMain", String.valueOf(this.isMain ? 1 : 0));
            hashMap.put("securityFeature", String.valueOf(RemoteConfig.getInstance().useSecurityAdapter));
            hashMap.put("isPrefetch", String.valueOf(this.isPrefetch ? 1 : 0));
            hashMap.put("handler", String.valueOf(this.handler ? 1 : 0));
            NetworkStats networkStats = getNetworkStats();
            if (networkStats != null) {
                obj = "1";
                obj2 = "isMain";
                hashMap.put("connType", networkStats.connectionType);
                hashMap.put("isSSL", networkStats.isSSL ? obj : "0");
                hashMap.put("retryTimes", String.valueOf(networkStats.retryTimes));
                hashMap.put("ip_port", networkStats.ip_port);
            } else {
                obj = "1";
                obj2 = "isMain";
            }
            if (Mtop.mIsFullTrackValid) {
                obj3 = "backGround";
                hashMap.put("launchType", String.valueOf(SceneIdentifier.getStartType()));
                hashMap.put("appLaunchExternal", SceneIdentifier.isUrlLaunch() ? obj : "0");
                obj4 = MtopJSBridge.MtopJSParam.PAGE_URL;
                hashMap.put("sinceAppLaunchInterval", String.valueOf(this.bizReqStart - SceneIdentifier.getAppLaunchTime()));
                hashMap.put("deviceLevel", String.valueOf(SceneIdentifier.getDeviceLevel()));
                if (SceneIdentifier.getStartType() != 1) {
                    hashMap.put("sinceLastLaunchInternal", String.valueOf((int) (SceneIdentifier.getAppLaunchTime() - SceneIdentifier.getLastLaunchTime())));
                }
                String tBSpeedBucket = ABTestCenter.getTBSpeedBucket();
                if (TextUtils.isEmpty(tBSpeedBucket)) {
                    tBSpeedBucket = "0";
                }
                hashMap.put("speedBucket", tBSpeedBucket);
                String uTABTestBucketId = ABTestCenter.getUTABTestBucketId(MTOP_STATS_MODULE);
                if (TextUtils.isEmpty(uTABTestBucketId)) {
                    uTABTestBucketId = "0";
                }
                hashMap.put("speedBucketId", uTABTestBucketId);
            } else {
                obj3 = "backGround";
                obj4 = MtopJSBridge.MtopJSParam.PAGE_URL;
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put(ImageStatistics.KEY_TOTAL_TIME, Double.valueOf(this.totalTime));
            hashMap2.put("networkExeTime", Double.valueOf(this.netTotalTime));
            hashMap2.put("cacheCostTime", Double.valueOf(this.cacheCostTime));
            hashMap2.put("cacheResponseParseTime", Double.valueOf(this.cacheResponseParseTime));
            hashMap2.put("waitExecuteTime", Double.valueOf(this.waitExecuteTime));
            hashMap2.put("waitCallbackTime", Double.valueOf(this.waitCallbackTime));
            hashMap2.put("waitExecute2BuildParamTime", Double.valueOf(this.waitExecute2BuildParamTime));
            hashMap2.put("buildParamsTime", Double.valueOf(this.buildParamsTime));
            hashMap2.put("buildParams2NetworkTime", Double.valueOf(this.buildParams2NetworkTime));
            hashMap2.put("startCallBack2EndTime", Double.valueOf(this.startCallBack2EndTime));
            hashMap2.put("signTime", Double.valueOf(this.computeSignTime));
            hashMap2.put("wuaTime", Double.valueOf(this.computeWuaTime));
            hashMap2.put("miniWuaTime", Double.valueOf(this.computeMiniWuaTime));
            hashMap2.put("callbackPocTime", Double.valueOf(this.callbackPocTime));
            hashMap2.put("allTime", Double.valueOf(this.allTime));
            hashMap2.put("requestPocTime", Double.valueOf(this.requestPocTime));
            if (networkStats != null) {
                hashMap2.put("processTime", Double.valueOf(networkStats.processTime));
                obj5 = "serverTraceId";
                hashMap2.put("firstDataTime", Double.valueOf(networkStats.firstDataTime));
                hashMap2.put("recDataTime", Double.valueOf(networkStats.recDataTime));
                hashMap2.put("oneWayTime_ANet", Double.valueOf(networkStats.oneWayTime_ANet));
                hashMap2.put(IFullTraceAnalysisV3.Stage.SERVE_RT, Double.valueOf(networkStats.serverRT));
                hashMap2.put("revSize", Double.valueOf(networkStats.recvSize));
                hashMap2.put("dataSpeed", Double.valueOf(networkStats.dataSpeed));
            } else {
                obj5 = "serverTraceId";
            }
            RbStatisticData rbStatisticData = this.rbStatData;
            if (rbStatisticData != null) {
                hashMap2.put("rbReqTime", Double.valueOf(rbStatisticData.rbReqTime));
                hashMap2.put("toMainThTime", Double.valueOf(this.rbStatData.toMainThTime));
                hashMap2.put("mtopDispatchTime", Double.valueOf(this.rbStatData.mtopDispatchTime));
                hashMap2.put("bizCallbackTime", Double.valueOf(this.rbStatData.bizCallbackTime));
                hashMap2.put("mtopJsonParseTime", Double.valueOf(this.rbStatData.jsonParseTime));
                hashMap2.put("mtopReqTime", Double.valueOf(this.rbStatData.mtopReqTime));
            }
            IUploadStats iUploadStats = this.uploadStats;
            if (iUploadStats != null) {
                iUploadStats.onCommit(MTOP_STATS_MODULE, MTOP_STATS_MONITOR_POINT, hashMap, hashMap2);
            }
            if (!ErrorConstant.isSuccess(this.retCode)) {
                HashMap hashMap3 = new HashMap();
                hashMap3.put("api", this.apiKey);
                hashMap3.put("ret", this.retCode);
                hashMap3.put("retType", String.valueOf(this.retType));
                hashMap3.put("reqSource", String.valueOf(this.reqSource));
                hashMap3.put("mappingCode", this.mappingCode);
                hashMap3.put("httpResponseStatus", String.valueOf(this.statusCode));
                hashMap3.put("domain", this.domain);
                hashMap3.put("refer", this.pageUrl);
                hashMap3.put("clientTraceId", this.clientTraceId);
                hashMap3.put(obj5, this.serverTraceId);
                hashMap3.put("pageName", this.pageName);
                hashMap3.put(obj4, this.pageUrl);
                hashMap3.put(obj3, String.valueOf(this.backGround ? 1 : 0));
                hashMap3.put(obj2, String.valueOf(this.isMain ? 1 : 0));
                hashMap3.put("securityFeature", String.valueOf(RemoteConfig.getInstance().useSecurityAdapter));
                hashMap3.put("isPrefetch", String.valueOf(this.isPrefetch ? 1 : 0));
                IUploadStats iUploadStats2 = this.uploadStats;
                if (iUploadStats2 != null) {
                    iUploadStats2.onCommit(MTOP_STATS_MODULE, MTOP_EXCEPTIONS_MONITOR_POINT, hashMap3, null);
                }
                if (this.retType != 0 && this.mtopStatsListener != null) {
                    hashMap3.put("seqNo", this.seqNo);
                    try {
                        this.mtopStatsListener.onStats(hashMap3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            HashMap hashMap4 = new HashMap();
            hashMap4.put(hh1.DIMEN_BIZ, !TextUtils.isEmpty(this.bizIdStr) ? this.bizIdStr : String.valueOf(this.bizId));
            hashMap4.put("api", this.apiKey);
            hashMap4.put("version", this.apiKey);
            hashMap4.put("domain", this.domain);
            hashMap4.put("httpResponseStatus", String.valueOf(this.statusCode));
            hashMap4.put("ret", this.retCode);
            hashMap4.put("bxSessionId", this.bxSessionId);
            hashMap4.put("bxUI", String.valueOf(this.bxUI));
            hashMap4.put("bxMainAction", String.valueOf(this.bxMainAction));
            hashMap4.put("bxSubAction", String.valueOf(this.bxSubAction));
            hashMap4.put("bxRetry", String.valueOf(this.bxRetry));
            HashMap hashMap5 = new HashMap();
            hashMap5.put("bxSleep", Double.valueOf(this.bxSleep));
            hashMap5.put("checkTime", Double.valueOf(this.fcProcessCheckEndTime - this.fcProcessCheckStartTime));
            hashMap5.put("processTime", Double.valueOf(this.fcProcessCallbackTime - this.fcProcessStartTime));
            IUploadStats iUploadStats3 = this.uploadStats;
            if (iUploadStats3 != null) {
                iUploadStats3.onCommit(MTOP_STATS_MODULE, MTOP_BX_ACTION_POINT, hashMap4, hashMap5);
            }
            z = false;
        } catch (Throwable th) {
            try {
                String str = this.seqNo;
                TBSdkLog.e(TAG, str, "[commitStatData] commit mtopStats error ---" + th.toString());
                z = false;
            } catch (Throwable th2) {
                this.commitStat = false;
                throw th2;
            }
        }
        this.commitStat = z;
    }

    private void registerMtopStats() {
        String str;
        String str2;
        String str3;
        try {
            if (this.uploadStats == null) {
                TBSdkLog.e(TAG, this.seqNo, "[registerMtopStats]register MtopStats error, uploadStats=null");
                return;
            }
            HashSet hashSet = new HashSet();
            hashSet.add("api");
            hashSet.add("domain");
            hashSet.add("httpResponseStatus");
            hashSet.add("ret");
            hashSet.add("retType");
            hashSet.add("reqSource");
            try {
                hashSet.add("cacheSwitch");
                hashSet.add("cacheHitType");
                hashSet.add("clientTraceId");
                hashSet.add("serverTraceId");
                hashSet.add("connType");
                hashSet.add("isSSL");
                hashSet.add("retryTimes");
                hashSet.add("ip_port");
                hashSet.add("pageName");
                hashSet.add(MtopJSBridge.MtopJSParam.PAGE_URL);
                hashSet.add("backGround");
                hashSet.add("isMain");
                hashSet.add("isPrefetch");
                hashSet.add("handler");
                hashSet.add("launchType");
                hashSet.add("appLaunchExternal");
                hashSet.add("sinceAppLaunchInterval");
                hashSet.add("deviceLevel");
                hashSet.add("sinceLastLaunchInternal");
                hashSet.add("securityFeature");
                hashSet.add("speedBucket");
                hashSet.add("speedBucketId");
                HashSet hashSet2 = new HashSet();
                hashSet2.add(ImageStatistics.KEY_TOTAL_TIME);
                hashSet2.add("waitExecuteTime");
                hashSet2.add("waitExecute2BuildParamTime");
                hashSet2.add("buildParamsTime");
                hashSet2.add("buildParams2NetworkTime");
                hashSet2.add("networkExeTime");
                hashSet2.add("waitCallbackTime");
                hashSet2.add("startCallBack2EndTime");
                hashSet2.add("cacheCostTime");
                hashSet2.add("cacheResponseParseTime");
                hashSet2.add("signTime");
                hashSet2.add("wuaTime");
                hashSet2.add("miniWuaTime");
                hashSet2.add("requestPocTime");
                hashSet2.add("callbackPocTime");
                hashSet2.add("allTime");
                hashSet2.add("rbReqTime");
                hashSet2.add("toMainThTime");
                hashSet2.add("mtopDispatchTime");
                hashSet2.add("bizCallbackTime");
                hashSet2.add("mtopJsonParseTime");
                hashSet2.add("mtopReqTime");
                hashSet2.add("processTime");
                hashSet2.add("firstDataTime");
                hashSet2.add("recDataTime");
                hashSet2.add("revSize");
                hashSet2.add("dataSpeed");
                hashSet2.add("oneWayTime_ANet");
                hashSet2.add(IFullTraceAnalysisV3.Stage.SERVE_RT);
                IUploadStats iUploadStats = this.uploadStats;
                if (iUploadStats != null) {
                    iUploadStats.onRegister(MTOP_STATS_MODULE, MTOP_STATS_MONITOR_POINT, hashSet, hashSet2, false);
                }
                HashSet hashSet3 = new HashSet();
                hashSet3.add("api");
                hashSet3.add("domain");
                hashSet3.add("ret");
                hashSet3.add("retType");
                hashSet3.add("reqSource");
                hashSet3.add("mappingCode");
                hashSet3.add("httpResponseStatus");
                hashSet3.add("refer");
                hashSet3.add("clientTraceId");
                hashSet3.add("serverTraceId");
                hashSet3.add("pageName");
                hashSet3.add(MtopJSBridge.MtopJSParam.PAGE_URL);
                hashSet3.add("backGround");
                hashSet3.add("securityFeature");
                IUploadStats iUploadStats2 = this.uploadStats;
                if (iUploadStats2 != null) {
                    iUploadStats2.onRegister(MTOP_STATS_MODULE, MTOP_EXCEPTIONS_MONITOR_POINT, hashSet3, null, false);
                }
                HashSet hashSet4 = new HashSet();
                hashSet4.add(hh1.DIMEN_BIZ);
                hashSet4.add("api");
                hashSet4.add("version");
                hashSet4.add("domain");
                hashSet4.add("httpResponseStatus");
                hashSet4.add("ret");
                hashSet4.add("bxSessionId");
                hashSet4.add("bxUI");
                hashSet4.add("bxMainAction");
                hashSet4.add("bxSubAction");
                hashSet4.add("bxRetry");
                HashSet hashSet5 = new HashSet();
                hashSet5.add("bxSleep");
                hashSet5.add("checkTime");
                hashSet5.add("processTime");
                IUploadStats iUploadStats3 = this.uploadStats;
                if (iUploadStats3 != null) {
                    iUploadStats3.onRegister(MTOP_STATS_MODULE, MTOP_BX_ACTION_POINT, hashSet4, hashSet5, false);
                }
                str2 = this.seqNo;
                str3 = "[registerMtopStats]register MtopStats executed.uploadStats=" + this.uploadStats;
                str = TAG;
            } catch (Throwable th) {
                th = th;
                str = TAG;
            }
            try {
                TBSdkLog.i(str, str2, str3);
            } catch (Throwable th2) {
                th = th2;
                TBSdkLog.e(str, this.seqNo, "[registerMtopStats] register MtopStats error ---" + th.toString());
            }
        } catch (Throwable th3) {
            th = th3;
            str = TAG;
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void commitFullTrace() {
        if (Mtop.mIsFullTrackValid) {
            formatEndLog();
            try {
                RequestInfo requestInfo = new RequestInfo();
                requestInfo.url = this.url;
                if (this.statusCode == -8) {
                    requestInfo.ret = 2;
                } else {
                    requestInfo.ret = this.retType == 0 ? 1 : 0;
                }
                requestInfo.bizId = !TextUtils.isEmpty(this.bizIdStr) ? this.bizIdStr : String.valueOf(this.bizId);
                requestInfo.bizReqStart = this.bizReqStart;
                requestInfo.bizReqProcessStart = this.bizReqProcessStart;
                requestInfo.bizRspProcessStart = this.bizRspProcessStart;
                requestInfo.bizRspCbDispatch = this.rspCbDispatch;
                requestInfo.bizRspCbStart = this.rspCbStart;
                requestInfo.bizRspCbEnd = this.rspCbEnd;
                requestInfo.serverTraceId = this.eagleEyeTraceId;
                requestInfo.isCbMain = this.isMain;
                requestInfo.isReqMain = this.isReqMain;
                requestInfo.isReqSync = this.isReqSync;
                if (this.cacheHitType == 1) {
                    requestInfo.protocolType = "cache";
                }
                if (getRbStatData() != null) {
                    requestInfo.deserializeTime = getRbStatData().jsonParseTime;
                }
                FullTraceAnalysis.getInstance().commitRequest(this.fullTraceId, "mtop", requestInfo);
            } catch (Throwable unused) {
                TBSdkLog.e(MTOP_STATS_MODULE, this.seqNo, "FullTrack sdk version not compatible");
            }
        }
    }

    public void commitStatData(boolean z) {
        this.commitStat = z;
        if (!z || this.isNoNetwork) {
            return;
        }
        if (MtopUtils.isMainThread()) {
            MtopSDKThreadPoolExecutorFactory.submit(new Runnable() { // from class: mtopsdk.mtop.util.MtopStatistics.2
                @Override // java.lang.Runnable
                public void run() {
                    MtopStatistics.this.doCommitStatsTask();
                }
            });
        } else {
            doCommitStatsTask();
        }
    }

    public long currentTimeMillis() {
        return System.nanoTime() / 1000000;
    }

    public void formatEndLog() {
        if (this.seqNo == null) {
            return;
        }
        TBSdkLog.e(MTOP_STATS_MODULE, this.seqNo, "[traceId:" + this.fullTraceId + "] |MtopStatistics," + this.statSum);
    }

    public void formatStartLog() {
        if (this.seqNo == null) {
            return;
        }
        TBSdkLog.e(MTOP_STATS_MODULE, this.seqNo, "[traceId:" + this.fullTraceId + "] |start");
    }

    @Deprecated
    public StatisticData getNetStat() {
        if (this.netStats != null) {
            StatisticData statisticData = new StatisticData();
            NetworkStats networkStats = this.netStats;
            statisticData.isRequestSuccess = networkStats.isRequestSuccess;
            statisticData.connectionType = networkStats.connectionType;
            statisticData.oneWayTime_ANet = networkStats.oneWayTime_ANet;
            statisticData.serverRT = networkStats.serverRT;
            statisticData.totalSize = networkStats.recvSize;
            return statisticData;
        }
        return null;
    }

    public NetworkStats getNetworkStats() {
        return this.netStats;
    }

    public synchronized RbStatisticData getRbStatData() {
        if (this.rbStatData == null) {
            this.rbStatData = new RbStatisticData();
        }
        return this.rbStatData;
    }

    public String getStatSum() {
        if (this.rbStatData != null) {
            if ("".equals(this.statSum)) {
                return this.rbStatData.getStatSum();
            }
            return this.statSum + "," + this.rbStatData.getStatSum();
        }
        return this.statSum;
    }

    public long getTotalTime() {
        return this.totalTime;
    }

    public String launchInfoValue() {
        if (Mtop.mIsFullTrackValid) {
            StringBuilder sb = new StringBuilder();
            sb.append(SceneIdentifier.getStartType());
            sb.append(",");
            sb.append(SceneIdentifier.isUrlLaunch() ? "1" : "0");
            sb.append(",");
            sb.append(this.bizReqStart);
            sb.append(",");
            sb.append(SceneIdentifier.getAppLaunchTime());
            sb.append(",");
            sb.append(SceneIdentifier.getDeviceLevel());
            return sb.toString();
        }
        return "";
    }

    public void onEndAndCommit() {
        long currentTimeMillis = currentTimeMillis();
        this.endTime = currentTimeMillis;
        long j = this.startTime;
        this.totalTime = currentTimeMillis - j;
        long j2 = this.startExecuteTime;
        this.waitExecuteTime = j2 > j ? j2 - j : 0L;
        long j3 = this.cacheReturnTime;
        this.cacheCostTime = j3 > 0 ? j3 - j : 0L;
        this.cacheResponseParseTime = this.cacheResponseParseEndTime - this.cacheResponseParseStartTime;
        if (this.netSendEndTime == 0) {
            this.netSendEndTime = currentTimeMillis();
        }
        long j4 = this.netSendEndTime;
        long j5 = this.netSendStartTime;
        this.netTotalTime = j4 - j5;
        long j6 = this.startCallbackTime;
        this.waitCallbackTime = j6 > j4 ? j6 - j4 : 0L;
        this.waitExecute2BuildParamTime = this.buildParamsStartTime - this.startExecuteTime;
        this.buildParams2NetworkTime = j5 - this.buildParamsEndTime;
        this.startCallBack2EndTime = this.endTime - j6;
        this.requestPocTime = j5 - this.startTime;
        StringBuilder sb = new StringBuilder(128);
        sb.append("apiKey=");
        sb.append(this.apiKey);
        sb.append(",httpResponseStatus=");
        sb.append(this.statusCode);
        sb.append(",retCode=");
        sb.append(this.retCode);
        sb.append(",retType=");
        sb.append(this.retType);
        sb.append(",reqSource=");
        sb.append(this.reqSource);
        sb.append(",mappingCode=");
        sb.append(this.mappingCode);
        sb.append(",isCbMain=");
        sb.append(this.isMain);
        sb.append(",isReqMain=");
        sb.append(this.isReqMain);
        sb.append(",isReqSync=");
        sb.append(this.isReqSync);
        sb.append(",mtopTotalTime=");
        sb.append(this.totalTime);
        sb.append(",waitExecuteTime=");
        sb.append(this.waitExecuteTime);
        sb.append(",waitExecute2BuildParamTime=");
        sb.append(this.waitExecute2BuildParamTime);
        sb.append(",buildParamsTime=");
        sb.append(this.buildParamsTime);
        sb.append(",buildParams2NetworkTime=");
        sb.append(this.buildParams2NetworkTime);
        sb.append(",networkTotalTime=");
        sb.append(this.netTotalTime);
        sb.append(",waitCallbackTime=");
        sb.append(this.waitCallbackTime);
        sb.append(",startCallBack2EndTime=");
        sb.append(this.startCallBack2EndTime);
        sb.append(",computeSignTime=");
        sb.append(this.computeSignTime);
        sb.append(",computeMiniWuaTime=");
        sb.append(this.computeMiniWuaTime);
        sb.append(",computeWuaTime=");
        sb.append(this.computeWuaTime);
        sb.append(",cacheSwitch=");
        sb.append(this.cacheSwitch);
        sb.append(",cacheHitType=");
        sb.append(this.cacheHitType);
        sb.append(",cacheCostTime=");
        sb.append(this.cacheCostTime);
        sb.append(",cacheResponseParseTime=");
        sb.append(this.cacheResponseParseTime);
        sb.append(",useSecurityAdapter=");
        sb.append(SwitchConfig.getInstance().getUseSecurityAdapter());
        sb.append(",isPrefetch=");
        sb.append(this.isPrefetch);
        if (this.netStats != null) {
            sb.append(",");
            if (StringUtils.isBlank(this.netStats.netStatSum)) {
                sb.append(this.netStats.sumNetStat());
            } else {
                sb.append(this.netStats.netStatSum);
            }
        }
        this.statSum = sb.toString();
        if (this.commitStat && !this.isNoNetwork) {
            if (MtopUtils.isMainThread()) {
                MtopSDKThreadPoolExecutorFactory.submit(new Runnable() { // from class: mtopsdk.mtop.util.MtopStatistics.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MtopStatistics.this.doCommitStatsTask();
                    }
                });
            } else {
                doCommitStatsTask();
            }
        }
        TBSdkLog.logTraceId(this.clientTraceId, this.serverTraceId);
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, this.seqNo, toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("MtopStatistics ");
        sb.append(hashCode());
        sb.append("[SumStat(ms)]:");
        sb.append(this.statSum);
        if (this.rbStatData != null) {
            sb.append(" [rbStatData]:");
            sb.append(this.rbStatData);
        }
        return sb.toString();
    }

    public MtopStatistics(IUploadStats iUploadStats, MtopStatsListener mtopStatsListener, MtopNetworkProp mtopNetworkProp) {
        this(iUploadStats, mtopStatsListener);
        if (mtopNetworkProp != null) {
            this.pageName = mtopNetworkProp.pageName;
            this.pageUrl = MtopUtils.convertUrl(mtopNetworkProp.pageUrl);
            this.backGround = mtopNetworkProp.backGround;
        }
    }
}
