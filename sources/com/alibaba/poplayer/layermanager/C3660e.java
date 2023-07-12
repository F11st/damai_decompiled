package com.alibaba.poplayer.layermanager;

import android.app.Activity;
import android.app.Application;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.annotation.IdRes;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.R$id;
import com.alibaba.poplayer.exception.PoplayerException;
import com.alibaba.poplayer.layermanager.PopRequest;
import com.alibaba.poplayer.layermanager.config.ConfigItem;
import com.alibaba.poplayer.layermanager.view.PopLayerViewContainer;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import tb.C9556pm;
import tb.dt1;
import tb.fw2;
import tb.sc;
import tb.yv0;

/* compiled from: Taobao */
/* renamed from: com.alibaba.poplayer.layermanager.e */
/* loaded from: classes8.dex */
public class C3660e {
    public static final String TAG = "e";
    public static boolean i;
    private static C3660e j;
    private C9556pm a;
    private ILayerMgrAdapter b;
    private WeakReference<Activity> c;
    private sc d;
    private ICVMHolderAction e;
    C3661a g = new C3661a();
    C3662b h = new C3662b();
    private ArrayList<PopRequest> f = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayer.layermanager.e$a */
    /* loaded from: classes8.dex */
    public class C3661a {
        C3661a() {
        }

        ICVMHolderAction a(PopRequest popRequest) {
            Activity a = popRequest.a();
            if (popRequest.b() == 1) {
                return C3660e.this.e;
            }
            if (popRequest.b() == 2) {
                if (a == null) {
                    return null;
                }
                return C3660e.this.g.e(popRequest.a());
            } else if (popRequest.b() == 3) {
                if (popRequest.d() != null) {
                    if (a == null) {
                        return null;
                    }
                    return C3660e.this.g.f(popRequest.a());
                }
                throw new PoplayerException("This request not has HostView but Domain is VIEW.");
            } else {
                throw new PoplayerException("UNKNOW Domain.");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public PopLayerViewContainer b(Activity activity) {
            Window window;
            PopLayerViewContainer c = C3660e.this.g.c(activity);
            if (c != null) {
                return c;
            }
            if (C3660e.i && activity.isChild() && (activity.getParent() instanceof Activity)) {
                activity = activity.getParent();
            }
            PopLayerViewContainer popLayerViewContainer = new PopLayerViewContainer(activity);
            popLayerViewContainer.setId(R$id.layermanager_penetrate_webview_container_id);
            popLayerViewContainer.setVisibility(0);
            if (C3660e.i && activity.isChild() && (activity.getParent() instanceof Activity)) {
                window = activity.getParent().getWindow();
            } else {
                window = activity.getWindow();
            }
            window.addContentView(popLayerViewContainer, new LinearLayout.LayoutParams(-1, -1));
            popLayerViewContainer.bringToFront();
            return popLayerViewContainer;
        }

        PopLayerViewContainer c(Activity activity) {
            if (C3660e.i && activity.isChild() && (activity.getParent() instanceof Activity)) {
                activity = activity.getParent();
            }
            return (PopLayerViewContainer) activity.getWindow().findViewById(R$id.layermanager_penetrate_webview_container_id);
        }

        View d(Activity activity) {
            if (C3660e.i && activity.isChild() && (activity.getParent() instanceof Activity)) {
                activity = activity.getParent();
            }
            return activity.getWindow().findViewById(16908290);
        }

        C3663f e(Activity activity) {
            Object tag;
            View d = d(activity);
            if (d == null || (tag = d.getTag(R$id.layermanager_viewmodel_page_id)) == null) {
                return null;
            }
            return (C3663f) tag;
        }

        C3664g f(Activity activity) {
            Object tag;
            View d = d(activity);
            if (d == null || (tag = d.getTag(R$id.layermanager_viewmodel_view_id)) == null) {
                return null;
            }
            return (C3664g) tag;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayer.layermanager.e$b */
    /* loaded from: classes8.dex */
    public class C3662b {
        C3662b() {
        }

        public void a(Activity activity, ICVMHolderAction iCVMHolderAction, @IdRes int i) {
            C3660e.this.g.d(activity).setTag(i, iCVMHolderAction);
        }
    }

    public C3660e(ILayerMgrAdapter iLayerMgrAdapter) {
        this.b = iLayerMgrAdapter;
        this.a = new C9556pm(this.b);
    }

    private Activity c() {
        return (Activity) fw2.c(this.c);
    }

    public static C3660e f() {
        return j;
    }

    private yv0<ICVMHolderAction, PopRequest> i(ArrayList<? extends PopRequest> arrayList) throws PoplayerException {
        yv0<ICVMHolderAction, PopRequest> yv0Var = new yv0<>();
        Iterator<? extends PopRequest> it = arrayList.iterator();
        while (it.hasNext()) {
            PopRequest next = it.next();
            if (!this.f.isEmpty() && this.f.contains(next)) {
                this.f.remove(next);
            } else if (next.i() == PopRequest.Status.REMOVED) {
                dt1.b("%s.removeAdjustRequests=> but status = remove", toString());
            } else if (next.h() == null || !(next.h() instanceof C3658c)) {
                dt1.b("%s.removeAdjustRequests=> but popParam is empty or but InnerPopParam", toString());
            } else {
                ICVMHolderAction a = this.g.a(next);
                if (a == null) {
                    dt1.b("%s.removeAdjustRequests=> find canvas view model fail.", toString());
                } else {
                    yv0Var.c(a, next);
                }
            }
        }
        return yv0Var;
    }

    private void j(Activity activity) {
        if (this.e == null) {
            this.e = new C3656a(activity.getApplication());
        }
        this.e.attach(activity);
        C3663f e = this.g.e(activity);
        Object[] objArr = new Object[2];
        String str = TAG;
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(e != null);
        dt1.b("%s.resetViewModels: find pageVM : %s.", objArr);
        if (e == null) {
            e = new C3663f(this, activity);
            this.h.a(activity, e, R$id.layermanager_viewmodel_page_id);
        }
        e.attach(activity);
        C3664g f = this.g.f(activity);
        Object[] objArr2 = new Object[2];
        objArr2[0] = str;
        objArr2[1] = Boolean.valueOf(f != null);
        dt1.b("%s.resetViewModels: find viewsVM : %s.", objArr2);
        if (f == null) {
            f = new C3664g(this, activity);
            this.h.a(activity, f, R$id.layermanager_viewmodel_view_id);
        }
        f.attach(activity);
    }

    private yv0<ICVMHolderAction, PopRequest> l(ArrayList<? extends PopRequest> arrayList) throws PoplayerException {
        ConfigItem configItem;
        yv0<ICVMHolderAction, PopRequest> yv0Var = new yv0<>();
        Iterator<? extends PopRequest> it = arrayList.iterator();
        while (it.hasNext()) {
            PopRequest next = it.next();
            PopRequest.Status i2 = next.i();
            PopRequest.Status status = PopRequest.Status.WAITTING;
            if (i2 == status || next.i() == PopRequest.Status.REMOVED) {
                sc scVar = this.d;
                if (scVar == null || (configItem = scVar.a(next.f())) == null) {
                    dt1.b("%s.tryAdjustRequests.not find ConfigRule,use default.", TAG);
                    configItem = new ConfigItem();
                }
                ICVMHolderAction a = this.g.a(next);
                if (a == null) {
                    dt1.b("%s.tryAdjustRequests=> find canvas view model fail.", toString());
                } else {
                    if (!(next.h() instanceof C3658c)) {
                        next.p(new C3658c(next.h(), configItem));
                    }
                    next.q(status);
                    yv0Var.c(a, next);
                }
            } else {
                dt1.b("%s.tryAdjustRequests=> add but status not in (waitting or removed)", toString());
            }
        }
        return yv0Var;
    }

    public void b(PopRequest popRequest) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (popRequest.i() == PopRequest.Status.WAITTING || popRequest.i() == PopRequest.Status.REMOVED) {
                dt1.b("%s.viewReadyNotify=> add but status = waitting or removed.", toString());
                return;
            } else if (!(popRequest.h() instanceof C3658c)) {
                dt1.b("%s.viewReadyNotify=> add but popParam not InnerPopParam", toString());
                return;
            } else if (popRequest.e() == null) {
                dt1.b("%s.viewReadyNotify=>layer is empty.", toString());
                return;
            } else {
                this.g.a(popRequest).viewReadyNotify(popRequest);
                return;
            }
        }
        throw new PoplayerException("Please execute on UI Thread.");
    }

    public PopLayerViewContainer d() {
        return this.g.c((Activity) fw2.c(this.c));
    }

    public void e(Application application) {
        if (j == null) {
            j = this;
        }
        this.b.initializeConfigContainer(this);
        this.b.addConfigObserver(this);
        n();
    }

    public void g(PopRequest popRequest) {
        if (popRequest == null) {
            return;
        }
        ArrayList<PopRequest> arrayList = new ArrayList<>();
        arrayList.add(popRequest);
        h(arrayList);
    }

    public void h(ArrayList<PopRequest> arrayList) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            yv0<ICVMHolderAction, PopRequest> i2 = i(arrayList);
            for (ICVMHolderAction iCVMHolderAction : i2.b().keySet()) {
                iCVMHolderAction.removeRequests(i2.a(iCVMHolderAction));
            }
            return;
        }
        throw new PoplayerException("Please execute on UI Thread.");
    }

