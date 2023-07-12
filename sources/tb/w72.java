package tb;

import android.view.View;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.bricks.onearch.AbsPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class w72 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(AbsPresenter absPresenter, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-417103627")) {
            ipChange.ipc$dispatch("-417103627", new Object[]{absPresenter, view});
        } else if (absPresenter.isOnlyChild()) {
            view.setBackgroundResource(R$drawable.bricks_list_bg_radius);
        } else if (absPresenter.isFirstChild()) {
            view.setBackgroundResource(R$drawable.bricks_list_bg_topradius);
        } else if (absPresenter.isLastChild()) {
            view.setBackgroundResource(R$drawable.bricks_list_bg_bottomradius);
        } else {
            view.setBackgroundResource(R$drawable.bricks_list_bg);
        }
    }
}
