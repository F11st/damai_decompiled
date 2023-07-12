package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class uf<EventData, BizResponse> {
    private static transient /* synthetic */ IpChange $ipChange;
    private EventData a;

    public uf(EventData eventdata) {
        this.a = eventdata;
    }

    public final EventData a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "98995005") ? (EventData) ipChange.ipc$dispatch("98995005", new Object[]{this}) : this.a;
    }
}
