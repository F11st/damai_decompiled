package cn.damai.tetris.component.rank;

import cn.damai.tetris.component.rank.RankProjectContract;
import cn.damai.tetris.component.rank.bean.RankItemBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class RankProjectModel extends AbsModel<RankItemBean> implements RankProjectContract.Model<BaseNode> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private RankItemBean bean;

    @Override // cn.damai.tetris.component.rank.RankProjectContract.Model
    @Nullable
    public RankItemBean getBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1251655032") ? (RankItemBean) ipChange.ipc$dispatch("1251655032", new Object[]{this}) : this.bean;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(@NotNull BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1713664736")) {
            ipChange.ipc$dispatch("1713664736", new Object[]{this, baseNode});
            return;
        }
        b41.i(baseNode, "baseNode");
        setBean((RankItemBean) m61.d(baseNode.getItem(), RankItemBean.class));
        RankItemBean bean = getBean();
        if (bean == null) {
            return;
        }
        bean.index = baseNode.getOffset();
    }

    public void setBean(@Nullable RankItemBean rankItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "461653984")) {
            ipChange.ipc$dispatch("461653984", new Object[]{this, rankItemBean});
        } else {
            this.bean = rankItemBean;
        }
    }
}
