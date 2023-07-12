package com.ali.user.mobile.utils;

import com.ali.user.mobile.app.dataprovider.DataProviderFactory;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class SiteUtil {
    public static int getDefaultLoginSite() {
        return DataProviderFactory.getDataProvider().getSite();
    }
}
