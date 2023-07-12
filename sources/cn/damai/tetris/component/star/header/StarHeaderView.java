package cn.damai.tetris.component.star.header;

import android.view.View;
import android.view.ViewGroup;
import cn.damai.tetris.component.star.header.StarHeaderContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class StarHeaderView extends AbsView implements StarHeaderContract.View {
    private static transient /* synthetic */ IpChange $ipChange;

    public StarHeaderView(View view) {
        super(view);
    }

    @Override // cn.damai.tetris.component.star.header.StarHeaderContract.View
    public ViewGroup getHeaderView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1291214750") ? (ViewGroup) ipChange.ipc$dispatch("1291214750", new Object[]{this}) : (ViewGroup) getView();
    }
}
