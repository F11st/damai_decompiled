package com.youku.live.dsl.network;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class IRequestModelCallback<Model extends Serializable> implements IRequestCallback {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.network.IRequestCallback
    public void onCallback(IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1845290750")) {
            ipChange.ipc$dispatch("1845290750", new Object[]{this, iResponse});
        } else {
            onModelCallback((IResponseModel) iResponse);
        }
    }

    public abstract void onModelCallback(IResponseModel<Model> iResponseModel);
}
