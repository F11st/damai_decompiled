package tb;

import kotlin.reflect.jvm.internal.impl.builtins.C8277c;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class or2 extends fu2<Byte> {
    public or2(byte b) {
        super(Byte.valueOf(b));
    }

    @Override // tb.fn
    @NotNull
    public z71 a(@NotNull ModuleDescriptor moduleDescriptor) {
        b41.i(moduleDescriptor, "module");
        ClassDescriptor a = FindClassInModuleKt.a(moduleDescriptor, C8277c.C8278a.uByte);
        fd2 defaultType = a == null ? null : a.getDefaultType();
        if (defaultType == null) {
            fd2 j = kf0.j("Unsigned type UByte not found");
            b41.h(j, "createErrorType(\"Unsigned type UByte not found\")");
            return j;
        }
        return defaultType;
    }

    @Override // tb.fn
    @NotNull
    public String toString() {
        return b().intValue() + ".toUByte()";
    }
}
