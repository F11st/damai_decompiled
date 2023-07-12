package com.google.common.eventbus;

import com.google.common.annotations.Beta;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Taobao */
@Target({ElementType.METHOD})
@Beta
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes10.dex */
public @interface AllowConcurrentEvents {
}
