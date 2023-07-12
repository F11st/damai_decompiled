package com.alibaba.poplayer.layermanager;

import android.app.Activity;
import com.alibaba.poplayer.R$id;
import com.alibaba.poplayer.layermanager.view.PopLayerViewContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import tb.fw2;

/* compiled from: Taobao */
/* renamed from: com.alibaba.poplayer.layermanager.f */
/* loaded from: classes8.dex */
public class C3663f implements ICVMHolderAction {
    private WeakReference<Activity> b;
    private C3660e d;
    private boolean c = false;
    private C3657b a = new C3657b(2);

    public C3663f(C3660e c3660e, Activity activity) {
        this.d = c3660e;
        this.b = new WeakReference<>(activity);
    }

    private void a() {
        Activity activity;
        if (this.c || (activity = (Activity) fw2.c(this.b)) == null) {
            return;
        }
        PopLayerViewContainer b = this.d.g.b(activity);
        b.setTag(R$id.layermanager_viewmodel_page_id, this);
        this.a.f(b.getCanvas());
        new WeakReference(b);
        this.c = true;
    }

    @Override // com.alibaba.poplayer.layermanager.ICVMHolderAction
    public void acceptRequests(ArrayList<PopRequest> arrayList) {
        a();
        this.a.a(arrayList);
    }

    @Override // com.alibaba.poplayer.layermanager.ICVMHolderAction
    public void attach(Activity activity) {
        if (C3660e.i && activity.isChild() && (activity.getParent() instanceof Activity)) {
            this.b = new WeakReference<>(activity);
        }
        this.c = false;
    }

    @Override // com.alibaba.poplayer.layermanager.ICVMHolderAction
    public void removeRequests(ArrayList<PopRequest> arrayList) {
        this.a.e(arrayList);
    }

    @Override // com.alibaba.poplayer.layermanager.ICVMHolderAction
    public void viewReadyNotify(PopRequest popRequest) {
        this.a.h(popRequest);
    }
}
