package com.ut.mini.behavior.module;

import com.alibaba.fastjson.annotation.JSONField;
import com.taobao.weex.ui.component.WXComponent;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ModulesConfig implements Serializable {
    @JSONField(name = WXComponent.PROP_FS_MATCH_PARENT)
    public List<Module> moduleList;
    @JSONField(name = "t")
    public long timestamp;
    @JSONField(name = "v")
    public int version;
}
