package cn.damai.mine.contract;

import cn.damai.common.app.base.AbstractC0470a;
import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.BaseView;
import cn.damai.commonbusiness.faceverify.bean.CertificateTypeBean;
import cn.damai.mine.bean.RealNameAuthBean;
import cn.damai.mine.bean.RealNameCustomerListBean;
import cn.damai.mine.bean.RealNameVerifyBean;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface RealNameAuthContract {

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static abstract class Presenter extends AbstractC0470a<View, Model> {
        public abstract void fetchCertificateType(String str);

        public abstract void fetchCustomers();

        public abstract void getFaceVerifyToken(boolean z);

        public abstract void submitAuth(String str, String str2, String str3);
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface View extends BaseView {
        void authFailed(String str, String str2);

        void authSuccess(RealNameAuthBean realNameAuthBean);

        void fetchCertificateTypeFailed(String str, String str2);

        void fetchCertificateTypeSuccess(CertificateTypeBean certificateTypeBean);

        void fetchCustomersFailed(String str, String str2);

        void fetchCustomersSuccess(RealNameCustomerListBean realNameCustomerListBean);

        void getFaceVerifyTokenFailed(String str, String str2);

        void getFaceVerifyTokenSuccess(RealNameVerifyBean realNameVerifyBean);
    }
}
