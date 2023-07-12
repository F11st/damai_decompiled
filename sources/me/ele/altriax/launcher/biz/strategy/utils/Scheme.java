package me.ele.altriax.launcher.biz.strategy.utils;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ali.user.open.core.Site;
import me.ele.altriax.launcher.common.AltriaXConfig;
import me.ele.altriax.launcher.common.AltriaXExecutor;
import me.ele.altriax.launcher.common.AltriaXLog;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class Scheme {
    static final String ELEME_WEB = "eleme://web";
    static final String ELEME_WINDVANE = "eleme://windvane";
    static final String ELEME_WINDVANE_2 = "eleme://windvane2";

    public static String getAppId(Uri uri) {
        if (uri.isHierarchical()) {
            return uri.getQueryParameter("_ariver_appid");
        }
        return null;
    }

    public static String getRealH5Url(@NonNull String str) {
        if (str == null) {
            return null;
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String authority = parse.getAuthority();
        if (!"http".equals(scheme) && !"https".equals(scheme)) {
            if (!Site.ELEME.equals(scheme) || (!"web".equals(authority) && !"windvane".equals(authority) && !"windvane2".equals(authority))) {
                return null;
            }
            str = parse.getQueryParameter("url");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri parse2 = Uri.parse(str);
        if (isTriverUrl(parse2) || isWindmillUrl(parse2)) {
            return null;
        }
        return str;
    }

    public static String getWmlCode(Uri uri) {
        if (uri.isHierarchical()) {
            return uri.getQueryParameter("_wml_code");
        }
        return null;
    }

    public static boolean isTriverUrl(Uri uri) {
        return !TextUtils.isEmpty(getAppId(uri));
    }

    public static boolean isWindmillUrl(Uri uri) {
        return !TextUtils.isEmpty(getWmlCode(uri));
    }

    private static void schemeLog(@NonNull final String str, @Nullable final String str2, @Nullable final String str3) {
        AltriaXExecutor.ALTRIAX_EXECUTOR.execute(new Runnable() { // from class: me.ele.altriax.launcher.biz.strategy.utils.Scheme.1
            @Override // java.lang.Runnable
            public void run() {
                String str4;
                String str5 = str;
                if (TextUtils.isEmpty(str3)) {
                    str4 = str2;
                } else {
                    str4 = str2 + " -> " + str3;
                }
                AltriaXLog.v(AltriaXLog.ALTRIAX, AltriaXLog.formatLog(AltriaXLog.ALTRIAX, str5, null, str4));
            }
        });
    }

    public static String schemeUpgrade(@NonNull String str) {
        if ("1".equals(AltriaXConfig.loadOrangeValue(AltriaXConfig.KEY_EXTERNAL_LINK_SCHEME_UPGRADE_WINDVANE2_DOWNGRADE)) || TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith(ELEME_WINDVANE_2)) {
            schemeLog("windvane2 == windvane2", str, null);
            return str;
        } else if (str.startsWith(ELEME_WINDVANE)) {
            AltriaXLog.v(AltriaXLog.ALTRIAX, AltriaXLog.formatLog(AltriaXLog.ALTRIAX, "scheme upgrade", null, "windvane -> windvane2"));
            String str2 = ELEME_WINDVANE_2 + str.substring(16);
            schemeLog("windvane -> windvane2", str, str2);
            return str2;
        } else if (str.startsWith(ELEME_WEB)) {
            String str3 = ELEME_WINDVANE_2 + str.substring(11);
            schemeLog("web -> windvane2", str, str3);
            return str3;
        } else {
            schemeLog("no match", str, null);
            return str;
        }
    }
}
