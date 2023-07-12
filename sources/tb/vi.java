package tb;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class vi extends Drawable {
    private static transient /* synthetic */ IpChange $ipChange;
    private Paint a;
    private int b;
    private Bitmap c;

    public vi(Bitmap bitmap) {
        this.c = bitmap;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setShader(bitmapShader);
        this.b = Math.min(this.c.getWidth(), this.c.getHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1063760556")) {
            ipChange.ipc$dispatch("1063760556", new Object[]{this, canvas});
            return;
        }
        int i = this.b;
        canvas.drawCircle(i / 2, i / 2, i / 2, this.a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "268966522") ? ((Integer) ipChange.ipc$dispatch("268966522", new Object[]{this})).intValue() : this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1583072041") ? ((Integer) ipChange.ipc$dispatch("1583072041", new Object[]{this})).intValue() : this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1254120805")) {
            return ((Integer) ipChange.ipc$dispatch("-1254120805", new Object[]{this})).intValue();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1283227170")) {
            ipChange.ipc$dispatch("1283227170", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.a.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1232301988")) {
            ipChange.ipc$dispatch("-1232301988", new Object[]{this, colorFilter});
        } else {
            this.a.setColorFilter(colorFilter);
        }
    }
}
