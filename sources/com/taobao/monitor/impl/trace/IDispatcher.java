package com.taobao.monitor.impl.trace;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IDispatcher<LISTENER> {
    void addListener(LISTENER listener);

    void removeListener(LISTENER listener);
}
