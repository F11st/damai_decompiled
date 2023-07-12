package tb;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class ki {
    private final boolean a;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a extends ki {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
            super(false, null);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class b extends ki {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull String str) {
            super(false, null);
            b41.i(str, "error");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class c extends ki {
        @NotNull
        public static final c INSTANCE = new c();

        private c() {
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
