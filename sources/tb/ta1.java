package tb;

import android.content.Context;
import com.taobao.dp.DeviceSecuritySDK;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ta1 {
    private static boolean a = true;

    public static String a(Context context) {
        if (context == null || !a) {
            return null;
        }
        try {
            int i = DeviceSecuritySDK.ENVIRONMENT_ONLINE;
            Object d = z02.d(DeviceSecuritySDK.class, "getInstance", new Object[]{context}, Context.class);
            if (d != null) {
                Object a2 = z02.a(d, "getSecurityToken");
                if (a2 != null) {
                    String str = (String) a2;
                }
                return (String) a2;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
