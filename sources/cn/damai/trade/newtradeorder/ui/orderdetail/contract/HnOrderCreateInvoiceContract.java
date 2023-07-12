package cn.damai.trade.newtradeorder.ui.orderdetail.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.base.BaseDamaiView;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.hn.HnInvoiceApplyInfoResult;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.hn.HnInvoiceSubmitInfoResult;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.HNOrderInvoiceSubmitRequest;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface HnOrderCreateInvoiceContract {

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void requestInvoiceInfo(String str);

        public abstract void submitInvoiceInfo(HNOrderInvoiceSubmitRequest hNOrderInvoiceSubmitRequest);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface View extends BaseDamaiView {
        void returnInvoiceInfo(HnInvoiceApplyInfoResult hnInvoiceApplyInfoResult);

        void returnInvoiceInfoError(String str, String str2, String str3);

        void returnInvoiceSubmitInfo(HnInvoiceSubmitInfoResult hnInvoiceSubmitInfoResult);

        void returnInvoiceSubmitInfoError(String str, String str2);
    }
}
