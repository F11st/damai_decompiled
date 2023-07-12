package tb;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedureCallbacks;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class nw2 {
    private static final z71 a(z71 z71Var) {
        return CapturedTypeApproximationKt.a(z71Var).d();
    }

    private static final String b(TypeConstructor typeConstructor) {
        StringBuilder sb = new StringBuilder();
        c(b41.r("type: ", typeConstructor), sb);
        c(b41.r("hashCode: ", Integer.valueOf(typeConstructor.hashCode())), sb);
        c(b41.r("javaClass: ", typeConstructor.getClass().getCanonicalName()), sb);
        for (DeclarationDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor(); declarationDescriptor != null; declarationDescriptor = declarationDescriptor.getContainingDeclaration()) {
            c(b41.r("fqName: ", DescriptorRenderer.FQ_NAMES_IN_TYPES.a(declarationDescriptor)), sb);
            c(b41.r("javaClass: ", declarationDescriptor.getClass().getCanonicalName()), sb);
        }
        String sb2 = sb.toString();
        b41.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private static final StringBuilder c(String str, StringBuilder sb) {
        b41.i(str, "<this>");
        sb.append(str);
        b41.h(sb, "append(value)");
        sb.append('\n');
        b41.h(sb, "append('\\n')");
        return sb;
    }

    @Nullable
    public static final z71 d(@NotNull z71 z71Var, @NotNull z71 z71Var2, @NotNull TypeCheckingProcedureCallbacks typeCheckingProcedureCallbacks) {
        boolean z;
        boolean z2;
        b41.i(z71Var, "subtype");
        b41.i(z71Var2, "supertype");
        b41.i(typeCheckingProcedureCallbacks, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new ti2(z71Var, null));
        TypeConstructor c = z71Var2.c();
        while (!arrayDeque.isEmpty()) {
            ti2 ti2Var = (ti2) arrayDeque.poll();
            z71 b = ti2Var.b();
            TypeConstructor c2 = b.c();
            if (typeCheckingProcedureCallbacks.assertEqualTypeConstructors(c2, c)) {
                boolean d = b.d();
                for (ti2 a = ti2Var.a(); a != null; a = a.a()) {
                    z71 b2 = a.b();
                    List<TypeProjection> b3 = b2.b();
                    if (!(b3 instanceof Collection) || !b3.isEmpty()) {
                        for (TypeProjection typeProjection : b3) {
                            if (typeProjection.getProjectionKind() != Variance.INVARIANT) {
                                z = true;
                                continue;
                            } else {
                                z = false;
                                continue;
                            }
                            if (z) {
                                z2 = true;
                                break;
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                        z71 n = CapturedTypeConstructorKt.f(oq2.Companion.b(b2), false, 1, null).c().n(b, Variance.INVARIANT);
                        b41.h(n, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
                        b = a(n);
                    } else {
                        b = oq2.Companion.b(b2).c().n(b, Variance.INVARIANT);
                        b41.h(b, "{\n                    Ty…ARIANT)\n                }");
                    }
                    d = d || b2.d();
                }
                TypeConstructor c3 = b.c();
                if (typeCheckingProcedureCallbacks.assertEqualTypeConstructors(c3, c)) {
                    return fr2.q(b, d);
                }
                throw new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + b(c3) + ", \n\nsupertype: " + b(c) + " \n" + typeCheckingProcedureCallbacks.assertEqualTypeConstructors(c3, c));
            }
            for (z71 z71Var3 : c2.getSupertypes()) {
                b41.h(z71Var3, "immediateSupertype");
                arrayDeque.add(new ti2(z71Var3, ti2Var));
            }
        }
        return null;
    }
}
