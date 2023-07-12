package com.youku.live.dsl.network;

import cn.damai.net.NetConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class INetClientImp implements INetClient {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.network.INetClient
    public INetRequest createRequestWithHttp(String str, Map<String, String> map, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1782326006")) {
            return (INetRequest) ipChange.ipc$dispatch("-1782326006", new Object[]{this, str, map, Boolean.valueOf(z)});
        }
        return null;
    }

    @Override // com.youku.live.dsl.network.INetClient
    public INetRequest createRequestWithMTop(String str, String str2, Map<String, String> map, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1481786396") ? (INetRequest) ipChange.ipc$dispatch("-1481786396", new Object[]{this, str, str2, map, Boolean.valueOf(z), Boolean.valueOf(z2)}) : new INetRequestMtopImp(str, str2, map, z, z2);
    }

    @Override // com.youku.live.dsl.network.INetClient
    public String getMtopId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1228193327") ? (String) ipChange.ipc$dispatch("1228193327", new Object[]{this}) : NetConstants.YOUKU_MTOP_INSTANCE_ID;
    }
}
