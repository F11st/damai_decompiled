package tb;

import com.alibaba.fastjson.JSONObject;
import com.taobao.accs.common.Constants;
import com.taobao.update.datasource.UpdateListener;
import com.taobao.updatecenter.hotpatch.HotPatchManager;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class wq1 implements UpdateListener {
    @Override // com.taobao.update.datasource.UpdateListener
    public void onUpdate(boolean z, JSONObject jSONObject, String str) {
        if (jSONObject != null && !jSONObject.isEmpty()) {
            vq1 a = vq1.a(jSONObject);
            String string = jSONObject.containsKey(Constants.KEY_DATA_ID) ? jSONObject.getString(Constants.KEY_DATA_ID) : "";
            HotPatchManager.getInstance().dealPatchInfo(a, str, string);
            ku2.b("data_receiver", string);
            return;
        }
        ku2.a("data_receiver", z + "", "-1", "the data is null or empty");
    }
}
