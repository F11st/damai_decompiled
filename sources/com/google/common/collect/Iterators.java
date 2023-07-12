package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.au2;
import tb.du1;
import tb.jn1;
import tb.yt2;

/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
public final class Iterators {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum EmptyModifiableIterator implements Iterator<Object> {
        INSTANCE;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            C5191k.e(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Iterators$a */
    /* loaded from: classes10.dex */
    public static class C4997a<T> extends yt2<T> {
        final /* synthetic */ Iterator a;

        C4997a(Iterator it) {
            this.a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return (T) this.a.next();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Iterators$b */
    /* loaded from: classes10.dex */
    static class C4998b<T> extends AbstractIterator<T> {
        final /* synthetic */ Iterator c;
        final /* synthetic */ Predicate d;

        C4998b(Iterator it, Predicate predicate) {
            this.c = it;
            this.d = predicate;
        }

        @Override // com.google.common.collect.AbstractIterator
        protected T a() {
            while (this.c.hasNext()) {
                T t = (T) this.c.next();
                if (this.d.apply(t)) {
                    return t;
                }
            }
            return b();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, F] */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Iterators$c */
    /* loaded from: classes10.dex */
    static class C4999c<F, T> extends AbstractC5190j0<F, T> {
        final /* synthetic */ Function b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C4999c(Iterator it, Function function) {
            super(it);
            this.b = function;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractC5190j0
        public T a(F f) {
            return (T) this.b.apply(f);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Iterators$d */
    /* loaded from: classes10.dex */
    static class C5000d<T> extends yt2<T> {
        boolean a;
        final /* synthetic */ Object b;

        C5000d(Object obj) {
            this.b = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.a;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.a) {
                this.a = true;
                return (T) this.b;
            }
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Iterators$e */
    /* loaded from: classes10.dex */
    public static final class C5001e<T> extends AbstractC5151a<T> {
        static final au2<Object> e = new C5001e(new Object[0], 0, 0, 0);
        private final T[] c;
        private final int d;

        C5001e(T[] tArr, int i, int i2, int i3) {
            super(i2, i3);
            this.c = tArr;
            this.d = i;
        }

        @Override // com.google.common.collect.AbstractC5151a
        protected T a(int i) {
            return this.c[this.d + i];
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Iterators$f */
    /* loaded from: classes10.dex */
    private static class C5002f<T> implements Iterator<T> {
        @NullableDecl
        private Iterator<? extends T> a;
        private Iterator<? extends T> b = Iterators.h();
        private Iterator<? extends Iterator<? extends T>> c;
        @NullableDecl
        private Deque<Iterator<? extends Iterator<? extends T>>> d;

        C5002f(Iterator<? extends Iterator<? extends T>> it) {
            this.c = (Iterator) du1.p(it);
        }

        @NullableDecl
        private Iterator<? extends Iterator<? extends T>> a() {
            while (true) {
                Iterator<? extends Iterator<? extends T>> it = this.c;
                if (it != null && it.hasNext()) {
                    return this.c;
                }
                Deque<Iterator<? extends Iterator<? extends T>>> deque = this.d;
                if (deque == null || deque.isEmpty()) {
                    return null;
                }
                this.c = this.d.removeFirst();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (!((Iterator) du1.p(this.b)).hasNext()) {
                Iterator<? extends Iterator<? extends T>> a = a();
                this.c = a;
                if (a == null) {
                    return false;
                }
                Iterator<? extends T> next = a.next();
                this.b = next;
                if (next instanceof C5002f) {
                    C5002f c5002f = (C5002f) next;
                    this.b = c5002f.b;
                    if (this.d == null) {
                        this.d = new ArrayDeque();
                    }
                    this.d.addFirst(this.c);
                    if (c5002f.d != null) {
                        while (!c5002f.d.isEmpty()) {
                            this.d.addFirst(c5002f.d.removeLast());
                        }
                    }
                    this.c = c5002f.c;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                Iterator<? extends T> it = this.b;
                this.a = it;
                return it.next();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            C5191k.e(this.a != null);
            this.a.remove();
            this.a = null;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Iterators$g */
    /* loaded from: classes10.dex */
    private static class C5003g<T> extends yt2<T> {
        final Queue<PeekingIterator<T>> a;

        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.Iterators$g$a */
        /* loaded from: classes10.dex */
        class C5004a implements Comparator<PeekingIterator<T>> {
            final /* synthetic */ Comparator a;

            C5004a(C5003g c5003g, Comparator comparator) {
                this.a = comparator;
            }

            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(PeekingIterator<T> peekingIterator, PeekingIterator<T> peekingIterator2) {
                return this.a.compare(peekingIterator.peek(), peekingIterator2.peek());
            }
        }

        public C5003g(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
            this.a = new PriorityQueue(2, new C5004a(this, comparator));
            for (Iterator<? extends T> it : iterable) {
                if (it.hasNext()) {
                    this.a.add(Iterators.p(it));
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.a.isEmpty();
        }

        @Override // java.util.Iterator
        public T next() {
            PeekingIterator<T> remove = this.a.remove();
            T next = remove.next();
            if (remove.hasNext()) {
                this.a.add(remove);
            }
            return next;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Iterators$h */
    /* loaded from: classes10.dex */
    public static class C5005h<E> implements PeekingIterator<E> {
        private final Iterator<? extends E> a;
        private boolean b;
        @NullableDecl
        private E c;

        public C5005h(Iterator<? extends E> it) {
            this.a = (Iterator) du1.p(it);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b || this.a.hasNext();
        }

        @Override // com.google.common.collect.PeekingIterator, java.util.Iterator
        public E next() {
            if (!this.b) {
                return this.a.next();
            }
            E e = this.c;
            this.b = false;
            this.c = null;
            return e;
        }

        @Override // com.google.common.collect.PeekingIterator
        public E peek() {
            if (!this.b) {
                this.c = this.a.next();
                this.b = true;
            }
            return this.c;
        }

        @Override // com.google.common.collect.PeekingIterator, java.util.Iterator
        public void remove() {
            du1.x(!this.b, "Can't remove after you've peeked at next");
            this.a.remove();
        }
    }

    @CanIgnoreReturnValue
    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        du1.p(collection);
        du1.p(it);
        boolean z = false;
        while (it.hasNext()) {
            z |= collection.add(it.next());
        }
        return z;
    }

    @CanIgnoreReturnValue
    public static int b(Iterator<?> it, int i) {
        du1.p(it);
        int i2 = 0;
        du1.e(i >= 0, "numberToAdvance must be nonnegative");
        while (i2 < i && it.hasNext()) {
            it.next();
            i2++;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> ListIterator<T> c(Iterator<T> it) {
        return (ListIterator) it;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Iterator<?> it) {
        du1.p(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static <T> Iterator<T> e(Iterator<? extends Iterator<? extends T>> it) {
        return new C5002f(it);
    }

    public static boolean f(Iterator<?> it, @NullableDecl Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0006  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean g(java.util.Iterator<?> r3, java.util.Iterator<?> r4) {
        /*
        L0:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L1d
            boolean r0 = r4.hasNext()
            r1 = 0
            if (r0 != 0) goto Le
            return r1
        Le:
            java.lang.Object r0 = r3.next()
            java.lang.Object r2 = r4.next()
            boolean r0 = tb.nm1.a(r0, r2)
            if (r0 != 0) goto L0
            return r1
        L1d:
            boolean r3 = r4.hasNext()
            r3 = r3 ^ 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Iterators.g(java.util.Iterator, java.util.Iterator):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> yt2<T> h() {
        return i();
    }

    static <T> au2<T> i() {
        return (au2<T>) C5001e.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Iterator<T> j() {
        return EmptyModifiableIterator.INSTANCE;
    }

    public static <T> yt2<T> k(Iterator<T> it, Predicate<? super T> predicate) {
        du1.p(it);
        du1.p(predicate);
        return new C4998b(it, predicate);
    }

    public static <T> T l(Iterator<T> it) {
        T next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    @NullableDecl
    public static <T> T m(Iterator<? extends T> it, @NullableDecl T t) {
        return it.hasNext() ? it.next() : t;
    }

    public static <T> T n(Iterator<T> it) {
        T next = it.next();
        if (it.hasNext()) {
            StringBuilder sb = new StringBuilder();
            sb.append("expected one element but was: <");
            sb.append(next);
            for (int i = 0; i < 4 && it.hasNext(); i++) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
                sb.append(it.next());
            }
            if (it.hasNext()) {
                sb.append(", ...");
            }
            sb.append('>');
            throw new IllegalArgumentException(sb.toString());
        }
        return next;
    }

    @Beta
    public static <T> yt2<T> o(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        du1.q(iterable, "iterators");
        du1.q(comparator, "comparator");
        return new C5003g(iterable, comparator);
    }

    public static <T> PeekingIterator<T> p(Iterator<? extends T> it) {
        if (it instanceof C5005h) {
            return (C5005h) it;
        }
        return new C5005h(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NullableDecl
    public static <T> T q(Iterator<T> it) {
        if (it.hasNext()) {
            T next = it.next();
            it.remove();
            return next;
        }
        return null;
    }

    @CanIgnoreReturnValue
    public static boolean r(Iterator<?> it, Collection<?> collection) {
        du1.p(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @CanIgnoreReturnValue
    public static boolean s(Iterator<?> it, Collection<?> collection) {
        du1.p(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static <T> yt2<T> t(@NullableDecl T t) {
        return new C5000d(t);
    }

    public static int u(Iterator<?> it) {
        long j = 0;
        while (it.hasNext()) {
            it.next();
            j++;
        }
        return Ints.j(j);
    }

    public static String v(Iterator<?> it) {
        StringBuilder sb = new StringBuilder();
        sb.append(jn1.ARRAY_START);
        boolean z = true;
        while (it.hasNext()) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            z = false;
            sb.append(it.next());
        }
        sb.append(jn1.ARRAY_END);
        return sb.toString();
    }

    public static <F, T> Iterator<T> w(Iterator<F> it, Function<? super F, ? extends T> function) {
        du1.p(function);
        return new C4999c(it, function);
    }

    public static <T> yt2<T> x(Iterator<? extends T> it) {
        du1.p(it);
        if (it instanceof yt2) {
            return (yt2) it;
        }
        return new C4997a(it);
    }
}
