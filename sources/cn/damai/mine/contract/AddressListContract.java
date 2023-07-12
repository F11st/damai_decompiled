package cn.damai.mine.contract;

import cn.damai.common.app.base.AbstractC0470a;
import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.BaseView;
import cn.damai.commonbusiness.address.bean.AddressListBean;
import cn.damai.mine.bean.DefaultAddressBean;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface AddressListContract {

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static abstract class Presenter extends AbstractC0470a<View, Model> {
        public abstract void deleteAddress(String str);

        public abstract void getAddressList();

        public abstract void setDefaultAddress(String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface View extends BaseView {
        void deleteAddressFailed(String str, String str2);

        void deleteAddressSuccess(DefaultAddressBean defaultAddressBean);

        void getAddressListError(String str, String str2);

        void returnAddressList(AddressListBean addressListBean);

        void setDefaultAddressFailed(String str, String str2);

        void setDefaultAddressSuccess(DefaultAddressBean defaultAddressBean);
    }
}
