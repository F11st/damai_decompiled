package com.alient.oneservice.userinfo;

import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import org.joor.C8883a;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MemberProviderProxy {
    private static MemberProvider sProxy;

    public static JSONObject getCurrentUserInfo() {
        try {
            if (sProxy == null) {
                sProxy = (MemberProvider) C8883a.j("com.alient.oneservice.provider.impl.userinfo.MemberProviderImpl").b().f();
            }
            return sProxy.getCurrentUserInfo();
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.userinfo.MemberProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static MemberProvider getProxy() {
        if (sProxy == null) {
            sProxy = (MemberProvider) C8883a.j("com.alient.oneservice.provider.impl.userinfo.MemberProviderImpl").b().f();
        }
        return sProxy;
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
}
