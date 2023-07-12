package tb;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class o02 implements JavaType {
    @NotNull
    public static final a Factory = new a(null);

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public final o02 a(@NotNull Type type) {
            o02 a02Var;
            b41.i(type, "type");
            boolean z = type instanceof Class;
            if (z) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new n02(cls);
                }
            }
            if (!(type instanceof GenericArrayType) && (!z || !((Class) type).isArray())) {
                a02Var = type instanceof WildcardType ? new r02((WildcardType) type) : new e02(type);
            } else {
                a02Var = new a02(type);
            }
            return a02Var;
        }
    }

    @NotNull
    protected abstract Type a();

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof o02) && b41.d(a(), ((o02) obj).a());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @Nullable
    public JavaAnnotation findAnnotation(@NotNull hp0 hp0Var) {
        return JavaType.a.a(this, hp0Var);
    }

    public int hashCode() {
        return a().hashCode();
    }

    @NotNull
    public String toString() {
        return getClass().getName() + ": " + a();
    }
}
