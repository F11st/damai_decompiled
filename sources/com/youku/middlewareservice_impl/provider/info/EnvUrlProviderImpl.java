package com.youku.middlewareservice_impl.provider.info;

import com.alient.oneservice.provider.impl.OneConfig;
import com.youku.middlewareservice.provider.info.EnvUrlProvider;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class EnvUrlProviderImpl implements EnvUrlProvider {
    @Override // com.youku.middlewareservice.provider.info.EnvUrlProvider
    public String getDailyUrl() {
        return null;
    }

    @Override // com.youku.middlewareservice.provider.info.EnvUrlProvider
    public int getEnvType() {
        return OneConfig.getEnvType();
    }

    @Override // com.youku.middlewareservice.provider.info.EnvUrlProvider
    public String getOnlineUrl() {
        return null;
    }

    @Override // com.youku.middlewareservice.provider.info.EnvUrlProvider
    public String getPreUrl() {
        return null;
    }

    @Override // com.youku.middlewareservice.provider.info.EnvUrlProvider
    public String getUrl() {
        return null;
    }

    @Override // com.youku.middlewareservice.provider.info.EnvUrlProvider
    public boolean isDaily() {
        return getEnvType() == 2;
    }

    @Override // com.youku.middlewareservice.provider.info.EnvUrlProvider
    public boolean isOnline() {
        return getEnvType() == 0;
    }

    @Override // com.youku.middlewareservice.provider.info.EnvUrlProvider
    public boolean isPre() {
        return getEnvType() == 1;
    }
}
