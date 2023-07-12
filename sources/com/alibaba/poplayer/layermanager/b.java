package com.alibaba.poplayer.layermanager;

import android.view.View;
import androidx.annotation.UiThread;
import com.alibaba.poplayer.Domain;
import com.alibaba.poplayer.layermanager.PopRequest;
import com.alibaba.poplayer.layermanager.view.Canvas;
import java.util.ArrayList;
import java.util.Iterator;
import tb.dt1;
import tb.ft1;
import tb.yv0;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class b {
    private final int a;
    private LayerInfoOrderList b = new LayerInfoOrderList();
    private Canvas c;

    public b(int i) {
        this.a = i;
    }

    private yv0<d, PopRequest> b(ArrayList<PopRequest> arrayList) {
        yv0<d, PopRequest> yv0Var = new yv0<>();
        Iterator<PopRequest> it = arrayList.iterator();
        while (it.hasNext()) {
            PopRequest next = it.next();
            yv0Var.c(this.b.findLayerInfoByLevel(((c) next.h()).e), next);
        }
        return yv0Var;
    }

    @UiThread
    private synchronized void g() {
        Canvas d = d();
        if (d == null) {
            dt1.b("%s. updateCanvas ,but lose canvas.", toString());
            return;
        }
        Iterator<d> it = this.b.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.g()) {
                View findViewByLevel = d.findViewByLevel(next.f());
                if (findViewByLevel != null) {
                    d().removeView(findViewByLevel);
                }
                if (next.c() != null && next.c().e() != null) {
                    View e = next.c().e();
                    if (e != null) {
                        dt1.b("%s. remove Layer {level:%s}.", toString(), Integer.valueOf(next.f()));
                        d.addViewByLevel(e, next.f());
                        ft1.a(next.c(), PopRequest.Status.SHOWING);
                        dt1.b("%s. add Layer {level:%s}.", toString(), Integer.valueOf(next.f()));
                    }
                }
                next.b();
            }
        }
    }

    public synchronized void a(ArrayList<PopRequest> arrayList) {
        yv0<d, PopRequest> b = b(arrayList);
        for (d dVar : b.b().keySet()) {
            dVar.a(b.a(dVar));
        }
        g();
    }

    public int c() {
        Iterator<d> it = this.b.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().c() != null) {
                i++;
            }
        }
        return i;
    }

    public Canvas d() {
        return this.c;
    }

    public synchronized void e(ArrayList<PopRequest> arrayList) {
        yv0<d, PopRequest> b = b(arrayList);
        for (d dVar : b.b().keySet()) {
            dVar.i(b.a(dVar));
        }
        g();
    }

    public void f(Canvas canvas) {
        this.c = canvas;
    }

    public void h(PopRequest popRequest) {
        d findLayerInfoByLevel = this.b.findLayerInfoByLevel(((c) popRequest.h()).e);
        if (findLayerInfoByLevel.c() != popRequest) {
            dt1.b("%s.viewReadyNotify=>request not match!", toString());
            return;
        }
        dt1.b("%s.viewReadyNotify=>readyToShow!", toString());
        findLayerInfoByLevel.h();
        g();
    }

    public String toString() {
        return "CanvasViewModel{mDomain=" + Domain.toString(this.a) + '}';
    }
}
