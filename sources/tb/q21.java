package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class q21 {
    static {
        new hp0("kotlin.jvm.JvmInline");
    }

    public static final boolean a(@NotNull CallableDescriptor callableDescriptor) {
        b41.i(callableDescriptor, "<this>");
        if (callableDescriptor instanceof PropertyGetterDescriptor) {
            PropertyDescriptor correspondingProperty = ((PropertyGetterDescriptor) callableDescriptor).getCorrespondingProperty();
            b41.h(correspondingProperty, "correspondingProperty");
            if (d(correspondingProperty)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean b(@NotNull DeclarationDescriptor declarationDescriptor) {
        b41.i(declarationDescriptor, "<this>");
        if (declarationDescriptor instanceof ClassDescriptor) {
            ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
            if (classDescriptor.isInline() || classDescriptor.isValue()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean c(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        ClassifierDescriptor declarationDescriptor = z71Var.c().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return false;
        }
        return b(declarationDescriptor);
    }

    public static final boolean d(@NotNull VariableDescriptor variableDescriptor) {
        p21<fd2> inlineClassRepresentation;
        b41.i(variableDescriptor, "<this>");
        if (variableDescriptor.getExtensionReceiverParameter() == null) {
            DeclarationDescriptor containingDeclaration = variableDescriptor.getContainingDeclaration();
            ni1 ni1Var = null;
            ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
            if (classDescriptor != null && (inlineClassRepresentation = classDescriptor.getInlineClassRepresentation()) != null) {
                ni1Var = inlineClassRepresentation.a();
            }
            if (b41.d(ni1Var, variableDescriptor.getName())) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static final z71 e(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        z71 f = f(z71Var);
        if (f == null) {
            return null;
        }
        return TypeSubstitutor.f(z71Var).q(f, Variance.INVARIANT);
    }

    @Nullable
    public static final z71 f(@NotNull z71 z71Var) {
        p21<fd2> inlineClassRepresentation;
        b41.i(z71Var, "<this>");
        ClassifierDescriptor declarationDescriptor = z71Var.c().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof ClassDescriptor)) {
            declarationDescriptor = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
        if (classDescriptor == null || (inlineClassRepresentation = classDescriptor.getInlineClassRepresentation()) == null) {
            return null;
        }
        return inlineClassRepresentation.b();
    }
}
