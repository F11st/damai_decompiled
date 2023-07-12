package com.ali.user.mobile.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.UIBaseConstants;
import com.ali.user.mobile.callback.CommonDataCallback;
import com.ali.user.mobile.callback.DataCallback;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.ui.AliUserContainer;
import com.ali.user.mobile.login.ui.HalfTransparentUserLoginActivity;
import com.ali.user.mobile.login.ui.UserLoginActivity;
import com.ali.user.mobile.model.CommonCallback;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.RegistParam;
import com.ali.user.mobile.register.RegistConstants;
import com.ali.user.mobile.register.ui.AliUserRegisterActivity;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.service.NumberAuthService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.ui.WebConstant;
import com.ali.user.mobile.webview.AliUserRegisterWebviewActivity;
import com.ali.user.mobile.webview.AliUserWebTransparent;
import com.ali.user.mobile.webview.WebViewActivity;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.constants.LoginStatus;
import com.taobao.login4android.session.SessionManager;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class NavigatorManager {
    private static volatile NavigatorManager navigatorManager;
    private List<String> deviceMaskMobileList = null;

    private NavigatorManager() {
    }

    public static NavigatorManager getInstance() {
        if (navigatorManager == null) {
            synchronized (NavigatorManager.class) {
                if (navigatorManager == null) {
                    navigatorManager = new NavigatorManager();
                }
            }
        }
        return navigatorManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loginDispatchForCheckOneKeyLogin(Context context, Intent intent, String str) {
        this.deviceMaskMobileList = null;
        if (context != null) {
            if (LoginSwitch.isInABTestRegion(LoginSwitch.SKIP_CHECK_NEW_DEVICE_PERCENT, -1)) {
                if (TextUtils.isEmpty(SessionManager.getInstance(context).getOldUserId())) {
                    onekeyLogin(context, intent, false);
                } else {
                    nonOneKeyLogin(context, intent);
                }
            } else if (!DataProviderFactory.getDataProvider().supportOneKeyLogin() && !LoginStatus.enableOnekeyLoginV2) {
                context.startActivity(intent);
            } else {
                onekeyLogin(context, intent, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needCheckOnekey(Bundle bundle) {
        return bundle == null || ((TextUtils.isEmpty(bundle != null ? bundle.getString(UIBaseConstants.LoginPage.PAGE_LOGIN_TYPE) : "") || TextUtils.equals(bundle.getString(UIBaseConstants.LoginPage.PAGE_LOGIN_TYPE), UIBaseConstants.LoginPage.PAGE_ONEKEY_LOGIN) || TextUtils.equals(bundle.getString(UIBaseConstants.LoginPage.PAGE_LOGIN_TYPE), UIBaseConstants.LoginPage.HALF_PAGE_ONEKEY_LOGIN)) && ServiceFactory.getService(NumberAuthService.class) != null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nonOneKeyLogin(Context context, Intent intent) {
        context.startActivity(intent);
    }

    public void navToFinger(Context context, int i, CommonCallback commonCallback) {
        Intent intent = new Intent(context, AliUserContainer.class);
        if (context == null) {
            context = DataProviderFactory.getApplicationContext();
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        AliUserContainer.callback = commonCallback;
        intent.putExtra("status", i);
        intent.putExtra("actionType", AliUserContainer.TYPE_FINGER);
        context.startActivity(intent);
    }

    public void navToFingerLogin(Context context, CommonCallback commonCallback) {
        navToFinger(context, 1, commonCallback);
    }

    public void navToFingerSet(Context context, CommonCallback commonCallback) {
        navToFinger(context, 2, commonCallback);
    }

    public void navToLoginPage(final Context context, Bundle bundle, final String str, boolean z) {
        if (context != null) {
            Intent callingIntent = UserLoginActivity.getCallingIntent(context, str, z, false);
            String string = bundle != null ? bundle.getString(UIBaseConstants.LoginPage.PAGE_LOGIN_TYPE) : "";
            if (bundle != null && UIBaseConstants.isHalfPage(string)) {
                callingIntent = HalfTransparentUserLoginActivity.getCallingIntent(context, str);
            }
            if (bundle != null) {
                callingIntent.putExtras(bundle);
            }
            if (!(context instanceof Activity)) {
                callingIntent.addFlags(268435456);
            }
            if (AliUserLogin.getInstance().getPreOpenLoginPageFiler() != null) {
                AliUserLogin.getInstance().getPreOpenLoginPageFiler().handleIntent(context, callingIntent, new DataCallback<Intent>() { // from class: com.ali.user.mobile.navigation.NavigatorManager.1
                    @Override // com.ali.user.mobile.callback.DataCallback
                    public void result(Intent intent) {
                        if (intent == null || NavigatorManager.this.needCheckOnekey(intent.getExtras())) {
                            NavigatorManager.this.loginDispatchForCheckOneKeyLogin(context, intent, str);
                        } else {
                            context.startActivity(intent);
                        }
                    }
                });
            } else if (needCheckOnekey(bundle)) {
                loginDispatchForCheckOneKeyLogin(context, callingIntent, str);
            } else {
                context.startActivity(callingIntent);
            }
        }
    }

    public void navToRegWebViewPage(Context context, String str, String str2, String str3, LoginParam loginParam) {
        if (context != null) {
            Intent callingIntent = AliUserRegisterWebviewActivity.getCallingIntent(context, str, str2, loginParam);
            if (!TextUtils.isEmpty(str3)) {
                callingIntent.putExtra(WebConstant.REG_TYPE, str3);
            }
            context.startActivity(callingIntent);
        }
    }

    public void navToRegisterPage(Context context, RegistParam registParam) {
        navToRegisterPage(context, null, registParam);
    }

    public void navToTransparentWeb(Context context, String str) {
        Intent intent = new Intent(context, AliUserWebTransparent.class);
        intent.putExtra(WebConstant.WEBURL, str);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void navToWebViewPage(Activity activity, String str, LoginParam loginParam, LoginReturnData loginReturnData) {
        if (activity != null) {
            activity.startActivityForResult(WebViewActivity.getCallingIntent(activity, str, loginParam, loginReturnData, true), 257);
        }
    }

    public void onekeyLogin(Context context, Intent intent) {
        onekeyLogin(context, intent, false);
    }

    protected void transmitMap(Map<String, String> map, Intent intent, Context context, boolean z) {
        if (map != null) {
            try {
                if (this.deviceMaskMobileList != null && !z) {
                    if (this.deviceMaskMobileList.contains(map.get("number"))) {
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            intent.putExtra(entry.getKey(), entry.getValue());
                        }
                    }
                } else {
                    for (Map.Entry<String, String> entry2 : map.entrySet()) {
                        intent.putExtra(entry2.getKey(), entry2.getValue());
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        context.startActivity(intent);
    }

    public void waitLoginPhone(final Context context, final Intent intent, final boolean z) {
        Log.e("Login.login", "call waitLoginPhone");
        ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getLoginMaskPhone(2000, new CommonDataCallback() { // from class: com.ali.user.mobile.navigation.NavigatorManager.2
            @Override // com.ali.user.mobile.callback.CommonDataCallback
            public void onFail(int i, String str) {
                Log.e("Login.login", "call waitLoginPhone onFail");
                NavigatorManager.this.nonOneKeyLogin(context, intent);
            }

            @Override // com.ali.user.mobile.callback.CommonDataCallback
            public void onSuccess(Map<String, String> map) {
                Log.e("Login.login", "call waitLoginPhone,success");
                NavigatorManager.this.transmitMap(map, intent, context, z);
            }
        });
    }

    public void waitRegisterPhone(final Context context, final Intent intent, final Properties properties) {
        final int i = LoginSwitch.getSwitch(LoginSwitch.REGISTER_ONEKEY_WAIT, 3000);
        UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "get_register_number_commit", "", String.valueOf(i), properties);
        ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getLoginMaskPhone(i, "openRegView", new CommonDataCallback() { // from class: com.ali.user.mobile.navigation.NavigatorManager.3
            @Override // com.ali.user.mobile.callback.CommonDataCallback
            public void onFail(int i2, String str) {
                Properties properties2 = new Properties();
                properties2.setProperty("code", i2 + "");
                properties2.setProperty("cause", str + "");
                properties2.setProperty("wait_time", String.valueOf(i));
                UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "get_register_number_fail", properties2);
                UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "get_register_number_failure", i2 + "", String.valueOf(i), properties);
                context.startActivity(intent);
            }

            @Override // com.ali.user.mobile.callback.CommonDataCallback
            public void onSuccess(Map<String, String> map) {
                UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "get_register_number_success", "", String.valueOf(i), properties);
                if (map != null) {
                    try {
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            intent.putExtra(entry.getKey(), entry.getValue());
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                context.startActivity(intent);
            }
        });
    }

    public void navToRegisterPage(Context context, Intent intent, RegistParam registParam) {
        if (context != null) {
            Intent callingIntent = AliUserRegisterActivity.getCallingIntent(context);
            if (intent != null) {
                callingIntent.putExtras(intent);
            }
            if (registParam != null) {
                callingIntent.putExtra(RegistConstants.REGISTPARAM, registParam);
            }
            if (!(context instanceof Activity)) {
                callingIntent.addFlags(268435456);
            }
            if (DataProviderFactory.getDataProvider().supportOneKeyRegister()) {
                try {
                    if (ServiceFactory.getService(NumberAuthService.class) != null) {
                        Properties properties = new Properties();
                        properties.setProperty("monitor", "T");
                        Map<String, String> authInfoMap = ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getAuthInfoMap();
                        if (authInfoMap != null && !TextUtils.isEmpty(authInfoMap.get("number"))) {
                            for (Map.Entry<String, String> entry : authInfoMap.entrySet()) {
                                callingIntent.putExtra(entry.getKey(), entry.getValue());
                            }
                            context.startActivity(callingIntent);
                            return;
                        }
                        waitRegisterPhone(context, callingIntent, properties);
                        return;
                    }
                    context.startActivity(callingIntent);
                    return;
                } catch (Throwable th) {
                    UserTrackAdapter.sendUT("ONEKEY_REGISTER_EXCEPTION");
                    context.startActivity(callingIntent);
                    th.printStackTrace();
                    return;
                }
            }
            context.startActivity(callingIntent);
        }
    }

    public void onekeyLogin(Context context, Intent intent, boolean z) {
        try {
            if (ServiceFactory.getService(NumberAuthService.class) != null) {
                Map<String, String> authInfoMap = ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getAuthInfoMap();
                if (authInfoMap != null && !TextUtils.isEmpty(authInfoMap.get("number"))) {
                    transmitMap(authInfoMap, intent, context, z);
                    return;
                } else {
                    waitLoginPhone(context, intent, z);
                    return;
                }
            }
            nonOneKeyLogin(context, intent);
        } catch (Throwable th) {
            th.printStackTrace();
            UserTrackAdapter.sendUT("ONEKEY_LOGIN_EXCEPTION");
            nonOneKeyLogin(context, intent);
        }
    }

    public void navToWebViewPage(Activity activity, String str, LoginParam loginParam, boolean z) {
        if (activity != null) {
            activity.startActivityForResult(WebViewActivity.getCallingIntent(activity, str, loginParam, null, z), 257);
        }
    }

    public void navToLoginPage(Activity activity, String str, Bundle bundle) {
        if (activity instanceof UserLoginActivity) {
            Intent intent = new Intent();
            intent.putExtras(bundle);
            if (TextUtils.equals(str, UIBaseConstants.LoginPage.PAGE_SMS_LOGIN)) {
                ((UserLoginActivity) activity).gotoMobileLoginFragment(intent);
                return;
            } else if (TextUtils.equals(str, UIBaseConstants.LoginPage.PAGE_PWD_LOGIN)) {
                ((UserLoginActivity) activity).gotoPwdLoginFragment(intent);
                return;
            } else if (TextUtils.equals(str, UIBaseConstants.LoginPage.PAGE_RECOMMEND_LOGIN)) {
                ((UserLoginActivity) activity).switchToRecommendLogin(intent);
                return;
            } else if (TextUtils.equals(str, UIBaseConstants.LoginPage.PAGE_ONEKEY_LOGIN)) {
                onekeyLogin(activity, intent);
                return;
            } else {
                navToLoginPage(activity, bundle, "", true);
                return;
            }
        }
        navToLoginPage(activity, bundle, "", true);
    }
}
