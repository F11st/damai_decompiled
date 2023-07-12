package com.huawei.secure.android.common.webview;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.huawei.secure.android.common.util.LogsUtil;
import com.youku.live.livesdk.wkit.component.Constants;
import java.net.MalformedURLException;
import java.net.URL;
import tb.m80;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class UriUtil {
    private static final String a = "UriUtil";

    private static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return !URLUtil.isNetworkUrl(str) ? str : getHostByURI(str);
        }
        LogsUtil.i(a, "whiteListUrl is null");
        return null;
    }

    @TargetApi(9)
    public static String getHostByURI(String str) {
        if (TextUtils.isEmpty(str)) {
            LogsUtil.i(a, "url is null");
            return str;
        }
        try {
            if (!URLUtil.isNetworkUrl(str)) {
                LogsUtil.e(a, "url don't starts with http or https");
                return "";
            }
            return new URL(str.replaceAll("[\\\\#]", "/")).getHost();
        } catch (MalformedURLException e) {
            LogsUtil.e(a, "getHostByURI error  MalformedURLException : " + e.getMessage());
            return "";
        }
    }

    public static boolean isUrlHostAndPathInWhitelist(String str, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str2 : strArr) {
                if (isUrlHostAndPathMatchWhitelist(str, str2)) {
                    return true;
                }
            }
            return false;
        }
        LogsUtil.e(a, "whitelist is null");
        return false;
    }

    public static boolean isUrlHostAndPathMatchWhitelist(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!str.contains("..") && !str.contains(m80.DINAMIC_PREFIX_AT)) {
                if (!str2.equals(str)) {
                    if (!str.startsWith(str2 + "?")) {
                        if (!str.startsWith(str2 + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                            if (str2.endsWith("/")) {
                                if (Uri.parse(str).getPathSegments().size() - Uri.parse(str2).getPathSegments().size() != 1) {
                                    return false;
                                }
                                return str.startsWith(str2);
                            }
                            return false;
                        }
                    }
                }
                return true;
            }
            Log.e(a, "url contains unsafe char");
        }
        return false;
    }

    public static boolean isUrlHostInWhitelist(String str, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str2 : strArr) {
                if (isUrlHostMatchWhitelist(str, str2)) {
                    return true;
                }
            }
            return false;
        }
        LogsUtil.e(a, "whitelist is null");
        return false;
    }

    public static boolean isUrlHostMatchWhitelist(String str, String str2) {
        String hostByURI = getHostByURI(str);
        if (!TextUtils.isEmpty(hostByURI) && !TextUtils.isEmpty(str2)) {
            String a2 = a(str2);
            if (TextUtils.isEmpty(a2)) {
                Log.e(a, "whitelist host is null");
                return false;
            } else if (a2.equals(hostByURI)) {
                return true;
            } else {
                if (hostByURI.endsWith(a2)) {
                    try {
                        String substring = hostByURI.substring(0, hostByURI.length() - a2.length());
                        if (substring.endsWith(".")) {
                            return substring.matches("^[A-Za-z0-9.-]+$");
                        }
                        return false;
                    } catch (IndexOutOfBoundsException e) {
                        LogsUtil.e(a, "IndexOutOfBoundsException" + e.getMessage());
                    } catch (Exception e2) {
                        LogsUtil.e(a, "Exception : " + e2.getMessage());
                        return false;
                    }
                }
                return false;
            }
        }
        LogsUtil.e(a, "url or whitelist is null");
        return false;
    }

    public static boolean isUrlHostSameWhitelist(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return TextUtils.equals(getHostByURI(str), a(str2));
        }
        Log.e(a, "isUrlHostSameWhitelist: url or host is null");
        return false;
    }

    public static boolean isUrlHostSameWhitelist(String str, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str2 : strArr) {
                if (isUrlHostSameWhitelist(str, str2)) {
                    return true;
                }
            }
            return false;
        }
        LogsUtil.e(a, "whitelist is null");
        return false;
    }
}
