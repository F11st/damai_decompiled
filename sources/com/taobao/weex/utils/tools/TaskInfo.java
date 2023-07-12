package com.taobao.weex.utils.tools;

import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TaskInfo {
    @JSONField(name = "args")
    public String args;
    @JSONField(name = "relateTaskId")
    public int relateTaskId;

    public String toString() {
        return "TaskInfo{args = '" + this.args + "',relateTaskId = '" + this.relateTaskId + "'}";
    }
}
