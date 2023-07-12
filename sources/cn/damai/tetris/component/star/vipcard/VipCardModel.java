package cn.damai.tetris.component.star.vipcard;

import cn.damai.tetris.component.star.vipcard.VipCardContract;
import cn.damai.tetris.component.star.vipcard.bean.ArtistVipBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class VipCardModel extends AbsModel implements VipCardContract.Model<BaseNode> {
    private static transient /* synthetic */ IpChange $ipChange;
    ArtistVipBean vipBean;

    @Override // cn.damai.tetris.component.star.vipcard.VipCardContract.Model
    public ArtistVipBean getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1598634135") ? (ArtistVipBean) ipChange.ipc$dispatch("1598634135", new Object[]{this}) : this.vipBean;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-352818140")) {
            ipChange.ipc$dispatch("-352818140", new Object[]{this, baseNode});
            return;
        }
        try {
            this.vipBean = (ArtistVipBean) JSON.parseObject(baseNode.getItem().toJSONString(), ArtistVipBean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
