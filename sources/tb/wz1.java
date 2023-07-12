package tb;

import java.lang.annotation.Annotation;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class wz1 implements JavaAnnotationArgument {
    @NotNull
    public static final a Factory = new a(null);
    @Nullable
    private final ni1 a;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public final wz1 a(@NotNull Object obj, @Nullable ni1 ni1Var) {
            b41.i(obj, "value");
            return ReflectClassUtilKt.h(obj.getClass()) ? new h02(ni1Var, (Enum) obj) : obj instanceof Annotation ? new xz1(ni1Var, (Annotation) obj) : obj instanceof Object[] ? new zz1(ni1Var, (Object[]) obj) : obj instanceof Class ? new d02(ni1Var, (Class) obj) : new j02(ni1Var, obj);
        }
    }

    private wz1(ni1 ni1Var) {
        this.a = ni1Var;
    }

    public /* synthetic */ wz1(ni1 ni1Var, k50 k50Var) {
        this(ni1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument
    @Nullable
    public ni1 getName() {
        return this.a;
    }
}
