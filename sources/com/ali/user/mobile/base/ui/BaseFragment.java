package com.ali.user.mobile.base.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.DrawableRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.app.init.Debuggable;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;
import com.ali.user.mobile.helper.ActivityUIHelper;
import com.ali.user.mobile.helper.IDialogHelper;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.taobao.login4android.constants.LoginEnvType;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class BaseFragment extends Fragment {
    protected ActivityUIHelper mActivityHelper;
    protected BaseActivity mAttachedActivity;
    protected IDialogHelper mDialogHelper;
    protected View mFragmentView;
    protected boolean isConfigureChanged = false;
    protected int mCurrentScreenOrientation = 1;
    public boolean needAdaptElder = true;

    /* JADX INFO: Access modifiers changed from: protected */
    public void addControl(String str) {
        UserTrackAdapter.control(getPageName(), getPageSpm(), str);
    }

    public void alert(String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2) {
        IDialogHelper iDialogHelper = this.mDialogHelper;
        if (iDialogHelper != null) {
            iDialogHelper.alert(getActivity(), str, str2, str3, onClickListener, str4, onClickListener2);
        } else {
            this.mActivityHelper.alert(str, str2, str3, onClickListener, str4, onClickListener2);
        }
    }

    public void alertList(String[] strArr, DialogInterface.OnClickListener onClickListener, boolean z) {
        this.mActivityHelper.alertList(strArr, onClickListener, z);
    }

    public void dismiss() {
        try {
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager == null) {
                return;
            }
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.remove(this);
            beginTransaction.commitAllowingStateLoss();
            fragmentManager.popBackStack();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dismissAlertDialog() {
        IDialogHelper iDialogHelper = this.mDialogHelper;
        if (iDialogHelper != null) {
            iDialogHelper.dismissAlertDialog();
        } else {
            this.mActivityHelper.dismissAlertDialog();
        }
    }

    public void dismissLoading() {
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        dismissProgress();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dismissProgress() {
        IDialogHelper iDialogHelper = this.mDialogHelper;
        if (iDialogHelper != null) {
            iDialogHelper.dismissProgressDialog();
        } else {
            this.mActivityHelper.dismissProgressDialog();
        }
    }

    public AppCompatActivity getAppCompatActivity() {
        return this.mAttachedActivity;
    }

    public Activity getBaseActivity() {
        return this.mAttachedActivity;
    }

    protected int getLayoutContent() {
        return -1;
    }

    public String getPageName() {
        return "";
    }

    public String getPageSpm() {
        return "";
    }

    protected ActionBar getSupportActionBar() {
        return getAppCompatActivity().getSupportActionBar();
    }

    public void goSmsList() {
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setType("vnd.android-dir/mms-sms");
            intent.addFlags(268435456);
            startActivity(intent);
        } catch (Throwable th) {
            UserTrackAdapter.sendUT(getPageName(), "goSmsError");
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initViews(View view) {
    }

    public boolean isActive() {
        return isActivityAvaiable();
    }

    public boolean isActivityAvaiable() {
        boolean z;
        BaseActivity baseActivity;
        if (getActivity() != null && (baseActivity = this.mAttachedActivity) != null) {
            int i = Build.VERSION.SDK_INT;
            boolean isFinishing = baseActivity.isFinishing();
            if (i >= 17 ? !(isFinishing || this.mAttachedActivity.isDestroyed()) : !isFinishing) {
                z = true;
                return !z && isAdded();
            }
        }
        z = false;
        if (z) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof BaseActivity) {
            this.mAttachedActivity = (BaseActivity) activity;
        }
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (loginApprearanceExtensions != null && loginApprearanceExtensions.getDialogHelper() != null) {
            try {
                this.mDialogHelper = (IDialogHelper) AliUserLogin.mAppreanceExtentions.getDialogHelper().newInstance();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.mActivityHelper = new ActivityUIHelper(activity);
    }

    public boolean onBackPressed() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i = configuration.orientation;
        this.mCurrentScreenOrientation = i;
        onScreenRotate(i);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        if (getActivity() == null || Debuggable.isDebug() || DataProviderFactory.getDataProvider().getEnvType() != LoginEnvType.ONLINE.getSdkEnvType()) {
            return;
        }
        getActivity().getWindow().addFlags(8192);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(getLayoutContent(), (ViewGroup) null);
        this.mFragmentView = inflate;
        try {
            initViews(inflate);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!this.isConfigureChanged || z) {
            return;
        }
        onScreenRotate(this.mCurrentScreenOrientation);
        this.isConfigureChanged = false;
    }

    protected void onScreenRotate(int i) {
    }

    public void setNavigationBackIcon(@DrawableRes int i) {
        BaseActivity baseActivity = this.mAttachedActivity;
        if (baseActivity != null) {
            baseActivity.setNavigationBackIcon(i);
        }
    }

    public void showLoading() {
        showProgress("");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showProgress(String str) {
        IDialogHelper iDialogHelper = this.mDialogHelper;
        if (iDialogHelper != null) {
            iDialogHelper.showProgressDialog(getActivity(), str, true);
        } else {
            this.mActivityHelper.showProgress(str);
        }
    }

    public void toast(String str, int i) {
        if (this.mDialogHelper != null) {
            if (isActivityAvaiable()) {
                this.mDialogHelper.toast(getActivity().getApplicationContext(), str, i);
            }
        } else if (isActivityAvaiable()) {
            this.mActivityHelper.toast(str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uiShown(String str) {
        UserTrackAdapter.UIShown(getPageName(), getPageSpm(), str);
    }
}
