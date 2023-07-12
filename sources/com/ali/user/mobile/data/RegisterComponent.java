package com.ali.user.mobile.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.data.model.RegisterUserInfo;
import com.ali.user.mobile.exception.RpcException;
import com.ali.user.mobile.info.AlipayInfo;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.login.service.impl.UserLoginServiceImpl;
import com.ali.user.mobile.model.AliValidRequest;
import com.ali.user.mobile.model.RegistParam;
import com.ali.user.mobile.register.model.BaseRegistRequest;
import com.ali.user.mobile.register.model.MtopRegisterH5ResponseData;
import com.ali.user.mobile.register.model.MtopRegisterInitcontextResponseData;
import com.ali.user.mobile.register.model.OceanRegisterParam;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.RpcRequest;
import com.ali.user.mobile.rpc.login.model.MemberRequestBase;
import com.ali.user.mobile.rpc.login.model.WSecurityData;
import com.ali.user.mobile.rpc.login.model.WUAData;
import com.ali.user.mobile.rpc.register.model.NumAuthFastRegisterResponseData;
import com.ali.user.mobile.rpc.register.model.OceanRegisterResponseData;
import com.ali.user.mobile.rpc.register.model.RegisterRequestBase;
import com.ali.user.mobile.rpc.safe.RSAKey;
import com.ali.user.mobile.rpc.safe.Rsa;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.RpcService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.service.StorageService;
import com.ali.user.mobile.utils.ResourceUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import com.taobao.login4android.config.LoginSwitch;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class RegisterComponent {
    private static RegisterComponent mRegisterComponent;
    private final String TAG = "login.RegisterComponent";

    private RegisterComponent() {
    }

    private void buildBaseParams(MemberRequestBase memberRequestBase) {
        memberRequestBase.appName = DataProviderFactory.getDataProvider().getAppkey();
        memberRequestBase.sdkVersion = AppInfo.getInstance().getSdkVersion();
        memberRequestBase.ttid = DataProviderFactory.getDataProvider().getTTID();
        memberRequestBase.utdid = AppInfo.getInstance().getUtdid();
        memberRequestBase.site = DataProviderFactory.getDataProvider().getSite();
        memberRequestBase.locale = ResourceUtil.getLocaleStr();
    }

    private void encryptPassword(OceanRegisterParam oceanRegisterParam) {
        if (TextUtils.isEmpty(oceanRegisterParam.password)) {
            return;
        }
        try {
            String rsaPubkey = RSAKey.getRsaPubkey();
            if (!TextUtils.isEmpty(rsaPubkey)) {
                String encrypt = Rsa.encrypt(oceanRegisterParam.password, rsaPubkey);
                oceanRegisterParam.password = encrypt;
                TLogAdapter.d("login.RegisterComponent", encrypt);
                return;
            }
            TLogAdapter.e("login.RegisterComponent", "RSAKey == null");
            throw new RpcException("getRsaKeyResult is null");
        } catch (RpcException e) {
            throw new RpcException("get RSA exception===> " + e.getMessage());
        }
    }

    public static RegisterComponent getInstance() {
        if (mRegisterComponent == null) {
            synchronized (RegisterComponent.class) {
                if (mRegisterComponent == null) {
                    mRegisterComponent = new RegisterComponent();
                }
            }
        }
        return mRegisterComponent;
    }

    @NonNull
    private RegisterRequestBase getOceanRegisterMemberRequestBase() {
        RegisterRequestBase registerRequestBase = new RegisterRequestBase();
        registerRequestBase.appName = DataProviderFactory.getDataProvider().getAppkey();
        registerRequestBase.sdkVersion = AppInfo.getInstance().getSdkVersion();
        registerRequestBase.ttid = DataProviderFactory.getDataProvider().getTTID();
        registerRequestBase.utdid = AppInfo.getInstance().getUtdid();
        registerRequestBase.site = DataProviderFactory.getDataProvider().getSite();
        registerRequestBase.locale = ResourceUtil.getLocaleStr();
        return registerRequestBase;
    }

    public RpcRequest buildDirectRegisterRequest(String str, String str2, String str3, Map<String, String> map) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = str;
        rpcRequest.VERSION = "1.0";
        rpcRequest.requestSite = DataProviderFactory.getDataProvider().getSite();
        rpcRequest.addParam(AbstractC3893a.f, JSON.toJSONString(getOceanRegisterMemberRequestBase()));
        rpcRequest.addParam("token", str2);
        rpcRequest.addParam(ApiConstants.ApiField.RISK_INFO, JSON.toJSONString(UserLoginServiceImpl.getScanFaceWSecurityData()));
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("sdkTraceId", str3);
        rpcRequest.addParam("extra", JSON.toJSONString(map));
        return rpcRequest;
    }

    public RpcRequest buildRegisterRpcRequest(RegistParam registParam, OceanRegisterParam oceanRegisterParam) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.API_REGISTER;
        rpcRequest.VERSION = "1.0";
        rpcRequest.requestSite = DataProviderFactory.getDataProvider().getSite();
        RegisterRequestBase oceanRegisterMemberRequestBase = getOceanRegisterMemberRequestBase();
        rpcRequest.addParam(AbstractC3893a.f, JSON.toJSONString(oceanRegisterMemberRequestBase));
        encryptPassword(oceanRegisterParam);
        rpcRequest.addParam("info", JSON.toJSONString(oceanRegisterParam.toInfo()));
        rpcRequest.addParam(ApiConstants.ApiField.RISK_INFO, JSON.toJSONString(UserLoginServiceImpl.getScanFaceWSecurityData()));
        Map map = oceanRegisterParam.externParams;
        if (map == null) {
            map = new HashMap();
        }
        if (registParam != null) {
            if (registParam.userSiteHere) {
                oceanRegisterMemberRequestBase.site = registParam.registSite;
            }
            if (!TextUtils.isEmpty(registParam.registerSiteString)) {
                map.put("registerSite", registParam.registerSiteString);
            }
        }
        if (!TextUtils.isEmpty(oceanRegisterParam.sendType)) {
            map.put("checkAudio", oceanRegisterParam.sendType);
        }
        map.put("sdkTraceId", oceanRegisterParam.traceId);
        if (DataProviderFactory.getDataProvider().getRegisterExternalData("register") != null) {
            map.putAll(DataProviderFactory.getDataProvider().getRegisterExternalData("register"));
        }
        rpcRequest.addParam("extra", JSON.toJSONString(map));
        return rpcRequest;
    }

    public RpcRequest buildSendEmailCodeRequest(OceanRegisterParam oceanRegisterParam) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = "mtop.havana.register.sdk.email.checkcode.send";
        rpcRequest.VERSION = "1.0";
        rpcRequest.requestSite = DataProviderFactory.getDataProvider().getSite();
        rpcRequest.addParam(AbstractC3893a.f, JSON.toJSONString(getOceanRegisterMemberRequestBase()));
        OceanRegisterParam oceanRegisterParam2 = new OceanRegisterParam();
        oceanRegisterParam2.email = oceanRegisterParam.email;
        if (LoginSwitch.isInABTestRegion(LoginSwitch.EMAILCODE_LENGTH, 10000)) {
            oceanRegisterParam2.codeLength = "4";
        } else {
            oceanRegisterParam2.codeLength = "6";
        }
        rpcRequest.addParam("info", JSON.toJSONString(oceanRegisterParam2));
        rpcRequest.addParam(ApiConstants.ApiField.RISK_INFO, JSON.toJSONString(SecurityGuardManagerWraper.buildWSecurityData()));
        Map map = oceanRegisterParam.externParams;
        if (map == null) {
            map = new HashMap();
        }
        if (!TextUtils.isEmpty(oceanRegisterParam.sendType)) {
            map.put("checkAudio", oceanRegisterParam.sendType);
        }
        map.put("sdkTraceId", oceanRegisterParam.traceId);
        rpcRequest.addParam("extra", JSON.toJSONString(map));
        return rpcRequest;
    }

    public RpcRequest buildSendSmsRequest(RegistParam registParam, OceanRegisterParam oceanRegisterParam) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.API_SEND_SMS;
        rpcRequest.VERSION = "1.0";
        rpcRequest.requestSite = DataProviderFactory.getDataProvider().getSite();
        RegisterRequestBase oceanRegisterMemberRequestBase = getOceanRegisterMemberRequestBase();
        rpcRequest.addParam(AbstractC3893a.f, JSON.toJSONString(oceanRegisterMemberRequestBase));
        encryptPassword(oceanRegisterParam);
        OceanRegisterParam info = oceanRegisterParam.toInfo();
        if (!LoginSwitch.isInABTestRegion(LoginSwitch.SMSCODE_LENGTH, -1) && DataProviderFactory.getDataProvider().getSmsLength() != 4) {
            info.codeLength = "6";
        } else {
            info.codeLength = "4";
        }
        rpcRequest.addParam("info", JSON.toJSON(info));
        rpcRequest.addParam(ApiConstants.ApiField.RISK_INFO, JSON.toJSONString(UserLoginServiceImpl.getScanFaceWSecurityData()));
        Map map = oceanRegisterParam.externParams;
        if (map == null) {
            map = new HashMap();
        }
        if (registParam != null) {
            if (registParam.userSiteHere) {
                oceanRegisterMemberRequestBase.site = registParam.registSite;
            }
            if (!TextUtils.isEmpty(registParam.registerSiteString)) {
                map.put("registerSite", registParam.registerSiteString);
            }
        }
        if (!TextUtils.isEmpty(oceanRegisterParam.sendType)) {
            map.put("sendAudio", oceanRegisterParam.sendType);
        }
        if (DataProviderFactory.getDataProvider().getRegisterExternalData("sendSms") != null) {
            map.putAll(DataProviderFactory.getDataProvider().getRegisterExternalData("sendSms"));
        }
        map.put("sdkTraceId", oceanRegisterParam.traceId);
        rpcRequest.addParam("extra", JSON.toJSONString(map));
        return rpcRequest;
    }

    public RpcRequest buildVerifyShopNameRequest(OceanRegisterParam oceanRegisterParam) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.API_NICK_VERIFY;
        rpcRequest.VERSION = "1.0";
        rpcRequest.requestSite = DataProviderFactory.getDataProvider().getSite();
        rpcRequest.addParam(AbstractC3893a.f, JSON.toJSONString(getOceanRegisterMemberRequestBase()));
        OceanRegisterParam oceanRegisterParam2 = new OceanRegisterParam();
        oceanRegisterParam2.nick = oceanRegisterParam.nick;
        rpcRequest.addParam("info", JSON.toJSONString(oceanRegisterParam2.toInfo()));
        rpcRequest.addParam(ApiConstants.ApiField.RISK_INFO, JSON.toJSONString(SecurityGuardManagerWraper.buildWSecurityData()));
        Map map = oceanRegisterParam.externParams;
        if (map == null) {
            map = new HashMap();
        }
        if (!TextUtils.isEmpty(oceanRegisterParam.sendType)) {
            map.put("checkAudio", oceanRegisterParam.sendType);
        }
        map.put("sdkTraceId", oceanRegisterParam.traceId);
        rpcRequest.addParam("extra", JSON.toJSONString(map));
        return rpcRequest;
    }

    public MtopRegisterInitcontextResponseData countryCodeRes(BaseRegistRequest baseRegistRequest) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.REGISTER_INIT;
        rpcRequest.VERSION = "1.0";
        MemberRequestBase memberRequestBase = new MemberRequestBase();
        int i = baseRegistRequest.registSite;
        memberRequestBase.site = i;
        rpcRequest.requestSite = i;
        buildBaseParams(memberRequestBase);
        rpcRequest.addParam("info", JSON.toJSONString(memberRequestBase));
        WSecurityData wSecurityData = new WSecurityData();
        WUAData wua = SecurityGuardManagerWraper.getWUA();
        if (wua != null) {
            wSecurityData.wua = wua.wua;
        }
        wSecurityData.apdId = AlipayInfo.getInstance().getApdid();
        wSecurityData.umidToken = AppInfo.getInstance().getUmidToken();
        rpcRequest.addParam(ApiConstants.ApiField.RISK_INFO, JSON.toJSONString(wSecurityData));
        if (memberRequestBase.ext == null) {
            memberRequestBase.ext = new HashMap();
            if (!TextUtils.isEmpty(baseRegistRequest.regFrom)) {
                memberRequestBase.ext.put("regFrom", baseRegistRequest.regFrom);
            }
        }
        if (DataProviderFactory.getDataProvider().getRegisterExternalData("getCountry") != null) {
            memberRequestBase.ext.putAll(DataProviderFactory.getDataProvider().getRegisterExternalData("getCountry"));
        }
        rpcRequest.addParam("extra", JSON.toJSONString(memberRequestBase.ext));
        return (MtopRegisterInitcontextResponseData) ((RpcService) ServiceFactory.getService(RpcService.class)).post(rpcRequest, MtopRegisterInitcontextResponseData.class);
    }

    public void fastRegister(String str, RegisterUserInfo registerUserInfo, boolean z, RpcRequestCallback rpcRequestCallback) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.API_FAST_REGISTER;
        rpcRequest.VERSION = "1.0";
        RegisterRequestBase oceanRegisterMemberRequestBase = getOceanRegisterMemberRequestBase(null);
        new HashMap().put("ncAppkey", ((StorageService) ServiceFactory.getService(StorageService.class)).getAppKey(0));
        rpcRequest.addParam(AbstractC3893a.f, JSON.toJSONString(oceanRegisterMemberRequestBase));
        rpcRequest.addParam("info", JSON.toJSONString(registerUserInfo));
        rpcRequest.addParam(ApiConstants.ApiField.RISK_INFO, JSON.toJSONString(SecurityGuardManagerWraper.buildWSecurityData()));
        rpcRequest.addParam("token", str);
        HashMap hashMap = new HashMap();
        hashMap.put("isThirdEmail", z + "");
        rpcRequest.addParam("extra", JSON.toJSONString(hashMap));
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(rpcRequest, OceanRegisterResponseData.class, rpcRequestCallback);
    }

    public void getRegisterH5Url(BaseRegistRequest baseRegistRequest, RpcRequestCallback rpcRequestCallback) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.REGISTER_QUERY_REGISTER_LINK;
        rpcRequest.VERSION = "1.0";
        MemberRequestBase memberRequestBase = new MemberRequestBase();
        int i = baseRegistRequest.registSite;
        memberRequestBase.site = i;
        rpcRequest.requestSite = i;
        buildBaseParams(memberRequestBase);
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(baseRegistRequest.regFrom)) {
            hashMap.put("regFrom", baseRegistRequest.regFrom);
        }
        if (DataProviderFactory.getDataProvider().getRegisterExternalData("getRegUrl") != null) {
            hashMap.putAll(DataProviderFactory.getDataProvider().getRegisterExternalData("getRegUrl"));
        }
        memberRequestBase.ext = hashMap;
        rpcRequest.addParam("info", JSON.toJSONString(memberRequestBase));
        rpcRequest.addParam("extra", JSON.toJSONString(hashMap));
        rpcRequest.addParam(ApiConstants.ApiField.RISK_INFO, JSON.toJSONString(SecurityGuardManagerWraper.buildWSecurityData()));
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(rpcRequest, MtopRegisterH5ResponseData.class, rpcRequestCallback);
    }

    public void numAuthRegister(AliValidRequest aliValidRequest, OceanRegisterParam oceanRegisterParam, RpcRequestCallback rpcRequestCallback) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.API_AUTH_NUM_REIGSTER;
        rpcRequest.VERSION = "1.0";
        rpcRequest.addParam("vendorRequest", JSON.toJSONString(aliValidRequest));
        rpcRequest.addParam(AbstractC3893a.f, JSON.toJSONString(getOceanRegisterMemberRequestBase()));
        rpcRequest.addParam(ApiConstants.ApiField.RISK_INFO, JSON.toJSONString(UserLoginServiceImpl.getScanFaceWSecurityData()));
        encryptPassword(oceanRegisterParam);
        rpcRequest.addParam("registerUserInfo", JSON.toJSON(oceanRegisterParam.toInfo()));
        Object obj = oceanRegisterParam.externParams;
        if (obj == null) {
            obj = new HashMap();
        }
        rpcRequest.addParam("map", JSON.toJSONString(obj));
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(rpcRequest, NumAuthFastRegisterResponseData.class, rpcRequestCallback);
    }

    @NonNull
    private RegisterRequestBase getOceanRegisterMemberRequestBase(OceanRegisterParam oceanRegisterParam) {
        RegisterRequestBase registerRequestBase = new RegisterRequestBase();
        registerRequestBase.appName = DataProviderFactory.getDataProvider().getAppkey();
        registerRequestBase.sdkVersion = AppInfo.getInstance().getSdkVersion();
        registerRequestBase.ttid = DataProviderFactory.getDataProvider().getTTID();
        registerRequestBase.utdid = AppInfo.getInstance().getUtdid();
        registerRequestBase.site = DataProviderFactory.getDataProvider().getSite();
        registerRequestBase.locale = ResourceUtil.getLocaleStr();
        return registerRequestBase;
    }

    public RpcRequest buildDirectRegisterRequest(RegistParam registParam, String str) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.API_DIRECT_REGISTER;
        rpcRequest.VERSION = "1.0";
        rpcRequest.requestSite = DataProviderFactory.getDataProvider().getSite();
        RegisterRequestBase oceanRegisterMemberRequestBase = getOceanRegisterMemberRequestBase();
        HashMap hashMap = new HashMap();
        if (registParam != null) {
            if (registParam.userSiteHere) {
                oceanRegisterMemberRequestBase.site = registParam.registSite;
            }
            if (!TextUtils.isEmpty(registParam.registerSiteString)) {
                hashMap.put("registerSite", registParam.registerSiteString);
            }
        }
        if (DataProviderFactory.getDataProvider().getRegisterExternalData("directRegister") != null) {
            hashMap.putAll(DataProviderFactory.getDataProvider().getRegisterExternalData("directRegister"));
        }
        rpcRequest.addParam(AbstractC3893a.f, JSON.toJSONString(oceanRegisterMemberRequestBase));
        rpcRequest.addParam("token", str);
        rpcRequest.addParam(ApiConstants.ApiField.RISK_INFO, JSON.toJSONString(SecurityGuardManagerWraper.buildWSecurityData()));
        rpcRequest.addParam("extra", JSON.toJSONString(hashMap));
        return rpcRequest;
    }
}
