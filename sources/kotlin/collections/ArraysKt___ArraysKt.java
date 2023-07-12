package kotlin.collections;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hq2;
import tb.i21;
import tb.j21;
import tb.n31;
import tb.r7;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ArraysKt___ArraysKt extends h {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a<T> implements Iterable<T>, KMappedMarker {
        final /* synthetic */ Object[] a;

        public a(Object[] objArr) {
            this.a = objArr;
        }

        @Override // java.lang.Iterable
        @NotNull
        public Iterator<T> iterator() {
            return r7.a(this.a);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class b<T> implements Sequence<T> {
        final /* synthetic */ Object[] a;

        public b(Object[] objArr) {
            this.a = objArr;
        }

        @Override // kotlin.sequences.Sequence
        @NotNull
        public Iterator<T> iterator() {
            return r7.a(this.a);
        }
    }

    public static final int A(@NotNull int[] iArr, int i) {
        b41.i(iArr, "<this>");
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i == iArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static <T> int B(@NotNull T[] tArr, T t) {
        b41.i(tArr, "<this>");
        int i = 0;
        if (t == null) {
            int length = tArr.length;
            while (i < length) {
                if (tArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i < length2) {
            if (b41.d(t, tArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @NotNull
    public static final <T, A extends Appendable> A C(@NotNull T[] tArr, @NotNull A a2, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        b41.i(tArr, "<this>");
        b41.i(a2, "buffer");
        b41.i(charSequence, "separator");
        b41.i(charSequence2, Constants.Name.PREFIX);
        b41.i(charSequence3, "postfix");
        b41.i(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (T t : tArr) {
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            kotlin.text.h.a(a2, t, function1);
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    @NotNull
    public static final <T> String E(@NotNull T[] tArr, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        b41.i(tArr, "<this>");
        b41.i(charSequence, "separator");
        b41.i(charSequence2, Constants.Name.PREFIX);
        b41.i(charSequence3, "postfix");
        b41.i(charSequence4, "truncated");
        String sb = ((StringBuilder) C(tArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
        b41.h(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String F(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = AVFSCacheConstants.COMMA_SEP;
        }
        String str = (i2 & 2) != 0 ? "" : charSequence2;
        String str2 = (i2 & 4) == 0 ? charSequence3 : "";
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return E(objArr, charSequence, str, str2, i3, charSequence5, function1);
    }

    public static <T> T G(@NotNull T[] tArr) {
        int x;
        b41.i(tArr, "<this>");
        if (!(tArr.length == 0)) {
            x = x(tArr);
            return tArr[x];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int H(@NotNull byte[] bArr, byte b2) {
        b41.i(bArr, "<this>");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (b2 == bArr[length]) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    public static final int I(@NotNull int[] iArr, int i) {
        b41.i(iArr, "<this>");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (i == iArr[length]) {
                    return length;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return -1;
    }

    @NotNull
    public static <T, R> List<R> J(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> function1) {
        b41.i(tArr, "<this>");
        b41.i(function1, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T t : tArr) {
            arrayList.add(function1.invoke(t));
        }
        return arrayList;
    }

    public static char K(@NotNull char[] cArr) {
        b41.i(cArr, "<this>");
        int length = cArr.length;
        if (length != 0) {
            if (length == 1) {
                return cArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static <T> T L(@NotNull T[] tArr) {
        b41.i(tArr, "<this>");
        int length = tArr.length;
        if (length != 0) {
            if (length == 1) {
                return tArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Nullable
    public static <T> T M(@NotNull T[] tArr) {
        b41.i(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    @NotNull
    public static List<Byte> N(@NotNull byte[] bArr, @NotNull n31 n31Var) {
        byte[] g;
        List<Byte> g2;
        b41.i(bArr, "<this>");
        b41.i(n31Var, "indices");
        if (n31Var.isEmpty()) {
            g2 = m.g();
            return g2;
        }
        g = h.g(bArr, n31Var.getStart().intValue(), n31Var.getEndInclusive().intValue() + 1);
        return h.b(g);
    }

    @NotNull
    public static final <T> T[] O(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        b41.i(tArr, "<this>");
        b41.i(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        b41.h(tArr2, "copyOf(this, size)");
        h.m(tArr2, comparator);
        return tArr2;
    }

    @NotNull
    public static <T> List<T> P(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        List<T> d;
        b41.i(tArr, "<this>");
        b41.i(comparator, "comparator");
        d = h.d(O(tArr, comparator));
        return d;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C Q(@NotNull T[] tArr, @NotNull C c) {
        b41.i(tArr, "<this>");
        b41.i(c, "destination");
        for (T t : tArr) {
            c.add(t);
        }
        return c;
    }

    @NotNull
    public static List<Byte> R(@NotNull byte[] bArr) {
        List<Byte> g;
        List<Byte> e;
        b41.i(bArr, "<this>");
        int length = bArr.length;
        if (length == 0) {
            g = m.g();
            return g;
        } else if (length != 1) {
            return a0(bArr);
        } else {
            e = l.e(Byte.valueOf(bArr[0]));
            return e;
        }
    }

    @NotNull
    public static List<Character> S(@NotNull char[] cArr) {
        List<Character> g;
        List<Character> e;
        b41.i(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            g = m.g();
            return g;
        } else if (length != 1) {
            return b0(cArr);
        } else {
            e = l.e(Character.valueOf(cArr[0]));
            return e;
        }
    }

    @NotNull
    public static List<Double> T(@NotNull double[] dArr) {
        List<Double> g;
        List<Double> e;
        b41.i(dArr, "<this>");
        int length = dArr.length;
        if (length == 0) {
            g = m.g();
            return g;
        } else if (length != 1) {
            return c0(dArr);
        } else {
            e = l.e(Double.valueOf(dArr[0]));
            return e;
        }
    }

    @NotNull
    public static List<Float> U(@NotNull float[] fArr) {
        List<Float> g;
        List<Float> e;
        b41.i(fArr, "<this>");
        int length = fArr.length;
        if (length == 0) {
            g = m.g();
            return g;
        } else if (length != 1) {
            return d0(fArr);
        } else {
            e = l.e(Float.valueOf(fArr[0]));
            return e;
        }
    }

    @NotNull
    public static List<Integer> V(@NotNull int[] iArr) {
        List<Integer> g;
        List<Integer> e;
        b41.i(iArr, "<this>");
        int length = iArr.length;
        if (length == 0) {
            g = m.g();
            return g;
        } else if (length != 1) {
            return e0(iArr);
        } else {
            e = l.e(Integer.valueOf(iArr[0]));
            return e;
        }
    }

    @NotNull
    public static List<Long> W(@NotNull long[] jArr) {
        List<Long> g;
        List<Long> e;
        b41.i(jArr, "<this>");
        int length = jArr.length;
        if (length == 0) {
            g = m.g();
            return g;
        } else if (length != 1) {
            return f0(jArr);
        } else {
            e = l.e(Long.valueOf(jArr[0]));
            return e;
        }
    }

    @NotNull
    public static <T> List<T> X(@NotNull T[] tArr) {
        List<T> g;
        List<T> e;
        List<T> g0;
        b41.i(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            g = m.g();
            return g;
        } else if (length != 1) {
            g0 = g0(tArr);
            return g0;
        } else {
            e = l.e(tArr[0]);
            return e;
        }
    }

    @NotNull
    public static List<Short> Y(@NotNull short[] sArr) {
        List<Short> g;
        List<Short> e;
        b41.i(sArr, "<this>");
        int length = sArr.length;
        if (length == 0) {
            g = m.g();
            return g;
        } else if (length != 1) {
            return h0(sArr);
        } else {
            e = l.e(Short.valueOf(sArr[0]));
            return e;
        }
    }

    @NotNull
    public static List<Boolean> Z(@NotNull boolean[] zArr) {
        List<Boolean> g;
        List<Boolean> e;
        b41.i(zArr, "<this>");
        int length = zArr.length;
        if (length == 0) {
            g = m.g();
            return g;
        } else if (length != 1) {
            return i0(zArr);
        } else {
            e = l.e(Boolean.valueOf(zArr[0]));
            return e;
        }
    }

    @NotNull
    public static final List<Byte> a0(@NotNull byte[] bArr) {
        b41.i(bArr, "<this>");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b2 : bArr) {
            arrayList.add(Byte.valueOf(b2));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Character> b0(@NotNull char[] cArr) {
        b41.i(cArr, "<this>");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c : cArr) {
            arrayList.add(Character.valueOf(c));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Double> c0(@NotNull double[] dArr) {
        b41.i(dArr, "<this>");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d : dArr) {
            arrayList.add(Double.valueOf(d));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Float> d0(@NotNull float[] fArr) {
        b41.i(fArr, "<this>");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f : fArr) {
            arrayList.add(Float.valueOf(f));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Integer> e0(@NotNull int[] iArr) {
        b41.i(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Long> f0(@NotNull long[] jArr) {
        b41.i(jArr, "<this>");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j : jArr) {
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    @NotNull
    public static <T> List<T> g0(@NotNull T[] tArr) {
        b41.i(tArr, "<this>");
        return new ArrayList(m.f(tArr));
    }

    @NotNull
    public static final List<Short> h0(@NotNull short[] sArr) {
        b41.i(sArr, "<this>");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s : sArr) {
            arrayList.add(Short.valueOf(s));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Boolean> i0(@NotNull boolean[] zArr) {
        b41.i(zArr, "<this>");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z : zArr) {
            arrayList.add(Boolean.valueOf(z));
        }
        return arrayList;
    }

    @NotNull
    public static <T> Set<T> j0(@NotNull T[] tArr) {
        Set<T> d;
        Set<T> c;
        int e;
        b41.i(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            d = e0.d();
            return d;
        } else if (length != 1) {
            e = w.e(tArr.length);
            return (Set) Q(tArr, new LinkedHashSet(e));
        } else {
            c = d0.c(tArr[0]);
            return c;
        }
    }

    @NotNull
    public static <T> Iterable<i21<T>> k0(@NotNull final T[] tArr) {
        b41.i(tArr, "<this>");
        return new j21(new Function0<Iterator<? extends T>>() { // from class: kotlin.collections.ArraysKt___ArraysKt$withIndex$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Iterator<T> invoke() {
                return r7.a(tArr);
            }
        });
    }

    @NotNull
    public static <T, R> List<Pair<T, R>> l0(@NotNull T[] tArr, @NotNull R[] rArr) {
        b41.i(tArr, "<this>");
        b41.i(rArr, "other");
        int min = Math.min(tArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(hq2.a(tArr[i], rArr[i]));
        }
        return arrayList;
    }

    @NotNull
    public static <T> Iterable<T> n(@NotNull T[] tArr) {
        List g;
        b41.i(tArr, "<this>");
        if (tArr.length == 0) {
            g = m.g();
            return g;
        }
        return new a(tArr);
    }

    @NotNull
    public static <T> Sequence<T> o(@NotNull T[] tArr) {
        Sequence<T> e;
        b41.i(tArr, "<this>");
        if (tArr.length == 0) {
            e = SequencesKt__SequencesKt.e();
            return e;
        }
        return new b(tArr);
    }

    public static final boolean p(@NotNull byte[] bArr, byte b2) {
        b41.i(bArr, "<this>");
        return z(bArr, b2) >= 0;
    }

    public static final boolean q(@NotNull int[] iArr, int i) {
        b41.i(iArr, "<this>");
        return A(iArr, i) >= 0;
    }

    public static <T> boolean r(@NotNull T[] tArr, T t) {
        int B;
        b41.i(tArr, "<this>");
        B = B(tArr, t);
        return B >= 0;
    }

    @NotNull
    public static <T> List<T> s(@NotNull T[] tArr) {
        b41.i(tArr, "<this>");
        return (List) t(tArr, new ArrayList());
    }

    @NotNull
    public static final <C extends Collection<? super T>, T> C t(@NotNull T[] tArr, @NotNull C c) {
        b41.i(tArr, "<this>");
        b41.i(c, "destination");
        for (T t : tArr) {
            if (t != null) {
                c.add(t);
            }
        }
        return c;
    }

    public static <T> T u(@NotNull T[] tArr) {
        b41.i(tArr, "<this>");
        if (!(tArr.length == 0)) {
            return tArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Nullable
    public static <T> T v(@NotNull T[] tArr) {
        b41.i(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    public static final int w(@NotNull int[] iArr) {
        b41.i(iArr, "<this>");
        return iArr.length - 1;
    }

    public static <T> int x(@NotNull T[] tArr) {
        b41.i(tArr, "<this>");
        return tArr.length - 1;
    }

    @Nullable
    public static Integer y(@NotNull int[] iArr, int i) {
        b41.i(iArr, "<this>");
        if (i < 0 || i > w(iArr)) {
            return null;
        }
        return Integer.valueOf(iArr[i]);
    }

    public static final int z(@NotNull byte[] bArr, byte b2) {
        b41.i(bArr, "<this>");
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if (b2 == bArr[i]) {
                return i;
            }
        }
        return -1;
    }
}
