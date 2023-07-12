package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import tb.du1;

/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
public final class b0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static Object a(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static Object[] b(Object... objArr) {
        return c(objArr, objArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static Object[] c(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            a(objArr[i2], i2);
        }
        return objArr;
    }

    @CanIgnoreReturnValue
    private static Object[] d(Iterable<?> iterable, Object[] objArr) {
        Iterator<?> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return objArr;
    }

    public static <T> T[] e(T[] tArr, int i) {
        return (T[]) e0.b(tArr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] f(Collection<?> collection) {
        return d(collection, new Object[collection.size()]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] g(Collection<?> collection, T[] tArr) {
        int size = collection.size();
        if (tArr.length < size) {
            tArr = (T[]) e(tArr, size);
        }
        d(collection, tArr);
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] h(Object[] objArr, int i, int i2, T[] tArr) {
        du1.v(i, i + i2, objArr.length);
        if (tArr.length < i2) {
            tArr = (T[]) e(tArr, i2);
        } else if (tArr.length > i2) {
            tArr[i2] = null;
        }
        System.arraycopy(objArr, i, tArr, 0, i2);
        return tArr;
    }
}
