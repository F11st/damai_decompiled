package tb;

import android.content.Context;
import com.amap.api.location.DPoint;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class y73 {
    static double a = 3.141592653589793d;
    private static final List<DPoint> b = new ArrayList(Arrays.asList(new DPoint(23.379947d, 119.757001d), new DPoint(24.983296d, 120.474496d), new DPoint(25.518722d, 121.359866d), new DPoint(25.41329d, 122.443582d), new DPoint(24.862708d, 122.288354d), new DPoint(24.461292d, 122.188319d), new DPoint(21.584761d, 120.968923d), new DPoint(21.830837d, 120.654445d)));

    private static double a(double d) {
        return Math.sin(d * 3000.0d * (a / 180.0d)) * 2.0E-5d;
    }

    private static double b(double d, double d2) {
        return (Math.cos(d2 / 100000.0d) * (d / 18000.0d)) + (Math.sin(d / 100000.0d) * (d2 / 9000.0d));
    }

    private static DPoint c(double d, double d2, double d3, double d4) {
        DPoint dPoint = new DPoint();
        double d5 = d - d3;
        double d6 = d2 - d4;
        DPoint m = m(d5, d6);
        dPoint.setLongitude(j((d + d5) - m.getLongitude()));
        dPoint.setLatitude(j((d2 + d6) - m.getLatitude()));
        return dPoint;
    }

    public static DPoint d(Context context, DPoint dPoint) {
        if (context == null) {
            return null;
        }
        return i(dPoint);
    }

    public static DPoint e(DPoint dPoint) {
        if (dPoint != null) {
            try {
                if (com.loc.j1.i(dPoint.getLatitude(), dPoint.getLongitude())) {
                    return l(dPoint);
                }
                if (n(dPoint.getLatitude(), dPoint.getLongitude())) {
                    DPoint l = l(dPoint);
                    return o(l.getLatitude(), l.getLongitude());
                }
                return dPoint;
            } catch (Throwable th) {
                com.loc.j1.h(th, "OffsetUtil", "b2G");
            }
        }
        return dPoint;
    }

    private static double f(double d) {
        return Math.cos(d * 3000.0d * (a / 180.0d)) * 3.0E-6d;
    }

    private static double g(double d, double d2) {
        return (Math.sin(d2 / 100000.0d) * (d / 18000.0d)) + (Math.cos(d / 100000.0d) * (d2 / 9000.0d));
    }

    public static DPoint h(Context context, DPoint dPoint) {
        try {
            return !com.loc.j1.i(dPoint.getLatitude(), dPoint.getLongitude()) ? dPoint : d(context, k(dPoint.getLongitude(), dPoint.getLatitude()));
        } catch (Throwable th) {
            com.loc.j1.h(th, "OffsetUtil", "marbar2G");
            return dPoint;
        }
    }

    private static DPoint i(DPoint dPoint) {
        try {
            if (com.loc.j1.i(dPoint.getLatitude(), dPoint.getLongitude())) {
                double[] b2 = b83.b(dPoint.getLongitude(), dPoint.getLatitude());
                return new DPoint(b2[1], b2[0]);
            }
            return dPoint;
        } catch (Throwable th) {
            com.loc.j1.h(th, "OffsetUtil", "cover part2");
            return dPoint;
        }
    }

    private static double j(double d) {
        return new BigDecimal(d).setScale(8, 4).doubleValue();
    }

    private static DPoint k(double d, double d2) {
        double d3;
        double d4;
        double d5 = ((long) (d * 100000.0d)) % 36000000;
        double d6 = ((long) (d2 * 100000.0d)) % 36000000;
        return new DPoint(((int) (((-g(d4, d3)) + d6) + (d6 <= 0.0d ? -1 : 1))) / 100000.0d, ((int) (((-b((int) ((-b(d5, d6)) + d5), (int) ((-g(d5, d6)) + d6))) + d5) + (d5 > 0.0d ? 1 : -1))) / 100000.0d);
    }

    private static DPoint l(DPoint dPoint) {
        DPoint dPoint2 = null;
        double d = 0.006401062d;
        double d2 = 0.0060424805d;
        for (int i = 0; i < 2; i++) {
            dPoint2 = c(dPoint.getLongitude(), dPoint.getLatitude(), d, d2);
            d = dPoint.getLongitude() - dPoint2.getLongitude();
            d2 = dPoint.getLatitude() - dPoint2.getLatitude();
        }
        return dPoint2;
    }

    private static DPoint m(double d, double d2) {
        DPoint dPoint = new DPoint();
        double d3 = (d * d) + (d2 * d2);
        dPoint.setLongitude(j((Math.cos(f(d) + Math.atan2(d2, d)) * (a(d2) + Math.sqrt(d3))) + 0.0065d));
        dPoint.setLatitude(j((Math.sin(f(d) + Math.atan2(d2, d)) * (a(d2) + Math.sqrt(d3))) + 0.006d));
        return dPoint;
    }

    private static boolean n(double d, double d2) {
        return com.loc.j1.l(new DPoint(d, d2), b);
    }

    private static DPoint o(double d, double d2) {
        DPoint p = p(d, d2);
        return new DPoint((d * 2.0d) - p.getLatitude(), (d2 * 2.0d) - p.getLongitude());
    }

    private static DPoint p(double d, double d2) {
        double d3 = d2 - 105.0d;
        double d4 = d - 35.0d;
        double q = q(d3, d4);
        double r = r(d3, d4);
        double d5 = (d / 180.0d) * a;
        double sin = Math.sin(d5);
        double d6 = 1.0d - ((0.006693421622965943d * sin) * sin);
        double sqrt = Math.sqrt(d6);
        return new DPoint(d + ((q * 180.0d) / ((6335552.717000426d / (d6 * sqrt)) * a)), d2 + ((r * 180.0d) / (((6378245.0d / sqrt) * Math.cos(d5)) * a)));
    }

    private static double q(double d, double d2) {
        double d3 = d * 2.0d;
        return (-100.0d) + d3 + (d2 * 3.0d) + (d2 * 0.2d * d2) + (0.1d * d * d2) + (Math.sqrt(Math.abs(d)) * 0.2d) + ((((Math.sin((d * 6.0d) * a) * 20.0d) + (Math.sin(d3 * a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(a * d2) * 20.0d) + (Math.sin((d2 / 3.0d) * a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d2 / 12.0d) * a) * 160.0d) + (Math.sin((d2 * a) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    private static double r(double d, double d2) {
        double d3 = d * 0.1d;
        return d + 300.0d + (d2 * 2.0d) + (d3 * d) + (d3 * d2) + (Math.sqrt(Math.abs(d)) * 0.1d) + ((((Math.sin((6.0d * d) * a) * 20.0d) + (Math.sin((d * 2.0d) * a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(a * d) * 20.0d) + (Math.sin((d / 3.0d) * a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d / 12.0d) * a) * 150.0d) + (Math.sin((d / 30.0d) * a) * 300.0d)) * 2.0d) / 3.0d);
    }
}
