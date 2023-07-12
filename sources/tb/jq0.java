package tb;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class jq0 extends gs0 {
    @NotNull
    private final Paint e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jq0(@NotNull Path path) {
        super(path);
        b41.i(path, "shadowPath");
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        wt2 wt2Var = wt2.INSTANCE;
        this.e = paint;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        b41.i(canvas, "canvas");
        canvas.drawPath(c(), this.e);
    }

    @Override // tb.gs0
    public void e(float f, int i, boolean z) {
        BlurMaskFilter.Blur blur;
        if (b()) {
            blur = BlurMaskFilter.Blur.INNER;
        } else {
            blur = BlurMaskFilter.Blur.NORMAL;
        }
        this.e.setMaskFilter((a() > 0.0f ? 1 : (a() == 0.0f ? 0 : -1)) == 0 ? null : new BlurMaskFilter(a(), blur));
        this.e.setColor(i);
    }
}
