package tb;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.factory.view.base.PopLayerBaseView;
import com.alibaba.poplayer.layermanager.PopRequest;
import com.alibaba.poplayer.trigger.Event;
import com.alibaba.poplayer.trigger.app.AppConfigItem;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class d7 extends com.alibaba.poplayer.trigger.b<Event, AppConfigItem, p6> {
    public static final String APP_SCHEME = "poplayerapp://";
    private MutableContextWrapper i = new MutableContextWrapper(null);
    private ArrayList<t01<AppConfigItem>> j = new ArrayList<>();
    private b9 k;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class a {
        private static d7 a = new d7();
    }

    public static d7 A() {
        return a.a;
    }

    private void B(Event event) {
        this.i.setBaseContext((Context) fw2.c(this.e));
        this.b.b(-1);
        this.c.clear();
        this.c.add(event);
        F(event);
        C(event);
    }

    private void C(Event event) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uri", event.uri);
            jSONObject.put("param", event.param);
            Iterator<t01<AppConfigItem>> it = this.j.iterator();
            while (it.hasNext()) {
                t01<AppConfigItem> next = it.next();
                if (next.e() != null && (next.e() instanceof PopLayerBaseView)) {
                    ((PopLayerBaseView) next.e()).onReceiveEvent("PopLayer.AttachPageInfo", jSONObject.toString());
                }
            }
        } catch (Throwable th) {
            dt1.c("notifyPageInfo.error", th);
        }
    }

    private void F(Event event) {
        if (this.j.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<t01<AppConfigItem>> it = this.j.iterator();
        while (it.hasNext()) {
            t01<AppConfigItem> next = it.next();
            if (!g().y(next.r(), event)) {
                arrayList.add(next);
            }
        }
        dt1.b("requestsSurvivalSupervise.find dirty request size : %s.", Integer.valueOf(arrayList.size()));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            q((t01) it2.next());
        }
    }

    private Event y(String str, String str2, String str3) {
        String str4;
        Event event = new Event(1, str, str2, str3, 2);
        int indexOf = event.uri.indexOf(63);
        boolean z = -1 == indexOf;
        String substring = z ? event.uri : event.uri.substring(0, indexOf);
        int i = event.uri.startsWith(APP_SCHEME) ? 1 : 2;
        boolean z2 = i == event.source;
        if (z && z2) {
            str4 = str;
        } else {
            if (z2) {
                substring = event.uri;
            }
            str4 = str;
            event = new Event(2, substring, event.param, str3, i);
        }
        event.originUri = str4;
        return event;
    }

    private ArrayList<t01<AppConfigItem>> z(Event event, String str, String str2) {
        vw2<AppConfigItem> h;
        if (str2 != null && str != null) {
            h = ((p6) this.a).x(event, str, str2);
        } else {
            h = ((p6) this.a).h(event);
        }
        ArrayList<t01<AppConfigItem>> arrayList = new ArrayList<>();
        if (!h.a.isEmpty()) {
            Iterator<AppConfigItem> it = h.a.iterator();
            while (it.hasNext()) {
                arrayList.add(new t01<>(1, event, it.next(), null, this));
            }
        }
        if (2 == event.source && !h.b.isEmpty()) {
            this.b.c(event, h.b);
        }
        return arrayList;
    }

    public void D() {
        x(this.g, this.h);
    }

    public void E(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        t01<AppConfigItem> t01Var = null;
        Iterator<t01<AppConfigItem>> it = this.j.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            t01<AppConfigItem> next = it.next();
            if (str.equals(next.r().uuid) && next.r().autoClose) {
                t01Var = next;
                break;
            }
        }
        if (t01Var != null) {
            q(t01Var);
        }
    }

    @Override // com.alibaba.poplayer.trigger.b
    public void a(Event event) {
        ArrayList<t01<AppConfigItem>> z;
        if (event == null || (z = z(event, this.g, this.h)) == null || z.isEmpty()) {
            return;
        }
        t(this.f, z);
        Iterator<t01<AppConfigItem>> it = z.iterator();
        while (it.hasNext()) {
            t01<AppConfigItem> next = it.next();
            if (k(this.j, next)) {
                dt1.b("AppTrigger.drop exist request.{%s}", next.r().toString());
            } else {
                this.j.add(next);
                if (next.r().autoClose) {
                    this.k.a(next.r());
                }
            }
        }
    }

    @Override // com.alibaba.poplayer.trigger.b
    protected void j() {
        this.a = new p6(PopLayer.getReference().getConfigAdapter(1));
        this.b = new com.alibaba.poplayer.trigger.d(this);
        this.k = new b9(this);
        this.c = new ArrayList();
    }

    @Override // com.alibaba.poplayer.trigger.b
    protected boolean k(ArrayList<t01<AppConfigItem>> arrayList, t01<AppConfigItem> t01Var) {
        if (arrayList != null && !arrayList.isEmpty() && t01Var != null) {
            Iterator<t01<AppConfigItem>> it = arrayList.iterator();
            while (it.hasNext()) {
                t01<AppConfigItem> next = it.next();
                if (next.r().uuid.equals(t01Var.r().uuid) && next.i() != PopRequest.Status.REMOVED) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.alibaba.poplayer.trigger.b, com.alibaba.poplayer.layermanager.PopRequest.PopRequestStatusCallBack
    public void onReady(PopRequest popRequest) {
        PopLayerBaseView popLayerBaseView;
        if (popRequest instanceof t01) {
            t01 t01Var = (t01) popRequest;
            if (t01Var.e() == null) {
                popLayerBaseView = k81.b().a(this.i, t01Var.r().type);
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
                popLayerBaseView.init(this.i, t01Var);
            } catch (Throwable th) {
                dt1.c("PopLayerView init fail.", th);
            }
            com.alibaba.poplayer.layermanager.e.f().b(popRequest);
            try {
                popLayerBaseView.onViewAdded(this.i);
            } catch (Throwable th2) {
                dt1.c("PopLayerView onViewAdded fail.", th2);
            }
            try {
                PopLayer.getReference().onPopped(popRequest.b(), this.i, popRequest.e());
            } catch (Throwable th3) {
                dt1.c("PopLayerView onLayerPopped notify fail.", th3);
            }
            if (ip1.a(t01Var.r())) {
                ((PopLayerBaseView) t01Var.e()).displayMe();
            }
        }
    }

    @Override // com.alibaba.poplayer.trigger.b
    public void q(PopRequest popRequest) {
        r(popRequest, true, true);
        for (int i = 0; i < this.j.size(); i++) {
            if (this.j.get(i) == popRequest) {
                this.j.remove(i);
                return;
            }
        }
    }

    public void x(String str, String str2) {
        Event y = y(str, str2, this.f);
        if (y.source == 1) {
            this.c.add(y);
        } else {
            B(y);
        }
        a(y);
    }
}
