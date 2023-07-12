package tb;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class js1 {
    @NotNull
    public static final C9320a Companion = new C9320a(null);
    @Nullable
    private static js1 b;
    @NotNull
    private final Map<Integer, WeakReference<AbstractC9321b>> a = new LinkedHashMap();

    /* compiled from: Taobao */
    /* renamed from: tb.js1$a */
    /* loaded from: classes8.dex */
    public static final class C9320a {
        private C9320a() {
        }

        public /* synthetic */ C9320a(k50 k50Var) {
            this();
        }

        @NotNull
        public final synchronized js1 a() {
            js1 js1Var;
            if (js1.b == null) {
                js1.b = new js1();
            }
            js1Var = js1.b;
            b41.f(js1Var);
            return js1Var;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.js1$b */
    /* loaded from: classes8.dex */
    public static abstract class AbstractC9321b {
        public boolean a(@NotNull Activity activity) {
            b41.i(activity, "activity");
            return false;
        }

        public void b(@NotNull Activity activity) {
            b41.i(activity, "activity");
        }

        public void c(@NotNull Activity activity) {
            b41.i(activity, "activity");
        }
    }

    public final void c(@Nullable AbstractC9321b abstractC9321b) {
        if (abstractC9321b != null) {
            this.a.put(Integer.valueOf(abstractC9321b.hashCode()), new WeakReference<>(abstractC9321b));
        }
    }

    @NotNull
    public final Map<Integer, WeakReference<AbstractC9321b>> d() {
        return this.a;
    }

    public final void e(@Nullable AbstractC9321b abstractC9321b) {
        if (abstractC9321b != null) {
            this.a.remove(Integer.valueOf(abstractC9321b.hashCode()));
        }
    }
}
