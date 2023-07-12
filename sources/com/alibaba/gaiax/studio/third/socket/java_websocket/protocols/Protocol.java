package com.alibaba.gaiax.studio.third.socket.java_websocket.protocols;

import androidx.annotation.Keep;
import java.util.regex.Pattern;

/* compiled from: Taobao */
@Keep
/* loaded from: classes6.dex */
public class Protocol implements IProtocol {
    private final String providedProtocol;
    private static final Pattern patternSpace = Pattern.compile(" ");
    private static final Pattern patternComma = Pattern.compile(",");

    public Protocol(String str) {
        if (str != null) {
            this.providedProtocol = str;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.protocols.IProtocol
    public boolean acceptProvidedProtocol(String str) {
        for (String str2 : patternComma.split(patternSpace.matcher(str).replaceAll(""))) {
            if (this.providedProtocol.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.protocols.IProtocol
    public IProtocol copyInstance() {
        return new Protocol(getProvidedProtocol());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.providedProtocol.equals(((Protocol) obj).providedProtocol);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.protocols.IProtocol
    public String getProvidedProtocol() {
        return this.providedProtocol;
    }

    public int hashCode() {
        return this.providedProtocol.hashCode();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.protocols.IProtocol
    public String toString() {
        return getProvidedProtocol();
    }
}
