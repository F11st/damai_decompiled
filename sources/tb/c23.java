package tb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class c23 extends ImageSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private int b;
    private WeakReference<Drawable> c;

    public c23(@NonNull Context context, @NonNull Bitmap bitmap, int i, int i2) {
        super(context, bitmap);
        this.b = i2;
        this.a = i;
    }

    private Drawable a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "638624651")) {
            return (Drawable) ipChange.ipc$dispatch("638624651", new Object[]{this});
        }
        WeakReference<Drawable> weakReference = this.c;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        if (drawable == null) {
            Drawable drawable2 = getDrawable();
            this.c = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1555256128")) {
            ipChange.ipc$dispatch("-1555256128", new Object[]{this, canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint});
            return;
        }
        Drawable a = a();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        canvas.save();
        canvas.translate(f, ((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - (a.getBounds().bottom / 2));
        a.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-268575159")) {
            return (Drawable) ipChange.ipc$dispatch("-268575159", new Object[]{this});
        }
        Drawable drawable = super.getDrawable();
        if (drawable != null) {
            drawable.setBounds(0, 0, this.a, this.b);
        }
        return drawable;
    }
}
