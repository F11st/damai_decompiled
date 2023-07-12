package tb;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class hq1 extends Drawable {
    protected Paint a;

    /* JADX INFO: Access modifiers changed from: protected */
    public hq1() {
        Paint paint = new Paint();
        this.a = paint;
        paint.setStyle(Paint.Style.FILL);
        this.a.setAntiAlias(true);
        this.a.setColor(-5592406);
    }

    public void a(int i) {
        this.a.setColor(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }
}
