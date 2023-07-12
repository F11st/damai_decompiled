package com.alibaba.poplayer.layermanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
class LayerInfoOrderList extends ArrayList<C3659d> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayer.layermanager.LayerInfoOrderList$a */
    /* loaded from: classes8.dex */
    public class C3654a implements Comparator<C3659d> {
        C3654a(LayerInfoOrderList layerInfoOrderList) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(C3659d c3659d, C3659d c3659d2) {
            return c3659d.f() - c3659d2.f();
        }
    }

    private void sort() {
        Collections.sort(this, new C3654a(this));
    }

    public C3659d findLayerInfoByLevel(int i) {
        Iterator<C3659d> it = iterator();
        while (it.hasNext()) {
            C3659d next = it.next();
            if (next.f() == i) {
                return next;
            }
        }
        C3659d c3659d = new C3659d(i);
        add(c3659d);
        return c3659d;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(C3659d c3659d) {
        boolean add = super.add((LayerInfoOrderList) c3659d);
        sort();
        return add;
    }
}
