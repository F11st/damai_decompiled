package tb;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.opensource.svgaplayer.SVGAVideoEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class s42 extends Drawable {
    private boolean a;
    private int b;
    @NotNull
    private ImageView.ScaleType c;
    private final r42 d;
    @NotNull
    private final SVGAVideoEntity e;
    @NotNull
    private final t42 f;

    public s42(@NotNull SVGAVideoEntity sVGAVideoEntity, @NotNull t42 t42Var) {
        b41.j(sVGAVideoEntity, "videoItem");
        b41.j(t42Var, "dynamicItem");
        this.e = sVGAVideoEntity;
        this.f = t42Var;
        this.a = true;
        this.c = ImageView.ScaleType.MATRIX;
        this.d = new r42(sVGAVideoEntity, t42Var);
    }

    public final int a() {
        return this.b;
    }

    @NotNull
    public final SVGAVideoEntity b() {
        return this.e;
    }

    public final void c(boolean z) {
        if (this.a == z) {
            return;
        }
        this.a = z;
        invalidateSelf();
    }

    public final void d(int i) {
        if (this.b == i) {
            return;
        }
        this.b = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@Nullable Canvas canvas) {
        if (this.a || canvas == null) {
            return;
        }
        this.d.a(canvas, this.b, this.c);
    }

    public final void e(@NotNull ImageView.ScaleType scaleType) {
        b41.j(scaleType, "<set-?>");
        this.c = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s42(@NotNull SVGAVideoEntity sVGAVideoEntity) {
        this(sVGAVideoEntity, new t42());
        b41.j(sVGAVideoEntity, "videoItem");
    }
}
