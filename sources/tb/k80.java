package tb;

import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class k80 {

    /* compiled from: Taobao */
    /* renamed from: tb.k80$a */
    /* loaded from: classes.dex */
    public static final class C9337a extends k80 {
        @NotNull
        public static final C9337a INSTANCE = new C9337a();

        private C9337a() {
            super(null);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.k80$b */
    /* loaded from: classes.dex */
    public static final class C9338b extends k80 {
        private final float a;

        public C9338b(float f) {
            super(null);
            this.a = f;
        }

        public final float c() {
            return this.a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C9338b) && b41.d(Float.valueOf(this.a), Float.valueOf(((C9338b) obj).a));
        }

        public int hashCode() {
            return Float.floatToIntBits(this.a);
        }

        @Override // tb.k80
        @NotNull
        public String toString() {
            return "Percent(percentage=" + this.a + ')';
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.k80$c */
    /* loaded from: classes.dex */
    public static final class C9339c extends k80 {
        private final float a;

        public C9339c(float f) {
            super(null);
            this.a = f;
        }

        public final float c() {
            return this.a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C9339c) && b41.d(Float.valueOf(this.a), Float.valueOf(((C9339c) obj).a));
        }

        public int hashCode() {
            return Float.floatToIntBits(this.a);
        }

        @Override // tb.k80
        @NotNull
        public String toString() {
            return "Points(points=" + this.a + ')';
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.k80$d */
    /* loaded from: classes.dex */
    public static final class C9340d extends k80 {
        @NotNull
        public static final C9340d INSTANCE = new C9340d();

        private C9340d() {
            super(null);
        }
    }

    private k80() {
    }

    public /* synthetic */ k80(k50 k50Var) {
        this();
    }

    public final int a() {
        if (this instanceof C9339c) {
            return 0;
        }
        if (this instanceof C9338b) {
            return 1;
        }
        if (this instanceof C9340d) {
            return 2;
        }
        if (this instanceof C9337a) {
            return 3;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final float b() {
        if (this instanceof C9339c) {
            return ((C9339c) this).c();
        }
        if (this instanceof C9338b) {
            return ((C9338b) this).c();
        }
        if ((this instanceof C9340d) || (this instanceof C9337a)) {
            return 0.0f;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public String toString() {
        if (this instanceof C9339c) {
            return "Dimension.Points";
        }
        if (this instanceof C9338b) {
            return "Dimension.Percent(value=" + b() + ')';
        } else if (this instanceof C9340d) {
            return "Dimension.Undefined";
        } else {
            if (this instanceof C9337a) {
                return "Dimension.Auto";
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
