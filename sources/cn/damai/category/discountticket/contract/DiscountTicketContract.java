package cn.damai.category.discountticket.contract;

import android.os.Bundle;
import androidx.annotation.Nullable;
import cn.damai.category.discountticket.bean.CouponActivityBean;
import cn.damai.category.discountticket.bean.HeaderCouponBean;
import cn.damai.category.discountticket.bean.HeaderData;
import cn.damai.category.discountticket.bean.biz.FirstPageData;
import cn.damai.category.discountticket.bean.biz.MorePageData;
import cn.damai.category.discountticket.model.BaseListener;
import cn.damai.category.discountticket.model.OnApplyCouponListener;
import cn.damai.category.discountticket.model.OnShareListener;
import cn.damai.category.discountticket.model.OnTListener;
import cn.damai.category.discountticket.ui.IBaseCompatView;
import cn.damai.common.app.base.AbstractC0470a;
import cn.damai.common.app.base.BaseModel;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface DiscountTicketContract {

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface DtModel extends BaseModel {
        void applyCoupon(HeaderCouponBean headerCouponBean, CouponActivityBean couponActivityBean, OnApplyCouponListener onApplyCouponListener);

        boolean changeCityId(String str);

        void destroy();

        @Nullable
        @Deprecated
        ProjectItemBean firstProject();

        String getCityId();

        @Nullable
        HeaderData getHeaderData();

        void load(BaseListener<FirstPageData> baseListener);

        void loadMore(OnTListener<MorePageData> onTListener);

        void share(OnShareListener onShareListener);
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static abstract class DtPresenter extends AbstractC0470a<DtView, DtModel> {
        public abstract void applyCoupon(HeaderCouponBean headerCouponBean, CouponActivityBean couponActivityBean);

        public abstract void changeCity(String str);

        public abstract void load(boolean z);

        public abstract void loadMore();

        public abstract void openMoreActivity();

        public abstract void share();
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface DtView extends IBaseCompatView {
        void showFirstPage(FirstPageData firstPageData);

        void showMorePage(MorePageData morePageData);

        void showShareView(Bundle bundle);

        void updateRecyclerViewItem(Object obj);
    }
}
