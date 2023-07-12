package com.taobao.android.dinamicx.model;

import androidx.collection.LongSparseArray;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXLongSparseArray<E> extends LongSparseArray<E> {
    public DXLongSparseArray() {
    }

    public void putAll(DXLongSparseArray<E> dXLongSparseArray) {
        if (dXLongSparseArray == null) {
            return;
        }
        for (int i = 0; i < dXLongSparseArray.size(); i++) {
            put(dXLongSparseArray.keyAt(i), dXLongSparseArray.valueAt(i));
        }
    }

    public DXLongSparseArray(int i) {
        super(i);
    }

    public DXLongSparseArray(DXLongSparseArray<E> dXLongSparseArray) {
        putAll((DXLongSparseArray) dXLongSparseArray);
    }
}
