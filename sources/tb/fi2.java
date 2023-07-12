package tb;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import android.text.style.UpdateAppearance;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class fi2 extends MetricAffectingSpan implements UpdateAppearance {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final float[] c = {0.9f, 1.0f, 1.1f, 1.2f, 1.28f, 1.35f, 1.4f};
    private int a;
    private int b;

    public fi2(c.a aVar) {
        this.a = aVar.c;
        this.b = aVar.d;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1376466895")) {
            ipChange.ipc$dispatch("-1376466895", new Object[]{this, textPaint});
            return;
        }
        int i = this.a;
        if (i != 1) {
            textPaint.setColor(i);
        }
        int i2 = this.b;
        if (i2 > 0) {
            float[] fArr = c;
            if (i2 > fArr.length) {
                this.b = fArr.length;
            }
            textPaint.setTextSize(textPaint.getTextSize() * fArr[this.b - 1]);
        }
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-708642151")) {
            ipChange.ipc$dispatch("-708642151", new Object[]{this, textPaint});
            return;
        }
        int i = this.b;
        if (i > 0) {
            float[] fArr = c;
            if (i > fArr.length) {
                this.b = fArr.length;
            }
            textPaint.setTextSize(textPaint.getTextSize() * fArr[this.b - 1]);
        }
    }
}
