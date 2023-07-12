package com.huawei.hms.stats;

import android.content.Context;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hms.utils.HMSBIInitializer;
import java.util.LinkedHashMap;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class b {
    public static HiAnalyticsInstance a;

    public static HiAnalyticsInstance a(Context context) {
        HiAnalyticsInstance analyticsInstance = HMSBIInitializer.getInstance(context).getAnalyticsInstance();
        a = analyticsInstance;
        return analyticsInstance;
    }

    public static void a(Context context, String str, String str2) {
        if (a(context) != null) {
            a.onEvent(context, str, str2);
        }
    }

    public static void a(Context context, int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a(context) != null) {
            a.onEvent(i, str, linkedHashMap);
        }
    }

    public static void a(Context context, int i) {
        if (a(context) != null) {
            a.onReport(i);
        }
    }
}
