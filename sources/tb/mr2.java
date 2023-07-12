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
public final class mr2 implements Comparable<mr2> {
    @NotNull
    public static final C9451a Companion = new C9451a(null);
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    private final byte a;

    /* compiled from: Taobao */
    /* renamed from: tb.mr2$a */
    /* loaded from: classes3.dex */
    public static final class C9451a {
        private C9451a() {
        }

        public /* synthetic */ C9451a(k50 k50Var) {
            this();
        }
    }

    @PublishedApi
    private /* synthetic */ mr2(byte b) {
        this.a = b;
    }

    public static final /* synthetic */ mr2 a(byte b) {
        return new mr2(b);
    }

    @PublishedApi
    public static byte b(byte b) {
        return b;
    }

    public static boolean c(byte b, Object obj) {
        return (obj instanceof mr2) && b == ((mr2) obj).f();
    }

    public static int d(byte b) {
        return b;
    }

    @NotNull
    public static String e(byte b) {
        return String.valueOf(b & 255);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(mr2 mr2Var) {
        return b41.k(f() & 255, mr2Var.f() & 255);
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public final /* synthetic */ byte f() {
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
