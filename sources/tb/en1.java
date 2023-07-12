package tb;

import com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class en1 extends OpenSimplePopupSubscriber {
    public static final String KEY_COMPONENTS_GROUPS = "componentGroups";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber
    public List<IDMComponent> p(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray(KEY_COMPONENTS_GROUPS);
        if (jSONArray != null && !jSONArray.isEmpty()) {
            for (int i = 0; i < jSONArray.size(); i++) {
                arrayList.addAll(super.p((JSONObject) jSONArray.get(i)));
            }
        }
        return arrayList;
    }
}
