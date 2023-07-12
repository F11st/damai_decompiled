package cn.damai.tetris.component.rank;

import android.view.View;
import cn.damai.tetris.component.rank.RankFilterContract;
import cn.damai.tetris.component.rank.bean.RankFilterBean;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RankFilterView extends AbsView<RankFilterContract.Presenter> implements RankFilterContract.View<RankFilterContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;

    public RankFilterView(View view) {
        super(view);
    }

    @Override // cn.damai.tetris.component.rank.RankFilterContract.View
    public void bindView(RankFilterBean rankFilterBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-432134996")) {
            ipChange.ipc$dispatch("-432134996", new Object[]{this, rankFilterBean});
        }
    }
}
