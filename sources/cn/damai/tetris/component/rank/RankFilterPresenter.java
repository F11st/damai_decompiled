package cn.damai.tetris.component.rank;

import cn.damai.tetris.component.rank.RankFilterContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ja;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RankFilterPresenter extends BasePresenter<RankFilterContract.Model, RankFilterContract.View, BaseSection> implements RankFilterContract.Presenter<RankFilterContract.Model, RankFilterContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public RankFilterPresenter(RankFilterView rankFilterView, String str, ja jaVar) {
        super(rankFilterView, str, jaVar);
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(RankFilterContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2112227997")) {
            ipChange.ipc$dispatch("2112227997", new Object[]{this, model});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2031355616")) {
            ipChange.ipc$dispatch("2031355616", new Object[]{this, Integer.valueOf(i), obj});
        }
    }
}
