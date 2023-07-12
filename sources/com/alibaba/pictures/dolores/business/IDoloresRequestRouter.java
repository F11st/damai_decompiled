package com.alibaba.pictures.dolores.business;

import com.alibaba.pictures.dolores.DoloresKernel;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J.\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J.\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/alibaba/pictures/dolores/business/IDoloresRequestRouter;", "", "BizResponse", "Lcom/alibaba/pictures/dolores/DoloresKernel;", "doloresKernel", "", "syncTime", "Lcom/alibaba/pictures/dolores/business/Result;", "onSyncRequestIntercept", "Lcom/alibaba/pictures/dolores/business/AsyncResult;", "onAsyncRequestIntercept", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface IDoloresRequestRouter {
    @Nullable
    <BizResponse> AsyncResult<BizResponse> onAsyncRequestIntercept(@Nullable DoloresKernel<BizResponse> doloresKernel, boolean z);

    @Nullable
    <BizResponse> Result<BizResponse> onSyncRequestIntercept(@Nullable DoloresKernel<BizResponse> doloresKernel, boolean z);
}
