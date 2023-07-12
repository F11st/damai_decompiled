package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;
import tb.nm1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@GwtIncompatible
/* loaded from: classes10.dex */
public class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    @VisibleForTesting
    static final int DEFAULT_SIZE = 3;
    private static final long HASH_MASK = -4294967296L;
    private static final float LOAD_FACTOR = 1.0f;
    private static final long NEXT_MASK = 4294967295L;
    static final int UNSET = -1;
    @MonotonicNonNullDecl
    transient Object[] elements;
    @MonotonicNonNullDecl
    private transient long[] entries;
    transient int modCount;
    private transient int size;
    @MonotonicNonNullDecl
    private transient int[] table;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    class a implements Iterator<E> {
        int a;
        int b;
        int c = -1;

        a() {
            this.a = CompactHashSet.this.modCount;
            this.b = CompactHashSet.this.firstEntryIndex();
        }

        private void a() {
            if (CompactHashSet.this.modCount != this.a) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b >= 0;
        }

        @Override // java.util.Iterator
        public E next() {
            a();
            if (hasNext()) {
                int i = this.b;
                this.c = i;
                CompactHashSet compactHashSet = CompactHashSet.this;
                E e = (E) compactHashSet.elements[i];
                this.b = compactHashSet.getSuccessor(i);
                return e;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            k.e(this.c >= 0);
            this.a++;
            CompactHashSet compactHashSet = CompactHashSet.this;
            compactHashSet.remove(compactHashSet.elements[this.c], CompactHashSet.getHash(compactHashSet.entries[this.c]));
            this.b = CompactHashSet.this.adjustAfterRemove(this.b, this.c);
            this.c = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompactHashSet() {
        init(3);
    }

    public static <E> CompactHashSet<E> create() {
        return new CompactHashSet<>();
    }

    public static <E> CompactHashSet<E> createWithExpectedSize(int i) {
        return new CompactHashSet<>(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getHash(long j) {
        return (int) (j >>> 32);
    }

    private static int getNext(long j) {
        return (int) j;
    }

    private int hashTableMask() {
        return this.table.length - 1;
    }

    private static long[] newEntries(int i) {
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    private static int[] newTable(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            init(readInt);
            for (int i = 0; i < readInt; i++) {
                add(objectInputStream.readObject());
            }
            return;
        }
        throw new InvalidObjectException("Invalid size: " + readInt);
    }

    private void resizeMeMaybe(int i) {
        int length = this.entries.length;
        if (i > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                resizeEntries(max);
            }
        }
    }

    private void resizeTable(int i) {
        int[] newTable = newTable(i);
        long[] jArr = this.entries;
        int length = newTable.length - 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            int hash = getHash(jArr[i2]);
            int i3 = hash & length;
            int i4 = newTable[i3];
            newTable[i3] = i2;
            jArr[i2] = (hash << 32) | (i4 & NEXT_MASK);
        }
        this.table = newTable;
    }

    private static long swapNext(long j, int i) {
        return (j & HASH_MASK) | (i & NEXT_MASK);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        int firstEntryIndex = firstEntryIndex();
        while (firstEntryIndex >= 0) {
            objectOutputStream.writeObject(this.elements[firstEntryIndex]);
            firstEntryIndex = getSuccessor(firstEntryIndex);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean add(@NullableDecl E e) {
        if (needsAllocArrays()) {
            allocArrays();
        }
        long[] jArr = this.entries;
        Object[] objArr = this.elements;
        int d = z.d(e);
        int hashTableMask = hashTableMask() & d;
        int i = this.size;
        int[] iArr = this.table;
        int i2 = iArr[hashTableMask];
        if (i2 == -1) {
            iArr[hashTableMask] = i;
        } else {
            while (true) {
                long j = jArr[i2];
                if (getHash(j) == d && nm1.a(e, objArr[i2])) {
                    return false;
                }
                int next = getNext(j);
                if (next == -1) {
                    jArr[i2] = swapNext(j, i);
                    break;
                }
                i2 = next;
            }
        }
        if (i != Integer.MAX_VALUE) {
            int i3 = i + 1;
            resizeMeMaybe(i3);
            insertEntry(i, e, d);
            this.size = i3;
            int length = this.table.length;
            if (z.b(i, length, 1.0d)) {
                resizeTable(length * 2);
            }
            this.modCount++;
            return true;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    int adjustAfterRemove(int i, int i2) {
        return i - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void allocArrays() {
        du1.x(needsAllocArrays(), "Arrays already allocated");
        int i = this.modCount;
        this.table = newTable(z.a(i, 1.0d));
        this.entries = newEntries(i);
        this.elements = new Object[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        this.modCount++;
        Arrays.fill(this.elements, 0, this.size, (Object) null);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, 0, this.size, -1L);
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        int d = z.d(obj);
        int i = this.table[hashTableMask() & d];
        while (i != -1) {
            long j = this.entries[i];
            if (getHash(j) == d && nm1.a(obj, this.elements[i])) {
                return true;
            }
            i = getNext(j);
        }
        return false;
    }

    int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    int getSuccessor(int i) {
        int i2 = i + 1;
        if (i2 < this.size) {
            return i2;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init(int i) {
        du1.e(i >= 0, "Initial capacity must be non-negative");
        this.modCount = Math.max(1, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void insertEntry(int i, E e, int i2) {
        this.entries[i] = (i2 << 32) | NEXT_MASK;
        this.elements[i] = e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void moveLastEntry(int i) {
        int size = size() - 1;
        if (i < size) {
            Object[] objArr = this.elements;
            objArr[i] = objArr[size];
            objArr[size] = null;
            long[] jArr = this.entries;
            long j = jArr[size];
            jArr[i] = j;
            jArr[size] = -1;
            int hash = getHash(j) & hashTableMask();
            int[] iArr = this.table;
            int i2 = iArr[hash];
            if (i2 == size) {
                iArr[hash] = i;
                return;
            }
            while (true) {
                long j2 = this.entries[i2];
                int next = getNext(j2);
                if (next == size) {
                    this.entries[i2] = swapNext(j2, i);
                    return;
                }
                i2 = next;
            }
        } else {
            this.elements[i] = null;
            this.entries[i] = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean needsAllocArrays() {
        return this.table == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        return remove(obj, z.d(obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resizeEntries(int i) {
        this.elements = Arrays.copyOf(this.elements, i);
        long[] jArr = this.entries;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(copyOf, length, i, -1L);
        }
        this.entries = copyOf;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return needsAllocArrays() ? new Object[0] : Arrays.copyOf(this.elements, this.size);
    }

    public void trimToSize() {
        if (needsAllocArrays()) {
            return;
        }
        int i = this.size;
        if (i < this.entries.length) {
            resizeEntries(i);
        }
        int a2 = z.a(i, 1.0d);
        if (a2 < this.table.length) {
            resizeTable(a2);
        }
    }

    public static <E> CompactHashSet<E> create(Collection<? extends E> collection) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompactHashSet(int i) {
        init(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
    public boolean remove(Object obj, int i) {
        int hashTableMask = hashTableMask() & i;
        int i2 = this.table[hashTableMask];
        if (i2 == -1) {
            return false;
        }
        int i3 = -1;
        while (true) {
            if (getHash(this.entries[i2]) == i && nm1.a(obj, this.elements[i2])) {
                if (i3 == -1) {
                    this.table[hashTableMask] = getNext(this.entries[i2]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i3] = swapNext(jArr[i3], getNext(jArr[i2]));
                }
                moveLastEntry(i2);
                this.size--;
                this.modCount++;
                return true;
            }
            int next = getNext(this.entries[i2]);
            if (next == -1) {
                return false;
            }
            i3 = i2;
            i2 = next;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public <T> T[] toArray(T[] tArr) {
        if (needsAllocArrays()) {
            if (tArr.length > 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        return (T[]) b0.h(this.elements, 0, this.size, tArr);
    }

    public static <E> CompactHashSet<E> create(E... eArr) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }
}
