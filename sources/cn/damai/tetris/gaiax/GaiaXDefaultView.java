package cn.damai.tetris.gaiax;

import android.view.View;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class GaiaXDefaultView extends AbsView<GaiaXDefaultPresenter> implements GaiaXView<GaiaXDefaultPresenter> {
    private static transient /* synthetic */ IpChange $ipChange;

    public GaiaXDefaultView(View view) {
        super(view);
    }

    @Override // cn.damai.tetris.gaiax.GaiaXView
    public View getContainer() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-7064720") ? (View) ipChange.ipc$dispatch("-7064720", new Object[]{this}) : getRootView();
    }

    @Override // cn.damai.tetris.gaiax.GaiaXView
    public View getGaiaXContainer() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1622168894") ? (View) ipChange.ipc$dispatch("-1622168894", new Object[]{this}) : getRootView();
    }
}
