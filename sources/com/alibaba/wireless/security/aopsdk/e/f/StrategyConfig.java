package com.alibaba.wireless.security.aopsdk.e.f;

import com.alibaba.wireless.security.aopsdk.e.e.AopAttribute;
import com.alibaba.wireless.security.aopsdk.e.e.AopAttributeType;
import java.util.List;

/* renamed from: com.alibaba.wireless.security.aopsdk.e.f.f */
/* loaded from: classes.dex */
public class StrategyConfig extends BaseAopConfig {
    @AopAttribute(key = "sid", type = AopAttributeType.INT)
    public int d;
    @AopAttribute(handler = RuleConfig.class, key = "rules", type = AopAttributeType.JSON_ARRAY)
    public List<RuleConfig> e;
}
