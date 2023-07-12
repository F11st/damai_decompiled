package com.alibaba.poplayer.trigger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class BaseConfigItem {
    private static final SimpleDateFormat sFormat;
    public boolean appear;
    public String debugInfo;
    public boolean embed;
    public String endTime;
    public boolean enqueue;
    public String entityId;
    public boolean exclusive;
    public Object extra;
    public boolean forcePopRespectingPriority;
    private String json;
    public String layerType;
    public String params;
    public int priority;
    public boolean showCloseBtn;
    public String startTime;
    public int times;
    public String type;
    public String uuid = "Undefined";
    public double modalThreshold = 0.8d;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayer.trigger.BaseConfigItem$a */
    /* loaded from: classes8.dex */
    public static class C3677a {
        public String a;
        public String[] b;
        public String c;

        public String toString() {
            return "{uri='" + this.a + "', uris=" + Arrays.toString(this.b) + ", paramContains='" + this.c + "'}";
        }
    }

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        sFormat = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }

    public long getEndTimeStamp() {
        try {
            return sFormat.parse(this.endTime).getTime();
        } catch (ParseException unused) {
            return Long.parseLong(this.endTime);
        }
    }

    public long getStartTimeStamp() {
        try {
            return sFormat.parse(this.startTime).getTime();
        } catch (ParseException unused) {
            return Long.parseLong(this.startTime);
        }
    }

    public String toString() {
        return "{appear=" + this.appear + ", startTime='" + this.startTime + "', endTime='" + this.endTime + "', uuid='" + this.uuid + "', times=" + this.times + ", embed=" + this.embed + ", modalThreshold=" + this.modalThreshold + ", showCloseBtn=" + this.showCloseBtn + ", layerType='" + this.layerType + "', type='" + this.type + "', params='" + this.params + "', priority=" + this.priority + ", enqueue=" + this.enqueue + ", forcePopRespectingPriority=" + this.forcePopRespectingPriority + ", exclusive=" + this.exclusive + ", debugInfo='" + this.debugInfo + "', extra=" + this.extra + ", json='" + this.json + "'}";
    }
}
