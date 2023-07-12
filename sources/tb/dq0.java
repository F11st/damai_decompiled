package tb;

import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public abstract class dq0 {
    @NotNull
    public static final b Companion = new b(null);

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class a extends dq0 {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
            super(null);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(k50 k50Var) {
            this();
        }

        @Nullable
        public final dq0 a(@NotNull String str) {
            boolean K;
            b41.i(str, "backdropFilter");
            if (b41.d(str, "none")) {
                return c.INSTANCE;
            }
            K = StringsKt__StringsKt.K(str, "blur", false, 2, null);
            if (K) {
                return a.INSTANCE;
            }
            return null;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class c extends dq0 {
        @NotNull
        public static final c INSTANCE = new c();

        private c() {
            super(null);
        }
    }

    private dq0() {
    }

    public /* synthetic */ dq0(k50 k50Var) {
        this();
    }
}
