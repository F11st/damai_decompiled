package cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.address.bean.AddressBean;
import cn.damai.commonbusiness.address.bean.AddressListBean;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.pay.AliPayActivity;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.InvoiceAddBean;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.InvoiceAddInfo;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.InvoicePayInfo;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.InvoiceSubmitResult;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.InvoiceTitleInfo;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.InvoicesTrans;
import cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderInvoiceContract;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.api.OrderDetailConstantsApi;
import cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderInvoicePresenter;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.InvoiceTypeViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.ap1;
import tb.c41;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderInvoiceActivity extends DamaiBaseActivity<OrderInvoicePresenter, OrderInvoiceContract.Model> implements OrderInvoiceContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private LayoutInflater mInflater;
    private InvoiceAddBean mInvoiceBean;
    private LinearLayout mInvoiceDeliveryWayLayout;
    private c41 mInvoiceHeaderViewHolder;
    private String mInvoicePhone;
    private AddressBean mInvoiceSelectAddress;
    private int mInvoiceSelectTitle;
    private Button mInvoiceSubmit;
    private String mInvoiceTaxNumStr;
    private LinearLayout mInvoiceTitleLayout;
    private String mInvoiceTitleStr;
    private InvoiceTypeViewHolder mInvoiceTypeViewHolder;
    private String mInvoiceUserName;
    private String mOrderId;
    private String mProjectId;
    private FrameLayout mRootView;
    private String mSelectAddressId;
    private String mSelectDeliveryType;
    private String payId;
    private String mErrorCode = "SUCCESS";
    private View.OnClickListener mClickListener = new a();

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "913096582")) {
                ipChange.ipc$dispatch("913096582", new Object[]{this, view});
            } else if (view.getId() == R$id.btn_invoice_submit) {
                OrderInvoiceActivity.this.mInvoiceSubmit.setEnabled(false);
                OrderInvoiceActivity.this.requestInvoiceSubmit();
            }
        }
    }

    private void getIntentData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1200257382")) {
            ipChange.ipc$dispatch("1200257382", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        if (intent == null) {
            finish();
        }
        String stringExtra = intent.getStringExtra("orderId");
        this.mOrderId = stringExtra;
        if (wh2.j(stringExtra)) {
            finish();
        }
        this.mProjectId = intent.getStringExtra("projectId");
    }

    private void resetSubmitBtn() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2115610259")) {
            ipChange.ipc$dispatch("2115610259", new Object[]{this});
        } else {
            this.mInvoiceSubmit.setEnabled(true);
        }
    }

    private void showInvoiceContent(List<InvoiceTitleInfo> list, List<AddressBean> list2, List<InvoicesTrans> list3, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "306235996")) {
            ipChange.ipc$dispatch("306235996", new Object[]{this, list, list2, list3, str});
            return;
        }
        stopProgressDialog();
        this.mInvoiceSubmit.setVisibility(0);
        c41 c41Var = new c41(this, this.mInvoiceTitleLayout, this.mInflater);
        this.mInvoiceHeaderViewHolder = c41Var;
        c41Var.e(list);
        this.mInvoiceTypeViewHolder = new InvoiceTypeViewHolder(this, this.mInvoiceDeliveryWayLayout, this.mInflater, this.mRootView);
        if (wh2.e(list2) > 0) {
            this.mInvoiceTypeViewHolder.y(list2);
        }
        this.mInvoiceTypeViewHolder.o(list3, str);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1084601680")) {
            ipChange.ipc$dispatch("-1084601680", new Object[]{this, Integer.valueOf(i)});
        } else {
            onBackPressed();
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderInvoiceContract.View
    public void deliveryTypeChanged(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2112562938")) {
            ipChange.ipc$dispatch("-2112562938", new Object[]{this, str});
        } else if ("1".equals(str)) {
            this.mInvoiceSubmit.setText("确定并支付");
        } else {
            this.mInvoiceSubmit.setText("确定");
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2126366406") ? ((Integer) ipChange.ipc$dispatch("-2126366406", new Object[]{this})).intValue() : R$layout.activity_order_invoice;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "940119425")) {
            ipChange.ipc$dispatch("940119425", new Object[]{this, Integer.valueOf(i)});
        } else {
            requestInvoiceInfo();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "449792202")) {
            ipChange.ipc$dispatch("449792202", new Object[]{this});
        } else {
            ((OrderInvoicePresenter) this.mPresenter).setVM(this, (OrderInvoiceContract.Model) this.mModel);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1673861229")) {
            ipChange.ipc$dispatch("-1673861229", new Object[]{this});
            return;
        }
        this.mInflater = LayoutInflater.from(this);
        this.mRootView = (FrameLayout) findViewById(R$id.fl_order_content);
        this.mInvoiceTitleLayout = (LinearLayout) findViewById(R$id.ll_invoice_title);
        this.mInvoiceDeliveryWayLayout = (LinearLayout) findViewById(R$id.ll_invoice_way);
        Button button = (Button) findViewById(R$id.btn_invoice_submit);
        this.mInvoiceSubmit = button;
        button.setVisibility(8);
        this.mInvoiceSubmit.setEnabled(true);
        this.mInvoiceSubmit.setOnClickListener(this.mClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Parcelable parcelableExtra;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2093622598")) {
            ipChange.ipc$dispatch("-2093622598", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i != 10001) {
            if (i == 2000) {
                setResult(-1);
                finish();
            }
        } else if (i2 != -1 || intent == null || (parcelableExtra = intent.getParcelableExtra("added_address")) == null) {
        } else {
            AddressBean addressBean = (AddressBean) parcelableExtra;
            InvoiceTypeViewHolder invoiceTypeViewHolder = this.mInvoiceTypeViewHolder;
            if (invoiceTypeViewHolder != null) {
                invoiceTypeViewHolder.i(addressBean);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2034110919")) {
            ipChange.ipc$dispatch("2034110919", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        getIntentData();
        requestInvoiceInfo();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2112297296")) {
            ipChange.ipc$dispatch("-2112297296", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1090982245")) {
            ipChange.ipc$dispatch("1090982245", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2091024260")) {
            ipChange.ipc$dispatch("-2091024260", new Object[]{this, str, str2, str3});
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1658692867")) {
            ipChange.ipc$dispatch("1658692867", new Object[]{this});
        } else {
            onResponseSuccess(this.mRootView);
        }
    }

    public void requestAddressInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "308048437")) {
            ipChange.ipc$dispatch("308048437", new Object[]{this});
        } else {
            ((OrderInvoicePresenter) this.mPresenter).requestAddressList();
        }
    }

    public void requestInvoiceInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "482797788")) {
            ipChange.ipc$dispatch("482797788", new Object[]{this});
            return;
        }
        startProgressDialog();
        ((OrderInvoicePresenter) this.mPresenter).requestInvoiceInfo(this.mOrderId);
    }

    public void requestInvoiceSubmit() {
        InvoicePayInfo invoicePayInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-717784078")) {
            ipChange.ipc$dispatch("-717784078", new Object[]{this});
            return;
        }
        c41 c41Var = this.mInvoiceHeaderViewHolder;
        if (c41Var == null) {
            resetSubmitBtn();
            return;
        }
        this.mInvoiceTitleStr = "";
        this.mInvoiceTaxNumStr = "";
        int d = c41Var.d();
        this.mInvoiceSelectTitle = d;
        if (d != 1) {
            if (d != 2) {
                resetSubmitBtn();
                return;
            }
            this.mInvoiceTitleStr = this.mInvoiceHeaderViewHolder.c();
            this.mInvoiceTaxNumStr = this.mInvoiceHeaderViewHolder.b();
            if (wh2.j(this.mInvoiceTitleStr) || wh2.j(this.mInvoiceTaxNumStr)) {
                ToastUtil.i("请输入发票信息");
                resetSubmitBtn();
                return;
            }
        }
        InvoiceTypeViewHolder invoiceTypeViewHolder = this.mInvoiceTypeViewHolder;
        if (invoiceTypeViewHolder == null) {
            resetSubmitBtn();
            return;
        }
        this.mInvoiceUserName = "";
        this.mInvoicePhone = "";
        this.mInvoiceSelectAddress = null;
        this.mSelectAddressId = "";
        String k = invoiceTypeViewHolder.k();
        this.mSelectDeliveryType = k;
        if (k.equals("2")) {
            this.mInvoiceUserName = this.mInvoiceTypeViewHolder.l();
            this.mInvoicePhone = this.mInvoiceTypeViewHolder.j();
            if (wh2.j(this.mInvoiceUserName)) {
                ToastUtil.i("请输入取票人姓名");
                resetSubmitBtn();
                return;
            } else if (wh2.j(this.mInvoicePhone)) {
                ToastUtil.i("请输入手机");
                resetSubmitBtn();
                return;
            } else {
                this.payId = "0";
            }
        } else if (this.mSelectDeliveryType.equals("1")) {
            AddressBean n = this.mInvoiceTypeViewHolder.n();
            this.mInvoiceSelectAddress = n;
            if (n == null) {
                ToastUtil.i(getResources().getString(R$string.damai_orderconfirmchooseseat_add_address));
                resetSubmitBtn();
                return;
            }
            this.mSelectAddressId = n.getAddressId();
            this.payId = "96";
            InvoiceAddBean invoiceAddBean = this.mInvoiceBean;
            if (invoiceAddBean != null && wh2.e(invoiceAddBean.pay) > 0 && (invoicePayInfo = this.mInvoiceBean.pay.get(0)) != null) {
                this.payId = invoicePayInfo.payId;
            }
        }
        startProgressDialog();
        this.mInvoiceSubmit.setEnabled(false);
        ((OrderInvoicePresenter) this.mPresenter).requestSubmitInvoice(this.mOrderId, String.valueOf(this.mInvoiceSelectTitle), this.mInvoiceTitleStr, this.mInvoiceTaxNumStr, String.valueOf(this.mSelectDeliveryType), this.mInvoiceUserName, this.mInvoicePhone, String.valueOf(this.mSelectAddressId), this.payId);
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderInvoiceContract.View
    public void returnAddressList(AddressListBean addressListBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-817921144")) {
            ipChange.ipc$dispatch("-817921144", new Object[]{this, addressListBean});
            return;
        }
        InvoiceAddBean invoiceAddBean = this.mInvoiceBean;
        if (invoiceAddBean == null) {
            return;
        }
        if (addressListBean != null) {
            List<InvoiceTitleInfo> list = invoiceAddBean.invoice;
            List<AddressBean> list2 = addressListBean.getList();
            InvoiceAddBean invoiceAddBean2 = this.mInvoiceBean;
            showInvoiceContent(list, list2, invoiceAddBean2.trans, invoiceAddBean2.aomunt);
            return;
        }
        showInvoiceContent(invoiceAddBean.invoice, null, invoiceAddBean.trans, invoiceAddBean.aomunt);
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderInvoiceContract.View
    public void returnAddressListError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2011743446")) {
            ipChange.ipc$dispatch("2011743446", new Object[]{this, str, str2});
            return;
        }
        InvoiceAddBean invoiceAddBean = this.mInvoiceBean;
        if (invoiceAddBean != null) {
            showInvoiceContent(invoiceAddBean.invoice, null, invoiceAddBean.trans, invoiceAddBean.aomunt);
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderInvoiceContract.View
    public void returnInvoiceInfo(InvoiceAddInfo invoiceAddInfo) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1875819383")) {
            ipChange.ipc$dispatch("-1875819383", new Object[]{this, invoiceAddInfo});
        } else if (invoiceAddInfo != null && invoiceAddInfo.os) {
            this.mInvoiceBean = null;
            InvoiceAddBean invoiceAddBean = invoiceAddInfo.info;
            this.mInvoiceBean = invoiceAddBean;
            if (invoiceAddBean == null) {
                returnInvoiceInfoError(this.mErrorCode, invoiceAddInfo.error);
                return;
            }
            int e = wh2.e(invoiceAddBean.trans);
            if (wh2.e(this.mInvoiceBean.invoice) == 0 || e == 0) {
                returnInvoiceInfoError(this.mErrorCode, invoiceAddInfo.error);
                return;
            }
            int i = 0;
            while (true) {
                if (i >= e) {
                    z = false;
                    break;
                } else if (this.mInvoiceBean.trans.get(i).transId.equals("1")) {
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                requestAddressInfo();
                return;
            }
            InvoiceAddBean invoiceAddBean2 = this.mInvoiceBean;
            showInvoiceContent(invoiceAddBean2.invoice, null, invoiceAddBean2.trans, invoiceAddBean2.aomunt);
        } else {
            returnInvoiceInfoError(this.mErrorCode, invoiceAddInfo.error);
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderInvoiceContract.View
    public void returnInvoiceInfoError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1410175519")) {
            ipChange.ipc$dispatch("1410175519", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        this.mInvoiceSubmit.setVisibility(8);
        if (wh2.j(str2)) {
            str2 = "网络异常，请稍后重试";
        }
        onResponseError(str2, str, OrderDetailConstantsApi.API_ZL_ORDER_INVOICE_INFO, this.mRootView, true);
        ap1.d(OrderDetailConstantsApi.API_ZL_ORDER_INVOICE_INFO, str, str2, "projectId:" + this.mProjectId + ",orderId:" + this.mOrderId + ",fromWhere:发票渲染接口失败");
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderInvoiceContract.View
    public void returnSubmitInvoiceError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "907337945")) {
            ipChange.ipc$dispatch("907337945", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        resetSubmitBtn();
        if (wh2.j(str2)) {
            str2 = "发票信息提交失败请稍后重试";
        }
        ToastUtil.i(str2);
        ap1.d(OrderDetailConstantsApi.API_ZL_ORDER_INVOICE_SUBMIT, str, str2, "projectId:" + this.mProjectId + ",orderId:" + this.mOrderId + ",fromWhere:发票提交信息接口失败");
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderInvoiceContract.View
    public void returnSubmitInvoiceInfo(InvoiceSubmitResult invoiceSubmitResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-255363141")) {
            ipChange.ipc$dispatch("-255363141", new Object[]{this, invoiceSubmitResult});
            return;
        }
        if (invoiceSubmitResult == null) {
            returnSubmitInvoiceError(this.mErrorCode, "");
        }
        if (invoiceSubmitResult.os) {
            stopProgressDialog();
            resetSubmitBtn();
            if (this.mSelectDeliveryType.equals("1")) {
                if (wh2.j(invoiceSubmitResult.payParm)) {
                    returnSubmitInvoiceError(this.mErrorCode, invoiceSubmitResult.error);
                    return;
                }
                Intent intent = new Intent(this.mContext, AliPayActivity.class);
                intent.putExtra("alipay_param", invoiceSubmitResult.payParm);
                intent.putExtra("orderid", this.mOrderId + "");
                startActivityForResult(intent, 2000);
                return;
            }
            setResult(-1);
            finish();
            return;
        }
        returnSubmitInvoiceError(this.mErrorCode, invoiceSubmitResult.error);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1932365266") ? (String) ipChange.ipc$dispatch("-1932365266", new Object[]{this}) : "大麦订单";
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-777330675")) {
            ipChange.ipc$dispatch("-777330675", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "393477513")) {
            ipChange.ipc$dispatch("393477513", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "416867757")) {
            ipChange.ipc$dispatch("416867757", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1006737048")) {
            ipChange.ipc$dispatch("-1006737048", new Object[]{this});
        }
    }
}
