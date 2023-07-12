package com.scwang.smartrefresh.layout.api;

import android.view.View;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface ScrollBoundaryDecider {
    boolean canLoadMore(View view);

    boolean canRefresh(View view);
}
