package tb;

import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class es2 extends fu2<Long> {
    public es2(long j) {
        super(Long.valueOf(j));
    }

    @Override // tb.fn
    @NotNull
    public z71 a(@NotNull ModuleDescriptor moduleDescriptor) {
        b41.i(moduleDescriptor, "module");
        ClassDescriptor a = FindClassInModuleKt.a(moduleDescriptor, c.a.uLong);
        fd2 defaultType = a == null ? null : a.getDefaultType();
        if (defaultType == null) {
            fd2 j = kf0.j("Unsigned type ULong not found");
            b41.h(j, "createErrorType(\"Unsigned type ULong not found\")");
            return j;
        }
        return defaultType;
    }

    @Override // tb.fn
    @NotNull
    public String toString() {
        return b().longValue() + ".toULong()";
    }
}
