package android.taobao.windvane.grey;

import android.taobao.windvane.util.TaoLog;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class GreyPageInfo {
    public static final String KEY_AIR_TAG = "wxAirTag";
    public static final String KEY_CONTENT_VERSION = "x-air-content-version";
    public static final String KEY_ENV = "x-air-env";
    public static final String KEY_GREY = "x-air-grey";
    private static final String TAG = "GreyPageInfo";
    String URL;
    String envParam;
    String isGreyPage;

    public GreyPageInfo(String str, String str2, String str3) {
        this.URL = str;
        this.envParam = str2;
        this.isGreyPage = str3;
        TaoLog.v(TAG, "GreyPageInfo() called with: URL = [" + str + "], envParam = [" + str2 + "], isGreyPage = [" + str3 + jn1.ARRAY_END_STR);
    }

    public String generateOutputString() {
        boolean z;
        StringBuilder sb = new StringBuilder();
        String str = this.envParam;
        if (str == null || str.isEmpty()) {
            z = false;
        } else {
            sb.append(KEY_ENV);
            sb.append("=");
            sb.append(this.envParam);
            z = true;
        }
        String str2 = this.envParam;
        if (str2 != null && !str2.isEmpty()) {
            if (z) {
                sb.append("&");
            }
            sb.append(KEY_GREY);
            sb.append("=");
            sb.append(this.isGreyPage);
        }
        String sb2 = sb.toString();
        TaoLog.v(TAG, "generateOutputString: " + sb2);
        return sb2;
    }

    public String getEnvParam() {
        return this.envParam;
    }

    public String getGreyPage() {
        return this.isGreyPage;
    }

    public String getURL() {
        return this.URL;
    }
}
