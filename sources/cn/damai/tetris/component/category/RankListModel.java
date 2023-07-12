package cn.damai.tetris.component.category;

import cn.damai.commonbusiness.rank.RankItemBean;
import cn.damai.tetris.component.category.RankListContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m61;
import tb.m91;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RankListModel extends AbsModel implements RankListContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    RankItemBean bean1;
    int index;

    @Override // cn.damai.tetris.component.category.RankListContract.Model
    public RankItemBean getBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1485383708") ? (RankItemBean) ipChange.ipc$dispatch("1485383708", new Object[]{this}) : this.bean1;
    }

    @Override // cn.damai.tetris.component.category.RankListContract.Model
    public int getIndex() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-813439065") ? ((Integer) ipChange.ipc$dispatch("-813439065", new Object[]{this})).intValue() : this.index;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-180249985")) {
            ipChange.ipc$dispatch("-180249985", new Object[]{this, baseNode});
            return;
        }
        this.index = baseNode.getOffset();
        RankListBean rankListBean = (RankListBean) m61.d(baseNode.getItem(), RankListBean.class);
        if (rankListBean == null) {
            return;
        }
        RankItemBean rankItemBean = new RankItemBean();
        this.bean1 = rankItemBean;
        rankItemBean.type = 1;
        if (!m91.a(rankListBean.verticalPicList) && rankListBean.verticalPicList.get(0) != null) {
            this.bean1.pic = rankListBean.verticalPicList.get(0);
        }
        RankItemBean rankItemBean2 = this.bean1;
        rankItemBean2.shortName = rankListBean.shortName;
        rankItemBean2.shortDesc = rankListBean.shortDesc;
        rankItemBean2.followDesc = rankListBean.followDesc;
        rankItemBean2.id = rankListBean.id;
    }
}
