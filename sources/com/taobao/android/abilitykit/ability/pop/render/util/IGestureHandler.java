package com.taobao.android.abilitykit.ability.pop.render.util;

import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
interface IGestureHandler {
    boolean onInterceptTouchEvent(@NonNull MotionEvent motionEvent, @NonNull View view);

    boolean onTouchEvent(@NonNull MotionEvent motionEvent, @NonNull View view);
}
