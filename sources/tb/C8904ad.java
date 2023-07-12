package tb;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* renamed from: tb.ad */
/* loaded from: classes7.dex */
public final class C8904ad extends MetricAffectingSpan {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-840620603")) {
            ipChange.ipc$dispatch("-840620603", new Object[]{this, textPaint});
            return;
        }
        b41.i(textPaint, "tp");
        mw0.Companion.a(textPaint, 1);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(@NotNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1705196411")) {
            ipChange.ipc$dispatch("-1705196411", new Object[]{this, textPaint});
            return;
        }
        b41.i(textPaint, "p");
        mw0.Companion.a(textPaint, 1);
    }
}
