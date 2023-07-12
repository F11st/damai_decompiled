package com.alibaba.gaiax.studio.third.socket.java_websocket.handshake;

import androidx.annotation.Keep;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* compiled from: Taobao */
@Keep
/* loaded from: classes6.dex */
public class HandshakedataImpl1 implements HandshakeBuilder {
    private byte[] content;
    private TreeMap<String, String> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.Handshakedata
    public byte[] getContent() {
        return this.content;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.Handshakedata
    public String getFieldValue(String str) {
        String str2 = this.map.get(str);
        return str2 == null ? "" : str2;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.Handshakedata
    public boolean hasFieldValue(String str) {
        return this.map.containsKey(str);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.Handshakedata
    public Iterator<String> iterateHttpFields() {
        return Collections.unmodifiableSet(this.map.keySet()).iterator();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.HandshakeBuilder
    public void put(String str, String str2) {
        this.map.put(str, str2);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.HandshakeBuilder
    public void setContent(byte[] bArr) {
        this.content = bArr;
    }
}
