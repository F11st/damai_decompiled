package com.ali.user.mobile.sns;

import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.UIBaseConstants;
import com.ali.user.mobile.base.helper.LoginDataHelper;
import com.ali.user.mobile.base.ui.BaseActivity;
import com.ali.user.mobile.callback.CommonDataCallback;
import com.ali.user.mobile.filter.LoginFilterCallback;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.ui.UserLoginActivity;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.RegistParam;
import com.ali.user.mobile.model.SNSSignInAccount;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.model.UrlParam;
import com.ali.user.mobile.navigation.NavigatorManager;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.service.NumberAuthService;
import com.ali.user.mobile.service.SNSService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.UTConstans;
import com.ali.user.mobile.webview.LoginPostHandler;
import com.alibaba.fastjson.JSON;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.login4android.ui.AliUserBindMobileDialog;
import com.taobao.login4android.utils.ToastUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class SNSServiceImpl implements SNSService {
    public static final String TAG = "loginsdk.sns";
    public static final SNSServiceImpl INSTANCE = new SNSServiceImpl();
    public static String CUSTOM_SNS_FRAGMENT_TIMEOUT = "SNSOneKeyTimeout";

    public static void commonSuccess(Activity activity, final LoginReturnData loginReturnData, final Map<String, String> map) {
        Map<String, String> map2;
        if (activity != null && (activity instanceof FragmentActivity) && loginReturnData != null && (map2 = loginReturnData.extMap) != null && !TextUtils.isEmpty(map2.get("loginPostUrl"))) {
            String str = loginReturnData.extMap.get(ApiConstants.ApiField.SNS_BIND_CONTENT);
            if (!TextUtils.isEmpty(loginReturnData.extMap.get(ApiConstants.ApiField.SNS_BIND_TITLE)) && !TextUtils.isEmpty(str)) {
                doPostSuccess((FragmentActivity) activity, loginReturnData, map);
                return;
            } else {
                LoginPostHandler.openPostPage(activity, loginReturnData.extMap.get("loginPostUrl"), new LoginFilterCallback() { // from class: com.ali.user.mobile.sns.SNSServiceImpl.2
                    @Override // com.ali.user.mobile.filter.LoginFilterCallback
                    public void onFail(int i, Map<String, String> map3) {
                        SNSServiceImpl.doSuccess(LoginReturnData.this, map3);
                    }

                    @Override // com.ali.user.mobile.filter.LoginFilterCallback
                    public void onSuccess() {
                        SNSServiceImpl.doSuccess(LoginReturnData.this, map);
                    }
                });
                return;
            }
        }
        doSuccess(loginReturnData, map);
    }

    public static void doPostSuccess(final FragmentActivity fragmentActivity, final LoginReturnData loginReturnData, final Map<String, String> map) {
        Map<String, String> map2;
        if (loginReturnData == null || (map2 = loginReturnData.extMap) == null) {
            return;
        }
        String str = map2.get(ApiConstants.ApiField.SNS_BIND_TITLE);
        String str2 = loginReturnData.extMap.get(ApiConstants.ApiField.SNS_BIND_CONTENT);
        final String str3 = loginReturnData.extMap.get("loginPostUrl");
        final AliUserBindMobileDialog aliUserBindMobileDialog = new AliUserBindMobileDialog();
        aliUserBindMobileDialog.setPositive(new View.OnClickListener() { // from class: com.ali.user.mobile.sns.SNSServiceImpl.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AliUserBindMobileDialog aliUserBindMobileDialog2;
                if (!FragmentActivity.this.isFinishing() && (aliUserBindMobileDialog2 = aliUserBindMobileDialog) != null) {
                    aliUserBindMobileDialog2.dismissAllowingStateLoss();
                    LoginPostHandler.openPostPage(FragmentActivity.this, str3, new LoginFilterCallback() { // from class: com.ali.user.mobile.sns.SNSServiceImpl.3.1
                        @Override // com.ali.user.mobile.filter.LoginFilterCallback
                        public void onFail(int i, Map<String, String> map3) {
                            SNSServiceImpl.doSuccess(loginReturnData, map3);
                        }

                        @Override // com.ali.user.mobile.filter.LoginFilterCallback
                        public void onSuccess() {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            SNSServiceImpl.doSuccess(loginReturnData, map);
                        }
                    });
                    return;
                }
                SNSServiceImpl.doSuccess(loginReturnData, map);
            }
        });
        aliUserBindMobileDialog.setNagetive(new View.OnClickListener() { // from class: com.ali.user.mobile.sns.SNSServiceImpl.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AliUserBindMobileDialog aliUserBindMobileDialog2;
                if (!FragmentActivity.this.isFinishing() && (aliUserBindMobileDialog2 = aliUserBindMobileDialog) != null) {
                    aliUserBindMobileDialog2.dismissAllowingStateLoss();
                }
                SNSServiceImpl.doSuccess(loginReturnData, map);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            aliUserBindMobileDialog.setTitle(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            aliUserBindMobileDialog.setContent(Html.fromHtml(str2));
        }
        aliUserBindMobileDialog.show(fragmentActivity.getSupportFragmentManager(), UTConstans.PageName.UT_PAGE_RECOMMEND_LOGIN);
    }

    public static void doSuccess(LoginReturnData loginReturnData, Map<String, String> map) {
        LoginDataHelper.processLoginReturnData(true, loginReturnData, map);
    }

    @Override // com.ali.user.mobile.service.SNSService
    public void dismissLoading(Activity activity) {
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).dismissProgressDialog();
        }
    }

    @Override // com.ali.user.mobile.service.SNSService
    public void onError(Activity activity, RpcResponse<LoginReturnData> rpcResponse) {
    }

    @Override // com.ali.user.mobile.service.SNSService
    public void onFastRegOrLoginBind(Activity activity, String str, String str2, String str3) {
        if (activity instanceof UserLoginActivity) {
            Intent intent = new Intent();
            LoginParam loginParam = new LoginParam();
            loginParam.loginAccount = str2;
            loginParam.snsToken = str;
            loginParam.snsType = str3;
            intent.putExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, JSON.toJSONString(loginParam));
            ((UserLoginActivity) activity).gotoFastRegOrLoginBind(intent);
        }
    }

    @Override // com.ali.user.mobile.service.SNSService
    public void onH5(Activity activity, RpcResponse<LoginReturnData> rpcResponse, UrlParam urlParam) {
        String str = rpcResponse.returnValue.h5Url;
        if (activity == null || TextUtils.isEmpty(str)) {
            return;
        }
        LoginParam loginParam = new LoginParam();
        if (urlParam != null) {
            loginParam.nativeLoginType = urlParam.loginType;
            LoginParam loginParam2 = urlParam.loginParam;
            if (loginParam2 != null) {
                loginParam.traceId = loginParam2.traceId;
            }
            loginParam.tokenType = TokenType.SNS;
            LoginReturnData loginReturnData = rpcResponse.returnValue;
            loginParam.token = loginReturnData.token;
            loginParam.scene = loginReturnData.scene;
            loginParam.externParams = loginReturnData.extMap;
            loginParam.sendLoginFailWhenWebviewCancel = true;
            NavigatorManager.getInstance().navToWebViewPage(activity, str, loginParam, rpcResponse.returnValue);
        }
    }

    @Override // com.ali.user.mobile.service.SNSService
    public void onLoginBind(Activity activity, String str, String str2, String str3, String str4) {
        if (activity == null || !(activity instanceof UserLoginActivity)) {
            return;
        }
        Intent intent = new Intent();
        LoginParam loginParam = new LoginParam();
        loginParam.loginAccount = str2;
        loginParam.snsToken = str;
        loginParam.headImg = str3;
        loginParam.snsType = str4;
        intent.putExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, JSON.toJSONString(loginParam));
        ((UserLoginActivity) activity).gotoAuthCheckFragmentFromGuide(intent);
    }

    @Override // com.ali.user.mobile.service.SNSService
    public void onLoginSuccess(Activity activity, SNSSignInAccount sNSSignInAccount, RpcResponse<LoginReturnData> rpcResponse) {
        HashMap hashMap = new HashMap();
        if (sNSSignInAccount != null) {
            hashMap.put(LoginConstants.LOGIN_TYPE, sNSSignInAccount.snsType);
        }
        commonSuccess(activity, rpcResponse.returnValue, hashMap);
    }

    @Override // com.ali.user.mobile.service.SNSService
    public void onRebind(Activity activity, String str, String str2, String str3) {
    }

    @Override // com.ali.user.mobile.service.SNSService
    public void onRegBind(Activity activity, String str) {
        NavigatorManager.getInstance().navToRegisterPage(activity, new RegistParam());
    }

    @Override // com.ali.user.mobile.service.SNSService
    public void onSMSLogin(final Activity activity, SNSSignInAccount sNSSignInAccount) {
        if (activity == null) {
            return;
        }
        LoginParam loginParam = new LoginParam();
        loginParam.snsToken = sNSSignInAccount.token;
        loginParam.snsType = sNSSignInAccount.snsType;
        loginParam.bindProtocolUrl = sNSSignInAccount.bindProtocolUrl;
        loginParam.supportOverseaMobile = sNSSignInAccount.supportOverseaMobile;
        final Intent callingIntent = UserLoginActivity.getCallingIntent(activity, JSON.toJSONString(loginParam), true, true);
        if (ServiceFactory.getService(NumberAuthService.class) != null && DataProviderFactory.getDataProvider().enableNumAuthService()) {
            try {
                UserTrackAdapter.sendUT("SNS_AUTH_MASK");
                ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getLoginMaskPhone(LoginSwitch.getSwitch(CUSTOM_SNS_FRAGMENT_TIMEOUT, 3000), new CommonDataCallback() { // from class: com.ali.user.mobile.sns.SNSServiceImpl.5
                    @Override // com.ali.user.mobile.callback.CommonDataCallback
                    public void onFail(int i, String str) {
                        Properties properties = new Properties();
                        properties.setProperty("code", i + "");
                        properties.setProperty("cause", str + "");
                        UserTrackAdapter.sendUT("Page_Extend", "get_login_number_fail", properties);
                        activity.startActivity(callingIntent);
                    }

                    @Override // com.ali.user.mobile.callback.CommonDataCallback
                    public void onSuccess(Map<String, String> map) {
                        UserTrackAdapter.sendUT("Page_Extend", "get_login_number_success");
                        if (map != null) {
                            try {
                                for (Map.Entry<String, String> entry : map.entrySet()) {
                                    callingIntent.putExtra(entry.getKey(), entry.getValue());
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                        activity.startActivity(callingIntent);
                    }
                });
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                activity.startActivity(callingIntent);
                return;
            }
        }
        activity.startActivity(callingIntent);
    }

    @Override // com.ali.user.mobile.service.SNSService
    public void onTokenLogin(Activity activity, String str, String str2) {
        if (activity == null || !(activity instanceof UserLoginActivity)) {
            return;
        }
        Intent intent = new Intent();
        LoginParam loginParam = new LoginParam();
        loginParam.token = str;
        loginParam.scene = "1045";
        intent.putExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, JSON.toJSONString(loginParam));
        ((UserLoginActivity) activity).gotoLoginFragmentFromGuide(intent);
    }

    @Override // com.ali.user.mobile.service.SNSService
    public void showLoading(Activity activity) {
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).showProgress("");
        }
    }

    @Override // com.ali.user.mobile.service.SNSService
    public void toast(final Activity activity, final String str) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.ali.user.mobile.sns.SNSServiceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ToastUtil.showToast(activity, str, 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
