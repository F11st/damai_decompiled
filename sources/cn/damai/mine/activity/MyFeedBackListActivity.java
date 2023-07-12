package cn.damai.mine.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.screenshot.ScreenShotDetector;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.mine.adapter.MyFeedBackListAdapter;
import cn.damai.mine.bean.MyFeedBack;
import cn.damai.mine.bean.MyFeedBackDO;
import cn.damai.mine.bean.MyFeedBackList;
import cn.damai.mine.contract.MyFeedBackListContract;
import cn.damai.mine.presenter.MyFeedBackListPresenter;
import cn.damai.uikit.irecycler.IRecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.vf1;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MyFeedBackListActivity extends DamaiBaseActivity<MyFeedBackListPresenter, MyFeedBackListContract.Model> implements MyFeedBackListContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private MyFeedBackListAdapter mAdapter;
    private LinearLayout mEmptyPageLayout;
    private List<MyFeedBack> mFeedBackList = new ArrayList();
    private boolean mInitState = true;
    private IRecyclerView mRecyclerView;
    private FrameLayout mRootView;

    private void updateEmptyView(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1393059181")) {
            ipChange.ipc$dispatch("1393059181", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mEmptyPageLayout.setVisibility(0);
            this.mRecyclerView.setVisibility(8);
        } else {
            this.mEmptyPageLayout.setVisibility(8);
            this.mRecyclerView.setVisibility(0);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1416980798")) {
            ipChange.ipc$dispatch("-1416980798", new Object[]{this, Integer.valueOf(i)});
        } else {
            finish();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-351065624") ? ((Integer) ipChange.ipc$dispatch("-351065624", new Object[]{this})).intValue() : R$layout.activity_my_feed_back;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "139868819")) {
            ipChange.ipc$dispatch("139868819", new Object[]{this, Integer.valueOf(i)});
        } else {
            requestFeedBackList();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1411827192")) {
            ipChange.ipc$dispatch("1411827192", new Object[]{this});
        } else {
            ((MyFeedBackListPresenter) this.mPresenter).setVM(this, (MyFeedBackListContract.Model) this.mModel);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "184116645")) {
            ipChange.ipc$dispatch("184116645", new Object[]{this});
            return;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.ll_empty_page);
        this.mEmptyPageLayout = linearLayout;
        ((TextView) linearLayout.findViewById(R$id.tv_null_tip)).setText(" 当前你还没有提交过意见反馈哦～");
        this.mEmptyPageLayout.setVisibility(8);
        this.mRootView = (FrameLayout) findViewById(R$id.ll_content);
        IRecyclerView iRecyclerView = (IRecyclerView) findViewById(R$id.irc);
        this.mRecyclerView = iRecyclerView;
        iRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyFeedBackListAdapter myFeedBackListAdapter = new MyFeedBackListAdapter(this, this.mFeedBackList, this);
        this.mAdapter = myFeedBackListAdapter;
        this.mRecyclerView.setAdapter(myFeedBackListAdapter);
        this.mRecyclerView.setRefreshEnabled(false);
        this.mRecyclerView.setLoadMoreEnabled(false);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        requestFeedBackList();
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2061086645")) {
            ipChange.ipc$dispatch("-2061086645", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        MyFeedBackDO myFeedBackDO = (MyFeedBackDO) view.getTag();
        if (myFeedBackDO == null) {
            return;
        }
        c.e().x(vf1.x().k0(myFeedBackDO.index));
        Bundle bundle = new Bundle();
        bundle.putString("feedbackId", myFeedBackDO.feedBackId);
        DMNav.from(this).withExtras(bundle).toUri(NavUri.b("my_feed_back_detail"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1453581941")) {
            ipChange.ipc$dispatch("1453581941", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(vf1.x().G());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1543044363")) {
            ipChange.ipc$dispatch("-1543044363", new Object[]{this});
            return;
        }
        super.onDestroy();
        ScreenShotDetector.k().z(false);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1382419394")) {
            ipChange.ipc$dispatch("1382419394", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1428684269")) {
            ipChange.ipc$dispatch("-1428684269", new Object[]{this});
        }
    }

    @Override // cn.damai.mine.contract.MyFeedBackListContract.View, cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "552771726")) {
            ipChange.ipc$dispatch("552771726", new Object[]{this, str, str2, str3});
            return;
        }
        this.mInitState = true;
        stopLoading();
        onResponseError(str2, str, str3, this.mRootView, true);
    }

    @Override // cn.damai.mine.contract.MyFeedBackListContract.View, cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "858442261")) {
            ipChange.ipc$dispatch("858442261", new Object[]{this});
            return;
        }
        this.mInitState = true;
        stopLoading();
        onResponseSuccess(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "854943534")) {
            ipChange.ipc$dispatch("854943534", new Object[]{this});
            return;
        }
        super.onResume();
        ScreenShotDetector.k().z(true);
    }

    public void requestFeedBackList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-442417954")) {
            ipChange.ipc$dispatch("-442417954", new Object[]{this});
        } else if (this.mInitState) {
            this.mInitState = false;
            startProgressDialog();
            ((MyFeedBackListPresenter) this.mPresenter).getFeedBackList();
        }
    }

    @Override // cn.damai.mine.contract.MyFeedBackListContract.View
    public void returnFeedBackList(MyFeedBackList myFeedBackList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1106659021")) {
            ipChange.ipc$dispatch("1106659021", new Object[]{this, myFeedBackList});
        } else if (myFeedBackList != null) {
            if (myFeedBackList.count != 0 && wh2.e(myFeedBackList.items) != 0) {
                updateEmptyView(false);
                this.mFeedBackList.clear();
                this.mFeedBackList.addAll(myFeedBackList.items);
                MyFeedBackListAdapter myFeedBackListAdapter = this.mAdapter;
                if (myFeedBackListAdapter != null) {
                    myFeedBackListAdapter.notifyDataSetChanged();
                    return;
                }
                return;
            }
            showEmptyView();
        } else {
            onNetError("success", "网络异常，请稍后再试", "mtop.damai.wireless.user.feedback.replayList");
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1365351004") ? (String) ipChange.ipc$dispatch("1365351004", new Object[]{this}) : "我的反馈";
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "184704315")) {
            ipChange.ipc$dispatch("184704315", new Object[]{this});
        } else {
            updateEmptyView(true);
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1868811063")) {
            ipChange.ipc$dispatch("1868811063", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "874268379")) {
            ipChange.ipc$dispatch("874268379", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "768563734")) {
            ipChange.ipc$dispatch("768563734", new Object[]{this});
        } else {
            stopProgressDialog();
        }
    }
}
