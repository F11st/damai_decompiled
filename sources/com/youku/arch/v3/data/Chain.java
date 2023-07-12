package com.youku.arch.v3.data;

import kotlin.Metadata;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H&R\u001c\u0010\t\u001a\u00028\u00008&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/youku/arch/v3/data/Chain;", "T", "", "Ltb/wt2;", "proceed", "getParam", "()Ljava/lang/Object;", "setParam", "(Ljava/lang/Object;)V", "param", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface Chain<T> {
    T getParam();

    void proceed();

    void setParam(T t);
}
