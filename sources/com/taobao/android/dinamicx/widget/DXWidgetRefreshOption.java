package com.taobao.android.dinamicx.widget;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXWidgetRefreshOption {
    public static final int DX_REFRESH_CHILDREN_STRATEGY_REBUILD_CONTAINER = 2;
    public static final int DX_REFRESH_CHILDREN_STRATEGY_WITHOUT_CONTAINER = 0;
    public static final int DX_REFRESH_CHILDREN_STRATEGY_WITH_CONTAINER = 1;
    private boolean a = false;
    private int b = 0;
    private boolean c;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface DXRefreshChildrenStrategy {
    }

    public int a() {
        return this.b;
    }

    public boolean b() {
        return this.a;
    }

    public boolean c() {
        return this.c;
    }
}
