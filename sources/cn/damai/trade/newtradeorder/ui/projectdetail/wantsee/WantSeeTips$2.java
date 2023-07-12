package cn.damai.trade.newtradeorder.ui.projectdetail.wantsee;

import android.widget.PopupWindow;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.r03;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class WantSeeTips$2 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ r03 this$0;
    final /* synthetic */ PopupWindow val$popupWindow;

    WantSeeTips$2(r03 r03Var, PopupWindow popupWindow) {
        this.val$popupWindow = popupWindow;
    }

    @Override // java.lang.Runnable
    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1411883014")) {
            ipChange.ipc$dispatch("-1411883014", new Object[]{this});
        } else {
            this.val$popupWindow.dismiss();
        }
    }
}
