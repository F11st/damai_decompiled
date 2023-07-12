package tb;

import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class j02 extends wz1 implements JavaLiteralAnnotationArgument {
    @NotNull
    private final Object b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j02(@Nullable ni1 ni1Var, @NotNull Object obj) {
        super(ni1Var, null);
        b41.i(obj, "value");
        this.b = obj;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument
    @NotNull
    public Object getValue() {
        return this.b;
    }
}
