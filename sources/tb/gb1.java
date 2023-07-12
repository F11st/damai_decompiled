package tb;

import android.text.TextUtils;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class gb1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String a = "x_log";
    static boolean b;

    public static void a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1670736536")) {
            ipChange.ipc$dispatch("-1670736536", new Object[]{str});
        } else if (b) {
            Log.d(d(), str);
        }
    }

    public static void b(String str, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1170190451")) {
            ipChange.ipc$dispatch("-1170190451", new Object[]{str, th});
        } else if (b) {
            Log.d(d(), str, th);
        }
    }

    public static void c(String str, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1618887090")) {
            ipChange.ipc$dispatch("-1618887090", new Object[]{str, th});
        } else if (b) {
            Log.e(d(), str, th);
        }
    }

    private static String d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1887180931")) {
            return (String) ipChange.ipc$dispatch("1887180931", new Object[0]);
        }
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        String className = stackTraceElement.getClassName();
        String format = String.format("%s.%s(L:%d)", className.substring(className.lastIndexOf(".") + 1), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber()));
        if (TextUtils.isEmpty(a)) {
            return format;
        }
        return a + ":" + format;
    }
}
