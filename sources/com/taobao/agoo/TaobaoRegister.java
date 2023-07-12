package com.taobao.agoo;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsException;
import com.taobao.accs.IACCSManager;
import com.taobao.accs.IAgooAppReceiver;
import com.taobao.accs.client.AdapterGlobalClientInfo;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.init.Launcher_InitPush;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.ForeBackManager;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.xiaomi.mipush.sdk.MiPushClient;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.CallBack;
import org.android.agoo.common.Config;
import org.android.agoo.common.MsgDO;
import org.android.agoo.control.AgooFactory;
import org.android.agoo.control.NotifManager;
import tb.e22;
import tb.l12;
import tb.u4;

/* loaded from: classes8.dex */
public final class TaobaoRegister {
    private static final int EVENT_ID = 66001;
    static final String PREFERENCES = "Agoo_AppStore";
    static final String PROPERTY_APP_NOTIFICATION_CUSTOM_SOUND = "app_notification_custom_sound";
    static final String PROPERTY_APP_NOTIFICATION_ICON = "app_notification_icon";
    static final String PROPERTY_APP_NOTIFICATION_SOUND = "app_notification_sound";
    static final String PROPERTY_APP_NOTIFICATION_VIBRATE = "app_notification_vibrate";
    private static final String SERVICEID = "agooSend";
    protected static final String TAG = "TaobaoRegister";
    private static AtomicBoolean isManuRegister = new AtomicBoolean(false);
    private static boolean isRegisterSuccess;
    private static e22 mRequestListener;

    /* loaded from: classes8.dex */
    static class RemoveAliasCallback extends ICallback {
        ICallback callback;

        public RemoveAliasCallback(ICallback iCallback) {
            this.callback = iCallback;
            this.extra = iCallback.extra;
        }

        @Override // com.taobao.agoo.ICallback
        public void onFailure(String str, String str2) {
            ICallback iCallback = this.callback;
            if (iCallback != null) {
                iCallback.onFailure(str, str2);
            }
            ALog.e(TaobaoRegister.TAG, "setAlias onFailure", "errCode", str, "errDesc", str2, "extra", this.extra);
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_REMOVE_ALIAS, "", str, str2);
        }

