package com.alibaba.appmonitor.event;

import com.alibaba.analytics.utils.Logger;
import com.alibaba.appmonitor.sample.AlarmConfig;
import com.alibaba.appmonitor.sample.CounterConfig;
import com.alibaba.appmonitor.sample.StatConfig;
import com.taobao.android.tlog.protocol.Constants;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public enum EventType {
    ALARM(65501, 30, "alarmData", 1000, "ap_alarm", AlarmConfig.class),
    COUNTER(65502, 30, "counterData", 1000, "ap_counter", CounterConfig.class),
    STAT(65503, 30, Constants.KEY_STAT_DATA, 1000, "ap_stat", StatConfig.class);
    
    static String TAG = "EventType";
    private String aggregateEventArgsKey;
    private Class cls;
    private int defaultSampling;
    private int eventId;
    private String namespce;
    private int triggerCount;
    private int foregroundStatisticsInterval = 25;
    private int backgroundStatisticsInterval = 300;
    private boolean open = true;

    EventType(int i, int i2, String str, int i3, String str2, Class cls) {
        this.eventId = i;
        this.triggerCount = i2;
        this.aggregateEventArgsKey = str;
        this.defaultSampling = i3;
        this.namespce = str2;
        this.cls = cls;
    }

    public static EventType getEventType(int i) {
        EventType[] values;
        for (EventType eventType : values()) {
            if (eventType != null && eventType.getEventId() == i) {
                return eventType;
            }
        }
        return null;
    }

    public static EventType getEventTypeByNameSpace(String str) {
        EventType[] values;
        if (str == null) {
            return null;
        }
        for (EventType eventType : values()) {
            if (eventType != null && str.equalsIgnoreCase(eventType.getNameSpace())) {
                return eventType;
            }
        }
        return null;
    }

    private String getNameSpace() {
        return this.namespce;
    }

    public String getAggregateEventArgsKey() {
        return this.aggregateEventArgsKey;
    }

    public int getBackgroundStatisticsInterval() {
        return this.backgroundStatisticsInterval;
    }

    public Class getCls() {
        return this.cls;
    }

    public int getDefaultSampling() {
        return this.defaultSampling;
    }

    public int getEventId() {
        return this.eventId;
    }

    public int getForegroundStatisticsInterval() {
        return this.foregroundStatisticsInterval;
    }

    public int getTriggerCount() {
        return this.triggerCount;
    }

    public boolean isOpen() {
        return this.open;
    }

    public void setDefaultSampling(int i) {
        this.defaultSampling = i;
    }

    public void setOpen(boolean z) {
        this.open = z;
    }

    public void setStatisticsInterval(int i) {
        this.foregroundStatisticsInterval = i;
    }

    @Deprecated
    public void setTriggerCount(int i) {
        String str = TAG;
        Logger.f(str, "[setTriggerCount]", this.aggregateEventArgsKey, i + "");
        this.triggerCount = i;
    }
}
