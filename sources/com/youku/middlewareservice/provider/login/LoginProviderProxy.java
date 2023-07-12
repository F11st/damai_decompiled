package com.youku.middlewareservice.provider.login;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import org.joor.a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class LoginProviderProxy {
    private static LoginProvider sProxy;

    public static void clearSession() {
        try {
            if (sProxy == null) {
                sProxy = (LoginProvider) a.j("com.youku.middlewareservice_impl.provider.login.LoginProviderImpl").b().f();
            }
            sProxy.clearSession();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.login.LoginProviderImpl  Throwable: " + th.toString());
        }
    }

    public static String getAvatarUrl() {
        try {
            if (sProxy == null) {
                sProxy = (LoginProvider) a.j("com.youku.middlewareservice_impl.provider.login.LoginProviderImpl").b().f();
            }
            return sProxy.getAvatarUrl();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.login.LoginProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getEcode() {
        try {
            if (sProxy == null) {
                sProxy = (LoginProvider) a.j("com.youku.middlewareservice_impl.provider.login.LoginProviderImpl").b().f();
            }
            return sProxy.getEcode();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.login.LoginProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getEncryptedYtId() {
        try {
            if (sProxy == null) {
                sProxy = (LoginProvider) a.j("com.youku.middlewareservice_impl.provider.login.LoginProviderImpl").b().f();
            }
            return sProxy.getEncryptedYtId();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.login.LoginProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getNick() {
        try {
            if (sProxy == null) {
                sProxy = (LoginProvider) a.j("com.youku.middlewareservice_impl.provider.login.LoginProviderImpl").b().f();
            }
            return sProxy.getNick();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.login.LoginProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static LoginProvider getProxy() {
        if (sProxy == null) {
            sProxy = (LoginProvider) a.j("com.youku.middlewareservice_impl.provider.login.LoginProviderImpl").b().f();
        }
        return sProxy;
    }

    public static String getSid() {
        try {
            if (sProxy == null) {
                sProxy = (LoginProvider) a.j("com.youku.middlewareservice_impl.provider.login.LoginProviderImpl").b().f();
            }
            return sProxy.getSid();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.login.LoginProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getUserId() {
        try {
            if (sProxy == null) {
                sProxy = (LoginProvider) a.j("com.youku.middlewareservice_impl.provider.login.LoginProviderImpl").b().f();
            }
            return sProxy.getUserId();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.login.LoginProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getYid() {
        try {
            if (sProxy == null) {
                sProxy = (LoginProvider) a.j("com.youku.middlewareservice_impl.provider.login.LoginProviderImpl").b().f();
            }
            return sProxy.getYid();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.login.LoginProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getYoukuUid() {
        try {
            if (sProxy == null) {
                sProxy = (LoginProvider) a.j("com.youku.middlewareservice_impl.provider.login.LoginProviderImpl").b().f();
            }
            return sProxy.getYoukuUid();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.login.LoginProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static void goLogin(Context context) {
        try {
            if (sProxy == null) {
                sProxy = (LoginProvider) a.j("com.youku.middlewareservice_impl.provider.login.LoginProviderImpl").b().f();
            }
            sProxy.goLogin(context);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.login.LoginProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void goLoginForResult(Activity activity, int i) {
        try {
            if (sProxy == null) {
                sProxy = (LoginProvider) a.j("com.youku.middlewareservice_impl.provider.login.LoginProviderImpl").b().f();
            }
            sProxy.goLoginForResult(activity, i);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.login.LoginProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void goUserProfilePage(Activity activity, String str) {
        try {
            if (sProxy == null) {
                sProxy = (LoginProvider) a.j("com.youku.middlewareservice_impl.provider.login.LoginProviderImpl").b().f();
            }
            sProxy.goUserProfilePage(activity, str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.login.LoginProviderImpl  Throwable: " + th.toString());
        }
    }

    public static LoginProvider init(Application application, LoginConfig loginConfig) {
        try {
            if (sProxy == null) {
                sProxy = (LoginProvider) a.j("com.youku.middlewareservice_impl.provider.login.LoginProviderImpl").b().f();
            }
            return sProxy.init(application, loginConfig);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.login.LoginProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static void inject(Class cls) {
        if (sProxy == null && LoginProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (LoginProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isLogin() {
        try {
            if (sProxy == null) {
                sProxy = (LoginProvider) a.j("com.youku.middlewareservice_impl.provider.login.LoginProviderImpl").b().f();
            }
            return sProxy.isLogin();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.login.LoginProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static boolean isVip() {
        try {
            if (sProxy == null) {
                sProxy = (LoginProvider) a.j("com.youku.middlewareservice_impl.provider.login.LoginProviderImpl").b().f();
            }
            return sProxy.isVip();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.login.LoginProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }

    public static void logout() {
        try {
            if (sProxy == null) {
                sProxy = (LoginProvider) a.j("com.youku.middlewareservice_impl.provider.login.LoginProviderImpl").b().f();
            }
            sProxy.logout();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.login.LoginProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void release() {
        try {
            if (sProxy == null) {
                sProxy = (LoginProvider) a.j("com.youku.middlewareservice_impl.provider.login.LoginProviderImpl").b().f();
            }
            sProxy.release();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.login.LoginProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void goLogin(Context context, String str) {
        try {
            if (sProxy == null) {
                sProxy = (LoginProvider) a.j("com.youku.middlewareservice_impl.provider.login.LoginProviderImpl").b().f();
            }
            sProxy.goLogin(context, str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.login.LoginProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void goLoginForResult(Activity activity, int i, String str) {
        try {
            if (sProxy == null) {
                sProxy = (LoginProvider) a.j("com.youku.middlewareservice_impl.provider.login.LoginProviderImpl").b().f();
            }
            sProxy.goLoginForResult(activity, i, str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.login.LoginProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void goLogin(Context context, int i) {
        try {
            if (sProxy == null) {
                sProxy = (LoginProvider) a.j("com.youku.middlewareservice_impl.provider.login.LoginProviderImpl").b().f();
            }
            sProxy.goLogin(context, i);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.login.LoginProviderImpl  Throwable: " + th.toString());
        }
    }
}
