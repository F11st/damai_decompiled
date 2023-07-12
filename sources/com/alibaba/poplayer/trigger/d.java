package com.alibaba.poplayer.trigger;

import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.trigger.Event;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.util.List;
import tb.dt1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class d<T extends Event> extends c {
    public d(b bVar) {
        super(bVar);
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
