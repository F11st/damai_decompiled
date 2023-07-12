package com.youku.live.messagechannel.connection.Connector;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface Connector {
    boolean isSubscribe(String str);

    void reconnect();

    void subscribe(String str, ConnectorListener connectorListener);

    void unsubscribe(String str);
}
