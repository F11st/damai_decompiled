package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class t82 extends w92 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void g(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1912403015")) {
            ipChange.ipc$dispatch("-1912403015", new Object[]{str, str2, str3, str4, str5});
        } else {
            b23.a(v92.a(str, str2, str3, str4, str5), s82.SEAT_FIRST_PAY_AFTER_CHOOSE_ERROR_CODE, s82.SEAT_FIRST_PAY_AFTER_CHOOSE_ERROR_MSG);
        }
    }

    public static void h(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-386318631")) {
            ipChange.ipc$dispatch("-386318631", new Object[]{str, str2, str3});
        } else {
            b23.a(v92.a("mtop.damai.wireless.seat.queryperformseatstatus", "unknown", str3, str, str2), s82.SEAT_STATE_COMPRESS_MISMATCH, s82.SEAT_STATE_COMPRESS_MISMATCH_MSG);
        }
    }

    public static void i(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1823085103")) {
            ipChange.ipc$dispatch("-1823085103", new Object[]{str, str2, str3, str4, str5});
        } else {
            b23.a(s82.c(str, str2, str3, str4, str5), s82.SEAT_REGION_JPG_IMG_ERROR_CODE, s82.SEAT_REGION_JPG_IMG_ERROR_MSG);
        }
    }

    public static void j(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2125044242")) {
            ipChange.ipc$dispatch("-2125044242", new Object[]{str, str2, str3, str4, str5});
        } else {
            b23.a(s82.c(str, str2, str3, str4, str5), s82.SEAT_REGION_SVG_IMG_ERROR_CODE, s82.SEAT_REGION_SVG_IMG_ERROR_MSG);
        }
    }

    public static void k(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "431741103")) {
            ipChange.ipc$dispatch("431741103", new Object[]{str, str2, str3, str4, str5});
        } else {
            b23.a(v92.a(str, str2, str3, str4, str5), s82.SEAT_REGION_SVG_IMG_DATA_ERROR_CODE, s82.SEAT_REGION_SVG_IMG_DATA_ERROR_MSG);
        }
    }

    public static void l(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "453435298")) {
            ipChange.ipc$dispatch("453435298", new Object[]{str, str2, str3, str4, str5});
        } else {
            b23.a(v92.a(str, str2, str3, str4, str5), s82.SEAT_REGION_SVG_IMG_PARSE_ERROR_CODE, s82.SEAT_REGION_SVG_IMG_PARSE_ERROR_MSG);
        }
    }

    public static void m(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "132049011")) {
            ipChange.ipc$dispatch("132049011", new Object[]{str, str2, str3, str4});
        } else {
            b23.a(v92.a("mtop.damai.wireless.seat.dynamicInfo", str3, str4, str, str2), s82.SEAT_DYNAMIC_API_CODE, s82.SEAT_DYNAMIC_API_MSG);
        }
    }

    public static void n(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "344359070")) {
            ipChange.ipc$dispatch("344359070", new Object[]{str, str2, str3, str4, str5});
        } else {
            b23.a(v92.a(str, str2, str3, str4, str5), s82.SEAT_STATUS_DATA_ERROR_CODE, s82.SEAT_STATUS_DATA_ERROR_MSG);
        }
    }

    public static void o(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "179159369")) {
            ipChange.ipc$dispatch("179159369", new Object[]{str, str2, str3, str4});
        } else {
            b23.a(v92.a("mtop.damai.item.calcTicketPrice", str3, str4, str, str2), s82.SEAT_CALC_TICKET_API_CODE, s82.SEAT_CALC_TICKET_API_MSG);
        }
    }

    public static void p(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-57398322")) {
            ipChange.ipc$dispatch("-57398322", new Object[]{str, str2, str3, str4, str5});
            return;
        }
        try {
            b23.a(v92.a(str, str2, str3, str4, str5), s82.SVG_VIEW_DRAW_ERROR_CODE, s82.SVG_VIEW_DRAW_ERROR_MSG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