    public void k(Activity activity, String str) {
        if (PopLayer.getReference().isSamePage(activity, c())) {
            dt1.b("%s.touchActivity.is same page.", TAG);
            return;
        }
        j(activity);
        this.c = new WeakReference<>(activity);
        dt1.b("%s.currentActivity is: %s.", TAG, activity.getClass().getName());
        o();
    }

    public void m(ArrayList<? extends PopRequest> arrayList) throws PoplayerException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (!this.a.c()) {
                dt1.b("%s.tryOpen,but LayerMgr`configs not ready.Saving", TAG);
                this.f.addAll(arrayList);
                return;
            }
            yv0<ICVMHolderAction, PopRequest> l = l(arrayList);
            for (ICVMHolderAction iCVMHolderAction : l.b().keySet()) {
                iCVMHolderAction.acceptRequests(l.a(iCVMHolderAction));
            }
            return;
        }
        throw new PoplayerException("Please execute on UI Thread.");
    }

    public void n() {
        this.a.e();
    }

    public void o() {
        if (c() != null) {
            sc b = this.a.b(c().getClass().getName());
            this.d = b;
            Object[] objArr = new Object[2];
            objArr[0] = TAG;
            objArr[1] = b == null ? DXRecyclerLayout.LOAD_MORE_EMPTY : b.toString();
            dt1.b("%s.update BizConfig: %s.", objArr);
        } else {
            dt1.b("%s.currentActivity is empty.updateBizConfig fail.", TAG);
        }
        if (this.f.isEmpty()) {
            return;
        }
        dt1.b("%s.config update. deal waitting list ,size:{%s}.", TAG, Integer.valueOf(this.f.size()));
        m(this.f);
        this.f.clear();
    }
}
