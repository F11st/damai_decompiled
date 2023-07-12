package cn.damai.common.image;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.pexode.PexodeOptions;
import com.taobao.phenix.bitmap.BitmapProcessor;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class DMRoundedCornersBitmapProcessor implements BitmapProcessor {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final CornerType e;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum CornerType {
        ALL,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CornerType.values().length];
            a = iArr;
            try {
                iArr[CornerType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[CornerType.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[CornerType.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[CornerType.LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[CornerType.RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public DMRoundedCornersBitmapProcessor(int i, int i2) {
        this(0, 0, i, i2, CornerType.ALL);
    }

    private void a(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF;
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1150909927")) {
            ipChange.ipc$dispatch("1150909927", new Object[]{this, canvas, paint, Float.valueOf(f), Float.valueOf(f2)});
            return;
        }
        int i3 = this.d;
        float f3 = f - i3;
        float f4 = f2 - i3;
        int i4 = a.a[this.e.ordinal()];
        RectF rectF2 = null;
        if (i4 == 1) {
            int i5 = this.d;
            rectF2 = new RectF(i5, i5, f3, f4);
            rectF = null;
        } else if (i4 == 2) {
            int i6 = this.d;
            rectF2 = new RectF(i6, i6, f3, i6 + (this.c * 2));
            rectF = new RectF(this.d, i + this.c, f3, f4);
        } else if (i4 == 3) {
            rectF2 = new RectF(this.d, f4 - (this.c * 2), f3, f4);
            int i7 = this.d;
            rectF = new RectF(i7, i7, f3, f4 - this.c);
        } else if (i4 == 4) {
            int i8 = this.d;
            rectF2 = new RectF(i8, i8, i8 + (this.c * 2), f4);
            rectF = new RectF(this.c + i2, this.d, f3, f4);
        } else if (i4 != 5) {
            rectF = null;
        } else {
            rectF2 = new RectF(f3 - (this.c * 2), this.d, f3, f4);
            int i9 = this.d;
            rectF = new RectF(i9, i9, f3 - this.c, f4);
        }
        int i10 = this.c;
        canvas.drawRoundRect(rectF2, i10, i10, paint);
        if (rectF != null) {
            canvas.drawRect(rectF, paint);
        }
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    public String getId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "662278576")) {
            return (String) ipChange.ipc$dispatch("662278576", new Object[]{this});
        }
        return ExifInterface.LONGITUDE_WEST + this.a + "$H" + this.b + "$R" + this.c + "$M" + this.d + "$P" + this.e.ordinal();
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    public Bitmap process(@NonNull String str, @NonNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NonNull Bitmap bitmap) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "483275991")) {
            return (Bitmap) ipChange.ipc$dispatch("483275991", new Object[]{this, str, bitmapSupplier, bitmap});
        }
        float f = 1.0f;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = this.a;
        boolean z = i2 > 0 && (i = this.b) > 0 && !(i2 == width && i == height);
        if (z) {
            int i3 = this.b;
            if (width * i3 > height * i2) {
                float f2 = i3 / height;
                width = (int) ((width * f2) + 0.5d);
                height = i3;
                f = f2;
            } else {
                f = i2 / width;
                height = (int) ((height * f) + 0.5d);
                width = i2;
            }
        }
        Bitmap bitmap2 = bitmapSupplier.get(width, height, bitmap.getConfig() != null ? bitmap.getConfig() : PexodeOptions.CONFIG);
        Canvas canvas = new Canvas(bitmap2);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        if (z) {
            Matrix matrix = new Matrix();
            matrix.setScale(f, f);
            bitmapShader.setLocalMatrix(matrix);
        }
        paint.setShader(bitmapShader);
        a(canvas, paint, width, height);
        return bitmap2;
    }

    public DMRoundedCornersBitmapProcessor(int i, int i2, int i3, int i4, CornerType cornerType) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = cornerType;
    }
}
