package cn.damai.tetris.component.discover.mvp;

import cn.damai.commonbusiness.discover.bean.VoteInfoBean;
import cn.damai.tetris.component.discover.mvp.VoteContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class VoteModel extends AbsModel implements VoteContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private VoteInfoBean bean;

    @Override // cn.damai.tetris.component.discover.mvp.VoteContract.Model
    public VoteInfoBean getBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "202531530") ? (VoteInfoBean) ipChange.ipc$dispatch("202531530", new Object[]{this}) : this.bean;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1262273380")) {
            ipChange.ipc$dispatch("-1262273380", new Object[]{this, baseNode});
            return;
        }
        VoteInfoBean voteInfoBean = (VoteInfoBean) m61.d(baseNode.getItem(), VoteInfoBean.class);
        this.bean = voteInfoBean;
        voteInfoBean.posInFeedList = baseNode.getOffset();
    }
}
