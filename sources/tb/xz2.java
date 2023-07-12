package tb;

import android.net.Uri;
import android.taobao.windvane.config.WVServerConfig;
import android.text.TextUtils;
import com.alibaba.aliweex.C3004a;
import com.alibaba.aliweex.IConfigAdapter;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.performance.WXInstanceApm;
import com.taobao.weex.utils.WXLogUtils;
import java.net.URLDecoder;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class xz2 {
    private static String a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Uri parse = Uri.parse(URLDecoder.decode(str, "utf-8"));
            String queryParameter = parse.getQueryParameter("_wx_tpl");
            if (queryParameter == null) {
                queryParameter = parse.getQueryParameter("weex_original_url");
            }
            if (queryParameter != null) {
                parse = Uri.parse(queryParameter);
            }
            if (z) {
                return parse.getHost() + parse.getPath();
            }
            return parse.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String b(String str, boolean z) {
        try {
            String a = str.startsWith("http") ? a(str, z) : str;
            if (a != null) {
                return a;
            }
            int i = 0;
            if (str.startsWith("https:")) {
                i = 8;
            } else if (str.startsWith("http:")) {
                i = 7;
            }
            return str.substring(i);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "default";
            }
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.scheme("");
            return buildUpon.toString().replaceFirst("^(/|://|:/|//)", "");
        } catch (Exception e) {
            WXLogUtils.e("pageNameError", e);
            return str;
        }
    }

    public static void d(WXSDKInstance wXSDKInstance, String str) {
        WXInstanceApm apmForInstance;
        IConfigAdapter c;
        if (wXSDKInstance == null || TextUtils.isEmpty(str) || (apmForInstance = wXSDKInstance.getApmForInstance()) == null || (c = C3004a.l().c()) == null) {
            return;
        }
        if (!"true".equals(c.getConfig("android_weex_ext_config", "enableReportUnsafeUrl", "true"))) {
            WXLogUtils.d("reportUnsafeHost shutdown");
            return;
        }
        boolean c2 = ev2.c(str);
        if (c2) {
            return;
        }
        WXLogUtils.d("unsafe_url :" + str);
        apmForInstance.e("trusted", Boolean.toString(c2));
        apmForInstance.e("check_pattern", WVServerConfig.DOMAIN_PATTERN);
        apmForInstance.e("unsafe_url", str);
    }
}
