package com.taobao.analysis;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface StageType {
    public static final String PARSE = "parse";
    public static final String PROCESS = "process";
    public static final String RENDER = "render";

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes8.dex */
    public @interface Definition {
    }
}
