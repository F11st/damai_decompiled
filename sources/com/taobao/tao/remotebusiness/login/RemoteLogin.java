package com.taobao.tao.remotebusiness.login;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.intf.Mtop;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class RemoteLogin {
    private static final String DEFAULT_USERINFO = "DEFAULT";
    public static final String TAG = "mtopsdk.RemoteLogin";
    private static Map<String, IRemoteLogin> mtopLoginMap = new ConcurrentHashMap();

    public static IRemoteLogin getLogin(Mtop mtop) {
        String instanceId = mtop == null ? Mtop.Id.INNER : mtop.getInstanceId();
        IRemoteLogin iRemoteLogin = mtopLoginMap.get(instanceId);
        if (iRemoteLogin == null) {
            synchronized (RemoteLogin.class) {
                iRemoteLogin = mtopLoginMap.get(instanceId);
                if (iRemoteLogin == null) {
                    DefaultLoginImpl defaultLoginImpl = DefaultLoginImpl.getDefaultLoginImpl(mtop == null ? null : mtop.getMtopConfig().context);
                    if (defaultLoginImpl != null) {
                        mtopLoginMap.put(instanceId, defaultLoginImpl);
                        iRemoteLogin = defaultLoginImpl;
                    } else {
                        TBSdkLog.e(TAG, instanceId + " [getLogin]loginImpl is null");
                        throw new LoginNotImplementException(instanceId + " [getLogin] Login Not Implement!");
                    }
                }
            }
        }
        return iRemoteLogin;
    }

    public static LoginContext getLoginContext(@NonNull Mtop mtop, @Nullable String str) {
        IRemoteLogin login = getLogin(mtop);
        if (login instanceof MultiAccountRemoteLogin) {
            if ("DEFAULT".equals(str)) {
                str = null;
            }
            return ((MultiAccountRemoteLogin) login).getLoginContext(str);
        }
        return login.getLoginContext();
    }

    public static boolean isSessionValid(@NonNull Mtop mtop, @Nullable String str) {
        IRemoteLogin login = getLogin(mtop);
        MultiAccountRemoteLogin multiAccountRemoteLogin = login instanceof MultiAccountRemoteLogin ? (MultiAccountRemoteLogin) login : null;
        if ("DEFAULT".equals(str)) {
            str = null;
        }
        if (multiAccountRemoteLogin != null ? multiAccountRemoteLogin.isLogining(str) : login.isLogining()) {
            return false;
        }
        return multiAccountRemoteLogin != null ? multiAccountRemoteLogin.isSessionValid(str) : login.isSessionValid();
    }

    public static void login(@NonNull Mtop mtop, @Nullable String str, boolean z, Object obj) {
        IRemoteLogin login = getLogin(mtop);
        String concatStr = StringUtils.concatStr(mtop == null ? Mtop.Id.INNER : mtop.getInstanceId(), StringUtils.isBlank(str) ? "DEFAULT" : str);
        MultiAccountRemoteLogin multiAccountRemoteLogin = login instanceof MultiAccountRemoteLogin ? (MultiAccountRemoteLogin) login : null;
        String str2 = "DEFAULT".equals(str) ? null : str;
        if (multiAccountRemoteLogin != null ? multiAccountRemoteLogin.isLogining(str2) : login.isLogining()) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                TBSdkLog.e(TAG, concatStr + " [login] loginsdk is logining");
                return;
            }
            return;
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
            TBSdkLog.e(TAG, concatStr + " [login]call login");
        }
        if (obj != null && (login instanceof DefaultLoginImpl)) {
            ((DefaultLoginImpl) login).setSessionInvalid(obj);
        }
        LoginHandler instance = LoginHandler.instance(mtop, str);
        if (multiAccountRemoteLogin != null) {
            multiAccountRemoteLogin.login(str2, instance, z);
        } else {
            login.login(instance, z);
        }
        instance.sendEmptyMessageDelayed(LoginHandler.LOGIN_TIMEOUT, 20000L);
    }

    public static void setLoginImpl(@NonNull Mtop mtop, @NonNull IRemoteLogin iRemoteLogin) {
        if (iRemoteLogin != null) {
            String instanceId = mtop == null ? Mtop.Id.INNER : mtop.getInstanceId();
            mtopLoginMap.put(instanceId, iRemoteLogin);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, instanceId + " [setLoginImpl] set loginImpl=" + iRemoteLogin);
            }
        }
    }

    public static void setSessionInvalid(@NonNull Mtop mtop, Bundle bundle) {
        IRemoteLogin login = getLogin(mtop);
        if (login instanceof IRemoteLoginAdapter) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                String instanceId = mtop == null ? Mtop.Id.INNER : mtop.getInstanceId();
                TBSdkLog.i(TAG, instanceId + " [setSessionInvalid] bundle=" + bundle);
            }
            ((IRemoteLoginAdapter) login).setSessionInvalid(bundle);
        }
    }

    @Deprecated
    public static void setLoginImpl(IRemoteLogin iRemoteLogin) {
        setLoginImpl(null, iRemoteLogin);
    }

    @Deprecated
    public static LoginContext getLoginContext() {
        return getLoginContext(null, null);
    }

    @Deprecated
    public static boolean isSessionValid() {
        return isSessionValid(null, null);
    }

    @Deprecated
    public static IRemoteLogin getLogin() {
        return getLogin(null);
    }

    @Deprecated
    public static void login(boolean z) {
        login(null, null, z, null);
    }

    @Deprecated
    public static void login(boolean z, Object obj) {
        login(null, null, z, obj);
    }
}
