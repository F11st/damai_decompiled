package com.alibaba.poplayer.layermanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
class LayerInfoOrderList extends ArrayList<d> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a implements Comparator<d> {
        a(LayerInfoOrderList layerInfoOrderList) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            return dVar.f() - dVar2.f();
        }
    }

    private void sort() {
        Collections.sort(this, new a(this));
    }

    public d findLayerInfoByLevel(int i) {
        Iterator<d> it = iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.f() == i) {
                return next;
            }
        }
        d dVar = new d(i);
        add(dVar);
        return dVar;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(d dVar) {
        boolean add = super.add((LayerInfoOrderList) dVar);
        sort();
        return add;
    }
}
