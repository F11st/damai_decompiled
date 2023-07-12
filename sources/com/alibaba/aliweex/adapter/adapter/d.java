package com.alibaba.aliweex.adapter.adapter;

import com.taobao.weex.appfram.websocket.IWebSocketAdapter;
import com.taobao.weex.appfram.websocket.IWebSocketAdapterFactory;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class d implements IWebSocketAdapterFactory {
    private boolean a() {
        return true;
    }

    @Override // com.taobao.weex.appfram.websocket.IWebSocketAdapterFactory
    public IWebSocketAdapter createWebSocketAdapter() {
        if (a()) {
            return new c();
        }
        return null;
    }
}
