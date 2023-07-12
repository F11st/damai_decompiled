package tb;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class f11 extends ReplacementSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C9124a Companion = new C9124a(null);
    private static final float c = 0.71428573f;
    private static final int d = ((Integer) Float.valueOf(a01.Companion.a())).intValue() / 5;
    @NotNull
    private final Drawable a;
    @Nullable
    private WeakReference<Drawable> b;

    /* compiled from: Taobao */
    /* renamed from: tb.f11$a */
    /* loaded from: classes7.dex */
    public static final class C9124a {
        private C9124a() {
        }

        public /* synthetic */ C9124a(k50 k50Var) {
            this();
        }
    }

    public f11(@Nullable String str, @NotNull Drawable drawable) {
        b41.i(drawable, "drawable");
        this.a = drawable;
    }

    private final Drawable a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-639292777")) {
            return (Drawable) ipChange.ipc$dispatch("-639292777", new Object[]{this});
        }
        WeakReference<Drawable> weakReference = this.b;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        if (drawable == null) {
            Drawable drawable2 = this.a;
            this.b = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }

    private final boolean b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-514549166")) {
            return ((Boolean) ipChange.ipc$dispatch("-514549166", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NotNull Canvas canvas, @NotNull CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NotNull Paint paint) {
        int i6;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1223312436")) {
            ipChange.ipc$dispatch("1223312436", new Object[]{this, canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint});
            return;
        }
        b41.i(canvas, "canvas");
        b41.i(charSequence, "text");
        b41.i(paint, "paint");
        Drawable a = a();
        canvas.save();
        if (b()) {
            b41.f(a);
            i6 = (i5 - a.getBounds().bottom) - paint.getFontMetricsInt().descent;
        } else {
            i6 = i3 + d;
        }
        canvas.translate(f, i6);
        b41.f(a);
        a.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NotNull Paint paint, @Nullable CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1896007828")) {
            return ((Integer) ipChange.ipc$dispatch("1896007828", new Object[]{this, paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})).intValue();
        }
        b41.i(paint, "paint");
        Drawable a = a();
        b41.f(a);
        Rect bounds = a.getBounds();
        b41.h(bounds, "d!!.bounds");
        if (fontMetricsInt != null) {
            if (b()) {
                fontMetricsInt.ascent = -bounds.bottom;
                fontMetricsInt.descent = 0;
            } else {
                int i3 = d;
                fontMetricsInt.ascent = ((int) (-(bounds.bottom * c))) - i3;
                fontMetricsInt.descent = ((Integer) Float.valueOf(a01.Companion.a() * 0.39999998f)).intValue() + i3;
            }
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = fontMetricsInt.descent;
        }
        return bounds.right;
    }
}
