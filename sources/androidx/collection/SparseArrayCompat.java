package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alipay.sdk.m.n.a;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SparseArrayCompat<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private int[] mKeys;
    private int mSize;
    private Object[] mValues;

    public SparseArrayCompat() {
        this(10);
    }

    private void gc() {
        int i = this.mSize;
        int[] iArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != DELETED) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.mGarbage = false;
        this.mSize = i2;
    }

    public void append(int i, E e) {
        int i2 = this.mSize;
        if (i2 != 0 && i <= this.mKeys[i2 - 1]) {
            put(i, e);
            return;
        }
        if (this.mGarbage && i2 >= this.mKeys.length) {
            gc();
        }
        int i3 = this.mSize;
        if (i3 >= this.mKeys.length) {
            int idealIntArraySize = ContainerHelpers.idealIntArraySize(i3 + 1);
            int[] iArr = new int[idealIntArraySize];
            Object[] objArr = new Object[idealIntArraySize];
            int[] iArr2 = this.mKeys;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.mValues;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.mKeys = iArr;
            this.mValues = objArr;
        }
        this.mKeys[i3] = i;
        this.mValues[i3] = e;
        this.mSize = i3 + 1;
    }

    public void clear() {
        int i = this.mSize;
        Object[] objArr = this.mValues;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public boolean containsKey(int i) {
        return indexOfKey(i) >= 0;
    }

    public boolean containsValue(E e) {
        return indexOfValue(e) >= 0;
    }

    @Deprecated
    public void delete(int i) {
        remove(i);
    }

    @Nullable
    public E get(int i) {
        return get(i, null);
    }

    public int indexOfKey(int i) {
        if (this.mGarbage) {
            gc();
        }
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
    }

    public int indexOfValue(E e) {
        if (this.mGarbage) {
            gc();
        }
        for (int i = 0; i < this.mSize; i++) {
            if (this.mValues[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int keyAt(int i) {
        if (this.mGarbage) {
            gc();
        }
        return this.mKeys[i];
    }

    public void put(int i, E e) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = e;
            return;
        }
        int i2 = ~binarySearch;
        int i3 = this.mSize;
        if (i2 < i3) {
            Object[] objArr = this.mValues;
            if (objArr[i2] == DELETED) {
                this.mKeys[i2] = i;
                objArr[i2] = e;
                return;
            }
        }
        if (this.mGarbage && i3 >= this.mKeys.length) {
            gc();
            i2 = ~ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
        }
        int i4 = this.mSize;
        if (i4 >= this.mKeys.length) {
            int idealIntArraySize = ContainerHelpers.idealIntArraySize(i4 + 1);
            int[] iArr = new int[idealIntArraySize];
            Object[] objArr2 = new Object[idealIntArraySize];
            int[] iArr2 = this.mKeys;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.mValues;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.mKeys = iArr;
            this.mValues = objArr2;
        }
        int i5 = this.mSize;
        if (i5 - i2 != 0) {
            int[] iArr3 = this.mKeys;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr4 = this.mValues;
            System.arraycopy(objArr4, i2, objArr4, i6, this.mSize - i2);
        }
        this.mKeys[i2] = i;
        this.mValues[i2] = e;
        this.mSize++;
    }

    public void putAll(@NonNull SparseArrayCompat<? extends E> sparseArrayCompat) {
        int size = sparseArrayCompat.size();
        for (int i = 0; i < size; i++) {
            put(sparseArrayCompat.keyAt(i), sparseArrayCompat.valueAt(i));
        }
    }

    @Nullable
    public E putIfAbsent(int i, E e) {
        E e2 = get(i);
        if (e2 == null) {
            put(i, e);
        }
        return e2;
    }

    public void remove(int i) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
        if (binarySearch >= 0) {
            Object[] objArr = this.mValues;
            Object obj = objArr[binarySearch];
            Object obj2 = DELETED;
            if (obj != obj2) {
                objArr[binarySearch] = obj2;
                this.mGarbage = true;
            }
        }
    }

    public void removeAt(int i) {
        Object[] objArr = this.mValues;
        Object obj = objArr[i];
        Object obj2 = DELETED;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.mGarbage = true;
        }
    }

    public void removeAtRange(int i, int i2) {
        int min = Math.min(this.mSize, i2 + i);
        while (i < min) {
            removeAt(i);
            i++;
        }
    }

    @Nullable
    public E replace(int i, E e) {
        int indexOfKey = indexOfKey(i);
        if (indexOfKey >= 0) {
            Object[] objArr = this.mValues;
            E e2 = (E) objArr[indexOfKey];
            objArr[indexOfKey] = e;
            return e2;
        }
        return null;
    }

    public void setValueAt(int i, E e) {
        if (this.mGarbage) {
            gc();
        }
        this.mValues[i] = e;
    }

    public int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append(keyAt(i));
            sb.append(a.h);
            E valueAt = valueAt(i);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public E valueAt(int i) {
        if (this.mGarbage) {
            gc();
        }
        return (E) this.mValues[i];
    }

    public SparseArrayCompat(int i) {
        this.mGarbage = false;
        if (i == 0) {
            this.mKeys = ContainerHelpers.EMPTY_INTS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
            return;
        }
        int idealIntArraySize = ContainerHelpers.idealIntArraySize(i);
        this.mKeys = new int[idealIntArraySize];
        this.mValues = new Object[idealIntArraySize];
    }

    /* renamed from: clone */
    public SparseArrayCompat<E> m1clone() {
        try {
            SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) super.clone();
            sparseArrayCompat.mKeys = (int[]) this.mKeys.clone();
            sparseArrayCompat.mValues = (Object[]) this.mValues.clone();
            return sparseArrayCompat;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public E get(int i, E e) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
        if (binarySearch >= 0) {
            Object[] objArr = this.mValues;
            if (objArr[binarySearch] != DELETED) {
                return (E) objArr[binarySearch];
            }
        }
        return e;
    }

    public boolean replace(int i, E e, E e2) {
        int indexOfKey = indexOfKey(i);
        if (indexOfKey >= 0) {
            Object obj = this.mValues[indexOfKey];
            if (obj == e || (e != null && e.equals(obj))) {
                this.mValues[indexOfKey] = e2;
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean remove(int i, Object obj) {
        int indexOfKey = indexOfKey(i);
        if (indexOfKey >= 0) {
            E valueAt = valueAt(indexOfKey);
            if (obj == valueAt || (obj != null && obj.equals(valueAt))) {
                removeAt(indexOfKey);
                return true;
            }
            return false;
        }
        return false;
    }
}
