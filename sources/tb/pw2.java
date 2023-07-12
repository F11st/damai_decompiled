package tb;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class pw2 {
    private static transient /* synthetic */ IpChange $ipChange;
    public static boolean a;

    public static void a(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-977522643")) {
            ipChange.ipc$dispatch("-977522643", new Object[]{str, str2});
        } else if (a) {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "484057356")) {
            ipChange.ipc$dispatch("484057356", new Object[]{str, str2});
        } else if (a) {
            Log.e(str, str2);
        }
    }

    public static void c(Throwable th, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1499716487")) {
            ipChange.ipc$dispatch("1499716487", new Object[]{th, str});
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
        if (AndroidInstantRuntime.support(ipChange, "2035410056")) {
            ipChange.ipc$dispatch("2035410056", new Object[]{str, str2});
        } else if (a) {
            Log.i(str, str2);
        }
    }

    private static void e(int i, String str, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1869864511")) {
            ipChange.ipc$dispatch("-1869864511", new Object[]{Integer.valueOf(i), str, th});
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
