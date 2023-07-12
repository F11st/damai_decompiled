package cn.damai.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.screenshot.ScreenShotBean;
import cn.damai.commonbusiness.screenshot.ScreenShotDetector;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.im.AliMeUtil;
import cn.damai.mine.adapter.FeedBackListAdapter;
import cn.damai.mine.bean.FeedBack;
import cn.damai.mine.bean.FeedBackList;
import cn.damai.mine.contract.FeedBackContract;
import cn.damai.mine.presenter.FeedBackPresenter;
import cn.damai.uikit.irecycler.IRecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.vf1;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class FeedBackListActivity extends DamaiBaseActivity<FeedBackPresenter, FeedBackContract.Model> implements FeedBackContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private FeedBackListAdapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private IRecyclerView mRecyclerView;
    private LinearLayout mRootView;
    private ScreenShotBean mScreenShotBean;
    private List<FeedBack> mFeedBackList = new ArrayList();
    private boolean mInitState = true;
    private final int REQUEST_FEED_BACK_PAGE = 1001;

    private void addUTClickBuilder(FeedBack feedBack) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1925130219")) {
            ipChange.ipc$dispatch("-1925130219", new Object[]{this, feedBack});
        } else if (feedBack == null) {
        } else {
            try {
                i = this.mFeedBackList.indexOf(feedBack);
            } catch (Exception e) {
                e.printStackTrace();
            }
            c e2 = c.e();
            e2.x(vf1.x().v(i, feedBack.name + JSMethod.NOT_SET + feedBack.title));
        }
    }

    private void gotoFeedBackPage(FeedBack feedBack) {
        HashMap<String, String> hashMap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-164991225")) {
            ipChange.ipc$dispatch("-164991225", new Object[]{this, feedBack});
            return;
        }
        addUTClickBuilder(feedBack);
        Intent intent = new Intent(this, FeedBackActivity.class);
        Bundle bundle = new Bundle();
        ScreenShotBean screenShotBean = this.mScreenShotBean;
        if (screenShotBean != null && (hashMap = screenShotBean.mScreenShotMap) != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
        }
        bundle.putString("name", feedBack.name);
        bundle.putString("title", feedBack.title);
        bundle.putString(SocialConstants.PARAM_APP_DESC, feedBack.desc);
        bundle.putParcelableArrayList("data", (ArrayList) this.mAdapter.b());
        intent.putExtras(bundle);
        startActivityForResult(intent, 1001);
    }

    private void initData() {
        Bundle extras;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "257095796")) {
            ipChange.ipc$dispatch("257095796", new Object[]{this});
            return;
        }
        if (getIntent() != null && (extras = getIntent().getExtras()) != null && extras.containsKey("screenshot_info")) {
            this.mScreenShotBean = (ScreenShotBean) extras.getSerializable("screenshot_info");
        }
        requestFeedBackList();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1098548406")) {
            ipChange.ipc$dispatch("1098548406", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 10002) {
            c.e().x(vf1.x().l0());
            startActivity(new Intent(this, MyFeedBackListActivity.class));
        } else {
            finish();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1673220980") ? ((Integer) ipChange.ipc$dispatch("1673220980", new Object[]{this})).intValue() : R$layout.activity_feed_back;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1531755897")) {
            ipChange.ipc$dispatch("-1531755897", new Object[]{this, Integer.valueOf(i)});
        } else {
            requestFeedBackList();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1131068548")) {
            ipChange.ipc$dispatch("1131068548", new Object[]{this});
        } else {
            ((FeedBackPresenter) this.mPresenter).setVM(this, (FeedBackContract.Model) this.mModel);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-731871335")) {
            ipChange.ipc$dispatch("-731871335", new Object[]{this});
            return;
        }
        this.mRootView = (LinearLayout) findViewById(R$id.ll_content);
        this.mRecyclerView = (IRecyclerView) findViewById(R$id.irc);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mLinearLayoutManager = linearLayoutManager;
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        FeedBackListAdapter feedBackListAdapter = new FeedBackListAdapter(this, this.mFeedBackList, this);
        this.mAdapter = feedBackListAdapter;
        this.mRecyclerView.setAdapter(feedBackListAdapter);
        this.mRecyclerView.setRefreshEnabled(false);
        this.mRecyclerView.setLoadMoreEnabled(false);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mRecyclerView.getRefreshHeaderView().setVisibility(8);
        initData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1393031488")) {
            ipChange.ipc$dispatch("1393031488", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1001) {
            finish();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1607228735")) {
            ipChange.ipc$dispatch("1607228735", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        FeedBack feedBack = (FeedBack) view.getTag();
        if (feedBack == null) {
            return;
        }
        if (!feedBack.name.equals("10")) {
            gotoFeedBackPage(feedBack);
        } else {
            AliMeUtil.k(this, "damai_feedback");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-792758271")) {
            ipChange.ipc$dispatch("-792758271", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(vf1.x().w());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "126099329")) {
            ipChange.ipc$dispatch("126099329", new Object[]{this});
            return;
        }
        super.onDestroy();
        ScreenShotDetector.k().z(false);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-289205322")) {
            ipChange.ipc$dispatch("-289205322", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "595602335")) {
            ipChange.ipc$dispatch("595602335", new Object[]{this});
        }
    }

    @Override // cn.damai.mine.contract.FeedBackContract.View, cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1872451202")) {
            ipChange.ipc$dispatch("1872451202", new Object[]{this, str, str2, str3});
            return;
        }
        this.mInitState = true;
        stopProgressDialog();
        onResponseError(str2, str, str3, this.mRootView, true);
    }

    @Override // cn.damai.mine.contract.FeedBackContract.View, cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-813182455")) {
            ipChange.ipc$dispatch("-813182455", new Object[]{this});
            return;
        }
        this.mInitState = true;
        stopProgressDialog();
        onResponseSuccess(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-61044446")) {
            ipChange.ipc$dispatch("-61044446", new Object[]{this});
            return;
        }
        super.onResume();
        ScreenShotDetector.k().z(true);
    }

    public void requestFeedBackList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1098717802")) {
            ipChange.ipc$dispatch("1098717802", new Object[]{this});
        } else if (this.mInitState) {
            this.mInitState = false;
            startProgressDialog();
            ((FeedBackPresenter) this.mPresenter).getFeedBackList();
        }
    }

    @Override // cn.damai.mine.contract.FeedBackContract.View
    public void returnFeedBackList(FeedBackList feedBackList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1981926565")) {
            ipChange.ipc$dispatch("1981926565", new Object[]{this, feedBackList});
        } else if (feedBackList != null && feedBackList.data != null) {
            this.mFeedBackList.clear();
            this.mFeedBackList.addAll(feedBackList.data);
            FeedBackListAdapter feedBackListAdapter = this.mAdapter;
            if (feedBackListAdapter != null) {
                feedBackListAdapter.notifyDataSetChanged();
            }
        } else if (wh2.e(this.mFeedBackList) == 0) {
            onNetError("success", "网络异常，请稍后再试", "mtop.damai.wireless.user.feedback.bizIdentifiers");
        } else {
            ToastUtil.i("网络异常，请稍后再试");
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-871620888") ? (String) ipChange.ipc$dispatch("-871620888", new Object[]{this}) : "我要反馈";
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-96054329")) {
            ipChange.ipc$dispatch("-96054329", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1728296643")) {
            ipChange.ipc$dispatch("1728296643", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1785092761")) {
            ipChange.ipc$dispatch("-1785092761", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1502116958")) {
            ipChange.ipc$dispatch("-1502116958", new Object[]{this});
        }
    }
}
