package android.taobao.windvane.jsbridge;

import android.os.SystemClock;
import android.taobao.windvane.extra.performance2.IPerformance;
import android.taobao.windvane.util.FullTraceUtils;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.utils.TimeUtils;
import android.taobao.windvane.webview.IFullTrace;
import android.taobao.windvane.webview.IWVWebView;
import android.view.View;
import com.taobao.analysis.v3.FalcoSpan;
import com.taobao.monitor.procedure.IProcedure;
import com.taobao.monitor.procedure.ViewToken;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.uc.webview.export.WebView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tb.wu1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVH5PP extends WVApiPlugin {
    private static final String TAG = "WVH5PP";
    private static Set<String> activityPropertiedSet;
    private static Set<String> activityStagedSet;
    private static Set<String> launcherPropertiedSet;
    private static Set<String> launcherStagedSet;
    private static Set<String> procedurePropertiedSet;
    private static Set<String> procedureStagedSet;

    private void procedureProperty(JSONObject jSONObject, IProcedure iProcedure, Set<String> set, WVCallBackContext wVCallBackContext) throws JSONException {
        FalcoSpan falcoSpan;
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!set.contains(next)) {
                String string = jSONObject.getString(next);
                TaoLog.v(TAG, "key:" + next + " value:" + string);
                IWVWebView webview = wVCallBackContext.getWebview();
                if ("isFinished".equals(next) && "true".equalsIgnoreCase(string)) {
                    if (webview instanceof WebView) {
                        try {
                            ((WebView) webview).setTag(ViewToken.APM_VIEW_TOKEN, ViewToken.APM_VIEW_VALID);
                        } catch (Throwable th) {
                            TaoLog.d(TAG, "ViewToken doesn't exist: " + th);
                        }
                        TaoLog.d(TAG, "receive isFinished setTag " + SystemClock.uptimeMillis());
                    }
                    if (webview instanceof IPerformance) {
                        ((IPerformance) webview).setReportedFSP(true);
                    }
                }
                iProcedure.addProperty("H5_H5_" + next, string);
                if ((webview instanceof IFullTrace) && (falcoSpan = ((IFullTrace) webview).getFalcoSpan()) != null) {
                    falcoSpan.setTag("H5_H5_" + next, string);
                }
                set.add(next);
            } else {
                TaoLog.v(TAG, "property add abort because added:" + next);
            }
        }
    }

    private void procedureStage(JSONObject jSONObject, IProcedure iProcedure, Set<String> set, IWVWebView iWVWebView) throws JSONException {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!set.contains(next)) {
                Long valueOf = Long.valueOf(jSONObject.getLong(next));
                Long valueOf2 = Long.valueOf(TimeUtils.generateUptimeFromCurrentTime(valueOf.longValue()));
                TaoLog.v(TAG, "stage:" + next + " time:" + valueOf2);
                StringBuilder sb = new StringBuilder();
                sb.append("H5_H5_");
                sb.append(next);
                iProcedure.stage(sb.toString(), valueOf2.longValue());
                if (iWVWebView instanceof IFullTrace) {
                    FalcoSpan falcoSpan = ((IFullTrace) iWVWebView).getFalcoSpan();
                    FullTraceUtils.addCustomStage(falcoSpan, "H5_H5_" + next, valueOf);
                }
                set.add(next);
            } else {
                TaoLog.v(TAG, "stage add abort because added:" + next);
            }
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("receiveFSPTime".equals(str)) {
            receiveFSPTime(str2, wVCallBackContext);
            return true;
        } else if ("receiveFPTime".equals(str)) {
            receiveFPTime(str2, wVCallBackContext);
            return true;
        } else if ("receiveTTITime".equals(str)) {
            receiveTTITime(str2, wVCallBackContext);
            return true;
        } else if ("onStage".equals(str)) {
            onStage(str2, wVCallBackContext);
            return true;
        } else if ("onProperty".equals(str)) {
            onProperty(str2, wVCallBackContext);
            return true;
        } else {
            return false;
        }
    }

    public final void onProperty(String str, WVCallBackContext wVCallBackContext) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("property");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                IProcedure launcherProcedure = wu1.b.getLauncherProcedure();
                if (launcherProcedure != null && launcherProcedure.isAlive()) {
                    procedureProperty(optJSONObject, launcherProcedure, launcherPropertiedSet, wVCallBackContext);
                } else {
                    TaoLog.v(TAG, "LauncherProcedure is not Alive");
                }
                IProcedure currentActivityProcedure = wu1.b.getCurrentActivityProcedure();
                if (currentActivityProcedure != null && currentActivityProcedure.isAlive()) {
                    procedureProperty(optJSONObject, currentActivityProcedure, activityPropertiedSet, wVCallBackContext);
                } else {
                    TaoLog.v(TAG, "CurrentActivityProcedure is not Alive");
                }
                IProcedure procedure = wu1.b.getProcedure((View) wVCallBackContext.getWebview());
                if (procedure != null && procedure.isAlive()) {
                    procedureProperty(optJSONObject, procedure, procedurePropertiedSet, wVCallBackContext);
                } else {
                    TaoLog.v(TAG, "Procedure is not Alive");
                }
            }
            wVCallBackContext.success();
        } catch (Throwable unused) {
            wVCallBackContext.error();
        }
    }

    public final void onStage(String str, WVCallBackContext wVCallBackContext) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(TLogEventConst.PARAM_UPLOAD_STAGE);
            if (optJSONObject != null && optJSONObject.length() > 0) {
                IProcedure launcherProcedure = wu1.b.getLauncherProcedure();
                if (launcherProcedure != null && launcherProcedure.isAlive()) {
                    procedureStage(optJSONObject, launcherProcedure, launcherStagedSet, wVCallBackContext.getWebview());
                } else {
                    TaoLog.v(TAG, "LauncherProcedure is not Alive");
                }
                IProcedure currentActivityProcedure = wu1.b.getCurrentActivityProcedure();
                if (currentActivityProcedure != null && currentActivityProcedure.isAlive()) {
                    procedureStage(optJSONObject, currentActivityProcedure, activityStagedSet, wVCallBackContext.getWebview());
                } else {
                    TaoLog.v(TAG, "CurrentActivityProcedure is not Alive");
                }
                IProcedure procedure = wu1.b.getProcedure((View) wVCallBackContext.getWebview());
                if (procedure != null && procedure.isAlive()) {
                    procedureStage(optJSONObject, procedure, procedureStagedSet, wVCallBackContext.getWebview());
                } else {
                    TaoLog.v(TAG, "LauncherProcedure is not Alive");
                }
            }
            wVCallBackContext.success();
        } catch (Throwable unused) {
            wVCallBackContext.error();
        }
    }

    public final void receiveFPTime(String str, WVCallBackContext wVCallBackContext) {
        if (this.performance == null) {
            return;
        }
        try {
            long optLong = new JSONObject(str).optLong("time");
            if (optLong != 0) {
                this.performance.receiveJSMessageForFP(optLong);
            }
            wVCallBackContext.success();
        } catch (Exception unused) {
            wVCallBackContext.error();
        }
    }

    public final void receiveFSPTime(String str, WVCallBackContext wVCallBackContext) {
        if (this.performance == null) {
            return;
        }
        try {
            long optLong = new JSONObject(str).optLong("time");
            if (optLong != 0) {
                this.performance.receiveJSMessageForFSP(optLong);
            }
            wVCallBackContext.success();
        } catch (Exception unused) {
            wVCallBackContext.error();
        }
    }

    public final void receiveTTITime(String str, WVCallBackContext wVCallBackContext) {
        if (this.performance == null) {
            return;
        }
        try {
            long optLong = new JSONObject(str).optLong("time");
            if (optLong != 0) {
                this.performance.receiveJSMessageForTTI(optLong);
            }
            wVCallBackContext.success();
        } catch (Exception unused) {
            wVCallBackContext.error();
        }
    }

    public void resetAllStoredSet() {
        launcherStagedSet = new HashSet();
        activityStagedSet = new HashSet();
        procedureStagedSet = new HashSet();
        launcherPropertiedSet = new HashSet();
        activityPropertiedSet = new HashSet();
        procedurePropertiedSet = new HashSet();
    }
}
