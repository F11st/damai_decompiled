package tb;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ny1 extends ReplacementSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private int b;
    private int c;

    public ny1(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "263524772")) {
            ipChange.ipc$dispatch("263524772", new Object[]{this, canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint});
            return;
        }
        paint.setColor(this.a);
        float f2 = i4;
        canvas.drawRoundRect(new RectF(f, paint.ascent() + f2, getSize(paint, charSequence.subSequence(i, i2), i, i2, paint.getFontMetricsInt()) + f, (paint.descent() / 2.0f) + f2), (paint.descent() + f2) / 2.0f, (f2 + paint.descent()) / 2.0f, paint);
        paint.setColor(this.b);
        paint.setTextSize(this.c);
        canvas.drawText(charSequence, i, i2, 0.0f, 0.0f, paint);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-302690012") ? ((Integer) ipChange.ipc$dispatch("-302690012", new Object[]{this, paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})).intValue() : (int) paint.measureText(charSequence, i, i2);
    }
}
