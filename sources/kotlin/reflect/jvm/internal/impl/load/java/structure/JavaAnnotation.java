package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hj;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface JavaAnnotation extends JavaElement {

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation$a */
    /* loaded from: classes3.dex */
    public static final class C8357a {
        public static boolean a(@NotNull JavaAnnotation javaAnnotation) {
            b41.i(javaAnnotation, "this");
            return false;
        }

        public static boolean b(@NotNull JavaAnnotation javaAnnotation) {
            b41.i(javaAnnotation, "this");
            return false;
        }
    }

    @NotNull
    Collection<JavaAnnotationArgument> getArguments();

    @Nullable
    hj getClassId();

    boolean isFreshlySupportedTypeUseAnnotation();

    boolean isIdeExternalAnnotation();

    @Nullable
    JavaClass resolve();
}
