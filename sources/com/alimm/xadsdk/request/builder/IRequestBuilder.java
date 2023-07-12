package com.alimm.xadsdk.request.builder;

import androidx.annotation.NonNull;
import com.alimm.xadsdk.base.net.AdNetwork;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IRequestBuilder extends IRequestConst {
    AdNetwork buildRequest(@NonNull RequestInfo requestInfo, boolean z);
}
