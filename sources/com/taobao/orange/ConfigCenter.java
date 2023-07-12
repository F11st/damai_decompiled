package com.taobao.orange;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.RemoteException;
import android.taobao.windvane.connect.api.ApiConstants;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.ta.utdid2.device.UTDevice;
import com.taobao.orange.OConstant;
import com.taobao.orange.accssupport.OrangeAccsService;
import com.taobao.orange.aidl.OrangeConfigListenerStub;
import com.taobao.orange.aidl.ParcelableConfigListener;
import com.taobao.orange.cache.ConfigCache;
import com.taobao.orange.cache.IndexCache;
import com.taobao.orange.candidate.MultiAnalyze;
import com.taobao.orange.inner.OInitListener;
import com.taobao.orange.model.ConfigDO;
import com.taobao.orange.model.IndexAckDO;
import com.taobao.orange.model.IndexDO;
import com.taobao.orange.model.NameSpaceDO;
import com.taobao.orange.receiver.OrangeReceiver;
import com.taobao.orange.sync.BaseAuthRequest;
import com.taobao.orange.sync.BaseCdnRequest;
import com.taobao.orange.sync.BaseRequest;
import com.taobao.orange.sync.IndexUpdateHandler;
import com.taobao.orange.sync.NetworkInterceptor;
import com.taobao.orange.util.FileUtil;
import com.taobao.orange.util.OLog;
import com.taobao.orange.util.OrangeMonitor;
import com.taobao.orange.util.OrangeMonitorData;
import com.taobao.orange.util.OrangeUtils;
import com.taobao.orange.util.ReportAckUtils;
import com.taobao.orange.util.SPUtil;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.core.Constants;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import tb.jg1;
import tb.v31;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ConfigCenter {
    static final int BASE_ACKDELAY_INTERVAL = 10;
    public static final int DEFAULT_BIND_TIMEOUT = 3;
    private static final long FAIL_LOAD_INDEX_UPD_INTERVAL = 180000;
    private static final long FAIL_LOAD_INDEX_UPD_NUM = 10;
    private static final long MAX_LISTENER_NUM = 10;
    private static final String NULL_VALUE = "null";
    static final String TAG = "ConfigCenter";
    private static volatile long failLastIndexUpdTime;
    static ConfigCenter mInstance = new ConfigCenter();
    public AtomicBoolean mIsOrangeInit = new AtomicBoolean(false);
    final Map<String, Long> mLoadingConfigMap = new ConcurrentHashMap();
    final Set<String> mFailRequestsSet = new HashSet();
    final Map<String, Set<ParcelableConfigListener>> mListeners = new HashMap();
    final Set<ParcelableConfigListener> mGlobalListeners = Collections.synchronizedSet(new HashSet());
    final ConcurrentLinkedQueue<NameSpaceDO> mConfigWaitingNetworkQueue = new ConcurrentLinkedQueue<>();
    volatile OInitListener mInitListener = null;
    public AtomicBoolean isAfterIdle = new AtomicBoolean(false);
    volatile boolean mIsFirstInstall = false;
    private AtomicInteger mRequestCount = new AtomicInteger(0);
    private Map<String, Long> mDowngradeConfigMap = new ConcurrentHashMap();
    private boolean channelIndexUpdate = false;
    Set<String> failCandidateSet = new HashSet();
    IndexCache mIndexCache = new IndexCache();
    ConfigCache mConfigCache = new ConfigCache();

    /* compiled from: Taobao */
    /* renamed from: com.taobao.orange.ConfigCenter$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ OConfig val$config;
        final /* synthetic */ Context val$context;

        AnonymousClass1(Context context, OConfig oConfig) {
            this.val$context = context;
            this.val$config = oConfig;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (ConfigCenter.this) {
                if (!ConfigCenter.this.mIsOrangeInit.get()) {
                    GlobalOrange.deviceId = UTDevice.getUtdid(this.val$context);
                    if (OLog.isPrintLog(2)) {
                        SimplePropertyPreFilter simplePropertyPreFilter = new SimplePropertyPreFilter(OConfig.class, new String[0]);
                        simplePropertyPreFilter.getExcludes().add(ApiConstants.APPSECRET);
                        OLog.i(ConfigCenter.TAG, "init start", "sdkVersion", "1.6.5.2", "utdid", GlobalOrange.deviceId, Constants.CONFIG, JSON.toJSONString(this.val$config, simplePropertyPreFilter, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.SortField));
                    }
                    GlobalOrange.context = this.val$context.getApplicationContext();
                    OConfig oConfig = this.val$config;
                    GlobalOrange.appKey = oConfig.appKey;
                    GlobalOrange.appVersion = oConfig.appVersion;
                    GlobalOrange.userId = oConfig.userId;
                    GlobalOrange.appSecret = oConfig.appSecret;
                    GlobalOrange.authCode = oConfig.authCode;
                    GlobalOrange.reportUpdateAck = oConfig.reportAck;
                    OConfig oConfig2 = this.val$config;
                    GlobalOrange.statUsedConfig = oConfig2.statUsedConfig;
                    GlobalOrange.indexUpdMode = OConstant.UPDMODE.valueOf(oConfig2.indexUpdateMode);
                    GlobalOrange.env = OConstant.ENV.valueOf(this.val$config.env);
                    GlobalOrange.randomDelayAckInterval = ConfigCenter.this.updateRandomDelayAckInterval(10L);
                    GlobalOrange.probeHosts.addAll(Arrays.asList(this.val$config.probeHosts));
                    OConfig oConfig3 = this.val$config;
                    GlobalOrange.dcHost = oConfig3.dcHost;
                    String[] strArr = oConfig3.dcVips;
                    if (strArr != null) {
                        GlobalOrange.dcVips.addAll(Arrays.asList(strArr));
                    }
                    OConfig oConfig4 = this.val$config;
                    GlobalOrange.ackHost = oConfig4.ackHost;
                    String[] strArr2 = oConfig4.ackVips;
                    if (strArr2 != null) {
                        GlobalOrange.ackVips.addAll(Arrays.asList(strArr2));
                    }
                    if (this.val$config.enableDiffIndex) {
                        GlobalOrange.indexDiff = 2;
                    }
                    ConfigCenter.this.channelIndexUpdate = this.val$config.channelIndexUpdate;
                    ConfigCenter.this.mListeners.put("orange", new HashSet<ParcelableConfigListener>() { // from class: com.taobao.orange.ConfigCenter.1.1
                        {
                            add(new ParcelableConfigListener.Stub() { // from class: com.taobao.orange.ConfigCenter.1.1.1
                                @Override // com.taobao.orange.aidl.ParcelableConfigListener
                                public void onConfigUpdate(String str, Map map) throws RemoteException {
                                    ConfigCenter.this.updateSystemConfig(map);
                                }
                            });
                        }
                    });
                    MultiAnalyze.initBuildInCandidates();
                    ConfigCenter.this.loadCaches();
                    File file = new File(FileUtil.getOrangeConfigDir(), IndexCache.INDEX_STORE_NAME);
                    ConfigCenter.this.mIsFirstInstall = !file.exists();
                    OrangeMonitor.init();
                    try {
                        int i = v31.b;
                        v31.a(new NetworkInterceptor());
                        OLog.i(ConfigCenter.TAG, UCCore.LEGACY_EVENT_INIT, "add orange interceptor success to networksdk");
                    } catch (ClassNotFoundException e) {
                        OLog.w(ConfigCenter.TAG, UCCore.LEGACY_EVENT_INIT, e, "add orange interceptor fail as not found networksdk");
                    }
                    ConfigCenter.this.mIsOrangeInit.set(true);
                    ConfigCenter.this.forceCheckUpdate();
                    OrangeAccsService.complete();
                    if (ConfigCenter.this.mInitListener != null) {
                        ConfigCenter.this.mInitListener.complete();
                    }
                    if (this.val$config.time >= 0) {
                        OThreadFactory.execute(new Runnable() { // from class: com.taobao.orange.ConfigCenter.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ConfigCenter.this.delayLoadConfig();
                            }
                        }, this.val$config.time);
                    }
                    OThreadFactory.execute(new Runnable() { // from class: com.taobao.orange.ConfigCenter.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            OrangeMonitorData orangeMonitorData = new OrangeMonitorData();
                            orangeMonitorData.performance.bootType = ConfigCenter.this.mIsFirstInstall;
                            orangeMonitorData.performance.downgradeType = GlobalOrange.downgrade;
                            OrangeMonitorData.PerformanceStat performanceStat = orangeMonitorData.performance;
                            performanceStat.monitorType = 2;
                            performanceStat.requestCount = ConfigCenter.this.mRequestCount.get();
                            orangeMonitorData.performance.persistCount = FileUtil.persistCount.get();
                            orangeMonitorData.performance.restoreCount = FileUtil.restoreCount.get();
                            orangeMonitorData.performance.persistTime = FileUtil.persistTime.get();
                            orangeMonitorData.performance.restoreTime = FileUtil.restoreTime.get();
                            orangeMonitorData.performance.ioTime = FileUtil.ioTime.get();
                            OrangeMonitor.commitBootPerformanceInfo(orangeMonitorData);
                            OrangeMonitor.mPerformanceInfoRecordDone = true;
                        }
                    }, 90000L);
                    OLog.i(ConfigCenter.TAG, "init completed", new Object[0]);
                } else {
                    OLog.w(ConfigCenter.TAG, "already init", new Object[0]);
                }
            }
        }
    }

    private ConfigCenter() {
    }

    private void addFail(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.mFailRequestsSet) {
            if (this.mFailRequestsSet.add(str) && OLog.isPrintLog(2)) {
                OLog.i(TAG, "addFail", "namespace", str);
            }
        }
    }

    private boolean checkLoading(String str, boolean z) {
        if (this.mLoadingConfigMap.get(str) != null) {
            OLog.d(TAG, Constants.CONFIG, str, "is loading");
            return true;
        }
        if (z) {
            this.mLoadingConfigMap.put(str, Long.valueOf(System.currentTimeMillis()));
        }
        return false;
    }

    private <T> T getConfigObj(String str) {
        if (TextUtils.isEmpty(str)) {
            OLog.e(TAG, "getConfigObj error, namespace is empty", new Object[0]);
            return null;
        } else if (!"orange".equals(str) && !IndexCache.INDEX_STORE_NAME.equals(str)) {
            T t = (T) this.mConfigCache.getConfigObj(str);
            if (t == null) {
                if (OLog.isPrintLog(0)) {
                    OLog.v(TAG, "getConfigObj", "namespace", str, "...null");
                }
                final NameSpaceDO nameSpace = this.mIndexCache.getNameSpace(str);
                if (nameSpace != null && this.mIsOrangeInit.get()) {
                    if (!checkLoading(str, false)) {
                        OThreadFactory.execute(new Runnable() { // from class: com.taobao.orange.ConfigCenter.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (OLog.isPrintLog(0)) {
                                    OLog.d(ConfigCenter.TAG, "getConfigObj force to load", "namespace", nameSpace.name);
                                }
                                ConfigCenter.this.loadConfigLazy(nameSpace);
                            }
                        });
                    }
                } else {
                    addFail(str);
                }
            }
            return t;
        } else {
            OLog.e(TAG, "getConfigObj error, namespace is occupied by sdk", new Object[0]);
            return null;
        }
    }

    public static ConfigCenter getInstance() {
        return mInstance;
    }

    private boolean loadIndex(final IndexUpdateHandler.IndexUpdateInfo indexUpdateInfo) {
        String str;
        double d;
        int i;
        if (indexUpdateInfo != null && indexUpdateInfo.checkValid()) {
            if (!TextUtils.isEmpty(this.mIndexCache.getIndex().md5) && this.mIndexCache.getIndex().md5.equals(indexUpdateInfo.md5)) {
                OLog.w(TAG, "loadIndex fail", "cdnMd5 is match");
                return false;
            }
            if (GlobalOrange.indexContinueFailsNum.get() >= 10) {
                long currentTimeMillis = System.currentTimeMillis();
                if (failLastIndexUpdTime != 0) {
                    if (currentTimeMillis - failLastIndexUpdTime <= FAIL_LOAD_INDEX_UPD_INTERVAL) {
                        return false;
                    }
                    GlobalOrange.indexContinueFailsNum.set(0);
                    failLastIndexUpdTime = 0L;
                    if (OLog.isPrintLog(3)) {
                        OLog.w(TAG, "updateIndex continuous fail already wait 100s", new Object[0]);
                    }
                } else {
                    failLastIndexUpdTime = currentTimeMillis;
                    if (OLog.isPrintLog(3)) {
                        OLog.w(TAG, "updateIndex continuous fail numbers exceed 10", new Object[0]);
                    }
                    return false;
                }
            }
            GlobalOrange.indexContinueFailsNum.incrementAndGet();
            if (OLog.isPrintLog(2)) {
                OLog.i(TAG, "loadIndex start", ConnType.PK_CDN, indexUpdateInfo.cdn, "resource", indexUpdateInfo.resourceId, "md5", indexUpdateInfo.md5);
            }
            try {
                BaseRequest baseRequest = new BaseCdnRequest<IndexDO>(GlobalOrange.schema + jg1.SCHEME_SLASH + indexUpdateInfo.cdn + File.separator + indexUpdateInfo.resourceId, indexUpdateInfo.md5) { // from class: com.taobao.orange.ConfigCenter.7
                    /* JADX INFO: Access modifiers changed from: protected */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.taobao.orange.sync.BaseCdnRequest
                    public IndexDO parseResContent(String str2) {
                        return (IndexDO) JSON.parseObject(str2, IndexDO.class);
                    }
                };
                IndexDO syncRequest = baseRequest.syncRequest();
                if (!OrangeMonitor.mPerformanceInfoRecordDone) {
                    this.mRequestCount.incrementAndGet();
                }
                if (!GlobalOrange.fallbackAvoid) {
                    if (syncRequest != null && syncRequest.checkValid()) {
                        str = OConstant.MONITOR_PRIVATE_MODULE;
                        d = 1.0d;
                    }
                    if (OLog.isPrintLog(0)) {
                        OLog.v(TAG, "loadIndex cdnReq fail downgrade to authReq", "code", baseRequest.getCode(), "msg", baseRequest.getMessage());
                    }
                    String str2 = indexUpdateInfo.md5;
                    d = 1.0d;
                    str = OConstant.MONITOR_PRIVATE_MODULE;
                    BaseRequest baseRequest2 = new BaseAuthRequest<IndexDO>(str2, false, OConstant.REQTYPE_DOWNLOAD_RESOURCE) { // from class: com.taobao.orange.ConfigCenter.8
                        @Override // com.taobao.orange.sync.BaseAuthRequest
                        protected Map<String, String> getReqParams() {
                            HashMap hashMap = new HashMap();
                            hashMap.put("resourceId", indexUpdateInfo.resourceId);
                            return hashMap;
                        }

                        @Override // com.taobao.orange.sync.BaseAuthRequest
                        protected String getReqPostBody() {
                            return null;
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.taobao.orange.sync.BaseAuthRequest
                        public IndexDO parseResContent(String str3) {
                            return (IndexDO) JSON.parseObject(str3, IndexDO.class);
                        }
                    };
                    baseRequest = baseRequest2;
                    syncRequest = (IndexDO) baseRequest2.syncRequest();
                } else {
                    str = OConstant.MONITOR_PRIVATE_MODULE;
                    d = 1.0d;
                    OrangeMonitor.commitCount(str, OConstant.POINT_FALLBACK_AVOID, indexUpdateInfo.resourceId, 1.0d);
                }
                if (syncRequest != null && syncRequest.checkValid()) {
                    GlobalOrange.indexContinueFailsNum.set(0);
                    if (!syncRequest.id.equals(this.mIndexCache.getIndex().id) && !syncRequest.version.equals(this.mIndexCache.getIndex().version)) {
                        syncRequest.md5 = indexUpdateInfo.md5;
                        List<String> cache = this.mIndexCache.cache(syncRequest);
                        OrangeMonitor.commitSuccess(OConstant.MONITOR_MODULE, OConstant.POINT_INDEX_RATE, indexUpdateInfo.resourceId);
                        OrangeMonitor.commitIndexUpdateMonitor(syncRequest.appIndexVersion, syncRequest.baseVersion, GlobalOrange.indexResponseHeader);
                        if (OLog.isPrintLog(1)) {
                            i = 2;
                            OLog.d(TAG, "loadIndex success", "indexDO", OrangeUtils.formatIndexDO(syncRequest));
                        } else {
                            i = 2;
                        }
                        try {
                            ReportAckUtils.reportIndexAck(new IndexAckDO(syncRequest.id, OrangeUtils.getCurFormatTime(), indexUpdateInfo.md5));
                        } catch (Exception e) {
                            OLog.w(TAG, "loadIndex", e, new Object[0]);
                        }
                        if (cache.size() > 0) {
                            if (OLog.isPrintLog(i)) {
                                Object[] objArr = new Object[i];
                                objArr[0] = "removeNamespaces";
                                objArr[1] = cache;
                                OLog.i(TAG, "loadIndex remove diff namespace", objArr);
                            }
                            for (String str3 : cache) {
                                OrangeMonitor.commitCount(str, OConstant.POINT_CONFIG_REMOVE_COUNTS, str3, d);
                                this.mConfigCache.remove(str3);
                            }
                            return true;
                        }
                        return true;
                    }
                    OLog.w(TAG, "loadIndex fail", "id or version is match");
                    return false;
                }
                if (!"-200".equals(baseRequest.getCode())) {
                    if (syncRequest != null && !syncRequest.checkValid()) {
                        baseRequest.setCode(-5);
                        baseRequest.setMessage("index is invaild");
                    }
                    OrangeMonitor.commitFail(OConstant.MONITOR_MODULE, OConstant.POINT_INDEX_RATE, indexUpdateInfo.resourceId, baseRequest.getCode(), baseRequest.getMessage());
                }
                OLog.e(TAG, "loadIndex fail", "code", baseRequest.getCode(), "msg", baseRequest.getMessage());
                return false;
            } catch (Throwable th) {
                OrangeMonitor.commitFail(OConstant.MONITOR_MODULE, OConstant.POINT_INDEX_RATE, indexUpdateInfo.resourceId, "0", th.getMessage());
                OLog.e(TAG, "loadIndex fail", th, new Object[0]);
                return false;
            }
        }
        OLog.e(TAG, "updateIndex param is null", new Object[0]);
        return false;
    }

    private void removeLoading(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mLoadingConfigMap.remove(str);
    }

    private void reportNullValue(String str, String str2, String str3) {
        ConfigDO configDO;
        try {
            if (!TextUtils.equals(NULL_VALUE, str3) || (configDO = this.mConfigCache.getConfigMap().get(str)) == null) {
                return;
            }
            OrangeMonitor.commitConfigMonitor(OConstant.POINT_CONFIG_USE_DETAIL, str, configDO.version, configDO.getChangeVersion(), str2);
        } catch (Throwable th) {
            OLog.e(TAG, "reportNullValue " + th.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLocalEnvironment() {
        if (((Integer) SPUtil.getFromSharePreference(GlobalOrange.context, "enableChangeVersion", 0)).intValue() > 0) {
            String str = (String) SPUtil.getFromSharePreference(GlobalOrange.context, "osVersion", "");
            if (!TextUtils.equals((String) SPUtil.getFromSharePreference(GlobalOrange.context, "appVersion", ""), GlobalOrange.appVersion)) {
                SPUtil.saveToSharePreference(GlobalOrange.context, "appVersion", GlobalOrange.appVersion);
            }
            int i = Build.VERSION.SDK_INT;
            if (TextUtils.equals(str, String.valueOf(i))) {
                return;
            }
            SPUtil.saveToSharePreference(GlobalOrange.context, "osVersion", String.valueOf(i));
        }
    }

    public void addFails(String[] strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        synchronized (this.mFailRequestsSet) {
            if (this.mFailRequestsSet.addAll(arrayList) && OLog.isPrintLog(2)) {
                OLog.i(TAG, "addFails", "namespaces", arrayList);
            }
        }
    }

    public boolean addGlobalListener(OConfigListener oConfigListener) {
        if (oConfigListener != null) {
            return this.mGlobalListeners.add(new OrangeConfigListenerStub(oConfigListener));
        }
        return false;
    }

    public void delayLoadConfig() {
        OLog.d(TAG, "delayLoadConfig", new Object[0]);
        if (!this.mIsOrangeInit.get()) {
            this.isAfterIdle.compareAndSet(false, true);
            OLog.w(TAG, "delayLoadConfig fail as not finish orange init", new Object[0]);
        } else if (this.isAfterIdle.compareAndSet(false, true)) {
            OrangeMonitorData orangeMonitorData = new OrangeMonitorData();
            orangeMonitorData.performance.bootType = this.mIsFirstInstall;
            orangeMonitorData.performance.downgradeType = GlobalOrange.downgrade;
            OrangeMonitorData.PerformanceStat performanceStat = orangeMonitorData.performance;
            performanceStat.monitorType = 0;
            performanceStat.requestCount = this.mRequestCount.get();
            orangeMonitorData.performance.persistCount = FileUtil.persistCount.get();
            orangeMonitorData.performance.restoreCount = FileUtil.restoreCount.get();
            orangeMonitorData.performance.persistTime = FileUtil.persistTime.get();
            orangeMonitorData.performance.restoreTime = FileUtil.restoreTime.get();
            orangeMonitorData.performance.ioTime = FileUtil.ioTime.get();
            if (getConfigWaitingNetworkQueue() != null) {
                OThreadFactory.execute(new Runnable() { // from class: com.taobao.orange.ConfigCenter.10
                    @Override // java.lang.Runnable
                    public void run() {
                        HashSet<NameSpaceDO> hashSet = new HashSet();
                        while (!ConfigCenter.this.getConfigWaitingNetworkQueue().isEmpty()) {
                            NameSpaceDO poll = ConfigCenter.this.getConfigWaitingNetworkQueue().poll();
                            if (poll != null) {
                                hashSet.add(poll);
                            }
                        }
                        for (NameSpaceDO nameSpaceDO : hashSet) {
                            if (nameSpaceDO != null) {
                                if (OLog.isPrintLog(0)) {
                                    OLog.d(ConfigCenter.TAG, "idle load config", "namespace", nameSpaceDO.name);
                                }
                                ConfigCenter.this.loadConfig(nameSpaceDO);
                            }
                        }
                    }
                });
            }
            for (String str : getConfigCache().getConfigMap().keySet()) {
                final ConfigDO configDO = getConfigCache().getConfigMap().get(str);
                if (configDO != null && !configDO.persisted) {
                    OThreadFactory.executeDisk(new Runnable() { // from class: com.taobao.orange.ConfigCenter.11
                        @Override // java.lang.Runnable
                        public void run() {
                            if (OLog.isPrintLog(0)) {
                                OLog.d(ConfigCenter.TAG, "idle persist config", "namespace", configDO.name);
                            }
                            ConfigDO configDO2 = configDO;
                            configDO2.persisted = true;
                            FileUtil.persistObject(configDO2, configDO2.name);
                        }
                    });
                }
            }
            OrangeMonitor.commitBootPerformanceInfo(orangeMonitorData);
        }
    }

    public void forceCheckUpdate() {
        if (!this.mIsOrangeInit.get()) {
            OLog.w(TAG, "forceCheckUpdate fail as not finish orange init", new Object[0]);
        } else if (GlobalOrange.indexUpdMode != OConstant.UPDMODE.O_XMD) {
            OLog.i(TAG, "forceCheckUpdate start", new Object[0]);
            IndexUpdateHandler.checkIndexUpdate(this.mIndexCache.getAppIndexVersion(), this.mIndexCache.getVersionIndexVersion());
        } else {
            OLog.w(TAG, "forceCheckUpdate fail as not allow in O_XMD mode", new Object[0]);
        }
    }

    public JSONObject getAllConfigs() {
        try {
            return new JSONObject(JSON.toJSONString(OrangeUtils.sortMapByKey(this.mConfigCache.getConfigMap(), true)));
        } catch (Exception e) {
            OLog.e(TAG, "getAllConfigs", e, new Object[0]);
            return null;
        }
    }

    public String getConfig(String str, String str2, String str3) {
        String str4;
        Map<String, String> configs = getConfigs(str);
        if (configs != null && (str4 = configs.get(str2)) != null) {
            reportNullValue(str, str2, str4);
            return str4;
        }
        reportNullValue(str, str2, str3);
        return str3;
    }

    public ConfigCache getConfigCache() {
        return this.mConfigCache;
    }

    public ConcurrentLinkedQueue<NameSpaceDO> getConfigWaitingNetworkQueue() {
        return this.mConfigWaitingNetworkQueue;
    }

    public Map<String, String> getConfigs(String str) {
        try {
            return (Map) getConfigObj(str);
        } catch (Throwable th) {
            OLog.w(TAG, "getConfigs error", th, "namespace", str);
            return null;
        }
    }

    public String getCustomConfig(String str, String str2) {
        try {
            String str3 = (String) getConfigObj(str);
            return str3 == null ? str2 : str3;
        } catch (Throwable th) {
            OLog.w(TAG, "getCustomConfig error", th, "namespace", str);
            return str2;
        }
    }

    public JSONObject getIndex() {
        try {
            IndexDO indexDO = new IndexDO(this.mIndexCache.getIndex());
            Collections.sort(indexDO.mergedNamespaces, new Comparator<NameSpaceDO>() { // from class: com.taobao.orange.ConfigCenter.12
                @Override // java.util.Comparator
                public int compare(NameSpaceDO nameSpaceDO, NameSpaceDO nameSpaceDO2) {
                    return nameSpaceDO.name.compareTo(nameSpaceDO2.name);
                }
            });
            return new JSONObject(JSON.toJSONString(indexDO));
        } catch (Exception e) {
            OLog.e(TAG, "getIndex", e, new Object[0]);
            return null;
        }
    }

    public JSONObject getIndexAndConfigs() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("index", getIndex());
            hashMap.put(Constants.CONFIG, getAllConfigs());
            return new JSONObject(hashMap);
        } catch (Exception e) {
            OLog.e(TAG, "getIndexAndConfigs", e, new Object[0]);
            return null;
        }
    }

    public void init(Context context, OConfig oConfig) {
        if (context != null && !TextUtils.isEmpty(oConfig.appKey) && !TextUtils.isEmpty(oConfig.appVersion)) {
            OThreadFactory.execute(new AnonymousClass1(context, oConfig));
        } else {
            OLog.e(TAG, "init start", "input param error");
        }
    }

    void loadCaches() {
        Set<NameSpaceDO> load;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            OLog.i(TAG, "loadCaches", "start index");
            this.mIndexCache.load();
            Set<NameSpaceDO> allNameSpaces = this.mIndexCache.getAllNameSpaces();
            OLog.i(TAG, "loadCaches", "start restore configs", Integer.valueOf(allNameSpaces.size()));
            if (this.channelIndexUpdate) {
                load = this.mConfigCache.loadByUseNamespacesFilter(allNameSpaces);
            } else {
                load = this.mConfigCache.load(allNameSpaces);
            }
            OLog.i(TAG, "loadCaches", "finish restore configs", Integer.valueOf(allNameSpaces.size()), "cost(ms)", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (load != null && !load.isEmpty()) {
                OLog.i(TAG, "loadCaches", "start load notMatchNamespaces", Integer.valueOf(load.size()));
                long currentTimeMillis2 = System.currentTimeMillis();
                for (NameSpaceDO nameSpaceDO : load) {
                    OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_CONFIG_NOTMATCH_COUNTS, nameSpaceDO.name, 1.0d);
                    loadConfig(nameSpaceDO);
                    load = load;
                }
                OLog.i(TAG, "loadCaches", "finish load notMatchNamespaces", Integer.valueOf(load.size()), "cost(ms)", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
            GlobalOrange.context.registerReceiver(new OrangeReceiver(), intentFilter);
        } catch (Throwable th) {
            OLog.e(TAG, "loadCaches", th, new Object[0]);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            th.printStackTrace(new PrintStream(byteArrayOutputStream));
            OrangeMonitor.commitFail(OConstant.MONITOR_MODULE, OConstant.POINT_EXCEPTION, "0", OConstant.CODE_POINT_EXP_LOAD_CACHE, byteArrayOutputStream.toString());
        }
    }

    public void loadConfig(NameSpaceDO nameSpaceDO) {
        loadConfig(nameSpaceDO, false);
    }

    public void loadConfigLazy(NameSpaceDO nameSpaceDO) {
        if (nameSpaceDO == null) {
            OLog.e(TAG, "loadConfigLazy fail", "nameSpaceDO is null");
        } else if ("orange".equals(nameSpaceDO.name)) {
            loadConfig(nameSpaceDO);
        } else if (GlobalOrange.downgrade > 0) {
            OLog.w(TAG, "loadConfigLazy downgrade, back to old strategy", nameSpaceDO.name, nameSpaceDO.loadLevel, Integer.valueOf(GlobalOrange.downgrade));
            loadConfig(nameSpaceDO);
            if (OrangeMonitor.mAppMonitorValid && this.mDowngradeConfigMap.get(nameSpaceDO.name) == null) {
                this.mDowngradeConfigMap.put(nameSpaceDO.name, Long.valueOf(System.currentTimeMillis()));
                OrangeMonitor.commitCount(OConstant.MONITOR_MODULE, OConstant.POINT_DOWNGRADE, nameSpaceDO.name, 1.0d);
            }
        } else {
            OLog.d(TAG, "loadConfigLazy", nameSpaceDO.name, nameSpaceDO.loadLevel, nameSpaceDO.highLazy);
            if (nameSpaceDO.highLazy.intValue() != 0 && this.mIsFirstInstall) {
                if (this.isAfterIdle.get()) {
                    loadConfig(nameSpaceDO);
                    return;
                }
                getConfigWaitingNetworkQueue().offer(nameSpaceDO);
                OLog.d(TAG, "offer a namespace", nameSpaceDO.name, "to network queue");
                return;
            }
            loadConfig(nameSpaceDO);
        }
    }

    public void notifyListeners(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("fromCache", String.valueOf(z));
        hashMap.put("configVersion", str2);
        if (!z && !this.mGlobalListeners.isEmpty()) {
            for (ParcelableConfigListener parcelableConfigListener : this.mGlobalListeners) {
                try {
                    parcelableConfigListener.onConfigUpdate(str, hashMap);
                } catch (Throwable th) {
                    OLog.w(TAG, "notifyGlobalListeners", th, new Object[0]);
                }
            }
        }
        HashSet<ParcelableConfigListener> hashSet = new HashSet();
        synchronized (this.mListeners) {
            Set<ParcelableConfigListener> set = this.mListeners.get(str);
            if (set != null && set.size() > 0) {
                hashSet.addAll(set);
            }
        }
        if (hashSet.size() > 0) {
            if (OLog.isPrintLog(1)) {
                OLog.d(TAG, "notifyListeners ", "namespace", str, "args", hashMap, "listenerSet.size", Integer.valueOf(hashSet.size()));
            }
            for (ParcelableConfigListener parcelableConfigListener2 : hashSet) {
                try {
                    parcelableConfigListener2.onConfigUpdate(str, hashMap);
                } catch (Throwable th2) {
                    OLog.w(TAG, "notifyListeners", th2, new Object[0]);
                }
            }
        }
    }

    public void registerListener(final String str, ParcelableConfigListener parcelableConfigListener, boolean z) {
        if (TextUtils.isEmpty(str) || parcelableConfigListener == null) {
            return;
        }
        synchronized (this.mListeners) {
            Set<ParcelableConfigListener> set = this.mListeners.get(str);
            if (set == null) {
                set = Collections.newSetFromMap(new LinkedHashMap<ParcelableConfigListener, Boolean>() { // from class: com.taobao.orange.ConfigCenter.5
                    @Override // java.util.LinkedHashMap
                    protected boolean removeEldestEntry(Map.Entry<ParcelableConfigListener, Boolean> entry) {
                        return ((long) size()) > 10;
                    }
                });
                this.mListeners.put(str, set);
            }
            if (set.contains(parcelableConfigListener)) {
                return;
            }
            if (z) {
                set.add(parcelableConfigListener);
                if (OLog.isPrintLog(1)) {
                    OLog.d(TAG, "registerListener append", "namespace", str, "size", Integer.valueOf(set.size()));
                }
            } else {
                if (OLog.isPrintLog(1)) {
                    OLog.d(TAG, "registerListener cover", "namespace", str);
                }
                set.clear();
                set.add(parcelableConfigListener);
            }
            ConfigDO configDO = this.mConfigCache.getConfigMap().get(str);
            if (configDO != null) {
                String curVersion = configDO.getCurVersion();
                if (OLog.isPrintLog(0)) {
                    OLog.v(TAG, "registerListener onConfigUpdate", "namespace", str, "version", curVersion);
                }
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("fromCache", "true");
                    hashMap.put("configVersion", curVersion);
                    parcelableConfigListener.onConfigUpdate(str, hashMap);
                    return;
                } catch (Throwable th) {
                    OLog.w(TAG, "registerListener", th, new Object[0]);
                    return;
                }
            }
            IndexCache indexCache = this.mIndexCache;
            if (indexCache != null && indexCache.getNameSpace(str) != null && this.mIsOrangeInit.get()) {
                if (checkLoading(str, false)) {
                    return;
                }
                OThreadFactory.execute(new Runnable() { // from class: com.taobao.orange.ConfigCenter.6
                    @Override // java.lang.Runnable
                    public void run() {
                        ConfigCenter configCenter = ConfigCenter.this;
                        configCenter.loadConfigLazy(configCenter.mIndexCache.getNameSpace(str));
                    }
                });
                return;
            }
            addFail(str);
        }
    }

    public void rematchNamespace(final Set<String> set, final boolean z) {
        OThreadFactory.execute(new Runnable() { // from class: com.taobao.orange.ConfigCenter.9
            @Override // java.lang.Runnable
            public void run() {
                Map<String, Set<String>> map;
                synchronized (ConfigCenter.this) {
                    Set set2 = set;
                    if (set2 != null && !set2.isEmpty() && (map = ConfigCenter.this.mIndexCache.candidateNamespace) != null && !map.isEmpty()) {
                        set.addAll(ConfigCenter.this.failCandidateSet);
                        ConfigCenter.this.failCandidateSet.clear();
                        if (OLog.isPrintLog(1)) {
                            OLog.d(ConfigCenter.TAG, "rematchNamespace", "<<<<<<<<<<<<<< START >>>>>>>>>>>>>>");
                        }
                        if (OLog.isPrintLog(1)) {
                            OLog.d(ConfigCenter.TAG, "rematchNamespace", "candidateKeys", set);
                        }
                        HashSet<String> hashSet = new HashSet();
                        for (String str : set) {
                            Set<String> set3 = ConfigCenter.this.mIndexCache.candidateNamespace.get(str);
                            if (set3 != null) {
                                hashSet.addAll(set3);
                            }
                        }
                        if (OLog.isPrintLog(1)) {
                            OLog.d(ConfigCenter.TAG, "rematchNamespace", "specialNamespaces", hashSet);
                        }
                        for (String str2 : hashSet) {
                            if (!ConfigCenter.this.mConfigCache.getConfigMap().containsKey(str2)) {
                                OLog.w(ConfigCenter.TAG, "rematchNamespace break as not used DEFAULT", "namespace", str2);
                            } else {
                                ConfigCenter configCenter = ConfigCenter.this;
                                configCenter.loadConfig(configCenter.mIndexCache.getNameSpace(str2), z);
                            }
                        }
                        ConfigCenter.this.updateLocalEnvironment();
                        if (OLog.isPrintLog(1)) {
                            OLog.d(ConfigCenter.TAG, "rematchNamespace", "<<<<<<<<<<<<<< END >>>>>>>>>>>>>>");
                        }
                        return;
                    }
                    if (OLog.isPrintLog(3)) {
                        OLog.w(ConfigCenter.TAG, "rematchNamespace fail", new Object[0]);
                    }
                    ConfigCenter.this.failCandidateSet.addAll(set);
                }
            }
        });
    }

    public void removeFail(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.mFailRequestsSet) {
            if (this.mFailRequestsSet.remove(str) && OLog.isPrintLog(2)) {
                OLog.i(TAG, "removeFail", "namespace", str);
            }
        }
    }

    public boolean removeGlobalListener(OConfigListener oConfigListener) {
        if (oConfigListener != null) {
            return this.mGlobalListeners.remove(new OrangeConfigListenerStub(oConfigListener));
        }
        return false;
    }

    public synchronized void retryFailRequests() {
        HashSet<NameSpaceDO> hashSet = new HashSet();
        synchronized (this.mFailRequestsSet) {
            for (String str : this.mFailRequestsSet) {
                NameSpaceDO nameSpace = this.mIndexCache.getNameSpace(str);
                if (nameSpace != null) {
                    hashSet.add(nameSpace);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            OLog.i(TAG, "retryFailRequests", "start load retryNamespaces", Integer.valueOf(hashSet.size()));
            long currentTimeMillis = System.currentTimeMillis();
            for (NameSpaceDO nameSpaceDO : hashSet) {
                loadConfig(nameSpaceDO);
            }
            OLog.i(TAG, "retryFailRequests", "finish load retryNamespaces", Integer.valueOf(hashSet.size()), "cost(ms)", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        } else if (OLog.isPrintLog(1)) {
            OLog.d(TAG, "retryFailRequests no any", new Object[0]);
        }
    }

    @Deprecated
    public void setGlobalListener(OConfigListener oConfigListener) {
        this.mGlobalListeners.add(new OrangeConfigListenerStub(oConfigListener));
    }

    public void setInitListener(OInitListener oInitListener) {
        this.mInitListener = oInitListener;
    }

    public void unregisterListener(String str, ParcelableConfigListener parcelableConfigListener) {
        if (TextUtils.isEmpty(str) || parcelableConfigListener == null) {
            return;
        }
        synchronized (this.mListeners) {
            Set<ParcelableConfigListener> set = this.mListeners.get(str);
            if (set != null && set.size() > 0 && set.remove(parcelableConfigListener) && OLog.isPrintLog(1)) {
                OLog.d(TAG, "unregisterListener", "namespace", str, "size", Integer.valueOf(set.size()));
            }
        }
    }

    public void unregisterListeners(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.mListeners) {
            this.mListeners.remove(str);
        }
    }

    public synchronized void updateIndex(IndexUpdateHandler.IndexUpdateInfo indexUpdateInfo) {
        Set<NameSpaceDO> updateNameSpaces;
        if (!loadIndex(indexUpdateInfo)) {
            if (OLog.isPrintLog(0)) {
                OLog.v(TAG, "updateIndex", "no need update or update fail index file");
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HashSet hashSet = new HashSet((int) ((this.mConfigCache.getConfigMap().size() + this.mFailRequestsSet.size()) * 1.4d));
        hashSet.addAll(this.mConfigCache.getConfigMap().keySet());
        synchronized (this.mFailRequestsSet) {
            hashSet.addAll(this.mFailRequestsSet);
        }
        if (this.channelIndexUpdate) {
            updateNameSpaces = this.mIndexCache.getUpdateNameSpacesByUsedList(hashSet);
        } else {
            updateNameSpaces = this.mIndexCache.getUpdateNameSpaces(hashSet);
        }
        OLog.i(TAG, "updateIndex", "start load updateNameSpaces", Integer.valueOf(updateNameSpaces.size()));
        for (NameSpaceDO nameSpaceDO : updateNameSpaces) {
            loadConfigLazy(nameSpaceDO);
        }
        OLog.i(TAG, "updateIndex", "finish load updateNameSpaces", Integer.valueOf(updateNameSpaces.size()), "cost(ms)", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    long updateRandomDelayAckInterval(long j) {
        if (j == 0) {
            return 0L;
        }
        return OrangeUtils.hash(GlobalOrange.deviceId) % (j * 1000);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0306 A[Catch: all -> 0x0381, TryCatch #0 {all -> 0x0381, blocks: (B:3:0x0026, B:5:0x0039, B:7:0x0053, B:9:0x0059, B:11:0x0067, B:16:0x0076, B:18:0x0084, B:23:0x0094, B:25:0x00a2, B:30:0x00b2, B:32:0x00c0, B:38:0x00d2, B:40:0x00e0, B:41:0x0116, B:43:0x0122, B:44:0x013a, B:46:0x0146, B:47:0x015e, B:49:0x016a, B:50:0x0182, B:52:0x018e, B:55:0x0196, B:56:0x01aa, B:58:0x01b6, B:62:0x01c0, B:63:0x01d4, B:65:0x01e0, B:67:0x01fa, B:68:0x0214, B:70:0x0222, B:71:0x023c, B:73:0x0248, B:75:0x0252, B:77:0x0257, B:78:0x0268, B:80:0x0276, B:82:0x027c, B:84:0x0282, B:85:0x028c, B:87:0x0292, B:89:0x02a2, B:90:0x02a5, B:91:0x02a8, B:93:0x02ae, B:94:0x02c8, B:96:0x02d4, B:98:0x02da, B:100:0x02e0, B:101:0x02f8, B:103:0x0306, B:105:0x030c, B:107:0x0312, B:108:0x032a, B:110:0x0338, B:114:0x0343, B:115:0x034a, B:117:0x0358, B:118:0x0365, B:120:0x0373), top: B:125:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0338 A[Catch: all -> 0x0381, TryCatch #0 {all -> 0x0381, blocks: (B:3:0x0026, B:5:0x0039, B:7:0x0053, B:9:0x0059, B:11:0x0067, B:16:0x0076, B:18:0x0084, B:23:0x0094, B:25:0x00a2, B:30:0x00b2, B:32:0x00c0, B:38:0x00d2, B:40:0x00e0, B:41:0x0116, B:43:0x0122, B:44:0x013a, B:46:0x0146, B:47:0x015e, B:49:0x016a, B:50:0x0182, B:52:0x018e, B:55:0x0196, B:56:0x01aa, B:58:0x01b6, B:62:0x01c0, B:63:0x01d4, B:65:0x01e0, B:67:0x01fa, B:68:0x0214, B:70:0x0222, B:71:0x023c, B:73:0x0248, B:75:0x0252, B:77:0x0257, B:78:0x0268, B:80:0x0276, B:82:0x027c, B:84:0x0282, B:85:0x028c, B:87:0x0292, B:89:0x02a2, B:90:0x02a5, B:91:0x02a8, B:93:0x02ae, B:94:0x02c8, B:96:0x02d4, B:98:0x02da, B:100:0x02e0, B:101:0x02f8, B:103:0x0306, B:105:0x030c, B:107:0x0312, B:108:0x032a, B:110:0x0338, B:114:0x0343, B:115:0x034a, B:117:0x0358, B:118:0x0365, B:120:0x0373), top: B:125:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0358 A[Catch: all -> 0x0381, TryCatch #0 {all -> 0x0381, blocks: (B:3:0x0026, B:5:0x0039, B:7:0x0053, B:9:0x0059, B:11:0x0067, B:16:0x0076, B:18:0x0084, B:23:0x0094, B:25:0x00a2, B:30:0x00b2, B:32:0x00c0, B:38:0x00d2, B:40:0x00e0, B:41:0x0116, B:43:0x0122, B:44:0x013a, B:46:0x0146, B:47:0x015e, B:49:0x016a, B:50:0x0182, B:52:0x018e, B:55:0x0196, B:56:0x01aa, B:58:0x01b6, B:62:0x01c0, B:63:0x01d4, B:65:0x01e0, B:67:0x01fa, B:68:0x0214, B:70:0x0222, B:71:0x023c, B:73:0x0248, B:75:0x0252, B:77:0x0257, B:78:0x0268, B:80:0x0276, B:82:0x027c, B:84:0x0282, B:85:0x028c, B:87:0x0292, B:89:0x02a2, B:90:0x02a5, B:91:0x02a8, B:93:0x02ae, B:94:0x02c8, B:96:0x02d4, B:98:0x02da, B:100:0x02e0, B:101:0x02f8, B:103:0x0306, B:105:0x030c, B:107:0x0312, B:108:0x032a, B:110:0x0338, B:114:0x0343, B:115:0x034a, B:117:0x0358, B:118:0x0365, B:120:0x0373), top: B:125:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0373 A[Catch: all -> 0x0381, TRY_LEAVE, TryCatch #0 {all -> 0x0381, blocks: (B:3:0x0026, B:5:0x0039, B:7:0x0053, B:9:0x0059, B:11:0x0067, B:16:0x0076, B:18:0x0084, B:23:0x0094, B:25:0x00a2, B:30:0x00b2, B:32:0x00c0, B:38:0x00d2, B:40:0x00e0, B:41:0x0116, B:43:0x0122, B:44:0x013a, B:46:0x0146, B:47:0x015e, B:49:0x016a, B:50:0x0182, B:52:0x018e, B:55:0x0196, B:56:0x01aa, B:58:0x01b6, B:62:0x01c0, B:63:0x01d4, B:65:0x01e0, B:67:0x01fa, B:68:0x0214, B:70:0x0222, B:71:0x023c, B:73:0x0248, B:75:0x0252, B:77:0x0257, B:78:0x0268, B:80:0x0276, B:82:0x027c, B:84:0x0282, B:85:0x028c, B:87:0x0292, B:89:0x02a2, B:90:0x02a5, B:91:0x02a8, B:93:0x02ae, B:94:0x02c8, B:96:0x02d4, B:98:0x02da, B:100:0x02e0, B:101:0x02f8, B:103:0x0306, B:105:0x030c, B:107:0x0312, B:108:0x032a, B:110:0x0338, B:114:0x0343, B:115:0x034a, B:117:0x0358, B:118:0x0365, B:120:0x0373), top: B:125:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0084 A[Catch: all -> 0x0381, TryCatch #0 {all -> 0x0381, blocks: (B:3:0x0026, B:5:0x0039, B:7:0x0053, B:9:0x0059, B:11:0x0067, B:16:0x0076, B:18:0x0084, B:23:0x0094, B:25:0x00a2, B:30:0x00b2, B:32:0x00c0, B:38:0x00d2, B:40:0x00e0, B:41:0x0116, B:43:0x0122, B:44:0x013a, B:46:0x0146, B:47:0x015e, B:49:0x016a, B:50:0x0182, B:52:0x018e, B:55:0x0196, B:56:0x01aa, B:58:0x01b6, B:62:0x01c0, B:63:0x01d4, B:65:0x01e0, B:67:0x01fa, B:68:0x0214, B:70:0x0222, B:71:0x023c, B:73:0x0248, B:75:0x0252, B:77:0x0257, B:78:0x0268, B:80:0x0276, B:82:0x027c, B:84:0x0282, B:85:0x028c, B:87:0x0292, B:89:0x02a2, B:90:0x02a5, B:91:0x02a8, B:93:0x02ae, B:94:0x02c8, B:96:0x02d4, B:98:0x02da, B:100:0x02e0, B:101:0x02f8, B:103:0x0306, B:105:0x030c, B:107:0x0312, B:108:0x032a, B:110:0x0338, B:114:0x0343, B:115:0x034a, B:117:0x0358, B:118:0x0365, B:120:0x0373), top: B:125:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a2 A[Catch: all -> 0x0381, TryCatch #0 {all -> 0x0381, blocks: (B:3:0x0026, B:5:0x0039, B:7:0x0053, B:9:0x0059, B:11:0x0067, B:16:0x0076, B:18:0x0084, B:23:0x0094, B:25:0x00a2, B:30:0x00b2, B:32:0x00c0, B:38:0x00d2, B:40:0x00e0, B:41:0x0116, B:43:0x0122, B:44:0x013a, B:46:0x0146, B:47:0x015e, B:49:0x016a, B:50:0x0182, B:52:0x018e, B:55:0x0196, B:56:0x01aa, B:58:0x01b6, B:62:0x01c0, B:63:0x01d4, B:65:0x01e0, B:67:0x01fa, B:68:0x0214, B:70:0x0222, B:71:0x023c, B:73:0x0248, B:75:0x0252, B:77:0x0257, B:78:0x0268, B:80:0x0276, B:82:0x027c, B:84:0x0282, B:85:0x028c, B:87:0x0292, B:89:0x02a2, B:90:0x02a5, B:91:0x02a8, B:93:0x02ae, B:94:0x02c8, B:96:0x02d4, B:98:0x02da, B:100:0x02e0, B:101:0x02f8, B:103:0x0306, B:105:0x030c, B:107:0x0312, B:108:0x032a, B:110:0x0338, B:114:0x0343, B:115:0x034a, B:117:0x0358, B:118:0x0365, B:120:0x0373), top: B:125:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c0 A[Catch: all -> 0x0381, TryCatch #0 {all -> 0x0381, blocks: (B:3:0x0026, B:5:0x0039, B:7:0x0053, B:9:0x0059, B:11:0x0067, B:16:0x0076, B:18:0x0084, B:23:0x0094, B:25:0x00a2, B:30:0x00b2, B:32:0x00c0, B:38:0x00d2, B:40:0x00e0, B:41:0x0116, B:43:0x0122, B:44:0x013a, B:46:0x0146, B:47:0x015e, B:49:0x016a, B:50:0x0182, B:52:0x018e, B:55:0x0196, B:56:0x01aa, B:58:0x01b6, B:62:0x01c0, B:63:0x01d4, B:65:0x01e0, B:67:0x01fa, B:68:0x0214, B:70:0x0222, B:71:0x023c, B:73:0x0248, B:75:0x0252, B:77:0x0257, B:78:0x0268, B:80:0x0276, B:82:0x027c, B:84:0x0282, B:85:0x028c, B:87:0x0292, B:89:0x02a2, B:90:0x02a5, B:91:0x02a8, B:93:0x02ae, B:94:0x02c8, B:96:0x02d4, B:98:0x02da, B:100:0x02e0, B:101:0x02f8, B:103:0x0306, B:105:0x030c, B:107:0x0312, B:108:0x032a, B:110:0x0338, B:114:0x0343, B:115:0x034a, B:117:0x0358, B:118:0x0365, B:120:0x0373), top: B:125:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d2 A[Catch: all -> 0x0381, TryCatch #0 {all -> 0x0381, blocks: (B:3:0x0026, B:5:0x0039, B:7:0x0053, B:9:0x0059, B:11:0x0067, B:16:0x0076, B:18:0x0084, B:23:0x0094, B:25:0x00a2, B:30:0x00b2, B:32:0x00c0, B:38:0x00d2, B:40:0x00e0, B:41:0x0116, B:43:0x0122, B:44:0x013a, B:46:0x0146, B:47:0x015e, B:49:0x016a, B:50:0x0182, B:52:0x018e, B:55:0x0196, B:56:0x01aa, B:58:0x01b6, B:62:0x01c0, B:63:0x01d4, B:65:0x01e0, B:67:0x01fa, B:68:0x0214, B:70:0x0222, B:71:0x023c, B:73:0x0248, B:75:0x0252, B:77:0x0257, B:78:0x0268, B:80:0x0276, B:82:0x027c, B:84:0x0282, B:85:0x028c, B:87:0x0292, B:89:0x02a2, B:90:0x02a5, B:91:0x02a8, B:93:0x02ae, B:94:0x02c8, B:96:0x02d4, B:98:0x02da, B:100:0x02e0, B:101:0x02f8, B:103:0x0306, B:105:0x030c, B:107:0x0312, B:108:0x032a, B:110:0x0338, B:114:0x0343, B:115:0x034a, B:117:0x0358, B:118:0x0365, B:120:0x0373), top: B:125:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0122 A[Catch: all -> 0x0381, TryCatch #0 {all -> 0x0381, blocks: (B:3:0x0026, B:5:0x0039, B:7:0x0053, B:9:0x0059, B:11:0x0067, B:16:0x0076, B:18:0x0084, B:23:0x0094, B:25:0x00a2, B:30:0x00b2, B:32:0x00c0, B:38:0x00d2, B:40:0x00e0, B:41:0x0116, B:43:0x0122, B:44:0x013a, B:46:0x0146, B:47:0x015e, B:49:0x016a, B:50:0x0182, B:52:0x018e, B:55:0x0196, B:56:0x01aa, B:58:0x01b6, B:62:0x01c0, B:63:0x01d4, B:65:0x01e0, B:67:0x01fa, B:68:0x0214, B:70:0x0222, B:71:0x023c, B:73:0x0248, B:75:0x0252, B:77:0x0257, B:78:0x0268, B:80:0x0276, B:82:0x027c, B:84:0x0282, B:85:0x028c, B:87:0x0292, B:89:0x02a2, B:90:0x02a5, B:91:0x02a8, B:93:0x02ae, B:94:0x02c8, B:96:0x02d4, B:98:0x02da, B:100:0x02e0, B:101:0x02f8, B:103:0x0306, B:105:0x030c, B:107:0x0312, B:108:0x032a, B:110:0x0338, B:114:0x0343, B:115:0x034a, B:117:0x0358, B:118:0x0365, B:120:0x0373), top: B:125:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0146 A[Catch: all -> 0x0381, TryCatch #0 {all -> 0x0381, blocks: (B:3:0x0026, B:5:0x0039, B:7:0x0053, B:9:0x0059, B:11:0x0067, B:16:0x0076, B:18:0x0084, B:23:0x0094, B:25:0x00a2, B:30:0x00b2, B:32:0x00c0, B:38:0x00d2, B:40:0x00e0, B:41:0x0116, B:43:0x0122, B:44:0x013a, B:46:0x0146, B:47:0x015e, B:49:0x016a, B:50:0x0182, B:52:0x018e, B:55:0x0196, B:56:0x01aa, B:58:0x01b6, B:62:0x01c0, B:63:0x01d4, B:65:0x01e0, B:67:0x01fa, B:68:0x0214, B:70:0x0222, B:71:0x023c, B:73:0x0248, B:75:0x0252, B:77:0x0257, B:78:0x0268, B:80:0x0276, B:82:0x027c, B:84:0x0282, B:85:0x028c, B:87:0x0292, B:89:0x02a2, B:90:0x02a5, B:91:0x02a8, B:93:0x02ae, B:94:0x02c8, B:96:0x02d4, B:98:0x02da, B:100:0x02e0, B:101:0x02f8, B:103:0x0306, B:105:0x030c, B:107:0x0312, B:108:0x032a, B:110:0x0338, B:114:0x0343, B:115:0x034a, B:117:0x0358, B:118:0x0365, B:120:0x0373), top: B:125:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x016a A[Catch: all -> 0x0381, TryCatch #0 {all -> 0x0381, blocks: (B:3:0x0026, B:5:0x0039, B:7:0x0053, B:9:0x0059, B:11:0x0067, B:16:0x0076, B:18:0x0084, B:23:0x0094, B:25:0x00a2, B:30:0x00b2, B:32:0x00c0, B:38:0x00d2, B:40:0x00e0, B:41:0x0116, B:43:0x0122, B:44:0x013a, B:46:0x0146, B:47:0x015e, B:49:0x016a, B:50:0x0182, B:52:0x018e, B:55:0x0196, B:56:0x01aa, B:58:0x01b6, B:62:0x01c0, B:63:0x01d4, B:65:0x01e0, B:67:0x01fa, B:68:0x0214, B:70:0x0222, B:71:0x023c, B:73:0x0248, B:75:0x0252, B:77:0x0257, B:78:0x0268, B:80:0x0276, B:82:0x027c, B:84:0x0282, B:85:0x028c, B:87:0x0292, B:89:0x02a2, B:90:0x02a5, B:91:0x02a8, B:93:0x02ae, B:94:0x02c8, B:96:0x02d4, B:98:0x02da, B:100:0x02e0, B:101:0x02f8, B:103:0x0306, B:105:0x030c, B:107:0x0312, B:108:0x032a, B:110:0x0338, B:114:0x0343, B:115:0x034a, B:117:0x0358, B:118:0x0365, B:120:0x0373), top: B:125:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x018e A[Catch: all -> 0x0381, TryCatch #0 {all -> 0x0381, blocks: (B:3:0x0026, B:5:0x0039, B:7:0x0053, B:9:0x0059, B:11:0x0067, B:16:0x0076, B:18:0x0084, B:23:0x0094, B:25:0x00a2, B:30:0x00b2, B:32:0x00c0, B:38:0x00d2, B:40:0x00e0, B:41:0x0116, B:43:0x0122, B:44:0x013a, B:46:0x0146, B:47:0x015e, B:49:0x016a, B:50:0x0182, B:52:0x018e, B:55:0x0196, B:56:0x01aa, B:58:0x01b6, B:62:0x01c0, B:63:0x01d4, B:65:0x01e0, B:67:0x01fa, B:68:0x0214, B:70:0x0222, B:71:0x023c, B:73:0x0248, B:75:0x0252, B:77:0x0257, B:78:0x0268, B:80:0x0276, B:82:0x027c, B:84:0x0282, B:85:0x028c, B:87:0x0292, B:89:0x02a2, B:90:0x02a5, B:91:0x02a8, B:93:0x02ae, B:94:0x02c8, B:96:0x02d4, B:98:0x02da, B:100:0x02e0, B:101:0x02f8, B:103:0x0306, B:105:0x030c, B:107:0x0312, B:108:0x032a, B:110:0x0338, B:114:0x0343, B:115:0x034a, B:117:0x0358, B:118:0x0365, B:120:0x0373), top: B:125:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01b6 A[Catch: all -> 0x0381, TryCatch #0 {all -> 0x0381, blocks: (B:3:0x0026, B:5:0x0039, B:7:0x0053, B:9:0x0059, B:11:0x0067, B:16:0x0076, B:18:0x0084, B:23:0x0094, B:25:0x00a2, B:30:0x00b2, B:32:0x00c0, B:38:0x00d2, B:40:0x00e0, B:41:0x0116, B:43:0x0122, B:44:0x013a, B:46:0x0146, B:47:0x015e, B:49:0x016a, B:50:0x0182, B:52:0x018e, B:55:0x0196, B:56:0x01aa, B:58:0x01b6, B:62:0x01c0, B:63:0x01d4, B:65:0x01e0, B:67:0x01fa, B:68:0x0214, B:70:0x0222, B:71:0x023c, B:73:0x0248, B:75:0x0252, B:77:0x0257, B:78:0x0268, B:80:0x0276, B:82:0x027c, B:84:0x0282, B:85:0x028c, B:87:0x0292, B:89:0x02a2, B:90:0x02a5, B:91:0x02a8, B:93:0x02ae, B:94:0x02c8, B:96:0x02d4, B:98:0x02da, B:100:0x02e0, B:101:0x02f8, B:103:0x0306, B:105:0x030c, B:107:0x0312, B:108:0x032a, B:110:0x0338, B:114:0x0343, B:115:0x034a, B:117:0x0358, B:118:0x0365, B:120:0x0373), top: B:125:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e0 A[Catch: all -> 0x0381, TryCatch #0 {all -> 0x0381, blocks: (B:3:0x0026, B:5:0x0039, B:7:0x0053, B:9:0x0059, B:11:0x0067, B:16:0x0076, B:18:0x0084, B:23:0x0094, B:25:0x00a2, B:30:0x00b2, B:32:0x00c0, B:38:0x00d2, B:40:0x00e0, B:41:0x0116, B:43:0x0122, B:44:0x013a, B:46:0x0146, B:47:0x015e, B:49:0x016a, B:50:0x0182, B:52:0x018e, B:55:0x0196, B:56:0x01aa, B:58:0x01b6, B:62:0x01c0, B:63:0x01d4, B:65:0x01e0, B:67:0x01fa, B:68:0x0214, B:70:0x0222, B:71:0x023c, B:73:0x0248, B:75:0x0252, B:77:0x0257, B:78:0x0268, B:80:0x0276, B:82:0x027c, B:84:0x0282, B:85:0x028c, B:87:0x0292, B:89:0x02a2, B:90:0x02a5, B:91:0x02a8, B:93:0x02ae, B:94:0x02c8, B:96:0x02d4, B:98:0x02da, B:100:0x02e0, B:101:0x02f8, B:103:0x0306, B:105:0x030c, B:107:0x0312, B:108:0x032a, B:110:0x0338, B:114:0x0343, B:115:0x034a, B:117:0x0358, B:118:0x0365, B:120:0x0373), top: B:125:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0222 A[Catch: all -> 0x0381, TryCatch #0 {all -> 0x0381, blocks: (B:3:0x0026, B:5:0x0039, B:7:0x0053, B:9:0x0059, B:11:0x0067, B:16:0x0076, B:18:0x0084, B:23:0x0094, B:25:0x00a2, B:30:0x00b2, B:32:0x00c0, B:38:0x00d2, B:40:0x00e0, B:41:0x0116, B:43:0x0122, B:44:0x013a, B:46:0x0146, B:47:0x015e, B:49:0x016a, B:50:0x0182, B:52:0x018e, B:55:0x0196, B:56:0x01aa, B:58:0x01b6, B:62:0x01c0, B:63:0x01d4, B:65:0x01e0, B:67:0x01fa, B:68:0x0214, B:70:0x0222, B:71:0x023c, B:73:0x0248, B:75:0x0252, B:77:0x0257, B:78:0x0268, B:80:0x0276, B:82:0x027c, B:84:0x0282, B:85:0x028c, B:87:0x0292, B:89:0x02a2, B:90:0x02a5, B:91:0x02a8, B:93:0x02ae, B:94:0x02c8, B:96:0x02d4, B:98:0x02da, B:100:0x02e0, B:101:0x02f8, B:103:0x0306, B:105:0x030c, B:107:0x0312, B:108:0x032a, B:110:0x0338, B:114:0x0343, B:115:0x034a, B:117:0x0358, B:118:0x0365, B:120:0x0373), top: B:125:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0248 A[Catch: all -> 0x0381, TryCatch #0 {all -> 0x0381, blocks: (B:3:0x0026, B:5:0x0039, B:7:0x0053, B:9:0x0059, B:11:0x0067, B:16:0x0076, B:18:0x0084, B:23:0x0094, B:25:0x00a2, B:30:0x00b2, B:32:0x00c0, B:38:0x00d2, B:40:0x00e0, B:41:0x0116, B:43:0x0122, B:44:0x013a, B:46:0x0146, B:47:0x015e, B:49:0x016a, B:50:0x0182, B:52:0x018e, B:55:0x0196, B:56:0x01aa, B:58:0x01b6, B:62:0x01c0, B:63:0x01d4, B:65:0x01e0, B:67:0x01fa, B:68:0x0214, B:70:0x0222, B:71:0x023c, B:73:0x0248, B:75:0x0252, B:77:0x0257, B:78:0x0268, B:80:0x0276, B:82:0x027c, B:84:0x0282, B:85:0x028c, B:87:0x0292, B:89:0x02a2, B:90:0x02a5, B:91:0x02a8, B:93:0x02ae, B:94:0x02c8, B:96:0x02d4, B:98:0x02da, B:100:0x02e0, B:101:0x02f8, B:103:0x0306, B:105:0x030c, B:107:0x0312, B:108:0x032a, B:110:0x0338, B:114:0x0343, B:115:0x034a, B:117:0x0358, B:118:0x0365, B:120:0x0373), top: B:125:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0276 A[Catch: all -> 0x0381, TryCatch #0 {all -> 0x0381, blocks: (B:3:0x0026, B:5:0x0039, B:7:0x0053, B:9:0x0059, B:11:0x0067, B:16:0x0076, B:18:0x0084, B:23:0x0094, B:25:0x00a2, B:30:0x00b2, B:32:0x00c0, B:38:0x00d2, B:40:0x00e0, B:41:0x0116, B:43:0x0122, B:44:0x013a, B:46:0x0146, B:47:0x015e, B:49:0x016a, B:50:0x0182, B:52:0x018e, B:55:0x0196, B:56:0x01aa, B:58:0x01b6, B:62:0x01c0, B:63:0x01d4, B:65:0x01e0, B:67:0x01fa, B:68:0x0214, B:70:0x0222, B:71:0x023c, B:73:0x0248, B:75:0x0252, B:77:0x0257, B:78:0x0268, B:80:0x0276, B:82:0x027c, B:84:0x0282, B:85:0x028c, B:87:0x0292, B:89:0x02a2, B:90:0x02a5, B:91:0x02a8, B:93:0x02ae, B:94:0x02c8, B:96:0x02d4, B:98:0x02da, B:100:0x02e0, B:101:0x02f8, B:103:0x0306, B:105:0x030c, B:107:0x0312, B:108:0x032a, B:110:0x0338, B:114:0x0343, B:115:0x034a, B:117:0x0358, B:118:0x0365, B:120:0x0373), top: B:125:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0292 A[Catch: all -> 0x0381, TryCatch #0 {all -> 0x0381, blocks: (B:3:0x0026, B:5:0x0039, B:7:0x0053, B:9:0x0059, B:11:0x0067, B:16:0x0076, B:18:0x0084, B:23:0x0094, B:25:0x00a2, B:30:0x00b2, B:32:0x00c0, B:38:0x00d2, B:40:0x00e0, B:41:0x0116, B:43:0x0122, B:44:0x013a, B:46:0x0146, B:47:0x015e, B:49:0x016a, B:50:0x0182, B:52:0x018e, B:55:0x0196, B:56:0x01aa, B:58:0x01b6, B:62:0x01c0, B:63:0x01d4, B:65:0x01e0, B:67:0x01fa, B:68:0x0214, B:70:0x0222, B:71:0x023c, B:73:0x0248, B:75:0x0252, B:77:0x0257, B:78:0x0268, B:80:0x0276, B:82:0x027c, B:84:0x0282, B:85:0x028c, B:87:0x0292, B:89:0x02a2, B:90:0x02a5, B:91:0x02a8, B:93:0x02ae, B:94:0x02c8, B:96:0x02d4, B:98:0x02da, B:100:0x02e0, B:101:0x02f8, B:103:0x0306, B:105:0x030c, B:107:0x0312, B:108:0x032a, B:110:0x0338, B:114:0x0343, B:115:0x034a, B:117:0x0358, B:118:0x0365, B:120:0x0373), top: B:125:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02ae A[Catch: all -> 0x0381, TryCatch #0 {all -> 0x0381, blocks: (B:3:0x0026, B:5:0x0039, B:7:0x0053, B:9:0x0059, B:11:0x0067, B:16:0x0076, B:18:0x0084, B:23:0x0094, B:25:0x00a2, B:30:0x00b2, B:32:0x00c0, B:38:0x00d2, B:40:0x00e0, B:41:0x0116, B:43:0x0122, B:44:0x013a, B:46:0x0146, B:47:0x015e, B:49:0x016a, B:50:0x0182, B:52:0x018e, B:55:0x0196, B:56:0x01aa, B:58:0x01b6, B:62:0x01c0, B:63:0x01d4, B:65:0x01e0, B:67:0x01fa, B:68:0x0214, B:70:0x0222, B:71:0x023c, B:73:0x0248, B:75:0x0252, B:77:0x0257, B:78:0x0268, B:80:0x0276, B:82:0x027c, B:84:0x0282, B:85:0x028c, B:87:0x0292, B:89:0x02a2, B:90:0x02a5, B:91:0x02a8, B:93:0x02ae, B:94:0x02c8, B:96:0x02d4, B:98:0x02da, B:100:0x02e0, B:101:0x02f8, B:103:0x0306, B:105:0x030c, B:107:0x0312, B:108:0x032a, B:110:0x0338, B:114:0x0343, B:115:0x034a, B:117:0x0358, B:118:0x0365, B:120:0x0373), top: B:125:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02d4 A[Catch: all -> 0x0381, TryCatch #0 {all -> 0x0381, blocks: (B:3:0x0026, B:5:0x0039, B:7:0x0053, B:9:0x0059, B:11:0x0067, B:16:0x0076, B:18:0x0084, B:23:0x0094, B:25:0x00a2, B:30:0x00b2, B:32:0x00c0, B:38:0x00d2, B:40:0x00e0, B:41:0x0116, B:43:0x0122, B:44:0x013a, B:46:0x0146, B:47:0x015e, B:49:0x016a, B:50:0x0182, B:52:0x018e, B:55:0x0196, B:56:0x01aa, B:58:0x01b6, B:62:0x01c0, B:63:0x01d4, B:65:0x01e0, B:67:0x01fa, B:68:0x0214, B:70:0x0222, B:71:0x023c, B:73:0x0248, B:75:0x0252, B:77:0x0257, B:78:0x0268, B:80:0x0276, B:82:0x027c, B:84:0x0282, B:85:0x028c, B:87:0x0292, B:89:0x02a2, B:90:0x02a5, B:91:0x02a8, B:93:0x02ae, B:94:0x02c8, B:96:0x02d4, B:98:0x02da, B:100:0x02e0, B:101:0x02f8, B:103:0x0306, B:105:0x030c, B:107:0x0312, B:108:0x032a, B:110:0x0338, B:114:0x0343, B:115:0x034a, B:117:0x0358, B:118:0x0365, B:120:0x0373), top: B:125:0x0026 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void updateSystemConfig(java.util.Map r26) {
        /*
            Method dump skipped, instructions count: 905
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.orange.ConfigCenter.updateSystemConfig(java.util.Map):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:29|(1:31)(1:130)|32|(1:34)|35|(1:37)|38|39|40|(4:(6:(14:46|47|48|(3:76|77|(2:79|(9:83|(2:85|(9:87|88|(2:90|91)|92|(1:94)(1:103)|95|(1:97)|98|99))|105|92|(0)(0)|95|(0)|98|99)))|50|51|(2:56|(1:58)(1:59))|60|(2:(1:65)|66)|67|68|69|70|72)|110|(4:118|119|120|121)(1:112)|113|114|115)(1:127)|69|70|72)|116|47|48|(0)|50|51|(3:54|56|(0)(0))|60|(0)|67|68) */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x02a6, code lost:
        r0 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0194 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01f4 A[Catch: all -> 0x02a6, TryCatch #2 {all -> 0x02a6, blocks: (B:76:0x01d1, B:78:0x01d6, B:80:0x01f4, B:82:0x01ff, B:84:0x0205, B:85:0x0210, B:81:0x01fa, B:90:0x0229, B:93:0x0239, B:95:0x023f, B:97:0x0243, B:98:0x0249, B:99:0x024e, B:102:0x0266, B:104:0x026c, B:105:0x0275, B:106:0x0282), top: B:128:0x0192 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01fa A[Catch: all -> 0x02a6, TryCatch #2 {all -> 0x02a6, blocks: (B:76:0x01d1, B:78:0x01d6, B:80:0x01f4, B:82:0x01ff, B:84:0x0205, B:85:0x0210, B:81:0x01fa, B:90:0x0229, B:93:0x0239, B:95:0x023f, B:97:0x0243, B:98:0x0249, B:99:0x024e, B:102:0x0266, B:104:0x026c, B:105:0x0275, B:106:0x0282), top: B:128:0x0192 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0205 A[Catch: all -> 0x02a6, TRY_LEAVE, TryCatch #2 {all -> 0x02a6, blocks: (B:76:0x01d1, B:78:0x01d6, B:80:0x01f4, B:82:0x01ff, B:84:0x0205, B:85:0x0210, B:81:0x01fa, B:90:0x0229, B:93:0x0239, B:95:0x023f, B:97:0x0243, B:98:0x0249, B:99:0x024e, B:102:0x0266, B:104:0x026c, B:105:0x0275, B:106:0x0282), top: B:128:0x0192 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0243 A[Catch: all -> 0x02a6, TryCatch #2 {all -> 0x02a6, blocks: (B:76:0x01d1, B:78:0x01d6, B:80:0x01f4, B:82:0x01ff, B:84:0x0205, B:85:0x0210, B:81:0x01fa, B:90:0x0229, B:93:0x0239, B:95:0x023f, B:97:0x0243, B:98:0x0249, B:99:0x024e, B:102:0x0266, B:104:0x026c, B:105:0x0275, B:106:0x0282), top: B:128:0x0192 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0249 A[Catch: all -> 0x02a6, TryCatch #2 {all -> 0x02a6, blocks: (B:76:0x01d1, B:78:0x01d6, B:80:0x01f4, B:82:0x01ff, B:84:0x0205, B:85:0x0210, B:81:0x01fa, B:90:0x0229, B:93:0x0239, B:95:0x023f, B:97:0x0243, B:98:0x0249, B:99:0x024e, B:102:0x0266, B:104:0x026c, B:105:0x0275, B:106:0x0282), top: B:128:0x0192 }] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2, types: [int] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadConfig(final com.taobao.orange.model.NameSpaceDO r28, boolean r29) {
        /*
            Method dump skipped, instructions count: 750
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.orange.ConfigCenter.loadConfig(com.taobao.orange.model.NameSpaceDO, boolean):void");
    }
}
