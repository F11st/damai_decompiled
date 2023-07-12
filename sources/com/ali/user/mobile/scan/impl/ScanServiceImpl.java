package com.ali.user.mobile.scan.impl;

import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.RpcRequest;
import com.ali.user.mobile.rpc.login.model.TokenLoginRequest;
import com.ali.user.mobile.scan.model.CommonScanParam;
import com.ali.user.mobile.scan.model.CommonScanResponse;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.RpcService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.ResourceUtil;
import com.alibaba.fastjson.JSON;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class ScanServiceImpl {
    private static ScanServiceImpl instance;

    private void commonScanWithRemoteBizAction(String str, CommonScanParam commonScanParam, RpcRequestCallback rpcRequestCallback) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = str;
        rpcRequest.VERSION = "1.0";
        rpcRequest.NEED_ECODE = true;
        rpcRequest.NEED_SESSION = true;
        rpcRequest.requestSite = commonScanParam.currentSite;
        String str2 = commonScanParam.dailyDomain;
        if (str2 != null) {
            rpcRequest.dailyDomain = str2;
        }
        String str3 = commonScanParam.preDomain;
        if (str3 != null) {
            rpcRequest.preDomain = str3;
        }
        String str4 = commonScanParam.onlineDomain;
        if (str4 != null) {
            rpcRequest.onlineDomain = str4;
        }
        TokenLoginRequest tokenLoginRequest = new TokenLoginRequest();
        tokenLoginRequest.token = commonScanParam.key;
        tokenLoginRequest.hid = commonScanParam.havanaId;
        tokenLoginRequest.locale = ResourceUtil.getLocaleStr();
        tokenLoginRequest.appName = commonScanParam.appName;
        tokenLoginRequest.site = commonScanParam.currentSite;
        tokenLoginRequest.sdkVersion = AppInfo.getInstance().getSdkVersion();
        tokenLoginRequest.ttid = DataProviderFactory.getDataProvider().getTTID();
        tokenLoginRequest.utdid = AppInfo.getInstance().getUtdid();
        tokenLoginRequest.deviceId = DataProviderFactory.getDataProvider().getDeviceId();
        HashMap hashMap = new HashMap();
        tokenLoginRequest.ext = hashMap;
        hashMap.put("youkuNotNeedUpgrade", String.valueOf(commonScanParam.youkuNotNeedUpgrade));
        rpcRequest.addParam("tokenInfo", JSON.toJSONString(tokenLoginRequest));
        rpcRequest.addParam("riskControlInfo", JSON.toJSONString(SecurityGuardManagerWraper.buildWSecurityData()));
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(rpcRequest, CommonScanResponse.class, rpcRequestCallback);
    }

    public static ScanServiceImpl getInstance() {
        if (instance == null) {
            instance = new ScanServiceImpl();
        }
        return instance;
    }

    public void commonCancelWithRemoteBiz(CommonScanParam commonScanParam, RpcRequestCallback rpcRequestCallback) {
        commonScanWithRemoteBizAction(ApiConstants.ApiName.COMMON_CANCEL_QRCODE, commonScanParam, rpcRequestCallback);
    }

    public void commonConfirmWithRemoteBiz(CommonScanParam commonScanParam, RpcRequestCallback rpcRequestCallback) {
        commonScanWithRemoteBizAction(ApiConstants.ApiName.COMMON_CONFIRM_QRCODE, commonScanParam, rpcRequestCallback);
    }

    public void commonScanWithRemoteBiz(CommonScanParam commonScanParam, RpcRequestCallback rpcRequestCallback) {
        commonScanWithRemoteBizAction(ApiConstants.ApiName.COMMON_SCAN_QRCODE, commonScanParam, rpcRequestCallback);
    }
}
