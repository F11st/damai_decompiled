package tb;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class q51 {
    @NotNull
    private final TypeUsage a;
    @NotNull
    private final JavaTypeFlexibility b;
    private final boolean c;
    @Nullable
    private final Set<TypeParameterDescriptor> d;
    @Nullable
    private final fd2 e;

    /* JADX WARN: Multi-variable type inference failed */
    public q51(@NotNull TypeUsage typeUsage, @NotNull JavaTypeFlexibility javaTypeFlexibility, boolean z, @Nullable Set<? extends TypeParameterDescriptor> set, @Nullable fd2 fd2Var) {
        b41.i(typeUsage, "howThisTypeIsUsed");
        b41.i(javaTypeFlexibility, "flexibility");
        this.a = typeUsage;
        this.b = javaTypeFlexibility;
        this.c = z;
        this.d = set;
        this.e = fd2Var;
    }

    public static /* synthetic */ q51 b(q51 q51Var, TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, Set set, fd2 fd2Var, int i, Object obj) {
        if ((i & 1) != 0) {
            typeUsage = q51Var.a;
        }
        if ((i & 2) != 0) {
            javaTypeFlexibility = q51Var.b;
        }
        JavaTypeFlexibility javaTypeFlexibility2 = javaTypeFlexibility;
        if ((i & 4) != 0) {
            z = q51Var.c;
        }
        boolean z2 = z;
        Set<TypeParameterDescriptor> set2 = set;
        if ((i & 8) != 0) {
            set2 = q51Var.d;
        }
        Set set3 = set2;
        if ((i & 16) != 0) {
            fd2Var = q51Var.e;
        }
        return q51Var.a(typeUsage, javaTypeFlexibility2, z2, set3, fd2Var);
    }

    @NotNull
    public final q51 a(@NotNull TypeUsage typeUsage, @NotNull JavaTypeFlexibility javaTypeFlexibility, boolean z, @Nullable Set<? extends TypeParameterDescriptor> set, @Nullable fd2 fd2Var) {
        b41.i(typeUsage, "howThisTypeIsUsed");
        b41.i(javaTypeFlexibility, "flexibility");
        return new q51(typeUsage, javaTypeFlexibility, z, set, fd2Var);
    }

    @Nullable
    public final fd2 c() {
        return this.e;
    }

    @NotNull
    public final JavaTypeFlexibility d() {
        return this.b;
    }

    @NotNull
    public final TypeUsage e() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q51) {
            q51 q51Var = (q51) obj;
            return this.a == q51Var.a && this.b == q51Var.b && this.c == q51Var.c && b41.d(this.d, q51Var.d) && b41.d(this.e, q51Var.e);
        }
        return false;
    }

    @Nullable
    public final Set<TypeParameterDescriptor> f() {
        return this.d;
    }

    public final boolean g() {
        return this.c;
    }

    @NotNull
    public final q51 h(@Nullable fd2 fd2Var) {
        return b(this, null, null, false, null, fd2Var, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        boolean z = this.c;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        Set<TypeParameterDescriptor> set = this.d;
        int hashCode2 = (i2 + (set == null ? 0 : set.hashCode())) * 31;
        fd2 fd2Var = this.e;
        return hashCode2 + (fd2Var != null ? fd2Var.hashCode() : 0);
    }

    @NotNull
    public final q51 i(@NotNull JavaTypeFlexibility javaTypeFlexibility) {
        b41.i(javaTypeFlexibility, "flexibility");
        return b(this, null, javaTypeFlexibility, false, null, null, 29, null);
    }

    @NotNull
    public final q51 j(@NotNull TypeParameterDescriptor typeParameterDescriptor) {
        b41.i(typeParameterDescriptor, "typeParameter");
        Set<TypeParameterDescriptor> set = this.d;
        return b(this, null, null, false, set != null ? kotlin.collections.f0.j(set, typeParameterDescriptor) : kotlin.collections.d0.c(typeParameterDescriptor), null, 23, null);
    }

    @NotNull
    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.a + ", flexibility=" + this.b + ", isForAnnotationParameter=" + this.c + ", visitedTypeParameters=" + this.d + ", defaultType=" + this.e + ')';
    }

    public /* synthetic */ q51(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, Set set, fd2 fd2Var, int i, k50 k50Var) {
        this(typeUsage, (i & 2) != 0 ? JavaTypeFlexibility.INFLEXIBLE : javaTypeFlexibility, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : set, (i & 16) != 0 ? null : fd2Var);
    }
}
