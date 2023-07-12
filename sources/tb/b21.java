package tb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import cn.damai.common.image.blur.ImageBlurHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class b21 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String SHARE_TMP_IMAGE = "dm_share_tmp.png";

    @Deprecated
    public static Bitmap a(Context context, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1612695734") ? (Bitmap) ipChange.ipc$dispatch("1612695734", new Object[]{context, bitmap}) : ImageBlurHelper.d(context, bitmap);
    }

    public static Bitmap b(Context context, String str, Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1447078957") ? (Bitmap) ipChange.ipc$dispatch("-1447078957", new Object[]{context, str, bitmap, Integer.valueOf(i)}) : ImageBlurHelper.f(context, str, bitmap, i);
    }

    public static void c(Context context, String str, Bitmap bitmap, ImageBlurHelper.BlurImageCallback blurImageCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-493702355")) {
            ipChange.ipc$dispatch("-493702355", new Object[]{context, str, bitmap, blurImageCallback});
        } else {
            ImageBlurHelper.i(context, str, bitmap, blurImageCallback);
        }
    }

    public static String d(Activity activity) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-419264084") ? (String) ipChange.ipc$dispatch("-419264084", new Object[]{activity}) : activity.getExternalCacheDir().getAbsoluteFile().getAbsolutePath();
    }

    public static String e(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1174271432")) {
            return (String) ipChange.ipc$dispatch("-1174271432", new Object[]{activity});
        }
        return activity.getExternalCacheDir().getAbsoluteFile() + File.separator + "dm_share_tmp.png";
    }

    public static Bitmap f(Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1103818084")) {
            return (Bitmap) ipChange.ipc$dispatch("-1103818084", new Object[]{bitmap, Integer.valueOf(i)});
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
}
