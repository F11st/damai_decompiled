package cn.damai.tetris.component.rank;

import android.view.View;
import cn.damai.tetris.component.rank.RankCardContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RankCardView extends AbsView<RankCardContract.Presenter> implements RankCardContract.View<RankCardContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    RankItemHolder holder;

    public RankCardView(View view) {
        super(view);
        this.holder = new RankItemHolder(view.getContext(), view);
    }

    @Override // cn.damai.tetris.component.rank.RankCardContract.View
    public RankItemHolder getHolder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1514442372") ? (RankItemHolder) ipChange.ipc$dispatch("1514442372", new Object[]{this}) : this.holder;
    }
}
