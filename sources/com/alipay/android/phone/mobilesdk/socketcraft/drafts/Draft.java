package com.alipay.android.phone.mobilesdk.socketcraft.drafts;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.alipay.android.phone.mobilesdk.socketcraft.WebSocket;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.IncompleteHandshakeException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidDataException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidHandshakeException;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.FramedataImpl1;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ClientHandshake;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ClientHandshakeBuilder;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.HandshakeBuilder;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.HandshakeImpl1Client;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.HandshakeImpl1Server;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.Handshakedata;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ServerHandshake;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ServerHandshakeBuilder;
import com.alipay.android.phone.mobilesdk.socketcraft.util.Charsetfunctions;
import com.taobao.login4android.constants.LoginConstants;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.commons.net.SocketClient;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public abstract class Draft {
    public static final byte[] FLASH_POLICY_REQUEST = Charsetfunctions.utf8Bytes("<policy-file-request/>\u0000");
    public static int INITIAL_FAMESIZE = 64;
    public static int MAX_FAME_SIZE = 1000;
    protected WebSocket.Role a = null;
    protected Framedata.Opcode b = null;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum CloseHandshakeType {
        NONE,
        ONEWAY,
        TWOWAY
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum HandshakeState {
        MATCHED,
        NOT_MATCHED
    }

    public static ByteBuffer readLine(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b = 48;
        while (byteBuffer.hasRemaining()) {
            byte b2 = byteBuffer.get();
            allocate.put(b2);
            if (b == 13 && b2 == 10) {
                allocate.limit(allocate.position() - 2);
                allocate.position(0);
                return allocate;
            }
            b = b2;
        }
        byteBuffer.position(byteBuffer.position() - allocate.position());
        return null;
    }

    public static String readStringLine(ByteBuffer byteBuffer) {
        ByteBuffer readLine = readLine(byteBuffer);
        if (readLine == null) {
            return null;
        }
        return Charsetfunctions.stringAscii(readLine.array(), 0, readLine.limit());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v5, types: [com.alipay.android.phone.mobilesdk.socketcraft.handshake.HandshakeImpl1Server, com.alipay.android.phone.mobilesdk.socketcraft.handshake.ServerHandshakeBuilder] */
    public static HandshakeBuilder translateHandshakeHttp(ByteBuffer byteBuffer, WebSocket.Role role) {
        HandshakeImpl1Client handshakeImpl1Client;
        String readStringLine;
        String readStringLine2 = readStringLine(byteBuffer);
        if (readStringLine2 != null) {
            String[] split = readStringLine2.split(" ", 3);
            if (split.length == 3) {
                if (role == WebSocket.Role.CLIENT) {
                    ?? handshakeImpl1Server = new HandshakeImpl1Server();
                    handshakeImpl1Server.setHttpStatus(Short.parseShort(split[1]));
                    handshakeImpl1Server.setHttpStatusMessage(split[2]);
                    handshakeImpl1Client = handshakeImpl1Server;
                } else {
                    HandshakeImpl1Client handshakeImpl1Client2 = new HandshakeImpl1Client();
                    handshakeImpl1Client2.setResourceDescriptor(split[1]);
                    handshakeImpl1Client = handshakeImpl1Client2;
                }
                while (true) {
                    readStringLine = readStringLine(byteBuffer);
                    if (readStringLine == null || readStringLine.length() <= 0) {
                        break;
                    }
                    String[] split2 = readStringLine.split(":", 2);
                    if (split2.length == 2) {
                        handshakeImpl1Client.put(split2[0], split2[1].replaceFirst("^ +", ""));
                    } else {
                        throw new InvalidHandshakeException("not an http header");
                    }
                }
                if (readStringLine != null) {
                    return handshakeImpl1Client;
                }
                throw new IncompleteHandshakeException();
            }
            throw new InvalidHandshakeException();
        }
        throw new IncompleteHandshakeException(byteBuffer.capacity() + 128);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(Handshakedata handshakedata) {
        return handshakedata.getFieldValue("Upgrade").equalsIgnoreCase("websocket") && handshakedata.getFieldValue(IRequestConst.CONNECTION).toLowerCase(Locale.ENGLISH).contains(LoginConstants.LOGIN_UPGRADE);
    }

    public abstract HandshakeState acceptHandshakeAsClient(ClientHandshake clientHandshake, ServerHandshake serverHandshake);

    public abstract HandshakeState acceptHandshakeAsServer(ClientHandshake clientHandshake);

    public int checkAlloc(int i) {
        if (i >= 0) {
            return i;
        }
        throw new InvalidDataException(1002, "Negative count");
    }

    public List<Framedata> continuousFrame(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        Framedata.Opcode opcode2;
        if (opcode != Framedata.Opcode.BINARY && opcode != (opcode2 = Framedata.Opcode.TEXT) && opcode != opcode2) {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
        if (this.b != null) {
            this.b = Framedata.Opcode.CONTINUOUS;
        } else {
            this.b = opcode;
        }
        FramedataImpl1 framedataImpl1 = new FramedataImpl1(this.b);
        try {
            framedataImpl1.setPayload(byteBuffer);
            framedataImpl1.setFin(z);
            if (z) {
                this.b = null;
            } else {
                this.b = opcode;
            }
            return Collections.singletonList(framedataImpl1);
        } catch (InvalidDataException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract Draft copyInstance();

    public abstract ByteBuffer createBinaryFrame(Framedata framedata);

    public abstract List<Framedata> createFrames(String str, boolean z);

    public abstract List<Framedata> createFrames(ByteBuffer byteBuffer, boolean z);

    public List<ByteBuffer> createHandshake(Handshakedata handshakedata, WebSocket.Role role) {
        return createHandshake(handshakedata, role, true);
    }

    public abstract CloseHandshakeType getCloseHandshakeType();

    public WebSocket.Role getRole() {
        return this.a;
    }

    public abstract ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder clientHandshakeBuilder);

    public abstract HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder);

    public abstract void reset();

    public void setParseMode(WebSocket.Role role) {
        this.a = role;
    }

    public abstract List<Framedata> translateFrame(ByteBuffer byteBuffer);

    public Handshakedata translateHandshake(ByteBuffer byteBuffer) {
        return translateHandshakeHttp(byteBuffer, this.a);
    }

    public List<ByteBuffer> createHandshake(Handshakedata handshakedata, WebSocket.Role role, boolean z) {
        StringBuilder sb = new StringBuilder(100);
        if (handshakedata instanceof ClientHandshake) {
            sb.append("GET ");
            sb.append(((ClientHandshake) handshakedata).getResourceDescriptor());
            sb.append(" HTTP/1.1");
        } else if (handshakedata instanceof ServerHandshake) {
            sb.append("HTTP/1.1 101 " + ((ServerHandshake) handshakedata).getHttpStatusMessage());
        } else {
            throw new RuntimeException("unknow role");
        }
        sb.append(SocketClient.NETASCII_EOL);
        Iterator<String> iterateHttpFields = handshakedata.iterateHttpFields();
        while (iterateHttpFields.hasNext()) {
            String next = iterateHttpFields.next();
            String fieldValue = handshakedata.getFieldValue(next);
            sb.append(next);
            sb.append(": ");
            sb.append(fieldValue);
            sb.append(SocketClient.NETASCII_EOL);
        }
        sb.append(SocketClient.NETASCII_EOL);
        byte[] asciiBytes = Charsetfunctions.asciiBytes(sb.toString());
        byte[] content = z ? handshakedata.getContent() : null;
        ByteBuffer allocate = ByteBuffer.allocate((content == null ? 0 : content.length) + asciiBytes.length);
        allocate.put(asciiBytes);
        if (content != null) {
            allocate.put(content);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }
}
