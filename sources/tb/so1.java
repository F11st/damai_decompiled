package tb;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class so1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(Context context, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1970018109") ? (String) ipChange.ipc$dispatch("1970018109", new Object[]{context, str}) : context == null ? "" : "待付款".equals(str) ? "#FF3E29" : "待发货".equals(str) ? "#FFA913" : ("已发货".equals(str) || "交易完成".equals(str)) ? "#2CB95E" : "交易关闭".equals(str) ? "#888888" : "";
    }

    public static String b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-458219609")) {
            return (String) ipChange.ipc$dispatch("-458219609", new Object[]{str});
        }
        if (str == null) {
            return null;
        }
        return Pattern.compile("^\\s*|\\s*$").matcher(str).replaceAll("");
    }
}
