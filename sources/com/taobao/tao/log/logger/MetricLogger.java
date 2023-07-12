package com.taobao.tao.log.logger;

import androidx.annotation.Keep;
import com.alibaba.fastjson.annotation.JSONField;
import com.taobao.tao.log.LogCategory;
import com.taobao.tao.log.LogLevel;
import com.taobao.tao.log.TLogNative;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import tb.zp0;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class MetricLogger extends ILogger implements Serializable {
    public static final int METRIC_TRIGGER_LAUNCH = 1;
    public static final int METRIC_TRIGGER_MANUAL = 4;
    public static final int METRIC_TRIGGER_PAGE = 2;
    public static final int METRIC_TRIGGER_SCHEDULE = 3;
    public static final int METRIC_TYPE_APP = 1;
    public static final int METRIC_TYPE_CUSTOM = 2;
    private static final String TAG = "MetricLog";
    @JSONField(name = "id")
    private String pageID = null;
    @JSONField(name = "ts")
    private long time = System.currentTimeMillis();
    @JSONField(name = zp0.KEY_TRIGGER)
    private int trigger;
    @JSONField(name = "type")
    private int type;

    private MetricLogger(int i, int i2) {
        this.type = i;
        this.trigger = i2;
    }

    public static MetricLogger builder(int i, int i2) {
        return new MetricLogger(i, i2);
    }

    public String getPageID() {
        return this.pageID;
    }

    public int getTrigger() {
        return this.trigger;
    }

    public int getType() {
        return this.type;
    }

    @Override // com.taobao.tao.log.logger.ILogger
    public void log() {
        Map<String, String> map = this.data;
        if (map == null || map.isEmpty()) {
            return;
        }
        TLogNative.writeLog(LogCategory.EventLog, LogLevel.I, TAG, "", toString());
    }

    public MetricLogger setData(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            if (this.data == null) {
                this.data = new HashMap();
            }
            this.data.putAll(map);
        }
        return this;
    }

    public MetricLogger setPageID(String str) {
        this.pageID = str;
        return this;
    }

    public MetricLogger setTime(long j) {
        setData("ts", String.valueOf(j));
        return this;
    }

    public MetricLogger setData(String str, String str2) {
        if (this.data == null) {
            this.data = new HashMap();
        }
        this.data.put(str, str2);
        return this;
    }

    public MetricLogger setData(Map.Entry<String, String> entry) {
        if (this.data == null) {
            this.data = new HashMap();
        }
        this.data.put(entry.getKey(), entry.getValue());
        return this;
    }
}
