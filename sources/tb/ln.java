package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ln {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ORDER_CREATE_ADD_NEW_CONTACTS_ERROR_CODE = "-4101";
    public static final String ORDER_CREATE_ADD_NEW_CONTACTS_ERROR_MSG = "新增观演人失败";

    public static void a(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1491421958")) {
            ipChange.ipc$dispatch("-1491421958", new Object[]{str, str2, str3, str4});
        } else {
            b23.a(b(str, str2, str3, str4, z20.q()), ORDER_CREATE_ADD_NEW_CONTACTS_ERROR_CODE, ORDER_CREATE_ADD_NEW_CONTACTS_ERROR_MSG);
        }
    }

    private static String b(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1750440602")) {
            return (String) ipChange.ipc$dispatch("-1750440602", new Object[]{str, str2, str3, str4, str5});
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(":jsondata={");
        sb.append("apiName: ");
        sb.append(str2);
        sb.append(", retCode: ");
        if (TextUtils.isEmpty(str3)) {
            str3 = "0";
        }
        sb.append(str3);
        sb.append(", retMsg: ");
        sb.append(str4);
        sb.append(", loginKey: ");
        sb.append(str5);
        sb.append("}");
        return sb.toString();
    }
}
