package com.alient.oneservice.provider.impl.appinfo;

import androidx.annotation.Keep;
import cn.damai.common.AppConfig;
import com.alient.oneservice.appinfo.AppInfoProvider;
import tb.z20;

/* compiled from: Taobao */
@Keep
/* loaded from: classes10.dex */
public class AppInfoProviderImpl implements AppInfoProvider {
    @Override // com.alient.oneservice.appinfo.AppInfoProvider
    public String getCityId() {
        return z20.c();
    }

    @Override // com.alient.oneservice.appinfo.AppInfoProvider
    public String getComboChannel() {
        return "1";
    }

    @Override // com.alient.oneservice.appinfo.AppInfoProvider
    public String getTTID() {
        return AppConfig.p();
    }
}
