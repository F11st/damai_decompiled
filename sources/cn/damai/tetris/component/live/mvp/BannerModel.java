package cn.damai.tetris.component.live.mvp;

import cn.damai.tetris.component.live.bean.LiveHeaderCardBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BannerModel extends AbsModel implements BannerContract$Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private LiveHeaderCardBean bean;

    @Override // cn.damai.tetris.component.live.mvp.BannerContract$Model
    public LiveHeaderCardBean getBannerBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1968853407") ? (LiveHeaderCardBean) ipChange.ipc$dispatch("1968853407", new Object[]{this}) : this.bean;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1731526469")) {
            ipChange.ipc$dispatch("-1731526469", new Object[]{this, baseNode});
            return;
        }
        try {
            this.bean = (LiveHeaderCardBean) m61.d(baseNode.getItem(), LiveHeaderCardBean.class);
        } catch (Exception unused) {
        }
    }
}
