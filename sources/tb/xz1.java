package tb;

import java.lang.annotation.Annotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class xz1 extends wz1 implements JavaAnnotationAsAnnotationArgument {
    @NotNull
    private final Annotation b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xz1(@Nullable ni1 ni1Var, @NotNull Annotation annotation) {
        super(ni1Var, null);
        b41.i(annotation, "annotation");
        this.b = annotation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument
    @NotNull
    public JavaAnnotation getAnnotation() {
        return new vz1(this.b);
    }
}
