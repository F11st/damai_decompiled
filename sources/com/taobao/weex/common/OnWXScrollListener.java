package com.taobao.weex.common;

import android.view.View;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface OnWXScrollListener {
    public static final int DRAGGING = 1;
    public static final int IDLE = 0;
    public static final int SETTLING = 2;

    void onScrollStateChanged(View view, int i, int i2, int i3);

    void onScrolled(View view, int i, int i2);
}
