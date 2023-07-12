package cn.damai.uikit.banner.transformer;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DepthPageTransformer extends ABaseTransformer {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.uikit.banner.transformer.ABaseTransformer
    protected boolean b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1392168618")) {
            return ((Boolean) ipChange.ipc$dispatch("-1392168618", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.uikit.banner.transformer.ABaseTransformer
    protected void f(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1458660354")) {
            ipChange.ipc$dispatch("-1458660354", new Object[]{this, view, Float.valueOf(f)});
        } else if (f <= 0.0f) {
            view.setTranslationX(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
        } else if (f <= 1.0f) {
            float abs = ((1.0f - Math.abs(f)) * 0.25f) + 0.75f;
            view.setAlpha(1.0f - f);
            view.setPivotY(view.getHeight() * 0.5f);
            view.setTranslationX(view.getWidth() * (-f));
            view.setScaleX(abs);
            view.setScaleY(abs);
        }
    }
}
