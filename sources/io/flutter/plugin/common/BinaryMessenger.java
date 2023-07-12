package io.flutter.plugin.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface BinaryMessenger {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface BinaryMessageHandler {
        @UiThread
        void onMessage(@Nullable ByteBuffer byteBuffer, @NonNull BinaryReply binaryReply);
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface BinaryReply {
        @UiThread
        void reply(@Nullable ByteBuffer byteBuffer);
    }

    @UiThread
    void send(@NonNull String str, @Nullable ByteBuffer byteBuffer);

    @UiThread
    void send(@NonNull String str, @Nullable ByteBuffer byteBuffer, @Nullable BinaryReply binaryReply);

    @UiThread
    void setMessageHandler(@NonNull String str, @Nullable BinaryMessageHandler binaryMessageHandler);
}
