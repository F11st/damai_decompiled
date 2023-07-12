package com.uc.crashsdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.uc.crashsdk.a.C7134a;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.crashsdk.c */
/* loaded from: classes11.dex */
public final class C7144c implements Application.ActivityLifecycleCallbacks {
    private boolean a = false;
    private boolean b = false;

    private void a(Activity activity, int i) {
        WeakHashMap weakHashMap;
        WeakHashMap weakHashMap2;
        if (1 == i) {
            String unused = C7143b.ad = activity.getComponentName().flattenToShortString();
        } else {
            String unused2 = C7143b.ad = "";
        }
        C7143b.D();
        if (C7152g.J()) {
            C7143b.O();
            weakHashMap = C7143b.ab;
            synchronized (weakHashMap) {
                weakHashMap2 = C7143b.ab;
                weakHashMap2.put(activity, Integer.valueOf(i));
                a(i);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        WeakHashMap weakHashMap;
        WeakHashMap weakHashMap2;
        if (C7152g.J()) {
            C7143b.O();
            weakHashMap = C7143b.ab;
            synchronized (weakHashMap) {
                weakHashMap2 = C7143b.ab;
                weakHashMap2.remove(activity);
                a(2);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(activity, 1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(activity, 1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(activity, 2);
    }

    private void a(int i) {
        WeakHashMap weakHashMap;
        WeakHashMap weakHashMap2;
        if (C7146e.u()) {
            C7134a.a("crashsdk", "[LifeCycle] ignore state change while crashing");
            return;
        }
        boolean z = true;
        boolean z2 = 1 == i;
        if (!z2) {
            weakHashMap2 = C7143b.ab;
            for (Map.Entry entry : weakHashMap2.entrySet()) {
                Object value = entry.getValue();
                if (value != null && ((Integer) value).intValue() == 1) {
                    break;
                }
            }
        }
        z = z2;
        if (this.a != z) {
            C7143b.b(z);
            this.a = z;
        }
        weakHashMap = C7143b.ab;
        boolean isEmpty = weakHashMap.isEmpty();
        if (this.b != isEmpty) {
            if (isEmpty) {
                C7143b.w();
            }
            this.b = isEmpty;
        }
    }
}
