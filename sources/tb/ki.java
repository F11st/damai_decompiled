package tb;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class ki {
    private final boolean a;

    /* compiled from: Taobao */
    /* renamed from: tb.ki$a */
    /* loaded from: classes3.dex */
    public static final class C9361a extends ki {
        @NotNull
        public static final C9361a INSTANCE = new C9361a();

        private C9361a() {
            super(false, null);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.ki$b */
    /* loaded from: classes3.dex */
    public static final class C9362b extends ki {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9362b(@NotNull String str) {
            super(false, null);
            b41.i(str, "error");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.ki$c */
    /* loaded from: classes3.dex */
    public static final class C9363c extends ki {
        @NotNull
        public static final C9363c INSTANCE = new C9363c();

        private C9363c() {
            super(true, null);
        }
    }

    private ki(boolean z) {
        this.a = z;
    }

    public /* synthetic */ ki(boolean z, k50 k50Var) {
        this(z);
    }

    public final boolean a() {
        return this.a;
    }
}
