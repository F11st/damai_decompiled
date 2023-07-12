package cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.pay.AliPayActivity;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderAddressModifyResult;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderAddressSubmitResult;
import cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderAddressModifyContract;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.api.OrderDetailConstantsApi;
import cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderAddressModifyPresenter;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.view.ModifyAddressDialog;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.AddressModifyViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.apache.commons.lang3.StringUtils;
import tb.ap1;
import tb.pp2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderModifyAddressActivity extends DamaiBaseActivity<OrderAddressModifyPresenter, OrderAddressModifyContract.Model> implements OrderAddressModifyContract.View, AddressModifyViewHolder.OnDeliveryAddressClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int REQUEST_GOTO_ALIPAY = 1101;
    private static final int REQUEST_NEW_ADDRESS = 1102;
    private LinearLayout mAddressExpLayout;
    private String mAddressId;
    private LinearLayout mAddressLayout;
    private Button mAddressModifySubmit;
    private View.OnClickListener mClickListener = new View$OnClickListenerC2182a();
    private TextView mFreightTv;
    private LayoutInflater mInflater;
    private View mMainView;
    private AddressModifyViewHolder mNewAddressViewHolder;
    private String mOldAddressId;
    private OrderAddressModifyResult mOrderAddressModifyInfo;
    private String mOrderId;
    private AddressModifyViewHolder mOriginalAddressViewHolder;
    private Button mPayBtn;
    private View mPayFreightLayout;
    private String mProjectId;
    private TextView mTipTv;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity.OrderModifyAddressActivity$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2182a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity.OrderModifyAddressActivity$a$a */
        /* loaded from: classes16.dex */
        public class DialogInterface$OnClickListenerC2183a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            DialogInterface$OnClickListenerC2183a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1894074769")) {
                    ipChange.ipc$dispatch("-1894074769", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                C0529c.e().x(pp2.u().k(OrderModifyAddressActivity.this.mOrderId, OrderModifyAddressActivity.this.mProjectId));
                OrderModifyAddressActivity.this.mAddressModifySubmit.setEnabled(false);
                OrderModifyAddressActivity.this.mPayFreightLayout.setEnabled(false);
                OrderModifyAddressActivity orderModifyAddressActivity = OrderModifyAddressActivity.this;
                orderModifyAddressActivity.requestNewAddressSubmit(orderModifyAddressActivity.mOrderId, OrderModifyAddressActivity.this.mAddressId);
            }
        }

        /* compiled from: Taobao */
        /* renamed from: cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity.OrderModifyAddressActivity$a$b */
        /* loaded from: classes16.dex */
        public class DialogInterface$OnClickListenerC2184b implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            DialogInterface$OnClickListenerC2184b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-924493746")) {
                    ipChange.ipc$dispatch("-924493746", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                } else {
                    C0529c.e().x(pp2.u().j(OrderModifyAddressActivity.this.mOrderId, OrderModifyAddressActivity.this.mProjectId));
                }
            }
        }

        View$OnClickListenerC2182a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1451740237")) {
                ipChange.ipc$dispatch("-1451740237", new Object[]{this, view});
                return;
            }
            int id = view.getId();
            if (id == R$id.btn_address_submit || id == R$id.btn_pay) {
                OrderModifyAddressActivity.this.reportSubmitNewAddressClick();
                if (OrderModifyAddressActivity.this.mOrderAddressModifyInfo != null && OrderModifyAddressActivity.this.mOrderAddressModifyInfo.sameAddress) {
                    OrderModifyAddressActivity.this.showSameAddressTip();
                    return;
                }
                ModifyAddressDialog modifyAddressDialog = new ModifyAddressDialog(OrderModifyAddressActivity.this.mContext);
                modifyAddressDialog.b(OrderModifyAddressActivity.this.mOrderAddressModifyInfo.newDeliveryInfo);
                modifyAddressDialog.setCancelable(true);
                modifyAddressDialog.d(new DialogInterface$OnClickListenerC2183a());
                modifyAddressDialog.c(new DialogInterface$OnClickListenerC2184b());
                modifyAddressDialog.show();
                pp2.u().l(OrderModifyAddressActivity.this.mOrderId, OrderModifyAddressActivity.this.mProjectId);
            }
        }
    }

    private String getFormatStyleTipData(String[] strArr, String[] strArr2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1505646356")) {
            return (String) ipChange.ipc$dispatch("-1505646356", new Object[]{this, strArr, strArr2});
        }
        if (strArr == null) {
            return "";
        }
        if (strArr2 != null && strArr2.length != 0) {
            return getFormatTipData(strArr2, true);
        }
        return getFormatTipData(strArr, false);
    }

    private String getFormatTipData(String[] strArr, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2064363570")) {
            return (String) ipChange.ipc$dispatch("-2064363570", new Object[]{this, strArr, Boolean.valueOf(z)});
        }
        if (strArr == null) {
            return "";
        }
        String str = z ? "<br>" : StringUtils.LF;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            if (i == 0) {
                sb.append(strArr[i]);
            } else {
                sb.append(str);
                sb.append(strArr[i]);
            }
        }
        return sb.toString();
    }

    private void getIntentData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1020473127")) {
            ipChange.ipc$dispatch("-1020473127", new Object[]{this});
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return;
        }
        String string = extras.getString("orderId", "");
        this.mOrderId = string;
        if (TextUtils.isEmpty(string)) {
            finish();
        }
        this.mAddressId = extras.getString("addressId", "");
        if (extras.containsKey("projectId")) {
            this.mProjectId = extras.getString("projectId", "");
        }
    }

    private void hideView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "860536782")) {
            ipChange.ipc$dispatch("860536782", new Object[]{this});
            return;
        }
        findViewById(R$id.layout_address_main).setVisibility(4);
        findViewById(R$id.layout_bottom).setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportSubmitNewAddressClick() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1079314957")) {
            ipChange.ipc$dispatch("1079314957", new Object[]{this});
        } else if (this.mOrderAddressModifyInfo == null) {
        } else {
            String E = z20.E();
            int i2 = this.mOrderAddressModifyInfo.supplementType;
            if (i2 == 1) {
                i = 1;
            } else if (i2 == 2) {
                i = 2;
            }
            pp2 u = pp2.u();
            String str = this.mOrderId;
            C0529c.e().x(u.y2(E, str, i + ""));
        }
    }

    private void setAddressData(OrderAddressModifyResult orderAddressModifyResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1606988468")) {
            ipChange.ipc$dispatch("-1606988468", new Object[]{this, orderAddressModifyResult});
            return;
        }
        this.mAddressLayout.removeAllViews();
        AddressModifyViewHolder addressModifyViewHolder = new AddressModifyViewHolder(this, this.mAddressLayout, this.mInflater);
        this.mOriginalAddressViewHolder = addressModifyViewHolder;
        addressModifyViewHolder.b(orderAddressModifyResult.originalDeliveryInfo);
        if (orderAddressModifyResult.originalDeliveryInfo != null) {
            this.mOldAddressId = orderAddressModifyResult.originalDeliveryInfo.addressId + "";
        }
        AddressModifyViewHolder addressModifyViewHolder2 = new AddressModifyViewHolder(this, this.mAddressLayout, this.mInflater);
        this.mNewAddressViewHolder = addressModifyViewHolder2;
        addressModifyViewHolder2.a(orderAddressModifyResult.newDeliveryInfo);
        this.mNewAddressViewHolder.d(this);
    }

    private void setTipData(String[] strArr, String[] strArr2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "703511890")) {
            ipChange.ipc$dispatch("703511890", new Object[]{this, strArr, strArr2});
            return;
        }
        String formatStyleTipData = getFormatStyleTipData(strArr, strArr2);
        if (!TextUtils.isEmpty(formatStyleTipData)) {
            this.mAddressExpLayout.setVisibility(0);
            if (strArr2 != null && strArr2.length > 0) {
                this.mTipTv.setText(Html.fromHtml(formatStyleTipData));
                return;
            } else {
                this.mTipTv.setText(formatStyleTipData);
                return;
            }
        }
        this.mAddressExpLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSameAddressTip() {
        String[] strArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1245968011")) {
            ipChange.ipc$dispatch("1245968011", new Object[]{this});
            return;
        }
        OrderAddressModifyResult.AddressModifyExt addressModifyExt = this.mOrderAddressModifyInfo.ext;
        if (addressModifyExt != null && (strArr = addressModifyExt.tips) != null && strArr.length != 0) {
            ToastUtil.a().e(this, getFormatTipData(strArr, false));
        } else {
            ToastUtil.a().e(this, "新地址与原地址相同,无需修改");
        }
    }

    private void showView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1369106867")) {
            ipChange.ipc$dispatch("1369106867", new Object[]{this});
            return;
        }
        findViewById(R$id.layout_address_main).setVisibility(0);
        findViewById(R$id.layout_bottom).setVisibility(0);
    }

    private void updateBottomBtnStatus(OrderAddressModifyResult orderAddressModifyResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "592925130")) {
            ipChange.ipc$dispatch("592925130", new Object[]{this, orderAddressModifyResult});
        } else if (orderAddressModifyResult.supplementType == 1) {
            this.mPayFreightLayout.setVisibility(0);
            this.mAddressModifySubmit.setVisibility(8);
            SpannableString spannableString = new SpannableString(orderAddressModifyResult.supplementFee);
            int indexOf = orderAddressModifyResult.supplementFee.indexOf(".");
            if (indexOf >= 0) {
                spannableString.setSpan(new RelativeSizeSpan(0.8f), indexOf, orderAddressModifyResult.supplementFee.length(), 17);
                this.mFreightTv.setText(spannableString);
                return;
            }
            this.mFreightTv.setText(orderAddressModifyResult.supplementFee);
        } else {
            this.mPayFreightLayout.setVisibility(8);
            this.mAddressModifySubmit.setVisibility(0);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "809032285")) {
            ipChange.ipc$dispatch("809032285", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 10003) {
            finish();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "678023533") ? ((Integer) ipChange.ipc$dispatch("678023533", new Object[]{this})).intValue() : R$layout.activity_order_address_modfity;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1976861614")) {
            ipChange.ipc$dispatch("1976861614", new Object[]{this, Integer.valueOf(i)});
        } else {
            requestModifyAddressInfo(this.mOrderId, this.mAddressId);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1770938307")) {
            ipChange.ipc$dispatch("-1770938307", new Object[]{this});
        } else {
            ((OrderAddressModifyPresenter) this.mPresenter).setVM(this, (OrderAddressModifyContract.Model) this.mModel);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1993968576")) {
            ipChange.ipc$dispatch("-1993968576", new Object[]{this});
            return;
        }
        this.mInflater = LayoutInflater.from(this);
        this.mMainView = findViewById(R$id.fl_main_content);
        this.mAddressLayout = (LinearLayout) findViewById(R$id.ll_order_address);
        this.mAddressExpLayout = (LinearLayout) findViewById(R$id.tv_tip_container);
        this.mTipTv = (TextView) findViewById(R$id.tv_tip);
        this.mPayFreightLayout = findViewById(R$id.layout_pay_freight);
        this.mAddressModifySubmit = (Button) findViewById(R$id.btn_address_submit);
        Button button = (Button) findViewById(R$id.btn_pay);
        this.mPayBtn = button;
        if (button != null) {
            button.setOnClickListener(this.mClickListener);
        }
        Button button2 = this.mAddressModifySubmit;
        if (button2 != null) {
            button2.setOnClickListener(this.mClickListener);
        }
        this.mFreightTv = (TextView) findViewById(R$id.tv_freight);
        hideView();
        getIntentData();
        setDamaiUTKeyBuilder(new C0525a.C0527b().h(this.mOrderId).i(pp2.ORDER_MODIFY_ADDRESS_PAGE));
        requestModifyAddressInfo(this.mOrderId, this.mAddressId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2125986855")) {
            ipChange.ipc$dispatch("2125986855", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i != 1101) {
            if (i == 1102 && intent != null && i2 == -1) {
                String stringExtra = intent.getStringExtra("addressId");
                this.mAddressId = stringExtra;
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                hideView();
                requestModifyAddressInfo(this.mOrderId, this.mAddressId);
            }
        } else if (intent != null && intent.getBooleanExtra("payResult", false)) {
            setResult(-1);
            ToastUtil.a().e(this, "配送地址修改成功");
            finish();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("projectId:" + this.mProjectId);
            sb.append(",orderId:" + this.mOrderId);
            sb.append(",oldAddressId:" + this.mOldAddressId);
            sb.append(",addressId:" + this.mAddressId);
            sb.append(",fromWhere:补差价支付失败");
            ap1.f(OrderDetailConstantsApi.API_ORDER_DETAIL_MODIFY_ADDRESS, null, "alipay failed", sb.toString());
            this.mAddressModifySubmit.setEnabled(true);
            this.mPayFreightLayout.setEnabled(true);
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.AddressModifyViewHolder.OnDeliveryAddressClickListener
    public void onDeliveryAddressClick(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1696678760")) {
            ipChange.ipc$dispatch("-1696678760", new Object[]{this, str});
            return;
        }
        C0529c.e().x(pp2.u().l1(z20.E(), this.mOrderId));
        Bundle bundle = new Bundle();
        bundle.putString("dm_bundle_address_id", str);
        DMNav.from(this).withExtras(bundle).forResult(1102).toUri(NavUri.b("purchase_address_list"));
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderAddressModifyContract.View
    public void onGetModifyAddressInfoError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2105123740")) {
            ipChange.ipc$dispatch("2105123740", new Object[]{this, str, str2, str3});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("projectId:" + this.mProjectId);
        sb.append(",orderId:" + this.mOrderId);
        sb.append(",addressId:" + this.mAddressId);
        sb.append(",fromWhere:修改配送地址渲染接口失败");
        ap1.f(str3, str, str2, sb.toString());
        if (str2 != null && str2.contains("抱歉，当前排队的人数太多啦，请稍后再试哦")) {
            onResponseError(2, str2, str, str3, this.mMainView, true);
        } else {
            onResponseError(str2, str, str3, this.mMainView, true);
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1075555107")) {
            ipChange.ipc$dispatch("-1075555107", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-399595112")) {
            ipChange.ipc$dispatch("-399595112", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "222241321")) {
            ipChange.ipc$dispatch("222241321", new Object[]{this, str, str2, str3});
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1599532240")) {
            ipChange.ipc$dispatch("-1599532240", new Object[]{this});
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderAddressModifyContract.View
    public void onNewAddressSubmitError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1501313716")) {
            ipChange.ipc$dispatch("-1501313716", new Object[]{this, str, str2});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("project:" + this.mProjectId);
        sb.append(",orderId:" + this.mOrderId);
        sb.append(",oldAddressId:" + this.mOldAddressId);
        sb.append(",addressId:" + this.mAddressId);
        sb.append(",fromWhere:修改配送地址提交新地址接口失败");
        ap1.f(OrderDetailConstantsApi.API_ORDER_DETAIL_SUBMIT_NEW_ADDRESS, str, str2, sb.toString());
        this.mAddressModifySubmit.setEnabled(true);
        this.mPayFreightLayout.setEnabled(true);
        ToastUtil.a().e(this, str2);
    }

    public void requestModifyAddressInfo(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1465325104")) {
            ipChange.ipc$dispatch("-1465325104", new Object[]{this, str, str2});
            return;
        }
        showLoading("");
        ((OrderAddressModifyPresenter) this.mPresenter).requestModifyAddressInfo(str, str2);
    }

    public void requestNewAddressSubmit(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1707322162")) {
            ipChange.ipc$dispatch("-1707322162", new Object[]{this, str, str2});
            return;
        }
        showLoading("");
        ((OrderAddressModifyPresenter) this.mPresenter).requestNewAddressSubmit(str, str2);
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderAddressModifyContract.View
    public void returnModifyAddressInfo(OrderAddressModifyResult orderAddressModifyResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-34992088")) {
            ipChange.ipc$dispatch("-34992088", new Object[]{this, orderAddressModifyResult});
            return;
        }
        onResponseSuccess(this.mMainView);
        showView();
        this.mOrderAddressModifyInfo = orderAddressModifyResult;
        setAddressData(orderAddressModifyResult);
        OrderAddressModifyResult.AddressModifyExt addressModifyExt = orderAddressModifyResult.ext;
        if (addressModifyExt != null) {
            setTipData(addressModifyExt.tips, addressModifyExt.boldtips);
        }
        updateBottomBtnStatus(orderAddressModifyResult);
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderAddressModifyContract.View
    public void returnNewAddressSubmit(OrderAddressSubmitResult orderAddressSubmitResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1152119698")) {
            ipChange.ipc$dispatch("-1152119698", new Object[]{this, orderAddressSubmitResult});
            return;
        }
        onResponseSuccess(this.mMainView);
        OrderAddressModifyResult orderAddressModifyResult = this.mOrderAddressModifyInfo;
        if (orderAddressModifyResult != null && orderAddressModifyResult.supplementType == 1) {
            if (!TextUtils.isEmpty(orderAddressSubmitResult.payurl)) {
                Intent intent = new Intent(this.mContext, AliPayActivity.class);
                intent.putExtra("alipay_param", orderAddressSubmitResult.payurl);
                intent.putExtra("from", "OrderDetailPage");
                intent.putExtra("orderid", this.mOrderId);
                startActivityForResult(intent, 1101);
                return;
            }
            this.mAddressModifySubmit.setEnabled(true);
            this.mPayFreightLayout.setEnabled(true);
            ToastUtil.a().e(this, "支付订单异常");
            return;
        }
        setResult(-1);
        ToastUtil.a().e(this, "配送地址修改成功");
        finish();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1367749921") ? (String) ipChange.ipc$dispatch("1367749921", new Object[]{this}) : "修改配送地址";
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1296906112")) {
            ipChange.ipc$dispatch("1296906112", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-111641028")) {
            ipChange.ipc$dispatch("-111641028", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "121370400")) {
            ipChange.ipc$dispatch("121370400", new Object[]{this, str});
        } else {
            startProgressDialog();
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1797652891")) {
            ipChange.ipc$dispatch("1797652891", new Object[]{this});
        } else {
            stopProgressDialog();
        }
    }
}
