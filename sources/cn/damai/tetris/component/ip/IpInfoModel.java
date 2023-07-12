package cn.damai.tetris.component.ip;

import cn.damai.tetris.component.ip.IpInfoContract;
import cn.damai.tetris.component.ip.bean.IPInfoBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class IpInfoModel extends AbsModel implements IpInfoContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    IPInfoBean ipInfo;

    @Override // cn.damai.tetris.component.ip.IpInfoContract.Model
    public IPInfoBean getIpInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2074391317") ? (IPInfoBean) ipChange.ipc$dispatch("-2074391317", new Object[]{this}) : this.ipInfo;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1076632575")) {
            ipChange.ipc$dispatch("-1076632575", new Object[]{this, baseNode});
            return;
        }
        try {
            this.ipInfo = (IPInfoBean) JSON.parseObject(baseNode.getItem().toJSONString(), IPInfoBean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
