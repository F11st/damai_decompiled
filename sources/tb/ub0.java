package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ub0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private final Map<String, Closeable> a = new HashMap();
    private boolean b;

    private final void c(Closeable closeable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-344905856")) {
            ipChange.ipc$dispatch("-344905856", new Object[]{this, closeable});
            return;
        }
        try {
            closeable.close();
        } catch (Exception e) {
            rq.b("DoloresViewModel", e);
        }
    }

    @NotNull
    public final Closeable a(@NotNull String str, @NotNull Closeable closeable) {
        Closeable closeable2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1182185166")) {
            return (Closeable) ipChange.ipc$dispatch("1182185166", new Object[]{this, str, closeable});
        }
        b41.i(str, "key");
        b41.i(closeable, "newValue");
        synchronized (this.a) {
            closeable2 = this.a.get(str);
            if (closeable2 == null) {
                this.a.put(str, closeable);
            }
            wt2 wt2Var = wt2.INSTANCE;
        }
        if (closeable2 != null) {
            closeable = closeable2;
        }
        if (this.b) {
            c(closeable);
        }
        return closeable;
    }

    public final void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1389588861")) {
            ipChange.ipc$dispatch("1389588861", new Object[]{this});
            return;
        }
        this.b = true;
        synchronized (this.a) {
            for (Map.Entry<String, Closeable> entry : this.a.entrySet()) {
                Closeable value = entry.getValue();
                if (value != null) {
                    c(value);
                }
            }
            wt2 wt2Var = wt2.INSTANCE;
        }
    }

    public final void d(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-427658587")) {
            ipChange.ipc$dispatch("-427658587", new Object[]{this, str});
            return;
        }
        b41.i(str, "key");
        synchronized (this.a) {
            this.a.remove(str);
        }
    }
}
