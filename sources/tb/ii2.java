package tb;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ii2 extends MetricAffectingSpan {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1058613740")) {
            ipChange.ipc$dispatch("1058613740", new Object[]{this, textPaint});
        } else {
            textPaint.baselineShift -= (int) (textPaint.ascent() / 2.0f);
        }
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "780925694")) {
            ipChange.ipc$dispatch("780925694", new Object[]{this, textPaint});
        } else {
            textPaint.baselineShift -= (int) (textPaint.ascent() / 2.0f);
        }
    }
}
