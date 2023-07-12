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
public final class cs2 implements Comparable<cs2> {
    @NotNull
    public static final C9014a Companion = new C9014a(null);
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;
    private final long a;

    /* compiled from: Taobao */
    /* renamed from: tb.cs2$a */
    /* loaded from: classes3.dex */
    public static final class C9014a {
        private C9014a() {
        }

        public /* synthetic */ C9014a(k50 k50Var) {
            this();
        }
    }

    @PublishedApi
    private /* synthetic */ cs2(long j) {
        this.a = j;
    }

    public static final /* synthetic */ cs2 a(long j) {
        return new cs2(j);
    }

    @PublishedApi
    public static long b(long j) {
        return j;
    }

    public static boolean c(long j, Object obj) {
        return (obj instanceof cs2) && j == ((cs2) obj).f();
    }

    public static int d(long j) {
        return (int) (j ^ (j >>> 32));
    }

    @NotNull
    public static String e(long j) {
        return du2.c(j);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(cs2 cs2Var) {
        return du2.b(f(), cs2Var.f());
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public final /* synthetic */ long f() {
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
