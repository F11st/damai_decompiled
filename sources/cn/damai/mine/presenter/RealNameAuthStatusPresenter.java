package cn.damai.mine.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.model.RealNameAuthStatusBean;
import cn.damai.message.observer.Action;
import cn.damai.mine.bean.RealNameVerifyBean;
import cn.damai.mine.contract.RealNameAuthStatusContract;
import cn.damai.mine.net.RealNameAuthStatusRequest;
import cn.damai.mine.net.RealNameVerifyRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RealNameAuthStatusPresenter extends RealNameAuthStatusContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "544066149")) {
                ipChange.ipc$dispatch("544066149", new Object[]{this, obj});
            } else {
                ((RealNameAuthStatusContract.View) RealNameAuthStatusPresenter.this.mView).faceVerifySuccess();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class b implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1237167846")) {
                ipChange.ipc$dispatch("1237167846", new Object[]{this, obj});
            } else {
                ((RealNameAuthStatusContract.View) RealNameAuthStatusPresenter.this.mView).faceVerifing();
            }
        }
    }

    @Override // cn.damai.mine.contract.RealNameAuthStatusContract.Presenter
    public void getAuthResult() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-128960267")) {
            ipChange.ipc$dispatch("-128960267", new Object[]{this});
            return;
        }
        RealNameAuthStatusRequest realNameAuthStatusRequest = new RealNameAuthStatusRequest();
        realNameAuthStatusRequest.loginKey = z20.q();
        realNameAuthStatusRequest.request(new DMMtopRequestListener<RealNameAuthStatusBean>(RealNameAuthStatusBean.class) { // from class: cn.damai.mine.presenter.RealNameAuthStatusPresenter.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1802899136")) {
                    ipChange2.ipc$dispatch("1802899136", new Object[]{this, str, str2});
                } else {
                    ((RealNameAuthStatusContract.View) RealNameAuthStatusPresenter.this.mView).getAuthStatusFailed(str, str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(RealNameAuthStatusBean realNameAuthStatusBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1703214486")) {
                    ipChange2.ipc$dispatch("-1703214486", new Object[]{this, realNameAuthStatusBean});
                } else {
                    ((RealNameAuthStatusContract.View) RealNameAuthStatusPresenter.this.mView).getAuthStatus(realNameAuthStatusBean);
                }
            }
        });
    }

    @Override // cn.damai.mine.contract.RealNameAuthStatusContract.Presenter
    public void getFaceVerifyToken(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1944782503")) {
            ipChange.ipc$dispatch("1944782503", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        RealNameVerifyRequest realNameVerifyRequest = new RealNameVerifyRequest();
        realNameVerifyRequest.loginKey = z20.q();
        if (z) {
            realNameVerifyRequest.subBiz = "accountConflict";
        } else {
            realNameVerifyRequest.subBiz = "accountSafe";
        }
        realNameVerifyRequest.request(new DMMtopRequestListener<RealNameVerifyBean>(RealNameVerifyBean.class) { // from class: cn.damai.mine.presenter.RealNameAuthStatusPresenter.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1795139777")) {
                    ipChange2.ipc$dispatch("1795139777", new Object[]{this, str, str2});
                } else {
                    ((RealNameAuthStatusContract.View) RealNameAuthStatusPresenter.this.mView).getFaceVerifyTokenFailed(str, str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(RealNameVerifyBean realNameVerifyBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1567752939")) {
                    ipChange2.ipc$dispatch("-1567752939", new Object[]{this, realNameVerifyBean});
                } else {
                    ((RealNameAuthStatusContract.View) RealNameAuthStatusPresenter.this.mView).getFaceVerifyTokenSuccess(realNameVerifyBean);
                }
            }
        });
    }

    @Override // cn.damai.common.app.base.a
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "805579341")) {
            ipChange.ipc$dispatch("805579341", new Object[]{this});
            return;
        }
        super.onStart();
        this.mDMMessage.b("auth_success", new a());
        this.mDMMessage.b("auth_verifing", new b());
    }
}
