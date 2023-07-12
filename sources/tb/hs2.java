package tb;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.JvmInline;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@SinceKotlin(version = "1.5")
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: classes3.dex */
public final class hs2 implements Comparable<hs2> {
    @NotNull
    public static final C9233a Companion = new C9233a(null);
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short a;

    /* compiled from: Taobao */
    /* renamed from: tb.hs2$a */
    /* loaded from: classes3.dex */
    public static final class C9233a {
        private C9233a() {
        }

        public /* synthetic */ C9233a(k50 k50Var) {
            this();
        }
    }

    @PublishedApi
    private /* synthetic */ hs2(short s) {
        this.a = s;
    }

    public static final /* synthetic */ hs2 a(short s) {
        return new hs2(s);
    }

    @PublishedApi
    public static short b(short s) {
        return s;
    }

    public static boolean c(short s, Object obj) {
        return (obj instanceof hs2) && s == ((hs2) obj).f();
    }

    public static int d(short s) {
        return s;
    }

    @NotNull
    public static String e(short s) {
        return String.valueOf(s & MAX_VALUE);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(hs2 hs2Var) {
        return b41.k(f() & MAX_VALUE, hs2Var.f() & MAX_VALUE);
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public final /* synthetic */ short f() {
        return this.a;
    }

    public int hashCode() {
        return d(this.a);
    }

    @NotNull
    public String toString() {
        return e(this.a);
    }
}
