package tb;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.C8213l;
import kotlin.collections.C8215n;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b;
import kotlin.reflect.jvm.internal.impl.builtins.C8277c;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class fj2 {
    @NotNull
    private static final di1 a;
    @NotNull
    private static final di1 b;

    static {
        List<TypeParameterDescriptor> e;
        List<TypeParameterDescriptor> e2;
        ModuleDescriptor q = kf0.q();
        b41.h(q, "getErrorModule()");
        ie0 ie0Var = new ie0(q, C8277c.COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL);
        ClassKind classKind = ClassKind.INTERFACE;
        ni1 g = C8277c.CONTINUATION_INTERFACE_FQ_NAME_EXPERIMENTAL.g();
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        StorageManager storageManager = LockBasedStorageManager.NO_LOCKS;
        di1 di1Var = new di1(ie0Var, classKind, false, false, g, sourceElement, storageManager);
        Modality modality = Modality.ABSTRACT;
        di1Var.g(modality);
        f70 f70Var = e70.PUBLIC;
        di1Var.i(f70Var);
        Annotations.C8302a c8302a = Annotations.Companion;
        Annotations b2 = c8302a.b();
        Variance variance = Variance.IN_VARIANCE;
        e = C8213l.e(wq2.l(di1Var, b2, false, variance, ni1.f("T"), 0, storageManager));
        di1Var.h(e);
        di1Var.e();
        a = di1Var;
        ModuleDescriptor q2 = kf0.q();
        b41.h(q2, "getErrorModule()");
        di1 di1Var2 = new di1(new ie0(q2, C8277c.COROUTINES_PACKAGE_FQ_NAME_RELEASE), classKind, false, false, C8277c.CONTINUATION_INTERFACE_FQ_NAME_RELEASE.g(), sourceElement, storageManager);
        di1Var2.g(modality);
        di1Var2.i(f70Var);
        e2 = C8213l.e(wq2.l(di1Var2, c8302a.b(), false, variance, ni1.f("T"), 0, storageManager));
        di1Var2.h(e2);
        di1Var2.e();
        b = di1Var2;
    }

    public static final boolean a(@Nullable hp0 hp0Var, boolean z) {
        if (z) {
            return b41.d(hp0Var, C8277c.CONTINUATION_INTERFACE_FQ_NAME_RELEASE);
        }
        return b41.d(hp0Var, C8277c.CONTINUATION_INTERFACE_FQ_NAME_EXPERIMENTAL);
    }

    @NotNull
    public static final fd2 b(@NotNull z71 z71Var, boolean z) {
        int q;
        TypeConstructor typeConstructor;
        List e;
        List n0;
        b41.i(z71Var, "suspendFunType");
        up0.o(z71Var);
        AbstractC8271b h = TypeUtilsKt.h(z71Var);
        Annotations annotations = z71Var.getAnnotations();
        z71 h2 = up0.h(z71Var);
        List<TypeProjection> j = up0.j(z71Var);
        q = C8215n.q(j, 10);
        ArrayList arrayList = new ArrayList(q);
        for (TypeProjection typeProjection : j) {
            arrayList.add(typeProjection.getType());
        }
        Annotations b2 = Annotations.Companion.b();
        if (z) {
            typeConstructor = b.getTypeConstructor();
        } else {
            typeConstructor = a.getTypeConstructor();
        }
        TypeConstructor typeConstructor2 = typeConstructor;
        b41.h(typeConstructor2, "if (isReleaseCoroutines)…ERIMENTAL.typeConstructor");
        e = C8213l.e(TypeUtilsKt.a(up0.i(z71Var)));
        n0 = CollectionsKt___CollectionsKt.n0(arrayList, KotlinTypeFactory.i(b2, typeConstructor2, e, false, null, 16, null));
        fd2 I = TypeUtilsKt.h(z71Var).I();
        b41.h(I, "suspendFunType.builtIns.nullableAnyType");
        return up0.b(h, annotations, h2, n0, null, I, false, 64, null).j(z71Var.d());
    }
}
