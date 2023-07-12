package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.bridge.WXBridgeManager;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.manager.C7539a;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.AbstractC7689n;
import com.xiaomi.push.C7667h;
import com.xiaomi.push.C7672hn;
import com.xiaomi.push.C7676in;
import com.xiaomi.push.C7678ip;
import com.xiaomi.push.C7680j;
import com.xiaomi.push.C7688m;
import com.xiaomi.push.C7690o;
import com.xiaomi.push.C7784t;
import com.xiaomi.push.C7786v;
import com.xiaomi.push.Cdo;
import com.xiaomi.push.bp;
import com.xiaomi.push.dd;
import com.xiaomi.push.dn;
import com.xiaomi.push.el;
import com.xiaomi.push.em;
import com.xiaomi.push.en;
import com.xiaomi.push.ey;
import com.xiaomi.push.hj;
import com.xiaomi.push.ho;
import com.xiaomi.push.ht;
import com.xiaomi.push.hw;
import com.xiaomi.push.hx;
import com.xiaomi.push.id;
import com.xiaomi.push.ii;
import com.xiaomi.push.ij;
import com.xiaomi.push.ir;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.bd;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import io.flutter.wpkbridge.WPKFactory;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class MiPushClient {
    public static final String COMMAND_REGISTER = "register";
    public static final String COMMAND_SET_ACCEPT_TIME = "accept-time";
    public static final String COMMAND_SET_ACCOUNT = "set-account";
    public static final String COMMAND_SET_ALIAS = "set-alias";
    public static final String COMMAND_SUBSCRIBE_TOPIC = "subscribe-topic";
    public static final String COMMAND_UNREGISTER = "unregister";
    public static final String COMMAND_UNSET_ACCOUNT = "unset-account";
    public static final String COMMAND_UNSET_ALIAS = "unset-alias";
    public static final String COMMAND_UNSUBSCRIBE_TOPIC = "unsubscibe-topic";
    public static final String PREF_EXTRA = "mipush_extra";
    private static Context sContext;
    private static long sCurMsgId = System.currentTimeMillis();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class CodeResult {
        private long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        protected void setResultCode(long j) {
            this.resultCode = j;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface ICallbackResult<R> {
        void onResult(R r);
    }

    /* compiled from: Taobao */
    @Deprecated
    /* loaded from: classes11.dex */
    public static abstract class MiPushClientCallback {
        private String category;

        /* JADX INFO: Access modifiers changed from: protected */
        public String getCategory() {
            return this.category;
        }

        public void onCommandResult(String str, long j, String str2, List<String> list) {
        }

        public void onInitializeResult(long j, String str, String str2) {
        }

        public void onReceiveMessage(MiPushMessage miPushMessage) {
        }

        public void onReceiveMessage(String str, String str2, String str3, boolean z) {
        }

        public void onSubscribeResult(long j, String str, String str2) {
        }

        public void onUnsubscribeResult(long j, String str, String str2) {
        }

        protected void setCategory(String str) {
            this.category = str;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class TokenResult {
        private String token = null;
        private long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        public String getToken() {
            return this.token;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void setResultCode(long j) {
            this.resultCode = j;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void setToken(String str) {
            this.token = str;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface UPSRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface UPSTurnCallBack extends ICallbackResult<CodeResult> {
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface UPSUnRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    private static boolean acceptTimeSet(Context context, String str, String str2) {
        String acceptTime = getAcceptTime(context);
        return TextUtils.equals(acceptTime, str + "," + str2);
    }

    public static long accountSetTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        return sharedPreferences.getLong("account_" + str, -1L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void addAcceptTime(Context context, String str, String str2) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString(Constants.EXTRA_KEY_ACCEPT_TIME, str + "," + str2);
            C7784t.a(edit);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void addAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("account_" + str, System.currentTimeMillis()).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void addAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("alias_" + str, System.currentTimeMillis()).commit();
        }
    }

    private static void addPullNotificationTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_pull_notification", System.currentTimeMillis());
        C7784t.a(edit);
    }

    private static void addRegRequestTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_reg_request", System.currentTimeMillis());
        C7784t.a(edit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void addTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("topic_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static long aliasSetTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        return sharedPreferences.getLong("alias_" + str, -1L);
    }

    public static void awakeApps(final Context context, final String[] strArr) {
        com.xiaomi.push.al.a(context).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.4
            @Override // java.lang.Runnable
            public void run() {
                String[] strArr2;
                PackageInfo packageInfo;
                try {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str) && (packageInfo = context.getPackageManager().getPackageInfo(str, 4)) != null) {
                            MiPushClient.awakePushServiceByPackageInfo(context, packageInfo);
                        }
                    }
                } catch (Throwable th) {
                    AbstractC7535b.a(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void awakePushServiceByPackageInfo(Context context, PackageInfo packageInfo) {
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    try {
                        Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                        Intent intent = new Intent();
                        intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                        intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                        intent.putExtra("waker_pkgname", context.getPackageName());
                        PushMessageHandler.a(context, intent);
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
            }
        }
    }

    private static void checkNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new IllegalArgumentException("param " + str + " is not nullable");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void clearExtras(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.clear();
        edit.commit();
    }

    private static void clearExtrasForInitialize(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        Iterator<String> it = getAllAlias(context).iterator();
        while (it.hasNext()) {
            edit.remove("alias_" + it.next());
        }
        Iterator<String> it2 = getAllUserAccount(context).iterator();
        while (it2.hasNext()) {
            edit.remove("account_" + it2.next());
        }
        Iterator<String> it3 = getAllTopic(context).iterator();
        while (it3.hasNext()) {
            edit.remove("topic_" + it3.next());
        }
        edit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
        edit.commit();
    }

    public static void clearLocalNotificationType(Context context) {
        ao.a(context).f();
    }

    public static void clearNotification(Context context) {
        ao.a(context).a(-1);
    }

    public static void clearNotification(Context context, int i) {
        ao.a(context).a(i);
    }

    public static void clearNotification(Context context, String str, String str2) {
        ao.a(context).a(str, str2);
    }

    public static void disablePush(Context context) {
        ao.a(context).a(true);
    }

    public static void enablePush(Context context) {
        ao.a(context).a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String getAcceptTime(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getString(Constants.EXTRA_KEY_ACCEPT_TIME, "00:00-23:59");
    }

    public static List<String> getAllAlias(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("alias_")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllTopic(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("topic_") && !str.contains("**ALL**")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllUserAccount(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("account_")) {
                arrayList.add(str.substring(8));
            }
        }
        return arrayList;
    }

    public static String getAppRegion(Context context) {
        if (C7564b.m629a(context).m638c()) {
            return C7564b.m629a(context).f();
        }
        return null;
    }

    private static boolean getDefaultSwitch() {
        return C7688m.m1122b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getOpenFCMPush(Context context) {
        checkNotNull(context, WPKFactory.INIT_KEY_CONTEXT);
        return C7569f.a(context).b(EnumC7568e.ASSEMBLE_PUSH_FCM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getOpenHmsPush(Context context) {
        checkNotNull(context, WPKFactory.INIT_KEY_CONTEXT);
        return C7569f.a(context).b(EnumC7568e.ASSEMBLE_PUSH_HUAWEI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getOpenOPPOPush(Context context) {
        checkNotNull(context, WPKFactory.INIT_KEY_CONTEXT);
        return C7569f.a(context).b(EnumC7568e.ASSEMBLE_PUSH_COS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getOpenVIVOPush(Context context) {
        return C7569f.a(context).b(EnumC7568e.ASSEMBLE_PUSH_FTOS);
    }

    public static String getRegId(Context context) {
        if (C7564b.m629a(context).m638c()) {
            return C7564b.m629a(context).m637c();
        }
        return null;
    }

    private static void initEventPerfLogic(final Context context) {
        en.a(new en.InterfaceC7647a() { // from class: com.xiaomi.mipush.sdk.MiPushClient.5
            @Override // com.xiaomi.push.en.InterfaceC7647a
            public void uploader(Context context2, C7672hn c7672hn) {
                MiTinyDataClient.upload(context2, c7672hn);
            }
        });
        Config a = en.a(context);
        C7539a.a(context).a("4_9_1");
        ClientReportClient.init(context, a, new el(context), new em(context));
        C7558a.a(context);
        C7584t.a(context, a);
        ba.a(context).a(new ba.AbstractRunnableC7734a(100, "perf event job update") { // from class: com.xiaomi.mipush.sdk.MiPushClient.6
            @Override // com.xiaomi.push.service.ba.AbstractRunnableC7734a
            protected void onCallback() {
                en.m859a(context);
            }
        });
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback) {
        initialize(context, str, str2, miPushClientCallback, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback, String str3, ICallbackResult iCallbackResult) {
        try {
            AbstractC7535b.a(context.getApplicationContext());
            AbstractC7535b.e("sdk_version = 4_9_1");
            com.xiaomi.push.ba.a(context).a();
            dd.a(context);
            if (miPushClientCallback != null) {
                PushMessageHandler.a(miPushClientCallback);
            }
            if (iCallbackResult != null) {
                PushMessageHandler.a(iCallbackResult);
            }
            if (C7786v.m1248a(sContext)) {
                C7586v.a(sContext);
            }
            boolean z = C7564b.m629a(sContext).a() != Constants.a();
            if (!z && !shouldSendRegRequest(sContext)) {
                ao.a(sContext).m620a();
                AbstractC7535b.m586a("Could not send  register message within 5s repeatly .");
                return;
            }
            if (z || !C7564b.m629a(sContext).a(str, str2) || C7564b.m629a(sContext).m641f()) {
                String a = bp.a(6);
                C7564b.m629a(sContext).m631a();
                C7564b.m629a(sContext).a(Constants.a());
                C7564b.m629a(sContext).a(str, str2, a);
                MiTinyDataClient.C7555a.a().b(MiTinyDataClient.PENDING_REASON_APPID);
                clearExtras(sContext);
                clearNotification(context);
                ij ijVar = new ij();
                ijVar.a(bd.b());
                ijVar.b(str);
                ijVar.e(str2);
                ijVar.d(sContext.getPackageName());
                ijVar.f(a);
                Context context2 = sContext;
                ijVar.c(C7667h.m941a(context2, context2.getPackageName()));
                Context context3 = sContext;
                ijVar.b(C7667h.a(context3, context3.getPackageName()));
                ijVar.h("4_9_1");
                ijVar.a(40091);
                ijVar.a(hx.Init);
                if (!TextUtils.isEmpty(str3)) {
                    ijVar.g(str3);
                }
                if (!C7688m.m1124d()) {
                    String e = C7680j.e(sContext);
                    if (!TextUtils.isEmpty(e)) {
                        ijVar.i(bp.a(e) + "," + C7680j.h(sContext));
                    }
                }
                int a2 = C7680j.a();
                if (a2 >= 0) {
                    ijVar.c(a2);
                }
                ao.a(sContext).a(ijVar, z);
                sContext.getSharedPreferences("mipush_extra", 4).getBoolean("mipush_registed", true);
            } else {
                if (1 == PushMessageHelper.getPushMode(sContext)) {
                    checkNotNull(miPushClientCallback, WXBridgeManager.METHOD_CALLBACK);
                    miPushClientCallback.onInitializeResult(0L, null, C7564b.m629a(sContext).m637c());
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(C7564b.m629a(sContext).m637c());
                    PushMessageHelper.sendCommandMessageBroadcast(sContext, PushMessageHelper.generateCommandMessage(ey.COMMAND_REGISTER.f325a, arrayList, 0L, null, null, null));
                }
                ao.a(sContext).m620a();
                if (C7564b.m629a(sContext).m633a()) {
                    ii iiVar = new ii();
                    iiVar.b(C7564b.m629a(sContext).m630a());
                    iiVar.c(ht.ClientInfoUpdate.f497a);
                    iiVar.a(bd.a());
                    HashMap hashMap = new HashMap();
                    iiVar.f636a = hashMap;
                    Context context4 = sContext;
                    hashMap.put("app_version", C7667h.m941a(context4, context4.getPackageName()));
                    Map<String, String> map = iiVar.f636a;
                    Context context5 = sContext;
                    map.put(Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(C7667h.a(context5, context5.getPackageName())));
                    iiVar.f636a.put("push_sdk_vn", "4_9_1");
                    iiVar.f636a.put("push_sdk_vc", Integer.toString(40091));
                    String e2 = C7564b.m629a(sContext).e();
                    if (!TextUtils.isEmpty(e2)) {
                        iiVar.f636a.put("deviceid", e2);
                    }
                    ao.a(sContext).a((ao) iiVar, hj.Notification, false, (hw) null);
                }
                if (!AbstractC7689n.m1126a(sContext, "update_devId", false)) {
                    updateImeiOrOaid();
                    AbstractC7689n.a(sContext, "update_devId", true);
                }
                if (shouldUseMIUIPush(sContext) && shouldPullNotification(sContext)) {
                    ii iiVar2 = new ii();
                    iiVar2.b(C7564b.m629a(sContext).m630a());
                    iiVar2.c(ht.PullOfflineMessage.f497a);
                    iiVar2.a(bd.a());
                    iiVar2.a(false);
                    ao.a(sContext).a((ao) iiVar2, hj.Notification, false, (hw) null, false);
                    addPullNotificationTime(sContext);
                }
            }
            addRegRequestTime(sContext);
            scheduleOcVersionCheckJob();
            scheduleDataCollectionJobs(sContext);
            initEventPerfLogic(sContext);
            av.a(sContext);
            if (!sContext.getPackageName().equals("com.xiaomi.xmsf")) {
                if (Logger.getUserLogger() != null) {
                    Logger.setLogger(sContext, Logger.getUserLogger());
                }
                AbstractC7535b.a(2);
            }
            operateSyncAction(context);
        } catch (Throwable th) {
            AbstractC7535b.a(th);
        }
    }

    private static void operateSyncAction(Context context) {
        if ("syncing".equals(af.a(sContext).a(au.DISABLE_PUSH))) {
            disablePush(sContext);
        }
        if ("syncing".equals(af.a(sContext).a(au.ENABLE_PUSH))) {
            enablePush(sContext);
        }
        if ("syncing".equals(af.a(sContext).a(au.UPLOAD_HUAWEI_TOKEN))) {
            syncAssemblePushToken(sContext);
        }
        if ("syncing".equals(af.a(sContext).a(au.UPLOAD_FCM_TOKEN))) {
            syncAssembleFCMPushToken(sContext);
        }
        if ("syncing".equals(af.a(sContext).a(au.UPLOAD_COS_TOKEN))) {
            syncAssembleCOSPushToken(context);
        }
        if ("syncing".equals(af.a(sContext).a(au.UPLOAD_FTOS_TOKEN))) {
            syncAssembleFTOSPushToken(context);
        }
    }

    public static void pausePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 0, 0, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reInitialize(Context context, hx hxVar) {
        AbstractC7535b.e("re-register reason: " + hxVar);
        String a = bp.a(6);
        String m630a = C7564b.m629a(context).m630a();
        String b = C7564b.m629a(context).b();
        C7564b.m629a(context).m631a();
        clearExtrasForInitialize(context);
        clearNotification(context);
        C7564b.m629a(context).a(Constants.a());
        C7564b.m629a(context).a(m630a, b, a);
        ij ijVar = new ij();
        ijVar.a(bd.b());
        ijVar.b(m630a);
        ijVar.e(b);
        ijVar.f(a);
        ijVar.d(context.getPackageName());
        ijVar.c(C7667h.m941a(context, context.getPackageName()));
        ijVar.b(C7667h.a(context, context.getPackageName()));
        ijVar.h("4_9_1");
        ijVar.a(40091);
        ijVar.a(hxVar);
        int a2 = C7680j.a();
        if (a2 >= 0) {
            ijVar.c(a2);
        }
        ao.a(context).a(ijVar, false);
    }

    @Deprecated
    public static void registerCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
    }

    private static void registerNetworkReceiver(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
            intentFilter.addCategory("android.intent.category.DEFAULT");
            C7690o.a(context.getApplicationContext(), new NetworkStatusReceiver(null), intentFilter);
            C7690o.a(context, NetworkStatusReceiver.class);
        } catch (Throwable th) {
            AbstractC7535b.m586a("dynamic register network status receiver failed:" + th);
        }
    }

    public static void registerPush(Context context, String str, String str2) {
        registerPush(context, str, str2, new PushConfiguration());
    }

    public static void registerPush(Context context, String str, String str2, PushConfiguration pushConfiguration) {
        registerPush(context, str, str2, pushConfiguration, null, null);
    }

    private static void registerPush(Context context, final String str, final String str2, PushConfiguration pushConfiguration, final String str3, final ICallbackResult iCallbackResult) {
        checkNotNull(context, WPKFactory.INIT_KEY_CONTEXT);
        checkNotNull(str, "appID");
        checkNotNull(str2, "appToken");
        Context applicationContext = context.getApplicationContext();
        sContext = applicationContext;
        if (applicationContext == null) {
            sContext = context;
        }
        Context context2 = sContext;
        C7786v.a(context2);
        if (!NetworkStatusReceiver.a()) {
            registerNetworkReceiver(sContext);
        }
        C7569f.a(sContext).a(pushConfiguration);
        com.xiaomi.push.al.a(context2).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.1
            @Override // java.lang.Runnable
            public void run() {
                MiPushClient.initialize(MiPushClient.sContext, str, str2, null, str3, iCallbackResult);
            }
        });
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        registerPush(context, str, str2, new PushConfiguration(), str3, null);
    }

    public static void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallBack uPSRegisterCallBack) {
        registerPush(context, str, str2, new PushConfiguration(), null, uPSRegisterCallBack);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeAcceptTime(Context context) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
            C7784t.a(edit);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("account_" + str).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("alias_" + str).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeAllAccounts(Context context) {
        synchronized (MiPushClient.class) {
            for (String str : getAllUserAccount(context)) {
                removeAccount(context, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeAllAliases(Context context) {
        synchronized (MiPushClient.class) {
            for (String str : getAllAlias(context)) {
                removeAlias(context, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeAllTopics(Context context) {
        synchronized (MiPushClient.class) {
            for (String str : getAllTopic(context)) {
                removeTopic(context, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("topic_" + str).commit();
        }
    }

    public static void removeWindow(Context context) {
        ao.a(context).m628e();
    }

    public static void reportAppRunInBackground(Context context, boolean z) {
        if (C7564b.m629a(context).m636b()) {
            ht htVar = z ? ht.APP_SLEEP : ht.APP_WAKEUP;
            ii iiVar = new ii();
            iiVar.b(C7564b.m629a(context).m630a());
            iiVar.c(htVar.f497a);
            iiVar.d(context.getPackageName());
            iiVar.a(bd.a());
            iiVar.a(false);
            ao.a(context).a((ao) iiVar, hj.Notification, false, (hw) null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportIgnoreRegMessageClicked(Context context, String str, hw hwVar, String str2, String str3) {
        ii iiVar = new ii();
        if (TextUtils.isEmpty(str3)) {
            AbstractC7535b.d("do not report clicked message");
            return;
        }
        iiVar.b(str3);
        iiVar.c("bar:click");
        iiVar.a(str);
        iiVar.a(false);
        ao.a(context).a(iiVar, hj.Notification, false, true, hwVar, true, str2, str3);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        hw hwVar = new hw();
        hwVar.a(miPushMessage.getMessageId());
        hwVar.b(miPushMessage.getTopic());
        hwVar.d(miPushMessage.getDescription());
        hwVar.c(miPushMessage.getTitle());
        hwVar.c(miPushMessage.getNotifyId());
        hwVar.a(miPushMessage.getNotifyType());
        hwVar.b(miPushMessage.getPassThrough());
        hwVar.a(miPushMessage.getExtra());
        reportMessageClicked(context, miPushMessage.getMessageId(), hwVar, null);
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        reportMessageClicked(context, str, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportMessageClicked(Context context, String str, hw hwVar, String str2) {
        ii iiVar = new ii();
        if (TextUtils.isEmpty(str2)) {
            if (!C7564b.m629a(context).m636b()) {
                AbstractC7535b.d("do not report clicked message");
                return;
            }
            str2 = C7564b.m629a(context).m630a();
        }
        iiVar.b(str2);
        iiVar.c("bar:click");
        iiVar.a(str);
        iiVar.a(false);
        ao.a(context).a((ao) iiVar, hj.Notification, false, hwVar);
    }

    public static void resumePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 23, 59, str);
    }

    private static void scheduleDataCollectionJobs(Context context) {
        if (ba.a(sContext).a(ho.DataCollectionSwitch.a(), getDefaultSwitch())) {
            dn.a().a(new C7582r(context));
            com.xiaomi.push.al.a(sContext).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.2
                @Override // java.lang.Runnable
                public void run() {
                    Cdo.a(MiPushClient.sContext);
                }
            }, 10);
        }
    }

    private static void scheduleOcVersionCheckJob() {
        com.xiaomi.push.al.a(sContext).a(new C7561ae(sContext), ba.a(sContext).a(ho.OcVersionCheckFrequency.a(), 86400), 5);
    }

    public static void setAcceptTime(Context context, int i, int i2, int i3, int i4, String str) {
        if (i < 0 || i >= 24 || i3 < 0 || i3 >= 24 || i2 < 0 || i2 >= 60 || i4 < 0 || i4 >= 60) {
            throw new IllegalArgumentException("the input parameter is not valid.");
        }
        long rawOffset = ((TimeZone.getTimeZone("GMT+08").getRawOffset() - TimeZone.getDefault().getRawOffset()) / 1000) / 60;
        long j = ((((i * 60) + i2) + rawOffset) + 1440) % 1440;
        long j2 = ((((i3 * 60) + i4) + rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j / 60), Long.valueOf(j % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i), Integer.valueOf(i2)));
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i3), Integer.valueOf(i4)));
        if (!acceptTimeSet(context, (String) arrayList.get(0), (String) arrayList.get(1))) {
            setCommand(context, ey.COMMAND_SET_ACCEPT_TIME.f325a, arrayList, str);
        } else if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.a(context, str, ey.COMMAND_SET_ACCEPT_TIME.f325a, 0L, null, arrayList2);
        } else {
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ey.COMMAND_SET_ACCEPT_TIME.f325a, arrayList2, 0L, null, null, null));
        }
    }

    public static void setAlias(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, ey.COMMAND_SET_ALIAS.f325a, str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
        if (1 == com.xiaomi.mipush.sdk.PushMessageHelper.getPushMode(r12)) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0033, code lost:
        com.xiaomi.mipush.sdk.PushMessageHandler.a(r12, r15, r13, 0, null, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003e, code lost:
        com.xiaomi.mipush.sdk.PushMessageHelper.sendCommandMessageBroadcast(r12, com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(r0.f325a, r6, 0, null, r15, null));
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a9, code lost:
        if (1 == com.xiaomi.mipush.sdk.PushMessageHelper.getPushMode(r12)) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected static void setCommand(android.content.Context r12, java.lang.String r13, java.lang.String r14, java.lang.String r15) {
        /*
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            boolean r0 = android.text.TextUtils.isEmpty(r14)
            if (r0 != 0) goto Le
            r6.add(r14)
        Le:
            com.xiaomi.push.ey r0 = com.xiaomi.push.ey.COMMAND_SET_ALIAS
            java.lang.String r1 = r0.f325a
            boolean r1 = r1.equalsIgnoreCase(r13)
            r2 = 1
            if (r1 == 0) goto L50
            long r3 = java.lang.System.currentTimeMillis()
            long r7 = aliasSetTime(r12, r14)
            long r3 = r3 - r7
            long r3 = java.lang.Math.abs(r3)
            r7 = 86400000(0x5265c00, double:4.2687272E-316)
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 >= 0) goto L50
            int r14 = com.xiaomi.mipush.sdk.PushMessageHelper.getPushMode(r12)
            if (r2 != r14) goto L3e
        L33:
            r3 = 0
            r5 = 0
            r0 = r12
            r1 = r15
            r2 = r13
            com.xiaomi.mipush.sdk.PushMessageHandler.a(r0, r1, r2, r3, r5, r6)
            goto Lc9
        L3e:
            java.lang.String r0 = r0.f325a
            r2 = 0
            r4 = 0
            r13 = 0
            r1 = r6
            r5 = r15
            r6 = r13
            com.xiaomi.mipush.sdk.MiPushCommandMessage r13 = com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(r0, r1, r2, r4, r5, r6)
            com.xiaomi.mipush.sdk.PushMessageHelper.sendCommandMessageBroadcast(r12, r13)
            goto Lc9
        L50:
            com.xiaomi.push.ey r0 = com.xiaomi.push.ey.COMMAND_UNSET_ALIAS
            java.lang.String r0 = r0.f325a
            boolean r0 = r0.equalsIgnoreCase(r13)
            java.lang.String r1 = " is unseted"
            r3 = 3
            r4 = 0
            if (r0 == 0) goto L87
            long r7 = aliasSetTime(r12, r14)
            int r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r0 >= 0) goto L87
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Don't cancel alias for "
        L6e:
            r12.append(r13)
            java.lang.String r13 = r6.toString()
            java.lang.String r13 = com.xiaomi.push.bp.a(r13, r3)
            r12.append(r13)
            r12.append(r1)
            java.lang.String r12 = r12.toString()
            com.xiaomi.channel.commonutils.logger.AbstractC7535b.m586a(r12)
            goto Lc9
        L87:
            com.xiaomi.push.ey r0 = com.xiaomi.push.ey.COMMAND_SET_ACCOUNT
            java.lang.String r7 = r0.f325a
            boolean r7 = r7.equalsIgnoreCase(r13)
            if (r7 == 0) goto Lac
            long r7 = java.lang.System.currentTimeMillis()
            long r9 = accountSetTime(r12, r14)
            long r7 = r7 - r9
            long r7 = java.lang.Math.abs(r7)
            r9 = 3600000(0x36ee80, double:1.7786363E-317)
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 >= 0) goto Lac
            int r14 = com.xiaomi.mipush.sdk.PushMessageHelper.getPushMode(r12)
            if (r2 != r14) goto L3e
            goto L33
        Lac:
            com.xiaomi.push.ey r0 = com.xiaomi.push.ey.COMMAND_UNSET_ACCOUNT
            java.lang.String r0 = r0.f325a
            boolean r0 = r0.equalsIgnoreCase(r13)
            if (r0 == 0) goto Lc6
            long r7 = accountSetTime(r12, r14)
            int r14 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r14 >= 0) goto Lc6
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Don't cancel account for "
            goto L6e
        Lc6:
            setCommand(r12, r13, r6, r15)
        Lc9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MiPushClient.setCommand(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void");
    }

    protected static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (TextUtils.isEmpty(C7564b.m629a(context).m630a())) {
            return;
        }
        id idVar = new id();
        String a = bd.a();
        idVar.a(a);
        idVar.b(C7564b.m629a(context).m630a());
        idVar.c(str);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            idVar.m1013a(it.next());
        }
        idVar.e(str2);
        idVar.d(context.getPackageName());
        AbstractC7535b.e("cmd:" + str + AVFSCacheConstants.COMMA_SEP + a);
        ao.a(context).a((ao) idVar, hj.Command, (hw) null);
    }

    public static void setLocalNotificationType(Context context, int i) {
        ao.a(context).b(i & (-1));
    }

    public static void setUserAccount(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, ey.COMMAND_SET_ACCOUNT.f325a, str, str2);
    }

    private static boolean shouldPullNotification(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1L)) > 300000;
    }

    private static boolean shouldSendRegRequest(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1L)) > DanmakuFactory.DEFAULT_DANMAKU_DURATION_V;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return ao.a(context).m622a();
    }

    public static void subscribe(Context context, String str, String str2) {
        if (TextUtils.isEmpty(C7564b.m629a(context).m630a()) || TextUtils.isEmpty(str)) {
            return;
        }
        if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) <= 86400000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str2, 0L, null, str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ey.COMMAND_SUBSCRIBE_TOPIC.f325a, arrayList, 0L, null, null, null));
            return;
        }
        C7676in c7676in = new C7676in();
        String a = bd.a();
        c7676in.a(a);
        c7676in.b(C7564b.m629a(context).m630a());
        c7676in.c(str);
        c7676in.d(context.getPackageName());
        c7676in.e(str2);
        AbstractC7535b.e("cmd:" + ey.COMMAND_SUBSCRIBE_TOPIC + AVFSCacheConstants.COMMA_SEP + a);
        ao.a(context).a((ao) c7676in, hj.Subscription, (hw) null);
    }

    public static void syncAssembleCOSPushToken(Context context) {
        ao.a(context).a((String) null, au.UPLOAD_COS_TOKEN, EnumC7568e.ASSEMBLE_PUSH_COS);
    }

    public static void syncAssembleFCMPushToken(Context context) {
        ao.a(context).a((String) null, au.UPLOAD_FCM_TOKEN, EnumC7568e.ASSEMBLE_PUSH_FCM);
    }

    public static void syncAssembleFTOSPushToken(Context context) {
        ao.a(context).a((String) null, au.UPLOAD_FTOS_TOKEN, EnumC7568e.ASSEMBLE_PUSH_FTOS);
    }

    public static void syncAssemblePushToken(Context context) {
        ao.a(context).a((String) null, au.UPLOAD_HUAWEI_TOKEN, EnumC7568e.ASSEMBLE_PUSH_HUAWEI);
    }

    public static long topicSubscribedTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        return sharedPreferences.getLong("topic_" + str, -1L);
    }

    public static void turnOffPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        disablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0L);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void turnOnPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        enablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0L);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void unRegisterToken(Context context, UPSUnRegisterCallBack uPSUnRegisterCallBack) {
        unregisterPush(context);
        if (uPSUnRegisterCallBack != null) {
            TokenResult tokenResult = new TokenResult();
            tokenResult.setToken(null);
            tokenResult.getToken();
            tokenResult.setResultCode(0L);
            tokenResult.getResultCode();
            uPSUnRegisterCallBack.onResult(tokenResult);
        }
    }

    public static void unregisterPush(Context context) {
        C7572i.c(context);
        ba.a(context).a();
        if (C7564b.m629a(context).m636b()) {
            C7678ip c7678ip = new C7678ip();
            c7678ip.a(bd.a());
            c7678ip.b(C7564b.m629a(context).m630a());
            c7678ip.c(C7564b.m629a(context).m637c());
            c7678ip.e(C7564b.m629a(context).b());
            c7678ip.d(context.getPackageName());
            ao.a(context).a(c7678ip);
            PushMessageHandler.a();
            PushMessageHandler.b();
            C7564b.m629a(context).m635b();
            clearLocalNotificationType(context);
            clearNotification(context);
            clearExtras(context);
        }
    }

    public static void unsetAlias(Context context, String str, String str2) {
        setCommand(context, ey.COMMAND_UNSET_ALIAS.f325a, str, str2);
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        setCommand(context, ey.COMMAND_UNSET_ACCOUNT.f325a, str, str2);
    }

    public static void unsubscribe(Context context, String str, String str2) {
        if (C7564b.m629a(context).m636b()) {
            if (topicSubscribedTime(context, str) < 0) {
                AbstractC7535b.m586a("Don't cancel subscribe for " + str + " is unsubscribed");
                return;
            }
            ir irVar = new ir();
            String a = bd.a();
            irVar.a(a);
            irVar.b(C7564b.m629a(context).m630a());
            irVar.c(str);
            irVar.d(context.getPackageName());
            irVar.e(str2);
            AbstractC7535b.e("cmd:" + ey.COMMAND_UNSUBSCRIBE_TOPIC + AVFSCacheConstants.COMMA_SEP + a);
            ao.a(context).a((ao) irVar, hj.UnSubscription, (hw) null);
        }
    }

    private static void updateImeiOrOaid() {
        new Thread(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.3
            @Override // java.lang.Runnable
            public void run() {
                String d;
                if (C7688m.m1124d()) {
                    return;
                }
                if (C7680j.d(MiPushClient.sContext) != null || com.xiaomi.push.ba.a(MiPushClient.sContext).mo671a()) {
                    ii iiVar = new ii();
                    iiVar.b(C7564b.m629a(MiPushClient.sContext).m630a());
                    iiVar.c(ht.ClientInfoUpdate.f497a);
                    iiVar.a(bd.a());
                    iiVar.a(new HashMap());
                    String str = "";
                    if (!TextUtils.isEmpty(C7680j.d(MiPushClient.sContext))) {
                        str = "" + bp.a(d);
                    }
                    String f = C7680j.f(MiPushClient.sContext);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(f)) {
                        str = str + "," + f;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        iiVar.m1038a().put(Constants.EXTRA_KEY_IMEI_MD5, str);
                    }
                    com.xiaomi.push.ba.a(MiPushClient.sContext).a(iiVar.m1038a());
                    int a = C7680j.a();
                    if (a >= 0) {
                        iiVar.m1038a().put("space_id", Integer.toString(a));
                    }
                    ao.a(MiPushClient.sContext).a((ao) iiVar, hj.Notification, false, (hw) null);
                }
            }
        }).start();
    }
}
