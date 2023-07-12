package com.alibaba.wireless.security.aopsdk.e.e;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: AopAttribute.java */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface a {
    Class<? extends com.alibaba.wireless.security.aopsdk.e.f.a> handler() default com.alibaba.wireless.security.aopsdk.e.f.a.class;

    String key();

    b type();
}
