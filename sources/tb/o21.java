package tb;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.C8277c;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class o21 {
    private static final boolean a(ClassDescriptor classDescriptor) {
        return b41.d(DescriptorUtilsKt.i(classDescriptor), C8277c.RESULT_FQ_NAME);
    }

    public static final boolean b(@NotNull DeclarationDescriptor declarationDescriptor) {
        b41.i(declarationDescriptor, "<this>");
        return q21.b(declarationDescriptor) && !a((ClassDescriptor) declarationDescriptor);
    }

    public static final boolean c(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        ClassifierDescriptor declarationDescriptor = z71Var.c().getDeclarationDescriptor();
        return declarationDescriptor != null && b(declarationDescriptor);
    }

    private static final boolean d(z71 z71Var) {
        ClassifierDescriptor declarationDescriptor = z71Var.c().getDeclarationDescriptor();
        TypeParameterDescriptor typeParameterDescriptor = declarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) declarationDescriptor : null;
        if (typeParameterDescriptor == null) {
            return false;
        }
        return e(TypeUtilsKt.i(typeParameterDescriptor));
    }

    private static final boolean e(z71 z71Var) {
        return c(z71Var) || d(z71Var);
    }

    public static final boolean f(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        b41.i(callableMemberDescriptor, "descriptor");
        ClassConstructorDescriptor classConstructorDescriptor = callableMemberDescriptor instanceof ClassConstructorDescriptor ? (ClassConstructorDescriptor) callableMemberDescriptor : null;
        if (classConstructorDescriptor == null || e70.g(classConstructorDescriptor.getVisibility())) {
            return false;
        }
        ClassDescriptor constructedClass = classConstructorDescriptor.getConstructedClass();
        b41.h(constructedClass, "constructorDescriptor.constructedClass");
        if (q21.b(constructedClass) || d70.G(classConstructorDescriptor.getConstructedClass())) {
            return false;
        }
        List<ValueParameterDescriptor> valueParameters = classConstructorDescriptor.getValueParameters();
        b41.h(valueParameters, "constructorDescriptor.valueParameters");
        if ((valueParameters instanceof Collection) && valueParameters.isEmpty()) {
            return false;
        }
        for (ValueParameterDescriptor valueParameterDescriptor : valueParameters) {
            z71 type = valueParameterDescriptor.getType();
            b41.h(type, "it.type");
            if (e(type)) {
                return true;
            }
        }
        return false;
    }
}
