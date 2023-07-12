package com.youku.middlewareservice.provider.antitheftchain;

import android.content.Context;
import android.util.Log;
import com.youku.middlewareservice.provider.antitheftchain.AntiTheftChainProvider;
import java.util.HashMap;
import org.joor.a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class AntiTheftChainProviderProxy {
    private static AntiTheftChainProvider sProxy;

    public static String getAntiTheftChainKey(AntiTheftChainProvider.AntiTheftChainClientType antiTheftChainClientType, String str, String str2, Context context, HashMap hashMap) {
        try {
            if (sProxy == null) {
                sProxy = (AntiTheftChainProvider) a.j("com.youku.middlewareservice_impl.provider.antitheftchain.AntiTheftChainProviderImpl").b().f();
            }
            return sProxy.getAntiTheftChainKey(antiTheftChainClientType, str, str2, context, hashMap);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.antitheftchain.AntiTheftChainProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static AntiTheftChainProvider getProxy() {
        if (sProxy == null) {
            sProxy = (AntiTheftChainProvider) a.j("com.youku.middlewareservice_impl.provider.antitheftchain.AntiTheftChainProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && AntiTheftChainProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (AntiTheftChainProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
