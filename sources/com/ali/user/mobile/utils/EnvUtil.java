package com.ali.user.mobile.utils;

import com.ali.user.mobile.app.dataprovider.DataProviderFactory;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class EnvUtil {
    public static int getAlimmsdk_env() {
        if (DataProviderFactory.getDataProvider().getEnvType() == 1) {
            return 2;
        }
        return DataProviderFactory.getDataProvider().getEnvType() == 2 ? 1 : 0;
    }
}
