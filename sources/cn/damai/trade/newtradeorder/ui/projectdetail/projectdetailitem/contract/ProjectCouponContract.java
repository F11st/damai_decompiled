package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.base.BaseDamaiView;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.CouponActivityBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.CouponApplyDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.VipCardDescWrap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface ProjectCouponContract {

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void getProjectCouponList(String str, String str2);

        public abstract void getVipCardDesc();

        public abstract void receiveProjectCoupon(int i, String str, boolean z, String str2, String str3);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface View extends BaseDamaiView {
        void onReturnCouponListError(String str, String str2);

        void onReturnCouponListSuccess(List<CouponActivityBean> list);

        void onReturnReceiveCouponError(String str, String str2);

        void onReturnReceiveCouponSuccess(int i, String str, CouponApplyDataBean couponApplyDataBean);

        void onReturnVipCardError(String str, String str2);

        void onReturnVipCardSuccess(VipCardDescWrap vipCardDescWrap);
    }
}
