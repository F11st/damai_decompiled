package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hj;
import tb.hp0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface ListBasedJavaAnnotationOwner extends JavaAnnotationOwner {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        @Nullable
        public static JavaAnnotation a(@NotNull ListBasedJavaAnnotationOwner listBasedJavaAnnotationOwner, @NotNull hp0 hp0Var) {
            Object obj;
            b41.i(listBasedJavaAnnotationOwner, "this");
            b41.i(hp0Var, "fqName");
            Iterator<T> it = listBasedJavaAnnotationOwner.getAnnotations().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                hj classId = ((JavaAnnotation) next).getClassId();
                if (b41.d(classId != null ? classId.b() : null, hp0Var)) {
                    obj = next;
                    break;
                }
            }
            return (JavaAnnotation) obj;
        }
    }
}
