package com.alibaba.gaiax.studio.third.socket.java_websocket.extensions;

import androidx.annotation.Keep;
import com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions.InvalidDataException;
import com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions.InvalidFrameException;
import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata;

/* compiled from: Taobao */
@Keep
/* loaded from: classes6.dex */
public class DefaultExtension implements IExtension {
    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.extensions.IExtension
    public boolean acceptProvidedExtensionAsClient(String str) {
        return true;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.extensions.IExtension
    public boolean acceptProvidedExtensionAsServer(String str) {
        return true;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.extensions.IExtension
    public IExtension copyInstance() {
        return new DefaultExtension();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.extensions.IExtension
    public void decodeFrame(Framedata framedata) throws InvalidDataException {
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.extensions.IExtension
    public void encodeFrame(Framedata framedata) {
    }

    public boolean equals(Object obj) {
        return this == obj || (obj != null && getClass() == obj.getClass());
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.extensions.IExtension
    public String getProvidedExtensionAsClient() {
        return "";
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.extensions.IExtension
    public String getProvidedExtensionAsServer() {
        return "";
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.extensions.IExtension
    public void isFrameValid(Framedata framedata) throws InvalidDataException {
        if (framedata.isRSV1() || framedata.isRSV2() || framedata.isRSV3()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.isRSV1() + " RSV2: " + framedata.isRSV2() + " RSV3: " + framedata.isRSV3());
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.extensions.IExtension
    public void reset() {
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.extensions.IExtension
    public String toString() {
        return getClass().getSimpleName();
    }
}
