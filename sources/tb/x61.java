package tb;

import java.util.Arrays;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class x61 extends AbstractC9135fc {
    @NotNull
    public static final C9910a Companion = new C9910a(null);
    @JvmField
    @NotNull
    public static final x61 INSTANCE = new x61(1, 5, 1);
    @JvmField
    @NotNull
    public static final x61 INVALID_VERSION = new x61(new int[0]);
    private final boolean f;

    /* compiled from: Taobao */
    /* renamed from: tb.x61$a */
    /* loaded from: classes3.dex */
    public static final class C9910a {
        private C9910a() {
        }

        public /* synthetic */ C9910a(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x61(@NotNull int[] iArr, boolean z) {
        super(Arrays.copyOf(iArr, iArr.length));
        b41.i(iArr, "versionArray");
        this.f = z;
    }

    public boolean h() {
        boolean z;
        if (a() == 1 && b() == 0) {
            return false;
        }
        if (this.f) {
            z = f(INSTANCE);
        } else {
            int a = a();
            x61 x61Var = INSTANCE;
            z = a == x61Var.a() && b() <= x61Var.b() + 1;
        }
        return z;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x61(@NotNull int... iArr) {
        this(iArr, false);
        b41.i(iArr, "numbers");
    }
}
