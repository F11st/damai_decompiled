package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class yn2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BUSINESS_NAME_TICKLET = "ticklet";
    public static final String TICKLET_TOCOMMENT_LIST_NETWORK_ERROR_CODE = "-5830";
    public static final String TICKLET_TOCOMMENT_LIST_NETWORK_ERROR_MSG = "票夹待评价列表加载失败";

    public static String a(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "814897725")) {
            return (String) ipChange.ipc$dispatch("814897725", new Object[]{str, str2, str3});
        }
        return "ticklet:jsondata={apiName: " + str + ", retCode: " + str2 + ", retMsg: " + str3 + "}";
    }
}
