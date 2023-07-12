package com.taobao.weex.common;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface WXJSEngineListener {
    void callback(boolean z, String str, String str2, String str3);

    void createInstanceFailed(String str);

    void createInstanceSuccess(String str);

    void destroyInstanceFailed(String str);

    void destroyInstanceSuccess(String str);

    void fireEvent(boolean z, String str, String str2, String str3);

    void initFramework(boolean z, String str, double d);
}
