package tb;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class qw2 {
    private static transient /* synthetic */ IpChange $ipChange;
    public static boolean a;

    public static void a(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1588095258")) {
            ipChange.ipc$dispatch("-1588095258", new Object[]{str, str2});
        } else if (a) {
            Log.d(str, str2);
        }
    }

    public static void b(Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "145405284")) {
            ipChange.ipc$dispatch("145405284", new Object[]{th});
        } else {
            c(th, th.getMessage());
        }
    }

    public static void c(Throwable th, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1117441582")) {
            ipChange.ipc$dispatch("1117441582", new Object[]{th, str});
        } else if (a) {
            try {
                e(6, str, th);
            } catch (Exception e) {
                Log.e("damai", "Failed to e: " + e.getMessage());
            }
        }
    }

    public static void d(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1424837441")) {
            ipChange.ipc$dispatch("1424837441", new Object[]{str, str2});
        } else if (a) {
            Log.i(str, str2);
        }
    }

    private static void e(int i, String str, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "31709626")) {
            ipChange.ipc$dispatch("31709626", new Object[]{Integer.valueOf(i), str, th});
        } else if (a) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(th == null ? "" : Log.getStackTraceString(th));
                Log.println(i, "damai", sb.toString());
            } catch (Exception e) {
                Log.e("damai", "Failed to log: " + e.getMessage());
            }
        }
    }
}
