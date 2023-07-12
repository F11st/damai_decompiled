package tb;

import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import java.util.Random;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class vj2 {
    public static final String CONST_0 = "0";
    public static final String CONST_1 = "1";
    public static final int COVERAGE_RANGE_MAX = 100;
    public static final int COVERAGE_RANGE_MIN = 0;
    private static Random b = new Random();
    protected boolean a;

    public static boolean c(int i) {
        return b.nextInt(100) + 1 <= i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(int i) {
        return i <= 0 || (i < 100 && !c(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(MeasureSet measureSet, String str, Double d, Double d2, Double d3) {
        Measure measure = new Measure(str, d);
        if (d2 != null && d3 != null) {
            measure.setRange(d2, d3);
        }
        measureSet.addMeasure(measure);
    }
}
