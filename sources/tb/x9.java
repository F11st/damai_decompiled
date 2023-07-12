package tb;

import com.alibaba.analytics.utils.Logger;
import com.alibaba.analytics.utils.UTServerAppStatusTrigger;
import com.alibaba.appmonitor.delegate.C3309a;
import com.alibaba.appmonitor.event.EventType;
import com.alibaba.appmonitor.sample.C3317a;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class x9 implements UTServerAppStatusTrigger.UTServerAppStatusChangeCallback {
    private static x9 a = new x9();

    private x9() {
        UTServerAppStatusTrigger.d(this);
    }

    public static x9 a() {
        return a;
    }

    private void b(boolean z) {
        int i = 0;
        Logger.f("BackgroundTrigger", "isAppOnForeground", Boolean.valueOf(z));
        if (z) {
            C3317a.h().p();
            EventType[] values = EventType.values();
            int length = values.length;
            while (i < length) {
                EventType eventType = values[i];
                C3309a.o(eventType, eventType.getForegroundStatisticsInterval());
                i++;
            }
            return;
        }
        EventType[] values2 = EventType.values();
        int length2 = values2.length;
        while (i < length2) {
            EventType eventType2 = values2[i];
            C3309a.o(eventType2, eventType2.getBackgroundStatisticsInterval());
            i++;
        }
        C3309a.p();
    }

    @Override // com.alibaba.analytics.utils.UTServerAppStatusTrigger.UTServerAppStatusChangeCallback
    public void onBackground() {
        b(false);
    }

    @Override // com.alibaba.analytics.utils.UTServerAppStatusTrigger.UTServerAppStatusChangeCallback
    public void onForeground() {
        b(true);
    }
}
