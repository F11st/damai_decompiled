package tb;

import android.content.Context;
import android.text.TextUtils;
import cn.damai.common.app.ShareperfenceConstants;
import cn.damai.common.util.C0535a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class yi {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1766777203")) {
            return (String) ipChange.ipc$dispatch("1766777203", new Object[]{context});
        }
        String str = "";
        try {
            cb1.b("CityListDefaultUitl", "read cache -> start time = " + System.currentTimeMillis());
            str = z20.B(ShareperfenceConstants.CITY_DATA_New);
            cb1.b("CityListDefaultUitl", "read cache -> start time = " + System.currentTimeMillis());
            if (wh2.j(str)) {
                cb1.b("CityListDefaultUitl", "read default -> start time = " + System.currentTimeMillis());
                str = C0535a.n(context.getAssets().open("damai_city_list.json"));
                if (!TextUtils.isEmpty(str)) {
                    z20.T(ShareperfenceConstants.CITY_DATA_New, str);
                }
                cb1.b("CityListDefaultUitl", "read default -> end time = " + System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
