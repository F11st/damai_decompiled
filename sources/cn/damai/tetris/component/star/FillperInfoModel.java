package cn.damai.tetris.component.star;

import cn.damai.tetris.component.star.FillperInfoContract;
import cn.damai.tetris.component.star.bean.FillperItemBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class FillperInfoModel extends AbsModel implements FillperInfoContract.Model<BaseNode> {
    private static transient /* synthetic */ IpChange $ipChange;
    List<FillperItemBean> fillperItemBeans;

    @Override // cn.damai.tetris.component.star.FillperInfoContract.Model
    public List<FillperItemBean> getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1871506197") ? (List) ipChange.ipc$dispatch("-1871506197", new Object[]{this}) : this.fillperItemBeans;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "228699329")) {
            ipChange.ipc$dispatch("228699329", new Object[]{this, baseNode});
            return;
        }
        try {
            if (baseNode.getItem() == null || baseNode.getItem().getString("result") == null) {
                return;
            }
            this.fillperItemBeans = JSON.parseArray(baseNode.getItem().getString("result"), FillperItemBean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
