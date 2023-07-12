package tb;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class a91 implements LeadingMarginSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final float b;
    private static final int c;
    private static Path d;
    private final float a = HtmlView.h * 0.6f;

    static {
        float f = HtmlView.h;
        b = f;
        c = (int) (f / 8.0f);
        d = null;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1130311181")) {
            ipChange.ipc$dispatch("-1130311181", new Object[]{this, canvas, paint, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), charSequence, Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), layout});
        } else if (((Spanned) charSequence).getSpanStart(this) == i6) {
            Paint.Style style = paint.getStyle();
            int color = paint.getColor();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(-13421773);
            if (canvas.isHardwareAccelerated()) {
                if (d == null) {
                    Path path = new Path();
                    d = path;
                    path.addCircle(0.0f, 0.0f, c * 1.2f, Path.Direction.CW);
                }
                canvas.save();
                float f = b;
                int i8 = c;
                canvas.translate(i + (i2 * (f - i8)), ((i3 + i4) / 2.0f) + i8);
                canvas.drawPath(d, paint);
                canvas.restore();
            } else {
                float f2 = b;
                int i9 = c;
                canvas.drawCircle(i + (i2 * (f2 - i9)), ((i3 + i4) / 2.0f) + i9, i9, paint);
            }
            paint.setColor(color);
            paint.setStyle(style);
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-391942768") ? ((Integer) ipChange.ipc$dispatch("-391942768", new Object[]{this, Boolean.valueOf(z)})).intValue() : (int) (b + this.a);
    }
}
