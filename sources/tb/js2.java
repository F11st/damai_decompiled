package tb;

import kotlin.reflect.jvm.internal.impl.builtins.C8277c;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class js2 extends fu2<Short> {
    public js2(short s) {
        super(Short.valueOf(s));
    }

    @Override // tb.fn
    @NotNull
    public z71 a(@NotNull ModuleDescriptor moduleDescriptor) {
        b41.i(moduleDescriptor, "module");
        ClassDescriptor a = FindClassInModuleKt.a(moduleDescriptor, C8277c.C8278a.uShort);
        fd2 defaultType = a == null ? null : a.getDefaultType();
        if (defaultType == null) {
            fd2 j = kf0.j("Unsigned type UShort not found");
            b41.h(j, "createErrorType(\"Unsigned type UShort not found\")");
            return j;
        }
        return defaultType;
    }

    @Override // tb.fn
    @NotNull
    public String toString() {
        return b().intValue() + ".toUShort()";
    }
}
