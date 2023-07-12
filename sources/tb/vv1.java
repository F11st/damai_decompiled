package tb;

import android.content.Context;
import android.text.TextUtils;
import cn.damai.trade.R$string;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class vv1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(Context context, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1739300729")) {
            return (String) ipChange.ipc$dispatch("-1739300729", new Object[]{context, str, str2});
        }
        if (context == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
            sb.append(context.getResources().getString(R$string.str_venue_city_name_divider));
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public static boolean b(int i, int i2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "716894555") ? ((Boolean) ipChange.ipc$dispatch("716894555", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})).booleanValue() : i > 0 && i2 > 0 && ((long) (i2 * i)) > 640000;
    }
}
