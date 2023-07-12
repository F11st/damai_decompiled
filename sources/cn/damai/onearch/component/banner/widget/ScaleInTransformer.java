package cn.damai.onearch.component.banner.widget;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ScaleInTransformer implements ViewPager2.PageTransformer {
    private static transient /* synthetic */ IpChange $ipChange;
    private float a = 0.85f;

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-846187058")) {
            ipChange.ipc$dispatch("-846187058", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        int width = view.getWidth();
        view.setPivotY(view.getHeight() >> 1);
        view.setPivotX(width >> 1);
        if (f < -1.0f) {
            view.setScaleX(this.a);
            view.setScaleY(this.a);
            view.setPivotX(width);
        } else if (f > 1.0f) {
            view.setPivotX(0.0f);
            view.setScaleX(this.a);
            view.setScaleY(this.a);
        } else if (f < 0.0f) {
            float f2 = this.a;
            float f3 = ((f + 1.0f) * (1.0f - f2)) + f2;
            view.setScaleX(f3);
            view.setScaleY(f3);
            view.setPivotX(width * (((-f) * 0.5f) + 0.5f));
        } else {
            float f4 = 1.0f - f;
            float f5 = this.a;
            float f6 = ((1.0f - f5) * f4) + f5;
            view.setScaleX(f6);
            view.setScaleY(f6);
            view.setPivotX(width * f4 * 0.5f);
        }
    }
}
