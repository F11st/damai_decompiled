package tb;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a01;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class z81 implements LeadingMarginSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    private static final float c;
    private static final int d;
    @Nullable
    private static Path e;
    private final float a = a01.Companion.a() * 0.6f;
    private final int b = -13421773;

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
        c = aVar.a();
        d = ((Integer) Float.valueOf(aVar.a() / 8)).intValue();
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(@NotNull Canvas canvas, @NotNull Paint paint, int i, int i2, int i3, int i4, int i5, @NotNull CharSequence charSequence, int i6, int i7, boolean z, @NotNull Layout layout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1550113519")) {
            ipChange.ipc$dispatch("1550113519", new Object[]{this, canvas, paint, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), charSequence, Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), layout});
            return;
        }
        b41.i(canvas, com.huawei.hms.opendevice.c.a);
        b41.i(paint, "p");
        b41.i(charSequence, "text");
        b41.i(layout, NotifyType.LIGHTS);
        if (((Spanned) charSequence).getSpanStart(this) == i6) {
            Paint.Style style = paint.getStyle();
            int color = paint.getColor();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.b);
            if (canvas.isHardwareAccelerated()) {
                if (e == null) {
                    Path path = new Path();
                    e = path;
                    b41.f(path);
                    path.addCircle(0.0f, 0.0f, d * 1.2f, Path.Direction.CW);
                }
                canvas.save();
                float f = c;
                int i8 = d;
                canvas.translate(i + (i2 * (f - i8)), ((i3 + i4) / 2.0f) + i8);
                Path path2 = e;
                b41.f(path2);
                canvas.drawPath(path2, paint);
                canvas.restore();
            } else {
                float f2 = c;
                int i9 = d;
                canvas.drawCircle(i + (i2 * (f2 - i9)), ((i3 + i4) / 2.0f) + i9, i9, paint);
            }
            paint.setColor(color);
            paint.setStyle(style);
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "152417164") ? ((Integer) ipChange.ipc$dispatch("152417164", new Object[]{this, Boolean.valueOf(z)})).intValue() : (int) (c + this.a);
    }
}
