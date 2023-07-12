package cn.damai.tetris.component.star;

import cn.damai.tetris.component.star.TourInfoContract;
import cn.damai.tetris.component.star.bean.TourInfoBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TourInfoModel extends AbsModel implements TourInfoContract.Model<BaseNode> {
    private static transient /* synthetic */ IpChange $ipChange;
    TourInfoBean tourInfoBean;

    @Override // cn.damai.tetris.component.star.TourInfoContract.Model
    public TourInfoBean getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1870820418") ? (TourInfoBean) ipChange.ipc$dispatch("-1870820418", new Object[]{this}) : this.tourInfoBean;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1877859481")) {
            ipChange.ipc$dispatch("-1877859481", new Object[]{this, baseNode});
            return;
        }
        try {
            if (baseNode.getItem() != null) {
                this.tourInfoBean = (TourInfoBean) JSON.parseObject(baseNode.getItem().toJSONString(), TourInfoBean.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
