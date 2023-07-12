package tb;

import kotlin.jvm.JvmField;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@InternalCoroutinesApi
/* loaded from: classes9.dex */
public final class yw2<T> {
    public static final b Companion = new b(null);
    private final Object a;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static final class a {
        @JvmField
        @Nullable
        public final Throwable a;

        public a(@Nullable Throwable th) {
            this.a = th;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof a) && b41.d(this.a, ((a) obj).a);
        }

        public int hashCode() {
            Throwable th = this.a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return "Closed(" + this.a + ')';
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(k50 k50Var) {
            this();
        }
    }

    private /* synthetic */ yw2(@Nullable Object obj) {
        this.a = obj;
    }

    @NotNull
    public static final /* synthetic */ yw2 a(@Nullable Object obj) {
        return new yw2(obj);
    }

    @NotNull
    public static Object b(@Nullable Object obj) {
        return obj;
    }

    public static boolean c(Object obj, @Nullable Object obj2) {
        return (obj2 instanceof yw2) && b41.d(obj, ((yw2) obj2).i());
    }

    @Nullable
    public static final Throwable d(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).a;
        }
        throw new IllegalStateException("Channel was not closed".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final T e(Object obj) {
        if (obj instanceof a) {
            throw new IllegalStateException(kotlinx.coroutines.channels.b.DEFAULT_CLOSE_MESSAGE.toString());
        }
        return obj;
    }

    public static int f(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static final boolean g(Object obj) {
        return obj instanceof a;
    }

    @NotNull
    public static String h(Object obj) {
        if (obj instanceof a) {
            return obj.toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public int hashCode() {
        return f(this.a);
    }

    @Nullable
    public final /* synthetic */ Object i() {
        return this.a;
    }

    @NotNull
    public String toString() {
        return h(this.a);
    }
}
