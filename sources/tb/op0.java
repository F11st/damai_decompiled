package tb;

import com.taobao.phenix.request.ImageFlowMonitor;
import com.taobao.phenix.request.ImageStatistics;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class op0 {
    public static String a = "bizReqStart";
    public static String b = "bizReqProcessStart";
    public static String c = "bizRspProcessStart";
    public static String d = "bizRspCbDispatch";
    public static String e = "bizRspCbStart";
    public static String f = "bizRspCbEnd";
    public static String g = "bizFinish";

    private static String a(ImageStatistics imageStatistics) {
        com.taobao.phenix.request.b p;
        return (imageStatistics == null || (p = imageStatistics.p()) == null) ? "" : p.k();
    }

    public static void b(ImageStatistics imageStatistics, String str) {
        c(imageStatistics, str, "");
    }

    public static void c(ImageStatistics imageStatistics, String str, String str2) {
        ImageFlowMonitor k = ur1.o().k();
        if (k != null) {
            k.onProcess(imageStatistics, str, str2);
        }
    }

    public static void d(ImageStatistics imageStatistics, String str) {
        c(imageStatistics, g, str);
    }

    public static void e(ImageStatistics imageStatistics) {
        imageStatistics.s = System.currentTimeMillis();
        b(imageStatistics, b);
    }

    public static void f(ImageStatistics imageStatistics) {
        imageStatistics.z(System.currentTimeMillis());
        String str = a;
        c(imageStatistics, str, "url=" + a(imageStatistics));
    }

    public static void g(ImageStatistics imageStatistics) {
        imageStatistics.u = System.currentTimeMillis();
        b(imageStatistics, d);
    }

    public static void h(ImageStatistics imageStatistics) {
        imageStatistics.w = System.currentTimeMillis();
        b(imageStatistics, f);
    }

    public static void i(ImageStatistics imageStatistics) {
        imageStatistics.v = System.currentTimeMillis();
        b(imageStatistics, e);
    }

    public static void j(ImageStatistics imageStatistics) {
        imageStatistics.t = System.currentTimeMillis();
        b(imageStatistics, c);
    }
}
