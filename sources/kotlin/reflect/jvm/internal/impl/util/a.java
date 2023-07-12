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
/* loaded from: classes3.dex */
final class a implements Check {
    @NotNull
    public static final a INSTANCE = new a();
    @NotNull
    private static final String a = "second parameter must be of type KProperty<*> or its supertype";

    private a() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
        b41.i(functionDescriptor, "functionDescriptor");
        ValueParameterDescriptor valueParameterDescriptor = functionDescriptor.getValueParameters().get(1);
        ReflectionTypes.b bVar = ReflectionTypes.Companion;
        b41.h(valueParameterDescriptor, "secondParameter");
        z71 a2 = bVar.a(DescriptorUtilsKt.l(valueParameterDescriptor));
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
        return Check.a.a(this, functionDescriptor);
    }
}
