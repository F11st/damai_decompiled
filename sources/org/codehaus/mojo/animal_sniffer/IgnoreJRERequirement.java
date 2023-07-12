package org.codehaus.mojo.animal_sniffer;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Taobao */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes2.dex */
public @interface IgnoreJRERequirement {
}
