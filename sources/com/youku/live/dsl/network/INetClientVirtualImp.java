package com.youku.live.dsl.network;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class INetClientVirtualImp implements INetClient {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.network.INetClient
    public INetRequest createRequestWithHttp(String str, Map<String, String> map, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1941902711")) {
            return (INetRequest) ipChange.ipc$dispatch("-1941902711", new Object[]{this, str, map, Boolean.valueOf(z)});
        }
        return null;
    }

    @Override // com.youku.live.dsl.network.INetClient
    public INetRequest createRequestWithMTop(String str, String str2, Map<String, String> map, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1086527483")) {
            return (INetRequest) ipChange.ipc$dispatch("-1086527483", new Object[]{this, str, str2, map, Boolean.valueOf(z), Boolean.valueOf(z2)});
        }
        return null;
    }

    @Override // com.youku.live.dsl.network.INetClient
    public String getMtopId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "708959022")) {
            return (String) ipChange.ipc$dispatch("708959022", new Object[]{this});
        }
        return null;
    }
}
