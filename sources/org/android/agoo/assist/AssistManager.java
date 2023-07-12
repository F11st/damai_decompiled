package org.android.agoo.assist;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.UtilityImpl;
import com.uc.webview.export.extension.UCCore;
import org.android.agoo.assist.common.AssistConstant;
import org.android.agoo.assist.common.PhoneType;
import org.android.agoo.assist.filter.Operator;
import org.android.agoo.assist.util.DeviceUtil;
import org.android.agoo.assist.util.OrangeUtil;
import org.android.agoo.control.AgooFactory;
import org.android.agoo.control.NotifManager;
import org.android.agoo.huawei.HuaWeiRegister;
import org.android.agoo.mezu.MeizuRegister;
import org.android.agoo.oppo.OppoRegister;
import org.android.agoo.vivo.VivoRegister;
import org.android.agoo.xiaomi.MiPushRegistar;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AssistManager {
    private static final String TAG = "AssistManager";
    private static AgooFactory agooFactory;
    public static Context appContext;
    private static PhoneType phoneType;

    private static void debugLog() {
        if ((appContext.getApplicationInfo().flags & 2) != 0) {
            ALog.setPrintLog(true);
            ALog.setUseTlog(false);
            anet.channel.util.ALog.i(false);
        }
    }

    private static synchronized void getPhoneType() {
        synchronized (AssistManager.class) {
            try {
                if (phoneType == null) {
                    PhoneType checkDevice = DeviceUtil.checkDevice(appContext);
                    phoneType = checkDevice;
                    ALog.d(TAG, "getPhoneType()", "PhoneType", checkDevice.getTokenType());
                }
            } finally {
            }
        }
    }

    public static void init(final Context context, final AssistCallback assistCallback) {
        if (appContext == null) {
            Context applicationContext = context.getApplicationContext();
            appContext = applicationContext;
            Object[] objArr = new Object[2];
            objArr[0] = "AssistManager.appContext";
            objArr[1] = Boolean.valueOf(applicationContext == null);
            ALog.d(TAG, UCCore.LEGACY_EVENT_INIT, objArr);
            getPhoneType();
        }
        if (assistCallback == null) {
            return;
        }
        debugLog();
        if (!UtilityImpl.isMainProcess(context)) {
            ALog.d(TAG, "init only allowed in main process!!", new Object[0]);
        } else {
            ThreadPoolExecutorFactory.execute(new Runnable() { // from class: org.android.agoo.assist.AssistManager.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        OrangeUtil.registerListener();
                        Operator operator = AssistManager.phoneType.getOperator();
                        if (OrangeUtil.isAssistEnabled()) {
                            if (AssistCallback.this == null) {
                                ALog.e(AssistManager.TAG, "init callback is null", new Object[0]);
                                return;
                            } else {
                                ALog.i(AssistManager.TAG, "init#isAssistEnabled=true", new Object[0]);
                                operator.onRegister(AssistCallback.this);
                            }
                        } else {
                            ALog.i(AssistManager.TAG, "init#isAssistEnabled=false", new Object[0]);
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: org.android.agoo.assist.AssistManager.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        ApplicationInfo applicationInfo = AssistManager.appContext.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                                        String replace = applicationInfo.metaData.getString(AssistConstant.META_DATA.XM_APP_ID).replace("appid=", "");
                                        String replace2 = applicationInfo.metaData.getString(AssistConstant.META_DATA.XM_APP_KEY).replace("appkey=", "");
                                        String replace3 = applicationInfo.metaData.getString(AssistConstant.META_DATA.MZ_APP_ID).replace("appid=", "");
                                        String replace4 = applicationInfo.metaData.getString(AssistConstant.META_DATA.MZ_APP_KEY).replace("appkey=", "");
                                        String string = applicationInfo.metaData.getString(AssistConstant.META_DATA.OP_APP_KEY);
                                        String string2 = applicationInfo.metaData.getString(AssistConstant.META_DATA.OP_APP_SECRET);
                                        MiPushRegistar.register(AssistManager.appContext, replace, replace2);
                                        MeizuRegister.register(AssistManager.appContext, replace3, replace4);
                                        OppoRegister.register(AssistManager.appContext, string, string2);
                                        VivoRegister.register(AssistManager.appContext);
                                        HuaWeiRegister.register(AssistManager.appContext);
                                    } catch (Throwable th) {
                                        ALog.e(AssistManager.TAG, "old register err", th, new Object[0]);
                                    }
                                }
                            }, 20000L);
                        }
                        AssistManager.monitorRegister();
                    } catch (Throwable th) {
                        ALog.e(AssistManager.TAG, "init err", th, new Object[0]);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void monitorRegister() {
        AppMonitorAdapter.commitCount("accs", AssistConstant.Monitor.COUNT_ASSIST_REGISTER, "", 0.0d);
    }

    public static String parseMsgFromIntent(Intent intent) {
        if (!OrangeUtil.isAssistEnabled()) {
            ALog.d(TAG, "parseMsgFromIntent#isAssistEnabled=false", new Object[0]);
            return null;
        }
        PhoneType phoneType2 = phoneType;
        if (phoneType2 == null) {
            ALog.d(TAG, "reportToken#phoneType=null", new Object[0]);
            return null;
        } else if (intent == null) {
            ALog.e(TAG, "parseMsgFromIntent null", new Object[0]);
            return null;
        } else {
            try {
                ALog.i(TAG, "parseMsgFromIntent", "msg", phoneType2.getOperator().parseMsgFromIntent(intent));
            } catch (Exception e) {
                ALog.e(TAG, "parseMsgFromIntent", e, new Object[0]);
                e.printStackTrace();
            }
            return null;
        }
    }

    public static void reportMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            ALog.d(TAG, "report message token", new Object[0]);
        } else if (phoneType != null) {
            try {
                if (agooFactory == null) {
                    AgooFactory agooFactory2 = new AgooFactory();
                    agooFactory = agooFactory2;
                    agooFactory2.init(appContext, null, null);
                }
                agooFactory.msgRecevie(str.getBytes("UTF-8"), phoneType.getMsgSource(), null);
            } catch (Exception e) {
                ALog.e(TAG, "reportMessage", e, new Object[0]);
            }
            if (OrangeUtil.isAssistEnabled()) {
                return;
            }
            phoneType.getOperator().onPayload(str);
        } else {
            ALog.d(TAG, "reportMessage phoneType=null", new Object[0]);
        }
    }

    public static void reportToken(String str) {
        if (TextUtils.isEmpty(str)) {
            ALog.d(TAG, "report empty token", new Object[0]);
        } else if (phoneType != null) {
            NotifManager notifManager = new NotifManager();
            notifManager.init(appContext);
            if ("vivo".equals(phoneType.getMsgSource())) {
                notifManager.reportThirdPushToken(str, phoneType.getTokenType(), "1.1.5", true);
            } else {
                notifManager.reportThirdPushToken(str, phoneType.getTokenType());
            }
            if (OrangeUtil.isAssistEnabled()) {
                return;
            }
            phoneType.getOperator().onToken(str);
        } else {
            ALog.d(TAG, "reportToken phoneType = null", new Object[0]);
        }
    }
}
