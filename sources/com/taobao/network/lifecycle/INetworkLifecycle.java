package com.taobao.network.lifecycle;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface INetworkLifecycle {
    void onCancel(String str, Map<String, Object> map);

    void onError(String str, Map<String, Object> map);

    void onEvent(String str, String str2, Map<String, Object> map);

    void onFinished(String str, Map<String, Object> map);

    void onRequest(String str, String str2, Map<String, Object> map);

    void onValidRequest(String str, String str2, Map<String, Object> map);
}
