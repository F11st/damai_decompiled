package cn.damai.tetris.component.star.vipcard;

import android.view.View;
import android.view.ViewGroup;
import cn.damai.tetris.component.star.vipcard.VipCardContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class VipCardView extends AbsView implements VipCardContract.View {
    private static transient /* synthetic */ IpChange $ipChange;

    public VipCardView(View view) {
        super(view);
    }

    @Override // cn.damai.tetris.component.star.vipcard.VipCardContract.View
    public ViewGroup getVipView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "968317420") ? (ViewGroup) ipChange.ipc$dispatch("968317420", new Object[]{this}) : (ViewGroup) getView();
    }
}
