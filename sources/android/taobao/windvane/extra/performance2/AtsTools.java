package android.taobao.windvane.extra.performance2;

import android.taobao.windvane.config.GlobalConfig;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.taobao.aboat.ReceivePerformance;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
class AtsTools {
    private static boolean needSendPerformance;

    static {
        try {
            Class.forName("com.taobao.aboat.ReceivePerformance");
            needSendPerformance = true;
        } catch (Throwable unused) {
        }
    }

    AtsTools() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void sendAtsPerformanceLog(String str, Object obj) {
        try {
            if (needSendPerformance && !TextUtils.isEmpty(str) && obj != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, obj);
                ReceivePerformance.onReceiveWindmillPerformanceLog(GlobalConfig.context.getApplicationContext(), "windvane_performance_statistics", jSONObject.toJSONString());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
