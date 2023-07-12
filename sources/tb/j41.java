package tb;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class j41 extends MetricAffectingSpan {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-963094342")) {
            ipChange.ipc$dispatch("-963094342", new Object[]{this, textPaint});
            return;
        }
        b41.i(textPaint, "tp");
        mw0.Companion.a(textPaint, 2);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(@NotNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "401846640")) {
            ipChange.ipc$dispatch("401846640", new Object[]{this, textPaint});
            return;
        }
        b41.i(textPaint, "p");
        mw0.Companion.a(textPaint, 2);
    }
}
