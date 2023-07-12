package com.taobao.tao.remotebusiness.auth;

import androidx.annotation.NonNull;
import com.taobao.tao.remotebusiness.RequestPoolManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.xstate.XState;
import mtopsdk.xstate.util.XStateConstants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class RemoteAuth {
    private static final String TAG = "mtopsdk.RemoteAuth";
    private static Map<String, IRemoteAuth> mtopAuthMap = new ConcurrentHashMap();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class AuthHandler implements AuthListener {
        @NonNull
        private AuthParam authParam;
        @NonNull
        private Mtop mtopInstance;

        public AuthHandler(@NonNull Mtop mtop, @NonNull AuthParam authParam) {
            this.mtopInstance = mtop;
            this.authParam = authParam;
        }

        @Override // com.taobao.tao.remotebusiness.auth.AuthListener
        public void onAuthCancel(String str, String str2) {
            String str3 = this.authParam.openAppKey;
            if (str3 == null) {
                str3 = "DEFAULT_AUTH";
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                StringBuilder sb = new StringBuilder(64);
                sb.append("[onAuthCancel] auth cancel,key=");
                sb.append(StringUtils.concatStr(this.mtopInstance.getInstanceId(), str3));
                sb.append(",code=");
                sb.append(str);
                sb.append(",msg=");
                sb.append(str2);
                TBSdkLog.e(RemoteAuth.TAG, sb.toString());
            }
            RequestPoolManager.getPool(RequestPoolManager.Type.AUTH).failAllRequest(this.mtopInstance, str3, str, str2);
        }

        @Override // com.taobao.tao.remotebusiness.auth.AuthListener
        public void onAuthFail(String str, String str2) {
            String str3 = this.authParam.openAppKey;
            if (str3 == null) {
                str3 = "DEFAULT_AUTH";
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                StringBuilder sb = new StringBuilder(64);
                sb.append("[onAuthFail] auth fail,key=");
                sb.append(StringUtils.concatStr(this.mtopInstance.getInstanceId(), str3));
                sb.append(",code=");
                sb.append(str);
                sb.append(",msg=");
                sb.append(str2);
                TBSdkLog.e(RemoteAuth.TAG, sb.toString());
            }
            RequestPoolManager.getPool(RequestPoolManager.Type.AUTH).failAllRequest(this.mtopInstance, str3, str, str2);
        }

        @Override // com.taobao.tao.remotebusiness.auth.AuthListener
        public void onAuthSuccess() {
            String str = this.authParam.openAppKey;
            if (str == null) {
                str = "DEFAULT_AUTH";
            }
            String concatStr = StringUtils.concatStr(this.mtopInstance.getInstanceId(), str);
            String authToken = RemoteAuth.getAuthToken(this.mtopInstance, this.authParam);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(RemoteAuth.TAG, "auth success.authToken=" + authToken + ",key=" + concatStr);
            }
            XState.setValue(concatStr, XStateConstants.KEY_ACCESS_TOKEN, authToken);
            RequestPoolManager.getPool(RequestPoolManager.Type.AUTH).retryAllRequest(this.mtopInstance, str);
        }
    }

    public static void authorize(@NonNull Mtop mtop, AuthParam authParam) {
        if (authParam == null) {
            TBSdkLog.e(TAG, "[authorize] authParam is null");
            return;
        }
        IRemoteAuth auth = getAuth(mtop);
        if (auth == null) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, "didn't set IRemoteAuth implement. remoteAuth=null");
                return;
            }
            return;
        }
        IMtopRemoteAuth iMtopRemoteAuth = auth instanceof IMtopRemoteAuth ? (IMtopRemoteAuth) auth : null;
        if (iMtopRemoteAuth != null ? iMtopRemoteAuth.isAuthorizing(authParam) : auth.isAuthorizing()) {
            return;
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, "call authorize. " + authParam);
        }
        AuthHandler authHandler = new AuthHandler(mtop, authParam);
        if (iMtopRemoteAuth != null) {
            iMtopRemoteAuth.authorize(authParam, authHandler);
        } else {
            auth.authorize(authParam.bizParam, authParam.apiInfo, authParam.failInfo, authParam.showAuthUI, authHandler);
        }
    }

    private static IRemoteAuth getAuth(@NonNull Mtop mtop) {
        String instanceId = mtop == null ? Mtop.Id.OPEN : mtop.getInstanceId();
        IRemoteAuth iRemoteAuth = mtopAuthMap.get(instanceId);
        if (iRemoteAuth == null) {
            TBSdkLog.e(TAG, instanceId + " [getAuth]remoteAuthImpl is null");
        }
        return iRemoteAuth;
    }

    public static String getAuthToken(@NonNull Mtop mtop, AuthParam authParam) {
        if (authParam == null) {
            TBSdkLog.e(TAG, "[getAuthToken] authParam is null");
            return null;
        }
        IRemoteAuth auth = getAuth(mtop);
        if (auth == null) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, "didn't set IRemoteAuth implement. remoteAuth=null");
            }
            return null;
        }
        IMtopRemoteAuth iMtopRemoteAuth = auth instanceof IMtopRemoteAuth ? (IMtopRemoteAuth) auth : null;
        return iMtopRemoteAuth != null ? iMtopRemoteAuth.getAuthToken(authParam) : auth.getAuthToken();
    }

    public static boolean isAuthInfoValid(@NonNull Mtop mtop, AuthParam authParam) {
        if (authParam == null) {
            TBSdkLog.e(TAG, "[isAuthInfoValid] authParam is null");
            return true;
        }
        IRemoteAuth auth = getAuth(mtop);
        if (auth == null) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, "didn't set IRemoteAuth implement. remoteAuth=null");
            }
            return true;
        }
        IMtopRemoteAuth iMtopRemoteAuth = auth instanceof IMtopRemoteAuth ? (IMtopRemoteAuth) auth : null;
        if (iMtopRemoteAuth != null ? iMtopRemoteAuth.isAuthorizing(authParam) : auth.isAuthorizing()) {
            return false;
        }
        return iMtopRemoteAuth != null ? iMtopRemoteAuth.isAuthInfoValid(authParam) : auth.isAuthInfoValid();
    }

    @Deprecated
    public static void setAuthImpl(IRemoteAuth iRemoteAuth) {
        setAuthImpl(null, iRemoteAuth);
    }

    public static void setAuthImpl(@NonNull Mtop mtop, @NonNull IRemoteAuth iRemoteAuth) {
        if (iRemoteAuth != null) {
            String instanceId = mtop == null ? Mtop.Id.OPEN : mtop.getInstanceId();
            mtopAuthMap.put(instanceId, iRemoteAuth);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, instanceId + " [setAuthImpl] set remoteAuthImpl=" + iRemoteAuth);
            }
        }
    }
}
