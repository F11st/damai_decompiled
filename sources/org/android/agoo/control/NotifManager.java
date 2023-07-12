package org.android.agoo.control;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.IACCSManager;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.init.Launcher_InitPush;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UTMini;
import com.taobao.agoo.TaobaoConstants;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.common.MsgDO;
import org.json.JSONObject;
import tb.m80;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NotifManager {
    private static final String ACK_MESSAGE = "accs.ackMessage";
    private static final int EVENT_ID = 66001;
    private static final String TAG = "NotifManager";
    private static Context mContext;
    public static String tokenReportDataId;

    private byte[] convertMsgToBytes(MsgDO msgDO) throws UnsupportedEncodingException {
        HashMap hashMap = new HashMap();
        hashMap.put("api", "agooReport");
        hashMap.put("id", msgDO.msgIds + m80.DINAMIC_PREFIX_AT + msgDO.messageSource);
        hashMap.put("ext", msgDO.extData);
        hashMap.put("status", msgDO.msgStatus);
        if (!TextUtils.isEmpty(msgDO.errorCode)) {
            hashMap.put("ec", msgDO.errorCode);
        }
        if (!TextUtils.isEmpty(msgDO.type)) {
            hashMap.put("type", msgDO.type);
        }
        if (!TextUtils.isEmpty(msgDO.fromPkg)) {
            hashMap.put("fromPkg", msgDO.fromPkg);
        }
        if (!TextUtils.isEmpty(msgDO.fromAppkey)) {
            hashMap.put(AgooConstants.MESSAGE_FROM_APPKEY, msgDO.fromAppkey);
        }
        if (!TextUtils.isEmpty(msgDO.notifyEnable)) {
            hashMap.put("notifyEnable", msgDO.notifyEnable);
        }
        if (!TextUtils.isEmpty(msgDO.extData)) {
            hashMap.put("ext", msgDO.extData);
        }
        hashMap.put("isStartProc", Boolean.toString(msgDO.isStartProc));
        hashMap.put("triggerType", String.valueOf(msgDO.triggerType));
        hashMap.put("appkey", Config.getAgooAppKey(mContext));
        hashMap.put("utdid", AdapterUtilityImpl.getDeviceId(mContext));
        hashMap.put("evokeAppStatus", String.valueOf(msgDO.evokeAppStatus));
        hashMap.put("lastActiveTime", String.valueOf(msgDO.lastActiveTime));
        hashMap.put("isGlobalClick", String.valueOf(msgDO.isGlobalClick));
        if (OrangeAdapter.isRegIdSwitchEnableAndValid(mContext)) {
            hashMap.put("regId", OrangeAdapter.getRegId(mContext));
        }
        return new JSONObject(hashMap).toString().getBytes("UTF-8");
    }

    public static String getServiceId(Context context, String str) {
        return OrangeAdapter.isRegIdSwitchEnableAndValid(context) ? TaobaoConstants.SERVICE_ID_AGOO : str;
    }

    private String getVersion(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "null";
            }
            String str2 = mContext.getPackageManager().getPackageInfo(str, 0).versionName;
            ALog.d(TAG, "getVersion###版本号为 : " + str2, new Object[0]);
            return str2;
        } catch (Throwable unused) {
            return "null";
        }
    }

    private boolean isAppInstalled(String str) {
        PackageInfo packageInfo;
        try {
        } catch (Throwable unused) {
            packageInfo = null;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        packageInfo = mContext.getPackageManager().getPackageInfo(str, 0);
        if (packageInfo == null) {
            return false;
        }
        ALog.i(TAG, "isAppInstalled true..", new Object[0]);
        return true;
    }

    private void reportMethod(MsgDO msgDO, TaoBaseService.ExtraInfo extraInfo) {
        try {
            if (msgDO == null) {
                ALog.e(TAG, "reportMethod msg null", new Object[0]);
                return;
            }
            ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(null, AgooConstants.AGOO_SERVICE_AGOOACK, convertMsgToBytes(msgDO), null, null, null, null);
            accsRequest.setTag(msgDO.msgIds);
            Context context = mContext;
            String sendPushResponse = ACCSManager.getAccsInstance(context, Config.getAgooAppKey(context), Config.getAccsConfigTag(mContext)).sendPushResponse(mContext, accsRequest, extraInfo);
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.e(TAG, "report", Constants.KEY_DATA_ID, sendPushResponse, "status", msgDO.msgStatus, "errorcode", msgDO.errorCode);
            }
        } catch (Throwable th) {
            AppMonitorAdapter.commitCount("accs", "error", th.toString(), 0.0d);
        }
    }

    public void doUninstall(String str, boolean z) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("pack", str);
            hashMap.put("appkey", Config.getAgooAppKey(mContext));
            hashMap.put("utdid", AdapterUtilityImpl.getDeviceId(mContext));
            if (OrangeAdapter.isRegIdSwitchEnableAndValid(mContext)) {
                hashMap.put("cmd", "uninstallReport");
                hashMap.put("regId", OrangeAdapter.getRegId(mContext));
            }
            ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(null, getServiceId(mContext, "agooKick"), new JSONObject(hashMap).toString().getBytes("UTF-8"), null, null, null, null);
            Context context = mContext;
            ACCSManager.getAccsInstance(context, Config.getAgooAppKey(context), Config.getAccsConfigTag(mContext)).sendPushResponse(mContext, accsRequest, new TaoBaseService.ExtraInfo());
        } catch (Throwable th) {
            ALog.e(TAG, "[doUninstall] is error", th, new Object[0]);
        }
    }

    public void handlerACKMessage(MsgDO msgDO, TaoBaseService.ExtraInfo extraInfo) {
        if (msgDO == null) {
            return;
        }
        if (TextUtils.isEmpty(msgDO.msgIds) && TextUtils.isEmpty(msgDO.removePacks) && TextUtils.isEmpty(msgDO.errorCode)) {
            UTMini uTMini = UTMini.getInstance();
            String deviceId = AdapterUtilityImpl.getDeviceId(mContext);
            uTMini.commitEvent(AgooConstants.AGOO_EVENT_ID, ACK_MESSAGE, deviceId, "handlerACKMessageRetuen", "msgids=" + msgDO.msgIds + ",removePacks=" + msgDO.removePacks + ",errorCode=" + msgDO.errorCode);
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("api", AgooConstants.AGOO_SERVICE_AGOOACK);
            hashMap.put("id", msgDO.msgIds + m80.DINAMIC_PREFIX_AT + msgDO.messageSource);
            if (!TextUtils.isEmpty(msgDO.removePacks)) {
                hashMap.put("del_pack", msgDO.removePacks);
            }
            if (!TextUtils.isEmpty(msgDO.errorCode)) {
                hashMap.put("ec", msgDO.errorCode);
            }
            if (!TextUtils.isEmpty(msgDO.type)) {
                hashMap.put("type", msgDO.type);
            }
            if (!TextUtils.isEmpty(msgDO.extData)) {
                hashMap.put("ext", msgDO.extData);
            }
            hashMap.put("appkey", Config.getAgooAppKey(mContext));
            hashMap.put("utdid", AdapterUtilityImpl.getDeviceId(mContext));
            if (OrangeAdapter.isRegIdSwitchEnableAndValid(mContext)) {
                hashMap.put("regId", OrangeAdapter.getRegId(mContext));
            }
            byte[] bytes = new JSONObject(hashMap).toString().getBytes("UTF-8");
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ACK_MESSAGE, AdapterUtilityImpl.getDeviceId(mContext), "handlerACKMessageSendData", msgDO.msgIds);
            AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_AGOO_ACK, "handlerACKMessage", 0.0d);
            ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(null, AgooConstants.AGOO_SERVICE_AGOOACK, bytes, null, null, null, null);
            accsRequest.setTag(msgDO.msgIds);
            Context context = mContext;
            String sendPushResponse = ACCSManager.getAccsInstance(context, Config.getAgooAppKey(context), Config.getAccsConfigTag(mContext)).sendPushResponse(mContext, accsRequest, extraInfo);
            ALog.i(TAG, "handlerACKMessage,endRequest,dataId=" + sendPushResponse, new Object[0]);
        } catch (Throwable th) {
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.e(TAG, "handlerACKMessage Throwable,msgIds=" + msgDO.msgIds + ",type=" + msgDO.type + ",e=" + th.toString(), new Object[0]);
            }
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ACK_MESSAGE, AdapterUtilityImpl.getDeviceId(mContext), "handlerACKMessageExceptionFailed", th.toString());
        }
    }

    public void init(Context context) {
        mContext = context;
    }

    public void pingApp(String str, String str2, String str3, int i) {
    }

    public void report(MsgDO msgDO, TaoBaseService.ExtraInfo extraInfo) {
        if (TextUtils.isEmpty(msgDO.reportStr)) {
            return;
        }
        try {
            if (Integer.parseInt(msgDO.reportStr) >= -1) {
                reportMethod(msgDO, extraInfo);
                if (msgDO.isFromCache) {
                    return;
                }
                AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_AGOO_ACK, msgDO.msgStatus, 0.0d);
            }
        } catch (Throwable th) {
            ALog.e(TAG, "[report] is error", th, new Object[0]);
        }
    }

    public void reportNotifyMessage(MsgDO msgDO) {
        if (msgDO != null) {
            try {
                AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_AGOO_REPORT_ID, msgDO.msgIds, 0.0d);
                ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(null, AgooConstants.AGOO_SERVICE_AGOOACK, convertMsgToBytes(msgDO), null, null, null, null);
                Context context = mContext;
                ACCSManager.getAccsInstance(context, Config.getAgooAppKey(context), Config.getAccsConfigTag(mContext)).sendPushResponse(mContext, accsRequest, null);
                if (ALog.isPrintLog(ALog.Level.E)) {
                    ALog.e(TAG, "reportNotifyMessage", Constants.KEY_DATA_ID, accsRequest.dataId, "status", msgDO.msgStatus);
                }
                AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_AGOO_CLICK, msgDO.msgStatus, 0.0d);
                AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_AGOO_ACK, msgDO.msgStatus, 0.0d);
            } catch (Throwable th) {
                ALog.e(TAG, "[reportNotifyMessage] is error", th, new Object[0]);
                AppMonitorAdapter.commitCount("accs", "error", th.toString(), 0.0d);
            }
        }
    }

    public void reportThirdPushToken(String str, String str2, boolean z) {
        reportThirdPushToken(str, str2, null, z);
    }

    public void reportThirdPushToken(final String str, final String str2, final String str3, final boolean z) {
        if (TextUtils.isEmpty(str)) {
            ALog.i(TAG, "reportThirdPushToken thirdId is empty", new Object[0]);
            return;
        }
        Launcher_InitPush.manuMonitor.isTokenEmpty = false;
        ThreadPoolExecutorFactory.schedule(new Runnable() { // from class: org.android.agoo.control.NotifManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("thirdTokenType", str2);
                    hashMap.put("token", str);
                    hashMap.put("appkey", Config.getAgooAppKey(NotifManager.mContext));
                    hashMap.put("utdid", AdapterUtilityImpl.getDeviceId(NotifManager.mContext));
                    if (!TextUtils.isEmpty(str3)) {
                        hashMap.put("vendorSdkVersion", str3);
                    }
                    NotifManager.report(hashMap, str, str2, z);
                } catch (Throwable th) {
                    UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "reportThirdPushToken", AdapterUtilityImpl.getDeviceId(NotifManager.mContext), th.toString());
                    if (ALog.isPrintLog(ALog.Level.E)) {
                        ALog.e(NotifManager.TAG, "[report] is error", th, new Object[0]);
                    }
                }
            }
        }, 10L, TimeUnit.SECONDS);
        try {
            Intent intent = new Intent();
            intent.setAction(AgooConstants.ACTION_THIRD_PUSH_TOKEN);
            intent.putExtra(AgooConstants.AGOO_PARAM_THIRD_BRAND_TYPE, str2);
            intent.putExtra(AgooConstants.AGOO_PARAM_THIRD_PUSH_TOKEN, str);
            mContext.sendBroadcast(intent);
        } catch (Exception e) {
            ALog.e(TAG, "[report] send push token broadcast error", e, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void report(Map<String, Object> map, String str, String str2, boolean z) throws UnsupportedEncodingException {
        boolean isRegIdSwitchEnableAndValid = OrangeAdapter.isRegIdSwitchEnableAndValid(mContext);
        String regId = OrangeAdapter.getRegId(mContext);
        if (isRegIdSwitchEnableAndValid) {
            map.put("cmd", "thirdTokenReport");
            map.put("regId", regId);
        }
        ALog.d(TAG, "report", "utdid", AdapterUtilityImpl.getDeviceId(mContext), "thirdId", str, "type", str2, "regId", regId);
        ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(null, getServiceId(mContext, "agooTokenReport"), new JSONObject(map).toString().getBytes("UTF-8"), null, null, null, null);
        Context context = mContext;
        IACCSManager accsInstance = ACCSManager.getAccsInstance(context, Config.getAgooAppKey(context), Config.getAccsConfigTag(mContext));
        if (z) {
            tokenReportDataId = accsInstance.sendData(mContext, accsRequest);
        } else {
            tokenReportDataId = accsInstance.sendPushResponse(mContext, accsRequest, new TaoBaseService.ExtraInfo());
        }
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.i(TAG, "reportThirdPushToken,dataId=" + tokenReportDataId + ",thirdId=" + str + ",type=" + str2, new Object[0]);
        }
    }

    public void reportThirdPushToken(String str, String str2) {
        reportThirdPushToken(str, str2, true);
    }
}
