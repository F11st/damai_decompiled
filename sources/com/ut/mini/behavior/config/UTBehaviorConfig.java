package com.ut.mini.behavior.config;

import com.alibaba.fastjson.annotation.JSONField;
import com.ut.mini.behavior.module.ModulesConfig;
import com.ut.mini.behavior.trigger.TriggerConfig;
import java.io.Serializable;
import tb.zp0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTBehaviorConfig implements Serializable {
    @JSONField(name = "module")
    public ModulesConfig modulesConfig;
    @JSONField(name = "t")
    public long timestamp;
    @JSONField(name = zp0.KEY_TRIGGER)
    public TriggerConfig triggerConfig;
    @JSONField(name = "v")
    public int v;
}
