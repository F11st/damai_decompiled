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
/* loaded from: classes9.dex */
public class ui extends Drawable {
    private static transient /* synthetic */ IpChange $ipChange;
    private Paint a;
    private int b;
    private Bitmap c;

    public ui(Bitmap bitmap) {
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
        if (AndroidInstantRuntime.support(ipChange, "-1349691764")) {
            ipChange.ipc$dispatch("-1349691764", new Object[]{this, canvas});
            return;
        }
        int i = this.b;
        canvas.drawCircle(i / 2, i / 2, i / 2, this.a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1661084314") ? ((Integer) ipChange.ipc$dispatch("1661084314", new Object[]{this})).intValue() : this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-34588919") ? ((Integer) ipChange.ipc$dispatch("-34588919", new Object[]{this})).intValue() : this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "575916731")) {
            return ((Integer) ipChange.ipc$dispatch("575916731", new Object[]{this})).intValue();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "372429314")) {
            ipChange.ipc$dispatch("372429314", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.a.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1750159236")) {
            ipChange.ipc$dispatch("-1750159236", new Object[]{this, colorFilter});
        } else {
            this.a.setColorFilter(colorFilter);
        }
    }
}
