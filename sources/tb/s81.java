package tb;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class s81 extends LazyJavaScope {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s81(@NotNull r81 r81Var) {
        super(r81Var, null, 2, null);
        b41.i(r81Var, com.huawei.hms.opendevice.c.a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    protected LazyJavaScope.a A(@NotNull JavaMethod javaMethod, @NotNull List<? extends TypeParameterDescriptor> list, @NotNull z71 z71Var, @NotNull List<? extends ValueParameterDescriptor> list2) {
        List g;
        b41.i(javaMethod, "method");
        b41.i(list, "methodTypeParameters");
        b41.i(z71Var, "returnType");
        b41.i(list2, "valueParameters");
        g = kotlin.collections.m.g();
        return new LazyJavaScope.a(z71Var, null, list2, list, false, g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void l(@NotNull ni1 ni1Var, @NotNull Collection<PropertyDescriptor> collection) {
        b41.i(ni1Var, "name");
        b41.i(collection, "result");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @Nullable
    protected ReceiverParameterDescriptor s() {
        return null;
    }
}
