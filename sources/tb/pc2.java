package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class pc2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BRANCH_NAME = "show";
    public static final String CATEGORY_LIST_ERROR_CODE = "-1200";
    public static final String CATEGORY_LIST_ERROR_MSG = "演出列表加载失败";

    public static void a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1128716481")) {
            ipChange.ipc$dispatch("1128716481", new Object[]{str});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("show");
        sb.append(":jsondata={apiName:");
        sb.append("mtop.damai.mec.aristotle.get");
        sb.append(",request:" + str);
        sb.append("}");
        b23.a(sb.toString(), CATEGORY_LIST_ERROR_CODE, "演出列表加载失败");
    }
}
