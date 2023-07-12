package tb;

import android.graphics.Bitmap;
import android.os.Build;
import com.taobao.pexode.animate.AnimatedImage;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class or1 {
    public Bitmap a;
    public AnimatedImage b;

    public static or1 a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        or1 or1Var = new or1();
        or1Var.a = bitmap;
        if (Build.VERSION.SDK_INT > 23) {
            bitmap.prepareToDraw();
        }
        return or1Var;
    }

    public static or1 b(AnimatedImage animatedImage) {
        if (animatedImage == null) {
            return null;
        }
        or1 or1Var = new or1();
        or1Var.b = animatedImage;
        return or1Var;
    }

    public String toString() {
        return "PexodeResult(bitmap=" + this.a + ", animated=" + this.b + jn1.BRACKET_END_STR;
    }
}
