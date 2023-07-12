package cn.damai.evaluate.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.comment.R$color;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import cn.damai.evaluate.adapter.EvaluateSuccessAdapter;
import cn.damai.issue.net.EvaluteSuccessRenderResponse;
import cn.damai.issue.net.IssueResponse;
import cn.damai.issue.view.DMEvaluateSuccessHeadView;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.irecycler.IRecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.dl;
import tb.kg2;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class EvaluateSuccessActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int REQUEST_CODE_FOR_LOGIN = 1;
    private EvaluateSuccessAdapter adapter;
    private TextView btnShare;
    private DMEvaluateSuccessHeadView headView;
    private IssueResponse issueResponse;
    private String itemType;
    private IRecyclerView mRecyclerView;
    private View mViewStatusBarSpace;
    private EvaluteSuccessRenderResponse renderResponse;
    private DMShareMessage shareMessage;
    private String storeId;

    public static Intent createIntent(Context context, String str, String str2, IssueResponse issueResponse, EvaluteSuccessRenderResponse evaluteSuccessRenderResponse, DMShareMessage dMShareMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "601422887")) {
            return (Intent) ipChange.ipc$dispatch("601422887", new Object[]{context, str, str2, issueResponse, evaluteSuccessRenderResponse, dMShareMessage});
        }
        Intent intent = new Intent(context, EvaluateSuccessActivity.class);
        intent.putExtra("itemType", str);
        intent.putExtra("storeId", str2);
        intent.putExtra("issueResponse", issueResponse);
        intent.putExtra("renderResponse", evaluteSuccessRenderResponse);
        intent.putExtra("shareMessage", dMShareMessage);
        return intent;
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1531363660")) {
            ipChange.ipc$dispatch("-1531363660", new Object[]{this});
            return;
        }
        IssueResponse issueResponse = this.issueResponse;
        if (issueResponse != null) {
            this.headView.setData(this.itemType, issueResponse.getCommentsDO() != null ? this.issueResponse.getCommentsDO().getCommentId() : "-1", this.storeId, this.renderResponse, wh2.e(this.issueResponse.getHotScriptInfoList()));
            if (this.issueResponse.getHotScriptInfoList() != null) {
                this.adapter.e(this.itemType);
                this.adapter.setData(this.issueResponse.getHotScriptInfoList());
            }
        } else {
            this.headView.setData(this.itemType, "-1", this.storeId, this.renderResponse, 0);
        }
        if (this.shareMessage != null) {
            this.btnShare.setVisibility(0);
            this.btnShare.setOnClickListener(this);
            return;
        }
        this.btnShare.setVisibility(8);
    }

    private void initIRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1448833215")) {
            ipChange.ipc$dispatch("1448833215", new Object[]{this});
            return;
        }
        this.adapter = new EvaluateSuccessAdapter(this);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mRecyclerView.setAdapter(this.adapter);
        this.mRecyclerView.setRefreshEnabled(false);
        this.mRecyclerView.setLoadMoreEnabled(false);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
    }

    private void initIrcHead() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "166092818")) {
            ipChange.ipc$dispatch("166092818", new Object[]{this});
            return;
        }
        DMEvaluateSuccessHeadView dMEvaluateSuccessHeadView = new DMEvaluateSuccessHeadView(this);
        this.headView = dMEvaluateSuccessHeadView;
        this.mRecyclerView.addHeaderView(dMEvaluateSuccessHeadView);
    }

    private void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1452713140")) {
            ipChange.ipc$dispatch("1452713140", new Object[]{this});
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

    private void share() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2032322429")) {
            ipChange.ipc$dispatch("2032322429", new Object[]{this});
        } else if (this.shareMessage == null) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("title", this.shareMessage.shareTitle);
            bundle.putString("imageurl", this.shareMessage.shareContent);
            bundle.putString("message", this.shareMessage.sharePictureUrl);
            bundle.putString("producturl", this.shareMessage.shareLink);
            bundle.putString("shareType", "chat_h5");
            bundle.putBoolean("showGenerateImage", false);
            ShareManager.E().P(this, bundle, getWindow().getDecorView());
            c.e().x(dl.I().O(this.itemType, this.issueResponse.getCommentsDO().getCommentId()));
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-665416970")) {
            ipChange.ipc$dispatch("-665416970", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "746874164") ? ((Integer) ipChange.ipc$dispatch("746874164", new Object[]{this})).intValue() : R$layout.evaluate_success_layout;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-183736121")) {
            ipChange.ipc$dispatch("-183736121", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-29991356")) {
            ipChange.ipc$dispatch("-29991356", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1774636505")) {
            ipChange.ipc$dispatch("1774636505", new Object[]{this});
            return;
        }
        this.mViewStatusBarSpace = findViewById(R$id.comment_title_bar_space_view);
        this.btnShare = (TextView) findViewById(R$id.comment_success_share_btn);
        this.mRecyclerView = (IRecyclerView) findViewById(R$id.comment_list);
        setImmersionStyle();
        initIRecyclerView();
        initIrcHead();
        ((DMIconFontTextView) findViewById(R$id.comment_iv_manager_left_icon)).setOnClickListener(this);
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1459252353")) {
            ipChange.ipc$dispatch("-1459252353", new Object[]{this, view});
        } else if (view.getId() == R$id.comment_iv_manager_left_icon) {
            onBackPressed();
        } else if (view.getId() == R$id.comment_success_share_btn) {
            share();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1364391487")) {
            ipChange.ipc$dispatch("-1364391487", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(dl.I().M());
        if (getIntent() != null) {
            this.itemType = getIntent().getStringExtra("itemType");
            this.storeId = getIntent().getStringExtra("storeId");
            this.shareMessage = (DMShareMessage) getIntent().getSerializableExtra("shareMessage");
            this.issueResponse = (IssueResponse) getIntent().getSerializableExtra("issueResponse");
            this.renderResponse = (EvaluteSuccessRenderResponse) getIntent().getSerializableExtra("renderResponse");
        }
        initData();
        hideBaseLayout();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2050153623")) {
            return ((Boolean) ipChange.ipc$dispatch("2050153623", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 4) {
            onBackPressed();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1058814454")) {
            ipChange.ipc$dispatch("1058814454", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-330744481")) {
            ipChange.ipc$dispatch("-330744481", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-139255640")) {
            return (String) ipChange.ipc$dispatch("-139255640", new Object[]{this});
        }
        return null;
    }
}
