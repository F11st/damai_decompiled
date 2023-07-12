package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class r3 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static r3 d;
    private final HashMap<String, Integer> a = new HashMap<>();
    private int b = 10000;
    private long[] c = new long[2];

    public static r3 a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1621593595")) {
            return (r3) ipChange.ipc$dispatch("1621593595", new Object[0]);
        }
        if (d == null) {
            synchronized (r3.class) {
                if (d == null) {
                    d = new r3();
                }
            }
        }
        return d;
    }

    public int b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1361928799")) {
            return ((Integer) ipChange.ipc$dispatch("-1361928799", new Object[]{this, str})).intValue();
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        Integer num = this.a.get(str);
        if (num == null) {
            int i = this.b + 1;
            this.b = i;
            this.a.put(str, Integer.valueOf(i));
            return this.b;
        }
        return num.intValue();
    }

    public int c(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-362764652")) {
            return ((Integer) ipChange.ipc$dispatch("-362764652", new Object[]{this, Long.valueOf(j)})).intValue();
        }
        hg.b(j, this.c);
        return (int) this.c[1];
    }
}
