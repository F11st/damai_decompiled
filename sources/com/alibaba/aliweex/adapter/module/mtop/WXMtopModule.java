package com.alibaba.aliweex.adapter.module.mtop;

import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.common.WXModule;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXMtopModule extends WXModule implements Destroyable {

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public enum MTOP_VERSION {
        V1,
        V2
    }

    public void destroy() {
    }

    @JSMethod
    public void request(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        new WXMtopRequest(MTOP_VERSION.V2).r(this.mWXSDKInstance.getInstanceId()).p(this.mWXSDKInstance.getContext(), jSONObject, jSCallback, jSCallback2);
    }

    @JSMethod
    public void send(String str, JSCallback jSCallback) {
        new WXMtopRequest(MTOP_VERSION.V1).r(this.mWXSDKInstance.getInstanceId()).q(this.mWXSDKInstance.getContext(), str, jSCallback, null);
    }
}
