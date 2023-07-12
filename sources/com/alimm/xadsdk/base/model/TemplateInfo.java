package com.alimm.xadsdk.base.model;

import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class TemplateInfo implements BaseInfo {
    @JSONField(name = "effect_type")
    private int mEffectType;
    @JSONField(name = "id")
    private int mTemplateId;

    public int getEffectType() {
        return this.mEffectType;
    }

    public int getTemplateId() {
        return this.mTemplateId;
    }

    public TemplateInfo setEffectType(int i) {
        this.mEffectType = i;
        return this;
    }

    public TemplateInfo setTemplateId(int i) {
        this.mTemplateId = i;
        return this;
    }

    public String toString() {
        return "Template{id=" + this.mTemplateId + ", type = " + this.mEffectType + "}";
    }
}
