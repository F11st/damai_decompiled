package tb;

import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.common.model.IDMEvent;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class vm extends ib {
    public vm() {
        a();
    }

    private IDMComponent m() {
        Pair<IDMComponent, IDMEvent> popupWindowTrigger = this.c.getViewManager().getPopupWindowTrigger();
        if (popupWindowTrigger == null) {
            return null;
        }
        return (IDMComponent) popupWindowTrigger.first;
    }

    private IDMEvent n() {
        Pair<IDMComponent, IDMEvent> popupWindowTrigger = this.c.getViewManager().getPopupWindowTrigger();
        if (popupWindowTrigger == null) {
            return null;
        }
        return (IDMEvent) popupWindowTrigger.second;
    }

    public static boolean o(IDMComponent iDMComponent) {
        JSONObject stashData = iDMComponent.getStashData();
        JSONObject data = iDMComponent.getData();
        boolean z = false;
        if (stashData == null || data == null) {
            return false;
        }
        try {
            z = q(data, stashData);
        } catch (Exception unused) {
        }
        return !z;
    }

    private boolean p(List<IDMComponent> list) {
        if (list != null && !list.isEmpty()) {
            for (IDMComponent iDMComponent : list) {
                if (iDMComponent != null && o(iDMComponent)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean q(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return false;
        }
        for (String str : jSONObject.keySet()) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Object obj = jSONObject.get(str);
            Object obj2 = jSONObject2.get(str);
            if (obj instanceof JSONObject) {
                if (!q((JSONObject) obj, (JSONObject) obj2)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    private void r() {
        List<IDMComponent> components;
        if (this.c.getViewManager().isPopupShowing()) {
            IDMComponent m = m();
            IDMEvent n = n();
            if (m == null || n == null || (components = n.getComponents()) == null) {
                return;
            }
            int size = components.size();
            JSONObject jSONObject = new JSONObject();
            for (int i = 0; i < size; i++) {
                IDMComponent iDMComponent = components.get(i);
                jSONObject.put(iDMComponent.getKey(), (Object) iDMComponent.getData().toJSONString());
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("params", (Object) jSONObject);
            k(n, jSONObject2);
        }
    }

    @Override // tb.ib
    protected void h(np2 np2Var) {
        IDMEvent n = n();
        if (n == null) {
            return;
        }
        List<IDMComponent> components = n.getComponents();
        if (p(components)) {
            np2Var.o(new xh1(components));
            r();
            this.c.getDataManager().respondToLinkage(m(), np2Var);
        }
        this.c.getViewManager().closePopupWindow(true);
    }
}
