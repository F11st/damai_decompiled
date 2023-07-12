package tb;

import com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber;
import com.alibaba.android.ultron.trade.event.model.SimplePopupModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ot1 extends ib {
    public static final String KEY_AS_SELECT = "asSelect";
    public static final String KEY_DISABLED = "disabled";
    public static final String KEY_IS_CHECKED = "isChecked";

    private void m(SimplePopupModel simplePopupModel, IDMComponent iDMComponent, JSONObject jSONObject) {
        int i;
        SimplePopupModel.AsSelect asSelect = simplePopupModel.getAsSelect();
        if (asSelect == null) {
            return;
        }
        boolean equals = Boolean.TRUE.toString().equals(asSelect.getOptional());
        try {
            i = Integer.parseInt(asSelect.getMax());
        } catch (Exception unused) {
            i = 1;
        }
        List<String> selectedIds = asSelect.getSelectedIds();
        if (selectedIds == null) {
            selectedIds = new ArrayList<>();
        }
        String string = this.e.getFields().getString("id");
        int size = selectedIds.size();
        List<IDMComponent> children = iDMComponent.getChildren();
        if (children == null) {
            return;
        }
        if (selectedIds.contains(string)) {
            if (equals || (size > 0 && i > 1)) {
                selectedIds.remove(string);
                this.e.getFields().put("isChecked", (Object) Boolean.FALSE.toString());
                for (IDMComponent iDMComponent2 : children) {
                    if (iDMComponent2 != null && !iDMComponent2.equals(this.e)) {
                        iDMComponent2.getFields().put("disabled", (Object) "false");
                    }
                }
                n(jSONObject, simplePopupModel);
            }
            this.c.getViewManager().refreshCurrentContainer();
            return;
        }
        if (i == 1) {
            selectedIds.clear();
            selectedIds.add(string);
            this.e.getFields().put("isChecked", (Object) "true");
            for (IDMComponent iDMComponent3 : children) {
                if (iDMComponent3 != null && !iDMComponent3.equals(this.e)) {
                    iDMComponent3.getFields().put("isChecked", (Object) "false");
                }
            }
        } else if (size >= i) {
            return;
        } else {
            selectedIds.add(string);
            this.e.getFields().put("isChecked", (Object) "true");
            if (selectedIds.size() == i) {
                for (IDMComponent iDMComponent4 : children) {
                    if (iDMComponent4 != null && !"true".equals(iDMComponent4.getFields().getString("isChecked"))) {
                        iDMComponent4.getFields().put("disabled", (Object) "true");
                    }
                }
            }
        }
        n(jSONObject, simplePopupModel);
        this.c.getViewManager().refreshCurrentContainer();
    }

    private void n(JSONObject jSONObject, SimplePopupModel simplePopupModel) {
        JSONObject jSONObject2;
        try {
            jSONObject2 = (JSONObject) JSON.toJSON(simplePopupModel);
        } catch (Exception unused) {
            jSONObject2 = null;
        }
        jSONObject.putAll(jSONObject2);
    }

    @Override // tb.ib
    protected void h(np2 np2Var) {
        IDMComponent iDMComponent;
        IDMComponent parent;
        if (this.c.getTradeEventHandler().i() == null || (iDMComponent = this.e) == null || "true".equals(iDMComponent.getFields().getString("disabled")) || (parent = this.e.getParent()) == null) {
            return;
        }
        Object obj = parent.getExtMap().get(OpenSimplePopupSubscriber.KEY_SIMPLE_POPUP_MODEL);
        Object obj2 = parent.getExtMap().get(OpenSimplePopupSubscriber.KEY_SIMPLE_POPUP_FIELDS);
        if ((obj instanceof SimplePopupModel) && (obj2 instanceof JSONObject)) {
            m((SimplePopupModel) obj, parent, (JSONObject) obj2);
        }
    }
}
