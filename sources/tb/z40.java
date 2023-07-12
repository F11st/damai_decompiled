package tb;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.taobao.pexode.animate.AnimatedImage;
import com.taobao.rxm.common.Releasable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class z40 implements Releasable {
    public static final int ANIMATE_IMAGE = 2;
    public static final int STATIC_BITMAP = 1;
    private oe0 a;
    private final int b;
    private final Bitmap c;
    private final Rect d;
    private final AnimatedImage e;

    public z40(oe0 oe0Var, Bitmap bitmap) {
        this(oe0Var, bitmap, null, null);
    }

    public AnimatedImage a() {
        return this.e;
    }

    public Bitmap b() {
        return this.c;
    }

    public Rect c() {
        return this.d;
    }

    public oe0 d() {
        return this.a;
    }

    public boolean e() {
        int i = this.b;
        if (i != 1 || this.c == null) {
            return i == 2 && this.e != null;
        }
        return true;
    }

    public boolean f() {
        return this.b == 1;
    }

    public boolean g() {
        oe0 oe0Var = this.a;
        return oe0Var == null || oe0Var.g;
    }

    @Override // com.taobao.rxm.common.Releasable
    public void release() {
        oe0 oe0Var = this.a;
        if (oe0Var != null) {
            oe0Var.release();
        }
        AnimatedImage animatedImage = this.e;
        if (animatedImage != null) {
            animatedImage.dispose();
        }
    }

    public String toString() {
        return "DecodedImage(type=" + this.b + ", bitmap=" + this.c + ", animated=" + this.e + jn1.BRACKET_END_STR;
    }

    public z40(oe0 oe0Var, Bitmap bitmap, AnimatedImage animatedImage, Rect rect) {
        if (bitmap != null) {
            this.b = 1;
        } else {
            this.b = 2;
        }
        this.a = oe0Var;
        this.c = bitmap;
        this.e = animatedImage;
        this.d = rect;
    }
}
