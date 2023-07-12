package com.taobao.monitor.performance;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IApmAdapterFactory {
    IWXApmAdapter createApmAdapter();

    IWXApmAdapter createApmAdapterByType(String str);
}
