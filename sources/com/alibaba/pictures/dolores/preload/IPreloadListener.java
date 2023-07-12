package com.alibaba.pictures.dolores.preload;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tb.dc0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J \u0010\b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0019\u0010\n\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0007H&¨\u0006\r"}, d2 = {"Lcom/alibaba/pictures/dolores/preload/IPreloadListener;", "BizResponse", "", "Ltb/dc0;", "doloresResponse", "", "isRealRequestStart", "Ltb/wt2;", "onPreloadOver", "bizResponseType", "onHitCache", "(Ljava/lang/Object;)V", "onFail", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface IPreloadListener<BizResponse> {
    void onFail();

    void onHitCache(@Nullable BizResponse bizresponse);

    void onPreloadOver(@Nullable dc0<BizResponse> dc0Var, boolean z);
}
