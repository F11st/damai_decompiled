package com.scwang.smartrefresh.layout.api;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.constant.RefreshState;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface RefreshKernel {
    ValueAnimator animSpinner(int i);

    RefreshKernel finishTwoLevel();

    @NonNull
    RefreshContent getRefreshContent();

    @NonNull
    RefreshLayout getRefreshLayout();

    RefreshKernel moveSpinner(int i, boolean z);

    RefreshKernel requestDefaultTranslationContentFor(@NonNull RefreshInternal refreshInternal, boolean z);

    RefreshKernel requestDrawBackgroundFor(@NonNull RefreshInternal refreshInternal, int i);

    RefreshKernel requestFloorDuration(int i);

    RefreshKernel requestNeedTouchEventFor(@NonNull RefreshInternal refreshInternal, boolean z);

    RefreshKernel requestRemeasureHeightFor(@NonNull RefreshInternal refreshInternal);

    RefreshKernel setState(@NonNull RefreshState refreshState);

    RefreshKernel startTwoLevel(boolean z);
}
