package tb;

import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.common.model.IDMEvent;
import com.taobao.android.ultron.datamodel.imp.C6663c;
import com.taobao.weex.ui.component.WXBasicComponentType;
import com.youku.resource.widget.YKActionSheet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ca2 extends ib {
    public static final String KEY_SELECT_IS_CHECKED = "isChecked";

    private void m(boolean z) {
        u(this.e, !z);
        this.c.getDataManager().respondToLinkage(this.e, this.a);
    }

    private IDMEvent n(List<IDMEvent> list, String str) {
        if (list != null && !list.isEmpty()) {
            for (IDMEvent iDMEvent : list) {
                if (iDMEvent != null && str != null && str.equals(iDMEvent.getType())) {
                    return iDMEvent;
                }
            }
        }
        return null;
    }

    private String o(IDMComponent iDMComponent) {
        IDMComponent parent = iDMComponent.getParent();
        if (parent == null || parent.getFields() == null || parent.getFields().get("groupType") == null) {
            return null;
        }
        return (String) parent.getFields().get("groupType");
    }

    private boolean p(IDMComponent iDMComponent) {
        IDMComponent parent = iDMComponent.getParent();
        if (parent == null || parent.getFields() == null || parent.getFields().get("optional") == null) {
            return false;
        }
        return parent.getFields().getBoolean("optional").booleanValue();
    }

    private IDMComponent q() {
        if (this.c.getViewManager().isPopupShowing()) {
            return (IDMComponent) this.c.getViewManager().getPopupWindowTrigger().first;
        }
        return this.e;
    }

    private void r(boolean z) {
        List<IDMComponent> children;
        IDMComponent parent = this.e.getParent();
        if (parent == null || (children = parent.getChildren()) == null || z) {
            return;
        }
        u(this.e, z);
        int intValue = parent.getFields().getInteger("maxCount").intValue();
        ArrayList<IDMComponent> arrayList = new ArrayList();
        int i = 0;
        for (IDMComponent iDMComponent : children) {
            JSONObject fields = iDMComponent.getFields();
            if (fields.containsKey("isChecked") && fields.getBoolean("isChecked").booleanValue()) {
                i++;
            } else {
                arrayList.add(iDMComponent);
            }
        }
        if (i >= intValue) {
            for (IDMComponent iDMComponent2 : arrayList) {
                if (iDMComponent2 != null) {
                    String e = C6663c.e(iDMComponent2);
                    if (!"header".equals(e) && !WXBasicComponentType.FOOTER.equals(e)) {
                        iDMComponent2.getFields().put("status", (Object) YKActionSheet.ACTION_STYLE_DISABLE);
                    }
                }
            }
        }
        this.c.getDataManager().respondToLinkage(q(), this.a);
    }

    private void s(boolean z) {
        List<IDMComponent> children;
        IDMComponent parent = this.e.getParent();
        if (parent == null || (children = parent.getChildren()) == null) {
            return;
        }
        if (p(this.e)) {
            u(this.e, !z);
        } else {
            u(this.e, true);
        }
        for (IDMComponent iDMComponent : children) {
            if (iDMComponent != null) {
                String e = C6663c.e(iDMComponent);
                if (!this.e.equals(iDMComponent) && !"header".equals(e) && !WXBasicComponentType.FOOTER.equals(e)) {
                    u(iDMComponent, false);
                }
            }
        }
        this.c.getDataManager().respondToLinkage(this.e, this.a);
    }

    private boolean t() {
        Object e = this.a.e(op2.KEY_VIEW_PARAMS);
        JSONObject fields = this.e.getFields();
        boolean z = false;
        if (fields == null) {
            return false;
        }
        if (e instanceof List) {
            List list = (List) e;
            if (!list.isEmpty()) {
                return !"true".equals(String.valueOf(list.get(0)));
            }
        }
        if (fields.containsKey("isChecked") && fields.getBoolean("isChecked").booleanValue()) {
            z = true;
        }
        return z;
    }

    private void u(IDMComponent iDMComponent, boolean z) {
        if (iDMComponent == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("isChecked", String.valueOf(z));
        i(iDMComponent, hashMap);
        v(iDMComponent, hashMap);
    }

    private void v(IDMComponent iDMComponent, Map<String, String> map) {
        List<IDMEvent> list;
        Map<String, List<IDMEvent>> eventMap = iDMComponent.getEventMap();
        if (eventMap == null || (list = eventMap.get(this.a.g())) == null) {
            return;
        }
        k(n(list, this.a.d()), map);
    }

    @Override // tb.ib
    protected void h(np2 np2Var) {
        if (!this.c.getViewManager().isPopupShowing()) {
            np2Var.o(new d60(this.e, this.c));
        }
        boolean t = t();
        String o = o(this.e);
        if (o != null) {
            if (o.equals("multiSelect")) {
                r(t);
                return;
            } else if (o.equals("singleSelect")) {
                s(t);
                return;
            }
        }
        m(t);
    }
}
