package com.youku.live.messagechannel.connection;

import com.youku.live.messagechannel.callback.IMCConnectionEventCallback;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IMCConnection {
    MCConnectionFlag getConnectionFlag();

    MCConnectionState getConnectionState();

    boolean isHealth();

    void launch(IMCConnectionEventCallback iMCConnectionEventCallback);

    void shutdown(IMCConnectionEventCallback iMCConnectionEventCallback);
}
