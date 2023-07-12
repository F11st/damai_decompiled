package com.alipay.android.phone.mobilesdk.socketcraft.handshake;

import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class HandshakeImpl1Client extends HandshakedataImpl1 implements ClientHandshakeBuilder {
    private String c = jn1.MUL;

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.handshake.ClientHandshake
    public String getResourceDescriptor() {
        return this.c;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.handshake.ClientHandshakeBuilder
    public void setResourceDescriptor(String str) {
        if (str != null) {
            this.c = str;
            return;
        }
        throw new IllegalArgumentException("http resource descriptor must not be null");
    }
}
