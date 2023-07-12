package tb;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class jb1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String a = "Tetris.";

    public static void a(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1982779299")) {
            ipChange.ipc$dispatch("-1982779299", new Object[]{str, str2});
        } else if (c()) {
            Log.d(a + str, str2);
        }
    }

    public static void b(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-521199300")) {
            ipChange.ipc$dispatch("-521199300", new Object[]{str, str2});
        } else if (c()) {
            Log.e(a + str, str2);
        }
    }

    public static boolean c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-168530070")) {
            return ((Boolean) ipChange.ipc$dispatch("-168530070", new Object[0])).booleanValue();
        }
        return true;
    }
}
