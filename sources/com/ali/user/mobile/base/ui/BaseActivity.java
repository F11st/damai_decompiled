package com.ali.user.mobile.base.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.ali.user.mobile.app.dataprovider.DataProvider;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;
import com.ali.user.mobile.helper.ActivityUIHelper;
import com.ali.user.mobile.helper.IDialogHelper;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.login.action.LoginResActions;
import com.ali.user.mobile.security.biz.R;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class BaseActivity extends AppCompatActivity {
    public static int HOOK_NATIVE_BACK = 0;
    private static final String TAG = "BaseActivity";
    protected boolean activityIsTranslucent;
    protected boolean isLoginObserver;
    protected ViewGroup mContentView;
    protected IDialogHelper mDialogHelper;
    protected BroadcastReceiver mLoginReceiver;
    protected Toolbar mToolbar;
    protected ViewGroup mViewGroup;
    public boolean supportTaobaoOrAlipay = false;
    public boolean isHookNativeBackByJs = false;
    public boolean isHookNativeBack = false;
    protected Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.ali.user.mobile.base.ui.BaseActivity.2
        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            super.dispatchMessage(message);
            if (message.what == BaseActivity.HOOK_NATIVE_BACK) {
                TLogAdapter.e(BaseActivity.TAG, "onMessage : " + message.what);
                BaseActivity.this.isHookNativeBack = true;
            }
        }
    };

    public void alert(String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2) {
        IDialogHelper iDialogHelper = this.mDialogHelper;
        if (iDialogHelper != null) {
            iDialogHelper.alert(this, str, str2, str3, onClickListener, str4, onClickListener2);
        }
    }

    public void dismissAlertDialog() {
        IDialogHelper iDialogHelper = this.mDialogHelper;
        if (iDialogHelper != null) {
            iDialogHelper.dismissAlertDialog();
        }
    }

    public void dismissProgressDialog() {
        IDialogHelper iDialogHelper = this.mDialogHelper;
        if (iDialogHelper != null) {
            iDialogHelper.dismissProgressDialog();
        }
    }

    protected void finishWhenLoginSuccess() {
        finish();
    }

    public Handler getHandler() {
        return this.handler;
    }

    protected int getLayoutContent() {
        return R.C2960layout.aliuser_activity_parent_default_content;
    }

    public Toolbar getToolbar() {
        return this.mToolbar;
    }

    protected int getToolbarLayout() {
        return R.C2960layout.aliuser_toolbar;
    }

    public void hideInputMethodPannel(View view) {
        if (view != null) {
            try {
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void initToolBar() {
        ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(getToolbarLayout(), this.mViewGroup, false);
        this.mToolbar = (AliUserCustomToolbar) viewGroup.findViewById(R.id.aliuser_toolbar);
        this.mViewGroup.addView(viewGroup, 0);
        setSupportActionBar(this.mToolbar);
        if (isShowNavIcon()) {
            if (isNavIconLeftBack()) {
                if (DataProviderFactory.getDataProvider().getToolbarBackIcon() > 0) {
                    setNavigationBackIcon(DataProviderFactory.getDataProvider().getToolbarBackIcon());
                } else {
                    setNavigationBackIcon(R.C2959drawable.aliuser_ic_actionbar_back);
                }
            } else {
                setNavigationCloseIcon();
            }
        } else {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
        this.mToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.ali.user.mobile.base.ui.BaseActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivity.this.hideInputMethodPannel(view);
                BaseActivity.this.onBackPressed();
            }
        });
        this.mToolbar.setNavigationContentDescription(R.string.aliuser_title_back);
        if (DataProviderFactory.getDataProvider().isTaobaoApp()) {
            ViewGroup.LayoutParams layoutParams = this.mToolbar.getLayoutParams();
            layoutParams.height = (int) getResources().getDimension(R.dimen.aliuser_btn_height);
            this.mToolbar.setLayoutParams(layoutParams);
        }
        if (needToolbar()) {
            return;
        }
        getSupportActionBar().hide();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initViews() {
    }

    public boolean isNavIconLeftBack() {
        return true;
    }

    public boolean isShowNavIcon() {
        return true;
    }

    protected boolean needToolbar() {
        if (this.activityIsTranslucent) {
            return false;
        }
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        return loginApprearanceExtensions == null || loginApprearanceExtensions.isNeedToolbar();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            onLanguageSwitchNotify();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setOrientation();
        setDefaultTheme();
        super.onCreate(bundle);
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                getWindow().getDecorView().setImportantForAutofill(8);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        onLanguageSwitchNotify();
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (loginApprearanceExtensions != null && loginApprearanceExtensions.getDialogHelper() != null) {
            try {
                this.mDialogHelper = (IDialogHelper) AliUserLogin.mAppreanceExtentions.getDialogHelper().newInstance();
            } catch (Throwable th2) {
                th2.printStackTrace();
                this.mDialogHelper = new ActivityUIHelper(this);
            }
        } else {
            this.mDialogHelper = new ActivityUIHelper(this);
        }
        if (this.isLoginObserver) {
            this.mLoginReceiver = new BroadcastReceiver() { // from class: com.ali.user.mobile.base.ui.BaseActivity.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    TLogAdapter.d(BaseActivity.TAG, "onReceive action=" + intent.getAction());
                    if (LoginResActions.LOGIN_SUCCESS_ACTION.equals(intent.getAction())) {
                        BaseActivity.this.finishWhenLoginSuccess();
                    } else if (LoginResActions.LOGIN_CLOSE_ACTION.equals(intent.getAction())) {
                        BaseActivity.this.finish();
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(LoginResActions.LOGIN_SUCCESS_ACTION);
            intentFilter.addAction(LoginResActions.LOGIN_CLOSE_ACTION);
            LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(this.mLoginReceiver, intentFilter);
        }
        setupViews();
        try {
            if (needToolbar()) {
                initToolBar();
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
        initViews();
        setListenerToRootView();
        setStatusBarMode();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mLoginReceiver != null) {
            LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(this.mLoginReceiver);
        }
    }

    protected void onLanguageSwitchNotify() {
        if (DataProviderFactory.getDataProvider() instanceof DataProvider) {
            Configuration configuration = getResources().getConfiguration();
            Locale currentLanguage = DataProviderFactory.getDataProvider().getCurrentLanguage();
            configuration.locale = currentLanguage;
            if (currentLanguage != null) {
                TLogAdapter.i(TAG, "current language = " + configuration.locale);
                getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
                DataProviderFactory.getApplicationContext().getResources().updateConfiguration(configuration, DataProviderFactory.getApplicationContext().getResources().getDisplayMetrics());
                return;
            }
            TLogAdapter.i(TAG, "current language = null");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        onLanguageSwitchNotify();
    }

    public void setContainerBackground(int i) {
        ViewGroup viewGroup = this.mViewGroup;
        if (viewGroup != null) {
            viewGroup.setBackgroundResource(i);
        }
    }

    protected void setDefaultTheme() {
        if (DataProviderFactory.getDataProvider().getLoginStyle() > 0) {
            setTheme(DataProviderFactory.getDataProvider().getLoginStyle());
        } else if (this.activityIsTranslucent) {
        } else {
            setTheme(R.C2962style.AliUserAppThemeBase);
        }
    }

    public void setListenerToRootView() {
        final View findViewById = getWindow().getDecorView().findViewById(16908290);
        findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.ali.user.mobile.base.ui.BaseActivity.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (findViewById.getRootView().getHeight() - findViewById.getHeight() > 100) {
                    BaseActivity.this.dismissProgressDialog();
                }
            }
        });
    }

    public void setNavigationBackIcon(int i) {
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            toolbar.setNavigationIcon(i);
        }
    }

    public void setNavigationCloseIcon() {
        setNavigationBackIcon(R.C2959drawable.aliuser_ic_actionbar_close);
    }

    protected void setOrientation() {
        if (this.activityIsTranslucent && Build.VERSION.SDK_INT == 26) {
            return;
        }
        if (DataProviderFactory.getDataProvider().getOrientation() == 0) {
            setRequestedOrientation(0);
            getWindow().setFlags(1024, 1024);
        } else if (DataProviderFactory.getDataProvider().getOrientation() == 1) {
            setRequestedOrientation(1);
        }
    }

    protected void setStatusBarMode() {
        try {
            LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
            if (loginApprearanceExtensions != null && !loginApprearanceExtensions.isNeedDarkStatusBarMode()) {
                LoginApprearanceExtensions loginApprearanceExtensions2 = AliUserLogin.mAppreanceExtentions;
                if (loginApprearanceExtensions2 != null && !loginApprearanceExtensions2.isNeedDarkStatusBarMode()) {
                    StatusBarHelper.setStatusBarMode(this, false);
                }
            }
            StatusBarHelper.setStatusBarMode(this, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void setupViews() {
        setContentView(R.C2960layout.aliuser_activity_container);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.aliuser_main_content);
        this.mViewGroup = viewGroup;
        if (viewGroup != null && this.activityIsTranslucent) {
            viewGroup.setBackgroundColor(0);
        }
        this.mContentView = (ViewGroup) findViewById(R.id.aliuser_content);
        this.mContentView.addView((ViewGroup) getLayoutInflater().inflate(getLayoutContent(), this.mViewGroup, false));
    }

    public void showProgress(String str) {
        IDialogHelper iDialogHelper = this.mDialogHelper;
        if (iDialogHelper != null) {
            iDialogHelper.showProgressDialog(this, str, true);
        }
    }

    public void toast(String str, int i) {
        IDialogHelper iDialogHelper = this.mDialogHelper;
        if (iDialogHelper != null) {
            iDialogHelper.toast(this, str, i);
        }
    }

    public void setNavigationBackIcon() {
        setNavigationBackIcon(R.C2959drawable.aliuser_ic_actionbar_back);
    }
}
