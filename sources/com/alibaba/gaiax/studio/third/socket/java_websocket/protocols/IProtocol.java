package com.alibaba.gaiax.studio.third.socket.java_websocket.protocols;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes6.dex */
public interface IProtocol {
    boolean acceptProvidedProtocol(String str);

    IProtocol copyInstance();

    String getProvidedProtocol();

    String toString();
}
