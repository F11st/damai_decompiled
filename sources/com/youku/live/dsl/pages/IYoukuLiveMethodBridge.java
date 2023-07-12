package com.youku.live.dsl.pages;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IYoukuLiveMethodBridge {
    void asyncMethod(String str, Map<String, Object> map, IYoukuLiveMethodCallback iYoukuLiveMethodCallback);

    Object syncMethod(String str, Map<String, Object> map);
}
