package com.alibaba.poplayer.layermanager;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: Taobao */
/* renamed from: com.alibaba.poplayer.layermanager.h */
/* loaded from: classes8.dex */
class C3665h {
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
        PopRequest d = C3659d.d(this.a);
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
