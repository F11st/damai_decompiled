package tb;

import kotlin.ranges.ClosedRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ei extends ci implements ClosedRange<Character> {
    @NotNull
    public static final C9100a Companion = new C9100a(null);

    /* compiled from: Taobao */
    /* renamed from: tb.ei$a */
    /* loaded from: classes3.dex */
    public static final class C9100a {
        private C9100a() {
        }

        public /* synthetic */ C9100a(k50 k50Var) {
            this();
        }
    }

    static {
        new ei((char) 1, (char) 0);
    }

    public ei(char c, char c2) {
        super(c, c2, 1);
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(Character ch) {
        return d(ch.charValue());
    }

    public boolean d(char c) {
        return b41.k(a(), c) <= 0 && b41.k(c, b()) <= 0;
    }

    @Override // kotlin.ranges.ClosedRange
    @NotNull
    /* renamed from: e */
    public Character getEndInclusive() {
        return Character.valueOf(b());
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ei) {
            if (!isEmpty() || !((ei) obj).isEmpty()) {
                ei eiVar = (ei) obj;
                if (a() != eiVar.a() || b() != eiVar.b()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.ClosedRange
    @NotNull
    /* renamed from: f */
    public Character getStart() {
        return Character.valueOf(a());
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return b41.k(a(), b()) > 0;
    }

    @NotNull
    public String toString() {
        return a() + ".." + b();
    }
}
