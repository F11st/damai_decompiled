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
import com.uc.webview.export.cyclone.StatAction;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class jd implements IConverter<BaseResponse, BaseSection, GlobalConfig, List<Node>> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.v2.convertor.IConverter
    /* renamed from: a */
    public List<Node> convert(BaseResponse baseResponse, BaseSection baseSection, GlobalConfig globalConfig, C9039db c9039db) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "455710367")) {
            return (List) ipChange.ipc$dispatch("455710367", new Object[]{this, baseResponse, baseSection, globalConfig, c9039db});
        }
        ArrayList arrayList = new ArrayList();
        NodeData item = baseSection.getItem();
        if (item != null) {
            BaseSection baseSection2 = new BaseSection();
            baseSection2.setComponentId("dm_card_common_title");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("title", (Object) item.getString("mainTitle"));
            if (item.containsKey(StatAction.KEY_TOTAL) && item.getInteger(StatAction.KEY_TOTAL).intValue() > 3 && item.getString("schema") != null) {
                jSONObject.put("schema", (Object) item.getString("schema"));
            }
            baseSection2.setItem(jSONObject);
            JSONArray jSONArray = item.getJSONArray("content");
            if (jSONArray != null && jSONArray.size() > 0) {
                arrayList.addAll(new C9039db().l(baseSection2, globalConfig));
                for (int i = 0; i < jSONArray.size(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        TrackInfo trackInfo = new TrackInfo();
                        if (baseSection.getTrackInfo() != null) {
                            trackInfo = baseSection.getTrackInfo();
                        }
                        trackInfo.trackB = item.getString("trackB");
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(C9039db.KEY_PROJECT, (Object) jSONObject2);
                        baseSection.setItem(jSONObject3);
                        baseSection.setTrackInfo(trackInfo);
                        baseSection.setComponentId(xl2.DM_PROJECT_HORIZONTAL);
                        List<Node> l = c9039db.l(baseSection, globalConfig);
                        if (l != null) {
                            arrayList.addAll(l);
                        }
                    }
                }
            }
        }
        return arrayList;
    }
}
