package tb;

import android.annotation.SuppressLint;
import com.alibaba.emas.datalab.metrics.listener.DatalabMetricListener;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tb.d30;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
abstract class d30<T extends d30> {
    protected static final Double f = Double.valueOf(-1.0d);
    protected static String g = "yyyy-MM-dd HH:mm:ss";
    @SuppressLint({"SimpleDateFormat"})
    protected SimpleDateFormat a = new SimpleDateFormat(g);
    protected String b;
    protected String c;
    protected Map<String, String> d;
    protected Map<String, Double> e;

    /* JADX INFO: Access modifiers changed from: protected */
    public d30(String str, String str2) {
        if (str != null && str2 != null) {
            this.c = str2;
            this.b = c(str);
            return;
        }
        throw new IllegalArgumentException();
    }

    private static String c(String str) {
        return "DataLab-" + str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Set<String> set, Set<String> set2) {
        MeasureSet addMeasure;
        if (set2 != null && !set2.isEmpty()) {
            if (!set2.isEmpty()) {
                addMeasure = MeasureSet.create(set2);
            } else {
                addMeasure = MeasureSet.create().addMeasure("_v");
            }
            if (set != null && !set.isEmpty()) {
                set.add("uploadTime");
                AppMonitor.register(this.b, this.c, addMeasure, DimensionSet.create(set), true);
                return;
            }
            AppMonitor.register(this.b, this.c, addMeasure, true);
            return;
        }
        throw new IllegalArgumentException("data lab doRegister fail. values is empty");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) {
        Map<String, String> map = this.d;
        if (map != null && !map.isEmpty()) {
            if (dimensionValueSet == null) {
                dimensionValueSet = DimensionValueSet.create();
            }
            for (Map.Entry<String, String> entry : this.d.entrySet()) {
                dimensionValueSet.setValue(entry.getKey(), entry.getValue());
            }
        }
        if (measureValueSet == null) {
            measureValueSet = MeasureValueSet.create();
        }
        Map<String, Double> map2 = this.e;
        if (map2 != null && !map2.isEmpty()) {
            for (Map.Entry<String, Double> entry2 : this.e.entrySet()) {
                measureValueSet.setValue(entry2.getKey(), entry2.getValue().doubleValue());
            }
        }
        if (measureValueSet.isEmpty()) {
            measureValueSet.setValue("_v", 0.0d);
        }
        if (dimensionValueSet != null) {
            String str = null;
            try {
                str = this.a.format(new Date());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (str != null && str.length() > 0) {
                dimensionValueSet.setValue("uploadTime", str);
            } else {
                dimensionValueSet.setValue("uploadTime", "-");
            }
        }
        AppMonitor.Stat.commit(this.b, this.c, dimensionValueSet, measureValueSet);
        try {
            Map<String, MeasureValue> map3 = measureValueSet.getMap();
            if (map3 != null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                HashSet<String> hashSet = new HashSet();
                hashSet.addAll(map3.keySet());
                for (String str2 : hashSet) {
                    MeasureValue measureValue = map3.get(str2);
                    if (measureValue != null) {
                        concurrentHashMap.put(str2, Double.valueOf(measureValue.getValue()));
                    }
                }
                List<DatalabMetricListener> b = o30.a().b();
                if (b == null || b.size() <= 0) {
                    return;
                }
                for (DatalabMetricListener datalabMetricListener : b) {
                    try {
                        datalabMetricListener.dataCommit(this.b, this.c, dimensionValueSet.getMap(), concurrentHashMap);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public T d(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.d == null) {
                this.d = new HashMap();
            }
            this.d.put(str, str2);
        }
        return this;
    }

    public T e(String str, Double d) {
        if (str != null && d != null) {
            if (this.e == null) {
                this.e = new HashMap();
            }
            this.e.put(str, d);
        }
        return this;
    }
}
