package com.taobao.android.sns4android.rpc;

import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.login.service.impl.UserLoginServiceImpl;
import com.ali.user.mobile.model.SNSSignInAccount;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.RpcRequest;
import com.ali.user.mobile.rpc.login.model.DefaultLoginResponseData;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.RpcService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.ResourceUtil;
import com.alibaba.fastjson.JSON;
import com.taobao.android.sns4android.SnsLoginRequest;
import com.taobao.android.sns4android.model.ExtraCainiaoBindRequest;
import com.taobao.android.sns4android.model.SnsCainiaoBindResult;
import com.taobao.login4android.session.SessionManager;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class SNSDataRepository {
    public static final String TAG = "login.SNSBusiness";
    private static SNSDataRepository instance;

    private SNSDataRepository() {
    }

    public static SNSDataRepository getInstance() {
        if (instance == null) {
            synchronized (SNSDataRepository.class) {
                if (instance == null) {
                    instance = new SNSDataRepository();
                }
            }
        }
        return instance;
    }

    public void newBind(String str, RpcRequestCallback rpcRequestCallback) {
        snsChangeBindCaiNiao("", "", str, "", "", "", rpcRequestCallback);
    }

    public void snsBindCaiNiao(String str, String str2, String str3, RpcRequestCallback rpcRequestCallback) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.SNS_BIND_NEW;
        rpcRequest.VERSION = "1.0";
        SNSBindModel sNSBindModel = new SNSBindModel();
        sNSBindModel.snsPlatform = str;
        sNSBindModel.thirdBindToken = str2;
        sNSBindModel.appName = DataProviderFactory.getDataProvider().getAppkey();
        sNSBindModel.extraBindManageFrom = str3;
        SessionManager sessionManager = SessionManager.getInstance(DataProviderFactory.getApplicationContext());
        if (sessionManager != null) {
            sNSBindModel.hid = sessionManager.getUserId();
        }
        rpcRequest.addParam("extraBindRequest", JSON.toJSONString(sNSBindModel));
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(rpcRequest, SnsCainiaoBindResult.class, rpcRequestCallback);
    }

    public void snsChangeBindCaiNiao(String str, String str2, String str3, String str4, String str5, String str6, RpcRequestCallback rpcRequestCallback) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.SNS_CHANGE_BIND_NEW;
        rpcRequest.VERSION = "1.0";
        ExtraCainiaoBindRequest extraCainiaoBindRequest = new ExtraCainiaoBindRequest();
        extraCainiaoBindRequest.extraBindManageFrom = str4;
        extraCainiaoBindRequest.snsPlatform = str;
        extraCainiaoBindRequest.thirdPartId = str2;
        extraCainiaoBindRequest.headUrl = str5;
        extraCainiaoBindRequest.thirdNick = str6;
        extraCainiaoBindRequest.thirdBindToken = str3;
        rpcRequest.addParam("extraBindRequest", JSON.toJSONString(extraCainiaoBindRequest));
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(rpcRequest, SnsCainiaoBindResult.class, rpcRequestCallback);
    }

    public void snsLogin(SNSSignInAccount sNSSignInAccount, RpcRequestCallback rpcRequestCallback) {
        if (sNSSignInAccount == null) {
            return;
        }
        RpcRequest rpcRequest = new RpcRequest();
        if (DataProviderFactory.getDataProvider().getSite() == 4) {
            rpcRequest.API_NAME = ApiConstants.ApiName.OCEAN_SNS_LOGIN;
            rpcRequest.VERSION = "1.0";
        } else {
            rpcRequest.API_NAME = ApiConstants.ApiName.SNS_LOGIN;
            rpcRequest.VERSION = "1.0";
        }
        SnsLoginRequest snsLoginRequest = new SnsLoginRequest();
        snsLoginRequest.site = DataProviderFactory.getDataProvider().getSite();
        rpcRequest.requestSite = DataProviderFactory.getDataProvider().getSite();
        snsLoginRequest.snsType = sNSSignInAccount.snsType;
        snsLoginRequest.token = sNSSignInAccount.token;
        snsLoginRequest.email = sNSSignInAccount.email;
        snsLoginRequest.firstName = sNSSignInAccount.firstName;
        UserLoginServiceImpl.getInstance();
        UserLoginServiceImpl.buildBaseRequest(null, snsLoginRequest);
        snsLoginRequest.locale = ResourceUtil.getLocaleStr();
        if (DataProviderFactory.getDataProvider().getExternalData() != null) {
            if (snsLoginRequest.ext == null) {
                snsLoginRequest.ext = new HashMap();
            }
            snsLoginRequest.ext.putAll(DataProviderFactory.getDataProvider().getExternalData());
        }
        rpcRequest.addParam(ApiConstants.ApiField.SNS_LOGIN_INFO, JSON.toJSONString(snsLoginRequest));
        rpcRequest.addParam("riskControlInfo", JSON.toJSONString(SecurityGuardManagerWraper.buildWSecurityData()));
        HashMap hashMap = new HashMap();
        hashMap.put(ApiConstants.ApiField.OCEAN_APPKEY, DataProviderFactory.getDataProvider().getOceanAppkey());
        rpcRequest.addParam("ext", JSON.toJSONString(hashMap));
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(rpcRequest, DefaultLoginResponseData.class, rpcRequestCallback);
    }
}
