package com.taobao.tao.remotebusiness.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.taobao.aranger.constant.Constants;
import com.taobao.login4android.Login;
import com.taobao.login4android.broadcast.LoginBroadcastHelper;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.login4android.constants.LoginStatus;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.util.HeaderHandlerUtil;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.stat.IUploadStats;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.xstate.XState;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class DefaultLoginImpl implements IRemoteLogin {
    private static final String MTOP_API_REFERENCE = "apiReferer";
    private static final String STATS_MODULE_MTOPRB = "mtoprb";
    private static final String STATS_MONITOR_POINT_SESSION_INVALID = "SessionInvalid";
    private static final String TAG = "mtopsdk.DefaultLoginImpl";
    static Context mContext;
    private Method checkSessionValidMethod;
    private Method getNickMethod;
    private Method getSidMethod;
    private Method getUserIdMethod;
    private Method isLoginingMethod;
    private Class<?> loginBroadcastHelperCls;
    private Class<?> loginCls;
    private Method loginMethod;
    private Class<?> loginStatusCls;
    private Method registerReceiverMethod;
    private static ThreadLocal<SessionInvalidEvent> threadLocal = new ThreadLocal<>();
    private static volatile AtomicBoolean isRegistered = new AtomicBoolean(false);
    public static volatile DefaultLoginImpl instance = null;
    private LoginContext loginContext = new LoginContext();
    protected BroadcastReceiver receiver = null;

    private DefaultLoginImpl() throws ClassNotFoundException, NoSuchMethodException {
        try {
            this.loginCls = Class.forName("com.taobao.login4android.api.Login");
        } catch (ClassNotFoundException unused) {
            String str = Login.TAG;
            this.loginCls = Login.class;
        }
        this.loginMethod = this.loginCls.getDeclaredMethod("login", Boolean.TYPE, Bundle.class);
        this.checkSessionValidMethod = this.loginCls.getDeclaredMethod("checkSessionValid", new Class[0]);
        this.getSidMethod = this.loginCls.getDeclaredMethod("getSid", new Class[0]);
        this.getUserIdMethod = this.loginCls.getDeclaredMethod("getUserId", new Class[0]);
        this.getNickMethod = this.loginCls.getDeclaredMethod("getNick", new Class[0]);
        boolean z = LoginStatus.saveSalt;
        this.loginStatusCls = LoginStatus.class;
        this.isLoginingMethod = LoginStatus.class.getDeclaredMethod("isLogining", new Class[0]);
        int i = LoginBroadcastHelper.a;
        this.loginBroadcastHelperCls = LoginBroadcastHelper.class;
        this.registerReceiverMethod = LoginBroadcastHelper.class.getMethod("registerLoginReceiver", Context.class, BroadcastReceiver.class);
        registerReceiver();
        TBSdkLog.e(TAG, "register login event receiver");
    }

    public static DefaultLoginImpl getDefaultLoginImpl(@NonNull Context context) {
        if (instance == null) {
            synchronized (DefaultLoginImpl.class) {
                if (instance == null) {
                    if (context == null) {
                        try {
                            context = MtopUtils.getContext();
                            if (context == null) {
                                TBSdkLog.e(TAG, "[getDefaultLoginImpl]context can't be null.reflect context is still null.");
                                Mtop instance2 = Mtop.instance(Mtop.Id.INNER, (Context) null);
                                if (instance2.getMtopConfig().context == null) {
                                    TBSdkLog.e(TAG, "[getDefaultLoginImpl]context can't be null.wait INNER mtopInstance init.");
                                    instance2.checkMtopSDKInit();
                                }
                                context = instance2.getMtopConfig().context;
                                if (context == null) {
                                    TBSdkLog.e(TAG, "[getDefaultLoginImpl]context can't be null.wait INNER mtopInstance init finish,context is still null");
                                    return instance;
                                }
                                TBSdkLog.e(TAG, "[getDefaultLoginImpl]context can't be null.wait INNER mtopInstance init finish.context=" + context);
                            }
                        } catch (Exception e) {
                            TBSdkLog.e(TAG, "[getDefaultLoginImpl]get DefaultLoginImpl instance error", e);
                        }
                    }
                    mContext = context;
                    instance = new DefaultLoginImpl();
                }
            }
        }
        return instance;
    }

    private <T> T invokeMethod(Method method, Object... objArr) {
        if (method != null) {
            try {
                return (T) method.invoke(this.loginCls, objArr);
            } catch (Exception e) {
                TBSdkLog.e(TAG, "[invokeMethod]invokeMethod error,method:" + method + ",args:" + objArr, e);
                return null;
            }
        }
        return null;
    }

    private void registerReceiver() {
        if (this.receiver == null) {
            if (mContext == null) {
                TBSdkLog.e(TAG, "[registerReceiver]Context is null, register receiver fail.");
                return;
            }
            synchronized (DefaultLoginImpl.class) {
                if (this.receiver == null) {
                    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.taobao.tao.remotebusiness.login.DefaultLoginImpl.1
                        @Override // android.content.BroadcastReceiver
                        public void onReceive(Context context, Intent intent) {
                            if (intent == null) {
                                return;
                            }
                            String action = intent.getAction();
                            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                                TBSdkLog.e(DefaultLoginImpl.TAG, "[onReceive]Login Broadcast Received. action=" + action);
                            }
                            action.hashCode();
                            char c = 65535;
                            switch (action.hashCode()) {
                                case -1186442906:
                                    if (action.equals("NOTIFY_LOGIN_CANCEL")) {
                                        c = 0;
                                        break;
                                    }
                                    break;
                                case -1100695767:
                                    if (action.equals("NOTIFY_LOGIN_FAILED")) {
                                        c = 1;
                                        break;
                                    }
                                    break;
                                case -542410121:
                                    if (action.equals("NOTIFY_LOGIN_SUCCESS")) {
                                        c = 2;
                                        break;
                                    }
                                    break;
                            }
                            switch (c) {
                                case 0:
                                    LoginHandler.instance().onLoginCancel();
                                    return;
                                case 1:
                                    LoginHandler.instance().onLoginFail();
                                    return;
                                case 2:
                                    LoginHandler.instance().onLoginSuccess();
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                    this.receiver = broadcastReceiver;
                    invokeMethod(this.registerReceiverMethod, mContext, broadcastReceiver);
                }
            }
        }
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public LoginContext getLoginContext() {
        this.loginContext.sid = (String) invokeMethod(this.getSidMethod, new Object[0]);
        this.loginContext.userId = (String) invokeMethod(this.getUserIdMethod, new Object[0]);
        this.loginContext.nickname = (String) invokeMethod(this.getNickMethod, new Object[0]);
        return this.loginContext;
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public boolean isLogining() {
        Boolean bool = (Boolean) invokeMethod(this.isLoginingMethod, new Object[0]);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public boolean isSessionValid() {
        Boolean bool = (Boolean) invokeMethod(this.checkSessionValidMethod, new Object[0]);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public void login(onLoginListener onloginlistener, boolean z) {
        Bundle bundle;
        Exception e;
        final IUploadStats iUploadStats;
        TBSdkLog.LogEnable logEnable = TBSdkLog.LogEnable.ErrorEnable;
        if (TBSdkLog.isLogEnable(logEnable)) {
            TBSdkLog.e(TAG, "[login]call login,showLoginUI:" + z + " , listener:" + onloginlistener);
        }
        Bundle bundle2 = null;
        final SessionInvalidEvent sessionInvalidEvent = threadLocal.get();
        if (sessionInvalidEvent != null) {
            try {
                try {
                    bundle = new Bundle();
                    try {
                        String jSONString = sessionInvalidEvent.toJSONString();
                        if (TBSdkLog.isLogEnable(logEnable)) {
                            TBSdkLog.e(TAG, "[login]apiRefer=" + jSONString);
                        }
                        bundle.putString("apiReferer", jSONString);
                        iUploadStats = Mtop.instance(mContext).getMtopConfig().uploadStats;
                    } catch (Exception e2) {
                        e = e2;
                        TBSdkLog.e(TAG, "[login]  login extra bundle error.", e);
                        threadLocal.remove();
                        bundle2 = bundle;
                        registerReceiver();
                        invokeMethod(this.loginMethod, Boolean.valueOf(z), bundle2);
                    }
                } finally {
                    threadLocal.remove();
                }
            } catch (Exception e3) {
                bundle = null;
                e = e3;
            }
            if (iUploadStats == null) {
                return;
            }
            MtopSDKThreadPoolExecutorFactory.submit(new Runnable() { // from class: com.taobao.tao.remotebusiness.login.DefaultLoginImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (DefaultLoginImpl.isRegistered.compareAndSet(false, true)) {
                            HashSet hashSet = new HashSet();
                            hashSet.add("long_nick");
                            hashSet.add("apiName");
                            hashSet.add("apiV");
                            hashSet.add("msgCode");
                            hashSet.add("S_STATUS");
                            hashSet.add(Constants.PARAM_PROCESS_NAME);
                            hashSet.add("appBackGround");
                            IUploadStats iUploadStats2 = iUploadStats;
                            if (iUploadStats2 != null) {
                                iUploadStats2.onRegister(DefaultLoginImpl.STATS_MODULE_MTOPRB, DefaultLoginImpl.STATS_MONITOR_POINT_SESSION_INVALID, hashSet, null, false);
                            }
                            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                                TBSdkLog.e(DefaultLoginImpl.TAG, "onRegister called. module=mtoprb,monitorPoint=SessionInvalid");
                            }
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("long_nick", sessionInvalidEvent.long_nick);
                        hashMap.put("apiName", sessionInvalidEvent.apiName);
                        hashMap.put("apiV", sessionInvalidEvent.v);
                        hashMap.put("msgCode", sessionInvalidEvent.msgCode);
                        hashMap.put("S_STATUS", sessionInvalidEvent.S_STATUS);
                        hashMap.put(Constants.PARAM_PROCESS_NAME, sessionInvalidEvent.processName);
                        hashMap.put("appBackGround", sessionInvalidEvent.appBackGround ? "1" : "0");
                        IUploadStats iUploadStats3 = iUploadStats;
                        if (iUploadStats3 != null) {
                            iUploadStats3.onCommit(DefaultLoginImpl.STATS_MODULE_MTOPRB, DefaultLoginImpl.STATS_MONITOR_POINT_SESSION_INVALID, hashMap, null);
                        }
                    } catch (Exception e4) {
                        TBSdkLog.e(DefaultLoginImpl.TAG, "upload  SessionInvalid Stats error.", e4);
                    }
                }
            });
            threadLocal.remove();
            bundle2 = bundle;
        }
        registerReceiver();
        invokeMethod(this.loginMethod, Boolean.valueOf(z), bundle2);
    }

    public void setSessionInvalid(Object obj) {
        if (obj instanceof MtopResponse) {
            threadLocal.set(new SessionInvalidEvent((MtopResponse) obj, (String) invokeMethod(this.getNickMethod, new Object[0])));
        } else if (obj instanceof MtopRequest) {
            threadLocal.set(new SessionInvalidEvent((MtopRequest) obj));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class SessionInvalidEvent {
        private static final String HEADER_KEY = "S";
        public String S_STATUS;
        public String apiName;
        public boolean appBackGround;
        public String eventName;
        public String long_nick;
        public String msgCode;
        public String processName;
        public String v;

        public SessionInvalidEvent(MtopResponse mtopResponse, String str) {
            this.eventName = LoginConstants.EVENT_SESSION_INVALID;
            this.long_nick = str;
            this.apiName = mtopResponse.getApi();
            this.v = mtopResponse.getV();
            this.msgCode = mtopResponse.getRetCode();
            this.S_STATUS = HeaderHandlerUtil.getSingleHeaderFieldByKey(mtopResponse.getHeaderFields(), "S");
            this.processName = MtopUtils.getCurrentProcessName(DefaultLoginImpl.mContext);
            this.appBackGround = XState.isAppBackground();
        }

        public String toJSONString() {
            return JSON.toJSONString(this);
        }

        public SessionInvalidEvent(MtopRequest mtopRequest) {
            this.apiName = mtopRequest.getApiName();
            this.v = mtopRequest.getVersion();
            this.processName = MtopUtils.getCurrentProcessName(DefaultLoginImpl.mContext);
            this.appBackGround = XState.isAppBackground();
        }
    }
}
