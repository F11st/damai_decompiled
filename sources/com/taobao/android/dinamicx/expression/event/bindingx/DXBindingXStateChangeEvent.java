package com.taobao.android.dinamicx.expression.event.bindingx;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import tb.hy;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXBindingXStateChangeEvent extends hy {
    public static final long DXVIEWWIDGETNODE_ONBINDINGXFINISH = -5192979070104500639L;
    public static final long DXVIEWWIDGETNODE_ONBINDINGXSTART = -1026451533627932147L;
    public static final long DXVIEWWIDGETNODE_ONBINDINGXSTOP = 6689515913358780580L;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    @interface DXBindingStateChangeEventId {
    }

    public DXBindingXStateChangeEvent(long j, String str) {
        super(j);
    }
}
