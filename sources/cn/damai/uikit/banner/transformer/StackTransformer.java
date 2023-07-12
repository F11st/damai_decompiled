package cn.damai.uikit.banner.transformer;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class StackTransformer extends ABaseTransformer {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.uikit.banner.transformer.ABaseTransformer
    protected void f(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "337415188")) {
            ipChange.ipc$dispatch("337415188", new Object[]{this, view, Float.valueOf(f)});
        } else {
            view.setTranslationX(f >= 0.0f ? (-view.getWidth()) * f : 0.0f);
        }
    }
}
