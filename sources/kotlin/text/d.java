package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.n31;
import tb.ty1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class d implements Sequence<n31> {
    @NotNull
    private final CharSequence a;
    private final int b;
    private final int c;
    @NotNull
    private final Function2<CharSequence, Integer, Pair<Integer, Integer>> d;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a implements Iterator<n31>, KMappedMarker {
        private int a = -1;
        private int b;
        private int c;
        @Nullable
        private n31 d;
        private int e;

        a() {
            int f;
            f = ty1.f(d.this.b, 0, d.this.a.length());
            this.b = f;
            this.c = f;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
            if (r0 < r6.f.c) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void a() {
            /*
                r6 = this;
                int r0 = r6.c
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.a = r1
                r0 = 0
                r6.d = r0
                goto L9e
            Lc:
                kotlin.text.d r0 = kotlin.text.d.this
                int r0 = kotlin.text.d.c(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.e
                int r0 = r0 + r3
                r6.e = r0
                kotlin.text.d r4 = kotlin.text.d.this
                int r4 = kotlin.text.d.c(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.c
                kotlin.text.d r4 = kotlin.text.d.this
                java.lang.CharSequence r4 = kotlin.text.d.b(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                tb.n31 r0 = new tb.n31
                int r1 = r6.b
                kotlin.text.d r4 = kotlin.text.d.this
                java.lang.CharSequence r4 = kotlin.text.d.b(r4)
                int r4 = kotlin.text.g.T(r4)
                r0.<init>(r1, r4)
                r6.d = r0
                r6.c = r2
                goto L9c
            L47:
                kotlin.text.d r0 = kotlin.text.d.this
                kotlin.jvm.functions.Function2 r0 = kotlin.text.d.a(r0)
                kotlin.text.d r4 = kotlin.text.d.this
                java.lang.CharSequence r4 = kotlin.text.d.b(r4)
                int r5 = r6.c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                kotlin.Pair r0 = (kotlin.Pair) r0
                if (r0 != 0) goto L77
                tb.n31 r0 = new tb.n31
                int r1 = r6.b
                kotlin.text.d r4 = kotlin.text.d.this
                java.lang.CharSequence r4 = kotlin.text.d.b(r4)
                int r4 = kotlin.text.g.T(r4)
                r0.<init>(r1, r4)
                r6.d = r0
                r6.c = r2
                goto L9c
            L77:
                java.lang.Object r2 = r0.component1()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.component2()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.b
                tb.n31 r4 = tb.ry1.h(r4, r2)
                r6.d = r4
                int r2 = r2 + r0
                r6.b = r2
                if (r0 != 0) goto L99
                r1 = 1
            L99:
                int r2 = r2 + r1
                r6.c = r2
            L9c:
                r6.a = r3
            L9e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.d.a.a():void");
        }

        @Override // java.util.Iterator
        @NotNull
        /* renamed from: b */
        public n31 next() {
            if (this.a == -1) {
                a();
            }
            if (this.a != 0) {
                n31 n31Var = this.d;
                b41.g(n31Var, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.d = null;
                this.a = -1;
                return n31Var;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.a == -1) {
                a();
            }
            return this.a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull CharSequence charSequence, int i, int i2, @NotNull Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>> function2) {
        b41.i(charSequence, "input");
        b41.i(function2, "getNextMatch");
        this.a = charSequence;
        this.b = i;
        this.c = i2;
        this.d = function2;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<n31> iterator() {
        return new a();
    }
}
