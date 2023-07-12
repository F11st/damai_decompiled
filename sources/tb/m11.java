package tb;

import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class m11 {
    @Nullable
    public static ColorFilter a(int i) {
        if (i == 1) {
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            return new ColorMatrixColorFilter(colorMatrix);
        }
        return null;
    }

    public static void b(@NonNull ImageView imageView, int i) {
        c(imageView, i, null);
    }

    public static void c(@NonNull ImageView imageView, int i, @Nullable ColorFilter colorFilter) {
        ColorFilter a = a(i);
        if (a != null) {
            imageView.setColorFilter(a);
        } else if (colorFilter != null) {
            imageView.setColorFilter(colorFilter);
        } else {
            imageView.clearColorFilter();
        }
    }
}
