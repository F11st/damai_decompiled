package com.youku.live.messagechannel.connection.Connector;

/* compiled from: Taobao */
/* renamed from: com.youku.live.messagechannel.connection.Connector.Connector */
/* loaded from: classes12.dex */
public interface InterfaceC7962Connector {
    boolean isSubscribe(String str);

    void reconnect();

    void subscribe(String str, ConnectorListener connectorListener);

    void unsubscribe(String str);
}
