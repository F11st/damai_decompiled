package com.taobao.android.abilitykit.ability.pop.animation;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface IAKPopAnimation {
    String animationKey();

    void dismiss(@NonNull View view, @Nullable IAKPopAnimationCallback iAKPopAnimationCallback);

    long dismissDurationInMills();

    boolean isAnimating();

    void show(@NonNull View view, @Nullable View view2, @Nullable IAKPopAnimationCallback iAKPopAnimationCallback);

    long showDurationInMills();
}
