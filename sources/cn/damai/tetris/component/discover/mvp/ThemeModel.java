package cn.damai.tetris.component.discover.mvp;

import cn.damai.tetris.component.discover.bean.ThemeBean;
import cn.damai.tetris.component.discover.mvp.ThemeContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ThemeModel extends AbsModel implements ThemeContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    ThemeBean mBean;

    @Override // cn.damai.tetris.component.discover.mvp.ThemeContract.Model
    public ThemeBean getBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "701953732") ? (ThemeBean) ipChange.ipc$dispatch("701953732", new Object[]{this}) : this.mBean;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1291646257")) {
            ipChange.ipc$dispatch("1291646257", new Object[]{this, baseNode});
            return;
        }
        ThemeBean themeBean = (ThemeBean) m61.d(baseNode.getItem(), ThemeBean.class);
        this.mBean = themeBean;
        themeBean.pos = baseNode.getOffset();
    }
}
