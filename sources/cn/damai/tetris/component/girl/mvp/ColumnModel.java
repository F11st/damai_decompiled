package cn.damai.tetris.component.girl.mvp;

import cn.damai.tetris.component.girl.bean.StepBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ColumnModel extends AbsModel implements ColumnContract$Model {
    private static transient /* synthetic */ IpChange $ipChange;
    public String mCityId;
    StepBean stepBean;

    @Override // cn.damai.tetris.component.girl.mvp.ColumnContract$Model
    public String getCityId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-384277556") ? (String) ipChange.ipc$dispatch("-384277556", new Object[]{this}) : this.mCityId;
    }

    @Override // cn.damai.tetris.component.girl.mvp.ColumnContract$Model
    public StepBean getStepBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1703677774") ? (StepBean) ipChange.ipc$dispatch("-1703677774", new Object[]{this}) : this.stepBean;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-511359947")) {
            ipChange.ipc$dispatch("-511359947", new Object[]{this, baseNode});
            return;
        }
        StepBean stepBean = (StepBean) JSON.parseObject(baseNode.toJSONString(), StepBean.class);
        if (getTrackInfo() != null && getTrackInfo().containsKey("cityId")) {
            this.mCityId = getTrackInfo().getString("cityId");
        }
        this.stepBean = stepBean;
        if (stepBean != null) {
            stepBean.position = baseNode.getOffset();
        }
    }
}
