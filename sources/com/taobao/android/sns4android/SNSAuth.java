package com.taobao.android.sns4android;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.base.helper.LoginDataHelper;
import com.ali.user.mobile.callback.CommonDataCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.helper.ActivityUIHelper;
import com.ali.user.mobile.helper.DialogHelper;
import com.ali.user.mobile.helper.IDialogHelper;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.model.CommonCallback;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.SNSSignInAccount;
import com.ali.user.mobile.model.UrlParam;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.rpc.login.model.SNSReturnData;
import com.ali.user.mobile.service.SNSBindService;
import com.ali.user.mobile.service.SNSService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.url.service.impl.UrlUtil;
import com.ali.user.mobile.utils.ResourceUtil;
import com.ali.user.open.ucc.util.UccConstants;
import com.alibaba.fastjson.JSON;
import com.taobao.android.sns4android.alipay3.Alipay3SignInHelper;
import com.taobao.android.sns4android.alipayinside.AlipayInsideSignInHelper;
import com.taobao.android.sns4android.bind.SNSBindContext;
import com.taobao.android.sns4android.handler.LoginFailHandler;
import com.taobao.android.sns4android.huawei.HuaweiSignInHelper;
import com.taobao.android.sns4android.jsbridge.AccountBindJSBridge;
import com.taobao.android.sns4android.model.SnsCainiaoBindResult;
import com.taobao.android.sns4android.qq.QQSignInHelper;
import com.taobao.android.sns4android.rpc.ExtraBindResult;
import com.taobao.android.sns4android.rpc.SNSDataRepository;
import com.taobao.android.sns4android.taobao3.TaobaoSignInHelper;
import com.taobao.android.sns4android.uc.UCSignInHelper;
import com.taobao.android.sns4android.util.AlertModel;
import com.taobao.android.sns4android.util.AlertUtil;
import com.taobao.android.sns4android.util.UTConstans;
import com.taobao.android.sns4android.wc.WCSignInHelper;
import com.taobao.android.sns4android.weibo.WeiboSignInHelper;
import com.taobao.android.sns4android.weixin.WeixinSignInHelper;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.login4android.constants.LoginStatus;
import com.taobao.login4android.thread.LoginThreadHelper;
import com.taobao.login4android.utils.ReflectionHelper;
import com.uc.webview.export.extension.UCCore;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class SNSAuth {
    private static boolean isBind;
    public static SNSListenerImpl mListener;
    private static LoginFailHandler mLoginFailHandler;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class SNSListenerImpl implements SNSSignInListener {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.taobao.android.sns4android.SNSAuth$SNSListenerImpl$a */
        /* loaded from: classes11.dex */
        public class C6594a implements RpcRequestCallback {
            final /* synthetic */ Activity a;
            final /* synthetic */ SNSSignInAccount b;

            C6594a(Activity activity, SNSSignInAccount sNSSignInAccount) {
                this.a = activity;
                this.b = sNSSignInAccount;
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onError(RpcResponse rpcResponse) {
                SNSListenerImpl.this.handleLoginResult(this.a, this.b, rpcResponse);
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSuccess(RpcResponse rpcResponse) {
                SNSListenerImpl.this.handleLoginResult(this.a, this.b, rpcResponse);
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSystemError(RpcResponse rpcResponse) {
                SNSListenerImpl.this.handleLoginResult(this.a, this.b, rpcResponse);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.taobao.android.sns4android.SNSAuth$SNSListenerImpl$b */
        /* loaded from: classes12.dex */
        public class DialogInterface$OnClickListenerC6595b implements DialogInterface.OnClickListener {
            final /* synthetic */ DialogHelper a;
            final /* synthetic */ Activity b;
            final /* synthetic */ SNSSignInAccount c;
            final /* synthetic */ RpcResponse d;

            DialogInterface$OnClickListenerC6595b(SNSListenerImpl sNSListenerImpl, DialogHelper dialogHelper, Activity activity, SNSSignInAccount sNSSignInAccount, RpcResponse rpcResponse) {
                this.a = dialogHelper;
                this.b = activity;
                this.c = sNSSignInAccount;
                this.d = rpcResponse;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                this.a.dismissAlertDialog();
                if (this.b != null) {
                    UrlParam urlParam = new UrlParam();
                    urlParam.needTitle = false;
                    LoginParam loginParam = new LoginParam();
                    loginParam.traceId = ApiReferer.generateTraceId(UTConstans.convertSnsTypeToLoginType(this.c.snsType), UTConstant.PageName.UT_PAGE_EXTEND);
                    urlParam.loginParam = loginParam;
                    ((SNSService) ServiceFactory.getService(SNSService.class)).onH5(this.b, this.d, urlParam);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.taobao.android.sns4android.SNSAuth$SNSListenerImpl$c */
        /* loaded from: classes11.dex */
        public class C6596c implements CommonDataCallback {
            final /* synthetic */ SNSSignInAccount a;
            final /* synthetic */ UrlParam b;
            final /* synthetic */ Activity c;

            C6596c(SNSListenerImpl sNSListenerImpl, SNSSignInAccount sNSSignInAccount, UrlParam urlParam, Activity activity) {
                this.a = sNSSignInAccount;
                this.b = urlParam;
                this.c = activity;
            }

            @Override // com.ali.user.mobile.callback.CommonDataCallback
            public void onFail(int i, String str) {
                Properties access$100 = SNSAuth.access$100();
                access$100.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
                if (i != 10003 && i != 10004 && i != 15 && i != 1403) {
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, i + "", UTConstans.convertSnsTypeToLoginType(this.a.snsType), access$100);
                    BroadCastHelper.sendLoginFailBroadcast(i, str);
                    if (this.c != null) {
                        ((SNSService) ServiceFactory.getService(SNSService.class)).toast(this.c, str);
                        return;
                    }
                    return;
                }
                UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_CANCEL, "", UTConstans.convertSnsTypeToLoginType(this.a.snsType), access$100);
                BroadCastHelper.sendLoginFailBroadcast(701, "user cancel");
            }

            @Override // com.ali.user.mobile.callback.CommonDataCallback
            public void onSuccess(Map<String, String> map) {
                if (map != null) {
                    Properties access$100 = SNSAuth.access$100();
                    access$100.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_SUCCESS, "", UTConstans.convertSnsTypeToLoginType(this.a.snsType), access$100);
                    String str = map.get(UccConstants.PARAM_LOGIN_DATA);
                    if (!TextUtils.isEmpty(str)) {
                        HashMap hashMap = new HashMap();
                        Log.e(LoginThreadHelper.TAG, "loginType=" + this.b.loginType);
                        if (!TextUtils.isEmpty(this.b.loginType)) {
                            hashMap.put(LoginConstants.LOGIN_TYPE, this.b.loginType);
                        }
                        LoginDataHelper.processLoginReturnData(true, (LoginReturnData) JSON.parseObject(str, LoginReturnData.class), (Map<String, String>) hashMap);
                        return;
                    }
                    BroadCastHelper.sendLoginFailBroadcast(702, "");
                    return;
                }
                BroadCastHelper.sendLoginFailBroadcast(702, "");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.taobao.android.sns4android.SNSAuth$SNSListenerImpl$d */
        /* loaded from: classes12.dex */
        public class DialogInterface$OnClickListenerC6597d implements DialogInterface.OnClickListener {
            final /* synthetic */ RpcResponse a;
            final /* synthetic */ DialogHelper b;

            DialogInterface$OnClickListenerC6597d(SNSListenerImpl sNSListenerImpl, RpcResponse rpcResponse, DialogHelper dialogHelper) {
                this.a = rpcResponse;
                this.b = dialogHelper;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                BroadCastHelper.sendLoginFailBroadcast(703, this.a.message);
                this.b.dismissAlertDialog();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleLoginResult(Activity activity, SNSSignInAccount sNSSignInAccount, RpcResponse<LoginReturnData> rpcResponse) {
            if (activity != null) {
                ((SNSService) ServiceFactory.getService(SNSService.class)).dismissLoading(activity);
            }
            try {
                UTConstans.setLoginFrom(sNSSignInAccount.snsType);
                if (rpcResponse == null) {
                    SNSAuth.snsTokenUT(rpcResponse, UTConstant.PageName.UT_PAGE_EXTEND, "Other");
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, "704", UTConstans.convertSnsTypeToLoginType(sNSSignInAccount.snsType), SNSAuth.access$100());
                    BroadCastHelper.sendLoginFailBroadcast(704, "sns auth code login with empty response");
                    if (activity != null) {
                        ((SNSService) ServiceFactory.getService(SNSService.class)).toast(activity, ResourceUtil.getStringById("aliuser_network_error"));
                        return;
                    }
                    return;
                }
                String str = rpcResponse.actionType;
                String str2 = rpcResponse.codeGroup;
                String str3 = rpcResponse.message;
                if (TextUtils.isEmpty(str3)) {
                    str3 = ResourceUtil.getStringById("aliuser_network_error");
                }
                if ("SUCCESS".equals(str) && rpcResponse.returnValue != null) {
                    if (activity != null) {
                        ((SNSService) ServiceFactory.getService(SNSService.class)).onLoginSuccess(activity, sNSSignInAccount, rpcResponse);
                    }
                    try {
                        UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_SUCCESS, "", UTConstans.convertSnsTypeToLoginType(sNSSignInAccount.snsType), SNSAuth.access$100());
                    } catch (Throwable unused) {
                    }
                } else if (ApiConstants.ResultActionType.TOAST.equalsIgnoreCase(str)) {
                    SNSAuth.snsTokenUT(rpcResponse, UTConstant.PageName.UT_PAGE_EXTEND, "Other");
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, String.valueOf(rpcResponse.code), UTConstans.convertSnsTypeToLoginType(sNSSignInAccount.snsType), SNSAuth.access$100());
                    if (SNSAuth.mLoginFailHandler == null || !SNSAuth.mLoginFailHandler.loginFailHandler(rpcResponse)) {
                        if (activity != null) {
                            ((SNSService) ServiceFactory.getService(SNSService.class)).toast(activity, str3);
                        }
                        BroadCastHelper.sendLoginFailBroadcast(703, str3);
                    }
                } else if ("H5".equals(str) && rpcResponse.returnValue != null) {
                    SNSAuth.snsTokenUT(rpcResponse, UTConstant.PageName.UT_PAGE_EXTEND, "h5");
                    UrlParam urlParam = new UrlParam();
                    urlParam.loginType = sNSSignInAccount.snsType;
                    LoginParam loginParam = new LoginParam();
                    loginParam.traceId = ApiReferer.generateTraceId(UTConstans.convertSnsTypeToLoginType(sNSSignInAccount.snsType), UTConstant.PageName.UT_PAGE_EXTEND);
                    urlParam.loginParam = loginParam;
                    if (activity != null) {
                        ((SNSService) ServiceFactory.getService(SNSService.class)).onH5(activity, rpcResponse, urlParam);
                    }
                } else if (ApiConstants.ResultActionType.ALERT_WITH_H5.equals(str)) {
                    SNSAuth.snsTokenUT(rpcResponse, UTConstant.PageName.UT_PAGE_EXTEND, "alert_with_h5");
                    DialogHelper dialogHelper = new DialogHelper(activity);
                    dialogHelper.alert("", rpcResponse.message, activity.getResources().getString(R.string.aliuser_confirm), new DialogInterface$OnClickListenerC6595b(this, dialogHelper, activity, sNSSignInAccount, rpcResponse), null, null);
                } else if (ApiConstants.ResultActionType.UCC_H5.equals(str) && rpcResponse.returnValue != null) {
                    SNSAuth.snsTokenUT(rpcResponse, UTConstant.PageName.UT_PAGE_EXTEND, "ucc_h5");
                    String str4 = rpcResponse.returnValue.h5Url;
                    UrlParam urlParam2 = new UrlParam();
                    urlParam2.loginType = sNSSignInAccount.snsType;
                    LoginReturnData loginReturnData = rpcResponse.returnValue;
                    urlParam2.token = loginReturnData.token;
                    urlParam2.scene = loginReturnData.scene;
                    urlParam2.url = str4;
                    UrlUtil.OpenUCC(activity, urlParam2, new C6596c(this, sNSSignInAccount, urlParam2, activity));
                } else if (ApiConstants.ResultActionType.ALERT.equals(str)) {
                    SNSAuth.snsTokenUT(rpcResponse, UTConstant.PageName.UT_PAGE_EXTEND, "Alert");
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, String.valueOf(rpcResponse.code), UTConstans.convertSnsTypeToLoginType(sNSSignInAccount.snsType), SNSAuth.access$100());
                    if (activity != null) {
                        DialogHelper dialogHelper2 = new DialogHelper(activity);
                        String string = activity.getResources().getString(R.string.aliuser_SNS_cancel);
                        String string2 = activity.getResources().getString(R.string.aliuser_confirm);
                        DialogInterface$OnClickListenerC6597d dialogInterface$OnClickListenerC6597d = new DialogInterface$OnClickListenerC6597d(this, rpcResponse, dialogHelper2);
                        dialogHelper2.alert("", rpcResponse.message, string2, dialogInterface$OnClickListenerC6597d, string, dialogInterface$OnClickListenerC6597d);
                    }
                } else if (!ApiConstants.CodeGroup.SNSFAILED.equals(str2) || rpcResponse.returnValue == null) {
                    SNSAuth.snsTokenUT(rpcResponse, UTConstant.PageName.UT_PAGE_EXTEND, "Other");
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, String.valueOf(rpcResponse.code), UTConstans.convertSnsTypeToLoginType(sNSSignInAccount.snsType), SNSAuth.access$100());
                    if (activity != null) {
                        ((SNSService) ServiceFactory.getService(SNSService.class)).toast(activity, str3);
                    }
                    BroadCastHelper.sendLoginFailBroadcast(rpcResponse.code, rpcResponse.message);
                } else {
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, String.valueOf(rpcResponse.code), UTConstans.convertSnsTypeToLoginType(sNSSignInAccount.snsType), SNSAuth.access$100());
                    SNSAuth.handleSNSFailCase(activity, rpcResponse, sNSSignInAccount, UTConstant.PageName.UT_PAGE_EXTEND);
                }
            } finally {
            }
        }

        @Override // com.taobao.android.sns4android.SNSSignInListener
        public void onCancel(Activity activity, String str) {
            if (SNSAuth.isBind) {
                if (SNSBindContext.sBindCallback != null) {
                    ((CommonCallback) SNSBindContext.sBindCallback).onFail(701, "绑定取消");
                    return;
                }
                return;
            }
            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstans.CustomEvent.UT_SNS_AUTHCODE_CANCEL, "", UTConstans.convertSnsTypeToLoginType(str), SNSAuth.access$100());
            BroadCastHelper.sendCancelBroadcast("701", "用户取消");
        }

        public void onCanceld(Activity activity, String str) {
            onCancel(activity, str);
        }

        @Override // com.taobao.android.sns4android.SNSSignInListener
        public void onError(Activity activity, String str, int i, String str2) {
            if (SNSAuth.isBind) {
                if (SNSBindContext.sBindCallback != null) {
                    ((CommonCallback) SNSBindContext.sBindCallback).onFail(i, "绑定失败");
                    return;
                }
                return;
            }
            Properties access$100 = SNSAuth.access$100();
            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstans.CustomEvent.UT_SNS_AUTHCODE_FAILURE, i + "", UTConstans.convertSnsTypeToLoginType(str), access$100);
            if (activity != null && !activity.isFinishing()) {
                ((SNSService) ServiceFactory.getService(SNSService.class)).toast(activity, str2);
            }
            BroadCastHelper.sendLoginFailBroadcast(i, str2);
        }

        @Override // com.taobao.android.sns4android.SNSSignInListener
        public void onSucceed(Activity activity, SNSSignInAccount sNSSignInAccount) {
            if (SNSAuth.isBind) {
                if (SNSBindContext.sBindCallback == null || ServiceFactory.getService(SNSBindService.class) == null) {
                    return;
                }
                ((SNSBindService) ServiceFactory.getService(SNSBindService.class)).doBind(activity, sNSSignInAccount, (CommonCallback) SNSBindContext.sBindCallback);
                return;
            }
            if (activity != null) {
                ((SNSService) ServiceFactory.getService(SNSService.class)).showLoading(activity);
            }
            if (sNSSignInAccount != null) {
                Properties access$100 = SNSAuth.access$100();
                UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstans.CustomEvent.UT_SNS_AUTHCODE_SUCCESS, "", UTConstans.convertSnsTypeToLoginType(sNSSignInAccount.snsType), access$100);
                UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_COMMIT, "", UTConstans.convertSnsTypeToLoginType(sNSSignInAccount.snsType), access$100);
            }
            SNSDataRepository.getInstance().snsLogin(sNSSignInAccount, new C6594a(activity, sNSSignInAccount));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.sns4android.SNSAuth$a */
    /* loaded from: classes12.dex */
    public static class DialogInterface$OnClickListenerC6598a implements DialogInterface.OnClickListener {
        final /* synthetic */ String a;
        final /* synthetic */ Activity b;
        final /* synthetic */ IDialogHelper c;

        /* compiled from: Taobao */
        /* renamed from: com.taobao.android.sns4android.SNSAuth$a$a */
        /* loaded from: classes11.dex */
        class C6599a implements RpcRequestCallback {
            C6599a() {
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onError(RpcResponse rpcResponse) {
                ((SNSService) ServiceFactory.getService(SNSService.class)).toast(DialogInterface$OnClickListenerC6598a.this.b, ResourceUtil.getStringById("aliuser_SNS_platform_auth_fail"));
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSuccess(RpcResponse rpcResponse) {
                if (rpcResponse != null) {
                    String stringById = ResourceUtil.getStringById("aliuser_SNS_platform_auth_fail");
                    if (!TextUtils.isEmpty(rpcResponse.message)) {
                        stringById = rpcResponse.message;
                    }
                    if (rpcResponse.returnValue != 0 && rpcResponse.code == 200 && (rpcResponse instanceof SnsCainiaoBindResult)) {
                        T t = ((SnsCainiaoBindResult) rpcResponse).returnValue;
                        ((SNSService) ServiceFactory.getService(SNSService.class)).onTokenLogin(DialogInterface$OnClickListenerC6598a.this.b, ((ExtraBindResult) t).trustLoginToken, ((ExtraBindResult) t).scene);
                        return;
                    }
                    ((SNSService) ServiceFactory.getService(SNSService.class)).toast(DialogInterface$OnClickListenerC6598a.this.b, stringById);
                    return;
                }
                ((SNSService) ServiceFactory.getService(SNSService.class)).toast(DialogInterface$OnClickListenerC6598a.this.b, ResourceUtil.getStringById("aliuser_SNS_platform_auth_fail"));
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSystemError(RpcResponse rpcResponse) {
                ((SNSService) ServiceFactory.getService(SNSService.class)).toast(DialogInterface$OnClickListenerC6598a.this.b, ResourceUtil.getStringById("aliuser_SNS_platform_auth_fail"));
            }
        }

        DialogInterface$OnClickListenerC6598a(String str, Activity activity, IDialogHelper iDialogHelper) {
            this.a = str;
            this.b = activity;
            this.c = iDialogHelper;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            SNSDataRepository.getInstance().newBind(this.a, new C6599a());
            this.c.dismissAlertDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.sns4android.SNSAuth$b */
    /* loaded from: classes12.dex */
    public static class DialogInterface$OnClickListenerC6600b implements DialogInterface.OnClickListener {
        final /* synthetic */ IDialogHelper a;

        DialogInterface$OnClickListenerC6600b(IDialogHelper iDialogHelper) {
            this.a = iDialogHelper;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.dismissAlertDialog();
        }
    }

    static /* synthetic */ Properties access$100() {
        return getMonitorProperties();
    }

    public static void auth(SNSPlatform sNSPlatform, Activity activity, SNSSignInListener sNSSignInListener) {
        auth(sNSPlatform, activity, null);
    }

    public static void bind(SNSPlatform sNSPlatform, Activity activity) {
        if (activity == null) {
            return;
        }
        isBind = true;
        if (SNSProviderFactory.getInstance().getSNSProvider(sNSPlatform) != null) {
            SNSProviderFactory.getInstance().getSNSProvider(sNSPlatform).signIn(activity);
        }
    }

    public static SNSListenerImpl getListener() {
        return mListener;
    }

    private static Properties getMonitorProperties() {
        Properties properties = new Properties();
        properties.setProperty("monitor", "T");
        return properties;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleSNSFailCase(Activity activity, RpcResponse<LoginReturnData> rpcResponse, SNSSignInAccount sNSSignInAccount, String str) {
        Map<String, String> map;
        String string;
        LoginReturnData loginReturnData = rpcResponse.returnValue;
        if (loginReturnData != null && (map = loginReturnData.extMap) != null) {
            sNSSignInAccount.supportOverseaMobile = Boolean.parseBoolean(map.get("supportOverseaCountry"));
            sNSSignInAccount.bindProtocolUrl = loginReturnData.extMap.get("bindProtocolUrl");
            String str2 = loginReturnData.extMap.get(ApiConstants.ApiField.SNS_USER_INFO);
            String str3 = loginReturnData.extMap.get(ApiConstants.ApiField.SNS_RESULT_CODE);
            String str4 = loginReturnData.extMap.get(ApiConstants.ApiField.SNS_LOGIN_TOKEN);
            String str5 = loginReturnData.extMap.get("token");
            if (str3 != null && str2 != null) {
                if (!SNSResultCode.REGISTER_BIND.equals(str3) && !SNSResultCode.NO_EMAIL_NEED_REGISTER_BIND.equals(str3) && !SNSResultCode.CONFLICT_FOR_REGISTER_BIND.equals(str3)) {
                    if (SNSResultCode.LOGIN_BIND.equals(str3)) {
                        SNSReturnData sNSReturnData = (SNSReturnData) JSON.parseObject(str2, SNSReturnData.class);
                        if (sNSReturnData != null) {
                            sNSSignInAccount.firstName = sNSReturnData.firstName;
                            sNSSignInAccount.lastName = sNSReturnData.lastName;
                            sNSSignInAccount.email = sNSReturnData.email;
                            ((SNSService) ServiceFactory.getService(SNSService.class)).onLoginBind(activity, str4, sNSReturnData.email, sNSReturnData.headUrl, sNSSignInAccount.snsType);
                        }
                        snsTokenUT(rpcResponse, str, "LoginToBind");
                        return;
                    } else if (SNSResultCode.UNBIND_AND_REBIND.equals(str3)) {
                        ((SNSService) ServiceFactory.getService(SNSService.class)).onRebind(activity, str2, str4, str3);
                        snsTokenUT(rpcResponse, str, "ChangeBind");
                        return;
                    } else if (SNSResultCode.FAST_REG_OR_LOGIN_BIND.equals(str3)) {
                        snsTokenUT(rpcResponse, str, SNSResultCode.FAST_REG_OR_LOGIN_BIND);
                        ((SNSService) ServiceFactory.getService(SNSService.class)).onFastRegOrLoginBind(activity, str4, ((SNSReturnData) JSON.parseObject(str2, SNSReturnData.class)).email, sNSSignInAccount.snsType);
                        return;
                    } else if (SNSResultCode.ALIPAY_AUTH_LOGIN.equals(str3)) {
                        signIn(SNSPlatform.PLATFORM_ALIPAY, activity);
                        return;
                    } else if (ApiConstants.ResultActionType.ALERT_CONFIRM.equals(str3)) {
                        String str6 = loginReturnData.extMap.get(ApiConstants.ApiField.SNS_BIND_CONTENT);
                        AlertModel alertModel = null;
                        try {
                            alertModel = (AlertModel) JSON.parseObject(str6, AlertModel.class);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        ActivityUIHelper activityUIHelper = new ActivityUIHelper(activity);
                        if (alertModel != null) {
                            AlertUtil.alertConfirm(activity, alertModel, activityUIHelper);
                            return;
                        }
                        if (TextUtils.isEmpty(str6)) {
                            str6 = rpcResponse.message;
                        }
                        ((SNSService) ServiceFactory.getService(SNSService.class)).toast(activity, str6);
                        return;
                    } else if (!SNSResultCode.GO_BIND_ALIPAY.equals(str3) && !SNSResultCode.GO_UNBIND_AND_BIND_ALIPAY.equals(str3)) {
                        if (SNSResultCode.SNS_TO_SMSLOGIN.equals(str3)) {
                            sNSSignInAccount.token = str4;
                            if (activity != null) {
                                ((SNSService) ServiceFactory.getService(SNSService.class)).onSMSLogin(activity, sNSSignInAccount);
                                return;
                            }
                            return;
                        }
                        ((SNSService) ServiceFactory.getService(SNSService.class)).toast(activity, ResourceUtil.getStringById("aliuser_network_error"));
                        BroadCastHelper.sendLoginFailBroadcast(705, "sns auth code login with empty return value");
                        snsTokenUT(rpcResponse, str, "Other");
                        return;
                    } else {
                        snsTokenUT(rpcResponse, str, str3);
                        String str7 = loginReturnData.extMap.get(ApiConstants.ApiField.SNS_BIND_TITLE);
                        String str8 = loginReturnData.extMap.get(ApiConstants.ApiField.SNS_BIND_CONTENT);
                        String string2 = activity.getResources().getString(R.string.aliuser_SNS_cancel);
                        if (SNSResultCode.GO_BIND_ALIPAY.equals(str3)) {
                            string = activity.getResources().getString(R.string.aliuser_SNS_bind_alipay);
                        } else {
                            string = activity.getResources().getString(R.string.aliuser_SNS_change_alipay);
                        }
                        String str9 = string;
                        ActivityUIHelper activityUIHelper2 = new ActivityUIHelper(activity);
                        activityUIHelper2.alert(activity, str7, str8, str9, new DialogInterface$OnClickListenerC6598a(str5, activity, activityUIHelper2), string2, new DialogInterface$OnClickListenerC6600b(activityUIHelper2));
                        return;
                    }
                }
                SNSReturnData sNSReturnData2 = (SNSReturnData) JSON.parseObject(str2, SNSReturnData.class);
                if (sNSReturnData2 != null) {
                    sNSSignInAccount.firstName = sNSReturnData2.firstName;
                    sNSSignInAccount.lastName = sNSReturnData2.lastName;
                    sNSSignInAccount.email = sNSReturnData2.email;
                    sNSSignInAccount.userId = sNSReturnData2.openId;
                    ((SNSService) ServiceFactory.getService(SNSService.class)).onRegBind(activity, JSON.toJSONString(sNSSignInAccount));
                } else {
                    ((SNSService) ServiceFactory.getService(SNSService.class)).toast(activity, ResourceUtil.getStringById("aliuser_network_error"));
                    BroadCastHelper.sendLoginFailBroadcast(703, str3);
                }
                snsTokenUT(rpcResponse, str, "RegisterToBind");
                return;
            }
            ((SNSService) ServiceFactory.getService(SNSService.class)).toast(activity, ResourceUtil.getStringById("aliuser_network_error"));
            BroadCastHelper.sendLoginFailBroadcast(705, "sns auth code login with empty return value");
            snsTokenUT(rpcResponse, str, "Other");
            return;
        }
        ((SNSService) ServiceFactory.getService(SNSService.class)).toast(activity, ResourceUtil.getStringById("aliuser_network_error"));
        BroadCastHelper.sendLoginFailBroadcast(705, "sns auth code login with empty return value");
        snsTokenUT(rpcResponse, str, "Other");
    }

    public static void init(SNSConfig sNSConfig) {
        if (sNSConfig == null) {
            return;
        }
        if (mListener == null) {
            mListener = new SNSListenerImpl();
        }
        if (isAlipay(sNSConfig.platform)) {
            Alipay3SignInHelper create = Alipay3SignInHelper.create(sNSConfig);
            create.setSNSSignInListener(mListener);
            SNSProviderFactory.getInstance().putSNSProvider(sNSConfig.platform, create);
        } else if (isAlipayInside(sNSConfig.platform)) {
            AlipayInsideSignInHelper create2 = AlipayInsideSignInHelper.create(sNSConfig);
            create2.setSNSSignInListener(mListener);
            SNSProviderFactory.getInstance().putSNSProvider(sNSConfig.platform, create2);
        } else {
            init(sNSConfig.platform, sNSConfig.app_id, sNSConfig.callback);
        }
    }

    public static void invokeError(SNSSignInListener sNSSignInListener, String str, int i, String str2) {
        if (sNSSignInListener != null) {
            if (TextUtils.equals(str, WeixinSignInHelper.SNS_TYPE)) {
                sNSSignInListener.onError(WeixinSignInHelper.getContext(), str, i, str2);
            } else {
                sNSSignInListener.onError(null, str, i, str2);
            }
        }
    }

    public static void invokeTokenLogin(SNSSignInAccount sNSSignInAccount) {
        if (mListener != null) {
            if (sNSSignInAccount != null && TextUtils.equals(sNSSignInAccount.snsType, WeixinSignInHelper.SNS_TYPE)) {
                mListener.onSucceed(WeixinSignInHelper.getContext(), sNSSignInAccount);
            } else {
                mListener.onSucceed(null, sNSSignInAccount);
            }
        }
    }

    private static boolean isAlipay(SNSPlatform sNSPlatform) {
        return TextUtils.equals(sNSPlatform.getPlatform(), SNSPlatform.PLATFORM_ALIPAY.getPlatform());
    }

    private static boolean isAlipayInside(SNSPlatform sNSPlatform) {
        return TextUtils.equals(sNSPlatform.getPlatform(), SNSPlatform.PLATFORM_ALIPAYINSIDE.getPlatform());
    }

    public static boolean isFacebook(SNSPlatform sNSPlatform) {
        return TextUtils.equals(sNSPlatform.getPlatform(), SNSPlatform.PLATFORM_FACEBOOK.getPlatform());
    }

    public static boolean isGoogle(SNSPlatform sNSPlatform) {
        return TextUtils.equals(sNSPlatform.getPlatform(), SNSPlatform.PLATFORM_GOOGLE.getPlatform());
    }

    private static boolean isHuawei(SNSPlatform sNSPlatform) {
        return TextUtils.equals(SNSPlatform.PLATFORM_HUAWEI.getPlatform(), sNSPlatform.getPlatform());
    }

    public static boolean isLine(SNSPlatform sNSPlatform) {
        return TextUtils.equals(sNSPlatform.getPlatform(), SNSPlatform.PLATFORM_LINE.getPlatform());
    }

    public static boolean isLinkedin(SNSPlatform sNSPlatform) {
        return TextUtils.equals(sNSPlatform.getPlatform(), SNSPlatform.PLATFORM_LINKEDIN.getPlatform());
    }

    private static boolean isNetease(SNSPlatform sNSPlatform) {
        return TextUtils.equals(sNSPlatform.getPlatform(), SNSPlatform.PLATFORM_NETEASE.getPlatform());
    }

    private static boolean isQQ(SNSPlatform sNSPlatform) {
        return TextUtils.equals(sNSPlatform.getPlatform(), SNSPlatform.PLATFORM_QQ.getPlatform());
    }

    private static boolean isTaobao(SNSPlatform sNSPlatform) {
        return TextUtils.equals(sNSPlatform.getPlatform(), SNSPlatform.PLATFORM_TAOBAO.getPlatform());
    }

    public static boolean isTwitter(SNSPlatform sNSPlatform) {
        return TextUtils.equals(sNSPlatform.getPlatform(), SNSPlatform.PLATFORM_TWITTER.getPlatform());
    }

    private static boolean isUC(SNSPlatform sNSPlatform) {
        return TextUtils.equals(SNSPlatform.PLATFORM_UC.getPlatform(), sNSPlatform.getPlatform());
    }

    public static boolean isWC(SNSPlatform sNSPlatform) {
        return TextUtils.equals(sNSPlatform.getPlatform(), SNSPlatform.PLATFORM_WC.getPlatform());
    }

    private static boolean isWeibo(SNSPlatform sNSPlatform) {
        return TextUtils.equals(sNSPlatform.getPlatform(), SNSPlatform.PLATFORM_WEIBO.getPlatform());
    }

    private static boolean isWeixin(SNSPlatform sNSPlatform) {
        return TextUtils.equals(sNSPlatform.getPlatform(), SNSPlatform.PLATFORM_WEIXIN.getPlatform());
    }

    public static void onActivityResult(SNSPlatform sNSPlatform, int i, int i2, Intent intent) {
        if (SNSProviderFactory.getInstance().getSNSProvider(sNSPlatform) != null) {
            SNSProviderFactory.getInstance().getSNSProvider(sNSPlatform).onActivityResult(i, i2, intent);
        }
    }

    public static void setLoginFailHandler(LoginFailHandler loginFailHandler) {
        mLoginFailHandler = loginFailHandler;
    }

    public static void signIn(SNSPlatform sNSPlatform, Activity activity) {
        signIn(sNSPlatform, activity, null);
    }

    public static void signOut(SNSPlatform sNSPlatform) {
        if (SNSProviderFactory.getInstance().getSNSProvider(sNSPlatform) != null) {
            SNSProviderFactory.getInstance().getSNSProvider(sNSPlatform).signOut(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void snsTokenUT(RpcResponse<LoginReturnData> rpcResponse, String str, String str2) {
        Properties properties = new Properties();
        properties.setProperty("result", str2);
        UserTrackAdapter.sendUT(str, UTConstans.CustomEvent.UT_SNS_LOGIN_RESULT, String.valueOf(rpcResponse != null ? rpcResponse.code : -1), properties);
    }

    public static void toastBusy(String str) {
        if (TextUtils.isEmpty(str)) {
            str = DataProviderFactory.getApplicationContext().getResources().getString(R.string.aliuser_network_error);
        }
        Toast.makeText(DataProviderFactory.getApplicationContext(), str, 0).show();
    }

    public static void uccOAuthLogin(Activity activity, SNSPlatform sNSPlatform) {
        if (activity == null) {
            return;
        }
        isBind = false;
        if (isTaobao(sNSPlatform)) {
            TaobaoSignInHelper.create().uccOAuthLogin(activity);
        }
    }

    public static void auth(SNSPlatform sNSPlatform, Activity activity, SNSSignInListener sNSSignInListener, JSONObject jSONObject) {
        if (activity == null) {
            return;
        }
        isBind = false;
        if (SNSProviderFactory.getInstance().getSNSProvider(sNSPlatform) != null) {
            SNSProviderFactory.getInstance().getSNSProvider(sNSPlatform).auth(activity, sNSSignInListener, jSONObject);
        }
    }

    public static void signIn(SNSPlatform sNSPlatform, Activity activity, Map<String, String> map) {
        if (activity == null) {
            return;
        }
        isBind = false;
        LoginStatus.loginEntrance = null;
        if (SNSProviderFactory.getInstance().getSNSProvider(sNSPlatform) != null) {
            Properties monitorProperties = getMonitorProperties();
            if (map != null) {
                String str = map.get(UTConstant.PageName.UT_KEY_PAGE_NAME);
                if (!TextUtils.isEmpty(str)) {
                    UserTrackAdapter.sendUT(str, UTConstans.CustomEvent.UT_SNS_AUTHCODE_COMMIT, "", UTConstans.convertSnsPlatformToLoginType(sNSPlatform.getPlatform()), monitorProperties);
                } else {
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstans.CustomEvent.UT_SNS_AUTHCODE_COMMIT, "", UTConstans.convertSnsPlatformToLoginType(sNSPlatform.getPlatform()), monitorProperties);
                }
            } else {
                UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstans.CustomEvent.UT_SNS_AUTHCODE_COMMIT, "", UTConstans.convertSnsPlatformToLoginType(sNSPlatform.getPlatform()), monitorProperties);
            }
            SNSProviderFactory.getInstance().getSNSProvider(sNSPlatform).signIn(activity, map);
            return;
        }
        ((SNSService) ServiceFactory.getService(SNSService.class)).toast(activity, ResourceUtil.getStringById("aliuser_SNS_auth_init_failed"));
        BroadCastHelper.sendLoginFailBroadcast(703, "exception");
    }

    public static void invokeError(String str, int i, String str2) {
        if (mListener != null) {
            if (TextUtils.equals(str, WeixinSignInHelper.SNS_TYPE)) {
                mListener.onError(WeixinSignInHelper.getContext(), str, i, str2);
            } else {
                mListener.onError(null, str, i, str2);
            }
        }
    }

    public static void invokeTokenLogin(SNSSignInListener sNSSignInListener, SNSSignInAccount sNSSignInAccount) {
        if (sNSSignInListener != null) {
            if (sNSSignInAccount != null && TextUtils.equals(sNSSignInAccount.snsType, WeixinSignInHelper.SNS_TYPE)) {
                sNSSignInListener.onSucceed(WeixinSignInHelper.getContext(), sNSSignInAccount);
            } else {
                sNSSignInListener.onSucceed(null, sNSSignInAccount);
            }
        }
    }

    public static void init(SNSPlatform sNSPlatform, String str, String str2, String str3) {
        if (mListener == null) {
            mListener = new SNSListenerImpl();
        }
        SNSSignInAbstractHelper sNSSignInAbstractHelper = null;
        if (!isGoogle(sNSPlatform) && !isFacebook(sNSPlatform) && !isTwitter(sNSPlatform) && !isLinkedin(sNSPlatform) && !isLine(sNSPlatform)) {
            if (isQQ(sNSPlatform)) {
                sNSSignInAbstractHelper = QQSignInHelper.create(str, str2);
            } else if (isWeibo(sNSPlatform)) {
                sNSSignInAbstractHelper = WeiboSignInHelper.create(str, str2, str3);
            } else if (isWeixin(sNSPlatform)) {
                sNSSignInAbstractHelper = WeixinSignInHelper.create(str, str2);
            } else if (isTaobao(sNSPlatform)) {
                sNSSignInAbstractHelper = TaobaoSignInHelper.create();
            } else if (isHuawei(sNSPlatform)) {
                sNSSignInAbstractHelper = HuaweiSignInHelper.create();
            } else if (isUC(sNSPlatform)) {
                sNSSignInAbstractHelper = UCSignInHelper.create(str, str3);
            } else if (isWC(sNSPlatform)) {
                sNSSignInAbstractHelper = WCSignInHelper.create(str, str2);
            }
        } else {
            try {
                Class<?> cls = Class.forName("com.taobao.android.sns4android.SNSOverseaAuth");
                ReflectionHelper.invokeMethod(cls, cls.getDeclaredMethod(UCCore.LEGACY_EVENT_INIT, SNSPlatform.class, String.class, String.class, String.class), sNSPlatform, str, str2, str3);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (sNSSignInAbstractHelper != null) {
            sNSSignInAbstractHelper.setSNSSignInListener(mListener);
            SNSProviderFactory.getInstance().putSNSProvider(sNSPlatform, sNSSignInAbstractHelper);
        }
        try {
            WVPluginManager.registerPlugin("aluAccountBindJSBridge", (Class<? extends WVApiPlugin>) AccountBindJSBridge.class);
        } catch (Throwable unused) {
        }
    }

    public static void init(SNSPlatform sNSPlatform, String str, String str2) {
        init(sNSPlatform, str, str2, "");
    }
}
