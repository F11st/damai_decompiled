package com.youku.usercenter.passport.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.TextUtils;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.config.Environment;
import com.ali.user.open.core.config.WebViewOption;
import com.ali.user.open.tbauth.callback.LogoutCallback;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.securitybody.ISecurityBodyComponent;
import com.alibaba.wireless.security.open.umid.IUMIDComponent;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.youku.usercenter.passport.Domain;
import com.youku.usercenter.passport.PassportConfig;
import com.youku.usercenter.passport.PassportManager;
import com.youku.usercenter.passport.PassportPreference;
import com.youku.usercenter.passport.statistics.PassportAppMonitor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.kh1;
import tb.m80;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class MiscUtil {
    private static final String TAG = "MiscUtil";

    public static int addAlpha(int i) {
        return Color.argb((Color.alpha(i) * 3) / 4, Color.red(i), Color.green(i), Color.blue(i));
    }

    public static String getAppKey(Context context) {
        try {
            return SecurityGuardManager.getInstance(context).getStaticDataStoreComp().getAppKeyByIndex(0, "");
        } catch (SecException e) {
            Logger.e("ali security get appkey exception! errorCode = " + e.getErrorCode());
            return null;
        } catch (Exception unused) {
            Logger.e("ali security get appkey exception! errorCode = ");
            return null;
        }
    }

    public static Object getField(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = obj.getClass().getDeclaredField(str);
        if (declaredField != null) {
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        }
        return null;
    }

    public static String getHiddenEmail(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split(m80.DINAMIC_PREFIX_AT);
        if (split.length != 2) {
            return "";
        }
        String str2 = split[0];
        if (str2.length() > 3) {
            return ((Object) str2.subSequence(0, 3)) + "***" + m80.DINAMIC_PREFIX_AT + split[1];
        }
        return str;
    }

    public static String getHiddenMobile(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("0086")) {
            return ((Object) str.subSequence(4, 7)) + "*****" + ((Object) str.subSequence(str.length() - 3, str.length()));
        }
        return ((Object) str.subSequence(0, 6)) + "*****" + ((Object) str.subSequence(str.length() - 3, str.length()));
    }

    public static String getSecurityUMID(Context context) {
        try {
            IUMIDComponent uMIDComp = SecurityGuardManager.getInstance(context).getUMIDComp();
            uMIDComp.initUMIDSync(0);
            return uMIDComp.getSecurityToken(0);
        } catch (SecException e) {
            Logger.e("ali security get Token exception! errorCode = " + e.getErrorCode());
            return null;
        } catch (Exception unused) {
            Logger.e("ali security get Token normal exception!");
            return null;
        }
    }

    public static String getSecurityWUA(Context context) {
        try {
            return ((ISecurityBodyComponent) SecurityGuardManager.getInstance(context.getApplicationContext()).getInterface(ISecurityBodyComponent.class)).getSecurityBodyDataEx(null, null, "", null, 4, 0);
        } catch (SecException e) {
            Logger.e("ali security get UA exception! errorCode = " + e.getErrorCode());
            return null;
        } catch (Exception unused) {
            Logger.e("ali security get UA normal exception!");
            return null;
        }
    }

    public static void handleConfig(JSONObject jSONObject) throws Exception {
        long optLong = jSONObject.optLong("ptoken.refresh.interval");
        String optString = jSONObject.optString(PassportPreference.LOGIN_URLS);
        String optString2 = jSONObject.optString(PassportPreference.REGISTER_URLS);
        String optString3 = jSONObject.optString("riskuser.trustdomains");
        boolean optBoolean = jSONObject.optBoolean("tokenExChange");
        String optString4 = jSONObject.optString("thirdPartyLogin");
        PassportConfig config = PassportManager.getInstance().getConfig();
        SharedPreferences.Editor editor = PassportPreference.getInstance(config.mContext).getEditor();
        if (!TextUtils.isEmpty(optString)) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = new JSONArray(optString);
            int i = 0;
            for (int length = jSONArray.length(); i < length; length = length) {
                arrayList.add(jSONArray.optString(i));
                i++;
            }
            if (arrayList.size() > 0) {
                config.mLoginUrls = arrayList;
                editor.putString(PassportPreference.LOGIN_URLS, optString);
            }
        }
        if (!TextUtils.isEmpty(optString2)) {
            ArrayList arrayList2 = new ArrayList();
            JSONArray jSONArray2 = new JSONArray(optString2);
            int length2 = jSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                arrayList2.add(jSONArray2.optString(i2));
            }
            if (arrayList2.size() > 0) {
                config.mRegisterUrls = arrayList2;
                editor.putString(PassportPreference.REGISTER_URLS, optString2);
            }
        }
        if (jSONObject.has("handleBindTaobaoError")) {
            editor.putBoolean(PassportPreference.HANDLE_BIND_TAOBAO_ERROR, jSONObject.getBoolean("handleBindTaobaoError"));
        }
        if (jSONObject.has("otherSwitchBind")) {
            editor.putBoolean(PassportPreference.NEED_SWITCH_BIND_OTHERS, jSONObject.getBoolean("otherSwitchBind"));
        }
        if (jSONObject.has("fingerprint.auth")) {
            boolean z = jSONObject.getBoolean("fingerprint.auth");
            config.mServerFpAuth = z;
            editor.putBoolean(PassportPreference.SERVER_FP_AUTH, z);
        }
        if (jSONObject.has("registerPageProtocolAndUrls")) {
            editor.putString(PassportPreference.REGISTER_PROTOCOLS, jSONObject.getString("registerPageProtocolAndUrls"));
        }
        if (optLong > 0) {
            editor.putLong(PassportPreference.COOKIE_REFRESH_INTERVAL, optLong);
        }
        editor.putString(PassportPreference.TRUST_DOMAINS, optString3);
        editor.putString(PassportPreference.THIRD_PARTY_LOGIN, optString4);
        parseTopNoticeData(jSONObject);
        if (optBoolean) {
            PassportManager.getInstance().getService().yktk4PToken();
        }
        if (jSONObject.has(PassportPreference.ONE_KEY_PROTOCOL_SWITCH)) {
            editor.putBoolean(PassportPreference.ONE_KEY_PROTOCOL_SWITCH, jSONObject.getBoolean(PassportPreference.ONE_KEY_PROTOCOL_SWITCH));
        }
        if (jSONObject.has(PassportPreference.ONE_KEY_SERVICE_SWITCH)) {
            editor.putBoolean(PassportPreference.ONE_KEY_SERVICE_SWITCH, jSONObject.getBoolean(PassportPreference.ONE_KEY_SERVICE_SWITCH));
        }
        if (jSONObject.has(PassportPreference.ONE_KEY_GET_MOBILE_SWITCH)) {
            editor.putBoolean(PassportPreference.ONE_KEY_GET_MOBILE_SWITCH, jSONObject.getBoolean(PassportPreference.ONE_KEY_GET_MOBILE_SWITCH));
        }
        if (jSONObject.has(PassportPreference.JUMP_UPGRADE)) {
            editor.putBoolean(PassportPreference.JUMP_UPGRADE, jSONObject.getBoolean(PassportPreference.JUMP_UPGRADE));
        }
        editor.apply();
    }

    public static void logoutTaobao(LogoutCallback logoutCallback) {
    }

    private static void parseTopNoticeData(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            SharedPreferences.Editor editor = PassportPreference.getInstance(null).getEditor();
            String optString = jSONObject.optString("topNotice");
            if (TextUtils.isEmpty(optString)) {
                editor.putString(PassportPreference.TOP_NOTICE_LOGIN, "");
                editor.putString(PassportPreference.TOP_NOTICE_REGISTER, "");
            } else {
                JSONObject jSONObject2 = new JSONObject(optString);
                JSONArray optJSONArray = jSONObject2.optJSONArray("login");
                JSONArray optJSONArray2 = jSONObject2.optJSONArray("register");
                if (optJSONArray == null) {
                    editor.putString(PassportPreference.TOP_NOTICE_LOGIN, "");
                } else {
                    editor.putString(PassportPreference.TOP_NOTICE_LOGIN, optJSONArray.toString());
                }
                if (optJSONArray2 == null) {
                    editor.putString(PassportPreference.TOP_NOTICE_REGISTER, "");
                } else {
                    editor.putString(PassportPreference.TOP_NOTICE_REGISTER, optJSONArray2.toString());
                }
            }
            editor.apply();
        } catch (JSONException e) {
            AdapterForTLog.loge("TopNotice", "Invalid top notice format: " + e.getMessage());
        } catch (Exception e2) {
            Logger.printStackTrace(e2);
        }
    }

    public static void securityDelete(Context context, String str) {
        try {
            SecurityGuardManager.getInstance(context.getApplicationContext()).getDynamicDataStoreComp().removeString(str);
        } catch (SecException e) {
            Logger.e("ali security delete exception! errorCode = " + e.getErrorCode());
        } catch (Exception unused) {
            Logger.e("ali security delete normal exception!");
        }
        securityDeleteEx(context, str);
    }

    private static void securityDeleteEx(Context context, String str) {
        try {
            SecurityGuardManager.getInstance(context.getApplicationContext()).getDynamicDataStoreComp().removeStringDDpEx(str, 0);
        } catch (SecException e) {
            Logger.e("ali security delete exception! errorCode = " + e.getErrorCode());
        } catch (Exception unused) {
            Logger.e("ali security delete normal exception!");
        }
    }

    public static String securityRead(Context context, String str) {
        String securityReadEx = securityReadEx(context, str);
        if (TextUtils.isEmpty(securityReadEx)) {
            int i = 0;
            try {
                return SecurityGuardManager.getInstance(context.getApplicationContext()).getDynamicDataStoreComp().getString(str);
            } catch (SecException e) {
                i = e.getErrorCode();
                Logger.e("ali security read exception! errorCode = " + i);
                AdapterForTLog.loge("YKLogin.MiscUtil", "securityRead Exception! key = " + str + "reason = " + e.getErrorCode());
                PassportAppMonitor.commitSecurityIOError(kh1.OPERATION_READ, "normal", str, i);
                return null;
            } catch (Exception e2) {
                Logger.e("ali security read normal exception!");
                AdapterForTLog.loge("YKLogin.MiscUtil", "securityRead Exception! key = " + str + "reason = " + e2.getMessage());
                PassportAppMonitor.commitSecurityIOError(kh1.OPERATION_READ, "normal", str, i);
                return null;
            }
        }
        return securityReadEx;
    }

    private static String securityReadEx(Context context, String str) {
        int i = 0;
        try {
            return SecurityGuardManager.getInstance(context.getApplicationContext()).getDynamicDataStoreComp().getStringDDpEx(str, 0);
        } catch (SecException e) {
            i = e.getErrorCode();
            Logger.e("ali security read exception! errorCode = " + i);
            AdapterForTLog.loge("YKLogin.MiscUtil", "securityReadEx Exception! key = " + str + "reason = " + e.getErrorCode());
            PassportAppMonitor.commitSecurityIOError(kh1.OPERATION_READ, "extend", str, i);
            return null;
        } catch (Exception e2) {
            Logger.e("ali security read normal exception!");
            AdapterForTLog.loge("YKLogin.MiscUtil", "securityReadEx Exception! key = " + str + "reason = " + e2.getMessage());
            PassportAppMonitor.commitSecurityIOError(kh1.OPERATION_READ, "extend", str, i);
            return null;
        }
    }

    public static boolean securitySave(Context context, String str, String str2) {
        int i;
        try {
            return securitySaveEx(context.getApplicationContext(), str, str2) || SecurityGuardManager.getInstance(context).getDynamicDataStoreComp().putString(str, str2) == 1;
        } catch (SecException e) {
            i = e.getErrorCode();
            Logger.e("ali security save exception! errorCode = " + i);
            AdapterForTLog.loge("YKLogin.MiscUtil", "securitySave Exception! key = " + str + "reason = " + e.getErrorCode());
            PassportAppMonitor.commitSecurityIOError(kh1.OPERATION_WRITE, "normal", str, i);
            return false;
        } catch (Exception e2) {
            Logger.e("ali security save normal exception!");
            AdapterForTLog.loge("YKLogin.MiscUtil", "securitySave Exception! key = " + str + "reason = " + e2.getMessage());
            i = 0;
            PassportAppMonitor.commitSecurityIOError(kh1.OPERATION_WRITE, "normal", str, i);
            return false;
        }
    }

    private static boolean securitySaveEx(Context context, String str, String str2) {
        try {
            return SecurityGuardManager.getInstance(context).getDynamicDataStoreComp().putStringDDpEx(str, str2, 0);
        } catch (SecException e) {
            Logger.e("securitySaveEx exception! errorCode = " + e.getErrorCode());
            AdapterForTLog.loge("YKLogin.MiscUtil", "securitySaveEx Exception! key = " + str + "reason = " + e.getErrorCode());
            return false;
        } catch (Exception e2) {
            Logger.e("securitySaveEx normal exception!");
            AdapterForTLog.loge("YKLogin.MiscUtil", "securitySaveEx Exception! key = " + str + "reason = " + e2.getMessage());
            return false;
        }
    }

    public static void setUccEnv() {
        Environment environment = Environment.ONLINE;
        Domain domain = PassportManager.getInstance().getConfig().mDomain;
        if (Domain.DOMAIN_PRE.equals(domain)) {
            environment = Environment.PRE;
        } else if (Domain.DOMAIN_TRUNK.equals(domain) || Domain.DOMAIN_TEST.equals(domain)) {
            environment = Environment.TEST;
        }
        AliMemberSDK.setEnvironment(environment);
        ConfigManager.setAppKeyIndex(0, 2);
        ConfigManager.getInstance().setWebViewOption(WebViewOption.SYSTEM);
    }

    public static JSONObject string2JSON(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            String[] split = str.split(str2);
            for (int i = 0; i < split.length; i++) {
                String[] split2 = split[i].split("=");
                jSONObject.put(split2[0], split[i].substring(split2[0].length() + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
