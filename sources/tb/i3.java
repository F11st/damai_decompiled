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
/* loaded from: classes8.dex */
public class i3 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static i3 d;
    private Application.ActivityLifecycleCallbacks a;
    private Application b;
    private HashMap<Integer, WeakReference<g3>> c = new HashMap<>();

    /* compiled from: Taobao */
    /* renamed from: tb.i3$a */
    /* loaded from: classes8.dex */
    public class C9250a implements Application.ActivityLifecycleCallbacks {
        private static transient /* synthetic */ IpChange $ipChange;

        C9250a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1622492307")) {
                ipChange.ipc$dispatch("-1622492307", new Object[]{this, activity, bundle});
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1086431754")) {
                ipChange.ipc$dispatch("-1086431754", new Object[]{this, activity});
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1173683279")) {
                ipChange.ipc$dispatch("-1173683279", new Object[]{this, activity});
            } else {
                i3.this.c(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_PAUSED, activity, null);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1882022392")) {
                ipChange.ipc$dispatch("1882022392", new Object[]{this, activity});
            } else {
                i3.this.c(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED, activity, null);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1498320516")) {
                ipChange.ipc$dispatch("1498320516", new Object[]{this, activity, bundle});
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1067766414")) {
                ipChange.ipc$dispatch("1067766414", new Object[]{this, activity});
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "858934978")) {
                ipChange.ipc$dispatch("858934978", new Object[]{this, activity});
            }
        }
    }

    private i3(Application application) {
        this.b = application;
        C9250a c9250a = new C9250a();
        this.a = c9250a;
        this.b.registerActivityLifecycleCallbacks(c9250a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, Activity activity, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1844878380")) {
            ipChange.ipc$dispatch("1844878380", new Object[]{this, str, activity, obj});
            return;
        }
        HashMap<Integer, WeakReference<g3>> hashMap = this.c;
        if (hashMap == null || hashMap.size() == 0) {
            return;
        }
        ArrayList<Integer> arrayList = null;
        for (Integer num : this.c.keySet()) {
            g3 g3Var = this.c.get(num).get();
            if (g3Var == null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(num);
            } else if (g3Var.a(activity)) {
                str.hashCode();
                if (str.equals(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_PAUSED)) {
                    g3Var.onActivityPaused(activity);
                } else if (str.equals(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED)) {
                    g3Var.onActivityResumed(activity);
                }
            }
        }
        if (arrayList != null) {
            for (Integer num2 : arrayList) {
                this.c.remove(num2);
            }
        }
    }

    public static i3 d(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1287229886")) {
            return (i3) ipChange.ipc$dispatch("1287229886", new Object[]{application});
        }
        if (d == null) {
            synchronized (i3.class) {
                if (d == null) {
                    d = new i3(application);
                }
            }
        }
        return d;
    }

    public void b(g3 g3Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1774634257")) {
            ipChange.ipc$dispatch("-1774634257", new Object[]{this, g3Var});
        } else if (g3Var != null) {
            this.c.put(Integer.valueOf(g3Var.hashCode()), new WeakReference<>(g3Var));
        }
    }

    public void e(g3 g3Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1529677142")) {
            ipChange.ipc$dispatch("1529677142", new Object[]{this, g3Var});
        } else if (g3Var != null) {
            this.c.remove(Integer.valueOf(g3Var.hashCode()));
        }
    }
}
