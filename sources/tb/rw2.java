package tb;

import android.net.Uri;
import android.text.TextUtils;
import cn.damai.common.user.C0529c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class rw2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "152378371")) {
            ipChange.ipc$dispatch("152378371", new Object[]{str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            String queryParameter = Uri.parse(str).getQueryParameter("utm");
            if (TextUtils.isEmpty(queryParameter)) {
                return;
            }
            C0529c.e().H("utm", queryParameter);
        }
    }
}
