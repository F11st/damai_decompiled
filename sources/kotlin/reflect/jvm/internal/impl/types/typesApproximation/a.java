package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class a {
    @NotNull
    private final TypeParameterDescriptor a;
    @NotNull
    private final z71 b;
    @NotNull
    private final z71 c;

    public a(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull z71 z71Var, @NotNull z71 z71Var2) {
        b41.i(typeParameterDescriptor, "typeParameter");
        b41.i(z71Var, "inProjection");
        b41.i(z71Var2, "outProjection");
        this.a = typeParameterDescriptor;
        this.b = z71Var;
        this.c = z71Var2;
    }

    @NotNull
    public final z71 a() {
        return this.b;
    }

    @NotNull
    public final z71 b() {
        return this.c;
    }

    @NotNull
    public final TypeParameterDescriptor c() {
        return this.a;
    }

    public final boolean d() {
        return KotlinTypeChecker.DEFAULT.isSubtypeOf(this.b, this.c);
    }
}
