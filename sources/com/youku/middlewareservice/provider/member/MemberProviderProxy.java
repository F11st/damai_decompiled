package com.youku.middlewareservice.provider.member;

import android.util.Log;
import com.youku.middlewareservice.provider.member.MemberProvider;
import org.joor.C8883a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class MemberProviderProxy {
    private static MemberProvider sProxy;

    public static String getLoginEmail(String str) {
        try {
            if (sProxy == null) {
                sProxy = (MemberProvider) C8883a.j("com.youku.middlewareservice_impl.provider.member.MemberProviderImpl").b().f();
            }
            return sProxy.getLoginEmail(str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.member.MemberProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getLoginMobile(String str) {
        try {
            if (sProxy == null) {
                sProxy = (MemberProvider) C8883a.j("com.youku.middlewareservice_impl.provider.member.MemberProviderImpl").b().f();
            }
            return sProxy.getLoginMobile(str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.member.MemberProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static String getMemberId(String str) {
        try {
            if (sProxy == null) {
                sProxy = (MemberProvider) C8883a.j("com.youku.middlewareservice_impl.provider.member.MemberProviderImpl").b().f();
            }
            return sProxy.getMemberId(str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.member.MemberProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static void getNewestMemberInfo(MemberProvider.MemberInfoUpdateListener memberInfoUpdateListener, MemberProvider.MemberInfoErrorListener memberInfoErrorListener) {
        try {
            if (sProxy == null) {
                sProxy = (MemberProvider) C8883a.j("com.youku.middlewareservice_impl.provider.member.MemberProviderImpl").b().f();
            }
            sProxy.getNewestMemberInfo(memberInfoUpdateListener, memberInfoErrorListener);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.member.MemberProviderImpl  Throwable: " + th.toString());
        }
    }

    public static MemberProvider getProxy() {
        if (sProxy == null) {
            sProxy = (MemberProvider) C8883a.j("com.youku.middlewareservice_impl.provider.member.MemberProviderImpl").b().f();
        }
        return sProxy;
    }

    public static String getVipExpireTime(String str) {
        try {
            if (sProxy == null) {
                sProxy = (MemberProvider) C8883a.j("com.youku.middlewareservice_impl.provider.member.MemberProviderImpl").b().f();
            }
            return sProxy.getVipExpireTime(str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.member.MemberProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static int getVipStatus(String str) {
        try {
            if (sProxy == null) {
                sProxy = (MemberProvider) C8883a.j("com.youku.middlewareservice_impl.provider.member.MemberProviderImpl").b().f();
            }
            return sProxy.getVipStatus(str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.member.MemberProviderImpl  Throwable: " + th.toString());
            return 0;
        }
    }

    public static void inject(Class cls) {
        if (sProxy == null && MemberProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (MemberProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isMember(String str) {
        try {
            if (sProxy == null) {
                sProxy = (MemberProvider) C8883a.j("com.youku.middlewareservice_impl.provider.member.MemberProviderImpl").b().f();
            }
            return sProxy.isMember(str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.member.MemberProviderImpl  Throwable: " + th.toString());
            return false;
        }
    }
}
