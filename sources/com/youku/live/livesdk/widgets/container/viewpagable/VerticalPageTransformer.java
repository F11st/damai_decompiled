package com.youku.live.livesdk.widgets.container.viewpagable;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class VerticalPageTransformer implements ViewPager.PageTransformer {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-662604778")) {
            ipChange.ipc$dispatch("-662604778", new Object[]{this, view, Float.valueOf(f)});
        } else if (f < -1.0f) {
            view.setAlpha(0.0f);
        } else if (f <= 1.0f) {
            view.setAlpha(1.0f);
            view.setTranslationX(view.getWidth() * (-f));
            view.setTranslationY(f * view.getHeight());
        } else {
            view.setAlpha(0.0f);
        }
    }
}
