package com.alipay.android.phone.mobilesdk.socketcraft.framing;

import com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata;
import com.alipay.android.phone.mobilesdk.socketcraft.util.Charsetfunctions;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class FramedataImpl1 implements FrameBuilder {
    protected static byte[] e = new byte[0];
    protected boolean a;
    protected Framedata.Opcode b;
    private ByteBuffer c;
    protected boolean d;

    public FramedataImpl1() {
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata
    public void append(Framedata framedata) {
        ByteBuffer payloadData = framedata.getPayloadData();
        if (this.c == null) {
            this.c = ByteBuffer.allocate(payloadData.remaining());
            payloadData.mark();
            this.c.put(payloadData);
            payloadData.reset();
        } else {
            payloadData.mark();
            ByteBuffer byteBuffer = this.c;
            byteBuffer.position(byteBuffer.limit());
            ByteBuffer byteBuffer2 = this.c;
            byteBuffer2.limit(byteBuffer2.capacity());
            if (payloadData.remaining() > this.c.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(payloadData.remaining() + this.c.capacity());
                this.c.flip();
                allocate.put(this.c);
                allocate.put(payloadData);
                this.c = allocate;
            } else {
                this.c.put(payloadData);
            }
            this.c.rewind();
            payloadData.reset();
        }
        this.a = framedata.isFin();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata
    public Framedata.Opcode getOpcode() {
        return this.b;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata
    public ByteBuffer getPayloadData() {
        return this.c;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata
    public boolean getTransfereMasked() {
        return this.d;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata
    public boolean isFin() {
        return this.a;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.FrameBuilder
    public void setFin(boolean z) {
        this.a = z;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.FrameBuilder
    public void setOptcode(Framedata.Opcode opcode) {
        this.b = opcode;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.FrameBuilder
    public void setPayload(ByteBuffer byteBuffer) {
        this.c = byteBuffer;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.FrameBuilder
    public void setTransferemasked(boolean z) {
        this.d = z;
    }

    public String toString() {
        return "Framedata{ optcode:" + getOpcode() + ", fin:" + isFin() + ", payloadlength:[pos:" + this.c.position() + ", len:" + this.c.remaining() + "], payload:" + Arrays.toString(Charsetfunctions.utf8Bytes(new String(this.c.array()))) + "}";
    }

    public FramedataImpl1(Framedata.Opcode opcode) {
        this.b = opcode;
        this.c = ByteBuffer.wrap(e);
    }

    public FramedataImpl1(Framedata framedata) {
        this.a = framedata.isFin();
        this.b = framedata.getOpcode();
        this.c = framedata.getPayloadData();
        this.d = framedata.getTransfereMasked();
    }
}
