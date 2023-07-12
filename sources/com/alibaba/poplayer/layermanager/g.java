package com.alibaba.poplayer.layermanager;

import android.app.Activity;
import android.view.View;
import com.alibaba.poplayer.R$id;
import com.alibaba.poplayer.layermanager.PopRequest;
import com.alibaba.poplayer.layermanager.view.Canvas;
import com.alibaba.poplayer.layermanager.view.PopLayerViewContainer;
import com.alibaba.poplayer.layermanager.view.SandoContainer;
import com.alibaba.poplayer.trigger.view.TrackingService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tb.dt1;
import tb.fw2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class g implements ICVMHolderAction {
    private WeakReference<Activity> a;
    private e c;
    private WeakReference<SandoContainer> d;
    private boolean e = false;
    private HashMap<View, b> b = new HashMap<>();

    public g(e eVar, Activity activity) {
        this.c = eVar;
        this.a = new WeakReference<>(activity);
    }

    private void a() {
        Activity activity;
        if (this.e || (activity = (Activity) fw2.c(this.a)) == null) {
            return;
        }
        PopLayerViewContainer b = this.c.g.b(activity);
        b.setTag(R$id.layermanager_viewmodel_view_id, this);
        this.d = new WeakReference<>(b.getSandoContainer());
        this.e = true;
    }

    private boolean b(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.toString().contains(TrackingService.OPER_MIRROR);
    }

    @Override // com.alibaba.poplayer.layermanager.ICVMHolderAction
    public void acceptRequests(ArrayList<PopRequest> arrayList) {
        a();
        Activity activity = (Activity) fw2.c(this.a);
        if (activity == null) {
            dt1.b("context is empty!", new Object[0]);
            return;
        }
        SandoContainer sandoContainer = (SandoContainer) fw2.c(this.d);
        if (sandoContainer == null) {
            dt1.b("container is empty!", new Object[0]);
            return;
        }
        Iterator<PopRequest> it = arrayList.iterator();
        while (it.hasNext()) {
            PopRequest next = it.next();
            View d = next.d();
            if (d != null) {
                Object c = next.c();
                if (b(c)) {
                    sandoContainer.getMirrorLayer().addMirrorView(c.toString().contains("realTime"), d);
                    dt1.b("ViewCVMHolder.add new Canvas", new Object[0]);
                    next.q(PopRequest.Status.SHOWING);
                } else {
                    b bVar = this.b.get(d);
                    if (bVar != null && bVar.d() == null) {
                        this.b.remove(d);
                        bVar = null;
                    }
                    if (bVar == null) {
                        bVar = new b(3);
                        bVar.f(new Canvas(activity));
                        this.b.put(d, bVar);
                    }
                    ArrayList<PopRequest> arrayList2 = new ArrayList<>();
                    arrayList2.add(next);
                    bVar.a(arrayList2);
                    sandoContainer.getAugmentedLayer().augmentTargetView(next.d(), bVar.d());
                    dt1.b("ViewCVMHolder.add new Canvas", new Object[0]);
                }
            }
        }
    }

    @Override // com.alibaba.poplayer.layermanager.ICVMHolderAction
    public void attach(Activity activity) {
        if (e.i && activity.isChild() && (activity.getParent() instanceof Activity)) {
            this.a = new WeakReference<>(activity);
        }
        this.e = false;
    }

    @Override // com.alibaba.poplayer.layermanager.ICVMHolderAction
    public void removeRequests(ArrayList<PopRequest> arrayList) {
        if (((Activity) fw2.c(this.a)) == null) {
            dt1.b("context is empty!", new Object[0]);
            return;
        }
        SandoContainer sandoContainer = (SandoContainer) fw2.c(this.d);
        if (sandoContainer == null) {
            dt1.b("container is empty!", new Object[0]);
            return;
        }
        Iterator<PopRequest> it = arrayList.iterator();
        while (it.hasNext()) {
            PopRequest next = it.next();
            View d = next.d();
            if (d != null) {
                if (b(next.c())) {
                    sandoContainer.getMirrorLayer().removeMirrorView(d);
                    dt1.b("RemoveMirrorView{hostView:%s}.", d.toString());
                } else {
                    b bVar = this.b.get(d);
                    if (bVar != null && bVar.d() != null) {
                        ArrayList<PopRequest> arrayList2 = new ArrayList<>();
                        arrayList2.add(next);
                        bVar.e(arrayList2);
                        if (bVar.c() == 0) {
                            sandoContainer.getAugmentedLayer().unaugmentTarget(bVar.d());
                            bVar.f(null);
                            this.b.remove(d);
                            dt1.b("Free Augmentd CVM :{hostView:%s}.", d.toString());
                        }
                    } else {
                        dt1.b("removeRequest fail:Cvm is null.", new Object[0]);
                    }
                }
            }
        }
    }

    @Override // com.alibaba.poplayer.layermanager.ICVMHolderAction
    public void viewReadyNotify(PopRequest popRequest) {
    }
}
