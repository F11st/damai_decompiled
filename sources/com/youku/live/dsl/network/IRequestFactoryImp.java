package com.youku.live.dsl.network;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IRequestFactoryImp implements IRequestFactory {
    private static transient /* synthetic */ IpChange $ipChange;
    private static IRequestFactory sInstance;

    public static IRequestFactory getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1514091947")) {
            return (IRequestFactory) ipChange.ipc$dispatch("1514091947", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (IRequestFactoryImp.class) {
                if (sInstance == null) {
                    sInstance = new IRequestFactoryImp();
                }
            }
        }
        return sInstance;
    }

    @Override // com.youku.live.dsl.network.IRequestFactory
    public IRequest createRequestWithMtop(String str, String str2, Map<String, String> map, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-344265640") ? (IRequest) ipChange.ipc$dispatch("-344265640", new Object[]{this, str, str2, map, Boolean.valueOf(z), Boolean.valueOf(z2)}) : new IMtopRequestImp(str, str2, map, z, z2);
    }
}
