package cn.damai.commonbusiness.faceverify.contract;

import cn.damai.common.app.base.AbstractC0470a;
import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.BaseView;
import cn.damai.commonbusiness.faceverify.bean.CertificateTypeBean;
import cn.damai.commonbusiness.faceverify.bean.IdentityInfoQueryBean;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public interface IdentityInfoQueryContract {

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public static abstract class Presenter extends AbstractC0470a<View, Model> {
        public abstract void fetchCertificateType(String str);

        public abstract void queryIdentityInfo(String str, String str2, String str3);
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public interface View extends BaseView {
        void closeSelf();

        void fetchCertificateTypeFailed(String str, String str2);

        void fetchCertificateTypeSuccess(CertificateTypeBean certificateTypeBean);

        void queryIdentityInfoFailed(String str, String str2);

        void queryIdentityInfoSuccess(IdentityInfoQueryBean identityInfoQueryBean);
    }
}
