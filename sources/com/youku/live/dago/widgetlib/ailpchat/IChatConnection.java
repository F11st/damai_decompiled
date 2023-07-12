package com.youku.live.dago.widgetlib.ailpchat;

import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IChatConnection {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface ConnectionListner {
        ConnectState connectState();

        void connectionStateChange(ConnectState connectState);

        void dispatchReceiveMessage(ChatMessage chatMessage);

        void dispatchWeexMessage(Map<String, Object> map);

        void refreshWeexListener();
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface SendMessageCallback {
        void onFail(Map<String, Object> map);

        void onSuccess(Map<String, Object> map);
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface WeexMessageListener {
        void onDispatch(Map<String, Object> map);
    }

    boolean connect(ICallback iCallback);

    boolean disconnect(ICallback iCallback);

    void pause();

    void release();

    void resume();

    boolean sendMessage(Map<String, Object> map, SendMessageCallback sendMessageCallback);

    void setConnectionListener(ConnectionListner connectionListner);

    void setWeexMessageListener(List<WeexMessageListener> list);
}
