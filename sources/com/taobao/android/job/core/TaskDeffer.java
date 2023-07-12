package com.taobao.android.job.core;

import com.taobao.android.job.core.task.Task;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface TaskDeffer<T, R> {
    public static final int OPTION_DEFFER_LAST = 1;
    public static final int OPTION_DEFFER_NORMAL = 0;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface Option {
    }

    boolean offer(Task<T, R> task, int i);

    Task<T, R> poll(int i);
}
