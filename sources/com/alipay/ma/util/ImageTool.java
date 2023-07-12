package com.alipay.ma.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import com.alipay.ma.MaBuryRecord;
import com.alipay.ma.MaLogger;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ImageTool {
    public static final String TAG = "ImageTool";

    private static int a(double d, double d2) {
        if (d2 <= 0.0d || d <= 0.0d) {
            return -1;
        }
        if (d2 * d >= 9.0E7d) {
            boolean d3 = d();
            MaLogger.d(TAG, "bigPixelsImagePreExecute isMemRich =" + d3);
            MaBuryRecord.recordBigPixelsImageScan(d, d2);
            return d3 ? 3000 : -1;
        }
        return -1;
    }

    private static int b(BitmapFactory.Options options, int i, int i2) {
        int min;
        double d = options.outWidth;
        double d2 = options.outHeight;
        MaLogger.d(TAG, "computeInitialSampleSize w=" + d + ",h=" + d2);
        int a = a(d, d2);
        if (a > 0) {
            i2 = a * a;
            MaLogger.d(TAG, "computeInitialSampleSize bigPixelsSampleSize=" + a + ",maxNumOfPixels=" + i2);
            i = a;
        }
        int floor = i2 == -1 ? 1 : (int) Math.floor(Math.sqrt((d * d2) / i2));
        if (i == -1) {
            min = 128;
        } else {
            double d3 = i;
            min = (int) Math.min(Math.floor(d / d3), Math.floor(d2 / d3));
        }
        if (min < floor) {
            return floor;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        return i == -1 ? floor : min;
    }

    private static int c(String str) {
        ExifInterface exifInterface;
        try {
            exifInterface = new ExifInterface(str);
        } catch (IOException unused) {
            exifInterface = null;
        }
        if (exifInterface != null) {
            int attributeInt = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    if (attributeInt != 8) {
                        return 0;
                    }
                    return AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE;
                }
                return 90;
            }
            return 180;
        }
        return 0;
    }

    public static int computeSampleSize(BitmapFactory.Options options, int i, int i2) {
        int b = b(options, i, i2);
        if (b <= 8) {
            int i3 = 1;
            while (i3 < b) {
                i3 <<= 1;
            }
            return i3;
        }
        return ((b + 7) / 8) * 8;
    }

    public static Bitmap createThumbnail(FileDescriptor fileDescriptor, int i, int i2) {
        BitmapFactory.Options options;
        if (fileDescriptor != null) {
            if (i <= 0 || i2 <= 0) {
                options = null;
            } else {
                try {
                    options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
                    options.inSampleSize = computeSampleSize(options, Math.min(i, i2), i * i2);
                    options.inJustDecodeBounds = false;
                    options.inInputShareable = true;
                    options.inPurgeable = true;
                } catch (Throwable th) {
                    MaLogger.e(TAG, "createThumbnail error:" + th.getMessage());
                    return null;
                }
            }
            return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        }
        return null;
    }

    private static boolean d() {
        try {
            return ((Boolean) Class.forName("com.alipay.mobile.mascanengine.AlipayMaEngineUtils").getMethod("isBigPixelsScanMemoryRich", null).invoke(null, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Bitmap rotateBitmap(String str, int i) {
        return rotateBitmap(BitmapFactory.decodeFile(str), i);
    }

    public static boolean rotateBitmapAtPath(String str, int i, Bitmap.CompressFormat compressFormat) {
        Bitmap rotateBitmap = rotateBitmap(str, i);
        if (rotateBitmap == null) {
            return false;
        }
        try {
            return rotateBitmap.compress(compressFormat, 100, new FileOutputStream(str));
        } catch (FileNotFoundException e) {
            MaLogger.e(TAG, "rotateBitmapAtPath Error", e);
            return false;
        }
    }

    public static Bitmap toGrayscale(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public static Bitmap toRoundCorner(Context context, Bitmap bitmap, int i, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4) {
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        float f = context.getResources().getDisplayMetrics().density;
        Paint paint = new Paint();
        RectF rectF = new RectF(new Rect(0, 0, i2, i3));
        float f2 = i * f;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (z) {
            canvas.drawRect(0.0f, 0.0f, i2 / 2, i3 / 2, paint);
        }
        if (z2) {
            canvas.drawRect(i2 / 2, 0.0f, i2, i3 / 2, paint);
        }
        if (z3) {
            canvas.drawRect(0.0f, i3 / 2, i2 / 2, i3, paint);
        }
        if (z4) {
            canvas.drawRect(i2 / 2, i3 / 2, i2, i3, paint);
        }
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap createThumbnail(File file, int i, int i2) {
        return createThumbnail(file, i, i2, false);
    }

    public static Bitmap createThumbnail(File file, int i, int i2, boolean z) {
        BitmapFactory.Options options;
        int c;
        Bitmap bitmap = null;
        if (file == null || !file.exists()) {
            return null;
        }
        if (i <= 0 || i2 <= 0) {
            options = null;
        } else {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getPath(), options);
            options.inSampleSize = computeSampleSize(options, Math.min(i, i2), i * i2);
            options.inJustDecodeBounds = false;
            options.inInputShareable = true;
            options.inPurgeable = true;
        }
        try {
            bitmap = BitmapFactory.decodeFile(file.getPath(), options);
            Bitmap.Config config = bitmap.getConfig();
            MaLogger.d("TAG", "type=" + config.name());
        } catch (OutOfMemoryError e) {
            MaLogger.d("TAG", "e" + e.getLocalizedMessage());
        }
        if (bitmap == null || !z || (c = c(file.getAbsolutePath())) == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(c);
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }
}
