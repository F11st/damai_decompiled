package cn.damai.mine.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.address.bean.AddressListBean;
import cn.damai.commonbusiness.address.net.AddressListRequest;
import cn.damai.mine.bean.DefaultAddressBean;
import cn.damai.mine.contract.AddressListContract;
import cn.damai.mine.model.DeleteAddressRequest;
import cn.damai.mine.model.SetDefaultAddressRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class AddressListPresenter extends AddressListContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.mine.contract.AddressListContract.Presenter
    public void deleteAddress(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1844427512")) {
            ipChange.ipc$dispatch("1844427512", new Object[]{this, str});
            return;
        }
        DeleteAddressRequest deleteAddressRequest = new DeleteAddressRequest();
        deleteAddressRequest.addressId = str;
        deleteAddressRequest.loginKey = z20.q();
        deleteAddressRequest.request(new DMMtopRequestListener<DefaultAddressBean>(DefaultAddressBean.class) { // from class: cn.damai.mine.presenter.AddressListPresenter.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-757484168")) {
                    ipChange2.ipc$dispatch("-757484168", new Object[]{this, str2, str3});
                } else {
                    ((AddressListContract.View) AddressListPresenter.this.mView).deleteAddressFailed(str2, str3);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(DefaultAddressBean defaultAddressBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1284532197")) {
                    ipChange2.ipc$dispatch("-1284532197", new Object[]{this, defaultAddressBean});
                } else {
                    ((AddressListContract.View) AddressListPresenter.this.mView).deleteAddressSuccess(defaultAddressBean);
                }
            }
        });
    }

    @Override // cn.damai.mine.contract.AddressListContract.Presenter
    public void getAddressList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1934617833")) {
            ipChange.ipc$dispatch("-1934617833", new Object[]{this});
            return;
        }
        AddressListRequest addressListRequest = new AddressListRequest();
        addressListRequest.loginKey = z20.q();
        addressListRequest.returnAll = "1";
        addressListRequest.request(new DMMtopRequestListener<AddressListBean>(AddressListBean.class) { // from class: cn.damai.mine.presenter.AddressListPresenter.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-749724809")) {
                    ipChange2.ipc$dispatch("-749724809", new Object[]{this, str, str2});
                } else {
                    ((AddressListContract.View) AddressListPresenter.this.mView).getAddressListError(str, str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(AddressListBean addressListBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-728472146")) {
                    ipChange2.ipc$dispatch("-728472146", new Object[]{this, addressListBean});
                } else {
                    ((AddressListContract.View) AddressListPresenter.this.mView).returnAddressList(addressListBean);
                }
            }
        });
    }

    @Override // cn.damai.mine.contract.AddressListContract.Presenter
    public void setDefaultAddress(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1951919564")) {
            ipChange.ipc$dispatch("1951919564", new Object[]{this, str});
            return;
        }
        SetDefaultAddressRequest setDefaultAddressRequest = new SetDefaultAddressRequest();
        setDefaultAddressRequest.addressId = str;
        setDefaultAddressRequest.loginKey = z20.q();
        setDefaultAddressRequest.request(new DMMtopRequestListener<DefaultAddressBean>(DefaultAddressBean.class) { // from class: cn.damai.mine.presenter.AddressListPresenter.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-765243527")) {
                    ipChange2.ipc$dispatch("-765243527", new Object[]{this, str2, str3});
                } else {
                    ((AddressListContract.View) AddressListPresenter.this.mView).setDefaultAddressFailed(str2, str3);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(DefaultAddressBean defaultAddressBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-591139492")) {
                    ipChange2.ipc$dispatch("-591139492", new Object[]{this, defaultAddressBean});
                } else {
                    ((AddressListContract.View) AddressListPresenter.this.mView).setDefaultAddressSuccess(defaultAddressBean);
                }
            }
        });
    }
}
