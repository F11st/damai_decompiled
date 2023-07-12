package com.alibaba.gaiax.studio.third.socket.java_websocket.drafts;

import android.util.Log;
import androidx.annotation.Keep;
import com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketImpl;
import com.alibaba.gaiax.studio.third.socket.java_websocket.enums.CloseHandshakeType;
import com.alibaba.gaiax.studio.third.socket.java_websocket.enums.HandshakeState;
import com.alibaba.gaiax.studio.third.socket.java_websocket.enums.Opcode;
import com.alibaba.gaiax.studio.third.socket.java_websocket.enums.ReadyState;
import com.alibaba.gaiax.studio.third.socket.java_websocket.enums.Role;
import com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions.IncompleteException;
import com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions.InvalidDataException;
import com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions.InvalidFrameException;
import com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions.InvalidHandshakeException;
import com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions.LimitExceededException;
import com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions.NotSendableException;
import com.alibaba.gaiax.studio.third.socket.java_websocket.extensions.DefaultExtension;
import com.alibaba.gaiax.studio.third.socket.java_websocket.extensions.IExtension;
import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.BinaryFrame;
import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.CloseFrame;
import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata;
import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.FramedataImpl1;
import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.TextFrame;
import com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.ClientHandshake;
import com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.ClientHandshakeBuilder;
import com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.HandshakeBuilder;
import com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.ServerHandshake;
import com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.ServerHandshakeBuilder;
import com.alibaba.gaiax.studio.third.socket.java_websocket.protocols.IProtocol;
import com.alibaba.gaiax.studio.third.socket.java_websocket.protocols.Protocol;
import com.alibaba.gaiax.studio.third.socket.java_websocket.util.Base64;
import com.alibaba.gaiax.studio.third.socket.java_websocket.util.Charsetfunctions;
import com.alipay.android.phone.mobilesdk.socketcraft.util.WsMessageConstants;
import com.google.common.primitives.SignedBytes;
import com.squareup.okhttp.internal.ws.WebSocketProtocol;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import mtopsdk.common.util.HttpHeaderConstant;
import org.apache.commons.lang3.time.TimeZones;
import tb.cu2;
import tb.m8;

