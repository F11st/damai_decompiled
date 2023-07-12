package tb;

import android.os.SystemClock;
import cn.damai.trade.R$string;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class gn2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int ADAPTER_BOTTON = 4;
    public static final int ADAPTER_NOTICE = 3;
    public static final int ADAPTER_PRE_ONE_LINE = 2;
    public static final int ADAPTER_PRE_TWO_LINE = 1;
    public static final int ADAPTER_TITLE = 0;
    public static final int CHECK_APP_VERSION = 1;
    public static final int CHECK_LOGIN = 2;
    public static final int CHECK_NETWORK = 3;
    public static final int CHECK_REMIND = 4;
    private static gn2 f;
    private HashMap<String, Integer> a = new HashMap<>();
    private HashMap<String, Integer> b = new HashMap<>();
    private HashMap<String, Integer> c = new HashMap<>();
    private long d;
    private long e;

    private gn2() {
        i();
        j();
        h();
    }

    public static gn2 b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1211099227")) {
            return (gn2) ipChange.ipc$dispatch("1211099227", new Object[0]);
        }
        if (f == null) {
            f = new gn2();
        }
        return f;
    }

    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-463364686")) {
            ipChange.ipc$dispatch("-463364686", new Object[]{this});
            return;
        }
        this.c.clear();
        this.c.put("UpgradeModule", 1);
        this.c.put("LoginCheckModule", 2);
        this.c.put("NetworkModule", 3);
        this.c.put("ReminderModule", 4);
    }

    private void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1307239925")) {
            ipChange.ipc$dispatch("-1307239925", new Object[]{this});
            return;
        }
        this.a.clear();
        this.a.put("UpgradeModule", Integer.valueOf(R$string.iconfont_shengjibanben));
        this.a.put("LoginCheckModule", Integer.valueOf(R$string.iconfont_dengluzhanghao));
        this.a.put("NetworkModule", Integer.valueOf(R$string.iconfont_wi_fi));
        this.a.put("ReminderModule", Integer.valueOf(R$string.iconfont_rili));
        this.a.put("PreFillModule", Integer.valueOf(R$string.iconfont_tianxie));
    }

    private void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "495862698")) {
            ipChange.ipc$dispatch("495862698", new Object[]{this});
            return;
        }
        this.b.clear();
        this.b.put("UpgradeModule", 1);
        this.b.put("LoginCheckModule", 1);
        this.b.put("NetworkModule", 1);
        this.b.put("ReminderModule", 1);
        this.b.put("PreFillModule", 2);
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-77247345")) {
            ipChange.ipc$dispatch("-77247345", new Object[]{this});
            return;
        }
        this.d = 0L;
        this.e = SystemClock.elapsedRealtime();
    }

    public int c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-497014715")) {
            return ((Integer) ipChange.ipc$dispatch("-497014715", new Object[]{this, str})).intValue();
        }
        if (str == null || !this.c.containsKey(str)) {
            return 1;
        }
        return this.c.get(str).intValue();
    }

    public int d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "292111256")) {
            return ((Integer) ipChange.ipc$dispatch("292111256", new Object[]{this, str})).intValue();
        }
        if (str != null && this.a.containsKey(str)) {
            return this.a.get(str).intValue();
        }
        return R$string.iconfont_shengjibanben;
    }

    public int e(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-149101705")) {
            return ((Integer) ipChange.ipc$dispatch("-149101705", new Object[]{this, str})).intValue();
        }
        if (str == null || !this.b.containsKey(str)) {
            return 1;
        }
        return this.b.get(str).intValue();
    }

    public long f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1181152927")) {
            return ((Long) ipChange.ipc$dispatch("1181152927", new Object[]{this})).longValue();
        }
        long j = this.d;
        if (j <= 0) {
            return 0L;
        }
        long elapsedRealtime = (((j * 1000) + this.e) - SystemClock.elapsedRealtime()) / 1000;
        this.d = elapsedRealtime;
        return elapsedRealtime;
    }

    public boolean g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-327838972") ? ((Boolean) ipChange.ipc$dispatch("-327838972", new Object[]{this})).booleanValue() : f() > 600;
    }

    public void k(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1514855776")) {
            ipChange.ipc$dispatch("-1514855776", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.d = j;
        this.e = SystemClock.elapsedRealtime();
    }
}
