package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;
import kotlin.collections.C8214m;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hp0;
import tb.vz1;
import tb.yz1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface ReflectJavaAnnotationOwner extends JavaAnnotationOwner {

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner$a */
    /* loaded from: classes3.dex */
    public static final class C8322a {
        @Nullable
        public static vz1 a(@NotNull ReflectJavaAnnotationOwner reflectJavaAnnotationOwner, @NotNull hp0 hp0Var) {
            Annotation[] declaredAnnotations;
            b41.i(reflectJavaAnnotationOwner, "this");
            b41.i(hp0Var, "fqName");
            AnnotatedElement element = reflectJavaAnnotationOwner.getElement();
            if (element == null || (declaredAnnotations = element.getDeclaredAnnotations()) == null) {
                return null;
            }
            return yz1.a(declaredAnnotations, hp0Var);
        }

        @NotNull
        public static List<vz1> b(@NotNull ReflectJavaAnnotationOwner reflectJavaAnnotationOwner) {
            List<vz1> g;
            b41.i(reflectJavaAnnotationOwner, "this");
            AnnotatedElement element = reflectJavaAnnotationOwner.getElement();
            Annotation[] declaredAnnotations = element == null ? null : element.getDeclaredAnnotations();
            if (declaredAnnotations == null) {
                g = C8214m.g();
                return g;
            }
            return yz1.b(declaredAnnotations);
        }

        public static boolean c(@NotNull ReflectJavaAnnotationOwner reflectJavaAnnotationOwner) {
            b41.i(reflectJavaAnnotationOwner, "this");
            return false;
        }
    }

    @Nullable
    AnnotatedElement getElement();
}
