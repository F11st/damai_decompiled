package tb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import cn.damai.commonbusiness.util.Utils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class w11 {
    private static transient /* synthetic */ IpChange $ipChange;

    private static int a(BitmapFactory.Options options, int i, int i2) {
        IpChange ipChange = $ipChange;
        int i3 = 2;
        if (AndroidInstantRuntime.support(ipChange, "960879478")) {
            return ((Integer) ipChange.ipc$dispatch("960879478", new Object[]{options, Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
        }
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        if (-1 != i && -1 != i2) {
            i3 = 1;
        }
        return (i4 <= i || i5 <= i2) ? i3 : Math.max(Math.round(i4 / i), Math.round(i5 / i2));
    }

    public static Bitmap b(String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1335434723")) {
            return (Bitmap) ipChange.ipc$dispatch("-1335434723", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            Utils.d(mu0.a(), str, options);
            options.inSampleSize = a(options, i, i2);
            options.inJustDecodeBounds = false;
            return Utils.d(mu0.a(), str, options);
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }

    public static int c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "733256868")) {
            return ((Integer) ipChange.ipc$dispatch("733256868", new Object[]{str})).intValue();
        }
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
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
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Bitmap d(String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1813239428")) {
            return (Bitmap) ipChange.ipc$dispatch("-1813239428", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        int c = c(str);
        Bitmap b = b(str, i, i2);
        return (b == null || c == 0) ? b : e(c, b);
    }

    public static Bitmap e(int i, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1740708336")) {
            return (Bitmap) ipChange.ipc$dispatch("1740708336", new Object[]{Integer.valueOf(i), bitmap});
        }
        Bitmap bitmap2 = null;
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        try {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Exception | OutOfMemoryError unused) {
        }
        if (bitmap2 == null) {
            bitmap2 = bitmap;
        }
        if (bitmap != bitmap2) {
            bitmap.recycle();
        }
        return bitmap2;
    }
}
