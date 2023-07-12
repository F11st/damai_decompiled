package cn.damai.tetris.component.star;

import android.view.View;
import android.view.ViewGroup;
import cn.damai.tetris.component.star.FansRankingContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class FansRankingView extends AbsView implements FansRankingContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    ViewGroup root;

    public FansRankingView(View view) {
        super(view);
        this.root = (ViewGroup) view;
    }

    @Override // cn.damai.tetris.component.star.FansRankingContract.View
    public ViewGroup getFansView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "864350694") ? (ViewGroup) ipChange.ipc$dispatch("864350694", new Object[]{this}) : this.root;
    }
}
