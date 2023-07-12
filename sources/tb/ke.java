package tb;

import com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.IResponseDispatcher;
import com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.ResponseDelivery;
import com.alibaba.gaiax.studio.third.socket.websocket.response.Response;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ke implements Response<ByteBuffer> {
    private ByteBuffer a;

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.response.Response
    /* renamed from: a */
    public ByteBuffer getResponseData() {
        return this.a;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.response.Response
    /* renamed from: b */
    public void setResponseData(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.response.Response
    public void onResponse(IResponseDispatcher iResponseDispatcher, ResponseDelivery responseDelivery) {
        iResponseDispatcher.onMessage(this.a, responseDelivery);
        release();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.response.Response
    public void release() {
        q22.f(this);
    }

    public String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(hashCode());
        ByteBuffer byteBuffer = this.a;
        objArr[1] = byteBuffer == null ? "null" : byteBuffer.toString();
        return String.format("[@ByteBufferResponse%s->ByteBuffer:%s]", objArr);
    }
}
