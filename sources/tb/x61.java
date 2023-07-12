package tb;

import java.util.Arrays;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class x61 extends fc {
    @NotNull
    public static final a Companion = new a(null);
    @JvmField
    @NotNull
    public static final x61 INSTANCE = new x61(1, 5, 1);
    @JvmField
    @NotNull
    public static final x61 INVALID_VERSION = new x61(new int[0]);
    private final boolean f;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
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
            int a2 = a();
            x61 x61Var = INSTANCE;
            z = a2 == x61Var.a() && b() <= x61Var.b() + 1;
        }
        return z;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x61(@NotNull int... iArr) {
        this(iArr, false);
        b41.i(iArr, "numbers");
    }
}
