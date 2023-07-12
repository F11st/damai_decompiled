package com.alipay.android.phone.mobilesdk.socketcraft.handshake;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class HandshakedataImpl1 implements HandshakeBuilder {
    private byte[] a;
    private TreeMap<String, String> b = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.handshake.Handshakedata
    public byte[] getContent() {
        return this.a;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.handshake.Handshakedata
    public String getFieldValue(String str) {
        String str2 = this.b.get(str);
        return str2 == null ? "" : str2;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.handshake.Handshakedata
    public boolean hasFieldValue(String str) {
        return this.b.containsKey(str);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.handshake.Handshakedata
    public Iterator<String> iterateHttpFields() {
        return Collections.unmodifiableSet(this.b.keySet()).iterator();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.handshake.HandshakeBuilder
    public void put(String str, String str2) {
        this.b.put(str, str2);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.handshake.HandshakeBuilder
    public void setContent(byte[] bArr) {
        this.a = bArr;
    }
}
