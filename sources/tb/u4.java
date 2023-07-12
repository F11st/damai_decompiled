package tb;

import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.JsonUtility;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UtilityImpl;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class u4 extends la {
    public static final String JSON_CMD_REMOVEALIAS = "removeAlias";
    public static final String JSON_CMD_REMOVEALLALIAS = "unbindAllAlias";
    public static final String JSON_CMD_SETALIAS = "setAlias";
    public static final String JSON_PUSH_USER_TOKEN = "pushAliasToken";
    public String b;
    public String c;
    public String d;
    public String e;

    public static byte[] b(String str, String str2) {
        u4 u4Var = new u4();
        u4Var.b = str;
        u4Var.c = str2;
        u4Var.a = JSON_CMD_REMOVEALLALIAS;
        return u4Var.a();
    }

    public static byte[] c(String str, String str2, String str3) {
        u4 u4Var = new u4();
        u4Var.b = str;
        u4Var.c = str2;
        u4Var.e = str3;
        u4Var.a = JSON_CMD_REMOVEALIAS;
        return u4Var.a();
    }

    public static byte[] d(String str, String str2, String str3) {
        u4 u4Var = new u4();
        u4Var.b = str;
        u4Var.c = str2;
        u4Var.d = str3;
        u4Var.a = JSON_CMD_REMOVEALIAS;
        return u4Var.a();
    }

    public static byte[] e(String str, String str2, String str3) {
        u4 u4Var = new u4();
        u4Var.b = str;
        u4Var.c = str2;
        u4Var.d = str3;
        u4Var.a = JSON_CMD_SETALIAS;
        return u4Var.a();
    }

    public byte[] a() {
        try {
            JsonUtility.JsonObjectBuilder put = new JsonUtility.JsonObjectBuilder().put("cmd", this.a).put("appKey", this.b).put("deviceId", this.c).put("alias", this.d).put(JSON_PUSH_USER_TOKEN, this.e);
            if (OrangeAdapter.isRegIdSwitchEnableAndValid(GlobalClientInfo.getContext())) {
                put.put("regId", OrangeAdapter.getRegId(GlobalClientInfo.getContext()));
                put.put("utdid", UtilityImpl.getDeviceId(GlobalClientInfo.getContext()));
            }
            String jSONObject = put.build().toString();
            ALog.i("AliasDO", "buildData", "data", jSONObject);
            return jSONObject.getBytes("utf-8");
        } catch (Throwable th) {
            ALog.e("AliasDO", "buildData", th, new Object[0]);
            return null;
        }
    }
}
