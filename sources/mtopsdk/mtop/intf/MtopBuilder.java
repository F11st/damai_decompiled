package mtopsdk.mtop.intf;

import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.taobao.analysis.fulltrace.FullTraceAnalysis;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.manager.FilterManager;
import mtopsdk.framework.util.FilterUtils;
import mtopsdk.mtop.common.ApiID;
import mtopsdk.mtop.common.DefaultMtopCallback;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.common.listener.MtopBaseListenerProxy;
import mtopsdk.mtop.common.listener.MtopCacheListenerProxy;
import mtopsdk.mtop.domain.ApiTypeEnum;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.JsonTypeEnum;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.domain.ProtocolEnum;
import mtopsdk.mtop.intf.MtopPrefetch;
import mtopsdk.mtop.stat.PrefetchStatistics;
import mtopsdk.mtop.util.ErrorConstant;
import mtopsdk.mtop.util.MtopConvert;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.mtop.util.MtopStatistics;
import mtopsdk.xstate.XState;
import mtopsdk.xstate.util.XStateConstants;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MtopBuilder {
    private static final String TAG = "mtopsdk.MtopBuilder";
    public MtopListener listener;
    protected MtopContext mtopContext;
    protected Mtop mtopInstance;
    protected MtopPrefetch mtopPrefetch;
    public final MtopNetworkProp mtopProp;
    public MtopRequest request;
    @Deprecated
    public Object requestContext;
    protected MtopStatistics stat;

    public MtopBuilder(Mtop mtop, IMTOPDataObject iMTOPDataObject, String str) {
        this(mtop, MtopConvert.inputDoToMtopRequest(iMTOPDataObject), str);
    }

    private ApiID asyncRequest(MtopListener mtopListener) {
        MtopStatistics mtopStatistics = this.stat;
        mtopStatistics.startTime = mtopStatistics.currentTimeMillis();
        final MtopContext createMtopContext = createMtopContext(mtopListener);
        createMtopContext.stats.bizReqStart = System.currentTimeMillis();
        this.mtopContext = createMtopContext;
        createMtopContext.apiId = new ApiID(null, createMtopContext);
        try {
            if (Mtop.mIsFullTrackValid) {
                String createRequest = FullTraceAnalysis.getInstance().createRequest("mtop");
                if (!TextUtils.isEmpty(createRequest)) {
                    createMtopContext.stats.fullTraceId = createRequest;
                    if (!TextUtils.isEmpty(this.mtopProp.bizIdStr)) {
                        createMtopContext.stats.bizIdStr = this.mtopProp.bizIdStr;
                    } else {
                        createMtopContext.stats.bizId = this.mtopProp.bizId;
                    }
                    createMtopContext.stats.isReqMain = MtopUtils.isMainThread();
                    createMtopContext.stats.formatStartLog();
                }
            }
            if (!MtopUtils.isMainThread() && this.mtopInstance.isInited()) {
                createMtopContext.stats.startExecuteTime = this.stat.currentTimeMillis();
                createMtopContext.stats.bizReqProcessStart = System.currentTimeMillis();
                FilterManager filterManager = this.mtopInstance.getMtopConfig().filterManager;
                if (filterManager != null) {
                    filterManager.start(null, createMtopContext);
                }
                FilterUtils.checkFilterManager(filterManager, createMtopContext);
                return createMtopContext.apiId;
            }
            MtopSDKThreadPoolExecutorFactory.getRequestThreadPoolExecutor().submit(new Runnable() { // from class: mtopsdk.mtop.intf.MtopBuilder.1
                @Override // java.lang.Runnable
                public void run() {
                    createMtopContext.stats.bizReqProcessStart = System.currentTimeMillis();
                    createMtopContext.stats.startExecuteTime = MtopBuilder.this.stat.currentTimeMillis();
                    MtopBuilder.this.mtopInstance.checkMtopSDKInit();
                    FilterManager filterManager2 = MtopBuilder.this.mtopInstance.getMtopConfig().filterManager;
                    if (filterManager2 != null) {
                        filterManager2.start(null, createMtopContext);
                    }
                    FilterUtils.checkFilterManager(filterManager2, createMtopContext);
                }
            });
            return createMtopContext.apiId;
        } catch (Throwable unused) {
            return createMtopContext.apiId;
        }
    }

    private MtopBaseListenerProxy createListenerProxy(MtopListener mtopListener) {
        MtopBaseListenerProxy mtopBaseListenerProxy;
        if (mtopListener == null) {
            return new MtopBaseListenerProxy(new DefaultMtopCallback());
        }
        if (mtopListener instanceof MtopCallback.MtopCacheListener) {
            mtopBaseListenerProxy = new MtopCacheListenerProxy(mtopListener);
        } else {
            mtopBaseListenerProxy = new MtopBaseListenerProxy(mtopListener);
        }
        return mtopBaseListenerProxy;
    }

    public MtopBuilder addCacheKeyParamBlackList(List<String> list) {
        if (list != null) {
            this.mtopProp.cacheKeyBlackList = list;
        }
        return this;
    }

    public MtopBuilder addHttpQueryParameter(String str, String str2) {
        if (!StringUtils.isBlank(str) && !StringUtils.isBlank(str2)) {
            MtopNetworkProp mtopNetworkProp = this.mtopProp;
            if (mtopNetworkProp.queryParameterMap == null) {
                mtopNetworkProp.queryParameterMap = new HashMap();
            }
            this.mtopProp.queryParameterMap.put(str, str2);
            return this;
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
            TBSdkLog.d(TAG, "[addHttpQueryParameter]add HttpQueryParameter error,key=" + str + ",value=" + str2);
        }
        return this;
    }

    public MtopBuilder addListener(MtopListener mtopListener) {
        this.listener = mtopListener;
        return this;
    }

    public MtopBuilder addMteeUa(String str) {
        addHttpQueryParameter("ua", str);
        return this;
    }

    public MtopBuilder addOpenApiParams(String str, String str2) {
        MtopNetworkProp mtopNetworkProp = this.mtopProp;
        mtopNetworkProp.apiType = ApiTypeEnum.ISV_OPEN_API;
        mtopNetworkProp.openAppKey = str;
        mtopNetworkProp.accessToken = str2;
        return this;
    }

    public MtopContext createMtopContext(MtopListener mtopListener) {
        MtopContext mtopContext = new MtopContext();
        mtopContext.mtopInstance = this.mtopInstance;
        MtopStatistics mtopStatistics = this.stat;
        mtopContext.stats = mtopStatistics;
        mtopContext.seqNo = mtopStatistics.seqNo;
        MtopRequest mtopRequest = this.request;
        mtopContext.mtopRequest = mtopRequest;
        mtopContext.property = this.mtopProp;
        mtopContext.mtopListener = mtopListener;
        mtopContext.mtopBuilder = this;
        if (mtopRequest != null) {
            mtopStatistics.apiKey = mtopRequest.getKey();
            this.stat.reqSource = this.mtopProp.reqSource;
        }
        if (StringUtils.isBlank(mtopContext.property.ttid)) {
            mtopContext.property.ttid = this.mtopInstance.getTtid();
        }
        Object obj = this.requestContext;
        if (obj != null) {
            reqContext(obj);
        }
        return mtopContext;
    }

    public MtopBuilder enableProgressListener() {
        this.mtopProp.enableProgressListener = true;
        return this;
    }

    public MtopBuilder forceRefreshCache() {
        this.mtopProp.forceRefreshCache = true;
        return this;
    }

    public MtopContext getMtopContext() {
        return this.mtopContext;
    }

    public Mtop getMtopInstance() {
        return this.mtopInstance;
    }

    public MtopPrefetch getMtopPrefetch() {
        return this.mtopPrefetch;
    }

    public Object getReqContext() {
        return this.mtopProp.reqContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MtopResponse handleAsyncTimeoutException() {
        MtopResponse mtopResponse = new MtopResponse(this.request.getApiName(), this.request.getVersion(), ErrorConstant.ERRCODE_MTOP_APICALL_ASYNC_TIMEOUT, "服务竟然出错了");
        mtopResponse.mappingCodeSuffix = ErrorConstant.getMappingCodeByErrorCode(mtopResponse.getRetCode());
        mtopResponse.mappingCode = ErrorConstant.appendMappingCode(mtopResponse.getResponseCode(), mtopResponse.mappingCodeSuffix);
        this.stat.retCode = mtopResponse.getRetCode();
        this.stat.mappingCode = mtopResponse.getMappingCode();
        MtopStatistics mtopStatistics = this.stat;
        mtopStatistics.retType = 2;
        mtopResponse.setMtopStat(mtopStatistics);
        this.stat.onEndAndCommit();
        this.stat.commitFullTrace();
        return mtopResponse;
    }

    public MtopBuilder handler(Handler handler) {
        this.mtopProp.handler = handler;
        return this;
    }

    public MtopBuilder headers(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            MtopNetworkProp mtopNetworkProp = this.mtopProp;
            Map<String, String> map2 = mtopNetworkProp.requestHeaders;
            if (map2 != null) {
                map2.putAll(map);
            } else {
                mtopNetworkProp.requestHeaders = map;
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mtopCommitStatData(boolean z) {
        this.stat.commitStat = z;
    }

    public MtopBuilder prefetch(long j, List<String> list, MtopPrefetch.IPrefetchCallback iPrefetchCallback) {
        prefetch(j, iPrefetchCallback);
        MtopPrefetch mtopPrefetch = this.mtopPrefetch;
        if (mtopPrefetch != null) {
            mtopPrefetch.whiteListParams = list;
        }
        return this;
    }

    public MtopBuilder prefetchComparator(MtopPrefetch.IPrefetchComparator iPrefetchComparator) {
        if (this.mtopPrefetch == null) {
            this.mtopPrefetch = new MtopPrefetch(new PrefetchStatistics(this.mtopInstance.getMtopConfig().uploadStats));
        }
        this.mtopPrefetch.setComparator(iPrefetchComparator);
        return this;
    }

    public MtopBuilder protocol(ProtocolEnum protocolEnum) {
        if (protocolEnum != null) {
            this.mtopProp.protocol = protocolEnum;
        }
        return this;
    }

    public MtopBuilder reqContext(Object obj) {
        this.mtopProp.reqContext = obj;
        return this;
    }

    public MtopBuilder reqMethod(MethodEnum methodEnum) {
        if (methodEnum != null) {
            this.mtopProp.method = methodEnum;
        }
        return this;
    }

    public MtopBuilder retryTime(int i) {
        this.mtopProp.retryTimes = i;
        return this;
    }

    @Deprecated
    public MtopBuilder setBizId(int i) {
        this.mtopProp.bizId = i;
        return this;
    }

    public MtopBuilder setCacheControlNoCache() {
        Map<String, String> map = this.mtopProp.requestHeaders;
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("cache-control", HttpHeaderConstant.NO_CACHE);
        this.mtopProp.requestHeaders = map;
        return this;
    }

    public MtopBuilder setConnectionTimeoutMilliSecond(int i) {
        if (i > 0) {
            this.mtopProp.connTimeout = i;
        }
        return this;
    }

    public MtopBuilder setCustomDomain(String str) {
        if (str != null) {
            this.mtopProp.customDomain = str;
        }
        return this;
    }

    public MtopBuilder setJsonType(JsonTypeEnum jsonTypeEnum) {
        if (jsonTypeEnum != null) {
            addHttpQueryParameter("type", jsonTypeEnum.getJsonType());
        }
        return this;
    }

    public MtopBuilder setMiniAppKey(String str) {
        if (str != null) {
            this.mtopProp.miniAppKey = str;
        }
        return this;
    }

    public MtopBuilder setNetInfo(int i) {
        this.mtopProp.netParam = i;
        return this;
    }

    public MtopBuilder setOpenBiz(String str) {
        if (str != null) {
            this.mtopProp.openBiz = str;
        }
        return this;
    }

    public MtopBuilder setOpenBizData(String str) {
        if (str != null) {
            this.mtopProp.openBizData = str;
        }
        return this;
    }

    public MtopBuilder setPageName(String str) {
        if (str != null) {
            this.mtopProp.pageName = str;
            this.stat.pageName = str;
        }
        return this;
    }

    public MtopBuilder setPageUrl(String str) {
        if (str != null) {
            this.mtopProp.pageUrl = str;
            this.stat.pageUrl = str;
        }
        return this;
    }

    public MtopBuilder setPlaceId(String str) {
        this.mtopProp.placeId = str;
        return this;
    }

    public MtopBuilder setReqAppKey(String str, String str2) {
        MtopNetworkProp mtopNetworkProp = this.mtopProp;
        mtopNetworkProp.reqAppKey = str;
        mtopNetworkProp.authCode = str2;
        return this;
    }

    public MtopBuilder setReqBizExt(String str) {
        this.mtopProp.reqBizExt = str;
        return this;
    }

    public MtopBuilder setReqSource(int i) {
        this.mtopProp.reqSource = i;
        return this;
    }

    public MtopBuilder setReqUserId(String str) {
        this.mtopProp.reqUserId = str;
        return this;
    }

    public MtopBuilder setRequestSourceAppKey(String str) {
        if (str != null) {
            this.mtopProp.requestSourceAppKey = str;
        }
        return this;
    }

    public MtopBuilder setRouterId(String str) {
        this.mtopProp.routerId = str;
        return this;
    }

    public MtopBuilder setSocketTimeoutMilliSecond(int i) {
        if (i > 0) {
            this.mtopProp.socketTimeout = i;
        }
        return this;
    }

    public MtopBuilder setUnitStrategy(String str) {
        if (str != null) {
            str.hashCode();
            if (str.equals(MtopUnitStrategy.UNIT_GUIDE)) {
                setCustomDomain(MtopUnitStrategy.GUIDE_ONLINE_DOMAIN, MtopUnitStrategy.GUIDE_PRE_DOMAIN, MtopUnitStrategy.GUIDE_DAILY_DOMAIN);
            } else if (str.equals(MtopUnitStrategy.UNIT_TRADE)) {
                setCustomDomain(MtopUnitStrategy.TRADE_ONLINE_DOMAIN, MtopUnitStrategy.TRADE_PRE_DOMAIN, MtopUnitStrategy.TRADE_DAILY_DOMAIN);
            }
        }
        return this;
    }

    public MtopBuilder setUserInfo(@Nullable String str) {
        MtopNetworkProp mtopNetworkProp = this.mtopProp;
        if (StringUtils.isBlank(str)) {
            str = "DEFAULT";
        }
        mtopNetworkProp.userInfo = str;
        return this;
    }

    public MtopResponse syncRequest() {
        this.stat.isReqSync = true;
        MtopBaseListenerProxy createListenerProxy = createListenerProxy(this.listener);
        asyncRequest(createListenerProxy);
        synchronized (createListenerProxy) {
            try {
                if (createListenerProxy.response == null) {
                    createListenerProxy.wait(DateUtils.MILLIS_PER_MINUTE);
                }
            } catch (Exception e) {
                TBSdkLog.e(TAG, "[syncRequest] callback wait error", e);
            }
        }
        MtopResponse mtopResponse = createListenerProxy.response;
        Object obj = createListenerProxy.reqContext;
        if (obj != null) {
            this.mtopProp.reqContext = obj;
        }
        return mtopResponse != null ? mtopResponse : handleAsyncTimeoutException();
    }

    public MtopBuilder ttid(String str) {
        this.mtopProp.ttid = str;
        return this;
    }

    public MtopBuilder useCache() {
        this.mtopProp.useCache = true;
        return this;
    }

    public MtopBuilder useWua() {
        return useWua(4);
    }

    public MtopBuilder(Mtop mtop, MtopRequest mtopRequest, String str) {
        MtopNetworkProp mtopNetworkProp = new MtopNetworkProp();
        this.mtopProp = mtopNetworkProp;
        this.listener = null;
        this.requestContext = null;
        this.stat = null;
        this.mtopInstance = mtop;
        this.request = mtopRequest;
        mtopNetworkProp.ttid = str;
        mtopNetworkProp.pageName = XState.getValue(XStateConstants.KEY_CURRENT_PAGE_NAME);
        mtopNetworkProp.pageUrl = XState.getValue(XStateConstants.KEY_CURRENT_PAGE_URL);
        mtopNetworkProp.backGround = XState.isAppBackground();
        this.stat = new MtopStatistics(mtop.getMtopConfig().uploadStats, mtop.getMtopConfig().mtopStatsListener, mtopNetworkProp);
    }

    public MtopBuilder setBizId(String str) {
        this.mtopProp.bizIdStr = str;
        return this;
    }

    public MtopBuilder setCustomDomain(String str, String str2, String str3) {
        if (StringUtils.isNotBlank(str)) {
            this.mtopProp.customOnlineDomain = str;
        }
        if (StringUtils.isNotBlank(str2)) {
            this.mtopProp.customPreDomain = str2;
        }
        if (StringUtils.isNotBlank(str3)) {
            this.mtopProp.customDailyDomain = str3;
        }
        return this;
    }

    @Deprecated
    public MtopBuilder useWua(int i) {
        this.mtopProp.wuaFlag = i;
        return this;
    }

    public MtopBuilder prefetch(long j, MtopPrefetch.IPrefetchCallback iPrefetchCallback) {
        if (this.mtopPrefetch == null) {
            this.mtopPrefetch = new MtopPrefetch(new PrefetchStatistics(this.mtopInstance.getMtopConfig().uploadStats));
        }
        if (j > 0) {
            MtopPrefetch mtopPrefetch = this.mtopPrefetch;
            if (j > 15000) {
                j = 15000;
            }
            mtopPrefetch.setPrefetchExpireTime(j);
        }
        this.mtopPrefetch.setCallback(iPrefetchCallback);
        if (this.mtopPrefetch.getComparator() == null) {
            this.mtopPrefetch.setComparator(new MtopPrefetch.DefaultPrefetchComparator());
        }
        return this;
    }

    public MtopBuilder prefetch() {
        return prefetch(0L, null);
    }

    @Deprecated
    public MtopBuilder(Mtop mtop, Object obj, String str) {
        this(mtop, MtopConvert.inputDoToMtopRequest(obj), str);
    }

    @Deprecated
    public MtopBuilder(IMTOPDataObject iMTOPDataObject, String str) {
        this(Mtop.instance(null), iMTOPDataObject, str);
    }

    @Deprecated
    public MtopBuilder(MtopRequest mtopRequest, String str) {
        this(Mtop.instance(null), mtopRequest, str);
    }

    @Deprecated
    public MtopBuilder(Object obj, String str) {
        this(Mtop.instance(null), obj, str);
    }

    public ApiID asyncRequest() {
        this.stat.isReqSync = false;
        return asyncRequest(this.listener);
    }
}
