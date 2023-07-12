package cn.damai.common.image.blur;

import android.graphics.Bitmap;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class LibBlur {
    private static transient /* synthetic */ IpChange $ipChange;
    private static boolean a;
    private static LibBlur b;

    static {
        try {
            System.loadLibrary("blur");
            a = true;
        } catch (Throwable th) {
            a = false;
            th.printStackTrace();
        }
    }

    LibBlur() {
    }

    public static LibBlur a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1431896581")) {
            return (LibBlur) ipChange.ipc$dispatch("-1431896581", new Object[0]);
        }
        if (b == null) {
            synchronized (LibBlur.class) {
                if (b == null) {
                    b = new LibBlur();
                }
            }
        }
        return b;
    }

    private static native void nativeStackBlur(Bitmap bitmap, int i);

    public Bitmap b(Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "961504536")) {
            return (Bitmap) ipChange.ipc$dispatch("961504536", new Object[]{this, bitmap, Integer.valueOf(i)});
        }
        if (bitmap != null && bitmap.getConfig() == Bitmap.Config.ARGB_8888 && a) {
            try {
                nativeStackBlur(bitmap, i);
                return bitmap;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
