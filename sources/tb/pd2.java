package tb;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.issue.tool.IssueConstants;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class pd2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String PROJECT_SCHEMA = "damai://projectdetail";

    public static void a(Context context, String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "963491561")) {
            ipChange.ipc$dispatch("963491561", new Object[]{context, str, str2, str3, str4});
        } else if (!TextUtils.isEmpty(str)) {
            Action action = new Action();
            action.setActionType(1);
            action.setActionUrl(str);
            NavProviderProxy.getProxy().toUri(context, action);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(IssueConstants.ProjectID, str2);
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("projectName", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("projectImage", str4);
            }
            Action action2 = new Action();
            action2.setActionType(1);
            action2.setActionUrl(PROJECT_SCHEMA);
            action2.setExtra(bundle);
            NavProviderProxy.getProxy().toUri(context, action2);
        }
    }
}
