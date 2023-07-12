package tb;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class x02 {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class a<T> extends c<T> implements Function0<T> {
        private final Function0<T> b;
        private volatile SoftReference<Object> c;

        public a(@Nullable T t, @NotNull Function0<T> function0) {
            if (function0 == null) {
                d(0);
            }
            this.c = null;
            this.b = function0;
            if (t != null) {
                this.c = new SoftReference<>(a(t));
            }
        }

        private static /* synthetic */ void d(int i) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"));
        }

        @Override // tb.x02.c, kotlin.jvm.functions.Function0
        public T invoke() {
            Object obj;
            SoftReference<Object> softReference = this.c;
            if (softReference != null && (obj = softReference.get()) != null) {
                return c(obj);
            }
            T invoke = this.b.invoke();
            this.c = new SoftReference<>(a(invoke));
            return invoke;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class b<T> extends c<T> {
        private final Function0<T> b;
        private volatile Object c;

        public b(@NotNull Function0<T> function0) {
            if (function0 == null) {
                d(0);
            }
            this.c = null;
            this.b = function0;
        }

        private static /* synthetic */ void d(int i) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyVal", "<init>"));
        }

        @Override // tb.x02.c, kotlin.jvm.functions.Function0
        public T invoke() {
            Object obj = this.c;
            if (obj != null) {
                return c(obj);
            }
            T invoke = this.b.invoke();
            this.c = a(invoke);
            return invoke;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static abstract class c<T> {
        private static final Object a = new a();

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        static class a {
            a() {
            }
        }

        protected Object a(T t) {
            return t == null ? a : t;
        }

        public final T b(Object obj, Object obj2) {
            return invoke();
        }

        /* JADX WARN: Multi-variable type inference failed */
        protected T c(Object obj) {
            if (obj == a) {
                return null;
            }
            return obj;
        }

        public abstract T invoke();
    }

    private static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        objArr[0] = "initializer";
        objArr[1] = "kotlin/reflect/jvm/internal/ReflectProperties";
        if (i == 1 || i == 2) {
            objArr[2] = "lazySoft";
        } else {
            objArr[2] = "lazy";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @NotNull
    public static <T> b<T> b(@NotNull Function0<T> function0) {
        if (function0 == null) {
            a(0);
        }
        return new b<>(function0);
    }

    @NotNull
    public static <T> a<T> c(@Nullable T t, @NotNull Function0<T> function0) {
        if (function0 == null) {
            a(1);
        }
        return new a<>(t, function0);
    }

    @NotNull
    public static <T> a<T> d(@NotNull Function0<T> function0) {
        if (function0 == null) {
            a(2);
        }
        return c(null, function0);
    }
}
