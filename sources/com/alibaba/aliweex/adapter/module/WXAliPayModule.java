package com.alibaba.aliweex.adapter.module;

import com.alibaba.aliweex.adapter.IAliPayModuleAdapter;
import com.alibaba.aliweex.adapter.ICallback;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXAliPayModule extends WXModule {

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    class a implements ICallback {
        final /* synthetic */ JSCallback a;
        final /* synthetic */ JSCallback b;

        a(WXAliPayModule wXAliPayModule, JSCallback jSCallback, JSCallback jSCallback2) {
            this.a = jSCallback;
            this.b = jSCallback2;
        }

        @Override // com.alibaba.aliweex.adapter.ICallback
        public void failure(JSONObject jSONObject) {
            this.b.invoke(jSONObject);
        }

        @Override // com.alibaba.aliweex.adapter.ICallback
        public void success(JSONObject jSONObject) {
            this.a.invoke(jSONObject);
        }
    }

    private void notSupported(JSCallback jSCallback) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", (Object) "WX_NOT_SUPPORTED");
        jSCallback.invoke(jSONObject);
    }

    @JSMethod
    public void tradePay(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        IAliPayModuleAdapter a2 = com.alibaba.aliweex.a.l().a();
        if (a2 != null) {
            a2.tradePay(this.mWXSDKInstance, jSONObject, new a(this, jSCallback, jSCallback2));
        } else {
            notSupported(jSCallback2);
        }
    }
}
