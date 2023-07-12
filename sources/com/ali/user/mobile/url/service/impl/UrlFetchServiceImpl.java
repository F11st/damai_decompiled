package com.ali.user.mobile.url.service.impl;

import android.text.TextUtils;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.info.AlipayInfo;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.model.DeviceTokenSignParam;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.RpcRequest;
import com.ali.user.mobile.rpc.h5.MtopAccountCenterUrlResponseData;
import com.ali.user.mobile.rpc.h5.MtopCanChangeNickResponseData;
import com.ali.user.mobile.rpc.h5.MtopFoundPasswordResponseData;
import com.ali.user.mobile.security.AlibabaSecurityTokenService;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.RpcService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.url.model.AccountCenterParam;
import com.ali.user.mobile.utils.ResourceUtil;
import com.alibaba.fastjson.JSON;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class UrlFetchServiceImpl {
    private static UrlFetchServiceImpl instance;

    private UrlFetchServiceImpl() {
    }

    private RpcRequest buildBaseRequest(AccountCenterParam accountCenterParam) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.requestSite = accountCenterParam.fromSite;
        rpcRequest.addParam("appKey", DataProviderFactory.getDataProvider().getAppkey());
        rpcRequest.addParam("locale", ResourceUtil.getLocaleStr());
        rpcRequest.addParam("umidToken", AppInfo.getInstance().getUmidToken());
        return rpcRequest;
    }

    private RpcRequest buildNavBySceneRequest(AccountCenterParam accountCenterParam) {
        RpcRequest buildBaseRequest = buildBaseRequest(accountCenterParam);
        buildBaseRequest.API_NAME = ApiConstants.ApiName.GET_URL_WITH_SESSION;
        buildBaseRequest.NEED_ECODE = true;
        buildBaseRequest.NEED_SESSION = true;
        if (accountCenterParam.useSessionDomain) {
            buildBaseRequest.preDomain = DataProviderFactory.getDataProvider().getSessionPreDomain();
            buildBaseRequest.onlineDomain = DataProviderFactory.getDataProvider().getSessionOnlineDomain();
        }
        buildBaseRequest.addParam(ApiConstants.ApiField.APDID, AlipayInfo.getInstance().getApdid());
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("taobao", SecurityGuardManagerWraper.getWUA());
            buildBaseRequest.addParam(ApiConstants.ApiField.RDS_INFO, hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        buildBaseRequest.addParam("scene", accountCenterParam.scene);
        buildBaseRequest.addParam(ApiConstants.ApiField.FROM_SITE, Integer.valueOf(accountCenterParam.fromSite));
        buildBaseRequest.addParam("appVersion", AppInfo.getInstance().getAppVersion());
        buildBaseRequest.addParam("sdkVersion", AppInfo.getInstance().getSdkVersion());
        buildBaseRequest.addParam(ApiConstants.ApiField.TRUST_LOGIN, "true");
        if (DataProviderFactory.getDataProvider().getExternalData() != null) {
            buildBaseRequest.addParam("extraInfo", JSON.toJSONString(DataProviderFactory.getDataProvider().getExternalData()));
        }
        return buildBaseRequest;
    }

    public static UrlFetchServiceImpl getInstance() {
        if (instance == null) {
            instance = new UrlFetchServiceImpl();
        }
        return instance;
    }

    public void checkNickModifiable(RpcRequestCallback rpcRequestCallback) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.CAN_CHANGE_NICK;
        rpcRequest.VERSION = "1.0";
        rpcRequest.NEED_ECODE = true;
        rpcRequest.NEED_SESSION = true;
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(rpcRequest, MtopCanChangeNickResponseData.class, rpcRequestCallback);
    }

    public MtopAccountCenterUrlResponseData foundH5urls(AccountCenterParam accountCenterParam) {
        RpcRequest buildBaseRequest = buildBaseRequest(accountCenterParam);
        buildBaseRequest.API_NAME = ApiConstants.ApiName.GET_HAVANA_ACCOUNT_URL;
        buildBaseRequest.addParam(ApiConstants.ApiField.APDID, AlipayInfo.getInstance().getApdid());
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("taobao", SecurityGuardManagerWraper.getWUA());
            buildBaseRequest.addParam(ApiConstants.ApiField.RDS_INFO, JSON.toJSONString(hashMap));
        } catch (Exception unused) {
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("sdkTraceId", accountCenterParam.traceId);
        if (DataProviderFactory.getDataProvider().getExternalData() != null) {
            hashMap2.putAll(DataProviderFactory.getDataProvider().getExternalData());
        }
        buildBaseRequest.addParam("extraInfo", JSON.toJSONString(hashMap2));
        buildBaseRequest.addParam("scene", accountCenterParam.scene);
        buildBaseRequest.addParam(ApiConstants.ApiField.FROM_SITE, Integer.valueOf(accountCenterParam.fromSite));
        buildBaseRequest.addParam("version", "android:new");
        buildBaseRequest.addParam(ApiConstants.ApiField.TRUST_LOGIN, "true");
        if (!TextUtils.isEmpty(accountCenterParam.userInputName)) {
            buildBaseRequest.addParam(ApiConstants.ApiField.USER_INPUT_NAME, accountCenterParam.userInputName);
        }
        if (!TextUtils.isEmpty(accountCenterParam.havanaId)) {
            buildBaseRequest.addParam("havanaId", accountCenterParam.havanaId);
        }
        return (MtopAccountCenterUrlResponseData) ((RpcService) ServiceFactory.getService(RpcService.class)).post(buildBaseRequest, MtopAccountCenterUrlResponseData.class);
    }

    public MtopFoundPasswordResponseData foundPassword(AccountCenterParam accountCenterParam) {
        RpcRequest buildBaseRequest = buildBaseRequest(accountCenterParam);
        buildBaseRequest.API_NAME = ApiConstants.ApiName.GENERATE_URL;
        buildBaseRequest.addParam("appVersion", AppInfo.getInstance().getAndroidAppVersion());
        buildBaseRequest.addParam("sdkVersion", AppInfo.getInstance().getSdkVersion());
        buildBaseRequest.addParam("deviceTokenKey", accountCenterParam.deviceTokenKey);
        String valueOf = String.valueOf(accountCenterParam.havanaId);
        buildBaseRequest.addParam(ApiConstants.ApiField.HID, valueOf);
        String valueOf2 = String.valueOf(System.currentTimeMillis());
        buildBaseRequest.addParam("timestamp", valueOf2);
        HashMap hashMap = new HashMap();
        hashMap.put("taobao", SecurityGuardManagerWraper.getWUA());
        buildBaseRequest.addParam(ApiConstants.ApiField.WIRELESS_ENVM, JSON.toJSONString(hashMap));
        DeviceTokenSignParam deviceTokenSignParam = new DeviceTokenSignParam();
        if (!TextUtils.isEmpty(DataProviderFactory.getDataProvider().getAppkey())) {
            deviceTokenSignParam.addAppKey(DataProviderFactory.getDataProvider().getAppkey());
        }
        deviceTokenSignParam.addAppVersion(AppInfo.getInstance().getAndroidAppVersion());
        deviceTokenSignParam.addHavanaId(valueOf);
        deviceTokenSignParam.addTimestamp(valueOf2);
        deviceTokenSignParam.addSDKVersion(AppInfo.getInstance().getSdkVersion());
        if (!TextUtils.isEmpty(accountCenterParam.deviceTokenKey)) {
            buildBaseRequest.addParam(ApiConstants.ApiField.LOGIN_SIGN, AlibabaSecurityTokenService.sign(accountCenterParam.deviceTokenKey, deviceTokenSignParam.build()));
        }
        return (MtopFoundPasswordResponseData) ((RpcService) ServiceFactory.getService(RpcService.class)).post(buildBaseRequest, MtopFoundPasswordResponseData.class, accountCenterParam.havanaId);
    }

    public void navBySceneRemote(AccountCenterParam accountCenterParam, RpcRequestCallback rpcRequestCallback) {
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(buildNavBySceneRequest(accountCenterParam), MtopAccountCenterUrlResponseData.class, rpcRequestCallback);
    }
}
