package tb;

import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.convertor.IConverter;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class nx0 implements IConverter<BaseResponse, BaseSection, GlobalConfig, List<Node>> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.v2.convertor.IConverter
    /* renamed from: a */
    public List<Node> convert(BaseResponse baseResponse, BaseSection baseSection, GlobalConfig globalConfig, db dbVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1030697861")) {
            return (List) ipChange.ipc$dispatch("-1030697861", new Object[]{this, baseResponse, baseSection, globalConfig, dbVar});
        }
        if (baseSection != null && baseSection.getItem() != null) {
            NodeData item = baseSection.getItem();
            JSONArray jSONArray = item.getJSONArray("projects");
            JSONObject jSONObject = item.getJSONObject("top");
            if (t41.b(jSONArray) <= 0 && jSONObject == null) {
                return null;
            }
            if (t41.b(jSONArray) > 0 && jSONObject != null) {
                int b = t41.b(jSONArray);
                for (int i = 0; i < b; i++) {
                    jSONArray.getJSONObject(i).put("topItemId", (Object) jSONObject.getString("itemId"));
                }
            }
            if (jSONObject != null && t41.b(jSONArray) <= 0) {
                JSONArray jSONArray2 = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("highlightTitle", (Object) jSONObject.getString("ipvuv"));
                jSONObject2.put("title", (Object) jSONObject.getString("name"));
                jSONObject2.put("itemId", (Object) jSONObject.getString("itemId"));
                jSONObject2.put("topItemId", (Object) jSONObject.getString("itemId"));
                jSONObject2.put("status", (Object) jSONObject.getString("status"));
                jSONArray2.add(jSONObject2);
                item.put("projects", (Object) jSONArray2);
            }
        }
        return new g32().convert(baseResponse, baseSection, globalConfig, dbVar);
    }
}
