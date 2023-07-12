package tb;

import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata;
import com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.IResponseDispatcher;
import com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.ResponseDelivery;
import com.alibaba.gaiax.studio.third.socket.websocket.response.Response;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ns1 implements Response<Framedata> {
    private Framedata a;

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.response.Response
    /* renamed from: a */
    public Framedata getResponseData() {
        return this.a;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.response.Response
    /* renamed from: b */
    public void setResponseData(Framedata framedata) {
        this.a = framedata;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.response.Response
    public void onResponse(IResponseDispatcher iResponseDispatcher, ResponseDelivery responseDelivery) {
        iResponseDispatcher.onPing(this.a, responseDelivery);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.response.Response
    public void release() {
        this.a = null;
        q22.g(this);
    }

    public String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(hashCode());
        Framedata framedata = this.a;
        objArr[1] = framedata == null ? "null" : framedata.toString();
        return String.format("[@PingResponse%s->Framedata:%s]", objArr);
    }
}
