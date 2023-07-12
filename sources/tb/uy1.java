package tb;

import android.text.TextUtils;
import cn.damai.category.ranking.ui.RankListFragment;
import cn.damai.tetris.component.rank.RankListItemHolder;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.StyleInfo;
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
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class uy1 implements IConverter<BaseResponse, BaseSection, GlobalConfig, List<Node>> {
    private static transient /* synthetic */ IpChange $ipChange;

    private void a(BaseSection baseSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1391693273")) {
            ipChange.ipc$dispatch("-1391693273", new Object[]{this, baseSection});
            return;
        }
        try {
            TrackInfo trackInfo = baseSection.getTrackInfo();
            StyleInfo style = baseSection.getStyle();
            if (trackInfo == null) {
                trackInfo = new TrackInfo();
                baseSection.setTrackInfo(trackInfo);
            }
            if (style != null) {
                String string = style.getString("title");
                if (!TextUtils.isEmpty(string)) {
                    trackInfo.put("titlelabel", (Object) string);
                }
            }
            String d = z20.d();
            trackInfo.put("usercode", (Object) z20.E());
            trackInfo.put("city", (Object) d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // cn.damai.tetris.v2.convertor.IConverter
    /* renamed from: b */
    public List<Node> convert(BaseResponse baseResponse, BaseSection baseSection, GlobalConfig globalConfig, C9039db c9039db) {
        JSONArray jSONArray;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1031851160")) {
            return (List) ipChange.ipc$dispatch("-1031851160", new Object[]{this, baseResponse, baseSection, globalConfig, c9039db});
        }
        ArrayList arrayList = new ArrayList();
        NodeData item = baseSection.getItem();
        a(baseSection);
        if (item == null || (jSONArray = item.getJSONArray("itemDOList")) == null) {
            return arrayList;
        }
        String string = item.getString("id");
        String string2 = item.getString("name");
        RankListItemHolder.Companion.b(new HashMap<>());
        if (jSONArray.size() > 0) {
            for (int i = 0; i < jSONArray.size(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    jSONObject.put(RankListFragment.KEY_RANK_ID, (Object) string);
                    jSONObject.put("rankName", (Object) string2);
                    baseSection.setComponentId(xl2.RANK_PROJECT_C_ID);
                    baseSection.setItem(jSONObject);
                    List<Node> l = c9039db.l(baseSection, globalConfig);
                    if (l != null) {
                        arrayList.addAll(l);
                    }
                }
            }
        }
        return arrayList;
    }
}
