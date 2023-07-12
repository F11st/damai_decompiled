package tb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class h92 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String SEAT = "seat";
    public static final String SEAT_LOCKED = "seat_locked";
    public static final String SEAT_NO_SELECTED = "seat_no_selected";
    public static final int SEAT_REND_MODE_CIRCLE = 1;
    public static final int SEAT_REND_MODE_OCTAGON = 2;
    public static final int SEAT_REND_MODE_SOFA = 3;
    public static final String SEAT_SELECTED = "seat_selected";
    public static final String TAOPIAO = "taopiao";
    public static final String TAOPIAO_PROMOTION = "taopiao_promotion";
    private static volatile h92 i;
    private Path a;
    private Path b;
    private Paint c;
    private Paint d;
    private Bitmap e;
    private int f = 225;
    private int g = 225;
    private final Matrix h = new Matrix();

    private h92() {
        new HashMap();
        this.a = new Path();
        this.b = new Path();
        Paint paint = new Paint(1);
        this.c = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.d = paint2;
        paint2.setStyle(Paint.Style.STROKE);
    }

    public static h92 e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2026404933")) {
            return (h92) ipChange.ipc$dispatch("-2026404933", new Object[0]);
        }
        if (i == null) {
            synchronized (h92.class) {
                if (i == null) {
                    i = new h92();
                }
            }
        }
        return i;
    }

    protected int a(int i2, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1036710204") ? ((Integer) ipChange.ipc$dispatch("1036710204", new Object[]{this, Integer.valueOf(i2), Float.valueOf(f)})).intValue() : (i2 & 16777215) | (((int) (Color.alpha(i2) * f)) << 24);
    }

    public Bitmap b(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1947540167")) {
            return (Bitmap) ipChange.ipc$dispatch("-1947540167", new Object[]{this, Integer.valueOf(i2)});
        }
        this.c.setAntiAlias(true);
        this.c.setStyle(Paint.Style.FILL);
        this.e = Bitmap.createBitmap(this.f, this.g, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.e);
        int i3 = this.f;
        float f = i3 / 32.0f;
        float f2 = i3 / 32.0f;
        this.a.reset();
        this.b.reset();
        this.h.setValues(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f});
        this.h.postScale(f, f2);
        this.a.moveTo(16.0f, 32.0f);
        this.a.cubicTo(7.163444f, 32.0f, 0.0f, 24.836555f, 0.0f, 16.0f);
        this.a.cubicTo(0.0f, 7.163444f, 7.163444f, 0.0f, 16.0f, 0.0f);
        this.a.cubicTo(24.836555f, 0.0f, 32.0f, 7.163444f, 32.0f, 16.0f);
        this.a.cubicTo(32.0f, 24.836555f, 24.836555f, 32.0f, 16.0f, 32.0f);
        this.a.close();
        this.a.moveTo(16.0f, 32.0f);
        this.b.addPath(this.a, this.h);
        this.b.setFillType(Path.FillType.WINDING);
        if (this.c == null) {
            Paint paint = new Paint(1);
            this.c = paint;
            paint.setStyle(Paint.Style.FILL);
            this.c.setAntiAlias(true);
        }
        this.c.setColor(a(i2, 1.0f));
        canvas.drawPath(this.b, this.c);
        this.a.reset();
        this.b.reset();
        this.h.setValues(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f});
        this.h.postScale(f, f2);
        this.a.moveTo(16.0f, 32.0f);
        this.a.cubicTo(7.163444f, 32.0f, 0.0f, 24.836555f, 0.0f, 16.0f);
        this.a.cubicTo(0.0f, 7.163444f, 7.163444f, 0.0f, 16.0f, 0.0f);
        this.a.cubicTo(24.836555f, 0.0f, 32.0f, 7.163444f, 32.0f, 16.0f);
        this.a.cubicTo(32.0f, 24.836555f, 24.836555f, 32.0f, 16.0f, 32.0f);
        this.a.close();
        this.a.moveTo(16.0f, 32.0f);
        this.a.moveTo(16.0f, 31.0f);
        this.a.cubicTo(24.284271f, 31.0f, 31.0f, 24.284271f, 31.0f, 16.0f);
        this.a.cubicTo(31.0f, 7.7157288f, 24.284271f, 1.0f, 16.0f, 1.0f);
        this.a.cubicTo(7.7157288f, 1.0f, 1.0f, 7.7157288f, 1.0f, 16.0f);
        this.a.cubicTo(1.0f, 24.284271f, 7.7157288f, 31.0f, 16.0f, 31.0f);
        this.a.close();
        this.a.moveTo(16.0f, 31.0f);
        this.b.addPath(this.a, this.h);
        this.b.setFillType(Path.FillType.WINDING);
        this.c.setColor(a(Color.parseColor("#1A000000"), 1.0f));
        canvas.drawPath(this.b, this.c);
        this.a.reset();
        this.b.reset();
        this.h.setValues(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f});
        this.h.postScale(f, f2);
        this.a.moveTo(19.224f, 13.112f);
        this.a.cubicTo(18.44f, 12.568f, 17.816f, 11.992f, 17.336f, 11.384f);
        this.a.lineTo(15.528f, 11.384f);
        this.a.cubicTo(14.984f, 12.024f, 14.344f, 12.6f, 13.608f, 13.112f);
        this.a.lineTo(19.224f, 13.112f);
        this.a.close();
        this.a.moveTo(19.224f, 13.112f);
        this.a.moveTo(18.584f, 11.384f);
        this.a.cubicTo(19.672f, 12.44f, 21.32f, 13.272f, 23.528f, 13.88f);
        this.a.lineTo(23.016f, 14.952f);
        this.a.cubicTo(21.848f, 14.536f, 20.84f, 14.088f, 19.992f, 13.592f);
        this.a.lineTo(19.992f, 14.072f);
        this.a.lineTo(13.368f, 14.072f);
        this.a.lineTo(13.368f, 15.048f);
        this.a.lineTo(20.792f, 15.048f);
        this.a.lineTo(20.792f, 15.976f);
        this.a.lineTo(13.368f, 15.976f);
        this.a.lineTo(13.368f, 16.936f);
        this.a.lineTo(20.792f, 16.936f);
        this.a.lineTo(20.792f, 17.864f);
        this.a.lineTo(13.368f, 17.864f);
        this.a.lineTo(13.368f, 18.872f);
        this.a.lineTo(23.096f, 18.872f);
        this.a.lineTo(23.096f, 19.912f);
        this.a.lineTo(14.76f, 19.912f);
        this.a.cubicTo(14.12f, 20.968f, 13.512f, 21.784f, 12.936f, 22.36f);
        this.a.cubicTo(15.336f, 22.232f, 17.656f, 21.992f, 19.864f, 21.64f);
        this.a.cubicTo(19.56f, 21.192f, 19.256f, 20.776f, 18.936f, 20.392f);
        this.a.lineTo(19.928f, 20.056f);
        this.a.cubicTo(20.776f, 21.048f, 21.512f, 22.104f, 22.136f, 23.24f);
        this.a.lineTo(21.096f, 23.704f);
        this.a.cubicTo(20.888f, 23.304f, 20.68f, 22.936f, 20.472f, 22.584f);
        this.a.cubicTo(17.512f, 23.016f, 14.408f, 23.288f, 11.176f, 23.416f);
        this.a.lineTo(10.888f, 22.456f);
        this.a.cubicTo(11.672f, 22.392f, 12.52f, 21.544f, 13.416f, 19.912f);
        this.a.lineTo(9.336f, 19.912f);
        this.a.lineTo(9.336f, 18.872f);
        this.a.lineTo(12.248f, 18.872f);
        this.a.lineTo(12.248f, 13.928f);
        this.a.cubicTo(11.416f, 14.344f, 10.52f, 14.712f, 9.544f, 15.016f);
        this.a.lineTo(9.0f, 14.04f);
        this.a.cubicTo(11.224f, 13.368f, 12.92f, 12.472f, 14.088f, 11.384f);
        this.a.lineTo(9.56f, 11.384f);
        this.a.lineTo(9.56f, 10.328f);
        this.a.lineTo(15.016f, 10.328f);
        this.a.cubicTo(15.32f, 9.912f, 15.56f, 9.464f, 15.752f, 9.0f);
        this.a.lineTo(16.872f, 9.128f);
        this.a.cubicTo(16.712f, 9.544f, 16.504f, 9.944f, 16.28f, 10.328f);
        this.a.lineTo(22.888f, 10.328f);
        this.a.lineTo(22.888f, 11.384f);
        this.a.lineTo(18.584f, 11.384f);
        this.a.close();
        this.a.moveTo(18.584f, 11.384f);
        this.b.addPath(this.a, this.h);
        this.b.setFillType(Path.FillType.WINDING);
        this.c.setColor(a(1291845632, 1.0f));
        canvas.drawPath(this.b, this.c);
        return this.e;
    }

    public Bitmap c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1867663610")) {
            return (Bitmap) ipChange.ipc$dispatch("-1867663610", new Object[]{this});
        }
        this.c.setAntiAlias(true);
        this.c.setStyle(Paint.Style.FILL);
        this.e = Bitmap.createBitmap(this.f, this.g, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.e);
        float f = this.f / 32.0f;
        float f2 = this.g / 32.0f;
        this.a.reset();
        this.b.reset();
        this.h.setValues(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f});
        this.h.postScale(f, f2);
        this.a.moveTo(16.0f, 16.0f);
        this.a.rMoveTo(-16.0f, 0.0f);
        this.a.cubicTo(-5.1947514E-16f, 11.758163f, 1.6868602f, 7.685723f, 4.6862917f, 4.6862917f);
        this.a.cubicTo(7.685723f, 1.6868602f, 11.758163f, 7.792127E-16f, 16.0f, 0.0f);
        this.a.cubicTo(20.241837f, -7.792127E-16f, 24.314278f, 1.6868602f, 27.31371f, 4.6862917f);
        this.a.cubicTo(30.313139f, 7.685723f, 32.0f, 11.758163f, 32.0f, 16.0f);
        this.a.cubicTo(32.0f, 20.241837f, 30.313139f, 24.314278f, 27.31371f, 27.31371f);
        this.a.cubicTo(24.314278f, 30.313139f, 20.241837f, 32.0f, 16.0f, 32.0f);
        this.a.cubicTo(11.758163f, 32.0f, 7.685723f, 30.313139f, 4.6862917f, 27.31371f);
        this.a.cubicTo(1.6868602f, 24.314278f, 5.1947514E-16f, 20.241837f, 0.0f, 16.0f);
        this.b.addPath(this.a, this.h);
        this.b.setFillType(Path.FillType.EVEN_ODD);
        if (this.c == null) {
            Paint paint = new Paint(1);
            this.c = paint;
            paint.setStyle(Paint.Style.FILL);
            this.c.setAntiAlias(true);
        }
        this.c.setColor(a(-10238644, 1.0f));
        canvas.drawPath(this.b, this.c);
        this.a.reset();
        this.b.reset();
        this.h.setValues(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f});
        this.h.postScale(f, f2);
        this.a.moveTo(16.0f, 32.0f);
        this.a.cubicTo(7.163444f, 32.0f, 0.0f, 24.836555f, 0.0f, 16.0f);
        this.a.cubicTo(0.0f, 7.163444f, 7.163444f, 0.0f, 16.0f, 0.0f);
        this.a.cubicTo(24.836555f, 0.0f, 32.0f, 7.163444f, 32.0f, 16.0f);
        this.a.cubicTo(32.0f, 24.836555f, 24.836555f, 32.0f, 16.0f, 32.0f);
        this.a.close();
        this.a.moveTo(16.0f, 32.0f);
        this.a.moveTo(16.0f, 31.0f);
        this.a.cubicTo(24.284271f, 31.0f, 31.0f, 24.284271f, 31.0f, 16.0f);
        this.a.cubicTo(31.0f, 7.7157288f, 24.284271f, 1.0f, 16.0f, 1.0f);
        this.a.cubicTo(7.7157288f, 1.0f, 1.0f, 7.7157288f, 1.0f, 16.0f);
        this.a.cubicTo(1.0f, 24.284271f, 7.7157288f, 31.0f, 16.0f, 31.0f);
        this.a.close();
        this.a.moveTo(16.0f, 31.0f);
        this.b.addPath(this.a, this.h);
        this.b.setFillType(Path.FillType.EVEN_ODD);
        this.c.setColor(a(-12082639, 1.0f));
        canvas.drawPath(this.b, this.c);
        this.a.reset();
        this.b.reset();
        this.h.setValues(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f});
        this.h.postScale(f, f2);
        this.a.moveTo(10.743418f, 14.610037f);
        this.a.cubicTo(10.374029f, 14.199464f, 9.741745f, 14.166077f, 9.331171f, 14.535465f);
        this.a.cubicTo(8.920598f, 14.904854f, 8.887211f, 15.537138f, 9.256599f, 15.947712f);
        this.a.lineTo(13.504148f, 20.668839f);
        this.a.cubicTo(13.891549f, 21.099434f, 14.562605f, 21.111862f, 14.965687f, 20.69591f);
        this.a.lineTo(22.71814f, 12.6959095f);
        this.a.cubicTo(23.102478f, 12.299297f, 23.09253f, 11.66621f, 22.695917f, 11.281871f);
        this.a.cubicTo(22.299305f, 10.897531f, 21.666218f, 10.907479f, 21.28188f, 11.304092f);
        this.a.lineTo(14.274692f, 18.535028f);
        this.a.lineTo(10.743418f, 14.610037f);
        this.a.close();
        this.a.moveTo(10.743418f, 14.610037f);
        this.b.addPath(this.a, this.h);
        this.b.setFillType(Path.FillType.WINDING);
        this.c.setColor(a(-1, 1.0f));
        canvas.drawPath(this.b, this.c);
        return this.e;
    }

    public Bitmap d(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1368461488")) {
            return (Bitmap) ipChange.ipc$dispatch("1368461488", new Object[]{this, Integer.valueOf(i2)});
        }
        this.c.setAntiAlias(true);
        this.c.setStyle(Paint.Style.FILL);
        this.e = Bitmap.createBitmap(this.f, this.g, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.e);
        float f = this.f / 32.0f;
        float f2 = this.g / 32.0f;
        this.a.reset();
        this.b.reset();
        this.h.setValues(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f});
        this.h.postScale(f, f2);
        this.a.moveTo(16.0f, 16.0f);
        this.a.rMoveTo(-16.0f, 0.0f);
        this.a.cubicTo(-5.1947514E-16f, 11.758163f, 1.6868602f, 7.685723f, 4.6862917f, 4.6862917f);
        this.a.cubicTo(7.685723f, 1.6868602f, 11.758163f, 7.792127E-16f, 16.0f, 0.0f);
        this.a.cubicTo(20.241837f, -7.792127E-16f, 24.314278f, 1.6868602f, 27.31371f, 4.6862917f);
        this.a.cubicTo(30.313139f, 7.685723f, 32.0f, 11.758163f, 32.0f, 16.0f);
        this.a.cubicTo(32.0f, 20.241837f, 30.313139f, 24.314278f, 27.31371f, 27.31371f);
        this.a.cubicTo(24.314278f, 30.313139f, 20.241837f, 32.0f, 16.0f, 32.0f);
        this.a.cubicTo(11.758163f, 32.0f, 7.685723f, 30.313139f, 4.6862917f, 27.31371f);
        this.a.cubicTo(1.6868602f, 24.314278f, 5.1947514E-16f, 20.241837f, 0.0f, 16.0f);
        this.b.addPath(this.a, this.h);
        this.b.setFillType(Path.FillType.EVEN_ODD);
        if (this.c == null) {
            Paint paint = new Paint(1);
            this.c = paint;
            paint.setStyle(Paint.Style.FILL);
            this.c.setAntiAlias(true);
        }
        this.c.setColor(a(i2, 1.0f));
        canvas.drawPath(this.b, this.c);
        this.a.reset();
        this.b.reset();
        this.h.setValues(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f});
        this.h.postScale(f, f2);
        this.a.moveTo(16.0f, 32.0f);
        this.a.cubicTo(7.163444f, 32.0f, 0.0f, 24.836555f, 0.0f, 16.0f);
        this.a.cubicTo(0.0f, 7.163444f, 7.163444f, 0.0f, 16.0f, 0.0f);
        this.a.cubicTo(24.836555f, 0.0f, 32.0f, 7.163444f, 32.0f, 16.0f);
        this.a.cubicTo(32.0f, 24.836555f, 24.836555f, 32.0f, 16.0f, 32.0f);
        this.a.close();
        this.a.moveTo(16.0f, 32.0f);
        this.a.moveTo(16.0f, 31.0f);
        this.a.cubicTo(24.284271f, 31.0f, 31.0f, 24.284271f, 31.0f, 16.0f);
        this.a.cubicTo(31.0f, 7.7157288f, 24.284271f, 1.0f, 16.0f, 1.0f);
        this.a.cubicTo(7.7157288f, 1.0f, 1.0f, 7.7157288f, 1.0f, 16.0f);
        this.a.cubicTo(1.0f, 24.284271f, 7.7157288f, 31.0f, 16.0f, 31.0f);
        this.a.close();
        this.a.moveTo(16.0f, 31.0f);
        this.b.addPath(this.a, this.h);
        this.b.setFillType(Path.FillType.EVEN_ODD);
        this.c.setColor(a(Color.parseColor("#1A000000"), 1.0f));
        canvas.drawPath(this.b, this.c);
        return this.e;
    }

    public void f(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-620905487")) {
            ipChange.ipc$dispatch("-620905487", new Object[]{this, Integer.valueOf(i2)});
        }
    }
}
