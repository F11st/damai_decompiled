package kotlin.collections.builders;

import com.alipay.sdk.m.n.C4250a;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.ui.component.WXComponent;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.C8202e;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.bd1;
import tb.cd1;
import tb.dd1;
import tb.i31;
import tb.jn1;
import tb.k50;
import tb.k91;
import tb.n31;
import tb.ry1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, KMutableMap {
    @NotNull
    private static final C8190a Companion = new C8190a(null);
    @Deprecated
    private static final int INITIAL_CAPACITY = 8;
    @Deprecated
    private static final int INITIAL_MAX_PROBE_DISTANCE = 2;
    @Deprecated
    private static final int MAGIC = -1640531527;
    @Deprecated
    private static final int TOMBSTONE = -1;
    @Nullable
    private bd1<K, V> entriesView;
    @NotNull
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;
    @NotNull
    private K[] keysArray;
    @Nullable
    private cd1<K> keysView;
    private int length;
    private int maxProbeDistance;
    @NotNull
    private int[] presenceArray;
    private int size;
    @Nullable
    private V[] valuesArray;
    @Nullable
    private dd1<V> valuesView;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: kotlin.collections.builders.MapBuilder$a */
    /* loaded from: classes3.dex */
    public static final class C8190a {
        private C8190a() {
        }

        public /* synthetic */ C8190a(k50 k50Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int c(int i) {
            return Integer.highestOneBit(ry1.a(i, 1) * 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d(int i) {
            return Integer.numberOfLeadingZeros(i) + 1;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.collections.builders.MapBuilder$b */
    /* loaded from: classes3.dex */
    public static final class C8191b<K, V> extends C8193d<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8191b(@NotNull MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            b41.i(mapBuilder, "map");
        }

        @Override // java.util.Iterator
        @NotNull
        /* renamed from: g */
        public C8192c<K, V> next() {
            if (a() < ((MapBuilder) c()).length) {
                int a = a();
                e(a + 1);
                f(a);
                C8192c<K, V> c8192c = new C8192c<>(c(), b());
                d();
                return c8192c;
            }
            throw new NoSuchElementException();
        }

        public final void h(@NotNull StringBuilder sb) {
            b41.i(sb, "sb");
            if (a() < ((MapBuilder) c()).length) {
                int a = a();
                e(a + 1);
                f(a);
                Object obj = ((MapBuilder) c()).keysArray[b()];
                if (b41.d(obj, c())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj);
                }
                sb.append(C4250a.h);
                Object[] objArr = ((MapBuilder) c()).valuesArray;
                b41.f(objArr);
                Object obj2 = objArr[b()];
                if (b41.d(obj2, c())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj2);
                }
                d();
                return;
            }
            throw new NoSuchElementException();
        }

        public final int i() {
            if (a() < ((MapBuilder) c()).length) {
                int a = a();
                e(a + 1);
                f(a);
                Object obj = ((MapBuilder) c()).keysArray[b()];
                int hashCode = obj != null ? obj.hashCode() : 0;
                Object[] objArr = ((MapBuilder) c()).valuesArray;
                b41.f(objArr);
                Object obj2 = objArr[b()];
                int hashCode2 = hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
                d();
                return hashCode2;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.collections.builders.MapBuilder$c */
    /* loaded from: classes3.dex */
    public static final class C8192c<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        @NotNull
        private final MapBuilder<K, V> a;
        private final int b;

        public C8192c(@NotNull MapBuilder<K, V> mapBuilder, int i) {
            b41.i(mapBuilder, "map");
            this.a = mapBuilder;
            this.b = i;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@Nullable Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (b41.d(entry.getKey(), getKey()) && b41.d(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) ((MapBuilder) this.a).keysArray[this.b];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = ((MapBuilder) this.a).valuesArray;
            b41.f(objArr);
            return (V) objArr[this.b];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K key = getKey();
            int hashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            return hashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            this.a.checkIsMutable$kotlin_stdlib();
            Object[] allocateValuesArray = this.a.allocateValuesArray();
            int i = this.b;
            V v2 = (V) allocateValuesArray[i];
            allocateValuesArray[i] = v;
            return v2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append(C4250a.h);
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.collections.builders.MapBuilder$d */
    /* loaded from: classes3.dex */
    public static class C8193d<K, V> {
        @NotNull
        private final MapBuilder<K, V> a;
        private int b;
        private int c;

        public C8193d(@NotNull MapBuilder<K, V> mapBuilder) {
            b41.i(mapBuilder, "map");
            this.a = mapBuilder;
            this.c = -1;
            d();
        }

        public final int a() {
            return this.b;
        }

        public final int b() {
            return this.c;
        }

        @NotNull
        public final MapBuilder<K, V> c() {
            return this.a;
        }

        public final void d() {
            while (this.b < ((MapBuilder) this.a).length) {
                int[] iArr = ((MapBuilder) this.a).presenceArray;
                int i = this.b;
                if (iArr[i] >= 0) {
                    return;
                }
                this.b = i + 1;
            }
        }

        public final void e(int i) {
            this.b = i;
        }

        public final void f(int i) {
            this.c = i;
        }

        public final boolean hasNext() {
            return this.b < ((MapBuilder) this.a).length;
        }

        public final void remove() {
            if (this.c != -1) {
                this.a.checkIsMutable$kotlin_stdlib();
                this.a.removeKeyAt(this.c);
                this.c = -1;
                return;
            }
            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.collections.builders.MapBuilder$e */
    /* loaded from: classes3.dex */
    public static final class C8194e<K, V> extends C8193d<K, V> implements Iterator<K>, KMutableIterator {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8194e(@NotNull MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            b41.i(mapBuilder, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            if (a() < ((MapBuilder) c()).length) {
                int a = a();
                e(a + 1);
                f(a);
                K k = (K) ((MapBuilder) c()).keysArray[b()];
                d();
                return k;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.collections.builders.MapBuilder$f */
    /* loaded from: classes3.dex */
    public static final class C8195f<K, V> extends C8193d<K, V> implements Iterator<V>, KMutableIterator {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8195f(@NotNull MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            b41.i(mapBuilder, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            if (a() < ((MapBuilder) c()).length) {
                int a = a();
                e(a + 1);
                f(a);
                Object[] objArr = ((MapBuilder) c()).valuesArray;
                b41.f(objArr);
                V v = (V) objArr[b()];
                d();
                return v;
            }
            throw new NoSuchElementException();
        }
    }

    private MapBuilder(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i, int i2) {
        this.keysArray = kArr;
        this.valuesArray = vArr;
        this.presenceArray = iArr;
        this.hashArray = iArr2;
        this.maxProbeDistance = i;
        this.length = i2;
        this.hashShift = Companion.d(getHashSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V[] allocateValuesArray() {
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) k91.d(getCapacity());
        this.valuesArray = vArr2;
        return vArr2;
    }

    private final void compact() {
        int i;
        V[] vArr = this.valuesArray;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.length;
            if (i2 >= i) {
                break;
            }
            if (this.presenceArray[i2] >= 0) {
                K[] kArr = this.keysArray;
                kArr[i3] = kArr[i2];
                if (vArr != null) {
                    vArr[i3] = vArr[i2];
                }
                i3++;
            }
            i2++;
        }
        k91.g(this.keysArray, i3, i);
        if (vArr != null) {
            k91.g(vArr, i3, this.length);
        }
        this.length = i3;
    }

    private final boolean contentEquals(Map<?, ?> map) {
        return size() == map.size() && containsAllEntries$kotlin_stdlib(map.entrySet());
    }

    private final void ensureCapacity(int i) {
        if (i >= 0) {
            if (i > getCapacity()) {
                int capacity = (getCapacity() * 3) / 2;
                if (i <= capacity) {
                    i = capacity;
                }
                this.keysArray = (K[]) k91.e(this.keysArray, i);
                V[] vArr = this.valuesArray;
                this.valuesArray = vArr != null ? (V[]) k91.e(vArr, i) : null;
                int[] copyOf = Arrays.copyOf(this.presenceArray, i);
                b41.h(copyOf, "copyOf(this, newSize)");
                this.presenceArray = copyOf;
                int c = Companion.c(i);
                if (c > getHashSize()) {
                    rehash(c);
                    return;
                }
                return;
            } else if ((this.length + i) - size() > getCapacity()) {
                rehash(getHashSize());
                return;
            } else {
                return;
            }
        }
        throw new OutOfMemoryError();
    }

    private final void ensureExtraCapacity(int i) {
        ensureCapacity(this.length + i);
    }

    private final int findKey(K k) {
        int hash = hash(k);
        int i = this.maxProbeDistance;
        while (true) {
            int i2 = this.hashArray[hash];
            if (i2 == 0) {
                return -1;
            }
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (b41.d(this.keysArray[i3], k)) {
                    return i3;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            hash = hash == 0 ? getHashSize() - 1 : hash - 1;
        }
    }

    private final int findValue(V v) {
        int i = this.length;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.presenceArray[i] >= 0) {
                V[] vArr = this.valuesArray;
                b41.f(vArr);
                if (b41.d(vArr[i], v)) {
                    return i;
                }
            }
        }
    }

    private final int getCapacity() {
        return this.keysArray.length;
    }

    private final int getHashSize() {
        return this.hashArray.length;
    }

    private final int hash(K k) {
        return ((k != null ? k.hashCode() : 0) * MAGIC) >>> this.hashShift;
    }

    private final boolean putAllEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z = false;
        if (collection.isEmpty()) {
            return false;
        }
        ensureExtraCapacity(collection.size());
        for (Map.Entry<? extends K, ? extends V> entry : collection) {
            if (putEntry(entry)) {
                z = true;
            }
        }
        return z;
    }

    private final boolean putEntry(Map.Entry<? extends K, ? extends V> entry) {
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
        V[] allocateValuesArray = allocateValuesArray();
        if (addKey$kotlin_stdlib >= 0) {
            allocateValuesArray[addKey$kotlin_stdlib] = entry.getValue();
            return true;
        }
        int i = (-addKey$kotlin_stdlib) - 1;
        if (b41.d(entry.getValue(), allocateValuesArray[i])) {
            return false;
        }
        allocateValuesArray[i] = entry.getValue();
        return true;
    }

    private final boolean putRehash(int i) {
        int hash = hash(this.keysArray[i]);
        int i2 = this.maxProbeDistance;
        while (true) {
            int[] iArr = this.hashArray;
            if (iArr[hash] == 0) {
                iArr[hash] = i + 1;
                this.presenceArray[i] = hash;
                return true;
            }
            i2--;
            if (i2 < 0) {
                return false;
            }
            hash = hash == 0 ? getHashSize() - 1 : hash - 1;
        }
    }

    private final void rehash(int i) {
        if (this.length > size()) {
            compact();
        }
        int i2 = 0;
        if (i != getHashSize()) {
            this.hashArray = new int[i];
            this.hashShift = Companion.d(i);
        } else {
            C8202e.i(this.hashArray, 0, 0, getHashSize());
        }
        while (i2 < this.length) {
            int i3 = i2 + 1;
            if (!putRehash(i2)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i2 = i3;
        }
    }

    private final void removeHashAt(int i) {
        int d = ry1.d(this.maxProbeDistance * 2, getHashSize() / 2);
        int i2 = 0;
        int i3 = i;
        do {
            i = i == 0 ? getHashSize() - 1 : i - 1;
            i2++;
            if (i2 > this.maxProbeDistance) {
                this.hashArray[i3] = 0;
                return;
            }
            int[] iArr = this.hashArray;
            int i4 = iArr[i];
            if (i4 == 0) {
                iArr[i3] = 0;
                return;
            }
            if (i4 < 0) {
                iArr[i3] = -1;
            } else {
                int i5 = i4 - 1;
                if (((hash(this.keysArray[i5]) - i) & (getHashSize() - 1)) >= i2) {
                    this.hashArray[i3] = i4;
                    this.presenceArray[i5] = i3;
                }
                d--;
            }
            i3 = i;
            i2 = 0;
            d--;
        } while (d >= 0);
        this.hashArray[i3] = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeKeyAt(int i) {
        k91.f(this.keysArray, i);
        removeHashAt(this.presenceArray[i]);
        this.presenceArray[i] = -1;
        this.size = size() - 1;
    }

    private final Object writeReplace() {
        if (this.isReadOnly) {
            return new SerializedMap(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    public final int addKey$kotlin_stdlib(K k) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int hash = hash(k);
            int d = ry1.d(this.maxProbeDistance * 2, getHashSize() / 2);
            int i = 0;
            while (true) {
                int i2 = this.hashArray[hash];
                if (i2 <= 0) {
                    if (this.length >= getCapacity()) {
                        ensureExtraCapacity(1);
                    } else {
                        int i3 = this.length;
                        int i4 = i3 + 1;
                        this.length = i4;
                        this.keysArray[i3] = k;
                        this.presenceArray[i3] = hash;
                        this.hashArray[hash] = i4;
                        this.size = size() + 1;
                        if (i > this.maxProbeDistance) {
                            this.maxProbeDistance = i;
                        }
                        return i3;
                    }
                } else if (b41.d(this.keysArray[i2 - 1], k)) {
                    return -i2;
                } else {
                    i++;
                    if (i > d) {
                        rehash(getHashSize() * 2);
                        break;
                    }
                    hash = hash == 0 ? getHashSize() - 1 : hash - 1;
                }
            }
        }
    }

    @NotNull
    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        return this;
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        i31 it = new n31(0, this.length - 1).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            int[] iArr = this.presenceArray;
            int i = iArr[nextInt];
            if (i >= 0) {
                this.hashArray[i] = 0;
                iArr[nextInt] = -1;
            }
        }
        k91.g(this.keysArray, 0, this.length);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            k91.g(vArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
    }

    public final boolean containsAllEntries$kotlin_stdlib(@NotNull Collection<?> collection) {
        b41.i(collection, WXComponent.PROP_FS_MATCH_PARENT);
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        b41.i(entry, "entry");
        int findKey = findKey(entry.getKey());
        if (findKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        b41.f(vArr);
        return b41.d(vArr[findKey], entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return findKey(obj) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return findValue(obj) >= 0;
    }

    @NotNull
    public final C8191b<K, V> entriesIterator$kotlin_stdlib() {
        return new C8191b<>(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(@Nullable Object obj) {
        return obj == this || ((obj instanceof Map) && contentEquals((Map) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V get(Object obj) {
        int findKey = findKey(obj);
        if (findKey < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        b41.f(vArr);
        return vArr[findKey];
    }

    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        bd1<K, V> bd1Var = this.entriesView;
        if (bd1Var == null) {
            bd1<K, V> bd1Var2 = new bd1<>(this);
            this.entriesView = bd1Var2;
            return bd1Var2;
        }
        return bd1Var;
    }

    @NotNull
    public Set<K> getKeys() {
        cd1<K> cd1Var = this.keysView;
        if (cd1Var == null) {
            cd1<K> cd1Var2 = new cd1<>(this);
            this.keysView = cd1Var2;
            return cd1Var2;
        }
        return cd1Var;
    }

    public int getSize() {
        return this.size;
    }

    @NotNull
    public Collection<V> getValues() {
        dd1<V> dd1Var = this.valuesView;
        if (dd1Var == null) {
            dd1<V> dd1Var2 = new dd1<>(this);
            this.valuesView = dd1Var2;
            return dd1Var2;
        }
        return dd1Var;
    }

    @Override // java.util.Map
    public int hashCode() {
        C8191b<K, V> entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            i += entriesIterator$kotlin_stdlib.i();
        }
        return i;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public final boolean isReadOnly$kotlin_stdlib() {
        return this.isReadOnly;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @NotNull
    public final C8194e<K, V> keysIterator$kotlin_stdlib() {
        return new C8194e<>(this);
    }

    @Override // java.util.Map
    @Nullable
    public V put(K k, V v) {
        checkIsMutable$kotlin_stdlib();
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(k);
        V[] allocateValuesArray = allocateValuesArray();
        if (addKey$kotlin_stdlib < 0) {
            int i = (-addKey$kotlin_stdlib) - 1;
            V v2 = allocateValuesArray[i];
            allocateValuesArray[i] = v;
            return v2;
        }
        allocateValuesArray[addKey$kotlin_stdlib] = v;
        return null;
    }

    @Override // java.util.Map
    public void putAll(@NotNull Map<? extends K, ? extends V> map) {
        b41.i(map, "from");
        checkIsMutable$kotlin_stdlib();
        putAllEntries(map.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V remove(Object obj) {
        int removeKey$kotlin_stdlib = removeKey$kotlin_stdlib(obj);
        if (removeKey$kotlin_stdlib < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        b41.f(vArr);
        V v = vArr[removeKey$kotlin_stdlib];
        k91.f(vArr, removeKey$kotlin_stdlib);
        return v;
    }

    public final boolean removeEntry$kotlin_stdlib(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        b41.i(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(entry.getKey());
        if (findKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        b41.f(vArr);
        if (b41.d(vArr[findKey], entry.getValue())) {
            removeKeyAt(findKey);
            return true;
        }
        return false;
    }

    public final int removeKey$kotlin_stdlib(K k) {
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(k);
        if (findKey < 0) {
            return -1;
        }
        removeKeyAt(findKey);
        return findKey;
    }

    public final boolean removeValue$kotlin_stdlib(V v) {
        checkIsMutable$kotlin_stdlib();
        int findValue = findValue(v);
        if (findValue < 0) {
            return false;
        }
        removeKeyAt(findValue);
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append(jn1.BLOCK_START_STR);
        C8191b<K, V> entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            if (i > 0) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            entriesIterator$kotlin_stdlib.h(sb);
            i++;
        }
        sb.append("}");
        String sb2 = sb.toString();
        b41.h(sb2, "sb.toString()");
        return sb2;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    @NotNull
    public final C8195f<K, V> valuesIterator$kotlin_stdlib() {
        return new C8195f<>(this);
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int i) {
        this(k91.d(i), null, new int[i], new int[Companion.c(i)], 2, 0);
    }
}
