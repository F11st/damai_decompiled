package com.taobao.accs.init;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsException;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.ILoginInfo;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.connection.ConnectionServiceManager;
import com.taobao.accs.dispatch.IntentDispatch;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.ForeBackManager;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.agoo.ICallback;
import com.taobao.agoo.TaobaoConstants;
import com.taobao.agoo.TaobaoRegister;
import com.taobao.analysis.v3.Tracer;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.intf.IReflect;
import com.taobao.mass.ServiceKey;
import com.uc.webview.export.extension.UCCore;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.control.NotifManager;
import tb.C9708t9;
import tb.e22;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class Launcher_InitAccs implements Serializable {
    public static final Map<String, String> SERVICES;
    private static final String TAG = "Launcher_InitAccs";
    public static String defaultAppkey = "21646297";
    private static Class<?> keepAliveClazz;
    public static IAppReceiver mAppReceiver;
    public static String mAppkey;
    public static Context mContext;
    public static boolean mForceBindUser;
    public static boolean mIsInited;
    private static e22 mRequestListener;
    public static String mSid;
    public static String mTtid;
    public static String mUserId;
    private static Class<?> restrictionClazz;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    static class AccsLoginInfo implements ILoginInfo {
        AccsLoginInfo() {
        }

        @Override // com.taobao.accs.ILoginInfo
        public boolean getCommentUsed() {
            return false;
        }

        @Override // com.taobao.accs.ILoginInfo
        public String getEcode() {
            return null;
        }

        @Override // com.taobao.accs.ILoginInfo
        public String getHeadPicLink() {
            return null;
        }

        @Override // com.taobao.accs.ILoginInfo
        public String getNick() {
            return null;
        }

        @Override // com.taobao.accs.ILoginInfo
        public String getSid() {
            return Launcher_InitAccs.mSid;
        }

        @Override // com.taobao.accs.ILoginInfo
        public String getSsoToken() {
            return null;
        }

        @Override // com.taobao.accs.ILoginInfo
        public String getUserId() {
            return Launcher_InitAccs.mUserId;
        }
    }

    static {
        try {
            keepAliveClazz = Class.forName("com.taobao.keepalive.KeepAliveManager");
            restrictionClazz = Class.forName("com.taobao.keepalive.reflect.Restriction");
        } catch (Exception e) {
            e.printStackTrace();
        }
        mAppReceiver = new IAppReceiver() { // from class: com.taobao.accs.init.Launcher_InitAccs.5
            @Override // com.taobao.accs.IAppReceiver
            public Map<String, String> getAllServices() {
                return Launcher_InitAccs.SERVICES;
            }

            @Override // com.taobao.accs.IAppReceiver
            public String getService(String str) {
                return Launcher_InitAccs.SERVICES.get(str);
            }

            @Override // com.taobao.accs.IAppReceiver
            public void onBindApp(int i) {
                ALog.Level level = ALog.Level.D;
                if (ALog.isPrintLog(level)) {
                    ALog.d(Launcher_InitAccs.TAG, "onBindApp,  errorCode:" + i, new Object[0]);
                }
                if (i == 200) {
                    if (UtilityImpl.isMainProcess(Launcher_InitAccs.mContext)) {
                        if (Launcher_InitAccs.mRequestListener == null) {
                            e22 unused = Launcher_InitAccs.mRequestListener = new e22(Launcher_InitAccs.mContext);
                        }
                        GlobalClientInfo.getInstance(Launcher_InitAccs.mContext).registerListener(NotifManager.getServiceId(Launcher_InitAccs.mContext, TaobaoConstants.SERVICE_ID_DEVICECMD), Launcher_InitAccs.mRequestListener);
                    }
                    if (!TextUtils.isEmpty(Launcher_InitAccs.mUserId)) {
                        try {
                            ACCSClient.getAccsClient().bindUser(Launcher_InitAccs.mUserId, Launcher_InitAccs.mForceBindUser);
                            if (OrangeAdapter.isRegIdSwitchEnable(Launcher_InitAccs.mContext)) {
                                TaobaoRegister.setAlias(Launcher_InitAccs.mContext, Launcher_InitAccs.mUserId, new ICallback() { // from class: com.taobao.accs.init.Launcher_InitAccs.5.1
                                    @Override // com.taobao.agoo.ICallback
                                    public void onFailure(String str, String str2) {
                                        if (ALog.isPrintLog(ALog.Level.D)) {
                                            ALog.d(Launcher_InitAccs.TAG, "setAlias fail, errDesc:" + str2 + " errorCode:" + str, new Object[0]);
                                        }
                                    }

                                    @Override // com.taobao.agoo.ICallback
                                    public void onSuccess() {
                                        if (ALog.isPrintLog(ALog.Level.D)) {
                                            ALog.d(Launcher_InitAccs.TAG, "setAlias success", new Object[0]);
                                        }
                                    }
                                });
                            }
                        } catch (AccsException e2) {
                            ALog.e(Launcher_InitAccs.TAG, "bindUser", e2, new Object[0]);
                        }
                        Launcher_InitAccs.mForceBindUser = false;
                    } else if (ALog.isPrintLog(level)) {
                        ALog.d(Launcher_InitAccs.TAG, "onBindApp,  bindUser userid :" + Launcher_InitAccs.mUserId, new Object[0]);
                    }
                }
            }

            @Override // com.taobao.accs.IAppReceiver
            public void onBindUser(String str, int i) {
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(Launcher_InitAccs.TAG, "onBindUser, userId:" + str + " errorCode:" + i, new Object[0]);
                }
                if (i == 300) {
                    try {
                        ACCSClient.getAccsClient().bindApp(Launcher_InitAccs.mTtid, Launcher_InitAccs.mAppReceiver);
                    } catch (AccsException e2) {
                        ALog.e(Launcher_InitAccs.TAG, "bindApp", e2, new Object[0]);
                    }
                }
            }

            @Override // com.taobao.accs.IAppReceiver
            public void onData(String str, String str2, byte[] bArr) {
                if (ALog.isPrintLog(ALog.Level.D)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onData,  userId:");
                    sb.append(str);
                    sb.append("dataId:");
                    sb.append(str2);
                    sb.append(" dataLen:");
                    sb.append(bArr == null ? 0 : bArr.length);
                    ALog.d(Launcher_InitAccs.TAG, sb.toString(), new Object[0]);
                }
            }

            @Override // com.taobao.accs.IAppReceiver
            public void onSendData(String str, int i) {
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(Launcher_InitAccs.TAG, "onSendData,  dataId:" + str + " errorCode:" + i, new Object[0]);
                }
            }

            @Override // com.taobao.accs.IAppReceiver
            public void onUnbindApp(int i) {
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(Launcher_InitAccs.TAG, "onUnbindApp,  errorCode:" + i, new Object[0]);
                }
            }

            @Override // com.taobao.accs.IAppReceiver
            public void onUnbindUser(int i) {
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(Launcher_InitAccs.TAG, "onUnbindUser, errorCode:" + i, new Object[0]);
                }
            }
        };
        HashMap hashMap = new HashMap();
        SERVICES = hashMap;
        hashMap.put(IRequestConst.IM, "com.taobao.tao.amp.remote.AccsReceiverCallback");
        hashMap.put(ServiceKey.POWER_MSG, "com.taobao.appfrmbundle.mkt.AccsReceiverService");
        hashMap.put("pmmonitor", "com.taobao.appfrmbundle.mkt.AccsReceiverService");
        hashMap.put("cloudsync", "com.taobao.datasync.network.accs.AccsCloudSyncService");
        hashMap.put("acds", "com.taobao.acds.compact.AccsACDSService");
        hashMap.put(GlobalClientInfo.AGOO_SERVICE_ID, "org.android.agoo.accs.AgooService");
        hashMap.put(AgooConstants.AGOO_SERVICE_AGOOACK, "org.android.agoo.accs.AgooService");
        hashMap.put("agooTokenReport", "org.android.agoo.accs.AgooService");
        hashMap.put("AliLive", "com.taobao.playbudyy.gameplugin.danmu.DanmuCallbackService");
        hashMap.put("orange", "com.taobao.orange.accssupport.OrangeAccsService");
        hashMap.put("tsla", "com.taobao.android.festival.accs.HomepageAccsMassService");
        hashMap.put("taobaoWaimaiAccsService", "com.taobao.takeout.order.detail.service.TakeoutOrderDetailACCSService");
        hashMap.put("login", "com.taobao.android.sso.v2.service.LoginAccsService");
        hashMap.put("ranger_abtest", "com.taobao.ranger3.RangerACCSService");
        hashMap.put("accs_poplayer", "com.taobao.tbpoplayer.AccsPopLayerService");
        hashMap.put("dm_abtest", "com.tmall.wireless.ant.accs.AntAccsService");
        hashMap.put("family", "com.taobao.family.FamilyAccsService");
        hashMap.put("taobao-dingtalk", "com.laiwang.protocol.android.LwpAccsService");
        hashMap.put("amp-sync", "com.taobao.message.init.accs.AccsReceiverCallback");
        hashMap.put("friend_invite_msg", "com.taobao.message.init.accs.TaoFriendAccsReceiverCallback");
        hashMap.put("slider", "com.taobao.slide.accs.SlideAccsService");
    }

    private void initADaemon(final Application application, int i) {
        if (Launcher_InitAgooLifecycle.mADaemonValid) {
            ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new Runnable() { // from class: com.taobao.accs.init.Launcher_InitAccs.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Launcher_InitAgooLifecycle.adaemonClazz.getMethod("initialize", Context.class).invoke(null, application);
                    } catch (Exception e) {
                        ALog.e(Launcher_InitAccs.TAG, "adaemon initializeLifecycle error", e, new Object[0]);
                    }
                }
            }, i, TimeUnit.SECONDS);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void initAccs(android.app.Application r11, java.util.HashMap<java.lang.String, java.lang.Object> r12) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.init.Launcher_InitAccs.initAccs(android.app.Application, java.util.HashMap):void");
    }

    private void initAwcnBgConfig() {
        boolean isChannelModeEnable = OrangeAdapter.isChannelModeEnable();
        boolean isMainProcess = UtilityImpl.isMainProcess(mContext);
        boolean isAllWeather = ConnectionServiceManager.getInstance().isAllWeather();
        ALog.e(TAG, "initAwcnBgConfig", "isChannelMode", Boolean.valueOf(isChannelModeEnable), "isMainProcess", Boolean.valueOf(isMainProcess), "isAllWeather", Boolean.valueOf(isAllWeather));
        if (!isChannelModeEnable || (isMainProcess && !isAllWeather)) {
            C9708t9.V(true);
        }
    }

    private void initSecurity() {
    }

    private void launchInChannel() throws Exception {
        if (OrangeAdapter.isChannelInitOptimizeEnable(mContext)) {
            GlobalClientInfo.TAG_SERVICES.put("default", mAppReceiver.getAllServices());
            Intent intent = new Intent(Constants.ACTION_START_SERVICE);
            intent.putExtra("appKey", mAppkey);
            intent.putExtra("ttid", mTtid);
            intent.putExtra("packageName", mContext.getPackageName());
            intent.putExtra("app_sercet", "");
            intent.putExtra("mode", AccsClientConfig.mEnv);
            intent.putExtra(Config.PROPERTY_APP_KEY, Config.getAgooAppKey(GlobalClientInfo.getContext()));
            intent.putExtra(Constants.KEY_CONFIG_TAG, "default");
            intent.putExtra("start", true);
            intent.setClassName(mContext.getPackageName(), AdapterUtilityImpl.channelService);
            IntentDispatch.dispatchIntent(mContext, intent);
        } else {
            ACCSClient.getAccsClient().bindApp(mTtid, mAppReceiver);
        }
        if (OrangeAdapter.isSetMaxThreadsEnable()) {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(new Runnable() { // from class: com.taobao.accs.init.Launcher_InitAccs.3
                @Override // java.lang.Runnable
                public void run() {
                    ARanger.setMaxThread(Launcher_InitAccs.restrictionClazz != null ? new IReflect() { // from class: com.taobao.accs.init.Launcher_InitAccs.3.1
                        public Method getHideMethod(Class cls, String str, Class... clsArr) {
                            try {
                                return (Method) Launcher_InitAccs.restrictionClazz.getMethod("getDeclaredMethod", Object.class, String.class, Class[].class).invoke(null, cls, str, clsArr);
                            } catch (Exception e) {
                                ALog.e(Launcher_InitAccs.TAG, "get Restriction method error", e, new Object[0]);
                                return null;
                            }
                        }
                    } : null, 30);
                }
            });
        }
        if (keepAliveClazz == null || !OrangeAdapter.isKeepAliveInit()) {
            return;
        }
        try {
            keepAliveClazz.getMethod(UCCore.LEGACY_EVENT_INIT, Context.class).invoke(null, mContext);
        } catch (Exception e) {
            ALog.e(TAG, "keepAlive module initialize error", e, new Object[0]);
        }
    }

    private void launchInMain() {
        ThreadPoolExecutorFactory.execute(new Runnable() { // from class: com.taobao.accs.init.Launcher_InitAccs.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OrangeAdapter.isChannelModeEnable() && !ConnectionServiceManager.getInstance().isAllWeather()) {
                        GlobalClientInfo.getInstance(Launcher_InitAccs.mContext).recoverListener("default");
                    }
                    ACCSClient.getAccsClient().setLoginInfo(new AccsLoginInfo());
                    ACCSClient.getAccsClient().bindApp(Launcher_InitAccs.mTtid, Launcher_InitAccs.mAppReceiver);
                    ForeBackManager.getManager().reportSaveClickMessage();
                } catch (AccsException e) {
                    ALog.e(Launcher_InitAccs.TAG, "bindApp", e, new Object[0]);
                }
            }
        });
    }

    private void traceAccs() {
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new Runnable() { // from class: com.taobao.accs.init.Launcher_InitAccs.4
            @Override // java.lang.Runnable
            public void run() {
                String str;
                try {
                    if (!Launcher_InitAgooLifecycle.hasConnected && !ACCSClient.getAccsClient().isAccsConnected()) {
                        str = "fail";
                        Tracer.getInstance().buildSpan("accs", "connect").start().setTag("status", str).finish();
                    }
                    str = "success";
                    Tracer.getInstance().buildSpan("accs", "connect").start().setTag("status", str).finish();
                } catch (Throwable th) {
                    ALog.e(Launcher_InitAccs.TAG, "traceAccs error", th, new Object[0]);
                }
            }
        }, 20L, TimeUnit.SECONDS);
    }

    public void init(Application application, HashMap<String, Object> hashMap) {
        initImpl(application, hashMap, 0);
        if (UtilityImpl.isMainProcess(application)) {
            traceAccs();
        }
    }

    public void initImpl(Application application, HashMap<String, Object> hashMap, int i) {
        ALog.e(TAG, UCCore.LEGACY_EVENT_INIT, new Object[0]);
        try {
            if (mIsInited && ConnectionServiceManager.getInstance().isAllWeather()) {
                ALog.e(TAG, "init return", new Object[0]);
                return;
            }
            Context applicationContext = application.getApplicationContext();
            mContext = applicationContext;
            UtilityImpl.debug(applicationContext);
            initADaemon(application, i);
            initSecurity();
            initAwcnBgConfig();
            initAccs(application, hashMap);
            if (UtilityImpl.isMainProcess(mContext)) {
                mIsInited = true;
                launchInMain();
            } else if (UtilityImpl.isChannelProcess(mContext)) {
                launchInChannel();
            }
        } catch (Throwable th) {
            ALog.e(TAG, UCCore.LEGACY_EVENT_INIT, th, new Object[0]);
        }
    }
}
