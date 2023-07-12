package kotlin.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.u1;

/* compiled from: Taobao */
/* renamed from: kotlin.collections.h */
/* loaded from: classes3.dex */
public class C8207h extends C8206g {

    /* compiled from: Taobao */
    /* renamed from: kotlin.collections.h$a */
    /* loaded from: classes3.dex */
    public static final class C8208a extends u1<Byte> implements RandomAccess {
        final /* synthetic */ byte[] a;

        C8208a(byte[] bArr) {
            this.a = bArr;
        }

        @Override // kotlin.collections.AbstractCollection
        public int a() {
            return this.a.length;
        }

        public boolean b(byte b) {
            return ArraysKt___ArraysKt.p(this.a, b);
        }

        @Override // tb.u1, java.util.List
        @NotNull
        /* renamed from: c */
        public Byte get(int i) {
            return Byte.valueOf(this.a[i]);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Byte) {
                return b(((Number) obj).byteValue());
            }
            return false;
        }

        public int d(byte b) {
            return ArraysKt___ArraysKt.z(this.a, b);
        }

        public int e(byte b) {
            return ArraysKt___ArraysKt.H(this.a, b);
        }

        @Override // tb.u1, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Byte) {
                return d(((Number) obj).byteValue());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.a.length == 0;
        }

        @Override // tb.u1, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Byte) {
                return e(((Number) obj).byteValue());
            }
            return -1;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.collections.h$b */
    /* loaded from: classes3.dex */
    public static final class C8209b extends u1<Integer> implements RandomAccess {
        final /* synthetic */ int[] a;

        C8209b(int[] iArr) {
            this.a = iArr;
        }

        @Override // kotlin.collections.AbstractCollection
        public int a() {
            return this.a.length;
        }

        public boolean b(int i) {
            return ArraysKt___ArraysKt.q(this.a, i);
        }

        @Override // tb.u1, java.util.List
        @NotNull
        /* renamed from: c */
        public Integer get(int i) {
            return Integer.valueOf(this.a[i]);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Integer) {
                return b(((Number) obj).intValue());
            }
            return false;
        }

        public int d(int i) {
            return ArraysKt___ArraysKt.A(this.a, i);
        }

        public int e(int i) {
            return ArraysKt___ArraysKt.I(this.a, i);
        }

        @Override // tb.u1, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return d(((Number) obj).intValue());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.a.length == 0;
        }

        @Override // tb.u1, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return e(((Number) obj).intValue());
            }
            return -1;
        }
    }

    @NotNull
    public static final List<Byte> b(@NotNull byte[] bArr) {
        b41.i(bArr, "<this>");
        return new C8208a(bArr);
    }

    @NotNull
    public static List<Integer> c(@NotNull int[] iArr) {
        b41.i(iArr, "<this>");
        return new C8209b(iArr);
    }

    @NotNull
    public static <T> List<T> d(@NotNull T[] tArr) {
        b41.i(tArr, "<this>");
        List<T> a = C8210i.a(tArr);
        b41.h(a, "asList(this)");
        return a;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static <T> T[] e(@NotNull T[] tArr, @NotNull T[] tArr2, int i, int i2, int i3) {
        b41.i(tArr, "<this>");
        b41.i(tArr2, "destination");
        System.arraycopy(tArr, i2, tArr2, i, i3 - i2);
        return tArr2;
    }

    public static /* synthetic */ Object[] f(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return C8202e.e(objArr, objArr2, i, i2, i3);
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static byte[] g(@NotNull byte[] bArr, int i, int i2) {
        b41.i(bArr, "<this>");
        C8204f.a(i2, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i2);
        b41.h(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static <T> T[] h(@NotNull T[] tArr, int i, int i2) {
        b41.i(tArr, "<this>");
        C8204f.a(i2, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i, i2);
        b41.h(tArr2, "copyOfRange(this, fromIndex, toIndex)");
        return tArr2;
    }

    public static void i(@NotNull int[] iArr, int i, int i2, int i3) {
        b41.i(iArr, "<this>");
        Arrays.fill(iArr, i2, i3, i);
    }

    public static <T> void j(@NotNull T[] tArr, T t, int i, int i2) {
        b41.i(tArr, "<this>");
        Arrays.fill(tArr, i, i2, t);
    }

    public static /* synthetic */ void k(Object[] objArr, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        j(objArr, obj, i, i2);
    }

    public static final <T> void l(@NotNull T[] tArr) {
        b41.i(tArr, "<this>");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    public static final <T> void m(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        b41.i(tArr, "<this>");
        b41.i(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }
}
