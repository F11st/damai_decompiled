package com.taobao.android.abilitykit.ability.pop.render.util;

import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface IAKGestureAnimation {
    void cancelAnimator();

    void close(@NonNull View view, float f, @NonNull Runnable runnable);

    void collapse(@NonNull View view, float f, @NonNull Runnable runnable);

    void expand(@NonNull View view, float f, @NonNull Runnable runnable);

    boolean isAnimating();

    void updateLimitSize(int i, int i2);
}
