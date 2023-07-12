package mtopsdk.mtop.stat;

import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.Map;
import java.util.Set;
import mtopsdk.common.util.TBSdkLog;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UploadStatAppMonitorImpl implements IUploadStats {
    private static final String TAG = "mtopsdk.UploadStatImpl";
    private static boolean mAppMonitorValid;

    public UploadStatAppMonitorImpl() {
        try {
            mAppMonitorValid = true;
        } catch (Throwable unused) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                TBSdkLog.e(TAG, "didn't find app-monitor-sdk or ut-analytics sdk.");
            }
        }
    }

    @Override // mtopsdk.mtop.stat.IUploadStats
    public void onCommit(String str, String str2, Map<String, String> map, Map<String, Double> map2) {
        DimensionValueSet create;
        if (mAppMonitorValid) {
            MeasureValueSet measureValueSet = null;
            if (map != null) {
                try {
                    create = DimensionValueSet.create();
                    create.setMap(map);
                } catch (Throwable th) {
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                        TBSdkLog.e(TAG, "call AppMonitor.onCommit error.", th);
                        return;
                    }
                    return;
                }
            } else {
                create = null;
            }
            if (map2 != null) {
                measureValueSet = MeasureValueSet.create();
                for (Map.Entry<String, Double> entry : map2.entrySet()) {
                    measureValueSet.setValue(entry.getKey(), entry.getValue().doubleValue());
                }
            }
            AppMonitor.Stat.commit(str, str2, create, measureValueSet);
        }
    }

    @Override // mtopsdk.mtop.stat.IUploadStats
    public void onRegister(String str, String str2, Set<String> set, Set<String> set2, boolean z) {
        DimensionSet create;
        if (mAppMonitorValid) {
            if (set != null) {
                try {
                    create = DimensionSet.create(set);
                } catch (Throwable th) {
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                        TBSdkLog.e(TAG, "call AppMonitor.register error.", th);
                        return;
                    }
                    return;
                }
            } else {
                create = null;
            }
            AppMonitor.register(str, str2, set2 != null ? MeasureSet.create(set2) : null, create, z);
        }
    }
}
