package cn.damai.commonbusiness.address.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.address.bean.AddAddressResultBean;
import cn.damai.commonbusiness.address.bean.DivisionListBean;
import cn.damai.commonbusiness.address.bean.PhoneAllowableBean;
import cn.damai.commonbusiness.address.bean.PhoneAllowableResult;
import cn.damai.commonbusiness.address.contract.AddAddressContract;
import cn.damai.commonbusiness.address.request.AddAddressRequest;
import cn.damai.commonbusiness.address.request.DivisionChildrenRequest;
import cn.damai.commonbusiness.address.request.ModifyAddressRequest;
import cn.damai.commonbusiness.address.request.PhoneAllowableRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.b4;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class AddAddressPresenter extends AddAddressContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.commonbusiness.address.contract.AddAddressContract.Presenter
    public void addShippingAddress(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1450520636")) {
            ipChange.ipc$dispatch("-1450520636", new Object[]{this, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13});
            return;
        }
        AddAddressRequest addAddressRequest = new AddAddressRequest();
        addAddressRequest.loginKey = str;
        addAddressRequest.consigneeName = str3;
        addAddressRequest.mobile = str4;
        addAddressRequest.provinceCode = str5;
        addAddressRequest.province = str6;
        addAddressRequest.cityCode = str7;
        addAddressRequest.city = str8;
        addAddressRequest.countyCode = str9;
        addAddressRequest.county = str10;
        addAddressRequest.streetCode = str11;
        addAddressRequest.street = str12;
        addAddressRequest.addressDetail = str13;
        addAddressRequest.nationPrefix = str2;
        addAddressRequest.request(new DMMtopRequestListener<AddAddressResultBean>(AddAddressResultBean.class) { // from class: cn.damai.commonbusiness.address.presenter.AddAddressPresenter.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str14, String str15) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1496875253")) {
                    ipChange2.ipc$dispatch("-1496875253", new Object[]{this, str14, str15});
                } else {
                    ((AddAddressContract.View) AddAddressPresenter.this.mView).onAddShippingAddressError(str14, str15);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(AddAddressResultBean addAddressResultBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "816665812")) {
                    ipChange2.ipc$dispatch("816665812", new Object[]{this, addAddressResultBean});
                } else {
                    ((AddAddressContract.View) AddAddressPresenter.this.mView).onAddShippingAddressSuccess(addAddressResultBean);
                }
            }
        });
    }

    @Override // cn.damai.commonbusiness.address.contract.AddAddressContract.Presenter
    public void getDivisionChildren(final int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1495208084")) {
            ipChange.ipc$dispatch("-1495208084", new Object[]{this, Integer.valueOf(i), str});
            return;
        }
        DivisionChildrenRequest divisionChildrenRequest = new DivisionChildrenRequest();
        divisionChildrenRequest.divisionId = str;
        divisionChildrenRequest.request(new DMMtopRequestListener<DivisionListBean>(DivisionListBean.class) { // from class: cn.damai.commonbusiness.address.presenter.AddAddressPresenter.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1512393971")) {
                    ipChange2.ipc$dispatch("-1512393971", new Object[]{this, str2, str3});
                } else {
                    ((AddAddressContract.View) AddAddressPresenter.this.mView).onRetrieveDivisionChildrenError(str2, str3);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(DivisionListBean divisionListBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-542389221")) {
                    ipChange2.ipc$dispatch("-542389221", new Object[]{this, divisionListBean});
                } else {
                    ((AddAddressContract.View) AddAddressPresenter.this.mView).onRetrieveDivisionChildrenSuccess(i, divisionListBean);
                }
            }
        });
    }

    @Override // cn.damai.commonbusiness.address.contract.AddAddressContract.Presenter
    public void modifyShippingAddress(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2132140355")) {
            ipChange.ipc$dispatch("2132140355", new Object[]{this, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14});
            return;
        }
        ModifyAddressRequest modifyAddressRequest = new ModifyAddressRequest();
        modifyAddressRequest.loginKey = str;
        modifyAddressRequest.consigneeName = str4;
        modifyAddressRequest.mobile = str5;
        modifyAddressRequest.addressId = str3;
        modifyAddressRequest.provinceCode = str6;
        modifyAddressRequest.province = str7;
        modifyAddressRequest.cityCode = str8;
        modifyAddressRequest.city = str9;
        modifyAddressRequest.countyCode = str10;
        modifyAddressRequest.county = str11;
        modifyAddressRequest.streetCode = str12;
        modifyAddressRequest.street = str13;
        modifyAddressRequest.addressDetail = str14;
        modifyAddressRequest.nationPrefix = str2;
        modifyAddressRequest.request(new DMMtopRequestListener<AddAddressResultBean>(AddAddressResultBean.class) { // from class: cn.damai.commonbusiness.address.presenter.AddAddressPresenter.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str15, String str16) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1504634612")) {
                    ipChange2.ipc$dispatch("-1504634612", new Object[]{this, str15, str16});
                } else {
                    ((AddAddressContract.View) AddAddressPresenter.this.mView).onModifyShippingAddressError(str15, str16);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(AddAddressResultBean addAddressResultBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1683718037")) {
                    ipChange2.ipc$dispatch("1683718037", new Object[]{this, addAddressResultBean});
                } else {
                    ((AddAddressContract.View) AddAddressPresenter.this.mView).onModifyShippingAddressSuccess(addAddressResultBean);
                }
            }
        });
    }

    @Override // cn.damai.commonbusiness.address.contract.AddAddressContract.Presenter
    public void retrievePhoneAllowable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2016962390")) {
            ipChange.ipc$dispatch("2016962390", new Object[]{this});
            return;
        }
        PhoneAllowableRequest phoneAllowableRequest = new PhoneAllowableRequest();
        phoneAllowableRequest.scence = "addressConsigneeMobile";
        phoneAllowableRequest.request(new DMMtopRequestListener<PhoneAllowableResult>(PhoneAllowableResult.class) { // from class: cn.damai.commonbusiness.address.presenter.AddAddressPresenter.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1520153330")) {
                    ipChange2.ipc$dispatch("-1520153330", new Object[]{this, str, str2});
                    return;
                }
                PhoneAllowableResult c = b4.c();
                if (c != null) {
                    ((AddAddressContract.View) AddAddressPresenter.this.mView).onRetrievePhoneAllowableSuccess(c);
                } else {
                    ((AddAddressContract.View) AddAddressPresenter.this.mView).onRetrievePhoneAllowableError(str, str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(PhoneAllowableResult phoneAllowableResult) {
                ArrayList<PhoneAllowableBean> arrayList;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2014837477")) {
                    ipChange2.ipc$dispatch("2014837477", new Object[]{this, phoneAllowableResult});
                    return;
                }
                if (phoneAllowableResult != null && (arrayList = phoneAllowableResult.result) != null && !arrayList.isEmpty()) {
                    b4.a(phoneAllowableResult);
                } else {
                    phoneAllowableResult = b4.c();
                }
                ((AddAddressContract.View) AddAddressPresenter.this.mView).onRetrievePhoneAllowableSuccess(phoneAllowableResult);
            }
        });
    }
}
