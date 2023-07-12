package com.alibaba.poplayer.layermanager;

import com.alibaba.poplayer.layermanager.PopRequest;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class d {
    private PopRequest a;
    private h b = new h();
    private volatile boolean c = false;
    private final int d;

    public d(int i) {
        this.d = i;
    }

    public static PopRequest d(ArrayList<PopRequest> arrayList) {
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            int i4 = arrayList.get(i3).h().a;
            if (i4 > i2) {
                i = i3;
                i2 = i4;
            }
        }
        if (i >= 0) {
            return arrayList.get(i);
        }
        return null;
    }

    public static PopRequest e(ArrayList<PopRequest> arrayList, PopRequest popRequest) {
        int i;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            if (arrayList.get(i4).h().c && (i = arrayList.get(i4).h().a) > i3) {
                i2 = i4;
                i3 = i;
            }
        }
        PopRequest popRequest2 = i2 >= 0 ? arrayList.get(i2) : null;
        if (popRequest2 == null || popRequest2.h().a > popRequest.h().a) {
            return popRequest2;
        }
        return null;
    }

    public void a(ArrayList<PopRequest> arrayList) {
        PopRequest popRequest = this.a;
        if (popRequest == null) {
            this.c = true;
            PopRequest d = d(arrayList);
            this.a = d;
            if (d.e() != null) {
                d.q(PopRequest.Status.SHOWING);
            } else {
                d.q(PopRequest.Status.READY);
                d.j().onReady(d);
            }
            arrayList.remove(d);
            Iterator<PopRequest> it = arrayList.iterator();
            while (it.hasNext()) {
                PopRequest next = it.next();
                if (next.h().b) {
                    this.b.a(next);
                }
            }
            return;
        }
        PopRequest e = e(arrayList, popRequest);
        if (e != null) {
            this.c = true;
            if (this.a.h().b) {
                this.b.a(this.a);
                this.a.q(PopRequest.Status.WAITTING);
            } else {
                this.a.q(PopRequest.Status.REMOVED);
                this.a.j().onForceRemoved(this.a);
            }
            if (e.e() != null) {
                e.q(PopRequest.Status.SHOWING);
            } else {
                e.q(PopRequest.Status.READY);
                e.j().onReady(e);
            }
            this.a = e;
            arrayList.remove(e);
        }
        Iterator<PopRequest> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            PopRequest next2 = it2.next();
            if (next2.h().b) {
                this.b.a(next2);
            }
        }
    }

    public void b() {
        this.c = false;
    }

    public PopRequest c() {
        return this.a;
    }

    public int f() {
        return this.d;
    }

    public boolean g() {
        return this.c;
    }

    public void h() {
        this.c = true;
    }

    public void i(ArrayList<PopRequest> arrayList) {
        PopRequest b;
        if (arrayList.contains(this.a)) {
            this.c = true;
            this.a.q(PopRequest.Status.REMOVED);
            arrayList.remove(this.a);
            this.a = null;
        }
        Iterator<PopRequest> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().q(PopRequest.Status.REMOVED);
        }
        this.b.d(arrayList);
        if (this.a != null || (b = this.b.b()) == null) {
            return;
        }
        if (b.e() != null) {
            b.q(PopRequest.Status.SHOWING);
        } else {
            b.q(PopRequest.Status.READY);
            b.j().onReady(b);
        }
        this.a = b;
    }
}
