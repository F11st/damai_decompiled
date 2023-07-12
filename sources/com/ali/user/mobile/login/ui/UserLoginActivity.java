package com.ali.user.mobile.login.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.ali.user.mobile.app.constant.FragmentConstant;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.UIBaseConstants;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.base.ui.BaseActivity;
import com.ali.user.mobile.base.ui.BaseFragment;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;
import com.ali.user.mobile.coordinator.CoordinatorWrapper;
import com.ali.user.mobile.filter.LoginFilterCallback;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.action.LoginResActions;
import com.ali.user.mobile.login.model.AppLaunchInfo;
import com.ali.user.mobile.login.model.AppLaunchInfoResponseData;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.login.presenter.RecommendLoginPresenter;
import com.ali.user.mobile.login.service.impl.UserLoginServiceImpl;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.rpc.LoginHistory;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.safe.AES;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.FaceService;
import com.ali.user.mobile.service.FingerprintService;
import com.ali.user.mobile.service.NumberAuthService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.utils.Constants;
import com.ali.user.mobile.utils.SharedPreferencesUtil;
import com.ali.user.mobile.utils.UTConstans;
import com.ali.user.mobile.verify.VerifyApi;
import com.alibaba.fastjson.JSON;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.constants.LoginStatus;
import com.taobao.login4android.log.LoginTLogAdapter;
import com.taobao.login4android.session.SessionManager;
import com.taobao.login4android.utils.ReflectionHelper;
import com.taobao.statistic.TBS;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UserLoginActivity extends BaseActivity {
    public static final String NUMBER = "number";
    public static final String NUM_PROTOCOL_NAME = "protocolName";
    public static final String NUM_PROTOCOL_URL = "protocolURL";
    private static final String TAG = "login.UserLoginActivity";
    protected AppLaunchInfoResponseData fireAppLaunchRes;
    public boolean isFaceLoginActivate;
    public boolean isFaceLoginEnvEnable;
    private boolean isOpenMobileLoginPage;
    private boolean isOpenUserLoginPage;
    public String mBiometricToken;
    protected FragmentManager mFragmentManager;
    public HistoryAccount mHistoryAccount;
    public boolean mOpenGuide;
    protected String mSource;
    protected long startOpenTime;
    protected long startTime;
    protected String mCurrentFragmentTag = FragmentConstant.PWD_LOGIN_FRAGMENT_TAG;
    public boolean hadReadHistory = false;
    public boolean mUserOpenFaceLogin = false;
    public boolean mAlipayInstall = false;
    public boolean mShowRegTV = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public static class LoginPreCheckTask extends AsyncTask<Object, Void, LoginHistory> {
        private WeakReference<UserLoginActivity> activityReference;
        private Intent mIntent;

        LoginPreCheckTask(UserLoginActivity userLoginActivity, Intent intent) {
            this.activityReference = new WeakReference<>(userLoginActivity);
            this.mIntent = intent;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            UserLoginActivity userLoginActivity = this.activityReference.get();
            if (userLoginActivity != null) {
                userLoginActivity.isFinishing();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public LoginHistory doInBackground(Object... objArr) {
            UserLoginActivity userLoginActivity = this.activityReference.get();
            if (userLoginActivity != null && !userLoginActivity.isFinishing()) {
                r0 = DataProviderFactory.getDataProvider().getMaxHistoryAccount() > 0 ? userLoginActivity.getLoginHistory(this.mIntent) : null;
                userLoginActivity.startOpenTime = System.currentTimeMillis();
                if (r0 != null) {
                    try {
                        if (r0.accountHistory != null) {
                            userLoginActivity.checkScanFaceLoginAvailable();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                userLoginActivity.checkGuidePageAvailable();
            }
            return r0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(LoginHistory loginHistory) {
            UserLoginActivity userLoginActivity = this.activityReference.get();
            if (userLoginActivity == null || userLoginActivity.isFinishing()) {
                return;
            }
            userLoginActivity.openFragmentByIntent(this.mIntent);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public static class NewLoginPreCheckTask extends AsyncTask<Object, Void, LoginHistory> {
        private WeakReference<UserLoginActivity> activityReference;
        private Intent mIntent;

        NewLoginPreCheckTask(UserLoginActivity userLoginActivity, Intent intent) {
            this.activityReference = new WeakReference<>(userLoginActivity);
            this.mIntent = intent;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            UserLoginActivity userLoginActivity = this.activityReference.get();
            if (userLoginActivity == null || userLoginActivity.isFinishing()) {
                return;
            }
            userLoginActivity.showProgress("");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public LoginHistory doInBackground(Object... objArr) {
            List<HistoryAccount> list;
            UserLoginActivity userLoginActivity = this.activityReference.get();
            if (userLoginActivity == null || userLoginActivity.isFinishing()) {
                return null;
            }
            LoginHistory loginHistory = userLoginActivity.getLoginHistory(this.mIntent);
            userLoginActivity.startOpenTime = System.currentTimeMillis();
            try {
                Class<?> cls = Class.forName("com.taobao.login4android.activity.auth.AlipayAuth");
                userLoginActivity.mAlipayInstall = ((Boolean) ReflectionHelper.invokeMethod(cls, cls.getDeclaredMethod("isSupportAlipay", Activity.class), userLoginActivity)).booleanValue();
                if (LoginSwitch.isInABTestRegion(LoginSwitch.NEW_USER_CALL_APP_LAUNCH, 10000) && (loginHistory == null || (list = loginHistory.accountHistory) == null || list.size() == 0)) {
                    TLogAdapter.e(UserLoginActivity.TAG, "new user do not call app launch.");
                    return loginHistory;
                }
                userLoginActivity.getOpenPageStrategy(this.mIntent);
                return loginHistory;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(LoginHistory loginHistory) {
            UserLoginActivity userLoginActivity = this.activityReference.get();
            if (userLoginActivity == null || userLoginActivity.isFinishing()) {
                return;
            }
            userLoginActivity.dismissProgressDialog();
            boolean z = false;
            try {
                z = this.mIntent.getBooleanExtra(LoginConstant.FORCE_NORMAL_MODE, false);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (z || !userLoginActivity.openFragmentByAppLaunch(this.mIntent)) {
                userLoginActivity.openFragmentByIntent(this.mIntent);
            }
        }
    }

    public UserLoginActivity() {
        boolean z = true;
        if (!LoginStatus.enableSsoAlways && !DataProviderFactory.getDataProvider().getAppInfoFromServer()) {
            z = false;
        }
        this.mOpenGuide = z;
        this.isFaceLoginEnvEnable = false;
        this.isFaceLoginActivate = false;
        this.isOpenMobileLoginPage = false;
        this.isOpenUserLoginPage = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkScanFaceLoginAvailable() {
        boolean z = false;
        this.isFaceLoginActivate = false;
        this.isFaceLoginEnvEnable = false;
        if (ServiceFactory.getService(FaceService.class) != null && this.mHistoryAccount != null && this.isFaceLoginActivate) {
            z = true;
        }
        this.mUserOpenFaceLogin = z;
    }

    private boolean getAuthCheck() {
        if (!LoginSwitch.isInABTestRegion(LoginSwitch.YUNYINGSHANG_CACHE, -1) || ServiceFactory.getService(NumberAuthService.class) == null) {
            return true;
        }
        boolean checkAuth = ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).checkAuth();
        Properties properties = new Properties();
        properties.put("result", Boolean.valueOf(checkAuth));
        UserTrackAdapter.sendUT("checkAuth", properties);
        return checkAuth;
    }

    public static Intent getCallingIntent(Context context, String str, boolean z, boolean z2) {
        Class<?> userLoginActivity = AliUserLogin.mAppreanceExtentions.getUserLoginActivity();
        if (userLoginActivity == null) {
            userLoginActivity = UserLoginActivity.class;
        }
        Intent intent = new Intent(context, userLoginActivity);
        intent.putExtra(LoginConstant.LAUNCH_PASS_GUIDE_FRAGMENT, z);
        intent.putExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, str);
        intent.putExtra(LoginConstant.LAUNCH_SNS_TO_SMS_FRAGMENT, z2);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LoginHistory getLoginHistory(Intent intent) {
        String stringExtra;
        LoginParam loginParam;
        LoginHistory loginHistory;
        HistoryAccount historyAccount;
        List<HistoryAccount> list;
        if (intent != null) {
            try {
                stringExtra = intent.getStringExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (!TextUtils.isEmpty(stringExtra)) {
                loginParam = (LoginParam) JSON.parseObject(stringExtra, LoginParam.class);
                System.currentTimeMillis();
                loginHistory = SecurityGuardManagerWraper.getLoginHistory();
                this.hadReadHistory = true;
                if (loginHistory == null && (list = loginHistory.accountHistory) != null && list.size() > 0) {
                    if (loginParam != null) {
                        long j = loginParam.havanaId;
                        if (j > 0) {
                            this.mHistoryAccount = SecurityGuardManagerWraper.findHistoryAccount(j);
                        }
                    }
                    int i = loginHistory.index;
                    if (i < 0 || i >= loginHistory.accountHistory.size()) {
                        i = loginHistory.accountHistory.size() - 1;
                    }
                    this.mHistoryAccount = loginHistory.accountHistory.get(i);
                } else {
                    this.mHistoryAccount = null;
                }
                historyAccount = this.mHistoryAccount;
                if (historyAccount != null && !TextUtils.isEmpty(historyAccount.biometricId)) {
                    this.mBiometricToken = SecurityGuardManagerWraper.getFingerValue(this.mHistoryAccount.biometricId);
                }
                return loginHistory;
            }
        }
        loginParam = null;
        System.currentTimeMillis();
        loginHistory = SecurityGuardManagerWraper.getLoginHistory();
        this.hadReadHistory = true;
        if (loginHistory == null) {
        }
        this.mHistoryAccount = null;
        historyAccount = this.mHistoryAccount;
        if (historyAccount != null) {
            this.mBiometricToken = SecurityGuardManagerWraper.getFingerValue(this.mHistoryAccount.biometricId);
        }
        return loginHistory;
    }

    private void gotoGuideFragment(Intent intent, LoginApprearanceExtensions loginApprearanceExtensions) {
        try {
            addFragment(intent, (Fragment) loginApprearanceExtensions.getFullyCustomizeGuideFragment().newInstance(), FragmentConstant.GUIDE_FRAGMENT_TAG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:107:0x015b A[Catch: all -> 0x0181, TryCatch #7 {all -> 0x0181, blocks: (B:15:0x0023, B:17:0x0027, B:19:0x002d, B:21:0x0031, B:24:0x003d, B:26:0x0041, B:28:0x0045, B:30:0x0049, B:61:0x00bc, B:65:0x00c6, B:67:0x00cc, B:70:0x00d4, B:72:0x00da, B:75:0x00e0, B:77:0x00e4, B:93:0x0113, B:95:0x0136, B:97:0x0140, B:103:0x014c, B:105:0x0152, B:107:0x015b, B:109:0x0161, B:110:0x0165, B:113:0x016f, B:115:0x0173, B:117:0x0179, B:118:0x017d, B:80:0x00f0, B:82:0x00f4, B:84:0x00f8, B:86:0x00fe, B:88:0x0102, B:90:0x010c, B:14:0x001f, B:57:0x00b1, B:33:0x0059, B:35:0x005f, B:37:0x0065, B:39:0x0071, B:41:0x0075, B:43:0x007d, B:45:0x0088, B:47:0x0090, B:49:0x0096), top: B:125:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x016d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0027 A[Catch: all -> 0x0181, TryCatch #7 {all -> 0x0181, blocks: (B:15:0x0023, B:17:0x0027, B:19:0x002d, B:21:0x0031, B:24:0x003d, B:26:0x0041, B:28:0x0045, B:30:0x0049, B:61:0x00bc, B:65:0x00c6, B:67:0x00cc, B:70:0x00d4, B:72:0x00da, B:75:0x00e0, B:77:0x00e4, B:93:0x0113, B:95:0x0136, B:97:0x0140, B:103:0x014c, B:105:0x0152, B:107:0x015b, B:109:0x0161, B:110:0x0165, B:113:0x016f, B:115:0x0173, B:117:0x0179, B:118:0x017d, B:80:0x00f0, B:82:0x00f4, B:84:0x00f8, B:86:0x00fe, B:88:0x0102, B:90:0x010c, B:14:0x001f, B:57:0x00b1, B:33:0x0059, B:35:0x005f, B:37:0x0065, B:39:0x0071, B:41:0x0075, B:43:0x007d, B:45:0x0088, B:47:0x0090, B:49:0x0096), top: B:125:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0059 A[Catch: all -> 0x009a, TRY_ENTER, TryCatch #7 {all -> 0x0181, blocks: (B:15:0x0023, B:17:0x0027, B:19:0x002d, B:21:0x0031, B:24:0x003d, B:26:0x0041, B:28:0x0045, B:30:0x0049, B:61:0x00bc, B:65:0x00c6, B:67:0x00cc, B:70:0x00d4, B:72:0x00da, B:75:0x00e0, B:77:0x00e4, B:93:0x0113, B:95:0x0136, B:97:0x0140, B:103:0x014c, B:105:0x0152, B:107:0x015b, B:109:0x0161, B:110:0x0165, B:113:0x016f, B:115:0x0173, B:117:0x0179, B:118:0x017d, B:80:0x00f0, B:82:0x00f4, B:84:0x00f8, B:86:0x00fe, B:88:0x0102, B:90:0x010c, B:14:0x001f, B:57:0x00b1, B:33:0x0059, B:35:0x005f, B:37:0x0065, B:39:0x0071, B:41:0x0075, B:43:0x007d, B:45:0x0088, B:47:0x0090, B:49:0x0096), top: B:125:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e0 A[Catch: all -> 0x0181, TryCatch #7 {all -> 0x0181, blocks: (B:15:0x0023, B:17:0x0027, B:19:0x002d, B:21:0x0031, B:24:0x003d, B:26:0x0041, B:28:0x0045, B:30:0x0049, B:61:0x00bc, B:65:0x00c6, B:67:0x00cc, B:70:0x00d4, B:72:0x00da, B:75:0x00e0, B:77:0x00e4, B:93:0x0113, B:95:0x0136, B:97:0x0140, B:103:0x014c, B:105:0x0152, B:107:0x015b, B:109:0x0161, B:110:0x0165, B:113:0x016f, B:115:0x0173, B:117:0x0179, B:118:0x017d, B:80:0x00f0, B:82:0x00f4, B:84:0x00f8, B:86:0x00fe, B:88:0x0102, B:90:0x010c, B:14:0x001f, B:57:0x00b1, B:33:0x0059, B:35:0x005f, B:37:0x0065, B:39:0x0071, B:41:0x0075, B:43:0x007d, B:45:0x0088, B:47:0x0090, B:49:0x0096), top: B:125:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f0 A[Catch: all -> 0x0181, TryCatch #7 {all -> 0x0181, blocks: (B:15:0x0023, B:17:0x0027, B:19:0x002d, B:21:0x0031, B:24:0x003d, B:26:0x0041, B:28:0x0045, B:30:0x0049, B:61:0x00bc, B:65:0x00c6, B:67:0x00cc, B:70:0x00d4, B:72:0x00da, B:75:0x00e0, B:77:0x00e4, B:93:0x0113, B:95:0x0136, B:97:0x0140, B:103:0x014c, B:105:0x0152, B:107:0x015b, B:109:0x0161, B:110:0x0165, B:113:0x016f, B:115:0x0173, B:117:0x0179, B:118:0x017d, B:80:0x00f0, B:82:0x00f4, B:84:0x00f8, B:86:0x00fe, B:88:0x0102, B:90:0x010c, B:14:0x001f, B:57:0x00b1, B:33:0x0059, B:35:0x005f, B:37:0x0065, B:39:0x0071, B:41:0x0075, B:43:0x007d, B:45:0x0088, B:47:0x0090, B:49:0x0096), top: B:125:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010c A[Catch: all -> 0x0181, TryCatch #7 {all -> 0x0181, blocks: (B:15:0x0023, B:17:0x0027, B:19:0x002d, B:21:0x0031, B:24:0x003d, B:26:0x0041, B:28:0x0045, B:30:0x0049, B:61:0x00bc, B:65:0x00c6, B:67:0x00cc, B:70:0x00d4, B:72:0x00da, B:75:0x00e0, B:77:0x00e4, B:93:0x0113, B:95:0x0136, B:97:0x0140, B:103:0x014c, B:105:0x0152, B:107:0x015b, B:109:0x0161, B:110:0x0165, B:113:0x016f, B:115:0x0173, B:117:0x0179, B:118:0x017d, B:80:0x00f0, B:82:0x00f4, B:84:0x00f8, B:86:0x00fe, B:88:0x0102, B:90:0x010c, B:14:0x001f, B:57:0x00b1, B:33:0x0059, B:35:0x005f, B:37:0x0065, B:39:0x0071, B:41:0x0075, B:43:0x007d, B:45:0x0088, B:47:0x0090, B:49:0x0096), top: B:125:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0136 A[Catch: all -> 0x0181, TryCatch #7 {all -> 0x0181, blocks: (B:15:0x0023, B:17:0x0027, B:19:0x002d, B:21:0x0031, B:24:0x003d, B:26:0x0041, B:28:0x0045, B:30:0x0049, B:61:0x00bc, B:65:0x00c6, B:67:0x00cc, B:70:0x00d4, B:72:0x00da, B:75:0x00e0, B:77:0x00e4, B:93:0x0113, B:95:0x0136, B:97:0x0140, B:103:0x014c, B:105:0x0152, B:107:0x015b, B:109:0x0161, B:110:0x0165, B:113:0x016f, B:115:0x0173, B:117:0x0179, B:118:0x017d, B:80:0x00f0, B:82:0x00f4, B:84:0x00f8, B:86:0x00fe, B:88:0x0102, B:90:0x010c, B:14:0x001f, B:57:0x00b1, B:33:0x0059, B:35:0x005f, B:37:0x0065, B:39:0x0071, B:41:0x0075, B:43:0x007d, B:45:0x0088, B:47:0x0090, B:49:0x0096), top: B:125:0x001f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void openFragmentByIntent(android.content.Intent r13) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.user.mobile.login.ui.UserLoginActivity.openFragmentByIntent(android.content.Intent):void");
    }

    private void sendCancelBroadcast() {
        BroadCastHelper.sendLocalBroadCast(new Intent(Constants.RESET_LOGIN_STATUS));
    }

    public void addFragment(Intent intent, Fragment fragment, String str) {
        hideAllFragment();
        Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(str);
        if (findFragmentByTag != null) {
            this.mFragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
        }
        this.mFragmentManager.beginTransaction().add(R.id.aliuser_content_frame, fragment, str).commitAllowingStateLoss();
        this.mFragmentManager.beginTransaction().show(fragment).commitAllowingStateLoss();
        this.mCurrentFragmentTag = str;
    }

    protected void cacheData(String str) {
        SharedPreferences sharedPreferences = DataProviderFactory.getApplicationContext().getSharedPreferences(str, 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("data", JSON.toJSONString(this.fireAppLaunchRes));
            edit.putLong("expire_time", (System.currentTimeMillis() / 1000) + ((AppLaunchInfo) this.fireAppLaunchRes.returnValue).expireTime);
            edit.apply();
        }
    }

    protected boolean cacheOneKeyAndCompareSuccess(Intent intent) {
        Map<String, String> authInfoMap;
        String str = "";
        if (intent != null) {
            try {
                str = intent.getStringExtra("number");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            authInfoMap = ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getAuthInfoMap();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if (authInfoMap != null && authInfoMap.size() != 0) {
            String str2 = authInfoMap.get("number");
            if (!TextUtils.isEmpty(str2) && str2.length() > 7) {
                String substring = str2.substring(str2.lastIndexOf(jn1.MUL) + 1);
                if (!TextUtils.isEmpty(this.mHistoryAccount.loginPhone)) {
                    if (this.mHistoryAccount.loginPhone.endsWith(substring)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    protected void callPageDisAppear() {
        UserTrackAdapter.pageDisAppear(this);
    }

    protected void checkGuidePageAvailable() {
        T t;
        try {
            if (DataProviderFactory.getDataProvider().getAppInfoFromServer() && LoginStatus.askServerForGuide) {
                RpcResponse appLaunchInfo = UserLoginServiceImpl.getInstance().getAppLaunchInfo(new LoginParam());
                if (appLaunchInfo != null && (t = appLaunchInfo.returnValue) != 0) {
                    this.mOpenGuide = ((AppLaunchInfo) t).fromOversea;
                    DataProviderFactory.getDataProvider().setAppInfoFromServer(this.mOpenGuide);
                    LoginStatus.askServerForGuide = false;
                } else {
                    this.mOpenGuide = false;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            this.mOpenGuide = false;
        }
    }

    protected boolean compareSuccess(Intent intent, AppLaunchInfo appLaunchInfo) {
        List<String> list;
        String str = "";
        if (intent != null) {
            try {
                str = intent.getStringExtra("number");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str) && getAuthCheck() && ServiceFactory.getService(NumberAuthService.class) != null) {
            Map<String, String> authInfoMap = ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getAuthInfoMap();
            if (authInfoMap != null && authInfoMap.containsKey("number")) {
                String str2 = authInfoMap.get("number");
                if (appLaunchInfo == null || (list = appLaunchInfo.deviceMaskMobiles) == null || list.size() == 0 || appLaunchInfo.deviceMaskMobiles.contains(str2)) {
                    return true;
                }
                UserTrackAdapter.sendUT(UTConstans.CustomEvent.UT_SIM_NOT_IN_COMPARE_LIST);
                return false;
            }
            UserTrackAdapter.sendUT(UTConstans.CustomEvent.UT_SIM_NO_CACHE);
        }
        return false;
    }

    public void doFinishThing() {
        BroadCastHelper.sendLocalBroadCast(new Intent(LoginResActions.LOGIN_CANCEL_ACTION));
        try {
            if (isFinishing()) {
                return;
            }
            UserTrackAdapter.sendUT(getPageName(), "handle_login_close_page");
            finish();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (loginApprearanceExtensions == null || loginApprearanceExtensions.getActivityExitAnimation() <= 0) {
            return;
        }
        overridePendingTransition(0, AliUserLogin.mAppreanceExtentions.getActivityExitAnimation());
    }

    public void finishCurrentAndNotify() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null && !fragmentManager.isDestroyed()) {
            if (this.supportTaobaoOrAlipay && !TextUtils.equals(this.mCurrentFragmentTag, FragmentConstant.GUIDE_FRAGMENT_TAG) && this.mOpenGuide) {
                gotoGuideFragment(null, AliUserLogin.mAppreanceExtentions);
                return;
            }
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(this.mCurrentFragmentTag);
            if ((findFragmentByTag instanceof BaseFragment) && ((BaseFragment) findFragmentByTag).onBackPressed()) {
                return;
            }
        }
        doFinishThing();
    }

    @Override // com.ali.user.mobile.base.ui.BaseActivity
    protected void finishWhenLoginSuccess() {
        if (AliUserLogin.getLoginFilter(SessionManager.getInstance(getApplicationContext()).getLoginSite()) != null) {
            AliUserLogin.getLoginFilter(SessionManager.getInstance(getApplicationContext()).getLoginSite()).onLoginSuccess(this, new LoginFilterCallback() { // from class: com.ali.user.mobile.login.ui.UserLoginActivity.1
                @Override // com.ali.user.mobile.filter.LoginFilterCallback
                public void onFail(int i, Map<String, String> map) {
                    UserLoginActivity.this.runOnUiThread(new Runnable() { // from class: com.ali.user.mobile.login.ui.UserLoginActivity.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            UserLoginActivity.this.finish();
                        }
                    });
                }

                @Override // com.ali.user.mobile.filter.LoginFilterCallback
                public void onSuccess() {
                    UserLoginActivity.this.runOnUiThread(new Runnable() { // from class: com.ali.user.mobile.login.ui.UserLoginActivity.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            UserLoginActivity.this.finish();
                        }
                    });
                }
            });
        } else {
            finish();
        }
    }

    protected void fragmentOnActivityResult(int i, int i2, Intent intent) {
        Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(this.mCurrentFragmentTag);
        if (findFragmentByTag == null || !findFragmentByTag.isVisible()) {
            return;
        }
        findFragmentByTag.onActivityResult(i, i2, intent);
    }

    protected Class<?> getAlipayFragment() {
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (loginApprearanceExtensions == null) {
            return null;
        }
        return loginApprearanceExtensions.getFullyCustomizedAlipayLoginFragment();
    }

    protected Class<?> getAlipayHistoryFragment() {
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (loginApprearanceExtensions == null) {
            return null;
        }
        return loginApprearanceExtensions.getFullyCustomizedAlipayHistoryFragment();
    }

    protected Class<?> getFaceLoginFragment(LoginApprearanceExtensions loginApprearanceExtensions) {
        return loginApprearanceExtensions.getFullyCustomizedFaceLoginFragment();
    }

    protected Class<?> getFingerFragment() {
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (loginApprearanceExtensions == null) {
            return null;
        }
        return loginApprearanceExtensions.getFingerFragment();
    }

    @Override // com.ali.user.mobile.base.ui.BaseActivity
    protected int getLayoutContent() {
        return R.layout.aliuser_activity_frame_content;
    }

    protected Fragment getMobileFragment(LoginApprearanceExtensions loginApprearanceExtensions) throws IllegalAccessException, InstantiationException {
        if (loginApprearanceExtensions != null && loginApprearanceExtensions.getFullyCustomizeMobileLoginFragment() != null) {
            return (AliUserMobileLoginFragment) loginApprearanceExtensions.getFullyCustomizeMobileLoginFragment().newInstance();
        }
        return new AliUserMobileLoginFragment();
    }

    protected Class<?> getOneKeyLoginFragment(LoginApprearanceExtensions loginApprearanceExtensions) {
        return loginApprearanceExtensions.getFullyCustomizedOneKeyLoginFragment();
    }

    protected void getOpenPageStrategy(Intent intent) {
        String str;
        if (this.mHistoryAccount != null) {
            str = LoginConstant.FILE_NAME_HISTORY;
        } else {
            str = LoginConstant.FILE_NAME;
        }
        readHistoryCache(str);
        if (this.fireAppLaunchRes == null && LoginSwitch.getSwitch(LoginSwitch.FIRE_APP_LAUNCH, "true")) {
            try {
                this.fireAppLaunchRes = RecommendLoginPresenter.fireAppLaunchRequest(new LoginParam(), this.mHistoryAccount);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            AppLaunchInfoResponseData appLaunchInfoResponseData = this.fireAppLaunchRes;
            if (appLaunchInfoResponseData == null || appLaunchInfoResponseData.returnValue == 0) {
                return;
            }
            cacheData(str);
        }
    }

    protected String getPageName() {
        return "login";
    }

    protected Properties getProperty(Intent intent) {
        Properties properties = new Properties();
        if (intent != null && !TextUtils.isEmpty(intent.getStringExtra("scene"))) {
            properties.put("pn_scene", intent.getStringExtra("scene"));
        }
        return properties;
    }

    protected Fragment getSMSVerificationFragment() throws IllegalAccessException, InstantiationException {
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (loginApprearanceExtensions != null && loginApprearanceExtensions.getFullyCustomizedLoginSmsCodeFragment() != null) {
            return (Fragment) loginApprearanceExtensions.getFullyCustomizedLoginSmsCodeFragment().newInstance();
        }
        return new AliUserSMSLoginVerificationFragment();
    }

    protected Fragment getTwoStepMobileFragment(LoginApprearanceExtensions loginApprearanceExtensions) throws IllegalAccessException, InstantiationException {
        if (loginApprearanceExtensions != null && loginApprearanceExtensions.getFullyCustomizeTwoStepMobileLoginFragment() != null) {
            return (Fragment) loginApprearanceExtensions.getFullyCustomizeTwoStepMobileLoginFragment().newInstance();
        }
        return new AliUserTwoStepMobileLoginFragment();
    }

    protected Fragment getUserLoginFragment() throws IllegalAccessException, InstantiationException {
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (loginApprearanceExtensions != null && loginApprearanceExtensions.getFullyCustomizeLoginFragment() != null) {
            return (AliUserLoginFragment) loginApprearanceExtensions.getFullyCustomizeLoginFragment().newInstance();
        }
        return new AliUserLoginFragment();
    }

    protected void goAlipayFragment(Intent intent) {
        try {
            Fragment fragment = (Fragment) getAlipayFragment().newInstance();
            if (intent != null) {
                fragment.setArguments(intent.getExtras());
            }
            addFragment(intent, fragment, FragmentConstant.ALIPAY_FRAGMENT_TAG);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected void goAlipayHistory(Intent intent) {
        try {
            Fragment fragment = (Fragment) getAlipayHistoryFragment().newInstance();
            if (intent != null) {
                fragment.setArguments(intent.getExtras());
            }
            addFragment(intent, fragment, FragmentConstant.ALIPAY_HISTORY_FRAGMENT_TAG);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected void goFaceFragment(Intent intent) {
        try {
            Fragment fragment = (Fragment) getFaceLoginFragment(AliUserLogin.mAppreanceExtentions).newInstance();
            if (intent != null) {
                fragment.setArguments(intent.getExtras());
            }
            addFragment(intent, fragment, FragmentConstant.FACE_LOGIN_FRAGMENT_TAG);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected boolean goFragmentByType(String str, Intent intent, AppLaunchInfo appLaunchInfo) {
        boolean z;
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        try {
            z = intent.getBooleanExtra(LoginConstant.FORCE_NORMAL_MODE, false);
        } catch (Throwable th) {
            th.printStackTrace();
            z = false;
        }
        if (z && switchToRecommendLogin(intent)) {
            return true;
        }
        Properties property = getProperty(intent);
        if (this.mHistoryAccount != null) {
            try {
                if ("biometric".equals(str) && getFingerFragment() != null && ServiceFactory.getService(FingerprintService.class) != null && ((FingerprintService) ServiceFactory.getService(FingerprintService.class)).isFingerprintAvailable() && new AES().checkValid()) {
                    if (TextUtils.isEmpty(this.mBiometricToken)) {
                        UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "EmptyBiometricToken");
                    }
                    HistoryAccount historyAccount = this.mHistoryAccount;
                    if (historyAccount != null && !TextUtils.isEmpty(historyAccount.biometricId)) {
                        if (!TextUtils.isEmpty(this.mBiometricToken) && getFingerFragment() != null) {
                            gotoFingerPage(intent);
                            return true;
                        }
                    } else {
                        UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "EmptyBiometricId");
                    }
                }
            } catch (Throwable th2) {
                try {
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "CheckValidException", th2.getMessage(), null);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                th2.printStackTrace();
                this.mBiometricToken = "";
                VerifyApi.invalidAll();
            }
            if ("sim".equals(str)) {
                UserTrackAdapter.sendUT(UTConstans.CustomEvent.UT_RECOMMEND_HISTORY_SIM, property);
                if (cacheOneKeyAndCompareSuccess(intent)) {
                    UserTrackAdapter.sendUT(UTConstans.CustomEvent.UT_RECOMMEND_HISTORY_OPEN, property);
                    gotoHistorySmsLoginPage(intent);
                    return true;
                }
            }
            if ("alipay".equals(str) && getAlipayHistoryFragment() != null && this.mAlipayInstall) {
                goAlipayHistory(intent);
                return true;
            } else if (BaseCellItem.TYPE_FACE.equals(str) && this.mUserOpenFaceLogin && DataProviderFactory.getDataProvider().supportFaceLogin() && !z) {
                goFaceFragment(intent);
                return true;
            } else if ("pwd".equals(str) && DataProviderFactory.getDataProvider().supportPwdLogin() && this.mHistoryAccount.hasPwd == 1) {
                gotoPwdLoginFragment(intent);
                return true;
            } else if ("sms".equals(str) && DataProviderFactory.getDataProvider().supportMobileLogin() && !TextUtils.isEmpty(this.mHistoryAccount.loginPhone)) {
                gotoMobileLoginFragment(intent);
                return true;
            }
        } else {
            if ("sim".equals(str)) {
                UserTrackAdapter.sendUT(UTConstans.CustomEvent.UT_RECOMMEND_SIM, property);
                if (loginApprearanceExtensions != null && getOneKeyLoginFragment(loginApprearanceExtensions) != null && compareSuccess(intent, appLaunchInfo)) {
                    UserTrackAdapter.sendUT(UTConstans.CustomEvent.UT_RECOMMEND_SIM_OPEN, property);
                    gotoOneKeyLoginFragment(intent);
                    return true;
                }
            }
            if ("alipay".equals(str) && getAlipayFragment() != null && this.mAlipayInstall) {
                goAlipayFragment(intent);
                return true;
            } else if ("recommend".equals(str)) {
                switchToRecommendLogin(intent);
                return true;
            }
        }
        return false;
    }

    public void goPwdOrSMSFragment(Intent intent) {
        TLogAdapter.d(TAG, "goPwdOrSMSFragment() called with: intent = [" + intent + jn1.ARRAY_END_STR);
        String str = (String) SharedPreferencesUtil.getData(getApplicationContext(), "login_type", "");
        if (DataProviderFactory.getDataProvider().isShowHistoryFragment() && this.mHistoryAccount != null) {
            if (this.isOpenMobileLoginPage && DataProviderFactory.getDataProvider().supportMobileLogin()) {
                if (TextUtils.isEmpty(this.mHistoryAccount.loginPhone)) {
                    intent.putExtra(LoginConstant.FORCE_NORMAL_MODE, true);
                }
                gotoHistorySmsLoginPage(intent);
            } else if ((this.isOpenUserLoginPage || DataProviderFactory.getDataProvider().alwaysPwdLoginPriority()) && DataProviderFactory.getDataProvider().supportPwdLogin()) {
                if (this.mHistoryAccount.hasPwd != 1) {
                    intent.putExtra(LoginConstant.FORCE_NORMAL_MODE, true);
                }
                gotoPwdLoginFragment(intent);
            } else if (DataProviderFactory.getDataProvider().alwaysSMSLoginPriority() && DataProviderFactory.getDataProvider().supportMobileLogin()) {
                if (TextUtils.isEmpty(this.mHistoryAccount.loginPhone)) {
                    intent.putExtra(LoginConstant.FORCE_NORMAL_MODE, true);
                }
                gotoMobileLoginFragment(intent);
            } else if (TextUtils.equals(this.mHistoryAccount.loginType, LoginType.ServerLoginType.SMSLogin.getType()) && DataProviderFactory.getDataProvider().supportMobileLogin()) {
                if (TextUtils.isEmpty(this.mHistoryAccount.loginPhone)) {
                    intent.putExtra(LoginConstant.FORCE_NORMAL_MODE, true);
                }
                gotoHistorySmsLoginPage(intent);
            } else if (TextUtils.equals(this.mHistoryAccount.loginType, LoginType.ServerLoginType.PasswordLogin.getType()) && DataProviderFactory.getDataProvider().supportPwdLogin()) {
                if (this.mHistoryAccount.hasPwd != 1) {
                    intent.putExtra(LoginConstant.FORCE_NORMAL_MODE, true);
                }
                gotoPwdLoginFragment(intent);
            } else if (DataProviderFactory.getDataProvider().isSmsLoginPriority() && !TextUtils.isEmpty(this.mHistoryAccount.loginPhone) && DataProviderFactory.getDataProvider().supportMobileLogin()) {
                gotoMobileLoginFragment(intent);
            } else if ((this.mHistoryAccount.hasPwd == 0 && DataProviderFactory.getDataProvider().supportMobileLogin()) || (DataProviderFactory.getDataProvider().supportMobileLogin() && !DataProviderFactory.getDataProvider().supportPwdLogin())) {
                if (TextUtils.isEmpty(this.mHistoryAccount.loginPhone)) {
                    intent.putExtra(LoginConstant.FORCE_NORMAL_MODE, true);
                }
                gotoMobileLoginFragment(intent);
            } else {
                if (this.mHistoryAccount.hasPwd != 1) {
                    intent.putExtra(LoginConstant.FORCE_NORMAL_MODE, true);
                }
                gotoPwdLoginFragment(intent);
            }
        } else if (this.isOpenMobileLoginPage && DataProviderFactory.getDataProvider().supportMobileLogin()) {
            gotoMobileLoginFragment(intent);
        } else if (this.isOpenUserLoginPage && DataProviderFactory.getDataProvider().supportPwdLogin()) {
            gotoPwdLoginFragment(intent);
        } else if (DataProviderFactory.getDataProvider().alwaysPwdLoginPriority() && DataProviderFactory.getDataProvider().supportPwdLogin()) {
            gotoPwdLoginFragment(intent);
        } else if (DataProviderFactory.getDataProvider().alwaysSMSLoginPriority() && DataProviderFactory.getDataProvider().supportMobileLogin()) {
            gotoMobileLoginFragment(intent);
        } else if (TextUtils.equals(str, LoginType.ServerLoginType.PasswordLogin.getType()) && DataProviderFactory.getDataProvider().supportPwdLogin()) {
            gotoPwdLoginFragment(intent);
        } else if (TextUtils.equals(str, LoginType.ServerLoginType.SMSLogin.getType()) && DataProviderFactory.getDataProvider().supportMobileLogin()) {
            gotoMobileLoginFragment(intent);
        } else if (DataProviderFactory.getDataProvider().isSmsLoginPriority() && DataProviderFactory.getDataProvider().supportMobileLogin()) {
            gotoMobileLoginFragment(intent);
        } else if (!TextUtils.isEmpty(SessionManager.getInstance(getApplicationContext()).getOldUserId()) && DataProviderFactory.getDataProvider().supportPwdLogin()) {
            gotoPwdLoginFragment(intent);
        } else if (DataProviderFactory.getDataProvider().isSmsLoginPriority() && DataProviderFactory.getDataProvider().supportMobileLogin()) {
            gotoMobileLoginFragment(intent);
        } else {
            gotoPwdLoginFragment(intent);
        }
    }

    public void goToSMSVerificationPage(Intent intent) {
        try {
            Fragment sMSVerificationFragment = getSMSVerificationFragment();
            sMSVerificationFragment.setArguments(intent.getExtras());
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(FragmentConstant.LOGIN_SMSCODE_FRAGMENT_TAG);
            if (findFragmentByTag != null) {
                this.mFragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
            }
            this.mCurrentFragmentTag = FragmentConstant.LOGIN_SMSCODE_FRAGMENT_TAG;
            this.mFragmentManager.beginTransaction().replace(R.id.aliuser_content_frame, sMSVerificationFragment, FragmentConstant.LOGIN_SMSCODE_FRAGMENT_TAG).addToBackStack(null).commitAllowingStateLoss();
            this.mFragmentManager.beginTransaction().show(sMSVerificationFragment).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Fragment gotoAuthCheckFragmentFromGuide(Intent intent) {
        Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(FragmentConstant.GUIDE_FRAGMENT_TAG);
        if (findFragmentByTag != null && findFragmentByTag.isVisible()) {
            this.mFragmentManager.beginTransaction().hide(findFragmentByTag).commitAllowingStateLoss();
        }
        gotoCheckAuthFragment(intent);
        this.mFragmentManager.executePendingTransactions();
        return this.mFragmentManager.findFragmentByTag(FragmentConstant.PWD_AUTH_WITH_FIXED_NICK);
    }

    public void gotoCheckAuthFragment(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM);
            Fragment fragment = null;
            LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
            if (loginApprearanceExtensions != null && loginApprearanceExtensions.getFullyCustomizedAuthCheckFragment() != null) {
                fragment = (Fragment) loginApprearanceExtensions.getFullyCustomizedAuthFragment().newInstance();
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(stringExtra)) {
                bundle.putString(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, stringExtra);
            }
            if (fragment != null) {
                fragment.setArguments(bundle);
                addFragment(intent, fragment, FragmentConstant.PWD_AUTH_WITH_FIXED_NICK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gotoFastRegOrLoginBind(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM);
            Fragment fragment = null;
            LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
            if (loginApprearanceExtensions != null && loginApprearanceExtensions.getFullyCustomizedAuthCheckFragment() != null) {
                fragment = (Fragment) loginApprearanceExtensions.getFullyCustomizedSNSChooseFragment().newInstance();
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(stringExtra)) {
                bundle.putString(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, stringExtra);
            }
            if (fragment != null) {
                fragment.setArguments(bundle);
                addFragment(intent, fragment, FragmentConstant.SNS_FAST_REG_OR_LOGIN_BIND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void gotoFingerPage(Intent intent) {
        try {
            Fragment fragment = (Fragment) getFingerFragment().newInstance();
            if (intent != null) {
                fragment.setArguments(intent.getExtras());
            }
            addFragment(intent, fragment, FragmentConstant.FINGER_FRAGMENT);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void gotoHistorySmsLoginPage(Intent intent) {
        LoginApprearanceExtensions loginApprearanceExtensions;
        try {
            if (LoginSwitch.isInABTestRegion(LoginSwitch.ONEKEY_LOGIN_HISTORY_PERCENT, 10000) && (loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions) != null && loginApprearanceExtensions.getFullyCustomizedOneKeyLoginHistoryFragment() != null && ServiceFactory.getService(NumberAuthService.class) != null && !TextUtils.isEmpty(this.mHistoryAccount.loginPhone)) {
                String str = ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getAuthInfoMap().get("number");
                if (!TextUtils.isEmpty(str) && str.length() > 7) {
                    if (this.mHistoryAccount.loginPhone.endsWith(str.substring(str.lastIndexOf(jn1.MUL) + 1))) {
                        Fragment fragment = (Fragment) loginApprearanceExtensions.getFullyCustomizedOneKeyLoginHistoryFragment().newInstance();
                        fragment.setArguments(intent.getExtras());
                        UserTrackAdapter.sendUT("history_sim", getProperty(intent));
                        addFragment(intent, fragment, FragmentConstant.ONE_KEY_LOGIN_HISTORY_FRAGMENT_TAG);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        gotoMobileLoginFragment(intent);
    }

    public AliUserLoginFragment gotoLoginFragmentFromGuide(Intent intent) {
        Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(FragmentConstant.GUIDE_FRAGMENT_TAG);
        if (findFragmentByTag != null && findFragmentByTag.isVisible()) {
            this.mFragmentManager.beginTransaction().hide(findFragmentByTag).commitAllowingStateLoss();
        }
        gotoPwdLoginFragment(intent);
        this.mFragmentManager.executePendingTransactions();
        Fragment findFragmentByTag2 = this.mFragmentManager.findFragmentByTag("aliuser_login");
        if (findFragmentByTag2 instanceof AliUserLoginFragment) {
            return (AliUserLoginFragment) findFragmentByTag2;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004c A[Catch: Exception -> 0x00c7, TryCatch #1 {Exception -> 0x00c7, blocks: (B:24:0x004c, B:31:0x0061, B:33:0x006d, B:35:0x0076, B:37:0x007f, B:42:0x008f, B:44:0x0093, B:48:0x009f, B:50:0x00b1, B:51:0x00be, B:34:0x0072, B:26:0x0050, B:28:0x005a, B:22:0x0044), top: B:58:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b1 A[Catch: Exception -> 0x00c7, TryCatch #1 {Exception -> 0x00c7, blocks: (B:24:0x004c, B:31:0x0061, B:33:0x006d, B:35:0x0076, B:37:0x007f, B:42:0x008f, B:44:0x0093, B:48:0x009f, B:50:0x00b1, B:51:0x00be, B:34:0x0072, B:26:0x0050, B:28:0x005a, B:22:0x0044), top: B:58:0x0044 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void gotoMobileLoginFragment(android.content.Intent r20) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            java.lang.String r3 = "check"
            java.lang.String r4 = "autoSendSms"
            java.lang.String r5 = "ut_from_register"
            java.lang.String r6 = "PARAM_LOGIN_PARAM"
            java.lang.String r7 = "account"
            java.lang.String r8 = "forceNormalMode"
            java.lang.String r9 = ""
            r10 = 0
            boolean r11 = r2.getBooleanExtra(r8, r10)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r12 = r2.getStringExtra(r7)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r9 = r2.getStringExtra(r6)     // Catch: java.lang.Throwable -> L30
            boolean r13 = r2.getBooleanExtra(r5, r10)     // Catch: java.lang.Throwable -> L30
            boolean r14 = r2.getBooleanExtra(r4, r10)     // Catch: java.lang.Throwable -> L2e
            boolean r0 = r2.getBooleanExtra(r3, r10)     // Catch: java.lang.Throwable -> L2c
            goto L4a
        L2c:
            r0 = move-exception
            goto L33
        L2e:
            r0 = move-exception
            goto L32
        L30:
            r0 = move-exception
            r13 = 0
        L32:
            r14 = 0
        L33:
            r18 = r12
            r12 = r0
            r0 = r9
            r9 = r18
            goto L44
        L3a:
            r0 = move-exception
            r12 = r0
            r0 = r9
            goto L42
        L3e:
            r0 = move-exception
            r12 = r0
            r0 = r9
            r11 = 0
        L42:
            r13 = 0
            r14 = 0
        L44:
            r12.printStackTrace()     // Catch: java.lang.Exception -> Lc7
            r12 = r9
            r9 = r0
            r0 = 0
        L4a:
            if (r11 != 0) goto L50
            com.ali.user.mobile.rpc.HistoryAccount r15 = r1.mHistoryAccount     // Catch: java.lang.Exception -> Lc7
            if (r15 != 0) goto L61
        L50:
            com.ali.user.mobile.app.dataprovider.IDataProvider r15 = com.ali.user.mobile.app.dataprovider.DataProviderFactory.getDataProvider()     // Catch: java.lang.Exception -> Lc7
            boolean r15 = r15.supportRecommendLogin()     // Catch: java.lang.Exception -> Lc7
            if (r15 == 0) goto L61
            boolean r15 = r19.switchToRecommendLogin(r20)     // Catch: java.lang.Exception -> Lc7
            if (r15 == 0) goto L61
            return
        L61:
            com.ali.user.mobile.common.api.LoginApprearanceExtensions r15 = com.ali.user.mobile.common.api.AliUserLogin.mAppreanceExtentions     // Catch: java.lang.Exception -> Lc7
            com.ali.user.mobile.app.dataprovider.IDataProvider r16 = com.ali.user.mobile.app.dataprovider.DataProviderFactory.getDataProvider()     // Catch: java.lang.Exception -> Lc7
            boolean r16 = r16.supportTwoStepMobileLogin()     // Catch: java.lang.Exception -> Lc7
            if (r16 == 0) goto L72
            androidx.fragment.app.Fragment r15 = r1.getTwoStepMobileFragment(r15)     // Catch: java.lang.Exception -> Lc7
            goto L76
        L72:
            androidx.fragment.app.Fragment r15 = r1.getMobileFragment(r15)     // Catch: java.lang.Exception -> Lc7
        L76:
            android.os.Bundle r10 = new android.os.Bundle     // Catch: java.lang.Exception -> Lc7
            r10.<init>()     // Catch: java.lang.Exception -> Lc7
            r17 = 1
            if (r11 != 0) goto L8d
            com.ali.user.mobile.app.dataprovider.IDataProvider r11 = com.ali.user.mobile.app.dataprovider.DataProviderFactory.getDataProvider()     // Catch: java.lang.Exception -> Lc7
            boolean r11 = r11.isShowHistoryFragment()     // Catch: java.lang.Exception -> Lc7
            if (r11 != 0) goto L8a
            goto L8d
        L8a:
            r16 = 0
            goto L8f
        L8d:
            r16 = 1
        L8f:
            com.ali.user.mobile.rpc.HistoryAccount r11 = r1.mHistoryAccount     // Catch: java.lang.Exception -> Lc7
            if (r11 == 0) goto L9d
            java.lang.String r11 = r11.loginPhone     // Catch: java.lang.Exception -> Lc7
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Exception -> Lc7
            if (r11 == 0) goto L9d
            r11 = 1
            goto L9f
        L9d:
            r11 = r16
        L9f:
            r10.putBoolean(r3, r0)     // Catch: java.lang.Exception -> Lc7
            r10.putBoolean(r8, r11)     // Catch: java.lang.Exception -> Lc7
            r10.putString(r7, r12)     // Catch: java.lang.Exception -> Lc7
            r10.putBoolean(r4, r14)     // Catch: java.lang.Exception -> Lc7
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Exception -> Lc7
            if (r0 != 0) goto Lbe
            r10.putBoolean(r5, r13)     // Catch: java.lang.Exception -> Lc7
            java.lang.String r0 = "startTime"
            long r3 = r1.startTime     // Catch: java.lang.Exception -> Lc7
            r10.putLong(r0, r3)     // Catch: java.lang.Exception -> Lc7
            r10.putString(r6, r9)     // Catch: java.lang.Exception -> Lc7
        Lbe:
            r15.setArguments(r10)     // Catch: java.lang.Exception -> Lc7
            java.lang.String r0 = "aliuser_mobile_login"
            r1.addFragment(r2, r15, r0)     // Catch: java.lang.Exception -> Lc7
            goto Lcb
        Lc7:
            r0 = move-exception
            r0.printStackTrace()
        Lcb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.user.mobile.login.ui.UserLoginActivity.gotoMobileLoginFragment(android.content.Intent):void");
    }

    public void gotoOneKeyLoginFragment(Intent intent) {
        try {
            Fragment fragment = (Fragment) getOneKeyLoginFragment(AliUserLogin.mAppreanceExtentions).newInstance();
            fragment.setArguments(intent.getExtras());
            UserTrackAdapter.sendUT("sim", getProperty(intent));
            addFragment(intent, fragment, FragmentConstant.ONE_KEY_LOGIN_FRAGMENT_TAG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004c A[Catch: Exception -> 0x00b2, TryCatch #3 {Exception -> 0x00b2, blocks: (B:24:0x004c, B:31:0x0061, B:33:0x006e, B:38:0x007e, B:40:0x0082, B:44:0x008a, B:46:0x009c, B:47:0x00a9, B:26:0x0050, B:28:0x005a, B:22:0x0044), top: B:58:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009c A[Catch: Exception -> 0x00b2, TryCatch #3 {Exception -> 0x00b2, blocks: (B:24:0x004c, B:31:0x0061, B:33:0x006e, B:38:0x007e, B:40:0x0082, B:44:0x008a, B:46:0x009c, B:47:0x00a9, B:26:0x0050, B:28:0x005a, B:22:0x0044), top: B:58:0x0044 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void gotoPwdLoginFragment(android.content.Intent r20) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            java.lang.String r3 = "check"
            java.lang.String r4 = "defaultTab"
            java.lang.String r5 = "ut_from_register"
            java.lang.String r6 = "PARAM_LOGIN_PARAM"
            java.lang.String r7 = "account"
            java.lang.String r8 = "forceNormalMode"
            java.lang.String r9 = ""
            r10 = 0
            boolean r11 = r2.getBooleanExtra(r8, r10)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r12 = r2.getStringExtra(r7)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r9 = r2.getStringExtra(r6)     // Catch: java.lang.Throwable -> L30
            boolean r13 = r2.getBooleanExtra(r5, r10)     // Catch: java.lang.Throwable -> L30
            int r14 = r2.getIntExtra(r4, r10)     // Catch: java.lang.Throwable -> L2e
            boolean r0 = r2.getBooleanExtra(r3, r10)     // Catch: java.lang.Throwable -> L2c
            goto L4a
        L2c:
            r0 = move-exception
            goto L33
        L2e:
            r0 = move-exception
            goto L32
        L30:
            r0 = move-exception
            r13 = 0
        L32:
            r14 = 0
        L33:
            r18 = r12
            r12 = r0
            r0 = r9
            r9 = r18
            goto L44
        L3a:
            r0 = move-exception
            r12 = r0
            r0 = r9
            goto L42
        L3e:
            r0 = move-exception
            r12 = r0
            r0 = r9
            r11 = 0
        L42:
            r13 = 0
            r14 = 0
        L44:
            r12.printStackTrace()     // Catch: java.lang.Exception -> Lb2
            r12 = r9
            r9 = r0
            r0 = 0
        L4a:
            if (r11 != 0) goto L50
            com.ali.user.mobile.rpc.HistoryAccount r15 = r1.mHistoryAccount     // Catch: java.lang.Exception -> Lb2
            if (r15 != 0) goto L61
        L50:
            com.ali.user.mobile.app.dataprovider.IDataProvider r15 = com.ali.user.mobile.app.dataprovider.DataProviderFactory.getDataProvider()     // Catch: java.lang.Exception -> Lb2
            boolean r15 = r15.supportRecommendLogin()     // Catch: java.lang.Exception -> Lb2
            if (r15 == 0) goto L61
            boolean r15 = r19.switchToRecommendLogin(r20)     // Catch: java.lang.Exception -> Lb2
            if (r15 == 0) goto L61
            return
        L61:
            androidx.fragment.app.Fragment r15 = r19.getUserLoginFragment()     // Catch: java.lang.Exception -> Lb2
            android.os.Bundle r10 = new android.os.Bundle     // Catch: java.lang.Exception -> Lb2
            r10.<init>()     // Catch: java.lang.Exception -> Lb2
            r17 = 1
            if (r11 != 0) goto L7c
            com.ali.user.mobile.app.dataprovider.IDataProvider r11 = com.ali.user.mobile.app.dataprovider.DataProviderFactory.getDataProvider()     // Catch: java.lang.Exception -> Lb2
            boolean r11 = r11.isShowHistoryFragment()     // Catch: java.lang.Exception -> Lb2
            if (r11 != 0) goto L79
            goto L7c
        L79:
            r16 = 0
            goto L7e
        L7c:
            r16 = 1
        L7e:
            com.ali.user.mobile.rpc.HistoryAccount r11 = r1.mHistoryAccount     // Catch: java.lang.Exception -> Lb2
            if (r11 == 0) goto L88
            int r11 = r11.hasPwd     // Catch: java.lang.Exception -> Lb2
            if (r11 != 0) goto L88
            r11 = 1
            goto L8a
        L88:
            r11 = r16
        L8a:
            r10.putBoolean(r3, r0)     // Catch: java.lang.Exception -> Lb2
            r10.putBoolean(r8, r11)     // Catch: java.lang.Exception -> Lb2
            r10.putInt(r4, r14)     // Catch: java.lang.Exception -> Lb2
            r10.putString(r7, r12)     // Catch: java.lang.Exception -> Lb2
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Exception -> Lb2
            if (r0 != 0) goto La9
            r10.putBoolean(r5, r13)     // Catch: java.lang.Exception -> Lb2
            java.lang.String r0 = "startTime"
            long r3 = r1.startTime     // Catch: java.lang.Exception -> Lb2
            r10.putLong(r0, r3)     // Catch: java.lang.Exception -> Lb2
            r10.putString(r6, r9)     // Catch: java.lang.Exception -> Lb2
        La9:
            r15.setArguments(r10)     // Catch: java.lang.Exception -> Lb2
            java.lang.String r0 = "aliuser_pwd_login"
            r1.addFragment(r2, r15, r0)     // Catch: java.lang.Exception -> Lb2
            goto Lb6
        Lb2:
            r0 = move-exception
            r0.printStackTrace()
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.user.mobile.login.ui.UserLoginActivity.gotoPwdLoginFragment(android.content.Intent):void");
    }

    public void gotoSNS_to_SMSFragment(Intent intent) {
        Fragment fragment = null;
        try {
            Bundle bundle = new Bundle();
            LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
            boolean z = false;
            if (intent != null && !TextUtils.isEmpty(intent.getStringExtra("number")) && !TextUtils.isEmpty(intent.getStringExtra("protocolName")) && !TextUtils.isEmpty("protocolURL")) {
                UserTrackAdapter.sendUT("SNS_AUTH_MASK_SUCCESS");
                TLogAdapter.d(TAG, "gotoSNS_to_SMSFragment: 支持 supportOneKey");
                z = true;
            }
            if (loginApprearanceExtensions != null && loginApprearanceExtensions.getFullyCustomizedSNSToSMSOneKeyLoginFragment() != null && z) {
                fragment = (Fragment) loginApprearanceExtensions.getFullyCustomizedSNSToSMSOneKeyLoginFragment().newInstance();
                bundle.putString("number", intent.getStringExtra("number"));
                bundle.putString("protocolName", intent.getStringExtra("protocolName"));
                bundle.putString("protocolURL", intent.getStringExtra("protocolURL"));
            } else if (loginApprearanceExtensions != null && loginApprearanceExtensions.getFullyCustomizedSNSToSMSLoginFragment() != null) {
                fragment = (Fragment) loginApprearanceExtensions.getFullyCustomizedSNSToSMSLoginFragment().newInstance();
            }
            if (fragment != null) {
                TLogAdapter.d(TAG, "gotoSNS_to_SMSFragment, fragment class: " + fragment.getClass().getName());
                bundle.putBoolean(LoginConstant.FORCE_NORMAL_MODE, true);
                if (!TextUtils.isEmpty(intent.getStringExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM))) {
                    bundle.putString(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, intent.getStringExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM));
                }
                fragment.setArguments(bundle);
                addFragment(intent, fragment, FragmentConstant.SNS_TO_SMS_LOGIN_FRAGMENT_TAG);
                return;
            }
            TLogAdapter.e(TAG, "you must custom SNS2SMSFragment");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void hideAllFragment() {
        List<String> fragmentTagList = FragmentConstant.getFragmentTagList();
        if (fragmentTagList != null) {
            for (String str : fragmentTagList) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(str);
                if (findFragmentByTag != null) {
                    this.mFragmentManager.beginTransaction().hide(findFragmentByTag).commitAllowingStateLoss();
                }
            }
        }
    }

    protected void initParam(Intent intent) {
        LoginParam loginParam;
        this.isLoginObserver = true;
        UserTrackAdapter.skipPage(this);
        this.startTime = System.currentTimeMillis();
        if (intent != null) {
            try {
                this.isOpenMobileLoginPage = TextUtils.equals(intent.getStringExtra(UIBaseConstants.LoginPage.PAGE_LOGIN_TYPE), UIBaseConstants.LoginPage.PAGE_SMS_LOGIN);
                this.isOpenUserLoginPage = TextUtils.equals(intent.getStringExtra(UIBaseConstants.LoginPage.PAGE_LOGIN_TYPE), UIBaseConstants.LoginPage.PAGE_PWD_LOGIN);
                String stringExtra = intent.getStringExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM);
                if (!TextUtils.isEmpty(stringExtra) && (loginParam = (LoginParam) JSON.parseObject(stringExtra, LoginParam.class)) != null) {
                    this.mSource = loginParam.source;
                }
            } catch (Throwable unused) {
                UserTrackAdapter.sendUT("Page_Login", "login_params_error");
            }
        }
        this.mFragmentManager = getSupportFragmentManager();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.base.ui.BaseActivity
    public void initViews() {
        super.initViews();
        try {
            if (getSupportActionBar() != null) {
                LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
                if (loginApprearanceExtensions != null && !loginApprearanceExtensions.isNeedToolbar()) {
                    getSupportActionBar().hide();
                }
                getSupportActionBar().setTitle("");
                LoginApprearanceExtensions loginApprearanceExtensions2 = AliUserLogin.mAppreanceExtentions;
                if (loginApprearanceExtensions2 != null && !loginApprearanceExtensions2.isNeedLoginToolbar()) {
                    getSupportActionBar().hide();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        openFragmentByConfig(getIntent());
    }

    @Override // com.ali.user.mobile.base.ui.BaseActivity
    public boolean isShowNavIcon() {
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        return loginApprearanceExtensions == null || loginApprearanceExtensions.needLoginBackButton();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        fragmentOnActivityResult(i, i2, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        TBS.Page.buttonClicked("Button_back");
        finishCurrentAndNotify();
    }

    @Override // com.ali.user.mobile.base.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.base.ui.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        TLogAdapter.d(TAG, "onCreate");
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (loginApprearanceExtensions != null && loginApprearanceExtensions.getActivityEnterAnimation() > 0) {
            overridePendingTransition(AliUserLogin.mAppreanceExtentions.getActivityEnterAnimation(), 0);
        }
        initParam(getIntent());
        UserTrackAdapter.sendUT("openLogin", getProperty(getIntent()));
        super.onCreate(bundle);
    }

    @Override // com.ali.user.mobile.base.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        try {
            sendCancelBroadcast();
            this.mFragmentManager = null;
            this.hadReadHistory = false;
            this.mHistoryAccount = null;
            super.onDestroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initParam(intent);
        openFragmentByConfig(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        try {
            callPageDisAppear();
            super.onPause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        try {
            super.onStart();
        } catch (Throwable th) {
            th.printStackTrace();
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        try {
            super.onStop();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected boolean openFragmentByAppLaunch(Intent intent) {
        T t;
        AppLaunchInfoResponseData appLaunchInfoResponseData = this.fireAppLaunchRes;
        if (appLaunchInfoResponseData != null && (t = appLaunchInfoResponseData.returnValue) != 0 && ((AppLaunchInfo) t).sortedRecommendLoginTypes != null) {
            List<String> list = ((AppLaunchInfo) t).sortedRecommendLoginTypes;
            if (((AppLaunchInfo) t).loginValidators != null) {
                this.isFaceLoginActivate = ((AppLaunchInfo) t).loginValidators.verify;
                this.isFaceLoginEnvEnable = ((AppLaunchInfo) t).loginValidators.preCheckVerify;
            }
            if (((AppLaunchInfo) t).testValue != null) {
                this.mShowRegTV = ((AppLaunchInfo) t).testValue.isRegOpen;
            }
            if (((AppLaunchInfo) t).userNotFound && this.mHistoryAccount != null) {
                UserTrackAdapter.sendUT("userNotFound");
                SecurityGuardManagerWraper.removeSessionModelFromFile(String.valueOf(this.mHistoryAccount.userId));
                SecurityGuardManagerWraper.removeHistoryAccount(SecurityGuardManagerWraper.findHistoryAccount(this.mHistoryAccount.userId));
                this.mHistoryAccount = null;
            }
            if (!((AppLaunchInfo) this.fireAppLaunchRes.returnValue).biometricOpen) {
                UserTrackAdapter.sendUT("biometricOpenFalse");
                this.mBiometricToken = "";
            }
            this.mUserOpenFaceLogin = this.isFaceLoginActivate && ServiceFactory.getService(FaceService.class) != null;
            if (list != null && list.size() > 0) {
                LoginTLogAdapter.e(TAG, "recommend: " + JSON.toJSONString(list));
                try {
                    UserTrackAdapter.sendUT(getPageName(), "RecommendList", JSON.toJSONString(list), null);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                for (String str : list) {
                    if (goFragmentByType(str, intent, (AppLaunchInfo) this.fireAppLaunchRes.returnValue)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void openFragmentByConfig(Intent intent) {
        if (LoginSwitch.getSwitch(LoginSwitch.OPEN_LOGIN_PAGE_WHEN_IS_LOGIN, "false")) {
            BroadCastHelper.sendLocalBroadCast(new Intent(LoginResActions.LOGIN_OPEN_ACTION));
        }
        if (DataProviderFactory.getDataProvider().useNewLoginStrategy()) {
            new CoordinatorWrapper().execute(new NewLoginPreCheckTask(this, intent), new Object[0]);
        } else {
            new CoordinatorWrapper().execute(new LoginPreCheckTask(this, intent), new Object[0]);
        }
    }

    protected void readHistoryCache(String str) {
        SharedPreferences sharedPreferences = DataProviderFactory.getApplicationContext().getSharedPreferences(str, 0);
        if (System.currentTimeMillis() / 1000 < sharedPreferences.getLong("expire_time", 0L)) {
            String string = sharedPreferences.getString("data", "");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                this.fireAppLaunchRes = (AppLaunchInfoResponseData) JSON.parseObject(string, AppLaunchInfoResponseData.class);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public boolean switchToRecommendLogin(Intent intent) {
        try {
            LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
            if (loginApprearanceExtensions == null || loginApprearanceExtensions.getFullyCustomizedRecommendLoginFragment() == null) {
                return false;
            }
            Fragment fragment = (Fragment) loginApprearanceExtensions.getFullyCustomizedRecommendLoginFragment().newInstance();
            fragment.setArguments(intent.getExtras());
            addFragment(intent, fragment, FragmentConstant.RECOMMEND_LOGIN_FRAGMENT_TAG);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
