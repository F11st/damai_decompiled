package tb;

import com.youku.arch.v3.data.Constants;
import kotlin.Lazy;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class r81 {
    @NotNull
    private final n51 a;
    @NotNull
    private final TypeParameterResolver b;
    @NotNull
    private final Lazy<t51> c;
    @NotNull
    private final Lazy d;
    @NotNull
    private final JavaTypeResolver e;

    public r81(@NotNull n51 n51Var, @NotNull TypeParameterResolver typeParameterResolver, @NotNull Lazy<t51> lazy) {
        b41.i(n51Var, Constants.COMPONENT);
        b41.i(typeParameterResolver, "typeParameterResolver");
        b41.i(lazy, "delegateForDefaultTypeQualifiers");
        this.a = n51Var;
        this.b = typeParameterResolver;
        this.c = lazy;
        this.d = lazy;
        this.e = new JavaTypeResolver(this, typeParameterResolver);
    }

    @NotNull
    public final n51 a() {
        return this.a;
    }

    @Nullable
    public final t51 b() {
        return (t51) this.d.getValue();
    }

    @NotNull
    public final Lazy<t51> c() {
        return this.c;
    }

    @NotNull
    public final ModuleDescriptor d() {
        return this.a.m();
    }

    @NotNull
    public final StorageManager e() {
        return this.a.u();
    }

    @NotNull
    public final TypeParameterResolver f() {
        return this.b;
    }

    @NotNull
    public final JavaTypeResolver g() {
        return this.e;
    }
}
