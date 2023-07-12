package cn.damai.tetris.component.star.group;

import android.widget.GridView;
import android.widget.ListAdapter;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.star.group.StarGroupRelateGridContract;
import cn.damai.tetris.component.star.group.adapter.GridAdapter;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ja;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class StarGroupRelateGridPresenter extends BasePresenter<StarGroupRelateGridContract.Model, StarGroupRelateGridView, BaseSection> implements StarGroupRelateGridContract.Presenter<StarGroupRelateGridContract.Model, StarGroupRelateGridView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public StarGroupRelateGridPresenter(StarGroupRelateGridView starGroupRelateGridView, String str, ja jaVar) {
        super(starGroupRelateGridView, str, jaVar);
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1038230134")) {
            ipChange.ipc$dispatch("1038230134", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(StarGroupRelateGridContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "943194389")) {
            ipChange.ipc$dispatch("943194389", new Object[]{this, model});
        } else {
            ((GridView) getView().getGridView().findViewById(R$id.tetris_star_grid_layout)).setAdapter((ListAdapter) new GridAdapter(getContext().getActivity(), model.getData(), this));
        }
    }
}
