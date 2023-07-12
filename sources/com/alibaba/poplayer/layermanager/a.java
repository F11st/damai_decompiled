package com.alibaba.poplayer.layermanager;

import android.app.Activity;
import android.app.Application;
import com.alibaba.poplayer.PopLayer;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class a implements ICVMHolderAction {
    private b a = new b(1);
    private com.alibaba.poplayer.layermanager.view.app.a b;

    public a(Application application) {
        this.b = new com.alibaba.poplayer.layermanager.view.app.a(this.a, application);
    }

    @Override // com.alibaba.poplayer.layermanager.ICVMHolderAction
    public void acceptRequests(ArrayList<PopRequest> arrayList) {
        if (this.a.c() == 0) {
            this.b.h(PopLayer.getReference().internalGetCurrentActivity());
        }
        this.a.a(arrayList);
    }

    @Override // com.alibaba.poplayer.layermanager.ICVMHolderAction
    public void attach(Activity activity) {
        if (activity.isChild() && (activity.getParent() instanceof Activity)) {
            activity = activity.getParent();
        }
        this.b.i(activity);
    }

    @Override // com.alibaba.poplayer.layermanager.ICVMHolderAction
    public void removeRequests(ArrayList<PopRequest> arrayList) {
        this.a.e(arrayList);
        if (this.a.c() == 0) {
            this.b.f();
        }
    }

    @Override // com.alibaba.poplayer.layermanager.ICVMHolderAction
    public void viewReadyNotify(PopRequest popRequest) {
        this.a.h(popRequest);
    }
}
