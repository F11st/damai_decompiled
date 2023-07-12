package cn.damai.uikit.banner.transformer.carousel;

import android.annotation.TargetApi;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ScaleInTransformer extends BasePageTransformer {
    private static transient /* synthetic */ IpChange $ipChange;
    private float b;

    public ScaleInTransformer() {
        this.b = 0.85f;
    }

    @Override // cn.damai.uikit.banner.transformer.carousel.BasePageTransformer
    @TargetApi(11)
    public void a(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1464796810")) {
            ipChange.ipc$dispatch("-1464796810", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        int width = view.getWidth();
        view.setPivotY(view.getHeight() / 2);
        view.setPivotX(width / 2);
        if (f < -1.0f) {
            view.setScaleX(this.b);
            view.setScaleY(this.b);
            view.setPivotX(width);
        } else if (f > 1.0f) {
            view.setPivotX(0.0f);
            view.setScaleX(this.b);
            view.setScaleY(this.b);
        } else if (f < 0.0f) {
            float f2 = this.b;
            float f3 = ((f + 1.0f) * (1.0f - f2)) + f2;
            view.setScaleX(f3);
            view.setScaleY(f3);
            view.setPivotX(width * (((-f) * 0.5f) + 0.5f));
        } else {
            float f4 = 1.0f - f;
            float f5 = this.b;
            float f6 = ((1.0f - f5) * f4) + f5;
            view.setScaleX(f6);
            view.setScaleY(f6);
            view.setPivotX(width * f4 * 0.5f);
        }
    }

    public ScaleInTransformer(float f) {
        this(f, NonPageTransformer.INSTANCE);
    }

    public ScaleInTransformer(float f, ViewPager.PageTransformer pageTransformer) {
        this.b = 0.85f;
        this.b = f;
        this.a = pageTransformer;
    }
}
