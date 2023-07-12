package com.youku.live.livesdk.widgets.plugin;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.nav.Nav;
import com.taobao.weex.ui.component.WXComponent;
import com.youku.live.arch.utils.ViewUtils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.account.IUser;
import com.youku.live.dsl.config.IRemoteConfig;
import com.youku.live.dsl.toast.IToast;
import com.youku.live.livesdk.constants.DagoDataCenterConstants;
import com.youku.live.livesdk.model.mtop.data.LiveFullInfoData;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.SimpleWidgetDTO;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.WidgetInitDTO;
import com.youku.live.livesdk.widgets.dialog.InterceptDialog;
import com.youku.live.livesdk.widgets.dialog.InterceptDialogHelper;
import com.youku.live.livesdk.widgets.plugin.DagoChannelPlugin;
import com.youku.live.livesdk.wkit.module.DagoExitPlayer;
import com.youku.live.messagechannel.utils.MyLog;
import com.youku.live.widgets.WidgetSDKEngine;
import com.youku.live.widgets.impl.BasePlugin;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IPlugin;
import com.youku.live.widgets.protocol.IPluginData;
import com.youku.live.widgets.protocol.Orientation;
import com.youku.live.widgets.protocol.activity.IActivityBackPressedListener;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DagoLiveFullInfoV4Plugin extends BasePlugin implements DagoChannelPlugin.Receiver, IDataHandler, IActivityBackPressedListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String AUDIO_FIRST_FRAME = "audioFirstFrame";
    public static final String CARD_DID_APPEAR = "cardDidAppear";
    public static final String CARD_DID_DISAPPEAR = "cardDidDisappear";
    public static final String DAGO_LIVE_FULL_INFO_V4_PLUGIN_VALUE = "dagoLiveFullInfoV4PluginValveProp";
    public static final String DAGO_SIGNAL_FIRST_FRAME = "dagoSignalFirstFrame";
    public static final String NAME_CHAT_BAN = "chat_ban";
    public static final String NAME_ROOM_KICKOUT = "userRoomKickoutV2";
    public static final String PLAYER_FIRST_ERROR = "playerFirstError";
    public static final String PLAYER_FIRST_FRAME = "playerFirstFrame";
    private static final String TAG = "DagoLiveFullInfoV4";
    public static final int TIMEOUT_FOR_FIRST_FRAME = 2000;
    public static final String WAIT_TIMEOUT = "waitTimeOut";
    private boolean mCanShow;
    private InterceptDialog mInterceptDialog;
    private String mLiveId;
    private String mLiveType;
    private String mPageName;
    private String mScreenId;
    private volatile boolean signalForFirstFrame = false;
    private Runnable asyncTimeoutForFirstFrame = new Runnable() { // from class: com.youku.live.livesdk.widgets.plugin.DagoLiveFullInfoV4Plugin.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-896450830")) {
                ipChange.ipc$dispatch("-896450830", new Object[]{this});
            } else {
                DagoLiveFullInfoV4Plugin.this.onFirstFrameTimeout();
            }
        }
    };
    private Runnable asyncSignalSetFirstFrameImpTrue = new Runnable() { // from class: com.youku.live.livesdk.widgets.plugin.DagoLiveFullInfoV4Plugin.2
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1092964335")) {
                ipChange.ipc$dispatch("-1092964335", new Object[]{this});
            } else {
                DagoLiveFullInfoV4Plugin.this.signalSetFirstFrameImp(true);
            }
        }
    };
    private Runnable asyncSignalSetFirstFrameImpFalse = new Runnable() { // from class: com.youku.live.livesdk.widgets.plugin.DagoLiveFullInfoV4Plugin.3
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1289477840")) {
                ipChange.ipc$dispatch("-1289477840", new Object[]{this});
            } else {
                DagoLiveFullInfoV4Plugin.this.signalSetFirstFrameImp(false);
            }
        }
    };

    private void asyncSignalSetFirstFrameImp(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1316321765")) {
            ipChange.ipc$dispatch("-1316321765", new Object[]{this, Boolean.valueOf(z)});
        } else {
            asyncSignalSetFirstFrameImp(z, 500);
        }
    }

    private void asyncTimeoutForFirstFrame() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1967283497")) {
            ipChange.ipc$dispatch("1967283497", new Object[]{this});
        } else {
            getEngineInstance().delayRunOnMainThread(this.asyncTimeoutForFirstFrame, getTimeoutOfFirstFrame());
        }
    }

    private void createInterceptDialog(String str, String str2, String str3, final String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1212785756")) {
            ipChange.ipc$dispatch("-1212785756", new Object[]{this, str, str2, str3, str4});
            return;
        }
        final Activity activity = ViewUtils.getActivity(getEngineInstance().getContext());
        InterceptDialog interceptDialog = new InterceptDialog(activity);
        this.mInterceptDialog = interceptDialog;
        interceptDialog.setOnButtonClickListener(new InterceptDialog.OnButtonClickListener() { // from class: com.youku.live.livesdk.widgets.plugin.DagoLiveFullInfoV4Plugin.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.livesdk.widgets.dialog.InterceptDialog.OnButtonClickListener
            public void onCloseButtonClick(boolean z) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "523802401")) {
                    ipChange2.ipc$dispatch("523802401", new Object[]{this, Boolean.valueOf(z)});
                } else {
                    InterceptDialogHelper.getsInstance().reportDialogCloseButtonClick(DagoLiveFullInfoV4Plugin.this.mPageName, DagoLiveFullInfoV4Plugin.this.mLiveId, DagoLiveFullInfoV4Plugin.this.mScreenId, DagoLiveFullInfoV4Plugin.this.mLiveType, z ? "2" : "1");
                }
            }

            @Override // com.youku.live.livesdk.widgets.dialog.InterceptDialog.OnButtonClickListener
            public void onLeftButtonClick() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1672451350")) {
                    ipChange2.ipc$dispatch("-1672451350", new Object[]{this});
                    return;
                }
                activity.onBackPressed();
                InterceptDialogHelper.getsInstance().reportDialogLeftButtonClick(DagoLiveFullInfoV4Plugin.this.mPageName, DagoLiveFullInfoV4Plugin.this.mLiveId, DagoLiveFullInfoV4Plugin.this.mScreenId, DagoLiveFullInfoV4Plugin.this.mLiveType);
            }

            @Override // com.youku.live.livesdk.widgets.dialog.InterceptDialog.OnButtonClickListener
            public void onRightButtonClick() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-707677385")) {
                    ipChange2.ipc$dispatch("-707677385", new Object[]{this});
                    return;
                }
                DagoLiveFullInfoV4Plugin.this.mInterceptDialog.dismiss();
                Nav.from(activity).toUri(str4);
                DagoLiveFullInfoV4Plugin.this.getEngineInstance().asyncPutData(DagoExitPlayer.ENTER_PIP_MODE_BY_WEEX_NOTIFY, 4);
                InterceptDialogHelper.getsInstance().reportDialogRightButtonClick(DagoLiveFullInfoV4Plugin.this.mPageName, DagoLiveFullInfoV4Plugin.this.mLiveId, DagoLiveFullInfoV4Plugin.this.mScreenId, DagoLiveFullInfoV4Plugin.this.mLiveType, str4);
            }
        });
        this.mInterceptDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.youku.live.livesdk.widgets.plugin.DagoLiveFullInfoV4Plugin.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1424774513")) {
                    ipChange2.ipc$dispatch("1424774513", new Object[]{this, dialogInterface});
                    return;
                }
                InterceptDialogHelper.getsInstance().addLiveId(DagoLiveFullInfoV4Plugin.this.mLiveId);
                InterceptDialogHelper.getsInstance().reportDialogLeftButtonShow(DagoLiveFullInfoV4Plugin.this.mPageName, DagoLiveFullInfoV4Plugin.this.mLiveId, DagoLiveFullInfoV4Plugin.this.mScreenId, DagoLiveFullInfoV4Plugin.this.mLiveType);
                InterceptDialogHelper.getsInstance().reportDialogRightButtonShow(DagoLiveFullInfoV4Plugin.this.mPageName, DagoLiveFullInfoV4Plugin.this.mLiveId, DagoLiveFullInfoV4Plugin.this.mScreenId, DagoLiveFullInfoV4Plugin.this.mLiveType, str4);
                InterceptDialogHelper.getsInstance().reportDialogCloseButtonShow(DagoLiveFullInfoV4Plugin.this.mPageName, DagoLiveFullInfoV4Plugin.this.mLiveId, DagoLiveFullInfoV4Plugin.this.mScreenId, DagoLiveFullInfoV4Plugin.this.mLiveType);
            }
        });
        this.mInterceptDialog.setData(str, str2, str3);
    }

    private void didAppearForFirstFrame() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "280670798")) {
            ipChange.ipc$dispatch("280670798", new Object[]{this});
        } else {
            asyncTimeoutForFirstFrame();
        }
    }

    private void didDisappearForFirstFrame() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-133871160")) {
            ipChange.ipc$dispatch("-133871160", new Object[]{this});
            return;
        }
        removeTimeoutForFirstFrame();
        signalSetFirstFrame(false, CARD_DID_DISAPPEAR);
    }

    private int getTimeoutOfFirstFrame() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1517114316") ? ((Integer) ipChange.ipc$dispatch("-1517114316", new Object[]{this})).intValue() : ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getInt("YKLiveRoom_ABTest", "signalFirstFrameTimeout", 2000);
    }

    private void initDagoChannelListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1466069768")) {
            ipChange.ipc$dispatch("1466069768", new Object[]{this});
            return;
        }
        IEngineInstance engineInstance = getEngineInstance();
        if (engineInstance != null) {
            IPlugin findPluginByName = engineInstance.findPluginByName("DagoChannel");
            if (findPluginByName instanceof DagoChannelPlugin) {
                MyLog.d(TAG, "initDagoChannelListener DagoChannel");
                ((DagoChannelPlugin) findPluginByName).addListener(this);
            }
        }
    }

    private void initInterceptDialog(LiveFullInfoData liveFullInfoData) {
        WidgetInitDTO widgetInitDTO;
        List<SimpleWidgetDTO> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "393467722")) {
            ipChange.ipc$dispatch("393467722", new Object[]{this, liveFullInfoData});
            return;
        }
        this.mScreenId = liveFullInfoData.screenId + "";
        Integer num = liveFullInfoData.liveStatus;
        int intValue = num != null ? num.intValue() : 0;
        if (intValue == 0) {
            this.mLiveType = "预约";
        } else if (intValue == 1) {
            this.mLiveType = "直播";
        } else {
            this.mLiveType = "回看";
        }
        Activity activity = ViewUtils.getActivity(getEngineInstance().getContext());
        if (activity == null || activity.isFinishing() || (widgetInitDTO = liveFullInfoData.widgets) == null || (list = widgetInitDTO.widgetList) == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            SimpleWidgetDTO simpleWidgetDTO = list.get(i);
            if (simpleWidgetDTO != null && "bubble".equals(simpleWidgetDTO.name)) {
                parseInterceptData(simpleWidgetDTO);
                return;
            }
        }
    }

    private void initWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2121274957")) {
            ipChange.ipc$dispatch("-2121274957", new Object[]{this});
            return;
        }
        Object data = getEngineInstance().getData(DagoDataCenterConstants.DAGO_LIVE_ID);
        if (data instanceof String) {
            this.mLiveId = (String) data;
        }
        getEngineInstance().addDataHandlers(new String[]{PLAYER_FIRST_FRAME, AUDIO_FIRST_FRAME, PLAYER_FIRST_ERROR, "mtop.youku.live.com.livefullinfo"}, this);
    }

    private void onFirstFrame(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1657856110")) {
            ipChange.ipc$dispatch("1657856110", new Object[]{this, str});
        } else {
            signalSetFirstFrame(true, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFirstFrameTimeout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-276847739")) {
            ipChange.ipc$dispatch("-276847739", new Object[]{this});
        } else {
            signalSetFirstFrame(true, WAIT_TIMEOUT);
        }
    }

    private void parseInterceptData(SimpleWidgetDTO simpleWidgetDTO) {
        JSON json;
        JSONObject parseObject;
        JSONObject jSONObject;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-778867741")) {
            ipChange.ipc$dispatch("-778867741", new Object[]{this, simpleWidgetDTO});
        } else if (simpleWidgetDTO == null || (json = simpleWidgetDTO.trustData) == null) {
        } else {
            String jSONString = json.toJSONString();
            if (!TextUtils.isEmpty(jSONString) && (parseObject = JSON.parseObject(jSONString)) != null && parseObject.containsKey("openState") && parseObject.containsKey("customInfo") && "1".equals(parseObject.getString("openState")) && (jSONObject = parseObject.getJSONObject("customInfo")) != null && jSONObject.containsKey("type") && jSONObject.containsKey("bgImg") && jSONObject.containsKey("leftBtnImg") && jSONObject.containsKey("rightBtnImg") && jSONObject.containsKey("rightBtnLinkUrl") && "1".equals(jSONObject.getString("type"))) {
                String string = jSONObject.getString("bgImg");
                String string2 = jSONObject.getString("leftBtnImg");
                String string3 = jSONObject.getString("rightBtnImg");
                String string4 = jSONObject.getString("rightBtnLinkUrl");
                z = (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3) || TextUtils.isEmpty(string4)) ? false : false;
                this.mCanShow = z;
                if (z) {
                    createInterceptDialog(string, string2, string3, string4);
                }
            }
        }
    }

    private void releaseDagoChannelListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1791233163")) {
            ipChange.ipc$dispatch("-1791233163", new Object[]{this});
            return;
        }
        IEngineInstance engineInstance = getEngineInstance();
        if (engineInstance != null) {
            IPlugin findPluginByName = engineInstance.findPluginByName("DagoChannel");
            if (findPluginByName instanceof DagoChannelPlugin) {
                MyLog.d(TAG, "releaseDagoChannelListener DagoChannel");
                ((DagoChannelPlugin) findPluginByName).removeListener(this);
            }
        }
    }

    private void releaseWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1121134368")) {
            ipChange.ipc$dispatch("1121134368", new Object[]{this});
        }
    }

    private void removeTimeoutForFirstFrame() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1344696297")) {
            ipChange.ipc$dispatch("-1344696297", new Object[]{this});
        } else {
            getEngineInstance().removeFromMainThread(this.asyncTimeoutForFirstFrame);
        }
    }

    private synchronized void signalSetFirstFrame(boolean z, String str) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1186190699")) {
            ipChange.ipc$dispatch("1186190699", new Object[]{this, Boolean.valueOf(z), str});
            return;
        }
        Log.e(TAG, "signalSetFirstFrame: " + this.mLiveId + "; source:" + str + "; hasFirstFrame:" + z + "; signalForFirstFrame:" + this.signalForFirstFrame + ";" + this);
        if (z != this.signalForFirstFrame) {
            this.signalForFirstFrame = z;
            if (z) {
                Log.e(TAG, "DAGO_SIGNAL_FIRST_FRAME: " + this.mLiveId + "; true;" + this);
                getEngineInstance().putData("dagoSignalFirstFrame", Boolean.TRUE);
            } else {
                Log.e(TAG, "DAGO_SIGNAL_FIRST_FRAME: " + this.mLiveId + "; false;" + this);
                getEngineInstance().putData("dagoSignalFirstFrame", Boolean.FALSE);
            }
            if (!WAIT_TIMEOUT.equals(str) && !PLAYER_FIRST_ERROR.equals(str) && !AUDIO_FIRST_FRAME.equals(str)) {
                i = 500;
            }
            asyncSignalSetFirstFrameImp(z, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void signalSetFirstFrameImp(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2140950665")) {
            ipChange.ipc$dispatch("2140950665", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        Log.e(TAG, "signalSetFirstFrame: " + this.mLiveId + "; hasFirstFrame:" + z + "; signalForFirstFrame:" + this.signalForFirstFrame + ";" + this);
        if (z != this.signalForFirstFrame) {
            this.signalForFirstFrame = z;
            if (z) {
                Log.e(TAG, "DAGO_SIGNAL_FIRST_FRAME: " + this.mLiveId + "; true;" + this);
                getEngineInstance().putData("dagoSignalFirstFrame", Boolean.TRUE);
                return;
            }
            Log.e(TAG, "DAGO_SIGNAL_FIRST_FRAME: " + this.mLiveId + "; false;" + this);
            getEngineInstance().putData("dagoSignalFirstFrame", Boolean.FALSE);
        }
    }

    @Override // com.youku.live.widgets.impl.BasePlugin, com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-923195184")) {
            ipChange.ipc$dispatch("-923195184", new Object[]{this});
        } else {
            super.destroy();
        }
    }

    @Override // com.youku.live.widgets.impl.BasePlugin, com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void didAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "792459862")) {
            ipChange.ipc$dispatch("792459862", new Object[]{this});
        } else {
            didAppearForFirstFrame();
        }
    }

    @Override // com.youku.live.widgets.impl.BasePlugin, com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void didDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1559151772")) {
            ipChange.ipc$dispatch("1559151772", new Object[]{this});
            return;
        }
        didDisappearForFirstFrame();
        releaseDagoChannelListener();
    }

    @Override // com.youku.live.widgets.impl.BasePlugin, com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener
    public void didUnmount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1596119937")) {
            ipChange.ipc$dispatch("-1596119937", new Object[]{this});
        } else {
            releaseWithNothing();
        }
    }

    @Override // com.youku.live.widgets.impl.BasePlugin, com.youku.live.widgets.protocol.IPlugin
    public void initWithData(IEngineInstance iEngineInstance, IPluginData iPluginData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "681803418")) {
            ipChange.ipc$dispatch("681803418", new Object[]{this, iEngineInstance, iPluginData});
            return;
        }
        super.initWithData(iEngineInstance, iPluginData);
        String string = iPluginData.getOptions().getString("liveid", "");
        this.mPageName = iPluginData.getOptions().getString("pagename", "");
        this.mLiveId = string;
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityBackPressedListener
    public boolean onActivityBackPressed() {
        InterceptDialog interceptDialog;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2703135")) {
            return ((Boolean) ipChange.ipc$dispatch("-2703135", new Object[]{this})).booleanValue();
        }
        if (WidgetSDKEngine.getOrientation() != Orientation.ORIENTATION_PORTAIT || (interceptDialog = this.mInterceptDialog) == null) {
            return false;
        }
        if (interceptDialog.isShowing()) {
            this.mInterceptDialog.dismiss();
            return false;
        }
        if (this.mCanShow && !InterceptDialogHelper.getsInstance().containsLiveId(this.mLiveId)) {
            if (ViewUtils.getActivity(getEngineInstance().getContext()) != null) {
                this.mInterceptDialog.show();
            }
            return true;
        }
        return false;
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1641867423")) {
            ipChange.ipc$dispatch("-1641867423", new Object[]{this, str, obj, obj2});
        } else if (PLAYER_FIRST_FRAME.equals(str)) {
            Log.e(TAG, "PLAYER_FIRST_FRAME");
            onFirstFrame(PLAYER_FIRST_FRAME);
        } else if (AUDIO_FIRST_FRAME.equals(str)) {
            Log.e(TAG, "AUDIO_FIRST_FRAME");
            onFirstFrame(AUDIO_FIRST_FRAME);
        } else if (PLAYER_FIRST_ERROR.equals(str)) {
            Log.e(TAG, "PLAYER_FIRST_ERROR");
            onFirstFrame(PLAYER_FIRST_ERROR);
        } else if ("mtop.youku.live.com.livefullinfo".equals(str) && (obj instanceof LiveFullInfoData)) {
            LiveFullInfoData liveFullInfoData = (LiveFullInfoData) obj;
            if (InterceptDialogHelper.getsInstance().containsLiveId(this.mLiveId)) {
                return;
            }
            initInterceptDialog(liveFullInfoData);
        }
    }

    @Override // com.youku.live.livesdk.widgets.plugin.DagoChannelPlugin.Receiver
    public void onMessage(DagoChannelPlugin.Message message) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "92354871")) {
            ipChange.ipc$dispatch("92354871", new Object[]{this, message});
        } else if (message == null || (str = message.msgType) == null) {
        } else {
            if ("userRoomKickoutV2".equals(str)) {
                try {
                    JSONObject jSONObject = JSON.parseObject(message.data).getJSONArray("args").getJSONObject(0).getJSONObject("body");
                    getEngineInstance().asyncPutData("userRoomKickoutV2", Boolean.valueOf(((IUser) Dsl.getService(IUser.class)).getId().equals(jSONObject.getString("ytid"))), jSONObject.getString(WXComponent.PROP_FS_MATCH_PARENT));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else if (NAME_CHAT_BAN.equals(message.msgType)) {
                try {
                    ((IToast) Dsl.getService(IToast.class)).showCenterToast(Dsl.getContext(), "1".equals(JSON.parseObject(message.data).getJSONArray("args").getJSONObject(0).getJSONObject("data").getString("chatBanEnum")) ? "你已被禁言" : "你已被取消禁言");
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }

    @Override // com.youku.live.widgets.impl.BasePlugin, com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void willAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "785513049")) {
            ipChange.ipc$dispatch("785513049", new Object[]{this});
        } else {
            initDagoChannelListener();
        }
    }

    @Override // com.youku.live.widgets.impl.BasePlugin, com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener
    public void willMount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-24398589")) {
            ipChange.ipc$dispatch("-24398589", new Object[]{this});
        } else {
            initWithNothing();
        }
    }

    private void asyncSignalSetFirstFrameImp(boolean z, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2143727688")) {
            ipChange.ipc$dispatch("2143727688", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i)});
            return;
        }
        getEngineInstance().removeFromMainThread(this.asyncSignalSetFirstFrameImpTrue);
        getEngineInstance().removeFromMainThread(this.asyncSignalSetFirstFrameImpFalse);
        getEngineInstance().delayRunOnMainThread(z ? this.asyncSignalSetFirstFrameImpTrue : this.asyncSignalSetFirstFrameImpFalse, i);
    }
}
