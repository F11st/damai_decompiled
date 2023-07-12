package com.alimm.xadsdk.base.expose;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alimm.xadsdk.AdSdkConfig;
import com.alimm.xadsdk.AdSdkManager;
import com.alimm.xadsdk.base.connectivity.NetworkStateObserver;
import com.alimm.xadsdk.base.core.AdThreadPoolExecutor;
import com.alimm.xadsdk.base.expose.OfflineExposeCache;
import com.alimm.xadsdk.base.model.BidInfo;
import com.alimm.xadsdk.base.model.InteractionCreativeInfo;
import com.alimm.xadsdk.base.model.MonitorInfo;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.alimm.xadsdk.base.utils.LogUtils;
import com.alimm.xadsdk.base.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ExposeManager {
    private static final int DEFAULT_MAP_SIZE = 16;
    private static final int DELAY_SEND_OFFLINE = 10000;
    private static final int RESPONSE_CODE_NO_EXPOSER = -10002;
    private static final int RESPONSE_CODE_NO_ITEM = -10001;
    private static final String TAG = "ExposeManager";
    private Context mContext;
    private DefaultExposer mDefaultExposer;
    private boolean mEnableOffline;
    private Map<String, IExposer> mExposerMap;
    private boolean mHasInternet = true;
    private final NetworkStateObserver.NetworkChangeListener mNetworkChangeListener = new NetworkStateObserver.NetworkChangeListener() { // from class: com.alimm.xadsdk.base.expose.ExposeManager.1
        @Override // com.alimm.xadsdk.base.connectivity.NetworkStateObserver.NetworkChangeListener
        public void onNetworkChanged(int i) {
            ExposeManager.this.mHasInternet = i != -1;
            if (ExposeManager.this.mHasInternet && ExposeManager.this.mEnableOffline) {
                ExposeManager.this.trySendOffline();
            }
        }
    };
    private OfflineExposeCache mOfflineExposeCache;
    private boolean mRetryEnabled;
    private List<String> mSupportRetryTypes;

    public ExposeManager(@NonNull Context context, @NonNull AdSdkConfig adSdkConfig) {
        this.mContext = context;
        this.mDefaultExposer = new DefaultExposer(adSdkConfig.getExposeConfig().getNetAdapter());
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        this.mExposerMap = concurrentHashMap;
        concurrentHashMap.put("0", this.mDefaultExposer);
        ExposeConfig exposeConfig = adSdkConfig.getExposeConfig();
        this.mEnableOffline = exposeConfig.isOfflineEnabled();
        this.mRetryEnabled = exposeConfig.isRetryEnabled();
        this.mSupportRetryTypes = exposeConfig.getSupportRetryTypes();
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "ExposeManager: offlineEnabled = " + this.mEnableOffline + ", retryEnabled = " + this.mRetryEnabled + ", retryTypes = " + this.mSupportRetryTypes);
        }
        if (this.mEnableOffline) {
            this.mOfflineExposeCache = new OfflineExposeCache(this.mContext);
            delayToStartOfflineExpose();
        }
        if (this.mRetryEnabled) {
            RetryExposeManager.getInstance().init(this.mContext, this);
        }
    }

    private void delayToStartOfflineExpose() {
        AdThreadPoolExecutor.postDelayed(new Runnable() { // from class: com.alimm.xadsdk.base.expose.ExposeManager.2
            @Override // java.lang.Runnable
            public void run() {
                NetworkStateObserver.getInstance().addNetworkChangeListener(ExposeManager.this.mNetworkChangeListener);
            }
        }, 10000);
    }

    private void dispatchExposeEvent(@NonNull BidInfo bidInfo, List<MonitorInfo> list, String str, int i, boolean z, boolean z2) {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "dispatchExposeEvent: type = " + str + ", hasInternet = " + this.mHasInternet);
        }
        if (list == null || list.isEmpty()) {
            if (LogUtils.DEBUG) {
                LogUtils.d(TAG, "dispatchExposeEvent fail with no data.");
            }
            recordExposeEnd(bidInfo, "", str, RESPONSE_CODE_NO_ITEM, "0");
        } else if (this.mHasInternet || !z2) {
            bidInfo.putExtend(AdUtConstants.XAD_UT_ARG_IS_OFFLINE, "0");
            expose(bidInfo, list, str, i, z);
        } else if (this.mEnableOffline) {
            bidInfo.putExtend(AdUtConstants.XAD_UT_ARG_IS_OFFLINE, "1");
            this.mOfflineExposeCache.save(OfflineExposeInfo.create(bidInfo, list, str));
            if (z) {
                list.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void expose(final BidInfo bidInfo, List<MonitorInfo> list, final String str, int i, boolean z) {
        BidInfo bidInfo2 = bidInfo;
        if (list == null || list.isEmpty()) {
            return;
        }
        recordExposeStart(bidInfo2, str);
        int size = list.size();
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "expose: exposeItemCount = " + size);
        }
        ArrayList arrayList = null;
        int i2 = 0;
        while (i2 < size) {
            MonitorInfo monitorInfo = list.get(i2);
            if (monitorInfo != null && !TextUtils.isEmpty(monitorInfo.getUrl())) {
                if (z) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(monitorInfo);
                }
                ArrayList arrayList2 = arrayList;
                final String sdk = monitorInfo.getSdk();
                final String replaceMacros = ExposeUtil.replaceMacros(monitorInfo.getUrl(), str, i);
                IExposer exposer = getExposer(sdk);
                if (exposer == null) {
                    recordExposeEnd(bidInfo2, replaceMacros, str, RESPONSE_CODE_NO_EXPOSER, sdk);
                } else {
                    exposer.onExpose(str, replaceMacros, new ExposeCallback() { // from class: com.alimm.xadsdk.base.expose.ExposeManager.3
                        @Override // com.alimm.xadsdk.base.expose.ExposeCallback
                        public void onFail(int i3, String str2) {
                            if (ExposeManager.this.needRetry(str, i3)) {
                                RetryExposeManager.getInstance().addRetryMonitorInfo(bidInfo, str, sdk, replaceMacros);
                            }
                            ExposeManager.recordExposeEnd(bidInfo, replaceMacros, str, i3, sdk);
                        }

                        @Override // com.alimm.xadsdk.base.expose.ExposeCallback
                        public void onSucceed(int i3) {
                            ExposeManager.recordExposeEnd(bidInfo, replaceMacros, str, i3, sdk);
                        }
                    });
                }
                arrayList = arrayList2;
            }
            i2++;
            bidInfo2 = bidInfo;
        }
        if (!z || arrayList == null) {
            return;
        }
        removeExposed(list, arrayList);
    }

    private IExposer getExposer(String str) {
        Map<String, IExposer> map = this.mExposerMap;
        IExposer iExposer = map != null ? map.get(str) : null;
        return (iExposer != null || TextUtils.equals(str, "1")) ? iExposer : this.mDefaultExposer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needRetry(String str, int i) {
        List<String> list;
        return this.mRetryEnabled && (list = this.mSupportRetryTypes) != null && list.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void recordExposeEnd(BidInfo bidInfo, String str, String str2, int i, String str3) {
        if (bidInfo != null) {
            HashMap hashMap = new HashMap(16);
            Utils.addCommonInfo(hashMap, bidInfo);
            hashMap.put(AdUtConstants.XAD_UT_ARG_EXPOSURE_TYPE, str2);
            hashMap.put(AdUtConstants.XAD_UT_ARG_EXPOSURE_SDK, str3);
            hashMap.put(AdUtConstants.XAD_UT_ARG_EXPOSURE_URL, str);
            hashMap.put("al", String.valueOf(bidInfo.getDuration()));
            hashMap.put("spm", AdUtConstants.XAD_UT_VALUE_SPM_XADSDK);
            if (bidInfo.getInteractionInfo() != null && bidInfo.getInteractionInfo().getCreativeInfo() != null) {
                InteractionCreativeInfo creativeInfo = bidInfo.getInteractionInfo().getCreativeInfo();
                hashMap.put(AdUtConstants.XAD_UT_ARG_INTERACTION, String.valueOf(creativeInfo.getType()));
                hashMap.putAll(creativeInfo.getAttributeMap());
            }
            if (bidInfo.getAllExtend() != null) {
                hashMap.putAll(bidInfo.getAllExtend());
            }
            AdSdkManager.getInstance().getUserTracker().track(AdSdkManager.getInstance().getConfig().getExposeConfig().getUtEventId(), AdUtConstants.XAD_ARG1_EXPOSE_END, String.valueOf(bidInfo.getType()), String.valueOf(i), hashMap);
        }
    }

    private static void recordExposeStart(BidInfo bidInfo, String str) {
        if (bidInfo != null) {
            HashMap hashMap = new HashMap(16);
            Utils.addCommonInfo(hashMap, bidInfo);
            hashMap.put(AdUtConstants.XAD_UT_ARG_EXPOSURE_TYPE, str);
            if (bidInfo.getAllExtend() != null) {
                hashMap.putAll(bidInfo.getAllExtend());
            }
            AdSdkManager.getInstance().getUserTracker().track(19999, AdUtConstants.XAD_ARG1_EXPOSE_START, String.valueOf(bidInfo.getType()), "", hashMap);
        }
    }

    private void removeExposed(List<MonitorInfo> list, List<MonitorInfo> list2) {
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        list.removeAll(list2);
        list2.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trySendOffline() {
        this.mOfflineExposeCache.read(new OfflineExposeCache.IReadListener() { // from class: com.alimm.xadsdk.base.expose.ExposeManager.4
            @Override // com.alimm.xadsdk.base.expose.OfflineExposeCache.IReadListener
            public void onRead(@NonNull OfflineExposeInfo offlineExposeInfo) {
                List<MonitorInfo> list = offlineExposeInfo.mExposureInfoList;
                if (list == null || list.isEmpty() || TextUtils.isEmpty(offlineExposeInfo.mExposureType)) {
                    return;
                }
                ExposeManager.this.expose(offlineExposeInfo.convertToAdvItem(), offlineExposeInfo.mExposureInfoList, offlineExposeInfo.mExposureType, -1, true);
            }
        });
    }

    public void expose(BidInfo bidInfo, String str, int i, boolean z, boolean z2) {
        if (bidInfo == null) {
            return;
        }
        dispatchExposeEvent(bidInfo, ExposeUtil.getAdMonitorInfoList(bidInfo, str), str, i, z, z2);
    }

    public void expose(BidInfo bidInfo, String str, boolean z, boolean z2) {
        if (bidInfo == null) {
            return;
        }
        dispatchExposeEvent(bidInfo, ExposeUtil.getAdMonitorInfoList(bidInfo, str), str, -1, z, z2);
    }

    public void exposeCum(BidInfo bidInfo, boolean z, boolean z2) {
        expose(bidInfo, "click", z, z2);
    }

    public void exposeInteraction(BidInfo bidInfo, String str, boolean z, boolean z2) {
        if (bidInfo == null) {
            return;
        }
        dispatchExposeEvent(bidInfo, ExposeUtil.getInteractionMonitorInfoList(bidInfo, str), str, -1, z, z2);
    }

    public void exposeRetry(RetryMonitorInfo retryMonitorInfo, ExposeCallback exposeCallback) {
        IExposer exposer;
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "exposeRetry: retryMonitorInfo = " + retryMonitorInfo);
        }
        if (retryMonitorInfo == null || (exposer = getExposer(retryMonitorInfo.getMonitorSdk())) == null) {
            return;
        }
        exposer.onExpose(retryMonitorInfo.getMonitorType(), retryMonitorInfo.getMonitorUrl(), exposeCallback);
    }

    public void exposeSu(BidInfo bidInfo, int i, boolean z, boolean z2) {
        List<MonitorInfo> adMonitorInfoList;
        if (bidInfo == null || (adMonitorInfoList = ExposeUtil.getAdMonitorInfoList(bidInfo, MonitorType.PLAYING)) == null || adMonitorInfoList.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (MonitorInfo monitorInfo : adMonitorInfoList) {
            if (ExposeUtil.isArriveExposeTime(monitorInfo, i)) {
                arrayList.add(monitorInfo);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        dispatchExposeEvent(bidInfo, arrayList, MonitorType.PLAYING, i, false, z2);
        if (z) {
            removeExposed(adMonitorInfoList, arrayList);
        }
    }

    public void exposeSus(BidInfo bidInfo, boolean z, boolean z2) {
        expose(bidInfo, MonitorType.IMPRESSION, z, z2);
    }

    public void registerExposer(String str, @NonNull IExposer iExposer) {
        this.mExposerMap.put(str, iExposer);
    }

    public void unregisterExposer(String str) {
        Map<String, IExposer> map = this.mExposerMap;
        if (map != null) {
            map.remove(str);
        }
    }
}
