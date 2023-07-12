package com.youku.phone.xcdnengine.statistics;

import androidx.annotation.NonNull;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public abstract class Statistic {
    public static final String MODULE_NAME = "YKDownloader";
    private HashMap<String, Double> mMeasures = new HashMap<>();
    private HashMap<String, String> mDimemsions = new HashMap<>();

    public void add(@NonNull String str, @NonNull String str2) {
        this.mDimemsions.put(str, str2);
    }

    public abstract String getMonitorPoint();

    public void register() {
        MeasureSet create = MeasureSet.create();
        create.addMeasure(Keys.BIZ_ID);
        DimensionSet create2 = DimensionSet.create();
        for (String str : this.mDimemsions.keySet()) {
            create2.addDimension(str, this.mDimemsions.get(str));
        }
        AppMonitor.register(MODULE_NAME, getMonitorPoint(), create, create2);
    }

    public void report() {
        MeasureValueSet create = MeasureValueSet.create();
        String str = Keys.BIZ_ID;
        MeasureValueSet value = create.setValue(str, this.mMeasures.get(str).doubleValue());
        DimensionValueSet create2 = DimensionValueSet.create();
        create2.setMap(this.mDimemsions);
        AppMonitor.Stat.commit(MODULE_NAME, getMonitorPoint(), create2, value);
    }

    public void add(@NonNull String str, double d) {
        this.mMeasures.put(str, Double.valueOf(d));
    }
}
