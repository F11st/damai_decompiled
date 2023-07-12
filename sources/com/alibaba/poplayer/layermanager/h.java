package com.alibaba.poplayer.layermanager;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
class h {
    private ArrayList<PopRequest> a = new ArrayList<>();

    public boolean a(PopRequest popRequest) {
        if (this.a.contains(popRequest)) {
            return false;
        }
        this.a.add(popRequest);
        return true;
    }

    public PopRequest b() {
        if (this.a.isEmpty()) {
            return null;
        }
        PopRequest d = d.d(this.a);
        c(d);
        return d;
    }

    public boolean c(PopRequest popRequest) {
        return this.a.remove(popRequest);
    }

    public boolean d(Collection<PopRequest> collection) {
        return this.a.removeAll(collection);
    }
}
