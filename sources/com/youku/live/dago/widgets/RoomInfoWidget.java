package com.youku.live.dago.widgets;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alibaba.fastjson.JSON;
import com.alibaba.wireless.security.aopsdk.report.ReportManager;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.alipay.sdk.m.s.C4293a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OrangeConfig;
import com.youku.live.dago.broadcast.BroadCastConstants;
import com.youku.live.dago.broadcast.BroadCastManager;
import com.youku.live.dago.model.LiveInfoGetInfoModel;
import com.youku.live.dago.model.data.LiveInfoGetAnchorInfoDataModel;
import com.youku.live.dago.model.event.FollowAnchorEvent;
import com.youku.live.dago.module.DagoPlayerInteract;
import com.youku.live.dago.utils.DataUtils;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailproom.adapter.userlist.UserListBean;
import com.youku.live.dago.widgetlib.ailproom.adapter.userlist.UserListView;
import com.youku.live.dago.widgetlib.util.FastJsonTools;
import com.youku.live.dago.widgetlib.util.ToastUtil;
import com.youku.live.dago.widgetlib.view.anchor.DagoAnchorInfoView;
import com.youku.live.dago.widgetlib.view.guard.LFAnchorGuardButton;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.account.ILogin;
import com.youku.live.dsl.account.ILoginChangedListener;
import com.youku.live.dsl.account.IUser;
import com.youku.live.dsl.alarm.ILiveAlarm;
import com.youku.live.dsl.config.IConfig;
import com.youku.live.dsl.config.IConfigImp;
import com.youku.live.dsl.json.IDeserialize;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.network.INetCallback;
import com.youku.live.dsl.network.INetClient;
import com.youku.live.dsl.network.INetResponse;
import com.youku.live.dsl.usertrack.IUserTracker;
import com.youku.live.livesdk.model.mtop.base.MtopLiveBaseDataBean;
import com.youku.live.livesdk.model.mtop.data.LiveFullInfoData;
import com.youku.live.livesdk.preloader.YKPrefReporter;
import com.youku.live.livesdk.widgets.container.pager.model.LiveInfoModel;
import com.youku.live.livesdk.widgets.container.pager.model.SwitchItemModel;
import com.youku.live.livesdk.widgets.plugin.DagoChannelPlugin;
import com.youku.live.livesdk.widgets.plugin.DagoLiveFullInfoV4Plugin;
import com.youku.live.livesdk.wkit.widget.LiveWeexWidget;
import com.youku.live.widgets.ActivityLifecycleState;
import com.youku.live.widgets.WidgetSDKEngine;
import com.youku.live.widgets.dom.CSSLayout;
import com.youku.live.widgets.impl.BaseWidget;
import com.youku.live.widgets.protocol.ICall;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IPlugin;
import com.youku.live.widgets.protocol.IProps;
import com.youku.live.widgets.protocol.IResult;
import com.youku.live.widgets.protocol.IWidget;
import com.youku.live.widgets.protocol.IWidgetData;
import com.youku.live.widgets.protocol.Orientation;
import com.youku.live.widgets.protocol.activity.IActivityLifecycleStateChangedListener;
import de.greenrobot.event.EventBus;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;
import tb.tx0;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class RoomInfoWidget extends BaseWidget implements UserListView.IClickCallback, ILoginChangedListener, DagoChannelPlugin.Receiver, ICall, IDataHandler, IActivityLifecycleStateChangedListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int BIZ_TYPE_LAIFENG = 3;
    public static final int BIZ_TYPE_PGC = 6;
    private static final String BubbleUserList = "BubbleUserList";
    private static final String DAGO_LIVE_START_OR_STOP_PROP = "dagoLiveStartOrStopProp";
    public static final int DATA_TYPE_ANCHOR_FANS = 1;
    public static final int DATA_TYPE_ANCHOR_INCOME = 2;
    public static final int DATA_TYPE_DISMISS = 0;
    public static final int DATA_TYPE_UNKOWN = -1;
    public static final String DEVICE_TYPE_ANDROID_PHONE = "6";
    public static final String DEVICE_TYPE_IPAD_APP = "5";
    public static final String DEVICE_TYPE_IPHONE_APP = "4";
    public static final String DEVICE_TYPE_MOBILE_WEB = "3";
    public static final String DEVICE_TYPE_PC_APP = "2";
    public static final String DEVICE_TYPE_PC_WEB = "1";
    private static final String MC_MSG_TYPE_ATTENTION = "attention";
    private static final String MC_MSG_TYPE_ROOM_HOT = "room_hot";
    private static final String MC_MSG_TYPE_USER_COUNT = "usercount";
    private static final String MC_MSG_TYPE_YKLIVE_PLATFORM_GIFT = "yklive_plaform_gift";
    public static final String METHOD_HIDE_LANDSCAPE = "hideOnLandscape";
    public static final String METHOD_HIDE_PORTRAIT = "hide";
    public static final String METHOD_SHOW_LANDSCAPE = "showOnLandscape";
    public static final String METHOD_SHOW_PORTRAIT = "show";
    public static final String MTOP_GET_INFO_API = "mtop.youku.live.widget.liveInfo.getInfo";
    public static final String MTOP_GET_INFO_VER = "1.0";
    public static final String MTOP_LAIFENG_SUBSCRIBE_API = "mtop.youku.laifeng.community.attention.ytid.do";
    public static final String MTOP_LAIFENG_SUBSCRIBE_VER = "1.0";
    public static final String MTOP_RET_CODE_RELATION_EXISTS = "-302";
    public static final String MTOP_RET_CODE_SUCCESS = "SUCCESS";
    public static final String MTOP_TUDOU_SUBSCRIBE_API = "mtop.tudou.subscribe.relation.RelationServiceMTOP.create";
    public static final String MTOP_TUDOU_SUBSCRIBE_VER = "1.1";
    private static final String NAME_SCREEN_STAT_INFO_RESPONSE = "ScreenStatInfo_response";
    public static final String PARAM_KEY_ANCHOR_INFO_CALLBACK = "anchorInfoCallback";
    public static final String PARAM_KEY_AVATAR_URL = "avatarUrl";
    public static final String PARAM_KEY_FANS_COUNT = "fansCount";
    public static final String PARAM_KEY_FOLLOWED = "followed";
    public static final String PARAM_KEY_INCOME = "income";
    public static final String PARAM_KEY_INCOME_ICON = "incomeIcon";
    public static final String PARAM_KEY_NICK_NAME = "nickName";
    public static final String PARAM_KEY_TITLE = "title";
    private static final String PS_UPDATE = "psUpdate";
    public static final long ROOM_ID_UNKNOWN = -1;
    public static final String TAG = "RoomInfoWidget";
    public static final int TITLE_TYPE_ANCHOR_NICK_NAME = 1;
    public static final int TITLE_TYPE_ANCHOR_REAL_NAME = 3;
    public static final int TITLE_TYPE_ANCHOR_TITLE = 2;
    public static final int TITLE_TYPE_UNKNOWN = -1;
    private static final String USER_COUNT = "usercount";
    public static final String WIDGET_NAME = "RoomInfo";
    public static final int YK_SOURCE_LAIFENG = 0;
    public static final int YK_SOURCE_UNKNOWN = -1;
    public static final int YK_SOURCE_YOUKU = 1;
    private String mAnchorId;
    private LiveInfoGetAnchorInfoDataModel mAnchorInfoData;
    private DagoAnchorInfoView mAnchorInfoView;
    private Context mContext;
    private boolean mIsLogin;
    private LFAnchorGuardButton mLFAnchorGuardButton;
    private LiveFullInfoData mLiveFullInfo;
    private Handler mMainHandler;
    private LocalBroadCastReciver mReciver;
    private String mRoomId;
    private FrameLayout mRoot;
    private SwitchItemModel mSwitchItemModel;
    private UserListView mUserListView;
    private int currentBizType = 6;
    private boolean userListRequested = false;
    private boolean mIsInit = false;
    private long roomIdInt = -1;
    private int ykSourceInt = 1;
    private int dataTypeInt = -1;
    private int titleTypeInt = -1;
    private boolean supportAnchorInfo = true;
    private boolean supportAnchorInfoFolllowAction = false;
    private boolean mRoomInfoDelay = true;
    private boolean mViewInited = false;
    private boolean mShowGuard = false;
    private ConcurrentLinkedQueue<DagoChannelPlugin.Message> mMessageQueue = new ConcurrentLinkedQueue<>();
    private ConcurrentLinkedQueue<ChangeData> mChangeDataQueue = new ConcurrentLinkedQueue<>();
    private boolean mLooping = false;
    private LFAnchorGuardButton.GuardClickListener guardClickListener = new LFAnchorGuardButton.GuardClickListener() { // from class: com.youku.live.dago.widgets.RoomInfoWidget.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.youku.live.dago.widgetlib.view.guard.LFAnchorGuardButton.GuardClickListener
        public void onGuardClicked() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "4689641")) {
                ipChange.ipc$dispatch("4689641", new Object[]{this});
            } else {
                RoomInfoWidget.this.openGuard();
            }
        }
    };
    private long currentCount = 0;
    private Runnable mRoomInfoDelayRunnable = new Runnable() { // from class: com.youku.live.dago.widgets.RoomInfoWidget.13
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-430245980")) {
                ipChange.ipc$dispatch("-430245980", new Object[]{this});
            } else if (!RoomInfoWidget.this.mViewInited) {
                try {
                    Log.d(RoomInfoWidget.TAG, "mRoomInfoDelayRunnable first run");
                    RoomInfoWidget roomInfoWidget = RoomInfoWidget.this;
                    roomInfoWidget.initView(roomInfoWidget.mContext);
                    RoomInfoWidget.this.initWithDataInteral();
                    RoomInfoWidget.this.didMountInteral();
                    RoomInfoWidget.this.willAppearInternal();
                    if (RoomInfoWidget.this.mLooping) {
                        return;
                    }
                    RoomInfoWidget.this.mLooping = true;
                    RoomInfoWidget.this.mMainHandler.post(RoomInfoWidget.this.loopRunnable);
                } catch (Exception e) {
                    ((ILiveAlarm) Dsl.getService(ILiveAlarm.class)).alarm("NewLiveRoom-RoomInfoWidget-delay", "1001", "delay error:" + e.getMessage());
                    e.printStackTrace();
                }
            } else {
                Log.d(RoomInfoWidget.TAG, "mRoomInfoDelayRunnable already run");
            }
        }
    };
    private Runnable loopRunnable = new Runnable() { // from class: com.youku.live.dago.widgets.RoomInfoWidget.14
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-626759485")) {
                ipChange.ipc$dispatch("-626759485", new Object[]{this});
                return;
            }
            if (!RoomInfoWidget.this.mMessageQueue.isEmpty()) {
                RoomInfoWidget roomInfoWidget = RoomInfoWidget.this;
                roomInfoWidget.processMessage((DagoChannelPlugin.Message) roomInfoWidget.mMessageQueue.poll());
            }
            if (!RoomInfoWidget.this.mChangeDataQueue.isEmpty()) {
                ChangeData changeData = (ChangeData) RoomInfoWidget.this.mChangeDataQueue.poll();
                RoomInfoWidget.this.processDataChange(changeData.key, changeData.data1, changeData.data2);
            }
            if (RoomInfoWidget.this.mLooping) {
                RoomInfoWidget.this.mMainHandler.postDelayed(RoomInfoWidget.this.loopRunnable, 50L);
            }
        }
    };
    private boolean mIsWeexMakePortraitThisVisible = true;
    private boolean mIsWeexMakeLandscapeThisVisible = true;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private class ChangeData {
        Object data1;
        Object data2;
        String key;

        public ChangeData(String str, Object obj, Object obj2) {
            this.key = str;
            this.data1 = obj;
            this.data2 = obj2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class LocalBroadCastReciver extends BroadcastReceiver {
        LocalBroadCastReciver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(BroadCastConstants.ACTION_ATTENTION)) {
                RoomInfoWidget.this.attention(intent.getExtras().getLong(BroadCastConstants.KEY_TARGETUSERID));
            } else if (action.equals(BroadCastConstants.ACTION_UNATTENTTION)) {
                RoomInfoWidget.this.unAttention(intent.getExtras().getLong(BroadCastConstants.KEY_TARGETUSERID));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void attentionYouku(final long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1632478066")) {
            ipChange.ipc$dispatch("1632478066", new Object[]{this, Long.valueOf(j)});
        } else if (isLoginOtherDoLogin()) {
            if (this.ykSourceInt != 1) {
                INetClient iNetClient = (INetClient) Dsl.getService(INetClient.class);
                HashMap hashMap = new HashMap(2);
                hashMap.put("id", this.mAnchorId);
                hashMap.put(ReportManager.e, this.mRoomId);
                hashMap.put("platform", "0");
                hashMap.put("did", "6");
                iNetClient.createRequestWithMTop(MTOP_LAIFENG_SUBSCRIBE_API, "1.0", hashMap, true, false).async(new INetCallback() { // from class: com.youku.live.dago.widgets.RoomInfoWidget.4
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.youku.live.dsl.network.INetCallback
                    public void onFinish(INetResponse iNetResponse) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1833409713")) {
                            ipChange2.ipc$dispatch("-1833409713", new Object[]{this, iNetResponse});
                        } else if (iNetResponse == null || iNetResponse.getRetCode() == null) {
                        } else {
                            String retCode = iNetResponse.getRetCode();
                            if (RoomInfoWidget.notUnmount(j, RoomInfoWidget.this.roomIdInt)) {
                                if ("-302".equals(retCode)) {
                                    RoomInfoWidget.this.updateAttentionStatus(j, true);
                                } else if ("SUCCESS".equals(retCode)) {
                                    RoomInfoWidget.this.updateAttentionStatus(j, true);
                                    ToastUtil.showCenter(RoomInfoWidget.this.mContext, "关注成功啦");
                                }
                                RoomInfoWidget.this.updateFollowed();
                            }
                        }
                    }
                });
                return;
            }
            INetClient iNetClient2 = (INetClient) Dsl.getService(INetClient.class);
            HashMap hashMap2 = new HashMap(2);
            hashMap2.put("target_id", this.mAnchorId);
            hashMap2.put("guid", "0");
            hashMap2.put("is_utdid", "true");
            hashMap2.put("platform", "0");
            hashMap2.put("did", "6");
            iNetClient2.createRequestWithMTop("mtop.tudou.subscribe.relation.RelationServiceMTOP.create", "1.1", hashMap2, false, false).async(new INetCallback() { // from class: com.youku.live.dago.widgets.RoomInfoWidget.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1813072338")) {
                        ipChange2.ipc$dispatch("-1813072338", new Object[]{this, iNetResponse});
                    } else if (iNetResponse == null || iNetResponse.getRetCode() == null) {
                    } else {
                        String retCode = iNetResponse.getRetCode();
                        if (RoomInfoWidget.notUnmount(j, RoomInfoWidget.this.roomIdInt)) {
                            if ("-302".equals(retCode)) {
                                RoomInfoWidget.this.updateAttentionStatus(j, true);
                            } else if ("SUCCESS".equals(retCode)) {
                                RoomInfoWidget.this.updateAttentionStatus(j, true);
                                ToastUtil.showCenter(RoomInfoWidget.this.mContext, "关注成功啦");
                                BroadCastManager.sendAttention(RoomInfoWidget.this.mContext, DataUtils.getLongNumberFromString(RoomInfoWidget.this.mAnchorId));
                            }
                            RoomInfoWidget.this.updateFollowed();
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void didMountInteral() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "810541632")) {
            ipChange.ipc$dispatch("810541632", new Object[]{this});
            return;
        }
        DagoAnchorInfoView dagoAnchorInfoView = this.mAnchorInfoView;
        if (dagoAnchorInfoView != null) {
            dagoAnchorInfoView.setVisibility(0);
        }
        initLoginListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forceOnMainThread(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1808207262")) {
            ipChange.ipc$dispatch("1808207262", new Object[]{this, runnable});
        } else if (runnable != null) {
            if (Looper.getMainLooper().equals(Looper.myLooper())) {
                runnable.run();
            } else {
                getEngineInstance().runOnMainThread(runnable);
            }
        }
    }

    private static String formatFansCount(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1875372975")) {
            return (String) ipChange.ipc$dispatch("-1875372975", new Object[]{Long.valueOf(j)});
        }
        return formatNumber(j) + " 粉丝";
    }

    private static String formatIncome(long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1438297945") ? (String) ipChange.ipc$dispatch("1438297945", new Object[]{Long.valueOf(j)}) : formatNumber(j);
    }

    private static String formatNumber(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1649260985")) {
            return (String) ipChange.ipc$dispatch("1649260985", new Object[]{Long.valueOf(j)});
        }
        double d = j;
        if (d < 100000.0d) {
            return String.valueOf(j);
        }
        if (d >= 100000.0d && d < 1.0E8d) {
            return formatNumber(String.valueOf(d / 10000.0d), "万");
        }
        return formatNumber(String.valueOf(d / 1.0E8d), "亿");
    }

    private String getOrientationLogText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2071131690") ? (String) ipChange.ipc$dispatch("2071131690", new Object[]{this}) : WidgetSDKEngine.getOrientation() == Orientation.ORIENTATION_LANDSCAPE ? "fplayer" : "vplayer";
    }

    private void initDagoChannelListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1957940523")) {
            ipChange.ipc$dispatch("1957940523", new Object[]{this});
            return;
        }
        IEngineInstance engineInstance = getEngineInstance();
        if (engineInstance != null) {
            IPlugin findPluginByName = engineInstance.findPluginByName("DagoChannel");
            if (findPluginByName instanceof DagoChannelPlugin) {
                ((DagoChannelPlugin) findPluginByName).addListener(this);
            }
        }
    }

    private void initDataCenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1260904306")) {
            ipChange.ipc$dispatch("-1260904306", new Object[]{this});
            return;
        }
        getEngineInstance().addDataHandler("mtop.youku.live.com.livefullinfo", this);
        getEngineInstance().addDataHandler("mtop.youku.live.widget.liveInfo.getInfo", this);
        getEngineInstance().addDataHandler(DagoLiveFullInfoV4Plugin.PLAYER_FIRST_FRAME, this);
    }

    private void initLoginListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1165263360")) {
            ipChange.ipc$dispatch("1165263360", new Object[]{this});
            return;
        }
        ILogin iLogin = (ILogin) Dsl.getService(ILogin.class);
        if (iLogin == null) {
            this.mIsLogin = false;
        } else {
            iLogin.registerLoginChangedListener(this);
            this.mIsLogin = iLogin.isLogined();
        }
        if (this.mIsLogin) {
            refreshYoukuAnchorInfo(this.roomIdInt, this.ykSourceInt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1796024832")) {
            ipChange.ipc$dispatch("1796024832", new Object[]{this, context});
        } else if (this.mViewInited) {
        } else {
            Log.d(TAG, "initView real inflate View");
            this.mViewInited = true;
            if (this.mRoot.getChildCount() == 0) {
                LayoutInflater.from(context).inflate(R.C7942layout.dago_pgc_room_info_layout, this.mRoot);
            }
            this.mAnchorInfoView = (DagoAnchorInfoView) this.mRoot.findViewById(R.id.dago_anchor_info_layout);
            UserListView userListView = (UserListView) this.mRoot.findViewById(R.id.dago_header_user_list);
            this.mUserListView = userListView;
            userListView.setOnItemClickListener(this);
            LFAnchorGuardButton lFAnchorGuardButton = (LFAnchorGuardButton) this.mRoot.findViewById(R.id.dago_lf_anchor_guard_button);
            this.mLFAnchorGuardButton = lFAnchorGuardButton;
            lFAnchorGuardButton.setGuardListener(this.guardClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initWithDataInteral() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1656117926")) {
            ipChange.ipc$dispatch("1656117926", new Object[]{this});
            return;
        }
        this.mIsInit = false;
        if (this.mShowGuard) {
            this.mLFAnchorGuardButton.setVisibility(0);
        } else {
            this.mLFAnchorGuardButton.setVisibility(8);
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "initWithDataInteral...");
    }

    private boolean isLinkLiving() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1077491604")) {
            return ((Boolean) ipChange.ipc$dispatch("1077491604", new Object[]{this})).booleanValue();
        }
        IEngineInstance engineInstance = getEngineInstance();
        if (engineInstance != null) {
            Object data = engineInstance.getData("dagoLiveStartOrStopProp");
            if ((data instanceof Boolean) && !((Boolean) data).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    private boolean isLoginOtherDoLogin() {
        ILogin iLogin;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2056423844")) {
            return ((Boolean) ipChange.ipc$dispatch("2056423844", new Object[]{this})).booleanValue();
        }
        if (((IUser) Dsl.getService(IUser.class)) == null || (iLogin = (ILogin) Dsl.getService(ILogin.class)) == null) {
            return false;
        }
        if (iLogin.isLogined()) {
            return true;
        }
        iLogin.login();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logAnchorClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1470565486")) {
            ipChange.ipc$dispatch("1470565486", new Object[]{this});
            return;
        }
        IProps options = getOptions();
        if (options == null) {
            return;
        }
        String string = options.getString("pagename", "");
        HashMap hashMap = new HashMap();
        hashMap.put("anchor-id", this.mAnchorId + "");
        hashMap.put("direction", getOrientationLogText());
        hashMap.put(tx0.VALUE_MODEL_DEFAULT, options.getString("spm-cnt", ""));
        hashMap.put("spm", options.getString("spm-cnt", "") + ".liveinfo.all");
        hashMap.put("roomid", this.mRoomId);
        hashMap.put("pageName", string);
        if (this.mLiveFullInfo != null) {
            hashMap.put("screenid", "" + this.mLiveFullInfo.screenId);
        }
        hashMap.put("liveid", this.mRoomId);
        hashMap.put("spm-name", "liveinfo");
        hashMap.put("action", "clickAnchorInfo");
        String string2 = ((IConfig) Dsl.getService(IConfig.class)).getString(IConfigImp.NAMESPACE_LOCALCONFIG, "pid", "");
        if (!TextUtils.isEmpty(string2)) {
            hashMap.put("pid", string2);
        }
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(string, "liveinfo_all", hashMap);
    }

    private void logAnchorShow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-408417353")) {
            ipChange.ipc$dispatch("-408417353", new Object[]{this});
            return;
        }
        IProps options = getOptions();
        if (options == null) {
            return;
        }
        String string = options.getString("pagename", "");
        HashMap hashMap = new HashMap();
        hashMap.put("anchor-id", this.mAnchorId + "");
        hashMap.put("direction", getOrientationLogText());
        hashMap.put(tx0.VALUE_MODEL_DEFAULT, options.getString("spm-cnt", ""));
        hashMap.put("spm", options.getString("spm-cnt", "") + ".liveinfo.all");
        hashMap.put("roomid", this.mRoomId);
        hashMap.put("pageName", string);
        if (this.mLiveFullInfo != null) {
            hashMap.put("screenid", "" + this.mLiveFullInfo.screenId);
        }
        hashMap.put("liveid", this.mRoomId);
        hashMap.put("spm-name", "liveinfo");
        String string2 = ((IConfig) Dsl.getService(IConfig.class)).getString(IConfigImp.NAMESPACE_LOCALCONFIG, "pid", "");
        if (!TextUtils.isEmpty(string2)) {
            hashMap.put("pid", string2);
        }
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Show(string, "liveinfo_all", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logFollowClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "765905258")) {
            ipChange.ipc$dispatch("765905258", new Object[]{this});
            return;
        }
        IProps options = getOptions();
        if (options == null) {
            return;
        }
        String string = options.getString("pagename", "");
        HashMap hashMap = new HashMap();
        hashMap.put("anchor-id", this.mAnchorId + "");
        hashMap.put("direction", getOrientationLogText());
        hashMap.put(tx0.VALUE_MODEL_DEFAULT, options.getString("spm-cnt", ""));
        hashMap.put("spm", options.getString("spm-cnt", "") + ".liveinfo.all");
        hashMap.put("roomid", this.mRoomId);
        hashMap.put("pageName", string);
        if (this.mLiveFullInfo != null) {
            hashMap.put("screenid", "" + this.mLiveFullInfo.screenId);
        }
        hashMap.put("liveid", this.mRoomId);
        hashMap.put("spm-name", "liveinfo");
        hashMap.put("action", "clickFollowBtn");
        String string2 = ((IConfig) Dsl.getService(IConfig.class)).getString(IConfigImp.NAMESPACE_LOCALCONFIG, "pid", "");
        if (!TextUtils.isEmpty(string2)) {
            hashMap.put("pid", string2);
        }
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(string, "liveinfo_all", hashMap);
    }

    private void logUserListClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "382807490")) {
            ipChange.ipc$dispatch("382807490", new Object[]{this});
            return;
        }
        IProps options = getOptions();
        if (options == null) {
            return;
        }
        String string = options.getString("pagename", "");
        HashMap hashMap = new HashMap();
        hashMap.put("anchor-id", this.mAnchorId + "");
        hashMap.put("direction", getOrientationLogText());
        hashMap.put(tx0.VALUE_MODEL_DEFAULT, options.getString("spm-cnt", ""));
        hashMap.put("spm", options.getString("spm-cnt", "") + ".online.useramount");
        hashMap.put("roomid", this.mRoomId);
        hashMap.put("pageName", string);
        if (this.mLiveFullInfo != null) {
            hashMap.put("screenid", "" + this.mLiveFullInfo.screenId);
        }
        hashMap.put("liveid", this.mRoomId);
        hashMap.put("spm-name", "online");
        String string2 = ((IConfig) Dsl.getService(IConfig.class)).getString(IConfigImp.NAMESPACE_LOCALCONFIG, "pid", "");
        if (!TextUtils.isEmpty(string2)) {
            hashMap.put("pid", string2);
        }
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(string, "online_useramount", hashMap);
    }

    private void logUserListShow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-859148317")) {
            ipChange.ipc$dispatch("-859148317", new Object[]{this});
            return;
        }
        IProps options = getOptions();
        if (options == null) {
            return;
        }
        String string = options.getString("pagename", "");
        HashMap hashMap = new HashMap();
        hashMap.put("anchor-id", this.mAnchorId + "");
        hashMap.put("direction", getOrientationLogText());
        hashMap.put(tx0.VALUE_MODEL_DEFAULT, options.getString("spm-cnt", ""));
        hashMap.put("spm", options.getString("spm-cnt", "") + ".online.useramount");
        hashMap.put("roomid", this.mRoomId);
        hashMap.put("pageName", string);
        if (this.mLiveFullInfo != null) {
            hashMap.put("screenid", "" + this.mLiveFullInfo.screenId);
        }
        hashMap.put("liveid", this.mRoomId);
        hashMap.put("spm-name", "online");
        String string2 = ((IConfig) Dsl.getService(IConfig.class)).getString(IConfigImp.NAMESPACE_LOCALCONFIG, "pid", "");
        if (!TextUtils.isEmpty(string2)) {
            hashMap.put("pid", string2);
        }
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Show(string, "online_useramount", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean notUnmount(long j, long j2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1731477676") ? ((Boolean) ipChange.ipc$dispatch("-1731477676", new Object[]{Long.valueOf(j), Long.valueOf(j2)})).booleanValue() : j == j2 && j2 != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openGuard() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "437074130")) {
            ipChange.ipc$dispatch("437074130", new Object[]{this});
            return;
        }
        IWidget findWidgetById = getEngineInstance().findWidgetById("live-weex");
        if (findWidgetById instanceof ICall) {
            HashMap hashMap = new HashMap();
            hashMap.put(LiveWeexWidget.GLOBAL_EVENT_NAME, "openWidgetEvent");
            hashMap.put("name", "guard");
            ((ICall) findWidgetById).call(getEngineInstance(), LiveWeexWidget.GLOBAL_EVENT, hashMap, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUserCardDialog(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-178350412")) {
            ipChange.ipc$dispatch("-178350412", new Object[]{this, Long.valueOf(j)});
        } else if (DataUtils.getLongNumberFromString(this.mAnchorId, -1L) < 0) {
        } else {
            IWidget findWidgetById = getEngineInstance().findWidgetById("live-weex");
            if (findWidgetById instanceof ICall) {
                HashMap hashMap = new HashMap();
                hashMap.put(LiveWeexWidget.GLOBAL_EVENT_NAME, "openWidgetEvent");
                HashMap hashMap2 = new HashMap();
                hashMap2.put("id", this.mAnchorId);
                hashMap.put("name", "card");
                hashMap.put("ext", hashMap2);
                ((ICall) findWidgetById).call(getEngineInstance(), LiveWeexWidget.GLOBAL_EVENT, hashMap, null, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDataChange(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "594848582")) {
            ipChange.ipc$dispatch("594848582", new Object[]{this, str, obj, obj2});
        } else if ("mtop.youku.live.com.livefullinfo".equals(str)) {
            if (obj instanceof LiveFullInfoData) {
                updateWithLiveFullInfo((LiveFullInfoData) obj);
            }
        } else if ("mtop.youku.live.widget.liveInfo.getInfo".equals(str)) {
            if (obj instanceof LiveInfoGetAnchorInfoDataModel) {
                ((ILog) Dsl.getService(ILog.class)).e(TAG, "1111 onDataChanged:" + obj);
            } else if (obj instanceof String) {
                LiveInfoGetAnchorInfoDataModel liveInfoGetAnchorInfoDataModel = (LiveInfoGetAnchorInfoDataModel) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize((String) obj, LiveInfoGetAnchorInfoDataModel.class);
                if (liveInfoGetAnchorInfoDataModel != null) {
                    updateWithliveInfo(liveInfoGetAnchorInfoDataModel, this.roomIdInt);
                }
                ((ILog) Dsl.getService(ILog.class)).e(TAG, "2222 onDataChanged:" + obj);
            } else {
                ((ILog) Dsl.getService(ILog.class)).e(TAG, "3333 onDataChanged:" + obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processMessage(final DagoChannelPlugin.Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1446117908")) {
            ipChange.ipc$dispatch("1446117908", new Object[]{this, message});
        } else if (message == null) {
        } else {
            Log.d(TAG, "processMessage : " + message.msgType);
            long j = 0;
            if (MC_MSG_TYPE_ATTENTION.equals(message.msgType)) {
                Log.d(TAG, "onMessage 关注");
                if (this.dataTypeInt == 1) {
                    try {
                        j = JSON.parseObject(message.data).getJSONArray("args").getJSONObject(0).getJSONObject("body").getLongValue(C4293a.u);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    final HashMap hashMap = new HashMap(1);
                    hashMap.put("fansCount", Long.valueOf(j));
                    try {
                        final long longValue = Long.valueOf(message.channelId).longValue();
                        getEngineInstance().runOnMainThread(new Runnable() { // from class: com.youku.live.dago.widgets.RoomInfoWidget.6
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.lang.Runnable
                            public void run() {
                                IpChange ipChange2 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange2, "1800413552")) {
                                    ipChange2.ipc$dispatch("1800413552", new Object[]{this});
                                } else {
                                    RoomInfoWidget.this.updateAnchorInfo(longValue, hashMap);
                                }
                            }
                        });
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                ((ILog) Dsl.getService(ILog.class)).e(TAG, message.data);
            } else if (MC_MSG_TYPE_YKLIVE_PLATFORM_GIFT.equals(message.msgType)) {
                Log.d(TAG, "onMessage 关注");
                if (this.currentBizType != 3 && this.dataTypeInt == 2) {
                    try {
                        j = JSON.parseObject(message.data).getJSONArray("args").getJSONObject(0).getJSONObject("body").getLongValue("popularity");
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                    final HashMap hashMap2 = new HashMap(1);
                    hashMap2.put("income", Long.valueOf(j));
                    try {
                        final long longValue2 = Long.valueOf(message.channelId).longValue();
                        getEngineInstance().runOnMainThread(new Runnable() { // from class: com.youku.live.dago.widgets.RoomInfoWidget.7
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.lang.Runnable
                            public void run() {
                                IpChange ipChange2 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange2, "1603900047")) {
                                    ipChange2.ipc$dispatch("1603900047", new Object[]{this});
                                    return;
                                }
                                ((ILog) Dsl.getService(ILog.class)).i(RoomInfoWidget.TAG, "update pgc coins: " + hashMap2.get("income"));
                                RoomInfoWidget.this.updateAnchorInfo(longValue2, hashMap2);
                            }
                        });
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                    ((ILog) Dsl.getService(ILog.class)).e(TAG, message.data);
                }
            } else if (MC_MSG_TYPE_ROOM_HOT.equals(message.msgType)) {
                if (this.currentBizType != 6 && this.dataTypeInt == 2) {
                    try {
                        j = JSON.parseObject(message.data).getJSONArray("args").getJSONObject(0).getJSONObject("body").getLongValue("tht");
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                    final HashMap hashMap3 = new HashMap(1);
                    hashMap3.put("income", Long.valueOf(j));
                    try {
                        final long longValue3 = Long.valueOf(message.channelId).longValue();
                        getEngineInstance().runOnMainThread(new Runnable() { // from class: com.youku.live.dago.widgets.RoomInfoWidget.8
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.lang.Runnable
                            public void run() {
                                IpChange ipChange2 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange2, "1407386542")) {
                                    ipChange2.ipc$dispatch("1407386542", new Object[]{this});
                                    return;
                                }
                                ((ILog) Dsl.getService(ILog.class)).i(RoomInfoWidget.TAG, "update laifeng coins: " + hashMap3.get("income"));
                                RoomInfoWidget.this.updateAnchorInfo(longValue3, hashMap3);
                            }
                        });
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                    ((ILog) Dsl.getService(ILog.class)).e(TAG, message.data);
                }
            } else if (NAME_SCREEN_STAT_INFO_RESPONSE.equals(message.msgType)) {
                getEngineInstance().runOnMainThread(new Runnable() { // from class: com.youku.live.dago.widgets.RoomInfoWidget.9
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1210873037")) {
                            ipChange2.ipc$dispatch("1210873037", new Object[]{this});
                            return;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(message.data).optJSONArray("args").getJSONObject(0).getJSONObject("body");
                            if (jSONObject != null) {
                                RoomInfoWidget.this.mLFAnchorGuardButton.onScreenStatInfo(jSONObject.getInt(IRequestConst.PN), jSONObject.getInt("pt"));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } else if ("usercount".equals(message.msgType)) {
                getEngineInstance().runOnMainThread(new Runnable() { // from class: com.youku.live.dago.widgets.RoomInfoWidget.10
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "159294535")) {
                            ipChange2.ipc$dispatch("159294535", new Object[]{this});
                            return;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(message.data).optJSONArray("args").getJSONObject(0);
                            String optString = jSONObject.optString("usercount");
                            String optString2 = jSONObject.optString("roomid");
                            if (TextUtils.isEmpty(RoomInfoWidget.this.mRoomId) || !RoomInfoWidget.this.mRoomId.equals(optString2)) {
                                return;
                            }
                            RoomInfoWidget.this.mUserListView.setUserCount(Integer.parseInt(optString));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } else if (PS_UPDATE.equals(message.msgType)) {
                getEngineInstance().runOnMainThread(new Runnable() { // from class: com.youku.live.dago.widgets.RoomInfoWidget.11
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-37218970")) {
                            ipChange2.ipc$dispatch("-37218970", new Object[]{this});
                            return;
                        }
                        try {
                            if (RoomInfoWidget.this.mLFAnchorGuardButton != null) {
                                RoomInfoWidget.this.mLFAnchorGuardButton.onPurchaseGuardianUpdate(message.data);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } else if (BubbleUserList.equals(message.msgType)) {
                getEngineInstance().runOnMainThread(new Runnable() { // from class: com.youku.live.dago.widgets.RoomInfoWidget.12
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-233732475")) {
                            ipChange2.ipc$dispatch("-233732475", new Object[]{this});
                            return;
                        }
                        try {
                            List<UserListBean> deserializeList = FastJsonTools.deserializeList(new JSONObject(message.data).optJSONArray("args").getJSONObject(0).getJSONObject("body").getJSONArray("data").toString(), UserListBean.class);
                            if (RoomInfoWidget.this.mUserListView != null) {
                                RoomInfoWidget.this.mUserListView.updateUserList(deserializeList);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    private void refreshYoukuAnchorInfo(final long j, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1449354869")) {
            ipChange.ipc$dispatch("-1449354869", new Object[]{this, Long.valueOf(j), Integer.valueOf(i)});
        } else if (j == -1 || i == -1 || !this.mIsInit) {
        } else {
            INetClient iNetClient = (INetClient) Dsl.getService(INetClient.class);
            HashMap hashMap = new HashMap(2);
            hashMap.put("liveId", String.valueOf(j));
            hashMap.put("ykSoucre", String.valueOf(i));
            iNetClient.createRequestWithMTop("mtop.youku.live.widget.liveInfo.getInfo", "1.0", hashMap, false, false).async(new INetCallback() { // from class: com.youku.live.dago.widgets.RoomInfoWidget.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1853747088")) {
                        ipChange2.ipc$dispatch("-1853747088", new Object[]{this, iNetResponse});
                    } else if (iNetResponse == null || iNetResponse.getRetCode() == null || !iNetResponse.getRetCode().startsWith("SUCCESS")) {
                    } else {
                        ((ILog) Dsl.getService(ILog.class)).e(RoomInfoWidget.TAG, "mtop.youku.live.widget.liveInfo.getInfo => " + iNetResponse.getSource());
                        final LiveInfoGetInfoModel liveInfoGetInfoModel = (LiveInfoGetInfoModel) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(iNetResponse.getSource(), LiveInfoGetInfoModel.class);
                        if (liveInfoGetInfoModel != null) {
                            RoomInfoWidget.this.forceOnMainThread(new Runnable() { // from class: com.youku.live.dago.widgets.RoomInfoWidget.3.1
                                private static transient /* synthetic */ IpChange $ipChange;

                                @Override // java.lang.Runnable
                                public void run() {
                                    IpChange ipChange3 = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange3, "579622118")) {
                                        ipChange3.ipc$dispatch("579622118", new Object[]{this});
                                        return;
                                    }
                                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                    if (RoomInfoWidget.notUnmount(j, RoomInfoWidget.this.roomIdInt)) {
                                        AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                                        RoomInfoWidget.this.updateWithliveInfo(liveInfoGetInfoModel, j);
                                    }
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    private void registerAttentionReciver() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1742084242")) {
            ipChange.ipc$dispatch("-1742084242", new Object[]{this});
            return;
        }
        if (this.mReciver == null) {
            this.mReciver = new LocalBroadCastReciver();
        }
        BroadCastManager.registerAttention(this.mContext, this.mReciver);
        BroadCastManager.registerUnAttention(this.mContext, this.mReciver);
    }

    private void releaseDagoChannelListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1396982386")) {
            ipChange.ipc$dispatch("1396982386", new Object[]{this});
            return;
        }
        IEngineInstance engineInstance = getEngineInstance();
        if (engineInstance != null) {
            IPlugin findPluginByName = engineInstance.findPluginByName("DagoChannel");
            if (findPluginByName instanceof DagoChannelPlugin) {
                ((DagoChannelPlugin) findPluginByName).removeListener(this);
            }
        }
    }

    private void releaseDataCenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1352904857")) {
            ipChange.ipc$dispatch("-1352904857", new Object[]{this});
            return;
        }
        getEngineInstance().removeDataHandler("mtop.youku.live.com.livefullinfo", this);
        getEngineInstance().removeDataHandler("mtop.youku.live.widget.liveInfo.getInfo", this);
        getEngineInstance().removeDataHandler(DagoLiveFullInfoV4Plugin.PLAYER_FIRST_FRAME, this);
    }

    private void releaseLoginListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "565983367")) {
            ipChange.ipc$dispatch("565983367", new Object[]{this});
            return;
        }
        ILogin iLogin = (ILogin) Dsl.getService(ILogin.class);
        if (iLogin != null) {
            iLogin.unregisterLoginChangedListener(this);
        }
        this.mIsLogin = false;
    }

    private void unRegisterAttentionReciver() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-323373291")) {
            ipChange.ipc$dispatch("-323373291", new Object[]{this});
        } else {
            BroadCastManager.unregisterAttentionReciver(this.mContext, this.mReciver);
        }
    }

    private void updateAnchorId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-14812082")) {
            ipChange.ipc$dispatch("-14812082", new Object[]{this, str});
        } else {
            this.mAnchorId = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateAnchorInfo(final long r13, java.util.Map<java.lang.String, java.lang.Object> r15) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgets.RoomInfoWidget.updateAnchorInfo(long, java.util.Map):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:6|(2:7|8)|(2:9|10)|(2:12|13)|(13:15|16|17|(1:19)|20|21|22|23|24|25|(2:27|(1:29)(1:32))(1:33)|30|31)|43|16|17|(0)|20|21|22|23|24|25|(0)(0)|30|31) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
        r2.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006b, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006c, code lost:
        r2.printStackTrace();
        r2 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007b, code lost:
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007c, code lost:
        r9.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void updateAnchorInfoWidgetAttribute(com.youku.live.livesdk.model.mtop.data.LiveFullInfoData r8, com.alibaba.fastjson.JSONObject r9) {
        /*
            r7 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.dago.widgets.RoomInfoWidget.$ipChange
            java.lang.String r1 = "-523811561"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L1a
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r6] = r7
            r2[r5] = r8
            r2[r4] = r9
            r0.ipc$dispatch(r1, r2)
            return
        L1a:
            r8 = -1
            java.lang.String r0 = "ykSource"
            java.lang.Integer r0 = r9.getInteger(r0)     // Catch: java.lang.Throwable -> L26
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L26
            goto L2b
        L26:
            r0 = move-exception
            r0.printStackTrace()
            r0 = -1
        L2b:
            java.lang.String r1 = "bizType"
            java.lang.Integer r1 = r9.getInteger(r1)     // Catch: java.lang.Throwable -> L35
            r1.intValue()     // Catch: java.lang.Throwable -> L35
            goto L39
        L35:
            r1 = move-exception
            r1.printStackTrace()
        L39:
            java.lang.String r1 = "attentionSwitch"
            java.lang.Integer r1 = r9.getInteger(r1)     // Catch: java.lang.Throwable -> L47
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L47
            if (r1 != r5) goto L4b
            r1 = 1
            goto L4c
        L47:
            r1 = move-exception
            r1.printStackTrace()
        L4b:
            r1 = 0
        L4c:
            java.lang.String r2 = "widgetSwitch"
            java.lang.Integer r2 = r9.getInteger(r2)     // Catch: java.lang.Throwable -> L5c
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L5c
            if (r2 != r5) goto L59
            goto L5a
        L59:
            r5 = 0
        L5a:
            r6 = r5
            goto L60
        L5c:
            r2 = move-exception
            r2.printStackTrace()
        L60:
            java.lang.String r2 = "titleType"
            java.lang.Integer r2 = r9.getInteger(r2)     // Catch: java.lang.Throwable -> L6b
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L6b
            goto L70
        L6b:
            r2 = move-exception
            r2.printStackTrace()
            r2 = -1
        L70:
            java.lang.String r5 = "dataType"
            java.lang.Integer r9 = r9.getInteger(r5)     // Catch: java.lang.Throwable -> L7b
            int r8 = r9.intValue()     // Catch: java.lang.Throwable -> L7b
            goto L7f
        L7b:
            r9 = move-exception
            r9.printStackTrace()
        L7f:
            r7.ykSourceInt = r0
            r7.dataTypeInt = r8
            r7.titleTypeInt = r2
            r7.supportAnchorInfo = r6
            r7.supportAnchorInfoFolllowAction = r1
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>(r4)
            r0 = 0
            java.lang.String r1 = "incomeIcon"
            if (r8 != r4) goto La3
            int r8 = r7.currentBizType
            if (r8 != r3) goto L9d
            java.lang.String r8 = "https://gw.alicdn.com/tfs/TB1n2fLF7P2gK0jSZPxXXacQpXa-42-42.png"
            r9.put(r1, r8)
            goto La6
        L9d:
            java.lang.String r8 = "https://gw.alicdn.com/tfs/TB1XmX6HW61gK0jSZFlXXXDKFXa-42-42.png"
            r9.put(r1, r8)
            goto La6
        La3:
            r9.put(r1, r0)
        La6:
            java.lang.String r8 = "anchorInfoCallback"
            r9.put(r8, r0)
            long r0 = r7.roomIdInt
            r7.updateAnchorInfo(r0, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgets.RoomInfoWidget.updateAnchorInfoWidgetAttribute(com.youku.live.livesdk.model.mtop.data.LiveFullInfoData, com.alibaba.fastjson.JSONObject):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAttentionStatus(long j, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-535630794")) {
            ipChange.ipc$dispatch("-535630794", new Object[]{this, Long.valueOf(j), Boolean.valueOf(z)});
        } else if (notUnmount(j, this.roomIdInt)) {
            if (z) {
                this.mAnchorInfoView.setAttentionVisibility(false, true);
                this.mLFAnchorGuardButton.startAnim();
                ((ILog) Dsl.getService(ILog.class)).i("jiangzAtt", "setAttentionVisibility 3");
                return;
            }
            this.mAnchorInfoView.setAttentionVisibility(this.supportAnchorInfoFolllowAction, false);
            this.mLFAnchorGuardButton.stopAnim();
            ((ILog) Dsl.getService(ILog.class)).i("jiangzAtt", "setAttentionVisibility 4");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFollowed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-40664540")) {
            ipChange.ipc$dispatch("-40664540", new Object[]{this});
            return;
        }
        Object data = getEngineInstance().getData("mtop.youku.live.widget.liveInfo.getInfo");
        if (data instanceof LiveInfoGetAnchorInfoDataModel) {
            ((LiveInfoGetAnchorInfoDataModel) data).followed = true;
            getEngineInstance().asyncPutData("mtop.youku.live.widget.liveInfo.getInfo", data);
        }
    }

    private void updateLandscapeVisibility() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1067314697")) {
            ipChange.ipc$dispatch("1067314697", new Object[]{this});
            return;
        }
        FrameLayout frameLayout = this.mRoot;
        ViewGroup.LayoutParams layoutParams = frameLayout != null ? frameLayout.getLayoutParams() : null;
        CSSLayout.LayoutParams layoutParams2 = layoutParams instanceof CSSLayout.LayoutParams ? layoutParams : null;
        if (layoutParams2 != null) {
            if (this.mIsWeexMakeLandscapeThisVisible) {
                layoutParams2.landscapeModel.visible = Boolean.TRUE;
            } else {
                layoutParams2.landscapeModel.visible = Boolean.FALSE;
            }
            frameLayout.setLayoutParams(layoutParams2);
            if (layoutParams2.landscapeModel.visible.booleanValue()) {
                if (frameLayout.getVisibility() != 0) {
                    frameLayout.setVisibility(0);
                }
            } else if (frameLayout.getVisibility() != 4) {
                frameLayout.setVisibility(4);
            }
        }
    }

    private void updatePortraitVisibility() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1048186183")) {
            ipChange.ipc$dispatch("1048186183", new Object[]{this});
            return;
        }
        FrameLayout frameLayout = this.mRoot;
        ViewGroup.LayoutParams layoutParams = frameLayout != null ? frameLayout.getLayoutParams() : null;
        CSSLayout.LayoutParams layoutParams2 = layoutParams instanceof CSSLayout.LayoutParams ? layoutParams : null;
        if (layoutParams2 != null) {
            if (this.mIsWeexMakePortraitThisVisible) {
                layoutParams2.portraitModel.visible = Boolean.TRUE;
            } else {
                layoutParams2.portraitModel.visible = Boolean.FALSE;
            }
            frameLayout.setLayoutParams(layoutParams2);
            if (layoutParams2.portraitModel.visible.booleanValue()) {
                if (frameLayout.getVisibility() != 0) {
                    frameLayout.setVisibility(0);
                }
            } else if (frameLayout.getVisibility() != 4) {
                frameLayout.setVisibility(4);
            }
        }
    }

    private void updateUserListMode(JSON json) {
        Integer integer;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "424879623")) {
            ipChange.ipc$dispatch("424879623", new Object[]{this, json});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "updateUserListMode...");
        if (json instanceof com.alibaba.fastjson.JSONObject) {
            com.alibaba.fastjson.JSONObject jSONObject = (com.alibaba.fastjson.JSONObject) json;
            Integer integer2 = jSONObject.getInteger("openState");
            if (integer2 == null) {
                this.mUserListView.setVisibility(8);
                return;
            }
            if (integer2.intValue() == 1) {
                this.mUserListView.setVisibility(0);
                if (!this.userListRequested) {
                    this.userListRequested = true;
                    ((ILog) Dsl.getService(ILog.class)).i(TAG, "request user list room id: " + this.mRoomId);
                    this.mUserListView.reqUserList(this.mRoomId);
                }
            } else {
                this.mUserListView.setVisibility(8);
            }
            com.alibaba.fastjson.JSONObject jSONObject2 = jSONObject.getJSONObject("customInfo");
            if (jSONObject2 == null || (integer = jSONObject2.getInteger("showData")) == null) {
                return;
            }
            if (integer.intValue() == 1) {
                this.mUserListView.setMode("plus");
            } else {
                this.mUserListView.setMode("normal");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void updateWithLiveFullInfo(com.youku.live.livesdk.model.mtop.data.LiveFullInfoData r13) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgets.RoomInfoWidget.updateWithLiveFullInfo(com.youku.live.livesdk.model.mtop.data.LiveFullInfoData):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWithliveInfo(LiveInfoGetInfoModel liveInfoGetInfoModel, long j) {
        T t;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-748543071")) {
            ipChange.ipc$dispatch("-748543071", new Object[]{this, liveInfoGetInfoModel, Long.valueOf(j)});
        } else if (liveInfoGetInfoModel == null || (t = liveInfoGetInfoModel.data) == 0 || ((MtopLiveBaseDataBean) t).data == 0) {
        } else {
            updateWithliveInfo((LiveInfoGetAnchorInfoDataModel) ((MtopLiveBaseDataBean) t).data, j);
        }
    }

    private void updateYoukuAnchorInfoWithSwitchItem(long j, LiveInfoModel liveInfoModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-852609001")) {
            ipChange.ipc$dispatch("-852609001", new Object[]{this, Long.valueOf(j), liveInfoModel});
            return;
        }
        HashMap hashMap = new HashMap(7);
        hashMap.put("avatarUrl", liveInfoModel.avatarUrl);
        hashMap.put("nickName", liveInfoModel.nickName);
        hashMap.put("title", liveInfoModel.title);
        updateAnchorInfo(j, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void willAppearInternal() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1796898393")) {
            ipChange.ipc$dispatch("1796898393", new Object[]{this});
        } else {
            refreshYoukuAnchorInfo(this.roomIdInt, this.ykSourceInt);
        }
    }

    public void attention(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "791939413")) {
            ipChange.ipc$dispatch("791939413", new Object[]{this, Long.valueOf(j)});
        } else if (DataUtils.getLongNumberFromString(this.mAnchorId, -1L) == j) {
            this.mAnchorInfoView.setAttentionVisibility(false, true);
            this.mLFAnchorGuardButton.startAnim();
            ((ILog) Dsl.getService(ILog.class)).i("jiangzAtt", "setAttentionVisibility 6");
        }
    }

    @Override // com.youku.live.widgets.protocol.ICall
    public void call(IEngineInstance iEngineInstance, String str, Map<String, Object> map, IResult iResult, IResult iResult2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1623676625")) {
            ipChange.ipc$dispatch("1623676625", new Object[]{this, iEngineInstance, str, map, iResult, iResult2});
            return;
        }
        Log.d(TAG, "call : " + str);
        if ("showOnLandscape".equals(str)) {
            this.mIsWeexMakeLandscapeThisVisible = true;
            updateLandscapeVisibility();
        } else if ("hideOnLandscape".equals(str)) {
            this.mIsWeexMakeLandscapeThisVisible = false;
            updateLandscapeVisibility();
        }
        if ("show".equals(str)) {
            this.mIsWeexMakePortraitThisVisible = true;
            updatePortraitVisibility();
        } else if ("hide".equals(str)) {
            this.mIsWeexMakePortraitThisVisible = false;
            updatePortraitVisibility();
        }
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void didAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1330937273")) {
            ipChange.ipc$dispatch("1330937273", new Object[]{this});
            return;
        }
        Log.d(TAG, "didAppear");
        super.didAppear();
        logAnchorShow();
        logUserListShow();
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void didDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1636852313")) {
            ipChange.ipc$dispatch("1636852313", new Object[]{this});
            return;
        }
        Log.d(TAG, "didDisappear");
        if (EventBus.b().g(this)) {
            EventBus.b().p(this);
        }
        unRegisterAttentionReciver();
        releaseDagoChannelListener();
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener
    public void didMount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1946466909")) {
            ipChange.ipc$dispatch("-1946466909", new Object[]{this});
            return;
        }
        Log.d(TAG, "didMount");
        if (!this.mRoomInfoDelay) {
            didMountInteral();
        }
        initDataCenter();
        initLoginListener();
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener
    public void didUnmount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2083189380")) {
            ipChange.ipc$dispatch("-2083189380", new Object[]{this});
            return;
        }
        Log.d(TAG, "didUnmount");
        releaseLoginListener();
        releaseDataCenter();
        DagoAnchorInfoView dagoAnchorInfoView = this.mAnchorInfoView;
        LFAnchorGuardButton lFAnchorGuardButton = this.mLFAnchorGuardButton;
        if (dagoAnchorInfoView != null) {
            dagoAnchorInfoView.clearAnimation();
            dagoAnchorInfoView.reset();
        }
        if (lFAnchorGuardButton != null) {
            lFAnchorGuardButton.release();
        }
        this.mRoomId = null;
        this.mAnchorId = null;
        this.mSwitchItemModel = null;
        this.mLiveFullInfo = null;
        this.mAnchorInfoData = null;
        this.mIsInit = false;
        this.mViewInited = false;
        this.mLooping = false;
        this.mMainHandler.removeCallbacks(this.loopRunnable);
        this.mMessageQueue.clear();
        this.mChangeDataQueue.clear();
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public View initHostView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1906509322")) {
            return (View) ipChange.ipc$dispatch("1906509322", new Object[]{this, context});
        }
        Log.d(TAG, YKPrefReporter.DATA_TIME_INIT_HOSTVIEW);
        this.mRoot = new FrameLayout(context);
        this.mContext = context;
        if (context != null) {
            this.mMainHandler = new Handler(this.mContext.getMainLooper());
        }
        String config = OrangeConfig.getInstance().getConfig("LiveRoom", "LiveRoomWeexDelay", "1");
        if (!TextUtils.isEmpty(config) && TextUtils.equals(config, "0")) {
            this.mRoomInfoDelay = false;
        }
        Log.d(TAG, this.mRoomInfoDelay ? "delay open" : "delay close");
        if (!this.mRoomInfoDelay) {
            initView(this.mContext);
        }
        return this.mRoot;
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public void initWithData(IEngineInstance iEngineInstance, IWidget iWidget, IWidgetData iWidgetData) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-567063070")) {
            ipChange.ipc$dispatch("-567063070", new Object[]{this, iEngineInstance, iWidget, iWidgetData});
            return;
        }
        Log.d(TAG, YKPrefReporter.DATA_TIME_INIT_WITHDATA);
        super.initWithData(iEngineInstance, iWidget, iWidgetData);
        IProps options = getEngineInstance().getOptions();
        IProps props = iWidgetData.getProps();
        String string = options.getString("liveid", "");
        this.mRoomId = string;
        this.roomIdInt = DataUtils.getLongNumberFromString(string, -1L);
        Object obj = props.get("guard");
        this.mShowGuard = ((obj instanceof String) && "true".equals(obj)) ? false : false;
        if (!this.mRoomInfoDelay) {
            initWithDataInteral();
        } else {
            WidgetSDKEngine.getInstance().getRenderMananger().postOnUiThread(this.mRoomInfoDelayRunnable, 1000L);
        }
        this.userListRequested = false;
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityLifecycleStateChangedListener
    public void onActivityLifecycleStateChanged(ActivityLifecycleState activityLifecycleState) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "908261486")) {
            ipChange.ipc$dispatch("908261486", new Object[]{this, activityLifecycleState});
        } else if (ActivityLifecycleState.RESUMED.equals(activityLifecycleState)) {
            Log.d(TAG, "onActivityLifecycleStateChanged onResume");
            refreshYoukuAnchorInfo(this.roomIdInt, this.ykSourceInt);
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1850738948")) {
            ipChange.ipc$dispatch("1850738948", new Object[]{this, str, obj, obj2});
            return;
        }
        Log.d(TAG, "onDataChanged : " + str);
        if (this.mRoomInfoDelay) {
            if (DagoLiveFullInfoV4Plugin.PLAYER_FIRST_FRAME.equals(str)) {
                this.mRoomInfoDelayRunnable.run();
                return;
            } else {
                this.mChangeDataQueue.offer(new ChangeData(str, obj, obj2));
                return;
            }
        }
        processDataChange(str, obj, obj2);
    }

    public void onEventMainThread(FollowAnchorEvent followAnchorEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "723563252")) {
            ipChange.ipc$dispatch("723563252", new Object[]{this, followAnchorEvent});
        } else if (followAnchorEvent == null) {
        } else {
            long longNumberFromString = DataUtils.getLongNumberFromString(this.mAnchorId, -1L);
            if (longNumberFromString == followAnchorEvent.ytid && followAnchorEvent.isFollowed) {
                this.mAnchorInfoView.setAttentionVisibility(false, false);
            }
            if ((getEngineInstance().getData("mtop.youku.live.widget.liveInfo.getInfo") instanceof LiveInfoGetAnchorInfoDataModel) && longNumberFromString == followAnchorEvent.ytid) {
                updateFollowed();
            }
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.userlist.UserListView.IClickCallback
    public void onItemClick(UserListBean userListBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-135681978")) {
            ipChange.ipc$dispatch("-135681978", new Object[]{this, userListBean});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "onItemClick: " + userListBean);
        logUserListClick();
        IWidget findWidgetById = getEngineInstance().findWidgetById("live-weex");
        if (findWidgetById instanceof ICall) {
            HashMap hashMap = new HashMap();
            hashMap.put(LiveWeexWidget.GLOBAL_EVENT_NAME, "openWidgetEvent");
            if (userListBean == null) {
                hashMap.put("name", DagoPlayerInteract.ELEMENT_USER_LIST);
                ((ICall) findWidgetById).call(getEngineInstance(), LiveWeexWidget.GLOBAL_EVENT, hashMap, null, null);
            } else if (TextUtils.isEmpty(userListBean.u)) {
            } else {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("id", userListBean.u);
                hashMap.put("name", "card");
                hashMap.put("ext", hashMap2);
                ((ICall) findWidgetById).call(getEngineInstance(), LiveWeexWidget.GLOBAL_EVENT, hashMap, null, null);
            }
        }
    }

    @Override // com.youku.live.dsl.account.ILoginChangedListener
    public void onLoginChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "877788993")) {
            ipChange.ipc$dispatch("877788993", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        Log.d(TAG, "onLoginChanged");
        this.mIsLogin = z;
        refreshYoukuAnchorInfo(this.roomIdInt, this.ykSourceInt);
    }

    @Override // com.youku.live.livesdk.widgets.plugin.DagoChannelPlugin.Receiver
    public void onMessage(DagoChannelPlugin.Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "192068148")) {
            ipChange.ipc$dispatch("192068148", new Object[]{this, message});
        } else if (message == null || message.msgType == null) {
        } else {
            if (this.mRoomInfoDelay) {
                if (this.mMessageQueue.size() > 200) {
                    this.mMessageQueue.clear();
                }
                this.mMessageQueue.offer(message);
                return;
            }
            processMessage(message);
        }
    }

    public void unAttention(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1745172796")) {
            ipChange.ipc$dispatch("1745172796", new Object[]{this, Long.valueOf(j)});
        } else if (DataUtils.getLongNumberFromString(this.mAnchorId, -1L) == j) {
            this.mAnchorInfoView.setAttentionVisibility(true, true);
            this.mLFAnchorGuardButton.stopAnim();
            ((ILog) Dsl.getService(ILog.class)).i("jiangzAtt", "setAttentionVisibility 5");
        }
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void willAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "298443606")) {
            ipChange.ipc$dispatch("298443606", new Object[]{this});
            return;
        }
        Log.d(TAG, "willAppear");
        if (!EventBus.b().g(this)) {
            EventBus.b().m(this);
        }
        registerAttentionReciver();
        if (!this.mRoomInfoDelay) {
            willAppearInternal();
        }
        initDagoChannelListener();
    }

    private void updateWithliveInfo(LiveInfoGetAnchorInfoDataModel liveInfoGetAnchorInfoDataModel, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-496129765")) {
            ipChange.ipc$dispatch("-496129765", new Object[]{this, liveInfoGetAnchorInfoDataModel, Long.valueOf(j)});
        } else if (liveInfoGetAnchorInfoDataModel == null) {
        } else {
            this.mAnchorInfoData = liveInfoGetAnchorInfoDataModel;
            HashMap hashMap = new HashMap(7);
            hashMap.put("avatarUrl", liveInfoGetAnchorInfoDataModel.avatarUrl);
            hashMap.put("nickName", liveInfoGetAnchorInfoDataModel.nickName);
            hashMap.put("title", liveInfoGetAnchorInfoDataModel.title);
            hashMap.put("income", Long.valueOf(liveInfoGetAnchorInfoDataModel.income));
            hashMap.put("fansCount", Long.valueOf(liveInfoGetAnchorInfoDataModel.fansCount));
            hashMap.put("followed", Boolean.valueOf(liveInfoGetAnchorInfoDataModel.followed));
            hashMap.put("anchorInfoCallback", null);
            updateAnchorInfo(j, hashMap);
        }
    }

    private static String formatNumber(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1111902607")) {
            return (String) ipChange.ipc$dispatch("1111902607", new Object[]{str, str2});
        }
        int length = str.length();
        if (str.indexOf(".") > 0 && length >= 5) {
            return str.substring(0, 5) + str2;
        }
        return str + str2;
    }
}
