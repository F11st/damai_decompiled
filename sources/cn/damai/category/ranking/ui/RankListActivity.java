package cn.damai.category.ranking.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.category.discountticket.ui.OnErrorClickListener;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RankListActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private RankListFragment fragment;
    private String mId;

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "132945088")) {
            return ((Integer) ipChange.ipc$dispatch("132945088", new Object[]{this})).intValue();
        }
        return 0;
    }

    public void hideErrorView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "878996981")) {
            ipChange.ipc$dispatch("878996981", new Object[]{this, view});
        } else if (view != null) {
            onResponseSuccess(view);
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "390172276")) {
            ipChange.ipc$dispatch("390172276", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        ShareManager.E().r0(i, i2, intent);
        RankListFragment rankListFragment = this.fragment;
        if (rankListFragment != null) {
            rankListFragment.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "113025357")) {
            ipChange.ipc$dispatch("113025357", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(R$layout.dm_layout_randlist_content);
        c.e().K(this);
        hideBaseLayout();
        removeHeadTitleView();
        if (getIntent() == null || getIntent().getExtras() == null) {
            return;
        }
        String string = getIntent().getExtras().getString(RankListFragment.KEY_RANK_ID);
        this.mId = string;
        if (TextUtils.isEmpty(string)) {
            this.mId = getIntent().getExtras().getLong(RankListFragment.KEY_RANK_ID) + "";
        }
        this.fragment = RankListFragment.newInstance(this.mId);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R$id.fragment_container, this.fragment);
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "698034996")) {
            return (String) ipChange.ipc$dispatch("698034996", new Object[]{this});
        }
        return null;
    }

    public void showErrorView(View view, String str, String str2, String str3, OnErrorClickListener onErrorClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1297519355")) {
            ipChange.ipc$dispatch("-1297519355", new Object[]{this, view, str, str2, str3, onErrorClickListener});
        } else if (view != null) {
            onResponseError(str2, str, str3, view, true);
            ResponseErrorPage responseErrorPage = this.mErrorPage;
            if (responseErrorPage != null) {
                responseErrorPage.setRefreshListener(onErrorClickListener);
            }
        }
    }
}
