package tb;

import android.view.animation.Animation;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class w5 implements Animation.AnimationListener {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "870106543")) {
            ipChange.ipc$dispatch("870106543", new Object[]{this, animation});
        }
    }
}
