package tb;

import cn.damai.ticklet.bean.TicketDeatilResult;
import cn.damai.ticklet.ui.observer.Observer;
import cn.damai.ticklet.ui.observer.Observerable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class kn2 implements Observerable {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<Observer> a = new ArrayList();
    private TicketDeatilResult b;

    public void a(Observer observer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "397091510")) {
            ipChange.ipc$dispatch("397091510", new Object[]{this, observer});
        } else if (observer != null) {
            observer.update(this.b);
        }
    }

    public void b(TicketDeatilResult ticketDeatilResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "694834323")) {
            ipChange.ipc$dispatch("694834323", new Object[]{this, ticketDeatilResult});
            return;
        }
        this.b = ticketDeatilResult;
        notifyObserver();
    }

    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1339781871")) {
            ipChange.ipc$dispatch("-1339781871", new Object[]{this});
        } else {
            this.a.clear();
        }
    }

    @Override // cn.damai.ticklet.ui.observer.Observerable
    public void notifyObserver() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1815263230")) {
            ipChange.ipc$dispatch("1815263230", new Object[]{this});
        } else if (!this.a.isEmpty()) {
            for (int i = 0; i < this.a.size(); i++) {
                this.a.get(i).update(this.b);
            }
        }
    }

    @Override // cn.damai.ticklet.ui.observer.Observerable
    public void registerObserver(Observer observer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1918588317")) {
            ipChange.ipc$dispatch("1918588317", new Object[]{this, observer});
            return;
        }
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.add(observer);
    }

    @Override // cn.damai.ticklet.ui.observer.Observerable
    public void removeObserver(Observer observer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-433267906")) {
            ipChange.ipc$dispatch("-433267906", new Object[]{this, observer});
        } else if (this.a.isEmpty()) {
        } else {
            this.a.remove(observer);
        }
    }
}
