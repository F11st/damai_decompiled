package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class rh2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1603140654")) {
            return (String) ipChange.ipc$dispatch("-1603140654", new Object[]{str});
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(StringUtils.LF);
                StringBuilder sb = new StringBuilder();
                for (String str2 : split) {
                    String trim = str2.trim();
                    if (!TextUtils.isEmpty(trim)) {
                        sb.append(StringUtils.LF);
                        sb.append(trim);
                    }
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(0);
                }
                return sb.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static int b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1010432776")) {
            return ((Integer) ipChange.ipc$dispatch("1010432776", new Object[]{str})).intValue();
        }
        try {
            return Integer.parseInt(c(str));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return -1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static String c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "699648567")) {
            return (String) ipChange.ipc$dispatch("699648567", new Object[]{str});
        }
        String str2 = "";
        if (str != null && str.length() != 0) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    str2 = str2 + str.charAt(i);
                }
            }
        }
        return str2;
    }
}
