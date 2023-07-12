package tb;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.C8214m;
import kotlin.collections.C8215n;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class r51 {
    @NotNull
    private final JavaResolverSettings a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.r51$a */
    /* loaded from: classes3.dex */
    public static class C9642a {
        @NotNull
        private final z71 a;
        private final int b;
        private final boolean c;

        public C9642a(@NotNull z71 z71Var, int i, boolean z) {
            b41.i(z71Var, "type");
            this.a = z71Var;
            this.b = i;
            this.c = z;
        }

        public final int a() {
            return this.b;
        }

        @NotNull
        public z71 b() {
            return this.a;
        }

        @Nullable
        public final z71 c() {
            z71 b = b();
            if (d()) {
                return b;
            }
            return null;
        }

        public final boolean d() {
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.r51$b */
    /* loaded from: classes3.dex */
    public static final class C9643b extends C9642a {
        @NotNull
        private final fd2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9643b(@NotNull fd2 fd2Var, int i, boolean z) {
            super(fd2Var, i, z);
            b41.i(fd2Var, "type");
            this.d = fd2Var;
        }

        @Override // tb.r51.C9642a
        @NotNull
        /* renamed from: e */
        public fd2 b() {
            return this.d;
        }
    }

    public r51(@NotNull JavaResolverSettings javaResolverSettings) {
        b41.i(javaResolverSettings, "javaResolverSettings");
        this.a = javaResolverSettings;
    }

    private final z71 a(z71 z71Var, z71 z71Var2) {
        z71 a = gr2.a(z71Var2);
        z71 a2 = gr2.a(z71Var);
        if (a2 == null) {
            if (a == null) {
                return null;
            }
            a2 = a;
        }
        return a == null ? a2 : KotlinTypeFactory.d(dk0.c(a2), dk0.d(a));
    }

    private final C9643b c(fd2 fd2Var, Function1<? super Integer, s51> function1, int i, TypeComponentPosition typeComponentPosition, boolean z, boolean z2) {
        ue0 e;
        int q;
        boolean z3;
        ArrayList arrayList;
        TypeProjection e2;
        ue0 h;
        List l;
        Annotations d;
        Function1<? super Integer, s51> function12 = function1;
        if (nq2.a(typeComponentPosition) || !fd2Var.b().isEmpty()) {
            ClassifierDescriptor declarationDescriptor = fd2Var.c().getDeclarationDescriptor();
            if (declarationDescriptor == null) {
                return new C9643b(fd2Var, 1, false);
            }
            s51 invoke = function12.invoke(Integer.valueOf(i));
            e = sq2.e(declarationDescriptor, invoke, typeComponentPosition);
            ClassifierDescriptor classifierDescriptor = (ClassifierDescriptor) e.a();
            Annotations b = e.b();
            TypeConstructor typeConstructor = classifierDescriptor.getTypeConstructor();
            b41.h(typeConstructor, "enhancedClassifier.typeConstructor");
            int i2 = i + 1;
            boolean z4 = b != null;
            if (z2 && z) {
                i2 += fd2Var.b().size();
                boolean z5 = z4;
                arrayList = fd2Var.b();
                z3 = z5;
            } else {
                List<TypeProjection> b2 = fd2Var.b();
                q = C8215n.q(b2, 10);
                ArrayList arrayList2 = new ArrayList(q);
                int i3 = 0;
                for (Object obj : b2) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        C8214m.p();
                    }
                    TypeProjection typeProjection = (TypeProjection) obj;
                    if (typeProjection.isStarProjection()) {
                        int i5 = i2 + 1;
                        if (function12.invoke(Integer.valueOf(i2)).c() == NullabilityQualifier.NOT_NULL && !z) {
                            z71 p = TypeUtilsKt.p(typeProjection.getType().f());
                            Variance projectionKind = typeProjection.getProjectionKind();
                            b41.h(projectionKind, "arg.projectionKind");
                            e2 = TypeUtilsKt.e(p, projectionKind, typeConstructor.getParameters().get(i3));
                        } else {
                            e2 = fr2.t(classifierDescriptor.getTypeConstructor().getParameters().get(i3));
                            b41.h(e2, "{\n                      …x])\n                    }");
                        }
                        i2 = i5;
                    } else {
                        C9642a e3 = e(typeProjection.getType().f(), function12, i2, z2);
                        z4 = z4 || e3.d();
                        i2 += e3.a();
                        z71 b3 = e3.b();
                        Variance projectionKind2 = typeProjection.getProjectionKind();
                        b41.h(projectionKind2, "arg.projectionKind");
                        e2 = TypeUtilsKt.e(b3, projectionKind2, typeConstructor.getParameters().get(i3));
                    }
                    arrayList2.add(e2);
                    function12 = function1;
                    i3 = i4;
                }
                z3 = z4;
                arrayList = arrayList2;
            }
            h = sq2.h(fd2Var, invoke, typeComponentPosition);
            boolean booleanValue = ((Boolean) h.a()).booleanValue();
            Annotations b4 = h.b();
            int i6 = i2 - i;
            if (!(z3 || b4 != null)) {
                return new C9643b(fd2Var, i6, false);
            }
            boolean z6 = false;
            l = C8214m.l(fd2Var.getAnnotations(), b, b4);
            d = sq2.d(l);
            fd2 i7 = KotlinTypeFactory.i(d, typeConstructor, arrayList, booleanValue, null, 16, null);
            gu2 gu2Var = i7;
            if (invoke.d()) {
                gu2Var = f(i7);
            }
            if (b4 != null && invoke.e()) {
                z6 = true;
            }
            if (z6) {
                gu2Var = gr2.e(fd2Var, gu2Var);
            }
            return new C9643b((fd2) gu2Var, i6, true);
        }
        return new C9643b(fd2Var, 1, false);
    }

    static /* synthetic */ C9643b d(r51 r51Var, fd2 fd2Var, Function1 function1, int i, TypeComponentPosition typeComponentPosition, boolean z, boolean z2, int i2, Object obj) {
        return r51Var.c(fd2Var, function1, i, typeComponentPosition, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? false : z2);
    }

    private final C9642a e(gu2 gu2Var, Function1<? super Integer, s51> function1, int i, boolean z) {
        gu2 gu2Var2 = gu2Var;
        boolean z2 = false;
        if (a81.a(gu2Var)) {
            return new C9642a(gu2Var2, 1, false);
        }
        if (gu2Var2 instanceof ak0) {
            boolean z3 = gu2Var2 instanceof RawType;
            ak0 ak0Var = (ak0) gu2Var2;
            C9643b c = c(ak0Var.k(), function1, i, TypeComponentPosition.FLEXIBLE_LOWER, z3, z);
            C9643b c2 = c(ak0Var.l(), function1, i, TypeComponentPosition.FLEXIBLE_UPPER, z3, z);
            c.a();
            c2.a();
            z2 = (c.d() || c2.d()) ? true : true;
            z71 a = a(c.b(), c2.b());
            if (z2) {
                gu2Var2 = gr2.e(gu2Var2 instanceof RawTypeImpl ? new RawTypeImpl(c.b(), c2.b()) : KotlinTypeFactory.d(c.b(), c2.b()), a);
            }
            return new C9642a(gu2Var2, c.a(), z2);
        } else if (gu2Var2 instanceof fd2) {
            return d(this, (fd2) gu2Var2, function1, i, TypeComponentPosition.INFLEXIBLE, false, z, 8, null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final fd2 f(fd2 fd2Var) {
        if (this.a.getCorrectNullabilityForNotNullTypeParameter()) {
            return bf2.h(fd2Var, true);
        }
        return new ll1(fd2Var);
    }

    @Nullable
    public final z71 b(@NotNull z71 z71Var, @NotNull Function1<? super Integer, s51> function1, boolean z) {
        b41.i(z71Var, "<this>");
        b41.i(function1, "qualifiers");
        return e(z71Var.f(), function1, 0, z).c();
    }
}
