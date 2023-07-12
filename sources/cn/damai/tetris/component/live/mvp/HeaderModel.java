package cn.damai.tetris.component.live.mvp;

import cn.damai.tetris.component.live.bean.LiveHeaderPicBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HeaderModel extends AbsModel implements HeaderContract$Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private LiveHeaderPicBean bean;

    @Override // cn.damai.tetris.component.live.mvp.HeaderContract$Model
    public LiveHeaderPicBean getHeaderBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1481425981") ? (LiveHeaderPicBean) ipChange.ipc$dispatch("1481425981", new Object[]{this}) : this.bean;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-811850340")) {
            ipChange.ipc$dispatch("-811850340", new Object[]{this, baseNode});
            return;
        }
        try {
            this.bean = (LiveHeaderPicBean) m61.d(baseNode.getItem(), LiveHeaderPicBean.class);
        } catch (Exception unused) {
        }
    }
}
