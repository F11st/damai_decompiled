package tb;

import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class iq0 extends fq0 {
    @NotNull
    private final Paint g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iq0(@NotNull Path path) {
        super(path);
        b41.i(path, "shadowPath");
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        wt2 wt2Var = wt2.INSTANCE;
        this.g = paint;
    }

    @Override // tb.fq0, tb.gs0
    public void e(float f, int i, boolean z) {
        BlurMaskFilter.Blur blur;
        super.e(f, i, z);
        if (b()) {
            blur = BlurMaskFilter.Blur.INNER;
        } else {
            blur = BlurMaskFilter.Blur.NORMAL;
        }
        this.g.setMaskFilter((a() > 0.0f ? 1 : (a() == 0.0f ? 0 : -1)) == 0 ? null : new BlurMaskFilter(a(), blur));
        this.g.setColor(i);
    }

    @Override // tb.fq0
    public void k(@NotNull Bitmap bitmap) {
        b41.i(bitmap, "bitmap");
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        float f = 2;
        canvas.translate(a() * f, a() * f);
        canvas.drawPath(c(), this.g);
    }
}
