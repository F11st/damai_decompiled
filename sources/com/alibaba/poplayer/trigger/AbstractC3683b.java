package com.alibaba.poplayer.trigger;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.factory.view.base.PopLayerBaseView;
import com.alibaba.poplayer.layermanager.C3660e;
import com.alibaba.poplayer.layermanager.PopRequest;
import com.alibaba.poplayer.trigger.AbstractC3680a;
import com.alibaba.poplayer.trigger.BaseConfigItem;
import com.alibaba.poplayer.trigger.Event;
import com.alibaba.poplayer.utils.Monitor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tb.dt1;
import tb.fw2;
import tb.ip1;
import tb.k81;
import tb.t01;

/* compiled from: Taobao */
@Monitor.TargetClass
/* renamed from: com.alibaba.poplayer.trigger.b */
/* loaded from: classes8.dex */
public abstract class AbstractC3683b<T extends Event, K extends BaseConfigItem, C extends AbstractC3680a> implements PopRequest.PopRequestStatusCallBack {
    @Monitor.TargetField
    public C a;
    public C3685d b;
    public List<T> c = new ArrayList();
    protected ConcurrentHashMap<String, ArrayList<t01<K>>> d = new ConcurrentHashMap<>();
    public WeakReference<Activity> e;
    public String f;
    public String g;
    public String h;

    public AbstractC3683b() {
        j();
    }

