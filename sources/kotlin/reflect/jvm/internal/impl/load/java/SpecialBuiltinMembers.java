package kotlin.reflect.jvm.internal.impl.load.java;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.d70;
import tb.fd2;
import tb.fe;
import tb.mq2;
import tb.ni1;

/* compiled from: Taobao */
@JvmName(name = "SpecialBuiltinMembers")
/* loaded from: classes3.dex */
public final class SpecialBuiltinMembers {
    public static final boolean a(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        b41.i(callableMemberDescriptor, "<this>");
        return d(callableMemberDescriptor) != null;
    }

    @Nullable
    public static final String b(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        ni1 i;
        b41.i(callableMemberDescriptor, "callableMemberDescriptor");
        CallableMemberDescriptor c = c(callableMemberDescriptor);
        CallableMemberDescriptor o = c == null ? null : DescriptorUtilsKt.o(c);
        if (o == null) {
            return null;
        }
        if (o instanceof PropertyDescriptor) {
            return ClassicBuiltinSpecialProperties.INSTANCE.a(o);
        }
        if (!(o instanceof SimpleFunctionDescriptor) || (i = BuiltinMethodsWithDifferentJvmName.INSTANCE.i((SimpleFunctionDescriptor) o)) == null) {
            return null;
        }
        return i.b();
    }

    private static final CallableMemberDescriptor c(CallableMemberDescriptor callableMemberDescriptor) {
        if (b.e0(callableMemberDescriptor)) {
            return d(callableMemberDescriptor);
        }
        return null;
    }

    @Nullable
    public static final <T extends CallableMemberDescriptor> T d(@NotNull T t) {
        b41.i(t, "<this>");
        if (SpecialGenericSignatures.Companion.g().contains(t.getName()) || fe.INSTANCE.d().contains(DescriptorUtilsKt.o(t).getName())) {
            if (t instanceof PropertyDescriptor ? true : t instanceof PropertyAccessorDescriptor) {
                return (T) DescriptorUtilsKt.d(t, false, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$1
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
                        b41.i(callableMemberDescriptor, AdvanceSetting.NETWORK_TYPE);
                        return Boolean.valueOf(ClassicBuiltinSpecialProperties.INSTANCE.b(DescriptorUtilsKt.o(callableMemberDescriptor)));
                    }
                }, 1, null);
            }
            if (t instanceof SimpleFunctionDescriptor) {
                return (T) DescriptorUtilsKt.d(t, false, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$2
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
                        b41.i(callableMemberDescriptor, AdvanceSetting.NETWORK_TYPE);
                        return Boolean.valueOf(BuiltinMethodsWithDifferentJvmName.INSTANCE.j((SimpleFunctionDescriptor) callableMemberDescriptor));
                    }
                }, 1, null);
            }
            return null;
        }
        return null;
    }

    @Nullable
    public static final <T extends CallableMemberDescriptor> T e(@NotNull T t) {
        b41.i(t, "<this>");
        T t2 = (T) d(t);
        if (t2 == null) {
            BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
            ni1 name = t.getName();
            b41.h(name, "name");
            if (builtinMethodsWithSpecialGenericSignature.l(name)) {
                return (T) DescriptorUtilsKt.d(t, false, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
                        b41.i(callableMemberDescriptor, AdvanceSetting.NETWORK_TYPE);
                        return Boolean.valueOf(b.e0(callableMemberDescriptor) && BuiltinMethodsWithSpecialGenericSignature.m(callableMemberDescriptor) != null);
                    }
                }, 1, null);
            }
            return null;
        }
        return t2;
    }

    public static final boolean f(@NotNull ClassDescriptor classDescriptor, @NotNull CallableDescriptor callableDescriptor) {
        b41.i(classDescriptor, "<this>");
        b41.i(callableDescriptor, "specialCallableDescriptor");
        fd2 defaultType = ((ClassDescriptor) callableDescriptor.getContainingDeclaration()).getDefaultType();
        b41.h(defaultType, "specialCallableDescripto…ssDescriptor).defaultType");
        ClassDescriptor s = d70.s(classDescriptor);
        while (true) {
            if (s == null) {
                return false;
            }
            if (!(s instanceof JavaClassDescriptor)) {
                if (mq2.b(s.getDefaultType(), defaultType) != null) {
                    return !b.e0(s);
                }
            }
            s = d70.s(s);
        }
    }

    public static final boolean g(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        b41.i(callableMemberDescriptor, "<this>");
        return DescriptorUtilsKt.o(callableMemberDescriptor).getContainingDeclaration() instanceof JavaClassDescriptor;
    }

    public static final boolean h(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        b41.i(callableMemberDescriptor, "<this>");
        return g(callableMemberDescriptor) || b.e0(callableMemberDescriptor);
    }
}
