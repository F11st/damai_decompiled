package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import tb.ak0;
import tb.b41;
import tb.fd2;
import tb.fr2;
import tb.gr2;
import tb.gu2;
import tb.lg;
import tb.t31;
import tb.z71;
import tb.zj1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class KotlinTypePreparator {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a extends KotlinTypePreparator {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }
    }

    private final fd2 b(fd2 fd2Var) {
        int q;
        int q2;
        List g;
        z71 type;
        int q3;
        TypeConstructor c = fd2Var.c();
        boolean z = false;
        IntersectionTypeConstructor intersectionTypeConstructor = null;
        r5 = null;
        gu2 f = null;
        if (c instanceof lg) {
            lg lgVar = (lg) c;
            TypeProjection projection = lgVar.getProjection();
            if (!(projection.getProjectionKind() == Variance.IN_VARIANCE)) {
                projection = null;
            }
            if (projection != null && (type = projection.getType()) != null) {
                f = type.f();
            }
            gu2 gu2Var = f;
            if (lgVar.b() == null) {
                TypeProjection projection2 = lgVar.getProjection();
                Collection<z71> supertypes = lgVar.getSupertypes();
                q3 = n.q(supertypes, 10);
                ArrayList arrayList = new ArrayList(q3);
                for (z71 z71Var : supertypes) {
                    arrayList.add(z71Var.f());
                }
                lgVar.d(new NewCapturedTypeConstructor(projection2, arrayList, null, 4, null));
            }
            CaptureStatus captureStatus = CaptureStatus.FOR_SUBTYPING;
            NewCapturedTypeConstructor b = lgVar.b();
            b41.f(b);
            return new zj1(captureStatus, b, gu2Var, fd2Var.getAnnotations(), fd2Var.d(), false, 32, null);
        } else if (c instanceof t31) {
            Collection<z71> supertypes2 = ((t31) c).getSupertypes();
            q2 = n.q(supertypes2, 10);
            ArrayList arrayList2 = new ArrayList(q2);
            for (z71 z71Var2 : supertypes2) {
                z71 q4 = fr2.q(z71Var2, fd2Var.d());
                b41.h(q4, "makeNullableAsSpecified(it, type.isMarkedNullable)");
                arrayList2.add(q4);
            }
            IntersectionTypeConstructor intersectionTypeConstructor2 = new IntersectionTypeConstructor(arrayList2);
            Annotations annotations = fd2Var.getAnnotations();
            g = m.g();
            return KotlinTypeFactory.j(annotations, intersectionTypeConstructor2, g, false, fd2Var.getMemberScope());
        } else if ((c instanceof IntersectionTypeConstructor) && fd2Var.d()) {
            IntersectionTypeConstructor intersectionTypeConstructor3 = (IntersectionTypeConstructor) c;
            Collection<z71> supertypes3 = intersectionTypeConstructor3.getSupertypes();
            q = n.q(supertypes3, 10);
            ArrayList arrayList3 = new ArrayList(q);
            for (z71 z71Var3 : supertypes3) {
                arrayList3.add(TypeUtilsKt.q(z71Var3));
                z = true;
            }
            if (z) {
                z71 c2 = intersectionTypeConstructor3.c();
                intersectionTypeConstructor = new IntersectionTypeConstructor(arrayList3).g(c2 != null ? TypeUtilsKt.q(c2) : null);
            }
            if (intersectionTypeConstructor != null) {
                intersectionTypeConstructor3 = intersectionTypeConstructor;
            }
            return intersectionTypeConstructor3.b();
        } else {
            return fd2Var;
        }
    }

    @NotNull
    public gu2 a(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        gu2 d;
        b41.i(kotlinTypeMarker, "type");
        if (kotlinTypeMarker instanceof z71) {
            gu2 f = ((z71) kotlinTypeMarker).f();
            if (f instanceof fd2) {
                d = b((fd2) f);
            } else if (f instanceof ak0) {
                ak0 ak0Var = (ak0) f;
                fd2 b = b(ak0Var.k());
                fd2 b2 = b(ak0Var.l());
                d = (b == ak0Var.k() && b2 == ak0Var.l()) ? f : KotlinTypeFactory.d(b, b2);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return gr2.c(d, f, new KotlinTypePreparator$prepareType$1(this));
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
