package android.taobao.windvane.config;

import android.taobao.windvane.connect.api.ApiResponse;
import android.taobao.windvane.util.ConfigStorage;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVConstants;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import com.ali.ha.fulltrace.dump.DumpManager;
import com.taobao.orange.OConstant;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVServerConfig {
    public static String ALLOW_ACCESS_DOMAIN_PATTERN;
    public static boolean CACHE;
    public static String DOMAIN_PATTERN;
    public static String FORBIDDEN_DOMAIN_PATTERN;
    public static boolean LOG;
    public static boolean STATISTICS;
    public static String SUPPORT_DOWNLOAD_DOMAIN_PATTERN;
    public static String THIRD_PARTY_DOMAIN_PATTERN;
    public static boolean URL_FILTER;
    public static Pattern allowAccessDomain;
    public static Pattern domainPat;
    public static Pattern forbiddenDomain;
    public static Pattern supportDownloadDomain;
    public static Pattern thirdPartyDomain;
    public static String v;

    static {
        try {
            updateGlobalConfig(ConfigStorage.getStringVal("WVURLCacheDefault", ConfigStorage.KEY_DATA));
        } catch (Exception unused) {
        }
        CACHE = true;
        URL_FILTER = true;
        LOG = false;
        STATISTICS = false;
        DOMAIN_PATTERN = WVConstants.DEFAULT_DOMAIN_PATTERN;
        domainPat = null;
        FORBIDDEN_DOMAIN_PATTERN = "";
        forbiddenDomain = null;
        THIRD_PARTY_DOMAIN_PATTERN = WVConstants.THIRD_PARTY_DOMAIN_PATTERN;
        thirdPartyDomain = null;
        SUPPORT_DOWNLOAD_DOMAIN_PATTERN = "";
        supportDownloadDomain = null;
        ALLOW_ACCESS_DOMAIN_PATTERN = WVConstants.ALLOW_SSL_DOMAIN_PATTERN;
        allowAccessDomain = null;
        v = "0";
    }

    public static boolean isAllowAccess(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (allowAccessDomain == null) {
            if (TextUtils.isEmpty(ALLOW_ACCESS_DOMAIN_PATTERN)) {
                ALLOW_ACCESS_DOMAIN_PATTERN = "";
            }
            try {
                allowAccessDomain = Pattern.compile(ALLOW_ACCESS_DOMAIN_PATTERN, 2);
                TaoLog.d("WVServerConfig", "compile pattern allowAccessDomain rule, " + ALLOW_ACCESS_DOMAIN_PATTERN);
            } catch (PatternSyntaxException e) {
                TaoLog.e("WVServerConfig", " PatternSyntaxException pattern:" + e.getMessage());
            }
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                return allowAccessDomain.matcher(str).matches();
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isBlackUrl(String str, IWVWebView iWVWebView) {
        if (iWVWebView.canUseUrlConfig()) {
            return WVUrlMatchUtils.getInstance().isForbiddenOpen(str);
        }
        return isBlackUrl(str);
    }

    public static boolean isSupportDownload(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (supportDownloadDomain == null) {
            if (TextUtils.isEmpty(SUPPORT_DOWNLOAD_DOMAIN_PATTERN)) {
                SUPPORT_DOWNLOAD_DOMAIN_PATTERN = "";
            }
            try {
                supportDownloadDomain = Pattern.compile(SUPPORT_DOWNLOAD_DOMAIN_PATTERN, 2);
                TaoLog.d("WVServerConfig", "compile pattern supportDownloadDomain rule, " + SUPPORT_DOWNLOAD_DOMAIN_PATTERN);
            } catch (PatternSyntaxException e) {
                TaoLog.e("WVServerConfig", " PatternSyntaxException pattern:" + e.getMessage());
            }
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                return supportDownloadDomain.matcher(str).matches();
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isThirdPartyUrl(String str, IWVWebView iWVWebView) {
        if (iWVWebView.canUseUrlConfig()) {
            return WVUrlMatchUtils.getInstance().isAllowOpen(str);
        }
        return isThirdPartyUrl(str);
    }

    public static boolean isTrustedUrl(String str, IWVWebView iWVWebView) {
        if (iWVWebView.canUseUrlConfig()) {
            return true;
        }
        return isTrustedUrl(str);
    }

    public static boolean updateGlobalConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ApiResponse apiResponse = new ApiResponse();
        JSONObject jSONObject = apiResponse.parseJsonResult(str).success ? apiResponse.data : null;
        if (jSONObject != null) {
            CACHE = jSONObject.optInt(OConstant.DIMEN_FILE_LOCK, 0) == 0;
            LOG = jSONObject.optInt(DumpManager.LOG_PATH) == 1;
            STATISTICS = jSONObject.optInt("statistics") == 1;
            DOMAIN_PATTERN = jSONObject.optString("alidomain");
            domainPat = null;
            return true;
        }
        return false;
    }

    public static boolean isTrustedUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (GlobalConfig.getInstance().isUseGlobalUrlConfig() && WVCommonConfig.commonConfig.useURLConfig) {
            return true;
        }
        if (domainPat == null) {
            if (TextUtils.isEmpty(DOMAIN_PATTERN)) {
                DOMAIN_PATTERN = WVConstants.DEFAULT_DOMAIN_PATTERN;
            }
            try {
                domainPat = Pattern.compile(DOMAIN_PATTERN, 2);
                TaoLog.d("WVServerConfig", "compile pattern domainPat rule, " + DOMAIN_PATTERN);
            } catch (PatternSyntaxException e) {
                TaoLog.e("WVServerConfig", " PatternSyntaxException pattern:" + e.getMessage());
            }
        }
        try {
            Pattern pattern = domainPat;
            if (pattern != null) {
                return pattern.matcher(str).matches();
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isBlackUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (GlobalConfig.getInstance().isUseGlobalUrlConfig() && WVCommonConfig.commonConfig.useURLConfig) {
            return WVUrlMatchUtils.getInstance().isForbiddenOpen(str);
        }
        if (forbiddenDomain == null) {
            if (TextUtils.isEmpty(FORBIDDEN_DOMAIN_PATTERN)) {
                FORBIDDEN_DOMAIN_PATTERN = "";
            }
            try {
                forbiddenDomain = Pattern.compile(FORBIDDEN_DOMAIN_PATTERN, 2);
                TaoLog.d("WVServerConfig", "compile pattern black rule, " + FORBIDDEN_DOMAIN_PATTERN);
            } catch (PatternSyntaxException e) {
                TaoLog.e("WVServerConfig", " PatternSyntaxException pattern:" + e.getMessage());
            }
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                return forbiddenDomain.matcher(str).matches();
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isThirdPartyUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (GlobalConfig.getInstance().isUseGlobalUrlConfig() && WVCommonConfig.commonConfig.useURLConfig) {
            return WVUrlMatchUtils.getInstance().isAllowOpen(str);
        }
        if (thirdPartyDomain == null) {
            if (TextUtils.isEmpty(THIRD_PARTY_DOMAIN_PATTERN)) {
                THIRD_PARTY_DOMAIN_PATTERN = WVConstants.THIRD_PARTY_DOMAIN_PATTERN;
            }
            try {
                thirdPartyDomain = Pattern.compile(THIRD_PARTY_DOMAIN_PATTERN, 2);
                TaoLog.d("WVServerConfig", "compile pattern thirdPartyDomain rule, " + THIRD_PARTY_DOMAIN_PATTERN);
            } catch (PatternSyntaxException e) {
                TaoLog.e("WVServerConfig", " PatternSyntaxException pattern:" + e.getMessage());
            }
        }
        try {
            Pattern pattern = thirdPartyDomain;
            if (pattern != null) {
                return pattern.matcher(str).matches();
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
