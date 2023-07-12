package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.C4834e;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;

/* compiled from: Taobao */
@Beta
@GwtIncompatible
/* loaded from: classes10.dex */
public class TreeRangeSet<C extends Comparable<?>> extends AbstractC5173f<C> implements Serializable {
    @MonotonicNonNullDecl
    private transient Set<Range<C>> asDescendingSetOfRanges;
    @MonotonicNonNullDecl
    private transient Set<Range<C>> asRanges;
    @MonotonicNonNullDecl
    private transient RangeSet<C> complement;
    @VisibleForTesting
    final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private final class Complement extends TreeRangeSet<C> {
        Complement() {
            super(new C5142c(TreeRangeSet.this.rangesByLowerBound));
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractC5173f, com.google.common.collect.RangeSet
        public void add(Range<C> range) {
            TreeRangeSet.this.remove(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.RangeSet
        public RangeSet<C> complement() {
            return TreeRangeSet.this;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractC5173f, com.google.common.collect.RangeSet
        public boolean contains(C c) {
            return !TreeRangeSet.this.contains(c);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractC5173f, com.google.common.collect.RangeSet
        public void remove(Range<C> range) {
            TreeRangeSet.this.add(range);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private final class SubRangeSet extends TreeRangeSet<C> {
        private final Range<C> restriction;

        SubRangeSet(Range<C> range) {
            super(new C5148e(Range.all(), range, TreeRangeSet.this.rangesByLowerBound));
            this.restriction = range;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractC5173f, com.google.common.collect.RangeSet
        public void add(Range<C> range) {
            du1.l(this.restriction.encloses(range), "Cannot add range %s to subRangeSet(%s)", range, this.restriction);
            super.add(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractC5173f, com.google.common.collect.RangeSet
        public void clear() {
            TreeRangeSet.this.remove(this.restriction);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractC5173f, com.google.common.collect.RangeSet
        public boolean contains(C c) {
            return this.restriction.contains(c) && TreeRangeSet.this.contains(c);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractC5173f, com.google.common.collect.RangeSet
        public boolean encloses(Range<C> range) {
            Range rangeEnclosing;
            return (this.restriction.isEmpty() || !this.restriction.encloses(range) || (rangeEnclosing = TreeRangeSet.this.rangeEnclosing(range)) == null || rangeEnclosing.intersection(this.restriction).isEmpty()) ? false : true;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractC5173f, com.google.common.collect.RangeSet
        @NullableDecl
        public Range<C> rangeContaining(C c) {
            Range<C> rangeContaining;
            if (this.restriction.contains(c) && (rangeContaining = TreeRangeSet.this.rangeContaining(c)) != null) {
                return rangeContaining.intersection(this.restriction);
            }
            return null;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractC5173f, com.google.common.collect.RangeSet
        public void remove(Range<C> range) {
            if (range.isConnected(this.restriction)) {
                TreeRangeSet.this.remove(range.intersection(this.restriction));
            }
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.RangeSet
        public RangeSet<C> subRangeSet(Range<C> range) {
            if (range.encloses(this.restriction)) {
                return this;
            }
            if (range.isConnected(this.restriction)) {
                return new SubRangeSet(this.restriction.intersection(range));
            }
            return ImmutableRangeSet.of();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.TreeRangeSet$b */
    /* loaded from: classes10.dex */
    final class C5141b extends AbstractC5200o<Range<C>> implements Set<Range<C>> {
        final Collection<Range<C>> a;

        C5141b(TreeRangeSet treeRangeSet, Collection<Range<C>> collection) {
            this.a = collection;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@NullableDecl Object obj) {
            return Sets.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.b(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractC5200o, com.google.common.collect.AbstractC5205t
        public Collection<Range<C>> delegate() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.TreeRangeSet$c */
    /* loaded from: classes10.dex */
    public static final class C5142c<C extends Comparable<?>> extends AbstractC5169e<Cut<C>, Range<C>> {
        private final NavigableMap<Cut<C>, Range<C>> a;
        private final NavigableMap<Cut<C>, Range<C>> b;
        private final Range<Cut<C>> c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.TreeRangeSet$c$a */
        /* loaded from: classes10.dex */
        public class C5143a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            Cut<C> c;
            final /* synthetic */ Cut d;
            final /* synthetic */ PeekingIterator e;

            C5143a(Cut cut, PeekingIterator peekingIterator) {
                this.d = cut;
                this.e = peekingIterator;
                this.c = cut;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                Range create;
                if (!C5142c.this.c.upperBound.isLessThan(this.c) && this.c != Cut.aboveAll()) {
                    if (this.e.hasNext()) {
                        Range range = (Range) this.e.next();
                        create = Range.create(this.c, range.lowerBound);
                        this.c = range.upperBound;
                    } else {
                        create = Range.create(this.c, Cut.aboveAll());
                        this.c = Cut.aboveAll();
                    }
                    return Maps.j(create.lowerBound, create);
                }
                return (Map.Entry) b();
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.TreeRangeSet$c$b */
        /* loaded from: classes10.dex */
        class C5144b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            Cut<C> c;
            final /* synthetic */ Cut d;
            final /* synthetic */ PeekingIterator e;

            C5144b(Cut cut, PeekingIterator peekingIterator) {
                this.d = cut;
                this.e = peekingIterator;
                this.c = cut;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (this.c == Cut.belowAll()) {
                    return (Map.Entry) b();
                }
                if (!this.e.hasNext()) {
                    if (C5142c.this.c.lowerBound.isLessThan(Cut.belowAll())) {
                        Range create = Range.create(Cut.belowAll(), this.c);
                        this.c = Cut.belowAll();
                        return Maps.j(Cut.belowAll(), create);
                    }
                } else {
                    Range range = (Range) this.e.next();
                    Range create2 = Range.create(range.upperBound, this.c);
                    this.c = range.lowerBound;
                    if (C5142c.this.c.lowerBound.isLessThan(create2.lowerBound)) {
                        return Maps.j(create2.lowerBound, create2);
                    }
                }
                return (Map.Entry) b();
            }
        }

        C5142c(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this(navigableMap, Range.all());
        }

        private NavigableMap<Cut<C>, Range<C>> g(Range<Cut<C>> range) {
            if (!this.c.isConnected(range)) {
                return ImmutableSortedMap.of();
            }
            return new C5142c(this.a, range.intersection(this.c));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.AbstractC5060k
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            Collection<Range<C>> values;
            Cut cut;
            if (this.c.hasLowerBound()) {
                values = this.b.tailMap(this.c.lowerEndpoint(), this.c.lowerBoundType() == BoundType.CLOSED).values();
            } else {
                values = this.b.values();
            }
            PeekingIterator p = Iterators.p(values.iterator());
            if (this.c.contains(Cut.belowAll()) && (!p.hasNext() || ((Range) p.peek()).lowerBound != Cut.belowAll())) {
                cut = Cut.belowAll();
            } else if (p.hasNext()) {
                cut = ((Range) p.next()).upperBound;
            } else {
                return Iterators.h();
            }
            return new C5143a(cut, p);
        }

        @Override // com.google.common.collect.AbstractC5169e
        Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            Cut<C> aboveAll;
            Cut<C> higherKey;
            if (this.c.hasUpperBound()) {
                aboveAll = this.c.upperEndpoint();
            } else {
                aboveAll = Cut.aboveAll();
            }
            PeekingIterator p = Iterators.p(this.b.headMap(aboveAll, this.c.hasUpperBound() && this.c.upperBoundType() == BoundType.CLOSED).descendingMap().values().iterator());
            if (p.hasNext()) {
                if (((Range) p.peek()).upperBound == Cut.aboveAll()) {
                    higherKey = ((Range) p.next()).lowerBound;
                } else {
                    higherKey = this.a.higherKey(((Range) p.peek()).upperBound);
                }
            } else if (this.c.contains(Cut.belowAll()) && !this.a.containsKey(Cut.belowAll())) {
                higherKey = this.a.higherKey(Cut.belowAll());
            } else {
                return Iterators.h();
            }
            return new C5144b((Cut) C4834e.a(higherKey, Cut.aboveAll()), p);
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @NullableDecl
        /* renamed from: d */
        public Range<C> get(Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    Map.Entry<Cut<C>, Range<C>> firstEntry = tailMap(cut, true).firstEntry();
                    if (firstEntry != null && firstEntry.getKey().equals(cut)) {
                        return firstEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* renamed from: e */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z) {
            return g(Range.upTo(cut, BoundType.forBoolean(z)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: f */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z, Cut<C> cut2, boolean z2) {
            return g(Range.range(cut, BoundType.forBoolean(z), cut2, BoundType.forBoolean(z2)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: h */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z) {
            return g(Range.downTo(cut, BoundType.forBoolean(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.u(a());
        }

        private C5142c(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.a = navigableMap;
            this.b = new C5145d(navigableMap);
            this.c = range;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.TreeRangeSet$e */
    /* loaded from: classes10.dex */
    public static final class C5148e<C extends Comparable<?>> extends AbstractC5169e<Cut<C>, Range<C>> {
        private final Range<Cut<C>> a;
        private final Range<C> b;
        private final NavigableMap<Cut<C>, Range<C>> c;
        private final NavigableMap<Cut<C>, Range<C>> d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.TreeRangeSet$e$a */
        /* loaded from: classes10.dex */
        public class C5149a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            final /* synthetic */ Iterator c;
            final /* synthetic */ Cut d;

            C5149a(Iterator it, Cut cut) {
                this.c = it;
                this.d = cut;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.c.next();
                if (!this.d.isLessThan(range.lowerBound)) {
                    Range intersection = range.intersection(C5148e.this.b);
                    return Maps.j(intersection.lowerBound, intersection);
                }
                return (Map.Entry) b();
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.TreeRangeSet$e$b */
        /* loaded from: classes10.dex */
        class C5150b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            final /* synthetic */ Iterator c;

            C5150b(Iterator it) {
                this.c = it;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.c.next();
                if (C5148e.this.b.lowerBound.compareTo((Cut) range.upperBound) < 0) {
                    Range intersection = range.intersection(C5148e.this.b);
                    if (C5148e.this.a.contains(intersection.lowerBound)) {
                        return Maps.j(intersection.lowerBound, intersection);
                    }
                    return (Map.Entry) b();
                }
                return (Map.Entry) b();
            }
        }

        private NavigableMap<Cut<C>, Range<C>> h(Range<Cut<C>> range) {
            if (!range.isConnected(this.a)) {
                return ImmutableSortedMap.of();
            }
            return new C5148e(this.a.intersection(range), this.b, this.c);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.AbstractC5060k
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            Iterator<Range<C>> it;
            if (this.b.isEmpty()) {
                return Iterators.h();
            }
            if (this.a.upperBound.isLessThan(this.b.lowerBound)) {
                return Iterators.h();
            }
            if (this.a.lowerBound.isLessThan(this.b.lowerBound)) {
                it = this.d.tailMap(this.b.lowerBound, false).values().iterator();
            } else {
                it = this.c.tailMap(this.a.lowerBound.endpoint(), this.a.lowerBoundType() == BoundType.CLOSED).values().iterator();
            }
            return new C5149a(it, (Cut) Ordering.natural().min(this.a.upperBound, Cut.belowValue(this.b.upperBound)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.AbstractC5169e
        Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            if (this.b.isEmpty()) {
                return Iterators.h();
            }
            Cut cut = (Cut) Ordering.natural().min(this.a.upperBound, Cut.belowValue(this.b.upperBound));
            return new C5150b(this.c.headMap(cut.endpoint(), cut.typeAsUpperBound() == BoundType.CLOSED).descendingMap().values().iterator());
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @NullableDecl
        /* renamed from: e */
        public Range<C> get(@NullableDecl Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    if (this.a.contains(cut) && cut.compareTo(this.b.lowerBound) >= 0 && cut.compareTo(this.b.upperBound) < 0) {
                        if (cut.equals(this.b.lowerBound)) {
                            Range range = (Range) Maps.M(this.c.floorEntry(cut));
                            if (range != null && range.upperBound.compareTo((Cut) this.b.lowerBound) > 0) {
                                return range.intersection(this.b);
                            }
                        } else {
                            Range range2 = (Range) this.c.get(cut);
                            if (range2 != null) {
                                return range2.intersection(this.b);
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* renamed from: f */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z) {
            return h(Range.upTo(cut, BoundType.forBoolean(z)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: g */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z, Cut<C> cut2, boolean z2) {
            return h(Range.range(cut, BoundType.forBoolean(z), cut2, BoundType.forBoolean(z2)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: i */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z) {
            return h(Range.downTo(cut, BoundType.forBoolean(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.u(a());
        }

        private C5148e(Range<Cut<C>> range, Range<C> range2, NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this.a = (Range) du1.p(range);
            this.b = (Range) du1.p(range2);
            this.c = (NavigableMap) du1.p(navigableMap);
            this.d = new C5145d(navigableMap);
        }
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create() {
        return new TreeRangeSet<>(new TreeMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NullableDecl
    public Range<C> rangeEnclosing(Range<C> range) {
        du1.p(range);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        if (floorEntry == null || !floorEntry.getValue().encloses(range)) {
            return null;
        }
        return floorEntry.getValue();
    }

    private void replaceRangeWithSameLowerBound(Range<C> range) {
        if (range.isEmpty()) {
            this.rangesByLowerBound.remove(range.lowerBound);
        } else {
            this.rangesByLowerBound.put(range.lowerBound, range);
        }
    }

    @Override // com.google.common.collect.AbstractC5173f, com.google.common.collect.RangeSet
    public void add(Range<C> range) {
        du1.p(range);
        if (range.isEmpty()) {
            return;
        }
        Cut<C> cut = range.lowerBound;
        Cut<C> cut2 = range.upperBound;
        Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(cut);
        if (lowerEntry != null) {
            Range<C> value = lowerEntry.getValue();
            if (value.upperBound.compareTo(cut) >= 0) {
                if (value.upperBound.compareTo(cut2) >= 0) {
                    cut2 = value.upperBound;
                }
                cut = value.lowerBound;
            }
        }
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(cut2);
        if (floorEntry != null) {
            Range<C> value2 = floorEntry.getValue();
            if (value2.upperBound.compareTo(cut2) >= 0) {
                cut2 = value2.upperBound;
            }
        }
        this.rangesByLowerBound.subMap(cut, cut2).clear();
        replaceRangeWithSameLowerBound(Range.create(cut, cut2));
    }

    @Override // com.google.common.collect.AbstractC5173f, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void addAll(RangeSet rangeSet) {
        super.addAll(rangeSet);
    }

    @Override // com.google.common.collect.RangeSet
    public Set<Range<C>> asDescendingSetOfRanges() {
        Set<Range<C>> set = this.asDescendingSetOfRanges;
        if (set == null) {
            C5141b c5141b = new C5141b(this, this.rangesByLowerBound.descendingMap().values());
            this.asDescendingSetOfRanges = c5141b;
            return c5141b;
        }
        return set;
    }

    @Override // com.google.common.collect.RangeSet
    public Set<Range<C>> asRanges() {
        Set<Range<C>> set = this.asRanges;
        if (set == null) {
            C5141b c5141b = new C5141b(this, this.rangesByLowerBound.values());
            this.asRanges = c5141b;
            return c5141b;
        }
        return set;
    }

    @Override // com.google.common.collect.AbstractC5173f, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.RangeSet
    public RangeSet<C> complement() {
        RangeSet<C> rangeSet = this.complement;
        if (rangeSet == null) {
            Complement complement = new Complement();
            this.complement = complement;
            return complement;
        }
        return rangeSet;
    }

    @Override // com.google.common.collect.AbstractC5173f, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    @Override // com.google.common.collect.AbstractC5173f, com.google.common.collect.RangeSet
    public boolean encloses(Range<C> range) {
        du1.p(range);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        return floorEntry != null && floorEntry.getValue().encloses(range);
    }

    @Override // com.google.common.collect.AbstractC5173f, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(RangeSet rangeSet) {
        return super.enclosesAll(rangeSet);
    }

    @Override // com.google.common.collect.AbstractC5173f, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractC5173f, com.google.common.collect.RangeSet
    public boolean intersects(Range<C> range) {
        du1.p(range);
        Map.Entry<Cut<C>, Range<C>> ceilingEntry = this.rangesByLowerBound.ceilingEntry(range.lowerBound);
        if (ceilingEntry == null || !ceilingEntry.getValue().isConnected(range) || ceilingEntry.getValue().intersection(range).isEmpty()) {
            Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
            return (lowerEntry == null || !lowerEntry.getValue().isConnected(range) || lowerEntry.getValue().intersection(range).isEmpty()) ? false : true;
        }
        return true;
    }

    @Override // com.google.common.collect.AbstractC5173f, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractC5173f, com.google.common.collect.RangeSet
    @NullableDecl
    public Range<C> rangeContaining(C c) {
        du1.p(c);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(Cut.belowValue(c));
        if (floorEntry == null || !floorEntry.getValue().contains(c)) {
            return null;
        }
        return floorEntry.getValue();
    }

    @Override // com.google.common.collect.AbstractC5173f, com.google.common.collect.RangeSet
    public void remove(Range<C> range) {
        du1.p(range);
        if (range.isEmpty()) {
            return;
        }
        Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        if (lowerEntry != null) {
            Range<C> value = lowerEntry.getValue();
            if (value.upperBound.compareTo(range.lowerBound) >= 0) {
                if (range.hasUpperBound() && value.upperBound.compareTo(range.upperBound) >= 0) {
                    replaceRangeWithSameLowerBound(Range.create(range.upperBound, value.upperBound));
                }
                replaceRangeWithSameLowerBound(Range.create(value.lowerBound, range.lowerBound));
            }
        }
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.upperBound);
        if (floorEntry != null) {
            Range<C> value2 = floorEntry.getValue();
            if (range.hasUpperBound() && value2.upperBound.compareTo(range.upperBound) >= 0) {
                replaceRangeWithSameLowerBound(Range.create(range.upperBound, value2.upperBound));
            }
        }
        this.rangesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
    }

    @Override // com.google.common.collect.AbstractC5173f, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void removeAll(RangeSet rangeSet) {
        super.removeAll(rangeSet);
    }

    @Override // com.google.common.collect.RangeSet
    public Range<C> span() {
        Map.Entry<Cut<C>, Range<C>> firstEntry = this.rangesByLowerBound.firstEntry();
        Map.Entry<Cut<C>, Range<C>> lastEntry = this.rangesByLowerBound.lastEntry();
        if (firstEntry != null) {
            return Range.create(firstEntry.getValue().lowerBound, lastEntry.getValue().upperBound);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.RangeSet
    public RangeSet<C> subRangeSet(Range<C> range) {
        return range.equals(Range.all()) ? this : new SubRangeSet(range);
    }

    private TreeRangeSet(NavigableMap<Cut<C>, Range<C>> navigableMap) {
        this.rangesByLowerBound = navigableMap;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(RangeSet<C> rangeSet) {
        TreeRangeSet<C> create = create();
        create.addAll(rangeSet);
        return create;
    }

    @Override // com.google.common.collect.AbstractC5173f, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void addAll(Iterable iterable) {
        super.addAll(iterable);
    }

    @Override // com.google.common.collect.AbstractC5173f, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // com.google.common.collect.AbstractC5173f, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void removeAll(Iterable iterable) {
        super.removeAll(iterable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    @VisibleForTesting
    /* renamed from: com.google.common.collect.TreeRangeSet$d */
    /* loaded from: classes10.dex */
    public static final class C5145d<C extends Comparable<?>> extends AbstractC5169e<Cut<C>, Range<C>> {
        private final NavigableMap<Cut<C>, Range<C>> a;
        private final Range<Cut<C>> b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.TreeRangeSet$d$a */
        /* loaded from: classes10.dex */
        public class C5146a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            final /* synthetic */ Iterator c;

            C5146a(Iterator it) {
                this.c = it;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.c.next();
                if (C5145d.this.b.upperBound.isLessThan(range.upperBound)) {
                    return (Map.Entry) b();
                }
                return Maps.j(range.upperBound, range);
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.TreeRangeSet$d$b */
        /* loaded from: classes10.dex */
        class C5147b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            final /* synthetic */ PeekingIterator c;

            C5147b(PeekingIterator peekingIterator) {
                this.c = peekingIterator;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.c.next();
                if (C5145d.this.b.lowerBound.isLessThan(range.upperBound)) {
                    return Maps.j(range.upperBound, range);
                }
                return (Map.Entry) b();
            }
        }

        C5145d(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this.a = navigableMap;
            this.b = Range.all();
        }

        private NavigableMap<Cut<C>, Range<C>> g(Range<Cut<C>> range) {
            if (range.isConnected(this.b)) {
                return new C5145d(this.a, range.intersection(this.b));
            }
            return ImmutableSortedMap.of();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.AbstractC5060k
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            Iterator<Range<C>> it;
            if (!this.b.hasLowerBound()) {
                it = this.a.values().iterator();
            } else {
                Map.Entry<Cut<C>, Range<C>> lowerEntry = this.a.lowerEntry(this.b.lowerEndpoint());
                if (lowerEntry == null) {
                    it = this.a.values().iterator();
                } else if (this.b.lowerBound.isLessThan(lowerEntry.getValue().upperBound)) {
                    it = this.a.tailMap(lowerEntry.getKey(), true).values().iterator();
                } else {
                    it = this.a.tailMap(this.b.lowerEndpoint(), true).values().iterator();
                }
            }
            return new C5146a(it);
        }

        @Override // com.google.common.collect.AbstractC5169e
        Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            Collection<Range<C>> values;
            if (this.b.hasUpperBound()) {
                values = this.a.headMap(this.b.upperEndpoint(), false).descendingMap().values();
            } else {
                values = this.a.descendingMap().values();
            }
            PeekingIterator p = Iterators.p(values.iterator());
            if (p.hasNext() && this.b.upperBound.isLessThan(((Range) p.peek()).upperBound)) {
                p.next();
            }
            return new C5147b(p);
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: d */
        public Range<C> get(@NullableDecl Object obj) {
            Map.Entry<Cut<C>, Range<C>> lowerEntry;
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    if (this.b.contains(cut) && (lowerEntry = this.a.lowerEntry(cut)) != null && lowerEntry.getValue().upperBound.equals(cut)) {
                        return lowerEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* renamed from: e */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z) {
            return g(Range.upTo(cut, BoundType.forBoolean(z)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: f */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z, Cut<C> cut2, boolean z2) {
            return g(Range.range(cut, BoundType.forBoolean(z), cut2, BoundType.forBoolean(z2)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: h */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z) {
            return g(Range.downTo(cut, BoundType.forBoolean(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            if (this.b.equals(Range.all())) {
                return this.a.isEmpty();
            }
            return !a().hasNext();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            if (this.b.equals(Range.all())) {
                return this.a.size();
            }
            return Iterators.u(a());
        }

        private C5145d(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.a = navigableMap;
            this.b = range;
        }
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(Iterable<Range<C>> iterable) {
        TreeRangeSet<C> create = create();
        create.addAll(iterable);
        return create;
    }
}
