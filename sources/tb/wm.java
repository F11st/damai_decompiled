package tb;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMComponent;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class wm extends ib {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v7 */
    private boolean m(IDMComponent iDMComponent) {
        boolean z;
        JSONObject stashData = iDMComponent.getStashData();
        JSONObject data = iDMComponent.getData();
        int i = false;
        i = 0;
        i = 0;
        if (stashData == null || data == null) {
            return false;
        }
        try {
            JSONObject jSONObject = data.getJSONObject("fields");
            JSONObject jSONObject2 = stashData.getJSONObject("fields");
            if (jSONObject.containsKey(en1.KEY_COMPONENTS_GROUPS)) {
                JSONArray jSONArray = jSONObject.getJSONArray(en1.KEY_COMPONENTS_GROUPS);
                JSONArray jSONArray2 = jSONObject2.getJSONArray(en1.KEY_COMPONENTS_GROUPS);
                int min = Math.min(jSONArray.size(), jSONArray2.size());
                z = false;
                while (i < min) {
                    try {
                        z = n(((JSONObject) jSONArray.get(i)).getJSONObject(ot1.KEY_AS_SELECT), ((JSONObject) jSONArray2.get(i)).getJSONObject(ot1.KEY_AS_SELECT));
                        if (z) {
                            i++;
                        }
                    } catch (Exception unused) {
                        i = z;
                        z = i;
                        return !z;
                    }
                }
            } else {
                z = n(jSONObject.getJSONObject(ot1.KEY_AS_SELECT), jSONObject2.getJSONObject(ot1.KEY_AS_SELECT));
            }
            break;
        } catch (Exception unused2) {
        }
        return !z;
    }

    private boolean n(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.toJSONString().equals(jSONObject2.toJSONString());
    }

    @Override // tb.ib
    protected void h(np2 np2Var) {
        np2 i = this.c.getTradeEventHandler().i();
        if (i == null || this.e == null) {
            return;
        }
        IDMComponent a = i.a();
        if (m(a)) {
            this.c.getDataManager().respondToLinkage(a, i);
        }
        this.c.getViewManager().closePopupWindow(true);
    }
}
