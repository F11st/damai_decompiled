package com.alibaba.poplayer.trigger.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.R$id;
import com.alibaba.poplayer.factory.view.base.PopLayerBaseView;
import com.alibaba.poplayer.layermanager.PopRequest;
import com.alibaba.poplayer.trigger.InternalTriggerController;
import com.alibaba.poplayer.trigger.view.TrackingService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import tb.dt1;
import tb.fw2;
import tb.t01;
import tb.vw2;
import tb.xx2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class d extends com.alibaba.poplayer.trigger.b<ViewEvent, ViewConfigItem, xx2> {
    public static final String TAG = "d";
    public static final String VIEW_SCHEME = "poplayerview://";
    private ArrayList<t01<ViewConfigItem>> i = new ArrayList<>();
    private TrackingService.OnSTaskInvokeListener j = new a();

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    class a implements TrackingService.OnSTaskInvokeListener {
        a() {
        }

        @Override // com.alibaba.poplayer.trigger.view.TrackingService.OnSTaskInvokeListener
        public void OnTargetViewAdded(View view, TrackingService.i iVar) {
            t01 t01Var;
            d dVar = d.this;
            ArrayList H = dVar.H(dVar.i, view);
            if (H != null && !H.isEmpty()) {
                Iterator it = H.iterator();
                while (it.hasNext()) {
                    t01Var = (t01) it.next();
                    if (t01Var.s() == iVar.i && t01Var.r() == iVar.j) {
                        break;
                    }
                }
            }
            t01Var = null;
            if (t01Var != null) {
                dt1.b("OnSTaskInvokeListener.find from cache:{%s}.", t01Var.toString());
                d.this.i.remove(t01Var);
            } else {
                t01Var = d.this.G(iVar.i, iVar.j, view);
                t01Var.l(new b(d.this, iVar.m, iVar.f, iVar.c, iVar));
                t01Var.o(iVar.l);
                dt1.b("OnSTaskInvokeListener.create new one:{%s}.", t01Var.toString());
            }
            t01Var.q(PopRequest.Status.WAITTING);
            ArrayList arrayList = new ArrayList();
            arrayList.add(t01Var);
            d dVar2 = d.this;
            dVar2.t(dVar2.f, arrayList);
        }

        @Override // com.alibaba.poplayer.trigger.view.TrackingService.OnSTaskInvokeListener
        public void OnTargetViewRemoved(View view, TrackingService.i iVar, boolean z) {
            d dVar = d.this;
            ArrayList H = dVar.H(dVar.i(dVar.f), view);
            if (H != null && !H.isEmpty()) {
                if (!z) {
                    d.this.i.addAll(H);
                }
                Iterator it = H.iterator();
                while (it.hasNext()) {
                    t01 t01Var = (t01) it.next();
                    Object c = t01Var.c();
                    if (c != null && (c instanceof b) && fw2.c(((b) c).d) == iVar) {
                        d.this.r(t01Var, z, true);
                    }
                }
            }
            dt1.b("OnSTaskInvokeListener.remove:{%s}.", view.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class b {
        final String a;
        final String b;
        final String c;
        final WeakReference<TrackingService.i> d;

        public b(d dVar, String str, String str2, String str3, TrackingService.i iVar) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = new WeakReference<>(iVar);
        }

        public String toString() {
            return "ReqTag{groupId='" + this.a + "', operationName='" + this.b + "', params='" + this.c + "'}";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class c {
        private static d a = new d();
    }

    private void F(Activity activity, ViewEvent viewEvent, @NonNull ArrayList<ViewConfigItem> arrayList) {
        if (arrayList.size() == 0) {
            return;
        }
        Iterator<ViewConfigItem> it = arrayList.iterator();
        while (it.hasNext()) {
            ViewConfigItem next = it.next();
            E(activity, viewEvent, next, (View) fw2.c(viewEvent.getHostView()), next.viewuri, "pageLauncher");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public t01 G(ViewEvent viewEvent, ViewConfigItem viewConfigItem, View view) {
        t01 t01Var = new t01(3, viewEvent, viewConfigItem, (Activity) view.getContext(), this);
        t01Var.k((Activity) view.getContext());
        t01Var.m(view);
        return t01Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<t01<ViewConfigItem>> H(ArrayList<t01<ViewConfigItem>> arrayList, View view) {
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        ArrayList<t01<ViewConfigItem>> arrayList2 = new ArrayList<>();
        Iterator<t01<ViewConfigItem>> it = arrayList.iterator();
        while (it.hasNext()) {
            t01<ViewConfigItem> next = it.next();
            if (next.d() == view) {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    public static d M() {
        return c.a;
    }

    public void C(String str, String str2) {
        TrackingService L;
        ViewEvent createViewEvent = ViewEvent.createViewEvent(str, str2, this.f);
        if (2 == createViewEvent.source) {
            this.c.clear();
            if (h() != null && (L = L(h())) != null) {
                L.q();
            }
        }
        a(createViewEvent);
    }

    void D(Activity activity, TrackingService trackingService) {
        InternalTriggerController.a(activity).setTag(R$id.poplayer_trigger_tracking_service_id, trackingService);
    }

    public TrackingService.i E(Activity activity, ViewEvent viewEvent, ViewConfigItem viewConfigItem, View view, String str, String str2) {
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            return J(activity).o(str2, view, viewConfigItem.viewuri, str, viewConfigItem.params, viewConfigItem.selectFromCache, viewConfigItem.continuousSelect, viewConfigItem.operationName, viewEvent, viewConfigItem, this.j, true);
        } catch (Throwable th2) {
            th = th2;
            dt1.c("createSelectTask.error", th);
            return null;
        }
    }

    public String I(PopRequest popRequest, String str) {
        Object c2;
        if (popRequest != null && (c2 = popRequest.c()) != null && (c2 instanceof b)) {
            b bVar = (b) c2;
            if ("groupId".equals(str)) {
                return bVar.a;
            }
            if (PopLayer.ACTION_TRACK_INFO_KEY_OPERATION_NAME.equals(str)) {
                return bVar.b;
            }
        }
        return null;
    }

    TrackingService J(Activity activity) {
        TrackingService L = L(activity);
        if (L == null) {
            TrackingService trackingService = new TrackingService(activity);
            D(activity, trackingService);
            return trackingService;
        }
        return L;
    }

    public ArrayList<PopRequest> K(PopLayerBaseView popLayerBaseView, String str, String str2) {
        Object c2;
        ArrayList<t01<ViewConfigItem>> i = i(str2);
        ArrayList<PopRequest> arrayList = new ArrayList<>();
        if (i != null && i.size() != 0) {
            Iterator<t01<ViewConfigItem>> it = i.iterator();
            while (it.hasNext()) {
                t01<ViewConfigItem> next = it.next();
                if (next.g() != null && next.g() == popLayerBaseView && (c2 = next.c()) != null && (c2 instanceof b)) {
                    b bVar = (b) c2;
                    if (!TextUtils.isEmpty(bVar.a) && bVar.a.equals(str)) {
                        arrayList.add(next);
                    }
                }
            }
        }
        return arrayList;
    }

    TrackingService L(Activity activity) {
        Object tag = InternalTriggerController.a(activity).getTag(R$id.poplayer_trigger_tracking_service_id);
        if (tag == null) {
            return null;
        }
        return (TrackingService) tag;
    }

    public void N(Activity activity, View view, String str, String str2, ViewConfigItem viewConfigItem, String str3) {
        if (activity == null) {
            dt1.b("managerTask.fail:opreateActivity == null", new Object[0]);
        } else {
            J(activity).k(view, str, str2, viewConfigItem, str3);
        }
    }

    public void O() {
        C(this.g, this.h);
    }

    public void P(String str, View view) {
        if (view == null) {
            dt1.b("removeMsg.fail:hostView == null", new Object[0]);
        } else {
            N((Activity) view.getContext(), view, str, TrackingService.TASK_OPER_REMOVE_ACTIVE_LAUNCHED, null, null);
        }
    }

    @Override // com.alibaba.poplayer.trigger.b
    protected void j() {
        this.a = new xx2(PopLayer.getReference(), PopLayer.getReference().getConfigAdapter(3));
        this.b = new com.alibaba.poplayer.trigger.d(this);
    }

    @Override // com.alibaba.poplayer.trigger.b
    protected boolean k(ArrayList<t01<ViewConfigItem>> arrayList, t01<ViewConfigItem> t01Var) {
        if (arrayList != null && !arrayList.isEmpty() && t01Var != null) {
            Iterator<t01<ViewConfigItem>> it = arrayList.iterator();
            while (it.hasNext()) {
                t01<ViewConfigItem> next = it.next();
                if (next.r().viewuri.equals(t01Var.r().viewuri) && next.d() == t01Var.d()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.alibaba.poplayer.trigger.b
    public void n(Activity activity, String str) {
        TrackingService L = L(activity);
        if (L != null) {
            L.j();
        }
        this.i.clear();
        this.b.b(-1);
        c(false, str, false);
    }

    @Override // com.alibaba.poplayer.trigger.b
    public void q(PopRequest popRequest) {
        if (popRequest instanceof t01) {
            t01 t01Var = (t01) popRequest;
            L(t01Var.a()).k(null, null, TrackingService.TASK_OPER_REMOVE_ALL, (ViewConfigItem) t01Var.r(), null);
            return;
        }
        r(popRequest, true, true);
    }

    @Override // com.alibaba.poplayer.trigger.b
    public void v(boolean z, Context context) {
        ((xx2) this.a).w(z, context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.poplayer.trigger.b
    /* renamed from: x */
    public void a(ViewEvent viewEvent) {
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        sb.append(str);
        sb.append(" create Event:{%s}.");
        dt1.b(sb.toString(), viewEvent.toString());
        if (TextUtils.isEmpty(viewEvent.attachActivityKeyCode) || !viewEvent.attachActivityKeyCode.equals(this.f)) {
            dt1.b("%s activeAccept Useless event,eventKeyCode:%s,curKeyCode:%s.", str, viewEvent.attachActivityKeyCode, this.f);
            return;
        }
        if (!b(viewEvent)) {
            this.c.add(viewEvent);
        }
        new ArrayList().add(viewEvent);
        vw2<ViewConfigItem> g = ((xx2) this.a).g(viewEvent);
        new ArrayList().add(g);
        F(h(), viewEvent, g.a);
        if (2 != viewEvent.source || g.b.isEmpty()) {
            return;
        }
        this.b.c(viewEvent, g.b);
    }

    public void y(View view, String str, Map<String, String> map) {
        if (!str.startsWith(VIEW_SCHEME)) {
            dt1.b("%s.activeAccept fail,uri{%s} must startsWith{%s} error", TAG, str, VIEW_SCHEME);
        } else if (view.getContext() == null) {
            dt1.b("%s.activeAccept fail,uri{%s},attachActivity is empty.", TAG, str);
        } else {
            Activity activity = (Activity) view.getContext();
            ViewEvent createViewEvent = ViewEvent.createViewEvent(str, map == null ? null : map.toString(), InternalTriggerController.b(activity));
            createViewEvent.setHostView(new WeakReference<>(view));
            F(activity, createViewEvent, ((xx2) this.a).y(createViewEvent, map).a);
        }
    }
}
