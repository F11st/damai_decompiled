package com.alipay.android.phone.mobilesdk.socketcraft;

import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidHandshakeException;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.FramedataImpl1;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ClientHandshake;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.HandshakeImpl1Server;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ServerHandshake;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ServerHandshakeBuilder;
import java.net.InetSocketAddress;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class WebSocketAdapter implements WebSocketListener {
    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public String getFlashPolicy(WebSocket webSocket) {
        InetSocketAddress localSocketAddress = webSocket.getLocalSocketAddress();
        if (localSocketAddress != null) {
            StringBuffer stringBuffer = new StringBuffer(90);
            stringBuffer.append("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
            stringBuffer.append(localSocketAddress.getPort());
            stringBuffer.append("\" /></cross-domain-policy>\u0000");
            return stringBuffer.toString();
        }
        throw new InvalidHandshakeException("socket not bound");
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public void onWebsocketHandshakeReceivedAsClient(WebSocket webSocket, ClientHandshake clientHandshake, ServerHandshake serverHandshake) {
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public ServerHandshakeBuilder onWebsocketHandshakeReceivedAsServer(WebSocket webSocket, Draft draft, ClientHandshake clientHandshake) {
        return new HandshakeImpl1Server();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public void onWebsocketHandshakeSentAsClient(WebSocket webSocket, ClientHandshake clientHandshake) {
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public void onWebsocketMessageFragment(WebSocket webSocket, Framedata framedata) {
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public void onWebsocketPing(WebSocket webSocket, Framedata framedata) {
        FramedataImpl1 framedataImpl1 = new FramedataImpl1(framedata);
        framedataImpl1.setOptcode(Framedata.Opcode.PONG);
        webSocket.sendFrame(framedataImpl1);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public void onWebsocketPong(WebSocket webSocket, Framedata framedata) {
    }
}
