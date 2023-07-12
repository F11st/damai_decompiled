package cn.damai.mine.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.faceverify.bean.CertificateTypeBean;
import cn.damai.commonbusiness.faceverify.request.CertificateTypeRequest;
import cn.damai.mine.bean.RealNameAuthBean;
import cn.damai.mine.bean.RealNameCustomerListBean;
import cn.damai.mine.bean.RealNameVerifyBean;
import cn.damai.mine.contract.RealNameAuthContract;
import cn.damai.mine.net.RealNameAuthRequest;
import cn.damai.mine.net.RealNameCustomerRequest;
import cn.damai.mine.net.RealNameVerifyRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RealNameAuthPresenter extends RealNameAuthContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.mine.contract.RealNameAuthContract.Presenter
    public void fetchCertificateType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "607840575")) {
            ipChange.ipc$dispatch("607840575", new Object[]{this, str});
            return;
        }
        CertificateTypeRequest certificateTypeRequest = new CertificateTypeRequest();
        certificateTypeRequest.scence = str;
        certificateTypeRequest.request(new DMMtopRequestListener<CertificateTypeBean>(CertificateTypeBean.class) { // from class: cn.damai.mine.presenter.RealNameAuthPresenter.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-754064303")) {
                    ipChange2.ipc$dispatch("-754064303", new Object[]{this, str2, str3});
                } else {
                    ((RealNameAuthContract.View) RealNameAuthPresenter.this.mView).fetchCertificateTypeFailed(str2, str3);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(CertificateTypeBean certificateTypeBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-373437501")) {
                    ipChange2.ipc$dispatch("-373437501", new Object[]{this, certificateTypeBean});
                } else {
                    ((RealNameAuthContract.View) RealNameAuthPresenter.this.mView).fetchCertificateTypeSuccess(certificateTypeBean);
                }
            }
        });
    }

    @Override // cn.damai.mine.contract.RealNameAuthContract.Presenter
    public void fetchCustomers() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1372782097")) {
            ipChange.ipc$dispatch("1372782097", new Object[]{this});
            return;
        }
        RealNameCustomerRequest realNameCustomerRequest = new RealNameCustomerRequest();
        realNameCustomerRequest.loginkey = z20.q();
        realNameCustomerRequest.request(new DMMtopRequestListener<RealNameCustomerListBean>(RealNameCustomerListBean.class) { // from class: cn.damai.mine.presenter.RealNameAuthPresenter.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-746304944")) {
                    ipChange2.ipc$dispatch("-746304944", new Object[]{this, str, str2});
                } else {
                    ((RealNameAuthContract.View) RealNameAuthPresenter.this.mView).fetchCustomersFailed(str, str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(RealNameCustomerListBean realNameCustomerListBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "341304609")) {
                    ipChange2.ipc$dispatch("341304609", new Object[]{this, realNameCustomerListBean});
                } else {
                    ((RealNameAuthContract.View) RealNameAuthPresenter.this.mView).fetchCustomersSuccess(realNameCustomerListBean);
                }
            }
        });
    }

    @Override // cn.damai.mine.contract.RealNameAuthContract.Presenter
    public void getFaceVerifyToken(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2017032491")) {
            ipChange.ipc$dispatch("-2017032491", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        RealNameVerifyRequest realNameVerifyRequest = new RealNameVerifyRequest();
        realNameVerifyRequest.loginKey = z20.q();
        if (z) {
            realNameVerifyRequest.subBiz = "accountConflict";
        } else {
            realNameVerifyRequest.subBiz = "accountSafe";
        }
        realNameVerifyRequest.request(new DMMtopRequestListener<RealNameVerifyBean>(RealNameVerifyBean.class) { // from class: cn.damai.mine.presenter.RealNameAuthPresenter.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-769583021")) {
                    ipChange2.ipc$dispatch("-769583021", new Object[]{this, str, str2});
                } else {
                    ((RealNameAuthContract.View) RealNameAuthPresenter.this.mView).getFaceVerifyTokenFailed(str, str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(RealNameVerifyBean realNameVerifyBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1810757415")) {
                    ipChange2.ipc$dispatch("1810757415", new Object[]{this, realNameVerifyBean});
                } else {
                    ((RealNameAuthContract.View) RealNameAuthPresenter.this.mView).getFaceVerifyTokenSuccess(realNameVerifyBean);
                }
            }
        });
    }

    @Override // cn.damai.mine.contract.RealNameAuthContract.Presenter
    public void submitAuth(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "461731114")) {
            ipChange.ipc$dispatch("461731114", new Object[]{this, str, str2, str3});
            return;
        }
        RealNameAuthRequest realNameAuthRequest = new RealNameAuthRequest();
        realNameAuthRequest.loginKey = z20.q();
        realNameAuthRequest.name = str2;
        realNameAuthRequest.idCard = str;
        realNameAuthRequest.idCardType = str3;
        realNameAuthRequest.request(new DMMtopRequestListener<RealNameAuthBean>(RealNameAuthBean.class) { // from class: cn.damai.mine.presenter.RealNameAuthPresenter.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str4, String str5) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-761823662")) {
                    ipChange2.ipc$dispatch("-761823662", new Object[]{this, str4, str5});
                } else {
                    ((RealNameAuthContract.View) RealNameAuthPresenter.this.mView).authFailed(str4, str5);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(RealNameAuthBean realNameAuthBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1863131031")) {
                    ipChange2.ipc$dispatch("1863131031", new Object[]{this, realNameAuthBean});
                } else {
                    ((RealNameAuthContract.View) RealNameAuthPresenter.this.mView).authSuccess(realNameAuthBean);
                }
            }
        });
    }
}
