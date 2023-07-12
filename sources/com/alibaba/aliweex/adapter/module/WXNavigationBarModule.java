package com.alibaba.aliweex.adapter.module;

import android.view.Menu;
import com.alibaba.aliweex.AliWXSDKInstance;
import com.alibaba.aliweex.C3004a;
import com.alibaba.aliweex.adapter.INavigationBarModuleAdapter;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.utils.WXLogUtils;
import tb.kz2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXNavigationBarModule extends WXModule {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.adapter.module.WXNavigationBarModule$a */
    /* loaded from: classes15.dex */
    public static class C3048a {
        JSONObject a;
        JSCallback b;
        JSCallback c;

        public C3048a(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
            this.a = jSONObject;
            this.b = jSCallback;
            this.c = jSCallback2;
        }
    }

    private INavigationBarModuleAdapter getNavBarAdapter() {
        INavigationBarModuleAdapter n = C3004a.l().n();
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        return wXSDKInstance instanceof AliWXSDKInstance ? ((AliWXSDKInstance) wXSDKInstance).b() : n;
    }

    private JSONObject getResultData(kz2 kz2Var) {
        return new JSONObject();
    }

    private void notSupported(JSCallback jSCallback) {
        if (jSCallback == null) {
            WXLogUtils.e("WXNavigationBarModule", "notSupported -> failure callback is null");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", (Object) "WX_NOT_SUPPORTED");
        jSCallback.invoke(jSONObject);
    }

    private void setMenuItem(C3048a c3048a, boolean z) {
        getNavBarAdapter();
        if (c3048a != null) {
            notSupported(c3048a.c);
        }
    }

    @JSMethod
    public void appendMenu(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        getNavBarAdapter();
    }

    @JSMethod
    public void getHeight(JSCallback jSCallback) {
        getNavBarAdapter();
        notSupported(jSCallback);
    }

    @JSMethod
    public void getStatusBarHeight(JSCallback jSCallback) {
        getNavBarAdapter();
        notSupported(jSCallback);
    }

    @JSMethod
    public void hasMenu(Boolean bool, JSCallback jSCallback, JSCallback jSCallback2) {
        getNavBarAdapter();
        if (jSCallback2 != null) {
            notSupported(jSCallback2);
        }
    }

    @JSMethod
    public void hide(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        getNavBarAdapter();
        notSupported(jSCallback2);
    }

    @Override // com.taobao.weex.common.WXModule
    public boolean onCreateOptionsMenu(Menu menu) {
        getNavBarAdapter();
        return super.onCreateOptionsMenu(menu);
    }

    @JSMethod
    public void setBadgeStyle(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        getNavBarAdapter();
        notSupported(jSCallback2);
    }

    @JSMethod
    public void setLeftItem(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        setMenuItem(new C3048a(jSONObject, jSCallback, jSCallback2), true);
    }

    @JSMethod
    public void setRightItem(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        setMenuItem(new C3048a(jSONObject, jSCallback, jSCallback2), false);
    }

    @JSMethod
    public void setStyle(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        getNavBarAdapter();
        notSupported(jSCallback2);
    }

    @JSMethod
    public void setTitle(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        getNavBarAdapter();
        notSupported(jSCallback2);
    }

    @JSMethod
    public void setTransparent(Boolean bool, JSCallback jSCallback, JSCallback jSCallback2) {
        getNavBarAdapter();
        if (jSCallback2 != null) {
            notSupported(jSCallback2);
        }
    }

    @JSMethod
    public void show(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        getNavBarAdapter();
        notSupported(jSCallback2);
    }

    @JSMethod
    public void showMenu(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        getNavBarAdapter();
        notSupported(jSCallback2);
    }
}
