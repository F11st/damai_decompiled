package kotlin.reflect.jvm.internal.impl.load.java;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.mf1;
import tb.ni1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class BuiltinMethodsWithSpecialGenericSignature extends SpecialGenericSignatures {
    @NotNull
    public static final BuiltinMethodsWithSpecialGenericSignature INSTANCE = new BuiltinMethodsWithSpecialGenericSignature();

    private BuiltinMethodsWithSpecialGenericSignature() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(CallableMemberDescriptor callableMemberDescriptor) {
        boolean J;
        J = CollectionsKt___CollectionsKt.J(SpecialGenericSignatures.Companion.e(), mf1.d(callableMemberDescriptor));
        return J;
    }

    @JvmStatic
    @Nullable
    public static final FunctionDescriptor k(@NotNull FunctionDescriptor functionDescriptor) {
        b41.i(functionDescriptor, "functionDescriptor");
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = INSTANCE;
        ni1 name = functionDescriptor.getName();
        b41.h(name, "functionDescriptor.name");
        if (builtinMethodsWithSpecialGenericSignature.l(name)) {
            return (FunctionDescriptor) DescriptorUtilsKt.d(functionDescriptor, false, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature$getOverriddenBuiltinFunctionWithErasedValueParametersInJava$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
                    boolean j;
                    b41.i(callableMemberDescriptor, AdvanceSetting.NETWORK_TYPE);
                    j = BuiltinMethodsWithSpecialGenericSignature.INSTANCE.j(callableMemberDescriptor);
                    return Boolean.valueOf(j);
                }
            }, 1, null);
        }
        return null;
    }

    @JvmStatic
    @Nullable
    public static final SpecialGenericSignatures.SpecialSignatureInfo m(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        b41.i(callableMemberDescriptor, "<this>");
        SpecialGenericSignatures.C8333a c8333a = SpecialGenericSignatures.Companion;
        if (c8333a.d().contains(callableMemberDescriptor.getName())) {
            CallableMemberDescriptor d = DescriptorUtilsKt.d(callableMemberDescriptor, false, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull CallableMemberDescriptor callableMemberDescriptor2) {
                    boolean z;
                    boolean j;
                    b41.i(callableMemberDescriptor2, AdvanceSetting.NETWORK_TYPE);
                    if (callableMemberDescriptor2 instanceof FunctionDescriptor) {
                        j = BuiltinMethodsWithSpecialGenericSignature.INSTANCE.j(callableMemberDescriptor2);
                        if (j) {
                            z = true;
                            return Boolean.valueOf(z);
                        }
                    }
                    z = false;
                    return Boolean.valueOf(z);
                }
            }, 1, null);
            String d2 = d == null ? null : mf1.d(d);
            if (d2 == null) {
                return null;
            }
            return c8333a.l(d2);
        }
        return null;
    }

    public final boolean l(@NotNull ni1 ni1Var) {
        b41.i(ni1Var, "<this>");
        return SpecialGenericSignatures.Companion.d().contains(ni1Var);
    }
}
