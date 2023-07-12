package kotlin.reflect.jvm.internal.impl.load.java;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Collection;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.fe;
import tb.ni1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ClassicBuiltinSpecialProperties {
    @NotNull
    public static final ClassicBuiltinSpecialProperties INSTANCE = new ClassicBuiltinSpecialProperties();

    private ClassicBuiltinSpecialProperties() {
    }

    private final boolean c(CallableMemberDescriptor callableMemberDescriptor) {
        boolean J;
        J = CollectionsKt___CollectionsKt.J(fe.INSTANCE.c(), DescriptorUtilsKt.e(callableMemberDescriptor));
        if (J && callableMemberDescriptor.getValueParameters().isEmpty()) {
            return true;
        }
        if (b.e0(callableMemberDescriptor)) {
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
            b41.h(overriddenDescriptors, "overriddenDescriptors");
            if (!overriddenDescriptors.isEmpty()) {
                for (CallableMemberDescriptor callableMemberDescriptor2 : overriddenDescriptors) {
                    ClassicBuiltinSpecialProperties classicBuiltinSpecialProperties = INSTANCE;
                    b41.h(callableMemberDescriptor2, AdvanceSetting.NETWORK_TYPE);
                    if (classicBuiltinSpecialProperties.b(callableMemberDescriptor2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    @Nullable
    public final String a(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        ni1 ni1Var;
        b41.i(callableMemberDescriptor, "<this>");
        b.e0(callableMemberDescriptor);
        CallableMemberDescriptor d = DescriptorUtilsKt.d(DescriptorUtilsKt.o(callableMemberDescriptor), false, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull CallableMemberDescriptor callableMemberDescriptor2) {
                b41.i(callableMemberDescriptor2, AdvanceSetting.NETWORK_TYPE);
                return Boolean.valueOf(ClassicBuiltinSpecialProperties.INSTANCE.b(callableMemberDescriptor2));
            }
        }, 1, null);
        if (d == null || (ni1Var = fe.INSTANCE.a().get(DescriptorUtilsKt.i(d))) == null) {
            return null;
        }
        return ni1Var.b();
    }

    public final boolean b(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        b41.i(callableMemberDescriptor, "callableMemberDescriptor");
        if (fe.INSTANCE.d().contains(callableMemberDescriptor.getName())) {
            return c(callableMemberDescriptor);
        }
        return false;
    }
}
