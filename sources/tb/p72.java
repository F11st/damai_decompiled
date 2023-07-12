package tb;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.utils.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class p72 {
    private static final Map<String, String> a;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        a = concurrentHashMap;
        concurrentHashMap.put("sdk-version", os2.a().getFullSDKVersion());
    }

    private static String a() {
        Object a2;
        try {
            Object e = z02.e("com.taobao.updatecenter.hotpatch.HotPatchManager", "getInstance");
            if (e == null || (a2 = z02.a(e, "getPatchSuccessedVersion")) == null) {
                return null;
            }
            return a2 + "";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Map<String, String> b() {
        Context j = Variables.n().j();
        if (j != null) {
            Map<String, String> map = a;
            if (!map.containsKey("pt")) {
                String c = c(j, "package_type");
                if (!TextUtils.isEmpty(c)) {
                    map.put("pt", c);
                } else {
                    map.put("pt", "");
                }
            }
            if (!map.containsKey("pid")) {
                String c2 = c(j, "project_id");
                if (!TextUtils.isEmpty(c2)) {
                    map.put("pid", c2);
                } else {
                    map.put("pid", "");
                }
            }
            if (!map.containsKey("bid")) {
                String c3 = c(j, "build_id");
                if (!TextUtils.isEmpty(c3)) {
                    map.put("bid", c3);
                } else {
                    map.put("bid", "");
                }
            }
            if (!map.containsKey("bv")) {
                String c4 = c(j, "base_version");
                if (!TextUtils.isEmpty(c4)) {
                    map.put("bv", c4);
                } else {
                    map.put("bv", "");
                }
            }
        }
        String a2 = a();
        if (!TextUtils.isEmpty(a2)) {
            a.put("hv", a2);
        } else {
            a.put("hv", "");
        }
        Map<String, String> map2 = a;
        if (!map2.containsKey("sdk-version")) {
            map2.put("sdk-version", os2.a().getFullSDKVersion());
        }
        return map2;
    }

    public static String c(Context context, String str) {
        if (context == null) {
            return null;
        }
        int i = 0;
        try {
            i = context.getResources().getIdentifier(str, "string", context.getPackageName());
        } catch (Throwable th) {
            Logger.v("SdkMeta", "getString Id error", th);
        }
        if (i != 0) {
            return context.getString(i);
        }
        return null;
    }
}
