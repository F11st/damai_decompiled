package com.youku.arch.beast.hostschedule;

import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class HostScheduleInfo {
    @JSONField(name = "adDomain")
    public DomainCell adDomain;
    @JSONField(name = "domainVersion")
    public String domainVersion;
    @JSONField(name = "feedDomain")
    public Domain feedDomain;
    @JSONField(name = "freeDomain")
    public FreeDomain freeDomain;
    @JSONField(name = "videoDomain")
    public Domain videoDomain;
}
