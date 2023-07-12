package com.youku.middlewareservice_impl.provider;

import com.youku.middlewareservice.provider.ChannelProvider;
import com.youku.middlewareservice.provider.LogProviderProxy;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ChannelProviderImpl implements ChannelProvider {
    @Override // com.youku.middlewareservice.provider.ChannelProvider
    public String getChannelId() {
        return null;
    }

    @Override // com.youku.middlewareservice.provider.ChannelProvider
    public String getPid() {
        return null;
    }

    @Override // com.youku.middlewareservice.provider.ChannelProvider
    public boolean isGooglePlayChannel() {
        boolean equalsIgnoreCase = "212200".equalsIgnoreCase(AppInfoProviderProxy.getTTID());
        if (AppInfoProviderProxy.isDebuggable()) {
            LogProviderProxy.loge("AppNewManufacture", "isGooglePlayChannel:" + equalsIgnoreCase);
        }
        return equalsIgnoreCase;
    }
}
