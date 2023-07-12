package cn.damai.projectfilter.model;

import cn.damai.projectfilter.bean.SortBean;
import cn.damai.projectfilter.bean.Type;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SortT extends GetTFromModel<SortBean> {
    private static transient /* synthetic */ IpChange $ipChange;

    public SortT(FilterModel filterModel) {
        super(filterModel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // cn.damai.projectfilter.model.GetTFromModel
    public SortBean getT(Type type) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "419792820") ? (SortBean) ipChange.ipc$dispatch("419792820", new Object[]{this, type}) : this.mModel.mSortBean;
    }
}
