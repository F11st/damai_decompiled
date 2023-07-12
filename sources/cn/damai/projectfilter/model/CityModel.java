package cn.damai.projectfilter.model;

import cn.damai.projectfilter.bean.CityBean;
import cn.damai.projectfilter.bean.Type;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class CityModel extends GetTFromModel<CityBean> {
    private static transient /* synthetic */ IpChange $ipChange;

    public CityModel(FilterModel filterModel) {
        super(filterModel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // cn.damai.projectfilter.model.GetTFromModel
    public CityBean getT(Type type) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-655913601") ? (CityBean) ipChange.ipc$dispatch("-655913601", new Object[]{this, type}) : this.mModel.mCityBean;
    }
}
