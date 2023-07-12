package tb;

import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class d02 extends wz1 implements JavaClassObjectAnnotationArgument {
    @NotNull
    private final Class<?> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d02(@Nullable ni1 ni1Var, @NotNull Class<?> cls) {
        super(ni1Var, null);
        b41.i(cls, "klass");
        this.b = cls;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument
    @NotNull
    public JavaType getReferencedType() {
        return o02.Factory.a(this.b);
    }
}
