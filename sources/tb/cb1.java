package tb;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class cb1 {
    private static transient /* synthetic */ IpChange $ipChange;
    public static boolean a;

    public static void a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1454814375")) {
            ipChange.ipc$dispatch("-1454814375", new Object[]{str});
        } else if (a) {
            h(3, str, null);
        }
    }

    public static void b(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "917352675")) {
            ipChange.ipc$dispatch("917352675", new Object[]{str, str2});
        } else if (a) {
            Log.d(str, str2);
        }
    }

    public static void c(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1916034622")) {
            ipChange.ipc$dispatch("-1916034622", new Object[]{str, str2});
        } else if (a) {
            Log.e(str, str2);
        }
    }

    public static void d(Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1025146617")) {
            ipChange.ipc$dispatch("-1025146617", new Object[]{th});
        } else if (th != null) {
            e(th, th.getMessage());
        }
    }

    public static void e(Throwable th, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1319823599")) {
            ipChange.ipc$dispatch("-1319823599", new Object[]{th, str});
        } else if (a) {
            try {
                h(6, str, th);
            } catch (Exception e) {
                Log.e("damai", "Failed to e: " + e.getMessage());
            }
        }
    }

    public static void f(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-883711255")) {
            ipChange.ipc$dispatch("-883711255", new Object[]{str, str2});
        } else if (a) {
            Log.e(str, str2 + " [thread:" + Thread.currentThread().getName() + ",mills:" + System.currentTimeMillis() + jn1.ARRAY_END_STR);
        }
    }

    public static void g(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-364681922")) {
            ipChange.ipc$dispatch("-364681922", new Object[]{str, str2});
        } else if (a) {
            Log.i(str, str2);
        }
    }

    private static void h(int i, String str, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2113158665")) {
            ipChange.ipc$dispatch("-2113158665", new Object[]{Integer.valueOf(i), str, th});
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
