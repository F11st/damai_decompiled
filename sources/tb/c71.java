package tb;

import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class c71 {
    @NotNull
    public static final C8991b Companion = new C8991b(null);
    @NotNull
    private static final C8993d a = new C8993d(JvmPrimitiveType.BOOLEAN);
    @NotNull
    private static final C8993d b = new C8993d(JvmPrimitiveType.CHAR);
    @NotNull
    private static final C8993d c = new C8993d(JvmPrimitiveType.BYTE);
    @NotNull
    private static final C8993d d = new C8993d(JvmPrimitiveType.SHORT);
    @NotNull
    private static final C8993d e = new C8993d(JvmPrimitiveType.INT);
    @NotNull
    private static final C8993d f = new C8993d(JvmPrimitiveType.FLOAT);
    @NotNull
    private static final C8993d g = new C8993d(JvmPrimitiveType.LONG);
    @NotNull
    private static final C8993d h = new C8993d(JvmPrimitiveType.DOUBLE);

    /* compiled from: Taobao */
    /* renamed from: tb.c71$a */
    /* loaded from: classes3.dex */
    public static final class C8990a extends c71 {
        @NotNull
        private final c71 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8990a(@NotNull c71 c71Var) {
            super(null);
            b41.i(c71Var, "elementType");
            this.i = c71Var;
        }

        @NotNull
        public final c71 i() {
            return this.i;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.c71$b */
    /* loaded from: classes3.dex */
    public static final class C8991b {
        private C8991b() {
        }

        public /* synthetic */ C8991b(k50 k50Var) {
            this();
        }

        @NotNull
        public final C8993d a() {
            return c71.a;
        }

        @NotNull
        public final C8993d b() {
            return c71.c;
        }

        @NotNull
        public final C8993d c() {
            return c71.b;
        }

        @NotNull
        public final C8993d d() {
            return c71.h;
        }

        @NotNull
        public final C8993d e() {
            return c71.f;
        }

        @NotNull
        public final C8993d f() {
            return c71.e;
        }

        @NotNull
        public final C8993d g() {
            return c71.g;
        }

        @NotNull
        public final C8993d h() {
            return c71.d;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.c71$c */
    /* loaded from: classes3.dex */
    public static final class C8992c extends c71 {
        @NotNull
        private final String i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8992c(@NotNull String str) {
            super(null);
            b41.i(str, "internalName");
            this.i = str;
        }

        @NotNull
        public final String i() {
            return this.i;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.c71$d */
    /* loaded from: classes3.dex */
    public static final class C8993d extends c71 {
        @Nullable
        private final JvmPrimitiveType i;

        public C8993d(@Nullable JvmPrimitiveType jvmPrimitiveType) {
            super(null);
            this.i = jvmPrimitiveType;
        }

        @Nullable
        public final JvmPrimitiveType i() {
            return this.i;
        }
    }

    private c71() {
    }

    public /* synthetic */ c71(k50 k50Var) {
        this();
    }

    @NotNull
    public String toString() {
        return d71.INSTANCE.toString(this);
    }
}
