package tb;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.tetris.component.drama.bean.IDramaBean;
import cn.damai.tetris.component.drama.bean.ProjectShowBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class xc0 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(Activity activity, IDramaBean iDramaBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-745677287")) {
            ipChange.ipc$dispatch("-745677287", new Object[]{activity, iDramaBean});
        } else if (activity == null || iDramaBean == null || TextUtils.isEmpty(iDramaBean.getDramaId())) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("id", iDramaBean.getDramaId());
            DMNav.from(activity).withExtras(bundle).toUri(NavUri.b("ipdrama"));
        }
    }

    public static void b(ja jaVar, IDramaBean iDramaBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "273682661")) {
            ipChange.ipc$dispatch("273682661", new Object[]{jaVar, iDramaBean});
        } else if (jaVar != null) {
            a(jaVar.getActivity(), iDramaBean);
        }
    }

    public static void c(ja jaVar, ProjectShowBean projectShowBean) {
        Activity activity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1027875628")) {
            ipChange.ipc$dispatch("1027875628", new Object[]{jaVar, projectShowBean});
        } else if (jaVar == null || projectShowBean == null || (activity = jaVar.getActivity()) == null) {
        } else {
            qd2.b(activity, projectShowBean.schema, projectShowBean.itemId, projectShowBean.name, projectShowBean.verticalPic);
        }
    }

    public static void d(ja jaVar, String str) {
        Activity activity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1196414850")) {
            ipChange.ipc$dispatch("-1196414850", new Object[]{jaVar, str});
        } else if (TextUtils.isEmpty(str) || jaVar == null || (activity = jaVar.getActivity()) == null) {
        } else {
            DMNav.from(activity).toUri(str);
        }
    }
}
