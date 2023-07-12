package com.youku.live.dago.widgets;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.sdk.m.s.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.bridge.JSCallback;
import com.youku.live.dago.model.LiveInfoGetInfoModel;
import com.youku.live.dago.model.data.LiveInfoGetAnchorInfoDataModel;
import com.youku.live.dago.widgetlib.component.DagoUserCardDialog;
import com.youku.live.dago.widgetlib.view.anchor.DagoAnchorInfoView;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.account.ILogin;
import com.youku.live.dsl.account.ILoginChangedListener;
import com.youku.live.dsl.account.IUser;
import com.youku.live.dsl.json.IDeserialize;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.network.INetCallback;
import com.youku.live.dsl.network.INetClient;
import com.youku.live.dsl.network.INetResponse;
import com.youku.live.livesdk.model.mtop.base.MtopLiveBaseDataBean;
import com.youku.live.livesdk.model.mtop.data.LiveFullInfoData;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.SimpleWidgetDTO;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.WidgetInitDTO;
import com.youku.live.livesdk.widgets.container.pager.model.LiveInfoModel;
import com.youku.live.livesdk.widgets.container.pager.model.SwitchItemModel;
import com.youku.live.livesdk.widgets.plugin.DagoChannelPlugin;
import com.youku.live.widgets.ActivityLifecycleState;
import com.youku.live.widgets.dom.CSSLayout;
import com.youku.live.widgets.impl.BaseWidget;
import com.youku.live.widgets.protocol.ICall;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IPlugin;
import com.youku.live.widgets.protocol.IResult;
import com.youku.live.widgets.protocol.IWidget;
import com.youku.live.widgets.protocol.IWidgetData;
import com.youku.live.widgets.protocol.activity.IActivityLifecycleStateChangedListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AnchorInfoWidget extends BaseWidget implements ILoginChangedListener, DagoChannelPlugin.Receiver, ICall, IDataHandler, IActivityLifecycleStateChangedListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
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
    public static final String IS_FOLLOW = "1";
    private static final String MC_MSG_TYPE_ATTENTION = "attention";
    private static final String MC_MSG_TYPE_ROOM_HOT = "room_hot";
    private static final String MC_MSG_TYPE_USER_COUNT = "usercount";
    private static final String MC_MSG_TYPE_YKLIVE_PLATFORM_GIFT = "yklive_platform_gift";
    public static final String METHOD_HIDE_LANDSCAPE = "hideOnLandscape";
    public static final String METHOD_HIDE_PORTRAIT = "hide";
    public static final String METHOD_SHOW_LANDSCAPE = "showOnLandscape";
    public static final String METHOD_SHOW_PORTRAIT = "show";
    public static final String MTOP_GET_INFO_API = "mtop.youku.live.widget.liveInfo.getInfo";
    public static final String MTOP_GET_INFO_VER = "1.0";
    public static final String MTOP_RET_CODE_RELATION_EXISTS = "-302";
    public static final String MTOP_RET_CODE_SUCCESS = "SUCCESS";
    public static final String MTOP_TUDOU_SUBSCRIBE_API = "mtop.tudou.subscribe.relation.RelationServiceMTOP.create";
    public static final String MTOP_TUDOU_SUBSCRIBE_VER = "1.1";
    public static final String PARAM_KEY_ANCHOR_INFO_CALLBACK = "anchorInfoCallback";
    public static final String PARAM_KEY_AVATAR_URL = "avatarUrl";
    public static final String PARAM_KEY_FANS_COUNT = "fansCount";
    public static final String PARAM_KEY_FOLLOWED = "followed";
    public static final String PARAM_KEY_INCOME = "income";
    public static final String PARAM_KEY_INCOME_ICON = "incomeIcon";
    public static final String PARAM_KEY_NICK_NAME = "nickName";
    public static final String PARAM_KEY_TITLE = "title";
    public static final long ROOM_ID_UNKNOWN = -1;
    public static final String TAG = "AnchorInfoWidget";
    public static final int TITLE_TYPE_ANCHOR_NICK_NAME = 1;
    public static final int TITLE_TYPE_ANCHOR_REAL_NAME = 3;
    public static final int TITLE_TYPE_ANCHOR_TITLE = 2;
    public static final int TITLE_TYPE_UNKNOWN = -1;
    public static final String WIDGET_NAME = "AnchorInfo";
    public static final int YK_SOURCE_LAIFENG = 0;
    public static final int YK_SOURCE_UNKNOWN = -1;
    public static final int YK_SOURCE_YOUKU = 1;
    private String mAnchorId;
    private LiveInfoGetAnchorInfoDataModel mAnchorInfoData;
    private DagoAnchorInfoView mAnchorInfoView;
    private boolean mIsLogin;
    private LiveFullInfoData mLiveFullInfo;
    private String mRoomId;
    private FrameLayout mRoot;
    private SwitchItemModel mSwitchItemModel;
    private DagoUserCardDialog mUserCardDialog;
    private boolean mIsInit = false;
    private long roomIdInt = -1;
    private int ykSourceInt = 1;
    private int dataTypeInt = -1;
    private int titleTypeInt = -1;
    private boolean supportAnchorInfo = true;
    private boolean supportAnchorInfoFolllowAction = false;
    private boolean mIsWeexMakePortraitThisVisible = true;
    private boolean mIsWeexMakeLandscapeThisVisible = true;

    /* JADX INFO: Access modifiers changed from: private */
    public void attentionYouku(final long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2008693784")) {
            ipChange.ipc$dispatch("2008693784", new Object[]{this, Long.valueOf(j)});
        } else if (isLoginOtherDoLogin()) {
            INetClient iNetClient = (INetClient) Dsl.getService(INetClient.class);
            HashMap hashMap = new HashMap(2);
            hashMap.put("target_id", this.mAnchorId);
            hashMap.put("guid", "0");
            hashMap.put("is_utdid", "true");
            hashMap.put("platform", "0");
            hashMap.put("did", "6");
            iNetClient.createRequestWithMTop("mtop.tudou.subscribe.relation.RelationServiceMTOP.create", "1.1", hashMap, false, false).async(new INetCallback() { // from class: com.youku.live.dago.widgets.AnchorInfoWidget.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1180028438")) {
                        ipChange2.ipc$dispatch("1180028438", new Object[]{this, iNetResponse});
                    } else if (iNetResponse == null || iNetResponse.getRetCode() == null) {
                    } else {
                        String retCode = iNetResponse.getRetCode();
                        if (AnchorInfoWidget.notUnmount(j, AnchorInfoWidget.this.roomIdInt)) {
                            if ("-302".equals(retCode)) {
                                AnchorInfoWidget.this.updateAttentionStatus(j, true);
                            } else if ("SUCCESS".equals(retCode)) {
                                AnchorInfoWidget.this.updateAttentionStatus(j, true);
                            }
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forceOnMainThread(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "945489348")) {
            ipChange.ipc$dispatch("945489348", new Object[]{this, runnable});
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
        if (AndroidInstantRuntime.support(ipChange, "-366342281")) {
            return (String) ipChange.ipc$dispatch("-366342281", new Object[]{Long.valueOf(j)});
        }
        return formatNumber(j) + " 粉丝";
    }

    private static String formatIncome(long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-98503181") ? (String) ipChange.ipc$dispatch("-98503181", new Object[]{Long.valueOf(j)}) : formatNumber(j);
    }

    private static String formatNumber(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "112459859")) {
            return (String) ipChange.ipc$dispatch("112459859", new Object[]{Long.valueOf(j)});
        }
        double d = j;
        if (d < 100000.0d) {
            return String.valueOf(j);
        }
        if (d >= 100000.0d && d < 1.0E8d) {
            return formatNumber(String.valueOf(d / 10000.0d), String.valueOf(d % 10000.0d)) + "万";
        }
        return formatNumber(String.valueOf(d / 1.0E8d), String.valueOf((d / 10000.0d) % 10000.0d)) + "亿";
    }

    private void initDagoChannelListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "627597265")) {
            ipChange.ipc$dispatch("627597265", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "2076367656")) {
            ipChange.ipc$dispatch("2076367656", new Object[]{this});
            return;
        }
        getEngineInstance().addDataHandler("mtop.youku.live.com.livefullinfo", this);
        getEngineInstance().addDataHandler("mtop.youku.live.widget.liveInfo.getInfo", this);
    }

    private void initLoginListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1931315494")) {
            ipChange.ipc$dispatch("1931315494", new Object[]{this});
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

    private boolean isLinkLiving() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1072025774")) {
            return ((Boolean) ipChange.ipc$dispatch("1072025774", new Object[]{this})).booleanValue();
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
        if (AndroidInstantRuntime.support(ipChange, "-501850294")) {
            return ((Boolean) ipChange.ipc$dispatch("-501850294", new Object[]{this})).booleanValue();
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
    public static boolean notUnmount(long j, long j2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1736943506") ? ((Boolean) ipChange.ipc$dispatch("-1736943506", new Object[]{Long.valueOf(j), Long.valueOf(j2)})).booleanValue() : j == j2 && j2 != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUserCardDialog(final long j) {
        long j2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1558342746")) {
            ipChange.ipc$dispatch("1558342746", new Object[]{this, Long.valueOf(j)});
            return;
        }
        String str = this.mAnchorId;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            j2 = Long.parseLong(str);
        } catch (Exception unused) {
            j2 = 0;
        }
        if (j2 > 0) {
            DagoUserCardDialog dagoUserCardDialog = new DagoUserCardDialog(getEngineInstance().getContext(), isLinkLiving());
            dagoUserCardDialog.setTargetUserId(str);
            dagoUserCardDialog.setJSCallback(new JSCallback() { // from class: com.youku.live.dago.widgets.AnchorInfoWidget.6
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.taobao.weex.bridge.JSCallback
                public void invoke(Object obj) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1731338867")) {
                        ipChange2.ipc$dispatch("-1731338867", new Object[]{this, obj});
                    } else if (AnchorInfoWidget.notUnmount(j, AnchorInfoWidget.this.roomIdInt) && (obj instanceof Map)) {
                        Object obj2 = ((Map) obj).get("isFollow");
                        if ((obj2 instanceof String) && "1".equals((String) obj2)) {
                            AnchorInfoWidget.this.updateAttentionStatus(j, true);
                        }
                    }
                }

                @Override // com.taobao.weex.bridge.JSCallback
                public void invokeAndKeepAlive(Object obj) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-2002646052")) {
                        ipChange2.ipc$dispatch("-2002646052", new Object[]{this, obj});
                    }
                }
            });
            dagoUserCardDialog.showDialog();
        }
    }

    private void refreshYoukuAnchorInfo(final long j, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "259677093")) {
            ipChange.ipc$dispatch("259677093", new Object[]{this, Long.valueOf(j), Integer.valueOf(i)});
        } else if (j == -1 || i == -1 || !this.mIsInit) {
        } else {
            INetClient iNetClient = (INetClient) Dsl.getService(INetClient.class);
            HashMap hashMap = new HashMap(2);
            hashMap.put("liveId", String.valueOf(j));
            hashMap.put("ykSoucre", String.valueOf(i));
            iNetClient.createRequestWithMTop("mtop.youku.live.widget.liveInfo.getInfo", "1.0", hashMap, false, false).async(new INetCallback() { // from class: com.youku.live.dago.widgets.AnchorInfoWidget.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1159691063")) {
                        ipChange2.ipc$dispatch("1159691063", new Object[]{this, iNetResponse});
                    } else if (iNetResponse == null || iNetResponse.getRetCode() == null || !iNetResponse.getRetCode().startsWith("SUCCESS")) {
                    } else {
                        ((ILog) Dsl.getService(ILog.class)).e(AnchorInfoWidget.TAG, "mtop.youku.live.widget.liveInfo.getInfo => " + iNetResponse.getSource());
                        final LiveInfoGetInfoModel liveInfoGetInfoModel = (LiveInfoGetInfoModel) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(iNetResponse.getSource(), LiveInfoGetInfoModel.class);
                        if (liveInfoGetInfoModel != null) {
                            AnchorInfoWidget.this.forceOnMainThread(new Runnable() { // from class: com.youku.live.dago.widgets.AnchorInfoWidget.2.1
                                private static transient /* synthetic */ IpChange $ipChange;

                                @Override // java.lang.Runnable
                                public void run() {
                                    IpChange ipChange3 = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange3, "-94024147")) {
                                        ipChange3.ipc$dispatch("-94024147", new Object[]{this});
                                        return;
                                    }
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    if (AnchorInfoWidget.notUnmount(j, AnchorInfoWidget.this.roomIdInt)) {
                                        AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                        AnchorInfoWidget.this.updateWithliveInfo(liveInfoGetInfoModel, j);
                                    }
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    private void releaseDagoChannelListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1195776500")) {
            ipChange.ipc$dispatch("-1195776500", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-586852723")) {
            ipChange.ipc$dispatch("-586852723", new Object[]{this});
            return;
        }
        getEngineInstance().removeDataHandler("mtop.youku.live.com.livefullinfo", this);
        getEngineInstance().removeDataHandler("mtop.youku.live.widget.liveInfo.getInfo", this);
    }

    private void releaseLoginListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1431103583")) {
            ipChange.ipc$dispatch("-1431103583", new Object[]{this});
            return;
        }
        ILogin iLogin = (ILogin) Dsl.getService(ILogin.class);
        if (iLogin != null) {
            iLogin.unregisterLoginChangedListener(this);
        }
        this.mIsLogin = false;
    }

    private void updateAnchorId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "588055656")) {
            ipChange.ipc$dispatch("588055656", new Object[]{this, str});
        } else {
            this.mAnchorId = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateAnchorInfo(final long r11, java.util.Map<java.lang.String, java.lang.Object> r13) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgets.AnchorInfoWidget.updateAnchorInfo(long, java.util.Map):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:(2:6|7)|(2:8|9)|(2:11|12)|(14:14|15|16|(1:18)|19|20|21|22|23|24|25|(1:27)(1:30)|28|29)|40|15|16|(0)|19|20|21|22|23|24|25|(0)(0)|28|29) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0059, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005a, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0069, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006a, code lost:
        r1.printStackTrace();
        r1 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0079, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007a, code lost:
        r8.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void updateAnchorInfoWidgetAttribute(com.youku.live.livesdk.model.mtop.data.LiveFullInfoData r7, com.alibaba.fastjson.JSONObject r8) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.dago.widgets.AnchorInfoWidget.$ipChange
            java.lang.String r1 = "-452493763"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L1a
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r5] = r6
            r2[r4] = r7
            r2[r3] = r8
            r0.ipc$dispatch(r1, r2)
            return
        L1a:
            java.lang.String r7 = "ykSource"
            java.lang.Integer r7 = r8.getInteger(r7)     // Catch: java.lang.Throwable -> L24
            r7.intValue()     // Catch: java.lang.Throwable -> L24
            goto L28
        L24:
            r7 = move-exception
            r7.printStackTrace()
        L28:
            java.lang.String r7 = "bizType"
            java.lang.Integer r7 = r8.getInteger(r7)     // Catch: java.lang.Throwable -> L32
            r7.intValue()     // Catch: java.lang.Throwable -> L32
            goto L36
        L32:
            r7 = move-exception
            r7.printStackTrace()
        L36:
            java.lang.String r7 = "attentionSwitch"
            java.lang.Integer r7 = r8.getInteger(r7)     // Catch: java.lang.Throwable -> L44
            int r7 = r7.intValue()     // Catch: java.lang.Throwable -> L44
            if (r7 != r4) goto L48
            r7 = 1
            goto L49
        L44:
            r7 = move-exception
            r7.printStackTrace()
        L48:
            r7 = 0
        L49:
            java.lang.String r0 = "widgetSwitch"
            java.lang.Integer r0 = r8.getInteger(r0)     // Catch: java.lang.Throwable -> L59
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L59
            if (r0 != r4) goto L56
            goto L57
        L56:
            r4 = 0
        L57:
            r5 = r4
            goto L5d
        L59:
            r0 = move-exception
            r0.printStackTrace()
        L5d:
            r0 = -1
            java.lang.String r1 = "titleType"
            java.lang.Integer r1 = r8.getInteger(r1)     // Catch: java.lang.Throwable -> L69
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L69
            goto L6e
        L69:
            r1 = move-exception
            r1.printStackTrace()
            r1 = -1
        L6e:
            java.lang.String r2 = "dataType"
            java.lang.Integer r8 = r8.getInteger(r2)     // Catch: java.lang.Throwable -> L79
            int r0 = r8.intValue()     // Catch: java.lang.Throwable -> L79
            goto L7d
        L79:
            r8 = move-exception
            r8.printStackTrace()
        L7d:
            r6.dataTypeInt = r0
            r6.titleTypeInt = r1
            r6.supportAnchorInfo = r5
            r6.supportAnchorInfoFolllowAction = r7
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>(r3)
            r8 = 0
            java.lang.String r1 = "incomeIcon"
            if (r0 != r3) goto L95
            java.lang.String r0 = "https://gw.alicdn.com/tfs/TB1XmX6HW61gK0jSZFlXXXDKFXa-42-42.png"
            r7.put(r1, r0)
            goto L98
        L95:
            r7.put(r1, r8)
        L98:
            java.lang.String r0 = "anchorInfoCallback"
            r7.put(r0, r8)
            long r0 = r6.roomIdInt
            r6.updateAnchorInfo(r0, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgets.AnchorInfoWidget.updateAnchorInfoWidgetAttribute(com.youku.live.livesdk.model.mtop.data.LiveFullInfoData, com.alibaba.fastjson.JSONObject):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAttentionStatus(long j, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1865974052")) {
            ipChange.ipc$dispatch("-1865974052", new Object[]{this, Long.valueOf(j), Boolean.valueOf(z)});
        } else if (notUnmount(j, this.roomIdInt)) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("followed", Boolean.valueOf(z));
            updateAnchorInfo(j, hashMap);
        }
    }

    private void updateLandscapeVisibility() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1787269329")) {
            ipChange.ipc$dispatch("-1787269329", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-1537749151")) {
            ipChange.ipc$dispatch("-1537749151", new Object[]{this});
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

    private void updateWithLiveFullInfo(LiveFullInfoData liveFullInfoData) {
        LiveInfoModel liveInfoModel;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "418657115")) {
            ipChange.ipc$dispatch("418657115", new Object[]{this, liveFullInfoData});
            return;
        }
        long j = -1;
        this.mLiveFullInfo = liveFullInfoData;
        if (liveFullInfoData != null) {
            Long l = liveFullInfoData.liveId;
            String str = "";
            if (l != null) {
                j = l.longValue();
                if (notUnmount(j, this.roomIdInt)) {
                    str = "" + liveFullInfoData.anchorYtid;
                }
            }
            if (!TextUtils.isEmpty(str) && !str.equals(this.mAnchorId)) {
                updateAnchorId(str);
                z = true;
            }
            WidgetInitDTO widgetInitDTO = liveFullInfoData.widgets;
            JSON json = null;
            List<SimpleWidgetDTO> list = widgetInitDTO != null ? widgetInitDTO.widgetList : null;
            if (list != null) {
                Iterator<SimpleWidgetDTO> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SimpleWidgetDTO next = it.next();
                    if (!TextUtils.isEmpty(next.name) && next.name.equals("liveinfo")) {
                        json = next.trustData;
                        break;
                    }
                }
            }
            if (json instanceof JSONObject) {
                updateAnchorInfoWidgetAttribute(liveFullInfoData, (JSONObject) json);
                this.mIsInit = true;
            }
        }
        if (z && notUnmount(j, this.roomIdInt)) {
            SwitchItemModel switchItemModel = this.mSwitchItemModel;
            if (switchItemModel != null && (liveInfoModel = switchItemModel.liveInfo) != null) {
                updateYoukuAnchorInfoWithSwitchItem(j, liveInfoModel);
            }
            refreshYoukuAnchorInfo(j, this.ykSourceInt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWithliveInfo(LiveInfoGetInfoModel liveInfoGetInfoModel, long j) {
        T t;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "960615751")) {
            ipChange.ipc$dispatch("960615751", new Object[]{this, liveInfoGetInfoModel, Long.valueOf(j)});
        } else if (liveInfoGetInfoModel == null || (t = liveInfoGetInfoModel.data) == 0 || ((MtopLiveBaseDataBean) t).data == 0) {
        } else {
            updateWithliveInfo((LiveInfoGetAnchorInfoDataModel) ((MtopLiveBaseDataBean) t).data, j);
        }
    }

    private void updateYoukuAnchorInfoWithSwitchItem(long j, LiveInfoModel liveInfoModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "814396977")) {
            ipChange.ipc$dispatch("814396977", new Object[]{this, Long.valueOf(j), liveInfoModel});
            return;
        }
        HashMap hashMap = new HashMap(7);
        hashMap.put("avatarUrl", liveInfoModel.avatarUrl);
        hashMap.put("nickName", liveInfoModel.nickName);
        hashMap.put("title", liveInfoModel.title);
        updateAnchorInfo(j, hashMap);
    }

    @Override // com.youku.live.widgets.protocol.ICall
    public void call(IEngineInstance iEngineInstance, String str, Map<String, Object> map, IResult iResult, IResult iResult2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "111543531")) {
            ipChange.ipc$dispatch("111543531", new Object[]{this, iEngineInstance, str, map, iResult, iResult2});
            return;
        }
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
    public void didDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1631386483")) {
            ipChange.ipc$dispatch("1631386483", new Object[]{this});
        } else {
            releaseDagoChannelListener();
        }
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener
    public void didMount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1648067651")) {
            ipChange.ipc$dispatch("-1648067651", new Object[]{this});
            return;
        }
        DagoAnchorInfoView dagoAnchorInfoView = this.mAnchorInfoView;
        if (dagoAnchorInfoView != null) {
            dagoAnchorInfoView.setVisibility(0);
        }
        initDataCenter();
        initLoginListener();
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener
    public void didUnmount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1210656022")) {
            ipChange.ipc$dispatch("1210656022", new Object[]{this});
            return;
        }
        releaseLoginListener();
        releaseDataCenter();
        DagoAnchorInfoView dagoAnchorInfoView = this.mAnchorInfoView;
        if (dagoAnchorInfoView != null) {
            dagoAnchorInfoView.clearAnimation();
            dagoAnchorInfoView.reset();
            dagoAnchorInfoView.setVisibility(4);
        }
        this.mRoomId = null;
        this.mAnchorId = null;
        this.mSwitchItemModel = null;
        this.mLiveFullInfo = null;
        this.mAnchorInfoData = null;
        this.mIsInit = false;
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public View initHostView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-176979792")) {
            return (View) ipChange.ipc$dispatch("-176979792", new Object[]{this, context});
        }
        this.mRoot = new FrameLayout(context);
        DagoAnchorInfoView dagoAnchorInfoView = new DagoAnchorInfoView(context);
        this.mAnchorInfoView = dagoAnchorInfoView;
        dagoAnchorInfoView.setAttentionVisibility(false, false);
        this.mRoot.addView(this.mAnchorInfoView);
        return this.mRoot;
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public void initWithData(IEngineInstance iEngineInstance, IWidget iWidget, IWidgetData iWidgetData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1590246520")) {
            ipChange.ipc$dispatch("-1590246520", new Object[]{this, iEngineInstance, iWidget, iWidgetData});
            return;
        }
        super.initWithData(iEngineInstance, iWidget, iWidgetData);
        this.mIsInit = false;
        String string = getEngineInstance().getOptions().getString("liveid", "");
        this.mRoomId = string;
        try {
            this.roomIdInt = Long.valueOf(string).longValue();
        } catch (Throwable unused) {
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityLifecycleStateChangedListener
    public void onActivityLifecycleStateChanged(ActivityLifecycleState activityLifecycleState) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1888754936")) {
            ipChange.ipc$dispatch("-1888754936", new Object[]{this, activityLifecycleState});
        } else if (ActivityLifecycleState.RESUMED.equals(activityLifecycleState)) {
            refreshYoukuAnchorInfo(this.roomIdInt, this.ykSourceInt);
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-735069526")) {
            ipChange.ipc$dispatch("-735069526", new Object[]{this, str, obj, obj2});
        } else if ("mtop.youku.live.com.livefullinfo".equals(str)) {
            if (obj instanceof LiveFullInfoData) {
                updateWithLiveFullInfo((LiveFullInfoData) obj);
            }
        } else if ("mtop.youku.live.widget.liveInfo.getInfo".equals(str)) {
            if (obj instanceof LiveInfoGetAnchorInfoDataModel) {
                ((ILog) Dsl.getService(ILog.class)).e(TAG, "onDataChanged:" + obj);
            } else if (obj instanceof String) {
                LiveInfoGetAnchorInfoDataModel liveInfoGetAnchorInfoDataModel = (LiveInfoGetAnchorInfoDataModel) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize((String) obj, LiveInfoGetAnchorInfoDataModel.class);
                if (liveInfoGetAnchorInfoDataModel != null) {
                    updateWithliveInfo(liveInfoGetAnchorInfoDataModel, this.roomIdInt);
                }
                ((ILog) Dsl.getService(ILog.class)).e(TAG, "onDataChanged:" + obj);
            } else {
                ((ILog) Dsl.getService(ILog.class)).e(TAG, "onDataChanged:" + obj);
            }
        }
    }

    @Override // com.youku.live.dsl.account.ILoginChangedListener
    public void onLoginChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1254004711")) {
            ipChange.ipc$dispatch("1254004711", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mIsLogin = z;
        refreshYoukuAnchorInfo(this.roomIdInt, this.ykSourceInt);
    }

    @Override // com.youku.live.livesdk.widgets.plugin.DagoChannelPlugin.Receiver
    public void onMessage(DagoChannelPlugin.Message message) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "683475406")) {
            ipChange.ipc$dispatch("683475406", new Object[]{this, message});
        } else if (message == null || (str = message.msgType) == null) {
        } else {
            long j = 0;
            if (MC_MSG_TYPE_ATTENTION.equals(str)) {
                if (this.dataTypeInt == 1) {
                    try {
                        j = JSON.parseObject(message.data).getJSONArray("args").getJSONObject(0).getJSONObject("body").getLongValue(a.u);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    final HashMap hashMap = new HashMap(1);
                    hashMap.put("fansCount", Long.valueOf(j));
                    try {
                        final long longValue = Long.valueOf(message.channelId).longValue();
                        getEngineInstance().runOnMainThread(new Runnable() { // from class: com.youku.live.dago.widgets.AnchorInfoWidget.4
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.lang.Runnable
                            public void run() {
                                IpChange ipChange2 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange2, "-578072744")) {
                                    ipChange2.ipc$dispatch("-578072744", new Object[]{this});
                                } else {
                                    AnchorInfoWidget.this.updateAnchorInfo(longValue, hashMap);
                                }
                            }
                        });
                    } catch (Throwable unused) {
                    }
                }
                ((ILog) Dsl.getService(ILog.class)).e(TAG, message.data);
            } else if (MC_MSG_TYPE_YKLIVE_PLATFORM_GIFT.equals(message.msgType) && this.dataTypeInt == 2) {
                try {
                    j = JSON.parseObject(message.data).getJSONArray("args").getJSONObject(0).getJSONObject("body").getLongValue("popularity");
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                final HashMap hashMap2 = new HashMap(1);
                hashMap2.put("income", Long.valueOf(j));
                try {
                    final long longValue2 = Long.valueOf(message.channelId).longValue();
                    getEngineInstance().runOnMainThread(new Runnable() { // from class: com.youku.live.dago.widgets.AnchorInfoWidget.5
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Runnable
                        public void run() {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "-774586249")) {
                                ipChange2.ipc$dispatch("-774586249", new Object[]{this});
                            } else {
                                AnchorInfoWidget.this.updateAnchorInfo(longValue2, hashMap2);
                            }
                        }
                    });
                } catch (Throwable unused2) {
                }
                ((ILog) Dsl.getService(ILog.class)).e(TAG, message.data);
            }
        }
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void willAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-702678288")) {
            ipChange.ipc$dispatch("-702678288", new Object[]{this});
            return;
        }
        refreshYoukuAnchorInfo(this.roomIdInt, this.ykSourceInt);
        initDagoChannelListener();
    }

    private void updateWithliveInfo(LiveInfoGetAnchorInfoDataModel liveInfoGetAnchorInfoDataModel, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1101772469")) {
            ipChange.ipc$dispatch("1101772469", new Object[]{this, liveInfoGetAnchorInfoDataModel, Long.valueOf(j)});
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
        if (AndroidInstantRuntime.support(ipChange, "-879612747")) {
            return (String) ipChange.ipc$dispatch("-879612747", new Object[]{str, str2});
        }
        if (str.length() < 4) {
            while (str2.length() < 4) {
                str2 = "0" + str2;
            }
            return (str + "." + str2).substring(0, 5);
        }
        return str;
    }
}
