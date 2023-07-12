package tb;

import com.alibaba.appmonitor.event.EventType;
import com.alibaba.appmonitor.pool.C3316a;
import com.alibaba.appmonitor.pool.Reusable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class pf1 implements Reusable {
    private Map<nf1, qf0> a = Collections.synchronizedMap(new HashMap());

    public qf0 a(Integer num, String str, String str2, String str3, Class<? extends qf0> cls) {
        nf1 nf1Var;
        boolean z;
        qf0 qf0Var;
        boolean z2 = false;
        if (num.intValue() == EventType.STAT.getEventId()) {
            nf1Var = of1.c().b(str, str2);
            z = false;
        } else {
            nf1Var = (nf1) C3316a.a().poll(nf1.class, str, str2, str3);
            z = true;
        }
        qf0 qf0Var2 = null;
        if (nf1Var != null) {
            if (this.a.containsKey(nf1Var)) {
                qf0Var2 = this.a.get(nf1Var);
                z2 = z;
            } else {
                synchronized (pf1.class) {
                    qf0Var = (qf0) C3316a.a().poll(cls, num, str, str2, str3);
                    this.a.put(nf1Var, qf0Var);
                }
                qf0Var2 = qf0Var;
            }
            if (z2) {
                C3316a.a().offer(nf1Var);
            }
        }
        return qf0Var2;
    }

    public List<qf0> b() {
        return new ArrayList(this.a.values());
    }

    @Override // com.alibaba.appmonitor.pool.Reusable
    public void clean() {
        for (qf0 qf0Var : this.a.values()) {
            C3316a.a().offer(qf0Var);
        }
        this.a.clear();
    }

    @Override // com.alibaba.appmonitor.pool.Reusable
    public void fill(Object... objArr) {
        if (this.a == null) {
            this.a = Collections.synchronizedMap(new HashMap());
        }
    }
}
