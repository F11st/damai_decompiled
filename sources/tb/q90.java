package tb;

import android.text.TextUtils;
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
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class q90 implements IConverter<BaseResponse, BaseSection, GlobalConfig, List<Node>> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.v2.convertor.IConverter
    /* renamed from: a */
    public List<Node> convert(BaseResponse baseResponse, BaseSection baseSection, GlobalConfig globalConfig, C9039db c9039db) {
        JSONArray jSONArray;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1006184708")) {
            return (List) ipChange.ipc$dispatch("-1006184708", new Object[]{this, baseResponse, baseSection, globalConfig, c9039db});
        }
        ArrayList arrayList = new ArrayList();
        NodeData item = baseSection.getItem();
        if (item != null && (jSONArray = item.getJSONArray("card")) != null && jSONArray.size() > 0) {
            for (int i = 0; i < jSONArray.size(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    jSONObject.put("hwRatio", (Object) Float.valueOf(i % 5 == 0 ? 1.3333334f : 1.0f));
                    String string = jSONObject.getString("type");
                    if (TextUtils.equals("1", string)) {
                        baseSection.setComponentId(xl2.NOTE_C_ID);
                        baseSection.setItem(jSONObject);
                        List<Node> l = c9039db.l(baseSection, globalConfig);
                        if (l != null) {
                            arrayList.addAll(l);
                        }
                    } else if (TextUtils.equals("2", string)) {
                        baseSection.setComponentId(xl2.THEME_C_ID);
                        baseSection.setItem(jSONObject);
                        List<Node> l2 = c9039db.l(baseSection, globalConfig);
                        if (l2 != null) {
                            arrayList.addAll(l2);
                        }
                    } else if (TextUtils.equals("5", string)) {
                        baseSection.setComponentId(xl2.VOTE_C_ID);
                        baseSection.setItem(jSONObject);
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
