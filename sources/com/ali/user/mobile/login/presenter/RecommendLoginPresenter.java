package com.ali.user.mobile.login.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.login.model.AppLaunchInfoResponseData;
import com.ali.user.mobile.login.service.impl.UserLoginServiceImpl;
import com.ali.user.mobile.login.ui.BaseLoginView;
import com.ali.user.mobile.login.ui.RecommendLoginView;
import com.ali.user.mobile.model.DeviceTokenSignParam;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.rpc.RpcRequest;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.security.AlibabaSecurityTokenService;
import com.ali.user.mobile.service.NumberAuthService;
import com.ali.user.mobile.service.RpcService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.NetworkUtil;
import com.ali.user.mobile.utils.ResourceUtil;
import com.ali.user.mobile.utils.SharedPreferencesUtil;
import com.alibaba.fastjson.JSON;
import com.taobao.login4android.config.LoginSwitch;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class RecommendLoginPresenter extends BaseLoginPresenter {
    protected static final String TAG = "login." + RecommendLoginPresenter.class.getSimpleName();

    public RecommendLoginPresenter(BaseLoginView baseLoginView, LoginParam loginParam) {
        super(baseLoginView, loginParam);
    }

    protected static void buildLoginFlowRequest(LoginParam loginParam, LoginFlowRequest loginFlowRequest) {
        Context applicationContext = DataProviderFactory.getApplicationContext();
        UserLoginServiceImpl.getInstance();
        UserLoginServiceImpl.buildBaseRequest(loginParam, loginFlowRequest);
        loginFlowRequest.mobileNetworkOn = NetworkUtil.checkEnv(applicationContext);
        loginFlowRequest.loginId = loginParam.loginAccount;
        loginFlowRequest.t = System.currentTimeMillis();
        loginFlowRequest.locale = ResourceUtil.getLocaleStr();
        loginFlowRequest.site = 0;
    }

    public static AppLaunchInfoResponseData fireAppLaunchRequest(LoginParam loginParam, HistoryAccount historyAccount) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.API_CALLED_BEFORE_LOGIN_PAGE;
        rpcRequest.VERSION = "1.0";
        rpcRequest.timeoutMilliSecond = 1000;
        AppLaunchRequest appLaunchRequest = new AppLaunchRequest();
        buildLoginFlowRequest(loginParam, appLaunchRequest);
        HashMap hashMap = new HashMap();
        appLaunchRequest.ext = hashMap;
        hashMap.put("lastLoginType", getLastLoginType());
        if (historyAccount != null) {
            appLaunchRequest.deviceTokenKey = historyAccount.tokenKey;
            appLaunchRequest.hid = String.valueOf(historyAccount.userId);
            DeviceTokenSignParam deviceTokenSignParam = new DeviceTokenSignParam();
            if (!TextUtils.isEmpty(DataProviderFactory.getDataProvider().getAppkey())) {
                deviceTokenSignParam.addAppKey(DataProviderFactory.getDataProvider().getAppkey());
            }
            deviceTokenSignParam.addAppVersion(AppInfo.getInstance().getAndroidAppVersion());
            deviceTokenSignParam.addHavanaId(String.valueOf(historyAccount.userId));
            deviceTokenSignParam.addTimestamp(String.valueOf(appLaunchRequest.t));
            deviceTokenSignParam.addSDKVersion(AppInfo.getInstance().getSdkVersion());
            if (!TextUtils.isEmpty(historyAccount.tokenKey)) {
                appLaunchRequest.deviceTokenSign = AlibabaSecurityTokenService.sign(historyAccount.tokenKey, deviceTokenSignParam.build());
            }
        } else {
            appLaunchRequest.firstLogin = true;
        }
        if (ServiceFactory.getService(NumberAuthService.class) != null && ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getAuthInfoMap() != null && LoginSwitch.getSwitch("getloginflow_take_maskmobile", "true")) {
            appLaunchRequest.maskMobile = ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getAuthInfoMap().get("number");
        }
        rpcRequest.addParam("loginInfo", JSON.toJSONString(appLaunchRequest));
        rpcRequest.addParam("riskControlInfo", JSON.toJSONString(UserLoginServiceImpl.getScanFaceWSecurityData()));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("sdkTraceId", loginParam.traceId);
        rpcRequest.addParam("ext", JSON.toJSONString(hashMap2));
        return (AppLaunchInfoResponseData) ((RpcService) ServiceFactory.getService(RpcService.class)).post(rpcRequest, AppLaunchInfoResponseData.class);
    }

    public static String getLastLoginType() {
        String str = (String) SharedPreferencesUtil.getData(DataProviderFactory.getApplicationContext(), "login_type", "");
        return LoginType.ServerLoginType.AlipaySSOLogin.getType().equals(str) ? "alipay" : LoginType.ServerLoginType.PasswordLogin.getType().equals(str) ? "pwd" : LoginType.ServerLoginType.SMSLogin.getType().equals(str) ? "sms" : LoginType.ServerLoginType.FaceLogin.getType().equals(str) ? BaseCellItem.TYPE_FACE : LoginType.ServerLoginType.SimLogin.getType().equals(str) ? "sim" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetLoginFlowError(RpcResponse rpcResponse, String str) {
        BaseLoginView baseLoginView = this.mViewer;
        if (baseLoginView == null || !baseLoginView.isActive()) {
            return;
        }
        this.mViewer.dismissLoading();
        if (rpcResponse != null && rpcResponse.code != 7) {
            onFlowLimitLocked(str);
            return;
        }
        String str2 = rpcResponse != null ? rpcResponse.message : "";
        if (TextUtils.isEmpty(str2)) {
            str2 = ResourceUtil.getStringById("aliuser_network_error");
        }
        this.mViewer.toast(str2, 0);
    }

    public void getLoginFlow() {
        BaseLoginView baseLoginView = this.mViewer;
        if (baseLoginView == null || !baseLoginView.isActive()) {
            return;
        }
        this.mViewer.showLoading();
        getLoginFlowRequest(this.mLoginParam, new RpcRequestCallback() { // from class: com.ali.user.mobile.login.presenter.RecommendLoginPresenter.1
            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onError(RpcResponse rpcResponse) {
                RecommendLoginPresenter.this.mViewer.dismissLoading();
                if (rpcResponse != null && TextUtils.equals(rpcResponse.actionType, ApiConstants.ResultActionType.FORCE_TOAST)) {
                    RecommendLoginPresenter.this.mViewer.toast(rpcResponse.message, 1);
                } else if (rpcResponse != null && "mobileNeedCheck".equals(rpcResponse.codeGroup) && ApiConstants.ResultActionType.TOAST.equals(rpcResponse.actionType)) {
                    RecommendLoginPresenter recommendLoginPresenter = RecommendLoginPresenter.this;
                    ((RecommendLoginView) recommendLoginPresenter.mViewer).onNeedAlert(recommendLoginPresenter.mLoginParam, rpcResponse);
                } else if (rpcResponse != null && "guideH5".equals(rpcResponse.codeGroup)) {
                    RecommendLoginPresenter recommendLoginPresenter2 = RecommendLoginPresenter.this;
                    ((RecommendLoginView) recommendLoginPresenter2.mViewer).onGuideH5(recommendLoginPresenter2.mLoginParam, rpcResponse);
                } else {
                    RecommendLoginPresenter recommendLoginPresenter3 = RecommendLoginPresenter.this;
                    LoginParam loginParam = recommendLoginPresenter3.mLoginParam;
                    recommendLoginPresenter3.onGetLoginFlowError(rpcResponse, loginParam == null ? "" : loginParam.loginAccount);
                }
            }

            /* JADX WARN: Can't wrap try/catch for region: R(11:12|(2:14|(1:67)(9:18|19|(3:23|(3:25|(2:27|28)(1:30)|29)|31)|(3:60|61|(1:63))|33|34|35|36|(2:38|39)(2:41|(2:43|44)(2:45|(2:47|48)(2:49|(2:51|52)(2:53|(2:55|56)(1:57)))))))|68|19|(4:21|23|(0)|31)|(0)|33|34|35|36|(0)(0)) */
            /* JADX WARN: Removed duplicated region for block: B:29:0x0090  */
            /* JADX WARN: Removed duplicated region for block: B:46:0x00f8  */
            /* JADX WARN: Removed duplicated region for block: B:47:0x0104  */
            /* JADX WARN: Removed duplicated region for block: B:63:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onSuccess(com.ali.user.mobile.rpc.RpcResponse r9) {
                /*
                    Method dump skipped, instructions count: 368
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ali.user.mobile.login.presenter.RecommendLoginPresenter.AnonymousClass1.onSuccess(com.ali.user.mobile.rpc.RpcResponse):void");
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSystemError(RpcResponse rpcResponse) {
                RecommendLoginPresenter recommendLoginPresenter = RecommendLoginPresenter.this;
                LoginParam loginParam = recommendLoginPresenter.mLoginParam;
                recommendLoginPresenter.onGetLoginFlowError(rpcResponse, loginParam == null ? "" : loginParam.loginAccount);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getLoginFlowRequest(LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        Map map;
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.GET_LOGIN_FLOW;
        rpcRequest.VERSION = "1.0";
        LoginFlowRequest loginFlowRequest = new LoginFlowRequest();
        buildLoginFlowRequest(loginParam, loginFlowRequest);
        UserLoginServiceImpl.addExt(loginFlowRequest);
        rpcRequest.addParam("loginInfo", JSON.toJSONString(loginFlowRequest));
        rpcRequest.addParam("riskControlInfo", JSON.toJSONString(UserLoginServiceImpl.getScanFaceWSecurityData()));
        Map hashMap = new HashMap();
        if (loginParam != null && (map = loginParam.externParams) != null) {
            hashMap = map;
        }
        hashMap.put("sdkTraceId", loginParam.traceId);
        if (ServiceFactory.getService(NumberAuthService.class) != null && ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getAuthInfoMap() != null && LoginSwitch.getSwitch("getloginflow_take_maskmobile", "true")) {
            String str = ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getAuthInfoMap().get("number");
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("maskMobile", str);
            }
        }
        if (LoginSwitch.getSwitch("isRecommendNotOpenFace", "true")) {
            hashMap.put("isRecommendNotOpenFace", "true");
        }
        rpcRequest.addParam("ext", JSON.toJSONString(hashMap));
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(rpcRequest, LoginFlowResponseData.class, rpcRequestCallback);
    }

    protected void onFlowLimitLocked(String str) {
        ((RecommendLoginView) this.mViewer).onFlowLimitLocked(str);
    }
}
