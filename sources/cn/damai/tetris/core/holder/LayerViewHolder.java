package cn.damai.tetris.core.holder;

import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.IView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.a1;
import tb.ja;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class LayerViewHolder extends AbsViewHolder<a1, BasePresenter, BaseLayer> {
    private static transient /* synthetic */ IpChange $ipChange;

    public LayerViewHolder(a1 a1Var, ja jaVar) {
        super(a1Var, jaVar);
    }

    @Override // cn.damai.tetris.core.holder.AbsViewHolder
    public void a(a1 a1Var, IView iView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2133386617")) {
            ipChange.ipc$dispatch("2133386617", new Object[]{this, a1Var, iView});
        } else if (a1Var == null || iView == null) {
        } else {
            a1Var.d().addView(iView.getRootView());
        }
    }
}
