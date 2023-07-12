package cn.damai.tetris.component.category;

import android.view.View;
import cn.damai.commonbusiness.rank.CommonRankHolder;
import cn.damai.tetris.component.category.RankListContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RankListView extends AbsView<RankListContract.Presenter> implements RankListContract.View<RankListContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    CommonRankHolder viewHolder;

    public RankListView(View view) {
        super(view);
        this.viewHolder = new CommonRankHolder(view);
    }

    @Override // cn.damai.tetris.component.category.RankListContract.View
    public CommonRankHolder getHolder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-330403252") ? (CommonRankHolder) ipChange.ipc$dispatch("-330403252", new Object[]{this}) : this.viewHolder;
    }
}
