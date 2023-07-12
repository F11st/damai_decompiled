package com.alibaba.poplayer.layermanager;

import android.app.Activity;
import android.app.Application;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.layermanager.view.app.C3673a;
import java.util.ArrayList;

/* compiled from: Taobao */
/* renamed from: com.alibaba.poplayer.layermanager.a */
/* loaded from: classes8.dex */
public class C3656a implements ICVMHolderAction {
    private C3657b a = new C3657b(1);
    private C3673a b;

    public C3656a(Application application) {
        this.b = new C3673a(this.a, application);
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
