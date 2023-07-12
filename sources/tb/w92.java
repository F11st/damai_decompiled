package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class w92 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "573259973")) {
            ipChange.ipc$dispatch("573259973", new Object[]{str, str2, str3, str4, str5});
        } else {
            b23.a(v92.a(str, str2, str3, str4, str5), v92.SEAT_STATIC_DATA_PARSE_ERROR_CODE, v92.SEAT_STATIC_DATA_PARSE_ERROR_MSG);
        }
    }

    public static void b(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-694972503")) {
            ipChange.ipc$dispatch("-694972503", new Object[]{str, str2, str3});
        } else {
            b23.a(v92.a(str, "", "Region info has missing", str3, str2), v92.SEAT_REGION_STATIC_DATA_HAS_MISSING_CODE, v92.SEAT_REGION_STATIC_DATA_HAS_MISSING_MSG);
        }
    }

    public static void c(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "251083296")) {
            ipChange.ipc$dispatch("251083296", new Object[]{str, str2, str3, str4, str5});
        } else {
            b23.a(v92.a(str, str2, str3, str5, str4), v92.SEAT_REGION_STATIC_DATA_ERROR_CODE, v92.SEAT_REGION_STATIC_DATA_ERROR_MSG);
        }
    }

    public static void d(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-807729174")) {
            ipChange.ipc$dispatch("-807729174", new Object[]{str, str2, str3, str4});
        } else {
            b23.a(v92.a(str, "unknown", "unknown", str2, str3), v92.SEAT_SVG_DECRYPT_FAIL_CODE, str4);
        }
    }

    public static void e(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1597999968")) {
            ipChange.ipc$dispatch("-1597999968", new Object[]{str, str2, str3, str4, str5});
        } else {
            b23.a(v92.a(str, str2, str3, str4, str5), v92.SEAT_STATIC_DATA_SERIALIZE_ERROR_CODE, v92.SEAT_STATIC_DATA_SERIALIZE_ERROR_MSG);
        }
    }

    public static void f(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-32786062")) {
            ipChange.ipc$dispatch("-32786062", new Object[]{str, str2, str3, str4, str5});
        } else {
            b23.a(v92.a(str, str2, str3, str4, str5), v92.SEAT_STATIC_DATA_VALIDATE_ERROR_CODE, v92.SEAT_STATIC_DATA_VALIDATE_ERROR_MSG);
        }
    }
}
