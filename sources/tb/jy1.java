package tb;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineHeightSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import tb.a01;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class jy1 extends CharacterStyle implements LeadingMarginSpan, LineHeightSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    private static final float a;
    private static final float b;
    private static final float c;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    static {
        a01.a aVar = a01.Companion;
        a = aVar.a() / 4;
        b = aVar.a();
        c = 0.89285713f;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(@NotNull CharSequence charSequence, int i, int i2, int i3, int i4, @NotNull Paint.FontMetricsInt fontMetricsInt) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1140790884")) {
            ipChange.ipc$dispatch("1140790884", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontMetricsInt});
            return;
        }
        b41.i(charSequence, "text");
        b41.i(fontMetricsInt, "fm");
        int i5 = fontMetricsInt.ascent;
        float f = c;
        fontMetricsInt.ascent = i5 * ((int) f);
        fontMetricsInt.descent *= (int) f;
        fontMetricsInt.top *= (int) f;
        fontMetricsInt.bottom *= (int) f;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(@NotNull Canvas canvas, @NotNull Paint paint, int i, int i2, int i3, int i4, int i5, @NotNull CharSequence charSequence, int i6, int i7, boolean z, @NotNull Layout layout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1299685162")) {
            ipChange.ipc$dispatch("-1299685162", new Object[]{this, canvas, paint, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), charSequence, Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), layout});
            return;
        }
        b41.i(canvas, com.huawei.hms.opendevice.c.a);
        b41.i(paint, "p");
        b41.i(charSequence, "text");
        b41.i(layout, "layout");
        Paint.Style style = paint.getStyle();
        int color = paint.getColor();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-2236963);
        float f = i;
        canvas.drawRect(f, !z ? i3 - (i5 - i4) : ((int) (i3 - a)) + 5, (i2 * a) + f, i4 + 5, paint);
        paint.setStyle(style);
        paint.setColor(color);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1298958003") ? ((Integer) ipChange.ipc$dispatch("1298958003", new Object[]{this, Boolean.valueOf(z)})).intValue() : (int) (a + b);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "714819828")) {
            ipChange.ipc$dispatch("714819828", new Object[]{this, textPaint});
            return;
        }
        b41.i(textPaint, "tp");
        textPaint.setColor(-8947849);
    }
}
