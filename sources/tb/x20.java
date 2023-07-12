package tb;

import android.text.TextUtils;
import cn.damai.push.DaMaiPushAgent;
import com.alibaba.pictures.accs.PushAgent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.AccsException;
import com.taobao.tao.log.TLog;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class x20 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ACCSS_HAVANAID_CONFIG = "accs_havanaid_config";
    public static final String ACCSS_HAVANAID_ENABLED = "accs_havanaid_enabled";

    public static void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "381889099")) {
            ipChange.ipc$dispatch("381889099", new Object[0]);
            return;
        }
        try {
            ACCSClient accsClient = ACCSClient.getAccsClient("default");
            if (accsClient != null && !TextUtils.isEmpty(c())) {
                accsClient.bindUser(String.valueOf(c()));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        e();
    }

    public static void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1774292366")) {
            ipChange.ipc$dispatch("-1774292366", new Object[0]);
            return;
        }
        try {
            ACCSClient accsClient = ACCSClient.getAccsClient("default");
            if (accsClient != null) {
                accsClient.unbindUser();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        f();
    }

    public static String c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1676155552")) {
            return (String) ipChange.ipc$dispatch("1676155552", new Object[0]);
        }
        String i = z20.i();
        if (!d().booleanValue() || TextUtils.isEmpty(i)) {
            i = z20.E();
        }
        if (TextUtils.isEmpty(i)) {
            return null;
        }
        return i;
    }

    private static Boolean d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1724629978") ? (Boolean) ipChange.ipc$dispatch("-1724629978", new Object[0]) : Boolean.TRUE;
    }

    public static void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-56031768")) {
            ipChange.ipc$dispatch("-56031768", new Object[0]);
        } else {
            PushAgent.b(mu0.a(), c());
        }
    }

    private static void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2045591628")) {
            ipChange.ipc$dispatch("2045591628", new Object[0]);
        } else {
            PushAgent.r(mu0.a());
        }
    }

    public static void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1742772190")) {
            ipChange.ipc$dispatch("-1742772190", new Object[0]);
            return;
        }
        try {
            if (z20.H() != null) {
                ACCSClient.getAccsClient("youku").bindUser(z20.H());
            }
        } catch (AccsException e) {
            e.printStackTrace();
        }
    }

    public static void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-837226839")) {
            ipChange.ipc$dispatch("-837226839", new Object[0]);
            return;
        }
        try {
            ACCSClient.getAccsClient("youku").unbindUser();
        } catch (AccsException e) {
            TLog.logw(DaMaiPushAgent.TAG_ACCS, "Accs-Youku unbindUser AccsException", e);
        }
    }
}
