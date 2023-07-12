package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class h02 extends wz1 implements JavaEnumValueAnnotationArgument {
    @NotNull
    private final Enum<?> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h02(@Nullable ni1 ni1Var, @NotNull Enum<?> r3) {
        super(ni1Var, null);
        b41.i(r3, "value");
        this.b = r3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument
    @Nullable
    public ni1 getEntryName() {
        return ni1.f(this.b.name());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument
    @Nullable
    public hj getEnumClassId() {
        Class<?> cls = this.b.getClass();
        if (!cls.isEnum()) {
            cls = cls.getEnclosingClass();
        }
        b41.h(cls, "enumClass");
        return ReflectClassUtilKt.a(cls);
    }
}
