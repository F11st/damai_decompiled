package com.ut.mini.behavior.trigger;

import com.alibaba.fastjson.annotation.JSONField;
import com.huawei.hms.opendevice.c;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Scene implements Serializable {
    @JSONField(name = c.a)
    public String condition;
    @JSONField(name = "ena")
    public int enableSample;
    @JSONField(name = "e")
    public Event event;
    @JSONField(name = "n")
    public String name;
}
