package com.ali.user.mobile.base.helper;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.app.init.Debuggable;
import com.ali.user.mobile.coordinator.CoordinatorWrapper;
import com.ali.user.mobile.login.action.LoginResActions;
import com.ali.user.mobile.login.history.LoginHistoryManager;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.AliUserResponseData;
import com.ali.user.mobile.rpc.login.model.DeviceTokenRO;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.rpc.login.model.SessionModel;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.utils.SharedPreferencesUtil;
import com.ali.user.mobile.utils.StringUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.taobao.login4android.broadcast.LoginAction;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.login4android.constants.LoginStatus;
import com.taobao.login4android.log.LoginTLogAdapter;
import com.taobao.login4android.session.ISession;
import com.taobao.login4android.session.SessionManager;
import com.taobao.login4android.session.constants.SessionConstants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class LoginDataHelper {
    public static final String TAG = "login.LoginDataHelper";

    public static long adjustSessionExpireTime(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return currentTimeMillis > j2 ? j > 0 ? j + (currentTimeMillis - j2) : 86400 + currentTimeMillis : j;
    }

    public static void beforeProcessLoginData(boolean z, AliUserResponseData aliUserResponseData, String str) {
        if (LoginStatus.isFromChangeAccount() && z) {
            SessionManager sessionManager = SessionManager.getInstance(DataProviderFactory.getApplicationContext());
            if (aliUserResponseData == null || sessionManager == null || !LoginSwitch.getSwitch(LoginSwitch.NEW_LOGOUT_BROADCAST_SWITCH, "true") || !TextUtils.equals(sessionManager.getUserId(), aliUserResponseData.userId)) {
                HashMap hashMap = new HashMap();
                hashMap.put(LoginConstants.LOGOUT_TYPE, LoginConstants.LogoutType.CHANGE_ACCOUNT.getType());
                hashMap.put("nick", SessionManager.getInstance(DataProviderFactory.getApplicationContext()).getOldNick());
                hashMap.put("uid", SessionManager.getInstance(DataProviderFactory.getApplicationContext()).getOldUserId());
                BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_LOGOUT, false, 0, str, (Map<String, String>) hashMap, "before recover account");
            }
        }
    }

    public static void handleHistory(LoginReturnData loginReturnData, ISession iSession, AliUserResponseData aliUserResponseData, Map<String, String> map) {
        String str;
        String str2 = (map == null || TextUtils.isEmpty(map.get(LoginConstants.LOGIN_TYPE))) ? "" : map.get(LoginConstants.LOGIN_TYPE);
        LoginType.ServerLoginType serverLoginType = LoginType.ServerLoginType.AutoLogin;
        if (!TextUtils.equals(str2, serverLoginType.getType()) && !TextUtils.equals(str2, LoginConstant.LOGIN_TYPE_FINGERPRINT)) {
            SharedPreferencesUtil.saveData(DataProviderFactory.getApplicationContext(), "login_type", str2);
        }
        if (DataProviderFactory.getDataProvider().isYoukuApps()) {
            return;
        }
        DeviceTokenRO deviceTokenRO = loginReturnData.deviceToken;
        String str3 = null;
        if (deviceTokenRO != null) {
            str = deviceTokenRO.key;
            str3 = deviceTokenRO.salt;
        } else {
            str = null;
        }
        int i = loginReturnData.site;
        String str4 = loginReturnData.showLoginId;
        if (TextUtils.isEmpty(str4)) {
            str4 = loginReturnData.taobaoNick;
        }
        String str5 = str4;
        String str6 = loginReturnData.mobile;
        String str7 = aliUserResponseData.headPicLink;
        Long l = loginReturnData.hid;
        long longValue = l == null ? 0L : l.longValue();
        Long l2 = loginReturnData.alipayHid;
        long longValue2 = l2 == null ? 0L : l2.longValue();
        String str8 = aliUserResponseData.autoLoginToken;
        String str9 = str3;
        long j = aliUserResponseData.loginTime;
        if (j <= 0) {
            j = System.currentTimeMillis() / 1000;
        }
        HistoryAccount historyAccount = new HistoryAccount(str5, str6, str7, longValue, longValue2, str8, j, str, loginReturnData.loginType, loginReturnData.taobaoNick, loginReturnData.email, loginReturnData.alipayCrossed, i);
        if (!TextUtils.isEmpty(loginReturnData.accountId)) {
            historyAccount.setAccountId(loginReturnData.accountId);
        }
        Map<String, String> map2 = loginReturnData.extMap;
        if (map2 != null) {
            historyAccount.biometricId = map2.get(SessionConstants.BIOMETRIC);
        }
        historyAccount.setLoginPhone(aliUserResponseData.loginPhone);
        if (aliUserResponseData.loginServiceExt != null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = aliUserResponseData.loginServiceExt.get(LoginConstants.LOGIN_TYPE);
            }
            String str10 = aliUserResponseData.loginServiceExt.get("loginEntrance");
            if (!TextUtils.isEmpty(str10)) {
                SharedPreferencesUtil.saveData(DataProviderFactory.getApplicationContext(), LoginConstant.LOGIN_ENTRANCE, str10);
            }
            if (aliUserResponseData.loginServiceExt.containsKey("hasPwd")) {
                if (TextUtils.equals("true", aliUserResponseData.loginServiceExt.get("hasPwd"))) {
                    historyAccount.hasPwd = 1;
                } else {
                    historyAccount.hasPwd = 0;
                }
            } else {
                historyAccount.hasPwd = -1;
            }
        }
        if (!TextUtils.equals(str2, serverLoginType.getType()) && !TextUtils.equals(str2, LoginConstant.LOGIN_TYPE_FINGERPRINT)) {
            historyAccount.loginType = str2;
            SharedPreferencesUtil.saveData(DataProviderFactory.getApplicationContext(), "login_type", str2);
        }
        if (loginReturnData.deviceToken != null) {
            LoginHistoryManager.getInstance().saveHistory(historyAccount, str9);
        } else if (DataProviderFactory.getDataProvider().isSaveHistoryWithoutSalt()) {
            LoginHistoryManager.getInstance().saveHistoryWithNoSalt(historyAccount);
        } else if (loginReturnData.hid != null) {
            SecurityGuardManagerWraper.updateLoginHistoryIndex(historyAccount);
        }
        SessionModel sessionModel = new SessionModel();
        sessionModel.sid = aliUserResponseData.sid;
        sessionModel.ecode = aliUserResponseData.ecode;
        sessionModel.nick = aliUserResponseData.nick;
        sessionModel.userId = aliUserResponseData.userId;
        sessionModel.email = aliUserResponseData.email;
        sessionModel.havanaId = aliUserResponseData.havanaId;
        sessionModel.alipayHid = aliUserResponseData.alipayHid;
        sessionModel.loginTime = aliUserResponseData.loginTime;
        sessionModel.autoLoginToken = aliUserResponseData.autoLoginToken;
        sessionModel.headPicLink = aliUserResponseData.headPicLink;
        sessionModel.havanaSsoToken = aliUserResponseData.havanaSsoToken;
        sessionModel.havanaSsoTokenExpiredTime = aliUserResponseData.havanaSsoTokenExpiredTime;
        sessionModel.externalCookies = aliUserResponseData.externalCookies;
        sessionModel.cookies = aliUserResponseData.cookies;
        sessionModel.ssoToken = aliUserResponseData.ssoToken;
        sessionModel.expires = aliUserResponseData.expires;
        sessionModel.extendAttribute = aliUserResponseData.extendAttribute;
        sessionModel.loginServiceExt = aliUserResponseData.loginServiceExt;
        sessionModel.site = loginReturnData.site;
        sessionModel.showLoginId = loginReturnData.showLoginId;
        SecurityGuardManagerWraper.putSessionModelToFile(sessionModel);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(27:6|(1:89)(1:10)|11|(1:13)(1:88)|14|(1:18)|(3:80|81|(1:83)(20:84|21|22|(1:24)(1:77)|25|(1:30)|32|33|(2:37|(4:39|40|41|(1:45)))|49|(3:51|(1:53)|54)(1:76)|(1:58)|59|(2:63|64)|67|(1:69)|70|(1:72)(1:75)|73|74))|20|21|22|(0)(0)|25|(2:27|30)|32|33|(3:35|37|(0))|49|(0)(0)|(2:56|58)|59|(3:61|63|64)|67|(0)|70|(0)(0)|73|74) */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d3, code lost:
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00af A[Catch: Exception -> 0x00d3, TryCatch #3 {Exception -> 0x00d3, blocks: (B:31:0x00a0, B:35:0x00b3, B:37:0x00bf, B:40:0x00c6, B:34:0x00af), top: B:92:0x00a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0245  */
    @android.annotation.SuppressLint({"CommitPrefEdits"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void onLoginSuccess(com.ali.user.mobile.rpc.login.model.LoginReturnData r38, com.ali.user.mobile.rpc.login.model.AliUserResponseData r39, com.taobao.login4android.session.SessionManager r40) {
        /*
            Method dump skipped, instructions count: 596
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.user.mobile.base.helper.LoginDataHelper.onLoginSuccess(com.ali.user.mobile.rpc.login.model.LoginReturnData, com.ali.user.mobile.rpc.login.model.AliUserResponseData, com.taobao.login4android.session.SessionManager):void");
    }

    public static boolean processLoginReturnData(boolean z, LoginReturnData loginReturnData) {
        return processLoginReturnData(z, loginReturnData, null, "", null);
    }

    private static void saveCp(String str, String str2, String str3) {
        try {
            if (DataProviderFactory.getDataProvider().isTaobaoApp()) {
                Context applicationContext = DataProviderFactory.getApplicationContext();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", (Object) str);
                jSONObject.put("nick", (Object) StringUtil.dataMasking(str3));
                jSONObject.put("avatar", (Object) str2);
                CPHelper.save(applicationContext, LoginConstant.ACCOUNT, jSONObject.toString());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void sendLoginResultBroadcast(boolean z, String str, String str2, LoginParam loginParam, LoginReturnData loginReturnData, AliUserResponseData aliUserResponseData, String str3, String str4) {
        Map<String, String> map;
        Map<String, String> map2;
        if (z) {
            String str5 = "";
            if (!TextUtils.isEmpty(str)) {
                Intent intent = new Intent(LoginResActions.LOGIN_SUCCESS_ACTION);
                intent.putExtra("nick", str2);
                intent.putExtra("uid", str);
                if (loginParam != null && TokenType.MERGE_ACCOUNT.equals(loginParam.tokenType)) {
                    intent.putExtra("message", TokenType.MERGE_ACCOUNT);
                }
                if (LoginStatus.isFromChangeAccount()) {
                    intent.putExtra(LoginConstants.LOGIN_FROM, LoginConstants.LOGIN_FROM_MULTI_ACCOUNT);
                }
                if (aliUserResponseData != null && (map2 = aliUserResponseData.loginServiceExt) != null) {
                    str5 = map2.get(LoginConstants.LOGIN_TYPE);
                }
                if (TextUtils.isEmpty(str5) && (map = loginReturnData.extMap) != null) {
                    str5 = map.get(LoginConstants.LOGIN_TYPE);
                    if (TextUtils.isEmpty(str5)) {
                        str5 = loginReturnData.extMap.get("rootLoginType");
                    }
                }
                if (TextUtils.isEmpty(str3)) {
                    str3 = str5;
                }
                intent.putExtra(LoginConstants.LOGIN_TYPE, str3);
                intent.putExtra(LoginConstants.LOGIN_ACCOUNT, str4);
                intent.putExtra("serverLoginType", str5);
                BroadCastHelper.sendLocalBroadCast(intent);
                return;
            }
            BroadCastHelper.sendLoginFailBroadcast(LoginResActions.LoginFailCode.LOGIN_DATA_EXCEPTION, "");
            LoginStatus.resetLoginFlag();
        }
    }

    public static SessionModel sessionToModel(ISession iSession) {
        SessionModel sessionModel = new SessionModel();
        sessionModel.sid = iSession.getSid();
        sessionModel.ecode = iSession.getEcode();
        sessionModel.nick = iSession.getNick();
        sessionModel.userId = iSession.getUserId();
        sessionModel.email = iSession.getEmail();
        sessionModel.autoLoginToken = iSession.getLoginToken();
        sessionModel.havanaSsoToken = iSession.getOneTimeToken();
        sessionModel.havanaSsoTokenExpiredTime = iSession.getHavanaSsoTokenExpiredTime();
        sessionModel.ssoToken = iSession.getSsoToken();
        sessionModel.expires = iSession.getSessionExpiredTime();
        if (!TextUtils.isEmpty(iSession.getExtJson())) {
            try {
                sessionModel.loginServiceExt = (Map) JSON.parseObject(iSession.getExtJson(), new TypeReference<Map<String, String>>() { // from class: com.ali.user.mobile.base.helper.LoginDataHelper.1
                }, new Feature[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        sessionModel.site = iSession.getLoginSite();
        String email = iSession.getEmail();
        sessionModel.showLoginId = email;
        if (TextUtils.isEmpty(email)) {
            sessionModel.showLoginId = iSession.getNick();
        }
        return sessionModel;
    }

    public static boolean processLoginReturnData(boolean z, LoginReturnData loginReturnData, String str) {
        return processLoginReturnData(z, loginReturnData, null, "", null);
    }

    public static boolean processLoginReturnData(boolean z, LoginReturnData loginReturnData, Map<String, String> map) {
        return processLoginReturnData(z, loginReturnData, null, "", map);
    }

    public static boolean processLoginReturnData(boolean z, LoginReturnData loginReturnData, LoginParam loginParam, String str, Map<String, String> map) {
        if (loginReturnData != null && loginReturnData.data != null) {
            if (LoginSwitch.getSwitch("login_data_async2", "true")) {
                new CoordinatorWrapper().execute(new LoginDataHelperTask(z, loginReturnData, loginParam, str, map), new Object[0]);
                return true;
            }
            if (Debuggable.isDebug()) {
                LoginTLogAdapter.d(TAG, "LoginResponse Data=" + loginReturnData.data);
            }
            try {
                AliUserResponseData aliUserResponseData = (AliUserResponseData) JSON.parseObject(loginReturnData.data, AliUserResponseData.class);
                beforeProcessLoginData(z, aliUserResponseData, str);
                SessionManager sessionManager = SessionManager.getInstance(DataProviderFactory.getApplicationContext());
                onLoginSuccess(loginReturnData, aliUserResponseData, sessionManager);
                handleHistory(loginReturnData, sessionManager, aliUserResponseData, map);
                sendLoginResultBroadcast(z, aliUserResponseData.userId, aliUserResponseData.nick, loginParam, loginReturnData, aliUserResponseData, (map == null || TextUtils.isEmpty(map.get(LoginConstants.LOGIN_TYPE))) ? "" : map.get(LoginConstants.LOGIN_TYPE), (map == null || TextUtils.isEmpty(map.get(LoginConstants.LOGIN_ACCOUNT))) ? "" : map.get(LoginConstants.LOGIN_ACCOUNT));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void onLoginSuccess(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse) {
        LoginReturnData loginReturnData;
        if (rpcResponse == null || (loginReturnData = rpcResponse.returnValue) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(loginParam.snsType)) {
            hashMap.put(LoginConstants.LOGIN_TYPE, loginParam.snsType);
        } else if (TextUtils.equals(loginParam.tokenType, TokenType.FIND_PWD)) {
            hashMap.put(LoginConstants.LOGIN_TYPE, TokenType.FIND_PWD);
        } else if (!TextUtils.isEmpty(loginParam.nativeLoginType)) {
            hashMap.put(LoginConstants.LOGIN_TYPE, loginParam.nativeLoginType);
        } else if (!TextUtils.isEmpty(loginReturnData.extMap.get(LoginConstants.LOGIN_TYPE))) {
            hashMap.put(LoginConstants.LOGIN_TYPE, loginReturnData.extMap.get(LoginConstants.LOGIN_TYPE));
        }
        if (!TextUtils.isEmpty(loginParam.loginAccount)) {
            hashMap.put(LoginConstants.LOGIN_ACCOUNT, loginParam.loginAccount);
        }
        processLoginReturnData(true, loginReturnData, (Map<String, String>) hashMap);
    }
}
