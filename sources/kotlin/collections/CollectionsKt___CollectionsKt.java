package kotlin.collections;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.text.C8597h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hq2;
import tb.i21;
import tb.j21;
import tb.ty1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class CollectionsKt___CollectionsKt extends C8222t {

    /* compiled from: Taobao */
    /* renamed from: kotlin.collections.CollectionsKt___CollectionsKt$a */
    /* loaded from: classes3.dex */
    public static final class C8182a<T> implements Sequence<T> {
        final /* synthetic */ Iterable a;

        public C8182a(Iterable iterable) {
            this.a = iterable;
        }

        @Override // kotlin.sequences.Sequence
        @NotNull
        public Iterator<T> iterator() {
            return this.a.iterator();
        }
    }

    @NotNull
    public static <T> List<T> A0(@NotNull Iterable<? extends T> iterable) {
        List<T> n;
        List<T> g;
        List<T> e;
        List<T> C0;
        b41.i(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                g = C8214m.g();
                return g;
            } else if (size != 1) {
                C0 = C0(collection);
                return C0;
            } else {
                e = C8213l.e(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
                return e;
            }
        }
        n = C8214m.n(B0(iterable));
        return n;
    }

    @NotNull
    public static final <T> List<T> B0(@NotNull Iterable<? extends T> iterable) {
        List<T> C0;
        b41.i(iterable, "<this>");
        if (iterable instanceof Collection) {
            C0 = C0((Collection) iterable);
            return C0;
        }
        return (List) x0(iterable, new ArrayList());
    }

    @NotNull
    public static <T> List<T> C0(@NotNull Collection<? extends T> collection) {
        b41.i(collection, "<this>");
        return new ArrayList(collection);
    }

    @NotNull
    public static <T> Set<T> D0(@NotNull Iterable<? extends T> iterable) {
        b41.i(iterable, "<this>");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) x0(iterable, new LinkedHashSet());
    }

    @NotNull
    public static <T> Set<T> E0(@NotNull Iterable<? extends T> iterable) {
        Set<T> d;
        Set<T> c;
        int e;
        b41.i(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                d = C8203e0.d();
                return d;
            } else if (size != 1) {
                e = C8225w.e(collection.size());
                return (Set) x0(iterable, new LinkedHashSet(e));
            } else {
                c = C8201d0.c(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
                return c;
            }
        }
        return C8203e0.f((Set) x0(iterable, new LinkedHashSet()));
    }

    @NotNull
    public static <T> Set<T> F0(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> iterable2) {
        Set<T> D0;
        b41.i(iterable, "<this>");
        b41.i(iterable2, "other");
        D0 = D0(iterable);
        C8220r.v(D0, iterable2);
        return D0;
    }

    @NotNull
    public static <T> Iterable<i21<T>> G0(@NotNull final Iterable<? extends T> iterable) {
        b41.i(iterable, "<this>");
        return new j21(new Function0<Iterator<? extends T>>() { // from class: kotlin.collections.CollectionsKt___CollectionsKt$withIndex$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Iterator<T> invoke() {
                return iterable.iterator();
            }
        });
    }

    public static <T> boolean H(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        b41.i(iterable, "<this>");
        b41.i(function1, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (!function1.invoke((T) it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static <T, R> List<Pair<T, R>> H0(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends R> iterable2) {
        int q;
        int q2;
        b41.i(iterable, "<this>");
        b41.i(iterable2, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = iterable2.iterator();
        q = C8215n.q(iterable, 10);
        q2 = C8215n.q(iterable2, 10);
        ArrayList arrayList = new ArrayList(Math.min(q, q2));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(hq2.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    @NotNull
    public static <T> Sequence<T> I(@NotNull Iterable<? extends T> iterable) {
        b41.i(iterable, "<this>");
        return new C8182a(iterable);
    }

    public static <T> boolean J(@NotNull Iterable<? extends T> iterable, T t) {
        b41.i(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t);
        }
        return T(iterable, t) >= 0;
    }

    @NotNull
    public static <T> List<T> K(@NotNull Iterable<? extends T> iterable) {
        Set D0;
        List<T> A0;
        b41.i(iterable, "<this>");
        D0 = D0(iterable);
        A0 = A0(D0);
        return A0;
    }

    @NotNull
    public static <T> List<T> L(@NotNull Iterable<? extends T> iterable, int i) {
        ArrayList arrayList;
        List<T> n;
        List<T> e;
        List<T> g;
        List<T> A0;
        b41.i(iterable, "<this>");
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        } else if (i == 0) {
            A0 = A0(iterable);
            return A0;
        } else {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                int size = collection.size() - i;
                if (size <= 0) {
                    g = C8214m.g();
                    return g;
                } else if (size == 1) {
                    e = C8213l.e(C8212k.a0(iterable));
                    return e;
                } else {
                    arrayList = new ArrayList(size);
                    if (iterable instanceof List) {
                        if (iterable instanceof RandomAccess) {
                            int size2 = collection.size();
                            while (i < size2) {
                                arrayList.add(((List) iterable).get(i));
                                i++;
                            }
                        } else {
                            ListIterator listIterator = ((List) iterable).listIterator(i);
                            while (listIterator.hasNext()) {
                                arrayList.add(listIterator.next());
                            }
                        }
                        return arrayList;
                    }
                }
            } else {
                arrayList = new ArrayList();
            }
            for (T t : iterable) {
                if (i2 >= i) {
                    arrayList.add(t);
                } else {
                    i2++;
                }
            }
            n = C8214m.n(arrayList);
            return n;
        }
    }

    @NotNull
    public static <T> List<T> M(@NotNull List<? extends T> list, int i) {
        int a;
        List<T> v0;
        b41.i(list, "<this>");
        if (i >= 0) {
            a = ty1.a(list.size() - i, 0);
            v0 = v0(list, a);
            return v0;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @NotNull
    public static <T> List<T> N(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        b41.i(iterable, "<this>");
        b41.i(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (T) it.next();
            if (function1.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static <T> T O(@NotNull Iterable<? extends T> iterable) {
        b41.i(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) C8212k.P((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T P(@NotNull List<? extends T> list) {
        b41.i(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    @Nullable
    public static <T> T Q(@NotNull Iterable<? extends T> iterable) {
        b41.i(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    @Nullable
    public static <T> T R(@NotNull List<? extends T> list) {
        b41.i(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Nullable
    public static <T> T S(@NotNull List<? extends T> list, int i) {
        int i2;
        b41.i(list, "<this>");
        if (i >= 0) {
            i2 = C8214m.i(list);
            if (i <= i2) {
                return list.get(i);
            }
        }
        return null;
    }

    public static final <T> int T(@NotNull Iterable<? extends T> iterable, T t) {
        b41.i(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t);
        }
        int i = 0;
        for (T t2 : iterable) {
            if (i < 0) {
                C8214m.p();
            }
            if (b41.d(t, t2)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static <T> int U(@NotNull List<? extends T> list, T t) {
        b41.i(list, "<this>");
        return list.indexOf(t);
    }

    @NotNull
    public static <T> Set<T> V(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> iterable2) {
        Set<T> D0;
        b41.i(iterable, "<this>");
        b41.i(iterable2, "other");
        D0 = D0(iterable);
        C8220r.A(D0, iterable2);
        return D0;
    }

    @NotNull
    public static final <T, A extends Appendable> A W(@NotNull Iterable<? extends T> iterable, @NotNull A a, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        b41.i(iterable, "<this>");
        b41.i(a, "buffer");
        b41.i(charSequence, "separator");
        b41.i(charSequence2, Constants.Name.PREFIX);
        b41.i(charSequence3, "postfix");
        b41.i(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (T t : iterable) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            C8597h.a(a, t, function1);
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    public static /* synthetic */ Appendable X(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        return W(iterable, appendable, (i2 & 2) != 0 ? AVFSCacheConstants.COMMA_SEP : charSequence, (i2 & 4) != 0 ? "" : charSequence2, (i2 & 8) == 0 ? charSequence3 : "", (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? "..." : charSequence4, (i2 & 64) != 0 ? null : function1);
    }

    @NotNull
    public static <T> String Y(@NotNull Iterable<? extends T> iterable, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        b41.i(iterable, "<this>");
        b41.i(charSequence, "separator");
        b41.i(charSequence2, Constants.Name.PREFIX);
        b41.i(charSequence3, "postfix");
        b41.i(charSequence4, "truncated");
        String sb = ((StringBuilder) W(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
        b41.h(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String Z(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        String Y;
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
        Y = Y(iterable, charSequence, str, str2, i3, charSequence5, function1);
        return Y;
    }

    public static <T> T a0(@NotNull Iterable<? extends T> iterable) {
        b41.i(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) C8212k.b0((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                next = it.next();
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T b0(@NotNull List<? extends T> list) {
        int i;
        b41.i(list, "<this>");
        if (!list.isEmpty()) {
            i = C8214m.i(list);
            return list.get(i);
        }
        throw new NoSuchElementException("List is empty.");
    }

    @Nullable
    public static <T> T c0(@NotNull Iterable<? extends T> iterable) {
        b41.i(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(list.size() - 1);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                next = it.next();
            }
            return next;
        }
        return null;
    }

    @Nullable
    public static <T> T d0(@NotNull List<? extends T> list) {
        b41.i(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    @NotNull
    public static <T, R> List<R> e0(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> function1) {
        int q;
        b41.i(iterable, "<this>");
        b41.i(function1, "transform");
        q = C8215n.q(iterable, 10);
        ArrayList arrayList = new ArrayList(q);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(function1.invoke((T) it.next()));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static <T extends Comparable<? super T>> T f0(@NotNull Iterable<? extends T> iterable) {
        b41.i(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (next.compareTo(next2) < 0) {
                    next = next2;
                }
            }
            return next;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static <T> T g0(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        b41.i(iterable, "<this>");
        b41.i(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            Object obj = (T) it.next();
            while (it.hasNext()) {
                T next = it.next();
                if (comparator.compare(obj, next) < 0) {
                    obj = next;
                }
            }
            return (T) obj;
        }
        return null;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static <T extends Comparable<? super T>> T h0(@NotNull Iterable<? extends T> iterable) {
        b41.i(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (next.compareTo(next2) > 0) {
                    next = next2;
                }
            }
            return next;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static <T> T i0(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        b41.i(iterable, "<this>");
        b41.i(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            Object obj = (T) it.next();
            while (it.hasNext()) {
                T next = it.next();
                if (comparator.compare(obj, next) > 0) {
                    obj = next;
                }
            }
            return (T) obj;
        }
        return null;
    }

    @NotNull
    public static <T> List<T> j0(@NotNull Iterable<? extends T> iterable, T t) {
        int q;
        b41.i(iterable, "<this>");
        q = C8215n.q(iterable, 10);
        ArrayList arrayList = new ArrayList(q);
        boolean z = false;
        for (T t2 : iterable) {
            boolean z2 = true;
            if (!z && b41.d(t2, t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    @NotNull
    public static <T> List<T> k0(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> iterable2) {
        List<T> m0;
        b41.i(iterable, "<this>");
        b41.i(iterable2, "elements");
        if (iterable instanceof Collection) {
            m0 = m0((Collection) iterable, iterable2);
            return m0;
        }
        ArrayList arrayList = new ArrayList();
        C8220r.v(arrayList, iterable);
        C8220r.v(arrayList, iterable2);
        return arrayList;
    }

    @NotNull
    public static <T> List<T> l0(@NotNull Iterable<? extends T> iterable, T t) {
        List<T> n0;
        b41.i(iterable, "<this>");
        if (iterable instanceof Collection) {
            n0 = n0((Collection) iterable, t);
            return n0;
        }
        ArrayList arrayList = new ArrayList();
        C8220r.v(arrayList, iterable);
        arrayList.add(t);
        return arrayList;
    }

    @NotNull
    public static <T> List<T> m0(@NotNull Collection<? extends T> collection, @NotNull Iterable<? extends T> iterable) {
        b41.i(collection, "<this>");
        b41.i(iterable, "elements");
        if (iterable instanceof Collection) {
            Collection collection2 = (Collection) iterable;
            ArrayList arrayList = new ArrayList(collection.size() + collection2.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        C8220r.v(arrayList2, iterable);
        return arrayList2;
    }

    @NotNull
    public static <T> List<T> n0(@NotNull Collection<? extends T> collection, T t) {
        b41.i(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t);
        return arrayList;
    }

    @NotNull
    public static <T> List<T> o0(@NotNull Iterable<? extends T> iterable) {
        List<T> A0;
        b41.i(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            A0 = A0(iterable);
            return A0;
        }
        List<T> B0 = B0(iterable);
        C8222t.G(B0);
        return B0;
    }

    public static <T> T p0(@NotNull Iterable<? extends T> iterable) {
        b41.i(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) C8212k.q0((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (it.hasNext()) {
                throw new IllegalArgumentException("Collection has more than one element.");
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T q0(@NotNull List<? extends T> list) {
        b41.i(list, "<this>");
        int size = list.size();
        if (size != 0) {
            if (size == 1) {
                return list.get(0);
            }
            throw new IllegalArgumentException("List has more than one element.");
        }
        throw new NoSuchElementException("List is empty.");
    }

    @Nullable
    public static <T> T r0(@NotNull Iterable<? extends T> iterable) {
        b41.i(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.size() == 1) {
                return (T) list.get(0);
            }
            return null;
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (it.hasNext()) {
                return null;
            }
            return next;
        }
        return null;
    }

    @Nullable
    public static <T> T s0(@NotNull List<? extends T> list) {
        b41.i(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @NotNull
    public static <T extends Comparable<? super T>> List<T> t0(@NotNull Iterable<? extends T> iterable) {
        List<T> d;
        List<T> A0;
        b41.i(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                A0 = A0(iterable);
                return A0;
            }
            Object[] array = collection.toArray(new Comparable[0]);
            b41.g(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            b41.g(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.CollectionsKt___CollectionsKt.sorted>");
            Comparable[] comparableArr = (Comparable[]) array;
            C8207h.l(comparableArr);
            d = C8207h.d(comparableArr);
            return d;
        }
        List<T> B0 = B0(iterable);
        C8219q.t(B0);
        return B0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <T> List<T> u0(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        List<T> d;
        List<T> A0;
        b41.i(iterable, "<this>");
        b41.i(comparator, "comparator");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                A0 = A0(iterable);
                return A0;
            }
            Object[] array = collection.toArray(new Object[0]);
            b41.g(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            b41.g(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.CollectionsKt___CollectionsKt.sortedWith>");
            C8207h.m(array, comparator);
            d = C8207h.d(array);
            return d;
        }
        List<T> B0 = B0(iterable);
        C8219q.u(B0, comparator);
        return B0;
    }

    @NotNull
    public static <T> List<T> v0(@NotNull Iterable<? extends T> iterable, int i) {
        List<T> n;
        List<T> e;
        List<T> A0;
        List<T> g;
        b41.i(iterable, "<this>");
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        } else if (i == 0) {
            g = C8214m.g();
            return g;
        } else {
            if (iterable instanceof Collection) {
                if (i >= ((Collection) iterable).size()) {
                    A0 = A0(iterable);
                    return A0;
                } else if (i == 1) {
                    e = C8213l.e(C8212k.O(iterable));
                    return e;
                }
            }
            ArrayList arrayList = new ArrayList(i);
            for (T t : iterable) {
                arrayList.add(t);
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            n = C8214m.n(arrayList);
            return n;
        }
    }

    @NotNull
    public static <T> List<T> w0(@NotNull List<? extends T> list, int i) {
        List<T> e;
        List<T> A0;
        List<T> g;
        b41.i(list, "<this>");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        } else if (i == 0) {
            g = C8214m.g();
            return g;
        } else {
            int size = list.size();
            if (i >= size) {
                A0 = A0(list);
                return A0;
            } else if (i == 1) {
                e = C8213l.e(C8212k.b0(list));
                return e;
            } else {
                ArrayList arrayList = new ArrayList(i);
                if (list instanceof RandomAccess) {
                    for (int i2 = size - i; i2 < size; i2++) {
                        arrayList.add(list.get(i2));
                    }
                } else {
                    ListIterator<? extends T> listIterator = list.listIterator(size - i);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        }
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C x0(@NotNull Iterable<? extends T> iterable, @NotNull C c) {
        b41.i(iterable, "<this>");
        b41.i(c, "destination");
        for (T t : iterable) {
            c.add(t);
        }
        return c;
    }

    @NotNull
    public static final <T> HashSet<T> y0(@NotNull Iterable<? extends T> iterable) {
        int q;
        int e;
        b41.i(iterable, "<this>");
        q = C8215n.q(iterable, 12);
        e = C8225w.e(q);
        return (HashSet) x0(iterable, new HashSet(e));
    }

    @NotNull
    public static int[] z0(@NotNull Collection<Integer> collection) {
        b41.i(collection, "<this>");
        int[] iArr = new int[collection.size()];
        int i = 0;
        for (Integer num : collection) {
            iArr[i] = num.intValue();
            i++;
        }
        return iArr;
    }
}
