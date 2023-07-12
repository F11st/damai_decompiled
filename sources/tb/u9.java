package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class u9 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static u9 b;
    private String a;

    private u9() {
        this.a = "1.3";
        if (gj2.a()) {
            return;
        }
        this.a = "1.2";
    }

    public static synchronized u9 b() {
        synchronized (u9.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-6306839")) {
                return (u9) ipChange.ipc$dispatch("-6306839", new Object[0]);
            }
            if (b == null) {
                b = new u9();
            }
            return b;
        }
    }

    public String a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2046498725") ? (String) ipChange.ipc$dispatch("2046498725", new Object[]{this}) : this.a;
    }
}
