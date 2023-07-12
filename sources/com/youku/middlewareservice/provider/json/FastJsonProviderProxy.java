package com.youku.middlewareservice.provider.json;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class FastJsonProviderProxy {
    private static FastJsonProvider sProxy;

    public static FastJsonProvider getProxy() {
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && FastJsonProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (FastJsonProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
