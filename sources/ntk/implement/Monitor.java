package ntk.implement;

import androidx.annotation.Keep;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
class Monitor {
    Monitor() {
    }

    public static void appMonitorRegister(String str, String str2, List<String> list, List<String> list2) {
        AppMonitor.register(str, str2, MeasureSet.create(list), DimensionSet.create(list2));
    }

    public static void appMonitorStatCommit(String str, String str2, Map<String, Double> map, Map<String, String> map2) {
        DimensionValueSet fromStringMap = DimensionValueSet.fromStringMap(map2);
        MeasureValueSet create = MeasureValueSet.create();
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            create.setValue(entry.getKey(), entry.getValue().doubleValue());
        }
        AppMonitor.Stat.commit(str, str2, fromStringMap, create);
    }
}
