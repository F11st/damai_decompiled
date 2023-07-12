package com.alibaba.wireless.security.framework;

import com.alibaba.wireless.security.open.SecException;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface ISGPluginManager {
    <T> T getInterface(Class<T> cls) throws SecException;

    String getMainPluginName();

    ISGPluginInfo getPluginInfo(String str) throws SecException;

    IRouterComponent getRouter();
}
