package tb;

import cn.damai.message.observer.Action;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class xr {
    private static transient /* synthetic */ IpChange $ipChange;
    private ConcurrentHashMap<String, Action<?>> a = new ConcurrentHashMap<>();

    public static <T> void c(String str, T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1353663702")) {
            ipChange.ipc$dispatch("1353663702", new Object[]{str, t});
        } else {
            yr.c().b(str, t);
        }
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1277960563")) {
            ipChange.ipc$dispatch("-1277960563", new Object[]{this});
            return;
        }
        for (Map.Entry<String, Action<?>> entry : this.a.entrySet()) {
            yr.c().a(entry.getKey(), entry.getValue());
        }
        this.a.clear();
    }

    public synchronized <T> void b(String str, Action<T> action) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2005106526")) {
            ipChange.ipc$dispatch("2005106526", new Object[]{this, str, action});
            return;
        }
        if (yr.c().e(str, action)) {
            this.a.put(str, action);
        }
    }
}
