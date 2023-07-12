package cn.damai.tetris.component.rank;

import cn.damai.tetris.component.rank.RankSelectContract;
import cn.damai.tetris.component.rank.bean.RankSelectBean;
import cn.damai.tetris.component.rank.bean.RankSelectItemBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.cb2;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class RankSelectModel extends AbsModel<RankSelectBean> implements RankSelectContract.Model<BaseNode> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private RankSelectBean bean;

    @Override // cn.damai.tetris.component.rank.RankSelectContract.Model
    @Nullable
    public RankSelectBean getBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-936518016") ? (RankSelectBean) ipChange.ipc$dispatch("-936518016", new Object[]{this}) : this.bean;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(@NotNull BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1214505327")) {
            ipChange.ipc$dispatch("1214505327", new Object[]{this, baseNode});
            return;
        }
        b41.i(baseNode, "baseNode");
        this.bean = (RankSelectBean) m61.d(baseNode.getItem(), RankSelectBean.class);
        if (getBean() != null) {
            RankSelectBean bean = getBean();
            b41.f(bean);
            List<RankSelectItemBean> list = bean.result;
            if (cb2.d(list)) {
                return;
            }
            b41.f(list);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                RankSelectItemBean rankSelectItemBean = list.get(i);
                b41.f(rankSelectItemBean);
                rankSelectItemBean.pos = i;
            }
        }
    }
}
