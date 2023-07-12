package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.JSONMessageCodec;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SystemChannel {
    private static final String TAG = "SystemChannel";
    @NonNull
    public final BasicMessageChannel<Object> channel;

    public SystemChannel(@NonNull DartExecutor dartExecutor) {
        this.channel = new BasicMessageChannel<>(dartExecutor, "flutter/system", JSONMessageCodec.INSTANCE);
    }

    public void sendApplicationDidEnterBackground() {
        Log.v(TAG, "Sending Application Did Enter Background envent to Flutter.");
        HashMap hashMap = new HashMap(1);
        hashMap.put("type", "applicationDidEnterBackground");
        this.channel.send(hashMap);
    }

    public void sendMemoryPressureWarning() {
        Log.v(TAG, "Sending memory pressure warning to Flutter.");
        HashMap hashMap = new HashMap(1);
        hashMap.put("type", "memoryPressure");
        this.channel.send(hashMap);
    }
}
