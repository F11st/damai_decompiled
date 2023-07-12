package tb;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.core.internal.view.SupportMenu;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class md2 {
    public static int a(int i, int i2, int i3, int i4) {
        double min = Math.min(i / i3, i2 / i4);
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (f2 > min) {
                return (int) f;
            }
            f = f2;
        }
    }

    public static int b(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
            }
        }
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    public static int c(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (i == 0) {
            return (int) (i3 * (i2 / i4));
        } else if (i2 == 0) {
            return i;
        } else {
            double d = i4 / i3;
            double d2 = i2;
            return ((double) i) * d > d2 ? (int) (d2 / d) : i;
        }
    }

    public static int d(int i) {
        return i & 65535;
    }

    public static int e(int i) {
        return (i & SupportMenu.CATEGORY_MASK) >> 16;
    }

    public static int f(int i, int i2) {
        return (i << 16) | (i2 & 65535);
    }
}
