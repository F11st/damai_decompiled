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
public final class zr2 implements Comparable<zr2> {
    @NotNull
    public static final C10033a Companion = new C10033a(null);
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;
    private final int a;

    /* compiled from: Taobao */
    /* renamed from: tb.zr2$a */
    /* loaded from: classes3.dex */
    public static final class C10033a {
        private C10033a() {
        }

        public /* synthetic */ C10033a(k50 k50Var) {
            this();
        }
    }

    @PublishedApi
    private /* synthetic */ zr2(int i) {
        this.a = i;
    }

    public static final /* synthetic */ zr2 a(int i) {
        return new zr2(i);
    }

    @PublishedApi
    public static int b(int i) {
        return i;
    }

    public static boolean c(int i, Object obj) {
        return (obj instanceof zr2) && i == ((zr2) obj).f();
    }

    public static int d(int i) {
        return i;
    }

    @NotNull
    public static String e(int i) {
        return String.valueOf(i & 4294967295L);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(zr2 zr2Var) {
        return du2.a(f(), zr2Var.f());
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public final /* synthetic */ int f() {
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
