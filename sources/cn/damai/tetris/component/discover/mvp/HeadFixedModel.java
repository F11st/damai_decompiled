package cn.damai.tetris.component.discover.mvp;

import cn.damai.commonbusiness.discover.bean.HeadFixedWrapBean;
import cn.damai.tetris.component.discover.mvp.HeadFixedContract;
import cn.damai.tetris.component.drama.bean.CardTitleBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HeadFixedModel extends AbsModel implements HeadFixedContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private HeadFixedWrapBean mBean;

    @Override // cn.damai.tetris.component.discover.mvp.HeadFixedContract.Model
    public HeadFixedWrapBean getBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "899091158") ? (HeadFixedWrapBean) ipChange.ipc$dispatch("899091158", new Object[]{this}) : this.mBean;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1460795356")) {
            ipChange.ipc$dispatch("1460795356", new Object[]{this, baseNode});
            return;
        }
        HeadFixedWrapBean headFixedWrapBean = (HeadFixedWrapBean) m61.d(baseNode.getItem(), HeadFixedWrapBean.class);
        this.mBean = headFixedWrapBean;
        headFixedWrapBean.handleData();
        this.mBean.pos = baseNode.getOffset();
        this.mBean.mTitleBean = CardTitleBean.fromTetrisStyle(baseNode.getStyle());
    }
}
