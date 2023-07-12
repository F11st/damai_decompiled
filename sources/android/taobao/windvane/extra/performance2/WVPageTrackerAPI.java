package android.taobao.windvane.extra.performance2;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVPageTrackerAPI extends WVApiPlugin {
    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (str.equals("reportPerformanceInfo")) {
            reportPerformanceInfo(str2, wVCallBackContext);
            return true;
        }
        return false;
    }

    public void reportPerformanceInfo(String str, WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        if (this.performance == null) {
            wVResult.setResult("HY_FAILED");
            wVResult.addData("msg", "performance object does not exist");
            wVCallBackContext.error(wVResult);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.performance.receiveJSMessageForCustomizedFSP(jSONObject.optLong("firstScreenPaint"));
            JSONObject jSONObject2 = jSONObject.getJSONObject("otherPerformanceStage");
            if (jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.performance.receiveJSMessageForCustomizedStage(jSONObject2.optLong(next), next);
                }
            }
            wVCallBackContext.success();
        } catch (Exception e) {
            wVResult.setResult("HY_FAILED");
            wVResult.addData("msg", "exception: " + e.getMessage());
            wVCallBackContext.error(wVResult);
        }
    }
}
