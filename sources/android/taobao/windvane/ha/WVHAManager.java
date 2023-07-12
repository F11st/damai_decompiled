package android.taobao.windvane.ha;

import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.util.TaoLog;
import com.alibaba.ha.bizerrorreporter.BizErrorReporter;
import com.alibaba.ha.bizerrorreporter.module.AggregationType;
import com.alibaba.ha.bizerrorreporter.module.BizErrorModule;
import com.taobao.monitor.terminator.ApmGodEye;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVHAManager {
    private static final String TAG = "WVHAManager";

    public static void commitData(String str, String str2, String str3, String str4, HashMap<String, String> hashMap) {
        try {
            BizErrorModule bizErrorModule = new BizErrorModule();
            bizErrorModule.aggregationType = AggregationType.CONTENT;
            bizErrorModule.businessType = str;
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            bizErrorModule.exceptionDetail = jSONObject.toString();
            bizErrorModule.exceptionCode = str2;
            bizErrorModule.exceptionArg1 = str3;
            bizErrorModule.exceptionArg2 = str4;
            BizErrorReporter.getInstance().send(GlobalConfig.context, bizErrorModule);
        } catch (Throwable th) {
            TaoLog.d(TAG, "commitData: 无法上报信息，请检查是否导入bizerrorreporter以及tbrest!");
            th.printStackTrace();
        }
    }

    public static void reportJSError(String str, String str2, String str3, String str4, String str5, String str6) {
        try {
            BizErrorModule bizErrorModule = new BizErrorModule();
            bizErrorModule.aggregationType = AggregationType.CONTENT;
            bizErrorModule.exceptionCode = str2;
            bizErrorModule.businessType = str;
            bizErrorModule.exceptionDetail = str3;
            if (str4 == null) {
                bizErrorModule.exceptionArg1 = "Script error";
            } else {
                bizErrorModule.exceptionArg1 = str4;
            }
            bizErrorModule.exceptionArg2 = "line: " + str5;
            bizErrorModule.exceptionArg3 = str6;
            BizErrorReporter.getInstance().send(GlobalConfig.context, bizErrorModule);
        } catch (Throwable th) {
            TaoLog.d(TAG, "commitData: 无法上报信息，请检查是否导入bizerrorreporter以及tbrest!");
            th.printStackTrace();
        }
    }

    private static void toString(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder(jn1.BLOCK_START_STR);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=[");
            sb.append(entry.getValue());
            sb.append(jn1.ARRAY_END_STR);
            sb.append(";");
        }
        sb.append("}");
        TaoLog.e("H5HA", sb.toString());
    }

    public static void uploadApmError(String str, String str2, Map<String, Object> map) {
        try {
            ApmGodEye.onError("H5", str, str2, new Map[]{map});
            toString(map);
        } catch (Throwable unused) {
        }
    }

    public static void uploadApmStage(String str, Map<String, Object> map) {
        try {
            ApmGodEye.onStage("H5", str, new Map[]{map});
            toString(map);
        } catch (Throwable unused) {
        }
    }
}
