package com.taobao.weex.utils.tools;

import com.alibaba.fastjson.annotation.JSONField;
import com.taobao.tao.log.TLogConstant;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Info {
    @JSONField(name = "instanceId")
    public String instanceId;
    @JSONField(name = "platform")
    public String platform;
    @JSONField(name = TLogConstant.PERSIST_TASK_ID)
    public int taskId;
    @JSONField(name = "taskInfo")
    public TaskInfo taskInfo = new TaskInfo();
    @JSONField(name = "taskName")
    public String taskName;

    public String toString() {
        return "Info : {instanceId = '" + this.instanceId + "',taskName = '" + this.taskName + "',taskInfo = '" + this.taskInfo + "',platform = '" + this.platform + "',taskId = '" + this.taskId + "'}";
    }
}
