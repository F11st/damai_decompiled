package com.youku.live.dsl.preloader;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uc.webview.export.cyclone.StatAction;
import com.youku.alixplayer.opensdk.live.LiveInfo;
import com.youku.android.liveservice.LivePlayerController;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.VideoInfo;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.alarm.IYoukuLiveAlarm;
import com.youku.live.dsl.config.IRemoteConfig;
import com.youku.live.widgets.WidgetSDKEngine;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ILivePayControlPreloader implements LivePlayerController.IPlayControlListener, IPreloader {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long DEFAULT_TIMEOUT_INTERVAL = 5000;
    private static ILivePayControlPreloader sInstance;
    private volatile long beginTimestamp = 0;
    private volatile IResultCallback failureCallback;
    private volatile String instanceId;
    private volatile boolean isFinish;
    private volatile boolean isSuccess;
    private volatile String liveId;
    private volatile Map<String, Object> results;
    private volatile IResultCallback successCallback;

    private void doFinish() {
        IResultCallback iResultCallback;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1329823419")) {
            ipChange.ipc$dispatch("-1329823419", new Object[]{this});
        } else if (isFinish()) {
            synchronized (this) {
                if (isSuccess()) {
                    iResultCallback = this.successCallback;
                } else {
                    iResultCallback = this.failureCallback;
                }
                this.successCallback = null;
                this.failureCallback = null;
            }
            if (iResultCallback != null) {
                iResultCallback.onResult(this.results);
                removeSelfImp(true);
            }
        }
    }

    public static IPreloader getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-746183834")) {
            return (IPreloader) ipChange.ipc$dispatch("-746183834", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (ILivePayControlPreloader.class) {
                if (sInstance == null) {
                    sInstance = new ILivePayControlPreloader();
                }
            }
        }
        return sInstance;
    }

    private long getTimeoutInterval() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1749192807")) {
            return ((Long) ipChange.ipc$dispatch("1749192807", new Object[]{this})).longValue();
        }
        IRemoteConfig iRemoteConfig = (IRemoteConfig) Dsl.getService(IRemoteConfig.class);
        if (iRemoteConfig != null) {
            return iRemoteConfig.getLong("YKLiveRoom_ABTest", "use_prefetch_playcontrol_timeout", 5000L);
        }
        return 5000L;
    }

    private boolean isSuccess() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1888847762") ? ((Boolean) ipChange.ipc$dispatch("1888847762", new Object[]{this})).booleanValue() : this.isSuccess;
    }

    private void removeSelfImp(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "505300169")) {
            ipChange.ipc$dispatch("505300169", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        IYoukuLiveAlarm iYoukuLiveAlarm = (IYoukuLiveAlarm) Dsl.getService(IYoukuLiveAlarm.class);
        if (iYoukuLiveAlarm != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("liveId", this.liveId);
            hashMap.put(StatAction.KEY_TOTAL, "0");
            hashMap.put("fromFinish", z ? "1" : "0");
            iYoukuLiveAlarm.commitSuccess("LivePlayControlPreloader", "", hashMap);
        }
        String str = this.instanceId;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ((IPreloaderManangerImp) IPreloaderManangerImp.getInstance()).removePreloader(str);
    }

    @Override // com.youku.live.dsl.preloader.IPreloader
    public IPreloader addResultCallback(IResultCallback iResultCallback, IResultCallback iResultCallback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1623002582")) {
            return (IPreloader) ipChange.ipc$dispatch("-1623002582", new Object[]{this, iResultCallback, iResultCallback2});
        }
        synchronized (this) {
            this.successCallback = iResultCallback;
            this.failureCallback = iResultCallback2;
        }
        doFinish();
        return this;
    }

    public boolean async(final String str, final String str2, final Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "641061485")) {
            return ((Boolean) ipChange.ipc$dispatch("641061485", new Object[]{this, str, str2, context})).booleanValue();
        }
        this.instanceId = str;
        this.liveId = str2;
        this.beginTimestamp = System.currentTimeMillis();
        IYoukuLiveAlarm iYoukuLiveAlarm = (IYoukuLiveAlarm) Dsl.getService(IYoukuLiveAlarm.class);
        if (iYoukuLiveAlarm != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("liveId", str2);
            hashMap.put(StatAction.KEY_TOTAL, "1");
            iYoukuLiveAlarm.commitSuccess("LivePlayControlPreloader", "", hashMap);
        }
        WidgetSDKEngine.getInstance().getRenderMananger().postOnWorkerThread(new Runnable() { // from class: com.youku.live.dsl.preloader.ILivePayControlPreloader.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-381013681")) {
                    ipChange2.ipc$dispatch("-381013681", new Object[]{this});
                } else {
                    ILivePayControlPreloader.this.asyncImp(str, str2, context);
                }
            }
        });
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean asyncImp(java.lang.String r16, java.lang.String r17, android.content.Context r18) {
        /*
            r15 = this;
            r0 = r15
            r2 = r17
            r1 = r18
            com.android.alibaba.ip.runtime.IpChange r3 = com.youku.live.dsl.preloader.ILivePayControlPreloader.$ipChange
            java.lang.String r4 = "-4086587"
            boolean r5 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r3, r4)
            r13 = 1
            if (r5 == 0) goto L29
            r5 = 4
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r6 = 0
            r5[r6] = r0
            r5[r13] = r16
            r6 = 2
            r5[r6] = r2
            r2 = 3
            r5[r2] = r1
            java.lang.Object r1 = r3.ipc$dispatch(r4, r5)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            return r1
        L29:
            com.youku.alixplayer.opensdk.PlayerConfig r3 = com.youku.live.dago.liveplayback.widget.Utils.getDefaultPlayerConfig(r18)
            boolean r4 = com.youku.live.dago.liveplayback.widget.Utils.isYoukuOrHuaweiBaipai(r18)
            r5 = 0
            if (r4 == 0) goto L39
            java.util.Map r4 = com.youku.xadsdk.plugin.AdUtil.getPreAdParameter(r1, r5)     // Catch: java.lang.Throwable -> L39
            goto L3a
        L39:
            r4 = r5
        L3a:
            com.youku.android.liveservice.LivePlayerController r6 = new com.youku.android.liveservice.LivePlayerController
            java.lang.String r7 = r3.getLiveCCode()
            java.lang.String r8 = r3.getAppKey()
            r6.<init>(r2, r1, r7, r8)
            r6.setPlayControlListener(r15)
            if (r4 == 0) goto L55
            com.alibaba.fastjson.JSONObject r1 = new com.alibaba.fastjson.JSONObject     // Catch: java.lang.Throwable -> L55
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L55
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L55
        L55:
            java.lang.String r1 = r3.getPlayAbilityJson()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L64
            java.lang.String r1 = r3.getPlayAbilityJson()
            goto L68
        L64:
            java.lang.String r1 = com.youku.alixplayer.opensdk.utils.PlayerUtil.getAbilityJson()
        L68:
            r7 = r1
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            java.lang.String r3 = ""
            java.lang.String r4 = "0"
            java.lang.String r12 = ""
            java.lang.String r14 = ""
            r1 = r6
            r2 = r17
            r6 = r7
            r7 = r12
            r12 = r14
            r1.getPlayControl(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dsl.preloader.ILivePayControlPreloader.asyncImp(java.lang.String, java.lang.String, android.content.Context):boolean");
    }

    public void clearResult() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "943013917")) {
            ipChange.ipc$dispatch("943013917", new Object[]{this});
        } else if (this.results != null) {
            this.results.clear();
        }
    }

    @Nullable
    public LiveInfo getPrefetchVideoInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-338278400")) {
            return (LiveInfo) ipChange.ipc$dispatch("-338278400", new Object[]{this});
        }
        if (this.results != null) {
            Object obj = this.results.get("videoInfo");
            if (obj instanceof LiveInfo) {
                return (LiveInfo) obj;
            }
            return null;
        }
        return null;
    }

    @Override // com.youku.live.dsl.preloader.IPreloader
    public boolean isFinish() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1784267658") ? ((Boolean) ipChange.ipc$dispatch("1784267658", new Object[]{this})).booleanValue() : this.isFinish;
    }

    public boolean isTimeout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-76606092")) {
            return ((Boolean) ipChange.ipc$dispatch("-76606092", new Object[]{this})).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.beginTimestamp;
        return j == 0 || currentTimeMillis - j > getTimeoutInterval();
    }

    public void removeSelf() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-16961645")) {
            ipChange.ipc$dispatch("-16961645", new Object[]{this});
        } else {
            removeSelfImp(false);
        }
    }

    @Override // com.youku.android.liveservice.LivePlayerController.IPlayControlListener
    public void requestFailure(LivePlayControl livePlayControl, int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-602179890")) {
            ipChange.ipc$dispatch("-602179890", new Object[]{this, livePlayControl, Integer.valueOf(i), str});
            return;
        }
        HashMap hashMap = new HashMap(3);
        hashMap.put("livePlayControl", livePlayControl);
        hashMap.put("code", Integer.valueOf(i));
        hashMap.put("msg", str);
        this.results = hashMap;
        this.isFinish = true;
        doFinish();
    }

    @Override // com.youku.android.liveservice.LivePlayerController.IPlayControlListener
    public void requestSuccess(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1186474438")) {
            ipChange.ipc$dispatch("-1186474438", new Object[]{this, videoInfo});
            return;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("videoInfo", videoInfo);
        this.results = hashMap;
        this.isFinish = true;
        this.isSuccess = true;
        doFinish();
    }
}
