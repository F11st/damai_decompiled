package com.huawei.hms.availableupdate;

import android.app.Activity;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class a {
    public static final a b = new a();
    public WeakReference<Activity> a;

    public boolean a(Activity activity) {
        HMSLog.i("UpdateAdapterMgr", "onActivityCreate");
        Activity a = a();
        if (a != null && !a.isFinishing()) {
            activity.finish();
            HMSLog.i("UpdateAdapterMgr", "finish one");
            return false;
        }
        this.a = new WeakReference<>(activity);
        return true;
    }

    public void b(Activity activity) {
        HMSLog.i("UpdateAdapterMgr", "onActivityDestroy");
        Activity a = a();
        if (activity == null || !activity.equals(a)) {
            return;
        }
        HMSLog.i("UpdateAdapterMgr", "reset");
        this.a = null;
    }

    public final Activity a() {
        WeakReference<Activity> weakReference = this.a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
