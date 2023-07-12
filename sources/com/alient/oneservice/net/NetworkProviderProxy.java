package com.alient.oneservice.net;

import android.util.Log;
import java.util.Map;
import org.joor.C8883a;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class NetworkProviderProxy {
    private static NetworkProvider sProxy;

    public static String getErrorMsg(String str, String str2) {
        try {
            if (sProxy == null) {
                sProxy = (NetworkProvider) C8883a.j("com.alient.oneservice.provider.impl.net.NetworkProviderImpl").b().f();
            }
            return sProxy.getErrorMsg(str, str2);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.net.NetworkProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static NetworkProvider getProxy() {
        if (sProxy == null) {
            sProxy = (NetworkProvider) C8883a.j("com.alient.oneservice.provider.impl.net.NetworkProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && NetworkProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (NetworkProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Map<String, String> signParams(String str, Map<String, String> map) {
        try {
            if (sProxy == null) {
                sProxy = (NetworkProvider) C8883a.j("com.alient.oneservice.provider.impl.net.NetworkProviderImpl").b().f();
            }
            return sProxy.signParams(str, map);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.alient.oneservice.provider.impl.net.NetworkProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }
}
