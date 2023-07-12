package tb;

import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.c71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class i51 implements ExternalOverridabilityCondition {
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        private final boolean b(FunctionDescriptor functionDescriptor) {
            if (functionDescriptor.getValueParameters().size() != 1) {
                return false;
            }
            DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
            ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
            if (classDescriptor == null) {
                return false;
            }
            List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
            b41.h(valueParameters, "f.valueParameters");
            ClassifierDescriptor declarationDescriptor = ((ValueParameterDescriptor) kotlin.collections.k.q0(valueParameters)).getType().c().getDeclarationDescriptor();
            ClassDescriptor classDescriptor2 = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
            return classDescriptor2 != null && kotlin.reflect.jvm.internal.impl.builtins.b.p0(classDescriptor) && b41.d(DescriptorUtilsKt.i(classDescriptor), DescriptorUtilsKt.i(classDescriptor2));
        }

        private final c71 c(FunctionDescriptor functionDescriptor, ValueParameterDescriptor valueParameterDescriptor) {
            if (!mf1.e(functionDescriptor) && !b(functionDescriptor)) {
                z71 type = valueParameterDescriptor.getType();
                b41.h(type, "valueParameterDescriptor.type");
                return mf1.g(type);
            }
            z71 type2 = valueParameterDescriptor.getType();
            b41.h(type2, "valueParameterDescriptor.type");
            return mf1.g(TypeUtilsKt.q(type2));
        }

        public final boolean a(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2) {
            List<Pair> H0;
            b41.i(callableDescriptor, "superDescriptor");
            b41.i(callableDescriptor2, "subDescriptor");
            if ((callableDescriptor2 instanceof JavaMethodDescriptor) && (callableDescriptor instanceof FunctionDescriptor)) {
                JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) callableDescriptor2;
                javaMethodDescriptor.getValueParameters().size();
                FunctionDescriptor functionDescriptor = (FunctionDescriptor) callableDescriptor;
                functionDescriptor.getValueParameters().size();
                List<ValueParameterDescriptor> valueParameters = javaMethodDescriptor.getOriginal().getValueParameters();
                b41.h(valueParameters, "subDescriptor.original.valueParameters");
                List<ValueParameterDescriptor> valueParameters2 = functionDescriptor.getOriginal().getValueParameters();
                b41.h(valueParameters2, "superDescriptor.original.valueParameters");
                H0 = CollectionsKt___CollectionsKt.H0(valueParameters, valueParameters2);
                for (Pair pair : H0) {
                    ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) pair.component1();
                    ValueParameterDescriptor valueParameterDescriptor2 = (ValueParameterDescriptor) pair.component2();
                    b41.h(valueParameterDescriptor, "subParameter");
                    boolean z = c((FunctionDescriptor) callableDescriptor2, valueParameterDescriptor) instanceof c71.d;
                    b41.h(valueParameterDescriptor2, "superParameter");
                    if (z != (c(functionDescriptor, valueParameterDescriptor2) instanceof c71.d)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private final boolean a(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor) {
        if ((callableDescriptor instanceof CallableMemberDescriptor) && (callableDescriptor2 instanceof FunctionDescriptor) && !kotlin.reflect.jvm.internal.impl.builtins.b.e0(callableDescriptor2)) {
            BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
            FunctionDescriptor functionDescriptor = (FunctionDescriptor) callableDescriptor2;
            ni1 name = functionDescriptor.getName();
            b41.h(name, "subDescriptor.name");
            if (!builtinMethodsWithSpecialGenericSignature.l(name)) {
                SpecialGenericSignatures.a aVar = SpecialGenericSignatures.Companion;
                ni1 name2 = functionDescriptor.getName();
                b41.h(name2, "subDescriptor.name");
                if (!aVar.k(name2)) {
                    return false;
                }
            }
            CallableMemberDescriptor e = SpecialBuiltinMembers.e((CallableMemberDescriptor) callableDescriptor);
            boolean isHiddenToOvercomeSignatureClash = functionDescriptor.isHiddenToOvercomeSignatureClash();
            boolean z = callableDescriptor instanceof FunctionDescriptor;
            FunctionDescriptor functionDescriptor2 = z ? (FunctionDescriptor) callableDescriptor : null;
            if ((!(functionDescriptor2 != null && isHiddenToOvercomeSignatureClash == functionDescriptor2.isHiddenToOvercomeSignatureClash())) && (e == null || !functionDescriptor.isHiddenToOvercomeSignatureClash())) {
                return true;
            }
            if ((classDescriptor instanceof JavaClassDescriptor) && functionDescriptor.getInitialSignatureDescriptor() == null && e != null && !SpecialBuiltinMembers.f(classDescriptor, e)) {
                if ((e instanceof FunctionDescriptor) && z && BuiltinMethodsWithSpecialGenericSignature.k((FunctionDescriptor) e) != null) {
                    String c = mf1.c(functionDescriptor, false, false, 2, null);
                    FunctionDescriptor original = ((FunctionDescriptor) callableDescriptor).getOriginal();
                    b41.h(original, "superDescriptor.original");
                    if (b41.d(c, mf1.c(original, false, false, 2, null))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @NotNull
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @NotNull
    public ExternalOverridabilityCondition.Result isOverridable(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2, @Nullable ClassDescriptor classDescriptor) {
        b41.i(callableDescriptor, "superDescriptor");
        b41.i(callableDescriptor2, "subDescriptor");
        if (a(callableDescriptor, callableDescriptor2, classDescriptor)) {
            return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
        }
        if (Companion.a(callableDescriptor, callableDescriptor2)) {
            return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
        }
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
