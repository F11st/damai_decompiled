package com.alibaba.wireless.security.aopsdk.e.f;

import com.alibaba.wireless.security.aopsdk.e.e.AopAttribute;
import com.alibaba.wireless.security.aopsdk.e.e.AopAttributeType;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.util.List;

/* renamed from: com.alibaba.wireless.security.aopsdk.e.f.d */
/* loaded from: classes.dex */
public class ProxyConfig extends BaseAopConfig {
    @AopAttribute(key = IRequestConst.PN, type = AopAttributeType.STRING)
    public String d;
    @AopAttribute(handler = StrategyConfig.class, key = "st", type = AopAttributeType.JSON_ARRAY)
    public List<StrategyConfig> e;
}
