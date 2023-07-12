package com.youku.usercenter.passport;

import android.content.Context;
import android.content.SharedPreferences;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.youku.passport.libs.LoginRecord;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class PassportPreference {
    public static final String CONFIG_DATA_MD5 = "config_data_md5";
    public static final String COOKIE_REFRESH_INTERVAL = "cookie_refresh_interval";
    public static final String COOKIE_REFRESH_TIME = "cookie_refresh_time";
    public static final long DEFAULT_COOKIE_REFRESH_TIME = 10;
    private static final String ENCRYPTED_YTID = "encrypted_yt_id";
    public static final String HANDLE_BIND_TAOBAO_ERROR = "handle_bind_taobao_error";
    public static final String JUMP_UPGRADE = "showJumpUpgrade";
    private static final String LAST_LOGIN_RECORD = "last_login_record";
    private static final String LAST_UTDID = "last_utdid";
    public static final String LOGIN_TYPE = "login_type";
    public static final String LOGIN_URLS = "login_urls";
    private static final String LOGIN_UTDID = "login_utdid";
    public static final String MTOP_SWITCH_SERVER = "mtop_switch_server";
    public static final String NEED_SWITCH_BIND_OTHERS = "other_switch_bind";
    private static final String OLD_LOGIN_UTDID = "old_login_utdid";
    public static final String ONE_KEY_GET_MOBILE_SWITCH = "oneKeyGetMobileSwitch";
    public static final String ONE_KEY_PROTOCOL_SWITCH = "oneKeyProtocolSwitch";
    public static final String ONE_KEY_SERVICE_SWITCH = "oneKeyServiceSwitch";
    private static final String PASSPORT_PREFERENCE = "passport_preference";
    public static final String REGISTER_PROTOCOLS = "register_protocols";
    public static final String REGISTER_URLS = "register_urls";
    public static final String SERVER_FP_AUTH = "server_fp_auth";
    public static final String SERVER_SYNC_TIME = "server_sync_time";
    public static final String SERVER_TIME = "server_time";
    public static final String THIRD_PARTY_LOGIN = "third_party_login";
    public static final String TOP_NOTICE_LOGIN = "topnotice_login";
    public static final String TOP_NOTICE_REGISTER = "topnotice_register";
    public static final String TRUST_DOMAINS = "trust_domains";
    private static PassportPreference sInstance;
    private SharedPreferences mPreference;

    private PassportPreference(Context context) {
        this.mPreference = context.getSharedPreferences(PASSPORT_PREFERENCE, 0);
    }

    public static synchronized PassportPreference getInstance(Context context) {
        PassportPreference passportPreference;
        synchronized (PassportPreference.class) {
            if (sInstance == null) {
                sInstance = new PassportPreference(context);
            }
            passportPreference = sInstance;
        }
        return passportPreference;
    }

    public String getConfigDataMd5() {
        return this.mPreference.getString(CONFIG_DATA_MD5, "");
    }

    public long getCookieRefreshInterval() {
        return this.mPreference.getLong(COOKIE_REFRESH_INTERVAL, 864000000L);
    }

    public long getCookieRefreshTime() {
        return this.mPreference.getLong(COOKIE_REFRESH_TIME, 0L);
    }

    public SharedPreferences.Editor getEditor() {
        return this.mPreference.edit();
    }

    public String getEncryptedYtid() {
        return this.mPreference.getString(ENCRYPTED_YTID, "");
    }

    public String getLastUtdid() {
        return this.mPreference.getString(LAST_UTDID, "");
    }

    public LoginRecord getLoginRecord() {
        return (LoginRecord) JSON.parseObject(this.mPreference.getString(LAST_LOGIN_RECORD, ""), new TypeReference<LoginRecord>() { // from class: com.youku.usercenter.passport.PassportPreference.1
        }, new Feature[0]);
    }

    public String getLoginType() {
        return this.mPreference.getString("login_type", "");
    }

    public String getLoginUrls() {
        return this.mPreference.getString(LOGIN_URLS, "");
    }

    public String getLoginUtdid() {
        return this.mPreference.getString(LOGIN_UTDID, "");
    }

    public boolean getMtopSwitchServer() {
        return this.mPreference.getBoolean(MTOP_SWITCH_SERVER, true);
    }

    public String getOldLoginUtdid() {
        return this.mPreference.getString(OLD_LOGIN_UTDID, "");
    }

    public String getRegisterUrls() {
        return this.mPreference.getString(REGISTER_URLS, "");
    }

    public long getServerSyncTime() {
        return this.mPreference.getLong(SERVER_SYNC_TIME, -1L);
    }

    public long getServerTime() {
        return this.mPreference.getLong(SERVER_TIME, -1L);
    }

    public String getThirdPartyLogin() {
        return this.mPreference.getString(THIRD_PARTY_LOGIN, "[\"youku\",\"qzone\",\"wechat\",\"taobao\",\"alipay\",\"sina\"]");
    }

    public boolean isServerFpAuthEnabled() {
        return this.mPreference.getBoolean(SERVER_FP_AUTH, true);
    }

    public void setConfigDataMd5(String str) {
        this.mPreference.edit().putString(CONFIG_DATA_MD5, str).apply();
    }

    public void setCookieRefreshInterval(long j) {
        this.mPreference.edit().putLong(COOKIE_REFRESH_INTERVAL, j).apply();
    }

    public void setCookieRefreshTime(long j) {
        this.mPreference.edit().putLong(COOKIE_REFRESH_TIME, j).apply();
    }

    public void setEncryptedYtId(String str) {
        this.mPreference.edit().putString(ENCRYPTED_YTID, str).apply();
    }

    public void setLastUtdid(String str) {
        this.mPreference.edit().putString(LAST_UTDID, str).apply();
    }

    public void setLoginUtdid(String str) {
        this.mPreference.edit().putString(LOGIN_UTDID, str).apply();
    }

    public void setMtopSwitchServer(boolean z) {
        this.mPreference.edit().putBoolean(MTOP_SWITCH_SERVER, z).apply();
    }

    public void setOldLoginUtdid(String str) {
        this.mPreference.edit().putString(OLD_LOGIN_UTDID, str).apply();
    }

    public void updateSyncTime(long j, long j2) {
        this.mPreference.edit().putLong(SERVER_TIME, j).putLong(SERVER_SYNC_TIME, j2).apply();
    }
}
