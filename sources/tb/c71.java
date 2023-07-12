package tb;

import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class c71 {
    @NotNull
    public static final b Companion = new b(null);
    @NotNull
    private static final d a = new d(JvmPrimitiveType.BOOLEAN);
    @NotNull
    private static final d b = new d(JvmPrimitiveType.CHAR);
    @NotNull
    private static final d c = new d(JvmPrimitiveType.BYTE);
    @NotNull
    private static final d d = new d(JvmPrimitiveType.SHORT);
    @NotNull
    private static final d e = new d(JvmPrimitiveType.INT);
    @NotNull
    private static final d f = new d(JvmPrimitiveType.FLOAT);
    @NotNull
    private static final d g = new d(JvmPrimitiveType.LONG);
    @NotNull
    private static final d h = new d(JvmPrimitiveType.DOUBLE);

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a extends c71 {
        @NotNull
        private final c71 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull c71 c71Var) {
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
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(k50 k50Var) {
            this();
        }

        @NotNull
        public final d a() {
            return c71.a;
        }

        @NotNull
        public final d b() {
            return c71.c;
        }

        @NotNull
        public final d c() {
            return c71.b;
        }

        @NotNull
        public final d d() {
            return c71.h;
        }

        @NotNull
        public final d e() {
            return c71.f;
        }

        @NotNull
        public final d f() {
            return c71.e;
        }

        @NotNull
        public final d g() {
            return c71.g;
        }

        @NotNull
        public final d h() {
            return c71.d;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class c extends c71 {
        @NotNull
        private final String i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull String str) {
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
    /* loaded from: classes3.dex */
    public static final class d extends c71 {
        @Nullable
        private final JvmPrimitiveType i;

        public d(@Nullable JvmPrimitiveType jvmPrimitiveType) {
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
