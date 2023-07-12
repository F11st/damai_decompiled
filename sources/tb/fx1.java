package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class fx1 {
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final <M extends GeneratedMessageLite.ExtendableMessage<M>, T> T a(@NotNull GeneratedMessageLite.ExtendableMessage<M> extendableMessage, @NotNull GeneratedMessageLite.C8441c<M, T> c8441c) {
        b41.i(extendableMessage, "<this>");
        b41.i(c8441c, "extension");
        if (extendableMessage.hasExtension(c8441c)) {
            return (T) extendableMessage.getExtension(c8441c);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final <M extends GeneratedMessageLite.ExtendableMessage<M>, T> T b(@NotNull GeneratedMessageLite.ExtendableMessage<M> extendableMessage, @NotNull GeneratedMessageLite.C8441c<M, List<T>> c8441c, int i) {
        b41.i(extendableMessage, "<this>");
        b41.i(c8441c, "extension");
        if (i < extendableMessage.getExtensionCount(c8441c)) {
            return (T) extendableMessage.getExtension(c8441c, i);
        }
        return null;
    }
}
