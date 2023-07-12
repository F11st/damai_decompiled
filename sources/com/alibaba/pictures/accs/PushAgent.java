package com.alibaba.pictures.accs;

import android.app.NotificationManager;
import android.content.Context;
import com.alibaba.security.biometrics.service.common.ABLogRecorderKeys;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.heytap.msp.push.HeytapPushManager;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.push.HmsMessaging;
import com.meizu.cloud.pushsdk.PushManager;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsException;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.agoo.ICallback;
import com.taobao.agoo.IRegister;
import com.taobao.agoo.TaobaoRegister;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;
import com.xiaomi.mipush.sdk.MiPushClient;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Objects;
import kotlin.jvm.JvmStatic;
import org.android.agoo.assist.AssistCallback;
import org.android.agoo.assist.AssistManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.f;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class PushAgent {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final PushAgent INSTANCE = new PushAgent();
    private static final String a = "AGOO." + PushAgent.class.getSimpleName();
    private static boolean b = true;
    private static int c;
    @Nullable
    private static IAccsServiceDelegate d;
    @Nullable
    private static IAgooServiceDelegate e;
    @Nullable
    private static INotifyActionHandler f;
    @Nullable
    private static IACCSConfigProvider g;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a implements AssistCallback {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.pictures.accs.PushAgent$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0148a implements ICallBackResultService {
            private static transient /* synthetic */ IpChange $ipChange;

            C0148a() {
            }

            @Override // com.heytap.msp.push.callback.ICallBackResultService
            public void onError(int i, @Nullable String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1884207078")) {
                    ipChange.ipc$dispatch("-1884207078", new Object[]{this, Integer.valueOf(i), str});
                    return;
                }
                String a = PushAgent.a(PushAgent.INSTANCE);
                ALog.i(a, "onError：" + i + "-mag=" + str, new Object[0]);
            }

            @Override // com.heytap.msp.push.callback.ICallBackResultService
            public void onGetNotificationStatus(int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1710889192")) {
                    ipChange.ipc$dispatch("1710889192", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                }
            }

            @Override // com.heytap.msp.push.callback.ICallBackResultService
            public void onGetPushStatus(int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2094104409")) {
                    ipChange.ipc$dispatch("2094104409", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                }
            }

            @Override // com.heytap.msp.push.callback.ICallBackResultService
            public void onRegister(int i, @NotNull String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "523516161")) {
                    ipChange.ipc$dispatch("523516161", new Object[]{this, Integer.valueOf(i), str});
                    return;
                }
                b41.i(str, "token");
                AssistManager.reportToken(str);
            }

            @Override // com.heytap.msp.push.callback.ICallBackResultService
            public void onSetPushTime(int i, @NotNull String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "902974299")) {
                    ipChange.ipc$dispatch("902974299", new Object[]{this, Integer.valueOf(i), str});
                } else {
                    b41.i(str, "s");
                }
            }

            @Override // com.heytap.msp.push.callback.ICallBackResultService
            public void onUnRegister(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "695022256")) {
                    ipChange.ipc$dispatch("695022256", new Object[]{this, Integer.valueOf(i)});
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes7.dex */
        public static final class b implements IPushActionListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ Context a;

            b(Context context) {
                this.a = context;
            }

            @Override // com.vivo.push.IPushActionListener
            public final void onStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-821572693")) {
                    ipChange.ipc$dispatch("-821572693", new Object[]{this, Integer.valueOf(i)});
                } else if (i == 0) {
                    PushClient pushClient = PushClient.getInstance(this.a);
                    b41.h(pushClient, "PushClient.getInstance(context)");
                    AssistManager.reportToken(pushClient.getRegId());
                }
            }
        }

        a() {
        }

        @Override // org.android.agoo.assist.AssistCallback
        public void onRegisterFlyme(@Nullable Context context, @Nullable String str, @Nullable String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1330915282")) {
                ipChange.ipc$dispatch("1330915282", new Object[]{this, context, str, str2});
            } else {
                PushManager.register(context, str, str2);
            }
        }

        @Override // org.android.agoo.assist.AssistCallback
        public void onRegisterHuawei(@Nullable Context context, @Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1044731300")) {
                ipChange.ipc$dispatch("1044731300", new Object[]{this, context, str});
                return;
            }
            PushAgent pushAgent = PushAgent.INSTANCE;
            ALog.d(PushAgent.a(pushAgent), "onRegisterHuawei: ---", new Object[0]);
            try {
                String token = HmsInstanceId.getInstance(context).getToken(str, HmsMessaging.DEFAULT_TOKEN_SCOPE);
                AssistManager.reportToken(token);
                String a = PushAgent.a(pushAgent);
                ALog.d(a, "onRegisterHuawei: ---" + token, new Object[0]);
            } catch (ApiException e) {
                e.printStackTrace();
                String a2 = PushAgent.a(PushAgent.INSTANCE);
                ALog.d(a2, "onRegisterHuawei: --- " + e.getMessage(), new Object[0]);
            }
        }

        @Override // org.android.agoo.assist.AssistCallback
        public void onRegisterOppo(@NotNull Context context, @Nullable String str, @Nullable String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "704175143")) {
                ipChange.ipc$dispatch("704175143", new Object[]{this, context, str, str2});
                return;
            }
            b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
            HeytapPushManager.init(context, (context.getApplicationInfo().flags & 2) != 0);
            HeytapPushManager.register(context, str, str2, new C0148a());
        }

        @Override // org.android.agoo.assist.AssistCallback
        public void onRegisterVivo(@Nullable Context context) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1329496161")) {
                ipChange.ipc$dispatch("-1329496161", new Object[]{this, context});
                return;
            }
            PushClient.getInstance(context).initialize();
            PushClient.getInstance(context).turnOnPush(new b(context));
        }

        @Override // org.android.agoo.assist.AssistCallback
        public void onRegisterXiaomi(@Nullable Context context, @Nullable String str, @Nullable String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1626762942")) {
                ipChange.ipc$dispatch("-1626762942", new Object[]{this, context, str, str2});
            } else {
                MiPushClient.registerPush(context, str, str2);
            }
        }
    }

    private PushAgent() {
    }

    public static final /* synthetic */ String a(PushAgent pushAgent) {
        return a;
    }

    @JvmStatic
    public static final void b(@NotNull Context context, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1341202008")) {
            ipChange.ipc$dispatch("-1341202008", new Object[]{context, str});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (str == null) {
            ALog.e(a, "error,bindAccsUser userId==null", new Object[0]);
            return;
        }
        try {
            ACCSClient.getAccsClient("default").bindUser(str);
        } catch (Exception e2) {
            String message = e2.getMessage();
            if (message == null) {
                message = "";
            }
            AppMonitorAdapter.commitAlarmFail("accs_agoo", "status", "", "10003", message);
        }
        try {
            TaobaoRegister.setAlias(context, str, new ICallback() { // from class: com.alibaba.pictures.accs.PushAgent$bindAccsUser$1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.taobao.agoo.ICallback
                public void onFailure(@Nullable String str2, @Nullable String str3) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2070386746")) {
                        ipChange2.ipc$dispatch("2070386746", new Object[]{this, str2, str3});
                        return;
                    }
                    ALog.d(PushAgent.a(PushAgent.INSTANCE), "onFailure: bindAccsUser", new Object[0]);
                    if (str2 == null) {
                        str2 = "";
                    }
                    AppMonitorAdapter.commitAlarmFail("accs_agoo", "status", "", ABLogRecorderKeys.EventIdEnterAdjust, str2);
                }

                @Override // com.taobao.agoo.ICallback
                public void onSuccess() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-549637875")) {
                        ipChange2.ipc$dispatch("-549637875", new Object[]{this});
                    } else {
                        ALog.d(PushAgent.a(PushAgent.INSTANCE), "onSuccess: bindAccsUser", new Object[0]);
                    }
                }
            });
        } catch (Exception e3) {
            String message2 = e3.getMessage();
            if (message2 == null) {
                message2 = "";
            }
            AppMonitorAdapter.commitAlarmFail("accs_agoo", "status", "", ABLogRecorderKeys.EventIdLeaveAdjust, message2);
        }
    }

    @JvmStatic
    public static final void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1051437602")) {
            ipChange.ipc$dispatch("1051437602", new Object[0]);
            return;
        }
        IACCSConfigProvider iACCSConfigProvider = g;
        if (iACCSConfigProvider == null) {
            INSTANCE.q();
            return;
        }
        ACCSClient.getAccsClient("default").bindApp(iACCSConfigProvider.getTTid(), new f(iACCSConfigProvider));
    }

    @JvmStatic
    public static final void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1207590046")) {
            ipChange.ipc$dispatch("-1207590046", new Object[0]);
            return;
        }
        try {
            IACCSConfigProvider iACCSConfigProvider = g;
            if (iACCSConfigProvider == null) {
                INSTANCE.q();
                return;
            }
            String appKey = iACCSConfigProvider.getAppKey();
            Context context = iACCSConfigProvider.getContext();
            ACCSManager.setAppkey(context, appKey, c);
            String inAppHost = iACCSConfigProvider.getInAppHost();
            String channelHost = iACCSConfigProvider.getChannelHost();
            ACCSClient.setEnvironment(context, c);
            if (iACCSConfigProvider.isDebuggable()) {
                ALog.setUseTlog(true);
            }
            AccsClientConfig.Builder builder = new AccsClientConfig.Builder();
            builder.setAppKey(appKey);
            builder.setTag("default");
            builder.setInappHost(inAppHost);
            builder.setChannelHost(channelHost);
            if (c == 2) {
                builder.setInappPubKey(0);
                builder.setChannelPubKey(0);
            } else {
                builder.setInappPubKey(10);
                builder.setChannelPubKey(10);
            }
            builder.setConfigEnv(c);
            ACCSClient.init(context, builder.build());
        } catch (AccsException e2) {
            e2.printStackTrace();
        }
    }

    @JvmStatic
    public static final void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-453912341")) {
            ipChange.ipc$dispatch("-453912341", new Object[0]);
            return;
        }
        IACCSConfigProvider iACCSConfigProvider = g;
        if (iACCSConfigProvider == null) {
            INSTANCE.q();
            return;
        }
        Context context = iACCSConfigProvider.getContext();
        try {
            TaobaoRegister.setAccsConfigTag(context, "default");
        } catch (Exception e2) {
            String str = a;
            ALog.e(str, "initAgooAccsChannel:error-" + e2.getMessage(), new Object[0]);
        }
        TaobaoRegister.setEnv(context, c);
        String agooMsgReceiveServiceName = iACCSConfigProvider.getAgooMsgReceiveServiceName();
        TaobaoRegister.setAgooMsgReceiveService(agooMsgReceiveServiceName == null || agooMsgReceiveServiceName.length() == 0 ? "com.alibaba.pictures.accs.TaobaoIntentService" : iACCSConfigProvider.getAgooMsgReceiveServiceName());
        TaobaoRegister.register(context, "default", iACCSConfigProvider.getAppKey(), null, iACCSConfigProvider.getTTid(), new IRegister() { // from class: com.alibaba.pictures.accs.PushAgent$initAgooAccsChannel$1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.agoo.IRegister, com.taobao.agoo.ICallback
            public void onFailure(@NotNull String str2, @NotNull String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "446257323")) {
                    ipChange2.ipc$dispatch("446257323", new Object[]{this, str2, str3});
                    return;
                }
                b41.i(str2, "errorCode");
                b41.i(str3, "errorMsg");
                ALog.i(PushAgent.a(PushAgent.INSTANCE), "onFailure", "errorcode", str2, "errormsg", str3);
            }

            @Override // com.taobao.agoo.IRegister
            public void onSuccess(@NotNull String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "219790408")) {
                    ipChange2.ipc$dispatch("219790408", new Object[]{this, str2});
                    return;
                }
                b41.i(str2, "deviceToken");
                ALog.i(PushAgent.a(PushAgent.INSTANCE), "onSuccess", "devicetoken", str2);
            }
        });
        String userId = iACCSConfigProvider.getUserId();
        if (userId != null) {
            TaobaoRegister.setAlias(context, userId, new ICallback() { // from class: com.alibaba.pictures.accs.PushAgent$initAgooAccsChannel$2$1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.taobao.agoo.ICallback
                public void onFailure(@Nullable String str2, @Nullable String str3) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-729203363")) {
                        ipChange2.ipc$dispatch("-729203363", new Object[]{this, str2, str3});
                        return;
                    }
                    String a2 = PushAgent.a(PushAgent.INSTANCE);
                    ALog.e(a2, "bindAlias fail, msg=" + str2 + ',' + str3, new Object[0]);
                }

                @Override // com.taobao.agoo.ICallback
                public void onSuccess() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1527239760")) {
                        ipChange2.ipc$dispatch("-1527239760", new Object[]{this});
                    } else {
                        ALog.d(PushAgent.a(PushAgent.INSTANCE), "bindAlias success", new Object[0]);
                    }
                }
            });
        } else {
            ALog.e(a, "bindAlias fail: userId null", new Object[0]);
        }
    }

    @JvmStatic
    public static final void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1090739628")) {
            ipChange.ipc$dispatch("1090739628", new Object[0]);
            return;
        }
        IACCSConfigProvider iACCSConfigProvider = g;
        if (iACCSConfigProvider == null) {
            INSTANCE.q();
        } else {
            AssistManager.init(iACCSConfigProvider.getContext(), new a());
        }
    }

    private final void q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1375350132")) {
            ipChange.ipc$dispatch("-1375350132", new Object[]{this});
            return;
        }
        ALog.e(a, "you need invoke PushAgent.setConfigProvider() first!", new Object[0]);
        AppMonitorAdapter.commitAlarmFail("accs_agoo", "status", "", "10000", "not init!");
    }

    @JvmStatic
    public static final void r(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-860941129")) {
            ipChange.ipc$dispatch("-860941129", new Object[]{context});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        try {
            ACCSClient.getAccsClient("default").unbindUser();
        } catch (Exception e2) {
            String message = e2.getMessage();
            if (message == null) {
                message = "";
            }
            AppMonitorAdapter.commitAlarmFail("accs_agoo", "status", "", ABLogRecorderKeys.EventIdEnterAct, message);
        }
        try {
            TaobaoRegister.removeAlias(context, new ICallback() { // from class: com.alibaba.pictures.accs.PushAgent$unbindAccsUser$1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.taobao.agoo.ICallback
                public void onFailure(@Nullable String str, @Nullable String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1204292353")) {
                        ipChange2.ipc$dispatch("1204292353", new Object[]{this, str, str2});
                        return;
                    }
                    ALog.d(PushAgent.a(PushAgent.INSTANCE), "onFailure: unbindAccsUser", new Object[0]);
                    if (str == null) {
                        str = "";
                    }
                    AppMonitorAdapter.commitAlarmFail("accs_agoo", "status", "", "10007", str);
                }

                @Override // com.taobao.agoo.ICallback
                public void onSuccess() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1873738580")) {
                        ipChange2.ipc$dispatch("1873738580", new Object[]{this});
                    } else {
                        ALog.d(PushAgent.a(PushAgent.INSTANCE), "onSuccess: unbindAccsUser", new Object[0]);
                    }
                }
            });
        } catch (Exception e3) {
            String message2 = e3.getMessage();
            if (message2 == null) {
                message2 = "";
            }
            AppMonitorAdapter.commitAlarmFail("accs_agoo", "status", "", "10008", message2);
        }
    }

    @Nullable
    public final IAccsServiceDelegate d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1826451152") ? (IAccsServiceDelegate) ipChange.ipc$dispatch("1826451152", new Object[]{this}) : d;
    }

    @Nullable
    public final IAgooServiceDelegate e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1379814064") ? (IAgooServiceDelegate) ipChange.ipc$dispatch("-1379814064", new Object[]{this}) : e;
    }

    @Nullable
    public final IACCSConfigProvider f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-21311452") ? (IACCSConfigProvider) ipChange.ipc$dispatch("-21311452", new Object[]{this}) : g;
    }

    @Nullable
    public final NotificationManager g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1140752405")) {
            return (NotificationManager) ipChange.ipc$dispatch("1140752405", new Object[]{this});
        }
        IACCSConfigProvider iACCSConfigProvider = g;
        if (iACCSConfigProvider == null) {
            q();
            return null;
        }
        Object systemService = iACCSConfigProvider.getContext().getSystemService("notification");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        return (NotificationManager) systemService;
    }

    @Nullable
    public final INotifyActionHandler h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-446859152") ? (INotifyActionHandler) ipChange.ipc$dispatch("-446859152", new Object[]{this}) : f;
    }

    public final boolean i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1368811416") ? ((Boolean) ipChange.ipc$dispatch("-1368811416", new Object[]{this})).booleanValue() : b;
    }

    public final void m(@Nullable IAccsServiceDelegate iAccsServiceDelegate) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-264303062")) {
            ipChange.ipc$dispatch("-264303062", new Object[]{this, iAccsServiceDelegate});
        } else {
            d = iAccsServiceDelegate;
        }
    }

    public final void n(@Nullable IAgooServiceDelegate iAgooServiceDelegate) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1928826130")) {
            ipChange.ipc$dispatch("1928826130", new Object[]{this, iAgooServiceDelegate});
        } else {
            e = iAgooServiceDelegate;
        }
    }

    public final void o(@Nullable IACCSConfigProvider iACCSConfigProvider) {
        IpChange ipChange = $ipChange;
        int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "1692526822")) {
            ipChange.ipc$dispatch("1692526822", new Object[]{this, iACCSConfigProvider});
            return;
        }
        if ((iACCSConfigProvider != null ? iACCSConfigProvider.getEnvMode() : null) == ACCSEnvMode.TEST) {
            i = 2;
        } else {
            if ((iACCSConfigProvider != null ? iACCSConfigProvider.getEnvMode() : null) != ACCSEnvMode.PRE) {
                i = 0;
            }
        }
        c = i;
        g = iACCSConfigProvider;
    }

    public final void p(@Nullable INotifyActionHandler iNotifyActionHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1715754340")) {
            ipChange.ipc$dispatch("1715754340", new Object[]{this, iNotifyActionHandler});
        } else {
            f = iNotifyActionHandler;
        }
    }
}
