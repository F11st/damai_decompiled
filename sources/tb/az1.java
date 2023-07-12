package tb;

import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.convertor.ILayerStyleBuilder;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.data.Constants;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class az1 implements ILayerStyleBuilder {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.v2.convertor.ILayerStyleBuilder
    @NotNull
    public Node setLayerStyle(@NotNull BaseSection baseSection, @NotNull Node node) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2131625485")) {
            return (Node) ipChange.ipc$dispatch("-2131625485", new Object[]{this, baseSection, node});
        }
        b41.i(baseSection, "style");
        b41.i(node, "layerNode");
        JSONObject jSONObject = node.data;
        b41.h(jSONObject, "layerNode.data");
        jSONObject.put((JSONObject) Constants.LAYOUT_TYPE, "linear");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put((JSONObject) Constants.Name.MARGIN_LEFT, (String) 9);
        jSONObject2.put((JSONObject) Constants.Name.MARGIN_RIGHT, (String) 9);
        JSONObject jSONObject3 = node.data;
        b41.h(jSONObject3, "layerNode.data");
        jSONObject3.put((JSONObject) "layoutParams", (String) jSONObject2);
        return node;
    }
}
