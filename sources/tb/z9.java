package tb;

import android.app.Application;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class z9 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static Application a = null;
    private static String b = "";

    public static synchronized Application a() {
        synchronized (z9.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1418050692")) {
                return (Application) ipChange.ipc$dispatch("1418050692", new Object[0]);
            }
            if (a == null) {
                a = mu0.a();
            }
            return a;
        }
    }

    public static String b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-781282800")) {
            return (String) ipChange.ipc$dispatch("-781282800", new Object[]{str});
        }
        return c() + JSMethod.NOT_SET + str;
    }

    public static String c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "122469537")) {
            return (String) ipChange.ipc$dispatch("122469537", new Object[0]);
        }
        if (!TextUtils.equals("", b)) {
            b = "";
        }
        return b;
    }
}
