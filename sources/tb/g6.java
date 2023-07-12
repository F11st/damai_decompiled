package tb;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class g6 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String REMOVE_ANNOUNCEMENT = "remove_announcement";

    public static String a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1931213571")) {
            return (String) ipChange.ipc$dispatch("1931213571", new Object[]{context});
        }
        try {
            return my0.b("homepage_announcement_content", "", context);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void b(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-364133317")) {
            ipChange.ipc$dispatch("-364133317", new Object[]{context, str});
            return;
        }
        try {
            my0.c("homepage_announcement_content", str, context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
