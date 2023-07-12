package tb;

import kotlin.reflect.jvm.internal.impl.builtins.C8277c;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class bs2 extends fu2<Integer> {
    public bs2(int i) {
        super(Integer.valueOf(i));
    }

    @Override // tb.fn
    @NotNull
    public z71 a(@NotNull ModuleDescriptor moduleDescriptor) {
        b41.i(moduleDescriptor, "module");
        ClassDescriptor a = FindClassInModuleKt.a(moduleDescriptor, C8277c.C8278a.uInt);
        fd2 defaultType = a == null ? null : a.getDefaultType();
        if (defaultType == null) {
            fd2 j = kf0.j("Unsigned type UInt not found");
            b41.h(j, "createErrorType(\"Unsigned type UInt not found\")");
            return j;
        }
        return defaultType;
    }

    @Override // tb.fn
    @NotNull
    public String toString() {
        return b().intValue() + ".toUInt()";
    }
}
