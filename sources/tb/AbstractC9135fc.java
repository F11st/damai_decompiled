package tb;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.C8207h;
import kotlin.collections.C8214m;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* renamed from: tb.fc */
/* loaded from: classes3.dex */
public abstract class AbstractC9135fc {
    @NotNull
    public static final C9136a Companion = new C9136a(null);
    @NotNull
    private final int[] a;
    private final int b;
    private final int c;
    private final int d;
    @NotNull
    private final List<Integer> e;

    /* compiled from: Taobao */
    /* renamed from: tb.fc$a */
    /* loaded from: classes3.dex */
    public static final class C9136a {
        private C9136a() {
        }

        public /* synthetic */ C9136a(k50 k50Var) {
            this();
        }
    }

    public AbstractC9135fc(@NotNull int... iArr) {
        Integer y;
        Integer y2;
        Integer y3;
        List<Integer> g;
        List<Integer> c;
        b41.i(iArr, "numbers");
        this.a = iArr;
        y = ArraysKt___ArraysKt.y(iArr, 0);
        this.b = y == null ? -1 : y.intValue();
        y2 = ArraysKt___ArraysKt.y(iArr, 1);
        this.c = y2 == null ? -1 : y2.intValue();
        y3 = ArraysKt___ArraysKt.y(iArr, 2);
        this.d = y3 != null ? y3.intValue() : -1;
        if (iArr.length > 3) {
            c = C8207h.c(iArr);
            g = CollectionsKt___CollectionsKt.A0(c.subList(3, iArr.length));
        } else {
            g = C8214m.g();
        }
        this.e = g;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public final boolean c(int i, int i2, int i3) {
        int i4 = this.b;
        if (i4 > i) {
            return true;
        }
        if (i4 < i) {
            return false;
        }
        int i5 = this.c;
        if (i5 > i2) {
            return true;
        }
        return i5 >= i2 && this.d >= i3;
    }

    public final boolean d(@NotNull AbstractC9135fc abstractC9135fc) {
        b41.i(abstractC9135fc, "version");
        return c(abstractC9135fc.b, abstractC9135fc.c, abstractC9135fc.d);
    }

    public final boolean e(int i, int i2, int i3) {
        int i4 = this.b;
        if (i4 < i) {
            return true;
        }
        if (i4 > i) {
            return false;
        }
        int i5 = this.c;
        if (i5 < i2) {
            return true;
        }
        return i5 <= i2 && this.d <= i3;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj != null && b41.d(getClass(), obj.getClass())) {
            AbstractC9135fc abstractC9135fc = (AbstractC9135fc) obj;
            if (this.b == abstractC9135fc.b && this.c == abstractC9135fc.c && this.d == abstractC9135fc.d && b41.d(this.e, abstractC9135fc.e)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean f(@NotNull AbstractC9135fc abstractC9135fc) {
        b41.i(abstractC9135fc, "ourVersion");
        int i = this.b;
        if (i == 0) {
            if (abstractC9135fc.b == 0 && this.c == abstractC9135fc.c) {
                return true;
            }
        } else if (i == abstractC9135fc.b && this.c <= abstractC9135fc.c) {
            return true;
        }
        return false;
    }

    @NotNull
    public final int[] g() {
        return this.a;
    }

    public int hashCode() {
        int i = this.b;
        int i2 = i + (i * 31) + this.c;
        int i3 = i2 + (i2 * 31) + this.d;
        return i3 + (i3 * 31) + this.e.hashCode();
    }

    @NotNull
    public String toString() {
        String Z;
        int[] g = g();
        ArrayList arrayList = new ArrayList();
        int length = g.length;
        for (int i = 0; i < length; i++) {
            int i2 = g[i];
            if (!(i2 != -1)) {
                break;
            }
            arrayList.add(Integer.valueOf(i2));
        }
        if (arrayList.isEmpty()) {
            return "unknown";
        }
        Z = CollectionsKt___CollectionsKt.Z(arrayList, ".", null, null, 0, null, null, 62, null);
        return Z;
    }
}
