package tb;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.net.URL;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class gs2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(String str) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "113289176")) {
            return (String) ipChange.ipc$dispatch("113289176", new Object[]{str});
        }
        Log.d("damai-pay", "parseUrlAndAddOstype(): url=" + str);
        try {
            str2 = new URL(str).getHost();
        } catch (Exception e) {
            e.printStackTrace();
            str2 = "";
        }
        if (str2 == null || str2.equals("") || !str2.contains("damai") || str2.contains("paybank.damai.cn") || str2.contains("payback.damai.cn") || str.contains("osType=2")) {
            return str;
        }
        if (str.contains("?")) {
            return str + "&osType=2";
        } else if (str.endsWith("/")) {
            return str;
        } else {
            return str + "?osType=2";
        }
    }
}
