package com.youku.vpm.proxy;

import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.youku.vpm.utils.TLogUtil;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class UtProxy {
    private static boolean sIsUseAppMonitor = true;
    private boolean mIsExternal;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static class Holder {
        private static final UtProxy instance = new UtProxy();

        private Holder() {
        }
    }

    private UtProxy() {
        this.mIsExternal = false;
    }

    public static UtProxy getInstance() {
        return Holder.instance;
    }

    public static boolean isIsUseAppMonitor() {
        return sIsUseAppMonitor;
    }

    public void commit(String str, String str2, Map<String, String> map, Map<String, Double> map2) {
        if (sIsUseAppMonitor) {
            DimensionValueSet create = DimensionValueSet.create();
            if (map != null) {
                create.setMap(map);
            }
            MeasureValueSet create2 = MeasureValueSet.create();
            if (map2 != null && map2.size() > 0) {
                for (String str3 : map2.keySet()) {
                    Double d = map2.get(str3);
                    if (d != null && d.doubleValue() >= -1.0d) {
                        create2.setValue(str3, d.doubleValue());
                    }
                }
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value != null && value.length() > 150) {
                    TLogUtil.vpmLog("vpm error size>150" + str2 + " key=" + key);
                }
            }
            AppMonitor.Stat.commit(str, str2, create, create2);
        }
    }

    public void register(String str, String str2, Set<String> set, Set<String> set2) {
        if (sIsUseAppMonitor) {
            if (!this.mIsExternal) {
                AppMonitor.register(str, str2, MeasureSet.create(set), DimensionSet.create(set2));
                return;
            }
            MeasureSet create = MeasureSet.create();
            if (set != null && set.size() > 0) {
                for (String str3 : set) {
                    Measure measure = new Measure(str3);
                    measure.setRange(Double.valueOf(-1.0d), Double.valueOf(Double.MAX_VALUE));
                    create.addMeasure(measure);
                }
            }
            AppMonitor.register(str, str2, create, DimensionSet.create(set2));
        }
    }

    public void setExternal(boolean z) {
        this.mIsExternal = z;
    }
}
