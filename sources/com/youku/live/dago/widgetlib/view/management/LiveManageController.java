package com.youku.live.dago.widgetlib.view.management;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import cn.damai.common.util.ACache;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import com.youku.live.dago.widgetlib.util.ToastUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.network.INetCallback;
import com.youku.live.dsl.network.INetClient;
import com.youku.live.dsl.network.INetError;
import com.youku.live.dsl.network.INetRequest;
import com.youku.live.dsl.network.INetResponse;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class LiveManageController {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String APP_ID = "1000";
    public static final String MTOP_LIVE_MANAGER_CANCEL = "mtop.youku.live.room.manager.cancel";
    public static final String MTOP_LIVE_MANAGER_SET = "mtop.youku.live.room.manager.set";
    public static final String MTOP_LIVE_USER_BAN_SPEAK = "mtop.youku.live.platform.chat.ban.add";
    public static final String MTOP_LIVE_USER_KICKOUT = "mtop.youku.live.room.user.kickout";
    public static final String MTOP_LIVE_USER_STATUS_GET = "mtop.youku.live.user.status.get";
    public static final String MTOP_LIVE_USER_UNBAN_SPEAK = "mtop.youku.live.platform.chat.ban.del";
    public static final String MTOP_LIVE_USER_UNKICKOUT = "mtop.youku.live.room.user.unkickout";
    public static final String MTOP_VER = "1.0";
    public static final int RIGHTS_BAN_SPEAK = 1;
    public static final int RIGHTS_KICKOUT = 2;
    public static final int RIGHTS_MANAGER = 4;
    public static final int ROLES_MANAGER = 32;
    public static final int ROLES_OWER = 4;
    private static final String TAG = "LiveManageController";
    private String mOperateUserId;
    private String mRoomId;
    private String mTargetUserId;

    private String getEndTime(int i) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1414648104")) {
            return (String) ipChange.ipc$dispatch("-1414648104", new Object[]{this, Integer.valueOf(i)});
        }
        if (i == 1) {
            i2 = 600;
        } else if (i == 2) {
            i2 = 1800;
        } else if (i == 3) {
            i2 = ACache.TIME_HOUR;
        } else if (i == 4) {
            i2 = 86400;
        }
        return i2 + "";
    }

    public static boolean isActor(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-148405995") ? ((Boolean) ipChange.ipc$dispatch("-148405995", new Object[]{Integer.valueOf(i)})).booleanValue() : (i & 4) == 4;
    }

    public static boolean isHasRightBanSpeak(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-195416503") ? ((Boolean) ipChange.ipc$dispatch("-195416503", new Object[]{Integer.valueOf(i)})).booleanValue() : (i & 1) == 1;
    }

    public static boolean isHasRightKickout(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1483265434") ? ((Boolean) ipChange.ipc$dispatch("-1483265434", new Object[]{Integer.valueOf(i)})).booleanValue() : (i & 2) == 2;
    }

    public static boolean isHasRightManager(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1130465205") ? ((Boolean) ipChange.ipc$dispatch("-1130465205", new Object[]{Integer.valueOf(i)})).booleanValue() : (i & 4) == 4;
    }

    public static boolean isManager(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-637917363") ? ((Boolean) ipChange.ipc$dispatch("-637917363", new Object[]{Integer.valueOf(i)})).booleanValue() : (i & 32) == 32;
    }

    public static Activity scanForActivity(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "869095746")) {
            return (Activity) ipChange.ipc$dispatch("869095746", new Object[]{context});
        }
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return scanForActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public void requestManagerCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "957324213")) {
            ipChange.ipc$dispatch("957324213", new Object[]{this});
            return;
        }
        INetClient iNetClient = (INetClient) Dsl.getService(INetClient.class);
        HashMap hashMap = new HashMap();
        hashMap.put("targetUserId", this.mTargetUserId);
        hashMap.put("liveId", this.mRoomId);
        INetRequest createRequestWithMTop = iNetClient.createRequestWithMTop(MTOP_LIVE_MANAGER_CANCEL, "1.0", hashMap, false, false);
        if (createRequestWithMTop != null) {
            createRequestWithMTop.async(new INetCallback() { // from class: com.youku.live.dago.widgetlib.view.management.LiveManageController.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1693121889")) {
                        ipChange2.ipc$dispatch("1693121889", new Object[]{this, iNetResponse});
                    } else if (iNetResponse.isSuccess()) {
                        try {
                            JSONObject jSONObject = new JSONObject(new JSONObject(new JSONObject(iNetResponse.getSource()).toString()).getString("data"));
                            String string = jSONObject.getString("msg");
                            if (jSONObject.getInt("status") == 200) {
                                if (TextUtils.isEmpty(string)) {
                                    string = "取消管理员成功";
                                }
                            } else if (TextUtils.isEmpty(string)) {
                                string = "取消管理员失败";
                            }
                            ToastUtil.showCenter(AppContextUtils.getApp(), string);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public void requestManagerSet() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1469228313")) {
            ipChange.ipc$dispatch("1469228313", new Object[]{this});
            return;
        }
        INetClient iNetClient = (INetClient) Dsl.getService(INetClient.class);
        HashMap hashMap = new HashMap();
        hashMap.put("targetUserId", this.mTargetUserId);
        hashMap.put("liveId", this.mRoomId);
        hashMap.put("level", "1");
        INetRequest createRequestWithMTop = iNetClient.createRequestWithMTop(MTOP_LIVE_MANAGER_SET, "1.0", hashMap, false, false);
        if (createRequestWithMTop != null) {
            createRequestWithMTop.async(new INetCallback() { // from class: com.youku.live.dago.widgetlib.view.management.LiveManageController.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1672784514")) {
                        ipChange2.ipc$dispatch("1672784514", new Object[]{this, iNetResponse});
                    } else if (iNetResponse.isSuccess()) {
                        try {
                            JSONObject jSONObject = new JSONObject(new JSONObject(new JSONObject(iNetResponse.getSource()).toString()).getString("data"));
                            String string = jSONObject.getString("msg");
                            if (jSONObject.getInt("status") == 200) {
                                if (TextUtils.isEmpty(string)) {
                                    string = "设置管理员成功";
                                }
                            } else if (TextUtils.isEmpty(string)) {
                                string = "设置管理员失败";
                            }
                            ToastUtil.showCenter(AppContextUtils.getApp(), string);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public void requestUserBanSpeak(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1229271229")) {
            ipChange.ipc$dispatch("-1229271229", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        INetClient iNetClient = (INetClient) Dsl.getService(INetClient.class);
        HashMap hashMap = new HashMap();
        hashMap.put(ALBiometricsKeys.KEY_APP_ID, "1000");
        hashMap.put("roomId", this.mRoomId);
        hashMap.put("userId", this.mTargetUserId);
        hashMap.put("type", "2");
        hashMap.put("endTime", getEndTime(i));
        hashMap.put("operatorId", this.mOperateUserId);
        INetRequest createRequestWithMTop = iNetClient.createRequestWithMTop(MTOP_LIVE_USER_BAN_SPEAK, "1.0", hashMap, false, false);
        if (createRequestWithMTop != null) {
            createRequestWithMTop.async(new INetCallback() { // from class: com.youku.live.dago.widgetlib.view.management.LiveManageController.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1754134014")) {
                        ipChange2.ipc$dispatch("1754134014", new Object[]{this, iNetResponse});
                    } else if (iNetResponse.isSuccess()) {
                        try {
                            String string = new JSONObject(new JSONObject(new JSONObject(iNetResponse.getSource()).toString()).getString("data")).getString("result");
                            if (TextUtils.isEmpty(string)) {
                                string = "禁言成功";
                            }
                            ToastUtil.showCenter(AppContextUtils.getApp(), string);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, new INetError() { // from class: com.youku.live.dago.widgetlib.view.management.LiveManageController.6
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetError
                public void onError(String str) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1381366292")) {
                        ipChange2.ipc$dispatch("-1381366292", new Object[]{this, str});
                    } else {
                        ToastUtil.showCenter(AppContextUtils.getApp(), str);
                    }
                }
            });
        }
    }

    public void requestUserKickout(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "977236388")) {
            ipChange.ipc$dispatch("977236388", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        INetClient iNetClient = (INetClient) Dsl.getService(INetClient.class);
        HashMap hashMap = new HashMap();
        hashMap.put("targetUserId", this.mTargetUserId);
        hashMap.put("liveId", this.mRoomId);
        hashMap.put("lastTimeType", i + "");
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "requestUserKickout [roomId: " + this.mRoomId + ", targetUserId: " + this.mTargetUserId + jn1.ARRAY_END_STR);
        INetRequest createRequestWithMTop = iNetClient.createRequestWithMTop(MTOP_LIVE_USER_KICKOUT, "1.0", hashMap, false, false);
        if (createRequestWithMTop != null) {
            createRequestWithMTop.async(new INetCallback() { // from class: com.youku.live.dago.widgetlib.view.management.LiveManageController.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1713459264")) {
                        ipChange2.ipc$dispatch("1713459264", new Object[]{this, iNetResponse});
                    } else if (iNetResponse.isSuccess()) {
                        try {
                            JSONObject jSONObject = new JSONObject(new JSONObject(new JSONObject(iNetResponse.getSource()).toString()).getString("data"));
                            String string = jSONObject.getString("msg");
                            if (jSONObject.getInt("status") == 200) {
                                if (TextUtils.isEmpty(string)) {
                                    string = "踢出成功";
                                }
                            } else if (TextUtils.isEmpty(string)) {
                                string = "踢出失败";
                            }
                            ToastUtil.showCenter(AppContextUtils.getApp(), string);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public void requestUserStatus(INetCallback iNetCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1240333653")) {
            ipChange.ipc$dispatch("1240333653", new Object[]{this, iNetCallback});
            return;
        }
        INetClient iNetClient = (INetClient) Dsl.getService(INetClient.class);
        HashMap hashMap = new HashMap();
        hashMap.put("liveId", this.mRoomId);
        hashMap.put("operateUserId", this.mOperateUserId);
        hashMap.put("targetUserId", this.mTargetUserId);
        INetRequest createRequestWithMTop = iNetClient.createRequestWithMTop(MTOP_LIVE_USER_STATUS_GET, "1.0", hashMap, false, false);
        if (createRequestWithMTop != null) {
            createRequestWithMTop.async(iNetCallback);
        }
    }

    public void requestUserUnBanSpeak() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1725401113")) {
            ipChange.ipc$dispatch("-1725401113", new Object[]{this});
            return;
        }
        INetClient iNetClient = (INetClient) Dsl.getService(INetClient.class);
        HashMap hashMap = new HashMap();
        hashMap.put(ALBiometricsKeys.KEY_APP_ID, "1000");
        hashMap.put("roomId", this.mRoomId);
        hashMap.put("userId", this.mTargetUserId);
        hashMap.put("operatorId", this.mOperateUserId);
        INetRequest createRequestWithMTop = iNetClient.createRequestWithMTop(MTOP_LIVE_USER_UNBAN_SPEAK, "1.0", hashMap, false, false);
        if (createRequestWithMTop != null) {
            createRequestWithMTop.async(new INetCallback() { // from class: com.youku.live.dago.widgetlib.view.management.LiveManageController.7
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1794808764")) {
                        ipChange2.ipc$dispatch("1794808764", new Object[]{this, iNetResponse});
                    } else if (iNetResponse.isSuccess()) {
                        try {
                            String string = new JSONObject(new JSONObject(new JSONObject(iNetResponse.getSource()).toString()).getString("data")).getString("result");
                            if (TextUtils.isEmpty(string)) {
                                string = "取消禁言成功";
                            }
                            ToastUtil.showCenter(AppContextUtils.getApp(), string);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, new INetError() { // from class: com.youku.live.dago.widgetlib.view.management.LiveManageController.8
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetError
                public void onError(String str) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1106606678")) {
                        ipChange2.ipc$dispatch("-1106606678", new Object[]{this, str});
                    } else {
                        ToastUtil.showCenter(AppContextUtils.getApp(), str);
                    }
                }
            });
        }
    }

    public void requestUserUnKickout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1072114744")) {
            ipChange.ipc$dispatch("1072114744", new Object[]{this});
            return;
        }
        INetClient iNetClient = (INetClient) Dsl.getService(INetClient.class);
        HashMap hashMap = new HashMap();
        hashMap.put("targetUserId", this.mTargetUserId);
        hashMap.put("liveId", this.mRoomId);
        INetRequest createRequestWithMTop = iNetClient.createRequestWithMTop(MTOP_LIVE_USER_UNKICKOUT, "1.0", hashMap, false, false);
        if (createRequestWithMTop != null) {
            createRequestWithMTop.async(new INetCallback() { // from class: com.youku.live.dago.widgetlib.view.management.LiveManageController.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1733796639")) {
                        ipChange2.ipc$dispatch("1733796639", new Object[]{this, iNetResponse});
                    } else if (iNetResponse.isSuccess()) {
                        try {
                            JSONObject jSONObject = new JSONObject(new JSONObject(new JSONObject(iNetResponse.getSource()).toString()).getString("data"));
                            String string = jSONObject.getString("msg");
                            if (jSONObject.getInt("status") == 200) {
                                if (TextUtils.isEmpty(string)) {
                                    string = "取消踢出成功";
                                }
                            } else if (TextUtils.isEmpty(string)) {
                                string = "取消踢出失败";
                            }
                            ToastUtil.showCenter(AppContextUtils.getApp(), string);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public void setUserInfo(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-786050080")) {
            ipChange.ipc$dispatch("-786050080", new Object[]{this, str, str2, str3});
            return;
        }
        this.mOperateUserId = str2;
        this.mTargetUserId = str3;
        this.mRoomId = str;
    }
}
