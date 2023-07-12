package com.alibaba.pictures.dolores.business;

import com.ali.user.open.core.context.KernelContext;
import com.alibaba.pictures.dolores.DoloresKernel;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.dc0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005H&J,\u0010\n\u001a\u00020\t\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005H&J&\u0010\f\u001a\u00020\t\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H&J,\u0010\u000f\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rH&¨\u0006\u0010"}, d2 = {"Lcom/alibaba/pictures/dolores/business/IRequestInterceptor;", "", "T", "Lcom/alibaba/pictures/dolores/DoloresKernel;", KernelContext.TAG, "Lcom/alibaba/pictures/dolores/request/DoloresRequest;", "doloresRequest", "Ltb/wt2;", "onRequestConfig", "", "onPreRequest", "remoteResponse", "onPreProcessData", "Ltb/dc0;", "doloresResponse", "onAfterProcessData", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface IRequestInterceptor {
    <T> void onAfterProcessData(@NotNull DoloresKernel<T> doloresKernel, @Nullable dc0<T> dc0Var);

    <T> boolean onPreProcessData(@NotNull DoloresKernel<T> doloresKernel, @Nullable Object obj);

    <T> boolean onPreRequest(@NotNull DoloresKernel<T> doloresKernel, @Nullable DoloresRequest<T> doloresRequest);

    <T> void onRequestConfig(@NotNull DoloresKernel<T> doloresKernel, @Nullable DoloresRequest<T> doloresRequest);
}
