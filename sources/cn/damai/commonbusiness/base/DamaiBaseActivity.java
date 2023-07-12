package cn.damai.commonbusiness.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import cn.damai.baseview.abcpullrefresh.smoothprogressbar.SmoothProgressBar;
import cn.damai.common.app.base.BaseActivity;
import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.commonbusiness.screenshot.ScreenShotBean;
import cn.damai.commonbusiness.screenshot.ScreenShotDetector;
import cn.damai.tetris.IOnResultListener;
import com.alibaba.pictures.bricks.base.BricksBaseFragment;
import com.alibaba.pictures.bricks.base.IBaseActivityProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.k3;
import tb.np0;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public abstract class DamaiBaseActivity<T extends cn.damai.common.app.base.a, E extends BaseModel> extends BaseActivity<T, E> implements ResponseErrorPage.ErrorRefreshListener, IBaseActivityProxy {
    private static transient /* synthetic */ IpChange $ipChange;
    private DamaiBaseMvpFragment currentFragment;
    public a.b mBuilder;
    protected ResponseErrorPage mErrorPage;
    protected View mProgressBar;
    protected SmoothProgressBar mSmoothProgressBar;
    public ArrayList<DamaiBaseMvpFragment> fragmentList = new ArrayList<>();
    private DamaiBaseMvpFragment firstLoadFragment = null;
    public DamaiBaseMvpFragment lastHandleFragment = null;
    public boolean isFromHome = false;
    ArrayList<IOnResultListener> listeners = new ArrayList<>();

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class a implements ResponseErrorPage.ErrorRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ BricksBaseFragment.IClickListener a;

        a(DamaiBaseActivity damaiBaseActivity, BricksBaseFragment.IClickListener iClickListener) {
            this.a = iClickListener;
        }

        @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
        public void handleError(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "61231998")) {
                ipChange.ipc$dispatch("61231998", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            BricksBaseFragment.IClickListener iClickListener = this.a;
            if (iClickListener != null) {
                iClickListener.handleClick(i);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class b implements ResponseErrorPage.ErrorRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ BricksBaseFragment.IClickListener a;

        b(DamaiBaseActivity damaiBaseActivity, BricksBaseFragment.IClickListener iClickListener) {
            this.a = iClickListener;
        }

        @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
        public void handleError(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-783239873")) {
                ipChange.ipc$dispatch("-783239873", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            BricksBaseFragment.IClickListener iClickListener = this.a;
            if (iClickListener != null) {
                iClickListener.handleClick(i);
            }
        }
    }

    private void applyProgressBarSettings() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1049983107")) {
            ipChange.ipc$dispatch("-1049983107", new Object[]{this});
            return;
        }
        View view = this.mProgressBar;
        if (view != null) {
            this.mSmoothProgressBar = (SmoothProgressBar) view.findViewById(R$id.ptr_progress);
            ShapeDrawable shapeDrawable = new ShapeDrawable();
            shapeDrawable.setShape(new RectShape());
            shapeDrawable.getPaint().setColor(ContextCompat.getColor(this.mContext, R$color.default_progress_bar_color));
            this.mSmoothProgressBar.setProgressDrawable(new ClipDrawable(shapeDrawable, 17, 1));
            SmoothProgressBar smoothProgressBar = this.mSmoothProgressBar;
            smoothProgressBar.setProgress(smoothProgressBar.getMax());
            this.mSmoothProgressBar.setIndeterminate(true);
        }
    }

    public void addResultListener(IOnResultListener iOnResultListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-970166173")) {
            ipChange.ipc$dispatch("-970166173", new Object[]{this, iOnResultListener});
            return;
        }
        ArrayList<IOnResultListener> arrayList = this.listeners;
        if (arrayList != null) {
            arrayList.add(iOnResultListener);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public List<Fragment> getActiveFragment() {
        List<Fragment> fragments;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1015792351")) {
            return (List) ipChange.ipc$dispatch("-1015792351", new Object[]{this});
        }
        ArrayList arrayList = null;
        if (isFinishing()) {
            return null;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null && (fragments = supportFragmentManager.getFragments()) != null) {
            arrayList = new ArrayList();
            for (int i = 0; i < fragments.size(); i++) {
                if (fragments.get(i) instanceof DamaiBaseMvpFragment) {
                    arrayList.add(fragments.get(i));
                }
            }
        }
        return arrayList;
    }

    public DamaiBaseMvpFragment getCurFragment() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-628323380") ? (DamaiBaseMvpFragment) ipChange.ipc$dispatch("-628323380", new Object[]{this}) : this.currentFragment;
    }

    public a.b getDamaiUTKeyBuilder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1730864878") ? (a.b) ipChange.ipc$dispatch("-1730864878", new Object[]{this}) : this.mBuilder;
    }

    public ScreenShotBean getDetectBean(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-556941554") ? (ScreenShotBean) ipChange.ipc$dispatch("-556941554", new Object[]{this, str}) : ScreenShotDetector.k().r(str);
    }

    @Override // com.alibaba.pictures.bricks.base.IBaseActivityProxy
    public void hideLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1765896648")) {
            ipChange.ipc$dispatch("-1765896648", new Object[]{this});
        } else {
            stopProgressDialog();
        }
    }

    @Override // com.alibaba.pictures.bricks.base.IBaseActivityProxy
    public void hideLoadingDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1950618224")) {
            ipChange.ipc$dispatch("-1950618224", new Object[]{this});
        } else {
            stopProgressDialog();
        }
    }

    public void hideLoadingTip(ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1450649270")) {
            ipChange.ipc$dispatch("1450649270", new Object[]{this, viewGroup});
            return;
        }
        View view = this.mProgressBar;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    public boolean isCurrentFragment(DamaiBaseMvpFragment damaiBaseMvpFragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1418369135")) {
            return ((Boolean) ipChange.ipc$dispatch("1418369135", new Object[]{this, damaiBaseMvpFragment})).booleanValue();
        }
        DamaiBaseMvpFragment damaiBaseMvpFragment2 = this.currentFragment;
        if (damaiBaseMvpFragment2 != null) {
            return damaiBaseMvpFragment2.equals(damaiBaseMvpFragment);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-119600854")) {
            ipChange.ipc$dispatch("-119600854", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        Iterator<IOnResultListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            IOnResultListener next = it.next();
            if (next != null) {
                next.onResult(i, i2, intent);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-716954762")) {
            ipChange.ipc$dispatch("-716954762", new Object[]{this});
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1184205269")) {
            ipChange.ipc$dispatch("1184205269", new Object[]{this, configuration});
        } else {
            super.onConfigurationChanged(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-695479977")) {
            ipChange.ipc$dispatch("-695479977", new Object[]{this, bundle});
            return;
        }
        np0 np0Var = np0.fragmentXFixer;
        np0Var.b(this, bundle);
        if (getIntent() != null) {
            np0Var.b(this, getIntent().getExtras());
        }
        super.onCreate(bundle);
        k3.b().e(this);
        c.e().m(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-492354985")) {
            ipChange.ipc$dispatch("-492354985", new Object[]{this});
            return;
        }
        super.onDestroy();
        k3.b().f(this);
        this.listeners.clear();
    }

    public void onFeedbackClick(ScreenShotBean screenShotBean, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1560611217")) {
            ipChange.ipc$dispatch("-1560611217", new Object[]{this, screenShotBean, activity});
            return;
        }
        if (ScreenShotDetector.k().o()) {
            activity.finish();
        }
        Bundle bundle = new Bundle();
        if (screenShotBean != null) {
            bundle.putSerializable("screenshot_info", screenShotBean);
            bundle.putBoolean("fromFloatActivity", true);
        }
        DMNav.from(this).withExtras(bundle).toUri(NavUri.b("feedback_list"));
    }

    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "748026144")) {
            ipChange.ipc$dispatch("748026144", new Object[]{this});
        }
    }

    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1033506571")) {
            ipChange.ipc$dispatch("-1033506571", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        ArrayList<DamaiBaseMvpFragment> arrayList;
        ArrayList<DamaiBaseMvpFragment> arrayList2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-154091045")) {
            ipChange.ipc$dispatch("-154091045", new Object[]{this});
            return;
        }
        super.onPause();
        ScreenShotDetector.k().v(true);
        c.e().q(this);
        List<Fragment> activeFragment = getActiveFragment();
        if (activeFragment != null && activeFragment.size() > 0) {
            for (int i = 0; i < activeFragment.size(); i++) {
                DamaiBaseMvpFragment damaiBaseMvpFragment = (DamaiBaseMvpFragment) activeFragment.get(i);
                if (damaiBaseMvpFragment != null) {
                    if (!isCurrentFragment(damaiBaseMvpFragment) && (!damaiBaseMvpFragment.equals(this.firstLoadFragment) || activeFragment.size() != 1 || (arrayList2 = this.fragmentList) == null || arrayList2.size() != 1)) {
                        damaiBaseMvpFragment.isNeedOnResumeUt = false;
                    } else {
                        damaiBaseMvpFragment.isNeedOnResumeUt = true;
                    }
                    if (damaiBaseMvpFragment.equals(this.firstLoadFragment) && !isCurrentFragment(damaiBaseMvpFragment) && (arrayList = this.fragmentList) != null && arrayList.size() > 1 && this.lastHandleFragment == null) {
                        ArrayList<DamaiBaseMvpFragment> arrayList3 = this.fragmentList;
                        DamaiBaseMvpFragment damaiBaseMvpFragment2 = arrayList3.get(arrayList3.size() - 1);
                        this.lastHandleFragment = damaiBaseMvpFragment2;
                        damaiBaseMvpFragment2.isNeedOnResumeUt = true;
                    }
                    damaiBaseMvpFragment.isNeedOnPauseUt = false;
                }
            }
        }
        if (this.fragmentList != null) {
            for (int i2 = 0; i2 < this.fragmentList.size(); i2++) {
                if (this.fragmentList.get(i2) != null) {
                    this.fragmentList.get(i2).isNeedOnPauseUt = false;
                }
            }
        }
        if (!this.isFromHome || activeFragment == null || activeFragment.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < activeFragment.size(); i3++) {
            DamaiBaseMvpFragment damaiBaseMvpFragment3 = (DamaiBaseMvpFragment) activeFragment.get(i3);
            if (damaiBaseMvpFragment3 != null) {
                damaiBaseMvpFragment3.onStop();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResponseError(String str, String str2, String str3, View view, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1669013130")) {
            ipChange.ipc$dispatch("1669013130", new Object[]{this, str, str2, str3, view, Boolean.valueOf(z)});
        } else {
            onResponseError(1, str, str2, str3, view, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResponseSuccess(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1978326947")) {
            ipChange.ipc$dispatch("1978326947", new Object[]{this, view});
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        ArrayList<DamaiBaseMvpFragment> arrayList;
        ArrayList<DamaiBaseMvpFragment> arrayList2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1165931404")) {
            ipChange.ipc$dispatch("1165931404", new Object[]{this});
            return;
        }
        super.onResume();
        setmDetectActivityShow(true);
        ScreenShotDetector.k().v(false);
        List<Fragment> activeFragment = getActiveFragment();
        if (this.mBuilder != null) {
            c.e().n(this, this.mBuilder);
        } else if (activeFragment != null && activeFragment.size() > 0) {
            if (this.currentFragment != null) {
                for (int i = 0; i < activeFragment.size(); i++) {
                    DamaiBaseMvpFragment damaiBaseMvpFragment = (DamaiBaseMvpFragment) activeFragment.get(i);
                    if (damaiBaseMvpFragment != null) {
                        if (!isCurrentFragment(damaiBaseMvpFragment) && ((getActiveFragment().size() != 1 || (arrayList2 = this.fragmentList) == null || arrayList2.size() != 0 || (this.lastHandleFragment != null && !isCurrentFragment(damaiBaseMvpFragment))) && ((arrayList = this.fragmentList) == null || arrayList.size() != 1 || !damaiBaseMvpFragment.equals(this.firstLoadFragment)))) {
                            damaiBaseMvpFragment.isFirstShowFragment = false;
                        } else {
                            damaiBaseMvpFragment.isFirstShowFragment = true;
                        }
                    }
                }
            } else if (activeFragment.get(0) != null) {
                ((DamaiBaseMvpFragment) activeFragment.get(0)).isFirstShowFragment = true;
                this.firstLoadFragment = (DamaiBaseMvpFragment) activeFragment.get(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-110986257")) {
            ipChange.ipc$dispatch("-110986257", new Object[]{this});
        } else {
            super.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-406425449")) {
            ipChange.ipc$dispatch("-406425449", new Object[]{this});
        } else {
            super.onStop();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2065449447")) {
            ipChange.ipc$dispatch("2065449447", new Object[]{this, Boolean.valueOf(z)});
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // com.alibaba.pictures.bricks.base.IBaseActivityProxy
    public void removeErrorView(ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "445996936")) {
            ipChange.ipc$dispatch("445996936", new Object[]{this, viewGroup});
        } else {
            onResponseSuccess(viewGroup);
        }
    }

    public void removeResultListener(IOnResultListener iOnResultListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2094794208")) {
            ipChange.ipc$dispatch("2094794208", new Object[]{this, iOnResultListener});
            return;
        }
        ArrayList<IOnResultListener> arrayList = this.listeners;
        if (arrayList != null) {
            arrayList.remove(iOnResultListener);
        }
    }

    public void setCurrentFragment(DamaiBaseMvpFragment damaiBaseMvpFragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-33502067")) {
            ipChange.ipc$dispatch("-33502067", new Object[]{this, damaiBaseMvpFragment});
        } else {
            this.currentFragment = damaiBaseMvpFragment;
        }
    }

    public void setDamaiUTKeyBuilder(a.b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "948994496")) {
            ipChange.ipc$dispatch("948994496", new Object[]{this, bVar});
        } else {
            this.mBuilder = bVar;
        }
    }

    protected void setResponseErrorTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-500049751")) {
            ipChange.ipc$dispatch("-500049751", new Object[]{this, str});
            return;
        }
        ResponseErrorPage responseErrorPage = this.mErrorPage;
        if (responseErrorPage != null) {
            responseErrorPage.setTitleContent(str);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void setRightIcon(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1895336322")) {
            ipChange.ipc$dispatch("-1895336322", new Object[]{this, Integer.valueOf(i)});
        } else {
            super.setRightIcon(i);
        }
    }

    public void setmDetectActivityShow(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1523922102")) {
            ipChange.ipc$dispatch("1523922102", new Object[]{this, Boolean.valueOf(z)});
        } else {
            ScreenShotDetector.k().y(z);
        }
    }

    @Override // com.alibaba.pictures.bricks.base.IBaseActivityProxy
    public void showErrorView(@NonNull String str, @NonNull String str2, @NonNull ViewGroup viewGroup, @NonNull BricksBaseFragment.IClickListener iClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1640861722")) {
            ipChange.ipc$dispatch("1640861722", new Object[]{this, str, str2, viewGroup, iClickListener});
            return;
        }
        onResponseError(str, str2, null, viewGroup, true);
        ResponseErrorPage responseErrorPage = this.mErrorPage;
        if (responseErrorPage != null) {
            responseErrorPage.setRefreshListener(new a(this, iClickListener));
        }
    }

    @Override // com.alibaba.pictures.bricks.base.IBaseActivityProxy
    public void showLoading(String... strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1601854476")) {
            ipChange.ipc$dispatch("1601854476", new Object[]{this, strArr});
        } else {
            startProgressDialog();
        }
    }

    @Override // com.alibaba.pictures.bricks.base.IBaseActivityProxy
    public void showLoadingDialog(String... strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-374153740")) {
            ipChange.ipc$dispatch("-374153740", new Object[]{this, strArr});
        } else {
            startProgressDialog();
        }
    }

    public void showLoadingTip(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "721530274")) {
            ipChange.ipc$dispatch("721530274", new Object[]{this, viewGroup, layoutParams});
        } else if (viewGroup == null) {
        } else {
            View view = this.mProgressBar;
            if (view == null) {
                this.mProgressBar = this.mInflater.inflate(R$layout.smooth_progressbar, (ViewGroup) null);
                applyProgressBarSettings();
                viewGroup.addView(this.mProgressBar, layoutParams);
                return;
            }
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResponseError(int i, String str, String str2, String str3, View view, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1364133831")) {
            ipChange.ipc$dispatch("-1364133831", new Object[]{this, Integer.valueOf(i), str, str2, str3, view, Boolean.valueOf(z)});
            return;
        }
        ResponseErrorPage responseErrorPage = this.mErrorPage;
        if (responseErrorPage == null || (!responseErrorPage.isShown() && this.mErrorPage.getParent() == null)) {
            ResponseErrorPage responseErrorPage2 = new ResponseErrorPage(this, i, str2, str, str3);
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

    @Override // com.alibaba.pictures.bricks.base.IBaseActivityProxy
    public void showErrorView(int i, @NonNull String str, @NonNull String str2, @NonNull ViewGroup viewGroup, boolean z, boolean z2, boolean z3, @NonNull BricksBaseFragment.IClickListener iClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1474778363")) {
            ipChange.ipc$dispatch("-1474778363", new Object[]{this, Integer.valueOf(i), str, str2, viewGroup, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), iClickListener});
            return;
        }
        onResponseError(i, str, str2, null, viewGroup, z3);
        ResponseErrorPage responseErrorPage = this.mErrorPage;
        if (responseErrorPage != null) {
            if (!z && responseErrorPage.getRefreshBtn() != null) {
                this.mErrorPage.getRefreshBtn().setVisibility(8);
            }
            if (!z2 && this.mErrorPage.getReportBtn() != null) {
                this.mErrorPage.getReportBtn().setVisibility(8);
            }
            this.mErrorPage.setRefreshListener(new b(this, iClickListener));
        }
    }
}
