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
/* renamed from: com.alibaba.poplayer.layermanager.g */
/* loaded from: classes8.dex */
public class C3664g implements ICVMHolderAction {
    private WeakReference<Activity> a;
    private C3660e c;
    private WeakReference<SandoContainer> d;
    private boolean e = false;
    private HashMap<View, C3657b> b = new HashMap<>();

    public C3664g(C3660e c3660e, Activity activity) {
        this.c = c3660e;
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
                    C3657b c3657b = this.b.get(d);
                    if (c3657b != null && c3657b.d() == null) {
                        this.b.remove(d);
                        c3657b = null;
                    }
                    if (c3657b == null) {
                        c3657b = new C3657b(3);
                        c3657b.f(new Canvas(activity));
                        this.b.put(d, c3657b);
                    }
                    ArrayList<PopRequest> arrayList2 = new ArrayList<>();
                    arrayList2.add(next);
                    c3657b.a(arrayList2);
                    sandoContainer.getAugmentedLayer().augmentTargetView(next.d(), c3657b.d());
                    dt1.b("ViewCVMHolder.add new Canvas", new Object[0]);
                }
            }
        }
    }

    @Override // com.alibaba.poplayer.layermanager.ICVMHolderAction
    public void attach(Activity activity) {
        if (C3660e.i && activity.isChild() && (activity.getParent() instanceof Activity)) {
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
                    C3657b c3657b = this.b.get(d);
                    if (c3657b != null && c3657b.d() != null) {
                        ArrayList<PopRequest> arrayList2 = new ArrayList<>();
                        arrayList2.add(next);
                        c3657b.e(arrayList2);
                        if (c3657b.c() == 0) {
                            sandoContainer.getAugmentedLayer().unaugmentTarget(c3657b.d());
                            c3657b.f(null);
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
