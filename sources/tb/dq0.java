package tb;

import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public abstract class dq0 {
    @NotNull
    public static final C9055b Companion = new C9055b(null);

    /* compiled from: Taobao */
    /* renamed from: tb.dq0$a */
    /* loaded from: classes6.dex */
    public static final class C9054a extends dq0 {
        @NotNull
        public static final C9054a INSTANCE = new C9054a();

        private C9054a() {
            super(null);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.dq0$b */
    /* loaded from: classes6.dex */
    public static final class C9055b {
        private C9055b() {
        }

        public /* synthetic */ C9055b(k50 k50Var) {
            this();
        }

        @Nullable
        public final dq0 a(@NotNull String str) {
            boolean K;
            b41.i(str, "backdropFilter");
            if (b41.d(str, "none")) {
                return C9056c.INSTANCE;
            }
            K = StringsKt__StringsKt.K(str, "blur", false, 2, null);
            if (K) {
                return C9054a.INSTANCE;
            }
            return null;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.dq0$c */
    /* loaded from: classes6.dex */
    public static final class C9056c extends dq0 {
        @NotNull
        public static final C9056c INSTANCE = new C9056c();

        private C9056c() {
            super(null);
        }
    }

    private dq0() {
    }

    public /* synthetic */ dq0(k50 k50Var) {
        this();
    }
}
