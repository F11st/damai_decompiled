package com.alibaba.android.umbrella.performance;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class PerformanceEntity implements Serializable {
    public Map<String, String> args;
    public String bizName;
    public Map<String, Long> otherMeasure;
    protected long registerTime;
    public String serviceId;

    public PerformanceEntity(String str, String str2, List<String> list) {
        this(str, str2, list, SystemClock.uptimeMillis());
    }

    public void addArgs(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.args.put(str, str2);
    }

    public void addRecordPoint(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.otherMeasure.put(str, Long.valueOf(j));
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }

    public PerformanceEntity(String str, String str2, List<String> list, long j) {
        this.bizName = str;
        this.serviceId = str2;
        this.otherMeasure = new HashMap();
        this.args = new HashMap();
        this.registerTime = j;
    }

    public void addArgs(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.args.putAll(map);
    }
}
