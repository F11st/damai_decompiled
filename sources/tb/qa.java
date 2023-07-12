package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class qa {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ERROR_CODE = "retCode:";
    public static final String ERROR_MSG = "retMsg:";
    public static final String JSON_LABEL = ":jsonData={";
    public static final String XFLUSH_NAME = "trade";

    public static String a(String str, String str2, String str3, String str4) {
        String str5;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-607360590")) {
            return (String) ipChange.ipc$dispatch("-607360590", new Object[]{str, str2, str3, str4});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("trade:jsonData={");
        String str6 = ",";
        if (TextUtils.isEmpty(str)) {
            str5 = "";
        } else {
            sb.append("apiName:");
            sb.append(str);
            str5 = ",";
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str5);
            sb.append(ERROR_CODE);
            if (TextUtils.isEmpty(str2)) {
                str2 = "0";
            }
            sb.append(str2);
            str5 = ",";
        }
        if (TextUtils.isEmpty(str3)) {
            str6 = str5;
        } else {
            sb.append(str5);
            sb.append(ERROR_MSG);
            sb.append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(str6);
            sb.append(str4);
        }
        sb.append("}");
        return sb.toString();
    }
}
