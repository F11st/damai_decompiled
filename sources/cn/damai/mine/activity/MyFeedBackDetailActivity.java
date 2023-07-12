package cn.damai.mine.activity;

import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.screenshot.ScreenShotDetector;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.mine.adapter.MyFeedBackDetailAdapter;
import cn.damai.mine.bean.MyFeedBackDetail;
import cn.damai.mine.bean.MyFeedBackDetailDataHolder;
import cn.damai.mine.contract.MyFeedBackDetailContract;
import cn.damai.mine.presenter.MyFeedBackDetailPresenter;
import cn.damai.uikit.irecycler.IRecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.vf1;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MyFeedBackDetailActivity extends DamaiBaseActivity<MyFeedBackDetailPresenter, MyFeedBackDetailContract.Model> implements MyFeedBackDetailContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private MyFeedBackDetailAdapter mAdapter;
    private List<MyFeedBackDetailDataHolder> mDataHolder = new ArrayList();
    private String mFeedbackId;
    private IRecyclerView mRecyclerView;
    private LinearLayout mRootView;

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "559505973")) {
            ipChange.ipc$dispatch("559505973", new Object[]{this, Integer.valueOf(i)});
        } else {
            finish();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1462123883") ? ((Integer) ipChange.ipc$dispatch("-1462123883", new Object[]{this})).intValue() : R$layout.activity_my_feed_back_detail;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "56801158")) {
            ipChange.ipc$dispatch("56801158", new Object[]{this, Integer.valueOf(i)});
        } else {
            requestFeedBack();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1163270299")) {
            ipChange.ipc$dispatch("-1163270299", new Object[]{this});
        } else {
            ((MyFeedBackDetailPresenter) this.mPresenter).setVM(this, (MyFeedBackDetailContract.Model) this.mModel);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "81286168")) {
            ipChange.ipc$dispatch("81286168", new Object[]{this});
            return;
        }
        this.mRootView = (LinearLayout) findViewById(R$id.ll_content);
        IRecyclerView iRecyclerView = (IRecyclerView) findViewById(R$id.irc);
        this.mRecyclerView = iRecyclerView;
        iRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyFeedBackDetailAdapter myFeedBackDetailAdapter = new MyFeedBackDetailAdapter(this, this.mDataHolder);
        this.mAdapter = myFeedBackDetailAdapter;
        this.mRecyclerView.setAdapter(myFeedBackDetailAdapter);
        this.mRecyclerView.setRefreshEnabled(false);
        this.mRecyclerView.setLoadMoreEnabled(true);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mFeedbackId = getIntent().getStringExtra("feedbackId");
        requestFeedBack();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "654673186")) {
            ipChange.ipc$dispatch("654673186", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(vf1.x().F());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-435821854")) {
            ipChange.ipc$dispatch("-435821854", new Object[]{this});
            return;
        }
        super.onDestroy();
        ScreenShotDetector.k().z(false);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1299351733")) {
            ipChange.ipc$dispatch("1299351733", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1755224768")) {
            ipChange.ipc$dispatch("1755224768", new Object[]{this});
        }
    }

    @Override // cn.damai.mine.contract.MyFeedBackDetailContract.View, cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1789893121")) {
            ipChange.ipc$dispatch("1789893121", new Object[]{this, str, str2, str3});
            return;
        }
        stopProgressDialog();
        onResponseError(str2, str, str3, this.mRootView, true);
    }

    @Override // cn.damai.mine.contract.MyFeedBackDetailContract.View, cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "775374600")) {
            ipChange.ipc$dispatch("775374600", new Object[]{this});
            return;
        }
        stopProgressDialog();
        onResponseSuccess(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "752113057")) {
            ipChange.ipc$dispatch("752113057", new Object[]{this});
            return;
        }
        super.onResume();
        ScreenShotDetector.k().z(true);
    }

    public void requestFeedBack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-458258423")) {
            ipChange.ipc$dispatch("-458258423", new Object[]{this});
            return;
        }
        startProgressDialog();
        ((MyFeedBackDetailPresenter) this.mPresenter).getFeedBackList(this.mFeedbackId);
    }

    @Override // cn.damai.mine.contract.MyFeedBackDetailContract.View
    public void returnFeedBack(MyFeedBackDetail myFeedBackDetail) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-582253975")) {
            ipChange.ipc$dispatch("-582253975", new Object[]{this, myFeedBackDetail});
        } else if (myFeedBackDetail != null && myFeedBackDetail.feedbackDO != null) {
            this.mDataHolder.clear();
            MyFeedBackDetailDataHolder myFeedBackDetailDataHolder = new MyFeedBackDetailDataHolder(0);
            myFeedBackDetailDataHolder.myFeedBackDetailDO = myFeedBackDetail.feedbackDO;
            this.mDataHolder.add(myFeedBackDetailDataHolder);
            for (int i = 0; i < wh2.e(myFeedBackDetail.replyDOs); i++) {
                MyFeedBackDetailDataHolder myFeedBackDetailDataHolder2 = new MyFeedBackDetailDataHolder(1);
                myFeedBackDetailDataHolder2.myFeedReplyDetailDO = myFeedBackDetail.replyDOs.get(i);
                this.mDataHolder.add(myFeedBackDetailDataHolder2);
            }
            MyFeedBackDetailAdapter myFeedBackDetailAdapter = this.mAdapter;
            if (myFeedBackDetailAdapter != null) {
                myFeedBackDetailAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2097479753") ? (String) ipChange.ipc$dispatch("2097479753", new Object[]{this}) : "反馈详情";
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1904574120")) {
            ipChange.ipc$dispatch("1904574120", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-481539228")) {
            ipChange.ipc$dispatch("-481539228", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1922100808")) {
            ipChange.ipc$dispatch("1922100808", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-342494525")) {
            ipChange.ipc$dispatch("-342494525", new Object[]{this});
        }
    }
}
