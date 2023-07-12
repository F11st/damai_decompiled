package com.alibaba.pictures.bricks.view;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface RefreshTrigger {
    void onComplete();

    void onMove(boolean z, boolean z2, int i);

    void onRefresh();

    void onRelease();

    void onReset();

    void onStart(boolean z, int i, int i2);
}
