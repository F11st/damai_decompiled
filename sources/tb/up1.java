package tb;

import android.app.Activity;
import android.util.Log;
import com.alibaba.ut.comm.ActivityLifecycleCB;
import com.alibaba.ut.page.VirtualPageObject;
import com.taobao.android.tlog.protocol.Constants;
import com.ut.mini.UTPageHitHelper;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class up1 implements ActivityLifecycleCB.ActivityDestroyCallBack {
    public void a() {
        ActivityLifecycleCB.d().a(this);
    }

    @Override // com.alibaba.ut.comm.ActivityLifecycleCB.ActivityDestroyCallBack
    public void onActivityDestroyed(Activity activity) {
        mb1.h(null, "activity", activity);
        List<VirtualPageObject> b = bq1.b(activity);
        if (b.size() > 0) {
            for (VirtualPageObject virtualPageObject : b) {
                try {
                    UTPageHitHelper.getInstance().pageDestroyed(virtualPageObject);
                } catch (Throwable unused) {
                    Log.i(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_DESTROYED, "onActivityDestroyed is exception");
                }
                ms2.l(virtualPageObject.b + "");
                bq1.a(virtualPageObject);
            }
        }
    }
}
