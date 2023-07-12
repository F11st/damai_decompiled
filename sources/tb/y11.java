package tb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.alibaba.pictures.bricks.util.blur.ImageBlurHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class y11 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String SHARE_TMP_IMAGE = "dm_share_tmp.png";

    @Deprecated
    public static Bitmap a(Context context, Bitmap bitmap, int i, int i2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1982583543") ? (Bitmap) ipChange.ipc$dispatch("1982583543", new Object[]{context, bitmap, Integer.valueOf(i), Integer.valueOf(i2)}) : ImageBlurHelper.d(context, bitmap, i, i2);
    }

    public static void b(Context context, String str, Bitmap bitmap, ImageBlurHelper.BlurImageCallback blurImageCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "843748228")) {
            ipChange.ipc$dispatch("843748228", new Object[]{context, str, bitmap, blurImageCallback});
        } else {
            ImageBlurHelper.g(context, str, bitmap, blurImageCallback);
        }
    }

    public static Bitmap c(Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "472416155")) {
            return (Bitmap) ipChange.ipc$dispatch("472416155", new Object[]{bitmap, Integer.valueOf(i)});
        }
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (i <= 0) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale((width / i) / width, (height / i) / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Bitmap d(Bitmap bitmap, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-914133467")) {
            return (Bitmap) ipChange.ipc$dispatch("-914133467", new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float min = Math.min(i / width, i2 / height);
        Matrix matrix = new Matrix();
        matrix.postScale(min, min);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }
}
