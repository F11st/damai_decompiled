package tb;

import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class pi1 {
    @NotNull
    public static final hj a(@NotNull NameResolver nameResolver, int i) {
        b41.i(nameResolver, "<this>");
        hj f = hj.f(nameResolver.getQualifiedClassName(i), nameResolver.isLocalClassName(i));
        b41.h(f, "fromString(getQualifiedC… isLocalClassName(index))");
        return f;
    }

    @NotNull
    public static final ni1 b(@NotNull NameResolver nameResolver, int i) {
        b41.i(nameResolver, "<this>");
        ni1 e = ni1.e(nameResolver.getString(i));
        b41.h(e, "guessByFirstCharacter(getString(index))");
        return e;
    }
}
