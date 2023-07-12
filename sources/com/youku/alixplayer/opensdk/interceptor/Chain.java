package com.youku.alixplayer.opensdk.interceptor;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface Chain<T> {
    int getAction();

    T getParam();

    void proceed();

    void setParam(T t);
}
