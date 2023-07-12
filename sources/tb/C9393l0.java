package tb;

import android.util.Log;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.AppMonitorStatTable;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.taobao.alivfsadapter.AVFSSDKAppMonitor;

/* compiled from: Taobao */
/* renamed from: tb.l0 */
/* loaded from: classes8.dex */
public class C9393l0 implements AVFSSDKAppMonitor {
    private final AppMonitorStatTable a;

    public C9393l0() {
        AppMonitorStatTable appMonitorStatTable = new AppMonitorStatTable("AliVfsSDK", "Cache");
        this.a = appMonitorStatTable;
        MeasureSet create = MeasureSet.create();
        create.addMeasure("DiskCost");
        DimensionSet create2 = DimensionSet.create();
        create2.addDimension("Cache");
        create2.addDimension("Module");
        create2.addDimension("Operation");
        create2.addDimension("HitMemory");
        create2.addDimension("MemoryCache");
        appMonitorStatTable.registerRowAndColumn(create2, create, false);
    }

    public static String a(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 114126:
                if (str.equals(kh1.CACHE_SQL)) {
                    c = 0;
                    break;
                }
                break;
            case 3143036:
                if (str.equals("file")) {
                    c = 1;
                    break;
                }
                break;
            case 3355087:
                if (str.equals(kh1.CACHE_MMAP)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "SQLiteCache";
            case 1:
                return "FileCache";
            case 2:
                return "MmapCache";
            default:
                throw new IllegalArgumentException("Unknown URL: " + str);
        }
    }

    public static String b(String str, String str2) {
        return a(str) + c(str2);
    }

    public static String c(String str) {
        str.hashCode();
        if (str.equals(kh1.OPERATION_READ)) {
            return "Read";
        }
        if (str.equals(kh1.OPERATION_WRITE)) {
            return "Write";
        }
        throw new IllegalArgumentException("Unknown URL: " + str);
    }

    @Override // com.taobao.alivfsadapter.AVFSSDKAppMonitor
    public void hitMemoryCacheForModule(String str, boolean z) {
        if (z) {
            AppMonitor.Alarm.commitSuccess("AliVfsSDK", "MemoryCacheHitRate", str);
        } else {
            AppMonitor.Alarm.commitFail("AliVfsSDK", "MemoryCacheHitRate", str, null, null);
        }
    }

    @Override // com.taobao.alivfsadapter.AVFSSDKAppMonitor
    public void writeEvent(kh1 kh1Var) {
        try {
            String b = b(kh1Var.b, kh1Var.e);
            int i = kh1Var.d;
            if (i == 0) {
                AppMonitor.Alarm.commitSuccess("AliVfsSDK", b, kh1Var.a);
                DimensionValueSet create = DimensionValueSet.create();
                create.setValue("Cache", kh1Var.b);
                create.setValue("Module", kh1Var.a);
                create.setValue("Operation", kh1Var.e);
                create.setValue("HitMemory", String.valueOf(kh1Var.g));
                create.setValue("MemoryCache", String.valueOf(kh1Var.f));
                MeasureValueSet create2 = MeasureValueSet.create();
                create2.setValue("DiskCost", kh1Var.h);
                this.a.update(create, create2);
                AppMonitor.Stat.commit("AliVfsSDK", "Cache", create, create2);
            } else {
                AppMonitor.Alarm.commitFail("AliVfsSDK", b, kh1Var.a, String.valueOf(i), kh1Var.c);
            }
        } catch (Exception e) {
            Log.e("AVFSSDKAppMonitorImpl", e.getMessage(), e);
        }
    }
}
