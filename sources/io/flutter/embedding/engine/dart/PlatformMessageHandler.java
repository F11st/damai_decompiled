package io.flutter.embedding.engine.dart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface PlatformMessageHandler {
    void handleMessageFromDart(@NonNull String str, @Nullable ByteBuffer byteBuffer, int i);

    void handlePlatformMessageResponse(int i, @Nullable ByteBuffer byteBuffer);
}
