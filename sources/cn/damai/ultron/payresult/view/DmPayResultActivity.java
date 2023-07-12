package cn.damai.ultron.payresult.view;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.banner.bean.PayAdvertBean;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.login.LoginManager;
import cn.damai.login.havana.ILoginListener;
import cn.damai.message.observer.Action;
import cn.damai.tetris.core.msg.Message;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import cn.damai.ultron.R$color;
import cn.damai.ultron.R$id;
import cn.damai.ultron.R$layout;
import cn.damai.ultron.payresult.bean.DmPaySuccessBean;
import cn.damai.ultron.payresult.bean.DmPaySuccessDataHolder;
import cn.damai.ultron.payresult.net.PaySuccessViewModel;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.bean.RecommendListMo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tb.kg2;
import tb.ua0;
import tb.xa0;
import tb.xr;
import tb.yr;
import tb.zx2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DmPayResultActivity extends SimpleBaseActivity implements ILoginListener, OnRefreshListener, Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BRAND_STATE_CHANGED = "brand_state_changed";
    Action action;
    private DmPaySuccessAdapter mAdapter;
    PayAdvertBean mAdvertBean;
    DmPaySuccessBean mDmPaySuccessBean;
    private String mProjectId;
    private IRecyclerView mRecyclerView;
    private RecommendListMo recommendListMo;
    zx2 viewCreater;
    private PaySuccessViewModel viewModel;
    private List<DmPaySuccessDataHolder> mDataHolderList = new ArrayList();
    private HashMap<String, String> orderStatusUTArgs = null;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ultron.payresult.view.DmPayResultActivity$a */
    /* loaded from: classes9.dex */
    public class C2623a implements Action<Bundle> {
        private static transient /* synthetic */ IpChange $ipChange;

        C2623a() {
        }

        @Override // cn.damai.message.observer.Action
        /* renamed from: a */
        public void call(Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1682776037")) {
                ipChange.ipc$dispatch("1682776037", new Object[]{this, bundle});
            } else if (DmPayResultActivity.this.viewCreater != null) {
                xr.c(DmPayResultActivity.this.viewCreater.a().a(), new Message(10241, bundle));
            }
        }
    }

    private void initModel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "482264593")) {
            ipChange.ipc$dispatch("482264593", new Object[]{this});
            return;
        }
        this.mProjectId = ua0.b(this) + "";
        PaySuccessViewModel paySuccessViewModel = (PaySuccessViewModel) ViewModelProviders.of(this).get(PaySuccessViewModel.class);
        this.viewModel = paySuccessViewModel;
        if (TextUtils.isEmpty(paySuccessViewModel.getOrderId(getIntent()))) {
            ToastUtil.i("订单号不能为空");
            finish();
        }
        onLoadStart();
        this.viewModel.getResultLiveData().observe(this, new Observer<DmPaySuccessBean>() { // from class: cn.damai.ultron.payresult.view.DmPayResultActivity.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable DmPaySuccessBean dmPaySuccessBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1484300881")) {
                    ipChange2.ipc$dispatch("1484300881", new Object[]{this, dmPaySuccessBean});
                    return;
                }
                if (DmPayResultActivity.this.mRecyclerView != null) {
                    DmPayResultActivity.this.mRecyclerView.setRefreshing(false);
                }
                DmPayResultActivity dmPayResultActivity = DmPayResultActivity.this;
                dmPayResultActivity.mDmPaySuccessBean = dmPaySuccessBean;
                if (dmPaySuccessBean != null) {
                    dmPaySuccessBean.orderId = dmPayResultActivity.viewModel != null ? DmPayResultActivity.this.viewModel.getOrderId() : "";
                    DmPayResultActivity.this.mDmPaySuccessBean.projectId = "";
                }
                DmPayResultActivity.this.onRefreshBanner();
                String orderId = DmPayResultActivity.this.viewModel != null ? DmPayResultActivity.this.viewModel.getOrderId() : "";
                String str = dmPaySuccessBean.requestSuccess ? "true".equals(dmPaySuccessBean.isPaid) ? "200" : "201" : "500";
                String str2 = dmPaySuccessBean.requestSuccess ? dmPaySuccessBean.resultDesc : "接口调用失败";
                DmPayResultActivity.this.orderStatusUTArgs = new HashMap();
                DmPayResultActivity.this.orderStatusUTArgs.put("orderid", orderId);
                DmPayResultActivity.this.orderStatusUTArgs.put("titlelabel", str);
                DmPayResultActivity.this.orderStatusUTArgs.put("contentlabel", str2);
                DmPayResultActivity.this.mAdapter.d = DmPayResultActivity.this.orderStatusUTArgs;
                C0529c.e().l(DmPayResultActivity.this, xa0.h().g(orderId, str, str2));
            }
        });
        this.viewModel.getBannerLiveData().observe(this, new Observer<PayAdvertBean>() { // from class: cn.damai.ultron.payresult.view.DmPayResultActivity.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable PayAdvertBean payAdvertBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1367716300")) {
                    ipChange2.ipc$dispatch("-1367716300", new Object[]{this, payAdvertBean});
                    return;
                }
                DmPayResultActivity dmPayResultActivity = DmPayResultActivity.this;
                dmPayResultActivity.mAdvertBean = payAdvertBean;
                dmPayResultActivity.viewModel.queryRecommendList();
            }
        });
        this.viewModel.getRecommendLiveData().observe(this, new Observer<RecommendListMo>() { // from class: cn.damai.ultron.payresult.view.DmPayResultActivity.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.lifecycle.Observer
            public void onChanged(RecommendListMo recommendListMo) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "392184191")) {
                    ipChange2.ipc$dispatch("392184191", new Object[]{this, recommendListMo});
                    return;
                }
                DmPayResultActivity.this.recommendListMo = recommendListMo;
                DmPayResultActivity.this.onLoadFinish();
                DmPayResultActivity.this.loadPageData();
            }
        });
        onLoadStart();
        loadRequest();
    }

    private void initRecyclerView(zx2 zx2Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1371403423")) {
            ipChange.ipc$dispatch("1371403423", new Object[]{this, zx2Var});
            return;
        }
        this.mRecyclerView = (IRecyclerView) findViewById(R$id.rc);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
        linearLayoutManager.setOrientation(1);
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        DmPaySuccessAdapter dmPaySuccessAdapter = new DmPaySuccessAdapter(this, this.mDataHolderList);
        this.mAdapter = dmPaySuccessAdapter;
        dmPaySuccessAdapter.b(zx2Var);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setRefreshEnabled(true);
        this.mRecyclerView.setRefreshing(true);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mRecyclerView.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(this));
        this.mRecyclerView.setOnRefreshListener(this);
    }

    private void initTitleStatusBar(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1960564053")) {
            ipChange.ipc$dispatch("-1960564053", new Object[]{this, view});
        } else if (view == null) {
        } else {
            if (Build.VERSION.SDK_INT >= 23) {
                view.getLayoutParams().height = kg2.a(this);
                view.setVisibility(0);
                kg2.f(this, true, R$color.black);
                kg2.d(true, this);
                return;
            }
            kg2.f(this, false, R$color.black);
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadPageData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1571905505")) {
            ipChange.ipc$dispatch("1571905505", new Object[]{this});
        } else if (this.mDmPaySuccessBean == null) {
        } else {
            this.mDataHolderList.clear();
            DmPaySuccessDataHolder dmPaySuccessDataHolder = new DmPaySuccessDataHolder();
            dmPaySuccessDataHolder.mPayResponse = this.mDmPaySuccessBean;
            dmPaySuccessDataHolder.type = 0;
            this.mDataHolderList.add(dmPaySuccessDataHolder);
            PayAdvertBean payAdvertBean = this.mAdvertBean;
            if (payAdvertBean != null && (payAdvertBean.baccount != null || payAdvertBean.vipScore != null)) {
                DmPaySuccessDataHolder dmPaySuccessDataHolder2 = new DmPaySuccessDataHolder();
                dmPaySuccessDataHolder2.mAdvertBean = this.mAdvertBean;
                PaySuccessViewModel paySuccessViewModel = this.viewModel;
                dmPaySuccessDataHolder2.mOrderId = paySuccessViewModel != null ? paySuccessViewModel.getOrderId() : "0";
                dmPaySuccessDataHolder2.mProjectId = this.mProjectId;
                dmPaySuccessDataHolder2.type = 1;
                this.mDataHolderList.add(dmPaySuccessDataHolder2);
            }
            RecommendListMo recommendListMo = this.recommendListMo;
            if (recommendListMo != null && recommendListMo.getResult() != null && this.recommendListMo.getResult().size() > 0) {
                DmPaySuccessDataHolder dmPaySuccessDataHolder3 = new DmPaySuccessDataHolder();
                dmPaySuccessDataHolder3.type = 2;
                this.mDataHolderList.add(dmPaySuccessDataHolder3);
                Iterator<JSONObject> it = this.recommendListMo.getResult().iterator();
                while (it.hasNext()) {
                    DmPaySuccessDataHolder dmPaySuccessDataHolder4 = new DmPaySuccessDataHolder();
                    dmPaySuccessDataHolder4.type = 3;
                    dmPaySuccessDataHolder4.recommendMo = it.next();
                    this.mDataHolderList.add(dmPaySuccessDataHolder4);
                }
            }
            this.mAdapter.notifyDataSetChanged();
        }
    }

    private void loadRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2018497537")) {
            ipChange.ipc$dispatch("2018497537", new Object[]{this});
            return;
        }
        this.mDmPaySuccessBean = null;
        this.mAdvertBean = null;
        this.recommendListMo = null;
        this.viewModel.queryPaySuccessInfo();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2017416670") ? ((Integer) ipChange.ipc$dispatch("-2017416670", new Object[]{this})).intValue() : R$layout.activity_pay_result;
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "766795691")) {
            ipChange.ipc$dispatch("766795691", new Object[]{this});
            return;
        }
        super.initView();
        initTitleStatusBar(findViewById(R$id.title_bar_space));
        hideBaseLayout();
        zx2 zx2Var = new zx2((Activity) this.mContext);
        this.viewCreater = zx2Var;
        initRecyclerView(zx2Var);
        initModel();
        this.action = new C2623a();
        yr.c().e("brand_state_changed", this.action);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1866154290")) {
            ipChange.ipc$dispatch("-1866154290", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "785232559")) {
            ipChange.ipc$dispatch("785232559", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        xa0 h = xa0.h();
        PaySuccessViewModel paySuccessViewModel = this.viewModel;
        setDamaiUTKeyBuilder(h.f(paySuccessViewModel != null ? paySuccessViewModel.getOrderId() : ""));
        C0529c.e().K(this);
        LoginManager.k().c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-659863121")) {
            ipChange.ipc$dispatch("-659863121", new Object[]{this});
            return;
        }
        yr.c().a("brand_state_changed", this.action);
        LoginManager.k().C(this);
        super.onDestroy();
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "139675590")) {
            ipChange.ipc$dispatch("139675590", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1500705634")) {
            ipChange.ipc$dispatch("1500705634", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1708995815")) {
            ipChange.ipc$dispatch("1708995815", new Object[]{this});
        } else {
            onRefresh();
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLogout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1716599479")) {
            ipChange.ipc$dispatch("1716599479", new Object[]{this});
        }
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1853185838")) {
            ipChange.ipc$dispatch("1853185838", new Object[]{this});
        } else {
            loadRequest();
        }
    }

    public void onRefreshBanner() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1934897570")) {
            ipChange.ipc$dispatch("1934897570", new Object[]{this});
        } else {
            this.viewModel.queryBanner(this.mProjectId);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-869978858")) {
            return (String) ipChange.ipc$dispatch("-869978858", new Object[]{this});
        }
        return null;
    }
}
