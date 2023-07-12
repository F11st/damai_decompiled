package com.tencent.connect.auth;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.common.Constants;
import com.tencent.open.b.C7081b;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.C7111a;
import com.tencent.open.utils.C7119g;
import com.tencent.open.utils.C7123k;
import com.tencent.open.utils.C7126m;
import com.tencent.open.web.security.JniInterface;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class QQToken {
    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;
    private static SharedPreferences g;
    private String a;
    private String b;
    private String c;
    private int d = 1;
    private long e = -1;
    private C7111a f;

    public QQToken(String str) {
        this.a = str;
    }

    @TargetApi(11)
    private static synchronized SharedPreferences a() {
        SharedPreferences sharedPreferences;
        synchronized (QQToken.class) {
            if (g == null) {
                g = C7119g.a().getSharedPreferences("token_info_file", 0);
            }
            sharedPreferences = g;
        }
        return sharedPreferences;
    }

    @Deprecated
    private static String b(String str) {
        return Base64.encodeToString(C7126m.j(str), 2);
    }

    @Deprecated
    private static String c(String str) {
        return Base64.encodeToString(C7126m.j(str), 2) + "_spkey";
    }

    public String getAccessToken() {
        return this.b;
    }

    public String getAppId() {
        return this.a;
    }

    public int getAuthSource() {
        return this.d;
    }

    public long getExpireTimeInSecond() {
        return this.e;
    }

    public String getOpenId() {
        return this.c;
    }

    public String getOpenIdWithCache() {
        String openId = getOpenId();
        try {
            if (TextUtils.isEmpty(openId)) {
                JSONObject loadSession = loadSession(this.a);
                if (loadSession != null) {
                    openId = loadSession.getString("openid");
                    if (!TextUtils.isEmpty(openId)) {
                        setOpenId(openId);
                    }
                }
                SLog.i("QQToken", "getOpenId from Session openId = " + openId + " appId = " + this.a);
            } else {
                SLog.i("QQToken", "getOpenId from field openId = " + openId + " appId = " + this.a);
            }
        } catch (Exception e) {
            SLog.i("QQToken", "getLocalOpenIdByAppId " + e.toString());
        }
        return openId;
    }

    public boolean isSessionValid() {
        return this.b != null && System.currentTimeMillis() < this.e;
    }

    public JSONObject loadSession(String str) {
        try {
            if (this.f == null) {
                this.f = new C7111a(C7119g.a());
            }
            return a(str, this.f);
        } catch (Exception e) {
            SLog.i("QQToken", "login loadSession" + e.toString());
            return null;
        }
    }

    public void removeSession(String str) {
        SharedPreferences.Editor edit = a().edit();
        edit.remove(c(str));
        edit.remove(c(str));
        edit.remove(a(str));
        edit.apply();
        SLog.i("QQToken", "removeSession sucess");
    }

    public boolean saveSession(JSONObject jSONObject) {
        try {
            if (this.f == null) {
                this.f = new C7111a(C7119g.a());
            }
            return a(this.a, jSONObject, this.f);
        } catch (Exception e) {
            SLog.i("QQToken", "login saveSession" + e.toString());
            return false;
        }
    }

    public void setAccessToken(String str, String str2) throws NumberFormatException {
        this.b = str;
        this.e = 0L;
        if (str2 != null) {
            this.e = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
        }
    }

    public void setAppId(String str) {
        this.a = str;
    }

    public void setAuthSource(int i) {
        this.d = i;
    }

    public void setOpenId(String str) {
        this.c = str;
        C7081b.a().a(str);
    }

    private static synchronized JSONObject a(String str, C7111a c7111a) {
        String b;
        synchronized (QQToken.class) {
            if (C7119g.a() == null) {
                SLog.i("QQToken", "loadJsonPreference context null");
                return null;
            } else if (str == null) {
                SLog.i("QQToken", "loadJsonPreference prefKey is null");
                return null;
            } else {
                String string = a().getString(a(str), "");
                if (TextUtils.isEmpty(string)) {
                    if (!JniInterface.isJniOk) {
                        C7123k.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 5);
                        JniInterface.loadSo();
                    }
                    if (!JniInterface.isJniOk) {
                        SLog.i("QQToken", "loadJsonPreference jni load fail SECURE_LIB_VERSION=5");
                        return null;
                    }
                    String c = c(str);
                    String string2 = a().getString(c, "");
                    if (TextUtils.isEmpty(string2)) {
                        String b2 = b(str);
                        String string3 = a().getString(b2, "");
                        if (TextUtils.isEmpty(string3)) {
                            SLog.i("QQToken", "loadJsonPreference oldDesValue null");
                            return null;
                        }
                        try {
                            b = JniInterface.d1(string3);
                            if (TextUtils.isEmpty(b)) {
                                SLog.i("QQToken", "loadJsonPreference decodeResult d1 empty");
                                a().edit().remove(b2).apply();
                                return null;
                            }
                            a(str, new JSONObject(b), c7111a);
                            a().edit().remove(b2).apply();
                        } catch (Exception e) {
                            SLog.e("QQToken", "Catch Exception", e);
                            a().edit().remove(b2).apply();
                            return null;
                        }
                    } else {
                        try {
                            b = JniInterface.d2(string2);
                            a(str, new JSONObject(b), c7111a);
                            a().edit().remove(c).apply();
                        } catch (Exception e2) {
                            SLog.e("QQToken", "Catch Exception", e2);
                            a().edit().remove(c).apply();
                            return null;
                        }
                    }
                } else {
                    b = c7111a.b(string);
                }
                try {
                    JSONObject jSONObject = new JSONObject(b);
                    SLog.i("QQToken", "loadJsonPreference sucess");
                    return jSONObject;
                } catch (Exception e3) {
                    SLog.i("QQToken", "loadJsonPreference decode " + e3.toString());
                    return null;
                }
            }
        }
    }

    private static synchronized boolean a(String str, JSONObject jSONObject, C7111a c7111a) {
        synchronized (QQToken.class) {
            if (C7119g.a() == null) {
                SLog.i("QQToken", "saveJsonPreference context null");
                return false;
            } else if (str != null && jSONObject != null) {
                try {
                    String string = jSONObject.getString(Constants.PARAM_EXPIRES_IN);
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put(Constants.PARAM_EXPIRES_TIME, System.currentTimeMillis() + (Long.parseLong(string) * 1000));
                        String a = a(str);
                        String a2 = c7111a.a(jSONObject.toString());
                        if (a.length() > 6 && a2 != null) {
                            a().edit().putString(a, a2).commit();
                            SLog.i("QQToken", "saveJsonPreference sucess");
                            return true;
                        }
                        SLog.i("QQToken", "saveJsonPreference keyEncode or josnEncode null");
                        return false;
                    }
                    SLog.i("QQToken", "expires is null");
                    return false;
                } catch (Exception e) {
                    SLog.e("QQToken", "saveJsonPreference exception:" + e.toString());
                    return false;
                }
            } else {
                SLog.i("QQToken", "saveJsonPreference prefKey or jsonObject null");
                return false;
            }
        }
    }

    private static String a(String str) {
        return Base64.encodeToString(C7126m.j(str), 2) + "_aes_google";
    }
}
