package com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures;

import android.view.MotionEvent;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface GestureDetector {
    boolean isDragging();

    boolean isScaling();

    boolean onTouchEvent(MotionEvent motionEvent);

    void setOnGestureListener(OnGestureListener onGestureListener);
}
