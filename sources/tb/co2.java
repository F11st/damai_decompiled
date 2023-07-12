package tb;

import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class co2 {
    public static final String KEY_ULTRON_PROFILE = "ultronProfile";
    public static final String TAG = "UltronPerformance";
    private static HashMap<String, Long> a = new HashMap<>();
    private static HashMap<String, Long> b = new HashMap<>();
    public static boolean c = false;

    public static void a(String str, String str2) {
        if (c) {
            long currentTimeMillis = System.currentTimeMillis();
            Long l = b.get(str);
            Long l2 = a.get(str);
            if (l != null && l.longValue() > 0) {
                vt2.b(TAG, "结束-" + str + ": " + str2 + ", 耗时: " + (currentTimeMillis - l.longValue()));
            }
            if (l2 != null && l2.longValue() > 0) {
                long longValue = currentTimeMillis - l2.longValue();
                vt2.b(TAG, "从开始到结束" + str + ": " + str2 + ", 总耗时: " + longValue);
            }
            b.remove(str);
            a.remove(str);
        }
    }

    public static boolean b(Context context, Uri uri) {
        String queryParameter;
        if (context == null || uri == null || (queryParameter = uri.getQueryParameter(KEY_ULTRON_PROFILE)) == null) {
            return true;
        }
        c = Boolean.TRUE.toString().equals(queryParameter);
        Context applicationContext = context.getApplicationContext();
        Toast.makeText(applicationContext, "开关状态: ultronProfile-" + c, 0).show();
        return true;
    }

    public static void c(String str, String str2) {
        if (c) {
            long currentTimeMillis = System.currentTimeMillis();
            Long l = b.get(str);
            if (l == null) {
                l = a.get(str);
            }
            if (l != null && l.longValue() > 0) {
                vt2.b(TAG, "过程-" + str + ": " + str2 + ", 耗时: " + (currentTimeMillis - l.longValue()));
            } else {
                vt2.b(TAG, "过程-" + str + ": " + str2 + ", no time");
            }
            b.put(str, Long.valueOf(currentTimeMillis));
        }
    }

    public static void d(String str, String str2) {
        if (c) {
            long currentTimeMillis = System.currentTimeMillis();
            Long l = a.get(str);
            if (l == null) {
                vt2.b(TAG, "开始至过程-" + str + ": " + str2 + ", no time");
                return;
            }
            if (l.longValue() > 0) {
                vt2.b(TAG, "开始至过程-" + str + ": " + str2 + ", 耗时: " + (currentTimeMillis - l.longValue()));
            }
            b.put(str, Long.valueOf(currentTimeMillis));
        }
    }

    public static void e(String str, String str2) {
        if (c) {
            vt2.b(TAG, "开始-" + str + ": " + str2);
            a.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }
}