    private void e(ArrayList<PopRequest> arrayList) {
        Iterator<PopRequest> it = arrayList.iterator();
        while (it.hasNext()) {
            t01 t01Var = (t01) it.next();
            if (t01Var.e() != null && (t01Var.e() instanceof PopLayerBaseView)) {
                ((PopLayerBaseView) t01Var.e()).destroyView();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(T t);

    public boolean b(T t) {
        for (T t2 : this.c) {
            if (t.equals(t2)) {
                return true;
            }
        }
        return false;
    }

    public void c(boolean z, String str, boolean z2) {
        ArrayList<t01<K>> arrayList;
        if (TextUtils.isEmpty(str) || (arrayList = this.d.get(str)) == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<t01<K>> it = arrayList.iterator();
        ArrayList<PopRequest> arrayList2 = new ArrayList<>();
        while (it.hasNext()) {
            t01<K> next = it.next();
            if (PopRequest.Status.WAITTING != next.i() && PopRequest.Status.READY != next.i() && PopRequest.Status.REMOVED != next.i()) {
                if (!z2 && PopRequest.Status.SHOWING == next.i() && (z || !next.r().embed)) {
                    arrayList2.add(next);
                    it.remove();
                    dt1.b("[%s].remove {%s}. - remove showing but unEmbed . ", str, next.toString());
                }
            } else {
                it.remove();
                arrayList2.add(next);
                dt1.b("[%s][.remove {%s}. - remove waitting and ready . ", str, next.toString());
            }
        }
        if (arrayList2.size() > 0) {
            e(arrayList2);
            C3660e.f().h(arrayList2);
        }
    }

    public void d() {
        this.d.clear();
    }

    public void f(PopRequest popRequest) {
        PopLayerBaseView popLayerBaseView;
        if (popRequest instanceof t01) {
            t01 t01Var = (t01) popRequest;
            Activity a = popRequest.a();
            if (t01Var.e() == null) {
                popLayerBaseView = k81.b().a(a, t01Var.r().type);
                if (popLayerBaseView == null) {
                    dt1.b("createLayerAndAddRequest fail.Create layer Fail.", new Object[0]);
                    p(popRequest);
                    dt1.b("createLayerAndAddRequest fail.Removed.", new Object[0]);
                    return;
                }
                t01Var.n(popLayerBaseView);
                popLayerBaseView.setPopRequest(t01Var);
            } else {
                popLayerBaseView = (PopLayerBaseView) t01Var.e();
            }
            try {
                popLayerBaseView.init(a, t01Var);
            } catch (Throwable th) {
                dt1.c("PopLayerView init fail.", th);
            }
            C3660e.f().b(popRequest);
            try {
                popLayerBaseView.onViewAdded(a);
            } catch (Throwable th2) {
                dt1.c("PopLayerView onViewAdded fail.", th2);
            }
            try {
                PopLayer.getReference().onPopped(popRequest.b(), a, popRequest.e());
            } catch (Throwable th3) {
                dt1.c("PopLayerView onLayerPopped notify fail.", th3);
            }
            if (ip1.a(t01Var.r())) {
                ((PopLayerBaseView) t01Var.e()).displayMe();
            }
        }
    }

    public C g() {
        return this.a;
    }

    public Activity h() {
        return (Activity) fw2.c(this.e);
    }

    public ArrayList<t01<K>> i(String str) {
        return this.d.get(str);
    }

    protected abstract void j();

    protected boolean k(ArrayList<t01<K>> arrayList, t01<K> t01Var) {
        if (arrayList != null && !arrayList.isEmpty() && t01Var != null) {
            Iterator<t01<K>> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().r().uuid.equals(t01Var.r().uuid)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void l(Activity activity) {
        ArrayList<t01<K>> i = i(InternalTriggerController.b(activity));
        if (i == null || i.isEmpty()) {
            return;
        }
        for (t01<K> t01Var : i) {
            if (t01Var != null) {
                try {
                    if (t01Var.i() == PopRequest.Status.SHOWING && t01Var.e() != null && (t01Var.e() instanceof PopLayerBaseView)) {
                        ((PopLayerBaseView) t01Var.e()).onActivityPaused();
                    }
                } catch (Throwable th) {
                    dt1.c("notifyShowingViewsOnActivityPaused error", th);
                }
            }
        }
    }

    public void m(Activity activity) {
        ArrayList<t01<K>> i = i(InternalTriggerController.b(activity));
        if (i == null || i.isEmpty()) {
            return;
        }
        for (t01<K> t01Var : i) {
            if (t01Var != null) {
                try {
                    if (t01Var.i() == PopRequest.Status.SHOWING && t01Var.e() != null && (t01Var.e() instanceof PopLayerBaseView)) {
                        ((PopLayerBaseView) t01Var.e()).onActivityResumed();
                    }
                } catch (Throwable th) {
                    dt1.c("notifyShowingViewsOnActivityResumed error", th);
                }
            }
        }
    }

    public void n(Activity activity, String str) {
    }

    public void o() {
        dt1.b("%s: activity resue,resume all event.", getClass().getSimpleName());
        for (T t : this.c) {
            a(t);
        }
    }

    @Override // com.alibaba.poplayer.layermanager.PopRequest.PopRequestStatusCallBack
    public void onForceRemoved(PopRequest popRequest) {
        p(popRequest);
    }

    @Override // com.alibaba.poplayer.layermanager.PopRequest.PopRequestStatusCallBack
    public void onReady(PopRequest popRequest) {
        if (popRequest instanceof t01) {
            f(popRequest);
        }
    }

    @Override // com.alibaba.poplayer.layermanager.PopRequest.PopRequestStatusCallBack
    public void onRecovered(PopRequest popRequest) {
    }

    @Override // com.alibaba.poplayer.layermanager.PopRequest.PopRequestStatusCallBack
    public void onSuspended(PopRequest popRequest) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(PopRequest popRequest) {
        for (String str : this.d.keySet()) {
            ArrayList<t01<K>> arrayList = this.d.get(str);
            if (arrayList != null && !arrayList.isEmpty() && arrayList.contains(popRequest)) {
                arrayList.remove(popRequest);
                dt1.b("[%s].remove {%s}. - active close. ", this.f, popRequest.toString());
                return;
            }
        }
    }

    public void q(PopRequest popRequest) {
        r(popRequest, true, false);
    }

    public void r(PopRequest popRequest, boolean z, boolean z2) {
        if (z && popRequest.e() != null && (popRequest.e() instanceof PopLayerBaseView)) {
            ((PopLayerBaseView) popRequest.e()).destroyView();
        }
        C3660e.f().g(popRequest);
        if (popRequest.e() instanceof PopLayerBaseView) {
            PopLayerBaseView popLayerBaseView = (PopLayerBaseView) popRequest.e();
            popLayerBaseView.onViewRemoved(popLayerBaseView.getContext());
        }
        if (z2) {
            p(popRequest);
        }
    }

    public void s() {
        this.b.b(-1);
        dt1.b("%s: activity pause,stop all timer.", getClass().getSimpleName());
    }

    public void t(String str, ArrayList<t01<K>> arrayList) {
        ArrayList<t01<K>> tryOpenRequestControl = PopLayer.getReference().tryOpenRequestControl(arrayList);
        if (tryOpenRequestControl == null || tryOpenRequestControl.isEmpty()) {
            return;
        }
        ArrayList<t01<K>> arrayList2 = this.d.get(str);
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            ArrayList<? extends PopRequest> arrayList3 = new ArrayList<>();
            for (int i = 0; i < tryOpenRequestControl.size(); i++) {
                t01<K> t01Var = tryOpenRequestControl.get(i);
                Event s = t01Var.s();
                boolean z = s != null && s.source == 2;
                dt1.b("tryOpenRequest.pageSwitchType:{%s}.", Boolean.valueOf(z));
                boolean k = k(arrayList2, t01Var);
                dt1.b("tryOpenRequest.isPopRequestContains:{%s}.", Boolean.valueOf(k));
                if (!z || !k) {
                    if (t01Var.i() != PopRequest.Status.SHOWING) {
                        arrayList3.add(t01Var);
                    }
                    arrayList2.add(t01Var);
                }
            }
            if (arrayList3.isEmpty()) {
                return;
            }
            C3660e.f().m(arrayList3);
            return;
        }
        this.d.put(str, tryOpenRequestControl);
        C3660e.f().m(tryOpenRequestControl);
    }

    public void u(Activity activity, String str, String str2, String str3) {
        this.e = new WeakReference<>(activity);
        this.g = str;
        this.h = str2;
        this.f = str3;
    }

    public void v(boolean z, Context context) {
        this.a.w(z, context);
    }

    public void w() {
        c(false, this.f, true);
        if (this.c.isEmpty()) {
            return;
        }
        for (T t : this.c) {
            a(t);
        }
    }
}
