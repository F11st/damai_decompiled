package cn.damai.tetris.component.star.header;

import cn.damai.tetris.component.star.bean.StarHeaderData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ja;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class StarHeaderPresenterTab extends StarHeaderPresenterBase {
    private static transient /* synthetic */ IpChange $ipChange;

    public StarHeaderPresenterTab(StarHeaderView starHeaderView, String str, ja jaVar) {
        super(starHeaderView, str, jaVar);
    }

    @Override // cn.damai.tetris.component.star.header.StarHeaderPresenterBase
    public int getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "16414458") ? ((Integer) ipChange.ipc$dispatch("16414458", new Object[]{this})).intValue() : StarHeaderData.TYPE_TAB;
    }
}
