package tb;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class c51 {
    @NotNull
    private final fm1 a;
    @NotNull
    private final Collection<AnnotationQualifierApplicabilityType> b;
    private final boolean c;
    private final boolean d;

    /* JADX WARN: Multi-variable type inference failed */
    public c51(@NotNull fm1 fm1Var, @NotNull Collection<? extends AnnotationQualifierApplicabilityType> collection, boolean z, boolean z2) {
        b41.i(fm1Var, "nullabilityQualifier");
        b41.i(collection, "qualifierApplicabilityTypes");
        this.a = fm1Var;
        this.b = collection;
        this.c = z;
        this.d = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ c51 b(c51 c51Var, fm1 fm1Var, Collection collection, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            fm1Var = c51Var.a;
        }
        if ((i & 2) != 0) {
            collection = c51Var.b;
        }
        if ((i & 4) != 0) {
            z = c51Var.c;
        }
        if ((i & 8) != 0) {
            z2 = c51Var.d;
        }
        return c51Var.a(fm1Var, collection, z, z2);
    }

    @NotNull
    public final c51 a(@NotNull fm1 fm1Var, @NotNull Collection<? extends AnnotationQualifierApplicabilityType> collection, boolean z, boolean z2) {
        b41.i(fm1Var, "nullabilityQualifier");
        b41.i(collection, "qualifierApplicabilityTypes");
        return new c51(fm1Var, collection, z, z2);
    }

    public final boolean c() {
        return this.d;
    }

    public final boolean d() {
        return this.c;
    }

    public final boolean e() {
        return this.a.c() == NullabilityQualifier.NOT_NULL && this.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c51) {
            c51 c51Var = (c51) obj;
            return b41.d(this.a, c51Var.a) && b41.d(this.b, c51Var.b) && this.c == c51Var.c && this.d == c51Var.d;
        }
        return false;
    }

    @NotNull
    public final fm1 f() {
        return this.a;
    }

    @NotNull
    public final Collection<AnnotationQualifierApplicabilityType> g() {
        return this.b;
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
        boolean z2 = this.d;
        return i2 + (z2 ? 1 : z2 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.a + ", qualifierApplicabilityTypes=" + this.b + ", affectsTypeParameterBasedTypes=" + this.c + ", affectsStarProjection=" + this.d + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ c51(tb.fm1 r1, java.util.Collection r2, boolean r3, boolean r4, int r5, tb.k50 r6) {
        /*
            r0 = this;
            r6 = r5 & 4
            if (r6 == 0) goto Lf
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r3 = r1.c()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
            if (r3 != r6) goto Le
            r3 = 1
            goto Lf
        Le:
            r3 = 0
        Lf:
            r5 = r5 & 8
            if (r5 == 0) goto L14
            r4 = r3
        L14:
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.c51.<init>(tb.fm1, java.util.Collection, boolean, boolean, int, tb.k50):void");
    }
}
