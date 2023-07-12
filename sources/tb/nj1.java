package tb;

import android.view.View;
import android.view.ViewParent;
import cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollChild;
import cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollParent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class nj1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean a(NestedScrollParent nestedScrollParent, NestedScrollChild nestedScrollChild) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1980340773")) {
            return ((Boolean) ipChange.ipc$dispatch("-1980340773", new Object[]{nestedScrollParent, nestedScrollChild})).booleanValue();
        }
        if ((nestedScrollParent instanceof View) && (nestedScrollChild instanceof View)) {
            View view = (View) nestedScrollChild;
            if (view.getVisibility() == 0) {
                View view2 = (View) nestedScrollParent;
                for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                    if (parent == view2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
