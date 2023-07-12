package com.taobao.weex.bridge;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface WXReactorPlugin {
    WXReactorPage createPage(long j, String str);

    String getPluginName();

    String getSoLibName();

    boolean isSkipFrameworkInit();
}
