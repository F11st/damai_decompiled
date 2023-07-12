package com.youku.live.livesdk.monitor.performance;

import android.util.Log;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.usertrack.IUserTracker;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AbsPerformance {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BOOLEAN_FALSE = "0";
    public static final String BOOLEAN_TRUE = "1";
    public static final double DOUBLE_NIL = Double.NaN;
    public static final long LONG_NIL = Long.MAX_VALUE;
    public static final String TAG = "AbsPerformance";
    private final String argOne;
    private Map<String, String> dimensionValueMap;
    private Map<String, Double> measureValueMap;
    private final String moduleName;
    private final String monitorPoint;
    private final String pageName;
    private volatile double mesNavigateStart = Double.NaN;
    private volatile boolean mesNavigateStartConfig = false;
    private boolean reported = false;

    public AbsPerformance(String str, String str2, String str3, String str4, List<String> list, List<String> list2) {
        this.moduleName = str;
        this.monitorPoint = str2;
        this.pageName = str3;
        this.argOne = str4;
        initWith(str, str2, list, list2);
    }

    private static void initWith(String str, String str2, String[] strArr, String[] strArr2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2070730531")) {
            ipChange.ipc$dispatch("-2070730531", new Object[]{str, str2, strArr, strArr2});
            return;
        }
        DimensionSet create = DimensionSet.create();
        if (strArr != null && strArr.length > 0) {
            for (String str3 : strArr) {
                create.addDimension(str3);
            }
        }
        MeasureSet create2 = MeasureSet.create();
        if (strArr2 != null && strArr2.length > 0) {
            for (String str4 : strArr2) {
                create2.addMeasure(str4);
            }
        }
        AppMonitor.register(str, str2, create2, create);
    }

    public static boolean isDoubleNil(double d) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-913083251") ? ((Boolean) ipChange.ipc$dispatch("-913083251", new Object[]{Double.valueOf(d)})).booleanValue() : Double.NaN == d;
    }

    public static boolean isLongNil(long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-18111992") ? ((Boolean) ipChange.ipc$dispatch("-18111992", new Object[]{Long.valueOf(j)})).booleanValue() : LONG_NIL == j;
    }

    public static boolean notDoubleNil(double d) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-735009936") ? ((Boolean) ipChange.ipc$dispatch("-735009936", new Object[]{Double.valueOf(d)})).booleanValue() : Double.NaN != d;
    }

    public static boolean notLongNil(long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-138596949") ? ((Boolean) ipChange.ipc$dispatch("-138596949", new Object[]{Long.valueOf(j)})).booleanValue() : LONG_NIL != j;
    }

    public AbsPerformance commit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2123286615")) {
            return (AbsPerformance) ipChange.ipc$dispatch("2123286615", new Object[]{this});
        }
        if (this.reported) {
            return this;
        }
        this.reported = true;
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append("moduleName=");
        sb.append(this.moduleName);
        sb.append(StringUtils.LF);
        sb.append("monitorPoint=");
        sb.append(this.monitorPoint);
        sb.append(StringUtils.LF);
        DimensionValueSet create = DimensionValueSet.create();
        for (Map.Entry<String, String> entry : getDimensionValueMap().entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append(StringUtils.LF);
            create.setValue(entry.getKey(), entry.getValue());
            hashMap.put(entry.getKey(), entry.getValue());
        }
        getMeasureValueMap().get(YoukuLivePerformanceConstants.MES_NAVIGATE_START);
        double measureValue = getMeasureValue(YoukuLivePerformanceConstants.MES_NAVIGATE_START);
        if (!isDoubleNil(measureValue)) {
            MeasureValueSet create2 = MeasureValueSet.create();
            for (Map.Entry<String, Double> entry2 : getMeasureValueMap().entrySet()) {
                double doubleValue = entry2.getValue().doubleValue() - measureValue;
                sb.append(entry2.getKey());
                sb.append("=");
                sb.append(doubleValue);
                sb.append(StringUtils.LF);
                create2.setValue(entry2.getKey(), doubleValue);
                hashMap.put(entry2.getKey(), String.valueOf(doubleValue));
            }
            AppMonitor.Stat.commit(this.moduleName, this.monitorPoint, create, create2);
            ((IUserTracker) Dsl.getService(IUserTracker.class)).trackCustom(this.pageName, this.argOne, hashMap);
        }
        Log.e("YoukuLivePerformance", sb.toString());
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, String> getDimensionValueMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2135202681")) {
            return (Map) ipChange.ipc$dispatch("2135202681", new Object[]{this});
        }
        if (this.dimensionValueMap == null) {
            synchronized (this) {
                if (this.dimensionValueMap == null) {
                    this.dimensionValueMap = new ConcurrentHashMap();
                }
            }
        }
        return this.dimensionValueMap;
    }

    public double getMeasure(String str) {
        Double d;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "96360303")) {
            return ((Double) ipChange.ipc$dispatch("96360303", new Object[]{this, str})).doubleValue();
        }
        if (str == null || !getMeasureValueMap().containsKey(str) || (d = getMeasureValueMap().get(str)) == null) {
            return Double.NaN;
        }
        return d.doubleValue();
    }

    public double getMeasureValue(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "16988410")) {
            return ((Double) ipChange.ipc$dispatch("16988410", new Object[]{this, str})).doubleValue();
        }
        if (str == null) {
            str = jn1.MUL;
        }
        if (getMeasureValueMap().containsKey(str)) {
            return getMeasureValueMap().get(str).doubleValue();
        }
        return Double.NaN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, Double> getMeasureValueMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1865723263")) {
            return (Map) ipChange.ipc$dispatch("-1865723263", new Object[]{this});
        }
        if (this.measureValueMap == null) {
            synchronized (this) {
                if (this.measureValueMap == null) {
                    this.measureValueMap = new ConcurrentHashMap();
                }
            }
        }
        return this.measureValueMap;
    }

    public boolean hasDimension(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1688260801")) {
            return ((Boolean) ipChange.ipc$dispatch("1688260801", new Object[]{this, str})).booleanValue();
        }
        if (str == null) {
            str = jn1.MUL;
        }
        return getDimensionValueMap().containsKey(str);
    }

    public boolean hasMeasure(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-291205943")) {
            return ((Boolean) ipChange.ipc$dispatch("-291205943", new Object[]{this, str})).booleanValue();
        }
        if (str == null) {
            str = jn1.MUL;
        }
        return getMeasureValueMap().containsKey(str);
    }

    public AbsPerformance setDimension(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1826917250")) {
            return (AbsPerformance) ipChange.ipc$dispatch("-1826917250", new Object[]{this, str, Boolean.valueOf(z)});
        }
        if (str == null) {
            str = jn1.MUL;
        }
        getDimensionValueMap().put(str, z ? "1" : "0");
        return this;
    }

    public AbsPerformance setMeasure(String str, double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1160066656")) {
            return (AbsPerformance) ipChange.ipc$dispatch("1160066656", new Object[]{this, str, Double.valueOf(d)});
        }
        if (str == null) {
            str = jn1.MUL;
        }
        Log.e(TAG, jn1.ARRAY_START_STR + str + "]:" + String.valueOf(d));
        getMeasureValueMap().put(str, Double.valueOf(d));
        return this;
    }

    public AbsPerformance setMeasureSub(String str, double d, String str2) {
        Double d2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1419602406")) {
            return (AbsPerformance) ipChange.ipc$dispatch("1419602406", new Object[]{this, str, Double.valueOf(d), str2});
        }
        if (str != null && str2 != null && getMeasureValueMap().containsKey(str2) && (d2 = getMeasureValueMap().get(str2)) != null) {
            getMeasureValueMap().put(str, Double.valueOf(d - d2.doubleValue()));
        }
        return this;
    }

    public AbsPerformance setDimension(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "60495006")) {
            return (AbsPerformance) ipChange.ipc$dispatch("60495006", new Object[]{this, str, str2});
        }
        if (str == null) {
            str = jn1.MUL;
        }
        if (str2 == null) {
            str2 = "";
        }
        getDimensionValueMap().put(str, str2);
        return this;
    }

    public AbsPerformance setDimension(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1169635368")) {
            return (AbsPerformance) ipChange.ipc$dispatch("1169635368", new Object[]{this, str, str2, str3});
        }
        if (str == null) {
            str = jn1.MUL;
        }
        if (str2 == null) {
            str2 = str3;
        }
        if (str2 == null) {
            str2 = "";
        }
        getDimensionValueMap().put(str, str2);
        return this;
    }

    public AbsPerformance setMeasure(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "743388828") ? (AbsPerformance) ipChange.ipc$dispatch("743388828", new Object[]{this, str}) : setMeasure(str, System.currentTimeMillis());
    }

    public AbsPerformance(String str, String str2, String str3, String str4, String[] strArr, String[] strArr2) {
        this.moduleName = str;
        this.monitorPoint = str2;
        this.pageName = str3;
        this.argOne = str4;
        initWith(str, str2, strArr, strArr2);
    }

    private static void initWith(String str, String str2, List<String> list, List<String> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-656679713")) {
            ipChange.ipc$dispatch("-656679713", new Object[]{str, str2, list, list2});
            return;
        }
        DimensionSet create = DimensionSet.create();
        if (list != null && !list.isEmpty()) {
            for (String str3 : list) {
                create.addDimension(str3);
            }
        }
        MeasureSet create2 = MeasureSet.create();
        if (list2 != null && !list2.isEmpty()) {
            for (String str4 : list2) {
                create2.addMeasure(str4);
            }
        }
        AppMonitor.register(str, str2, create2, create);
    }
}