/* compiled from: Taobao */
@Keep
/* loaded from: classes6.dex */
public class Draft_6455 extends Draft {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String CONNECTION = "Connection";
    private static final String SEC_WEB_SOCKET_ACCEPT = "Sec-WebSocket-Accept";
    private static final String SEC_WEB_SOCKET_EXTENSIONS = "Sec-WebSocket-Extensions";
    private static final String SEC_WEB_SOCKET_KEY = "Sec-WebSocket-Key";
    private static final String SEC_WEB_SOCKET_PROTOCOL = "Sec-WebSocket-Protocol";
    private static final String UPGRADE = "Upgrade";
    private final List<ByteBuffer> byteBufferList;
    private Framedata currentContinuousFrame;
    private IExtension extension;
    private ByteBuffer incompleteframe;
    private List<IExtension> knownExtensions;
    private List<IProtocol> knownProtocols;
    private int maxFrameSize;
    private IProtocol protocol;
    private final Random reuseableRandom;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a {
        private int a;
        private int b;

        a(Draft_6455 draft_6455, int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int c() {
            return this.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int d() {
            return this.b;
        }
    }

    public Draft_6455() {
        this(Collections.emptyList());
    }

    private void addToBufferList(ByteBuffer byteBuffer) {
        synchronized (this.byteBufferList) {
            this.byteBufferList.add(byteBuffer);
        }
    }

    private void checkBufferLimit() throws LimitExceededException {
        if (getByteBufferListSize() <= this.maxFrameSize) {
            return;
        }
        clearBufferList();
        Log.e("[GaiaX]", "Payload limit reached. Allowed: {} Current: {}");
        throw new LimitExceededException(this.maxFrameSize);
    }

    private void clearBufferList() {
        synchronized (this.byteBufferList) {
            this.byteBufferList.clear();
        }
    }

    private HandshakeState containsRequestedProtocol(String str) {
        for (IProtocol iProtocol : this.knownProtocols) {
            if (iProtocol.acceptProvidedProtocol(str)) {
                this.protocol = iProtocol;
                Log.e("[GaiaX]", "acceptHandshake - Matching protocol found: {}");
                return HandshakeState.MATCHED;
            }
        }
        return HandshakeState.NOT_MATCHED;
    }

    private ByteBuffer createByteBufferFromFramedata(Framedata framedata) {
        ByteBuffer payloadData = framedata.getPayloadData();
        int i = 0;
        boolean z = this.role == Role.CLIENT;
        int sizeBytes = getSizeBytes(payloadData);
        ByteBuffer allocate = ByteBuffer.allocate((sizeBytes > 1 ? sizeBytes + 1 : sizeBytes) + 1 + (z ? 4 : 0) + payloadData.remaining());
        allocate.put((byte) (((byte) (framedata.isFin() ? com.alipay.sdk.m.n.a.g : 0)) | fromOpcode(framedata.getOpcode())));
        byte[] byteArray = toByteArray(payloadData.remaining(), sizeBytes);
        if (sizeBytes == 1) {
            allocate.put((byte) (byteArray[0] | getMaskByte(z)));
        } else if (sizeBytes == 2) {
            allocate.put((byte) (getMaskByte(z) | 126));
            allocate.put(byteArray);
        } else if (sizeBytes == 8) {
            allocate.put((byte) (getMaskByte(z) | m8.DEL));
            allocate.put(byteArray);
        } else {
            throw new IllegalStateException("Size representation not supported/specified");
        }
        if (z) {
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.putInt(this.reuseableRandom.nextInt());
            allocate.put(allocate2.array());
            while (payloadData.hasRemaining()) {
                allocate.put((byte) (payloadData.get() ^ allocate2.get(i % 4)));
                i++;
            }
        } else {
            allocate.put(payloadData);
            payloadData.flip();
        }
        allocate.flip();
        return allocate;
    }

    private byte fromOpcode(Opcode opcode) {
        if (opcode == Opcode.CONTINUOUS) {
            return (byte) 0;
        }
        if (opcode == Opcode.TEXT) {
            return (byte) 1;
        }
        if (opcode == Opcode.BINARY) {
            return (byte) 2;
        }
        if (opcode == Opcode.CLOSING) {
            return (byte) 8;
        }
        if (opcode == Opcode.PING) {
            return (byte) 9;
        }
        if (opcode == Opcode.PONG) {
            return (byte) 10;
        }
        throw new IllegalArgumentException("Don't know how to handle " + opcode.toString());
    }

    private String generateFinalKey(String str) {
        try {
            return Base64.encodeBytes(MessageDigest.getInstance("SHA1").digest((str.trim() + WebSocketProtocol.ACCEPT_MAGIC).getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    private long getByteBufferListSize() {
        long j;
        synchronized (this.byteBufferList) {
            j = 0;
            for (ByteBuffer byteBuffer : this.byteBufferList) {
                j += byteBuffer.limit();
            }
        }
        return j;
    }

    private byte getMaskByte(boolean z) {
        if (z) {
            return cu2.MAX_POWER_OF_TWO;
        }
        return (byte) 0;
    }

    private ByteBuffer getPayloadFromByteBufferList() throws LimitExceededException {
        ByteBuffer allocate;
        synchronized (this.byteBufferList) {
            long j = 0;
            for (ByteBuffer byteBuffer : this.byteBufferList) {
                j += byteBuffer.limit();
            }
            checkBufferLimit();
            allocate = ByteBuffer.allocate((int) j);
            for (ByteBuffer byteBuffer2 : this.byteBufferList) {
                allocate.put(byteBuffer2);
            }
        }
        allocate.flip();
        return allocate;
    }

    private String getServerTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TimeZones.GMT_ID));
        return simpleDateFormat.format(calendar.getTime());
    }

    private int getSizeBytes(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 125) {
            return 1;
        }
        return byteBuffer.remaining() <= 65535 ? 2 : 8;
    }

    private void logRuntimeException(WebSocketImpl webSocketImpl, RuntimeException runtimeException) {
        Log.e("[GaiaX]", "Runtime exception during onWebsocketMessage", runtimeException);
        webSocketImpl.getWebSocketListener().onWebsocketError(webSocketImpl, runtimeException);
    }

    private void processFrameBinary(WebSocketImpl webSocketImpl, Framedata framedata) {
        try {
            webSocketImpl.getWebSocketListener().onWebsocketMessage(webSocketImpl, framedata.getPayloadData());
        } catch (RuntimeException e) {
            logRuntimeException(webSocketImpl, e);
        }
    }

    private void processFrameClosing(WebSocketImpl webSocketImpl, Framedata framedata) {
        int i;
        String str;
        if (framedata instanceof CloseFrame) {
            CloseFrame closeFrame = (CloseFrame) framedata;
            i = closeFrame.getCloseCode();
            str = closeFrame.getMessage();
        } else {
            i = 1005;
            str = "";
        }
        if (webSocketImpl.getReadyState() == ReadyState.CLOSING) {
            webSocketImpl.closeConnection(i, str, true);
        } else if (getCloseHandshakeType() == CloseHandshakeType.TWOWAY) {
            webSocketImpl.close(i, str, true);
        } else {
            webSocketImpl.flushAndClose(i, str, false);
        }
    }

    private void processFrameContinuousAndNonFin(WebSocketImpl webSocketImpl, Framedata framedata, Opcode opcode) throws InvalidDataException {
        Opcode opcode2 = Opcode.CONTINUOUS;
        if (opcode != opcode2) {
            processFrameIsNotFin(framedata);
        } else if (framedata.isFin()) {
            processFrameIsFin(webSocketImpl, framedata);
        } else if (this.currentContinuousFrame == null) {
            Log.e("[GaiaX]", "Protocol error: Continuous frame sequence was not started.");
            throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
        }
        if (opcode == Opcode.TEXT && !Charsetfunctions.isValidUTF8(framedata.getPayloadData())) {
            Log.e("[GaiaX]", "Protocol error: Payload is not UTF8");
            throw new InvalidDataException(1007);
        } else if (opcode != opcode2 || this.currentContinuousFrame == null) {
        } else {
            addToBufferList(framedata.getPayloadData());
        }
    }

    private void processFrameIsFin(WebSocketImpl webSocketImpl, Framedata framedata) throws InvalidDataException {
        if (this.currentContinuousFrame != null) {
            addToBufferList(framedata.getPayloadData());
            checkBufferLimit();
            if (this.currentContinuousFrame.getOpcode() == Opcode.TEXT) {
                ((FramedataImpl1) this.currentContinuousFrame).setPayload(getPayloadFromByteBufferList());
                ((FramedataImpl1) this.currentContinuousFrame).isValid();
                try {
                    webSocketImpl.getWebSocketListener().onWebsocketMessage(webSocketImpl, Charsetfunctions.stringUtf8(this.currentContinuousFrame.getPayloadData()));
                } catch (RuntimeException e) {
                    logRuntimeException(webSocketImpl, e);
                }
            } else if (this.currentContinuousFrame.getOpcode() == Opcode.BINARY) {
                ((FramedataImpl1) this.currentContinuousFrame).setPayload(getPayloadFromByteBufferList());
                ((FramedataImpl1) this.currentContinuousFrame).isValid();
                try {
                    webSocketImpl.getWebSocketListener().onWebsocketMessage(webSocketImpl, this.currentContinuousFrame.getPayloadData());
                } catch (RuntimeException e2) {
                    logRuntimeException(webSocketImpl, e2);
                }
            }
            this.currentContinuousFrame = null;
            clearBufferList();
            return;
        }
        Log.e("[GaiaX]", "Protocol error: Previous continuous frame sequence not completed.");
        throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
    }

    private void processFrameIsNotFin(Framedata framedata) throws InvalidDataException {
        if (this.currentContinuousFrame == null) {
            this.currentContinuousFrame = framedata;
            addToBufferList(framedata.getPayloadData());
            checkBufferLimit();
            return;
        }
        Log.e("[GaiaX]", "Protocol error: Previous continuous frame sequence not completed.");
        throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
    }

    private void processFrameText(WebSocketImpl webSocketImpl, Framedata framedata) throws InvalidDataException {
        try {
            webSocketImpl.getWebSocketListener().onWebsocketMessage(webSocketImpl, Charsetfunctions.stringUtf8(framedata.getPayloadData()));
        } catch (RuntimeException e) {
            logRuntimeException(webSocketImpl, e);
        }
    }

    private byte[] toByteArray(long j, int i) {
        byte[] bArr = new byte[i];
        int i2 = (i * 8) - 8;
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) (j >>> (i2 - (i3 * 8)));
        }
        return bArr;
    }

