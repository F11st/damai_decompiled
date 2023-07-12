package com.taobao.monitor.impl.common;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
@Documented
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes11.dex */
public @interface Stage {
    public static final int CANCELED = 3;
    public static final int FAILED = 2;
    public static final int REQUESTED = 0;
    public static final int SUCCESS = 1;
}
