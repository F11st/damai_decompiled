package tb;

import android.content.Context;
import com.ta.utdid2.device.UTDevice;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.JsonUtility;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.mass.MassClient;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class kd1 {
    private static final String a = "kd1";

    public static byte[] a(Context context, String str, String str2, String str3) {
        byte[] bArr = null;
        try {
            JSONObject build = new JsonUtility.JsonObjectBuilder().put("deviceId", OrangeAdapter.isRegIdSwitchEnableAndValid(context) ? OrangeAdapter.getRegId(context) : UTDevice.getUtdid(context)).put("appKey", str).put("serviceName", str2).put("operation", str3).put("version", "1.0").put("appVersion", context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName).build();
            JSONArray jSONArray = new JSONArray();
            for (String str4 : MassClient.getInstance().getTopicsByService(str2)) {
                jSONArray.put(str4);
            }
            build.put("topic", jSONArray);
            bArr = build.toString().getBytes("utf-8");
            ALog.i(a, "buildMassData", "data", build.toString());
            return bArr;
        } catch (Throwable th) {
            ALog.e(a, "buildMassData", th, new Object[0]);
            return bArr;
        }
    }
}
