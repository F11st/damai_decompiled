package tb;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;
import com.taobao.android.AliLogInterface;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class vt2 {
    public static final String KEY_USE_ANDROID_LOG = "useAndroidLog";
    public static String a = "[Page_DEFAULT]";
    private static AliLogInterface b = o4.c();
    public static boolean c = false;

    public static void a(String str, String... strArr) {
        AliLogInterface aliLogInterface = b;
        if (aliLogInterface == null) {
            return;
        }
        aliLogInterface.logd(a, c(str, strArr));
        if (c) {
            Log.d(a, c(str, strArr));
        }
    }

    public static void b(String str, String... strArr) {
        AliLogInterface aliLogInterface = b;
        if (aliLogInterface == null) {
            return;
        }
        aliLogInterface.loge(a, c(str, strArr));
        if (c) {
            Log.e(a, c(str, strArr));
        }
    }

    private static String c(String str, String... strArr) {
        if (strArr == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            if (i == 0) {
                sb.append(str);
                sb.append(".");
                sb.append(strArr[i]);
                if (strArr.length > 1) {
                    sb.append(" |");
                }
            } else {
                sb.append(" ");
                sb.append(strArr[i]);
            }
        }
        return sb.toString();
    }

    public static void d(String str, String... strArr) {
        AliLogInterface aliLogInterface = b;
        if (aliLogInterface == null) {
            return;
        }
        aliLogInterface.logi(a, c(str, strArr));
        if (c) {
            Log.i(a, c(str, strArr));
        }
    }

    public static boolean e(Context context, Uri uri) {
        String queryParameter;
        if (context == null || uri == null || (queryParameter = uri.getQueryParameter(KEY_USE_ANDROID_LOG)) == null) {
            return true;
        }
        c = Boolean.TRUE.toString().equals(queryParameter);
        Context applicationContext = context.getApplicationContext();
        Toast.makeText(applicationContext, "开关状态: useAndroidLog-" + c, 0).show();
        return true;
    }

    public static void f(String str) {
        a = str;
    }

    public static void g(String str, String... strArr) {
        AliLogInterface aliLogInterface = b;
        if (aliLogInterface == null) {
            return;
        }
        aliLogInterface.logw(a, c(str, strArr));
        if (c) {
            Log.w(a, c(str, strArr));
        }
    }
}
