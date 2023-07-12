package tb;

import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class l31 implements Iterable<Integer>, KMappedMarker {
    @NotNull
    public static final a Companion = new a(null);
    private final int a;
    private final int b;
    private final int c;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public final l31 a(int i, int i2, int i3) {
            return new l31(i, i2, i3);
        }
    }

    public l31(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 != Integer.MIN_VALUE) {
            this.a = i;
            this.b = hv1.c(i, i2, i3);
            this.c = i3;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    @Override // java.lang.Iterable
    @NotNull
    /* renamed from: d */
    public i31 iterator() {
        return new m31(this.a, this.b, this.c);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof l31) {
            if (!isEmpty() || !((l31) obj).isEmpty()) {
                l31 l31Var = (l31) obj;
                if (this.a != l31Var.a || this.b != l31Var.b || this.c != l31Var.c) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public boolean isEmpty() {
        if (this.c > 0) {
            if (this.a > this.b) {
                return true;
            }
        } else if (this.a < this.b) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        int i;
        if (this.c > 0) {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append("..");
            sb.append(this.b);
            sb.append(" step ");
            i = this.c;
        } else {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" downTo ");
            sb.append(this.b);
            sb.append(" step ");
            i = -this.c;
        }
        sb.append(i);
        return sb.toString();
    }
}
