package com.youku.live.livesdk.wkit.module;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.common.WXModule;
import com.youku.live.dago.liveplayback.widget.pip.PipUtils;
import com.youku.live.livesdk.LiveActivity;
import com.youku.live.livesdk.LiveActivityLifecycleCallbackWrapper;
import com.youku.live.livesdk.model.mtop.data.LiveFullInfoData;
import com.youku.live.livesdk.wkit.ILiveActivityActions;
import com.youku.live.livesdk.wkit.component.common.utils.SharedPreferenceUtil;
import com.youku.live.livesdk.wkit.utils.ConfigUtil;
import com.youku.live.widgets.protocol.ICall;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IWidget;
import com.youku.live.widgets.widgets.weex.WeexHelper;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DagoExitPlayer extends WXModule implements Destroyable, ILiveActivityActions, IDataHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int BIZE_TYPE_CIBN = 7;
    public static final String DAGO_ENTER_PIP_MODE = "enterPipMode";
    public static final String DAGO_ENTER_PIP_RESULT = "enterPipResult";
    public static final String DAGO_INIT_HOST_VIEW_END = "dagoLivePlayerbackInitHostViewEnd";
    public static final String DAGO_IS_IN_PIP_MODE = "isInPictureInPictureMode";
    public static final String DAGO_IS_SUPPORT_PIP = "isSupportPip";
    public static final String DAGO_IS_SUPPORT_PIP_RESULT = "isSupportPipResult";
    public static final String DAGO_NOTIFY_LAYOUT_PIP_ENABLE = "dagoNotifyLayoutPipEnable";
    public static final String DAGO_NOTIFY_WEEX_GONE_IN_PIP = "dagoNotifyWeexGoneInPip";
    public static final String DAGO_ON_PIP_MODE_CHANGED = "onPictureInPictureModeChanged";
    public static final String DAGO_PIP_CONFIG_FETCH = "pipConfigFetch";
    public static final String DAGO_PIP_SWITCH_CHANGED = "pipSwitchChanged";
    public static final String DAGO_SLID_ROOM = "slidingRoom";
    public static final String ENTER_PIP_MODE_BY_WEEX_NOTIFY = "enterPipModeByWeexNotify";
    private boolean isInPip;
    private Context mActivity;
    IEngineInstance mEngineInstance;
    private boolean isInited = false;
    JSCallback mPipConfigCallback = null;
    private Object mPipConfig = null;
    SharedPreferenceUtil spUtil = null;
    LiveActivityLifecycleCallbackWrapper mLifecycle = null;
    private boolean isSupportPipPrepared = false;
    private boolean isSupportPip = false;
    private boolean isPipSwitchOpenPrepared = false;
    private boolean isPipSwitchOpen = false;
    private boolean isPipSwitchEnableLayoutPrepared = false;
    private boolean isPipSwitchEnableLayout = false;
    private boolean isNotifiedWeexPipSwitchOpen = false;
    private boolean isRequiredSupportPipMode = false;
    private boolean isBack = false;

    private void enterPipMode(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1099222962")) {
            ipChange.ipc$dispatch("1099222962", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        Log.d("fornia", "pip live Liveactivity enterPipMode 5555进小窗!!!!" + this + " ");
        this.isBack = z;
        if (this.mEngineInstance == null) {
            this.mEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        }
        IEngineInstance iEngineInstance = this.mEngineInstance;
        if (iEngineInstance != null) {
            iEngineInstance.asyncPutData("enterPipMode", Boolean.TRUE);
        }
    }

    private void initDataHandler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-503313162")) {
            ipChange.ipc$dispatch("-503313162", new Object[]{this});
        } else if (this.isInited) {
        } else {
            this.isInited = true;
            initWithNothing();
        }
    }

    private void initPipSwitch() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1556787691")) {
            ipChange.ipc$dispatch("1556787691", new Object[]{this});
            return;
        }
        SharedPreferenceUtil sharedPreferenceUtil = this.spUtil;
        if (sharedPreferenceUtil != null) {
            this.isPipSwitchOpen = ((Boolean) sharedPreferenceUtil.getSharedPreference(SharedPreferenceUtil.KEY_LIVE_PIP_SWITCH, Boolean.TRUE)).booleanValue();
            this.isPipSwitchOpenPrepared = true;
            Log.d("fornia", "pip live Liveactivity initPipSwitch 000初始化开关状态" + this + " " + this.isPipSwitchOpen);
            updatePipConfig();
        }
    }

    private void initPipSwitchEnableLayout(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "991294326")) {
            ipChange.ipc$dispatch("991294326", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isPipSwitchEnableLayout = z;
        this.isPipSwitchEnableLayoutPrepared = true;
        updatePipConfig();
    }

    private void initWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1065424815")) {
            ipChange.ipc$dispatch("1065424815", new Object[]{this});
            return;
        }
        Log.d("fornia", "pip live initWithNothing 初始化nodule" + this + " ");
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance != null) {
            this.mActivity = wXSDKInstance.getContext();
        }
        Context context = this.mActivity;
        if (context instanceof LiveActivity) {
            ((LiveActivity) context).setILiveActivityActions(this);
            this.mLifecycle = new LiveActivityLifecycleCallbackWrapper();
            if (((LiveActivity) this.mActivity).getApplication() != null) {
                ((LiveActivity) this.mActivity).getApplication().registerActivityLifecycleCallbacks(this.mLifecycle);
            }
            this.spUtil = new SharedPreferenceUtil(this.mActivity, SharedPreferenceUtil.FILE_NAME_LIVE_PIP);
        }
        initPipSwitch();
        if (this.mEngineInstance == null) {
            this.mEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        }
        IEngineInstance iEngineInstance = this.mEngineInstance;
        if (iEngineInstance != null) {
            iEngineInstance.addDataHandlers(new String[]{"slidingRoom", "dagoNotifyWeexGoneInPip", "isSupportPipResult", "dagoLivePlayerbackInitHostViewEnd", DAGO_PIP_CONFIG_FETCH, ENTER_PIP_MODE_BY_WEEX_NOTIFY, "dagoNotifyLayoutPipEnable", "enterPipResult"}, this);
        }
    }

    private boolean isCIBN() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1077497580")) {
            return ((Boolean) ipChange.ipc$dispatch("1077497580", new Object[]{this})).booleanValue();
        }
        IEngineInstance iEngineInstance = this.mEngineInstance;
        if (iEngineInstance == null) {
            return false;
        }
        Object data = iEngineInstance.getData("mtop.youku.live.com.livefullinfo");
        return (data instanceof LiveFullInfoData) && 7 == ((LiveFullInfoData) data).bizType.intValue();
    }

    private boolean isLandscape() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "448527929")) {
            return ((Boolean) ipChange.ipc$dispatch("448527929", new Object[]{this})).booleanValue();
        }
        Context context = this.mActivity;
        if (context == null || !(context instanceof LiveActivity)) {
            return false;
        }
        return ((LiveActivity) context).isLandscape();
    }

    private void releaseWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "136931236")) {
            ipChange.ipc$dispatch("136931236", new Object[]{this});
            return;
        }
        Context context = this.mActivity;
        if ((context instanceof LiveActivity) && ((LiveActivity) context).getApplication() != null) {
            ((LiveActivity) this.mActivity).getApplication().unregisterActivityLifecycleCallbacks(this.mLifecycle);
            this.mLifecycle = null;
        }
        Log.d("fornia", "pip live releaseWithNothing 释放module" + this + " ");
        if (this.mEngineInstance == null) {
            this.mEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        }
        IEngineInstance iEngineInstance = this.mEngineInstance;
        if (iEngineInstance != null) {
            iEngineInstance.removeData("enterPipMode");
            this.mEngineInstance.removeData("dagoNotifyWeexGoneInPip");
            this.mEngineInstance.removeData(DAGO_PIP_CONFIG_FETCH);
            this.mEngineInstance.removeData("isSupportPip");
            this.mEngineInstance.removeData("dagoNotifyWeexGoneInPip");
            this.mEngineInstance.removeData("onPictureInPictureModeChanged");
            this.mEngineInstance.removeData(ENTER_PIP_MODE_BY_WEEX_NOTIFY);
            this.mEngineInstance.removeDataHandler("slidingRoom", this);
            this.mEngineInstance.removeDataHandler("dagoNotifyWeexGoneInPip", this);
            this.mEngineInstance.removeDataHandler("isSupportPipResult", this);
            this.mEngineInstance.removeDataHandler("dagoLivePlayerbackInitHostViewEnd", this);
            this.mEngineInstance.removeDataHandler(DAGO_PIP_CONFIG_FETCH, this);
            this.mEngineInstance.removeDataHandler(ENTER_PIP_MODE_BY_WEEX_NOTIFY, this);
            this.mEngineInstance.removeDataHandler("dagoNotifyLayoutPipEnable", this);
            this.mEngineInstance.removeDataHandler("enterPipResult", this);
        }
    }

    private void requireSupportPipMode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2004423542")) {
            ipChange.ipc$dispatch("2004423542", new Object[]{this});
            return;
        }
        if (this.mEngineInstance == null) {
            this.mEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        }
        if (this.mEngineInstance != null) {
            Log.d("fornia", "pip live Liveactivity requireSupportPipMode 请求是否支持小窗" + this + " ");
            this.isRequiredSupportPipMode = true;
            this.mEngineInstance.asyncPutData("isSupportPip", Boolean.TRUE);
        }
    }

    private void updatePipConfig() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-2028021482")) {
            ipChange.ipc$dispatch("-2028021482", new Object[]{this});
        } else if (this.isSupportPipPrepared && this.isPipSwitchOpenPrepared && this.isPipSwitchEnableLayoutPrepared && !this.isNotifiedWeexPipSwitchOpen) {
            if (this.mEngineInstance == null) {
                this.mEngineInstance = WeexHelper.getWidgetEngineInstance(this);
            }
            if (this.mEngineInstance != null) {
                HashMap hashMap = new HashMap();
                if (this.isSupportPip && ConfigUtil.isPipSwitchOpen()) {
                    z = true;
                }
                hashMap.put("support", Boolean.valueOf(z));
                hashMap.put("open", Boolean.valueOf(this.isPipSwitchOpen));
                this.mPipConfig = hashMap;
                JSCallback jSCallback = this.mPipConfigCallback;
                if (jSCallback != null) {
                    jSCallback.invokeAndKeepAlive(hashMap);
                }
                Log.d("fornia", "pip live Liveactivity updatePipConfig DAGO_PIP_CONFIG_GATHER_COMPLETE 通知" + this + " " + this.isSupportPip + this.isPipSwitchOpen + this.isPipSwitchEnableLayout);
                this.isNotifiedWeexPipSwitchOpen = true;
            }
        }
    }

    private void updatePipSwitch(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "377087856")) {
            ipChange.ipc$dispatch("377087856", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        Log.d("fornia", "pip live Liveactivity updatePipSwitch 更新weex按钮开关状态" + this + " " + z);
        this.isPipSwitchOpen = z;
        SharedPreferenceUtil sharedPreferenceUtil = this.spUtil;
        if (sharedPreferenceUtil != null) {
            sharedPreferenceUtil.put(SharedPreferenceUtil.KEY_LIVE_PIP_SWITCH, Boolean.valueOf(z));
        }
    }

    @Override // com.youku.live.livesdk.wkit.ILiveActivityActions
    public void deInit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "726809843")) {
            ipChange.ipc$dispatch("726809843", new Object[]{this});
        }
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1769598260")) {
            ipChange.ipc$dispatch("-1769598260", new Object[]{this});
        } else {
            releaseWithNothing();
        }
    }

    @Override // com.youku.live.livesdk.wkit.ILiveActivityActions
    public void enterPipBySlidingRoom() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2132517773")) {
            ipChange.ipc$dispatch("-2132517773", new Object[]{this});
        } else if (isEnterPipMode()) {
            Context context = this.mActivity;
            if (context instanceof LiveActivity) {
                ((LiveActivity) context).setPipType(1);
            }
            enterPipMode(true);
        }
    }

    @JSMethod
    public void getSwitch(JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2103940948")) {
            ipChange.ipc$dispatch("-2103940948", new Object[]{this, jSCallback});
            return;
        }
        Log.d("fornia", "pip live getSwitch weex初始化拿配置" + this + " ");
        initDataHandler();
        requireSupportPipMode();
        this.mPipConfigCallback = jSCallback;
        Object obj = this.mPipConfig;
        if (obj != null && jSCallback != null) {
            jSCallback.invokeAndKeepAlive(obj);
            return;
        }
        if (this.mEngineInstance == null) {
            this.mEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        }
        IEngineInstance iEngineInstance = this.mEngineInstance;
        if (iEngineInstance != null) {
            iEngineInstance.asyncPutData(DAGO_PIP_CONFIG_FETCH, null);
        }
    }

    @Override // com.youku.live.livesdk.wkit.ILiveActivityActions
    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "256334964")) {
            ipChange.ipc$dispatch("256334964", new Object[]{this});
        }
    }

    @Override // com.youku.live.livesdk.wkit.ILiveActivityActions
    public boolean isEnterPipMode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "798963996")) {
            return ((Boolean) ipChange.ipc$dispatch("798963996", new Object[]{this})).booleanValue();
        }
        Log.d("fornia", "pip live isEnterPipMode 判断是否进小窗:" + this + " isSupportPip:" + this.isSupportPip + " isPipSwitchOpen:" + this.isPipSwitchOpen + " isPipSwitchEnableLayout" + this.isPipSwitchEnableLayout);
        return !isCIBN() && this.isSupportPip && this.isPipSwitchOpen && this.isPipSwitchEnableLayout && ConfigUtil.isPipSwitchOpen() && !isLandscape();
    }

    @Override // com.youku.live.livesdk.wkit.ILiveActivityActions
    public boolean isInPipMode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "734866367") ? ((Boolean) ipChange.ipc$dispatch("734866367", new Object[]{this})).booleanValue() : this.isInPip;
    }

    @Override // com.youku.live.livesdk.wkit.ILiveActivityActions
    public void onActivityPictureInPictureModeChanged(boolean z, Configuration configuration) {
        Context context;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1256754438")) {
            ipChange.ipc$dispatch("-1256754438", new Object[]{this, Boolean.valueOf(z), configuration});
        } else if (!z && this.isInPip && (context = this.mActivity) != null && (context instanceof LiveActivity) && ((LiveActivity) context).isInPictureInPictureMode()) {
            Log.d("fornia", "pip live Liveactivity 告知退出小窗 但isInPip " + this + " " + this.isInPip + " sys in pip:" + ((LiveActivity) this.mActivity).isInPictureInPictureMode());
        } else {
            this.isInPip = z;
            if (this.mEngineInstance == null) {
                this.mEngineInstance = WeexHelper.getWidgetEngineInstance(this);
            }
            IEngineInstance iEngineInstance = this.mEngineInstance;
            if (iEngineInstance != null) {
                iEngineInstance.enableCSSLayoutNotifyConfigChanged(!this.isInPip);
                this.mEngineInstance.asyncPutData("dagoNotifyWeexGoneInPip", Boolean.valueOf(this.isInPip));
                HashMap hashMap = new HashMap();
                hashMap.put("isInPictureInPictureMode", Boolean.valueOf(z));
                hashMap.put(PipUtils.DAGO_PIP_MODE_CONFIGURATION, configuration);
                this.mEngineInstance.asyncPutData("onPictureInPictureModeChanged", hashMap);
            }
        }
    }

    @Override // com.youku.live.livesdk.wkit.ILiveActivityActions
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1918195946")) {
            ipChange.ipc$dispatch("1918195946", new Object[]{this});
            return;
        }
        Context context = this.mActivity;
        if (context instanceof LiveActivity) {
            ((LiveActivity) context).setPipType(1);
        }
        enterPipMode(true);
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        Context context;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1284407133")) {
            ipChange.ipc$dispatch("1284407133", new Object[]{this, str, obj, obj2});
        } else if ("slidingRoom".equals(str)) {
            Log.d("fornia", "pip live DAGO_SLID_ROOM 通知侧滑" + this + " " + obj);
            if (!isEnterPipMode() && (context = this.mActivity) != null && (context instanceof LiveActivity)) {
                Log.d("fornia", "pip live DAGO_SLID_ROOM 侧滑关闭直播间" + this);
                ((LiveActivity) this.mActivity).finishByUser(false);
                this.mActivity = null;
                return;
            }
            enterPipBySlidingRoom();
        } else if ("dagoNotifyWeexGoneInPip".equals(str)) {
            Log.d("fornia", "pip live DAGO_NOTIFY_WEEX_GONE_IN_PIP 通知weex隐藏" + this + " " + obj);
            if (this.mWXSDKInstance == null || !(obj instanceof Boolean)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("state", obj);
            this.mWXSDKInstance.fireGlobalEventCallback("AILPPipModeChanged", hashMap);
            if (this.mEngineInstance == null) {
                this.mEngineInstance = WeexHelper.getWidgetEngineInstance(this);
            }
            IEngineInstance iEngineInstance = this.mEngineInstance;
            if (iEngineInstance != null) {
                IWidget findWidgetById = iEngineInstance.findWidgetById("back-btn");
                if (findWidgetById instanceof ICall) {
                    ((ICall) findWidgetById).call(this.mEngineInstance, ((Boolean) obj).booleanValue() ? "hide" : "show", null, null, null);
                }
            }
        } else if ("isSupportPipResult".equals(str)) {
            Log.d("fornia", "pip live Liveactivity initPipSwitch 111播放器开关状态" + this + " " + obj);
            if (!(obj instanceof Boolean) || this.isSupportPipPrepared) {
                return;
            }
            this.isSupportPip = ((Boolean) obj).booleanValue();
            this.isSupportPipPrepared = true;
            updatePipConfig();
        } else if ("dagoLivePlayerbackInitHostViewEnd".equals(str)) {
            requireSupportPipMode();
        } else if (DAGO_PIP_CONFIG_FETCH.equals(str)) {
            updatePipConfig();
        } else if ("dagoNotifyLayoutPipEnable".equals(str)) {
            Log.d("fornia", "pip live Liveactivity initPipSwitch 222layout开关状态" + this + " " + obj);
            if (obj instanceof Boolean) {
                initPipSwitchEnableLayout(((Boolean) obj).booleanValue());
            }
            this.isPipSwitchEnableLayoutPrepared = true;
        } else if (ENTER_PIP_MODE_BY_WEEX_NOTIFY.equals(str)) {
            if (isEnterPipMode()) {
                Context context2 = this.mActivity;
                if (context2 instanceof LiveActivity) {
                    ((LiveActivity) context2).setPipType(((Integer) obj).intValue());
                }
                enterPipMode(false);
                return;
            }
            if (this.mEngineInstance == null) {
                this.mEngineInstance = WeexHelper.getWidgetEngineInstance(this);
            }
            IEngineInstance iEngineInstance2 = this.mEngineInstance;
            if (iEngineInstance2 != null) {
                iEngineInstance2.asyncPutData(DagoNavigate.ENTER_PIP_MODE_RESULT_BY_BIZ, null);
            }
        } else if ("enterPipResult".equals(str)) {
            Log.d("fornia", "pip live Liveactivity DAGO_ENTER_PIP_RESULT" + this + " " + obj);
            Context context3 = this.mActivity;
            if (context3 != null && (context3 instanceof LiveActivity) && this.isBack) {
                ((LiveActivity) context3).finish();
            }
        }
    }

    @JSMethod
    public void setSwitch(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2097020412")) {
            ipChange.ipc$dispatch("-2097020412", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        Log.d("fornia", "pip live setSwitch weex设置开关" + this + " " + z);
        updatePipSwitch(z);
    }
}
