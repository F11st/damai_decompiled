package tb;

import android.content.SharedPreferences;
import android.text.TextUtils;
import cn.damai.common.AppConfig;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class b23 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String MTOP_XFLUSH_SUCCESS_CODE = "2000";
    public static String a = "damai-android";
    public static String b = "failureMonitor";

    public static void a(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-982104354")) {
            ipChange.ipc$dispatch("-982104354", new Object[]{str, str2, str3});
        } else if (j()) {
        } else {
            try {
                k(a, b, str, str2, str3, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void b(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "182929089")) {
            ipChange.ipc$dispatch("182929089", new Object[]{str, str2, str3, str4, str5});
        } else if (j()) {
        } else {
            try {
                k(str, str2, str3, str4, str5, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void c(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1200823540")) {
            ipChange.ipc$dispatch("1200823540", new Object[]{str, str2, str3, str4, str5});
        } else if (j()) {
        } else {
            try {
                k(str, str2, str3, str4, str5, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-886026543")) {
            ipChange.ipc$dispatch("-886026543", new Object[]{str});
        } else if (j()) {
        } else {
            k(a, str, "", "", "", true);
        }
    }

    public static void e(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1913139045")) {
            ipChange.ipc$dispatch("1913139045", new Object[]{str, str2, str3});
        } else if (j()) {
        } else {
            try {
                k(str, str2, str3, "", "", true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void f(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-277457415")) {
            ipChange.ipc$dispatch("-277457415", new Object[]{str, str2, str3, str4, str5});
        } else if (j()) {
        } else {
            try {
                k(str, str2, str5, str3, str4, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void g(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1368082013")) {
            ipChange.ipc$dispatch("1368082013", new Object[]{str, str2, str3});
        } else if (j()) {
        } else {
            try {
                AppMonitor.Alarm.setSampling(10000);
                String str4 = a;
                String str5 = b;
                k(str4, str5, "DMTOP|" + str, str2, str3, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void h(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-181374233")) {
            ipChange.ipc$dispatch("-181374233", new Object[]{str, str2, str3, str4});
        } else if (j()) {
        } else {
            try {
                AppMonitor.Alarm.setSampling(10000);
                String str5 = a;
                k(str5, str, "DMTOP|" + str2, str3, str4, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String i(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1185814483")) {
            return (String) ipChange.ipc$dispatch("1185814483", new Object[]{str, str2, str3, str4, str5});
        }
        StringBuilder sb = new StringBuilder();
        sb.append(jn1.BLOCK_START_STR);
        if (!TextUtils.isEmpty(str)) {
            sb.append(" api:" + str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(", apiName:" + str2);
        }
        if (!TextUtils.isEmpty(str5)) {
            sb.append(AVFSCacheConstants.COMMA_SEP + str5);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(", retCode:" + str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(", retMsg:" + str4);
        }
        sb.append(" }");
        return sb.toString();
    }

    public static boolean j() {
        SharedPreferences sharedPreferences;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1631142298")) {
            return ((Boolean) ipChange.ipc$dispatch("1631142298", new Object[0])).booleanValue();
        }
        if (AppConfig.v()) {
            if (mu0.a() == null || (sharedPreferences = mu0.a().getSharedPreferences("popcorn", 0)) == null) {
                return true;
            }
            return !sharedPreferences.getBoolean("alarm_status", false);
        }
        return false;
    }

    private static void k(String str, String str2, String str3, String str4, String str5, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1750568073")) {
            ipChange.ipc$dispatch("-1750568073", new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(z)});
            return;
        }
        try {
            ps.a(str, str2, str3, str4, str5, z);
        } catch (Exception unused) {
        }
    }
}
