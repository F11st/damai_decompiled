package tb;

import android.content.Context;
import android.os.Bundle;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.contacts.bean.IdCardTypes;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class z3 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(Context context, int i, String str, ArrayList<IdCardTypes> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "162739782")) {
            ipChange.ipc$dispatch("162739782", new Object[]{context, Integer.valueOf(i), str, arrayList});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("contacts", arrayList);
        bundle.putString("bundleName", str);
        DMNav.from(context).forResult(i).withExtras(bundle).toUri(NavUri.b(cs.z));
    }
}
