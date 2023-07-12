package com.taobao.android.job.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes12.dex */
public @interface StagePhase {
    public static final int BUILDING = 0;
    public static final int RECOVERED = 4;
    public static final int RUNNING = 1;
    public static final int STOPPED = 3;
    public static final int TERMINATED = 2;
}
