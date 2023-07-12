package mtopsdk.mtop.protocol.converter.util;

import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class NetworkConverterUtils {
    private static final String TAG = "mtopsdk.NetworkConverterUtils";

    public static String createParamQueryStr(Map<String, String> map, String str) {
        if (map != null) {
            if (StringUtils.isBlank(str)) {
                str = "utf-8";
            }
            StringBuilder sb = new StringBuilder(64);
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                try {
                    String encode = next.getKey() != null ? URLEncoder.encode(next.getKey(), str) : null;
                    String encode2 = next.getValue() != null ? URLEncoder.encode(next.getValue(), str) : null;
                    sb.append(encode);
                    sb.append("=");
                    sb.append((Object) encode2);
                    if (it.hasNext()) {
                        sb.append("&");
                    }
                } catch (Throwable th) {
                    TBSdkLog.e(TAG, "[createParamQueryStr]getQueryStr error ---" + th.toString());
                }
            }
            return sb.toString();
        }
        return null;
    }

    public static URL initUrl(String str, Map<String, String> map) {
        if (StringUtils.isBlank(str)) {
            TBSdkLog.e(TAG, "[initUrl]baseUrl is blank,initUrl error");
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(str);
            if (map != null) {
                String createParamQueryStr = createParamQueryStr(map, "utf-8");
                if (StringUtils.isNotBlank(createParamQueryStr) && !str.contains("?")) {
                    sb.append("?");
                    sb.append(createParamQueryStr);
                }
            }
            return new URL(sb.toString());
        } catch (Exception e) {
            TBSdkLog.e(TAG, "[initUrl] build fullUrl error", e);
            return null;
        }
    }
}
