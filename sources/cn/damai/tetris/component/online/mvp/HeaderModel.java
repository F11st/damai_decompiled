package cn.damai.tetris.component.online.mvp;

import cn.damai.tetris.component.online.bean.ArtistBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HeaderModel extends AbsModel implements HeaderContract$Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private ArtistBean bean;

    @Override // cn.damai.tetris.component.online.mvp.HeaderContract$Model
    public ArtistBean getTopBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "553254547") ? (ArtistBean) ipChange.ipc$dispatch("553254547", new Object[]{this}) : this.bean;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1643103851")) {
            ipChange.ipc$dispatch("-1643103851", new Object[]{this, baseNode});
            return;
        }
        try {
            this.bean = (ArtistBean) m61.d(baseNode.getItem(), ArtistBean.class);
        } catch (Exception unused) {
        }
    }
}
