package tb;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.aliweex.C3004a;
import com.alibaba.aliweex.R$string;
import com.alibaba.fastjson.JSON;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.adapter.IWXUserTrackAdapter;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.common.WXPerformance;
import com.taobao.weex.utils.WXLogUtils;
import java.io.Serializable;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class yz2 implements IWXUserTrackAdapter {
    private static boolean a = false;
    private static String b = "false";
    private static boolean c;

    public yz2() {
        String string = C3004a.l().b().getString(R$string.weex_performance_log_switch);
        b = string;
        if (TextUtils.equals(string, "true")) {
            c = true;
        }
    }

    private void a() {
        WXPerformance.Measure[] values;
        if (a) {
            return;
        }
        DimensionSet create = DimensionSet.create();
        String[] dimensions = WXPerformance.getDimensions();
        StringBuilder sb = new StringBuilder("维度集:");
        for (String str : dimensions) {
            create.addDimension(str);
            if (WXEnvironment.isApkDebugable()) {
                sb.append(str);
                sb.append(jn1.OR);
            }
        }
        sb.append("指标集:");
        MeasureSet create2 = MeasureSet.create();
        for (WXPerformance.Measure measure : WXPerformance.Measure.values()) {
            Measure measure2 = new Measure(measure.toString());
            measure2.setRange(Double.valueOf(measure.getMinRange()), Double.valueOf(measure.getMaxRange()));
            create2.addMeasure(measure2);
            if (WXEnvironment.isApkDebugable()) {
                sb.append(measure.toString());
            }
        }
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("UserTrack", sb.toString());
        }
        AppMonitor.register("weex", "load", create2, create);
        a = true;
    }

    @Override // com.taobao.weex.adapter.IWXUserTrackAdapter
    public void commit(Context context, String str, String str2, WXPerformance wXPerformance, Map<String, Serializable> map) {
        try {
            a();
            if ("load".equals(str2) && wXPerformance != null) {
                Uri parse = Uri.parse(wXPerformance.pageName);
                String scheme = parse.getScheme();
                String queryParameter = parse.getQueryParameter("spm");
                wXPerformance.pageName = xz2.c(wXPerformance.pageName);
                DimensionValueSet create = DimensionValueSet.create();
                Map<String, String> dimensionMap = wXPerformance.getDimensionMap();
                dimensionMap.put("scheme", scheme);
                dimensionMap.put("spm", queryParameter);
                MeasureValueSet create2 = MeasureValueSet.create();
                StringBuilder sb = new StringBuilder("维度埋点数据:");
                if (map != null) {
                    dimensionMap.put("customMonitorInfo", JSON.toJSONString(map));
                }
                for (String str3 : dimensionMap.keySet()) {
                    create.setValue(str3, dimensionMap.get(str3));
                    if (WXEnvironment.isApkDebugable() || c) {
                        sb.append(str3);
                        sb.append(":");
                        sb.append(dimensionMap.get(str3));
                        sb.append(jn1.OR);
                    }
                }
                sb.append("指标埋点数据:");
                Map<String, Double> measureMap = wXPerformance.getMeasureMap();
                if (measureMap != null) {
                    for (String str4 : measureMap.keySet()) {
                        create2.setValue(str4, measureMap.get(str4).doubleValue());
                        if (WXEnvironment.isApkDebugable() || c) {
                            sb.append(str4);
                            sb.append(":");
                            sb.append(measureMap.get(str4));
                            sb.append(jn1.OR);
                        }
                    }
                }
                AppMonitor.Stat.commit("weex", "load", create, create2);
                if (WXEnvironment.isApkDebugable()) {
                    WXLogUtils.d("UserTrack", sb.toString());
                } else if (c) {
                    Log.d("Weex_Perf_Test", sb.toString());
                }
            } else if ((IWXUserTrackAdapter.DOM_MODULE.equals(str2) || IWXUserTrackAdapter.JS_BRIDGE.equals(str2) || WXEnvironment.ENVIRONMENT.equals(str2) || IWXUserTrackAdapter.STREAM_MODULE.equals(str2) || IWXUserTrackAdapter.JS_FRAMEWORK.equals(str2) || IWXUserTrackAdapter.JS_DOWNLOAD.equals(str2)) && wXPerformance != null) {
                if (!WXErrorCode.WX_SUCCESS.getErrorCode().equals(wXPerformance.errCode)) {
                    AppMonitor.Alarm.commitFail("weex", str2, wXPerformance.args, wXPerformance.errCode, wXPerformance.getErrMsg());
                } else {
                    AppMonitor.Alarm.commitSuccess("weex", str2, wXPerformance.args);
                }
            } else {
                if (!IWXUserTrackAdapter.INVOKE_MODULE.equals(str2) && !IWXUserTrackAdapter.INIT_FRAMEWORK.equals(str2)) {
                    if (!IWXUserTrackAdapter.COUNTER.equals(str2) || str == null) {
                        return;
                    }
                    AppMonitor.Counter.commit("weex", str, 1.0d);
                    if ("sJSFMStartListener".equals(str) && map != null && map.containsKey("time")) {
                        try {
                            AppMonitor.Counter.commit("weex", "sJSFMStartListenerTime", Double.valueOf(map.get("time").toString()).doubleValue());
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                AppMonitor.Alarm.commitFail("weex", str2, (String) map.get("arg"), (String) map.get("errCode"), (String) map.get("errMsg"));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
