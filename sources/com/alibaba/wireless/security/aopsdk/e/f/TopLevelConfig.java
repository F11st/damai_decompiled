package com.alibaba.wireless.security.aopsdk.e.f;

import com.alibaba.wireless.security.aopsdk.e.e.AopAttribute;
import com.alibaba.wireless.security.aopsdk.e.e.AopAttributeType;
import java.util.List;

/* renamed from: com.alibaba.wireless.security.aopsdk.e.f.g */
/* loaded from: classes.dex */
public class TopLevelConfig extends BaseAopConfig {
    @AopAttribute(key = "v", type = AopAttributeType.INT)
    public int d;
    @AopAttribute(key = "cid", type = AopAttributeType.INT)
    public int e;
    @AopAttribute(handler = ExecutionConfig.class, key = "gc", type = AopAttributeType.JSON)
    public ExecutionConfig f;
    @AopAttribute(handler = ProxyConfig.class, key = "pr", type = AopAttributeType.JSON_ARRAY)
    public List<ProxyConfig> g;
}
