package cn.damai.mine.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.mine.adapter.LogisticsDetailAdatper;
import cn.damai.mine.net.LogisticsDetailRequest;
import cn.damai.mine.net.LogisticsDetailResponse;
import cn.damai.uikit.irecycler.DamaiRootRecyclerView;
import cn.damai.uikit.irecycler.widget.PullToRefreshArrowLoadingView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.vf1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class LogisticsDetailActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private ImageView iv_header_image;
    private DamaiRootRecyclerView mRecyclerView;
    private String orderid;
    private View recyclerHeader;
    private RelativeLayout rl_root;
    private TextView tv_contact;
    private TextView tv_des;
    private TextView tv_info_state;

    private void getLogisticsDetailData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1658643729")) {
            ipChange.ipc$dispatch("1658643729", new Object[]{this});
            return;
        }
        LogisticsDetailRequest logisticsDetailRequest = new LogisticsDetailRequest();
        logisticsDetailRequest.orderId = this.orderid;
        logisticsDetailRequest.request(new DMMtopRequestListener<LogisticsDetailResponse>(LogisticsDetailResponse.class) { // from class: cn.damai.mine.activity.LogisticsDetailActivity.1
            private static transient /* synthetic */ IpChange $ipChange;

            private void updateUI(LogisticsDetailResponse logisticsDetailResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1133150262")) {
                    ipChange2.ipc$dispatch("1133150262", new Object[]{this, logisticsDetailResponse});
                } else if (logisticsDetailResponse != null) {
                    DMImageCreator c = C0504a.b().c(logisticsDetailResponse.getIconUrl());
                    int i = R$drawable.uikit_default_image_bg_gradient;
                    c.i(i).c(i).g(LogisticsDetailActivity.this.iv_header_image);
                    LogisticsDetailActivity.this.tv_info_state.setText(logisticsDetailResponse.getStatus());
                    TextView textView = LogisticsDetailActivity.this.tv_des;
                    textView.setText(logisticsDetailResponse.getWaybillName() + "：" + logisticsDetailResponse.getWaybillId());
                    TextView textView2 = LogisticsDetailActivity.this.tv_contact;
                    textView2.setText("官方电话：" + logisticsDetailResponse.getWaybillPhone());
                    LogisticsDetailActivity.this.mRecyclerView.setAdapter(new LogisticsDetailAdatper(LogisticsDetailActivity.this.mContext, logisticsDetailResponse.getTransitStepInfos()));
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1936479795")) {
                    ipChange2.ipc$dispatch("-1936479795", new Object[]{this, str, str2});
                    return;
                }
                LogisticsDetailActivity logisticsDetailActivity = LogisticsDetailActivity.this;
                logisticsDetailActivity.onResponseError(str2, str, "mtop.damai.wireless.order.querylogisticsdetail", logisticsDetailActivity.rl_root, true);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(LogisticsDetailResponse logisticsDetailResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2114082401")) {
                    ipChange2.ipc$dispatch("-2114082401", new Object[]{this, logisticsDetailResponse});
                    return;
                }
                LogisticsDetailActivity logisticsDetailActivity = LogisticsDetailActivity.this;
                logisticsDetailActivity.onResponseSuccess(logisticsDetailActivity.rl_root);
                updateUI(logisticsDetailResponse);
            }
        });
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-210703343")) {
            ipChange.ipc$dispatch("-210703343", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 10003) {
            finish();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1689419577") ? ((Integer) ipChange.ipc$dispatch("1689419577", new Object[]{this})).intValue() : R$layout.activity_logistics;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1029599390")) {
            ipChange.ipc$dispatch("-1029599390", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-481948919")) {
            ipChange.ipc$dispatch("-481948919", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "353729012")) {
            ipChange.ipc$dispatch("353729012", new Object[]{this});
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("orderid")) {
            this.orderid = extras.getString("orderid");
            this.rl_root = (RelativeLayout) findViewById(R$id.rl_root);
            this.mRecyclerView = (DamaiRootRecyclerView) findViewById(R$id.drrv_list);
            this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
            this.mRecyclerView.setRefreshEnabled(false);
            this.mRecyclerView.setIsAutoToDefault(false);
            this.mRecyclerView.setLoadMoreEnabled(false);
            this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
            this.mRecyclerView.setRefreshHeaderView(PullToRefreshArrowLoadingView.getInstance(this.mContext));
            View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.logistics_detail_header, (ViewGroup) this.mRecyclerView, false);
            this.recyclerHeader = inflate;
            this.iv_header_image = (ImageView) inflate.findViewById(R$id.iv_header_image);
            this.tv_info_state = (TextView) this.recyclerHeader.findViewById(R$id.tv_info_state);
            this.tv_des = (TextView) this.recyclerHeader.findViewById(R$id.tv_des);
            this.tv_contact = (TextView) this.recyclerHeader.findViewById(R$id.tv_contact);
            this.mRecyclerView.addHeaderView(this.recyclerHeader);
            getLogisticsDetailData();
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1632077370")) {
            ipChange.ipc$dispatch("-1632077370", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(vf1.x().y());
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "212951185")) {
            ipChange.ipc$dispatch("212951185", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "611800932")) {
            ipChange.ipc$dispatch("611800932", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1366609389") ? (String) ipChange.ipc$dispatch("1366609389", new Object[]{this}) : "物流详情";
    }
}
