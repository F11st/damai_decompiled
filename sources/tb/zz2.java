package tb;

import android.app.Activity;
import android.app.Application;
import android.content.res.TypedArray;
import android.os.Build;
import android.taobao.windvane.packageapp.zipapp.utils.ZipAppUtils;
import android.text.TextUtils;
import com.alibaba.aliweex.C3004a;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class zz2 {
    public static final String ERROR_BUNDLE_URL = "http://taobao.com?_wx_tpl=http://h5.m.taobao.com/weex/render/error.js";
    public static final String ERROR_RENDER_URL = "http://h5.m.taobao.com/weex/render/error.js";
    private static boolean a;
    private static String b;

    static {
        d();
        a = false;
        b = null;
    }

    public static int a(Activity activity) {
        if (activity != null) {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{16843499});
            int dimension = (int) obtainStyledAttributes.getDimension(0, 0.0f);
            obtainStyledAttributes.recycle();
            return dimension;
        }
        return 0;
    }

    public static String b(String str, String str2) {
        try {
            return ZipAppUtils.getStreamByUrl(str, str2);
        } catch (Throwable th) {
            WXLogUtils.e("TBWXSDKEngine", "getZCacheFromUrl:" + th.getMessage());
            return null;
        }
    }

    public static boolean c() {
        return a;
    }

    private static boolean d() {
        try {
            return Build.class.getMethod("hasSmartBar", new Class[0]) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean e() {
        if (TextUtils.isEmpty(b)) {
            Application b2 = C3004a.l().b();
            if (b2 == null) {
                return false;
            }
            b = b2.getPackageName();
        }
        return "com.taobao.taobao".equals(b);
    }
}
