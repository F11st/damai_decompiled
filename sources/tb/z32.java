package tb;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class z32 extends Drawable {
    private static transient /* synthetic */ IpChange $ipChange;
    private Bitmap a;
    private Paint b;
    private RectF c;
    private int d;
    private Bitmap e;

    public z32(Bitmap bitmap) {
        this.a = bitmap;
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setDither(true);
        Paint paint2 = this.b;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint2.setShader(new BitmapShader(bitmap, tileMode, tileMode));
    }

    public void a(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1103765665")) {
            ipChange.ipc$dispatch("1103765665", new Object[]{this, bitmap});
        } else {
            this.e = bitmap;
        }
    }

    public void b(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "180913743")) {
            ipChange.ipc$dispatch("180913743", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.d = i;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1145256153")) {
            ipChange.ipc$dispatch("-1145256153", new Object[]{this, canvas});
            return;
        }
        RectF rectF = this.c;
        int i = this.d;
        canvas.drawRoundRect(rectF, i, i, this.b);
        Bitmap bitmap = this.e;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (this.a.getWidth() / 2) - (this.e.getWidth() / 2), (this.a.getHeight() / 2) - (this.e.getHeight() / 2), this.b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1874003167") ? ((Integer) ipChange.ipc$dispatch("1874003167", new Object[]{this})).intValue() : this.a.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "942110756") ? ((Integer) ipChange.ipc$dispatch("942110756", new Object[]{this})).intValue() : this.a.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "645513728")) {
            return ((Integer) ipChange.ipc$dispatch("645513728", new Object[]{this})).intValue();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1149346275")) {
            ipChange.ipc$dispatch("-1149346275", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.b.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "849222257")) {
            ipChange.ipc$dispatch("849222257", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.setBounds(i, i2, i3, i4);
        this.c = new RectF(i, i2, i3, i4);
        Log.d("blockW", " change left: " + i + " , " + i2 + " , " + i3 + " , " + i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "738367105")) {
            ipChange.ipc$dispatch("738367105", new Object[]{this, colorFilter});
        } else {
            this.b.setColorFilter(colorFilter);
        }
    }
}
