package tb;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.WXConfig;
import com.taobao.weex.utils.WXViewUtils;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class nz2 {
    public static final String KEY_USER_AGENT = "user-agent";
    private static String a;

    public static String a(Context context, Map<String, String> map) {
        if (TextUtils.isEmpty(a)) {
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(WXConfig.sysModel));
            sb.append("(Android/");
            sb.append(map.get(WXConfig.sysVersion));
            sb.append(jn1.BRACKET_END_STR);
            sb.append(" ");
            sb.append(TextUtils.isEmpty(map.get(WXConfig.appGroup)) ? "" : map.get(WXConfig.appGroup));
            sb.append(jn1.BRACKET_START_STR);
            sb.append(TextUtils.isEmpty(map.get("appName")) ? "" : map.get("appName"));
            sb.append("/");
            sb.append(map.get("appVersion"));
            sb.append(jn1.BRACKET_END_STR);
            sb.append(" ");
            sb.append("Weex/");
            sb.append(map.get("weexVersion"));
            sb.append(" ");
            sb.append(TextUtils.isEmpty(map.get(WXConfig.externalUserAgent)) ? "" : map.get(WXConfig.externalUserAgent));
            sb.append(TextUtils.isEmpty(map.get(WXConfig.externalUserAgent)) ? "" : " ");
            sb.append(WXViewUtils.getScreenWidth(context) + Constants.Name.X + WXViewUtils.getScreenHeight(context));
            a = sb.toString();
        }
        return a;
    }
}
