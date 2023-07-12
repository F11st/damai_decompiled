package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class z71 implements Annotated, KotlinTypeMarker {
    private int a;

    private z71() {
    }

    public /* synthetic */ z71(k50 k50Var) {
        this();
    }

    private final int a() {
        if (a81.a(this)) {
            return super.hashCode();
        }
        return (((c().hashCode() * 31) + b().hashCode()) * 31) + (d() ? 1 : 0);
    }

    @NotNull
    public abstract List<TypeProjection> b();

    @NotNull
    public abstract TypeConstructor c();

    public abstract boolean d();

    @NotNull
    public abstract z71 e(@NotNull b81 b81Var);

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof z71) {
            z71 z71Var = (z71) obj;
            return d() == z71Var.d() && ah2.INSTANCE.a(f(), z71Var.f());
        }
        return false;
    }

    @NotNull
    public abstract gu2 f();

    @NotNull
    public abstract MemberScope getMemberScope();

    public final int hashCode() {
        int i = this.a;
        if (i != 0) {
            return i;
        }
        int a = a();
        this.a = a;
        return a;
    }
}
