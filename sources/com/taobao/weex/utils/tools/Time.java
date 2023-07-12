package com.taobao.weex.utils.tools;

import com.alibaba.fastjson.annotation.JSONField;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Time {
    @JSONField(name = "constructor")
    public long constructor;
    @JSONField(name = "destructor")
    public long destructor;
    @JSONField(name = "execTime")
    public long execTime;
    @JSONField(name = "taskEnd")
    public long taskEnd;
    @JSONField(name = "taskStart")
    public long taskStart;
    @JSONField(name = HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME)
    public long waitTime;

    private void b() {
        waitTime();
        this.destructor = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        this.constructor = System.currentTimeMillis();
    }

    public void execTime() {
        this.execTime = this.taskEnd - this.taskStart;
    }

    public void taskEnd() {
        this.taskEnd = System.currentTimeMillis();
        execTime();
        b();
    }

    public void taskStart() {
        this.taskStart = System.currentTimeMillis();
    }

    public String toString() {
        return "time : {constructor = '" + this.constructor + "',taskStart = '" + this.taskStart + "',execTime = '" + this.execTime + "',waitTime = '" + this.waitTime + "',destructor = '" + this.destructor + "',taskEnd = '" + this.taskEnd + "'}";
    }

    public void waitTime() {
        this.waitTime = this.taskStart - this.constructor;
    }
}
