package cn.damai.ticklet.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.member.R$color;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.TicketPerformanceNoticeResult;
import cn.damai.ticklet.net.TickletPerformanceNoticeRequest;
import cn.damai.ticklet.ui.adapter.TickletPerformanceNoticeAdapter;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.irecycler.IRecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.in2;
import tb.kg2;
import tb.py2;
import tb.un2;
import tb.xn2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TicketPerformanceNoticeActivity extends TickletBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private TickletPerformanceNoticeAdapter adapter;
    private LinearLayout errorPageView;
    private IRecyclerView mRecyclerView;
    private View mViewStatusBarSpace;
    private String performId;
    private String productSystemId;
    private String title;
    private TextView tvRule;
    private TextView tvTitle;
    private DMIconFontTextView tvTitleBack;
    private ArrayList<TicketPerformanceNoticeResult.TicketNoticeData> noticeDataList = new ArrayList<>();
    private int mCurrentPageIndex = 0;

    private void initIRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2099728158")) {
            ipChange.ipc$dispatch("2099728158", new Object[]{this});
            return;
        }
        this.adapter = new TickletPerformanceNoticeAdapter(this, this.noticeDataList);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mRecyclerView.setAdapter(this.adapter);
        this.mRecyclerView.setRefreshEnabled(false);
        this.mRecyclerView.setLoadMoreEnabled(false);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
    }

    private void onBackPresss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "993204281")) {
            ipChange.ipc$dispatch("993204281", new Object[]{this});
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportPerformNoticeXFlushError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1108290356")) {
            ipChange.ipc$dispatch("-1108290356", new Object[]{this, str, str2});
        } else {
            xn2.d(xn2.f(xn2.TICKLET_PERFORM_NOTE_INTERFACE_API, "mtop.damai.wireless.ticklet2.extension.notice.query", str, str2, ""), xn2.TICKLET_PERFORM_NOTE_INTERFACE_ERROR_CODE, str, xn2.TICKLET_PERFORM_NOTE_INTERFACE_ERROR_MSG);
        }
    }

    private void requestDetailData(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1818009891")) {
            ipChange.ipc$dispatch("1818009891", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (!z) {
            startProgressDialog();
        }
        TickletPerformanceNoticeRequest tickletPerformanceNoticeRequest = new TickletPerformanceNoticeRequest();
        tickletPerformanceNoticeRequest.performId = this.performId;
        tickletPerformanceNoticeRequest.productSystemId = this.productSystemId;
        tickletPerformanceNoticeRequest.request(new DMMtopRequestListener<TicketPerformanceNoticeResult>(TicketPerformanceNoticeResult.class) { // from class: cn.damai.ticklet.ui.activity.TicketPerformanceNoticeActivity.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1346187917")) {
                    ipChange2.ipc$dispatch("-1346187917", new Object[]{this, str, str2});
                    return;
                }
                TicketPerformanceNoticeActivity.this.stopProgressDialog();
                TicketPerformanceNoticeActivity.this.reportPerformNoticeXFlushError(str, str2);
                TicketPerformanceNoticeActivity.this.errorView(str, str2);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(TicketPerformanceNoticeResult ticketPerformanceNoticeResult) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1991644113")) {
                    ipChange2.ipc$dispatch("1991644113", new Object[]{this, ticketPerformanceNoticeResult});
                    return;
                }
                TicketPerformanceNoticeActivity.this.stopProgressDialog();
                if (ticketPerformanceNoticeResult != null) {
                    TicketPerformanceNoticeActivity.this.returnNoticeDetailData(ticketPerformanceNoticeResult.getPairInfoList());
                } else {
                    TicketPerformanceNoticeActivity.this.showEmptyPage();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void returnNoticeDetailData(ArrayList<TicketPerformanceNoticeResult.TicketNoticeData> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1839929634")) {
            ipChange.ipc$dispatch("-1839929634", new Object[]{this, arrayList});
            return;
        }
        stopProgressDialog();
        this.errorPageView.setVisibility(8);
        if (arrayList == null || arrayList.size() == 0) {
            if (this.mCurrentPageIndex == 0) {
                this.noticeDataList.clear();
                showEmptyPage();
                return;
            }
            return;
        }
        this.mRecyclerView.setVisibility(0);
        if (this.mCurrentPageIndex == 0) {
            this.noticeDataList.clear();
            this.noticeDataList.addAll(arrayList);
            this.adapter.notifyDataSetChanged();
        } else {
            this.noticeDataList.addAll(arrayList);
            this.adapter.notifyDataSetChanged();
        }
        this.mCurrentPageIndex++;
    }

    private void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2103608083")) {
            ipChange.ipc$dispatch("2103608083", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 23) {
            View view = this.mViewStatusBarSpace;
            if (view != null) {
                view.getLayoutParams().height = kg2.a(this);
                this.mViewStatusBarSpace.setVisibility(0);
            }
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
        } else {
            kg2.f(this, false, R$color.black);
            View view2 = this.mViewStatusBarSpace;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEmptyPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2129022148")) {
            ipChange.ipc$dispatch("-2129022148", new Object[]{this});
            return;
        }
        this.errorPageView.setVisibility(0);
        this.mRecyclerView.setVisibility(8);
        onResponseError(3, getString(R$string.ticklet_venue_error), "", "", this.errorPageView, true);
    }

    private void showErrorPage(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1374430901")) {
            ipChange.ipc$dispatch("1374430901", new Object[]{this, str, str2});
            return;
        }
        this.errorPageView.setVisibility(0);
        this.mRecyclerView.setVisibility(8);
        onResponseError(str2, str, "mtop.damai.wireless.ticklet2.extension.notice.query", this.errorPageView, true);
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1433789623")) {
            ipChange.ipc$dispatch("1433789623", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void errorView(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-719309886")) {
            ipChange.ipc$dispatch("-719309886", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        showErrorPage(str, str2);
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1471297235") ? ((Integer) ipChange.ipc$dispatch("1471297235", new Object[]{this})).intValue() : R$layout.ticklet_perforance_require_layout;
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "798542600")) {
            ipChange.ipc$dispatch("798542600", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.errorPageView.setVisibility(8);
        requestDetailData(false);
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "244873370")) {
            ipChange.ipc$dispatch("244873370", new Object[]{this});
            return;
        }
        this.mViewStatusBarSpace = findViewById(R$id.ticklet_title_bar_space_view);
        this.tvTitleBack = (DMIconFontTextView) findViewById(R$id.ticklet_iv_left_icon);
        this.tvRule = (TextView) findViewById(R$id.ticklet_rule_text_url);
        this.tvTitle = (TextView) findViewById(R$id.ticklet_title_text);
        setImmersionStyle();
        this.mRecyclerView = (IRecyclerView) findViewById(R$id.ticklet_notice_list);
        this.errorPageView = (LinearLayout) findViewById(R$id.errorPageView);
        initIRecyclerView();
        this.tvRule.setOnClickListener(this);
        this.tvTitleBack.setOnClickListener(this);
        this.tvRule.setVisibility(8);
        if (TextUtils.isEmpty(this.title)) {
            this.tvTitle.setText("温馨提示");
        } else {
            this.tvTitle.setText(this.title);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1307865088")) {
            ipChange.ipc$dispatch("1307865088", new Object[]{this, view});
        } else if (view.getId() == R$id.ticklet_iv_left_icon) {
            onBackPresss();
        } else if (view.getId() == R$id.ticklet_rule_text_url) {
            py2.f().n(this, in2.DAMAI_TRANSFER_RULE_URL);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1483096736")) {
            ipChange.ipc$dispatch("-1483096736", new Object[]{this, bundle});
            return;
        }
        if (getIntent() != null) {
            this.title = getIntent().getStringExtra("title");
            this.performId = getIntent().getStringExtra(TicketDetailExtFragment.PERFORM_ID);
            this.productSystemId = getIntent().getStringExtra(TicketDetailExtFragment.PRODUCT_SYSTEM_ID);
        }
        super.onCreate(bundle);
        hideBaseLayout();
        requestDetailData(false);
        setDamaiUTKeyBuilder(un2.k().l(un2.TICKLET_EXPLAIN));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "340414112")) {
            ipChange.ipc$dispatch("340414112", new Object[]{this});
        } else {
            super.onDestroy();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-393470730")) {
            return ((Boolean) ipChange.ipc$dispatch("-393470730", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 4) {
            onBackPresss();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2041093175")) {
            ipChange.ipc$dispatch("2041093175", new Object[]{this});
        }
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "393678590")) {
            ipChange.ipc$dispatch("393678590", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1361857636")) {
            ipChange.ipc$dispatch("1361857636", new Object[]{this});
        } else {
            super.onPause();
        }
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2128203769")) {
            return (String) ipChange.ipc$dispatch("-2128203769", new Object[]{this});
        }
        return null;
    }
}
