package com.alibaba.pictures.bricks.base;

import com.alibaba.pictures.request.BaseRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DamaiBaseRequest<BizResponse> extends BaseRequest<BizResponse> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.alibaba.pictures.request.BaseRequest, com.alibaba.pictures.dolores.request.DoloresRequest
    @NotNull
    public String markRequestLabel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "151666165") ? (String) ipChange.ipc$dispatch("151666165", new Object[]{this}) : "damai";
    }
}
