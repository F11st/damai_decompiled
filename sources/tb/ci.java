package tb;

import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ci implements Iterable<Character>, KMappedMarker {
    @NotNull
    public static final C9007a Companion = new C9007a(null);
    private final char a;
    private final char b;
    private final int c;

    /* compiled from: Taobao */
    /* renamed from: tb.ci$a */
    /* loaded from: classes3.dex */
    public static final class C9007a {
        private C9007a() {
        }

        public /* synthetic */ C9007a(k50 k50Var) {
            this();
        }
    }

    public ci(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i != Integer.MIN_VALUE) {
            this.a = c;
            this.b = (char) hv1.c(c, c2, i);
            this.c = i;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    }

    public final char a() {
        return this.a;
    }

    public final char b() {
        return this.b;
    }

    @Override // java.lang.Iterable
    @NotNull
    /* renamed from: c */
    public ai iterator() {
        return new di(this.a, this.b, this.c);
    }
}
