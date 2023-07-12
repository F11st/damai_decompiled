package android.taobao.windvane.config;

import android.taobao.windvane.connect.api.ApiResponse;
import android.taobao.windvane.util.ConfigStorage;
import android.text.TextUtils;
import android.webkit.CookieManager;
import java.net.URLEncoder;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVConfigUtils {
    public static final String SPNAME = "WVConfigUtils";
    protected static final String TAG = "WVConfigUtils";
    private static String appVersion;
    private static boolean isAppKeyAvailable;
    private static boolean isAppKeyChecked;

    public static synchronized boolean checkAppKeyAvailable() {
        int i;
        synchronized (WVConfigUtils.class) {
            if (isAppKeyChecked) {
                return isAppKeyAvailable;
            }
            isAppKeyChecked = true;
            String appKey = GlobalConfig.getInstance().getAppKey();
            if (appKey == null) {
                isAppKeyAvailable = false;
                isAppKeyChecked = false;
                return false;
            }
            char[] charArray = appKey.toCharArray();
            while (i < charArray.length) {
                i = (charArray[i] >= '0' && charArray[i] <= '9') ? i + 1 : 0;
                isAppKeyAvailable = false;
                return false;
            }
            isAppKeyAvailable = true;
            return true;
        }
    }

    public static synchronized String dealAppVersion() {
        String str;
        synchronized (WVConfigUtils.class) {
            if (appVersion == null) {
                try {
                    String encode = URLEncoder.encode(GlobalConfig.getInstance().getAppVersion(), "utf-8");
                    appVersion = encode;
                    encode.replace("-", "%2D");
                } catch (Exception unused) {
                }
            }
            str = appVersion;
        }
        return str;
    }

    public static String getTargetValue() {
        try {
            CookieManager cookieManager = CookieManager.getInstance();
            String cookie = cookieManager.getCookie("h5." + GlobalConfig.env.getValue() + ".taobao.com");
            if (TextUtils.isEmpty(cookie)) {
                return null;
            }
            int indexOf = cookie.indexOf("abt=");
            char charAt = indexOf == -1 ? 'a' : cookie.charAt(indexOf + 4);
            if ('a' > charAt || charAt > 'z') {
                return null;
            }
            String valueOf = String.valueOf(charAt);
            if (!valueOf.equals(ConfigStorage.getStringVal(WVConfigManager.SPNAME_CONFIG, "abt", ""))) {
                ConfigStorage.putStringVal(WVConfigManager.SPNAME_CONFIG, "abt", valueOf);
            }
            return valueOf;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean isNeedUpdate(boolean z, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis() - ConfigStorage.getLongVal(str, str2 + ConfigStorage.KEY_TIME);
        return currentTimeMillis > (z ? ConfigStorage.DEFAULT_SMALL_MAX_AGE : ConfigStorage.DEFAULT_MAX_AGE) || currentTimeMillis < 0;
    }

    protected boolean needSaveConfig(String str) {
        return !TextUtils.isEmpty(str) && new ApiResponse().parseJsonResult(str).success;
    }

    public static boolean isNeedUpdate(String str, String str2) {
        Long valueOf;
        String str3;
        if (str.contains(".")) {
            String[] split = str.split("\\.");
            if (split == null || split.length < 2) {
                return false;
            }
            valueOf = Long.valueOf(Long.parseLong(split[0]));
            str3 = split[1];
        } else {
            valueOf = Long.valueOf(Long.parseLong(str));
            str3 = null;
        }
        String[] split2 = ConfigStorage.getStringVal(WVConfigManager.SPNAME_CONFIG, str2, "0").split("\\.");
        if (valueOf.longValue() <= Long.parseLong(split2[0])) {
            if (valueOf.longValue() != Long.parseLong(split2[0])) {
                return false;
            }
            if (str3 != null) {
                if ((split2.length <= 1 || str3.equals(split2[1])) && split2.length >= 2) {
                    return false;
                }
            } else if (split2.length <= 1) {
                return false;
            }
        }
        return true;
    }
}
