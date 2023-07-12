package tb;

import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.convertor.IConverter;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ah implements IConverter<BaseResponse, BaseSection, GlobalConfig, List<Node>> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.v2.convertor.IConverter
    /* renamed from: a */
    public List<Node> convert(BaseResponse baseResponse, BaseSection baseSection, GlobalConfig globalConfig, C9039db c9039db) {
        JSONArray jSONArray;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "17611223")) {
            return (List) ipChange.ipc$dispatch("17611223", new Object[]{this, baseResponse, baseSection, globalConfig, c9039db});
        }
        ArrayList arrayList = new ArrayList();
        NodeData item = baseSection.getItem();
        if (item != null && (jSONArray = item.getJSONArray("result")) != null && jSONArray.size() > 0) {
            for (int i = 0; i < jSONArray.size(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    int intValue = jSONObject.getInteger("type").intValue();
                    TrackInfo trackInfo = new TrackInfo();
                    if (baseSection.getTrackInfo() != null) {
                        trackInfo = baseSection.getTrackInfo();
                    }
                    trackInfo.trackB = item.getString("trackB");
                    trackInfo.put(C9039db.TRACKKEY_CURRENT_ITEM_TOTAL, (Object) Integer.valueOf(item.getIntValue(C9039db.TRACKKEY_CURRENT_ITEM_TOTAL)));
                    trackInfo.put(C9039db.TRACKKEY_CATEGORY_NAME, (Object) item.getString(C9039db.TRACKKEY_CATEGORY_NAME));
                    trackInfo.put(C9039db.TRACKKEY_CITY, (Object) item.getString(C9039db.TRACKKEY_CITY));
                    if (intValue == 1) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("hasCurrentCity", (Object) jSONObject.getBoolean("hasCurrentCity"));
                        baseSection.setItem(jSONObject2);
                        baseSection.setComponentId(xl2.DM_CARD_CATEGORY_TITLE);
                        List<Node> l = c9039db.l(baseSection, globalConfig);
                        if (l != null) {
                            arrayList.addAll(l);
                        }
                    } else if (intValue == 5) {
                        baseSection.setItem(jSONObject.getJSONObject("rankBean"));
                        baseSection.setComponentId(xl2.DM_CARD_RANKLIST_HORIZONTAL);
                        baseSection.setTrackInfo(trackInfo);
                        List<Node> l2 = c9039db.l(baseSection, globalConfig);
                        if (l2 != null) {
                            arrayList.addAll(l2);
                        }
                    } else {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(C9039db.KEY_PROJECT, (Object) jSONObject.getJSONObject("projectItemBean"));
                        jSONObject3.put(C9039db.KEY_DAOJISHI, item.get(C9039db.KEY_DAOJISHI));
                        jSONObject3.put(C9039db.KEY_SHOW_DIS, item.get(C9039db.KEY_SHOW_DIS));
                        baseSection.setItem(jSONObject3);
                        boolean booleanValue = jSONObject.getBooleanValue(C9039db.TRACKKEY_IS_CURRENT_CITY);
                        trackInfo.put(C9039db.TRACKKEY_IS_CURRENT_CITY, (Object) Boolean.valueOf(booleanValue));
                        String str = booleanValue ? "categorylist" : "othercitylist";
                        trackInfo.trackC = str;
                        trackInfo.put("spmc", (Object) str);
                        baseSection.setTrackInfo(trackInfo);
                        baseSection.setComponentId(xl2.DM_PROJECT_HORIZONTAL);
                        List<Node> l3 = c9039db.l(baseSection, globalConfig);
                        if (l3 != null) {
                            arrayList.addAll(l3);
                        }
                    }
                }
            }
        }
        return arrayList;
    }
}
