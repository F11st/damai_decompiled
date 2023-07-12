package cn.damai.common.db.db.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Taobao */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes13.dex */
public @interface Column {
    boolean autoGen() default true;

    boolean isId() default false;

    String name();

    String property() default "";
}
