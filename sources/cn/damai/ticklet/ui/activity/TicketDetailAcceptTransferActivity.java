package cn.damai.ticklet.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.app.widget.ProtocolDialog;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.login.LoginManager;
import cn.damai.login.YouKuTrustListener;
import cn.damai.member.R$color;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.AcceptTransferH5Params;
import cn.damai.ticklet.bean.TicketPerformTransferAcceptResult;
import cn.damai.ticklet.bean.TicketTable;
import cn.damai.ticklet.bean.TicketTransferTicketPersonMapping;
import cn.damai.ticklet.bean.Tips;
import cn.damai.ticklet.net.TickletDetailConfirmAcceptUtil;
import cn.damai.ticklet.net.TickletTransferWaitingAcceptListRequest;
import cn.damai.ticklet.ui.adapter.TickletTransferDetailWaitAcceptAdapter;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import tb.b23;
import tb.fw0;
import tb.in2;
import tb.kg2;
import tb.m61;
import tb.mu0;
import tb.py2;
import tb.tn2;
import tb.un2;
import tb.wh2;
import tb.xh2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TicketDetailAcceptTransferActivity extends TickletBaseActivity implements TickletDetailConfirmAcceptUtil.TickletTransferConfirmAcceptCallBack, TickletTransferDetailWaitAcceptAdapter.TickletTransferWaitCallback, OnLoadMoreListener, OnRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static int TRANSFER_LOGIN_REQUEST_CODE = 100 + 1;
    private static int TRANSFER_PERSONS_REQUEST_CODE = 100;
    private TickletTransferDetailWaitAcceptAdapter adapter;
    private TicketPerformTransferAcceptResult.TicketPerformTransferData confirmAcceptData;
    private LinearLayout errorPageView;
    private String from;
    private IRecyclerView mRecyclerView;
    private TextView tvRule;
    private TextView tvTitle;
    private DMIconFontTextView tvTitleBack;
    private View viewTitleSpaceBar;
    private ArrayList<TicketPerformTransferAcceptResult.TicketPerformTransferData> transferResult = new ArrayList<>();
    private TickletDetailConfirmAcceptUtil confirmAcceptRequest = new TickletDetailConfirmAcceptUtil(this);
    private int mCurrentPageIndex = 0;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Map a;

        a(TicketDetailAcceptTransferActivity ticketDetailAcceptTransferActivity, Map map) {
            this.a = map;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "306452739")) {
                ipChange.ipc$dispatch("306452739", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            cn.damai.common.user.c.e().x(cn.damai.common.user.b.getInstance().e(un2.TICKLET_TRANSFER_CONDIRM_PAGE, "center", "cancel_receiver", this.a, Boolean.FALSE));
            dialogInterface.dismiss();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class b implements ProtocolDialog.OnConfirmListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Map a;

        b(Map map) {
            this.a = map;
        }

        @Override // cn.damai.common.app.widget.ProtocolDialog.OnConfirmListener
        public void onConfirmClick(boolean z, DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "930015175")) {
                ipChange.ipc$dispatch("930015175", new Object[]{this, Boolean.valueOf(z), dialogInterface});
            } else if (z) {
                dialogInterface.dismiss();
                cn.damai.common.user.c.e().x(cn.damai.common.user.b.getInstance().e(un2.TICKLET_TRANSFER_CONDIRM_PAGE, "center", "confim_receiver_btn", this.a, Boolean.FALSE));
                TicketDetailAcceptTransferActivity.this.checkLiveBind();
            } else {
                ToastUtil.a().j(mu0.a(), "请您认真阅读转送规则及《订票服务条款》，接受后可开始使用我们的服务");
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Map a;

        c(Map map) {
            this.a = map;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1907354094")) {
                ipChange.ipc$dispatch("1907354094", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(cn.damai.common.user.b.getInstance().e(un2.TICKLET_TRANSFER_CONDIRM_PAGE, "center", "transfermanager_notice", this.a, Boolean.TRUE));
            py2.f().n(TicketDetailAcceptTransferActivity.this, in2.DAMAI_PROTOCOL_TIPS_URL);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class d implements YouKuTrustListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.login.YouKuTrustListener
        public void showLoading(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-416615865")) {
                ipChange.ipc$dispatch("-416615865", new Object[]{this, Boolean.valueOf(z)});
            } else if (z) {
                TicketDetailAcceptTransferActivity.this.startProgressDialog();
            } else {
                TicketDetailAcceptTransferActivity.this.stopProgressDialog();
            }
        }

        @Override // cn.damai.login.YouKuTrustListener
        public void trustYouKuFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1970314115")) {
                ipChange.ipc$dispatch("1970314115", new Object[]{this, str, str2});
                return;
            }
            ToastUtil.i(str2);
            b23.a(b23.i("", "", str, str2, ""), fw0.LOGIN_YOUKU_BRIDGE_FAILED_CODE, "票夹待接收业务： 优酷h5桥自动登录失败");
        }

        @Override // cn.damai.login.YouKuTrustListener
        public void trustYouKuSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-497807558")) {
                ipChange.ipc$dispatch("-497807558", new Object[]{this});
            } else {
                TicketDetailAcceptTransferActivity.this.confirmAcceptOnclick();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkLiveBind() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1754816148")) {
            ipChange.ipc$dispatch("-1754816148", new Object[]{this});
        } else if ("1".equals(this.confirmAcceptData.isNeedLiveBind)) {
            LoginManager.k().i(this, 0, new d());
        } else {
            confirmAcceptOnclick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirmAcceptOnclick() {
        ArrayList<TicketTable> arrayList;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1976834868")) {
            ipChange.ipc$dispatch("-1976834868", new Object[]{this});
        } else if (wh2.e(getRealNameNum(this.confirmAcceptData)) > 0) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("confirmAcceptData", this.confirmAcceptData);
            intent.putExtras(bundle);
            intent.setClass(this, TickletAttendanceActivity.class);
            startActivityForResult(intent, TRANSFER_PERSONS_REQUEST_CODE);
        } else {
            TicketPerformTransferAcceptResult.TicketPerformTransferData ticketPerformTransferData = this.confirmAcceptData;
            if (ticketPerformTransferData == null || (arrayList = ticketPerformTransferData.ticketInfoVOs) == null || arrayList.size() <= 0) {
                return;
            }
            ArrayList<TicketTransferTicketPersonMapping> arrayList2 = new ArrayList<>();
            Iterator<TicketTable> it = this.confirmAcceptData.ticketInfoVOs.iterator();
            while (it.hasNext()) {
                TicketTransferTicketPersonMapping ticketTransferTicketPersonMapping = new TicketTransferTicketPersonMapping();
                ticketTransferTicketPersonMapping.transferRecordId = it.next().tranferRecordId;
                arrayList2.add(ticketTransferTicketPersonMapping);
            }
            this.confirmAcceptRequest.setTransferNum(arrayList2.size());
            this.confirmAcceptRequest.requestAcceptTransferData(arrayList2, this.confirmAcceptData.performId);
        }
    }

    private ArrayList<Integer> getRealNameNum(TicketPerformTransferAcceptResult.TicketPerformTransferData ticketPerformTransferData) {
        ArrayList<TicketTable> arrayList;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "762913917")) {
            return (ArrayList) ipChange.ipc$dispatch("762913917", new Object[]{this, ticketPerformTransferData});
        }
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        if (ticketPerformTransferData != null && (arrayList = ticketPerformTransferData.ticketInfoVOs) != null && arrayList.size() > 0) {
            for (int i = 0; i < ticketPerformTransferData.ticketInfoVOs.size(); i++) {
                if (ticketPerformTransferData.ticketInfoVOs.get(i) != null && "3".equals(ticketPerformTransferData.ticketInfoVOs.get(i).acceptVoucherType)) {
                    arrayList2.add(Integer.valueOf(i));
                }
            }
        }
        return arrayList2;
    }

    private void gotoLogin() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1578829321")) {
            ipChange.ipc$dispatch("-1578829321", new Object[]{this});
        } else {
            LoginManager.k().x(this, new Intent(), TRANSFER_LOGIN_REQUEST_CODE);
        }
    }

    private void initIRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "374193920")) {
            ipChange.ipc$dispatch("374193920", new Object[]{this});
            return;
        }
        TickletTransferDetailWaitAcceptAdapter tickletTransferDetailWaitAcceptAdapter = new TickletTransferDetailWaitAcceptAdapter(this, this.transferResult);
        this.adapter = tickletTransferDetailWaitAcceptAdapter;
        tickletTransferDetailWaitAcceptAdapter.d(this);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mRecyclerView.setAdapter(this.adapter);
        this.mRecyclerView.setRefreshEnabled(false);
        this.mRecyclerView.setLoadMoreEnabled(false);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.setOnRefreshListener(this);
        this.mRecyclerView.setOnLoadMoreListener(this);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
    }

    private void onBackPresss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1293599511")) {
            ipChange.ipc$dispatch("1293599511", new Object[]{this});
        } else if (!TicketDeatilActivity.FROM_PUSH.equals(this.from) && !TicketDeatilActivity.FROM_OTHER.equals(this.from)) {
            finish();
        } else {
            Intent intent = new Intent();
            intent.setClass(this, TickletListActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void onRefreshDeatil() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1653753066")) {
            ipChange.ipc$dispatch("1653753066", new Object[]{this});
        } else {
            requestDetailData(true);
        }
    }

    private void requestDetailData(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-133943935")) {
            ipChange.ipc$dispatch("-133943935", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            startProgressDialog();
            this.errorPageView.setVisibility(8);
            this.mCurrentPageIndex = 0;
        }
        new TickletTransferWaitingAcceptListRequest().request(new DMMtopRequestListener<TicketPerformTransferAcceptResult>(TicketPerformTransferAcceptResult.class) { // from class: cn.damai.ticklet.ui.activity.TicketDetailAcceptTransferActivity.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-912818095")) {
                    ipChange2.ipc$dispatch("-912818095", new Object[]{this, str, str2});
                    return;
                }
                TicketDetailAcceptTransferActivity.this.stopProgressDialog();
                TicketDetailAcceptTransferActivity.this.errorView(str, str2);
                tn2.c(5, str, str2, "");
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(TicketPerformTransferAcceptResult ticketPerformTransferAcceptResult) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "522464195")) {
                    ipChange2.ipc$dispatch("522464195", new Object[]{this, ticketPerformTransferAcceptResult});
                    return;
                }
                TicketDetailAcceptTransferActivity.this.stopProgressDialog();
                TicketDetailAcceptTransferActivity.this.returnTransfetDetailData(ticketPerformTransferAcceptResult.result);
            }
        });
    }

    private void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "378073845")) {
            ipChange.ipc$dispatch("378073845", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 23) {
            View view = this.viewTitleSpaceBar;
            if (view != null) {
                view.getLayoutParams().height = kg2.a(this);
                this.viewTitleSpaceBar.setVisibility(0);
            }
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
        } else {
            kg2.f(this, false, R$color.black);
            View view2 = this.viewTitleSpaceBar;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    private void showEmptyPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1406704610")) {
            ipChange.ipc$dispatch("-1406704610", new Object[]{this});
            return;
        }
        this.errorPageView.setVisibility(0);
        this.mRecyclerView.setVisibility(8);
        onResponseError(3, getString(R$string.ticklet_transfer_ticket_no_data), "", "", this.errorPageView, true);
    }

    private void showErrorPage(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1980403351")) {
            ipChange.ipc$dispatch("1980403351", new Object[]{this, str, str2});
            return;
        }
        this.errorPageView.setVisibility(0);
        this.mRecyclerView.setVisibility(8);
        onResponseError(str, str2, "mtop.damai.wireless.ticklet2.transfer.accept.query", this.errorPageView, true);
    }

    private void showInvalidPage(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1487583752")) {
            ipChange.ipc$dispatch("1487583752", new Object[]{this, str, str2});
            return;
        }
        this.errorPageView.setVisibility(0);
        this.mRecyclerView.setVisibility(8);
        onResponseError(3, str, str2, "mtop.damai.wireless.ticklet2.transfer.accept.query", this.errorPageView, true);
    }

    @Override // cn.damai.ticklet.ui.adapter.TickletTransferDetailWaitAcceptAdapter.TickletTransferWaitCallback
    public void acceptConfirm(TicketPerformTransferAcceptResult.TicketPerformTransferData ticketPerformTransferData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1319191716")) {
            ipChange.ipc$dispatch("1319191716", new Object[]{this, ticketPerformTransferData});
            return;
        }
        this.confirmAcceptData = ticketPerformTransferData;
        HashMap hashMap = new HashMap();
        hashMap.put("screening_id", this.confirmAcceptData.performId);
        cn.damai.common.user.c.e().x(cn.damai.common.user.b.getInstance().e(un2.TICKLET_TRANSFER_CONDIRM_PAGE, "center", "confimbtn", hashMap, Boolean.FALSE));
        SpannableString spannableString = new SpannableString(getResources().getString(R$string.ticklet_transfer_agree_rule_content));
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R$color.color_ff2d79)), 0, spannableString.length(), 33);
        Tips tips = this.confirmAcceptData.recvProtocolTips;
        String str = "";
        if (tips == null) {
            tn2.c(5, "android_native_alarm", "待接收用户协议服务端返回为null", "");
        } else {
            str = tips.getText();
        }
        ProtocolDialog.C(this, getResources().getString(R$string.ticklet_warm_tip), str, spannableString, getResources().getString(R$string.ticklet_transfer_cancel_button_thought), -16777216, new a(this, hashMap), getResources().getString(R$string.ticklet_simple_accept), Color.parseColor("#ff2d79"), new b(hashMap), new c(hashMap)).show();
    }

    @Override // cn.damai.ticklet.net.TickletDetailConfirmAcceptUtil.TickletTransferConfirmAcceptCallBack
    public void confirmAcceptSecondFail(ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-91519481")) {
            ipChange.ipc$dispatch("-91519481", new Object[]{this, arrayList});
        } else {
            requestDetailData(true);
        }
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2085556075")) {
            ipChange.ipc$dispatch("-2085556075", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void errorView(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-169747292")) {
            ipChange.ipc$dispatch("-169747292", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        if ("FAIL_BIZ_FAIL_BIZ_TRANS_SHARE_NO_ACCEPT_TICKET".equals(str)) {
            showInvalidPage(str2, str);
        } else {
            showErrorPage(str2, str);
        }
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1428506571") ? ((Integer) ipChange.ipc$dispatch("-1428506571", new Object[]{this})).intValue() : R$layout.ticklet_transfer_detail_wait_layout;
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1098937830")) {
            ipChange.ipc$dispatch("1098937830", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.errorPageView.setVisibility(8);
        requestDetailData(true);
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-648789384")) {
            ipChange.ipc$dispatch("-648789384", new Object[]{this});
            return;
        }
        this.viewTitleSpaceBar = findViewById(R$id.ticklet_title_bar_space_view);
        this.tvTitleBack = (DMIconFontTextView) findViewById(R$id.ticklet_iv_left_icon);
        this.tvRule = (TextView) findViewById(R$id.ticklet_rule_text_url);
        this.tvTitle = (TextView) findViewById(R$id.ticklet_title_text);
        this.mRecyclerView = (IRecyclerView) findViewById(R$id.ticklet_transfer_detail_list);
        this.errorPageView = (LinearLayout) findViewById(R$id.errorPageView);
        initIRecyclerView();
        this.tvTitleBack.setOnClickListener(this);
        this.tvRule.setVisibility(8);
        this.tvTitle.setText("接收管理");
        setImmersionStyle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1834761311")) {
            ipChange.ipc$dispatch("1834761311", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == TRANSFER_PERSONS_REQUEST_CODE) {
                onRefreshDeatil();
            } else if (i == TRANSFER_LOGIN_REQUEST_CODE) {
                requestDetailData(true);
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "544259678")) {
            ipChange.ipc$dispatch("544259678", new Object[]{this, view});
        } else if (view.getId() == R$id.ticklet_iv_left_icon) {
            onBackPresss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Uri data;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "614939330")) {
            ipChange.ipc$dispatch("614939330", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.from = getIntent().getStringExtra("from");
            if ("android.intent.action.VIEW".equals(getIntent().getAction()) && (data = getIntent().getData()) != null) {
                String queryParameter = data.getQueryParameter("params");
                if (!xh2.c(queryParameter)) {
                    try {
                        AcceptTransferH5Params acceptTransferH5Params = (AcceptTransferH5Params) m61.a(queryParameter, AcceptTransferH5Params.class);
                        if (acceptTransferH5Params != null) {
                            this.from = acceptTransferH5Params.getFrom();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            if (!TextUtils.isEmpty(getIntent().getStringExtra("from"))) {
                this.from = getIntent().getStringExtra("from");
            }
        }
        hideBaseLayout();
        this.confirmAcceptRequest.setCallBack(this);
        setDamaiUTKeyBuilder(un2.k().l(un2.TICKLET_TRANSFER_CONDIRM_PAGE));
        if (!LoginManager.k().q()) {
            gotoLogin();
        } else {
            requestDetailData(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1593327486")) {
            ipChange.ipc$dispatch("-1593327486", new Object[]{this});
        } else {
            super.onDestroy();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1391102168")) {
            return ((Boolean) ipChange.ipc$dispatch("1391102168", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 4) {
            onBackPresss();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1953478891")) {
            ipChange.ipc$dispatch("-1953478891", new Object[]{this});
        }
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1775855585")) {
            ipChange.ipc$dispatch("-1775855585", new Object[]{this, view});
        }
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1788842080")) {
            ipChange.ipc$dispatch("1788842080", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2130653498")) {
            ipChange.ipc$dispatch("-2130653498", new Object[]{this});
        } else {
            super.onPause();
        }
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "919721473")) {
            ipChange.ipc$dispatch("919721473", new Object[]{this});
        }
    }

    public void returnTransfetDetailData(ArrayList<TicketPerformTransferAcceptResult.TicketPerformTransferData> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1162446357")) {
            ipChange.ipc$dispatch("1162446357", new Object[]{this, arrayList});
            return;
        }
        stopProgressDialog();
        this.errorPageView.setVisibility(8);
        if (arrayList == null || arrayList.size() == 0) {
            if (this.mCurrentPageIndex == 0) {
                this.transferResult.clear();
                showEmptyPage();
                return;
            }
            return;
        }
        this.mRecyclerView.setVisibility(0);
        if (this.mCurrentPageIndex == 0) {
            this.transferResult.clear();
        }
        this.transferResult.addAll(arrayList);
        this.adapter.notifyDataSetChanged();
        this.mCurrentPageIndex++;
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "618110441")) {
            return (String) ipChange.ipc$dispatch("618110441", new Object[]{this});
        }
        return null;
    }
}
