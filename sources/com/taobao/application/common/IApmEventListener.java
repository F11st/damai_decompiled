package com.taobao.application.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IApmEventListener {
    public static final int NOTIFY_BACKGROUND_2_FOREGROUND = 2;
    public static final int NOTIFY_FOREGROUND_2_BACKGROUND = 1;
    public static final int NOTIFY_FOR_IN_BACKGROUND = 50;

    /* compiled from: Taobao */
    @Target({ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface ApmEventType {
    }

    void onEvent(int i);
}
