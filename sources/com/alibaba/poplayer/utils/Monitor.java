package com.alibaba.poplayer.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class Monitor {

    /* compiled from: Taobao */
    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes8.dex */
    public @interface TargetClass {
        String tag() default "";
    }

    /* compiled from: Taobao */
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes8.dex */
    public @interface TargetField {
        String name() default "";

        String prefix() default "";
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayer.utils.Monitor$a */
    /* loaded from: classes8.dex */
    public static class C3703a {
        public final Object a;
        public final Object b;

        public C3703a(Object obj, String str, Object obj2) {
            this.a = obj;
            this.b = obj2;
        }
    }

    private Monitor() {
    }
}
