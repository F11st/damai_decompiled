package anet.channel.statist;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Taobao */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface Measure {
    double constantValue() default 0.0d;

    double max() default Double.MAX_VALUE;

    double min() default 0.0d;

    String name() default "";
}
