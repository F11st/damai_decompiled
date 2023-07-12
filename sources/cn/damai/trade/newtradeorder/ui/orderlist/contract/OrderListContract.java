package cn.damai.trade.newtradeorder.ui.orderlist.contract;

import cn.damai.common.app.base.AbstractC0470a;
import cn.damai.common.app.base.BaseModel;
import cn.damai.commonbusiness.base.BaseDamaiView;
import cn.damai.trade.newtradeorder.ui.orderlist.bean.OrderListResultBean;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface OrderListContract {

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static abstract class Presenter extends AbstractC0470a<View, Model> {
        public abstract void getOrderListData(int i, int i2, int i3);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface View extends BaseDamaiView {
        void orderListRefreshNotify();

        void returnOrderListData(OrderListResultBean orderListResultBean);

        void startTimerNotify();
    }
}
