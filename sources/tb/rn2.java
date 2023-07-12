package tb;

import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.ui.observer.ObserverTicket;
import cn.damai.ticklet.ui.observer.ObserverableTicket;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class rn2 implements ObserverableTicket {
    private static transient /* synthetic */ IpChange $ipChange;
    private static rn2 c = new rn2();
    private List<ObserverTicket> a = new ArrayList();
    private UserTicketTable b;

    public static rn2 a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1609671667") ? (rn2) ipChange.ipc$dispatch("1609671667", new Object[0]) : c;
    }

    public void b(UserTicketTable userTicketTable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1261967642")) {
            ipChange.ipc$dispatch("-1261967642", new Object[]{this, userTicketTable});
            return;
        }
        this.b = userTicketTable;
        notifyObserver();
    }

    @Override // cn.damai.ticklet.ui.observer.ObserverableTicket
    public void notifyObserver() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2089799042")) {
            ipChange.ipc$dispatch("-2089799042", new Object[]{this});
        } else if (!this.a.isEmpty()) {
            for (int i = 0; i < this.a.size(); i++) {
                this.a.get(i).update(this.b);
            }
        }
    }

    @Override // cn.damai.ticklet.ui.observer.ObserverableTicket
    public void registerObserver(ObserverTicket observerTicket) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-711417679")) {
            ipChange.ipc$dispatch("-711417679", new Object[]{this, observerTicket});
            return;
        }
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.add(observerTicket);
    }

    @Override // cn.damai.ticklet.ui.observer.ObserverableTicket
    public void removeObserver(ObserverTicket observerTicket) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-171112046")) {
            ipChange.ipc$dispatch("-171112046", new Object[]{this, observerTicket});
        } else if (this.a.isEmpty()) {
        } else {
            this.a.remove(observerTicket);
        }
    }
}
