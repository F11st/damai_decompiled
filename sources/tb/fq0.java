package tb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import androidx.annotation.CallSuper;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public abstract class fq0 extends gs0 {
    @Nullable
    private Bitmap e;
    private boolean f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fq0(@NotNull Path path) {
        super(path);
        b41.i(path, "shadowPath");
    }

    private final void i() {
        float f = 4;
        int width = (int) (Rect.width(getBounds()) + (a() * f));
        int height = (int) (Rect.height(getBounds()) + (a() * f));
        Bitmap bitmap = this.e;
        if (bitmap == null || bitmap.getWidth() < width || bitmap.getHeight() < height) {
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.e = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            d();
        }
    }

    private final void j(Bitmap bitmap) {
        if (this.f) {
            return;
        }
        k(bitmap);
        this.f = true;
    }

    @Override // tb.gs0
    public void d() {
        this.f = false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(@NotNull Canvas canvas) {
        b41.i(canvas, "canvas");
        i();
        Bitmap bitmap = this.e;
        if (bitmap == null) {
            return;
        }
        j(bitmap);
        float f = 2;
        canvas.drawBitmap(bitmap, (-a()) * f, (-a()) * f, (Paint) null);
    }

    @Override // tb.gs0
    @CallSuper
    public void e(float f, int i, boolean z) {
        d();
    }

    @Override // tb.gs0
    @CallSuper
    public void f(float f) {
        super.f(f);
        d();
    }

    public abstract void k(@NotNull Bitmap bitmap);

    @Override // android.graphics.drawable.Drawable
    @CallSuper
    protected void onBoundsChange(@NotNull android.graphics.Rect rect) {
        b41.i(rect, "bounds");
        super.onBoundsChange(rect);
        d();
    }
}
