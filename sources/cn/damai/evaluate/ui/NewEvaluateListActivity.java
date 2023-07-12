package cn.damai.evaluate.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.comment.R$color;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.evaluate.ui.item.EvaluateItemDataBinder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.dl;
import tb.g41;
import tb.kg2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class NewEvaluateListActivity extends DamaiBaseActivity implements EvaluateItemDataBinder.EvaluateItemUTReportListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String IS_ALLOW_SHOW_WANT_GUIDE = "IS_ALLOW_SHOW_WANT_GUIDE";
    public static final String TOWHERE_EVALUATE = "EVALUATE_LIST";
    public static final String TOWHERE_TAG = "TOWHERE";
    public static final String TOWHERE_VEVALUATE = "VEVALUATE_LIST";
    EvaluateListFragment evaluateListFragment;
    private FragmentManager fm;
    private boolean isFromScript;
    private String mIpId;
    public long mItemId;
    private String mScriptId;
    private String mTourId;
    private String toWhere;
    private FragmentTransaction transaction;

    private void initExtras() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "855320968")) {
            ipChange.ipc$dispatch("855320968", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (extras.containsKey("projectId")) {
                try {
                    this.mItemId = Long.parseLong(intent.getStringExtra("projectId"));
                } catch (Throwable unused) {
                }
            } else {
                this.mItemId = extras.getLong("itemId");
            }
            this.mScriptId = extras.getString("scriptId");
            this.mIpId = extras.getString(g41.ISSUE_PARAM_IPID);
            this.mTourId = extras.getString("tourId");
            this.toWhere = extras.getString(TOWHERE_TAG, TOWHERE_EVALUATE);
            if (extras.containsKey("scriptId") && extras.getString("scriptId") != null) {
                z = true;
            }
            this.isFromScript = z;
        }
    }

    private void initTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1906457607")) {
            ipChange.ipc$dispatch("1906457607", new Object[]{this});
            return;
        }
        findViewById(R$id.evaluate_list_title_left_icon).setOnClickListener(this);
        TextView textView = (TextView) findViewById(R$id.evaluate_list_title);
        if (this.isFromScript) {
            textView.setText("全部内容");
        } else {
            textView.setText("全部评价");
        }
    }

    private void initTitleStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1957034210")) {
            ipChange.ipc$dispatch("1957034210", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.title_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            findViewById.getLayoutParams().height = kg2.a(this);
            findViewById.setVisibility(0);
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
            return;
        }
        kg2.f(this, false, R$color.black);
        findViewById.setVisibility(8);
    }

    private void replaceFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1648175371")) {
            ipChange.ipc$dispatch("1648175371", new Object[]{this});
            return;
        }
        EvaluateListFragment evaluateListFragment = EvaluateListFragment.getInstance(this.mItemId + "", this.mIpId, this.mTourId);
        this.evaluateListFragment = evaluateListFragment;
        evaluateListFragment.setEvalutateItemClickUTData(this);
        this.evaluateListFragment.setArguments(getIntent().getExtras());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.fm = supportFragmentManager;
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        this.transaction = beginTransaction;
        beginTransaction.replace(R$id.evaluate_container, this.evaluateListFragment);
        this.transaction.commitAllowingStateLoss();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1045298083")) {
            ipChange.ipc$dispatch("1045298083", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "415923303") ? ((Integer) ipChange.ipc$dispatch("415923303", new Object[]{this})).intValue() : R$layout.new_evaluate_activity;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1853278220")) {
            ipChange.ipc$dispatch("-1853278220", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-246188873")) {
            ipChange.ipc$dispatch("-246188873", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1086571642")) {
            ipChange.ipc$dispatch("-1086571642", new Object[]{this});
            return;
        }
        hideBaseLayout();
        initExtras();
        initTitleStatusBar();
        initTitle();
        replaceFragment();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1948225043")) {
            ipChange.ipc$dispatch("-1948225043", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        ShareManager.E().r0(i, i2, intent);
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-218247188")) {
            ipChange.ipc$dispatch("-218247188", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        if (view.getId() == R$id.evaluate_list_title_left_icon) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1547937036")) {
            ipChange.ipc$dispatch("-1547937036", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(dl.I().z(z20.E()));
        C0529c.e().K(this);
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportImageInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1073404463")) {
            ipChange.ipc$dispatch("-1073404463", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (commentsItemBean == null || commentsItemBean.getUserDO() == null || this.evaluateListFragment.getChooseLabel() == null) {
        } else {
            C0529c.e().x(dl.I().B(commentsItemBean.getCommentId(), commentsItemBean.getUserDO().getDamaiUserId(), this.evaluateListFragment.getChooseLabel().getLabelName(), (i2 != 0 || commentsItemBean.getVideoDO() == null) ? "" : commentsItemBean.getVideoDO().getVideoId(), this.evaluateListFragment.getChooseLabel().getPos(), i, i2));
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportItemClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "196085262")) {
            ipChange.ipc$dispatch("196085262", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        } else if (commentsItemBean == null || commentsItemBean.getUserDO() == null || this.evaluateListFragment.getChooseLabel() == null) {
        } else {
            C0529c.e().x(dl.I().C(commentsItemBean.getCommentId(), commentsItemBean.getUserDO().getDamaiUserId(), this.mScriptId, this.evaluateListFragment.getChooseLabel().getLabelName(), this.evaluateListFragment.getChooseLabel().getPos(), i));
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportMoreInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2056799234")) {
            ipChange.ipc$dispatch("-2056799234", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        } else if (commentsItemBean == null || commentsItemBean.getUserDO() == null || this.evaluateListFragment.getChooseLabel() == null) {
        } else {
            C0529c.e().x(dl.I().G(commentsItemBean.getCommentId(), commentsItemBean.getUserDO().getDamaiUserId(), this.mScriptId, this.evaluateListFragment.getChooseLabel().getLabelName(), this.evaluateListFragment.getChooseLabel().getPos(), i));
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportPraiseViewClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1449815264")) {
            ipChange.ipc$dispatch("1449815264", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        } else if (commentsItemBean == null || commentsItemBean.getUserDO() == null || this.evaluateListFragment.getChooseLabel() == null) {
        } else {
            C0529c.e().x(dl.I().E(commentsItemBean.getCommentId(), commentsItemBean.getUserDO().getDamaiUserId(), this.evaluateListFragment.getChooseLabel().getLabelName(), this.evaluateListFragment.getChooseLabel().getPos(), i));
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportReplyClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-305185135")) {
            ipChange.ipc$dispatch("-305185135", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        } else if (commentsItemBean == null || commentsItemBean.getUserDO() == null || this.evaluateListFragment.getChooseLabel() == null) {
        } else {
            C0529c.e().x(dl.I().F(commentsItemBean.getCommentId(), commentsItemBean.getUserDO().getDamaiUserId(), this.evaluateListFragment.getChooseLabel().getLabelName(), this.evaluateListFragment.getChooseLabel().getPos(), i));
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportSyncCircleClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "850551958")) {
            ipChange.ipc$dispatch("850551958", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportTransferClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-203688778")) {
            ipChange.ipc$dispatch("-203688778", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportUserInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1226164680")) {
            ipChange.ipc$dispatch("1226164680", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        } else if (commentsItemBean == null || commentsItemBean.getUserDO() == null || this.evaluateListFragment.getChooseLabel() == null) {
        } else {
            C0529c.e().x(dl.I().H(commentsItemBean.getCommentId(), commentsItemBean.getUserDO().getDamaiUserId(), this.mScriptId, this.evaluateListFragment.getChooseLabel().getLabelName(), this.evaluateListFragment.getChooseLabel().getPos(), i));
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1900338533")) {
            return (String) ipChange.ipc$dispatch("-1900338533", new Object[]{this});
        }
        return null;
    }
}
