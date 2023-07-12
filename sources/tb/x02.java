package tb;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class x02 {

    /* compiled from: Taobao */
    /* renamed from: tb.x02$a */
    /* loaded from: classes3.dex */
    public static class C9894a<T> extends AbstractC9896c<T> implements Function0<T> {
        private final Function0<T> b;
        private volatile SoftReference<Object> c;

        public C9894a(@Nullable T t, @NotNull Function0<T> function0) {
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

        @Override // tb.x02.AbstractC9896c, kotlin.jvm.functions.Function0
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
    /* renamed from: tb.x02$b */
    /* loaded from: classes3.dex */
    public static class C9895b<T> extends AbstractC9896c<T> {
        private final Function0<T> b;
        private volatile Object c;

        public C9895b(@NotNull Function0<T> function0) {
            if (function0 == null) {
                d(0);
            }
            this.c = null;
            this.b = function0;
        }

        private static /* synthetic */ void d(int i) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyVal", "<init>"));
        }

        @Override // tb.x02.AbstractC9896c, kotlin.jvm.functions.Function0
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
    /* renamed from: tb.x02$c */
    /* loaded from: classes3.dex */
    public static abstract class AbstractC9896c<T> {
        private static final Object a = new C9897a();

        /* compiled from: Taobao */
        /* renamed from: tb.x02$c$a */
        /* loaded from: classes3.dex */
        static class C9897a {
            C9897a() {
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
    public static <T> C9895b<T> b(@NotNull Function0<T> function0) {
        if (function0 == null) {
            a(0);
        }
        return new C9895b<>(function0);
    }

    @NotNull
    public static <T> C9894a<T> c(@Nullable T t, @NotNull Function0<T> function0) {
        if (function0 == null) {
            a(1);
        }
        return new C9894a<>(t, function0);
    }

    @NotNull
    public static <T> C9894a<T> d(@NotNull Function0<T> function0) {
        if (function0 == null) {
            a(2);
        }
        return c(null, function0);
    }
}
