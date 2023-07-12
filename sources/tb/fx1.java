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
    public static final <M extends GeneratedMessageLite.ExtendableMessage<M>, T> T a(@NotNull GeneratedMessageLite.ExtendableMessage<M> extendableMessage, @NotNull GeneratedMessageLite.c<M, T> cVar) {
        b41.i(extendableMessage, "<this>");
        b41.i(cVar, "extension");
        if (extendableMessage.hasExtension(cVar)) {
            return (T) extendableMessage.getExtension(cVar);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final <M extends GeneratedMessageLite.ExtendableMessage<M>, T> T b(@NotNull GeneratedMessageLite.ExtendableMessage<M> extendableMessage, @NotNull GeneratedMessageLite.c<M, List<T>> cVar, int i) {
        b41.i(extendableMessage, "<this>");
        b41.i(cVar, "extension");
        if (i < extendableMessage.getExtensionCount(cVar)) {
            return (T) extendableMessage.getExtension(cVar, i);
        }
        return null;
    }
}
