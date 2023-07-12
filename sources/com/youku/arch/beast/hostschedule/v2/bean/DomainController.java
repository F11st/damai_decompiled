package com.youku.arch.beast.hostschedule.v2.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DomainController {
    @JSONField(name = "ad_meta")
    public Ad_meta[] ad_meta;
    @JSONField(name = "ad_rule")
    public Ad_rule ad_rule;
    @JSONField(name = "meta")
    public Meta[] meta;
    public String rawString;
    @JSONField(name = "rule")
    public Rule rule;
}
