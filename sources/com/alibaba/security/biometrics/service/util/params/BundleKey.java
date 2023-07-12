package com.alibaba.security.biometrics.service.util.params;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Taobao */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes8.dex */
public @interface BundleKey {
    Class<? extends BundleConverter> converter() default BundleConverter.class;

    String key();
}
