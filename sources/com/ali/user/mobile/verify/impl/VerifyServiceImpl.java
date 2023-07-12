package com.ali.user.mobile.verify.impl;

import android.text.TextUtils;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.login.service.impl.UserLoginServiceImpl;
import com.ali.user.mobile.model.DeviceTokenSignParam;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.RpcRequest;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.security.AlibabaSecurityTokenService;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.RpcService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.ResourceUtil;
import com.ali.user.mobile.verify.model.BiometricCloseUsers;
import com.ali.user.mobile.verify.model.CloseBiometricApiRequest;
import com.ali.user.mobile.verify.model.CloseBiometricApiResponse;
import com.ali.user.mobile.verify.model.GetVerifyUrlResponse;
import com.ali.user.mobile.verify.model.OpenBiometricApiRequest;
import com.ali.user.mobile.verify.model.OpenBiometricApiResponse;
import com.ali.user.mobile.verify.model.OpenBiometricData;
import com.ali.user.mobile.verify.model.VerifyParam;
import com.ali.user.mobile.verify.model.VerifyTokenConsumedResponse;
import com.alibaba.fastjson.JSON;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class VerifyServiceImpl {
    private static VerifyServiceImpl instance;

    private VerifyServiceImpl() {
    }

    private RpcRequest buildBaseRequest(VerifyParam verifyParam) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.addParam(ApiConstants.ApiField.MEMBER_ID, verifyParam.userId);
        rpcRequest.addParam("actionType", verifyParam.actionType);
        rpcRequest.addParam("umidToken", AppInfo.getInstance().getUmidToken());
        rpcRequest.addParam(ApiConstants.ApiField.FROM_SITE, Integer.valueOf(verifyParam.fromSite));
        rpcRequest.requestSite = verifyParam.fromSite;
        rpcRequest.addParam("locale", ResourceUtil.getLocaleStr());
        return rpcRequest;
    }

    public static VerifyServiceImpl getInstance() {
        if (instance == null) {
            instance = new VerifyServiceImpl();
        }
        return instance;
    }

    public void closeFinger(VerifyParam verifyParam, RpcRequestCallback<Void> rpcRequestCallback) {
        if (rpcRequestCallback == null) {
            return;
        }
        if (verifyParam == null) {
            rpcRequestCallback.onSystemError(new RpcResponse<>());
        }
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.FINGER_CLOSE;
        CloseBiometricApiRequest closeBiometricApiRequest = new CloseBiometricApiRequest();
        closeBiometricApiRequest.requestScene = verifyParam.requestScene;
        closeBiometricApiRequest.site = DataProviderFactory.getDataProvider().getSite();
        closeBiometricApiRequest.appKey = DataProviderFactory.getDataProvider().getAppName();
        closeBiometricApiRequest.closeUsers = new ArrayList();
        if (verifyParam.list != null) {
            for (int i = 0; i < verifyParam.list.size(); i++) {
                BiometricCloseUsers biometricCloseUsers = new BiometricCloseUsers();
                biometricCloseUsers.biometricId = verifyParam.list.get(i).key;
                closeBiometricApiRequest.closeUsers.add(biometricCloseUsers);
            }
        } else {
            BiometricCloseUsers biometricCloseUsers2 = new BiometricCloseUsers();
            biometricCloseUsers2.biometricId = verifyParam.biometricId;
            closeBiometricApiRequest.closeUsers.add(biometricCloseUsers2);
        }
        rpcRequest.addParam("request", JSON.toJSONString(closeBiometricApiRequest));
        rpcRequest.addParam("riskControlInfo", JSON.toJSONString(SecurityGuardManagerWraper.buildWSecurityData()));
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(rpcRequest, CloseBiometricApiResponse.class, rpcRequestCallback);
    }

    public void getIdentityVerificationUrl(VerifyParam verifyParam, RpcRequestCallback rpcRequestCallback) {
        RpcRequest buildBaseRequest = buildBaseRequest(verifyParam);
        buildBaseRequest.API_NAME = ApiConstants.ApiName.IV_VERFIY_URL;
        buildBaseRequest.NEED_ECODE = true;
        buildBaseRequest.NEED_SESSION = true;
        buildBaseRequest.addParam("loginId", verifyParam.loginId);
        buildBaseRequest.addParam("sdkVersion", AppInfo.getInstance().getSdkVersion());
        long currentTimeMillis = System.currentTimeMillis();
        buildBaseRequest.addParam("t", Long.valueOf(currentTimeMillis));
        if (!TextUtils.isEmpty(verifyParam.deviceTokenKey)) {
            buildBaseRequest.addParam("deviceTokenKey", verifyParam.deviceTokenKey);
            DeviceTokenSignParam deviceTokenSignParam = new DeviceTokenSignParam();
            deviceTokenSignParam.addActionType(verifyParam.actionType);
            deviceTokenSignParam.addAppKey(DataProviderFactory.getDataProvider().getAppkey());
            deviceTokenSignParam.addSDKVersion(AppInfo.getInstance().getSdkVersion());
            deviceTokenSignParam.addTimestamp(String.valueOf(currentTimeMillis));
            buildBaseRequest.addParam("deviceTokenSign", AlibabaSecurityTokenService.sign(verifyParam.deviceTokenKey, deviceTokenSignParam.build()));
        }
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(buildBaseRequest, GetVerifyUrlResponse.class, rpcRequestCallback);
    }

    public GetVerifyUrlResponse getNonLoginVerfiyUrl(VerifyParam verifyParam) {
        RpcRequest buildBaseRequest = buildBaseRequest(verifyParam);
        buildBaseRequest.API_NAME = ApiConstants.ApiName.IV_NONLOGIN_VERFIY;
        return (GetVerifyUrlResponse) ((RpcService) ServiceFactory.getService(RpcService.class)).post(buildBaseRequest, GetVerifyUrlResponse.class);
    }

    public VerifyTokenConsumedResponse goNonLoginConsume(VerifyParam verifyParam) {
        RpcRequest buildBaseRequest = buildBaseRequest(verifyParam);
        buildBaseRequest.API_NAME = ApiConstants.ApiName.IV_VERIFY_ENV;
        buildBaseRequest.addParam("riskControlInfo", JSON.toJSONString(UserLoginServiceImpl.getScanFaceWSecurityData()));
        buildBaseRequest.addParam("ivToken", verifyParam.ivToken);
        return (VerifyTokenConsumedResponse) ((RpcService) ServiceFactory.getService(RpcService.class)).post(buildBaseRequest, VerifyTokenConsumedResponse.class);
    }

    public void openFinger(VerifyParam verifyParam, RpcRequestCallback<OpenBiometricData> rpcRequestCallback) {
        if (rpcRequestCallback == null) {
            return;
        }
        if (verifyParam == null) {
            rpcRequestCallback.onSystemError(new RpcResponse<>());
            return;
        }
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.FINGER_OPEN;
        OpenBiometricApiRequest openBiometricApiRequest = new OpenBiometricApiRequest();
        openBiometricApiRequest.requestScene = verifyParam.requestScene;
        openBiometricApiRequest.havanaIvToken = verifyParam.ivToken;
        openBiometricApiRequest.loginToken = verifyParam.loginToken;
        openBiometricApiRequest.appKey = DataProviderFactory.getDataProvider().getAppName();
        openBiometricApiRequest.site = DataProviderFactory.getDataProvider().getSite();
        rpcRequest.addParam("request", JSON.toJSONString(openBiometricApiRequest));
        rpcRequest.addParam("riskControlInfo", JSON.toJSONString(SecurityGuardManagerWraper.buildWSecurityData()));
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(rpcRequest, OpenBiometricApiResponse.class, rpcRequestCallback);
    }
}
