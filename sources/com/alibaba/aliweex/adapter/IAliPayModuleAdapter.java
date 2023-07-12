package com.alibaba.aliweex.adapter;

import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXSDKInstance;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface IAliPayModuleAdapter {
    void tradePay(WXSDKInstance wXSDKInstance, JSONObject jSONObject, ICallback iCallback);
}
