package tb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class m3 {
    public static Map<String, Object> a(Activity activity) {
        HashMap hashMap = new HashMap();
        if (activity != null) {
            Intent intent = activity.getIntent();
            if (intent != null) {
                hashMap.put("schemaUrl", intent.getDataString());
                hashMap.put("navStartTime", Long.valueOf(intent.getLongExtra("NAV_TO_URL_START_TIME", -1L)));
                hashMap.put("navStartActivityTime", Long.valueOf(intent.getLongExtra("NAV_START_ACTIVITY_TIME", -1L)));
                Bundle bundleExtra = intent.getBundleExtra("afc_bundle");
                if (bundleExtra != null) {
                    hashMap.put("blackPage", bundleExtra.getString("black_page"));
                    hashMap.put("outLink", bundleExtra.getString("out_link"));
                }
            }
            hashMap.put("fullPageName", b(activity));
        }
        return hashMap;
    }

    public static String b(Activity activity) {
        return activity == null ? "" : activity.getClass().getName();
    }

    public static String c(Activity activity) {
        Intent intent;
        if (activity == null || (intent = activity.getIntent()) == null) {
            return "";
        }
        String dataString = intent.getDataString();
        return !TextUtils.isEmpty(dataString) ? dataString : "";
    }

    public static String d(Activity activity) {
        return activity == null ? "" : activity.getClass().getSimpleName();
    }
}
