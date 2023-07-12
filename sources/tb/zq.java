package tb;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.pexode.PexodeOptions;
import com.taobao.phenix.bitmap.BitmapProcessor;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class zq implements BitmapProcessor {
    private static transient /* synthetic */ IpChange $ipChange;
    private final float a;
    private final int b;
    private final float c;
    private final int d;

    public zq(float f, int i, float f2, int i2) {
        this.a = f;
        this.b = i;
        this.d = i2;
        this.c = f2;
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    public String getId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1500298737")) {
            return (String) ipChange.ipc$dispatch("-1500298737", new Object[]{this});
        }
        return ExifInterface.LONGITUDE_WEST + this.a + "$C" + this.b;
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    public Bitmap process(@NonNull String str, @NonNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NonNull Bitmap bitmap) {
        float f;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1495299368")) {
            return (Bitmap) ipChange.ipc$dispatch("-1495299368", new Object[]{this, str, bitmapSupplier, bitmap});
        }
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        int width = (min - bitmap.getWidth()) / 2;
        int height = (min - bitmap.getHeight()) / 2;
        float f2 = min / 2.0f;
        float f3 = this.a;
        if (f3 > 0.0f) {
            f = f2 + f3;
        } else {
            f = f2;
            f3 = 0.0f;
        }
        int i = (int) (f * 2.0f);
        Bitmap bitmap2 = bitmapSupplier.get(i, i, bitmap.getConfig() != null ? bitmap.getConfig() : PexodeOptions.CONFIG);
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        if (width != 0 || height != 0) {
            Matrix matrix = new Matrix();
            matrix.setTranslate(width, height);
            bitmapShader.setLocalMatrix(matrix);
        }
        paint.setShader(bitmapShader);
        paint.setAntiAlias(true);
        canvas.drawCircle(f, f, f2, paint);
        if (this.a > 0.0f) {
            Path path = new Path();
            Paint paint2 = new Paint();
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setAntiAlias(true);
            paint2.setColor(this.b);
            paint2.setStrokeWidth(f3);
            path.addCircle(f, f, f - (f3 / 2.0f), Path.Direction.CCW);
            canvas.drawPath(path, paint2);
        }
        if (this.c > 0.0f) {
            Path path2 = new Path();
            Paint paint3 = new Paint();
            paint3.setStyle(Paint.Style.STROKE);
            paint3.setAntiAlias(true);
            paint3.setColor(this.d);
            paint3.setStrokeWidth(this.c);
            path2.addCircle(f, f, (f - f3) - (this.c / 2.0f), Path.Direction.CCW);
            canvas.drawPath(path2, paint3);
        }
        return bitmap2;
    }
}
