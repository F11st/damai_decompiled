package com.alipay.android.phone.mobilesdk.socketcraft.framing;

import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidDataException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidFrameException;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata;
import com.alipay.android.phone.mobilesdk.socketcraft.util.Charsetfunctions;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class CloseFrameBuilder extends FramedataImpl1 implements CloseFrame {
    static final ByteBuffer h = ByteBuffer.allocate(0);
    private int f;
    private String g;

    public CloseFrameBuilder() {
        super(Framedata.Opcode.CLOSING);
        setFin(true);
    }

    private void a() {
        this.f = 1005;
        ByteBuffer payloadData = super.getPayloadData();
        payloadData.mark();
        if (payloadData.remaining() >= 2) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.position(2);
            allocate.putShort(payloadData.getShort());
            allocate.position(0);
            int i = allocate.getInt();
            this.f = i;
            if (i == 1006 || i == 1015 || i == 1005 || i > 4999 || i < 1000 || i == 1004) {
                throw new InvalidFrameException("closecode must not be sent over the wire: " + this.f);
            }
        }
        payloadData.reset();
    }

    private void b() {
        if (this.f == 1005) {
            this.g = Charsetfunctions.stringUtf8(super.getPayloadData());
            return;
        }
        ByteBuffer payloadData = super.getPayloadData();
        int position = payloadData.position();
        try {
            try {
                payloadData.position(payloadData.position() + 2);
                this.g = Charsetfunctions.stringUtf8(payloadData);
            } catch (IllegalArgumentException e) {
                throw new InvalidFrameException(e);
            }
        } finally {
            payloadData.position(position);
        }
    }

    private void c(int i, String str) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (i == 1015) {
            i = 1005;
        } else {
            str2 = str;
        }
        if (i == 1005) {
            if (str2.length() > 0) {
                throw new InvalidDataException(1002, "A close frame must have a closecode if it has a reason");
            }
            return;
        }
        byte[] utf8Bytes = Charsetfunctions.utf8Bytes(str2);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.position(2);
        ByteBuffer allocate2 = ByteBuffer.allocate(utf8Bytes.length + 2);
        allocate2.put(allocate);
        allocate2.put(utf8Bytes);
        allocate2.rewind();
        setPayload(allocate2);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.CloseFrame
    public int getCloseCode() {
        return this.f;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.CloseFrame
    public String getMessage() {
        return this.g;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.FramedataImpl1, com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata
    public ByteBuffer getPayloadData() {
        if (this.f == 1005) {
            return h;
        }
        return super.getPayloadData();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.FramedataImpl1, com.alipay.android.phone.mobilesdk.socketcraft.framing.FrameBuilder
    public void setPayload(ByteBuffer byteBuffer) {
        super.setPayload(byteBuffer);
        a();
        b();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.FramedataImpl1
    public String toString() {
        return super.toString() + "code: " + this.f;
    }

    public CloseFrameBuilder(int i) {
        super(Framedata.Opcode.CLOSING);
        setFin(true);
        c(i, "");
    }

    public CloseFrameBuilder(int i, String str) {
        super(Framedata.Opcode.CLOSING);
        setFin(true);
        c(i, str);
    }
}
