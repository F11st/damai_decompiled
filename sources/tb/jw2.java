package tb;

import android.content.Context;
import android.content.res.Resources;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class jw2 {
    public static final jw2 INSTANCE = new jw2();

    private jw2() {
    }

    public final int a(@NotNull Context context, float f) {
        b41.j(context, WPKFactory.INIT_KEY_CONTEXT);
        Resources resources = context.getResources();
        b41.e(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    public final int b(int i, int i2, float f) {
        if (f <= 0) {
            return i;
        }
        if (f >= 1) {
            return i2;
        }
        int i3 = (i >> 24) & 255;
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = i & 255;
        return (i6 + ((int) (f * ((i2 & 255) - i6)))) | ((i3 + ((int) ((((i2 >> 24) & 255) - i3) * f))) << 24) | ((i4 + ((int) ((((i2 >> 16) & 255) - i4) * f))) << 16) | ((i5 + ((int) ((((i2 >> 8) & 255) - i5) * f))) << 8);
    }

    public final int c(@NotNull Context context) {
        b41.j(context, WPKFactory.INIT_KEY_CONTEXT);
        Resources resources = context.getResources();
        b41.e(resources, "context.resources");
        return DisplayMetrics.getwidthPixels(resources.getDisplayMetrics());
    }

    public final int d(@NotNull Context context, float f) {
        b41.j(context, WPKFactory.INIT_KEY_CONTEXT);
        Resources resources = context.getResources();
        b41.e(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
