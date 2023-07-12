package tb;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager;
import com.taobao.android.tlog.protocol.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.js1;
import tb.lt1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ks1 implements Application.ActivityLifecycleCallbacks {
    @NotNull
    private final String a = "openPopupManager_" + a12.b(ks1.class).getSimpleName();

    private final void a(Activity activity) {
        ct1.Companion.a().g(lt1.d(lt1.Companion.a(), activity, null, null, 6, null));
    }

    private final void b(String str, Activity activity, Object obj) {
        Map<Integer, WeakReference<js1.AbstractC9321b>> d;
        js1 a = js1.Companion.a();
        if (a == null || (d = a.d()) == null) {
            return;
        }
        ArrayList<Integer> arrayList = null;
        for (Integer num : d.keySet()) {
            int intValue = num.intValue();
            WeakReference<js1.AbstractC9321b> weakReference = d.get(Integer.valueOf(intValue));
            js1.AbstractC9321b abstractC9321b = weakReference != null ? weakReference.get() : null;
            if (abstractC9321b == null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(Integer.valueOf(intValue));
            } else if (abstractC9321b.a(activity)) {
                if (b41.d(str, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_PAUSED)) {
                    abstractC9321b.b(activity);
                } else if (b41.d(str, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED)) {
                    abstractC9321b.c(activity);
                }
            }
        }
        if (arrayList != null) {
            for (Integer num2 : arrayList) {
                tq2.c(d).remove(num2);
            }
        }
    }

    private final void c(Activity activity) {
        String simpleName = activity.getClass().getSimpleName();
        b41.h(simpleName, "activity::class.java.simpleName");
        if (!pt1.c(simpleName)) {
            String simpleName2 = activity.getClass().getSimpleName();
            b41.h(simpleName2, "activity::class.java.simpleName");
            if (!pt1.f(simpleName2) && lt1.Companion.a().o().get()) {
                String simpleName3 = activity.getClass().getSimpleName();
                b41.h(simpleName3, "activity::class.java.simpleName");
                pt1.g(simpleName3, "openPopupManager", "without_popup", null);
                return;
            }
            String simpleName4 = activity.getClass().getSimpleName();
            b41.h(simpleName4, "activity::class.java.simpleName");
            pt1.g(simpleName4, "openPopupManager", "need_popup", null);
            PopupPriorityManager popupPriorityManager = new PopupPriorityManager(activity);
            popupPriorityManager.s(null);
            popupPriorityManager.h(null);
            PopupPriorityManager.l(popupPriorityManager, true, null, null, null, null, null, 62, null);
            return;
        }
        String simpleName5 = activity.getClass().getSimpleName();
        b41.h(simpleName5, "activity::class.java.simpleName");
        pt1.g(simpleName5, "openPopupManager", "local_popup", null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        b41.i(activity, "activity");
        i23 i23Var = i23.INSTANCE;
        String str = this.a;
        i23Var.a(str, "onActivityCreated " + activity);
        lt1 a = lt1.Companion.a();
        if (a != null) {
            a.s(activity);
        }
        c(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        lt1 a;
        b41.i(activity, "activity");
        i23 i23Var = i23.INSTANCE;
        String str = this.a;
        i23Var.a(str, "onActivityDestroyed " + activity);
        a(activity);
        lt1.C9421a c9421a = lt1.Companion;
        lt1 a2 = c9421a.a();
        if ((a2 != null ? a2.k() : null) != activity || (a = c9421a.a()) == null) {
            return;
        }
        a.s(null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        b41.i(activity, "activity");
        i23 i23Var = i23.INSTANCE;
        String str = this.a;
        i23Var.a(str, "onActivityPaused " + activity);
        b(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_PAUSED, activity, null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        b41.i(activity, "activity");
        i23 i23Var = i23.INSTANCE;
        String str = this.a;
        i23Var.a(str, "onActivityResumed " + activity);
        b(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED, activity, null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
        b41.i(activity, "activity");
        b41.i(bundle, "outState");
        i23 i23Var = i23.INSTANCE;
        String str = this.a;
        i23Var.a(str, "onActivitySaveInstanceState " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        b41.i(activity, "activity");
        i23 i23Var = i23.INSTANCE;
        String str = this.a;
        i23Var.a(str, "onActivityStarted " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        b41.i(activity, "activity");
        i23 i23Var = i23.INSTANCE;
        String str = this.a;
        i23Var.a(str, "onActivityStopped " + activity);
    }
}