    private Opcode toOpcode(byte b) throws InvalidFrameException {
        if (b != 0) {
            if (b != 1) {
                if (b != 2) {
                    switch (b) {
                        case 8:
                            return Opcode.CLOSING;
                        case 9:
                            return Opcode.PING;
                        case 10:
                            return Opcode.PONG;
                        default:
                            throw new InvalidFrameException("Unknown opcode " + ((int) b));
                    }
                }
                return Opcode.BINARY;
            }
            return Opcode.TEXT;
        }
        return Opcode.CONTINUOUS;
    }

    private Framedata translateSingleFrame(ByteBuffer byteBuffer) throws IncompleteException, InvalidDataException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = 2;
            translateSingleFrameCheckPacketSize(remaining, 2);
            byte b = byteBuffer.get();
            boolean z = (b >> 8) != 0;
            boolean z2 = (b & SignedBytes.MAX_POWER_OF_TWO) != 0;
            boolean z3 = (b & 32) != 0;
            boolean z4 = (b & 16) != 0;
            byte b2 = byteBuffer.get();
            boolean z5 = (b2 & cu2.MAX_POWER_OF_TWO) != 0;
            int i2 = (byte) (b2 & m8.DEL);
            Opcode opcode = toOpcode((byte) (b & 15));
            if (i2 < 0 || i2 > 125) {
                a translateSingleFramePayloadLength = translateSingleFramePayloadLength(byteBuffer, opcode, i2, remaining, 2);
                i2 = translateSingleFramePayloadLength.c();
                i = translateSingleFramePayloadLength.d();
            }
            translateSingleFrameCheckLengthLimit(i2);
            translateSingleFrameCheckPacketSize(remaining, i + (z5 ? 4 : 0) + i2);
            ByteBuffer allocate = ByteBuffer.allocate(checkAlloc(i2));
            if (z5) {
                byte[] bArr = new byte[4];
                byteBuffer.get(bArr);
                for (int i3 = 0; i3 < i2; i3++) {
                    allocate.put((byte) (byteBuffer.get() ^ bArr[i3 % 4]));
                }
            } else {
                allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                byteBuffer.position(byteBuffer.position() + allocate.limit());
            }
            FramedataImpl1 framedataImpl1 = FramedataImpl1.get(opcode);
            framedataImpl1.setFin(z);
            framedataImpl1.setRSV1(z2);
            framedataImpl1.setRSV2(z3);
            framedataImpl1.setRSV3(z4);
            allocate.flip();
            framedataImpl1.setPayload(allocate);
            getExtension().isFrameValid(framedataImpl1);
            getExtension().decodeFrame(framedataImpl1);
            framedataImpl1.isValid();
            return framedataImpl1;
        }
        throw new IllegalArgumentException();
    }

    private void translateSingleFrameCheckLengthLimit(long j) throws LimitExceededException {
        if (j <= 2147483647L) {
            if (j > this.maxFrameSize) {
                Log.e("[GaiaX]", "Payload limit reached. Allowed: {} Current: {}");
                throw new LimitExceededException("Payload limit reached.", this.maxFrameSize);
            } else if (j >= 0) {
                return;
            } else {
                Log.e("[GaiaX]", "Limit underflow: Payloadsize is to little...");
                throw new LimitExceededException("Payloadsize is to little...");
            }
        }
        Log.e("[GaiaX]", "Limit exedeed: Payloadsize is to big...");
        throw new LimitExceededException(WsMessageConstants.MSG_PAYLOAD_SIZE_BIG);
    }

    private void translateSingleFrameCheckPacketSize(int i, int i2) throws IncompleteException {
        if (i >= i2) {
            return;
        }
        Log.e("[GaiaX]", "Incomplete frame: maxpacketsize < realpacketsize");
        throw new IncompleteException(i2);
    }

    private a translateSingleFramePayloadLength(ByteBuffer byteBuffer, Opcode opcode, int i, int i2, int i3) throws InvalidFrameException, IncompleteException, LimitExceededException {
        int i4;
        int i5;
        if (opcode != Opcode.PING && opcode != Opcode.PONG && opcode != Opcode.CLOSING) {
            if (i == 126) {
                i4 = i3 + 2;
                translateSingleFrameCheckPacketSize(i2, i4);
                i5 = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
            } else {
                i4 = i3 + 8;
                translateSingleFrameCheckPacketSize(i2, i4);
                byte[] bArr = new byte[8];
                for (int i6 = 0; i6 < 8; i6++) {
                    bArr[i6] = byteBuffer.get();
                }
                long longValue = new BigInteger(bArr).longValue();
                translateSingleFrameCheckLengthLimit(longValue);
                i5 = (int) longValue;
            }
            return new a(this, i5, i4);
        }
        Log.e("[GaiaX]", "Invalid frame: more than 125 octets");
        throw new InvalidFrameException("more than 125 octets");
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.drafts.Draft
    public HandshakeState acceptHandshakeAsClient(ClientHandshake clientHandshake, ServerHandshake serverHandshake) throws InvalidHandshakeException {
        if (!basicAccept(serverHandshake)) {
            Log.e("[GaiaX]", "acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return HandshakeState.NOT_MATCHED;
        } else if (clientHandshake.hasFieldValue(SEC_WEB_SOCKET_KEY) && serverHandshake.hasFieldValue(SEC_WEB_SOCKET_ACCEPT)) {
            if (!generateFinalKey(clientHandshake.getFieldValue(SEC_WEB_SOCKET_KEY)).equals(serverHandshake.getFieldValue(SEC_WEB_SOCKET_ACCEPT))) {
                Log.e("[GaiaX]", "acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return HandshakeState.NOT_MATCHED;
            }
            HandshakeState handshakeState = HandshakeState.NOT_MATCHED;
            String fieldValue = serverHandshake.getFieldValue(SEC_WEB_SOCKET_EXTENSIONS);
            Iterator<IExtension> it = this.knownExtensions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                IExtension next = it.next();
                if (next.acceptProvidedExtensionAsClient(fieldValue)) {
                    this.extension = next;
                    handshakeState = HandshakeState.MATCHED;
                    Log.e("[GaiaX]", "acceptHandshakeAsClient - Matching extension found: {}");
                    break;
                }
            }
            HandshakeState containsRequestedProtocol = containsRequestedProtocol(serverHandshake.getFieldValue("Sec-WebSocket-Protocol"));
            HandshakeState handshakeState2 = HandshakeState.MATCHED;
            if (containsRequestedProtocol == handshakeState2 && handshakeState == handshakeState2) {
                return handshakeState2;
            }
            Log.e("[GaiaX]", "acceptHandshakeAsClient - No matching extension or protocol found.");
            return HandshakeState.NOT_MATCHED;
        } else {
            Log.e("[GaiaX]", "acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return HandshakeState.NOT_MATCHED;
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.drafts.Draft
    public HandshakeState acceptHandshakeAsServer(ClientHandshake clientHandshake) throws InvalidHandshakeException {
        if (readVersion(clientHandshake) != 13) {
            Log.e("[GaiaX]", "acceptHandshakeAsServer - Wrong websocket version.");
            return HandshakeState.NOT_MATCHED;
        }
        HandshakeState handshakeState = HandshakeState.NOT_MATCHED;
        String fieldValue = clientHandshake.getFieldValue(SEC_WEB_SOCKET_EXTENSIONS);
        Iterator<IExtension> it = this.knownExtensions.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            IExtension next = it.next();
            if (next.acceptProvidedExtensionAsServer(fieldValue)) {
                this.extension = next;
                handshakeState = HandshakeState.MATCHED;
                Log.e("[GaiaX]", "acceptHandshakeAsServer - Matching extension found: {}");
                break;
            }
        }
        HandshakeState containsRequestedProtocol = containsRequestedProtocol(clientHandshake.getFieldValue("Sec-WebSocket-Protocol"));
        HandshakeState handshakeState2 = HandshakeState.MATCHED;
        if (containsRequestedProtocol == handshakeState2 && handshakeState == handshakeState2) {
            return handshakeState2;
        }
        Log.e("[GaiaX]", "acceptHandshakeAsServer - No matching extension or protocol found.");
        return HandshakeState.NOT_MATCHED;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.drafts.Draft
    public Draft copyInstance() {
        ArrayList arrayList = new ArrayList();
        for (IExtension iExtension : getKnownExtensions()) {
            arrayList.add(iExtension.copyInstance());
        }
        ArrayList arrayList2 = new ArrayList();
        for (IProtocol iProtocol : getKnownProtocols()) {
            arrayList2.add(iProtocol.copyInstance());
        }
        return new Draft_6455(arrayList, arrayList2, this.maxFrameSize);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.drafts.Draft
    public ByteBuffer createBinaryFrame(Framedata framedata) {
        getExtension().encodeFrame(framedata);
        return createByteBufferFromFramedata(framedata);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.drafts.Draft
    public List<Framedata> createFrames(ByteBuffer byteBuffer, boolean z) {
        BinaryFrame binaryFrame = new BinaryFrame();
        binaryFrame.setPayload(byteBuffer);
        binaryFrame.setTransferemasked(z);
        try {
            binaryFrame.isValid();
            return Collections.singletonList(binaryFrame);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Draft_6455 draft_6455 = (Draft_6455) obj;
        if (this.maxFrameSize != draft_6455.getMaxFrameSize()) {
            return false;
        }
        IExtension iExtension = this.extension;
        if (iExtension == null ? draft_6455.getExtension() == null : iExtension.equals(draft_6455.getExtension())) {
            IProtocol iProtocol = this.protocol;
            IProtocol protocol = draft_6455.getProtocol();
            return iProtocol != null ? iProtocol.equals(protocol) : protocol == null;
        }
        return false;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.drafts.Draft
    public CloseHandshakeType getCloseHandshakeType() {
        return CloseHandshakeType.TWOWAY;
    }

    public IExtension getExtension() {
        return this.extension;
    }

    public List<IExtension> getKnownExtensions() {
        return this.knownExtensions;
    }

    public List<IProtocol> getKnownProtocols() {
        return this.knownProtocols;
    }

    public int getMaxFrameSize() {
        return this.maxFrameSize;
    }

    public IProtocol getProtocol() {
        return this.protocol;
    }

    public int hashCode() {
        IExtension iExtension = this.extension;
        int hashCode = (iExtension != null ? iExtension.hashCode() : 0) * 31;
        IProtocol iProtocol = this.protocol;
        int hashCode2 = iProtocol != null ? iProtocol.hashCode() : 0;
        int i = this.maxFrameSize;
        return ((hashCode + hashCode2) * 31) + (i ^ (i >>> 32));
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.drafts.Draft
    public ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder clientHandshakeBuilder) {
        clientHandshakeBuilder.put(UPGRADE, "websocket");
        clientHandshakeBuilder.put("Connection", UPGRADE);
        byte[] bArr = new byte[16];
        this.reuseableRandom.nextBytes(bArr);
        clientHandshakeBuilder.put(SEC_WEB_SOCKET_KEY, Base64.encodeBytes(bArr));
        clientHandshakeBuilder.put("Sec-WebSocket-Version", "13");
        StringBuilder sb = new StringBuilder();
        for (IExtension iExtension : this.knownExtensions) {
            if (iExtension.getProvidedExtensionAsClient() != null && iExtension.getProvidedExtensionAsClient().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(AVFSCacheConstants.COMMA_SEP);
                }
                sb.append(iExtension.getProvidedExtensionAsClient());
            }
        }
        if (sb.length() != 0) {
            clientHandshakeBuilder.put(SEC_WEB_SOCKET_EXTENSIONS, sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (IProtocol iProtocol : this.knownProtocols) {
            if (iProtocol.getProvidedProtocol().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(AVFSCacheConstants.COMMA_SEP);
                }
                sb2.append(iProtocol.getProvidedProtocol());
            }
        }
        if (sb2.length() != 0) {
            clientHandshakeBuilder.put("Sec-WebSocket-Protocol", sb2.toString());
        }
        return clientHandshakeBuilder;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.drafts.Draft
    public HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) throws InvalidHandshakeException {
        serverHandshakeBuilder.put(UPGRADE, "websocket");
        serverHandshakeBuilder.put("Connection", clientHandshake.getFieldValue("Connection"));
        String fieldValue = clientHandshake.getFieldValue(SEC_WEB_SOCKET_KEY);
        if (fieldValue != null) {
            serverHandshakeBuilder.put(SEC_WEB_SOCKET_ACCEPT, generateFinalKey(fieldValue));
            if (getExtension().getProvidedExtensionAsServer().length() != 0) {
                serverHandshakeBuilder.put(SEC_WEB_SOCKET_EXTENSIONS, getExtension().getProvidedExtensionAsServer());
            }
            if (getProtocol() != null && getProtocol().getProvidedProtocol().length() != 0) {
                serverHandshakeBuilder.put("Sec-WebSocket-Protocol", getProtocol().getProvidedProtocol());
            }
            serverHandshakeBuilder.setHttpStatusMessage("Web Socket Protocol Handshake");
            serverHandshakeBuilder.put("Server", "TooTallNate Java-WebSocket");
            serverHandshakeBuilder.put(HttpHeaderConstant.DATE, getServerTime());
            return serverHandshakeBuilder;
        }
        throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.drafts.Draft
    public void processFrame(WebSocketImpl webSocketImpl, Framedata framedata) throws InvalidDataException {
        Opcode opcode = framedata.getOpcode();
        if (opcode == Opcode.CLOSING) {
            processFrameClosing(webSocketImpl, framedata);
        } else if (opcode == Opcode.PING) {
            webSocketImpl.getWebSocketListener().onWebsocketPing(webSocketImpl, framedata);
        } else if (opcode == Opcode.PONG) {
            webSocketImpl.updateLastPong();
            webSocketImpl.getWebSocketListener().onWebsocketPong(webSocketImpl, framedata);
        } else if (framedata.isFin() && opcode != Opcode.CONTINUOUS) {
            if (this.currentContinuousFrame == null) {
                if (opcode == Opcode.TEXT) {
                    processFrameText(webSocketImpl, framedata);
                    return;
                } else if (opcode == Opcode.BINARY) {
                    processFrameBinary(webSocketImpl, framedata);
                    return;
                } else {
                    Log.e("[GaiaX]", "non control or continious frame expected");
                    throw new InvalidDataException(1002, "non control or continious frame expected");
                }
            }
            Log.e("[GaiaX]", "Protocol error: Continuous frame sequence not completed.");
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            processFrameContinuousAndNonFin(webSocketImpl, framedata, opcode);
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.drafts.Draft
    public void reset() {
        this.incompleteframe = null;
        IExtension iExtension = this.extension;
        if (iExtension != null) {
            iExtension.reset();
        }
        this.extension = new DefaultExtension();
        this.protocol = null;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (getExtension() != null) {
            draft = draft + " extension: " + getExtension().toString();
        }
        if (getProtocol() != null) {
            draft = draft + " protocol: " + getProtocol().toString();
        }
        return draft + " max frame size: " + this.maxFrameSize;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.drafts.Draft
    public List<Framedata> translateFrame(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.incompleteframe == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.incompleteframe.remaining();
                if (remaining2 > remaining) {
                    this.incompleteframe.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(byteBuffer.position() + remaining);
                    return Collections.emptyList();
                }
                this.incompleteframe.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(translateSingleFrame((ByteBuffer) this.incompleteframe.duplicate().position(0)));
                this.incompleteframe = null;
            } catch (IncompleteException e) {
                ByteBuffer allocate = ByteBuffer.allocate(checkAlloc(e.getPreferredSize()));
                this.incompleteframe.rewind();
                allocate.put(this.incompleteframe);
                this.incompleteframe = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(translateSingleFrame(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                ByteBuffer allocate2 = ByteBuffer.allocate(checkAlloc(e2.getPreferredSize()));
                this.incompleteframe = allocate2;
                allocate2.put(byteBuffer);
            }
        }
        return linkedList;
    }

    public Draft_6455(IExtension iExtension) {
        this(Collections.singletonList(iExtension));
    }

    public Draft_6455(List<IExtension> list) {
        this(list, Collections.singletonList(new Protocol("")));
    }

    public Draft_6455(List<IExtension> list, List<IProtocol> list2) {
        this(list, list2, Integer.MAX_VALUE);
    }

    public Draft_6455(List<IExtension> list, int i) {
        this(list, Collections.singletonList(new Protocol("")), i);
    }

    public Draft_6455(List<IExtension> list, List<IProtocol> list2, int i) {
        this.extension = new DefaultExtension();
        this.reuseableRandom = new Random();
        if (list != null && list2 != null && i >= 1) {
            this.knownExtensions = new ArrayList(list.size());
            this.knownProtocols = new ArrayList(list2.size());
            boolean z = false;
            this.byteBufferList = new ArrayList();
            for (IExtension iExtension : list) {
                if (iExtension.getClass().equals(DefaultExtension.class)) {
                    z = true;
                }
            }
            this.knownExtensions.addAll(list);
            if (!z) {
                List<IExtension> list3 = this.knownExtensions;
                list3.add(list3.size(), this.extension);
            }
            this.knownProtocols.addAll(list2);
            this.maxFrameSize = i;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.drafts.Draft
    public List<Framedata> createFrames(String str, boolean z) {
        TextFrame textFrame = new TextFrame();
        textFrame.setPayload(ByteBuffer.wrap(Charsetfunctions.utf8Bytes(str)));
        textFrame.setTransferemasked(z);
        try {
            textFrame.isValid();
            return Collections.singletonList(textFrame);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }
}
