package com.alibaba.pictures.dolores.transfer;

import com.alibaba.pictures.dolores.request.DoloresRequest;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/alibaba/pictures/dolores/transfer/IDataTransformerFactory;", "", "BizResponse", "Lcom/alibaba/pictures/dolores/request/DoloresRequest;", "request", "Lcom/alibaba/pictures/dolores/transfer/IRemoteDataTransformer;", "createDataTransformer", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface IDataTransformerFactory {
    @NotNull
    <BizResponse> IRemoteDataTransformer<BizResponse> createDataTransformer(@Nullable DoloresRequest<BizResponse> doloresRequest);
}
