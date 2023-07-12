package com.youku.squareup.wire;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Taobao */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface WireField {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum Label {
        REQUIRED,
        OPTIONAL,
        REPEATED,
        ONE_OF,
        PACKED;

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isOneOf() {
            return this == ONE_OF;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isPacked() {
            return this == PACKED;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isRepeated() {
            return this == REPEATED || this == PACKED;
        }
    }

    String adapter();

    String keyAdapter() default "";

    Label label() default Label.OPTIONAL;

    boolean redacted() default false;

    int tag();
}
