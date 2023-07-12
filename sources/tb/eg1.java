package tb;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class eg1 {
    private static PointF a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static double b(double d, double d2, double d3) {
        return Math.max(d2, Math.min(d3, d));
    }

    public static float c(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static int d(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static boolean e(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    private static int f(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(float f, float f2) {
        return h((int) f, (int) f2);
    }

    private static int h(int i, int i2) {
        return i - (i2 * f(i, i2));
    }

    public static void i(jb2 jb2Var, Path path) {
        path.reset();
        PointF b = jb2Var.b();
        path.moveTo(b.x, b.y);
        a.set(b.x, b.y);
        for (int i = 0; i < jb2Var.a().size(); i++) {
            iq iqVar = jb2Var.a().get(i);
            PointF a2 = iqVar.a();
            PointF b2 = iqVar.b();
            PointF c = iqVar.c();
            if (a2.equals(a) && b2.equals(c)) {
                path.lineTo(c.x, c.y);
            } else {
                path.cubicTo(a2.x, a2.y, b2.x, b2.y, c.x, c.y);
            }
            a.set(c.x, c.y);
        }
        if (jb2Var.d()) {
            path.close();
        }
    }

    public static double j(double d, double d2, @FloatRange(from = 0.0d, to = 1.0d) double d3) {
        return d + (d3 * (d2 - d));
    }

    public static float k(float f, float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int l(int i, int i2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static void m(s71 s71Var, int i, List<s71> list, s71 s71Var2, KeyPathElementContent keyPathElementContent) {
        if (s71Var.c(keyPathElementContent.getName(), i)) {
            list.add(s71Var2.a(keyPathElementContent.getName()).i(keyPathElementContent));
        }
    }
}
