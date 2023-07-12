package com.taobao.android.job.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes12.dex */
public @interface ScheduleBehavior {
    public static final int IMMEDIATE_NON_TERMINATING = 1;
    public static final int IMMEDIATE_NON_TERMINATING_DEFERRABLE = 4;
    public static final int SCHEDULED_ON_CONDITION = 3;
    public static final int SCHEDULED_WHEN_IDLE = 2;
    public static final int TERMINATING = 0;
}
