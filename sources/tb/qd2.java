package tb;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.uikit.nav.INavUri;
import cn.damai.uikit.nav.NavProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class qd2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(Context context, String str, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "513956549")) {
            ipChange.ipc$dispatch("513956549", new Object[]{context, str, bundle});
        } else if (TextUtils.isEmpty(str)) {
            if (bundle != null) {
                NavProxy.from(context).withExtras(bundle).toUri(INavUri.page(cs.b));
            }
        } else if (bundle != null) {
            NavProxy.from(context).withExtras(bundle).toUri(str);
        } else {
            NavProxy.from(context).toUri(str);
        }
    }

    public static void b(Context context, String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1764605517")) {
            ipChange.ipc$dispatch("1764605517", new Object[]{context, str, str2, str3, str4});
        } else if (!TextUtils.isEmpty(str)) {
            NavProxy.from(context).toUri(str);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(IssueConstants.ProjectID, str2);
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("projectName", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("projectImage", str4);
            }
            NavProxy.from(context).withExtras(bundle).toUri(INavUri.page(cs.b));
        }
    }
}
