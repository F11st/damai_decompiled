package tb;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.JsonUtility;
import com.taobao.accs.utl.RomInfoCollecter;
import com.taobao.accs.utl.UtilityImpl;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class l12 extends la {
    public static final String JSON_CMD_REGISTER = "register";
    public String b;
    public String c;
    public String d;
    public String e = String.valueOf((int) Constants.SDK_VERSION_CODE);
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;

    public static byte[] b(Context context, String str, String str2) {
        l12 l12Var;
        String deviceId;
        String packageName;
        String str3;
        try {
            deviceId = UtilityImpl.getDeviceId(context);
            packageName = context.getPackageName();
            str3 = GlobalClientInfo.getInstance(context).getPackageInfo().versionName;
        } catch (Throwable th) {
            th = th;
            l12Var = null;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(deviceId) && !TextUtils.isEmpty(str3)) {
            l12Var = new l12();
            try {
                l12Var.a = "register";
                l12Var.b = str;
                l12Var.c = deviceId;
                l12Var.d = str3;
                l12Var.f = str2;
                l12Var.g = packageName;
                l12Var.j = Build.getBRAND();
                l12Var.k = Build.getMODEL();
                String isNotificationEnabled = AdapterUtilityImpl.isNotificationEnabled(context);
                l12Var.h = isNotificationEnabled;
                UtilityImpl.saveNotificationState(context, Constants.SP_CHANNEL_FILE_NAME, isNotificationEnabled);
                l12Var.i = RomInfoCollecter.getCollecter().collect();
            } catch (Throwable th2) {
                th = th2;
                try {
                    ALog.w("RegisterDO", "buildRegister", th.getMessage());
                    if (l12Var == null) {
                        return null;
                    }
                    return l12Var.a();
                } finally {
                    if (l12Var != null) {
                        l12Var.a();
                    }
                }
            }
            return l12Var.a();
        }
        ALog.e("RegisterDO", "buildRegister param null", "appKey", str, "utdid", deviceId, "appVersion", str3);
        return null;
    }

    public byte[] a() {
        try {
            String jSONObject = new JsonUtility.JsonObjectBuilder().put("cmd", this.a).put("appKey", this.b).put("utdid", this.c).put("appVersion", this.d).put("sdkVersion", this.e).put("ttid", this.f).put("packageName", this.g).put("notifyEnable", this.h).put("romInfo", this.i).put("c0", this.j).put("c1", this.k).put("c2", this.l).put("c3", this.m).put("c4", this.n).put("c5", this.o).put("c6", this.p).build().toString();
            ALog.i("RegisterDO", "buildData", "data", jSONObject);
            return jSONObject.getBytes("utf-8");
        } catch (Throwable th) {
            ALog.e("RegisterDO", "buildData", th, new Object[0]);
            return null;
        }
    }
}
