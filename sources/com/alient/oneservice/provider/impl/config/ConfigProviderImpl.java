package com.alient.oneservice.provider.impl.config;

import androidx.annotation.Keep;
import cn.damai.wantsee.StartConfig;
import com.alient.oneservice.config.ConfigProvider;
import tb.z20;

/* compiled from: Taobao */
@Keep
/* loaded from: classes10.dex */
public class ConfigProviderImpl implements ConfigProvider {
    @Override // com.alient.oneservice.config.ConfigProvider
    public boolean isAppRecommendAvailability() {
        return z20.K();
    }

    @Override // com.alient.oneservice.config.ConfigProvider
    public boolean isHomepageCndRequestEnable() {
        return z20.v();
    }

    @Override // com.alient.oneservice.config.ConfigProvider
    public boolean isOpenSearchCdnDowngrade() {
        return StartConfig.isOpenSearchCdnDowngrade();
    }
}
