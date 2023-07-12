package tb;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class nl {
    private static String a = "";
    private static String b = "";

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String b(Map<String, String> map, String str) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(64);
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() != null) {
                    sb.append(URLEncoder.encode(entry.getKey(), str));
                    sb.append("=");
                    sb.append(URLEncoder.encode(entry.getValue() == null ? "" : entry.getValue(), str).replace(jn1.PLUS, "%20"));
                    sb.append("&");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
        } catch (UnsupportedEncodingException unused) {
        }
        return sb.toString();
    }

    public static String c(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                sb.append(list.get(i));
            } else {
                sb.append("|");
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }

    public static String d(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return null;
    }

    public static String e(String str) {
        String encode;
        if (!TextUtils.isEmpty(str)) {
            try {
                encode = URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
            }
            au1.b(encode);
            return encode;
        }
        encode = null;
        au1.b(encode);
        return encode;
    }

    private static String f(Context context, int i) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String str = null;
        if (activityManager == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            try {
                if (runningAppProcessInfo.pid == i) {
                    str = runningAppProcessInfo.processName;
                }
            } catch (Exception unused) {
            }
        }
        return str;
    }

    public static long g(String str) {
        long j = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        int length = str.length();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < length; i++) {
            j = (j * 31) + charArray[i];
        }
        return j & AbsPerformance.LONG_NIL;
    }

    public static boolean h(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.isEmpty(str2) || str.compareTo(str2) > 0;
    }

    public static boolean i(Context context) {
        if (context == null) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(a)) {
                a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.processName;
            }
            if (TextUtils.isEmpty(b)) {
                b = f(context, Process.myPid());
            }
            if (TextUtils.isEmpty(a) || TextUtils.isEmpty(b)) {
                return true;
            }
            return a.equalsIgnoreCase(b);
        } catch (Throwable unused) {
            return true;
        }
    }

    public static long j(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            return Long.parseLong(str);
        } catch (Exception e) {
            m42.d("CommonUtil", "parseLong", e, new Object[0]);
            return 0L;
        }
    }
}
