package com.taobao.network.lifecycle;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IMtopLifecycle {
    void onMtopCancel(String str, Map<String, Object> map);

    void onMtopError(String str, Map<String, Object> map);

    void onMtopEvent(String str, String str2, Map<String, Object> map);

    void onMtopFinished(String str, Map<String, Object> map);

    void onMtopRequest(String str, String str2, Map<String, Object> map);
}
