package tb;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.android.ultron.trade.event.base.ISubscriber;
import com.alibaba.android.ultron.trade.presenter.IPresenter;
import com.alibaba.android.ultron.vfw.event.OnDynamicEventListener;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.common.model.IDMEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class op2 implements OnDynamicEventListener {
    public static final String KEY_COMPONENT = "component";
    public static final String KEY_EXTRA_PARAMS = "extraParams";
    public static final String KEY_VIEW = "view";
    public static final String KEY_VIEW_PARAMS = "viewParams";
    private Context a;
    private IPresenter b;
    private np2 c;
    private boolean d = false;
    private Map<String, List<ISubscriber>> e = new HashMap();
    private IDMComponent f;
    private String g;

    public op2(IPresenter iPresenter) {
        if (iPresenter != null) {
            this.b = iPresenter;
            this.a = iPresenter.getContext();
            return;
        }
        throw new IllegalArgumentException("presenter can not be null");
    }

    private void c(IDMComponent iDMComponent) {
        Map<String, List<IDMEvent>> eventMap;
        if (iDMComponent == null || (eventMap = iDMComponent.getEventMap()) == null) {
            return;
        }
        IDMEvent iDMEvent = null;
        for (IDMEvent iDMEvent2 : eventMap.get(this.g)) {
            if (iDMEvent2 != null && "autoJumpOpenUrl".equals(iDMEvent2.getType())) {
                iDMEvent = iDMEvent2;
            }
        }
        if (iDMEvent == null) {
            return;
        }
        np2 i = d().l("autoJumpOpenUrl").m("autoJump", "true").k(iDMEvent).i(iDMComponent);
        i.p(this.g);
        h(i);
        this.f = null;
        this.g = null;
    }

    private List<ISubscriber> j(String str) {
        List<ISubscriber> list = this.e.get(str);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            this.e.put(str, arrayList);
            return arrayList;
        }
        return list;
    }

    public void a(String str, ISubscriber iSubscriber) {
        if (str == null || iSubscriber == null) {
            return;
        }
        List<ISubscriber> j = j(str);
        if (j.contains(iSubscriber)) {
            return;
        }
        j.add(iSubscriber);
    }

    public void b(Map<String, ISubscriber> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, ISubscriber> entry : map.entrySet()) {
            if (entry != null) {
                a(entry.getKey(), entry.getValue());
            }
        }
    }

    public np2 d() {
        return new np2().j(this.a).n(this.b);
    }

    public void e(lp2 lp2Var) {
        if (this.f == null || this.g == null || lp2Var == null || lp2Var.a() == null) {
            return;
        }
        for (IDMComponent iDMComponent : lp2Var.a()) {
            if (iDMComponent != null && iDMComponent.getKey() != null && iDMComponent.getKey().equals(this.f.getKey())) {
                c(iDMComponent);
                return;
            }
        }
    }

    public void f() {
        this.d = true;
        this.a = null;
        Map<String, List<ISubscriber>> map = this.e;
        if (map != null) {
            map.clear();
        }
    }

    public void g() {
        this.c = null;
    }

    public void h(np2 np2Var) {
        String d = np2Var.d();
        if (d == null || this.d) {
            return;
        }
        List<ISubscriber> list = this.e.get(d);
        if (list == null) {
            vt2.b("TradeEventHandler", "事件未找到", d);
            return;
        }
        for (ISubscriber iSubscriber : list) {
            if (iSubscriber != null) {
                iSubscriber.handleEvent(np2Var);
            }
        }
    }

    public np2 i() {
        return this.c;
    }

    public void k(int i, int i2, Intent intent) {
        np2 np2Var = this.c;
        if (np2Var != null && "openUrl".equalsIgnoreCase(np2Var.d())) {
            h(d().l("openUrlResult").i(np2Var.a()).m(fn1.KEY_REQUEST_CODE, Integer.valueOf(i)).m(fn1.KEY_RESULT_CODE, Integer.valueOf(i2)).m(fn1.KEY_RESULT_DATA, intent).m(fn1.KEY_OPEN_URL_EVENT, np2Var));
        } else if (np2Var != null && "autoJumpOpenUrl".equalsIgnoreCase(np2Var.d())) {
            h(d().l("autoJumpOpenUrlResult").i(np2Var.a()).m(fn1.KEY_REQUEST_CODE, Integer.valueOf(i)).m(fn1.KEY_RESULT_CODE, Integer.valueOf(i2)).m(fn1.KEY_RESULT_DATA, intent).m(fn1.KEY_OPEN_URL_EVENT, np2Var));
        }
        g();
    }

    public void l(String str, ISubscriber iSubscriber) {
        if (str == null || iSubscriber == null) {
            return;
        }
        List<ISubscriber> j = j(str);
        j.clear();
        j.add(iSubscriber);
    }

    public void m(IDMComponent iDMComponent, String str) {
        this.f = iDMComponent;
        this.g = str;
    }

    public void n(np2 np2Var) {
        this.c = np2Var;
    }

    @Override // com.alibaba.android.ultron.vfw.event.OnDynamicEventListener
    public void onReceiveEvent(View view, String str, Object obj, Object obj2, Object obj3, ArrayList arrayList) {
        Object obj4;
        if (obj instanceof List) {
            List list = (List) obj;
            if (!list.isEmpty()) {
                obj4 = list.get(0);
                if ((obj4 instanceof String) || !(obj3 instanceof Map) || view == null) {
                    return;
                }
                Object obj5 = ((Map) obj3).get(n90.TAG_DINAMICX_VIEW_COMPONENT);
                if (!(obj5 instanceof IDMComponent)) {
                    vt2.b("TradeEventHandler", "eventmap is null");
                    return;
                }
                IDMComponent iDMComponent = (IDMComponent) obj5;
                int status = iDMComponent.getStatus();
                vt2.b("TradeEventHandler", "onReceiveEvent", "component", iDMComponent.getType(), iDMComponent.getTag(), "status:", String.valueOf(status));
                List<IDMEvent> list2 = iDMComponent.getEventMap() != null ? iDMComponent.getEventMap().get((String) obj4) : null;
                if (status == 1) {
                    return;
                }
                if (list2 == null) {
                    vt2.b("TradeEventHandler", "send event directly: ", String.valueOf(obj4));
                    np2 l = d().l(String.valueOf(obj4));
                    l.m(KEY_VIEW_PARAMS, arrayList);
                    l.m(KEY_EXTRA_PARAMS, obj);
                    l.i(iDMComponent);
                    l.p((String) obj4);
                    l.k(null);
                    h(l);
                    return;
                }
                for (int i = 0; i < list2.size(); i++) {
                    IDMEvent iDMEvent = list2.get(i);
                    if (iDMEvent != null) {
                        String type = iDMEvent.getType();
                        vt2.b("TradeEventHandler", "onReceiveEvent", "eventType", type);
                        if (!TextUtils.isEmpty(type)) {
                            np2 l2 = d().l(type);
                            l2.m(KEY_VIEW_PARAMS, arrayList);
                            l2.m(KEY_EXTRA_PARAMS, obj);
                            l2.i(iDMComponent);
                            l2.p((String) obj4);
                            l2.k(iDMEvent);
                            h(l2);
                        }
                    }
                }
                return;
            }
        }
        if (obj instanceof String) {
            obj4 = obj;
        } else {
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length > 0) {
                    obj4 = objArr[0];
                }
            }
            obj4 = null;
        }
        if (obj4 instanceof String) {
        }
    }
}
