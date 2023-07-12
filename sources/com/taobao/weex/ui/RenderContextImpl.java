package com.taobao.weex.ui;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.dom.RenderContext;
import com.taobao.weex.ui.component.WXComponent;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class RenderContextImpl implements RenderContext {
    private Map<String, WXComponent> mRegistry = new ConcurrentHashMap();
    private WXSDKInstance mWXSDKInstance;

    public RenderContextImpl(WXSDKInstance wXSDKInstance) {
        this.mWXSDKInstance = wXSDKInstance;
    }

    public void destroy() {
        this.mWXSDKInstance = null;
        try {
            this.mRegistry.clear();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.taobao.weex.dom.RenderContext
    public WXComponent getComponent(String str) {
        return this.mRegistry.get(str);
    }

    public int getComponentCount() {
        return this.mRegistry.size();
    }

    @Override // com.taobao.weex.dom.RenderContext
    public WXSDKInstance getInstance() {
        return this.mWXSDKInstance;
    }

    public WXSDKInstance getWXSDKInstance() {
        return this.mWXSDKInstance;
    }

    public void registerComponent(String str, WXComponent wXComponent) {
        this.mRegistry.put(str, wXComponent);
    }

    @Override // com.taobao.weex.dom.RenderContext
    public WXComponent unregisterComponent(String str) {
        return this.mRegistry.remove(str);
    }
}
