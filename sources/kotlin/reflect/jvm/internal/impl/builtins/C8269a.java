package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import org.jetbrains.annotations.NotNull;
import tb.k50;

/* compiled from: Taobao */
/* renamed from: kotlin.reflect.jvm.internal.impl.builtins.a */
/* loaded from: classes3.dex */
public final class C8269a extends AbstractC8271b {
    @NotNull
    public static final C8270a Companion = new C8270a(null);
    @NotNull
    private static final C8269a g = new C8269a(false, 1, null);

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.a$a */
    /* loaded from: classes3.dex */
    public static final class C8270a {
        private C8270a() {
        }

        public /* synthetic */ C8270a(k50 k50Var) {
            this();
        }

        @NotNull
        public final C8269a a() {
            return C8269a.g;
        }
    }

    public C8269a(boolean z) {
        super(new LockBasedStorageManager("DefaultBuiltIns"));
        if (z) {
            f(false);
        }
    }

    @NotNull
    public static final C8269a E0() {
        return Companion.a();
    }

    public /* synthetic */ C8269a(boolean z, int i, k50 k50Var) {
        this((i & 1) != 0 ? true : z);
    }
}
