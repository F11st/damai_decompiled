package com.taobao.tao.remotebusiness.login;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.tao.remotebusiness.RequestPoolManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.util.ErrorConstant;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class LoginHandler extends Handler implements onLoginListener {
    private static final String DEFAULT_USERINFO = "DEFAULT";
    public static final int LOGIN_CANCEL = 911103;
    public static final int LOGIN_FAILED = 911102;
    public static final int LOGIN_SUCCESS = 911101;
    public static final int LOGIN_TIMEOUT = 911104;
    private static final String TAG = "mtopsdk.LoginHandler";
    private static HandlerThread handlerThread;
    private static Map<String, LoginHandler> mtopLoginHandlerMap = new ConcurrentHashMap();
    @NonNull
    private Mtop mtopInstance;
    @Nullable
    private String userInfo;

    private LoginHandler(@NonNull Mtop mtop, @Nullable String str, Looper looper) {
        super(looper);
        this.mtopInstance = mtop;
        this.userInfo = str;
    }

    private static String getKey(@NonNull Mtop mtop, @Nullable String str) {
        if (StringUtils.isBlank(str)) {
            str = "DEFAULT";
        }
        return StringUtils.concatStr(mtop.getInstanceId(), str);
    }

    public static LoginHandler instance(@NonNull Mtop mtop, @Nullable String str) {
        Mtop instance = mtop == null ? Mtop.instance(null) : mtop;
        if (StringUtils.isBlank(str)) {
            str = "DEFAULT";
        }
        String key = getKey(mtop, str);
        LoginHandler loginHandler = mtopLoginHandlerMap.get(key);
        if (loginHandler == null) {
            synchronized (LoginHandler.class) {
                loginHandler = mtopLoginHandlerMap.get(key);
                if (loginHandler == null) {
                    if (handlerThread == null) {
                        HandlerThread handlerThread2 = new HandlerThread(TAG);
                        handlerThread = handlerThread2;
                        handlerThread2.start();
                    }
                    loginHandler = new LoginHandler(instance, str, handlerThread.getLooper());
                    mtopLoginHandlerMap.put(key, loginHandler);
                }
            }
        }
        return loginHandler;
    }

    private void updateXStateSessionInfo(String str) {
        LoginContext loginContext = RemoteLogin.getLoginContext(this.mtopInstance, this.userInfo);
        if (loginContext == null) {
            TBSdkLog.e(TAG, str + " [updateXStateSessionInfo] LoginContext is null.");
            return;
        }
        try {
            if (!StringUtils.isNotBlank(loginContext.sid) || loginContext.sid.equals(this.mtopInstance.getMultiAccountSid(this.userInfo))) {
                return;
            }
            this.mtopInstance.registerMultiAccountSession(this.userInfo, loginContext.sid, loginContext.userId);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                TBSdkLog.e(TAG, str + " [updateXStateSessionInfo] invoked.");
            }
        } catch (Exception e) {
            TBSdkLog.e(TAG, str + " [updateXStateSessionInfo] error.", e);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String key = getKey(this.mtopInstance, this.userInfo);
        TBSdkLog.LogEnable logEnable = TBSdkLog.LogEnable.ErrorEnable;
        if (TBSdkLog.isLogEnable(logEnable)) {
            TBSdkLog.e(TAG, key + " [handleMessage]The MtopBusiness LoginHandler receive message .");
        }
        switch (message.what) {
            case LOGIN_SUCCESS /* 911101 */:
                if (TBSdkLog.isLogEnable(logEnable)) {
                    TBSdkLog.e(TAG, key + " [handleMessage]onReceive: NOTIFY_LOGIN_SUCCESS.");
                }
                updateXStateSessionInfo(key);
                RequestPoolManager.getPool(RequestPoolManager.Type.SESSION).retryAllRequest(this.mtopInstance, this.userInfo);
                removeMessages(LOGIN_TIMEOUT);
                return;
            case LOGIN_FAILED /* 911102 */:
                if (TBSdkLog.isLogEnable(logEnable)) {
                    TBSdkLog.e(TAG, key + "[handleMessage]onReceive: NOTIFY_LOGIN_FAILED.");
                }
                RequestPoolManager.getPool(RequestPoolManager.Type.SESSION).failAllRequest(this.mtopInstance, this.userInfo, ErrorConstant.ERRCODE_ANDROID_SYS_LOGIN_FAIL, ErrorConstant.ERRMSG_ANDROID_SYS_LOGIN_FAIL);
                removeMessages(LOGIN_TIMEOUT);
                return;
            case LOGIN_CANCEL /* 911103 */:
                if (TBSdkLog.isLogEnable(logEnable)) {
                    TBSdkLog.e(TAG, key + "[handleMessage]onReceive: NOTIFY_LOGIN_CANCEL.");
                }
                RequestPoolManager.getPool(RequestPoolManager.Type.SESSION).failAllRequest(this.mtopInstance, this.userInfo, ErrorConstant.ERRCODE_ANDROID_SYS_LOGIN_CANCEL, ErrorConstant.ERRMSG_ANDROID_SYS_LOGIN_CANCEL);
                removeMessages(LOGIN_TIMEOUT);
                return;
            case LOGIN_TIMEOUT /* 911104 */:
                if (TBSdkLog.isLogEnable(logEnable)) {
                    TBSdkLog.e(TAG, key + "[handleMessage]onReceive: NOTIFY_LOGIN_TIMEOUT.");
                }
                if (RemoteLogin.isSessionValid(this.mtopInstance, this.userInfo)) {
                    if (TBSdkLog.isLogEnable(logEnable)) {
                        TBSdkLog.e(TAG, "Session valid, Broadcast may missed!");
                    }
                    updateXStateSessionInfo(key);
                    RequestPoolManager.getPool(RequestPoolManager.Type.SESSION).retryAllRequest(this.mtopInstance, this.userInfo);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.taobao.tao.remotebusiness.login.onLoginListener
    public void onLoginCancel() {
        sendEmptyMessage(LOGIN_CANCEL);
    }

    @Override // com.taobao.tao.remotebusiness.login.onLoginListener
    public void onLoginFail() {
        sendEmptyMessage(LOGIN_FAILED);
    }

    @Override // com.taobao.tao.remotebusiness.login.onLoginListener
    public void onLoginSuccess() {
        sendEmptyMessage(LOGIN_SUCCESS);
    }

    @Deprecated
    public static LoginHandler instance() {
        return instance(Mtop.instance(null), null);
    }
}
