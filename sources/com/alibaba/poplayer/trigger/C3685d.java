package com.alibaba.poplayer.trigger;

import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.trigger.Event;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.util.List;
import tb.dt1;

/* compiled from: Taobao */
/* renamed from: com.alibaba.poplayer.trigger.d */
/* loaded from: classes8.dex */
public class C3685d<T extends Event> extends C3684c {
    public C3685d(AbstractC3683b abstractC3683b) {
        super(abstractC3683b);
    }

    public void c(T t, List<BaseConfigItem> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b(1024);
        long currentTimeStamp = PopLayer.getReference().getCurrentTimeStamp();
        long j = AbsPerformance.LONG_NIL;
        BaseConfigItem baseConfigItem = null;
        for (int i = 0; i < list.size(); i++) {
            long startTimeStamp = list.get(i).getStartTimeStamp() - currentTimeStamp;
            if (startTimeStamp > 0 && startTimeStamp < j) {
                baseConfigItem = list.get(i);
                j = startTimeStamp;
            }
        }
        if (j <= 0 || baseConfigItem == null) {
            return;
        }
        dt1.b("TriggerTimerMgr.checkTimeAndRescheduleIfNeed.UUID{%s}.timeNotStart.leftTime{%sms}.startLater", baseConfigItem.uuid, Long.valueOf(j));
        a(t, j, 1024);
    }
}
