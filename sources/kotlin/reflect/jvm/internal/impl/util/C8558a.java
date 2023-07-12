package kotlin.reflect.jvm.internal.impl.util;

import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.Check;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.z71;

/* compiled from: Taobao */
/* renamed from: kotlin.reflect.jvm.internal.impl.util.a */
/* loaded from: classes3.dex */
final class C8558a implements Check {
    @NotNull
    public static final C8558a INSTANCE = new C8558a();
    @NotNull
    private static final String a = "second parameter must be of type KProperty<*> or its supertype";

    private C8558a() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
        b41.i(functionDescriptor, "functionDescriptor");
        ValueParameterDescriptor valueParameterDescriptor = functionDescriptor.getValueParameters().get(1);
        ReflectionTypes.C8268b c8268b = ReflectionTypes.Companion;
        b41.h(valueParameterDescriptor, "secondParameter");
        z71 a2 = c8268b.a(DescriptorUtilsKt.l(valueParameterDescriptor));
        if (a2 == null) {
            return false;
        }
        z71 type = valueParameterDescriptor.getType();
        b41.h(type, "secondParameter.type");
        return TypeUtilsKt.m(a2, TypeUtilsKt.p(type));
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    @NotNull
    public String getDescription() {
        return a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    @Nullable
    public String invoke(@NotNull FunctionDescriptor functionDescriptor) {
        return Check.C8556a.a(this, functionDescriptor);
    }
}
