package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class q81 {
    @NotNull
    public static final Annotations a(@NotNull r81 r81Var, @NotNull JavaAnnotationOwner javaAnnotationOwner) {
        b41.i(r81Var, "<this>");
        b41.i(javaAnnotationOwner, "annotationsOwner");
        return new LazyJavaAnnotations(r81Var, javaAnnotationOwner, false, 4, null);
    }
}