        @Override // com.taobao.agoo.ICallback
        public void onSuccess() {
            ICallback iCallback = this.callback;
            if (iCallback != null) {
                iCallback.onSuccess();
            }
            AppMonitorAdapter.commitAlarmSuccess("accs", BaseMonitor.ALARM_REMOVE_ALIAS, "");
        }
    }

    /* loaded from: classes8.dex */
    static class SetAliasCallback extends ICallback {
        ICallback callback;

        public SetAliasCallback(ICallback iCallback) {
            this.callback = iCallback;
            this.extra = iCallback.extra;
        }

        @Override // com.taobao.agoo.ICallback
        public void onFailure(String str, String str2) {
            ICallback iCallback = this.callback;
            if (iCallback != null) {
                iCallback.onFailure(str, str2);
            }
            ALog.e(TaobaoRegister.TAG, "setAlias onFailure", "errCode", str, "errDesc", str2, "extra", this.extra);
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_SET_ALIAS, "", str, str2);
        }

        @Override // com.taobao.agoo.ICallback
        public void onSuccess() {
            ICallback iCallback = this.callback;
            if (iCallback != null) {
                iCallback.onSuccess();
            }
            AppMonitorAdapter.commitAlarmSuccess("accs", BaseMonitor.ALARM_SET_ALIAS, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.taobao.agoo.TaobaoRegister$a */
    /* loaded from: classes8.dex */
    public static class C6250a implements IAgooAppReceiver {
        final /* synthetic */ Context a;
        final /* synthetic */ Context b;
        final /* synthetic */ IRegister c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ IACCSManager f;

        C6250a(Context context, Context context2, IRegister iRegister, String str, String str2, IACCSManager iACCSManager) {
            this.a = context;
            this.b = context2;
            this.c = iRegister;
            this.d = str;
            this.e = str2;
            this.f = iACCSManager;
        }

        @Override // com.taobao.accs.IAppReceiver
        public Map<String, String> getAllServices() {
            return null;
        }

        @Override // com.taobao.accs.IAgooAppReceiver
        public String getAppkey() {
            return this.d;
        }

        @Override // com.taobao.accs.IAppReceiver
        public String getService(String str) {
            return null;
        }

        @Override // com.taobao.accs.IAppReceiver
        public void onBindApp(int i) {
        }

        @Override // com.taobao.accs.IAgooAppReceiver, com.taobao.accs.IAppReceiverV1
        public void onBindApp(int i, String str) {
            try {
                ALog.i(TaobaoRegister.TAG, "onBindApp", "errorCode", Integer.valueOf(i));
                if (i == 200) {
                    if (TaobaoRegister.mRequestListener == null) {
                        e22 unused = TaobaoRegister.mRequestListener = new e22(this.a);
                    }
                    GlobalClientInfo.getInstance(this.b).registerListener(NotifManager.getServiceId(this.b, TaobaoConstants.SERVICE_ID_DEVICECMD), TaobaoRegister.mRequestListener);
                    if (OrangeAdapter.isRegIdSwitchEnableAndValid(this.b)) {
                        if (TextUtils.isEmpty(str)) {
                            this.c.onFailure(TaobaoConstants.REGISTER_ERROR, "agoo server error deviceid null");
                            return;
                        }
                        TaobaoRegister.setIsRegisterSuccess(true);
                        ForeBackManager.getManager().reportSaveClickMessage();
                        UtilityImpl.saveUtdid("Agoo_AppStore", GlobalClientInfo.getContext());
                        this.c.onSuccess(str);
                        return;
                    } else if (e22.b.b(this.a.getPackageName()) && !UtilityImpl.notificationStateChanged(Constants.SP_CHANNEL_FILE_NAME, this.b)) {
                        TaobaoRegister.setIsRegisterSuccess(true);
                        ForeBackManager.getManager().reportSaveClickMessage();
                        ALog.i(TaobaoRegister.TAG, "agoo already Registered return ", new Object[0]);
                        IRegister iRegister = this.c;
                        if (iRegister != null) {
                            iRegister.onSuccess(Config.getDeviceToken(this.a));
                            return;
                        }
                        return;
                    } else {
                        byte[] b = l12.b(this.a, this.d, this.e);
                        if (b == null) {
                            IRegister iRegister2 = this.c;
                            if (iRegister2 != null) {
                                iRegister2.onFailure(TaobaoConstants.REGISTER_ERROR, "req data null");
                                return;
                            }
                            return;
                        }
                        String sendRequest = this.f.sendRequest(this.a, new ACCSManager.AccsRequest(null, TaobaoConstants.SERVICE_ID_DEVICECMD, b, null));
                        if (TextUtils.isEmpty(sendRequest)) {
                            IRegister iRegister3 = this.c;
                            if (iRegister3 != null) {
                                iRegister3.onFailure(TaobaoConstants.REGISTER_ERROR, "accs channel disabled!");
                                return;
                            }
                            return;
                        } else if (this.c != null) {
                            TaobaoRegister.mRequestListener.a.put(sendRequest, this.c);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                IRegister iRegister4 = this.c;
                if (iRegister4 != null) {
                    iRegister4.onFailure(String.valueOf(i), "accs bindapp error!");
                }
            } catch (Throwable th) {
                ALog.e(TaobaoRegister.TAG, "register onBindApp", th, new Object[0]);
            }
        }

        @Override // com.taobao.accs.IAppReceiver
        public void onBindUser(String str, int i) {
        }

        @Override // com.taobao.accs.IAppReceiver
        public void onData(String str, String str2, byte[] bArr) {
        }

        @Override // com.taobao.accs.IAppReceiver
        public void onSendData(String str, int i) {
        }

        @Override // com.taobao.accs.IAppReceiver
        public void onUnbindApp(int i) {
        }

        @Override // com.taobao.accs.IAppReceiver
        public void onUnbindUser(int i) {
        }
    }

    private TaobaoRegister() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static void bindAgoo(Context context, String str, String str2, CallBack callBack) {
        bindAgoo(context, null);
    }

    public static void clickMessage(Context context, String str, String str2) {
        clickMessage(context, str, str2, 0, 0L);
    }

    public static void dismissMessage(Context context, String str, String str2) {
        NotifManager notifManager = new NotifManager();
        MsgDO msgDO = null;
        try {
            if (ALog.isPrintLog(ALog.Level.I)) {
                ALog.i(TAG, "dismissMessage", "msgid", str, AgooConstants.MESSAGE_EXT, str2);
            }
            if (TextUtils.isEmpty(str)) {
                ALog.d(TAG, "messageId == null", new Object[0]);
                return;
            }
            notifManager.init(context);
            MsgDO msgDO2 = new MsgDO();
            try {
                msgDO2.msgIds = str;
                msgDO2.extData = str2;
                msgDO2.messageSource = "accs";
                msgDO2.msgStatus = "9";
                AgooFactory agooFactory = new AgooFactory();
                agooFactory.init(context, notifManager, null);
                agooFactory.updateMsgStatus(str, "9");
                notifManager.reportNotifyMessage(msgDO2);
            } catch (Throwable th) {
                th = th;
                msgDO = msgDO2;
                try {
                    ALog.e(TAG, "dismissMessage,error=" + th, new Object[0]);
                } finally {
                    if (msgDO != null) {
                        notifManager.reportNotifyMessage(msgDO);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void exposureMessage(Context context, String str, String str2) {
        NotifManager notifManager = new NotifManager();
        MsgDO msgDO = null;
        try {
            if (ALog.isPrintLog(ALog.Level.I)) {
                ALog.i(TAG, "exposureMessage", "msgid", str, AgooConstants.MESSAGE_EXT, str2);
            }
            if (TextUtils.isEmpty(str)) {
                ALog.d(TAG, "messageId == null", new Object[0]);
                return;
            }
            notifManager.init(context);
            MsgDO msgDO2 = new MsgDO();
            try {
                msgDO2.msgIds = str;
                msgDO2.extData = str2;
                msgDO2.messageSource = "accs";
                msgDO2.msgStatus = "10";
                new AgooFactory().init(context, notifManager, null);
                notifManager.reportNotifyMessage(msgDO2);
            } catch (Throwable th) {
                th = th;
                msgDO = msgDO2;
                try {
                    ALog.e(TAG, "exposureMessage,error=" + th, new Object[0]);
                } finally {
                    if (msgDO != null) {
                        notifManager.reportNotifyMessage(msgDO);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean isRegisterSuccess() {
        return isRegisterSuccess;
    }

    public static void pingApp(Context context, String str, String str2, String str3, int i) {
        NotifManager notifManager = new NotifManager();
        notifManager.init(context);
        notifManager.pingApp(str, str2, str3, i);
    }

    @Deprecated
    public static synchronized void register(Context context, String str, String str2, String str3, IRegister iRegister) throws AccsException {
        synchronized (TaobaoRegister.class) {
            register(context, "default", str, str2, str3, iRegister);
        }
    }

    public static void registerManuMonitor(Context context) {
        if (isManuRegister.getAndSet(true) || AdapterUtilityImpl.isTaobao(context)) {
            return;
        }
        Launcher_InitPush.monitorPush(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0086, code lost:
        r10.onFailure(com.taobao.agoo.TaobaoConstants.ALIAS_ERROR, "input params null!!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void removeAlias(android.content.Context r8, java.lang.String r9, com.taobao.agoo.ICallback r10) {
        /*
            java.lang.Class<com.taobao.agoo.TaobaoRegister> r0 = com.taobao.agoo.TaobaoRegister.class
            monitor-enter(r0)
            boolean r1 = com.taobao.accs.utl.OrangeAdapter.isAliasAlarmEnabled()     // Catch: java.lang.Throwable -> Lc5
            if (r1 == 0) goto Lf
            com.taobao.agoo.TaobaoRegister$RemoveAliasCallback r1 = new com.taobao.agoo.TaobaoRegister$RemoveAliasCallback     // Catch: java.lang.Throwable -> Lc5
            r1.<init>(r10)     // Catch: java.lang.Throwable -> Lc5
            r10 = r1
        Lf:
            java.lang.String r1 = "TaobaoRegister"
            java.lang.String r2 = "removeAlias"
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> Lc5
            com.taobao.accs.utl.ALog.i(r1, r2, r4)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r1 = org.android.agoo.common.Config.getDeviceToken(r8)     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r2 = org.android.agoo.common.Config.getAgooAppKey(r8)     // Catch: java.lang.Throwable -> Lb9
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Lb9
            if (r4 != 0) goto L84
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Lb9
            if (r4 != 0) goto L84
            if (r8 == 0) goto L84
            boolean r4 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> Lb9
            if (r4 == 0) goto L36
            goto L84
        L36:
            java.lang.String r4 = org.android.agoo.common.Config.getAccsConfigTag(r8)     // Catch: java.lang.Throwable -> Lb9
            com.taobao.accs.IACCSManager r4 = com.taobao.accs.ACCSManager.getAccsInstance(r8, r2, r4)     // Catch: java.lang.Throwable -> Lb9
            tb.e22 r5 = com.taobao.agoo.TaobaoRegister.mRequestListener     // Catch: java.lang.Throwable -> Lb9
            if (r5 != 0) goto L4d
            tb.e22 r5 = new tb.e22     // Catch: java.lang.Throwable -> Lb9
            android.content.Context r6 = r8.getApplicationContext()     // Catch: java.lang.Throwable -> Lb9
            r5.<init>(r6)     // Catch: java.lang.Throwable -> Lb9
            com.taobao.agoo.TaobaoRegister.mRequestListener = r5     // Catch: java.lang.Throwable -> Lb9
        L4d:
            java.lang.String r5 = "AgooDeviceCmd"
            java.lang.String r5 = org.android.agoo.control.NotifManager.getServiceId(r8, r5)     // Catch: java.lang.Throwable -> Lb9
            com.taobao.accs.client.GlobalClientInfo r6 = com.taobao.accs.client.GlobalClientInfo.getInstance(r8)     // Catch: java.lang.Throwable -> Lb9
            tb.e22 r7 = com.taobao.agoo.TaobaoRegister.mRequestListener     // Catch: java.lang.Throwable -> Lb9
            r6.registerListener(r5, r7)     // Catch: java.lang.Throwable -> Lb9
            byte[] r9 = tb.u4.d(r2, r1, r9)     // Catch: java.lang.Throwable -> Lb9
            com.taobao.accs.ACCSManager$AccsRequest r1 = new com.taobao.accs.ACCSManager$AccsRequest     // Catch: java.lang.Throwable -> Lb9
            r2 = 0
            r1.<init>(r2, r5, r9, r2)     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r8 = r4.sendRequest(r8, r1)     // Catch: java.lang.Throwable -> Lb9
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> Lb9
            if (r9 == 0) goto L7a
            if (r10 == 0) goto Lc3
            java.lang.String r8 = "504.1"
            java.lang.String r9 = "accs channel disabled!"
            r10.onFailure(r8, r9)     // Catch: java.lang.Throwable -> Lb9
            goto Lc3
        L7a:
            if (r10 == 0) goto Lc3
            tb.e22 r9 = com.taobao.agoo.TaobaoRegister.mRequestListener     // Catch: java.lang.Throwable -> Lb9
            java.util.Map<java.lang.String, com.taobao.agoo.ICallback> r9 = r9.a     // Catch: java.lang.Throwable -> Lb9
            r9.put(r8, r10)     // Catch: java.lang.Throwable -> Lb9
            goto Lc3
        L84:
            if (r10 == 0) goto L8d
            java.lang.String r4 = "504.1"
            java.lang.String r5 = "input params null!!"
            r10.onFailure(r4, r5)     // Catch: java.lang.Throwable -> Lb9
        L8d:
            java.lang.String r10 = "TaobaoRegister"
            java.lang.String r4 = "setAlias param null"
            r5 = 8
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r6 = "appkey"
            r5[r3] = r6     // Catch: java.lang.Throwable -> Lb9
            r6 = 1
            r5[r6] = r2     // Catch: java.lang.Throwable -> Lb9
            r2 = 2
            java.lang.String r6 = "deviceId"
            r5[r2] = r6     // Catch: java.lang.Throwable -> Lb9
            r2 = 3
            r5[r2] = r1     // Catch: java.lang.Throwable -> Lb9
            r1 = 4
            java.lang.String r2 = "alias"
            r5[r1] = r2     // Catch: java.lang.Throwable -> Lb9
            r1 = 5
            r5[r1] = r9     // Catch: java.lang.Throwable -> Lb9
            r9 = 6
            java.lang.String r1 = "context"
            r5[r9] = r1     // Catch: java.lang.Throwable -> Lb9
            r9 = 7
            r5[r9] = r8     // Catch: java.lang.Throwable -> Lb9
            com.taobao.accs.utl.ALog.e(r10, r4, r5)     // Catch: java.lang.Throwable -> Lb9
            monitor-exit(r0)
            return
        Lb9:
            r8 = move-exception
            java.lang.String r9 = "TaobaoRegister"
            java.lang.String r10 = "removeAlias"
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> Lc5
            com.taobao.accs.utl.ALog.e(r9, r10, r8, r1)     // Catch: java.lang.Throwable -> Lc5
        Lc3:
            monitor-exit(r0)
            return
        Lc5:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.agoo.TaobaoRegister.removeAlias(android.content.Context, java.lang.String, com.taobao.agoo.ICallback):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0071, code lost:
        r11.onFailure(com.taobao.agoo.TaobaoConstants.ALIAS_ERROR, "input params null!!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void removeAllAlias(android.content.Context r10, com.taobao.agoo.ICallback r11) {
        /*
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "TaobaoRegister"
            java.lang.String r3 = "removeAllAlias"
            com.taobao.accs.utl.ALog.i(r2, r3, r1)
            java.lang.String r1 = org.android.agoo.common.Config.getDeviceToken(r10)     // Catch: java.lang.Throwable -> L96
            java.lang.String r4 = org.android.agoo.common.Config.getAgooAppKey(r10)     // Catch: java.lang.Throwable -> L96
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L96
            java.lang.String r6 = "504.1"
            if (r5 != 0) goto L6f
            boolean r5 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L96
            if (r5 != 0) goto L6f
            if (r10 != 0) goto L23
            goto L6f
        L23:
            java.lang.String r5 = org.android.agoo.common.Config.getAccsConfigTag(r10)     // Catch: java.lang.Throwable -> L96
            com.taobao.accs.IACCSManager r5 = com.taobao.accs.ACCSManager.getAccsInstance(r10, r4, r5)     // Catch: java.lang.Throwable -> L96
            tb.e22 r7 = com.taobao.agoo.TaobaoRegister.mRequestListener     // Catch: java.lang.Throwable -> L96
            if (r7 != 0) goto L3a
            tb.e22 r7 = new tb.e22     // Catch: java.lang.Throwable -> L96
            android.content.Context r8 = r10.getApplicationContext()     // Catch: java.lang.Throwable -> L96
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L96
            com.taobao.agoo.TaobaoRegister.mRequestListener = r7     // Catch: java.lang.Throwable -> L96
        L3a:
            java.lang.String r7 = "AgooDeviceCmd"
            java.lang.String r7 = org.android.agoo.control.NotifManager.getServiceId(r10, r7)     // Catch: java.lang.Throwable -> L96
            com.taobao.accs.client.GlobalClientInfo r8 = com.taobao.accs.client.GlobalClientInfo.getInstance(r10)     // Catch: java.lang.Throwable -> L96
            tb.e22 r9 = com.taobao.agoo.TaobaoRegister.mRequestListener     // Catch: java.lang.Throwable -> L96
            r8.registerListener(r7, r9)     // Catch: java.lang.Throwable -> L96
            byte[] r1 = tb.u4.b(r4, r1)     // Catch: java.lang.Throwable -> L96
            com.taobao.accs.ACCSManager$AccsRequest r4 = new com.taobao.accs.ACCSManager$AccsRequest     // Catch: java.lang.Throwable -> L96
            r8 = 0
            r4.<init>(r8, r7, r1, r8)     // Catch: java.lang.Throwable -> L96
            java.lang.String r10 = r5.sendRequest(r10, r4)     // Catch: java.lang.Throwable -> L96
            boolean r1 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> L96
            if (r1 == 0) goto L65
            if (r11 == 0) goto L9c
            java.lang.String r10 = "accs channel disabled!"
            r11.onFailure(r6, r10)     // Catch: java.lang.Throwable -> L96
            goto L9c
        L65:
            if (r11 == 0) goto L9c
            tb.e22 r1 = com.taobao.agoo.TaobaoRegister.mRequestListener     // Catch: java.lang.Throwable -> L96
            java.util.Map<java.lang.String, com.taobao.agoo.ICallback> r1 = r1.a     // Catch: java.lang.Throwable -> L96
            r1.put(r10, r11)     // Catch: java.lang.Throwable -> L96
            goto L9c
        L6f:
            if (r11 == 0) goto L76
            java.lang.String r5 = "input params null!!"
            r11.onFailure(r6, r5)     // Catch: java.lang.Throwable -> L96
        L76:
            java.lang.String r11 = "removeAllAlias param null"
            r5 = 6
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L96
            java.lang.String r6 = "appkey"
            r5[r0] = r6     // Catch: java.lang.Throwable -> L96
            r6 = 1
            r5[r6] = r4     // Catch: java.lang.Throwable -> L96
            r4 = 2
            java.lang.String r6 = "deviceId"
            r5[r4] = r6     // Catch: java.lang.Throwable -> L96
            r4 = 3
            r5[r4] = r1     // Catch: java.lang.Throwable -> L96
            r1 = 4
            java.lang.String r4 = "context"
            r5[r1] = r4     // Catch: java.lang.Throwable -> L96
            r1 = 5
            r5[r1] = r10     // Catch: java.lang.Throwable -> L96
            com.taobao.accs.utl.ALog.e(r2, r11, r5)     // Catch: java.lang.Throwable -> L96
            return
        L96:
            r10 = move-exception
            java.lang.Object[] r11 = new java.lang.Object[r0]
            com.taobao.accs.utl.ALog.e(r2, r3, r10, r11)
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.agoo.TaobaoRegister.removeAllAlias(android.content.Context, com.taobao.agoo.ICallback):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0092, code lost:
        r14.onFailure(com.taobao.agoo.TaobaoConstants.UNBINDAGOO_ERROR, "input params null!!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static synchronized void sendSwitch(android.content.Context r13, com.taobao.agoo.ICallback r14, boolean r15) {
        /*
            java.lang.Class<com.taobao.agoo.TaobaoRegister> r0 = com.taobao.agoo.TaobaoRegister.class
            monitor-enter(r0)
            r1 = 0
            java.lang.String r2 = org.android.agoo.common.Config.getDeviceToken(r13)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r3 = org.android.agoo.common.Config.getAgooAppKey(r13)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r4 = com.taobao.accs.utl.UtilityImpl.getDeviceId(r13)     // Catch: java.lang.Throwable -> Lc5
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> Lc5
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = 1
            if (r5 != 0) goto L90
            if (r13 == 0) goto L90
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Lc5
            if (r5 == 0) goto L29
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> Lc5
            if (r5 == 0) goto L29
            goto L90
        L29:
            java.lang.String r5 = org.android.agoo.common.Config.getAccsConfigTag(r13)     // Catch: java.lang.Throwable -> Lc5
            com.taobao.accs.IACCSManager r5 = com.taobao.accs.ACCSManager.getAccsInstance(r13, r3, r5)     // Catch: java.lang.Throwable -> Lc5
            tb.e22 r10 = com.taobao.agoo.TaobaoRegister.mRequestListener     // Catch: java.lang.Throwable -> Lc5
            if (r10 != 0) goto L40
            tb.e22 r10 = new tb.e22     // Catch: java.lang.Throwable -> Lc5
            android.content.Context r11 = r13.getApplicationContext()     // Catch: java.lang.Throwable -> Lc5
            r10.<init>(r11)     // Catch: java.lang.Throwable -> Lc5
            com.taobao.agoo.TaobaoRegister.mRequestListener = r10     // Catch: java.lang.Throwable -> Lc5
        L40:
            java.lang.String r10 = "AgooDeviceCmd"
            java.lang.String r10 = org.android.agoo.control.NotifManager.getServiceId(r13, r10)     // Catch: java.lang.Throwable -> Lc5
            com.taobao.accs.client.GlobalClientInfo r11 = com.taobao.accs.client.GlobalClientInfo.getInstance(r13)     // Catch: java.lang.Throwable -> Lc5
            tb.e22 r12 = com.taobao.agoo.TaobaoRegister.mRequestListener     // Catch: java.lang.Throwable -> Lc5
            r11.registerListener(r10, r12)     // Catch: java.lang.Throwable -> Lc5
            byte[] r2 = tb.hj2.b(r3, r2, r4, r15)     // Catch: java.lang.Throwable -> Lc5
            com.taobao.accs.ACCSManager$AccsRequest r3 = new com.taobao.accs.ACCSManager$AccsRequest     // Catch: java.lang.Throwable -> Lc5
            r4 = 0
            r3.<init>(r4, r10, r2, r4)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r13 = r5.sendRequest(r13, r3)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r2 = "TaobaoRegister"
            java.lang.String r3 = "sendSwitch"
            java.lang.Object[] r4 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r5 = "dataId"
            r4[r1] = r5     // Catch: java.lang.Throwable -> Lc5
            r4[r9] = r13     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r5 = "enablePush"
            r4[r8] = r5     // Catch: java.lang.Throwable -> Lc5
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r15)     // Catch: java.lang.Throwable -> Lc5
            r4[r7] = r15     // Catch: java.lang.Throwable -> Lc5
            com.taobao.accs.utl.ALog.e(r2, r3, r4)     // Catch: java.lang.Throwable -> Lc5
            boolean r15 = android.text.TextUtils.isEmpty(r13)     // Catch: java.lang.Throwable -> Lc5
            if (r15 == 0) goto L86
            if (r14 == 0) goto Lcf
            java.lang.String r13 = "503.2"
            java.lang.String r15 = "accs channel disabled!"
            r14.onFailure(r13, r15)     // Catch: java.lang.Throwable -> Lc5
            goto Lcf
        L86:
            if (r14 == 0) goto Lcf
            tb.e22 r15 = com.taobao.agoo.TaobaoRegister.mRequestListener     // Catch: java.lang.Throwable -> Lc5
            java.util.Map<java.lang.String, com.taobao.agoo.ICallback> r15 = r15.a     // Catch: java.lang.Throwable -> Lc5
            r15.put(r13, r14)     // Catch: java.lang.Throwable -> Lc5
            goto Lcf
        L90:
            if (r14 == 0) goto L99
            java.lang.String r4 = "503.3"
            java.lang.String r5 = "input params null!!"
            r14.onFailure(r4, r5)     // Catch: java.lang.Throwable -> Lc5
        L99:
            java.lang.String r14 = "TaobaoRegister"
            java.lang.String r4 = "sendSwitch param null"
            r5 = 8
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r10 = "appkey"
            r5[r1] = r10     // Catch: java.lang.Throwable -> Lc5
            r5[r9] = r3     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r3 = "deviceId"
            r5[r8] = r3     // Catch: java.lang.Throwable -> Lc5
            r5[r7] = r2     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r2 = "context"
            r5[r6] = r2     // Catch: java.lang.Throwable -> Lc5
            r2 = 5
            r5[r2] = r13     // Catch: java.lang.Throwable -> Lc5
            r13 = 6
            java.lang.String r2 = "enablePush"
            r5[r13] = r2     // Catch: java.lang.Throwable -> Lc5
            r13 = 7
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r15)     // Catch: java.lang.Throwable -> Lc5
            r5[r13] = r15     // Catch: java.lang.Throwable -> Lc5
            com.taobao.accs.utl.ALog.e(r14, r4, r5)     // Catch: java.lang.Throwable -> Lc5
            monitor-exit(r0)
            return
        Lc5:
            r13 = move-exception
            java.lang.String r14 = "TaobaoRegister"
            java.lang.String r15 = "sendSwitch"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Ld1
            com.taobao.accs.utl.ALog.e(r14, r15, r13, r1)     // Catch: java.lang.Throwable -> Ld1
        Lcf:
            monitor-exit(r0)
            return
        Ld1:
            r13 = move-exception
            monitor-exit(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.agoo.TaobaoRegister.sendSwitch(android.content.Context, com.taobao.agoo.ICallback, boolean):void");
    }

    public static synchronized void setAccsConfigTag(Context context, String str) {
        synchronized (TaobaoRegister.class) {
            Config.mAccsConfigTag = str;
            AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
            if (configByTag != null) {
                ALog.i(TAG, "setAccsConfigTag", com.youku.arch.v3.core.Constants.CONFIG, configByTag.toString());
                AdapterGlobalClientInfo.mAuthCode = configByTag.getAuthCode();
                Config.setAgooAppKey(context, configByTag.getAppKey());
                String appSecret = configByTag.getAppSecret();
                AdapterUtilityImpl.mAgooAppSecret = appSecret;
                if (!TextUtils.isEmpty(appSecret)) {
                    AdapterGlobalClientInfo.mSecurityType = 2;
                }
            } else {
                throw new RuntimeException("accs config not exist!! please set accs config first!!");
            }
        }
    }

    public static void setAgooMsgReceiveService(String str) {
        AdapterGlobalClientInfo.mAgooCustomServiceName = str;
    }

    public static synchronized void setAlias(Context context, String str, ICallback iCallback) {
        synchronized (TaobaoRegister.class) {
            if (OrangeAdapter.isAliasAlarmEnabled()) {
                iCallback = new SetAliasCallback(iCallback);
            }
            ALog.i(TAG, u4.JSON_CMD_SETALIAS, "alias", str);
            String deviceToken = Config.getDeviceToken(context);
            String agooAppKey = Config.getAgooAppKey(context);
            if (!TextUtils.isEmpty(agooAppKey) && !TextUtils.isEmpty(deviceToken) && context != null && !TextUtils.isEmpty(str)) {
                if (mRequestListener == null) {
                    mRequestListener = new e22(context.getApplicationContext());
                }
                if (e22.b.a(str)) {
                    ALog.i(TAG, "setAlias already set", "alias", str);
                    if (iCallback != null) {
                        iCallback.onSuccess();
                    }
                    return;
                }
                IACCSManager accsInstance = ACCSManager.getAccsInstance(context, agooAppKey, Config.getAccsConfigTag(context));
                if (!OrangeAdapter.isRegIdSwitchEnableAndValid(context) && !e22.b.b(context.getPackageName())) {
                    if (iCallback != null) {
                        iCallback.onFailure(TaobaoConstants.ALIAS_ERROR, "bindApp first!!");
                    }
                    return;
                }
                String serviceId = NotifManager.getServiceId(context, TaobaoConstants.SERVICE_ID_DEVICECMD);
                GlobalClientInfo.getInstance(context).registerListener(serviceId, mRequestListener);
                String sendRequest = accsInstance.sendRequest(context, new ACCSManager.AccsRequest(null, NotifManager.getServiceId(context, serviceId), u4.e(agooAppKey, deviceToken, str), null));
                if (TextUtils.isEmpty(sendRequest)) {
                    if (iCallback != null) {
                        iCallback.onFailure(TaobaoConstants.ALIAS_ERROR, "accs channel disabled!");
                    }
                } else if (iCallback != null) {
                    iCallback.extra = str;
                    mRequestListener.a.put(sendRequest, iCallback);
                }
                return;
            }
            if (iCallback != null) {
                iCallback.onFailure(TaobaoConstants.ALIAS_ERROR, "input params null!!");
            }
            ALog.e(TAG, "setAlias param null", "appkey", agooAppKey, "deviceId", deviceToken, "alias", str, WPKFactory.INIT_KEY_CONTEXT, context);
        }
    }

    @Deprecated
    public static void setBuilderSound(Context context, String str) {
    }

    public static void setEnv(Context context, @AccsClientConfig.ENV int i) {
        ACCSClient.setEnvironment(context, i);
    }

    public static void setIsRegisterSuccess(boolean z) {
        isRegisterSuccess = z;
    }

    @Deprecated
    public static void setNotificationIcon(Context context, int i) {
    }

    @Deprecated
    public static void setNotificationSound(Context context, boolean z) {
    }

    @Deprecated
    public static void setNotificationVibrate(Context context, boolean z) {
    }

    @Deprecated
    public static void unBindAgoo(Context context, String str, String str2, CallBack callBack) {
        unbindAgoo(context, null);
    }

    public static void unbindAgoo(Context context, ICallback iCallback) {
        sendSwitch(context, iCallback, false);
        UTMini.getInstance().commitEvent(66001, MiPushClient.COMMAND_UNREGISTER, UtilityImpl.getDeviceId(context));
    }

    @Deprecated
    public static void unregister(Context context, CallBack callBack) {
        unbindAgoo(context, null);
    }

    public static void bindAgoo(Context context, ICallback iCallback) {
        sendSwitch(context, iCallback, true);
        UTMini.getInstance().commitEvent(66001, "bindAgoo", UtilityImpl.getDeviceId(context));
    }

    public static void clickMessage(Context context, String str, String str2, int i, long j) {
        MsgDO msgDO;
        NotifManager notifManager = new NotifManager();
        try {
            if (ALog.isPrintLog(ALog.Level.I)) {
                ALog.i(TAG, "clickMessage", "msgid", str, AgooConstants.MESSAGE_EXT, str2);
            }
            if (TextUtils.isEmpty(str)) {
                ALog.d(TAG, "messageId == null", new Object[0]);
                return;
            }
            notifManager.init(context);
            MsgDO msgDO2 = new MsgDO();
            try {
                msgDO2.evokeAppStatus = 1;
                boolean z = (i & 1) == 1;
                boolean z2 = (i & 2) == 2;
                boolean z3 = (i & 4) == 4;
                boolean z4 = (i & 8) == 8;
                boolean z5 = z ^ z2;
                msgDO2.isGlobalClick = z5;
                if (z5) {
                    ALog.e(TAG, "clickMessage", "isLaunchByAgoo", Boolean.valueOf(z2), "isEvokeByAgoo", Boolean.valueOf(z), "isComeFromBg", Boolean.valueOf(z3), "isSameDay", Boolean.valueOf(z4), "lastActiveTime", Long.valueOf(j));
                    msgDO2.lastActiveTime = j;
                    if ((z && z3) || z2) {
                        if (z4) {
                            msgDO2.evokeAppStatus = z2 ? 2 : 3;
                        } else {
                            msgDO2.evokeAppStatus = 4;
                        }
                    }
                }
                msgDO2.msgIds = str;
                msgDO2.extData = str2;
                msgDO2.messageSource = "accs";
                msgDO2.msgStatus = "8";
                AgooFactory agooFactory = new AgooFactory();
                agooFactory.init(context, notifManager, null);
                agooFactory.updateMsgStatus(str, "8");
                notifManager.reportNotifyMessage(msgDO2);
            } catch (Throwable th) {
                th = th;
                msgDO = msgDO2;
                try {
                    ALog.e(TAG, "clickMessage,error=" + th, new Object[0]);
                } finally {
                    if (msgDO != null) {
                        notifManager.reportNotifyMessage(msgDO);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            msgDO = null;
        }
    }

    public static synchronized void register(Context context, String str, String str2, String str3, String str4, IRegister iRegister) throws AccsException {
        synchronized (TaobaoRegister.class) {
            if (context != null) {
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    if ((context.getApplicationInfo().flags & 2) != 0) {
                        ALog.isUseTlog = false;
                        anet.channel.util.ALog.i(false);
                    }
                    ALog.i(TAG, "register", "appKey", str2, Constants.KEY_CONFIG_TAG, str);
                    Context applicationContext = context.getApplicationContext();
                    Config.mAccsConfigTag = str;
                    Config.setAgooAppKey(context, str2);
                    AdapterUtilityImpl.mAgooAppSecret = str3;
                    if (!TextUtils.isEmpty(str3)) {
                        AdapterGlobalClientInfo.mSecurityType = 2;
                    }
                    AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
                    if (configByTag == null) {
                        new AccsClientConfig.Builder().setAppKey(str2).setAppSecret(str3).setTag(str).build();
                    } else {
                        AdapterGlobalClientInfo.mAuthCode = configByTag.getAuthCode();
                    }
                    IACCSManager accsInstance = ACCSManager.getAccsInstance(context, str2, str);
                    accsInstance.bindApp(applicationContext, str2, str3, str4, new C6250a(applicationContext, context, iRegister, str2, str4, accsInstance));
                    return;
                }
            }
            ALog.e(TAG, "register params null", "appkey", str2, Constants.KEY_CONFIG_TAG, str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x007e, code lost:
        r10.onFailure(com.taobao.agoo.TaobaoConstants.ALIAS_ERROR, "input params null!!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void removeAlias(android.content.Context r9, com.taobao.agoo.ICallback r10) {
        /*
            java.lang.Class<com.taobao.agoo.TaobaoRegister> r0 = com.taobao.agoo.TaobaoRegister.class
            monitor-enter(r0)
            java.lang.String r1 = "TaobaoRegister"
            java.lang.String r2 = "removeAlias"
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> Lbd
            com.taobao.accs.utl.ALog.i(r1, r2, r4)     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r1 = org.android.agoo.common.Config.getDeviceToken(r9)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r2 = org.android.agoo.common.Config.getPushAliasToken(r9)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r4 = org.android.agoo.common.Config.getAgooAppKey(r9)     // Catch: java.lang.Throwable -> Lb1
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> Lb1
            if (r5 != 0) goto L7c
            boolean r5 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Lb1
            if (r5 != 0) goto L7c
            if (r9 == 0) goto L7c
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Lb1
            if (r5 == 0) goto L2e
            goto L7c
        L2e:
            java.lang.String r5 = org.android.agoo.common.Config.getAccsConfigTag(r9)     // Catch: java.lang.Throwable -> Lb1
            com.taobao.accs.IACCSManager r5 = com.taobao.accs.ACCSManager.getAccsInstance(r9, r4, r5)     // Catch: java.lang.Throwable -> Lb1
            tb.e22 r6 = com.taobao.agoo.TaobaoRegister.mRequestListener     // Catch: java.lang.Throwable -> Lb1
            if (r6 != 0) goto L45
            tb.e22 r6 = new tb.e22     // Catch: java.lang.Throwable -> Lb1
            android.content.Context r7 = r9.getApplicationContext()     // Catch: java.lang.Throwable -> Lb1
            r6.<init>(r7)     // Catch: java.lang.Throwable -> Lb1
            com.taobao.agoo.TaobaoRegister.mRequestListener = r6     // Catch: java.lang.Throwable -> Lb1
        L45:
            java.lang.String r6 = "AgooDeviceCmd"
            java.lang.String r6 = org.android.agoo.control.NotifManager.getServiceId(r9, r6)     // Catch: java.lang.Throwable -> Lb1
            com.taobao.accs.client.GlobalClientInfo r7 = com.taobao.accs.client.GlobalClientInfo.getInstance(r9)     // Catch: java.lang.Throwable -> Lb1
            tb.e22 r8 = com.taobao.agoo.TaobaoRegister.mRequestListener     // Catch: java.lang.Throwable -> Lb1
            r7.registerListener(r6, r8)     // Catch: java.lang.Throwable -> Lb1
            byte[] r1 = tb.u4.c(r4, r1, r2)     // Catch: java.lang.Throwable -> Lb1
            com.taobao.accs.ACCSManager$AccsRequest r2 = new com.taobao.accs.ACCSManager$AccsRequest     // Catch: java.lang.Throwable -> Lb1
            r4 = 0
            r2.<init>(r4, r6, r1, r4)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r9 = r5.sendRequest(r9, r2)     // Catch: java.lang.Throwable -> Lb1
            boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> Lb1
            if (r1 == 0) goto L72
            if (r10 == 0) goto Lbb
            java.lang.String r9 = "504.1"
            java.lang.String r1 = "accs channel disabled!"
            r10.onFailure(r9, r1)     // Catch: java.lang.Throwable -> Lb1
            goto Lbb
        L72:
            if (r10 == 0) goto Lbb
            tb.e22 r1 = com.taobao.agoo.TaobaoRegister.mRequestListener     // Catch: java.lang.Throwable -> Lb1
            java.util.Map<java.lang.String, com.taobao.agoo.ICallback> r1 = r1.a     // Catch: java.lang.Throwable -> Lb1
            r1.put(r9, r10)     // Catch: java.lang.Throwable -> Lb1
            goto Lbb
        L7c:
            if (r10 == 0) goto L85
            java.lang.String r5 = "504.1"
            java.lang.String r6 = "input params null!!"
            r10.onFailure(r5, r6)     // Catch: java.lang.Throwable -> Lb1
        L85:
            java.lang.String r10 = "TaobaoRegister"
            java.lang.String r5 = "removeAlias param null"
            r6 = 8
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r7 = "appkey"
            r6[r3] = r7     // Catch: java.lang.Throwable -> Lb1
            r7 = 1
            r6[r7] = r4     // Catch: java.lang.Throwable -> Lb1
            r4 = 2
            java.lang.String r7 = "deviceId"
            r6[r4] = r7     // Catch: java.lang.Throwable -> Lb1
            r4 = 3
            r6[r4] = r1     // Catch: java.lang.Throwable -> Lb1
            r1 = 4
            java.lang.String r4 = "pushAliasToken"
            r6[r1] = r4     // Catch: java.lang.Throwable -> Lb1
            r1 = 5
            r6[r1] = r2     // Catch: java.lang.Throwable -> Lb1
            r1 = 6
            java.lang.String r2 = "context"
            r6[r1] = r2     // Catch: java.lang.Throwable -> Lb1
            r1 = 7
            r6[r1] = r9     // Catch: java.lang.Throwable -> Lb1
            com.taobao.accs.utl.ALog.e(r10, r5, r6)     // Catch: java.lang.Throwable -> Lb1
            monitor-exit(r0)
            return
        Lb1:
            r9 = move-exception
            java.lang.String r10 = "TaobaoRegister"
            java.lang.String r1 = "removeAlias"
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> Lbd
            com.taobao.accs.utl.ALog.e(r10, r1, r9, r2)     // Catch: java.lang.Throwable -> Lbd
        Lbb:
            monitor-exit(r0)
            return
        Lbd:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.agoo.TaobaoRegister.removeAlias(android.content.Context, com.taobao.agoo.ICallback):void");
    }
}
