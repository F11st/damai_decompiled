package com.alibaba.pictures.piclocation.mtop;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k12;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&¨\u0006\u0007"}, d2 = {"Lcom/alibaba/pictures/piclocation/mtop/RegionRequestHandler;", "", "Ltb/k12;", "regionPicResponse", "Ltb/wt2;", "onRequestRegionDataSuccess", "onRequestRegionDataFailed", "location_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface RegionRequestHandler {
    void onRequestRegionDataFailed();

    void onRequestRegionDataSuccess(@NotNull k12 k12Var);
}
