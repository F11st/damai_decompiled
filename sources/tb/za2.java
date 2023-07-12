package tb;

import android.text.TextUtils;
import com.alibaba.analytics.core.config.SystemConfigMgr;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.utils.Logger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class za2 {
    private static za2 j = new za2();
    private long a;
    private String b;
    private String c = "";
    private final AtomicInteger d = new AtomicInteger(0);
    private final AtomicInteger e = new AtomicInteger(0);
    private final Set<String> f = new HashSet();
    private final Set<String> g = new HashSet();
    private final HashMap<String, AtomicInteger> h = new HashMap<>();
    private final AtomicInteger i = new AtomicInteger(0);

    private za2() {
        c();
    }

    public static za2 a() {
        return j;
    }

    private synchronized void c() {
        this.a = System.currentTimeMillis();
        String str = "" + this.a;
        this.b = str;
        if (!TextUtils.isEmpty(str)) {
            if (this.b.length() >= 2) {
                String str2 = this.b;
                this.c = str2.substring(str2.length() - 2);
            } else {
                this.c = this.b;
            }
        }
        this.d.set(0);
        this.e.set(0);
        this.f.clear();
        this.f.add("65501");
        this.f.add("65502");
        this.f.add("65503");
        this.f.add("19998");
        this.f.add("19997");
        this.g.clear();
        this.g.add("1010");
        this.g.add("1023");
        this.g.add("2001");
        this.g.add("2101");
        this.g.add("2201");
        this.g.add("2202");
        this.g.add("65501");
        this.g.add("65502");
        this.g.add("65503");
        this.g.add("19998");
        this.g.add("19997");
        this.g.add("2006");
        this.h.clear();
        this.h.put("1010", new AtomicInteger(0));
        this.h.put("1023", new AtomicInteger(0));
        this.h.put("2001", new AtomicInteger(0));
        this.h.put("2101", new AtomicInteger(0));
        this.h.put("2201", new AtomicInteger(0));
        this.h.put("2202", new AtomicInteger(0));
        this.h.put("65501", new AtomicInteger(0));
        this.h.put("65502", new AtomicInteger(0));
        this.h.put("65503", new AtomicInteger(0));
        this.h.put("19998", new AtomicInteger(0));
        this.h.put("19997", new AtomicInteger(0));
        this.h.put("2006", new AtomicInteger(0));
        this.i.set(0);
    }

    public synchronized long b() {
        return this.a;
    }

    public synchronized void d(String str, Map<String, String> map) {
        int i;
        int incrementAndGet;
        if (map == null) {
            map = new HashMap<>();
        }
        if ("1".equals(SystemConfigMgr.i().h("ut_old_index"))) {
            map.put(LogField.RESERVE3.toString(), String.format("%s%06d", this.c, Integer.valueOf(this.d.incrementAndGet())));
            map.put(LogField.START_SESSION_TIMESTAMP.toString(), this.b);
            return;
        }
        long j2 = 0;
        if (!this.f.contains(str)) {
            i = this.e.incrementAndGet();
        } else {
            i = this.e.get();
        }
        long j3 = i;
        if (this.g.contains(str)) {
            AtomicInteger atomicInteger = this.h.get(str);
            if (atomicInteger != null) {
                incrementAndGet = atomicInteger.incrementAndGet();
            }
            map.put(LogField.RESERVE3.toString(), String.format("%s%06d,%s%06d", this.c, Long.valueOf(j3), this.c, Long.valueOf(j2)));
            map.put(LogField.START_SESSION_TIMESTAMP.toString(), this.b);
        }
        incrementAndGet = this.i.incrementAndGet();
        j2 = incrementAndGet;
        map.put(LogField.RESERVE3.toString(), String.format("%s%06d,%s%06d", this.c, Long.valueOf(j3), this.c, Long.valueOf(j2)));
        map.put(LogField.START_SESSION_TIMESTAMP.toString(), this.b);
    }

    public synchronized void e() {
        Logger.f("SessionTimeAndIndexMgr", "changeSession");
        c();
    }
}
