package com.google.j2objc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Taobao */
@Target({ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes10.dex */
public @interface LoopTranslation {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum LoopStyle {
        JAVA_ITERATOR,
        FAST_ENUMERATION
    }

    LoopStyle value();
}
