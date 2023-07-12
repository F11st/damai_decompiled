package cn.damai.uikit.banner.transformer;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class BackgroundToForegroundTransformer extends ABaseTransformer {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.uikit.banner.transformer.ABaseTransformer
    protected void f(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "813508434")) {
            ipChange.ipc$dispatch("813508434", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        float height = view.getHeight();
        float width = view.getWidth();
        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        float c = ABaseTransformer.c(i >= 0 ? Math.abs(1.0f - f) : 1.0f, 0.5f);
        view.setScaleX(c);
        view.setScaleY(c);
        view.setPivotX(width * 0.5f);
        view.setPivotY(height * 0.5f);
        view.setTranslationX(i < 0 ? width * f : (-width) * f * 0.25f);
    }
}
