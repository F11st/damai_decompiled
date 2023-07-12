package cn.damai.tetris.component.home.widget.banner.transformer;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ScaleInOutTransformer extends cn.damai.uikit.banner.transformer.ABaseTransformer {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.uikit.banner.transformer.ABaseTransformer
    protected void f(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1956697843")) {
            ipChange.ipc$dispatch("-1956697843", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        view.setPivotX(i >= 0 ? view.getWidth() : 0.0f);
        view.setPivotY(view.getHeight() / 2.0f);
        float f2 = i < 0 ? f + 1.0f : 1.0f - f;
        view.setScaleX(f2);
        view.setScaleY(f2);
    }
}
