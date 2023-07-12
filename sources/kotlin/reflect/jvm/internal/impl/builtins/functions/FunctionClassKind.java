package kotlin.reflect.jvm.internal.impl.builtins.functions;

import com.vivo.push.PushClientConstants;
import kotlin.jvm.JvmStatic;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hp0;
import tb.k50;
import tb.ni1;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum KFunction uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:289)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FunctionClassKind {
    private static final /* synthetic */ FunctionClassKind[] $VALUES;
    @NotNull
    public static final a Companion;
    public static final FunctionClassKind KFunction;
    public static final FunctionClassKind KSuspendFunction;
    @NotNull
    private final String classNamePrefix;
    private final boolean isReflectType;
    private final boolean isSuspendType;
    @NotNull
    private final hp0 packageFqName;
    public static final FunctionClassKind Function = new FunctionClassKind("Function", 0, c.BUILT_INS_PACKAGE_FQ_NAME, "Function", false, false);
    public static final FunctionClassKind SuspendFunction = new FunctionClassKind("SuspendFunction", 1, c.COROUTINES_PACKAGE_FQ_NAME_RELEASE, "SuspendFunction", true, false);

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {

        /* compiled from: Taobao */
        /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0412a {
            @NotNull
            private final FunctionClassKind a;
            private final int b;

            public C0412a(@NotNull FunctionClassKind functionClassKind, int i) {
                b41.i(functionClassKind, "kind");
                this.a = functionClassKind;
                this.b = i;
            }

            @NotNull
            public final FunctionClassKind a() {
                return this.a;
            }

            public final int b() {
                return this.b;
            }

            @NotNull
            public final FunctionClassKind c() {
                return this.a;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof C0412a) {
                    C0412a c0412a = (C0412a) obj;
                    return this.a == c0412a.a && this.b == c0412a.b;
                }
                return false;
            }

            public int hashCode() {
                return (this.a.hashCode() * 31) + this.b;
            }

            @NotNull
            public String toString() {
                return "KindWithArity(kind=" + this.a + ", arity=" + this.b + ')';
            }
        }

        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        private final Integer d(String str) {
            if (str.length() == 0) {
                return null;
            }
            int length = str.length();
            int i = 0;
            int i2 = 0;
            while (i < length) {
                char charAt = str.charAt(i);
                i++;
                int i3 = charAt - '0';
                if (!(i3 >= 0 && i3 <= 9)) {
                    return null;
                }
                i2 = (i2 * 10) + i3;
            }
            return Integer.valueOf(i2);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0032 A[LOOP:0: B:3:0x0011->B:13:0x0032, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0030 A[SYNTHETIC] */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind a(@org.jetbrains.annotations.NotNull tb.hp0 r9, @org.jetbrains.annotations.NotNull java.lang.String r10) {
            /*
                r8 = this;
                java.lang.String r0 = "packageFqName"
                tb.b41.i(r9, r0)
                java.lang.String r0 = "className"
                tb.b41.i(r10, r0)
                kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind[] r0 = kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind.values()
                int r1 = r0.length
                r2 = 0
                r3 = 0
            L11:
                r4 = 0
                if (r3 >= r1) goto L35
                r5 = r0[r3]
                tb.hp0 r6 = r5.getPackageFqName()
                boolean r6 = tb.b41.d(r6, r9)
                if (r6 == 0) goto L2d
                java.lang.String r6 = r5.getClassNamePrefix()
                r7 = 2
                boolean r4 = kotlin.text.g.F(r10, r6, r2, r7, r4)
                if (r4 == 0) goto L2d
                r4 = 1
                goto L2e
            L2d:
                r4 = 0
            L2e:
                if (r4 == 0) goto L32
                r4 = r5
                goto L35
            L32:
                int r3 = r3 + 1
                goto L11
            L35:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind.a.a(tb.hp0, java.lang.String):kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind");
        }

        @JvmStatic
        @Nullable
        public final FunctionClassKind b(@NotNull String str, @NotNull hp0 hp0Var) {
            b41.i(str, PushClientConstants.TAG_CLASS_NAME);
            b41.i(hp0Var, "packageFqName");
            C0412a c = c(str, hp0Var);
            if (c == null) {
                return null;
            }
            return c.c();
        }

        @Nullable
        public final C0412a c(@NotNull String str, @NotNull hp0 hp0Var) {
            b41.i(str, PushClientConstants.TAG_CLASS_NAME);
            b41.i(hp0Var, "packageFqName");
            FunctionClassKind a = a(hp0Var, str);
            if (a == null) {
                return null;
            }
            String substring = str.substring(a.getClassNamePrefix().length());
            b41.h(substring, "(this as java.lang.String).substring(startIndex)");
            Integer d = d(substring);
            if (d == null) {
                return null;
            }
            return new C0412a(a, d.intValue());
        }
    }

    private static final /* synthetic */ FunctionClassKind[] $values() {
        return new FunctionClassKind[]{Function, SuspendFunction, KFunction, KSuspendFunction};
    }

    static {
        hp0 hp0Var = c.KOTLIN_REFLECT_FQ_NAME;
        KFunction = new FunctionClassKind("KFunction", 2, hp0Var, "KFunction", false, true);
        KSuspendFunction = new FunctionClassKind("KSuspendFunction", 3, hp0Var, "KSuspendFunction", true, true);
        $VALUES = $values();
        Companion = new a(null);
    }

    private FunctionClassKind(String str, int i, hp0 hp0Var, String str2, boolean z, boolean z2) {
        this.packageFqName = hp0Var;
        this.classNamePrefix = str2;
        this.isSuspendType = z;
        this.isReflectType = z2;
    }

    public static FunctionClassKind valueOf(String str) {
        return (FunctionClassKind) Enum.valueOf(FunctionClassKind.class, str);
    }

    public static FunctionClassKind[] values() {
        return (FunctionClassKind[]) $VALUES.clone();
    }

    @NotNull
    public final String getClassNamePrefix() {
        return this.classNamePrefix;
    }

    @NotNull
    public final hp0 getPackageFqName() {
        return this.packageFqName;
    }

    @NotNull
    public final ni1 numberedClassName(int i) {
        ni1 f = ni1.f(b41.r(this.classNamePrefix, Integer.valueOf(i)));
        b41.h(f, "identifier(\"$classNamePrefix$arity\")");
        return f;
    }
}
