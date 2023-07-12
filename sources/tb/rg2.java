package tb;

import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.convertor.ILayerStyleBuilder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class rg2 implements ILayerStyleBuilder {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.v2.convertor.ILayerStyleBuilder
    public Node setLayerStyle(BaseSection baseSection, Node node) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1639429584")) {
            return (Node) ipChange.ipc$dispatch("-1639429584", new Object[]{this, baseSection, node});
        }
        node.data.put(Constants.LAYOUT_TYPE, (Object) "sticky");
        return node;
    }
}
