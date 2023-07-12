package com.youku.live.dago.widgetlib.interactive.resource.prefetch;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AsyncConfigFetcher implements ConfigFetcher {
    private static transient /* synthetic */ IpChange $ipChange;

    public final void notifyConfigFetched(Config config) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1073934223")) {
            ipChange.ipc$dispatch("-1073934223", new Object[]{this, config});
        }
    }

    @Override // com.youku.live.dago.widgetlib.interactive.resource.prefetch.ConfigFetcher
    public Config onFetchingStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2085574062")) {
            return (Config) ipChange.ipc$dispatch("-2085574062", new Object[]{this});
        }
        return null;
    }
}
