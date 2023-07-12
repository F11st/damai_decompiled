package com.alibaba.poplayer;

import com.youku.css.constraint.CssConst;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class Domain {
    public static final int APP = 1;
    public static final int PAGE = 2;
    public static final int VIEW = 3;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes8.dex */
    public @interface DomainSet {
    }

    public static String toString(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "Unknow" : CssConst.CssScenes.VIEW : "Page" : "App";
    }
}
