package cn.damai.commonbusiness.address.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.BaseView;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.address.bean.AddAddressResultBean;
import cn.damai.commonbusiness.address.bean.DivisionListBean;
import cn.damai.commonbusiness.address.bean.PhoneAllowableResult;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public interface AddAddressContract {

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void addShippingAddress(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13);

        public abstract void getDivisionChildren(int i, String str);

        public abstract void modifyShippingAddress(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14);

        public abstract void retrievePhoneAllowable();
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public interface View extends BaseView {
        void onAddShippingAddressError(String str, String str2);

        void onAddShippingAddressSuccess(AddAddressResultBean addAddressResultBean);

        void onModifyShippingAddressError(String str, String str2);

        void onModifyShippingAddressSuccess(AddAddressResultBean addAddressResultBean);

        void onRetrieveDivisionChildrenError(String str, String str2);

        void onRetrieveDivisionChildrenSuccess(int i, DivisionListBean divisionListBean);

        void onRetrievePhoneAllowableError(String str, String str2);

        void onRetrievePhoneAllowableSuccess(PhoneAllowableResult phoneAllowableResult);
    }
}
