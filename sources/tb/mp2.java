package tb;

import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.common.DamaiConstants;
import cn.damai.issue.tool.IssueConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class mp2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static long a(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1671487491")) {
            return ((Long) ipChange.ipc$dispatch("1671487491", new Object[]{bundle})).longValue();
        }
        long j = 0;
        String b = b(bundle);
        if (!TextUtils.isEmpty(b)) {
            Object obj = bundle.get(b);
            if (obj == null) {
                return 0L;
            }
            try {
                if (obj instanceof String) {
                    j = Long.parseLong((String) obj);
                } else if (obj instanceof Long) {
                    j = ((Long) obj).longValue();
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return j;
    }

    private static String b(Bundle bundle) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1527246066") ? (String) ipChange.ipc$dispatch("1527246066", new Object[]{bundle}) : bundle.containsKey(DamaiConstants.PUSH_MSG_SUMMARY) ? DamaiConstants.PUSH_MSG_SUMMARY : bundle.containsKey(IssueConstants.ProjectID) ? IssueConstants.ProjectID : bundle.containsKey("projectId") ? "projectId" : bundle.containsKey("id") ? "id" : bundle.containsKey("itemId") ? "itemId" : "";
    }
}
