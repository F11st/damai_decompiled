package com.taobao.android.job.core.task;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes12.dex */
public @interface ExecutionStatus {
    public static final int FAILED = 0;
    public static final int SKIPPED = 1;
    public static final int SUCCESS = 2;
}
