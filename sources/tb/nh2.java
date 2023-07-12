package tb;

import android.text.TextUtils;
import com.alibaba.gaiax.studio.third.socket.java_websocket.client.WebSocketClient;
import com.alibaba.gaiax.studio.third.socket.websocket.request.Request;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class nh2 implements Request<String> {
    private String a;

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.request.Request
    /* renamed from: a */
    public String getRequestData() {
        return this.a;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.request.Request
    /* renamed from: b */
    public void setRequestData(String str) {
        this.a = str;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.request.Request
    public void release() {
        b22.b(this);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.request.Request
    public void send(WebSocketClient webSocketClient) {
        webSocketClient.send(this.a);
    }

    public String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = TextUtils.isEmpty(this.a) ? "null" : this.a;
        return String.format("@StringRequest%s,requestText:%s", objArr);
    }
}
