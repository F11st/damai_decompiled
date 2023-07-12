package tb;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import cn.damai.trade.R$style;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ro1 extends DialogFragment {
    private static transient /* synthetic */ IpChange $ipChange;

    public void a(FragmentManager fragmentManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "480594416")) {
            ipChange.ipc$dispatch("480594416", new Object[]{this, fragmentManager});
            return;
        }
        try {
            show(fragmentManager, getClass().getName());
            fragmentManager.executePendingTransactions();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "150202627")) {
            ipChange.ipc$dispatch("150202627", new Object[]{this, bundle});
            return;
        }
        getDialog().requestWindowFeature(1);
        super.onActivityCreated(bundle);
        int i = (int) (DisplayMetrics.getheightPixels(m62.b(getActivity())) * 0.75d);
        Window window = getDialog().getWindow();
        window.setLayout(-1, i);
        window.setGravity(80);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.windowAnimations = R$style.ActionSheetDialogAnimation;
        window.setAttributes(attributes);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-358807248")) {
            ipChange.ipc$dispatch("-358807248", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setStyle(2, R$style.MyMiddleDialogStyle);
    }
}
