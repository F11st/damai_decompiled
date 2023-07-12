package cn.damai.mine.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.mine.bean.RealNameVerifyScheduleBean;
import cn.damai.mine.contract.RealNameVerifyScheduleContract;
import cn.damai.mine.net.RealNameVerifyScheduleRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RealNameVerifySchedulePresenter extends RealNameVerifyScheduleContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.mine.contract.RealNameVerifyScheduleContract.Presenter
    public void fetchRealNameVerifySchedule() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-146681901")) {
            ipChange.ipc$dispatch("-146681901", new Object[]{this});
        } else {
            new RealNameVerifyScheduleRequest().request(new DMMtopRequestListener<RealNameVerifyScheduleBean>(RealNameVerifyScheduleBean.class) { // from class: cn.damai.mine.presenter.RealNameVerifySchedulePresenter.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "558212360")) {
                        ipChange2.ipc$dispatch("558212360", new Object[]{this, str, str2});
                    } else {
                        ((RealNameVerifyScheduleContract.View) RealNameVerifySchedulePresenter.this.mView).fetchRealNameVerifyScheduleFailed(str, str2);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(RealNameVerifyScheduleBean realNameVerifyScheduleBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "879190405")) {
                        ipChange2.ipc$dispatch("879190405", new Object[]{this, realNameVerifyScheduleBean});
                    } else {
                        ((RealNameVerifyScheduleContract.View) RealNameVerifySchedulePresenter.this.mView).fetchRealNameVerifyScheduleSuccess(realNameVerifyScheduleBean);
                    }
                }
            });
        }
    }
}
