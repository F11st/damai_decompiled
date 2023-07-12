package tb;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class k41 extends MetricAffectingSpan {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-346696258")) {
            ipChange.ipc$dispatch("-346696258", new Object[]{this, textPaint});
        } else {
            nw0.a(textPaint, 2);
        }
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1762990612")) {
            ipChange.ipc$dispatch("-1762990612", new Object[]{this, textPaint});
        } else {
            nw0.a(textPaint, 2);
        }
    }
}
