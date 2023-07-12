package com.huawei.hmf.tasks.a;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.util.Log;
import com.huawei.hmf.tasks.ExecuteResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: Taobao */
/* renamed from: com.huawei.hmf.tasks.a.g */
/* loaded from: classes10.dex */
public final class FragmentC5501g extends Fragment {
    private static final WeakHashMap<Activity, WeakReference<FragmentC5501g>> b = new WeakHashMap<>();
    private final List<WeakReference<ExecuteResult<?>>> a = new ArrayList();

    private static FragmentC5501g a(Activity activity) {
        FragmentC5501g fragmentC5501g;
        WeakHashMap<Activity, WeakReference<FragmentC5501g>> weakHashMap = b;
        WeakReference<FragmentC5501g> weakReference = weakHashMap.get(activity);
        if (weakReference == null || weakReference.get() == null) {
            FragmentManager fragmentManager = activity.getFragmentManager();
            try {
                FragmentC5501g fragmentC5501g2 = (FragmentC5501g) fragmentManager.findFragmentByTag("com.huawei.hmf.tasks.lifecycle_fragment_tag");
                if (fragmentC5501g2 == null) {
                    try {
                        fragmentC5501g = a(fragmentManager);
                    } catch (ClassCastException e) {
                        e = e;
                        fragmentC5501g = fragmentC5501g2;
                        Log.e("LifecycleCallbackFrg", "found LifecycleCallbackFragment but the type do not match. " + e.getMessage());
                        return fragmentC5501g;
                    }
                } else {
                    fragmentC5501g = fragmentC5501g2;
                }
            } catch (ClassCastException e2) {
                e = e2;
                fragmentC5501g = null;
            }
            try {
                weakHashMap.put(activity, new WeakReference<>(fragmentC5501g));
            } catch (ClassCastException e3) {
                e = e3;
                Log.e("LifecycleCallbackFrg", "found LifecycleCallbackFragment but the type do not match. " + e.getMessage());
                return fragmentC5501g;
            }
            return fragmentC5501g;
        }
        return weakReference.get();
    }

    private static FragmentC5501g a(FragmentManager fragmentManager) {
        FragmentC5501g fragmentC5501g = null;
        try {
            FragmentC5501g fragmentC5501g2 = new FragmentC5501g();
            try {
                fragmentManager.beginTransaction().add(fragmentC5501g2, "com.huawei.hmf.tasks.lifecycle_fragment_tag").commitAllowingStateLoss();
                return fragmentC5501g2;
            } catch (Exception e) {
                e = e;
                fragmentC5501g = fragmentC5501g2;
                Log.e("LifecycleCallbackFrg", "create fragment failed." + e.getMessage());
                return fragmentC5501g;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static void a(Activity activity, ExecuteResult executeResult) {
        FragmentC5501g a = a(activity);
        if (a != null) {
            synchronized (a.a) {
                a.a.add(new WeakReference<>(executeResult));
            }
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        synchronized (this.a) {
            for (WeakReference<ExecuteResult<?>> weakReference : this.a) {
                ExecuteResult<?> executeResult = weakReference.get();
                if (executeResult != null) {
                    executeResult.cancel();
                }
            }
            this.a.clear();
        }
    }
}
