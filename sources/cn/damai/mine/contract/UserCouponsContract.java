package cn.damai.mine.contract;

import cn.damai.common.app.base.AbstractC0470a;
import cn.damai.common.app.base.BaseModel;
import cn.damai.commonbusiness.base.BaseDamaiView;
import cn.damai.mine.bean.CouponApplyResultBean;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface UserCouponsContract {

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static abstract class Presenter extends AbstractC0470a<View, Model> {
        public abstract void addCoupon(String str, String str2);
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface View extends BaseDamaiView {
        void onReturnExchangeCouponError(String str, String str2);

        void returnAddCoupon(CouponApplyResultBean.CouponApplyDataBean couponApplyDataBean);
    }
}
