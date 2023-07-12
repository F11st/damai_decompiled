package com.youku.resource.widget.tips;

import android.view.animation.BaseInterpolator;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(api = 22)
/* loaded from: classes3.dex */
public class YKTipsInterpolator extends BaseInterpolator {
    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return (float) ((1.0d - Math.cos((f * 12.0f) * 3.141592653589793d)) * 0.5d);
    }
}
