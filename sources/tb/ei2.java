package tb;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import android.text.style.UpdateAppearance;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import org.jetbrains.annotations.NotNull;
import tb.vz0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ei2 extends MetricAffectingSpan implements UpdateAppearance {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final float[] c = {0.9f, 1.0f, 1.1f, 1.2f, 1.28f, 1.35f, 1.4f};
    private int a;
    private int b;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    public ei2(@NotNull vz0.b bVar) {
        b41.i(bVar, RichTextNode.ATTR);
        this.a = bVar.b();
        this.b = bVar.e();
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "788370357")) {
            ipChange.ipc$dispatch("788370357", new Object[]{this, textPaint});
            return;
        }
        b41.i(textPaint, "tp");
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
    public void updateMeasureState(@NotNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1270984555")) {
            ipChange.ipc$dispatch("-1270984555", new Object[]{this, textPaint});
            return;
        }
        b41.i(textPaint, "tp");
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
