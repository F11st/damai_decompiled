package cn.damai.mine.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.mine.bean.AcquireScoreDto;
import cn.damai.mine.bean.LostScoreDto;
import cn.damai.mine.bean.UserScoreDto;
import cn.damai.mine.contract.IntegralContract;
import cn.damai.mine.net.GetScoreConsumListRequest;
import cn.damai.mine.net.GetScoreInfoRequest;
import cn.damai.mine.net.GetScoreListRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.dg1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class IntegralPresenter extends IntegralContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.mine.contract.IntegralContract.Presenter
    public void requestIntegralList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-665486912")) {
            ipChange.ipc$dispatch("-665486912", new Object[]{this});
        } else {
            new GetScoreInfoRequest().request(new DMMtopRequestListener<UserScoreDto>(UserScoreDto.class) { // from class: cn.damai.mine.presenter.IntegralPresenter.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "21519445")) {
                        ipChange2.ipc$dispatch("21519445", new Object[]{this, str, str2});
                    } else {
                        ((IntegralContract.View) IntegralPresenter.this.mView).stopLoading();
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(UserScoreDto userScoreDto) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "302797123")) {
                        ipChange2.ipc$dispatch("302797123", new Object[]{this, userScoreDto});
                        return;
                    }
                    ((IntegralContract.View) IntegralPresenter.this.mView).stopLoading();
                    ((IntegralContract.View) IntegralPresenter.this.mView).returnIntegralList(userScoreDto);
                }
            });
        }
    }

    @Override // cn.damai.mine.contract.IntegralContract.Presenter
    public void requestPointsIntegral(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2010150875")) {
            ipChange.ipc$dispatch("-2010150875", new Object[]{this, str});
            return;
        }
        GetScoreListRequest getScoreListRequest = new GetScoreListRequest();
        getScoreListRequest.pageIndex = str;
        getScoreListRequest.request(new DMMtopRequestListener<AcquireScoreDto>(AcquireScoreDto.class) { // from class: cn.damai.mine.presenter.IntegralPresenter.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "13760086")) {
                    ipChange2.ipc$dispatch("13760086", new Object[]{this, str2, str3});
                } else {
                    dg1.c("-1000", str3);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(AcquireScoreDto acquireScoreDto) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-277828559")) {
                    ipChange2.ipc$dispatch("-277828559", new Object[]{this, acquireScoreDto});
                    return;
                }
                ((IntegralContract.View) IntegralPresenter.this.mView).stopLoading();
                ((IntegralContract.View) IntegralPresenter.this.mView).returnPointsIntegral(acquireScoreDto);
            }
        });
    }

    @Override // cn.damai.mine.contract.IntegralContract.Presenter
    public void requestSumptionIntegral(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1447650449")) {
            ipChange.ipc$dispatch("-1447650449", new Object[]{this, str});
            return;
        }
        GetScoreConsumListRequest getScoreConsumListRequest = new GetScoreConsumListRequest();
        getScoreConsumListRequest.pageIndex = str;
        getScoreConsumListRequest.request(new DMMtopRequestListener<LostScoreDto>(LostScoreDto.class) { // from class: cn.damai.mine.presenter.IntegralPresenter.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "6000727")) {
                    ipChange2.ipc$dispatch("6000727", new Object[]{this, str2, str3});
                } else {
                    ((IntegralContract.View) IntegralPresenter.this.mView).stopLoading();
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(LostScoreDto lostScoreDto) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2071939148")) {
                    ipChange2.ipc$dispatch("2071939148", new Object[]{this, lostScoreDto});
                    return;
                }
                ((IntegralContract.View) IntegralPresenter.this.mView).stopLoading();
                ((IntegralContract.View) IntegralPresenter.this.mView).returnSumptionIntegral(lostScoreDto);
            }
        });
    }
}
