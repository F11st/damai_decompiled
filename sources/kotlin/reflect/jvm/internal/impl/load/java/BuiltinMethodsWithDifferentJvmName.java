package kotlin.reflect.jvm.internal.impl.load.java;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.mf1;
import tb.ni1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class BuiltinMethodsWithDifferentJvmName extends SpecialGenericSignatures {
    @NotNull
    public static final BuiltinMethodsWithDifferentJvmName INSTANCE = new BuiltinMethodsWithDifferentJvmName();

    private BuiltinMethodsWithDifferentJvmName() {
    }

    @Nullable
    public final ni1 i(@NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
        b41.i(simpleFunctionDescriptor, "functionDescriptor");
        Map<String, ni1> j = SpecialGenericSignatures.Companion.j();
        String d = mf1.d(simpleFunctionDescriptor);
        if (d == null) {
            return null;
        }
        return j.get(d);
    }

    public final boolean j(@NotNull final SimpleFunctionDescriptor simpleFunctionDescriptor) {
        b41.i(simpleFunctionDescriptor, "functionDescriptor");
        return b.e0(simpleFunctionDescriptor) && DescriptorUtilsKt.d(simpleFunctionDescriptor, false, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName$isBuiltinFunctionWithDifferentNameInJvm$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
                b41.i(callableMemberDescriptor, AdvanceSetting.NETWORK_TYPE);
                Map<String, ni1> j = SpecialGenericSignatures.Companion.j();
                String d = mf1.d(SimpleFunctionDescriptor.this);
                Objects.requireNonNull(j, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                return Boolean.valueOf(j.containsKey(d));
            }
        }, 1, null) != null;
    }

    public final boolean k(@NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
        b41.i(simpleFunctionDescriptor, "<this>");
        return b41.d(simpleFunctionDescriptor.getName().b(), "removeAt") && b41.d(mf1.d(simpleFunctionDescriptor), SpecialGenericSignatures.Companion.h().b());
    }
}
