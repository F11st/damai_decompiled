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
    public static final a Companion = new a(null);
    @Nullable
    private static js1 b;
    @NotNull
    private final Map<Integer, WeakReference<b>> a = new LinkedHashMap();

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
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
    /* loaded from: classes8.dex */
    public static abstract class b {
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

    public final void c(@Nullable b bVar) {
        if (bVar != null) {
            this.a.put(Integer.valueOf(bVar.hashCode()), new WeakReference<>(bVar));
        }
    }

    @NotNull
    public final Map<Integer, WeakReference<b>> d() {
        return this.a;
    }

    public final void e(@Nullable b bVar) {
        if (bVar != null) {
            this.a.remove(Integer.valueOf(bVar.hashCode()));
        }
    }
}
