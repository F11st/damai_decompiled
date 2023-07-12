package tb;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public abstract class sl {
    private static final sl a = new a();
    private static final sl b = new b(-1);
    private static final sl c = new b(1);

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class a extends sl {
        a() {
            super(null);
        }

        @Override // tb.sl
        public sl d(Comparable comparable, Comparable comparable2) {
            return g(comparable.compareTo(comparable2));
        }

        @Override // tb.sl
        public int e() {
            return 0;
        }

        sl g(int i) {
            if (i < 0) {
                return sl.b;
            }
            return i > 0 ? sl.c : sl.a;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static final class b extends sl {
        final int d;

        b(int i) {
            super(null);
            this.d = i;
        }

        @Override // tb.sl
        public sl d(@NullableDecl Comparable comparable, @NullableDecl Comparable comparable2) {
            return this;
        }

        @Override // tb.sl
        public int e() {
            return this.d;
        }
    }

    /* synthetic */ sl(a aVar) {
        this();
    }

    public static sl f() {
        return a;
    }

    public abstract sl d(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract int e();

    private sl() {
    }
}
