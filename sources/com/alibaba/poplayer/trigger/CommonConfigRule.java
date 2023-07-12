package com.alibaba.poplayer.trigger;

import com.alibaba.poplayer.PopLayer;
import tb.dt1;
import tb.et1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class CommonConfigRule {

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public enum ConfigStatus {
        INVALIED,
        VALIED,
        VALIED_BUT_UNSTARTED
    }

    private static boolean a(Event event, BaseConfigItem baseConfigItem) {
        if (2 == event.source) {
            long startTimeStamp = baseConfigItem.getStartTimeStamp();
            return startTimeStamp < baseConfigItem.getEndTimeStamp() && PopLayer.getReference().getCurrentTimeStamp() < startTimeStamp;
        }
        return false;
    }

    public static ConfigStatus b(Event event, BaseConfigItem baseConfigItem) {
        ConfigStatus configStatus = ConfigStatus.INVALIED;
        if (!d(baseConfigItem) && PopLayer.getReference().isValidConfig(baseConfigItem)) {
            if (c(baseConfigItem)) {
                return ConfigStatus.VALIED;
            }
            return a(event, baseConfigItem) ? ConfigStatus.VALIED_BUT_UNSTARTED : configStatus;
        }
        return configStatus;
    }

    private static boolean c(BaseConfigItem baseConfigItem) {
        if (baseConfigItem.appear) {
            dt1.b("ConfigManager.checkTimeAndRescheduleIfNeed.UUID{%s}.return.ignoreTime", baseConfigItem.uuid);
            return true;
        }
        long startTimeStamp = baseConfigItem.getStartTimeStamp();
        long endTimeStamp = baseConfigItem.getEndTimeStamp();
        if (endTimeStamp <= startTimeStamp) {
            dt1.a("ConfigManager.checkTimeAndRescheduleIfNeed.UUID{" + baseConfigItem.uuid + "}.error.endTime<=startTime");
            return false;
        }
        long currentTimeStamp = PopLayer.getReference().getCurrentTimeStamp();
        if (currentTimeStamp <= startTimeStamp || currentTimeStamp >= endTimeStamp) {
            dt1.b("ConfigManager.checkTimeAndRescheduleIfNeed.UUID{%s}.return.outOfTime", baseConfigItem.uuid);
            return false;
        }
        dt1.b("ConfigManager.checkTimeAndRescheduleIfNeed.UUID{%s}.return.timeToStart", baseConfigItem.uuid);
        return true;
    }

    private static boolean d(BaseConfigItem baseConfigItem) {
        if (baseConfigItem.times == 0) {
            return false;
        }
        int b = et1.b(baseConfigItem.uuid, 0);
        dt1.b("DefaultConfigManager.upToLimitPopupCount?localCount=%s&configTimes=%s", Integer.valueOf(b), Integer.valueOf(baseConfigItem.times));
        return b >= baseConfigItem.times;
    }
}
