package tb;

import java.math.BigDecimal;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class bc {
    public static double a(double d, double d2, int i) {
        return new BigDecimal(Double.toString(d)).divide(new BigDecimal(Double.toString(d2)), i, 1).doubleValue();
    }

    public static float b(float f, float f2, int i) {
        return new BigDecimal(Float.toString(f)).divide(new BigDecimal(Float.toString(f2)), i, 1).floatValue();
    }
}
