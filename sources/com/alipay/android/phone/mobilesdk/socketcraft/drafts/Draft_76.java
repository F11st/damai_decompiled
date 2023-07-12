package com.alipay.android.phone.mobilesdk.socketcraft.drafts;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.alipay.android.phone.mobilesdk.socketcraft.WebSocket;
import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.IncompleteHandshakeException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidFrameException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidHandshakeException;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.CloseFrameBuilder;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ClientHandshake;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ClientHandshakeBuilder;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.HandshakeBuilder;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.Handshakedata;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ServerHandshake;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ServerHandshakeBuilder;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class Draft_76 extends Draft_75 {
    private static final byte[] i = {-1, 0};
    private boolean g = false;
    private final Random h = new Random();

    private static String c() {
        Random random = new Random();
        long nextInt = random.nextInt(12) + 1;
        String l = Long.toString((random.nextInt(Math.abs(new Long(4294967295L / nextInt).intValue())) + 1) * nextInt);
        int nextInt2 = random.nextInt(12) + 1;
        for (int i2 = 0; i2 < nextInt2; i2++) {
            int abs = Math.abs(random.nextInt(l.length()));
            char nextInt3 = (char) (random.nextInt(95) + 33);
            if (nextInt3 >= '0' && nextInt3 <= '9') {
                nextInt3 = (char) (nextInt3 - 15);
            }
            l = new StringBuilder(l).insert(abs, nextInt3).toString();
        }
        for (int i3 = 0; i3 < nextInt; i3++) {
            l = new StringBuilder(l).insert(Math.abs(random.nextInt(l.length() - 1) + 1), " ").toString();
        }
        return l;
    }

    public static byte[] createChallenge(String str, String str2, byte[] bArr) {
        byte[] d = d(str);
        byte[] d2 = d(str2);
        try {
            return MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(new byte[]{d[0], d[1], d[2], d[3], d2[0], d2[1], d2[2], d2[3], bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7]});
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] d(String str) {
        try {
            long parseLong = Long.parseLong(str.replaceAll("[^0-9]", ""));
            long length = str.split(" ").length - 1;
            if (length != 0) {
                long longValue = new Long(parseLong / length).longValue();
                return new byte[]{(byte) (longValue >> 24), (byte) ((longValue << 8) >> 24), (byte) ((longValue << 16) >> 24), (byte) ((longValue << 24) >> 24)};
            }
            throw new InvalidHandshakeException("invalid Sec-WebSocket-Key (/key2/)");
        } catch (NumberFormatException unused) {
            throw new InvalidHandshakeException("invalid Sec-WebSocket-Key (/key1/ or /key2/)");
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft_75, com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public Draft.HandshakeState acceptHandshakeAsClient(ClientHandshake clientHandshake, ServerHandshake serverHandshake) {
        if (this.g) {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        try {
            if (serverHandshake.getFieldValue("Sec-WebSocket-Origin").equals(clientHandshake.getFieldValue("Origin")) && a(serverHandshake)) {
                byte[] content = serverHandshake.getContent();
                if (content != null && content.length != 0) {
                    if (Arrays.equals(content, createChallenge(clientHandshake.getFieldValue("Sec-WebSocket-Key1"), clientHandshake.getFieldValue("Sec-WebSocket-Key2"), clientHandshake.getContent()))) {
                        return Draft.HandshakeState.MATCHED;
                    }
                    return Draft.HandshakeState.NOT_MATCHED;
                }
                throw new IncompleteHandshakeException();
            }
            return Draft.HandshakeState.NOT_MATCHED;
        } catch (InvalidHandshakeException e) {
            throw new RuntimeException("bad handshakerequest", e);
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft_75, com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public Draft.HandshakeState acceptHandshakeAsServer(ClientHandshake clientHandshake) {
        if (clientHandshake.getFieldValue("Upgrade").equals("WebSocket") && clientHandshake.getFieldValue(IRequestConst.CONNECTION).contains("Upgrade") && clientHandshake.getFieldValue("Sec-WebSocket-Key1").length() > 0 && !clientHandshake.getFieldValue("Sec-WebSocket-Key2").isEmpty() && clientHandshake.hasFieldValue("Origin")) {
            return Draft.HandshakeState.MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft_75, com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public Draft copyInstance() {
        return new Draft_76();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft_75, com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public ByteBuffer createBinaryFrame(Framedata framedata) {
        if (framedata.getOpcode() == Framedata.Opcode.CLOSING) {
            return ByteBuffer.wrap(i);
        }
        return super.createBinaryFrame(framedata);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft_75, com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public Draft.CloseHandshakeType getCloseHandshakeType() {
        return Draft.CloseHandshakeType.ONEWAY;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft_75, com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder clientHandshakeBuilder) {
        clientHandshakeBuilder.put("Upgrade", "WebSocket");
        clientHandshakeBuilder.put(IRequestConst.CONNECTION, "Upgrade");
        clientHandshakeBuilder.put("Sec-WebSocket-Key1", c());
        clientHandshakeBuilder.put("Sec-WebSocket-Key2", c());
        if (!clientHandshakeBuilder.hasFieldValue("Origin")) {
            clientHandshakeBuilder.put("Origin", "random" + this.h.nextInt());
        }
        byte[] bArr = new byte[8];
        this.h.nextBytes(bArr);
        clientHandshakeBuilder.setContent(bArr);
        return clientHandshakeBuilder;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft_75, com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) {
        serverHandshakeBuilder.setHttpStatusMessage("WebSocket Protocol Handshake");
        serverHandshakeBuilder.put("Upgrade", "WebSocket");
        serverHandshakeBuilder.put(IRequestConst.CONNECTION, clientHandshake.getFieldValue(IRequestConst.CONNECTION));
        serverHandshakeBuilder.put("Sec-WebSocket-Origin", clientHandshake.getFieldValue("Origin"));
        serverHandshakeBuilder.put("Sec-WebSocket-Location", "ws://" + clientHandshake.getFieldValue(BizTime.HOST) + clientHandshake.getResourceDescriptor());
        String fieldValue = clientHandshake.getFieldValue("Sec-WebSocket-Key1");
        String fieldValue2 = clientHandshake.getFieldValue("Sec-WebSocket-Key2");
        byte[] content = clientHandshake.getContent();
        if (fieldValue != null && fieldValue2 != null && content != null && content.length == 8) {
            serverHandshakeBuilder.setContent(createChallenge(fieldValue, fieldValue2, content));
            return serverHandshakeBuilder;
        }
        throw new InvalidHandshakeException("Bad keys");
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft_75, com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public List<Framedata> translateFrame(ByteBuffer byteBuffer) {
        byteBuffer.mark();
        List<Framedata> b = super.b(byteBuffer);
        if (b == null) {
            byteBuffer.reset();
            List<Framedata> list = this.d;
            this.c = true;
            if (this.e == null) {
                this.e = ByteBuffer.allocate(2);
                if (byteBuffer.remaining() <= this.e.remaining()) {
                    this.e.put(byteBuffer);
                    if (!this.e.hasRemaining()) {
                        if (Arrays.equals(this.e.array(), i)) {
                            list.add(new CloseFrameBuilder(1000));
                            return list;
                        }
                        throw new InvalidFrameException();
                    }
                    this.d = new LinkedList();
                    return list;
                }
                throw new InvalidFrameException();
            }
            throw new InvalidFrameException();
        }
        return b;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public Handshakedata translateHandshake(ByteBuffer byteBuffer) {
        HandshakeBuilder translateHandshakeHttp = Draft.translateHandshakeHttp(byteBuffer, this.a);
        if ((translateHandshakeHttp.hasFieldValue("Sec-WebSocket-Key1") || this.a == WebSocket.Role.CLIENT) && !translateHandshakeHttp.hasFieldValue("Sec-WebSocket-Version")) {
            byte[] bArr = new byte[this.a == WebSocket.Role.SERVER ? 8 : 16];
            try {
                byteBuffer.get(bArr);
                translateHandshakeHttp.setContent(bArr);
            } catch (BufferUnderflowException unused) {
                throw new IncompleteHandshakeException(byteBuffer.capacity() + 16);
            }
        }
        return translateHandshakeHttp;
    }
}
