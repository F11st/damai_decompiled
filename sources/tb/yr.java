package tb;

import cn.damai.message.observer.Action;
import cn.damai.message.subscribe.EventCenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class yr {
    private static transient /* synthetic */ IpChange $ipChange;
    private HashMap<String, EventCenter> a;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    private static class b {
        private static final yr a = new yr();
    }

    public static yr c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1755104352") ? (yr) ipChange.ipc$dispatch("1755104352", new Object[0]) : b.a;
    }

    private EventCenter d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1352845922")) {
            return (EventCenter) ipChange.ipc$dispatch("-1352845922", new Object[]{this, str});
        }
        if (!this.a.containsKey(str)) {
            EventCenter eventCenter = new EventCenter();
            this.a.put(str, eventCenter);
            return eventCenter;
        }
        EventCenter eventCenter2 = this.a.get(str);
        return eventCenter2 == null ? new EventCenter() : eventCenter2;
    }

    public void a(String str, Action<?> action) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1295186137")) {
            ipChange.ipc$dispatch("1295186137", new Object[]{this, str, action});
            return;
        }
        EventCenter eventCenter = this.a.get(str);
        if (eventCenter == null) {
            return;
        }
        eventCenter.h(action);
        if (eventCenter.d()) {
            return;
        }
        this.a.remove(str);
    }

    public synchronized <T> void b(String str, T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-759212013")) {
            ipChange.ipc$dispatch("-759212013", new Object[]{this, str, t});
        } else {
            d(str).j(t);
        }
    }

    public synchronized <T> boolean e(String str, Action<T> action) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "229275456")) {
            return ((Boolean) ipChange.ipc$dispatch("229275456", new Object[]{this, str, action})).booleanValue();
        } else if (action == null) {
            return false;
        } else {
            return d(str).c(action);
        }
    }

    private yr() {
        this.a = new HashMap<>();
    }
}
