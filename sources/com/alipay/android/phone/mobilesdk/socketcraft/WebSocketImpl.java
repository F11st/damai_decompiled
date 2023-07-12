package com.alipay.android.phone.mobilesdk.socketcraft;

import com.alipay.android.phone.mobilesdk.socketcraft.WebSocket;
import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft;
import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft_10;
import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft_17;
import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft_75;
import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft_76;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.IncompleteHandshakeException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidDataException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidHandshakeException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.WebsocketNotConnectedException;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.CloseFrame;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.CloseFrameBuilder;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ClientHandshake;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ClientHandshakeBuilder;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.Handshakedata;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatUtil;
import com.alipay.android.phone.mobilesdk.socketcraft.util.Charsetfunctions;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class WebSocketImpl implements WebSocket {
    public static boolean DEBUG = true;
    public static int RCVBUF = 16384;
    public static final String TAG = "WebSocketImpl";
    public static final List<Draft> defaultdraftlist;
    private volatile boolean a;
    private WebSocket.READYSTATE b;
    private final WebSocketListener c;
    public ByteChannel channel;
    private List<Draft> d;
    private Draft e;
    private WebSocket.Role f;
    private Framedata.Opcode g;
    private ByteBuffer h;
    private ClientHandshake i;
    public final BlockingQueue<ByteBuffer> inQueue;
    private String j;
    private Integer k;
    public SelectionKey key;
    private Boolean l;
    private String m;
    public final BlockingQueue<ByteBuffer> outQueue;

    static {
        ArrayList arrayList = new ArrayList(4);
        defaultdraftlist = arrayList;
        arrayList.add(new Draft_17());
        arrayList.add(new Draft_10());
        arrayList.add(new Draft_76());
        arrayList.add(new Draft_75());
    }

    public WebSocketImpl(WebSocketListener webSocketListener, List<Draft> list) {
        this(webSocketListener, (Draft) null);
        this.f = WebSocket.Role.SERVER;
        if (list != null && !list.isEmpty()) {
            this.d = list;
        } else {
            this.d = defaultdraftlist;
        }
    }

    private void a(int i, String str, boolean z) {
        WebSocket.READYSTATE readystate = this.b;
        WebSocket.READYSTATE readystate2 = WebSocket.READYSTATE.CLOSING;
        if (readystate == readystate2 || readystate == WebSocket.READYSTATE.CLOSED) {
            return;
        }
        if (readystate == WebSocket.READYSTATE.OPEN) {
            if (i == 1006) {
                this.b = readystate2;
                f(i, str, false);
                return;
            }
            if (this.e.getCloseHandshakeType() != Draft.CloseHandshakeType.NONE) {
                try {
                    if (!z) {
                        try {
                            this.c.onWebsocketCloseInitiated(this, i, str);
                        } catch (RuntimeException e) {
                            this.c.onWebsocketError(this, e);
                        }
                    }
                    sendFrame(new CloseFrameBuilder(i, str));
                } catch (InvalidDataException e2) {
                    this.c.onWebsocketError(this, e2);
                    f(1006, "generated frame is invalid", false);
                }
            }
            f(i, str, z);
        } else if (i == -3) {
            f(-3, str, true);
        } else {
            f(-1, str, false);
        }
        if (i == 1002) {
            f(i, str, z);
        }
        this.b = WebSocket.READYSTATE.CLOSING;
        this.h = null;
    }

    private void d(ByteBuffer byteBuffer) {
        try {
        } catch (InvalidDataException e) {
            this.c.onWebsocketError(this, e);
            close(e);
            return;
        }
        for (Framedata framedata : this.e.translateFrame(byteBuffer)) {
            if (DEBUG) {
                SCLogCatUtil.debug(TAG, "matched frame: " + framedata);
            }
            Framedata.Opcode opcode = framedata.getOpcode();
            boolean isFin = framedata.isFin();
            if (opcode == Framedata.Opcode.CLOSING) {
                int i = 1005;
                String str = "";
                if (framedata instanceof CloseFrame) {
                    CloseFrame closeFrame = (CloseFrame) framedata;
                    i = closeFrame.getCloseCode();
                    str = closeFrame.getMessage();
                }
                if (this.b == WebSocket.READYSTATE.CLOSING) {
                    b(i, str, true);
                } else if (this.e.getCloseHandshakeType() == Draft.CloseHandshakeType.TWOWAY) {
                    a(i, str, true);
                } else {
                    f(i, str, false);
                }
            } else if (opcode == Framedata.Opcode.PING) {
                this.c.onWebsocketPing(this, framedata);
            } else if (opcode == Framedata.Opcode.PONG) {
                this.c.onWebsocketPong(this, framedata);
            } else {
                if (isFin && opcode != Framedata.Opcode.CONTINUOUS) {
                    if (this.g == null) {
                        if (opcode == Framedata.Opcode.TEXT) {
                            try {
                                this.c.onWebsocketMessage(this, Charsetfunctions.stringUtf8(framedata.getPayloadData()));
                            } catch (RuntimeException e2) {
                                this.c.onWebsocketError(this, e2);
                            }
                        } else if (opcode == Framedata.Opcode.BINARY) {
                            try {
                                this.c.onWebsocketMessage(this, framedata.getPayloadData());
                            } catch (RuntimeException e3) {
                                this.c.onWebsocketError(this, e3);
                            }
                        } else {
                            throw new InvalidDataException(1002, "non control or continious frame expected");
                        }
                        this.c.onWebsocketError(this, e);
                        close(e);
                        return;
                    }
                    throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
                }
                if (opcode != Framedata.Opcode.CONTINUOUS) {
                    if (this.g == null) {
                        this.g = opcode;
                    } else {
                        throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                    }
                } else if (isFin) {
                    if (this.g != null) {
                        this.g = null;
                    } else {
                        throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                    }
                } else if (this.g == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                try {
                    this.c.onWebsocketMessageFragment(this, framedata);
                } catch (RuntimeException e4) {
                    this.c.onWebsocketError(this, e4);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean e(java.nio.ByteBuffer r12) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.android.phone.mobilesdk.socketcraft.WebSocketImpl.e(java.nio.ByteBuffer):boolean");
    }

    private Draft.HandshakeState g(ByteBuffer byteBuffer) {
        byteBuffer.mark();
        int limit = byteBuffer.limit();
        byte[] bArr = Draft.FLASH_POLICY_REQUEST;
        if (limit > bArr.length) {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        if (byteBuffer.limit() >= bArr.length) {
            int i = 0;
            while (byteBuffer.hasRemaining()) {
                if (Draft.FLASH_POLICY_REQUEST[i] != byteBuffer.get()) {
                    byteBuffer.reset();
                    return Draft.HandshakeState.NOT_MATCHED;
                }
                i++;
            }
            return Draft.HandshakeState.MATCHED;
        }
        throw new IncompleteHandshakeException(bArr.length);
    }

    private void h(Handshakedata handshakedata) {
        if (DEBUG) {
            SCLogCatUtil.debug(TAG, "open using draft: " + this.e.getClass().getSimpleName());
        }
        this.b = WebSocket.READYSTATE.OPEN;
        try {
            this.c.onWebsocketOpen(this, handshakedata);
        } catch (RuntimeException e) {
            this.c.onWebsocketError(this, e);
        }
    }

    private void i(Collection<Framedata> collection) {
        if (isOpen()) {
            for (Framedata framedata : collection) {
                sendFrame(framedata);
            }
            return;
        }
        throw new WebsocketNotConnectedException();
    }

    private void j(ByteBuffer byteBuffer) {
        if (DEBUG) {
            StringBuilder sb = new StringBuilder("write(");
            sb.append(byteBuffer.remaining());
            sb.append("): {");
            sb.append(byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array()));
            sb.append("}");
            SCLogCatUtil.debug(TAG, sb.toString());
        }
        this.outQueue.add(byteBuffer);
        this.c.onWriteDemand(this);
    }

    private void k(List<ByteBuffer> list) {
        for (ByteBuffer byteBuffer : list) {
            j(byteBuffer);
        }
    }

    protected synchronized void b(int i, String str, boolean z) {
        if (this.b == WebSocket.READYSTATE.CLOSED) {
            return;
        }
        SelectionKey selectionKey = this.key;
        if (selectionKey != null) {
            selectionKey.cancel();
        }
        ByteChannel byteChannel = this.channel;
        if (byteChannel != null) {
            try {
                byteChannel.close();
            } catch (IOException e) {
                this.c.onWebsocketError(this, e);
            }
        }
        try {
            this.c.onWebsocketClose(this, i, str, z);
        } catch (RuntimeException e2) {
            this.c.onWebsocketError(this, e2);
        }
        Draft draft = this.e;
        if (draft != null) {
            draft.reset();
        }
        this.i = null;
        this.b = WebSocket.READYSTATE.CLOSED;
        this.outQueue.clear();
    }

    protected void c(int i, boolean z) {
        b(i, "", z);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void close(int i, String str) {
        a(i, str, false);
    }

    public void closeConnection() {
        if (this.l != null) {
            b(this.k.intValue(), this.j, this.l.booleanValue());
            return;
        }
        throw new IllegalStateException("this method must be used in conjuction with flushAndClose");
    }

    public void decode(ByteBuffer byteBuffer) {
        if (DEBUG) {
            StringBuilder sb = new StringBuilder("process(");
            sb.append(byteBuffer.remaining());
            sb.append("): {");
            sb.append(byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining()));
            sb.append("}");
            SCLogCatUtil.debug(TAG, sb.toString());
        }
        if (this.b != WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            d(byteBuffer);
        } else if (e(byteBuffer)) {
            if (byteBuffer.hasRemaining()) {
                d(byteBuffer);
            } else if (this.h.hasRemaining()) {
                d(this.h);
            }
        }
    }

    public void eot() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            c(-1, true);
        } else if (this.a) {
            b(this.k.intValue(), this.j, this.l.booleanValue());
        } else if (this.e.getCloseHandshakeType() == Draft.CloseHandshakeType.NONE) {
            c(1000, true);
        } else if (this.e.getCloseHandshakeType() == Draft.CloseHandshakeType.ONEWAY && this.f != WebSocket.Role.SERVER) {
            c(1000, true);
        } else {
            c(1006, true);
        }
    }

    protected synchronized void f(int i, String str, boolean z) {
        if (this.a) {
            return;
        }
        this.k = Integer.valueOf(i);
        this.j = str;
        this.l = Boolean.valueOf(z);
        this.a = true;
        this.c.onWriteDemand(this);
        try {
            this.c.onWebsocketClosing(this, i, str, z);
        } catch (RuntimeException e) {
            this.c.onWebsocketError(this, e);
        }
        Draft draft = this.e;
        if (draft != null) {
            draft.reset();
        }
        this.i = null;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public Draft getDraft() {
        return this.e;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public InetSocketAddress getLocalSocketAddress() {
        return this.c.getLocalSocketAddress(this);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public WebSocket.READYSTATE getReadyState() {
        return this.b;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public InetSocketAddress getRemoteSocketAddress() {
        return this.c.getRemoteSocketAddress(this);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public String getResourceDescriptor() {
        return this.m;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean hasBufferedData() {
        return !this.outQueue.isEmpty();
    }

    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean isClosed() {
        return this.b == WebSocket.READYSTATE.CLOSED;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean isClosing() {
        return this.b == WebSocket.READYSTATE.CLOSING;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean isConnecting() {
        return this.b == WebSocket.READYSTATE.CONNECTING;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean isFlushAndClose() {
        return this.a;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean isOpen() {
        return this.b == WebSocket.READYSTATE.OPEN;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void send(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        i(this.e.createFrames(str, this.f == WebSocket.Role.CLIENT));
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void sendFragmentedFrame(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        i(this.e.continuousFrame(opcode, byteBuffer, z));
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void sendFrame(Framedata framedata) {
        if (DEBUG) {
            SCLogCatUtil.debug(TAG, "send frame: " + framedata);
        }
        j(this.e.createBinaryFrame(framedata));
    }

    public void startHandshake(ClientHandshakeBuilder clientHandshakeBuilder) {
        this.i = this.e.postProcessHandshakeRequestAsClient(clientHandshakeBuilder);
        this.m = clientHandshakeBuilder.getResourceDescriptor();
        try {
            this.c.onWebsocketHandshakeSentAsClient(this, this.i);
            k(this.e.createHandshake(this.i, this.f));
        } catch (InvalidDataException unused) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        } catch (RuntimeException e) {
            this.c.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        }
    }

    public String toString() {
        return super.toString();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void close(int i) {
        a(i, "", false);
    }

    public void close(InvalidDataException invalidDataException) {
        a(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void send(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        i(this.e.createFrames(byteBuffer, this.f == WebSocket.Role.CLIENT));
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void close() {
        close(1000);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void closeConnection(int i, String str) {
        b(i, str, false);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void send(byte[] bArr) {
        send(ByteBuffer.wrap(bArr));
    }

    public WebSocketImpl(WebSocketListener webSocketListener, Draft draft) {
        this.a = false;
        this.b = WebSocket.READYSTATE.NOT_YET_CONNECTED;
        this.e = null;
        this.g = null;
        this.h = ByteBuffer.allocate(0);
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        if (webSocketListener != null && (draft != null || this.f != WebSocket.Role.SERVER)) {
            this.outQueue = new LinkedBlockingQueue();
            this.inQueue = new LinkedBlockingQueue();
            this.c = webSocketListener;
            this.f = WebSocket.Role.CLIENT;
            if (draft != null) {
                this.e = draft.copyInstance();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("parameters must not be null");
    }

    @Deprecated
    public WebSocketImpl(WebSocketListener webSocketListener, Draft draft, Socket socket) {
        this(webSocketListener, draft);
    }

    @Deprecated
    public WebSocketImpl(WebSocketListener webSocketListener, List<Draft> list, Socket socket) {
        this(webSocketListener, list);
    }
}
