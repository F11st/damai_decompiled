package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.C8220r;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class lm implements SyntheticJavaPartsProvider {
    @NotNull
    private final List<SyntheticJavaPartsProvider> a;

    /* JADX WARN: Multi-variable type inference failed */
    public lm(@NotNull List<? extends SyntheticJavaPartsProvider> list) {
        b41.i(list, "inner");
        this.a = list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateConstructors(@NotNull ClassDescriptor classDescriptor, @NotNull List<ClassConstructorDescriptor> list) {
        b41.i(classDescriptor, "thisDescriptor");
        b41.i(list, "result");
        for (SyntheticJavaPartsProvider syntheticJavaPartsProvider : this.a) {
            syntheticJavaPartsProvider.generateConstructors(classDescriptor, list);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateMethods(@NotNull ClassDescriptor classDescriptor, @NotNull ni1 ni1Var, @NotNull Collection<SimpleFunctionDescriptor> collection) {
        b41.i(classDescriptor, "thisDescriptor");
        b41.i(ni1Var, "name");
        b41.i(collection, "result");
        for (SyntheticJavaPartsProvider syntheticJavaPartsProvider : this.a) {
            syntheticJavaPartsProvider.generateMethods(classDescriptor, ni1Var, collection);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateStaticFunctions(@NotNull ClassDescriptor classDescriptor, @NotNull ni1 ni1Var, @NotNull Collection<SimpleFunctionDescriptor> collection) {
        b41.i(classDescriptor, "thisDescriptor");
        b41.i(ni1Var, "name");
        b41.i(collection, "result");
        for (SyntheticJavaPartsProvider syntheticJavaPartsProvider : this.a) {
            syntheticJavaPartsProvider.generateStaticFunctions(classDescriptor, ni1Var, collection);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    @NotNull
    public List<ni1> getMethodNames(@NotNull ClassDescriptor classDescriptor) {
        b41.i(classDescriptor, "thisDescriptor");
        List<SyntheticJavaPartsProvider> list = this.a;
        ArrayList arrayList = new ArrayList();
        for (SyntheticJavaPartsProvider syntheticJavaPartsProvider : list) {
            C8220r.v(arrayList, syntheticJavaPartsProvider.getMethodNames(classDescriptor));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    @NotNull
    public List<ni1> getStaticFunctionNames(@NotNull ClassDescriptor classDescriptor) {
        b41.i(classDescriptor, "thisDescriptor");
        List<SyntheticJavaPartsProvider> list = this.a;
        ArrayList arrayList = new ArrayList();
        for (SyntheticJavaPartsProvider syntheticJavaPartsProvider : list) {
            C8220r.v(arrayList, syntheticJavaPartsProvider.getStaticFunctionNames(classDescriptor));
        }
        return arrayList;
    }
}
