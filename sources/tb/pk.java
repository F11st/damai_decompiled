package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class pk {
    private static transient /* synthetic */ IpChange $ipChange;

    private static final String a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-449291959")) {
            return (String) ipChange.ipc$dispatch("-449291959", new Object[]{str});
        }
        if (str.length() == 1) {
            return "0" + str;
        }
        return str;
    }

    public static String b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "481647836")) {
            return (String) ipChange.ipc$dispatch("481647836", new Object[]{str});
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.replace("rgba(", "").replace(jn1.BRACKET_END_STR, "").split(",");
            if (split != null && split.length == 4) {
                return c(Double.parseDouble(split[3]), Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String c(double d, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1639210533")) {
            return (String) ipChange.ipc$dispatch("-1639210533", new Object[]{Double.valueOf(d), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        String a = a(Integer.toHexString((int) Math.round((Math.round(d * 100.0d) / 100.0d) * 255.0d)).toUpperCase());
        String a2 = a(Integer.toHexString(i));
        String a3 = a(Integer.toHexString(i2));
        String a4 = a(Integer.toHexString(i3));
        return Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + a + a2 + a3 + a4;
    }
}
