package com.taobao.uikit.feature.callback;

import android.view.MotionEvent;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface TouchEventCallback {
    void afterDispatchTouchEvent(MotionEvent motionEvent);

    void afterOnTouchEvent(MotionEvent motionEvent);

    void beforeDispatchTouchEvent(MotionEvent motionEvent);

    void beforeOnTouchEvent(MotionEvent motionEvent);
}
