package tb;

import cn.damai.tetris.component.drama.bean.ProjectShowBean;
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
public class lv1 implements IConverter<BaseResponse, BaseSection, GlobalConfig, List<Node>> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.v2.convertor.IConverter
    /* renamed from: a */
    public List<Node> convert(BaseResponse baseResponse, BaseSection baseSection, GlobalConfig globalConfig, db dbVar) {
        JSONArray jSONArray;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1661984705")) {
            return (List) ipChange.ipc$dispatch("-1661984705", new Object[]{this, baseResponse, baseSection, globalConfig, dbVar});
        }
        NodeData item = baseSection.getItem();
        if (item != null && (jSONArray = item.getJSONArray("result")) != null && jSONArray.size() > 0) {
            for (int i = 0; i < jSONArray.size(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    jSONObject.put(ProjectShowBean.REQUEST_FINISH_TIME, (Object) Long.valueOf(baseResponse.requestFinishTime));
                    jSONObject.put(ProjectShowBean.SERVER_TIME, (Object) Long.valueOf(baseResponse.serverTime));
                }
            }
        }
        return new g32().convert(baseResponse, baseSection, globalConfig, dbVar);
    }
}
