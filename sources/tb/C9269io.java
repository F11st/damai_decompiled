package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* renamed from: tb.io */
/* loaded from: classes7.dex */
public class C9269io {
    private static transient /* synthetic */ IpChange $ipChange;
    private static boolean a;

    public static void a(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1005550851")) {
            ipChange.ipc$dispatch("1005550851", new Object[]{str, str2});
        }
    }

    public static void b(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1827836446")) {
            ipChange.ipc$dispatch("-1827836446", new Object[]{str, str2});
        }
    }

    public static boolean c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-823276434") ? ((Boolean) ipChange.ipc$dispatch("-823276434", new Object[0])).booleanValue() : a;
    }
}
