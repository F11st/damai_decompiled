package tb;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class hi2 extends MetricAffectingSpan {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "997320816")) {
            ipChange.ipc$dispatch("997320816", new Object[]{this, textPaint});
            return;
        }
        b41.i(textPaint, "tp");
        textPaint.baselineShift -= (int) (textPaint.ascent() / 2);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(@NotNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "164527610")) {
            ipChange.ipc$dispatch("164527610", new Object[]{this, textPaint});
            return;
        }
        b41.i(textPaint, "tp");
        textPaint.baselineShift -= (int) (textPaint.ascent() / 2);
    }
}
