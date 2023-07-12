package tb;

import android.graphics.Matrix;
import android.widget.ImageView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class pr0 {
    @NotNull
    public static final C9565a Companion = new C9565a(null);
    @NotNull
    public static final String MODE_TYPE_CROP = "crop";
    @NotNull
    public static final String MODE_TYPE_SCALE = "scale";
    @NotNull
    private final String a;
    @NotNull
    private final String b;

    /* compiled from: Taobao */
    /* renamed from: tb.pr0$a */
    /* loaded from: classes6.dex */
    public static final class C9565a {
        private C9565a() {
        }

        public /* synthetic */ C9565a(k50 k50Var) {
            this();
        }
    }

    public pr0(@NotNull String str, @NotNull String str2) {
        b41.i(str, "modeType");
        b41.i(str2, "mode");
        this.a = str;
        this.b = str2;
    }

    private final Matrix a(int i, int i2, int i3, int i4) {
        float f;
        Matrix matrix = new Matrix();
        if (i2 > i4) {
            float f2 = 2;
            f = (i4 / f2) - (i2 / f2);
        } else {
            float f3 = 2;
            f = (i2 / f3) - (i4 / f3);
        }
        matrix.postTranslate(0.0f, f);
        return matrix;
    }

    private final Matrix b(int i, int i2, int i3, int i4) {
        String str = this.b;
        switch (str.hashCode()) {
            case -1687059567:
                if (str.equals("top right")) {
                    return i(i, i2, i3, i4);
                }
                break;
            case -1383228885:
                if (str.equals("bottom")) {
                    return c(i, i2, i3, i4);
                }
                break;
            case -1024435214:
                if (str.equals("top left")) {
                    return h(i, i2, i3, i4);
                }
                break;
            case -667379492:
                if (str.equals("bottom left")) {
                    return d(i, i2, i3, i4);
                }
                break;
            case 115029:
                if (str.equals("top")) {
                    return g(i, i2, i3, i4);
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    return a(i, i2, i3, i4);
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    return f(i, i2, i3, i4);
                }
                break;
            case 791733223:
                if (str.equals("bottom right")) {
                    return e(i, i2, i3, i4);
                }
                break;
        }
        return null;
    }

    private final Matrix c(int i, int i2, int i3, int i4) {
        float f;
        Matrix matrix = new Matrix();
        if (i > i3) {
            float f2 = 2;
            f = (i / f2) - (i3 / f2);
        } else {
            float f3 = 2;
            f = (i3 / f3) - (i / f3);
        }
        matrix.postTranslate(f, i2 > i4 ? i4 - i2 : i2 - i4);
        return matrix;
    }

    private final Matrix d(int i, int i2, int i3, int i4) {
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, i2 > i4 ? i4 - i2 : i2 - i4);
        return matrix;
    }

    private final Matrix e(int i, int i2, int i3, int i4) {
        Matrix matrix = new Matrix();
        matrix.postTranslate(i > i3 ? i - i3 : i3 - i, i2 > i4 ? i4 - i2 : i2 - i4);
        return matrix;
    }

    private final Matrix f(int i, int i2, int i3, int i4) {
        float f;
        Matrix matrix = new Matrix();
        float f2 = i > i3 ? i - i3 : i3 - i;
        if (i2 > i4) {
            float f3 = 2;
            f = (i4 / f3) - (i2 / f3);
        } else {
            float f4 = 2;
            f = (i2 / f4) - (i4 / f4);
        }
        matrix.postTranslate(f2, f);
        return matrix;
    }

    private final Matrix g(int i, int i2, int i3, int i4) {
        float f;
        Matrix matrix = new Matrix();
        if (i > i3) {
            float f2 = 2;
            f = (i / f2) - (i3 / f2);
        } else {
            float f3 = 2;
            f = (i3 / f3) - (i / f3);
        }
        matrix.postTranslate(f, 0.0f);
        return matrix;
    }

    private final Matrix h(int i, int i2, int i3, int i4) {
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, 0.0f);
        return matrix;
    }

    private final Matrix i(int i, int i2, int i3, int i4) {
        Matrix matrix = new Matrix();
        matrix.postTranslate(i > i3 ? i - i3 : i3 - i, 0.0f);
        return matrix;
    }

    private final Matrix k(int i, int i2, int i3, int i4) {
        String str = this.b;
        switch (str.hashCode()) {
            case -1383228885:
                if (str.equals("bottom")) {
                    return l(i, i2, i3, i4);
                }
                break;
            case 115029:
                if (str.equals("top")) {
                    return o(i, i2, i3, i4);
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    return m(i, i2, i3, i4);
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    return n(i, i2, i3, i4);
                }
                break;
        }
        return null;
    }

    private final Matrix l(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        Matrix matrix = new Matrix();
        float f4 = i;
        float f5 = i4;
        float f6 = i2;
        float f7 = i3;
        if (f4 * f5 >= f6 * f7) {
            f3 = Math.min(f7 / f4, f5 / f6);
            f = 0.0f;
            f2 = f5 - (f6 * f3);
        } else {
            float f8 = f5 / f6;
            f = (f7 - (f4 * f8)) * 0.5f;
            f2 = f5 - (f6 * f8);
            f3 = f8;
        }
        matrix.setScale(f3, f3);
        matrix.postTranslate(f, f2);
        return matrix;
    }

    private final Matrix m(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        Matrix matrix = new Matrix();
        float f3 = i;
        float f4 = i4;
        float f5 = i2;
        float f6 = i3;
        if (f3 * f4 >= f5 * f6) {
            f = Math.min(f6 / f3, f4 / f5);
            f2 = (f4 - (f5 * f)) * 0.5f;
        } else {
            f = f4 / f5;
            f2 = 0.0f;
        }
        matrix.setScale(f, f);
        matrix.postTranslate(0.0f, f2);
        return matrix;
    }

    private final Matrix n(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        Matrix matrix = new Matrix();
        float f4 = i;
        float f5 = i4;
        float f6 = i2;
        float f7 = i3;
        if (f4 * f5 >= f6 * f7) {
            f = Math.min(f7 / f4, f5 / f6);
            f2 = f7 - (f4 * f);
            f3 = (f5 - (f6 * f)) * 0.5f;
        } else {
            f = f5 / f6;
            f2 = f7 - (f4 * f);
            f3 = 0.0f;
        }
        matrix.setScale(f, f);
        matrix.postTranslate(f2, f3);
        return matrix;
    }

    private final Matrix o(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        Matrix matrix = new Matrix();
        float f3 = i;
        float f4 = i4;
        float f5 = i2;
        float f6 = i3;
        if (f3 * f4 >= f5 * f6) {
            f2 = Math.min(f6 / f3, f4 / f5);
            f = 0.0f;
        } else {
            float f7 = f4 / f5;
            f = (f6 - (f3 * f7)) * 0.5f;
            f2 = f7;
        }
        matrix.setScale(f2, f2);
        matrix.postTranslate(f, 0.0f);
        return matrix;
    }

    @Nullable
    public final Matrix j(int i, int i2, int i3, int i4) {
        String str = this.a;
        if (b41.d(str, "scale")) {
            return k(i3, i4, i, i2);
        }
        if (b41.d(str, MODE_TYPE_CROP)) {
            return b(i3, i4, i, i2);
        }
        return null;
    }

    @NotNull
    public final ImageView.ScaleType p() {
        String str = this.b;
        switch (str.hashCode()) {
            case -1687059567:
                if (str.equals("top right")) {
                    return ImageView.ScaleType.MATRIX;
                }
                break;
            case -1383228885:
                if (str.equals("bottom")) {
                    return ImageView.ScaleType.MATRIX;
                }
                break;
            case -1364013995:
                if (str.equals("center")) {
                    return ImageView.ScaleType.CENTER;
                }
                break;
            case -1362001767:
                if (str.equals("aspectFit")) {
                    return ImageView.ScaleType.FIT_CENTER;
                }
                break;
            case -1024435214:
                if (str.equals("top left")) {
                    return ImageView.ScaleType.MATRIX;
                }
                break;
            case -797304696:
                if (str.equals("scaleToFill")) {
                    return ImageView.ScaleType.FIT_XY;
                }
                break;
            case -667379492:
                if (str.equals("bottom left")) {
                    return ImageView.ScaleType.MATRIX;
                }
                break;
            case 115029:
                if (str.equals("top")) {
                    return ImageView.ScaleType.MATRIX;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    return ImageView.ScaleType.MATRIX;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    return ImageView.ScaleType.MATRIX;
                }
                break;
            case 727618043:
                if (str.equals("aspectFill")) {
                    return ImageView.ScaleType.CENTER_CROP;
                }
                break;
            case 791733223:
                if (str.equals("bottom right")) {
                    return ImageView.ScaleType.MATRIX;
                }
                break;
        }
        return ImageView.ScaleType.FIT_XY;
    }
}
