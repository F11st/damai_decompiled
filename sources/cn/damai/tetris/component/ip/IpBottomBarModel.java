package cn.damai.tetris.component.ip;

import cn.damai.tetris.component.ip.IpBottomBarContract;
import cn.damai.tetris.component.ip.bean.IpBottomBarBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class IpBottomBarModel extends AbsModel implements IpBottomBarContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    IpBottomBarBean bottomBarBean;

    @Override // cn.damai.tetris.component.ip.IpBottomBarContract.Model
    public IpBottomBarBean getBottomBarBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1272884674") ? (IpBottomBarBean) ipChange.ipc$dispatch("1272884674", new Object[]{this}) : this.bottomBarBean;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-828984497")) {
            ipChange.ipc$dispatch("-828984497", new Object[]{this, baseNode});
            return;
        }
        try {
            this.bottomBarBean = (IpBottomBarBean) JSON.parseObject(baseNode.getItem().toJSONString(), IpBottomBarBean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
