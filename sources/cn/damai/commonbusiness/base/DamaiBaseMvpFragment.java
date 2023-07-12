package cn.damai.commonbusiness.base;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import cn.damai.common.app.base.AbstractC0470a;
import cn.damai.common.app.base.BaseFragment;
import cn.damai.common.app.base.BaseModel;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public abstract class DamaiBaseMvpFragment<T extends AbstractC0470a, E extends BaseModel> extends BaseFragment<T, E> implements ResponseErrorPage.ErrorRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange;
    public Activity mActivity;
    public DamaiBaseActivity mBaseActivity;
    private C0525a.C0527b mBuilder;
    protected ResponseErrorPage mErrorPage;
    public C0525a.C0527b mUTBuilder;
    public boolean isNeedOnResumeUt = true;
    public boolean isNeedOnPauseUt = true;
    public boolean isFirstShowFragment = false;
    private boolean isRunningHidden = false;
    private boolean isUserVisibleHint = false;

    private void clearData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1322094035")) {
            ipChange.ipc$dispatch("1322094035", new Object[]{this});
        } else {
            this.isRunningHidden = false;
        }
    }

    public C0525a.C0527b getDamaiUTKeyBuilder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1190699366") ? (C0525a.C0527b) ipChange.ipc$dispatch("-1190699366", new Object[]{this}) : this.mBuilder;
    }

    @Override // cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-994616342")) {
            ipChange.ipc$dispatch("-994616342", new Object[]{this});
        } else {
            super.onDestroyView();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1059218325")) {
            ipChange.ipc$dispatch("1059218325", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.onHiddenChanged(z);
        this.isRunningHidden = true;
        if (this.mBaseActivity == null || this.mBuilder == null) {
            return;
        }
        if (isVisible() && !z) {
            C0529c.e().o(this, this.mBuilder);
            this.mBaseActivity.setCurrentFragment(this);
        }
        ArrayList<DamaiBaseMvpFragment> arrayList = this.mBaseActivity.fragmentList;
        if (arrayList != null) {
            if (z) {
                arrayList.remove(this);
            } else {
                arrayList.add(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResponseError(String str, String str2, String str3, View view, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1366940158")) {
            ipChange.ipc$dispatch("-1366940158", new Object[]{this, str, str2, str3, view, Boolean.valueOf(z)});
        } else {
            onResponseError(1, str, str2, str3, view, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResponseSuccess(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2139407061")) {
            ipChange.ipc$dispatch("-2139407061", new Object[]{this, view});
            return;
        }
        try {
            ResponseErrorPage responseErrorPage = this.mErrorPage;
            if (responseErrorPage != null) {
                responseErrorPage.setVisibility(8);
                if (view instanceof ViewGroup) {
                    ((ViewGroup) view).removeView(this.mErrorPage);
                }
                this.mErrorPage = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-744674028")) {
            ipChange.ipc$dispatch("-744674028", new Object[]{this});
            return;
        }
        super.onResume();
        this.mActivity = getActivity();
        if (getActivity() == null || !(getActivity() instanceof DamaiBaseActivity)) {
            return;
        }
        DamaiBaseActivity damaiBaseActivity = (DamaiBaseActivity) getActivity();
        this.mBaseActivity = damaiBaseActivity;
        if (damaiBaseActivity == null || this.mBuilder == null) {
            return;
        }
        if ((isVisible() || this.isFirstShowFragment) && !this.isRunningHidden && !this.isUserVisibleHint && getUserVisibleHint()) {
            this.mBaseActivity.fragmentList.add(this);
            this.mBaseActivity.setCurrentFragment(this);
            if (this.isNeedOnResumeUt) {
                DamaiBaseMvpFragment damaiBaseMvpFragment = this.mBaseActivity.lastHandleFragment;
                if (damaiBaseMvpFragment != null) {
                    if (damaiBaseMvpFragment.equals(this)) {
                        C0529c.e().o(this, this.mBuilder);
                        this.mBaseActivity.lastHandleFragment = null;
                    }
                } else {
                    C0529c.e().o(this, this.mBuilder);
                }
            } else {
                this.isNeedOnResumeUt = true;
            }
        }
        this.isRunningHidden = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1195004897")) {
            ipChange.ipc$dispatch("-1195004897", new Object[]{this});
            return;
        }
        super.onStop();
        DamaiBaseActivity damaiBaseActivity = this.mBaseActivity;
        if (damaiBaseActivity == null || this.mBuilder == null) {
            return;
        }
        if (this.isNeedOnPauseUt && !damaiBaseActivity.isFinishing() && getUserVisibleHint()) {
            this.mBaseActivity.fragmentList.remove(this);
            C0525a.C0527b damaiUTKeyBuilder = this.mBaseActivity.getDamaiUTKeyBuilder();
            ArrayList<DamaiBaseMvpFragment> arrayList = this.mBaseActivity.fragmentList;
            if (arrayList != null) {
                if (arrayList.size() > 0) {
                    ArrayList<DamaiBaseMvpFragment> arrayList2 = this.mBaseActivity.fragmentList;
                    damaiUTKeyBuilder = arrayList2.get(arrayList2.size() - 1).getDamaiUTKeyBuilder();
                } else if (this.mBaseActivity.isCurrentFragment(this) && this.mBaseActivity.fragmentList.size() == 0) {
                    damaiUTKeyBuilder = this.mBaseActivity.getDamaiUTKeyBuilder();
                }
            }
            C0529c.e().o(this, damaiUTKeyBuilder);
        } else {
            DamaiBaseActivity damaiBaseActivity2 = this.mBaseActivity;
            if (damaiBaseActivity2 != null) {
                damaiBaseActivity2.fragmentList.remove(this);
            }
            this.isNeedOnPauseUt = true;
            this.isUserVisibleHint = false;
        }
        clearData();
    }

    public void pageUtBuild() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1071475210")) {
            ipChange.ipc$dispatch("1071475210", new Object[]{this});
        } else if (this.mUTBuilder != null) {
            C0529c.e().o(this, this.mUTBuilder);
        }
    }

    public void setDamaiUTKeyBuilder(C0525a.C0527b c0527b) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "514256184")) {
            ipChange.ipc$dispatch("514256184", new Object[]{this, c0527b});
        } else {
            this.mBuilder = c0527b;
        }
    }

    protected void setResponseErrorTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "942026273")) {
            ipChange.ipc$dispatch("942026273", new Object[]{this, str});
            return;
        }
        ResponseErrorPage responseErrorPage = this.mErrorPage;
        if (responseErrorPage != null) {
            responseErrorPage.setTitleContent(str);
        }
    }

    public void setUTBuilder(C0525a.C0527b c0527b) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1505099489")) {
            ipChange.ipc$dispatch("1505099489", new Object[]{this, c0527b});
        } else {
            this.mUTBuilder = c0527b;
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1308227488")) {
            ipChange.ipc$dispatch("1308227488", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        this.isUserVisibleHint = true;
        if (this.mBaseActivity == null || this.mBuilder == null) {
            if (z) {
                this.isUserVisibleHint = false;
                return;
            }
            return;
        }
        if (z) {
            C0529c.e().o(this, this.mBuilder);
            this.mBaseActivity.setCurrentFragment(this);
        }
        ArrayList<DamaiBaseMvpFragment> arrayList = this.mBaseActivity.fragmentList;
        if (arrayList != null) {
            if (!z) {
                arrayList.remove(this);
            } else {
                arrayList.add(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResponseError(int i, String str, String str2, String str3, View view, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-989405247")) {
            ipChange.ipc$dispatch("-989405247", new Object[]{this, Integer.valueOf(i), str, str2, str3, view, Boolean.valueOf(z)});
            return;
        }
        ResponseErrorPage responseErrorPage = this.mErrorPage;
        if (responseErrorPage == null || (!responseErrorPage.isShown() && this.mErrorPage.getParent() == null)) {
            ResponseErrorPage responseErrorPage2 = new ResponseErrorPage(getActivity(), i, str2, str, str3);
            this.mErrorPage = responseErrorPage2;
            if (z) {
                responseErrorPage2.hideTitle();
            }
            this.mErrorPage.setRefreshListener(this);
            if (view instanceof FrameLayout) {
                this.mErrorPage.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                ((FrameLayout) view).addView(this.mErrorPage);
            } else if (view instanceof RelativeLayout) {
                this.mErrorPage.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                ((RelativeLayout) view).addView(this.mErrorPage);
            } else if (view instanceof LinearLayout) {
                this.mErrorPage.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                ((LinearLayout) view).addView(this.mErrorPage, 0);
            } else if (view instanceof ViewGroup) {
                ((ViewGroup) view).addView(this.mErrorPage, new ViewGroup.LayoutParams(-1, -1));
            }
        }
    }
}
