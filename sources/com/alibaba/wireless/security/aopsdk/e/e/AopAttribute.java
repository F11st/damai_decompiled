package com.alibaba.wireless.security.aopsdk.e.e;

import com.alibaba.wireless.security.aopsdk.e.f.BaseAopConfig;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: com.alibaba.wireless.security.aopsdk.e.e.a */
/* loaded from: classes.dex */
public @interface AopAttribute {
    Class<? extends BaseAopConfig> handler() default BaseAopConfig.class;

    String key();

    AopAttributeType type();
}
