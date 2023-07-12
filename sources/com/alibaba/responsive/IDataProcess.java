package com.alibaba.responsive;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface IDataProcess<T> {
    T getMappingConfig(T t);

    boolean isDisplayNumConfig(T t);

    boolean isFilterConfig(T t);

    boolean isMergeConfig(T t);
}
