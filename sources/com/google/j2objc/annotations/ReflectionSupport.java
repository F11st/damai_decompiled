package com.google.j2objc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Taobao */
@Target({ElementType.TYPE, ElementType.PACKAGE})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes10.dex */
public @interface ReflectionSupport {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum Level {
        NATIVE_ONLY,
        FULL
    }

    Level value();
}
