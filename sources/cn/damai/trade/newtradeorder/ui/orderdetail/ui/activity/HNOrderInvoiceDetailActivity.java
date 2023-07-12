package cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.HNInvoiceDataHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.HNInvoiceDetail;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.HNInvoiceLogisticsState;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.HNInvoiceTrans;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.HNOrderInvoiceDetailRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.api.OrderDetailConstantsApi;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.adapter.HNInvoiceDetailAdapter;
import cn.damai.uikit.irecycler.IRecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.pp2;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class HNOrderInvoiceDetailActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private HNInvoiceDetailAdapter mAdapter;
    private List<HNInvoiceDataHolder> mInvoiceDataList;
    private String mOrderId;
    private IRecyclerView mRecyclerView;
    private View mRootView;

    private void getIntentData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-52569265")) {
            ipChange.ipc$dispatch("-52569265", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        if (intent == null) {
            finish();
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        String string = extras.getString("orderId");
        this.mOrderId = string;
        if (wh2.j(string)) {
            finish();
        }
    }

    private void requestInvoiceData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1189997545")) {
            ipChange.ipc$dispatch("-1189997545", new Object[]{this});
            return;
        }
        onLoadStart();
        requestInvoiceDetail(this.mOrderId);
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-777440217")) {
            ipChange.ipc$dispatch("-777440217", new Object[]{this, Integer.valueOf(i)});
        } else {
            onBackPressed();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2091319651") ? ((Integer) ipChange.ipc$dispatch("2091319651", new Object[]{this})).intValue() : R$layout.activity_order_invoice_detail;
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1455598984")) {
            ipChange.ipc$dispatch("-1455598984", new Object[]{this, Integer.valueOf(i)});
        } else {
            requestInvoiceData();
        }
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1626720246")) {
            ipChange.ipc$dispatch("-1626720246", new Object[]{this});
            return;
        }
        this.mRootView = findViewById(R$id.ll_root);
        this.mRecyclerView = (IRecyclerView) findViewById(R$id.irc);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList arrayList = new ArrayList();
        this.mInvoiceDataList = arrayList;
        HNInvoiceDetailAdapter hNInvoiceDetailAdapter = new HNInvoiceDetailAdapter(this, arrayList);
        this.mAdapter = hNInvoiceDetailAdapter;
        this.mRecyclerView.setAdapter(hNInvoiceDetailAdapter);
        this.mRecyclerView.setRefreshEnabled(false);
        this.mRecyclerView.setLoadMoreEnabled(false);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.getRefreshHeaderView().setVisibility(8);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-850958352")) {
            ipChange.ipc$dispatch("-850958352", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        getIntentData();
        setDamaiUTKeyBuilder(pp2.u().s());
        requestInvoiceData();
    }

    public void onNetError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2016608269")) {
            ipChange.ipc$dispatch("-2016608269", new Object[]{this, str, str2, str3});
            return;
        }
        stopProgressDialog();
        if (wh2.j(str2)) {
            str2 = "网络异常，请稍后重试";
        }
        onResponseError(str2, str, str3, this.mRootView, true);
    }

    public void requestInvoiceDetail(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "325871834")) {
            ipChange.ipc$dispatch("325871834", new Object[]{this, str});
            return;
        }
        HNOrderInvoiceDetailRequest hNOrderInvoiceDetailRequest = new HNOrderInvoiceDetailRequest();
        hNOrderInvoiceDetailRequest.orderId = str;
        hNOrderInvoiceDetailRequest.request(new DMMtopRequestListener<HNInvoiceDetail>(HNInvoiceDetail.class) { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity.HNOrderInvoiceDetailActivity.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1810732259")) {
                    ipChange2.ipc$dispatch("1810732259", new Object[]{this, str2, str3});
                } else {
                    HNOrderInvoiceDetailActivity.this.onNetError(str2, str3, OrderDetailConstantsApi.API_HN_ORDER_INVOICE_DETAIL);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(HNInvoiceDetail hNInvoiceDetail) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2012245488")) {
                    ipChange2.ipc$dispatch("2012245488", new Object[]{this, hNInvoiceDetail});
                } else if (hNInvoiceDetail != null) {
                    HNOrderInvoiceDetailActivity.this.returnInvoiceInfo(hNInvoiceDetail);
                    HNOrderInvoiceDetailActivity.this.onLoadFinish();
                } else {
                    HNOrderInvoiceDetailActivity.this.onNetError("SUCCESS", "InvoicesDetail NULL", OrderDetailConstantsApi.API_HN_ORDER_INVOICE_DETAIL);
                }
            }
        });
    }

    public void returnInvoiceInfo(HNInvoiceDetail hNInvoiceDetail) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1996980554")) {
            ipChange.ipc$dispatch("-1996980554", new Object[]{this, hNInvoiceDetail});
        } else if (hNInvoiceDetail == null) {
            onNetError("SUCCESS", "", OrderDetailConstantsApi.API_HN_ORDER_INVOICE_DETAIL);
        } else {
            this.mInvoiceDataList.clear();
            HNInvoiceDataHolder hNInvoiceDataHolder = new HNInvoiceDataHolder(0);
            hNInvoiceDataHolder.invoicesDetail = hNInvoiceDetail;
            this.mInvoiceDataList.add(hNInvoiceDataHolder);
            HNInvoiceLogisticsState hNInvoiceLogisticsState = hNInvoiceDetail.logisticsStateDetail;
            if (hNInvoiceLogisticsState != null && !TextUtils.isEmpty(hNInvoiceLogisticsState.waybillId)) {
                HNInvoiceDataHolder hNInvoiceDataHolder2 = new HNInvoiceDataHolder(1);
                HNInvoiceLogisticsState hNInvoiceLogisticsState2 = hNInvoiceDetail.logisticsStateDetail;
                hNInvoiceDataHolder2.expressNo = hNInvoiceLogisticsState2.waybillId;
                hNInvoiceDataHolder2.expressName = hNInvoiceLogisticsState2.waybillName;
                hNInvoiceDataHolder2.status = hNInvoiceLogisticsState2.status;
                this.mInvoiceDataList.add(hNInvoiceDataHolder2);
                List<HNInvoiceTrans> list = hNInvoiceDetail.logisticsStateDetail.transitStepInfos;
                int e = wh2.e(list);
                int i = 0;
                while (i < e) {
                    HNInvoiceDataHolder hNInvoiceDataHolder3 = new HNInvoiceDataHolder(2);
                    hNInvoiceDataHolder3.mTransInfo = list.get(i);
                    hNInvoiceDataHolder3.mTransFirst = i == 0;
                    hNInvoiceDataHolder3.mTransEnd = i == e + (-1);
                    this.mInvoiceDataList.add(hNInvoiceDataHolder3);
                    i++;
                }
            }
            HNInvoiceDetailAdapter hNInvoiceDetailAdapter = this.mAdapter;
            if (hNInvoiceDetailAdapter != null) {
                hNInvoiceDetailAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1738719593") ? (String) ipChange.ipc$dispatch("-1738719593", new Object[]{this}) : "发票详情";
    }
}
