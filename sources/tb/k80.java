package tb;

import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class k80 {

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class a extends k80 {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
            super(null);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class b extends k80 {
        private final float a;

        public b(float f) {
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
            return (obj instanceof b) && b41.d(Float.valueOf(this.a), Float.valueOf(((b) obj).a));
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
    /* loaded from: classes.dex */
    public static final class c extends k80 {
        private final float a;

        public c(float f) {
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
            return (obj instanceof c) && b41.d(Float.valueOf(this.a), Float.valueOf(((c) obj).a));
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
    /* loaded from: classes.dex */
    public static final class d extends k80 {
        @NotNull
        public static final d INSTANCE = new d();

        private d() {
            super(null);
        }
    }

    private k80() {
    }

    public /* synthetic */ k80(k50 k50Var) {
        this();
    }

    public final int a() {
        if (this instanceof c) {
            return 0;
        }
        if (this instanceof b) {
            return 1;
        }
        if (this instanceof d) {
            return 2;
        }
        if (this instanceof a) {
            return 3;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final float b() {
        if (this instanceof c) {
            return ((c) this).c();
        }
        if (this instanceof b) {
            return ((b) this).c();
        }
        if ((this instanceof d) || (this instanceof a)) {
            return 0.0f;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public String toString() {
        if (this instanceof c) {
            return "Dimension.Points";
        }
        if (this instanceof b) {
            return "Dimension.Percent(value=" + b() + ')';
        } else if (this instanceof d) {
            return "Dimension.Undefined";
        } else {
            if (this instanceof a) {
                return "Dimension.Auto";
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
