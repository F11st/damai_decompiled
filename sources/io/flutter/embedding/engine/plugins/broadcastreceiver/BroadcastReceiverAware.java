package io.flutter.embedding.engine.plugins.broadcastreceiver;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface BroadcastReceiverAware {
    void onAttachedToBroadcastReceiver(@NonNull BroadcastReceiverPluginBinding broadcastReceiverPluginBinding);

    void onDetachedFromBroadcastReceiver();
}
