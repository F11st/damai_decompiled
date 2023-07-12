package com.taobao.weex.bridge;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface WXReactorPage {
    void fireEvent(String str, String str2, Map<String, String> map, String str3);

    void invokeCallBack(String str, String str2);

    void registerComponent();

    void render(String str, String str2);

    void setPageContext(long j);

    void unregisterJSContext();
}
