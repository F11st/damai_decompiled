package cn.damai.trade.newtradeorder.ui.orderdetail.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.base.BaseDamaiView;
import cn.damai.commonbusiness.notice.bean.ItemContent;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailBean;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailCanResellBean;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailTicketService;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderPayDTO;
import cn.damai.trade.oldtradeorder.ui.orderdetail.detail.model.OrderParmasResult;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface OrderDetailContract {

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void cancelOrderDetail(String str);

        public abstract void getOrderDetailData(String str, boolean z, boolean z2);

        public abstract void orderDetailCanResell(String str);

        public abstract void orderDetailChooseSeatRemind(String str);

        public abstract void orderDetailDeliveryRemind(String str);

        public abstract void orderDetailPay(String str, String str2, String str3, int i);

        public abstract void orderDetailRefundCheck(String str, String str2);

        public abstract void orderWolfDetailPay(String str, String str2);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface View extends BaseDamaiView {
        void jumpTicketServicePage(ArrayList<OrderDetailTicketService> arrayList);

        void openNoticePop(ArrayList<ItemContent> arrayList);

        void refundCheckResult(boolean z, String str, String str2);

        void requestCanReSellRequest();

        void requestRefundCheckRequest(String str);

        void returnCanResellData(OrderDetailCanResellBean orderDetailCanResellBean, boolean z);

        void returnOrderDetailCancel();

        void returnOrderDetailCancelFail(String str, String str2);

        void returnOrderDetailData(OrderDetailBean orderDetailBean);

        void returnOrderDetailFail(String str, String str2, String str3);

        void returnOrderDetailPay(OrderPayDTO orderPayDTO);

        void returnOrderDetailPayFail(String str, String str2);

        void returnOrderDetailWolfPay(OrderParmasResult orderParmasResult);
    }
}
