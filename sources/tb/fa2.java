package tb;

import com.alibaba.analytics.core.selfmonitor.SelfMonitorEventListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class fa2 {
    private static SelfMonitorEventListener b;
    private List<SelfMonitorEventListener> a = Collections.synchronizedList(new ArrayList());

    public void a(SelfMonitorEventListener selfMonitorEventListener) {
        try {
            this.a.add(selfMonitorEventListener);
        } catch (Exception unused) {
        }
    }

    public void onEvent(ea2 ea2Var) {
        try {
            SelfMonitorEventListener selfMonitorEventListener = b;
            if (selfMonitorEventListener != null) {
                selfMonitorEventListener.onEvent(ea2Var);
            }
            for (int i = 0; i < this.a.size(); i++) {
                this.a.get(i).onEvent(ea2Var);
            }
        } catch (Exception unused) {
        }
    }
}
