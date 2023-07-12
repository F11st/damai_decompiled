package cn.damai.mine.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.base.BaseDamaiView;
import cn.damai.mine.bean.CouponData;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface CouponsListContract {

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void loadCouponsList(String str, int i, boolean z, int i2, int i3);
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface View extends BaseDamaiView {
        void returnLoadCouponsList(CouponData.DiscountContainer discountContainer);
    }
}
