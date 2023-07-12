package tb;

import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class p21<Type extends SimpleTypeMarker> {
    @NotNull
    private final ni1 a;
    @NotNull
    private final Type b;

    public p21(@NotNull ni1 ni1Var, @NotNull Type type) {
        b41.i(ni1Var, "underlyingPropertyName");
        b41.i(type, "underlyingType");
        this.a = ni1Var;
        this.b = type;
    }

    @NotNull
    public final ni1 a() {
        return this.a;
    }

    @NotNull
    public final Type b() {
        return this.b;
    }
}
