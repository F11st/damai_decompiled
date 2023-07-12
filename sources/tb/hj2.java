package tb;

import android.text.TextUtils;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.JsonUtility;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UtilityImpl;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class hj2 extends la {
    public static final String JSON_CMD_DISABLEPUSH = "disablePush";
    public static final String JSON_CMD_ENABLEPUSH = "enablePush";
    public String b;
    public String c;
    public String d;

    public static byte[] b(String str, String str2, String str3, boolean z) {
        hj2 hj2Var = new hj2();
        hj2Var.b = str;
        hj2Var.c = str2;
        hj2Var.d = str3;
        if (z) {
            hj2Var.a = JSON_CMD_ENABLEPUSH;
        } else {
            hj2Var.a = JSON_CMD_DISABLEPUSH;
        }
        return hj2Var.a();
    }

    public byte[] a() {
        try {
            JsonUtility.JsonObjectBuilder jsonObjectBuilder = new JsonUtility.JsonObjectBuilder();
            jsonObjectBuilder.put("cmd", this.a).put("appKey", this.b);
            if (TextUtils.isEmpty(this.c)) {
                jsonObjectBuilder.put("utdid", this.d);
            } else {
                jsonObjectBuilder.put("deviceId", this.c);
            }
            if (OrangeAdapter.isRegIdSwitchEnableAndValid(GlobalClientInfo.getContext())) {
                jsonObjectBuilder.put("regId", OrangeAdapter.getRegId(GlobalClientInfo.getContext()));
                jsonObjectBuilder.put("utdid", UtilityImpl.getDeviceId(GlobalClientInfo.getContext()));
            }
            String jSONObject = jsonObjectBuilder.build().toString();
            ALog.i("SwitchDO", "buildData", "data", jSONObject);
            return jSONObject.getBytes("utf-8");
        } catch (Throwable th) {
            ALog.e("SwitchDO", "buildData", th, new Object[0]);
            return null;
        }
    }
}
