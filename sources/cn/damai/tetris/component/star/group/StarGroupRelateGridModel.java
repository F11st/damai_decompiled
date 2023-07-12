package cn.damai.tetris.component.star.group;

import cn.damai.tetris.component.star.group.StarGroupRelateGridContract;
import cn.damai.tetris.component.star.group.bean.StarInfoItem;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class StarGroupRelateGridModel extends AbsModel implements StarGroupRelateGridContract.Model<BaseNode> {
    private static transient /* synthetic */ IpChange $ipChange;
    List<StarInfoItem> starInfoItems;

    @Override // cn.damai.tetris.component.star.group.StarGroupRelateGridContract.Model
    public List<StarInfoItem> getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-728835305") ? (List) ipChange.ipc$dispatch("-728835305", new Object[]{this}) : this.starInfoItems;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-515571947")) {
            ipChange.ipc$dispatch("-515571947", new Object[]{this, baseNode});
            return;
        }
        try {
            if (baseNode.getItem() == null || baseNode.getItem().getString("result") == null) {
                return;
            }
            this.starInfoItems = JSON.parseArray(baseNode.getItem().getString("result"), StarInfoItem.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
