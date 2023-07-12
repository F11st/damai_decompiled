package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class l01 extends u53<Map<String, String>> {
    public static final int REQUEST_ERROR_DEFAULT = -1;
    public static final int REQUEST_ERROR_NETWORK_DISCONNECT = -2;
    public static final int REQUEST_ERROR_SOCKET_TIMEOUT = -3;

    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.HashMap] */
    public l01() {
        this.d = new HashMap();
    }

    public String a() {
        return !((Map) this.d).containsKey("biz_code") ? "" : (String) ((Map) this.d).get("biz_code");
    }

    public int b() {
        return this.b;
    }

    public String c() {
        return !((Map) this.d).containsKey("req_url") ? "" : (String) ((Map) this.d).get("req_url");
    }

    public void d(@NonNull String str) {
        ((Map) this.d).put("biz_code", str);
    }

    public void e(int i) {
        this.a = (i >= 200 && i < 300) || i == 304;
        this.b = i;
    }

    public void f(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (str.contains("?")) {
            str = str.substring(0, str.indexOf("?"));
        }
        ((Map) this.d).put("req_url", str);
    }

    public String toString() {
        return "HttpResponse {succ=" + this.a + ", code=" + this.b + ", data='" + this.c + "', extra=" + this.d + '}';
    }
}
