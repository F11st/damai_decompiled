package com.taomai.android.h5container.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.taobao.android.tlog.protocol.Constants;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.fb1;
import tb.jn1;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ActivityStackManager implements Application.ActivityLifecycleCallbacks {
    @NotNull
    public static final b Companion = new b(null);
    @NotNull
    public static final String TAG = "ActivityStackManager";
    @NotNull
    private static final Lazy b;
    private final LinkedList<a> a;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/taomai/android/h5container/utils/ActivityStackManager$IActivityStackBackEvent;", "", "", "jsonData", "Ltb/wt2;", "onPageBackResult", "h5container_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes11.dex */
    public interface IActivityStackBackEvent {
        void onPageBackResult(@Nullable String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class a {
        @Nullable
        private WeakReference<Activity> a;
        @Nullable
        private String b;

        public a(@Nullable Activity activity, @Nullable String str) {
            this.a = new WeakReference<>(activity);
            this.b = str;
        }

        @Nullable
        public final WeakReference<Activity> a() {
            return this.a;
        }

        @NotNull
        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            WeakReference<Activity> weakReference = this.a;
            b41.f(weakReference);
            if (weakReference.get() != null) {
                WeakReference<Activity> weakReference2 = this.a;
                b41.f(weakReference2);
                Activity activity = weakReference2.get();
                b41.f(activity);
                str = activity.getClass().getSimpleName();
            } else {
                str = "null";
            }
            sb.append(str);
            sb.append(jn1.ARRAY_START_STR);
            sb.append(this.b);
            sb.append(jn1.ARRAY_END_STR);
            return sb.toString();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class b {
        private b() {
        }

        @NotNull
        public final ActivityStackManager a() {
            Lazy lazy = ActivityStackManager.b;
            b bVar = ActivityStackManager.Companion;
            return (ActivityStackManager) lazy.getValue();
        }

        public /* synthetic */ b(k50 k50Var) {
            this();
        }
    }

    static {
        Lazy a2;
        a2 = kotlin.b.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<ActivityStackManager>() { // from class: com.taomai.android.h5container.utils.ActivityStackManager$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ActivityStackManager invoke() {
                return new ActivityStackManager(null);
            }
        });
        b = a2;
    }

    private ActivityStackManager() {
        this.a = new LinkedList<>();
    }

    private final void b(Activity activity, String str) {
        synchronized (this.a) {
            this.a.add(new a(activity, str));
        }
    }

    static /* synthetic */ void c(ActivityStackManager activityStackManager, Activity activity, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        activityStackManager.b(activity, str);
    }

    private final void e(Activity activity) {
        Activity activity2;
        WeakReference<Activity> a2;
        synchronized (this.a) {
            Iterator<a> it = this.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next == null || (a2 = next.a()) == null) {
                    activity2 = null;
                    continue;
                } else {
                    activity2 = a2.get();
                    continue;
                }
                if (activity == activity2) {
                    this.a.remove(next);
                    break;
                }
            }
            wt2 wt2Var = wt2.INSTANCE;
        }
    }

    public final boolean d(int i, @Nullable String str) {
        boolean z;
        WeakReference<Activity> a2;
        WeakReference<Activity> a3;
        if (i < 0 || Math.abs(i) <= this.a.size()) {
            synchronized (this.a) {
                int size = this.a.size() + i;
                z = true;
                a aVar = this.a.get(size - 1);
                LinkedList<a> linkedList = new LinkedList();
                int size2 = this.a.size();
                while (true) {
                    size2--;
                    if (size2 < 0) {
                        z = false;
                        break;
                    }
                    a aVar2 = this.a.get(size2);
                    if (aVar2 != null && aVar == aVar2) {
                        break;
                    }
                    linkedList.add(aVar2);
                }
                if (z) {
                    if (str != null) {
                        Activity activity = (aVar == null || (a3 = aVar.a()) == null) ? null : a3.get();
                        if (!(activity instanceof IActivityStackBackEvent)) {
                            activity = null;
                        }
                        IActivityStackBackEvent iActivityStackBackEvent = (IActivityStackBackEvent) activity;
                        if (iActivityStackBackEvent != null) {
                            iActivityStackBackEvent.onPageBackResult(str);
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("popToData ");
                        sb.append(String.valueOf(iActivityStackBackEvent != null ? iActivityStackBackEvent.hashCode() : 0));
                        fb1.a(TAG, sb.toString());
                    }
                    for (a aVar3 : linkedList) {
                        Activity activity2 = (aVar3 == null || (a2 = aVar3.a()) == null) ? null : a2.get();
                        if (activity2 != null && !activity2.isFinishing()) {
                            activity2.finish();
                        }
                    }
                    this.a.removeAll(linkedList);
                }
            }
            return z;
        }
        return false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        b41.i(activity, "activity");
        fb1.a(TAG, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_CREATED + String.valueOf(activity.hashCode()));
        c(this, activity, null, 2, null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        b41.i(activity, "activity");
        fb1.a(TAG, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_DESTROYED + String.valueOf(activity.hashCode()));
        e(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        b41.i(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        b41.i(activity, "activity");
        fb1.a(TAG, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED + String.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
        b41.i(activity, "activity");
        b41.i(bundle, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        b41.i(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        b41.i(activity, "activity");
    }

    public /* synthetic */ ActivityStackManager(k50 k50Var) {
        this();
    }
}
