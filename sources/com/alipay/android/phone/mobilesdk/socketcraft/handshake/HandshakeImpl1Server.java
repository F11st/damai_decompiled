package com.alipay.android.phone.mobilesdk.socketcraft.handshake;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class HandshakeImpl1Server extends HandshakedataImpl1 implements ServerHandshakeBuilder {
    private short c;
    private String d;

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.handshake.ServerHandshake
    public short getHttpStatus() {
        return this.c;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.handshake.ServerHandshake
    public String getHttpStatusMessage() {
        return this.d;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.handshake.ServerHandshakeBuilder
    public void setHttpStatus(short s) {
        this.c = s;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.handshake.ServerHandshakeBuilder
    public void setHttpStatusMessage(String str) {
        this.d = str;
    }
}
