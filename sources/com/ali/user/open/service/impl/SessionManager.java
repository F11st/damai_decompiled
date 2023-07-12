package com.ali.user.open.service.impl;

import android.content.Intent;
import android.text.TextUtils;
import com.ali.user.mobile.register.RegistConstants;
import com.ali.user.open.cookies.CookieManagerService;
import com.ali.user.open.cookies.CookieManagerWrapper;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.Site;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.model.DeviceTokenRO;
import com.ali.user.open.core.model.LoginDataModel;
import com.ali.user.open.core.model.LoginReturnData;
import com.ali.user.open.core.model.ResultCode;
import com.ali.user.open.core.service.RpcService;
import com.ali.user.open.core.service.StorageService;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.core.util.JSONUtils;
import com.ali.user.open.core.util.ReflectionUtils;
import com.ali.user.open.history.AccountHistoryManager;
import com.ali.user.open.history.HistoryAccount;
import com.ali.user.open.service.SessionService;
import com.ali.user.open.session.InternalSession;
import com.ali.user.open.session.Session;
import com.ali.user.open.util.SessionUtils;
import com.alibaba.fastjson.JSON;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.accs.common.Constants;
import com.taobao.login4android.session.constants.SessionConstants;
import com.youku.live.livesdk.preloader.Preloader;
import com.youku.usercenter.passport.util.CookieUtil;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class SessionManager implements SessionService {
    public static final String COOKIE_KEY_STOEKN = "P_sck";
    public static final SessionManager INSTANCE = new SessionManager();
    private static final String TAG = "SessionManager";
    private volatile InternalSession internalSession;
    private volatile Map<String, InternalSession> mIntenalSessions;
    public String internalSessionStoreKey = "internal_session";
    public String internalSessionMapKey = "internal_session_list";

    public SessionManager() {
        CommonUtils.sendUT("init_step_ucc_init_session_module");
        try {
            preInit();
        } catch (Throwable unused) {
            this.internalSession = new InternalSession();
            this.mIntenalSessions = new HashMap();
        }
    }

    private void buildYoukuExt(InternalSession internalSession, Map<String, String> map) {
        if (map == null || internalSession == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(new JSONObject(JSON.toJSONString(map)).optString("youkuExt")).optString("content"));
            JSONObject optJSONObject = jSONObject.optJSONObject("sessionInfo");
            long optLong = optJSONObject.optLong("cookieExpireTime");
            optJSONObject.optString("ptoken");
            String optString = optJSONObject.optString(IRequestConst.STOKEN);
            long optLong2 = optJSONObject.optLong(SessionConstants.LOGIN_TIME);
            optJSONObject.optInt("site");
            JSONObject optJSONObject2 = jSONObject.optJSONObject(Constants.KEY_USER_ID);
            optJSONObject2.optString(CookieUtil.COOKIE_KEY_YKTK);
            String optString2 = optJSONObject2.optString("ytid");
            optJSONObject2.optString("yid");
            optJSONObject2.optString("tid");
            optJSONObject2.optString("uid");
            String optString3 = optJSONObject2.optString("nickname");
            String optString4 = optJSONObject2.optString("avatar");
            optJSONObject2.optString("loginEmail");
            String str = null;
            JSONObject optJSONObject3 = jSONObject.optJSONObject("userProfile");
            if (optJSONObject3 != null) {
                optJSONObject3.optString(RegistConstants.REGION_INFO);
                str = optJSONObject3.optString("mobile");
                optJSONObject3.optBoolean("hasMobile");
                optJSONObject3.optBoolean("isLoginMobile");
                optJSONObject3.optString("maskMobile");
                optJSONObject3.optString("noRegionMobile");
            }
            jSONObject.optJSONObject("sdkCookieInfo");
            JSONArray optJSONArray = jSONObject.optJSONArray("domians");
            for (int i = 0; i < optJSONArray.length(); i++) {
                CookieManagerWrapper cookieManagerWrapper = CookieManagerWrapper.INSTANCE;
                CookieManagerService.getWebViewProxy().setCookie(optJSONArray.getString(i), CookieManagerWrapper.generateCookie(optJSONArray.getString(i), "P_sck", optString, true));
            }
            internalSession.userId = optString2;
            internalSession.avatarUrl = optString4;
            internalSession.mobile = str;
            internalSession.loginTime = optLong2;
            internalSession.sid = optString;
            internalSession.expireIn = adjustSessionExpireTime(optLong, optLong2);
            internalSession.loginTime = optLong2;
            internalSession.nick = optString3;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private Object getServiceInstance(String str, String[] strArr, Object[] objArr) {
        try {
            return ReflectionUtils.newInstance(str, strArr, objArr);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
            return null;
        }
    }

    private void preInit() throws JSONException {
        InternalSession createInternalSession;
        if (AliMemberSDK.getService(StorageService.class) == null) {
            registerStorage();
        }
        String value = ((StorageService) AliMemberSDK.getService(StorageService.class)).getValue("loginEnvironmentIndex", true);
        String valueOf = String.valueOf(KernelContext.getEnvironment().ordinal());
        if (value != null && !value.equals(valueOf)) {
            ((StorageService) AliMemberSDK.getService(StorageService.class)).putValue("loginEnvironmentIndex", valueOf, true);
            ((StorageService) AliMemberSDK.getService(StorageService.class)).removeValue(this.internalSessionStoreKey, true);
            ((StorageService) AliMemberSDK.getService(StorageService.class)).removeValue(this.internalSessionMapKey, true);
            this.internalSession = new InternalSession();
            this.mIntenalSessions = new HashMap();
            return;
        }
        String value2 = ((StorageService) AliMemberSDK.getService(StorageService.class)).getValue(this.internalSessionMapKey, true);
        if (TextUtils.isEmpty(value2)) {
            value2 = ((StorageService) AliMemberSDK.getService(StorageService.class)).getValue(this.internalSessionMapKey, true);
        }
        String value3 = ((StorageService) AliMemberSDK.getService(StorageService.class)).getValue(this.internalSessionStoreKey, true);
        if (TextUtils.isEmpty(value3)) {
            value3 = ((StorageService) AliMemberSDK.getService(StorageService.class)).getValue(this.internalSessionStoreKey, true);
        }
        this.mIntenalSessions = new HashMap();
        if (!TextUtils.isEmpty(value2)) {
            JSONArray jSONArray = null;
            try {
                jSONArray = new JSONArray(value2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                if (!TextUtils.isEmpty(jSONArray.optString(i)) && (createInternalSession = createInternalSession(jSONArray.optString(i))) != null && !TextUtils.isEmpty(createInternalSession.site)) {
                    this.mIntenalSessions.put(createInternalSession.site, createInternalSession);
                }
            }
        }
        if (!TextUtils.isEmpty(value3)) {
            this.internalSession = createInternalSession(value3);
            if (this.internalSession != null) {
                if (!TextUtils.isEmpty(this.internalSession.site)) {
                    this.mIntenalSessions.put(this.internalSession.site, this.internalSession);
                    return;
                } else {
                    this.mIntenalSessions.put("taobao", this.internalSession);
                    return;
                }
            }
            return;
        }
        this.internalSession = new InternalSession();
    }

    private void refreshInternalSession(InternalSession internalSession) {
        this.internalSession = internalSession;
        ((StorageService) AliMemberSDK.getService(StorageService.class)).putValue(this.internalSessionStoreKey, SessionUtils.toInternalSessionJSON(internalSession), true);
        if (this.mIntenalSessions != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, InternalSession> entry : this.mIntenalSessions.entrySet()) {
                InternalSession value = entry.getValue();
                if (value != null) {
                    jSONArray.put(SessionUtils.toInternalSessionJSON(value));
                }
            }
            ((StorageService) AliMemberSDK.getService(StorageService.class)).putValue(this.internalSessionMapKey, jSONArray.toString(), true);
        }
        if (KernelContext.getApplicationContext() != null) {
            Intent intent = new Intent();
            intent.setAction("aliuser_sync_session");
            intent.setPackage(KernelContext.getApplicationContext().getPackageName());
            KernelContext.getApplicationContext().sendBroadcast(intent);
        }
    }

    private void registerStorage() {
        try {
            KernelContext.registerService(new Class[]{StorageService.class}, getServiceInstance("com.ali.user.open.securityguard.SecurityGuardWrapper", null, null), null);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
    }

    public long adjustSessionExpireTime(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return currentTimeMillis > j2 ? j > 0 ? j + (currentTimeMillis - j2) : 86400 + currentTimeMillis : j;
    }

    public InternalSession createInternalSession(String str) {
        return createInternalSession("", str);
    }

    public Set<String> getAllSessionSites() {
        if (this.mIntenalSessions != null) {
            this.mIntenalSessions.keySet();
            return null;
        }
        return null;
    }

    public InternalSession getInternalSession() {
        return this.internalSession;
    }

    @Override // com.ali.user.open.service.SessionService
    public Session getSession() {
        Session session = new Session();
        session.nick = this.internalSession == null ? "" : this.internalSession.nick;
        session.hid = this.internalSession == null ? "" : this.internalSession.userId;
        session.sid = this.internalSession == null ? "" : this.internalSession.sid;
        session.loginTime = this.internalSession == null ? 0L : this.internalSession.loginTime;
        session.expireIn = this.internalSession != null ? this.internalSession.expireIn : 0L;
        session.avatarUrl = this.internalSession == null ? "" : this.internalSession.avatarUrl;
        session.openId = this.internalSession == null ? "" : this.internalSession.openId;
        session.openSid = this.internalSession == null ? "" : this.internalSession.openSid;
        session.topAccessToken = this.internalSession == null ? "" : this.internalSession.topAccessToken;
        session.topAuthCode = this.internalSession == null ? "" : this.internalSession.topAuthCode;
        session.topExpireTime = this.internalSession == null ? "" : this.internalSession.topExpireTime;
        session.bindToken = this.internalSession != null ? this.internalSession.bindToken : "";
        return session;
    }

    public String getSessionData() {
        try {
            return ((StorageService) getServiceInstance("com.ali.user.open.securityguard.SecurityGuardWrapper", null, null)).getValue(this.internalSessionStoreKey, true);
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.ali.user.open.service.SessionService
    public boolean isSessionValid() {
        String str = TAG;
        SDKLogger.d(str, "func isSessionValid");
        if (this.internalSession != null && !TextUtils.isEmpty(this.internalSession.sid)) {
            if (this.internalSession.loginTime != 0 && this.internalSession.expireIn != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("isSessionValid()  ");
                sb.append(System.currentTimeMillis() / 1000 < this.internalSession.expireIn);
                SDKLogger.d(str, sb.toString());
                return System.currentTimeMillis() / 1000 < this.internalSession.expireIn;
            }
            SDKLogger.d(str, "isSessionValid()  loginTime is 0 or expireIn is 0");
            return false;
        }
        SDKLogger.d(str, "isSessionValid()  internalSession is null");
        return false;
    }

    @Override // com.ali.user.open.service.SessionService
    public ResultCode logout(String str) {
        CookieManagerWrapper.INSTANCE.clearCookies(str);
        InternalSession internalSession = new InternalSession();
        if (this.mIntenalSessions != null) {
            this.mIntenalSessions.remove(str);
        }
        refreshInternalSession(internalSession);
        if (!TextUtils.isEmpty(Site.getMtopInstanceTag(str))) {
            ((RpcService) AliMemberSDK.getService(RpcService.class)).logout(Site.getMtopInstanceTag(str));
        }
        return ResultCode.SUCCESS;
    }

    @Override // com.ali.user.open.service.SessionService
    public void refreshCookie(String str, LoginReturnData loginReturnData) {
        if (loginReturnData != null && !TextUtils.isEmpty(loginReturnData.data)) {
            try {
                LoginDataModel loginDataModel = (LoginDataModel) JSONUtils.toPOJO(new JSONObject(loginReturnData.data), LoginDataModel.class);
                String[] strArr = null;
                Map<String, Object> map = loginDataModel.extendAttribute;
                if (map != null) {
                    try {
                        Object obj = map.get(SessionConstants.SSO_DOMAIN_LIST);
                        if (obj != null && (obj instanceof ArrayList)) {
                            strArr = (String[]) ((ArrayList) obj).toArray(new String[0]);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                CookieManagerWrapper.INSTANCE.injectCookie(str, loginDataModel.cookies, strArr);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.ali.user.open.service.SessionService
    public void refreshWhenLogin(String str, LoginReturnData loginReturnData) {
        if (loginReturnData == null || TextUtils.isEmpty(loginReturnData.data)) {
            return;
        }
        InternalSession internalSession = new InternalSession();
        try {
            LoginDataModel loginDataModel = (LoginDataModel) JSONUtils.toPOJO(new JSONObject(loginReturnData.data), LoginDataModel.class);
            internalSession.site = str;
            Map<String, String> map = loginDataModel.loginServiceExt;
            if (map != null && map.containsKey("youkuExt")) {
                buildYoukuExt(internalSession, loginDataModel.loginServiceExt);
            } else {
                internalSession.externalCookies = loginDataModel.externalCookies;
                internalSession.userId = loginDataModel.userId;
                String str2 = loginDataModel.nick;
                if (str2 != null) {
                    try {
                        internalSession.nick = URLDecoder.decode(str2, "UTF-8");
                    } catch (Exception e) {
                        SDKLogger.e(TAG, e.getMessage(), e);
                    }
                }
                internalSession.openId = loginDataModel.openId;
                internalSession.openSid = loginDataModel.openSid;
                internalSession.avatarUrl = loginDataModel.headPicLink;
                internalSession.email = loginDataModel.email;
                DeviceTokenRO deviceTokenRO = loginReturnData.deviceToken;
                if (deviceTokenRO != null) {
                    internalSession.deviceTokenSalt = deviceTokenRO.salt;
                    internalSession.deviceTokenKey = deviceTokenRO.key;
                }
                if (TextUtils.equals(str, "taobao")) {
                    AccountHistoryManager.getInstance().putLoginHistory(new HistoryAccount(loginDataModel.userId, internalSession.deviceTokenKey, loginDataModel.nick, loginDataModel.phone, loginDataModel.email), internalSession.deviceTokenSalt);
                }
                long j = loginDataModel.loginTime;
                internalSession.loginTime = j;
                internalSession.sid = loginDataModel.sid;
                internalSession.expireIn = adjustSessionExpireTime(loginDataModel.expires, j);
                internalSession.mobile = loginDataModel.loginPhone;
                internalSession.loginId = loginReturnData.showLoginId;
                internalSession.autoLoginToken = loginDataModel.autoLoginToken;
                internalSession.topAccessToken = loginDataModel.topAccessToken;
                internalSession.topAuthCode = loginDataModel.topAuthCode;
                internalSession.topExpireTime = loginDataModel.topExpireTime;
                Map<String, Object> map2 = loginDataModel.extendAttribute;
                internalSession.otherInfo = map2;
                String[] strArr = null;
                if (map2 != null) {
                    try {
                        Object obj = map2.get(SessionConstants.SSO_DOMAIN_LIST);
                        if (obj != null && (obj instanceof ArrayList)) {
                            strArr = (String[]) ((ArrayList) obj).toArray(new String[0]);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                CookieManagerWrapper.INSTANCE.injectCookie(str, loginDataModel.cookies, strArr);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        Map<String, String> map3 = loginReturnData.extMap;
        if (map3 != null) {
            internalSession.bindToken = map3.get("bind_token");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("site", str);
        hashMap.put("sid", internalSession.sid);
        CommonUtils.sendUT("ucc_register_to_mtop_site", hashMap);
        if (!TextUtils.isEmpty(Site.getMtopInstanceTag(str)) && TextUtils.equals(KernelContext.getApplicationContext().getPackageName(), CommonUtils.getProcessName(KernelContext.getApplicationContext()))) {
            ((RpcService) AliMemberSDK.getService(RpcService.class)).registerSessionInfo(Site.getMtopInstanceTag(str), internalSession.sid, internalSession.userId);
        }
        SDKLogger.d(Preloader.KEY_SESSION, "session = " + internalSession.toString());
        this.mIntenalSessions.put(str, internalSession);
        refreshInternalSession(internalSession);
    }

    public void reloadSession() {
        try {
            StorageService storageService = (StorageService) getServiceInstance("com.ali.user.open.securityguard.SecurityGuardWrapper", null, null);
            String value = storageService.getValue(this.internalSessionStoreKey, true);
            if (TextUtils.isEmpty(value)) {
                value = storageService.getValue(this.internalSessionStoreKey, true);
            }
            if (TextUtils.isEmpty(value)) {
                return;
            }
            this.internalSession = createInternalSession("taobao", value);
            storageService.putValue(this.internalSessionStoreKey, SessionUtils.toInternalSessionJSON(this.internalSession), true);
            if (this.mIntenalSessions == null) {
                this.mIntenalSessions = new HashMap();
            }
            if (!TextUtils.isEmpty(this.internalSession.site)) {
                this.mIntenalSessions.put(this.internalSession.site, this.internalSession);
            } else {
                this.mIntenalSessions.put("taobao", this.internalSession);
            }
        } catch (Throwable unused) {
        }
    }

    public InternalSession createInternalSession(String str, String str2) {
        InternalSession internalSession = new InternalSession();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            internalSession.sid = JSONUtils.optString(jSONObject, "sid");
            if (TextUtils.isEmpty(str)) {
                internalSession.site = JSONUtils.optString(jSONObject, "site");
            } else {
                internalSession.site = str;
            }
            internalSession.expireIn = JSONUtils.optInteger(jSONObject, "expireIn").intValue();
            internalSession.avatarUrl = JSONUtils.optString(jSONObject, "avatarUrl");
            internalSession.userId = JSONUtils.optString(jSONObject, "userId");
            internalSession.nick = JSONUtils.optString(jSONObject, "nick");
            internalSession.openId = JSONUtils.optString(jSONObject, "openId");
            internalSession.openSid = JSONUtils.optString(jSONObject, "openSid");
            internalSession.deviceTokenKey = JSONUtils.optString(jSONObject, "deviceTokenKey");
            internalSession.deviceTokenSalt = JSONUtils.optString(jSONObject, "deviceTokenSalt");
            if (!TextUtils.isEmpty(internalSession.sid) && !TextUtils.isEmpty(internalSession.userId) && TextUtils.equals(KernelContext.getApplicationContext().getPackageName(), CommonUtils.getProcessName(KernelContext.getApplicationContext()))) {
                if (ConfigManager.getInstance().isRegisterSidToMtopDefault()) {
                    CommonUtils.sendUT("ucc_register_to_mtop");
                    ((RpcService) AliMemberSDK.getService(RpcService.class)).registerSessionInfo(null, internalSession.sid, internalSession.userId);
                } else if (!TextUtils.isEmpty(internalSession.site)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("site", internalSession.site);
                    hashMap.put("sid", internalSession.sid);
                    CommonUtils.sendUT("ucc_register_to_mtop_site", hashMap);
                    if (!TextUtils.isEmpty(Site.getMtopInstanceTag(internalSession.site))) {
                        ((RpcService) AliMemberSDK.getService(RpcService.class)).registerSessionInfo(Site.getMtopInstanceTag(internalSession.site), internalSession.sid, internalSession.userId);
                    }
                }
            }
            internalSession.loginTime = JSONUtils.optLong(jSONObject, SessionConstants.LOGIN_TIME).longValue();
            internalSession.mobile = JSONUtils.optString(jSONObject, "mobile");
            internalSession.loginId = JSONUtils.optString(jSONObject, "loginId");
            internalSession.autoLoginToken = JSONUtils.optString(jSONObject, "autoLoginToken");
            internalSession.topAccessToken = JSONUtils.optString(jSONObject, "topAccessToken");
            internalSession.topExpireTime = JSONUtils.optString(jSONObject, "topExpireTime");
            internalSession.topAuthCode = JSONUtils.optString(jSONObject, "topAuthCode");
            internalSession.otherInfo = JSONUtils.toMap(jSONObject.optJSONObject("otherInfo"));
        } catch (Throwable th) {
            SDKLogger.e(TAG, th.getMessage(), th);
        }
        return internalSession;
    }

    public InternalSession getInternalSession(String str) {
        if (this.mIntenalSessions == null) {
            return null;
        }
        return this.mIntenalSessions.get(str);
    }

    @Override // com.ali.user.open.service.SessionService
    public boolean isSessionValid(String str) {
        String str2 = TAG;
        SDKLogger.d(str2, "func isSessionValid");
        if (this.mIntenalSessions != null && this.mIntenalSessions.get(str) != null && !TextUtils.isEmpty(this.mIntenalSessions.get(str).sid)) {
            InternalSession internalSession = this.mIntenalSessions.get(str);
            if (internalSession.loginTime != 0 && internalSession.expireIn != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("isSessionValid()  ");
                sb.append(System.currentTimeMillis() / 1000 < internalSession.expireIn);
                SDKLogger.d(str2, sb.toString());
                return System.currentTimeMillis() / 1000 < internalSession.expireIn;
            }
            SDKLogger.d(str2, "isSessionValid()  loginTime is 0 or expireIn is 0");
            return false;
        }
        SDKLogger.d(str2, "isSessionValid()  internalSession is null");
        return false;
    }

    public void reloadSession(String str, String str2) {
        try {
            StorageService storageService = (StorageService) getServiceInstance("com.ali.user.open.securityguard.SecurityGuardWrapper", null, null);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.internalSession = createInternalSession(str, str2);
            storageService.putValue(this.internalSessionStoreKey, SessionUtils.toInternalSessionJSON(this.internalSession), true);
            if (this.mIntenalSessions == null) {
                this.mIntenalSessions = new HashMap();
            }
            if (!TextUtils.isEmpty(this.internalSession.site)) {
                this.mIntenalSessions.put(this.internalSession.site, this.internalSession);
            } else {
                this.mIntenalSessions.put("taobao", this.internalSession);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ali.user.open.service.SessionService
    public Session getSession(String str) {
        InternalSession internalSession;
        Session session = new Session();
        if (this.mIntenalSessions != null && (internalSession = this.mIntenalSessions.get(str)) != null) {
            session.nick = internalSession.nick;
            session.hid = internalSession.userId;
            session.sid = internalSession.sid;
            session.loginTime = internalSession.loginTime;
            session.expireIn = internalSession.expireIn;
            session.avatarUrl = internalSession.avatarUrl;
            session.openId = internalSession.openId;
            session.openSid = internalSession.openSid;
            session.topAccessToken = internalSession.topAccessToken;
            session.topAuthCode = internalSession.topAuthCode;
            session.topExpireTime = internalSession.topExpireTime;
            session.bindToken = internalSession.bindToken;
        }
        return session;
    }
}
