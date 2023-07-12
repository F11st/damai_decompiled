package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class yv2 {
    @NotNull
    public static final List<ValueParameterDescriptor> a(@NotNull Collection<ax2> collection, @NotNull Collection<? extends ValueParameterDescriptor> collection2, @NotNull CallableDescriptor callableDescriptor) {
        List<Pair> H0;
        int q;
        b41.i(collection, "newValueParametersTypes");
        b41.i(collection2, "oldValueParameters");
        b41.i(callableDescriptor, "newOwner");
        collection.size();
        collection2.size();
        H0 = CollectionsKt___CollectionsKt.H0(collection, collection2);
        q = kotlin.collections.n.q(H0, 10);
        ArrayList arrayList = new ArrayList(q);
        for (Pair pair : H0) {
            ax2 ax2Var = (ax2) pair.component1();
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) pair.component2();
            int index = valueParameterDescriptor.getIndex();
            Annotations annotations = valueParameterDescriptor.getAnnotations();
            ni1 name = valueParameterDescriptor.getName();
            b41.h(name, "oldParameter.name");
            z71 b = ax2Var.b();
            boolean a = ax2Var.a();
            boolean isCrossinline = valueParameterDescriptor.isCrossinline();
            boolean isNoinline = valueParameterDescriptor.isNoinline();
            z71 k = valueParameterDescriptor.getVarargElementType() != null ? DescriptorUtilsKt.l(callableDescriptor).getBuiltIns().k(ax2Var.b()) : null;
            SourceElement source = valueParameterDescriptor.getSource();
            b41.h(source, "oldParameter.source");
            arrayList.add(new ValueParameterDescriptorImpl(callableDescriptor, null, index, annotations, name, b, a, isCrossinline, isNoinline, k, source));
        }
        return arrayList;
    }

    @Nullable
    public static final LazyJavaStaticClassScope b(@NotNull ClassDescriptor classDescriptor) {
        b41.i(classDescriptor, "<this>");
        ClassDescriptor p = DescriptorUtilsKt.p(classDescriptor);
        if (p == null) {
            return null;
        }
        MemberScope staticScope = p.getStaticScope();
        LazyJavaStaticClassScope lazyJavaStaticClassScope = staticScope instanceof LazyJavaStaticClassScope ? (LazyJavaStaticClassScope) staticScope : null;
        return lazyJavaStaticClassScope == null ? b(p) : lazyJavaStaticClassScope;
    }
}
