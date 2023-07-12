package com.alibaba.gaiax.studio.third.socket.java_websocket;

import androidx.annotation.Keep;
import com.alibaba.gaiax.studio.third.socket.java_websocket.drafts.Draft;
import com.alibaba.gaiax.studio.third.socket.java_websocket.enums.Opcode;
import com.alibaba.gaiax.studio.third.socket.java_websocket.enums.ReadyState;
import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.Collection;

/* compiled from: Taobao */
@Keep
/* loaded from: classes6.dex */
public interface WebSocket {
    void close();

    void close(int i);

    void close(int i, String str);

    void closeConnection(int i, String str);

    <T> T getAttachment();

    Draft getDraft();

    InetSocketAddress getLocalSocketAddress();

    ReadyState getReadyState();

    InetSocketAddress getRemoteSocketAddress();

    String getResourceDescriptor();

    boolean hasBufferedData();

    boolean isClosed();

    boolean isClosing();

    boolean isFlushAndClose();

    boolean isOpen();

    void send(String str);

    void send(ByteBuffer byteBuffer);

    void send(byte[] bArr);

    void sendFragmentedFrame(Opcode opcode, ByteBuffer byteBuffer, boolean z);

    void sendFrame(Framedata framedata);

    void sendFrame(Collection<Framedata> collection);

    void sendPing();

    <T> void setAttachment(T t);
}
