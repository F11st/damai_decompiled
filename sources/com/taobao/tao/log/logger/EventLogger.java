package com.taobao.tao.log.logger;

import androidx.annotation.Keep;
import com.alibaba.fastjson.annotation.JSONField;
import com.taobao.tao.log.LogCategory;
import com.taobao.tao.log.LogLevel;
import com.taobao.tao.log.TLogNative;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class EventLogger extends ILogger implements Serializable {
    public static final int EVENT_TYPE_BACKGROUND = 3;
    public static final int EVENT_TYPE_CHANGE = 6;
    public static final int EVENT_TYPE_CLICK = 7;
    public static final int EVENT_TYPE_EXCEPTION = 5;
    public static final int EVENT_TYPE_FOREGROUND = 2;
    public static final int EVENT_TYPE_LAUNCH = 1;
    public static final int EVENT_TYPE_NET_CHANGE = 4;
    private static final String TAG = "EventLog";
    @JSONField(name = "type")
    private int eventType;
    @JSONField(name = "id")
    private String pageID = null;

    private EventLogger(int i) {
        this.eventType = i;
    }

    public static EventLogger builder(int i) {
        return new EventLogger(i);
    }

    public int getEventType() {
        return this.eventType;
    }

    public String getPageID() {
        return this.pageID;
    }

    @Override // com.taobao.tao.log.logger.ILogger
    public void log() {
        TLogNative.writeLog(LogCategory.EventLog, LogLevel.I, TAG, "", toString());
    }

    public EventLogger setData(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            if (this.data == null) {
                this.data = new HashMap();
            }
            this.data.putAll(map);
        }
        return this;
    }

    public EventLogger setPageID(String str) {
        this.pageID = str;
        return this;
    }

    public EventLogger setTime(long j) {
        setData("ts", String.valueOf(j));
        return this;
    }

    public EventLogger setData(String str, String str2) {
        if (this.data == null) {
            this.data = new HashMap();
        }
        this.data.put(str, str2);
        return this;
    }

    public EventLogger setData(Map.Entry<String, String> entry) {
        if (this.data == null) {
            this.data = new HashMap();
        }
        this.data.put(entry.getKey(), entry.getValue());
        return this;
    }
}
