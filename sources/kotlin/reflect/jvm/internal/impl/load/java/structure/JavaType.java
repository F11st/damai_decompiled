package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.reflect.jvm.internal.impl.load.java.structure.ListBasedJavaAnnotationOwner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hp0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface JavaType extends ListBasedJavaAnnotationOwner {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        @Nullable
        public static JavaAnnotation a(@NotNull JavaType javaType, @NotNull hp0 hp0Var) {
            b41.i(javaType, "this");
            b41.i(hp0Var, "fqName");
            return ListBasedJavaAnnotationOwner.a.a(javaType, hp0Var);
        }
    }
}
