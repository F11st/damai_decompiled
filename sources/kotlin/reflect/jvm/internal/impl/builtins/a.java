package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import org.jetbrains.annotations.NotNull;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class a extends b {
    @NotNull
    public static final C0410a Companion = new C0410a(null);
    @NotNull
    private static final a g = new a(false, 1, null);

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0410a {
        private C0410a() {
        }

        public /* synthetic */ C0410a(k50 k50Var) {
            this();
        }

        @NotNull
        public final a a() {
            return a.g;
        }
    }

    public a(boolean z) {
        super(new LockBasedStorageManager("DefaultBuiltIns"));
        if (z) {
            f(false);
        }
    }

    @NotNull
    public static final a E0() {
        return Companion.a();
    }

    public /* synthetic */ a(boolean z, int i, k50 k50Var) {
        this((i & 1) != 0 ? true : z);
    }
}
