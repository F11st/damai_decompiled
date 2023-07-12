package tb;

import android.app.Activity;
import com.alibaba.ut.IWebView;
import com.alibaba.ut.comm.ActivityLifecycleCB;
import com.alibaba.ut.comm.JsBridge;
import com.ut.mini.UTAnalytics;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class mn implements ActivityLifecycleCB.ActivityPausedCallBack, ActivityLifecycleCB.ActivityResumedCallBack {
    private Set<Integer> a = new HashSet();

    public void a() {
        ActivityLifecycleCB.d().c(this);
        ActivityLifecycleCB.d().b(this);
    }

    @Override // com.alibaba.ut.comm.ActivityLifecycleCB.ActivityPausedCallBack
    public void onActivityPaused(Activity activity) {
        mb1.d(null, "activity", activity);
        IWebView a = ly2.a(activity);
        if (a == null || this.a.contains(Integer.valueOf(a.getDelegateHashCode()))) {
            return;
        }
        UTAnalytics.getInstance().getDefaultTracker().pageDisAppear(activity);
        JsBridge.g(a, "Aplus4UT.onPageHide", null);
    }

    @Override // com.alibaba.ut.comm.ActivityLifecycleCB.ActivityResumedCallBack
    public void onActivityResumed(Activity activity) {
        mb1.d(null, "activity", activity);
        IWebView a = ly2.a(activity);
        if (a == null || this.a.contains(Integer.valueOf(a.getDelegateHashCode()))) {
            return;
        }
        JsBridge.g(a, "Aplus4UT.onPageShow", null);
    }
}
