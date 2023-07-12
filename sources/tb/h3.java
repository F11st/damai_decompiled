package tb;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.tlog.protocol.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class h3 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static h3 d;
    private Application.ActivityLifecycleCallbacks a;
    private Application b;
    private HashMap<Integer, WeakReference<f3>> c = new HashMap<>();

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements Application.ActivityLifecycleCallbacks {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2052554887")) {
                ipChange.ipc$dispatch("-2052554887", new Object[]{this, activity, bundle});
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1987924074")) {
                ipChange.ipc$dispatch("1987924074", new Object[]{this, activity});
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1399997885")) {
                ipChange.ipc$dispatch("1399997885", new Object[]{this, activity});
            } else {
                h3.this.c(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_PAUSED, activity, null);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "61759852")) {
                ipChange.ipc$dispatch("61759852", new Object[]{this, activity});
            } else {
                h3.this.c(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED, activity, null);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1023429744")) {
                ipChange.ipc$dispatch("-1023429744", new Object[]{this, activity, bundle});
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-752496126")) {
                ipChange.ipc$dispatch("-752496126", new Object[]{this, activity});
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-961327562")) {
                ipChange.ipc$dispatch("-961327562", new Object[]{this, activity});
            }
        }
    }

    private h3(Application application) {
        this.b = application;
        a aVar = new a();
        this.a = aVar;
        this.b.registerActivityLifecycleCallbacks(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, Activity activity, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "448538424")) {
            ipChange.ipc$dispatch("448538424", new Object[]{this, str, activity, obj});
            return;
        }
        HashMap<Integer, WeakReference<f3>> hashMap = this.c;
        if (hashMap == null || hashMap.size() == 0) {
            return;
        }
        ArrayList<Integer> arrayList = null;
        for (Integer num : this.c.keySet()) {
            WeakReference<f3> weakReference = this.c.get(num);
            if (weakReference != null) {
                f3 f3Var = weakReference.get();
                if (f3Var == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(num);
                } else if (f3Var.a(activity)) {
                    str.hashCode();
                    if (str.equals(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_PAUSED)) {
                        f3Var.onActivityPaused(activity);
                    } else if (str.equals(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED)) {
                        f3Var.onActivityResumed(activity);
                    }
                }
            }
        }
        if (arrayList != null) {
            for (Integer num2 : arrayList) {
                this.c.remove(num2);
            }
        }
    }

    public static h3 d(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "434009774")) {
            return (h3) ipChange.ipc$dispatch("434009774", new Object[]{application});
        }
        if (d == null) {
            synchronized (h3.class) {
                if (d == null) {
                    d = new h3(application);
                }
            }
        }
        return d;
    }

    public void b(f3 f3Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1954399263")) {
            ipChange.ipc$dispatch("-1954399263", new Object[]{this, f3Var});
        } else if (f3Var != null) {
            this.c.put(Integer.valueOf(f3Var.hashCode()), new WeakReference<>(f3Var));
        }
    }

    public void e(f3 f3Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1533434178")) {
            ipChange.ipc$dispatch("1533434178", new Object[]{this, f3Var});
        } else if (f3Var != null) {
            this.c.remove(Integer.valueOf(f3Var.hashCode()));
        }
    }
}
