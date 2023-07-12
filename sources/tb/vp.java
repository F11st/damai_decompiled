package tb;

import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KMutableProperty0Impl;
import kotlin.reflect.jvm.internal.KMutableProperty1Impl;
import kotlin.reflect.jvm.internal.KMutableProperty2Impl;
import kotlin.reflect.jvm.internal.KProperty0Impl;
import kotlin.reflect.jvm.internal.KProperty1Impl;
import kotlin.reflect.jvm.internal.KProperty2Impl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class vp extends v40<KCallableImpl<?>, wt2> {
    private final KDeclarationContainerImpl a;

    public vp(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl) {
        b41.i(kDeclarationContainerImpl, "container");
        this.a = kDeclarationContainerImpl;
    }

    @Override // tb.v40, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    @NotNull
    /* renamed from: c */
    public KCallableImpl<?> visitFunctionDescriptor(@NotNull FunctionDescriptor functionDescriptor, @NotNull wt2 wt2Var) {
        b41.i(functionDescriptor, "descriptor");
        b41.i(wt2Var, "data");
        return new KFunctionImpl(this.a, functionDescriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    @NotNull
    /* renamed from: d */
    public KCallableImpl<?> visitPropertyDescriptor(@NotNull PropertyDescriptor propertyDescriptor, @NotNull wt2 wt2Var) {
        b41.i(propertyDescriptor, "descriptor");
        b41.i(wt2Var, "data");
        int i = (propertyDescriptor.getDispatchReceiverParameter() != null ? 1 : 0) + (propertyDescriptor.getExtensionReceiverParameter() != null ? 1 : 0);
        if (propertyDescriptor.isVar()) {
            if (i == 0) {
                return new KMutableProperty0Impl(this.a, propertyDescriptor);
            }
            if (i == 1) {
                return new KMutableProperty1Impl(this.a, propertyDescriptor);
            }
            if (i == 2) {
                return new KMutableProperty2Impl(this.a, propertyDescriptor);
            }
        } else if (i == 0) {
            return new KProperty0Impl(this.a, propertyDescriptor);
        } else {
            if (i == 1) {
                return new KProperty1Impl(this.a, propertyDescriptor);
            }
            if (i == 2) {
                return new KProperty2Impl(this.a, propertyDescriptor);
            }
        }
        throw new KotlinReflectionInternalError("Unsupported property: " + propertyDescriptor);
    }
}
