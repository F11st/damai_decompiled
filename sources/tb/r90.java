package tb;

import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.convertor.ILayerStyleBuilder;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class r90 implements ILayerStyleBuilder {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.v2.convertor.ILayerStyleBuilder
    public Node setLayerStyle(BaseSection baseSection, Node node) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2087834960")) {
            return (Node) ipChange.ipc$dispatch("-2087834960", new Object[]{this, baseSection, node});
        }
        node.data.put(Constants.LAYOUT_TYPE, (Object) "staggered");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.V_GAP, (Object) 9);
        jSONObject.put(Constants.H_GAP, (Object) 9);
        jSONObject.put("marginGap", (Object) 12);
        node.data.put("layoutParams", (Object) jSONObject);
        return node;
    }
}
