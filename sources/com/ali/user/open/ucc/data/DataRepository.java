package com.ali.user.open.ucc.data;

import android.text.TextUtils;
import android.webkit.CookieManager;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.Site;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.device.DeviceInfo;
import com.ali.user.open.core.model.RpcRequest;
import com.ali.user.open.core.model.RpcRequestCallbackWithCode;
import com.ali.user.open.core.service.RpcService;
import com.ali.user.open.core.service.StorageService;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.core.util.JSONUtils;
import com.ali.user.open.core.util.RiskControlInfoContext;
import com.ali.user.open.core.util.SystemUtils;
import com.ali.user.open.device.DeviceTokenAccount;
import com.ali.user.open.device.DeviceTokenManager;
import com.ali.user.open.history.AccountHistoryManager;
import com.ali.user.open.history.HistoryAccount;
import com.ali.user.open.oauth.OauthService;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.ali.user.open.ucc.context.UccContext;
import com.ali.user.open.ucc.data.ApiConstants;
import com.ali.user.open.ucc.model.ApplyTokenRequest;
import com.ali.user.open.ucc.model.FetchBindPageUrlResult;
import com.ali.user.open.ucc.model.MLoginTokenReturnValue;
import com.ali.user.open.ucc.model.UccParams;
import com.ali.user.open.ucc.util.UccConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DataRepository {
    private static void addAuthrizationRequestObject(UccParams uccParams, RpcRequest rpcRequest) {
        AuthorizationRequest authorizationRequest = new AuthorizationRequest();
        authorizationRequest.appName = ((StorageService) AliMemberSDK.getService(StorageService.class)).getAppKey();
        authorizationRequest.appVersion = CommonUtils.getAndroidAppVersion();
        authorizationRequest.utdid = DeviceInfo.deviceId;
        authorizationRequest.sdkVersion = KernelContext.getSdkVersion();
        authorizationRequest.deviceName = Build.getMODEL();
        authorizationRequest.locale = DeviceInfo.getLocale(KernelContext.applicationContext);
        authorizationRequest.localSite = uccParams.site;
        authorizationRequest.userToken = uccParams.userToken;
        authorizationRequest.targetSite = uccParams.bindSite;
        authorizationRequest.scene = uccParams.scene;
        HashMap hashMap = new HashMap();
        authorizationRequest.ext = hashMap;
        CommonUtils.addExt(hashMap);
        if (Site.ICBU.equals(uccParams.bindSite)) {
            HashMap hashMap2 = new HashMap();
            try {
                CookieManager.getInstance().setAcceptCookie(true);
                String cookie = CookieManager.getInstance().getCookie(".alibaba.com");
                if (!TextUtils.isEmpty(cookie)) {
                    String[] split = cookie.split(";");
                    if (cookie.length() > 0) {
                        HashMap hashMap3 = new HashMap();
                        for (String str : split) {
                            String trim = str.trim();
                            if (!TextUtils.isEmpty(trim) && trim.contains("=")) {
                                int indexOf = trim.indexOf("=");
                                String substring = trim.substring(0, indexOf);
                                String substring2 = trim.substring(indexOf + 1);
                                if ("xman_us_f".equals(substring) || "xman_t".equals(substring) || "xman_f".equals(substring) || "intl_common_forever".equals(substring) || "acs_usuc_t".equals(substring)) {
                                    hashMap3.put(substring, substring2);
                                }
                            }
                        }
                        hashMap2.put("alibaba.com", hashMap3);
                        hashMap.put("clientCookies", JSON.toJSONString(hashMap2));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        rpcRequest.addParam("authorizationRequest", JSON.toJSONString(authorizationRequest));
    }

    public static void applyToken(String str, Map<String, String> map, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "com.taobao.mtop.mLoginTokenService.applySsoToken";
        rpcRequest.version = "1.1";
        rpcRequest.NEED_ECODE = true;
        rpcRequest.NEED_SESSION = true;
        ApplyTokenRequest applyTokenRequest = new ApplyTokenRequest();
        applyTokenRequest.appName = ((StorageService) AliMemberSDK.getService(StorageService.class)).getAppKey();
        applyTokenRequest.site = Site.getHavanaSite(str);
        applyTokenRequest.t = System.currentTimeMillis();
        applyTokenRequest.sdkVersion = KernelContext.sdkVersion;
        if (map == null) {
            map = new HashMap<>();
        }
        rpcRequest.addParam("ext", JSON.toJSONString(map));
        rpcRequest.addParam("request", JSON.toJSONString(applyTokenRequest));
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, MLoginTokenReturnValue.class, rpcRequestCallbackWithCode);
    }

    public static void bindAfterRecommend(UccParams uccParams, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = ApiConstants.ApiName.BIND_H5_AUTH;
        rpcRequest.version = "1.0";
        JSONObject jSONObject = new JSONObject();
        try {
            buildBaseParam(uccParams, jSONObject);
            jSONObject.put("requestToken", uccParams.requestToken);
            jSONObject.put("bindUserToken", uccParams.bindUserToken);
            if (!TextUtils.isEmpty(uccParams.needUpgrade)) {
                jSONObject.put(ApiConstants.ApiField.BIND_NEED_UPGRADE, uccParams.needUpgrade);
            }
            jSONObject.put("miniAppId", uccParams.miniAppId);
            jSONObject.put("sdkTraceId", uccParams.traceId);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        rpcRequest.addParam("request", jSONObject.toString());
        rpcRequest.addParam("riskControlInfo", RiskControlInfoContext.buildRiskControlInfo());
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, String.class, rpcRequestCallbackWithCode);
    }

    public static void bindAlipay(String str, String str2, String str3, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "mtop.alibaba.havana.tbmpc.thirdPart.bindAlipay";
        rpcRequest.version = "1.0";
        rpcRequest.NEED_ECODE = true;
        rpcRequest.NEED_SESSION = true;
        rpcRequest.addParam("alipayAuthCode", str);
        rpcRequest.addParam(UccConstants.PARAM_REALM, str3);
        rpcRequest.addParam("bizcode", str2);
        rpcRequest.addParam("appKey", ((StorageService) AliMemberSDK.getService(StorageService.class)).getAppKey());
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, String.class, rpcRequestCallbackWithCode);
    }

    public static void bindByNativeAuth(UccParams uccParams, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = ApiConstants.ApiName.BIND_NATIVE_AUTH;
        rpcRequest.version = "1.0";
        JSONObject jSONObject = new JSONObject();
        try {
            buildBaseParam(uccParams, jSONObject);
            jSONObject.put("site", uccParams.site);
            jSONObject.put("scene", uccParams.scene);
            jSONObject.put("userToken", uccParams.userToken);
            jSONObject.put("bindSite", uccParams.bindSite);
            jSONObject.put("bindUserToken", uccParams.bindUserToken);
            jSONObject.put("bindUserTokenType", uccParams.bindUserTokenType);
            jSONObject.put(ApiConstants.ApiField.CREATE_BIND_SITE_SESSION, uccParams.createBindSiteSession);
            jSONObject.put("miniAppId", uccParams.miniAppId);
            jSONObject.put("sdkTraceId", uccParams.traceId);
            if (UccContext.getBizParams() != null) {
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<String, String> entry : UccContext.getBizParams().entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("ext", jSONObject2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rpcRequest.addParam("request", jSONObject.toString());
        rpcRequest.addParam("riskControlInfo", RiskControlInfoContext.buildRiskControlInfo());
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, String.class, rpcRequestCallbackWithCode);
    }

    public static void bindByRequestToken(UccParams uccParams, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = ApiConstants.ApiName.BIND_BY_REQUEST_TOKEN;
        rpcRequest.version = "1.0";
        JSONObject jSONObject = new JSONObject();
        try {
            buildBaseParam(uccParams, jSONObject);
            jSONObject.put("site", uccParams.site);
            jSONObject.put("scene", uccParams.scene);
            jSONObject.put("requestToken", uccParams.requestToken);
            jSONObject.put("bindSite", uccParams.bindSite);
            jSONObject.put("bindUserToken", uccParams.bindUserToken);
            jSONObject.put("bindUserTokenType", uccParams.bindUserTokenType);
            jSONObject.put(ApiConstants.ApiField.CREATE_BIND_SITE_SESSION, uccParams.createBindSiteSession);
            jSONObject.put("miniAppId", uccParams.miniAppId);
            jSONObject.put("sdkTraceId", uccParams.traceId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rpcRequest.addParam("request", jSONObject.toString());
        rpcRequest.addParam("riskControlInfo", RiskControlInfoContext.buildRiskControlInfo());
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, String.class, rpcRequestCallbackWithCode);
    }

    public static void bindIdentify(UccParams uccParams, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = ApiConstants.ApiName.BIND_IDENTIFY;
        rpcRequest.version = "1.0";
        JSONObject jSONObject = new JSONObject();
        try {
            buildBaseParam(uccParams, jSONObject);
            jSONObject.put("requestToken", uccParams.requestToken);
            jSONObject.put("ivToken", uccParams.ivToken);
            jSONObject.put("bindUserToken", uccParams.bindUserToken);
            jSONObject.put("miniAppId", uccParams.miniAppId);
            jSONObject.put("sdkTraceId", uccParams.traceId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rpcRequest.addParam("request", jSONObject.toString());
        rpcRequest.addParam("riskControlInfo", RiskControlInfoContext.buildRiskControlInfo());
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, String.class, rpcRequestCallbackWithCode);
    }

    public static void buildBaseParam(UccParams uccParams, JSONObject jSONObject) {
        try {
            jSONObject.put("appName", ((StorageService) AliMemberSDK.getService(StorageService.class)).getAppKey());
            jSONObject.put("appVersion", CommonUtils.getAndroidAppVersion());
            jSONObject.put("utdid", DeviceInfo.deviceId);
            jSONObject.put("sdkVersion", TextUtils.isEmpty(uccParams.sdkVersion) ? KernelContext.getSdkVersion() : uccParams.sdkVersion);
            jSONObject.put("deviceName", Build.getMODEL());
            jSONObject.put("locale", DeviceInfo.getLocale(KernelContext.applicationContext));
        } catch (Throwable unused) {
        }
    }

    public static void changeBind(UccParams uccParams, String str, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = ApiConstants.ApiName.CHANGE_BIND;
        rpcRequest.version = "1.0";
        JSONObject jSONObject = new JSONObject();
        try {
            buildBaseParam(uccParams, jSONObject);
            jSONObject.put("requestToken", str);
            jSONObject.put("miniAppId", uccParams.miniAppId);
            jSONObject.put("sdkTraceId", uccParams.traceId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rpcRequest.addParam("request", jSONObject.toString());
        rpcRequest.addParam("riskControlInfo", RiskControlInfoContext.buildRiskControlInfo());
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, String.class, rpcRequestCallbackWithCode);
    }

    public static void fetchBindPageUrl(UccParams uccParams, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = ApiConstants.ApiName.FETCH_AUTH_URL;
        rpcRequest.version = "1.0";
        JSONObject jSONObject = new JSONObject();
        try {
            buildBaseParam(uccParams, jSONObject);
            jSONObject.put("site", uccParams.site);
            jSONObject.put("userToken", uccParams.userToken);
            jSONObject.put("bindSite", uccParams.bindSite);
            jSONObject.put("scene", uccParams.scene);
            jSONObject.put(ApiConstants.ApiField.CREATE_BIND_SITE_SESSION, uccParams.createBindSiteSession);
            jSONObject.put("miniAppId", uccParams.miniAppId);
            jSONObject.put("sdkTraceId", uccParams.traceId);
            if (UccContext.getBizParams() != null) {
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<String, String> entry : UccContext.getBizParams().entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("ext", jSONObject2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rpcRequest.addParam("request", jSONObject.toString());
        rpcRequest.addParam("riskControlInfo", RiskControlInfoContext.buildRiskControlInfo());
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, FetchBindPageUrlResult.class, rpcRequestCallbackWithCode);
    }

    public static void fetchNewBindPageUrl(UccParams uccParams, String str, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "mtop.alibaba.ucc.localauthurl.get.bytoken";
        rpcRequest.version = "1.0";
        JSONObject jSONObject = new JSONObject();
        try {
            buildBaseParam(uccParams, jSONObject);
            jSONObject.put("site", uccParams.site);
            jSONObject.put("bindUserToken", str);
            jSONObject.put("bindUserTokenType", "IBB");
            jSONObject.put("bindSite", uccParams.bindSite);
            jSONObject.put("scene", uccParams.scene);
            jSONObject.put(ApiConstants.ApiField.CREATE_BIND_SITE_SESSION, uccParams.createBindSiteSession);
            jSONObject.put("sdkTraceId", uccParams.traceId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rpcRequest.addParam("request", jSONObject.toString());
        rpcRequest.addParam("riskControlInfo", RiskControlInfoContext.buildRiskControlInfo());
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, FetchBindPageUrlResult.class, rpcRequestCallbackWithCode);
    }

    public static void fetchNewUser(UccParams uccParams, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = ApiConstants.ApiName.LEAD_NEW_USER;
        rpcRequest.version = "1.0";
        JSONObject jSONObject = new JSONObject();
        try {
            buildBaseParam(uccParams, jSONObject);
            jSONObject.put(ApiConstants.ApiField.LOCAL_SITE, uccParams.site);
            jSONObject.put("userToken", uccParams.userToken);
            jSONObject.put("targetSite", uccParams.bindSite);
            jSONObject.put("scene", uccParams.scene);
            jSONObject.put("miniAppId", uccParams.miniAppId);
            jSONObject.put("sdkTraceId", uccParams.traceId);
            if (!TextUtils.isEmpty(uccParams.targetPackageName)) {
                jSONObject.put(ApiConstants.ApiField.TARGET_INSTALLED, SystemUtils.isAppsInstalled(KernelContext.getApplicationContext(), uccParams.targetPackageName));
            } else {
                jSONObject.put(ApiConstants.ApiField.TARGET_INSTALLED, ((OauthService) AliMemberSDK.getService(OauthService.class)).isAppAuthSurpport(KernelContext.getApplicationContext(), uccParams.bindSite));
            }
            jSONObject.put("activityId", uccParams.activityId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rpcRequest.addParam("request", jSONObject.toString());
        rpcRequest.addParam("riskControlInfo", RiskControlInfoContext.buildRiskControlInfo());
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, FetchBindPageUrlResult.class, rpcRequestCallbackWithCode);
    }

    public static void fetchNoLoginNewUserUrl(UccParams uccParams, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = ApiConstants.ApiName.LEAD_NEW_USER_NO_LOGIN;
        rpcRequest.version = "1.0";
        JSONObject jSONObject = new JSONObject();
        try {
            buildBaseParam(uccParams, jSONObject);
            jSONObject.put(ApiConstants.ApiField.LOCAL_SITE, uccParams.site);
            jSONObject.put("targetSite", uccParams.bindSite);
            jSONObject.put("scene", uccParams.scene);
            jSONObject.put("miniAppId", uccParams.miniAppId);
            jSONObject.put("sdkTraceId", uccParams.traceId);
            jSONObject.put("mobile", uccParams.maskMobile);
            jSONObject.put("activityId", uccParams.activityId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rpcRequest.addParam("request", jSONObject.toString());
        rpcRequest.addParam("riskControlInfo", RiskControlInfoContext.buildRiskControlInfo());
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, FetchBindPageUrlResult.class, rpcRequestCallbackWithCode);
    }

    private static Map<String, String> getDeviceTokenKey() {
        TreeMap treeMap = new TreeMap();
        DeviceTokenAccount deviceToken = DeviceTokenManager.getInstance().getDeviceToken();
        List<HistoryAccount> historyAccounts = AccountHistoryManager.getInstance().getHistoryAccounts();
        if (deviceToken != null && !TextUtils.isEmpty(deviceToken.tokenKey) && (historyAccounts == null || historyAccounts.size() == 0)) {
            treeMap.put("deviceTokenKey", deviceToken.tokenKey);
            treeMap.put("userId", deviceToken.hid);
        } else if (deviceToken == null && historyAccounts != null && historyAccounts.size() > 0) {
            treeMap.put("deviceTokenKey", historyAccounts.get(0).tokenKey);
            treeMap.put("userId", historyAccounts.get(0).userId);
        } else if (deviceToken != null && !TextUtils.isEmpty(deviceToken.tokenKey) && historyAccounts != null && historyAccounts.size() > 0) {
            if (Long.parseLong(deviceToken.t) < Long.parseLong(historyAccounts.get(0).t)) {
                treeMap.put("deviceTokenKey", historyAccounts.get(0).tokenKey);
                treeMap.put("userId", historyAccounts.get(0).userId);
            } else {
                treeMap.put("deviceTokenKey", deviceToken.tokenKey);
                treeMap.put("userId", deviceToken.hid);
            }
        }
        return treeMap;
    }

    public static void getUserInfo(UccParams uccParams, String str, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = ApiConstants.ApiName.GET_AUTH_INFO;
        rpcRequest.version = "1.0";
        JSONObject jSONObject = new JSONObject();
        try {
            buildBaseParam(uccParams, jSONObject);
            jSONObject.put("bindUserToken", uccParams.bindUserToken);
            jSONObject.put("bindUserTokenType", uccParams.bindUserTokenType);
            jSONObject.put("site", uccParams.site);
            jSONObject.put("userToken", uccParams.userToken);
            jSONObject.put("bindSite", uccParams.bindSite);
            jSONObject.put("miniAppId", uccParams.miniAppId);
            jSONObject.put("scene", uccParams.scene);
            jSONObject.put("sdkTraceId", uccParams.traceId);
            jSONObject.put("callFrom", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rpcRequest.addParam("request", jSONObject.toString());
        rpcRequest.addParam("riskControlInfo", RiskControlInfoContext.buildRiskControlInfo());
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, String.class, rpcRequestCallbackWithCode);
    }

    public static void loginByIVToken(int i, String str, String str2, String str3, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = ApiConstants.ApiName.TOKEN_LOGIN;
        rpcRequest.version = "1.0";
        try {
            JSONObject jSONObject = new JSONObject();
            if (KernelContext.isMini) {
                jSONObject.put("app_id", KernelContext.getApplicationContext().getPackageName() + "|" + SystemUtils.getApkPublicKeyDigest());
            } else {
                jSONObject.put("utdid", ((RpcService) AliMemberSDK.getService(RpcService.class)).getDeviceId());
            }
            jSONObject.put("site", i);
            jSONObject.put("appName", ((StorageService) AliMemberSDK.getService(StorageService.class)).getAppKey());
            jSONObject.put("token", str);
            jSONObject.put("t", "" + System.currentTimeMillis());
            jSONObject.put("scene", str2);
            jSONObject.put("sdkVersion", KernelContext.getSdkVersion());
            jSONObject.put(TbAuthConstants.CLIENT_IP, CommonUtils.getLocalIPAddress());
            try {
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject2.put("aliusersdk_h5querystring", str3);
                }
                if (ConfigManager.getInstance().isMiniProgram()) {
                    jSONObject2.put("sdkPlatform", "baichuanmp");
                }
                jSONObject.put("ext", jSONObject2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            rpcRequest.addParam("tokenInfo", jSONObject);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("umidToken", ((StorageService) AliMemberSDK.getService(StorageService.class)).getUmid());
            rpcRequest.addParam("riskControlInfo", jSONObject3);
            rpcRequest.addParam("ext", JSONUtils.toJsonObject(new HashMap()));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, String.class, rpcRequestCallbackWithCode);
    }

    public static void noActionBind(UccParams uccParams, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = ApiConstants.ApiName.NOACTION_BIND;
        rpcRequest.version = "1.0";
        JSONObject jSONObject = new JSONObject();
        try {
            buildBaseParam(uccParams, jSONObject);
            jSONObject.put("site", uccParams.site);
            jSONObject.put("scene", uccParams.scene);
            jSONObject.put("userToken", uccParams.userToken);
            jSONObject.put("userTokenType", uccParams.userTokenType);
            jSONObject.put("bindSiteNeedTransfer", uccParams.bindSiteNeedTransfer);
            jSONObject.put("bindSite", uccParams.bindSite);
            jSONObject.put("bindSiteUserId", uccParams.bindSiteUserId);
            jSONObject.put("bindUserToken", uccParams.bindUserToken);
            jSONObject.put("bindUserTokenType", uccParams.bindUserTokenType);
            jSONObject.put("miniAppId", uccParams.miniAppId);
            jSONObject.put("sdkTraceId", uccParams.traceId);
            jSONObject.put(ApiConstants.ApiField.CREATE_BIND_SITE_SESSION, uccParams.createBindSiteSession);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rpcRequest.addParam("request", jSONObject.toString());
        rpcRequest.addParam("riskControlInfo", RiskControlInfoContext.buildRiskControlInfo());
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, String.class, rpcRequestCallbackWithCode);
    }

    public static void noActionUnbind(UccParams uccParams, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = ApiConstants.ApiName.NOACTION_UNBIND;
        JSONObject jSONObject = new JSONObject();
        try {
            buildBaseParam(uccParams, jSONObject);
            jSONObject.put("site", uccParams.site);
            jSONObject.put("scene", uccParams.scene);
            jSONObject.put("userToken", uccParams.userToken);
            jSONObject.put("userTokenType", uccParams.userTokenType);
            jSONObject.put("bindSiteNeedTransfer", uccParams.bindSiteNeedTransfer);
            jSONObject.put("bindSite", uccParams.bindSite);
            jSONObject.put("bindSiteUserId", uccParams.bindSiteUserId);
            jSONObject.put("bindUserToken", uccParams.bindUserToken);
            jSONObject.put("bindUserTokenType", uccParams.bindUserTokenType);
            jSONObject.put("miniAppId", uccParams.miniAppId);
            jSONObject.put("sdkTraceId", uccParams.traceId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rpcRequest.addParam("request", jSONObject.toString());
        rpcRequest.addParam("riskControlInfo", RiskControlInfoContext.buildRiskControlInfo());
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, String.class, rpcRequestCallbackWithCode);
    }

    public static void queryBind(UccParams uccParams, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = ApiConstants.ApiName.QUERY_BIND;
        rpcRequest.version = "1.0";
        JSONObject jSONObject = new JSONObject();
        try {
            buildBaseParam(uccParams, jSONObject);
            jSONObject.put("site", uccParams.site);
            jSONObject.put("scene", uccParams.scene);
            jSONObject.put("userToken", uccParams.userToken);
            jSONObject.put("userTokenType", uccParams.userTokenType);
            jSONObject.put("bindSiteNeedTransfer", uccParams.bindSiteNeedTransfer);
            jSONObject.put("bindSite", uccParams.bindSite);
            jSONObject.put("miniAppId", uccParams.miniAppId);
            jSONObject.put("sdkTraceId", uccParams.traceId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rpcRequest.addParam("request", jSONObject.toString());
        rpcRequest.addParam("riskControlInfo", RiskControlInfoContext.buildRiskControlInfo());
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, String.class, rpcRequestCallbackWithCode);
    }

    public static void skipUpgrade(UccParams uccParams, String str, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = ApiConstants.ApiName.SKIP_UPGRADE;
        rpcRequest.version = "1.0";
        JSONObject jSONObject = new JSONObject();
        try {
            buildBaseParam(uccParams, jSONObject);
            jSONObject.put("site", uccParams.site);
            jSONObject.put("userToken", uccParams.userToken);
            jSONObject.put("requestToken", uccParams.requestToken);
            jSONObject.put("bindSite", uccParams.bindSite);
            jSONObject.put("miniAppId", uccParams.miniAppId);
            jSONObject.put("scene", uccParams.scene);
            jSONObject.put(ApiConstants.ApiField.USER_ACTION, uccParams.userAction);
            jSONObject.put("sdkTraceId", uccParams.traceId);
            jSONObject.put(ApiConstants.ApiField.CREATE_BIND_SITE_SESSION, uccParams.createBindSiteSession);
            jSONObject.put("callFrom", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rpcRequest.addParam("request", jSONObject.toString());
        rpcRequest.addParam("riskControlInfo", RiskControlInfoContext.buildRiskControlInfo());
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, String.class, rpcRequestCallbackWithCode);
    }

    public static void tokenLoginAfterBind(String str, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = ApiConstants.ApiName.TOKEN_LOGIN_AFTER_BIND;
        rpcRequest.version = "1.0";
        rpcRequest.addParam("trustLoginToken", str);
        rpcRequest.addParam("riskControlInfo", RiskControlInfoContext.buildRiskControlInfo());
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, String.class, rpcRequestCallbackWithCode);
    }

    public static void trustLogin(UccParams uccParams, Map<String, String> map, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = ApiConstants.ApiName.TRUST_LOGIN;
        rpcRequest.version = "1.0";
        addAuthrizationRequestObject(uccParams, rpcRequest);
        Map<String, String> deviceTokenKey = getDeviceTokenKey();
        if (!TextUtils.isEmpty(deviceTokenKey.get("deviceTokenKey"))) {
            rpcRequest.addParam("deviceTokenKey", deviceTokenKey.get("deviceTokenKey"));
            TreeMap<String, String> treeMap = new TreeMap<>();
            treeMap.put("appKey", ((StorageService) AliMemberSDK.getService(StorageService.class)).getAppKey());
            treeMap.put("appVersion", CommonUtils.getAndroidAppVersion());
            treeMap.put("havanaId", String.valueOf(deviceTokenKey.get("userId")));
            treeMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
            treeMap.put("sdkVersion", KernelContext.getSdkVersion());
            rpcRequest.addParam("deviceTokenSign", ((StorageService) AliMemberSDK.getService(StorageService.class)).signMap(deviceTokenKey.get("deviceTokenKey"), treeMap));
        }
        rpcRequest.addParam("riskControlInfo", RiskControlInfoContext.buildRiskControlInfo());
        if (map != null && map.containsKey("needRefreshToken")) {
            HashMap hashMap = new HashMap();
            hashMap.put("needRefreshToken", map.get("needRefreshToken"));
            rpcRequest.addParam("map", JSONUtils.toJsonObject(hashMap));
        }
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, String.class, rpcRequestCallbackWithCode);
    }

    public static void uccOAuthLogin(UccParams uccParams, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = ApiConstants.ApiName.OAUTH_LOGIN;
        rpcRequest.version = "1.0";
        JSONObject jSONObject = new JSONObject();
        try {
            buildBaseParam(uccParams, jSONObject);
            jSONObject.put("site", uccParams.site);
            jSONObject.put("userToken", uccParams.userToken);
            jSONObject.put("bindSite", uccParams.bindSite);
            jSONObject.put("bindUserToken", uccParams.bindUserToken);
            jSONObject.put("bindUserTokenType", uccParams.bindUserTokenType);
            jSONObject.put("miniAppId", uccParams.miniAppId);
            jSONObject.put("sdkTraceId", uccParams.traceId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rpcRequest.addParam("request", jSONObject.toString());
        rpcRequest.addParam("riskControlInfo", RiskControlInfoContext.buildRiskControlInfo());
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, String.class, rpcRequestCallbackWithCode);
    }

    public static void unbind(UccParams uccParams, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = ApiConstants.ApiName.UNBIND;
        rpcRequest.version = "1.0";
        JSONObject jSONObject = new JSONObject();
        try {
            buildBaseParam(uccParams, jSONObject);
            jSONObject.put("site", uccParams.site);
            jSONObject.put("userToken", uccParams.userToken);
            jSONObject.put("bindSite", uccParams.bindSite);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rpcRequest.addParam("request", jSONObject.toString());
        rpcRequest.addParam("riskControlInfo", RiskControlInfoContext.buildRiskControlInfo());
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, String.class, rpcRequestCallbackWithCode);
    }

    public static void updateGrantAuthorization(UccParams uccParams, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = ApiConstants.ApiName.UPDATE_OAUTH;
        rpcRequest.version = "1.0";
        JSONObject jSONObject = new JSONObject();
        try {
            buildBaseParam(uccParams, jSONObject);
            jSONObject.put("site", uccParams.site);
            jSONObject.put("scene", uccParams.scene);
            jSONObject.put("userToken", uccParams.userToken);
            jSONObject.put("userTokenType", uccParams.userTokenType);
            jSONObject.put("bindSiteNeedTransfer", uccParams.bindSiteNeedTransfer);
            jSONObject.put("bindSite", uccParams.bindSite);
            jSONObject.put("bindSiteUserId", uccParams.bindSiteUserId);
            jSONObject.put(ApiConstants.ApiField.UPDATE_ACTION_TYPE, uccParams.updateActionType);
            if (uccParams.operateType) {
                jSONObject.put(ApiConstants.ApiField.OPERATE_TYPE, "true");
            }
            jSONObject.put("miniAppId", uccParams.miniAppId);
            jSONObject.put("sdkTraceId", uccParams.traceId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rpcRequest.addParam("request", jSONObject.toString());
        rpcRequest.addParam("riskControlInfo", RiskControlInfoContext.buildRiskControlInfo());
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, String.class, rpcRequestCallbackWithCode);
    }

    public static void upgrade(UccParams uccParams, String str, String str2, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "mtop.alibaba.ucc.upgrade.account";
        rpcRequest.version = "1.0";
        JSONObject jSONObject = new JSONObject();
        try {
            buildBaseParam(uccParams, jSONObject);
            jSONObject.put("scene", str);
            jSONObject.put("requestToken", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rpcRequest.addParam("request", jSONObject.toString());
        rpcRequest.addParam("riskControlInfo", RiskControlInfoContext.buildRiskControlInfo());
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, String.class, rpcRequestCallbackWithCode);
    }

    public static void userGrowLogin(String str, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = ApiConstants.ApiName.USER_GROW_LOGIN;
        rpcRequest.version = "1.0";
        rpcRequest.addParam("requestToken", str);
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, String.class, rpcRequestCallbackWithCode);
    }
}
