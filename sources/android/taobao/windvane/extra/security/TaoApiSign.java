package android.taobao.windvane.extra.security;

import android.taobao.windvane.connect.api.ApiConstants;
import android.taobao.windvane.util.DigestUtils;
import android.taobao.windvane.util.TaoLog;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class TaoApiSign {
    public static String getSign(Map<String, String> map) {
        try {
            String str = map.get("appKey");
            String str2 = map.get(ApiConstants.APPSECRET);
            String str3 = map.get("api");
            String str4 = map.get("v");
            String str5 = map.get("imei");
            String str6 = map.get("imsi");
            String str7 = map.get("data");
            String str8 = map.get("t");
            String str9 = map.get("ecode");
            if (str4 == null || "".equals(str4)) {
                str4 = jn1.MUL;
            }
            if (str7 == null) {
                str7 = "";
            }
            String md5ToHex = DigestUtils.md5ToHex(str);
            StringBuilder sb = new StringBuilder();
            if (str9 != null) {
                sb.append(str9);
                sb.append("&");
            }
            sb.append(str2);
            sb.append("&");
            sb.append(md5ToHex);
            sb.append("&");
            sb.append(str3);
            sb.append("&");
            sb.append(str4);
            sb.append("&");
            sb.append(str5);
            sb.append("&");
            sb.append(str6);
            sb.append("&");
            sb.append(DigestUtils.md5ToHex(str7));
            sb.append("&");
            sb.append(str8);
            return DigestUtils.md5ToHex(sb.toString());
        } catch (Exception e) {
            TaoLog.e("TaoApiSign", "generate sign fail." + e);
            return null;
        }
    }
}
