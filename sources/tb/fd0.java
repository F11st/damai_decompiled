package tb;

import com.alibaba.analytics.utils.Logger;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class fd0 extends qf0 {
    private static final Long l = 300000L;
    private nf1 g;
    private MeasureValueSet h;
    private DimensionValueSet i;
    private Map<String, MeasureValue> j;
    private Long k;

    public void c(DimensionValueSet dimensionValueSet) {
        DimensionValueSet dimensionValueSet2 = this.i;
        if (dimensionValueSet2 == null) {
            this.i = dimensionValueSet;
        } else {
            dimensionValueSet2.addValues(dimensionValueSet);
        }
    }

    @Override // tb.qf0, com.alibaba.appmonitor.pool.Reusable
    public void clean() {
        super.clean();
        this.g = null;
        this.k = null;
        for (MeasureValue measureValue : this.j.values()) {
            com.alibaba.appmonitor.pool.a.a().offer(measureValue);
        }
        this.j.clear();
        if (this.h != null) {
            com.alibaba.appmonitor.pool.a.a().offer(this.h);
            this.h = null;
        }
        if (this.i != null) {
            com.alibaba.appmonitor.pool.a.a().offer(this.i);
            this.i = null;
        }
    }

    public boolean d(String str) {
        MeasureValue measureValue = this.j.get(str);
        if (measureValue != null) {
            double currentTimeMillis = System.currentTimeMillis();
            Logger.f("DurationEvent", "statEvent consumeTime. module:", this.a, " monitorPoint:", this.b, " measureName:", str, " time:", Double.valueOf(currentTimeMillis - measureValue.getValue()));
            measureValue.setValue(currentTimeMillis - measureValue.getValue());
            measureValue.setFinish(true);
            this.h.setValue(str, measureValue);
            if (this.g.b().valid(this.h)) {
                return true;
            }
        }
        super.a(null);
        return false;
    }

    public DimensionValueSet e() {
        return this.i;
    }

    public MeasureValueSet f() {
        return this.h;
    }

    @Override // tb.qf0, com.alibaba.appmonitor.pool.Reusable
    public void fill(Object... objArr) {
        super.fill(objArr);
        if (this.j == null) {
            this.j = new HashMap();
        }
        nf1 b = of1.c().b(this.a, this.b);
        this.g = b;
        if (b.a() != null) {
            this.i = (DimensionValueSet) com.alibaba.appmonitor.pool.a.a().poll(DimensionValueSet.class, new Object[0]);
            this.g.a().setConstantValue(this.i);
        }
        this.h = (MeasureValueSet) com.alibaba.appmonitor.pool.a.a().poll(MeasureValueSet.class, new Object[0]);
    }

    public boolean g() {
        long currentTimeMillis = System.currentTimeMillis();
        List<Measure> measures = this.g.b().getMeasures();
        if (measures != null) {
            int size = measures.size();
            for (int i = 0; i < size; i++) {
                Measure measure = measures.get(i);
                if (measure != null) {
                    double doubleValue = measure.getMax() != null ? measure.getMax().doubleValue() : l.longValue();
                    MeasureValue measureValue = this.j.get(measure.getName());
                    if (measureValue != null && !measureValue.isFinish() && currentTimeMillis - measureValue.getValue() > doubleValue) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void h(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.j.isEmpty()) {
            this.k = Long.valueOf(currentTimeMillis);
        }
        this.j.put(str, (MeasureValue) com.alibaba.appmonitor.pool.a.a().poll(MeasureValue.class, Double.valueOf(currentTimeMillis), Double.valueOf(currentTimeMillis - this.k.longValue())));
        super.a(null);
    }
}
