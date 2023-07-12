package com.youku.phone.xcdn.api;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes13.dex */
public class XcdnProxy {
    private static final String TAG = "XcdnDownloader";
    private static volatile IXcdnApi mXcdn;
    private static volatile Class mXcdnClz;

    public static IXcdnApi getProxy() throws Throwable {
        if (mXcdn != null) {
            return mXcdn;
        }
        throw new Throwable("xcdn proxy is not inject.");
    }

    public static void inject(Class cls) {
        if (mXcdnClz == null && IXcdnApi.class.isAssignableFrom(cls)) {
            mXcdnClz = cls;
        }
    }

    public static void setProxy(IXcdnApi iXcdnApi) {
        mXcdn = iXcdnApi;
    }
}
