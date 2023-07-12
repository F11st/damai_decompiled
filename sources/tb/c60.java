package tb;

import android.util.Log;
import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata;
import com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.IResponseDispatcher;
import com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.ResponseDelivery;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class c60 implements IResponseDispatcher {
    @Override // com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.IResponseDispatcher
    public void onConnectFailed(Throwable th, ResponseDelivery responseDelivery) {
        responseDelivery.onConnectFailed(th);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.IResponseDispatcher
    public void onConnected(ResponseDelivery responseDelivery) {
        responseDelivery.onConnected();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.IResponseDispatcher
    public void onDisconnect(ResponseDelivery responseDelivery) {
        if (responseDelivery != null) {
            responseDelivery.onDisconnect();
        } else {
            Log.e("DefaultResponseDispatch", "onDisconnect: ResponseDelivery is null");
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.IResponseDispatcher
    public void onMessage(String str, ResponseDelivery responseDelivery) {
        responseDelivery.onMessage(str, (String) null);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.IResponseDispatcher
    public void onPing(Framedata framedata, ResponseDelivery responseDelivery) {
        responseDelivery.onPing(framedata);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.IResponseDispatcher
    public void onPong(Framedata framedata, ResponseDelivery responseDelivery) {
        responseDelivery.onPong(framedata);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.IResponseDispatcher
    public void onSendDataError(gf0 gf0Var, ResponseDelivery responseDelivery) {
        responseDelivery.onSendDataError(gf0Var);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.IResponseDispatcher
    public void onMessage(ByteBuffer byteBuffer, ResponseDelivery responseDelivery) {
        responseDelivery.onMessage(byteBuffer, (ByteBuffer) null);
    }
}
