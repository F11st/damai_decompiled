package com.ali.user.open.tbauth.task;

import android.text.TextUtils;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.model.LoginReturnData;
import com.ali.user.open.core.model.RpcRequest;
import com.ali.user.open.core.model.RpcRequestCallbackWithCode;
import com.ali.user.open.core.service.RpcService;
import com.ali.user.open.core.service.StorageService;
import com.ali.user.open.core.service.UserTrackerService;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.core.util.JSONUtils;
import com.ali.user.open.core.util.SystemUtils;
import com.ali.user.open.history.AccountHistoryManager;
import com.ali.user.open.history.HistoryAccount;
import com.ali.user.open.service.impl.SessionManager;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.ali.user.open.tbauth.UTConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import mtopsdk.security.util.SignConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class RpcRepository {
    public static void addKey(Map<String, String> map, String str, String str2) {
        map.put(str, str2);
    }

    public static void getAccessTokenWithAuthCode(String str, String str2, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "mtop.alibaba.ucc.convertAuthCodeToAccessToken";
        rpcRequest.version = "1.0";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appName", ((StorageService) AliMemberSDK.getService(StorageService.class)).getAppKey());
            jSONObject.put(SignConstants.MIDDLE_PARAM_AUTHCODE, str);
            jSONObject.put("site", str2);
            rpcRequest.addParam("convertAccessTokenRequest", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, ConvertAuthCodeToAccessTokenData.class, rpcRequestCallbackWithCode);
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
                    CommonUtils.addExt(jSONObject2);
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
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, LoginReturnData.class, rpcRequestCallbackWithCode);
    }

    public static void loginByRefreshToken(RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        HistoryAccount findHistoryAccount;
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = ApiConstants.ApiName.AUTO_LOGIN;
        rpcRequest.version = "1.0";
        try {
            SessionManager sessionManager = SessionManager.INSTANCE;
            String str = sessionManager.getInternalSession().userId;
            rpcRequest.addParam("userId", Long.valueOf(Long.parseLong(str)));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appName", ((StorageService) AliMemberSDK.getService(StorageService.class)).getAppKey());
            jSONObject.put("token", sessionManager.getInternalSession().autoLoginToken);
            jSONObject.put("sdkVersion", KernelContext.getSdkVersion());
            long currentTimeMillis = System.currentTimeMillis();
            jSONObject.put("t", "" + currentTimeMillis);
            jSONObject.put(TbAuthConstants.CLIENT_IP, CommonUtils.getLocalIPAddress());
            if (KernelContext.isMini) {
                jSONObject.put("app_id", KernelContext.getApplicationContext().getPackageName() + "|" + SystemUtils.getApkPublicKeyDigest());
            } else {
                jSONObject.put("utdid", ((RpcService) AliMemberSDK.getService(RpcService.class)).getDeviceId());
            }
            if (!TextUtils.isEmpty(str) && (findHistoryAccount = AccountHistoryManager.getInstance().findHistoryAccount(str)) != null) {
                String str2 = findHistoryAccount.tokenKey;
                if (!TextUtils.isEmpty(str2)) {
                    TreeMap<String, String> treeMap = new TreeMap<>();
                    addKey(treeMap, "appKey", ((StorageService) AliMemberSDK.getService(StorageService.class)).getAppKey());
                    addKey(treeMap, "havanaId", findHistoryAccount.userId);
                    addKey(treeMap, "timestamp", String.valueOf(currentTimeMillis));
                    addKey(treeMap, "appVersion", CommonUtils.getAndroidAppVersion());
                    addKey(treeMap, "sdkVersion", KernelContext.getSdkVersion());
                    String signMap = ((StorageService) AliMemberSDK.getService(StorageService.class)).signMap(str2, treeMap);
                    if (!TextUtils.isEmpty(signMap)) {
                        jSONObject.put("deviceTokenSign", signMap);
                        jSONObject.put("deviceTokenKey", str2);
                        jSONObject.put(ApiConstants.ApiField.HID, findHistoryAccount.userId);
                    }
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            CommonUtils.addExt(jSONObject2);
            jSONObject.put("ext", jSONObject2);
            rpcRequest.addParam("tokenInfo", jSONObject);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("umidToken", ((StorageService) AliMemberSDK.getService(StorageService.class)).getUmid());
            rpcRequest.addParam("riskControlInfo", jSONObject3);
            rpcRequest.addParam("ext", new JSONObject());
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, LoginReturnData.class, rpcRequestCallbackWithCode);
    }

    public static void logout(String str, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = ApiConstants.ApiName.LOGOUT;
        rpcRequest.version = "1.0";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appKey", ((StorageService) AliMemberSDK.getService(StorageService.class)).getAppKey());
            jSONObject.put("sid", SessionManager.INSTANCE.getInternalSession().sid);
            jSONObject.put(TbAuthConstants.IP, CommonUtils.getLocalIPAddress());
            rpcRequest.addParam("userId", Long.valueOf(Long.parseLong(str)));
            rpcRequest.addParam("request", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, String.class, rpcRequestCallbackWithCode);
    }

    public static void refreshPageAfterOpenTb(String str, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send(UTConstants.E_TOP_TOKEN_LOGIN, null);
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "com.taobao.mtop.mloginService.topTokenLogin";
        rpcRequest.version = "1.0";
        try {
            JSONObject jSONObject = new JSONObject();
            if (KernelContext.isMini) {
                jSONObject.put("app_id", KernelContext.getApplicationContext().getPackageName() + "|" + SystemUtils.getApkPublicKeyDigest());
            } else {
                jSONObject.put("utdid", ((RpcService) AliMemberSDK.getService(RpcService.class)).getDeviceId());
            }
            jSONObject.put("appName", ((StorageService) AliMemberSDK.getService(StorageService.class)).getAppKey());
            jSONObject.put("token", str);
            jSONObject.put("t", "" + System.currentTimeMillis());
            jSONObject.put("sdkVersion", KernelContext.getSdkVersion());
            jSONObject.put(TbAuthConstants.CLIENT_IP, CommonUtils.getLocalIPAddress());
            JSONObject jSONObject2 = new JSONObject();
            CommonUtils.addExt(jSONObject2);
            jSONObject.put("ext", jSONObject2);
            rpcRequest.addParam("tokenInfo", jSONObject);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("umidToken", ((StorageService) AliMemberSDK.getService(StorageService.class)).getUmid());
            rpcRequest.addParam("riskControlInfo", jSONObject3);
            rpcRequest.addParam("ext", new JSONObject());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, LoginReturnData.class, rpcRequestCallbackWithCode);
    }

    public static void validateAuthCode(String str, String str2, String str3, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "mtop.alibaba.ucc.authcodet.validate";
        rpcRequest.version = "1.0";
        rpcRequest.addParam("appKey", ((StorageService) AliMemberSDK.getService(StorageService.class)).getAppKey());
        rpcRequest.addParam(SignConstants.MIDDLE_PARAM_AUTHCODE, str);
        rpcRequest.addParam("site", str2);
        rpcRequest.addParam("targetSite", str3);
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, ConvertAuthCodeToAccessTokenData.class, rpcRequestCallbackWithCode);
    }
}
