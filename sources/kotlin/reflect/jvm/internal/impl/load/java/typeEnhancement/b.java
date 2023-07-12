package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.c51;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class b {
    @NotNull
    private final z71 a;
    @Nullable
    private final c51 b;
    @Nullable
    private final TypeParameterDescriptor c;
    private final boolean d;

    public b(@NotNull z71 z71Var, @Nullable c51 c51Var, @Nullable TypeParameterDescriptor typeParameterDescriptor, boolean z) {
        b41.i(z71Var, "type");
        this.a = z71Var;
        this.b = c51Var;
        this.c = typeParameterDescriptor;
        this.d = z;
    }

    @NotNull
    public final z71 a() {
        return this.a;
    }

    @Nullable
    public final c51 b() {
        return this.b;
    }

    @Nullable
    public final TypeParameterDescriptor c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    @NotNull
    public final z71 e() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return b41.d(this.a, bVar.a) && b41.d(this.b, bVar.b) && b41.d(this.c, bVar.c) && this.d == bVar.d;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        c51 c51Var = this.b;
        int hashCode2 = (hashCode + (c51Var == null ? 0 : c51Var.hashCode())) * 31;
        TypeParameterDescriptor typeParameterDescriptor = this.c;
        int hashCode3 = (hashCode2 + (typeParameterDescriptor != null ? typeParameterDescriptor.hashCode() : 0)) * 31;
        boolean z = this.d;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        return "TypeAndDefaultQualifiers(type=" + this.a + ", defaultQualifiers=" + this.b + ", typeParameterForArgument=" + this.c + ", isFromStarProjection=" + this.d + ')';
    }
}
