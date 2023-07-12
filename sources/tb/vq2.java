package tb;

import androidx.core.app.FrameMetricsAggregator;
import kotlin.jvm.JvmField;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class vq2 {
    @JvmField
    @NotNull
    public static final vq2 CLASS_DECLARATION;
    @NotNull
    public static final C9824a Companion = new C9824a(null);
    @JvmField
    @NotNull
    public static final vq2 DEFAULT;
    @JvmField
    @NotNull
    public static final vq2 DEFAULT_UAST;
    @JvmField
    @NotNull
    public static final vq2 GENERIC_ARGUMENT;
    @JvmField
    @NotNull
    public static final vq2 GENERIC_ARGUMENT_UAST;
    @JvmField
    @NotNull
    public static final vq2 RETURN_TYPE_BOXED;
    @JvmField
    @NotNull
    public static final vq2 SUPER_TYPE;
    @JvmField
    @NotNull
    public static final vq2 SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS;
    @JvmField
    @NotNull
    public static final vq2 VALUE_FOR_ANNOTATION;
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    @Nullable
    private final vq2 f;
    private final boolean g;
    @Nullable
    private final vq2 h;
    @Nullable
    private final vq2 i;
    private final boolean j;

    /* compiled from: Taobao */
    /* renamed from: tb.vq2$a */
    /* loaded from: classes3.dex */
    public static final class C9824a {
        private C9824a() {
        }

        public /* synthetic */ C9824a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.vq2$b */
    /* loaded from: classes3.dex */
    public /* synthetic */ class C9825b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            iArr[Variance.IN_VARIANCE.ordinal()] = 1;
            iArr[Variance.INVARIANT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        vq2 vq2Var = new vq2(false, false, false, false, false, null, false, null, null, false, 1023, null);
        GENERIC_ARGUMENT = vq2Var;
        vq2 vq2Var2 = new vq2(false, false, false, false, false, null, false, null, null, true, FrameMetricsAggregator.EVERY_DURATION, null);
        GENERIC_ARGUMENT_UAST = vq2Var2;
        RETURN_TYPE_BOXED = new vq2(false, true, false, false, false, null, false, null, null, false, 1021, null);
        DEFAULT = new vq2(false, false, false, false, false, vq2Var, false, null, null, false, 988, null);
        DEFAULT_UAST = new vq2(false, false, false, false, false, vq2Var2, false, null, null, true, 476, null);
        CLASS_DECLARATION = new vq2(false, true, false, false, false, vq2Var, false, null, null, false, 988, null);
        SUPER_TYPE = new vq2(false, false, false, true, false, vq2Var, false, null, null, false, 983, null);
        SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS = new vq2(false, false, false, true, false, vq2Var, false, null, null, false, 919, null);
        VALUE_FOR_ANNOTATION = new vq2(false, false, true, false, false, vq2Var, false, null, null, false, 984, null);
    }

    public vq2(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, @Nullable vq2 vq2Var, boolean z6, @Nullable vq2 vq2Var2, @Nullable vq2 vq2Var3, boolean z7) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
        this.f = vq2Var;
        this.g = z6;
        this.h = vq2Var2;
        this.i = vq2Var3;
        this.j = z7;
    }

    public final boolean a() {
        return this.g;
    }

    public final boolean b() {
        return this.j;
    }

    public final boolean c() {
        return this.b;
    }

    public final boolean d() {
        return this.a;
    }

    public final boolean e() {
        return this.c;
    }

    @NotNull
    public final vq2 f(@NotNull Variance variance, boolean z) {
        b41.i(variance, "effectiveVariance");
        if (!z || !this.c) {
            int i = C9825b.$EnumSwitchMapping$0[variance.ordinal()];
            if (i == 1) {
                vq2 vq2Var = this.h;
                if (vq2Var != null) {
                    return vq2Var;
                }
            } else if (i != 2) {
                vq2 vq2Var2 = this.f;
                if (vq2Var2 != null) {
                    return vq2Var2;
                }
            } else {
                vq2 vq2Var3 = this.i;
                if (vq2Var3 != null) {
                    return vq2Var3;
                }
            }
        }
        return this;
    }

    @NotNull
    public final vq2 g() {
        return new vq2(this.a, true, this.c, this.d, this.e, this.f, this.g, this.h, this.i, false, 512, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ vq2(boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, tb.vq2 r17, boolean r18, tb.vq2 r19, tb.vq2 r20, boolean r21, int r22, tb.k50 r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            r2 = 1
            if (r1 == 0) goto L9
            r1 = 1
            goto La
        L9:
            r1 = r12
        La:
            r3 = r0 & 2
            if (r3 == 0) goto L10
            r3 = 1
            goto L11
        L10:
            r3 = r13
        L11:
            r4 = r0 & 4
            r5 = 0
            if (r4 == 0) goto L18
            r4 = 0
            goto L19
        L18:
            r4 = r14
        L19:
            r6 = r0 & 8
            if (r6 == 0) goto L1f
            r6 = 0
            goto L20
        L1f:
            r6 = r15
        L20:
            r7 = r0 & 16
            if (r7 == 0) goto L26
            r7 = 0
            goto L28
        L26:
            r7 = r16
        L28:
            r8 = r0 & 32
            if (r8 == 0) goto L2e
            r8 = 0
            goto L30
        L2e:
            r8 = r17
        L30:
            r9 = r0 & 64
            if (r9 == 0) goto L35
            goto L37
        L35:
            r2 = r18
        L37:
            r9 = r0 & 128(0x80, float:1.8E-43)
            if (r9 == 0) goto L3d
            r9 = r8
            goto L3f
        L3d:
            r9 = r19
        L3f:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L45
            r10 = r8
            goto L47
        L45:
            r10 = r20
        L47:
            r0 = r0 & 512(0x200, float:7.17E-43)
            if (r0 == 0) goto L4c
            goto L4e
        L4c:
            r5 = r21
        L4e:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r2
            r20 = r9
            r21 = r10
            r22 = r5
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.vq2.<init>(boolean, boolean, boolean, boolean, boolean, tb.vq2, boolean, tb.vq2, tb.vq2, boolean, int, tb.k50):void");
    }
}
