package cn.damai.tetris.component.common;

import cn.damai.tetris.component.home.bean.HomePageVideoBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.mvp.CommonBean;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HeaderVideoModel extends AbsModel implements HeaderVideoContract$Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private CommonBean data;

    @Override // cn.damai.tetris.component.common.HeaderVideoContract$Model
    public CommonBean getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-540147444") ? (CommonBean) ipChange.ipc$dispatch("-540147444", new Object[]{this}) : this.data;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1222861696")) {
            ipChange.ipc$dispatch("-1222861696", new Object[]{this, baseNode});
            return;
        }
        try {
            this.data = (CommonBean) JSON.parseObject(baseNode.getItem().toJSONString(), HomePageVideoBean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
