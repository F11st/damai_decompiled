package com.youku.live.dago.widgetlib.ailproom.protocol;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.youku.live.dago.widgetlib.ailproom.adapter.mclient.AILPMClientConfig;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface AILPMClientProtocol {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface Dispatcher {
        void onFail(Map<String, Object> map);

        void onSucess(Map<String, Object> map);
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface MsgReceiver {
        void onReceive(Map<String, Object> map);
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface ResultCallback {
        void onFail(Map<String, Object> map);

        void onSuccess(Map<String, Object> map);
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface YKLMClientGetterProtocol {
        AILPMClientProtocol getProtocol();
    }

    void connect(@Nullable Map<String, Object> map, @Nullable ResultCallback resultCallback);

    void disconnect();

    void register(@NonNull String str, @Nullable Map<String, Object> map, @Nullable MsgReceiver msgReceiver);

    void sendMessage(@NonNull Map<String, Object> map, @Nullable Dispatcher dispatcher);

    void setConfig(@Nullable AILPMClientConfig aILPMClientConfig);

    void unregister(@NonNull String str);
}
