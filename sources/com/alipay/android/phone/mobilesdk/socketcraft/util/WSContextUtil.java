package com.alipay.android.phone.mobilesdk.socketcraft.util;

import com.alipay.android.phone.mobilesdk.socketcraft.api.BasicWebSocketContext;
import com.alipay.android.phone.mobilesdk.socketcraft.api.WSContextConstant;
import com.alipay.android.phone.mobilesdk.socketcraft.api.WebSocketContext;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WSContextUtil {
    public static final WebSocketContext getInnerWebSocketContext(WebSocketContext webSocketContext) {
        if (webSocketContext != null) {
            Object attribute = webSocketContext.getAttribute(WSContextConstant.INNER_WS_CONTEXT);
            if (attribute != null && (attribute instanceof WebSocketContext)) {
                return (WebSocketContext) attribute;
            }
            synchronized (WSContextUtil.class) {
                Object attribute2 = webSocketContext.getAttribute(WSContextConstant.INNER_WS_CONTEXT);
                if (attribute2 != null && (attribute2 instanceof WebSocketContext)) {
                    return (WebSocketContext) attribute2;
                }
                BasicWebSocketContext basicWebSocketContext = new BasicWebSocketContext();
                webSocketContext.setAttribute(WSContextConstant.INNER_WS_CONTEXT, basicWebSocketContext);
                return basicWebSocketContext;
            }
        }
        throw new IllegalArgumentException("webSocketContext parameter can't null");
    }
}
