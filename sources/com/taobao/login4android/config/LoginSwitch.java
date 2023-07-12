package com.taobao.login4android.config;

import android.text.TextUtils;
import com.ali.user.mobile.info.AppInfo;
import com.taobao.login4android.log.LoginTLogAdapter;
import com.taobao.orange.OrangeConfig;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LoginSwitch {
    public static final String ACCS_LOGIN_SWITCH = "accs_login_switch";
    public static final String ALIPAY_SSO_SWITCH = "alipay_sso_switch";
    public static final int API_DEFAULT = 10000;
    public static final String API_Rollback = "api";
    public static final String BIND_ALIPAY_SWITCH = "bind_alipay_switch";
    public static final String CHECK_SAME_ACCOUNT = "check_same_account";
    public static final String CLEAR_COOKIE_WHEN_AUTOLOGIN = "clear_cookie_when_autologin";
    public static final String CLEAR_SESSION_WHEN_AUTOLOGIN_SWITCH = "clear_session_when_autoLogin_switch";
    public static final String CONFIG_GROUP_LOGIN = "login4android";
    public static final String DIRECT_REGISTER_ALERT = "direct_register_alert";
    public static final int DIRECT_REGISTER_ALERT_PERCENT = 10000;
    public static final String EMAILCODE_LENGTH = "short_emailcode_percent";
    public static final String ENABLE_EA_REG = "enable_enterprise_register";
    public static final String ENABLE_FIND_PASSWORD = "enable_find_password";
    public static final String ENABLE_HELP = "enable_help";
    public static final String ENABLE_REGISTER = "enable_register";
    public static final String ENABLE_REG_SESSION_MTOP = "enable_register_session_info_mtop";
    public static final String ENABLE_UPDATE_UT = "enable_update_ut_account";
    public static final String EXTRA_PREFECT = "extra_prefetch";
    public static final String FINGER_ORANGE = "finger_percent";
    public static final int FINGER_PERCENT = 10000;
    public static final String FIRE_APP_LAUNCH = "fire_app_launch";
    public static final String FORBID_LOGIN_FROM_BACKGROUND = "forbid_login_from_background_new";
    public static final String FORCE_SID_CHECK = "force_sid_check";
    public static final String HELP_LINK = "help_link";
    public static final String LOGIN_STRATEGY = "login_strategy";
    public static final int LOGIN_STRATEGY_PERCENT = -1;
    public static final int LOGOUT_MULTI_DEFAULT = 3000;
    public static final String LOGOUT_POST = "logout_post_url";
    public static final int LOGOUT_POST_DEFAULT = 7000;
    public static final String LOGOUT_REFACTOR = "logout_refactor";
    public static final int LOGOUT_REFACTOR_DEFAULT = -1;
    public static final String LOGOUT_TO_MULTI = "logout_to_multi";
    public static final String MAX_HISTORY_NUM = "max_history_account_num";
    public static final String MAX_SESSION_NUM = "multi_account_num";
    public static final int MULTI_DEFAULT = 10000;
    public static final String NEW_LOGOUT_BROADCAST_SWITCH = "new_logout_broadcast_switch";
    public static final int NEW_LOGOUT_DEFAULT = 10000;
    public static final String NEW_USER_CALL_APP_LAUNCH = "new_user_call_app_launch";
    public static final String ONEKEY_LOGIN_HISTORY_PERCENT = "recommend_login_hiatory_percent";
    public static final String ONEKEY_LOGIN_PERCENT = "onekey_login_percent_v2";
    public static final String ONEKEY_REGISTER_PERCENT = "onekey_register_percent";
    public static final String OPEN_LOGIN_PAGE_WHEN_IS_LOGIN = "openLoginPageWhenIsLogin";
    public static final String OPEN_LOGIN_PAGE_WHEN_IS_LOGIN_Default = "false";
    public static final String PROTOCOL = "custom_protocol";
    public static final String PWD_ERROR_TO_ALIPAY = "pwd2alipay";
    public static final int PWD_ERROR_TO_ALIPAY_PERCENT = 10000;
    public static final String RECOMMEND_LOGIN_PERCENT = "recommend_login_percent_v2";
    public static final String REFRESH_COOKIE_DEGRADE_SWITCH = "refresh_cookie_degrade";
    public static final String REGISTER_ONEKEY_WAIT = "register_onekey_wait";
    public static final String REGISTER_TV = "register_tv";
    public static final int REGITER_ONEKEY_WAIT_DEFAULT = 3000;
    public static final String REG_TO_LOGIN_SENDSMS = "reg_to_login_sendsms";
    public static final String RMD_TO_ONEKEY = "recommend_to_onekey";
    public static final String RPC_TIMEOUT_MS = "rpc_request_timeout_ms";
    public static final String SAVE_HISTORY_WITHOUT_SALT = "isSaveHistoryWithoutSalt";
    public static final String SECURITY_SETTING_PERCENT = "security_setting_percent";
    public static final String SKIP_CHECK_NEW_DEVICE_PERCENT = "skip_check_new_device_percent";
    public static final String SMSCODE_LENGTH = "short_smscode_percent";
    public static final String SSO_TAO_SIMPLE = "sso_tao_simple";
    public static final int SSO_TAO_SIMPLE_PERCENT = 10000;
    public static final String SUPPORT_FACE_LOGIN = "support_face_login";
    public static final String SUPPORT_FINGERPRINT_LOGIN = "support_fingerprint_login";
    public static final String SUPPORT_GUIDE_PAGE = "support_guide_login";
    public static final String SUPPORT_HISTORY_LOGIN_PAGE = "support_history_login";
    public static final String SUPPORT_MINI_PROGRAME = "support_mini_program";
    public static final String SUPPORT_NUM_AUTH = "enableNumAuthService";
    public static final String SWITCH_VALUE_FALSE = "false";
    public static final String SWITCH_VALUE_TRUE = "true";
    public static final String TAG = "login.LoginSwitch";
    public static final String YUNYINGSHANG_CACHE = "yunyingshang_cache2";
    public static final int YUNYINGSHANG_PERCENT = -1;

    public static String getConfig(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            String config = OrangeConfig.getInstance().getConfig("login4android", str, str2);
            LoginTLogAdapter.e(TAG, "LoginSwitch:getConfig, confighName=" + str + ", value=" + config);
            return config;
        } catch (Throwable th) {
            th.printStackTrace();
            LoginTLogAdapter.e(TAG, "LoginSwitch:getConfig, confighName=" + str, th);
            return str2;
        }
    }

    public static boolean getSwitch(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String config = OrangeConfig.getInstance().getConfig("login4android", str, str2);
            LoginTLogAdapter.e(TAG, "LoginSwitch:getSwitch, switchName=" + str + ", value=" + config);
            return Boolean.parseBoolean(config);
        } catch (Throwable th) {
            th.printStackTrace();
            LoginTLogAdapter.e(TAG, "LoginSwitch:getSwitch, switchName=" + str, th);
            return false;
        }
    }

    public static boolean isInABTestRegion(String str, int i) {
        return Math.abs(AppInfo.getInstance().getUtdid().hashCode()) % 10000 < getSwitch(str, i);
    }

    public static int getSwitch(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            OrangeConfig orangeConfig = OrangeConfig.getInstance();
            String config = orangeConfig.getConfig("login4android", str, i + "");
            LoginTLogAdapter.e(TAG, "LoginSwitch:getSwitch, switchName=" + str + ", value=" + config);
            return Integer.parseInt(config);
        } catch (Throwable th) {
            th.printStackTrace();
            LoginTLogAdapter.e(TAG, "LoginSwitch:getSwitch, switchName=" + str, th);
            return i;
        }
    }
}
