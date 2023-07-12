package cn.damai.tetris.component.star;

import cn.damai.tetris.component.star.OfficalMallContract;
import cn.damai.tetris.component.star.bean.ItemModuleBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class OfficalMallModel extends AbsModel implements OfficalMallContract.Model<BaseNode> {
    private static transient /* synthetic */ IpChange $ipChange;
    ItemModuleBean itemModuleBean;

    @Override // cn.damai.tetris.component.star.OfficalMallContract.Model
    public ItemModuleBean getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1034645099") ? (ItemModuleBean) ipChange.ipc$dispatch("1034645099", new Object[]{this}) : this.itemModuleBean;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        List<ItemModuleBean.GoodBean> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1648541985")) {
            ipChange.ipc$dispatch("1648541985", new Object[]{this, baseNode});
            return;
        }
        try {
            ItemModuleBean itemModuleBean = (ItemModuleBean) JSON.parseObject(baseNode.getItem().toJSONString(), ItemModuleBean.class);
            this.itemModuleBean = itemModuleBean;
            if (itemModuleBean == null || (list = itemModuleBean.goods) == null || list.size() <= 6) {
                return;
            }
            ItemModuleBean itemModuleBean2 = this.itemModuleBean;
            itemModuleBean2.goods = itemModuleBean2.goods.subList(0, 6);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
