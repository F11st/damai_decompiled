package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.C8215n;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ak1 {
    private static final List<TypeProjection> a(gu2 gu2Var, CaptureStatus captureStatus) {
        boolean z;
        List<Pair> H0;
        int q;
        if (gu2Var.b().size() != gu2Var.c().getParameters().size()) {
            return null;
        }
        List<TypeProjection> b = gu2Var.b();
        int i = 0;
        boolean z2 = true;
        if (!(b instanceof Collection) || !b.isEmpty()) {
            Iterator<T> it = b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((TypeProjection) it.next()).getProjectionKind() == Variance.INVARIANT) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (!z) {
                    z2 = false;
                    break;
                }
            }
        }
        if (z2) {
            return null;
        }
        List<TypeParameterDescriptor> parameters = gu2Var.c().getParameters();
        b41.h(parameters, "type.constructor.parameters");
        H0 = CollectionsKt___CollectionsKt.H0(b, parameters);
        q = C8215n.q(H0, 10);
        ArrayList arrayList = new ArrayList(q);
        for (Pair pair : H0) {
            TypeProjection typeProjection = (TypeProjection) pair.component1();
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) pair.component2();
            if (typeProjection.getProjectionKind() != Variance.INVARIANT) {
                gu2 f = (typeProjection.isStarProjection() || typeProjection.getProjectionKind() != Variance.IN_VARIANCE) ? null : typeProjection.getType().f();
                b41.h(typeParameterDescriptor, "parameter");
                typeProjection = TypeUtilsKt.a(new zj1(captureStatus, f, typeProjection, typeParameterDescriptor));
            }
            arrayList.add(typeProjection);
        }
        TypeSubstitutor c = oq2.Companion.a(gu2Var.c(), arrayList).c();
        int size = b.size() - 1;
        if (size >= 0) {
            while (true) {
                int i2 = i + 1;
                TypeProjection typeProjection2 = b.get(i);
                TypeProjection typeProjection3 = (TypeProjection) arrayList.get(i);
                if (typeProjection2.getProjectionKind() != Variance.INVARIANT) {
                    List<z71> upperBounds = gu2Var.c().getParameters().get(i).getUpperBounds();
                    b41.h(upperBounds, "type.constructor.parameters[index].upperBounds");
                    ArrayList arrayList2 = new ArrayList();
                    for (z71 z71Var : upperBounds) {
                        arrayList2.add(KotlinTypePreparator.C8547a.INSTANCE.a(c.n(z71Var, Variance.INVARIANT).f()));
                    }
                    if (!typeProjection2.isStarProjection() && typeProjection2.getProjectionKind() == Variance.OUT_VARIANCE) {
                        arrayList2.add(KotlinTypePreparator.C8547a.INSTANCE.a(typeProjection2.getType().f()));
                    }
                    ((zj1) typeProjection3.getType()).c().d(arrayList2);
                }
                if (i2 > size) {
                    break;
                }
                i = i2;
            }
        }
        return arrayList;
    }

    @Nullable
    public static final fd2 b(@NotNull fd2 fd2Var, @NotNull CaptureStatus captureStatus) {
        b41.i(fd2Var, "type");
        b41.i(captureStatus, "status");
        List<TypeProjection> a = a(fd2Var, captureStatus);
        if (a == null) {
            return null;
        }
        return c(fd2Var, a);
    }

    private static final fd2 c(gu2 gu2Var, List<? extends TypeProjection> list) {
        return KotlinTypeFactory.i(gu2Var.getAnnotations(), gu2Var.c(), list, gu2Var.d(), null, 16, null);
    }
}
