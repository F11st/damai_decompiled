package com.alibaba.pictures.dolores.prefetch;

import android.os.Bundle;
import com.alibaba.pictures.dolores.prefetch.page.PrefetchPageMo;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.Nullable;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016RP\u0010\u0011\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\n¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/alibaba/pictures/dolores/prefetch/PrefetchRequestAction;", "Lcom/alibaba/pictures/dolores/prefetch/PrefetchRequestBuilder;", "", "Landroid/os/Bundle;", "bundle", "Lcom/alibaba/pictures/dolores/request/DoloresRequest;", "build", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lcom/alibaba/pictures/dolores/prefetch/page/PrefetchPageMo;", "pageConfig", "Ltb/wt2;", "getRequestAction", "()Lkotlin/jvm/functions/Function2;", "setRequestAction", "(Lkotlin/jvm/functions/Function2;)V", "requestAction", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface PrefetchRequestAction extends PrefetchRequestBuilder<Object> {
    @Override // com.alibaba.pictures.dolores.prefetch.PrefetchRequestBuilder
    @Nullable
    DoloresRequest<Object> build(@Nullable Bundle bundle);

    @Nullable
    Function2<Bundle, PrefetchPageMo, wt2> getRequestAction();

    void setRequestAction(@Nullable Function2<? super Bundle, ? super PrefetchPageMo, wt2> function2);
}
