package tb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.C8215n;
import kotlin.collections.C8226x;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import tb.oq2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class gd1 {
    @NotNull
    public static final oq2 a(@NotNull ClassDescriptor classDescriptor, @NotNull ClassDescriptor classDescriptor2) {
        int q;
        int q2;
        List H0;
        Map r;
        b41.i(classDescriptor, "from");
        b41.i(classDescriptor2, "to");
        classDescriptor.getDeclaredTypeParameters().size();
        classDescriptor2.getDeclaredTypeParameters().size();
        oq2.C9530a c9530a = oq2.Companion;
        List<TypeParameterDescriptor> declaredTypeParameters = classDescriptor.getDeclaredTypeParameters();
        b41.h(declaredTypeParameters, "from.declaredTypeParameters");
        q = C8215n.q(declaredTypeParameters, 10);
        ArrayList arrayList = new ArrayList(q);
        for (TypeParameterDescriptor typeParameterDescriptor : declaredTypeParameters) {
            arrayList.add(typeParameterDescriptor.getTypeConstructor());
        }
        List<TypeParameterDescriptor> declaredTypeParameters2 = classDescriptor2.getDeclaredTypeParameters();
        b41.h(declaredTypeParameters2, "to.declaredTypeParameters");
        q2 = C8215n.q(declaredTypeParameters2, 10);
        ArrayList arrayList2 = new ArrayList(q2);
        for (TypeParameterDescriptor typeParameterDescriptor2 : declaredTypeParameters2) {
            fd2 defaultType = typeParameterDescriptor2.getDefaultType();
            b41.h(defaultType, "it.defaultType");
            arrayList2.add(TypeUtilsKt.a(defaultType));
        }
        H0 = CollectionsKt___CollectionsKt.H0(arrayList, arrayList2);
        r = C8226x.r(H0);
        return oq2.C9530a.e(c9530a, r, false, 2, null);
    }
}
