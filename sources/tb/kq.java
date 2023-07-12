package tb;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class kq extends MetricAffectingSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    private Typeface a;

    public kq(Typeface typeface) {
        this.a = typeface;
    }

    private void a(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1076724110")) {
            ipChange.ipc$dispatch("1076724110", new Object[]{this, textPaint});
            return;
        }
        Typeface typeface = textPaint.getTypeface();
        int style = (~this.a.getStyle()) & (typeface != null ? typeface.getStyle() : 0);
        if ((style & 1) != 0) {
            textPaint.setFakeBoldText(true);
        }
        if ((style & 2) != 0) {
            textPaint.setTextSkewX(-0.25f);
        }
        textPaint.setTypeface(this.a);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1957761944")) {
            ipChange.ipc$dispatch("1957761944", new Object[]{this, textPaint});
        } else {
            a(textPaint);
        }
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(@NonNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-405954094")) {
            ipChange.ipc$dispatch("-405954094", new Object[]{this, textPaint});
        } else {
            a(textPaint);
        }
    }
}
