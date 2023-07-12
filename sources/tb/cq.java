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
import com.taobao.pexode.PexodeOptions;
import com.taobao.phenix.bitmap.BitmapProcessor;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class cq implements BitmapProcessor {
    private final float a;
    private final int b;

    public cq() {
        this(0.0f, 0);
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    public String getId() {
        return ExifInterface.LONGITUDE_WEST + this.a + "$C" + this.b;
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    public Bitmap process(@NonNull String str, @NonNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NonNull Bitmap bitmap) {
        float f;
        float f2;
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        int width = (min - bitmap.getWidth()) / 2;
        int height = (min - bitmap.getHeight()) / 2;
        float f3 = min / 2.0f;
        float f4 = this.a;
        if (f4 > 0.0f) {
            f2 = f3 / f4;
            f = f3 + f2;
        } else {
            f = f3;
            f2 = 0.0f;
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
        canvas.drawCircle(f, f, f3, paint);
        if (this.a > 0.0f) {
            Path path = new Path();
            Paint paint2 = new Paint();
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setAntiAlias(true);
            paint2.setColor(this.b);
            paint2.setStrokeWidth(f2);
            path.addCircle(f, f, f - (f2 / 2.0f), Path.Direction.CCW);
            canvas.drawPath(path, paint2);
        }
        return bitmap2;
    }

    public cq(float f, int i) {
        this.a = f;
        this.b = i;
    }
}
