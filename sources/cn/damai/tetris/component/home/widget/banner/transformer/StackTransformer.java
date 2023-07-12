package cn.damai.tetris.component.home.widget.banner.transformer;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class StackTransformer extends cn.damai.uikit.banner.transformer.ABaseTransformer {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.uikit.banner.transformer.ABaseTransformer
    protected void f(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "927506732")) {
            ipChange.ipc$dispatch("927506732", new Object[]{this, view, Float.valueOf(f)});
        } else {
            view.setTranslationX(f >= 0.0f ? (-view.getWidth()) * f : 0.0f);
        }
    }
}
