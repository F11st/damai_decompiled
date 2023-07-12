package tb;

import cn.damai.tetris.component.rank.bean.RankFilterExtraInfo;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.convertor.IConverter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class vy1 implements IConverter<BaseResponse, BaseSection, GlobalConfig, List<Node>> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.v2.convertor.IConverter
    /* renamed from: a */
    public List<Node> convert(BaseResponse baseResponse, BaseSection baseSection, GlobalConfig globalConfig, db dbVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1091065955")) {
            return (List) ipChange.ipc$dispatch("-1091065955", new Object[]{this, baseResponse, baseSection, globalConfig, dbVar});
        }
        RankFilterExtraInfo obtainFromBaseRes = RankFilterExtraInfo.obtainFromBaseRes(baseResponse);
        NodeData item = baseSection.getItem();
        if (item == null) {
            item = new NodeData();
        }
        item.put("itemInfo", (Object) obtainFromBaseRes);
        return new g32().convert(baseResponse, baseSection, globalConfig, dbVar);
    }
}
