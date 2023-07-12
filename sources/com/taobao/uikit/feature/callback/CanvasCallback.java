package com.taobao.uikit.feature.callback;

import android.graphics.Canvas;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface CanvasCallback {
    void afterDispatchDraw(Canvas canvas);

    void afterDraw(Canvas canvas);

    void afterOnDraw(Canvas canvas);

    void beforeDispatchDraw(Canvas canvas);

    void beforeDraw(Canvas canvas);

    void beforeOnDraw(Canvas canvas);
}
