package tb;

import android.util.SparseLongArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class fd {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int PHASE_APP_CREATE_2_SPLASH_RESUME = 101;
    public static final int PHASE_APP_ON_CREATE = 100;
    public static final String TAG = "BootYu";
    public static boolean a = true;
    private static final SparseLongArray b = new SparseLongArray();

    public static void a(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "381323803")) {
            ipChange.ipc$dispatch("381323803", new Object[]{str, Integer.valueOf(i)});
        } else if (a) {
            b(TAG, str, i);
        }
    }

    public static void b(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "148636561")) {
            ipChange.ipc$dispatch("148636561", new Object[]{str, str2, Integer.valueOf(i)});
        } else if (a) {
            cb1.f(str, str2 + " cost:" + (System.currentTimeMillis() - b.get(i)) + "ms");
        }
    }

    public static void c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "611989129")) {
            ipChange.ipc$dispatch("611989129", new Object[]{str});
        } else if (a) {
            b(TAG, str, 10000);
            d();
        }
    }

    public static void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-209637218")) {
            ipChange.ipc$dispatch("-209637218", new Object[0]);
        } else if (a) {
            b.put(10000, System.currentTimeMillis());
        }
    }

    public static void e(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2091210277")) {
            ipChange.ipc$dispatch("2091210277", new Object[]{Integer.valueOf(i)});
        } else if (a) {
            b.put(i, System.currentTimeMillis());
        }
    }
}
